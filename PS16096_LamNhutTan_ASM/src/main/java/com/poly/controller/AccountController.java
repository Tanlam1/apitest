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

import com.poly.dao.AccountDAO;
import com.poly.entity.Account;
import com.poly.entity.Category;
import com.poly.entity.Product;

@Controller
public class AccountController {
	@Autowired
	AccountDAO dao;

	@RequestMapping("/admin/account")
	public String index(Model model) {
		Account item = new Account();
		model.addAttribute("item", item);
		List<Account> items = dao.findAll();
		model.addAttribute("items", items);
		return "admin/account";
	}

	@RequestMapping("/admin/account/edit/{id}")
	public String edit(Model model, @PathVariable("id") String id) {
		Account item = dao.findById(id).get();
		model.addAttribute("item", item);
		List<Account> items = dao.findAll();
		model.addAttribute("items", items);
		return "admin/account";
	}

	@RequestMapping("/admin/account/create")
	public String create(Account item) {
		dao.save(item);
		return "redirect:/admin/account";
	}

	@RequestMapping("/admin/account/update")
	public String update(Account item) {
		dao.save(item);
		return "redirect:/admin/account/edit/" + item.getUsername();
	}

	@RequestMapping("/admin/account/delete/{id}")
	public String create(@PathVariable("id") String id) {
		dao.deleteById(id);
		return "redirect:/admin/account";
	}
	
	@RequestMapping("/admin/sortaccount")
	public String sort(Model model, 
			@RequestParam("field") Optional<String> field) {
		Sort sort = Sort.by(Direction.DESC, field.orElse("username"));
		model.addAttribute("field", field.orElse("username").toUpperCase());
		List<Account> items = dao.findAll(sort);
		model.addAttribute("items", items);
		return "admin/sortaccount";	
	}
	
	@RequestMapping("/admin/pageaccount")
	public String paginate(Model model, @RequestParam("p") Optional<Integer> p) {
		Pageable pageable = PageRequest.of(p.orElse(0), 5);
		Page<Account> page = dao.findAll(pageable);
		model.addAttribute("page", page);
		return "/admin/pageaccount";
	}
}
