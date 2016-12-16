package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

class Cat {
	private String name;
	private Long id;

	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

	public Cat(String name, Long id) {

		this.name = name;
		this.id = id;
	}
}

@Controller
class CatController {

	private Set<Cat> cats = new HashSet<>(
			Arrays.asList(new Cat("Felix", 1L),
					new Cat("Garfield", 2L),
					new Cat("Rodger", 3L)));

	@GetMapping("/cats.html")
	String cats(Model model) {
		model.addAttribute("cats", this.cats);
		return "cats";
	}
}