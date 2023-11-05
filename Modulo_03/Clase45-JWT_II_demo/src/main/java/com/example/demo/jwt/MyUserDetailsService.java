package com.example.demo.jwt;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    public UsuarioRepository usuarioRepository;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        return new User("foo", "foo", new ArrayList<>());
        Optional<Usuario> usuario = usuarioRepository.findUsuarioByNombre(userName);
        if(usuario.isPresent()){
            return usuario.get();
        }else{
            throw new UsernameNotFoundException("Username incorrecto");
        }
    }
}
