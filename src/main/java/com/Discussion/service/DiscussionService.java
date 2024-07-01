package com.Discussion.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Discussion.entity.Discussion;
import com.Discussion.repo.DiscussionRepository;

@Service
public class DiscussionService {

    @Autowired
    private DiscussionRepository discussionRepository;

    @Autowired
    private RestTemplate restTemplate;

    private final String USER_SERVICE_URL = "http://localhost:8081/api/users"; // Replace with actual User Microservice URL

    public Discussion createDiscussion(Discussion discussion) {
        // Call User Microservice to check if user exists
        String url = USER_SERVICE_URL + "/" + discussion.getId();
        Boolean userExists = restTemplate.getForObject(url, Boolean.class);

        if (userExists != null && userExists) {
            return discussionRepository.save(discussion);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public Optional<Discussion> updateDiscussion(UUID discussionId, Discussion discussionDetails) {
        return discussionRepository.findById(discussionId).map(discussion -> {
            discussion.setText(discussionDetails.getText());
            discussion.setImageUrl(discussionDetails.getImageUrl());
            return discussionRepository.save(discussion);
        });
    }

    public void deleteDiscussion(UUID discussionId) {
        discussionRepository.deleteById(discussionId);
    }

    public List<Discussion> getAllDiscussions() {
        return discussionRepository.findAll();
    }
}