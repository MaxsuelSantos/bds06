package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreService {

    @Autowired
    private GenreRepository repository;


    @Transactional(readOnly = true)
    public List<GenreDTO> findAll() {
        List<Genre> entities = repository.findAll();
        return entities.stream().map(GenreDTO::new).collect(Collectors.toList());
    }

}
