package br.com.consulta.viacep.service;

import br.com.consulta.viacep.exception.ViaCepException;
import br.com.consulta.viacep.util.ValidateCepUtil;
import br.com.consulta.viacep.exception.ViaCepFormatException;
import br.com.consulta.viacep.view.CepView;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(CustomerCepService.class);
    private static final String viaCepUrl = "https://viacep.com.br/ws/";
    private static final Gson gson = new Gson();

    public CustomerCepService() {
        super();
    }


    public String findByCep(CepView cep) throws ViaCepException, ViaCepFormatException {


        if ( ValidateCepUtil.validaCep( cep.getCep() ) ) {

            try {
                HttpClient httpClient = HttpClient.newBuilder().connectTimeout(Duration.of(1, MINUTES)).build();
                HttpRequest httpRequest = HttpRequest.newBuilder().GET().uri(URI.create(viaCepUrl + cep.getCep() + "/json")).build();
                HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
                log.info("[VIA CEP API] - [SEARCH RESULT: {}]", httpResponse.body());
                CepView cepView = (CepView) gson.fromJson((String) httpResponse.body(), CepView.class);

                String Error = getError(cepView);
                return getString(cepView, Error);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        return null;
    }

    private String getString(CepView cepView, String Error) {
        if (Error == null) {
            return cepView.returnInfo();
        }else {
            return Error;
        }
    }

    private String getError(CepView cepView) {
        if (cepView.getCep() == null || cepView.getCep().isBlank() || cepView.getCep().isEmpty() ){
            return createMessage(cepView);
        }
        return null;
    }

    private String createMessage(CepView cepView){

        return "{\n" +
                "   ------- error client ------- " + "\n" +
                "   code http: 400 - BAD REQUEST" + "\n" +
                "   please inform a valid cep "  + "\n" +
                "   ---------------------------- " + "\n" +
                "}";
    }

}
