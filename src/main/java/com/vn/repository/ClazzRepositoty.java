package com.vn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vn.entity.Clazz;

@Repository
public interface ClazzRepositoty extends JpaRepository<Clazz, Integer> {

}
