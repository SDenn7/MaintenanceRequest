

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.Icon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author samanthadennison <your.name your.org>
 */
public class RequestData {
    private static Connection connection;
    private static PreparedStatement addRequest;
    private static PreparedStatement allRequests;
    private static PreparedStatement updateStatus;
    private static PreparedStatement filterChoices;
    private static PreparedStatement filterRequests;
    private static PreparedStatement dateRangeRequests;
    private static ResultSet resultSet;
    
    public static void addRequest(Requests req){
        connection = ConnectDB.getConnection();
        
        String id = req.getId();
        String apNum = req.getApNum();
        String area = req.getArea();
        String descrip = req.getDescrip();
        java.sql.Timestamp timestamp = req.getCurrentTime();
        String status = req.getStatus();
        String imageFile = req.getImageFile();
        String tenantID = req.getTenantID();
        
        try{
            addRequest = connection.prepareStatement("insert into app.Request (requestID, apartment, area, timestamp, status, description, imageFile, tenantID) values (?,?,?,?,?,?,?,?)");
            addRequest.setString(1, id);
            addRequest.setString(2, apNum);
            addRequest.setString(3, area);
            addRequest.setTimestamp(4, timestamp);
            addRequest.setString(5, status);
            addRequest.setString(6, descrip);
            addRequest.setString(7, imageFile);
            addRequest.setString(8, tenantID);
            addRequest.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
    
    public static ArrayList<Requests> allRequests(){
        connection = ConnectDB.getConnection();
        ArrayList<Requests> requestList = new ArrayList<Requests>();
        
        try{
            allRequests = connection.prepareStatement("select * from app.request order by requestID");
            resultSet = allRequests.executeQuery();
            
            while(resultSet.next()){
                requestList.add(new Requests(
                    resultSet.getString("requestID"),
                    resultSet.getString("apartment"),
                    resultSet.getString("area"),
                    resultSet.getTimestamp("timestamp"),
                    resultSet.getString("status"),
                    resultSet.getString("description"), 
                    resultSet.getString("imageFile"),
                    resultSet.getString("tenantID")));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }

        return requestList;
    }
    
    public static void updateStatus(Requests req, String newStatus){
        connection = ConnectDB.getConnection();
        
        String requestID = req.getId();
        String apNum = req.getApNum();
        String area = req.getArea();
        String descrip = req.getDescrip();
        String status = req.getStatus();
        String imageFile = req.getImageFile();
        String tenantID = req.getTenantID();
        
        
        try{
            updateStatus = connection.prepareStatement("update app.request set status = ? where requestID = ? and apartment = ? and area = ? and status = ? and description = ? and imageFile = ? and tenantID = ?");
            updateStatus.setString(1, newStatus);
            updateStatus.setString(2, requestID);
            updateStatus.setString(3, apNum);
            updateStatus.setString(4, area);
            updateStatus.setString(5, status);
            updateStatus.setString(6, descrip);
            updateStatus.setString(7, imageFile);
            updateStatus.setString(8, tenantID);
            updateStatus.executeUpdate();
        }
        
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        } 
    }
    
    public static ArrayList<String> filterChoices(String filterBy){
        connection = ConnectDB.getConnection();
        ArrayList<String> filters = new ArrayList<String>();
        filters.add("- Select One  -");
        try{
            if (filterBy.equals("Apartment Number")){
                filterChoices = connection.prepareStatement("select * from app.request");
                resultSet = filterChoices.executeQuery();
                while(resultSet.next()){
                    if (!filters.contains(resultSet.getString("apartment"))){
                        filters.add(resultSet.getString("apartment"));
                    }
                }
            }
            
            else if (filterBy.equals("Area")){
                filterChoices = connection.prepareStatement("select * from app.request");
                resultSet = filterChoices.executeQuery();
                while(resultSet.next()){
                    if (!filters.contains(resultSet.getString("area"))){
                        filters.add(resultSet.getString("area"));
                    }
                }
            }
            
            else if (filterBy.equals("Status")){
                filters.add("Pending");
                filters.add("Completed");
            }
            
            
        }
        
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return filters;
    }
    
    public static ArrayList<Requests> filterRequests(String filterBy, String subFilter){
        connection = ConnectDB.getConnection();
        ArrayList<Requests> requestList = new ArrayList<Requests>();
        
        try{
            filterRequests = connection.prepareStatement("select * from app.request order by requestID");
            
            
            if (filterBy.equals("Apartment Number")){
                //filterRequests = connection.prepareStatement("select apartment from app.request where apartment = subfilter");
                resultSet = filterRequests.executeQuery();
                while(resultSet.next()){
                    if (subFilter.equals(resultSet.getString("apartment"))){
                        requestList.add(new Requests(
                        resultSet.getString("requestID"),
                        resultSet.getString("apartment"),
                        resultSet.getString("area"),
                        resultSet.getTimestamp("timestamp"),
                        resultSet.getString("status"),
                        resultSet.getString("description"), 
                        resultSet.getString("imageFile"),
                        resultSet.getString("tenantID")));
                    }
                    
                }
            }
                
            else if (filterBy.equals("Area")){
                //filterRequests = connection.prepareStatement("select apartment from app.request where apartment = subfilter");
                resultSet = filterRequests.executeQuery();
                while(resultSet.next()){
                    if (subFilter.equals(resultSet.getString("area"))){
                        requestList.add(new Requests(
                        resultSet.getString("requestID"),
                        resultSet.getString("apartment"),
                        resultSet.getString("area"),
                        resultSet.getTimestamp("timestamp"),
                        resultSet.getString("status"),
                        resultSet.getString("description"), 
                        resultSet.getString("imageFile"),
                        resultSet.getString("tenantID")));
                    }
                    
                }
            }
            
            else if (filterBy.equals("Status")){
                //filterRequests = connection.prepareStatement("select apartment from app.request where apartment = subfilter");
                resultSet = filterRequests.executeQuery();
                while(resultSet.next()){
                    if (subFilter.equals(resultSet.getString("status"))){
                        requestList.add(new Requests(
                        resultSet.getString("requestID"),
                        resultSet.getString("apartment"),
                        resultSet.getString("area"),
                        resultSet.getTimestamp("timestamp"),
                        resultSet.getString("status"),
                        resultSet.getString("description"), 
                        resultSet.getString("imageFile"),
                        resultSet.getString("tenantID")));
                    }
                    
                }
            }
            
            
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        // Returns a list of SUNLabTime objects, listed by sorting style
        return requestList;
    }
    
    public static ArrayList<Requests> dateRangeRequests(String from, String to){
        connection = ConnectDB.getConnection();
        ArrayList<Requests> filters = new ArrayList<Requests>();
        
        String[] fromDateArr = from.split("/");
        String[] toDateArr = to.split("/");
        
        Calendar fromDate = Calendar.getInstance();
        fromDate.set(Integer.valueOf(fromDateArr[2]), Integer.valueOf(fromDateArr[0])-1, Integer.valueOf(fromDateArr[1]));
        fromDate.set(Calendar.HOUR_OF_DAY, 0);
        fromDate.set(Calendar.MINUTE, 0);
        fromDate.set(Calendar.SECOND, 0);

        Calendar toDate = Calendar.getInstance();

        toDate.set(Integer.valueOf(toDateArr[2]), Integer.valueOf(toDateArr[0])-1, Integer.valueOf(toDateArr[1]));
        toDate.set(Calendar.HOUR_OF_DAY, 23);
        toDate.set(Calendar.MINUTE, 59);
        toDate.set(Calendar.SECOND, 59);
        
        try{
            dateRangeRequests = connection.prepareStatement("select * from app.request order by requestID");
            resultSet = dateRangeRequests.executeQuery();
           
            while(resultSet.next()){
                java.sql.Timestamp time = resultSet.getTimestamp("timestamp");
                Calendar cal = Calendar.getInstance();
                cal.setTime(time);
                //int timestampYear = (cal.get(Calendar.YEAR));
                if (cal.before(toDate) && cal.after(fromDate)){   
                    filters.add(new Requests(
                        resultSet.getString("requestID"),
                        resultSet.getString("apartment"),    
                        resultSet.getString("area"),
                        resultSet.getTimestamp("timestamp"),
                        resultSet.getString("status"),
                        resultSet.getString("description"), 
                        resultSet.getString("imageFile"),
                        resultSet.getString("tenantID")));
                }
            }
            
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        // Returns a list of SUNLabTime objects, listed by sorting style
        return filters;
    }
}
