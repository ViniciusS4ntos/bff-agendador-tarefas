package com.vinicius.bffagendadortarefas.business.dto.in;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class LoginDTORequest {

    private String email;
    private String senha;

}
