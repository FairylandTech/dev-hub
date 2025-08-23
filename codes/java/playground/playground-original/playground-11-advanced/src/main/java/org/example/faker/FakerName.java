/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-23 13:12:03 UTC+08:00
 ****************************************************/
package org.example.faker;

import cn.hutool.core.io.FileUtil;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Lionel Johnson
 */
public class FakerName {
    private static final String lastNameUrl = "https://baike.baidu.com/item/%E7%99%BE%E5%AE%B6%E5%A7%93/194637";
    private static final String boyFirstNameUrl = "https://qiming.hao86.com/view/187142/";
    private static final String girlFirstNameUrl = "https://qiming.hao86.com/view/187155/";
    private static final String LocalFolderPath = "E:\\DevData";
    private static final String lastNameHtmlPath = LocalFolderPath + "\\last-name.html";
    private static final String boyFirstNameHtmlPath = LocalFolderPath + "\\boy-first-name.html";
    private static final String girlFirstNameHtmlPath = LocalFolderPath + "\\girl-first-name.html";
    private static final String lastNameDataPath = LocalFolderPath + "\\last-name.txt";
    private static final String boyFirstNameDataPath = LocalFolderPath + "\\boy-first-name.txt";
    private static final String girlFirstNameDataPath = LocalFolderPath + "\\girl-first-name.txt";
    private static final String fakeNameDataPath = LocalFolderPath + "\\fake-name-info.txt";
    
    public static void main(String[] args) throws IOException {
        ArrayList<String> lastNameList = readFile(lastNameDataPath);
        ArrayList<String> boyFirstNameList = readFile(boyFirstNameDataPath);
        ArrayList<String> girlFirstNameList = readFile(girlFirstNameDataPath);
        
        System.out.println("lastNameList = " + lastNameList);
        System.out.println("boyFirstNameList = " + boyFirstNameList);
        System.out.println("girlFirstNameList = " + girlFirstNameList);
        
        HashSet<String> stringHashSet = randomName(100, 100, lastNameList, boyFirstNameList, girlFirstNameList);
        
        System.out.println("stringHashSet = " + stringHashSet);
        
        FileUtil.writeLines(stringHashSet, fakeNameDataPath, StandardCharsets.UTF_8, true);
    }
    
    private static HashSet<String> randomName(int boy, int girl, ArrayList<String> lastName, ArrayList<String> boyFirstName, ArrayList<String> girlFirstName) {
        Random random = new Random();
        HashSet<String> result = new HashSet<>();
        
        for (int i = 0; i < boy; i++) {
            int lastNameRandomIndex = random.nextInt(lastName.size());
            int boyFirstNameRandomIndex = random.nextInt(boyFirstName.size());
            Collections.shuffle(lastName);
            Collections.shuffle(boyFirstName);
            String name = lastName.get(lastNameRandomIndex) + boyFirstName.get(boyFirstNameRandomIndex);
            result.add(new StringJoiner("-").add(name).add("男").add(String.valueOf(random.nextInt(6) + 18)).toString());
        }
        
        for (int i = 0; i < girl; i++) {
            int lastNameRandomIndex = random.nextInt(lastName.size());
            int girlFirstNameRandomIndex = random.nextInt(girlFirstName.size());
            Collections.shuffle(lastName);
            Collections.shuffle(girlFirstName);
            String name = lastName.get(lastNameRandomIndex) + girlFirstName.get(girlFirstNameRandomIndex);
            result.add(new StringJoiner("-").add(name).add("女").add(String.valueOf(random.nextInt(6) + 18)).toString());
        }
        
        return result;
    }
    
    private static ArrayList<String> webCrawle(String url) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> result = new ArrayList<>();
        
        URLConnection urlConnection = new URL(url).openConnection();
        InputStreamReader inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
        int point;
        while ((point = inputStreamReader.read()) != -1) {
            stringBuilder.append((char) point);
        }
        inputStreamReader.close();
        result.add(stringBuilder.toString());
        
