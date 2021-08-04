package Service;

import java.util.HashMap;
import java.util.List;

import Model.Split;
import Model.User;
import Storage.Wallet;

public class SplitServiceImpl implements SplitService {

    @Override
    public String splitMoney(User by, List<User> user, double amt, Split split) {
        HashMap<User, Double> splits = split.getSplits();
        for (User u : splits.keySet()) {
            if (!u.getUserID().equals(by.getUserID())) {
                if (!Wallet.owes.containsKey(u))
                    Wallet.owes.put(u, new HashMap<>());
                if (!Wallet.owes.get(u).containsKey(by))
                    Wallet.owes.get(u).put(by, splits.get(u));
                else
                    Wallet.owes.get(u).put(by, Wallet.owes.get(u).get(by)+splits.get(u));

                if (!Wallet.lends.containsKey(by))
                    Wallet.lends.put(by, new HashMap<>());

                Wallet.lends.get(by).put(u, splits.get(u));
            }
        }
        return "OK";
    }

}
