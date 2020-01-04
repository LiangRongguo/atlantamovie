package com.example.demo.service;

import com.example.demo.po.Theater;
import com.example.demo.vo.TheaterQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TheaterService {
    Page<Theater> listTheater(Pageable pageable);
    Page<Theater> filterTheater(Pageable pageable, TheaterQuery theater);
}
