package hibernate;

import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class Main {

    public static void main(String[] args) {

        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        DatabaseSessionProvider databaseSessionProvider = DatabaseSessionProvider.getInstance();

        Menu menu = new Menu();
        menu.start();
//        Session session = databaseSessionProvider.openSession();
//        session.beginTransaction();
//        User user = new User();
//        User user1 = new User();
//        Question question = new Question();
//        Question question1 = new Question();
//        user.setLogin("Mama");
//        user.setPassword("mama");
//        question.setText("kto to");
//        question1.setText("kto tam");
//        List<Question> questionList = new ArrayList<>();
//        questionList.add(question);
//        questionList.add(question1);
//        user.setQuestions(questionList);
//        session.persist(user);
//        session.persist(question);
////        session.persist(question1);
//        session.getTransaction().commit();
//        session.close();
//
//        Session session = databaseSessionProvider.openSession();
//        User user = session.get(User.class, 23);
//        System.out.println(user);
//        user.getQuestions().forEach(System.out::println);
//        session.close();
        databaseSessionProvider.closeSessionFactory();

    }
}
