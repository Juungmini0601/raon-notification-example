package com.raon;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 9.
 */
public class NotificationRepositoryMemoryImpl implements NotificationRepository{

	private final Map<String, Notification> memory = new HashMap<>();

	@Override
	public Optional<Notification> findById(String id) {
		return Optional.ofNullable(memory.get(id));
	}

	@Override
	public Notification save(Notification notification) {
		memory.put(notification.id, notification);
		return notification;
	}

	@Override
	public Notification deleteById(String id) {
		return memory.remove(id);
	}
}
