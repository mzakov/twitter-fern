package com.cooksys.user;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.cooksys.tweet.Tweet;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = {"username"}))
public class User {

	Date created;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable=false)
	private long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="creation_date", insertable = false, updatable = false)
	private Date creationDate() {
		return created;
	};
	
	@PrePersist
	protected void onCreate() {
		created = new Date();
	};
	
	@Column(name="username", updatable = false, nullable=false)
	private long username;
	
	@Column(name="password", insertable = false, updatable = false, nullable=false)
	private String password;
	
	@OneToMany(mappedBy = "user", fetch=FetchType.LAZY)
	@JsonIgnore
	private Set<Tweet> tweets;
	
	@ManyToMany(mappedBy="follower")
	private Set<User> followed;
	   
	@ManyToMany
	@JoinTable(name="followed_follower")
	private Set<User> follower;

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUsername() {
		return username;
	}

	public void setUsername(long username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(Set<Tweet> tweets) {
		this.tweets = tweets;
	}

	public Set<User> getFollowing() {
		return followed;
	}

	public void setFollowing(Set<User> following) {
		this.followed = following;
	}

	public Set<User> getFollowers() {
		return follower;
	}

	public void setFollowers(Set<User> followers) {
		this.follower = followers;
	}


}
