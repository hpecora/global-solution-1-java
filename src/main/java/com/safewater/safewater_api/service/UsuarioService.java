package com.safewater.safewater_api.service;

import com.safewater.safewater_api.dto.UsuarioDTO;
import com.safewater.safewater_api.model.Usuario;
import com.safewater.safewater_api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioRepository.findFirstByEmail(email);
    }
    public Usuario salvar(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setCidade(dto.getCidade());
        usuario.setSenha(dto.getSenha());
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizar(Long id, UsuarioDTO dto) {
        Optional<Usuario> existente = usuarioRepository.findById(id);
        if (existente.isPresent()) {
            Usuario usuario = existente.get();
            usuario.setNome(dto.getNome());
            usuario.setEmail(dto.getEmail());
            usuario.setCidade(dto.getCidade());
            usuario.setSenha(dto.getSenha());
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    public boolean deletar(Long id) {
        Optional<Usuario> existente = usuarioRepository.findById(id);
        if (existente.isPresent()) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
