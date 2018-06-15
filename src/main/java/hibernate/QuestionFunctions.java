package hibernate;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class QuestionFunctions {

    private DatabaseSessionProvider databaseSessionProvider = DatabaseSessionProvider.getInstance();
    private UserInteraction userInteraction = new UserInteraction();

    public List<Question> getAllQuestions(){

        Session session = databaseSessionProvider.openSession();
        String myQuery = "FROM Question";
        Query<Question> questionQuery = session.createQuery(myQuery, Question.class);
        List<Question> result = questionQuery.list();
        session.close();

        return result;
    }
    public void printAllQuestionsWithAnswersAndLogins() {
        Session session = databaseSessionProvider.openSession();
        List<Question> questionList = getAllQuestions();

        for (Question question : questionList) {
            List<Answer> answers = question.getAnswers();
            System.out.println(question + ":");
//            question.getAnswers().forEach(p-> System.out.println(p.getUser()+": "+p));
            for (Answer answer : answers) {
                System.out.println(answer.getUser() + ": " + answer);
            }
        }
        session.close();
    }

    public void addNewQuestion(){
        Question question = new Question();
        String questionText = userInteraction.stringChoice();
        question.setText(questionText);
        Session session = databaseSessionProvider.openSession();
        session.beginTransaction();
        session.persist(question);
        session.getTransaction().commit();
        session.close();

    }

    public void deleteQuestion() {
        printAllQuestions();
        int userChoice = userInteraction.intChoice();
        Session session = databaseSessionProvider.openSession();
        session.beginTransaction();
        Question question = findQuestion(userChoice, session);
        if(question!=null) {
            session.remove(question);
            session.getTransaction().commit();
            session.close();
        }
        else {
            System.out.println("There is no question with such ID.");
        }
    }

    private Question findQuestion(int userChoice, Session session) {
        Question question;
        try {
            question = session.get(Question.class, userChoice);
        } catch (Exception e) {
            question = null;
        }
        return question;
    }

    private void printAllQuestions() {
        Session session = databaseSessionProvider.openSession();
        List<Question> allQuestions = getAllQuestions();
        System.out.println("Select question to delete. Write ID.");
        allQuestions.forEach(p-> System.out.println(p.getId()+": "+ p.getText()));
        session.close();
    }
}
