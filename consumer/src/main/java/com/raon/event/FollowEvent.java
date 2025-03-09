package com.raon.event;

import java.time.Instant;

import lombok.Data;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 9.
 */
@Data
public class FollowEvent {
	private FollowEventType type;
	private Long userId;
	private Long targetUserId;
	private Instant createdAt;
}
