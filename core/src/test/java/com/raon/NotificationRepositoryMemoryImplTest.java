package com.raon;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.junit.jupiter.api.Test;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 9.
 */
class NotificationRepositoryMemoryImplTest {

	private final NotificationRepositoryMemoryImpl sut = new NotificationRepositoryMemoryImpl();

	private final Instant now = Instant.now();

	@Test
	void test_save() {
		// 알림 객체 생성
		Notification notification = new Notification("1", 2L, NotificationType.LIKE, now, now.plus(90, ChronoUnit.DAYS));
		// 저장
		sut.save(notification);
		// 조회 했을 때 객체가 있나?
		Optional<Notification> result = sut.findById("1");

		assertTrue(result.isPresent());
	}

	@Test
	void test_find_by_id() {
		Notification notification = new Notification("1", 2L, NotificationType.LIKE, now, now.plus(90, ChronoUnit.DAYS));

		sut.save(notification);
		// 조회 했을 때 객체가 있나?
		Optional<Notification> result = sut.findById("1");
		Notification findedNotification = result.get();

		assertTrue(result.isPresent());
		assertEquals("1", findedNotification.id);
		assertEquals(2L, findedNotification.userId);
		assertEquals(NotificationType.LIKE, findedNotification.type);
		assertEquals(now, findedNotification.createdAt);
		assertEquals(now.plus(90, ChronoUnit.DAYS), findedNotification.deletedAt);
	}

	@Test
	void test_delete_by_id() {
		Notification notification = new Notification("1", 2L, NotificationType.LIKE, now, now.plus(90, ChronoUnit.DAYS));

		sut.save(notification);
		sut.deleteById("1");

		assertFalse(sut.findById("1").isPresent());
	}
}