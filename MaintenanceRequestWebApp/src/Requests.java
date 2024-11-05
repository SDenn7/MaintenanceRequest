
import java.io.File;
import java.sql.Timestamp;
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
public class Requests {
    private final String id;
    private final String apNum;
    private final String area;
    java.sql.Timestamp currentTime = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
    private final String status;
    private final String descrip;
    private final String imageFile;
    private final String tenantID;

    public Requests(String id, String apNum, String area,  java.sql.Timestamp currentTime, String status, String descrip, String imageFile, String tenantID) {
        this.id = id;
        this.apNum = apNum;
        this.area = area;
        this.currentTime = currentTime;
        this.status = status;
        this.descrip = descrip;
        this.imageFile = imageFile;
        this.tenantID = tenantID;
    }

    public String getId() {
        return id;
    }

    public String getApNum() {
        return apNum;
    }

    public String getArea() {
        return area;
    }

    public Timestamp getCurrentTime() {
        return currentTime;
    }

    public String getStatus() {
        return status;
    }
    
    public String getDescrip() {
        return descrip;
    }
    
    public String getImageFile(){
        return imageFile;
    }
    
    public String getTenantID(){
        return tenantID;
    }
    
    
}
