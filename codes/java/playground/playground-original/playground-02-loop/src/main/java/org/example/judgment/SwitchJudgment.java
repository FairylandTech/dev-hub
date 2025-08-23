/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-12 19:58:23 UTC+08:00
 ****************************************************/
package org.example.judgment;

/**
 * @author Lionel Johnson
 */
public class SwitchJudgment {

    public static void main(String[] args) {

        String noodles = "兰州拉面";

        switch (noodles) {
            case "兰州拉面":
                System.out.println("吃兰州拉面");
                break;
            case "北京炸酱面":
                System.out.println("吃北京炸酱面");
                break;
            case "武汉热干面":
                System.out.println("吃武汉热干面");
                break;
            case "陕西油泼面":
                System.out.println("吃陕西油泼面");
                break;
            default:
                System.out.println("吃康师傅方便面");
                break;
        }

    }

}
