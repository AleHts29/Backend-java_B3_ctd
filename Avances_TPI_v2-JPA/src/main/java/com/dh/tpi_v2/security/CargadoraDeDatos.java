package com.dh.tpi_v2.security;

import com.dh.tpi_v2.entites.RolUser;
import com.dh.tpi_v2.entites.Usuario;
import com.dh.tpi_v2.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CargadoraDeDatos implements ApplicationRunner {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //cargar un user previo al inicio
        //guardar un User mediante repository
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String pass = "123qwe";
        String passHash = passwordEncoder.encode(pass);

        Usuario usuario = new Usuario();
        usuario.setNombre("userTest");
        usuario.setEmail("test@gmail.com");
        usuario.setPassword(passHash);
        usuario.setRolUser(RolUser.ROLE_USER);

        usuarioRepository.save(usuario);


    }
}
