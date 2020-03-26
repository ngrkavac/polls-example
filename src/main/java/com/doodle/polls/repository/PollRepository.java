package com.doodle.polls.repository;

import com.doodle.polls.model.Poll;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PollRepository extends MongoRepository<Poll, String> {

    @Query("{'initiator.name': ?0}")
    List<Poll> findByName(@Param("name") String name);
    List<Poll> findAllBy(TextCriteria criteria);
}
