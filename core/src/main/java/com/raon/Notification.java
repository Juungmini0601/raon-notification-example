package com.raon;

import java.time.Instant;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 9.
 */

enum NotificationType {
	LIKE,
	COMMENT,
	FOLLOW,
}

public class Notification {
	public String id;
	public Long userId;
	public NotificationType type;
	public Instant createdAt;
	public Instant deletedAt;

	public Notification(String id, Long userId, NotificationType type, Instant createdAt, Instant deletedAt) {
		this.id = id;
		this.userId = userId;
		this.type = type;
		this.createdAt = createdAt;
		this.deletedAt = deletedAt;
	}
}
