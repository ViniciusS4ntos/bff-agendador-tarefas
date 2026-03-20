package com.vinicius.bffagendadortarefas.business.dto.in;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UsuarioDTORequest {

    private String nome;
    private String email;
    private String senha;
    private List<EnderecoDTORequest> enderecoDTOS;
    private List<TelefoneDTORequest> telefoneDTOS;


}
