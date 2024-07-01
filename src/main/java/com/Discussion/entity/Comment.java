package com.Discussion.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Comment {

    public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(UUID id, UUID discussionId, UUID userId, String text, String createdOn) {
		super();
		this.id = id;
		this.discussionId = discussionId;
		this.userId = userId;
		this.text = text;
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", discussionId=" + discussionId + ", userId=" + userId + ", text=" + text
				+ ", createdOn=" + createdOn + "]";
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getDiscussionId() {
		return discussionId;
	}

	public void setDiscussionId(UUID discussionId) {
		this.discussionId = discussionId;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private UUID discussionId;

    @Column(nullable = false)
    private UUID userId;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private String createdOn;
}