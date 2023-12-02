package prototype;

import org.itstack.demo.design.AnswerQuestion;
import org.itstack.demo.design.ChoiceQuestion;
import prototype.util.Topic;
import prototype.util.TopicRandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 核⼼的题库类 QuestionBank
 * 题库中主要负责将各个的题⽬进⾏组装最终输出试卷
 * @author longshu
 *
 */
public class QuestionBank implements Cloneable{
    /**
     * 考生
     */
    private String candidate;

    /**
     * 考号
     */
    private String number;

    /**
     * 选择题
     */
    private ArrayList<ChoiceQuestion> choiceQuestionList = new ArrayList<>();

    /**
     * 简答题
     */
    private ArrayList<AnswerQuestion> answerQuestionList = new ArrayList<>();

    /**
     * 添加选择题
     * 对各项题⽬的添加，有点像在建造者模式中使⽤的⽅式，添加装修物料
     * @param choiceQuestion
     * @return
     */
    public QuestionBank append(ChoiceQuestion choiceQuestion){
        choiceQuestionList.add(choiceQuestion);
        return this;
    }

    /**
     * 添加简答题
     * @param answerQuestion
     * @return
     */
    public QuestionBank append(AnswerQuestion answerQuestion) {
        answerQuestionList.add(answerQuestion);
        return this;
    }

    /**
     * 重写克隆方法
     * clone() ，这⾥的核⼼操作就是对对象的复制，
     * 这⾥的复制不只是包括了本身，同时对两个集合也做了复制。只有这样的拷⻉才能确保在操作克隆对象的时候不影响原对象。
     * @see Cloneable
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 深克隆一个新的题库对象
        QuestionBank questionBank = (QuestionBank) super.clone();
        questionBank.choiceQuestionList = (ArrayList<ChoiceQuestion>) choiceQuestionList.clone();
        questionBank.answerQuestionList = (ArrayList<AnswerQuestion>) answerQuestionList.clone();

        // 题目乱序
        Collections.shuffle(questionBank.choiceQuestionList);
        Collections.shuffle(questionBank.answerQuestionList);
        // 答案乱序
        List<ChoiceQuestion> choiceQuestionList = questionBank.choiceQuestionList;
        for (ChoiceQuestion choiceQuestion : choiceQuestionList) {
            Topic randomTopic = TopicRandomUtil.ranDom(choiceQuestion.getOption(), choiceQuestion.getKey());
            choiceQuestion.setOption(randomTopic.getOption());
            choiceQuestion.setKey(randomTopic.getKey());
        }
        return questionBank;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {

        StringBuilder detail = new StringBuilder("考生：" + candidate + "\r\n" +
                "考号：" + number + "\r\n" +
                "--------------------------------------------\r\n" +
                "一、选择题" + "\r\n\n");

        for (int idx = 0; idx < choiceQuestionList.size(); idx++) {
            detail.append("第").append(idx + 1).append("题：").append(choiceQuestionList.get(idx).getName()).append("\r\n");
            Map<String, String> option = choiceQuestionList.get(idx).getOption();
            for (String key : option.keySet()) {
                detail.append(key).append("：").append(option.get(key)).append("\r\n");;
            }
            detail.append("答案：").append(choiceQuestionList.get(idx).getKey()).append("\r\n\n");
        }

        detail.append("二、问答题" + "\r\n\n");

        for (int idx = 0; idx < answerQuestionList.size(); idx++) {
            detail.append("第").append(idx + 1).append("题：").append(answerQuestionList.get(idx).getName()).append("\r\n");
            detail.append("答案：").append(answerQuestionList.get(idx).getKey()).append("\r\n\n");
        }

        return detail.toString();
    }

}
