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

import com.poly.dao.OrderDAO;
import com.poly.entity.Account;
import com.poly.entity.Category;
import com.poly.entity.Order;
import com.poly.entity.OrderDetail;

@Controller
public class OrderController {
	@Autowired
	OrderDAO dao;
	
	@RequestMapping("/admin/order")
	public String index(Model model) {
		Order item = new Order();
		model.addAttribute("item", item);
		List<Order> items = dao.findAll();
		model.addAttribute("items", items);
		return "admin/order";
	}

	@RequestMapping("/admin/order/edit/{id}")
	public String edit(Model model, @PathVariable("id") Long id) {
		Order item = dao.findById(id).get();
		model.addAttribute("item", item);
		List<Order> items = dao.findAll();
		model.addAttribute("items", items);
		return "admin/order";
	}

	@RequestMapping("/admin/order/create")
	public String create(Order item) {
		dao.save(item);
		return "redirect:/admin/order";
	}

	@RequestMapping("/admin/order/update")
	public String update(Order item) {
		dao.save(item);
		return "redirect:/admin/order/edit/" + item.getId();
	}

	@RequestMapping("/admin/order/delete/{id}")
	public String create(@PathVariable("id") Long id) {
		dao.deleteById(id);
		return "redirect:/admin/order";
	}
	
	@RequestMapping("/admin/sortorder")
	public String sort(Model model, 
			@RequestParam("field") Optional<String> field) {
		Sort sort = Sort.by(Direction.DESC, field.orElse("id"));
		model.addAttribute("field", field.orElse("id").toUpperCase());
		List<Order> items = dao.findAll(sort);
		model.addAttribute("items", items);
		return "admin/sortorder";	
	}
	
	@RequestMapping("/admin/pageorder")
	public String paginate(Model model, @RequestParam("p") Optional<Integer> p) {
		Pageable pageable = PageRequest.of(p.orElse(0), 5);
		Page<Order> page = dao.findAll(pageable);
		model.addAttribute("page", page);
		return "/admin/pageorder";
	}
}
