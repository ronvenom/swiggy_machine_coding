package Service;

import java.util.HashMap;

import Model.User;
import Storage.Wallet;

public class ShowServiceImpl implements ShowService {

    @Override
    public void showOwes(User user) {
        System.out.print(user.getUserID()+" ");
        if(!Wallet.owes.containsKey(user)) System.out.println("No Balance");
        for (User u : Wallet.owes.get(user).keySet()) {
            System.out.println(u.getUserID()+" "+Wallet.owes.get(user).get(u));
        }
    }

    @Override
    public void showOwes() {
        
        for (User u : Wallet.owes.keySet()) {
            System.out.print(u.getUserID()+" ");
            for(User otherUser : Wallet.owes.get(u).keySet()){

                System.out.print(otherUser.getUserID()+" "+Wallet.owes.get(u).get(otherUser));
            }
            System.out.println();
        }
    }
    
}
