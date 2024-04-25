package com.tfg.cookify;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Persona, Long> {
}
