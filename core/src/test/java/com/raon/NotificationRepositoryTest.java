package com.raon;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 9.
 */
@SpringBootApplication
@SpringBootTest
class NotificationRepositoryTest {

	private final Instant now = Instant.now();
	@Autowired
	private NotificationRepository sut;

	@Test
	void test_save() {
		// 알림 객체 생성
		CommentNotification notification = new CommentNotification(
			"1",
			2L,
			NotificationType.COMMENT,
			now,
			now.plus(90, ChronoUnit.DAYS),
			now.minus(1, ChronoUnit.DAYS),
			now,
			100L,
			101L,
			"Test comment"
		);

		// 저장
		sut.save(notification);
		// 조회 했을 때 객체가 있나?
		Optional<Notification> result = sut.findById("1");

		assertTrue(result.isPresent());
	}

	@Test
	void test_find_by_id() {
		// 알림 객체 생성
		CommentNotification notification = new CommentNotification(
			"1",
			2L,
			NotificationType.COMMENT,
			now,
			now.plus(90, ChronoUnit.DAYS),
			now.minus(1, ChronoUnit.DAYS),
			now,
			100L,
			101L,
			"Test comment"
		);

		sut.save(notification);
		// 조회 했을 때 객체가 있나?
		Optional<Notification> result = sut.findById("1");
		Notification findedNotification = result.get();

		assertTrue(result.isPresent());
		assertEquals("1", findedNotification.getId());
		assertEquals(2L, findedNotification.getUserId());
		assertEquals(NotificationType.COMMENT, findedNotification.getType());
		assertEquals(now.getEpochSecond(), findedNotification.getCreatedAt().getEpochSecond());
		assertEquals(now.plus(90, ChronoUnit.DAYS).getEpochSecond(),
			findedNotification.getDeletedAt().getEpochSecond());
	}

	@Test
	void test_delete_by_id() {
		// 알림 객체 생성
		CommentNotification notification = new CommentNotification(
			"1",
			2L,
			NotificationType.COMMENT,
			now,
			now.plus(90, ChronoUnit.DAYS),
			now.minus(1, ChronoUnit.DAYS),
			now,
			100L,
			101L,
			"Test comment"
		);

		sut.save(notification);
		sut.deleteById("1");

		assertFalse(sut.findById("1").isPresent());
	}
}