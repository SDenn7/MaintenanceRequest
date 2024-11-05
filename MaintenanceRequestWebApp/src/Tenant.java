/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author samanthadennison <your.name your.org>
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Tenant {
    private static Connection connection;
    private static PreparedStatement addTenant;
    private static PreparedStatement allTenants;
    private static PreparedStatement updateTenant;
    private static PreparedStatement deleteTenant; 
    private static ResultSet resultSet;
    
    public static void addTenant(TenantAccount ten){
        connection = ConnectDB.getConnection();
        
        String id = ten.getId();
        String name = ten.getName();
        String apNum = ten.getApNum();
        String phone = ten.getPhone();
        String email = ten.getEmail();
        String checkIn = ten.getCheckIn();
        String checkOut = ten.getCheckOut();
        String password = ten.getPassword();
        
        try{
            addTenant = connection.prepareStatement("insert into app.TENANTACCOUNT (tenantID, name, apartment, phone, email, checkIn, checkOut, password) values (?,?,?,?,?,?,?,?)");
            addTenant.setString(1, id);
            addTenant.setString(2, name);
            addTenant.setString(3, apNum);
            addTenant.setString(4, phone);
            addTenant.setString(5, email);
            addTenant.setString(6, checkIn);
            addTenant.setString(7, checkOut);
            addTenant.setString(8, password);
            addTenant.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
    
    public static ArrayList<TenantAccount> allTenants(){
        connection = ConnectDB.getConnection();
        ArrayList<TenantAccount> tenants = new ArrayList<TenantAccount>();
        
        try{
            allTenants = connection.prepareStatement("select * from app.tenantAccount order by tenantID");
            resultSet = allTenants.executeQuery();
            
            while(resultSet.next()){
                tenants.add(new TenantAccount(
                    resultSet.getString("tenantID"),
                    resultSet.getString("name"),
                    resultSet.getString("apartment"),
                    resultSet.getString("phone"),
                    resultSet.getString("email"),
                    resultSet.getString("checkIn"),
                    resultSet.getString("checkOut"),
                    resultSet.getString("password")));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }

        return tenants;
    }
    
    public static void updateTenant(TenantAccount ten, String newApartment){
        connection = ConnectDB.getConnection();
        
        String tenantId = ten.getId();
        String name = ten.getName();
        String apartment = ten.getApNum();
        String phone = ten.getPhone();
        String email = ten.getEmail();
        String checkIn = ten.getCheckIn();
        String checkOut = ten.getCheckOut();
        String password = ten.getPassword();
        
        try{
            updateTenant = connection.prepareStatement("update app.tenantAccount set apartment = ? where tenantID = ? and name = ? and apartment = ? and phone = ? and email = ? and checkIn = ? and checkOut = ? and password = ?");
            updateTenant.setString(1, newApartment);
            updateTenant.setString(2, tenantId);
            updateTenant.setString(3, name);
            updateTenant.setString(4, apartment);
            updateTenant.setString(5, phone);
            updateTenant.setString(6, email);
            updateTenant.setString(7, checkIn);
            updateTenant.setString(8, checkOut);
            updateTenant.setString(9, password);
            updateTenant.executeUpdate();
        }
        
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        } 
    }
    
    public static void deleteTenant(TenantAccount ten){
        connection = ConnectDB.getConnection();
        
        String id = ten.getId();
        String name = ten.getName();
        String apNum = ten.getApNum();
        String phone = ten.getPhone();
        String email = ten.getEmail();
        String checkIn = ten.getCheckIn();
        String checkOut = ten.getCheckOut();
        String password = ten.getPassword();
        
        try{
            deleteTenant = connection.prepareStatement("delete from app.tenantAccount where tenantID = ? and name = ? and apartment = ? and phone = ? and email = ? and checkIn = ? and checkOut = ? and password = ?");
            // Deletes the entry matching the timestamp
            deleteTenant.setString(1, id);
            deleteTenant.setString(2, name);
            deleteTenant.setString(3, apNum);
            deleteTenant.setString(4, phone);
            deleteTenant.setString(5, email);
            deleteTenant.setString(6, checkIn);
            deleteTenant.setString(7, checkOut);
            deleteTenant.setString(8, password);
            deleteTenant.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
}
