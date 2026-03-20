package com.vinicius.bffagendadortarefas.controller;

import com.vinicius.bffagendadortarefas.business.UsuarioService;
import com.vinicius.bffagendadortarefas.business.dto.in.EnderecoDTORequest;
import com.vinicius.bffagendadortarefas.business.dto.in.LoginDTORequest;
import com.vinicius.bffagendadortarefas.business.dto.in.TelefoneDTORequest;
import com.vinicius.bffagendadortarefas.business.dto.in.UsuarioDTORequest;
import com.vinicius.bffagendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.vinicius.bffagendadortarefas.business.dto.out.TelefoneDTOResponse;
import com.vinicius.bffagendadortarefas.business.dto.out.UsuarioDTOResponse;
import com.vinicius.bffagendadortarefas.business.dto.out.ViaCepDTOResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
@Tag(name = "Usuário", description = "cadastro, login e usuários ")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    // Swagger
    @Operation(summary = "Salvar Usuario", description = "Criar um novo usuario")
    @ApiResponse(responseCode = "200", description = "Usuario salvo com sucesso")
    @ApiResponse(responseCode = "409", description = "Usuario ja cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais invalidas")
    public ResponseEntity<UsuarioDTOResponse> salvarUsuario(@RequestBody UsuarioDTORequest usuarioDTO){
        return ResponseEntity.ok(usuarioService.salvaUsuario(usuarioDTO));
    }

    @PostMapping("/login")
    // Swagger
    @Operation(summary = "Login de Usuario", description = "Faz o login do usuario")
    @ApiResponse(responseCode = "200", description = "Usuario logado com sucesso")
    @ApiResponse(responseCode = "401", description = "Credencias invalidas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais invalidas")
    public String login(@RequestBody LoginDTORequest usuarioDTO) {
        return usuarioService.loginUsuario(usuarioDTO);

    }

    @GetMapping
    // Swagger
    @Operation(summary = "Buscar dados de usuarios por email",
            description = "Buscar dados do usuario")
    @ApiResponse(responseCode = "200", description = "Usuario encontrado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuario nao encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais invalidas")
    public ResponseEntity<UsuarioDTOResponse> buscarUsuarioPorEmail(@RequestParam("email") String email,
                                                                    @RequestHeader(name = "Authorization",required = false) String token){
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email,token));
    }

    @DeleteMapping("/{email}")
    // Swagger
    @Operation(summary = "Deleta Usuario por id", description = "Deleta usuario")
    @ApiResponse(responseCode = "200", description = "Usuario deletado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuario nao encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais invalidas")
    public ResponseEntity<Void> deletarPorEmail(@PathVariable String email,
                                                @RequestHeader(name = "Authorization",required = false) String token){
        usuarioService.deletarUsuarioPorEmail(email, token);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    // Swagger
    @Operation(summary = "Atualizar dados de usuario",
            description = "Atualizar dados de usuario")
    @ApiResponse(responseCode = "200", description = "Usuario atualizado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuario nao encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais invalidas")
    public ResponseEntity<UsuarioDTOResponse> atualizaDadosUsuario(@RequestBody UsuarioDTORequest dto,
                                                                  @RequestHeader(name = "Authorization",required = false) String token){
        return ResponseEntity.ok(usuarioService.atualizarDadosUsuario(token,dto));
    }

    @PutMapping("/endereco")
    // Swagger
    @Operation(summary = "Atualizar dados endereco de endereco",
            description = "Atualizar dados endereco de endereco")
    @ApiResponse(responseCode = "200", description = "endereco atualizado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuario nao encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais invalidas")
    public ResponseEntity<EnderecoDTOResponse> atualizarEndereco(@RequestBody EnderecoDTORequest dto,
                                                                 @RequestParam("id") Long id,
                                                                 @RequestHeader(name = "Authorization",required = false) String token){
        return ResponseEntity.ok(usuarioService.atualizarEndereco(id,dto,token));
    }

    @PutMapping("/telefone")
    // Swagger
    @Operation(summary = "Atualizar telefone de usuario",
            description = "Atualiza telefone de usuario")
    @ApiResponse(responseCode = "200", description = "Telefone atualizado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuario nao encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais invalidas")
    public ResponseEntity<TelefoneDTOResponse> atualizarTeleffone(@RequestBody TelefoneDTORequest dto,
                                                                  @RequestParam("id") Long id,
                                                                  @RequestHeader(name = "Authorization",required = false) String token){
        return ResponseEntity.ok(usuarioService.atualizarTelefone(id,dto,token));
    }

    @PostMapping("/endereco")
    // Swagger
    @Operation(summary = "salvar endereco de usuario",
            description = "salvar endereco de usuario")
    @ApiResponse(responseCode = "200", description = "endereco salvo com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuario nao encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais invalidas")
    public ResponseEntity<EnderecoDTOResponse> cadastraEndereco(@RequestBody EnderecoDTORequest dto,
                                                               @RequestHeader(name = "Authorization",required = false) String token){
        return ResponseEntity.ok(usuarioService.cadastraEndereco(token,dto));
    }

    @PostMapping("/telefone")
    // Swagger
    @Operation(summary = "salvar telefone de usuario",
            description = "salvar telefone de usuario")
    @ApiResponse(responseCode = "200", description = "Telefone salvo com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuario nao encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais invalidas")
    public ResponseEntity<TelefoneDTOResponse> cadastraTelefone(@RequestBody TelefoneDTORequest dto,
                                                               @RequestHeader(name = "Authorization",required = false) String token){
        return ResponseEntity.ok(usuarioService.cadastraTelefone(token,dto));
    }

    @GetMapping("/endereco/{cep}")
    // Swagger
    @Operation(summary = "Buscar endereco pelo cep",
            description = "Buscar informaçõoes do cep")
    @ApiResponse(responseCode = "200", description = "Dados de endereço retornado com sucesso")
    @ApiResponse(responseCode = "400", description = "Cep inválido ou nao encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<ViaCepDTOResponse> buscarEndereco(@PathVariable("cep") String cep){
        return ResponseEntity.ok(usuarioService.buscarDadosCep(cep));
    }




}
