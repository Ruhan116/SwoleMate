package com.painfullove.rongbuzz.config;

import com.painfullove.rongbuzz.entity.Role;
import com.painfullove.rongbuzz.entity.User;
import com.painfullove.rongbuzz.repository.RoleRepository;
import com.painfullove.rongbuzz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public void run(String... args) throws Exception {
        // Initialize roles
        initializeRoles();
        
        // Initialize default admin user
        initializeDefaultAdmin();
    }
    
    private void initializeRoles() {
        if (roleRepository.count() == 0) {
            Role adminRole = new Role();
            adminRole.setName(Role.ERole.ROLE_ADMIN);
            roleRepository.save(adminRole);
            
            Role userRole = new Role();
            userRole.setName(Role.ERole.ROLE_USER);
            roleRepository.save(userRole);
            
            Role tailorRole = new Role();
            tailorRole.setName(Role.ERole.ROLE_TAILOR);
            roleRepository.save(tailorRole);
            
            Role vendorRole = new Role();
            vendorRole.setName(Role.ERole.ROLE_VENDOR);
            roleRepository.save(vendorRole);
            
            System.out.println("Roles initialized successfully!");
        }
    }
    
    private void initializeDefaultAdmin() {
        if (!userRepository.existsByUsername("admin")) {
            User adminUser = new User();
            adminUser.setUsername("admin");
            adminUser.setEmail("admin@rongbuzz.com");
            adminUser.setPassword(passwordEncoder.encode("admin123"));
            adminUser.setFirstName("Admin");
            adminUser.setLastName("User");
            adminUser.setPhoneNumber("+1234567890");
            
            Set<Role> roles = new HashSet<>();
            Role adminRole = roleRepository.findByName(Role.ERole.ROLE_ADMIN)
                    .orElseThrow(() -> new RuntimeException("Admin role not found"));
            roles.add(adminRole);
            adminUser.setRoles(roles);
            
            userRepository.save(adminUser);
            System.out.println("Default admin user created successfully!");
        }
    }
}
