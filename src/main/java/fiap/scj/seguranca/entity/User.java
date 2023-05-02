package fiap.scj.seguranca.entity;

import java.util.Objects;

public class User {

    private String login;
    private String passw;

    public User(String login, String passw) {
        this.login = login;
        this.passw = passw;
    }

    public String getLogin() {
        return login;
    }

    public String getPassw() {
        return passw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) && Objects.equals(passw, user.passw);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, passw);
    }
}