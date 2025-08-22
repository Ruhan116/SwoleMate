package com.painfullove.rongbuzz.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private ERole name;
    
    public enum ERole {
        ROLE_ADMIN,
        ROLE_USER,
        ROLE_TAILOR,
        ROLE_VENDOR
    }
}
