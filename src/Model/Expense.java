package Model;

import java.util.List;

public class Expense {
    Double amount;
    Split split;
    User by;
    List<User> owes; 

    public Expense(Double amount, Split split, User by, List<User> owes){
        this.amount = amount;
        this.split = split;
        this.by = by;
        this.owes = owes;
    }
}
