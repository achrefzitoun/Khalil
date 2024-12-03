package com.example.back.Entites.Dto;

import lombok.*;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class RegisterRequest {
     String firstname;
     String lastname;
    LocalDate birthDate;
    String phoneNumber;
    String identifier;
    String email;
     String password;

}
