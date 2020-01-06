package com.example.demo.service;

import com.example.demo.dao.MovieRepository;
import com.example.demo.po.Movie;
import com.example.demo.po.MovieId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie findMovie(String name, String releasedate) {
        return movieRepository.findById_NameAndId_Releasedate(name, releasedate);
    }

    @Override
    public Movie saveMovie(String name, int duration, String releasedate) {
        Movie movie = new Movie();
        MovieId id = new MovieId(name, releasedate);
        movie.setId(id);
        movie.setDuration(duration);
        return movieRepository.saveAndFlush(movie);
    }
}
