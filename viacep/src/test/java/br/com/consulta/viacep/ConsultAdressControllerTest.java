package br.com.consulta.viacep;

import br.com.consulta.viacep.controller.ConsultAdressController;
import br.com.consulta.viacep.exception.ViaCepException;
import br.com.consulta.viacep.service.CustomerCepService;
import br.com.consulta.viacep.view.CepView;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Fail.fail;
import static org.mockito.Mockito.*;

class ConsultAdressControllerTest {


	private final static String EXPECTED_EXCEPTION = "expected exception not thrown";
	@Test
	@DisplayName("Checks the possibility of the findByCep method launch an exception")
	public void sendCep_whenFindCepThrowException_throwViaCepException() throws ViaCepException {

		ConsultAdressController instance = setupSendCepWhenFindCepThrowExceptionThrowViaCepException();
		try {
			String result = instance.sendCep(new CepView());
			fail( EXPECTED_EXCEPTION );
		}catch (ViaCepException e) {
			Assert.assertNotNull(e);
		}

	}

	private ConsultAdressController setupSendCepWhenFindCepThrowExceptionThrowViaCepException() throws ViaCepException {

		ConsultAdressController instance = spy(ConsultAdressController.class);

		CustomerCepService customerCepServiceMock = mock(CustomerCepService.class);
		instance.setCustomerCepService(customerCepServiceMock);

		doThrow(ViaCepException.class).when(customerCepServiceMock).findByCep(any());

		return instance;
	}


	@Test
	@DisplayName("Check the possibility that findByCep method does not throw an exception")
	public void sendCep_whenFindCepNotThrowException_shouldReturnCepNotNull() throws ViaCepException {

		ConsultAdressController instance = setupSendCepWhenFindCepNotThrowExceptionShouldReturnCepNotNull();

		String result = instance.sendCep(new CepView());

		Assert.assertNotNull(result);
		Assert.assertEquals("cep", result);

	}

	private ConsultAdressController setupSendCepWhenFindCepNotThrowExceptionShouldReturnCepNotNull() throws ViaCepException {

		ConsultAdressController instance = spy(ConsultAdressController.class);

		CustomerCepService customerCepServiceMock = mock(CustomerCepService.class);
		instance.setCustomerCepService(customerCepServiceMock);

		doReturn("cep").when(customerCepServiceMock).findByCep(any());

		return instance;
	}

}
