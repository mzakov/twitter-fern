package com.cooksys.tweet;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository <Tweet, Long> {

}
