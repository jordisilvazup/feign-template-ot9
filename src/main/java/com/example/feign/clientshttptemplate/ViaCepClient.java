package com.example.feign.clientshttptemplate;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "via-cep-api-client",url = "https://viacep.com.br/ws/")
public interface ViaCepClient {
    @GetMapping("/{cep}/json")
    ResponseEntity<EnderecoResponseApiViaCep> solicitaEndereco(@PathVariable String cep);
}
