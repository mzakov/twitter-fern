package com.cooksys.tweet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TweetServiceImpl implements TweetService{
	
	private final TweetRepository tweetRepo;
	
	@Autowired
	public TweetServiceImpl(TweetRepository tweetRepo) {
		super();
		this.tweetRepo = tweetRepo;
	}

}
