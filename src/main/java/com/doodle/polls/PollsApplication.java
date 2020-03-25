package com.doodle.polls;

import com.doodle.polls.model.Poll;
import com.doodle.polls.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PollsApplication implements CommandLineRunner {

	@Autowired
	PollRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(PollsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("-------------------------------");
		int count = 0;
		for (Poll poll : repository.findAll()) {
			if  (poll.getOptions() != null && !poll.getOptions().isEmpty()) {
				System.out.println("Poll: " + poll.getInitiator().getName() + " " + poll.getOptions().get(0).getDate());
			}
			count++;
		}
		System.out.println(count + " number of polls");

	}

}
