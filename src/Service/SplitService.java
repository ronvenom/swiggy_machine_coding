package Service;

import java.util.List;

import Model.Split;
import Model.User;

public interface SplitService {
    public String splitMoney(User by, List<User> user, double amt, Split split);
}
