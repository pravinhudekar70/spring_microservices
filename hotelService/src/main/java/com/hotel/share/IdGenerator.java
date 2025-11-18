package com.hotel.share;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class IdGenerator {
	 // General method for generating ID with prefix
    public static String generateId(String prefix) {
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss"));
        String randomPart = UUID.randomUUID().toString().replace("-", "").substring(0, 5);
        return prefix + "-" + dateTime + randomPart;
    }

}
