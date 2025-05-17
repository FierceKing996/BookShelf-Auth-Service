package com.example.booklibrary.config;

import com.example.booklibrary.model.Role;
import com.example.booklibrary.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final RoleRepository roleRepository;

    public DataInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void initRoles() {
        // Define the roles you need
        String[] roles = { "ROLE_USER", "ROLE_ADMIN" };

        for (String roleName : roles) {
            // If missing, insert it
            roleRepository.findByName(roleName)
                    .orElseGet(() -> roleRepository.save(new Role(null, roleName)));
        }
    }
}
