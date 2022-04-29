package com.javatipsandinterview.basic.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javatipsandinterview.basic.dto.UserDTO;

@RestController
public class AppController {

	List<UserDTO> userList = new ArrayList<>();

	@GetMapping("/")
	public String test() {
		return "Hello world";
	}

	// localhost:8080/search?query=hello
	@GetMapping("/search")
	public String search(@RequestParam String query) {
		return "Your Query " + query;

	}
	// localhost:8080/id/{value}

	@GetMapping("/rollNo/{id}")
	public Stream<UserDTO> findbyRollNumber(@PathVariable String id) {

		return userList.stream().filter(k -> k.getRollNo().equals(id));
	}

	@PostMapping("/save")
	public List<UserDTO> saveUser(@RequestBody UserDTO user) {
		userList.add(user);
		return userList;
	}

	@DeleteMapping("/rollNo/{id}")
	public String deleteUser(@PathVariable String id) {
		if (userList.removeIf(k -> k.getRollNo().equals(id))) {
			return "removed";
		} else {
			return "not found";
		}

	}

	@PutMapping("/update")
	public List<UserDTO> update(@RequestBody UserDTO user) {

		int index = IntStream.range(0, userList.size())
				.filter(k -> userList.get(k).getRollNo().equals(user.getRollNo())).findFirst().orElse(0);
		userList.set(index, user);
		return userList;
	}

}
