package ru.geekbrains.local_meeting_web.domain;

import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Client {
    @Id
    @Generated
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String mail;
    @NotNull
    private int login;
    @NotNull
    private int pass;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login.hashCode();
    }

    public int getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass.hashCode();
    }
}
