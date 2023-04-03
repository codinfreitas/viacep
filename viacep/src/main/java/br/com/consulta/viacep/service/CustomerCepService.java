package br.com.consulta.viacep.service;

import br.com.consulta.viacep.exception.ViaCepException;
import br.com.consulta.viacep.view.CepView;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import static java.time.temporal.ChronoUnit.MINUTES;

@Service
public class CustomerCepService {

    @Autowired
    private ValidateCepService validateCepService;
    private static final Logger log = LoggerFactory.getLogger(CustomerCepService.class);
    private static final String viaCepUrl = "https://viacep.com.br/ws/";
    private static final Gson gson = new Gson();

    public CustomerCepService() {
        super();
    }


    public String findByCep(CepView cep) throws ViaCepException {

        validateCepService.verifyCep(cep.getCep());

            try {
                HttpClient httpClient = HttpClient.newBuilder().connectTimeout(Duration.of(1, MINUTES)).build();
                HttpRequest httpRequest = HttpRequest.newBuilder().GET().uri(URI.create(viaCepUrl + cep.getCep() + "/json")).build();
                HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
                log.info("[VIA CEP API] - [SEARCH RESULT: {}]", httpResponse.body());
                CepView cepView = (CepView) gson.fromJson((String) httpResponse.body(), CepView.class);
                String error = getError(cepView);
                return getString(cepView, error);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
    }

    String getString(CepView cepView, String error) {

        return error == null ? cepView.returnInfo() : error;
    }

    String getError(CepView cepView) {
        return cepView.getCep() == null || cepView.getCep().isBlank() || cepView.getCep().isEmpty() ?
                createMessage(cepView) : null;
    }

    String createMessage(CepView cepView){

        return "{\n" +
                "   ------- error client ------- " + "\n" +
                "   code http: 400 - BAD REQUEST" + "\n" +
                "    please inform a valid cep "  + "\n" +
                "   ---------------------------- " + "\n" +
                "}";
    }

    public void setValidateCepService(ValidateCepService validateCepService) {
        this.validateCepService = validateCepService;
    }
}
