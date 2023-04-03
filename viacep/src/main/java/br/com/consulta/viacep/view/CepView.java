package br.com.consulta.viacep.view;

import br.com.consulta.viacep.util.ValidateCepUtil;
import io.swagger.annotations.ApiModelProperty;

public class CepView {

    private String cep;
    @ApiModelProperty(hidden = true)
    private String logradouro;
    private String complemento;
    private String bairro;
    @ApiModelProperty(hidden = true)
    private String localidade;
    @ApiModelProperty(hidden = true)
    private String uf;
    private String frete;
    private String cidade;
    private String estado;
    private String rua;

    public CepView() {
    }

    public CepView(String cep) {
        this.cep = cep;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getFrete() {
        return frete;
    }

    public void setFrete(String frete) {
        this.frete = frete;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String returnInfo() {
        return "{\n" +
                "   \"cep\": " + "\"" + cep + "\"" + ",\n" +
                "   \"rua:\" " + "\"" + logradouro + "\"" + ",\n" +
                "   \"complemento\": " + "\"" + complemento + "\"" + ",\n" +
                "   \"bairro\": " + "\"" + bairro + "\"" + ",\n" +
                "   \"cidade\": " + "\"" + localidade + "\"" + ",\n" +
                "   \"estado\": " + "\"" + uf + "\"" + ",\n" +
                "   \"frete\": " + ValidateCepUtil.getShipping(uf) + "\n" +
                "}";
    }

}
