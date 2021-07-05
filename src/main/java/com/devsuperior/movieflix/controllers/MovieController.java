package com.devsuperior.movieflix.controllers;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.MovieGenreDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService service;


    @GetMapping
    public ResponseEntity<Page<MovieGenreDTO>> findByGenre(
            @RequestParam(value = "genreId", defaultValue = "0") Long genreId,
            Pageable pageable
    ) {
        return ResponseEntity.ok().body(service.findByGenre(genreId, pageable));
    }

    @GetMapping("/{id}/reviews")
    public ResponseEntity<List<ReviewDTO>> findReview(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findReview(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
}
