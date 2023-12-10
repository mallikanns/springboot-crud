package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Job;
import com.example.demo.service.JobService;

@RestController
@RequestMapping(path = "/job")
public class JobController {

	@Autowired
	JobService service;
	
	@GetMapping("/")
	public List<Job> findAll() {

		System.out.println("Find All");
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Job findOne(@PathVariable String id) {
		System.out.println(id);

//		Employee e = service.findOne(id);
//		System.out.println(e.getFirstName());
//		System.out.println(e.getDepartment().getManager().getFirstName());

		return service.findOne(id);
	}

	@PostMapping("/")
	public Job addJob(@RequestBody Job job) {
		System.out.println(job);
		return service.addJob(job);
	}

	@PutMapping("/{id}")
	public Job updateJob(@PathVariable String id, @RequestBody Job job) {
		return service.updateJob(id, job);
	}

}
