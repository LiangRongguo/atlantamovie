package com.example.demo.service;

import com.example.demo.po.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MovieService {
    Movie findMovie(String name, String releasedate);
    Movie saveMovie(String name, int duration, String releasedate);
    Page<Movie> listMovie(Pageable pageable);
}
