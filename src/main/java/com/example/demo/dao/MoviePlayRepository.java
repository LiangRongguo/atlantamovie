package com.example.demo.dao;

import com.example.demo.po.MoviePlay;
import com.example.demo.po.MoviePlayId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviePlayRepository extends JpaRepository<MoviePlay, MoviePlayId> {
    MoviePlay findByMovienameAndReleasedateAndCompanynameAndTheaternameAndDate(String moviename,
                                                                               String releasedate,
                                                                               String companyname,
                                                                               String theatername,
                                                                               String date);
}
