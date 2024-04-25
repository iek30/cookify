package com.tfg.cookify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsuarioControlador {

    @Autowired
    private UsuarioRepositorio userRepository;

    @GetMapping
    public List<Persona> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public Persona createUser(@RequestBody Persona user) {
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public Persona getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @PutMapping("/{id}")
    public Persona updateUser(@PathVariable Long id, @RequestBody Persona userDetails) {
    	Persona user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());

        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "User deleted successfully.";
    }
}

