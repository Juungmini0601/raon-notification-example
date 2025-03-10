package com.raon.task;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.raon.Comment;
import com.raon.CommentClient;
import com.raon.CommentNotification;
import com.raon.Notification;
import com.raon.NotificationIdGenerator;
import com.raon.NotificationSaveService;
import com.raon.NotificationType;
import com.raon.Post;
import com.raon.PostClient;
import com.raon.event.CommentEvent;

import lombok.RequiredArgsConstructor;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 10.
 */
@Component
@RequiredArgsConstructor
public class CommentAddTask {

	private final PostClient postClient;
	private final CommentClient commentClient;
	private final NotificationSaveService notificationSaveService;

	public void processEvent(CommentEvent event) {
		// 내가 작성한 댓글인 경우 무시
		Post post = postClient.getPost(event.getPostId());
		if (Objects.equals(post.getUserId(), event.getUserId())) {
			return;
		}

		Comment comment = commentClient.getComment(event.getCommentId());
		// 알림 생성
		Notification notification = createNotification(post, comment);
		// 저장
		notificationSaveService.insert(notification);
	}

	private Notification createNotification(Post post, Comment comment) {
		Instant now = Instant.now();

		return new CommentNotification(
			NotificationIdGenerator.generate(),
			post.getUserId(),
			NotificationType.COMMENT,
			comment.getCreatedAt(),
			now,
			now,
			now.plus(90, ChronoUnit.DAYS),
			post.getId(),
			comment.getUserId(),
			comment.getContent(),
			1L
		);
	}
}
