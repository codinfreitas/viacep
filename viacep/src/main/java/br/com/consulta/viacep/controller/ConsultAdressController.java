package br.com.consulta.viacep.controller;

import br.com.consulta.viacep.exception.ViaCepException;
import br.com.consulta.viacep.service.CustomerCepService;
import br.com.consulta.viacep.exception.ViaCepFormatException;
import br.com.consulta.viacep.view.CepView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consult")
@Api(value = "viacep")
public class ConsultAdressController {

    @Autowired
    private CustomerCepService customerCepService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "search info with cep informed in request")
    public String sendCep( @RequestBody CepView cep) throws ViaCepException {
        return customerCepService.findByCep(cep);
    }

    public void setCustomerCepService(CustomerCepService customerCepService) {
        this.customerCepService = customerCepService;
    }
}
