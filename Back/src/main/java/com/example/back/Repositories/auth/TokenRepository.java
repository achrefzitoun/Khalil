package com.example.back.Repositories.auth;

import com.example.back.Entites.auth.Token;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {

    @Query("select token from Token token inner join User u on token.user.idUser = u.idUser where u.idUser = :userId and" +
            " (token.expired = false or token.revoked = false)")
    List<Token> findAllValidTokensByCompte(Integer userId);


    Optional<Token> findByToken (String token);
}