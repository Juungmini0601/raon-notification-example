package com.raon.event;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 9.
 */
@Slf4j
@Component
public class FollowEventConsumer {

	// 여기에 정의한 함수의 이름은 function.definition에 적힌 이름이랑 동일 해야함
	@Bean("follow")
	public Consumer<FollowEvent> follow() {
		return event -> log.info(event.toString());
	}
}
