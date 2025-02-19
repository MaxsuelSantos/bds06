package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Review;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class ReviewDTO implements Serializable {

    private Long id;
    @NotBlank
    private String text;
    private Long movieId;
    private UserDTO user;

    public ReviewDTO() {
    }

    public ReviewDTO(Long id, String text, UserDTO user, Long movieId) {
        this.id = id;
        this.text = text;
        this.user = user;
        this.movieId = movieId;
    }

    public ReviewDTO(Review entity) {
        id = entity.getId();
        text = entity.getText();
        user = new UserDTO(entity.getUser());
        movieId = entity.getMovie().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
}
