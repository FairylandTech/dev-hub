/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-18 21:00:54 UTC+08:00
 ****************************************************/
package org.example.ui;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * @author Lionel Johnson
 */
public class GameJFrame extends JFrame {
    public GameJFrame() {
        // 初始化 JFrame 控件
        initJFrame();
        // 初始化菜单栏
        initMenu();
        // 初始化图片
        initImage();
        
        this.setVisible(true);
    }
    
    public void initJFrame() {
        this.setSize(603 * 2, 680 * 2);
        // 设置标题
        this.setTitle("拼图小游戏-单机版 v0.1");
        // 设置图层置顶
        this.setAlwaysOnTop(true);
        // 程序居中
        this.setLocationRelativeTo(null);
        // 关闭模式: 点击x关闭
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    public void initMenu() {
        UIManager.put("MenuBar.font", new Font(null, Font.PLAIN, 22)); // 菜单栏字体
        UIManager.put("Menu.font", new Font(null, Font.PLAIN, 22));    // 菜单字体
        UIManager.put("MenuItem.font", new Font(null, Font.PLAIN, 22)); // 菜单项字体
        
        JMenuBar jMenuBar = new JMenuBar();
        Font font = new Font(null, Font.PLAIN, 22);
        
        JMenu funcJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");
        
        // 功能
        JMenuItem replayJMenuItem = new JMenuItem("重新游戏");
        JMenuItem reloginJMenuItem = new JMenuItem("重新登录");
        JMenuItem closeGameJMenuItem = new JMenuItem("关闭游戏");
        // 关于我们
        JMenuItem qrcodeJMenuItem = new JMenuItem("公众号");
        
        funcJMenu.add(replayJMenuItem);
        funcJMenu.add(reloginJMenuItem);
        funcJMenu.add(closeGameJMenuItem);
        
        aboutJMenu.add(qrcodeJMenuItem);
        
        jMenuBar.add(funcJMenu);
        jMenuBar.add(aboutJMenu);
        
        this.setJMenuBar(jMenuBar);
    }
    
    public void initImage() {
        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/assets/images/animal/animal1/1.jpg")));
        
        JLabel jLabel = new JLabel(imageIcon);
        
        this.add(jLabel);
    }
}
