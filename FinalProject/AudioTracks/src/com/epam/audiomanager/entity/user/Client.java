package com.epam.audiomanager.entity.user;

import java.util.Objects;

public class Client extends User {
    private boolean bonus;

    public Client() {
        super();
    }

    public Client(int id, String login, TypeUser type, String firstName, String secondName, String email, boolean bonus)
    {
        super(id, login, type, firstName, secondName, email);
        this.bonus = bonus;
    }

    public Client(String email, String login, String firstName, String secondName, TypeUser client) {
        this.email = email;
        this.login = login;
        this.firstName = firstName;
        this.secondName = secondName;
        this.type = client;
    }

    public boolean isBonus() {
        return bonus;
    }

    public void setBonus(boolean bonus) {
        this.bonus = bonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return isBonus() == client.isBonus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isBonus());
    }

    @Override
    public String toString() {
        return "Client{" +
                "bonus=" + bonus +
                ", login='" + login + '\'' +
                ", type=" + type +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}