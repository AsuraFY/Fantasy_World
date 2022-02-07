package com.nice.fantasy_world.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Login {
    @Basic
    @Column(name = "username_login", nullable = true, length = 255)
    private String usernameLogin;
    @Basic
    @Column(name = "pwd_login", nullable = true, length = 255)
    private String pwdLogin;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    public String getUsernameLogin() {
        return usernameLogin;
    }

    public void setUsernameLogin(String usernameLogin) {
        this.usernameLogin = usernameLogin;
    }

    public String getPwdLogin() {
        return pwdLogin;
    }

    public void setPwdLogin(String pwdLogin) {
        this.pwdLogin = pwdLogin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Login login = (Login) o;
        return id == login.id && Objects.equals(usernameLogin, login.usernameLogin) && Objects.equals(pwdLogin, login.pwdLogin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usernameLogin, pwdLogin, id);
    }
}
