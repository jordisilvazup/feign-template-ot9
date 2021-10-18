package com.example.feign.clientshttptemplate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/endereco")
@RestController
public class ConsultaEnderecoController {
    private final ViaCepClient viaCepClient;
    private final EntityManager manager;

    public ConsultaEnderecoController(ViaCepClient viaCepClient, EntityManager manager) {
        this.viaCepClient = viaCepClient;
        this.manager = manager;
    }

    @GetMapping
    @Transactional
    public EnderecoResponse solicita(@RequestParam String cep) {

        ResponseEntity<EnderecoResponseApiViaCep> responseCall = viaCepClient.solicitaEndereco(cep);

        EnderecoResponseApiViaCep enderecoResponseApiViaCep = responseCall.getBody();

        System.out.println(responseCall.getStatusCode()+"\n "+responseCall.getHeaders().get("content-type"));

        Endereco endereco = enderecoResponseApiViaCep.paraEndereco();

        manager.persist(endereco);

        return new EnderecoResponse(endereco);
    }

    @GetMapping("/all")
    public List<EnderecoResponse> solicitaEntity() {
        List<Endereco> enderecos = manager.createQuery("select r from Endereco r", Endereco.class).getResultList();
        return enderecos.stream().map(EnderecoResponse::new).collect(Collectors.toList());
    }
}
