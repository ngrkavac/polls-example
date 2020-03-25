package com.doodle.polls.service;

import com.doodle.polls.model.Poll;
import com.doodle.polls.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PollsService {

    @Autowired
    PollRepository pollRepository;

    public List<Poll> getPollsForUser(String user, String searchParam, String fromDate) {
        List<Poll> polls = searchParam != null ? pollRepository.findByName(getCriteria(searchParam), user) : pollRepository.findByName(user);
        return fromDate != null ? filterPollsFromdate(polls, fromDate) : polls;
    }

    private TextCriteria getCriteria(String searchParam) {
        return TextCriteria.forDefaultLanguage().matchingPhrase(searchParam);
    }

    private List<Poll> filterPollsFromdate(List<Poll> polls, String fromDate) {
        return polls.stream().filter(poll -> isAfter(poll.getInitiated(), fromDate)).collect(Collectors.toList());
    }

    private boolean isAfter(long date, String fromDate) {
        try {
            Timestamp fromTimestamp = Timestamp.valueOf(fromDate);
            Timestamp timestamp = new Timestamp(date);
            return timestamp.after(fromTimestamp);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Invalid date", e);
        }
    }
}
