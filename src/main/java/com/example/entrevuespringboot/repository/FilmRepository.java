package com.example.entrevuespringboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.entrevuespringboot.entite.FilmEntite;

public interface FilmRepository extends CrudRepository<FilmEntite, Long> {
}
