package com.example.demo.service;

import com.example.demo.dao.MovieRepository;
import com.example.demo.po.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie findMovie(String name, String releasedate) {
        return movieRepository.findByNameAndReleasedate(name, releasedate);
    }

    @Override
    public Movie saveMovie(String name, int duration, String releasedate) {
        Movie movie = new Movie();
        movie.setName(name);
        movie.setReleasedate(releasedate);
        movie.setDuration(duration);
        return movieRepository.saveAndFlush(movie);
    }
}
