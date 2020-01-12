package com.example.demo.service;

import com.example.demo.dao.MoviePlayRepository;
import com.example.demo.po.MoviePlay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoviePlayServiceImpl implements MoviePlayService {
    @Autowired
    private MoviePlayRepository moviePlayRepository;

    @Override
    public MoviePlay checkMoviePlay(String moviename, String releasedate, String companyname, String theatername, String date) {
        return moviePlayRepository.findByMovienameAndReleasedateAndCompanynameAndTheaternameAndDate(moviename, releasedate, companyname, theatername, date);
    }

    @Override
    public MoviePlay saveMoviePlay(String moviename, String releasedate, String companyname, String theatername, String date) {
        MoviePlay moviePlay = new MoviePlay(moviename, releasedate, companyname, theatername, date);
        return moviePlayRepository.saveAndFlush(moviePlay);
    }
}
