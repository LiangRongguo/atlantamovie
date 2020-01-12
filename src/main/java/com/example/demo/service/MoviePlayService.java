package com.example.demo.service;

import com.example.demo.po.MoviePlay;
import com.example.demo.vo.MoviePlayQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

    Page<MoviePlay> filterMoviePlay(Pageable pageable, MoviePlayQuery moviePlayQuery);
}
