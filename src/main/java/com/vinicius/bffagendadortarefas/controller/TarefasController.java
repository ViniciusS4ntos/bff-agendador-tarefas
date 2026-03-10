package com.vinicius.bffagendadortarefas.controller;


import com.vinicius.bffagendadortarefas.business.TarefasService;
import com.vinicius.bffagendadortarefas.business.dto.in.TarefasDTORequest;
import com.vinicius.bffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.vinicius.bffagendadortarefas.business.enums.StatusNotificacaoEnum;
import com.vinicius.bffagendadortarefas.infrastructure.security.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
@Tag(name = "Tarefas", description = "Cadastra tarefas de usuarios")
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
public class TarefasController {

    private final TarefasService tarefasService;

    @PostMapping
    // Swagger
    @Operation(summary = "Salvar Tarefas", description = "Criar uma nova tarefa")
    @ApiResponse(responseCode = "200", description = "Tarefa salva com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TarefasDTOResponse> gravarTarefas(@RequestBody TarefasDTORequest dto,
                                                            @RequestHeader(value = "Authorization",required = false) String token) {
        return ResponseEntity.ok(tarefasService.gravarTarefas(token, dto));
    }

    @GetMapping("/eventos")
    // Swagger
    @Operation(summary = "Buscar tarefas por periodo", description = "Buscar tarefas cadastradas por periodo")
    @ApiResponse(responseCode = "200", description = "Tarefas encontradas com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<List<TarefasDTOResponse>> buscarListaTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader(name = "Authorization",required = false) String token
    ) {
        return ResponseEntity.ok(tarefasService.buscarTarefasAgendadasPorPeriodo(dataInicial, dataFinal,token));
    }

    @GetMapping
    // Swagger
    @Operation(summary = "Buscar lista de tarefas por email de usuario", description = "Buscar tarefas cadastradas por email")
    @ApiResponse(responseCode = "200", description = "Tarefas encontradas com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "403", description = "Email nao encontrado")
    @ApiResponse(responseCode = "401", description = "Usuario nao autorizado")
    public ResponseEntity<List<TarefasDTOResponse>> buscarTarefaPorEmail(@RequestHeader(name = "Authorization",required = false) String token) {
        return ResponseEntity.ok(tarefasService.buscarTarefasPorEmail(token));
    }

    @DeleteMapping
    // Swagger
    @Operation(summary = "Deleta tarefas por id da tarefa", description = "Deleta tarefas cadastradas por id")
    @ApiResponse(responseCode = "200", description = "Tarefas deletadas com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "403", description = "Tarefa id nao encontrado")
    @ApiResponse(responseCode = "401", description = "Usuario nao autorizado")
    public ResponseEntity<Void> deletarTarefaPorId(@RequestParam String id, @RequestHeader(name = "Authorization",required = false) String token) {
        tarefasService.deletarTarefaPorId(id,token);
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    // Swagger
    @Operation(summary = "Altera status de tarefa", description = "Altera status das tarefas cadastradas")
    @ApiResponse(responseCode = "200", description = "Status da Tarefa alterado com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "403", description = "Tarefa id nao encontrado")
    @ApiResponse(responseCode = "401", description = "Usuario nao autorizado")
    public ResponseEntity<TarefasDTOResponse> alterarStatusNotificacao(@RequestParam("status") StatusNotificacaoEnum status,
                                                               @RequestParam("id") String id,
                                                               @RequestHeader(name = "Authorization",required = false) String token) {
        return ResponseEntity.ok(tarefasService.alterarStatus(status, id,token));
    }

    @PutMapping
    // Swagger
    @Operation(summary = "Altera dados de tarefa", description = "Altera dados das tarefas cadastradas")
    @ApiResponse(responseCode = "200", description = "Tarefas alteradas com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "403", description = "Tarefa id nao encontrado")
    @ApiResponse(responseCode = "401", description = "Usuario nao autorizado")
    public ResponseEntity<TarefasDTOResponse> updateTarefas(@RequestBody TarefasDTORequest dto,
                                                    @RequestParam("id") String id,
                                                    @RequestHeader(name = "Authorization",required = false) String token) {
        return ResponseEntity.ok(tarefasService.updateTarefas(dto, id,token));
    }


}