        return result;
    }
    
    private static void runWebCrawle() throws IOException {
        ArrayList<String> lastNameUrlData = webCrawle(lastNameUrl);
        ArrayList<String> boyFirstNameUrlData = webCrawle(boyFirstNameUrl);
        ArrayList<String> girlFirstNameUrlData = webCrawle(girlFirstNameUrl);
        
        FileUtil.writeLines(lastNameUrlData, lastNameHtmlPath, StandardCharsets.UTF_8);
        FileUtil.writeLines(boyFirstNameUrlData, boyFirstNameHtmlPath, StandardCharsets.UTF_8);
        FileUtil.writeLines(girlFirstNameUrlData, girlFirstNameHtmlPath, StandardCharsets.UTF_8);
    }
    
    private static ArrayList<String> handlerLastName() {
        ArrayList<String> result = new ArrayList<>();
        System.out.println("正在处理 -- 姓氏: " + lastNameHtmlPath);
        
        List<String> lastNameDataList = FileUtil.readLines(lastNameHtmlPath, StandardCharsets.UTF_8);
        String content = lastNameDataList.get(0);
        
        Matcher matcher = Pattern.compile("<a class=\"innerLink_yhSWL\\b[^>]*>[\\u4e00-\\u9fa5]</a>").matcher(content);
        while (matcher.find()) {
            Matcher matcher1 = Pattern.compile("[\\u4e00-\\u9fa5]").matcher(matcher.group());
            if (matcher1.find()) {
                result.add(matcher1.group());
            }
        }
        
        FileUtil.writeLines(result, lastNameDataPath, StandardCharsets.UTF_8);
        
        return result;
    }
    
    private static ArrayList<String> handlerBoyFirstName() {
        ArrayList<String> result = new ArrayList<>();
        System.out.println("正在处理 -- 男孩名字: " + boyFirstNameHtmlPath);
        
        StringBuilder stringBuilder = new StringBuilder();
        List<String> boyFirstNameDataList = FileUtil.readLines(boyFirstNameHtmlPath, StandardCharsets.UTF_8);
        boyFirstNameDataList.forEach(stringBuilder::append);
        
        Matcher matcher = Pattern.compile("<p>\\([0-9]{0,3}\\)[\\u4e00-\\u9fa5].*?</p>").matcher(stringBuilder.toString());
        while (matcher.find()) {
            Matcher matcher1 = Pattern.compile("[\\u4e00-\\u9fa5].").matcher(matcher.group());
            while (matcher1.find()) {
                result.add(matcher1.group());
            }
        }
        
        FileUtil.writeLines(result, boyFirstNameDataPath, StandardCharsets.UTF_8);
        
        return result;
    }
    
    private static ArrayList<String> handlerGirlFirstName() {
        ArrayList<String> result = new ArrayList<>();
        System.out.println("正在处理 -- 女孩名字: " + girlFirstNameHtmlPath);
        
        StringBuilder stringBuilder = new StringBuilder();
        List<String> boyFirstNameDataList = FileUtil.readLines(girlFirstNameHtmlPath, StandardCharsets.UTF_8);
        boyFirstNameDataList.forEach(stringBuilder::append);
        
        Matcher matcher = Pattern.compile("<p\\s+class\\s*=\\s*\"name_list\"\\s*>([\\s\\u4e00-\\u9fa5、]+?)\\s*</p>").matcher(stringBuilder.toString());
        while (matcher.find()) {
            Matcher matcher1 = Pattern.compile("[\\u4e00-\\u9fa5]{2}").matcher(matcher.group());
            while (matcher1.find()) {
                result.add(matcher1.group());
            }
        }
        
        FileUtil.writeLines(result, girlFirstNameDataPath, StandardCharsets.UTF_8);
        
        return result;
    }
    
    private static ArrayList<String> readFile(String fileName) {
        List<String> strings = FileUtil.readLines(fileName, StandardCharsets.UTF_8);
        
        return new ArrayList<>(strings);
    }
}
