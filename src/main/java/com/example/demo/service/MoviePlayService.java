package com.example.demo.service;

import com.example.demo.po.MoviePlay;

public interface MoviePlayService {
    MoviePlay checkMoviePlay(String moviename,
                             String releasedate,
                             String companyname,
                             String theatername,
                             String date);
    
    MoviePlay saveMoviePlay(String moviename,
                            String releasedate,
                            String companyname,
                            String theatername,
                            String date);
}
