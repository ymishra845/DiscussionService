package com.Discussion.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Discussion.entity.Like;

public interface LikeRepository extends JpaRepository<Like, UUID> {
}
