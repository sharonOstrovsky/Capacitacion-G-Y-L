package com.example.obspringdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface CacheRepository<T extends BaseClass, ID extends Serializable> extends JpaRepository<T, Long> {



}
