package com.raon.event;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.raon.task.CommentAddTask;
import com.raon.task.CommentRemoveTask;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 9.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CommentEventConsumer {

	private final CommentAddTask commentAddTask;
	private final CommentRemoveTask commentRemoveTask;

	// 여기에 정의한 함수의 이름은 function.definition에 적힌 이름이랑 동일 해야함
	@Bean("comment")
	public Consumer<CommentEvent> comment() {
		return event -> {
			if (event.getType() == CommentEventType.ADD) {
				commentAddTask.processEvent(event);
			} else if (event.getType() == CommentEventType.REMOVE) {
				commentRemoveTask.processEvent(event);
			}
		};
	}
}
