package com.poly.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.poly.entity.Category;

@Service
public interface CategoryService {

	Category update(Category category);

	Category create(Category category);

	List<Category> findAll();

	Category findById(String username);

	void deleteById(String id);

}
