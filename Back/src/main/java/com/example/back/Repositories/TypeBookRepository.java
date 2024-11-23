package com.example.back.Repositories;

import com.example.back.Entites.TypeBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeBookRepository extends JpaRepository<TypeBook, Integer> {
}