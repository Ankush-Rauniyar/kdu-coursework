package org.example;

import java.util.Date;
import java.util.HashMap;

public class Trader {
    private String firstName;
    private String lastName;
    private String phone;
    private String WalletAdderss;

    public double status = 0;

    public HashMap<String,Long> portfolio = new HashMap<>();
    public HashMap<String, Double> boughtPrice = new HashMap<>();

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getWalletAdderss() {
        return WalletAdderss;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setWalletAdderss(String walletAdderss) {
        WalletAdderss = walletAdderss;
    }

    public synchronized void setStatus(double status) {
        this.status = status;
    }

    public synchronized double getStatus() {
        return status;
    }
}
