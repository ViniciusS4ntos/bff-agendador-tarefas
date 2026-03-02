package com.vinicius.bffagendadortarefas.infrastructure.client;

import com.vinicius.bffagendadortarefas.business.dto.in.EnderecoDTORequest;
import com.vinicius.bffagendadortarefas.business.dto.in.LoginDTORequest;
import com.vinicius.bffagendadortarefas.business.dto.in.TelefoneDTORequest;
import com.vinicius.bffagendadortarefas.business.dto.in.UsuarioDTORequest;
import com.vinicius.bffagendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.vinicius.bffagendadortarefas.business.dto.out.TelefoneDTOResponse;
import com.vinicius.bffagendadortarefas.business.dto.out.UsuarioDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping
    UsuarioDTOResponse buscarUsuarioPorEmail(@RequestParam("email") String email,
                                             @RequestHeader("Authorization") String token);

    @PostMapping
    UsuarioDTOResponse salvarUsuario(@RequestBody UsuarioDTORequest usuarioDTO);

    @PostMapping("/login")
    String login(@RequestBody LoginDTORequest usuarioDTO);

    @DeleteMapping("/{email}")
    void deletarPorEmail(@PathVariable String email,
                        @RequestHeader("Authorization") String token);

    @PutMapping
    UsuarioDTOResponse atualizaDadosUsuario(@RequestBody UsuarioDTORequest dto,
                                           @RequestHeader("Authorization") String token);

    @PutMapping("/endereco")
    EnderecoDTOResponse atualizarEndereco(@RequestBody EnderecoDTORequest dto,
                                          @RequestParam("id") Long id,
                                          @RequestHeader("Authorization") String token);

    @PutMapping("/telefone")
    TelefoneDTOResponse atualizarTelefone(@RequestBody TelefoneDTORequest dto,
                                          @RequestParam("id") Long id,
                                          @RequestHeader("Authorization") String token);

    @PostMapping("/endereco")
    EnderecoDTOResponse cadastraEndereco(@RequestBody EnderecoDTORequest dto,
                                        @RequestHeader("Authorization") String token);

    @PostMapping("/telefone")
    TelefoneDTOResponse cadastraTelefone(@RequestBody TelefoneDTORequest dto,
                                        @RequestHeader("Authorization") String token);

}
