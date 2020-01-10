package com.example.demo.service;

import com.example.demo.po.Used;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsedService {
    Page<Used> filterUsed(Pageable pageable, String username);
}
