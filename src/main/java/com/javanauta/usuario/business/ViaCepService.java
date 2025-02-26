package com.javanauta.usuario.business;

import com.javanauta.usuario.infrastructure.clients.ViaCepClient;
import com.javanauta.usuario.infrastructure.clients.ViaCepDTO;
import com.javanauta.usuario.infrastructure.exceptions.IllegalArgumentException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ViaCepService {

    private final ViaCepClient client;

    public ViaCepDTO buscarDadosEndereeco(String cep){
        return client.buscarDadosEndereco(processarCep(cep));
    }

    private String processarCep(String cep){
        String cepFormato = cep.replace(" ", "")
                                        .replace("-", "");

        if(!cepFormato.matches("[0-9+]") || cepFormato.length() < 8){
            throw new IllegalArgumentException("o cep esta invalidos, favor verificar");
        }
        return cepFormato;
    }
}
