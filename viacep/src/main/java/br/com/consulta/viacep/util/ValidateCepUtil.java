package br.com.consulta.viacep.util;

import br.com.consulta.viacep.exception.ViaCepException;
import br.com.consulta.viacep.exception.ViaCepFormatException;

import java.util.Objects;

public class ValidateCepUtil {

    public static boolean validaCep(String cep) throws ViaCepException, ViaCepFormatException {

        if (Objects.isNull(cep) || cep.isEmpty() || cep.isBlank()) throw new ViaCepException("cep informed cannot be null or empty ");
        if (cep.length() != 8) throw new ViaCepFormatException("Client ERRO 400 - BAD REQUEST: inform a valid cep");

        return true;
    }

    public static String getShipping(String estado){

        String result = "";
        for (int i = 0; i < States.listStates().size(); i++){
            if (estado.equals(States.listStates())){
                result += States.compareTo(estado);
            }
        }
        return result;
    }
}
