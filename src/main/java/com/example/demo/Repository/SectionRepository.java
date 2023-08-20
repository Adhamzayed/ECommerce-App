package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Section;
@Repository
public interface SectionRepository extends JpaRepository<Section,Integer>{

}
