package com.example.ColegioSpring.Interface;

import com.example.ColegioSpring.Entity.BaseClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface ColegioRepository<T extends BaseClass, ID extends Serializable> extends JpaRepository<T, Long> {



}
