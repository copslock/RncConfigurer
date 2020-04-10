package com.dao;

import com.model.RncList;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RncListRepository /*extends CrudRepository<RncList, Integer>*/ {

  List<RncList> findByName(String name);

}
