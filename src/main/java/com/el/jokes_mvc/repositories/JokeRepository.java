package com.el.jokes_mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.el.jokes_mvc.models.Joke;

public interface JokeRepository extends JpaRepository<Joke, Integer> {
}
