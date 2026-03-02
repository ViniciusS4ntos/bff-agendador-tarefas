 package com.vinicius.bffagendadortarefas.business;



import com.vinicius.bffagendadortarefas.business.dto.in.EnderecoDTORequest;
import com.vinicius.bffagendadortarefas.business.dto.in.LoginDTORequest;
import com.vinicius.bffagendadortarefas.business.dto.in.TelefoneDTORequest;
import com.vinicius.bffagendadortarefas.business.dto.in.UsuarioDTORequest;
import com.vinicius.bffagendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.vinicius.bffagendadortarefas.business.dto.out.TelefoneDTOResponse;
import com.vinicius.bffagendadortarefas.business.dto.out.UsuarioDTOResponse;
import com.vinicius.bffagendadortarefas.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient client;

    public UsuarioDTOResponse salvaUsuario(UsuarioDTORequest usuarioDTO){
        return client.salvarUsuario(usuarioDTO);
    }

    public String loginUsuario(LoginDTORequest dto){
        return client.login(dto);
    }

    public UsuarioDTOResponse buscarUsuarioPorEmail(String email, String token){
        return client.buscarUsuarioPorEmail(email,token);
    }

    public void deletarUsuarioPorEmail(String email, String token){
        client.deletarPorEmail(email,token);
    }

    public UsuarioDTOResponse atualizarDadosUsuario(String token, UsuarioDTORequest dto){
        return client.atualizaDadosUsuario(dto, token);
    }

    public EnderecoDTOResponse atualizarEndereco(Long id, EnderecoDTORequest enderecoDTO, String token){
        return client.atualizarEndereco(enderecoDTO, id, token);
    }

    public TelefoneDTOResponse atualizarTelefone(Long id, TelefoneDTORequest telefoneDTO, String token){
        return client.atualizarTelefone(telefoneDTO,id,token);
    }

    public EnderecoDTOResponse cadastraEndereco(String token, EnderecoDTORequest dto){
        return client.cadastraEndereco(dto,token);
    }

    public TelefoneDTOResponse cadastraTelefone(String token, TelefoneDTORequest dto){
        return client.cadastraTelefone(dto,token);
    }



}
