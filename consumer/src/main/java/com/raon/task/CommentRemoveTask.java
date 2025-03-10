package com.raon.task;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.raon.NotificationGetService;
import com.raon.NotificationRemoveService;
import com.raon.NotificationType;
import com.raon.Post;
import com.raon.PostClient;
import com.raon.event.CommentEvent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 10.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CommentRemoveTask {

	private final PostClient postClient;
	private final NotificationGetService notificationGetService;
	private final NotificationRemoveService notificationRemoveService;

	public void processEvent(CommentEvent event) {
		Post post = postClient.getPost(event.getPostId());
		if (Objects.equals(post.getUserId(), event.getUserId())) {
			return;
		}

		notificationGetService.getNotification(NotificationType.COMMENT, event.getCommentId())
			.ifPresentOrElse(
				notification -> {
					// 삭제
					notificationRemoveService.deleteById(notification.getId());
				},
				() -> log.error("Notification not Found")
			);

	}
}
