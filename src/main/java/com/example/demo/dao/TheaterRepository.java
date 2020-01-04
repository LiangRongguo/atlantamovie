package com.example.demo.dao;

import com.example.demo.po.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TheaterRepository extends JpaRepository<Theater, String>, JpaSpecificationExecutor<Theater> {

}
