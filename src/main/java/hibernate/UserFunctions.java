package hibernate;

import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserFunctions {

    private DatabaseSessionProvider databaseSessionProvider = DatabaseSessionProvider.getInstance();
    private UserInteraction userInteraction = new UserInteraction();
    private AnswerFunctions answerFunctions = new AnswerFunctions();
    private QuestionFunctions questionFunctions = new QuestionFunctions();


    public void addNewUser() {
        User user = new User();
        System.out.println("Write your login:");
        String newName = userInteraction.stringChoice();
        System.out.println("Write your password:");
        String password = userInteraction.stringChoice();
        Session session = databaseSessionProvider.openSession();
        session.beginTransaction();
        user.setLogin(newName);
        user.setPassword(password);
        session.persist(user);
        session.getTransaction().commit();
        session.close();
    }

    public void getAnswersToQuestionsByUser() {
        User user = login();
        if (user != null) {
            List<Question> answeredQuestions = new ArrayList<>();
            List<Question> questionList = questionFunctions.getAllQuestions();
            List<Question> questionsWithNoAnswer = prepareQuestionithNoAnswer(user, questionList);
            for (Question question : questionsWithNoAnswer) {
                printQuestion(question);

                String userAnswer = userInteraction.stringChoice();
                java.sql.Date sqlDate = new java.sql.Date(new Date().getTime());

                answerFunctions.saveAnswerToDatabase(userAnswer, sqlDate, question, user);
                answeredQuestions.add(question);
            }
            updateUserByAnsweredQuestions(user, answeredQuestions);
        }
    }

    private List<Question> prepareQuestionithNoAnswer(User user, List<Question> questionList) {
        List<Question> questionsWithNoAnswer = new ArrayList<>();
        for (Question question : questionList) {
            if (user.getQuestions().stream().noneMatch(question1 -> question1.getId()==question.getId())){
                questionsWithNoAnswer.add(question);
            }
        }
        return questionsWithNoAnswer;
    }

    private void updateUserByAnsweredQuestions(User user, List<Question> questionsForUser) {
        Session session = databaseSessionProvider.openSession();
        session.beginTransaction();
        user.setQuestions(questionsForUser);
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

    private User login() {
        System.out.println("Write your login:");
        String login = userInteraction.stringChoice();
        System.out.println("Write your password:");
        String password = userInteraction.stringChoice();
        return checkLoginAndPassword(login, password);
    }

    private User checkLoginAndPassword(String login, String password) {
        User user = null;
        try (Session session = databaseSessionProvider.openSession()) {
            Query<User> query = session.createQuery("from User where login = :login and password = :password", User.class);
            query.setParameter("login", login);
            query.setParameter("password", password);
            user = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Wrong login/password");
        }
        return user;
    }

    private void printQuestion(Question question1) {
        System.out.println(question1.getId() + " " + question1.getText());
    }
}
