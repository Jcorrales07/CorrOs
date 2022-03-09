package org.example;

public class Admin extends User {
    public Admin() {}

    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Admin ");
        sb.append(super.toString());
        return sb.toString();
    }
}
