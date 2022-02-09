package com.nice.fantasy_world.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "iduser", nullable = false)
    private int iduser;
    @Basic
    @Column(name = "username", nullable = false, length = 255)
    private String username;
    @Basic
    @Column(name = "email", nullable = false, length = 255)
    private String email;
    @Basic
    @Column(name = "pwd", nullable = false, length = 11)
    private String pwd;
    @Basic
    @Column(name = "age", nullable = true)
    private Integer age;
//    @OneToMany(mappedBy = "userByIduser")
//    private Collection<Novelnote> novelnotesByIduser;
//    @OneToMany(mappedBy = "userByIduser")
//    private Collection<Webtoonnote> webtoonnotesByIduser;

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return iduser == user.iduser && Objects.equals(username, user.username) && Objects.equals(email, user.email) && Objects.equals(pwd, user.pwd) && Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iduser, username, email, pwd, age);
    }

//    public Collection<Novelnote> getNovelnotesByIduser() {
//        return novelnotesByIduser;
//    }
//
//    public void setNovelnotesByIduser(Collection<Novelnote> novelnotesByIduser) {
//        this.novelnotesByIduser = novelnotesByIduser;
//    }
//
//    public Collection<Webtoonnote> getWebtoonnotesByIduser() {
//        return webtoonnotesByIduser;
//    }
//
//    public void setWebtoonnotesByIduser(Collection<Webtoonnote> webtoonnotesByIduser) {
//        this.webtoonnotesByIduser = webtoonnotesByIduser;
//    }
}
