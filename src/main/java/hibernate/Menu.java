package hibernate;

public class Menu {

    private UserInteraction userInteraction = new UserInteraction();
    private UserFunctions userFunctions = new UserFunctions();
    private AnswerFunctions answerFunctions = new AnswerFunctions();
    private QuestionFunctions questionFunctions = new QuestionFunctions();

    public void start(){
        while(true){
            printMenu();
            int userChoice = userInteraction.intChoice();
            switch (userChoice){
                case 0:
                    return;
                case 1:
                    userFunctions.addNewUser();
                    break;
                case 2:
                    questionFunctions.printAllQuestionsWithAnswersAndLogins();
                    break;
                case 3:
                    questionFunctions.addNewQuestion();
                    break;
                case 4:
                    questionFunctions.deleteQuestion();
                    break;
                case 5:
                    userFunctions.getAnswersToQuestionsByUser();
            }
        }
    }

    private void printMenu(){
        System.out.println("Main menu:");
        System.out.println("0. Exit");
        System.out.println("1. Register");
        System.out.println("2. Print all questions with answers");
        System.out.println("3. Add new question");
        System.out.println("4. Delete question");
        System.out.println("5. Answer questions");
    }

}
