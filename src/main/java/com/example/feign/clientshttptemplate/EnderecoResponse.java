package com.example.feign.clientshttptemplate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnderecoResponse {
    @JsonProperty
    String cep;
    @JsonProperty
    String logradouro;
    @JsonProperty
    String complemento;
    @JsonProperty
    String bairro;
    @JsonProperty
    String localidade;
    @JsonProperty
    String uf;


    public EnderecoResponse(Endereco endereco) {
        this.cep=endereco.getCep();
        this.logradouro=endereco.getLogradouro();
        this.bairro=endereco.getBairro();
        this.localidade=endereco.getLocalidade();
        this.complemento=endereco.getComplemento();
        this.uf=endereco.getUf();
    }
    public EnderecoResponse(EnderecoResponseApiViaCep endereco) {
        this.cep=endereco.getCep();
        this.logradouro=endereco.getLogradouro();
        this.bairro=endereco.getBairro();
        this.localidade=endereco.getLocalidade();
        this.complemento=endereco.getComplemento();
        this.uf=endereco.getUF();
    }
}
