package br.com.consulta.viacep.controller;

import br.com.consulta.viacep.exception.ViaCepException;
import br.com.consulta.viacep.service.CustomerCepService;
import br.com.consulta.viacep.exception.ViaCepFormatException;
import br.com.consulta.viacep.view.CepView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consult")
public class ConsultAdressController {

    @Autowired
    private CustomerCepService customerCepService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CepView sendCep( @RequestBody String cep) throws ViaCepException, ViaCepFormatException {
        return customerCepService.findByCep(cep);
    }

    public void setCustomerCepService(CustomerCepService customerCepService) {
        this.customerCepService = customerCepService;
    }
}
