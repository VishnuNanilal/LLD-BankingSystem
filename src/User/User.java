package User;

import java.util.UUID;

public class User {
    UUID id;
    protected String name;
    protected String email;
    protected String password;
    protected int age;

    User(String name, String email, String password, int age){
        id= UUID.randomUUID();
        this.name=name;
        this.email= email;
        this.password=password;
        this.age=age;
    }

    public String getName(){return name;}

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}
