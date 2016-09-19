package com.cooksys.tweet;


import java.util.Date;

import javax.persistence.*;

import com.cooksys.user.User;

@Entity
@Table(name = "tweets")
public class Tweet {

	Date created;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
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
	
	@ManyToOne(optional=false, fetch=FetchType.EAGER)
	@JoinColumn(name="user_id") //State is not a column type. This is the column that represents a join between entity, not contains the entity
	private User user;
	
	@Column(name="content", updatable = false)
	private String content;
	
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
