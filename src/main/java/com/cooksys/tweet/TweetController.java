package com.cooksys.tweet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("tweets")
public class TweetController {

	private final TweetService tweetService;
	
	@Autowired
	public TweetController (TweetService tweetService) {
		super();
		this.tweetService = tweetService;
	}
}
