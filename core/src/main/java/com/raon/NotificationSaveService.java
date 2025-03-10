package com.raon;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 10.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationSaveService {
	private final NotificationRepository notificationRepository;

	public void insert(Notification notification) {
		Notification result = notificationRepository.insert(notification);
		log.info("inserted: {}", result);
	}
}
