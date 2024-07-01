package com.Discussion.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Discussion {

    public Discussion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Discussion(UUID id, UUID userId, String text, String imageUrl, String createdOn) {
		super();
		this.id = id;
		this.userId = userId;
		this.text = text;
		this.imageUrl = imageUrl;
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "Discussion [id=" + id + ", userId=" + userId + ", text=" + text + ", imageUrl=" + imageUrl
				+ ", createdOn=" + createdOn + "]";
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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
    private UUID userId;

    @Column(nullable = false)
    private String text;

    @Column
    private String imageUrl;

    @Column(nullable = false)
    private String createdOn;

	
}