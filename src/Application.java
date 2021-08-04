import java.util.ArrayList;
import java.util.List;

import Commands.CommandGeneration;
import Model.Expense;
import Model.User;

public class Application {
    public static void main(String[] args) {
        User user1 = new User("1", "rohan", "999", "r@y.c");
        User user2 = new User("2", "karan", "999", "r@y.c");
        User user3 = new User("3", "rounak", "999", "r@y.c");
        User user4 = new User("4", "chirag", "999", "r@y.c");
        List<User> listOfUsers = new ArrayList<>(){{
            add(user1);
            // add(user2);
            // add(user3);
            add(user4);
        }};
        Double totalAmount = (double) 1000;
        List<Double> amounts = new ArrayList<>(){{
            add((double)250);
            add((double)750);
        }};
        CommandGeneration commandGeneration = CommandGeneration.getInstance();
        commandGeneration.createObj(user2, totalAmount, 4, listOfUsers,"EXACT", amounts);
        commandGeneration.createObj(user2, totalAmount, 4, listOfUsers,"EXACT", amounts);
        commandGeneration.splitMoney();
        
        commandGeneration.showOwes(user4);
        
    }
}
