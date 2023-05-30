package com.sample.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sample.model.Item;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{


 @Query( value = "Select * from item i where i.ehtiyat_kodu = :item_code ",
 nativeQuery = true)
 Item findByItemCode(@Param("item_code") String item_code);


}
