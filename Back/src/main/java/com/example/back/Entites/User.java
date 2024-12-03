package com.example.back.Entites;

import com.example.back.Entites.auth.Token;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements Serializable, UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idUser;

    String numUSer;

    String firstName;

    String secondName;

    String email;

    String phoneNumber;

    @Enumerated(EnumType.STRING)
    Role role;

    String identifier;

    String pwd;

    LocalDate birthDate;

    LocalDate dateCreation = LocalDate.now();

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Reservation> reservations;


    String resetToken;

    LocalDateTime resetTokenExpiryDate ;

    @OneToMany(mappedBy = "user")
    private Set<Token> tokens ;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(role.name()));
    }


    @Override
    public String getPassword() {
        return pwd ;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
