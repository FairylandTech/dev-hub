/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-16 11:50:21 UTC+08:00
 ****************************************************/
package org.example.enums;

import com.sun.istack.internal.NotNull;

/**
 * @author Lionel Johnson
 */
public enum Color {
    RED("红色"),
    GREEN("绿色"),
    BLACK("黑色"),
    WHITE("白色"),
    BLUE("蓝色"),
    YELLOW("黄色"),
    GRAY("灰色"),
    SILVER("银色");
    
    private final String chineseName;
    
    Color(String chineseName) {
        this.chineseName = chineseName;
    }
    
    public static Color fromString(@NotNull String name) {
        String input = name.trim().toUpperCase();
        for (Color color : values()) {
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
