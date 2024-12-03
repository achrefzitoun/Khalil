package com.example.back.Entites.auth;

import com.example.back.Entites.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Token implements Serializable {

    static final long serialVersionUID = 1905122041950251207L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idToken;

    String token;

    @Enumerated(EnumType.STRING)
    TokenType tokenType;

    boolean expired;

    boolean revoked;


    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

}
