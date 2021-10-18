package com.example.feign.clientshttptemplate;

public class EnderecoResponseApiViaCep {
    String cep;
    String logradouro;
    String complemento;
    String bairro;
    String localidade;
    String uf;

    public EnderecoResponseApiViaCep(String cep, String logradouro, String complemento, String bairro, String localidade, String UF) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = UF;
    }

    Endereco paraEndereco(){
        return new Endereco(cep,logradouro,complemento,bairro,localidade,uf);
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUF() {
        return uf;
    }
}
