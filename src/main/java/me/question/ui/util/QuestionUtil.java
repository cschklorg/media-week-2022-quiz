package me.question.ui.util;

public class QuestionUtil {
    public static int id;
    public static String question;
    public static String option1;
    public static String option2;
    public static String option3;
    public static String option4;
    public static String ans;

    public QuestionUtil(Integer id, String question, String option1, String option2, String option3, String option4, String ans) {
        QuestionUtil.id = id;
        QuestionUtil.question = question;
        QuestionUtil.option1 = option1;
        QuestionUtil.option2 = option2;
        QuestionUtil.option3 = option3;
        QuestionUtil.option4 = option4;
        QuestionUtil.ans = ans;
    }
}
