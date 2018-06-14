package hibernate;

import java.util.logging.Level;

public class Main {

    public static void main(String[] args) {

        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        DatabaseSessionProvider databaseSessionProvider = DatabaseSessionProvider.getInstance();

        UserFunctions userFunctions = new UserFunctions();
        userFunctions.getAnswersToQuestions();

        databaseSessionProvider.closeSessionFactory();

    }
}
