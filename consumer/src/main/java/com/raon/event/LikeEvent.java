package com.raon.event;

import java.time.Instant;

import lombok.Data;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 9.
 */
@Data
public class LikeEvent {
	private LikeEventType type;
	private Long postId;
	private Long userId;
	private Instant createdAt;
}
