package Model;

import java.util.HashMap;
import java.util.List;

public abstract class Split {
    List<User> user;
    List<Double> amt;
    Double totalAmount;


    public Split(Double totalAmount,List<User> user){
        this.user = user;
        this.totalAmount = totalAmount;
    }

    public Split(List<Double> amt, List<User> user, Double totalAmount){
        this.amt = amt;
        this.user = user;
        this.totalAmount = totalAmount;
    }

    // At the end we will change this to add this feature in particular sections (runtime polymorphism)
    public HashMap<User, Double> getSplits(){
        HashMap<User,Double> splits = new HashMap<>();
        double eachShare = totalAmount / user.size();
        double tempAmount = 0;
        for (int i = 0; i < this.user.size(); i++) {
            if(amt.size()==0){
                splits.put(user.get(i),eachShare);
            }else{
                splits.put(user.get(i),amt.get(i));
                tempAmount+=amt.get(i);
            }
        }
        if(amt.size()==0){
            return splits;
        }else{
            if(tempAmount!=totalAmount){
                try {
                    throw new Exception("Share is not equal");
                } catch (Exception e) {
                    e.printStackTrace();
                    
                }
            }
            return splits;
        }
    }
}
