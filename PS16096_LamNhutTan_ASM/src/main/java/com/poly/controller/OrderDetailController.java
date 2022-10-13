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

import com.poly.dao.OrderDetailDAO;
import com.poly.entity.OrderDetail;
import com.poly.entity.Product;

@Controller
public class OrderDetailController {
	@Autowired
	OrderDetailDAO dao;

	@RequestMapping("/admin/orderdetail")
	public String index(Model model) {
		OrderDetail item = new OrderDetail();
		model.addAttribute("item", item);
		List<OrderDetail> items = dao.findAll();
		model.addAttribute("items", items);
		return "admin/orderdetail";
	}

	@RequestMapping("/admin/orderdetail/edit/{id}")
	public String edit(Model model, @PathVariable("id") Long id) {
		OrderDetail item = dao.findById(id).get();
		model.addAttribute("item", item);
		List<OrderDetail> items = dao.findAll();
		model.addAttribute("items", items);
		return "admin/orderdetail";
	}

	@RequestMapping("/admin/orderdetail/delete/{id}")
	public String create(@PathVariable("id") Long id) {
		dao.deleteById(id);
		return "redirect:/admin/orderdetail";
	}
	
	@RequestMapping("/admin/sortorderdetail")
	public String sort(Model model, 
			@RequestParam("field") Optional<String> field) {
		Sort sort = Sort.by(Direction.DESC, field.orElse("price"));
		model.addAttribute("field", field.orElse("price").toUpperCase());
		List<OrderDetail> items = dao.findAll(sort);
		model.addAttribute("items", items);
		return "admin/sortorderdetail";	
	}
	
	@RequestMapping("/admin/pageorderdetail")
	public String paginate(Model model, @RequestParam("p") Optional<Integer> p) {
		Pageable pageable = PageRequest.of(p.orElse(0), 5);
		Page<OrderDetail> page = dao.findAll(pageable);
		model.addAttribute("page", page);
		return "/admin/pageorderdetail";
	}
}
