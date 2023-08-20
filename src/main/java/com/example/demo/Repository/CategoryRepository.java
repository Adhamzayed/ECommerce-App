package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer>{

	@Query(nativeQuery = true,value = "select * from category c where c.section_id=:id")
	List<Category> findCategoryBySection(@Param("id") Integer id);
	
//	@Query(nativeQuery = true,value = "select * from category c where c.section_id=:id")
//	List<Category> findCategoryBySection();
}
