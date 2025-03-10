package com.raon;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 10.
 */
@Getter
@AllArgsConstructor
public class Post {
	private Long id;
	private Long userId;
	private String imageUrl;
	private String content;

}
