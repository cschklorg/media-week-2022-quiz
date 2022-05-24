package me.question.ui.runnable;

import java.util.concurrent.ConcurrentHashMap;

public class QuestionUI {
    public ConcurrentHashMap<Integer, Long> questionMap = new ConcurrentHashMap<>();
    public int currentQuestion = 0;
    public int questionCount = 1;
    public int stage = 1;
    public String question;
    public String answer1;
    public String answer2;
    public String answer3;
    public String answer4;

    public void onAction() {
        switch (stage) {
            case 1 -> {
                question = (questionCount + ": 1972年以后的计算机习惯上被称为第几代计算机");
                answer1 = ("第三代计算机");
                answer2 = ("第四代计算机");
                answer3 = ("第五代计算机");
                answer4 = ("新时代计算机");
                currentQuestion = stage;
            }
            case 2 -> {
                question = (questionCount + ": 3G是在哪一年开始普遍使用的？");
                answer1 = ("2002年");
                answer2 = ("2003年");
                answer3 = ("2004年");
                answer4 = ("2005年");
                currentQuestion = stage;
            }
            case 3 -> {
                question = (questionCount + ": 显卡的英文缩写是下列哪项？");
                answer1 = ("GPU");
                answer2 = ("CPU");
                answer3 = ("APU");
                answer4 = ("RAM");
                currentQuestion = stage;
            }
            case 4 -> {
                question = (questionCount + ": 电脑没有RAM会对电脑造成什么影响？");
                answer1 = ("没有影响");
                answer2 = ("电脑无法运行");
                answer3 = ("电脑无法储存资料");
                answer4 = ("电脑会容易感染病毒");
                currentQuestion = stage;
            }
            case 5 -> {
                question = (questionCount + ": 第一个微处理器是由什么公司是生产？");
                answer1 = ("Apple");
                answer2 = ("AMD");
                answer3 = ("Intel");
                answer4 = ("Nvidia");
                currentQuestion = stage;
            }
            case 6 -> {
                question = (questionCount + ": 以下哪项是线上广告和线下广告的共同点？");
                answer1 = ("传播范围广");
                answer2 = ("吸引用户");
                answer3 = ("互动性强");
                answer4 = ("制作周期短");
                currentQuestion = stage;
            }
            case 7 -> {
                question = (questionCount + ": 以下哪项不是假新闻的类型？");
                answer1 = ("误导性内容");
                answer2 = ("题文不符");
                answer3 = ("知识性内容");
                answer4 = ("操作性内容");
            }
            case 8 -> {
                question = (questionCount + ": 以下哪项不是照片编辑软件？");
                answer1 = ("GIMP");
                answer2 = ("Adobe Photoshop");
                answer3 = ("Adobe Lightroom");
                answer4 = ("Adobe Illustrator");
            }
            case 9 -> {
                question = (questionCount + ": 以下哪个是只能在手机正式使用的影片剪辑软件？");
                answer1 = ("Kinemaster");
                answer2 = ("剪映");
                answer3 = ("Premiere Pro");
                answer4 = ("Filmora");
            }
            case 10 -> {
                question = (questionCount + ": 以下哪个不是社交媒体所利用的技术以便有效地发布广告及精准地推广用户热爱的资讯？");
                answer1 = ("大数据");
                answer2 = ("演算法");
                answer3 = ("定位技术");
                answer4 = ("询问家人朋友");
            }
            case 11 -> {
                question = (questionCount + ": 以下哪项不是艾伦·图灵的誉称？");
                answer1 = ("计算机科学之父");
                answer2 = ("人工智能之父");
                answer3 = ("电脑之父");
                answer4 = ("编程之父");
            }
            case 12 -> {
                question = (questionCount + ": PCIe和SATA哪个的带宽速度比较快?");
                answer1 = ("PCIe");
                answer2 = ("SATA");
                answer3 = ("都一样快");
                answer4 = ("-");
            }
            case 13 -> {
                question = (questionCount + ": 以下哪项不是电子产品的品牌？");
                answer1 = ("Apple");
                answer2 = ("AMD");
                answer3 = ("Nvidia");
                answer4 = ("ClaryTech");
            }
            case 14 -> {
                question = (questionCount + ": Windows XP的发行日是几时？");
                answer1 = ("2001/10/25");
                answer2 = ("2002/10/25");
                answer3 = ("2001/11/25");
                answer4 = ("2002/11/25");
            }
            case 15 -> {
                question = (questionCount + ": 第一台现代意义上的可以商用的移动电话在哪一年诞生？");
                answer1 = ("1998");
                answer2 = ("1987");
                answer3 = ("1985");
                answer4 = ("1983");
            }
        }
    }

}
