/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author samanthadennison <your.name your.org>
 */
public class TeamMember {
     private static Connection connection;
    private static PreparedStatement addTeamMember;
    private static PreparedStatement allTeamMembers;
    private static PreparedStatement deleteTeamMember; 
    private static ResultSet resultSet;
    
    public static void addTeamMember(TeamMemberAccount team){
        connection = ConnectDB.getConnection();
        
        String id = team.getId();
        String name = team.getName();
        String phone = team.getPhone();
        String email = team.getEmail();
        String password = team.getPassword();
        
        try{
            addTeamMember = connection.prepareStatement("insert into app.maintenanceAccount (maintenanceID, maintenanceName, phone, email, password) values (?,?,?,?,?)");
            addTeamMember.setString(1, id);
            addTeamMember.setString(2, name);
            addTeamMember.setString(3, phone);
            addTeamMember.setString(4, email);
            addTeamMember.setString(5, password);
            addTeamMember.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }
    
    public static ArrayList<TeamMemberAccount> allTeamMembers(){
        connection = ConnectDB.getConnection();
        ArrayList<TeamMemberAccount> team = new ArrayList<TeamMemberAccount>();
        
        try{
            allTeamMembers = connection.prepareStatement("select * from app.maintenanceAccount order by maintenanceID");
            resultSet = allTeamMembers.executeQuery();
            
            while(resultSet.next()){
                team.add(new TeamMemberAccount(
                    resultSet.getString("maintenanceID"),
                    resultSet.getString("maintenanceName"),
                    resultSet.getString("phone"),
                    resultSet.getString("email"),
                    resultSet.getString("password")));
            }
        }catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return team;
    }
    
    public static void deleteTeamMember(TeamMemberAccount mtm){
        connection = ConnectDB.getConnection();
        
        String id = mtm.getId();
        String name = mtm.getName();
        String phone = mtm.getPhone();
        String email = mtm.getEmail();
        String password = mtm.getPassword();
        
        try{
            deleteTeamMember = connection.prepareStatement("delete from app.maintenanceAccount where maintenanceID = ? and maintenanceName = ? and phone = ? and email = ? and password = ?");
            // Deletes the entry matching the timestamp
            deleteTeamMember.setString(1, id);
            deleteTeamMember.setString(2, name);
            deleteTeamMember.setString(3, phone);
            deleteTeamMember.setString(4, email);
            deleteTeamMember.setString(5, password);
            deleteTeamMember.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }

    }
    
    
}
