package com.raon;

import org.bson.types.ObjectId;

/**
 * @author    : kimjungmin
 * Created on : 2025. 3. 10.
 */

public class NotificationIdGenerator {
	public static String generate() {
		return new ObjectId().toString();
	}
}
