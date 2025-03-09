package com.raon;

import java.util.Optional;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 9.
 */
public interface NotificationRepository {
	Optional<Notification> findById(String id);

	Notification save(Notification notification);

	Notification deleteById(String id);
}
