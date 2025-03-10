package com.raon;

import java.time.Instant;

import org.springframework.data.annotation.TypeAlias;

import lombok.Getter;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 10.
 */
@Getter
@TypeAlias("CommentNotification")
public class CommentNotification extends Notification {
	private final Long postId;
	private final Long writerId;
	private final String comment;

	public CommentNotification(
		String id,
		Long userId,
		NotificationType type,
		Instant createdAt,
		Instant deletedAt,
		Instant occurredAt,
		Instant lastUpdatedAt,
		Long postId,
		Long writerId,
		String comment
	) {
		super(id, userId, type, createdAt, deletedAt, occurredAt, lastUpdatedAt);
		this.postId = postId;
		this.writerId = writerId;
		this.comment = comment;
	}

}
