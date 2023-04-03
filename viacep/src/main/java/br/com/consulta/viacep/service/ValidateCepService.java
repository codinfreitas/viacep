package br.com.consulta.viacep.service;

import br.com.consulta.viacep.exception.ViaCepException;
import br.com.consulta.viacep.exception.ViaCepFormatException;
import br.com.consulta.viacep.util.StatesUtil;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ValidateCepService {

    public boolean validaCep(String cep) throws ViaCepException, ViaCepFormatException {

        if (Objects.isNull(cep) || cep.isEmpty() || cep.isBlank()) throw new ViaCepException("cep informed cannot be null or empty ");
        if (cep.length() == 9) throw new ViaCepFormatException("Client ERRO 400 - BAD REQUEST: inform a valid cep");

        return true;
    }

    public String verifyCep(String cep) throws ViaCepException {
        try {
            validaCep(cep);
            return cep;
        } catch (ViaCepFormatException e) {
            return cep.replace("-", "");
        }
    }


    public static String getShipping(String states) {

        return StatesUtil.listStates().stream()
                .filter(s -> s.equals(states))
                .map(StatesUtil::compareTo)
                .collect(Collectors.joining());
    }
}