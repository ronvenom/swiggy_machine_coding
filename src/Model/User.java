package Model;

public class User {
    String id;
    String name;
    String phone;
    String email;

    public User(String id,String name, String phone, String email){
        this.id=id;
        this.name=name;
        this.phone=phone;
        this.email=email;
    }

    public String getUserID(){
        return this.id;
    }
}
