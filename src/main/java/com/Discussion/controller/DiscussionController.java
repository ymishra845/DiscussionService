package com.Discussion.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Discussion.entity.Discussion;
import com.Discussion.service.DiscussionService;

@RestController
@RequestMapping("/api/discussions")
public class DiscussionController {

    @Autowired
    private DiscussionService discussionService;

    @PostMapping
    public ResponseEntity<Discussion> createDiscussion(@RequestBody Discussion discussion) {
        try {
            Discussion createdDiscussion = discussionService.createDiscussion(discussion);
            return ResponseEntity.status(201).body(createdDiscussion);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null); // User not found
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Discussion> updateDiscussion(@PathVariable UUID id, @RequestBody Discussion discussionDetails) {
        Optional<Discussion> updatedDiscussion = discussionService.updateDiscussion(id, discussionDetails);
        return updatedDiscussion.map(discussion -> ResponseEntity.ok().body(discussion))
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiscussion(@PathVariable UUID id) {
        discussionService.deleteDiscussion(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Discussion>> getAllDiscussions() {
        List<Discussion> discussions = discussionService.getAllDiscussions();
        return ResponseEntity.ok().body(discussions);
    }
}