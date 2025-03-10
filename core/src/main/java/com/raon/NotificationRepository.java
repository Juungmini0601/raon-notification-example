package com.raon;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 9.
 */
@Repository
public interface NotificationRepository extends MongoRepository<Notification, String> {
	Optional<Notification> findById(String id);

	Notification save(Notification notification);

	void deleteById(String id);

	@Query("{'tyoe': ?0, 'commentId':  ?1}")
	Optional<Notification> findByTypeAndCommentId(NotificationType type, Long commentId);
}
