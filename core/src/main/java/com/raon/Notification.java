package com.raon;

import java.time.Instant;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 9.
 */
@Getter
@AllArgsConstructor
@Document("notifications")
public abstract class Notification {
	private String id;
	private Long userId;
	private NotificationType type;
	private Instant createdAt;
	private Instant deletedAt;
	private Instant occurredAt; // 알림 대상인 실제 이벤트가 발생한 시간
	private Instant lastUpdatedAt;
}
