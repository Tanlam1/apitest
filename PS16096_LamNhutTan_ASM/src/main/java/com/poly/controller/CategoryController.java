package com.poly.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.dao.CategoryDAO;
import com.poly.entity.Account;
import com.poly.entity.Category;
import com.poly.entity.Order;

@Controller
public class CategoryController {
	@Autowired
	CategoryDAO dao;

	@RequestMapping("/admin/category")
	public String index(Model model) {
		Category item = new Category();
		model.addAttribute("item", item);
		List<Category> items = dao.findAll();
		model.addAttribute("items", items);
		return "admin/category";
	}

	@RequestMapping("/admin/category/edit/{id}")
	public String edit(Model model, @PathVariable("id") String id) {
		Category item = dao.findById(id).get();
		model.addAttribute("item", item);
		List<Category> items = dao.findAll();
		model.addAttribute("items", items);
		return "admin/category";
	}

	@RequestMapping("/admin/category/create")
	public String create(Category item) {
		dao.save(item);
		return "redirect:/admin/category";
	}

	@RequestMapping("/admin/category/update")
	public String update(Category item) {
		dao.save(item);
		return "redirect:/admin/category/edit/" + item.getId();
	}

	@RequestMapping("/admin/category/delete/{id}")
	public String create(@PathVariable("id") String id) {
		dao.deleteById(id);
		return "redirect:/admin/category";
	}
	
	@RequestMapping("/admin/sortcategory")
	public String sort(Model model, 
			@RequestParam("field") Optional<String> field) {
		Sort sort = Sort.by(Direction.DESC, field.orElse("id"));
		model.addAttribute("field", field.orElse("id").toUpperCase());
		List<Category> items = dao.findAll(sort);
		model.addAttribute("items", items);
		return "admin/sortcategory";	
	}
	
	@RequestMapping("/admin/pagecategory")
	public String paginate(Model model, @RequestParam("p") Optional<Integer> p) {
		Pageable pageable = PageRequest.of(p.orElse(0), 5);
		Page<Category> page = dao.findAll(pageable);
		model.addAttribute("page", page);
		return "/admin/pagecategory";
	}
}
