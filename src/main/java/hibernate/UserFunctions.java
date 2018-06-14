package hibernate;

import java.util.Date;
import java.util.List;

public class UserFunctions {

    private UserInteraction userInteraction = new UserInteraction();
    private AnswerFunctions answerFunctions = new AnswerFunctions();
    private QuestionFunctions questionFunctions = new QuestionFunctions();

    public void getAnswersToQuestions(){
        List<Question> questionList = questionFunctions.getAllQuestions();
            for (Question question : questionList) {
            printQuestion(question);

            String userAnswer = userInteraction.stringChoice();
            java.sql.Date sqlDate = new java.sql.Date(new Date().getTime());
            int questionId = question.getId();

            answerFunctions.saveAnswerToDatabase(userAnswer, sqlDate, questionId);
        }
    }

    public void getAnswersToQuestionsByUser(){
        List<Question> questionList = questionFunctions.getAllQuestions();
        for (Question question : questionList) {
            printQuestion(question);

            String userAnswer = userInteraction.stringChoice();
            java.sql.Date sqlDate = new java.sql.Date(new Date().getTime());
            int questionId = question.getId();

            answerFunctions.saveAnswerToDatabase(userAnswer, sqlDate, questionId);
        }
    }

    private void printQuestion(Question question1) {
        System.out.println(question1.getId()+" "+question1.getText());
    }
}
