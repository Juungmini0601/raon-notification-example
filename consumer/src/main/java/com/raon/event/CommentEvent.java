package com.raon.event;

import lombok.Data;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 9.
 */
@Data
public class CommentEvent {
	private CommentEventType type;
	private Long postId;
	private Long userId;
	private Long commentId;
}
