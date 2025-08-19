/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-18 21:00:54 UTC+08:00
 ****************************************************/
package org.example.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

/**
 * @author Lionel Johnson
 */
public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    private static final int[][] successfulArray = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };
    private static final Logger logger = LoggerFactory.getLogger(GameJFrame.class);
    int[][] random2Array = new int[4][4];
    int xAxisPuzzle = 0;
    int yAxisPuzzle = 0;
    int stepNumber = 0;
    // 功能
    JMenuItem replayJMenuItem = new JMenuItem("重新游戏");
    JMenuItem reloginJMenuItem = new JMenuItem("重新登录");
    JMenuItem closeGameJMenuItem = new JMenuItem("关闭游戏");
    // 关于我们
    JMenuItem qrcodeJMenuItem = new JMenuItem("公众号");
    
    String imageTypeName = "girl";
    int imageTypeIndex = 1;
    
    public GameJFrame() {
        // 初始化 JFrame 控件
        logger.info("开始加载 JFrame 控件.");
        initJFrame();
        // 初始化菜单栏
        logger.info("初始化菜单栏.");
        initMenu();
        // 初始化数据
        logger.info("初始化数据(打乱数据)");
        initData();
        // 初始化图片
        logger.info("初始化图片.");
        initImage();
        
        setVisible(true);
        logger.info("加载成功.");
    }
    
    public static int[] getRandomArray(int size) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }
        
        Collections.shuffle(arrayList);
        
        int[] shuffledArray = new int[size];
        for (int i = 0; i < size; i++) {
            shuffledArray[i] = arrayList.get(i);
        }
        
        return shuffledArray;
    }
    
    public static String getImageDir(String type, int index) {
        return String.format("/assets/images/%s/%s%s", type, type, index);
    }
    
    private void initData() {
        int[] randomArray = getRandomArray(16);
        
        for (int i = 0; i < randomArray.length; i++) {
            if (randomArray[i] == 0) {
                xAxisPuzzle = i / 4;
                yAxisPuzzle = i % 4;
            }
            random2Array[i / 4][i % 4] = randomArray[i];
        }
        
        logger.info("初始化数据: {}", Arrays.deepToString(random2Array));
    }
    
    private void initJFrame() {
        // GUI 大小
        setSize(603 * 2, 680 * 2);
        // 设置标题
        setTitle("拼图小游戏-单机版 v0.1");
        // 设置图层置顶
        setAlwaysOnTop(true);
        // 程序居中
        setLocationRelativeTo(null);
        // 关闭模式: 点击x关闭
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 禁用布局管理器
        getContentPane().setLayout(null);
        // 给整个界面添加键盘监听事件
        addKeyListener(this);
    }
    
    private void initMenu() {
        int size = 24;
        
        JMenuBar jMenuBar = new JMenuBar();
        
        jMenuBar.setFont(new Font(null, Font.PLAIN, size));
        
        JMenu funcJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");
        
        funcJMenu.setFont(new Font(null, Font.PLAIN, size));
        aboutJMenu.setFont(new Font(null, Font.PLAIN, size));
        
        replayJMenuItem.setFont(new Font(null, Font.PLAIN, size));
        reloginJMenuItem.setFont(new Font(null, Font.PLAIN, size));
        closeGameJMenuItem.setFont(new Font(null, Font.PLAIN, size));
        
        qrcodeJMenuItem.setFont(new Font(null, Font.PLAIN, size));
        
        replayJMenuItem.addActionListener(this);
        reloginJMenuItem.addActionListener(this);
        closeGameJMenuItem.addActionListener(this);
        
        qrcodeJMenuItem.addActionListener(this);
        
        funcJMenu.add(replayJMenuItem);
        funcJMenu.add(reloginJMenuItem);
        funcJMenu.add(closeGameJMenuItem);
        
        aboutJMenu.add(qrcodeJMenuItem);
        
        jMenuBar.add(funcJMenu);
        jMenuBar.add(aboutJMenu);
        
        setJMenuBar(jMenuBar);
    }
    
    private void initImage() {
        getContentPane().removeAll();
        
        loadSuccessfulImage();
        loadStepNumberText();
        loadPuzzleImage();
        loadPuzzleBackgroundImage();
        
        getContentPane().repaint();
    }
    
    private void loadPuzzleImage() {
        final int PuzzleImageWidth = 105 * 2;
        final int PuzzleImageHeight = 105 * 2;
        final int puzzleImageWidthOffset = 83 * 2;
        final int puzzleImageHeightOffset = 134 * 2;
        
        final BufferedImage puzzleErrorImage = new BufferedImage(PuzzleImageWidth, PuzzleImageHeight, BufferedImage.TYPE_INT_ARGB);
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                // 获取随机二维数组中的索引
                int index = random2Array[i][j];
                logger.debug("加载图片索引: {}", index);
                
                if (index == 0) {
                    JLabel jLabel = new JLabel(new ImageIcon(puzzleErrorImage));
                    jLabel.setBounds(PuzzleImageWidth * j + puzzleImageWidthOffset, PuzzleImageHeight * i + puzzleImageHeightOffset, PuzzleImageWidth, PuzzleImageHeight);
                    jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                    getContentPane().add(jLabel);
                } else {
                    String imagePath = String.format("%s/%s.jpg", getImageDir(imageTypeName, imageTypeIndex), index);
                    JLabel jLabel = imageRooming(ImageRoomingEnumLevel.HIGH, imagePath, PuzzleImageWidth, PuzzleImageHeight, puzzleErrorImage);
                    jLabel.setBounds(PuzzleImageWidth * j + puzzleImageWidthOffset, PuzzleImageHeight * i + puzzleImageHeightOffset, PuzzleImageWidth, PuzzleImageHeight);
                    jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                    getContentPane().add(jLabel);
                }
            }
        }
    }
    
    private void loadPuzzleBackgroundImage() {
        final int backgroundImageWidth = 508 * 2;
        final int backgroundImageHeight = 560 * 2;
        final int backgroundImageWidthOffset = 80;
        final int backgroundImageHeightOffset = 80;
        
        final BufferedImage backgroundErrorImage = new BufferedImage(backgroundImageWidth, backgroundImageHeight, BufferedImage.TYPE_INT_ARGB);
        
        String backgroundImagePath = "/assets/images/background.png";
        JLabel jLabelBackground = imageRooming(ImageRoomingEnumLevel.HIGH, backgroundImagePath, backgroundImageWidth, backgroundImageHeight, backgroundErrorImage);
        jLabelBackground.setBounds(backgroundImageWidthOffset, backgroundImageHeightOffset, backgroundImageWidth, backgroundImageHeight);
        getContentPane().add(jLabelBackground);
    }
    
    private JLabel imageRooming(ImageRoomingEnumLevel level, String imagePath, int width, int height, BufferedImage errorImage) {
        try {
            URL imageUrl = getClass().getResource(imagePath);
            if (imageUrl == null) {
                throw new IOException("资源加载失败" + imagePath);
            }
            
            switch (level) {
                case LOW:
                    return imageRoomingLow(imagePath, width, height);
                case HIGH:
                    return imageRoomingHigh(imageUrl, width, height);
                default:
                    throw new IllegalArgumentException("不支持的图片缩放级别.");
            }
            
        } catch (Exception exception) {
            logger.error("图片加载失败.", exception);
            return new JLabel(new ImageIcon(errorImage));
        }
    }
    
    private JLabel imageRoomingHigh(URL imageUrl, int width, int height) throws IOException {
        BufferedImage original = ImageIO.read(imageUrl);
        BufferedImage scaled = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = scaled.createGraphics();
        // 启用透明度混合
        g2d.setComposite(AlphaComposite.SrcOver);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(original, 0, 0, width, height, null);
        g2d.dispose();
        
        return new JLabel(new ImageIcon(scaled));
    }
    
    private JLabel imageRoomingLow(String imagePath, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource(imagePath)));
        Image scaled = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
        
        return new JLabel(new ImageIcon(scaled));
    }
    
    private void keyBoardMove(int pointX, int pointY) {
        random2Array[xAxisPuzzle][yAxisPuzzle] = random2Array[pointX][pointY];
        random2Array[pointX][pointY] = 0;
        
        stepNumber++;
        
        xAxisPuzzle = pointX;
        yAxisPuzzle = pointY;
    }
    
    private void loadSourceImage() {
        final int sourceImageWidth = 420 * 2;
        final int sourceImageHeight = 420 * 2;
        final int sourceImageWidthOffset = 83 * 2;
        final int sourceImageHeightOffset = 134 * 2;
        
        BufferedImage sourceErrorImage = new BufferedImage(sourceImageWidth, sourceImageHeight, BufferedImage.TYPE_INT_ARGB);
        
        getContentPane().removeAll();
        
        String imagePath = String.format("%s/all.jpg", getImageDir(imageTypeName, imageTypeIndex));
        JLabel jLabel = imageRooming(ImageRoomingEnumLevel.HIGH, imagePath, sourceImageWidth, sourceImageHeight, sourceErrorImage);
        jLabel.setBounds(sourceImageWidthOffset, sourceImageHeightOffset, sourceImageWidth, sourceImageHeight);
        getContentPane().add(jLabel);
        
        loadPuzzleBackgroundImage();
        
        getContentPane().repaint();
    }
    
    private boolean victory() {
        for (int i = 0; i < random2Array.length; i++) {
            for (int j = 0; j < random2Array[i].length; j++) {
                if (random2Array[i][j] != successfulArray[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private void loadSuccessfulImage() {
        if (victory()) {
            final int SuccessfulImageWidth = 197 * 2;
            final int SuccessfulImageHeight = 73 * 2;
            final int SuccessfulImageWidthOffset = 203 * 2;
            final int SuccessfulImageHeightOffset = 283 * 2;
            
            BufferedImage SuccessfulErrorImage = new BufferedImage(SuccessfulImageWidth, SuccessfulImageHeight, BufferedImage.TYPE_INT_ARGB);
            String winImagePath = "/assets/images/win.png";
            JLabel jLabel = imageRooming(ImageRoomingEnumLevel.HIGH, winImagePath, SuccessfulImageWidth, SuccessfulImageHeight, SuccessfulErrorImage);
            jLabel.setBounds(SuccessfulImageWidthOffset, SuccessfulImageHeightOffset, SuccessfulImageWidth, SuccessfulImageHeight);
            getContentPane().add(jLabel);
        }
    }
    
    private void loadStepNumberText() {
        JLabel stepJLabel = new JLabel("步数: " + stepNumber);
        stepJLabel.setBounds(100, 60, 200, 40);
        stepJLabel.setFont(new Font(null, Font.BOLD, 30));
        getContentPane().add(stepJLabel);
    }
    
    private void loadImageModule() {
        initImage();
    }
    
    private void loadAboutImage() {
        final int aboutImageWidth = 1074;
        final int aboutImageHeight = 1452;
        
        JDialog jDialog = new JDialog();
        
        BufferedImage aboutErrorImage = new BufferedImage(aboutImageWidth, aboutImageHeight, BufferedImage.TYPE_INT_ARGB);
        
        String aboutImagePath = "/assets/images/WeChatQRCode.jpg";
        JLabel jLabel = imageRooming(ImageRoomingEnumLevel.HIGH, aboutImagePath, aboutImageWidth, aboutImageHeight, aboutErrorImage);
        jLabel.setBounds(0, 0, aboutImageWidth, aboutImageHeight);
        
        jDialog.getContentPane().add(jLabel);
        jDialog.setSize(aboutImageWidth + 86, aboutImageHeight + 86);
        jDialog.setAlwaysOnTop(true);  // 置顶
        jDialog.setLocationRelativeTo(null);  // 居中
        jDialog.setModal(true);  // 弹框不关闭, 无法操作其他的
        jDialog.setVisible(true);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (victory()) {
            return;
        }
        
        int keyCode = e.getKeyCode();
        
        if (keyCode == 65) {
            loadSourceImage();
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        if (victory()) {
            return;
        }
        
        int keyCode = e.getKeyCode();
        
        switch (keyCode) {
            case 37:  // ←
                if (yAxisPuzzle == 0) {
                    logger.warn("不能超越左边界.");
                    break;
                }
                logger.debug("向左移动");
                keyBoardMove(xAxisPuzzle, yAxisPuzzle - 1);
                loadImageModule();
                break;
            case 38:  // ↑
                if (xAxisPuzzle == 0) {
                    logger.warn("不能超越上边界.");
                    break;
                }
                logger.debug("向上移动");
                keyBoardMove(xAxisPuzzle - 1, yAxisPuzzle);
                loadImageModule();
                break;
            case 39:  // →
                if (yAxisPuzzle == 3) {
                    logger.warn("不能超越右边界.");
                    break;
                }
                logger.debug("向右移动");
                keyBoardMove(xAxisPuzzle, yAxisPuzzle + 1);
                loadImageModule();
                break;
            case 40:  // ↓
                if (xAxisPuzzle == 3) {
                    logger.warn("不能超越下边界.");
                    break;
                }
                logger.debug("向下移动");
                keyBoardMove(xAxisPuzzle + 1, yAxisPuzzle);
                loadImageModule();
                break;
            case 65:  // a
                loadImageModule();
                break;
            case 87:  // w
                random2Array = successfulArray;
                loadImageModule();
            default:
                logger.debug("按键不是上下左右.");
                break;
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source == replayJMenuItem) {
            logger.info("重新游戏");
            stepNumber = 0;
            initData();
            initImage();
        } else if (source == reloginJMenuItem) {
            logger.info("重新登录");
            setVisible(false);
            new LoginJFrame();
        } else if (source == closeGameJMenuItem) {
            logger.info("关闭游戏");
            System.exit(0);
        } else if (source == qrcodeJMenuItem) {
            logger.info("微信二维码");
            loadAboutImage();
        }
    }
    
    private enum ImageRoomingEnumLevel {HIGH, LOW}
}
