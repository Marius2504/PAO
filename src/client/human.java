package client;

import java.sql.Date;

public abstract class human {
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String password;
    private Date birthDate;
    //private List<history> hst;
    //private settings st;
    public human()
    {
        this.name = "";
        this.surname = "";
        this.phone = "";
        this.email = "";
        this.password = "";
        this.birthDate = null;
    }

    public human(String name, String surname, String phone, String email, String password, Date birthDate) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
