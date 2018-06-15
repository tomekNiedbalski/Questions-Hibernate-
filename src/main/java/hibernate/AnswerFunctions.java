package hibernate;

import org.hibernate.Session;

public class AnswerFunctions {

    private DatabaseSessionProvider databaseSessionProvider = DatabaseSessionProvider.getInstance();

    public void saveAnswerToDatabase(String userAnswer, java.sql.Date sqlDate, Question question, User user) {
        Answer answer = new Answer();
        Session session1 = databaseSessionProvider.openSession();
        session1.beginTransaction();
        answer.setQuestion(question);
        answer.setText(userAnswer);
        answer.setDate(sqlDate);
        answer.setUser(user);
        session1.persist(answer);
        session1.getTransaction().commit();
        session1.close();
    }
}
