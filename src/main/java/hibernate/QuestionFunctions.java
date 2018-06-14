package hibernate;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class QuestionFunctions {

    DatabaseSessionProvider databaseSessionProvider = DatabaseSessionProvider.getInstance();

    public List<Question> getAllQuestions(){

        Session session = databaseSessionProvider.openSession();
        String myQuery = "FROM Question";
        Query<Question> questionQuery = session.createQuery(myQuery, Question.class);
        List<Question> result = questionQuery.list();
        session.close();

        return result;
    }
}
