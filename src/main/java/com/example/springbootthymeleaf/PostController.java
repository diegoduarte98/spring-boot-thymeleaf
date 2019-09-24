package com.example.springbootthymeleaf;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostController {

	List<Post> posts = new ArrayList<>(Arrays.asList(new Post(1L, "", "Java 8", "", LocalDate.now()),
			new Post(2L, "", "Spring Boot", "", LocalDate.now()), new Post(3L, "", "Angular 8", "", LocalDate.now())));

	@GetMapping("/")
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("/post");
		mv.addObject("posts", posts);

		return mv;
	}

	@GetMapping("/add")
	public ModelAndView add(Post post) {

		ModelAndView mv = new ModelAndView("/postAdd");
		mv.addObject("post", post);

		return mv;
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid Post post, BindingResult result) {

		if (result.hasErrors()) {
			return add(post);
		}

		posts.add(post);

		return findAll();
	}
}
