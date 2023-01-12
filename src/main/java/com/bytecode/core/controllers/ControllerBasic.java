package com.bytecode.core.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bytecode.core.model.Post;


@Controller
@RequestMapping("/hola")
public class ControllerBasic {
	
	@GetMapping(path = { "/", "/ndo"} )
	public String saludar() {
		return "index";
	}

	@GetMapping(path = { "/post"} )
	public String post(Model model) {
		model.addAttribute("listapost", this.getPosts());
		return "posts";
	}
	
	
	@GetMapping("/greetings")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
	
	public List<Post> getPosts(){
		ArrayList<Post> posts= new ArrayList();
		posts.add(new Post( 1,"Desarrollo Web ","https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/Tecnologias_del_internet.png/300px-Tecnologias_del_internet.png",new Date(),"Titulo 1"));
		posts.add(new Post( 2,"Desarrollo Web con Java EE ","https://images.pexels.com/photos/2261165/pexels-photo-2261165.jpeg?auto=compress&cs=tinysrgb&w=600",new Date(),"Titulo 2"));
		posts.add(new Post( 3,"Spring  Web  MVC","https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/Tecnologias_del_internet.png/300px-Tecnologias_del_internet.png",new Date(),"Titulo 3"));
		posts.add(new Post( 4,"Desarrollo Web ","https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/Tecnologias_del_internet.png/300px-Tecnologias_del_internet.png",new Date(),"Titulo 4"));
		System.out.println("enviando lista");
		return posts;
	}
	
}

/*
 * 
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>

		<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency>

 * 
 * 
 */
