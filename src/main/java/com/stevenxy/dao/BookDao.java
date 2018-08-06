package com.stevenxy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stevenxy.entity.Book;

/**
* @author stevenxy E-mail:random_xy@163.com
* @Date 2018年8月4日
* @Description 
*/
public interface BookDao extends JpaRepository<Book, Integer>{
	
}
