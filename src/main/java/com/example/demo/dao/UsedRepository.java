package com.example.demo.dao;

import com.example.demo.po.Used;
import com.example.demo.po.UsedId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UsedRepository extends JpaRepository<Used, UsedId>, JpaSpecificationExecutor<Used> {
}
