package com.vinicius.bffagendadortarefas.business.dto.out;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UsuarioDTOResponse {

    private String nome;
    private String email;
    private String senha;
    private List<EnderecoDTOResponse> enderecoDTOS;
    private List<TelefoneDTOResponse> telefoneDTOS;


}
