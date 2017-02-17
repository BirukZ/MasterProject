/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.leaveEntity;

/**
 *
 * @author ONEJAVA
 */
import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author MKB_59
 */
public class OrganizationCalendarEntity extends ConnectionManager {

    private String id;
    private String description;
    private String date;
    private String remark;


    // <editor-fold defaultstate="collapsed" desc="Getter Setter & Constructor">
   

  

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    public OrganizationCalendarEntity() {
    }

    // </editor-fold>
    HolidayEntity organizationCalendar = new HolidayEntity();
   public OrganizationCalendarEntity(String id, String description, String date) {
        this.id = id;
        this.description = description;
        this.date = date;

    }
    public ArrayList<OrganizationCalendarEntity> readOrganizationCalendar() {
        return organizationCalendar.readAll();
    }

    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

   
}
