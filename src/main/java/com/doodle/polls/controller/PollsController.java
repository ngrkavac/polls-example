package com.doodle.polls.controller;

import com.doodle.polls.model.Poll;
import com.doodle.polls.service.PollsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/polls")
public class PollsController {

    @Autowired
    PollsService pollsService;


    @GetMapping("/list")
    public ResponseEntity<List<Poll>> getPolls(@RequestParam(required=true) String user,
                                               @RequestParam(required=false) String searchParam,
                                               @RequestParam(required=false) String fromDate) {
        return ResponseEntity.ok(pollsService.getPollsForUser(user, searchParam, fromDate));
    }

}
