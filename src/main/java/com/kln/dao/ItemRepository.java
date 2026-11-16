package com.kln.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.kln.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {

}
