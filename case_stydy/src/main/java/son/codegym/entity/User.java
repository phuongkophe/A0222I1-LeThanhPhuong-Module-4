package son.codegym.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @Column(columnDefinition = "varchar(50)", name = "username")
    private String username;
    private String passWord;

    @JsonBackReference
    @OneToMany(mappedBy = "username", cascade = CascadeType.REMOVE)
    private Set<Employee> employees;

    public User(){};

    public User(String username, String passWord) {
        this.username = username;
        this.passWord = passWord;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
