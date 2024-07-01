package com.Discussion.repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Discussion.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, UUID> {
    List<Comment> findByDiscussionId(UUID discussionId);
}
