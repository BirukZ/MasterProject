/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.HolydayBonesManager;

import entity.HolydayBonesEntity.HolydayBonesEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.model.SelectItem;
import com.sun.webui.jsf.model.Option;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author Kibrom
 */
public class HolydayBonesManager {

    ArrayList<HolydayBonesManager> holydayBoneslist = new ArrayList<HolydayBonesManager>();
    HolydayBonesEntity holydayBonesEntity = new HolydayBonesEntity();
    private String empId;
    private String empName;
    private String religion;

    public HolydayBonesManager() {
    }
    public ArrayList<HolydayBonesManager> getHolydayBoneslist() {
        return holydayBoneslist;
    }


    public void setHolydayBoneslist(ArrayList<HolydayBonesManager> holydayBoneslist) {
        this.holydayBoneslist = holydayBoneslist;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public HolydayBonesManager(String empId, String empName, String religion) {
        this.empId = empId;
        this.empName = empName;
        this.religion = religion;
    }

    public ArrayList<HolydayBonesManager> selectEmpForHolydayBonesManager(String religion, String addressCode) {


        try {
            ArrayList<HashMap> holydayBones = holydayBonesEntity.getHolydayBones(religion, addressCode);

            for (HashMap hm : holydayBones) {

                holydayBoneslist.add(new HolydayBonesManager(
                        hm.get("empId").toString(),
                        hm.get("empName").toString(),
                        hm.get("religion").toString()));
//                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return holydayBoneslist;
    }
public ArrayList<HolydayBonesManager> selectEmpForHolydayBonesManager(int requestId) {


        try {
            ArrayList<HashMap> holydayBones = holydayBonesEntity.getHolydayBoneslistForApp(requestId);

            for (HashMap hm : holydayBones) {

                holydayBoneslist.add(new HolydayBonesManager(
                        hm.get("empId").toString(),
                        hm.get("empName").toString(),
                        hm.get("religion").toString()));
//                }
            }


        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return holydayBoneslist;
    }
    public String bonesAmount() {
        return holydayBonesEntity.bonesAmount();
    }

    public ArrayList<SelectItem> getReligionList() {
        ArrayList<SelectItem> religionList = new ArrayList<SelectItem>();
        religionList.add(new SelectItem("Select Religion"));
        religionList.add(new SelectItem("CR--Crestin"));
        religionList.add(new SelectItem("MS--Muslim"));
        return religionList;
    }

    public boolean request(String religion, String addressCode, String amount, String requester, String reqstDate,String holydayName ,ArrayList<HolydayBonesManager> holydayBonesManagerList) {
        if (holydayBonesEntity.request(religion, addressCode, amount, requester, reqstDate,holydayName)) {

            return holydayBonesEntity.request_emp(holydayBonesManagerList);

        }
        return false;
    }
    public ArrayList<SelectItem> getBonseRequst() {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = holydayBonesEntity.bonseRequst();
            String as = "";

            while (_rs.next()) {

             SelectItem currentItem = new SelectItem(_rs.getString("HOLYDAYBONESID") + "--" +
                     _rs.getString("BRANCH") );
              requestLists.add(currentItem);
            }
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }
     public HashMap readRequestInfo(int requestId) {
        try {
            return holydayBonesEntity.readRequestInfo(requestId);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean  aprove(int requestId) {
       return holydayBonesEntity.aprove(requestId);
    }
    public boolean  reject(int requestId) {
       return holydayBonesEntity.reject(requestId);
    }

    
    public Option[] readHolyday() {
        Option[] purposeOpt = null;
        ArrayList<HolydayBonesEntity> holydaylist = holydayBonesEntity.readHolyday();
        purposeOpt = new Option[holydaylist.size() + 1];
        Option purposeOptFirst = new Option("-----All Holydayes----");
        purposeOpt[0] = purposeOptFirst;
        for (int i = 0; i < holydaylist.size(); i++) {
            holydayBonesEntity = holydaylist.get(i);
            Option optRegionType = new Option(holydayBonesEntity.getHolydayName());
            purposeOpt[i + 1] = optRegionType;
        }

        return purposeOpt;
    }
      public ArrayList<SelectItem> getAddressCode() {
        ArrayList<SelectItem> addressList = new ArrayList<SelectItem>();
        addressList.add(new SelectItem("SELECT Address"));
        addressList.add(new SelectItem("MU1--Mugher1"));
        addressList.add(new SelectItem("MU2--Mugher2"));
        addressList.add(new SelectItem("AA--Addis Ababa"));
        addressList.add(new SelectItem("DR--Derba"));
        addressList.add(new SelectItem("NZ--Nazareth"));
        return addressList;
    }
}
