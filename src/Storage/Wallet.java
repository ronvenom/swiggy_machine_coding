package Storage;

import java.util.HashMap;

import Model.User;

public class Wallet {
    public static HashMap<User,HashMap<User, Double>> owes = new HashMap<>();
    public static HashMap<User,HashMap<User,Double>> lends = new HashMap<>();

    // We can also create getter for these objects

}
