package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.Entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer>{

	@Query(nativeQuery = true,value = "select * from item i where i.category_id=:id")
	List<Item> findItemByCategory(@Param("id") Integer id);
}
