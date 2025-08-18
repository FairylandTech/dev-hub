/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-16 13:33:47 UTC+08:00
 ****************************************************/
package org.example.enums;

import jakarta.validation.constraints.NotNull;

/**
 * @author Lionel Johnson
 */
public enum Gender {
    MALE("男"),
    FEMALE("女");
    
    private final String chineseName;
    
    Gender(String chineseName) {
        this.chineseName = chineseName;
    }
    
    public static Gender fromString(@NotNull String name) {
        String input = name.trim().toUpperCase();
        for (Gender color : values()) {
            if (color.chineseName.equals(name) || color.name().equals(input)) {
                return color;
            }
        }
        throw new IllegalArgumentException("无效枚举: " + name);
    }
    
    @Override
    public String toString() {
        return chineseName;
    }
}
