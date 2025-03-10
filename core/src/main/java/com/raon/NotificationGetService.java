package com.raon;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 10.
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class NotificationGetService {

	private final NotificationRepository notificationRepository;

	public Optional<Notification> getNotification(NotificationType type, Long commentId) {
		return notificationRepository.findByTypeAndCommentId(type, commentId);
	}
}
