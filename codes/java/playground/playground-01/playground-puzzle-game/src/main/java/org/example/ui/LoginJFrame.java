/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-18 21:02:54 UTC+08:00
 ****************************************************/
package org.example.ui;

import javax.swing.*;

/**
 * @author Lionel Johnson
 */
public class LoginJFrame extends JFrame {
    public LoginJFrame() {
        this.setSize(488 * 2, 430 * 2);
        // 设置标题
        this.setTitle("拼图小游戏-登录");
        // 设置图层置顶
        this.setAlwaysOnTop(true);
        // 程序居中
        this.setLocationRelativeTo(null);
        // 关闭模式: 点击x关闭
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        this.setVisible(true);
    }
}
