package ru.geekbrains.local_meeting_web.domain.DTO;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class ClientAuthDto {

    private Long id;

    private String name;

    private String mail;

    private int login;

    private int pass;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setLogin(String login) {
        this.login = login.hashCode();
    }

    public void setPass(String pass) {
        this.pass = pass.hashCode();
    }
}
