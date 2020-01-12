package com.example.demo.service;

import com.example.demo.dao.MoviePlayRepository;
import com.example.demo.po.Movie;
import com.example.demo.po.MoviePlay;
import com.example.demo.vo.MoviePlayQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public Page<MoviePlay> filterMoviePlay(Pageable pageable, MoviePlayQuery moviePlayQuery) {
        return moviePlayRepository.findAll(new Specification<MoviePlay>() {
            @Override
            public Predicate toPredicate(Root<MoviePlay> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if (!"".equals(moviePlayQuery.getCompanyname())) {
                    predicates.add(criteriaBuilder.equal(root.<String>get("companyname"), moviePlayQuery.getCompanyname()));
                }

                if (!"".equals(moviePlayQuery.getTheatername())) {
                    predicates.add(criteriaBuilder.equal(root.<String>get("theatername"), moviePlayQuery.getTheatername()));
                }

                if (!"".equals(moviePlayQuery.getMoviename())) {
                    if (moviePlayQuery.getMoviename() != null)
                        predicates.add(criteriaBuilder.like(root.get("moviename"), '%'+moviePlayQuery.getMoviename()+'%'));
                }

                Join<MoviePlay, Movie> joinMovie = root.join("movie", JoinType.LEFT);

                if (!"".equals(moviePlayQuery.getDuration_min())) {
                    if (moviePlayQuery.getDuration_min() != null) {
                        int duration_min = Integer.parseInt(moviePlayQuery.getDuration_min());
                        predicates.add(criteriaBuilder.ge(joinMovie.<Integer>get("duration"), duration_min));
                    }
                }

                if (!"".equals(moviePlayQuery.getDuration_max())) {
                    if (moviePlayQuery.getDuration_max() != null) {
                        int duration_max = Integer.parseInt(moviePlayQuery.getDuration_max());
                        predicates.add(criteriaBuilder.le(joinMovie.<Integer>get("duration"), duration_max));
                    }
                }

                if (!"".equals(moviePlayQuery.getRelease_min())) {
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.<String>get("releasedate"), moviePlayQuery.getRelease_min()));
                }

                if (!"".equals(moviePlayQuery.getRelease_max())) {
                    predicates.add(criteriaBuilder.lessThanOrEqualTo(root.<String>get("releasedate"), moviePlayQuery.getRelease_max()));
                }

                if (!"".equals(moviePlayQuery.getPlaydate_min())) {
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.<String>get("date"), moviePlayQuery.getPlaydate_min()));
                }

                if (!"".equals(moviePlayQuery.getPlaydate_max())) {
                    predicates.add(criteriaBuilder.lessThanOrEqualTo(root.<String>get("date"), moviePlayQuery.getPlaydate_max()));
                }

                query.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }
        }, pageable);
    }
}
