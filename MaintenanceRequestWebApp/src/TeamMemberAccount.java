/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author samanthadennison <your.name your.org>
 */
public class TeamMemberAccount {
    private final String id;
    private final String name;
    private final String phone;
    private final String email;
    private final String password;

    public TeamMemberAccount(String id, String name, String phone, String email, String password) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
    
    public String getPassword(){
        return password;
    }
    
    
}
