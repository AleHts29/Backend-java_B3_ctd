package com.example.demo.model;

import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CargaDeDatos implements ApplicationRunner {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public CargaDeDatos(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String pass = "123qwe";
        String passHash = passwordEncoder.encode(pass);
        Usuario usuario = new Usuario();
        usuario.setNombre("nameTest");
        usuario.setPassword(passHash);
        usuario.setUsuarioRole(Usuariorole.ROLE_USER);
        usuarioRepository.save(usuario);
    }
}
