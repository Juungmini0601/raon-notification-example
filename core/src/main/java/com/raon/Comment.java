package com.raon;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 10.
 */
@Getter
@AllArgsConstructor
public class Comment {
	private Long id;
	private Long userId;
	private String content;
	private Instant createdAt;
}
