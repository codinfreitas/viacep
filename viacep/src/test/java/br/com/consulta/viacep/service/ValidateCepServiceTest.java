package br.com.consulta.viacep.service;

import br.com.consulta.viacep.exception.ViaCepException;
import br.com.consulta.viacep.exception.ViaCepFormatException;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

class ValidateCepServiceTest {

    private final static String EXPECTED_EXCEPTION = "expected exception not thrown";

    @Test
    public void validaCep_whenCepIsNull_throwViaCepException() throws ViaCepFormatException {

        ValidateCepService instance = spy(ValidateCepService.class);

        try {
            boolean result = instance.validaCep(null);
            fail(EXPECTED_EXCEPTION);
        } catch (ViaCepException e) {
            Assert.notNull(e);
            Assert.notNull(e.getMessage());
            Assert.isTrue(e.getMessage().contains("cep informed cannot be null or empty"));
        }
    }

    @Test
    public void validaCep_whenCepSizeIsNine_throwViaCepFormatException() throws ViaCepException {
        ValidateCepService instance = spy(ValidateCepService.class);
        try {
            boolean result = instance.validaCep("383200000");
            fail(EXPECTED_EXCEPTION);
        } catch (ViaCepFormatException e) {
            Assert.notNull(e);
            Assert.notNull(e.getMessage());
            Assert.isTrue(e.getMessage().contains("Client ERRO 400 - BAD REQUEST: inform a valid cep"));
        }
    }

    @Test
    public void verifyCep_whenValidaCepThrowException_throwViaCepException() throws ViaCepException, ViaCepFormatException {

        ValidateCepService instance = setupVerifyCepWhenValidaCepThrowExceptionShouldReturnCep();
        try {
            String result = instance.verifyCep("383200000");
            fail(EXPECTED_EXCEPTION);
        } catch (ViaCepException e) {
            Assert.notNull(e);
        }
    }

    private ValidateCepService setupVerifyCepWhenValidaCepThrowExceptionShouldReturnCep() throws ViaCepException, ViaCepFormatException {

        ValidateCepService instance = spy(ValidateCepService.class);

        doThrow(ViaCepException.class).when(instance).validaCep(anyString());

        return instance;
    }


    @Test
    public void verifyCep_whenValidaCepNotThrowException_shouldReturnCep() throws ViaCepException, ViaCepFormatException {

        ValidateCepService instance = setupVerifyCepWhenValidaCepNotThrowExceptionShouldReturnCep();

        String result = instance.verifyCep("38320000");

        Assert.notNull(result);
    }

    private ValidateCepService setupVerifyCepWhenValidaCepNotThrowExceptionShouldReturnCep() throws ViaCepException, ViaCepFormatException {

        ValidateCepService instance = spy(ValidateCepService.class);

        doReturn(true).when(instance).validaCep(anyString());

        return instance;
    }


}