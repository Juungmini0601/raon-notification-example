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
public class NotificationRemoveService {
	private final NotificationRepository notificationRepository;

	public void deleteById(String commentId) {
		notificationRepository.deleteById(commentId);
	}
}
