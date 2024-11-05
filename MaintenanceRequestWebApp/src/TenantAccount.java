/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author samanthadennison <your.name your.org>
 */

public class TenantAccount {
    private final String id;
    private final String name;
    private final String apNum;
    private final String phone;
    private final String email;
    private final String checkIn;
    private final String checkOut;
    private final String password;

    public TenantAccount(String id, String name, String apNum, String phone, String email, String checkIn, String checkOut, String password) {
        this.id = id;
        this.name = name;
        this.apNum = apNum;
        this.phone = phone;
        this.email = email;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.password = password;
    }
    
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getApNum() {
        return apNum;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }
    
    public String getPassword(){
        return password;
    }
    
    
    
}
