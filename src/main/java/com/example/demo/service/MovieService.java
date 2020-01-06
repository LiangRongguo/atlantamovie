package com.example.demo.service;

import com.example.demo.po.Movie;

public interface MovieService {
    Movie findMovie(String name, String releasedate);
    Movie saveMovie(String name, int duration, String releasedate);
}
