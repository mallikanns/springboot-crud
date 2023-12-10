package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Job;
import com.example.demo.repository.JobRepository;

@Service
public class JobService {
	
	@Autowired
	JobRepository repo;

	public List<Job> findAll() {
		return repo.findAll();
	}

	public Job findOne(String id) {
		return repo.findById(id).get();
	}

	public Job addJob(Job job) {
		Job ret = null;
		try {
			findOne(job.getId());
		} catch (NoSuchElementException e) {
			System.out.println(job.getId());
			ret = repo.save(job);
		}
		return ret;
	}

	public Job updateJob(String id, Job job) {
		Job ret = null;
		try {
			findOne(job.getId());
			ret = repo.save(job);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return ret;
	}

}
