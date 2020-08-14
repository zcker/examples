package com.zcker.example.easyJDK.lang;

import java.util.*;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName Example6.java
 * @Description TODO
 * @createTime 2020年08月03日 09:10:00
 */

public class Example6 {
    public List<String> getHeadNumber() {
        List<String> list = new ArrayList<String>();
        String lotteryNumber = "";
        for (int i = 0; i < 36; i++) {
            if (i < 10) {
                list.add("0" + i + " ");
            } else {
                list.add("" + i + " ");
            }
        }

        int roundIndex = 0;

        List<String> lotteryList = new ArrayList<String>();
        for (int j = 0; j < 5; j++) {
            int amount = list.size();
            Random r = new Random();
            roundIndex = r.nextInt(amount);
            lotteryNumber = list.get(roundIndex);
            lotteryList.add((lotteryNumber));
            list.remove(roundIndex);
        }
        Collections.sort(lotteryList);
        return lotteryList;
    }

    public List<String> getRearNumber() {
        List<String> list = new ArrayList<String>();
        // 创建后半段号码集合，也就是最后两个球的数字

        String lotteryNumber = "";
        for (int i = 1; i < 13; i++) {
            // 初始化后半段号码集合

            if (i < 10) {
                list.add("0" + i + "  ");
                // 添加 0~9 的号码，原理同前半段
            } else {
                list.add("" + i + "  ");
                // 添加大于 9 的号码
            }
        }
        int roundIndex = 0;
        //创建并初始化随机数

        List<String> lotteryList = new ArrayList<String>();
        // 保存后半段号码的 List 集合

        for (int j = 0; j < 2; j++) {
            int amount = list.size(); // 获取后半段号码的个数
            Random r = new Random(); // 创建并实例化 Random 的对象
            roundIndex = r.nextInt(amount); // 获取一个 0 到 amount-1 的随机数
            lotteryNumber = list.get(roundIndex); // 摇号
            lotteryList.add(lotteryNumber); // 将彩票号码添加 lotteryList 中
            list.remove(roundIndex); // 移除刚刚产生的号码
        }

        Collections.sort(lotteryList);
        // 对后半段号码进行排序
        return lotteryList;
    }

    public void generateLottery(String groupNum) {
        int groupNumber = 0;
        groupNumber = Integer.parseInt(groupNum);
        StringBuilder sbuiler = new StringBuilder();
        for (int i = 0; i < groupNumber; i++) {
            List<String> startList = getHeadNumber();
            List<String> endList = getRearNumber();
            for (int m = 0; m < startList.size(); m++) {
                sbuiler.append(startList.get(m));
            }
            sbuiler.append("     ");
            for (int n = 0; n < endList.size(); n++) {
                sbuiler.append(endList.get(n));
            }
            sbuiler.append("\n");
        }
        System.out.println(sbuiler.toString());
    }

    public static void main(String[] args) {
        Example6 example6 = new Example6();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the number of lottery group(s) that you want to generate : ");

        String groupNum = scanner.nextLine();
        example6.generateLottery(groupNum);
    }
}
