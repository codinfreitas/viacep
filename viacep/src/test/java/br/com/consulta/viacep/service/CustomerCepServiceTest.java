package br.com.consulta.viacep.service;

import br.com.consulta.viacep.exception.ViaCepException;
import br.com.consulta.viacep.view.CepView;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Fail.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CustomerCepServiceTest {

    private final static String EXPECTED_EXCEPTION = "expected exception not thrown";

    @Test
    @DisplayName("Checks the possibility of the verifyCep method launch an exception")
    public void findByCep_whenVerifyCepThrowException_throwViaCepException() throws ViaCepException {

        CustomerCepService instance = setupFindByCepWhenVerifyCepThrowExceptionThrowViaCepException();
        try {
            String result = instance.findByCep(new CepView());
            fail( EXPECTED_EXCEPTION );
        }catch (ViaCepException e) {
            Assert.assertNotNull(e);
        }

    }

    private CustomerCepService setupFindByCepWhenVerifyCepThrowExceptionThrowViaCepException() throws ViaCepException {

        CustomerCepService instance = spy(CustomerCepService.class);

        ValidateCepService validateCepServiceMock = mock(ValidateCepService.class);
        instance.setValidateCepService(validateCepServiceMock);

        doThrow(ViaCepException.class).when(validateCepServiceMock).verifyCep(any());

        return instance;
    }


    @Test
    @DisplayName("Checks the possibility of error is null")
    public void getString_whenErrorIsNull_shouldReturnInfo(){

        CustomerCepService instance = spy(CustomerCepService.class);

        String result = instance.getString(new CepView(), null);

        Assert.assertNotNull(result);
    }

    @Test
    @DisplayName("Checks the possibility of error is not null")
    public void getString_whenErrorIsNotNull_shouldReturnError(){

        CustomerCepService instance = spy(CustomerCepService.class);

        String result = instance.getString(getCepView("error"), getCepView("error").getCep());

        Assert.assertNotNull(result);
        Assert.assertEquals(result, getCepView("error").getCep());
    }

    @Test
    @DisplayName("Checks the possibility of cep is null")
    public void getError_whenCepIsNull_shouldReturnMessage(){

        CustomerCepService instance = spy(CustomerCepService.class);

        String result = instance.getError(new CepView());

        Assert.assertNotNull(result);
        Assert.assertEquals(result, instance.createMessage(new CepView()));
    }

    @Test
    @DisplayName("Checks the possibility of cep is not null")
    public void getError_whenCepIsNotNullAndCepIsNotBlankAndCepIsNotEmpty_shouldReturnNull(){

        CustomerCepService instance = spy(CustomerCepService.class);

        String result = instance.getError(getCepView("38320000"));

        Assert.assertNull(result);
    }

    private CepView getCepView(String txt){

        return new CepView(txt);
    }

}