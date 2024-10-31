package User;
import Account.*;

import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

public class User {
    UID id;
    protected String name;
    protected String email;
    protected String password;
    protected int age;

    User(String name, String email, String password){
        id=new UID();
        this.name=name;
        this.email= email;
        this.password=password;
    }

    public String getName(){return name;}

    public UID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}
