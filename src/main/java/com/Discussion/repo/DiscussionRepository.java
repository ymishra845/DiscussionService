package com.Discussion.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Discussion.entity.Discussion;

public interface DiscussionRepository extends JpaRepository<Discussion, UUID> {
}