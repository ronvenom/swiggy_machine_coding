package Commands;

import java.util.List;

import Model.EqualSplit;
import Model.ExactSplit;
import Model.Expense;
import Model.Split;
import Model.User;
import Service.ShowService;
import Service.ShowServiceImpl;
import Service.SplitService;
import Service.SplitServiceImpl;

public class CommandGeneration {
    Expense expense;
    User by;
    Double amt;
    int totalUsers;
    List<User> allUsers;
    String split;
    Split splitObj;
    List<Double> amounts;

    SplitService splitService = new SplitServiceImpl();
    ShowService showService = new ShowServiceImpl();
    private static CommandGeneration commandGeneration=null;

    private CommandGeneration() {

        // createObj();
    }

    public static CommandGeneration getInstance(){
        if(commandGeneration==null){
            commandGeneration = new CommandGeneration();
        }
        return commandGeneration;
    }



    public void createObj(User by, Double amt, int totalUsers, List<User> allUsers, String split,
            List<Double> amounts) {
        
        switch (this.split) {
            case "EQUAL": {
                this.splitObj = new EqualSplit(amt, allUsers);
            }
            case "EXACT": {
                this.splitObj = new ExactSplit(amounts, allUsers, amt);
            }
            default:
                break;
        }
        expense = new Expense(amt, splitObj, by, allUsers);
    }

    public String splitMoney() {
        return splitService.splitMoney(by, allUsers, amt, splitObj);
    }

    public void showOwes() {
        showService.showOwes();
    }

    public void showOwes(User user) {
        showService.showOwes(user);
    }

}
