/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.courtOrder;

import com.sun.webui.jsf.model.Option;

import entity.courtOrder.CourtOrderPaymentEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import manager.globalUseManager.ErrorLogWriter;
import java.sql.Timestamp;

/**
 *
 * @author Administrator
 */
public class CourtOrderManager {

    public static final String TAKER_TYPE_PERSON = "PE";
    public static final String TAKER_TYPE_ORGANAZATION = "ORG";
    public static final String PERCENT = "PR";
    public static final String MONEY = "MO";
    public static final String YES = "Y";
    public static final String NO = "N";
    CourtOrderPaymentEntity courtEntity = new CourtOrderPaymentEntity();

    public ArrayList<Option> SelectSex() {
        ArrayList<Option> sex = new ArrayList<Option>();
        sex.add(new Option(-1, "--SELECT SEX--"));
        sex.add(new Option("Male", "Male"));
        sex.add(new Option("Female", "Female"));
        return sex;
    }

    public ArrayList<Option> SelectOrganazationType() {
        ArrayList<Option> Org = new ArrayList<Option>();
        Org.add(new Option(-1, "--SELECT ORGANIZATION TYPE--"));
        Org.add(new Option("GOVERMENT", "GOVERMENT"));
        Org.add(new Option("PRIVATE", "PRIVATE"));
        Org.add(new Option("SHARECOMPANY", "SHARECOMPANY"));
        return Org;
    }

    public ArrayList<Option> SelectRelationType() {
        ArrayList<Option> Org = new ArrayList<Option>();
        Org.add(new Option(-1, "--SELECT RELATION TYPE--"));
        Org.add(new Option("እናት", "እናት"));
        Org.add(new Option("አባት", "አባት"));
        Org.add(new Option("�?ጅ", "�?ጅ"));
        Org.add(new Option("ሚስት", "ሚስት"));
        Org.add(new Option("ወንድ�?", "ወንድ�?"));
        Org.add(new Option("እህት", "እህት"));
        Org.add(new Option("አጎት", "አጎት"));
        Org.add(new Option("አክስት", "አክስት"));
        Org.add(new Option("ሌላ", "ሌላ"));
        return Org;
    }

    public ArrayList<Option> getAllCharge() {
        ArrayList<Option> chargeTypes = new ArrayList<Option>();

        try {
            ResultSet _rs = courtEntity.selectAllChargeType();
            while (_rs.next()) {
                chargeTypes.add(new Option(_rs.getString("CHARGE_ID") + "--" + _rs.getString("CHARGE_NAME") + "--" + _rs.getString("CHARGE_DESCRIPTION"), _rs.getString("CHARGE_ID") + " : " + _rs.getString("CHARGE_NAME")));
            }
            if (chargeTypes.size() == 0) {
                chargeTypes.add(new Option("-1", "NO CHARGE TYPE"));
            } else {
                chargeTypes.add(0, new Option("-1", "--SELECT CHARGE TYPE--"));
            }
            _rs.close();
            return chargeTypes;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public static class CourtModel {
        String reporteDate;
        String requestID;
        String fullName;
        String iD;
        String department;
        String position;
        String relationType;
        String nameOfTaker;
        String takerAddress;
        String takerSex;
        String deductionFor;
        int takerAge;
        String age;
        String organazationType;
        String organazationName;
        String organazationAddress;
        String organazationPhone;
        String chargeType;
        String courtName;
        double totalDeductionAmount;
        String totalPercentDeduction;
        double deductionAmount;
        String percentValue;
        String startDate;
        String endDate;
        String reasoun;
        String docRef;
        String deductionType;
        String isThereBackDedu;
        String inputType;

        public String getInputType() {
            return inputType;
        }

        public void setInputType(String inputType) {
            this.inputType = inputType;
        }

        public String getTotalPercentDeduction() {
            return totalPercentDeduction;
        }

        public void setTotalPercentDeduction(String totalPercentDeduction) {
            this.totalPercentDeduction = totalPercentDeduction;
        }

      

        public double getTotalDeductionAmount() {
            return totalDeductionAmount;
        }

        public void setTotalDeductionAmount(double totalDeductionAmount) {
            this.totalDeductionAmount = totalDeductionAmount;
        }
      
        public String getReporteDate() {
            return reporteDate;
        }

        public void setReporteDate(String reporteDate) {
            this.reporteDate = reporteDate;
        }

        public String getRequestID() {
            return requestID;
        }

        public void setRequestID(String requestID) {
            this.requestID = requestID;
        }

        public String getDeductionFor() {
            return deductionFor;
        }

        public void setDeductionFor(String deductionFor) {
            this.deductionFor = deductionFor;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public CourtModel() {
        }

        public CourtModel(String requestID, String fullName, String id, String department, String position,String selectionCon, String organazationType, String organazationName, String organazationAddress, String organazationPhone, String charType, String courtName, String deductionType, double deductionAmount, String percentValu, String starDate, String enDate, String reasoun, String docRef,String reporteDate,double totalDeduction,String inputType) {
            this.requestID=requestID;
            this.fullName = fullName;
            this.iD = id;
            this.department = department;
            this.position = position;
            this.organazationType = organazationType;
            this.organazationName = organazationName;
            this.organazationAddress = organazationAddress;
            this.organazationPhone = organazationPhone;
            this.chargeType = charType;
            this.courtName = courtName;
            this.deductionType = deductionType;
            this.deductionAmount = deductionAmount;
            this.percentValue = percentValu;
            this.startDate = starDate;
            this.endDate = enDate;
            this.reasoun = reasoun;
            this.docRef = docRef;
            this.reporteDate=reporteDate;
            this.totalDeductionAmount=totalDeduction;
            this.inputType=inputType;
           // this.totalPercentDeduction=totalpercentDeduction;
        }

        public CourtModel( String request_id,String fullName, String id, String department, String position, String selectionCon, String relType, String nameOfTaker, String takerAddress, String takerSex, int takerAge, String chargeType, String courtName,
                String deductionType, double deductionAmount, String percentValue, String startDate,
                String endDate, String reasoun, String docRef,String reportDate,double totalDeduction,String inputType) {
            this.requestID=request_id;
            this.fullName = fullName;
            this.iD = id;
            this.department = department;
            this.position = position;
            this.relationType = relType;
            this.nameOfTaker = nameOfTaker;
            this.takerAddress = takerAddress;
            this.takerSex = takerSex;
            this.takerAge = takerAge;
            this.chargeType = chargeType;
            this.courtName = courtName;
            this.deductionType = deductionType;
            this.deductionAmount = deductionAmount;
            this.percentValue = percentValue;
       
            this.startDate = startDate;
            this.endDate = endDate;
            this.reasoun = reasoun;
            this.docRef = docRef;
            this.deductionFor=selectionCon;
            this.age=Integer.toString(takerAge);
            this.reporteDate=reportDate;
            this.totalDeductionAmount=totalDeduction;
            this.inputType=inputType;
           // this.totalPercentDeduction=totalpercentDeduction;
        }

        public String getIsThereBackDedu() {
            return isThereBackDedu;
        }

        public void setIsThereBackDedu(String isThereBackDedu) {
            this.isThereBackDedu = isThereBackDedu;
        }

        public String getPercentValue() {
            return percentValue;
        }

        public void setPercentValue(String percentValue) {
            this.percentValue = percentValue;
        }

     

        public String getDeductionType() {
            return deductionType;
        }

        public void setDeductionType(String deductionType) {
            this.deductionType = deductionType;
        }

        public String getChargeType() {
            return chargeType;
        }

        public void setChargeType(String chargeType) {
            this.chargeType = chargeType;
        }

        public String getCourtName() {
            return courtName;
        }

        public void setCourtName(String courtName) {
            this.courtName = courtName;
        }

        public double getDeductionAmount() {
            return deductionAmount;
        }

        public void setDeductionAmount(double deductionAmount) {
            this.deductionAmount = deductionAmount;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getDocRef() {
            return docRef;
        }

        public void setDocRef(String docRef) {
            this.docRef = docRef;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getID() {
            return iD;
        }

        public void setID(String iD) {
            this.iD = iD;
        }

        public String getNameOfTaker() {
            return nameOfTaker;
        }

        public void setNameOfTaker(String nameOfTaker) {
            this.nameOfTaker = nameOfTaker;
        }

        public String getOrganazationAddress() {
            return organazationAddress;
        }

        public void setOrganazationAddress(String organazationAddress) {
            this.organazationAddress = organazationAddress;
        }

        public String getOrganazationName() {
            return organazationName;
        }

        public void setOrganazationName(String organazationName) {
            this.organazationName = organazationName;
        }

        public String getOrganazationPhone() {
            return organazationPhone;
        }

        public void setOrganazationPhone(String organazationPhone) {
            this.organazationPhone = organazationPhone;
        }

        public String getOrganazationType() {
            return organazationType;
        }

        public void setOrganazationType(String organazationType) {
            this.organazationType = organazationType;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getReasoun() {
            return reasoun;
        }

        public void setReasoun(String reasoun) {
            this.reasoun = reasoun;
        }

        public String getRelationType() {
            return relationType;
        }

        public void setRelationType(String relationType) {
            this.relationType = relationType;
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public String getTakerAddress() {
            return takerAddress;
        }

        public void setTakerAddress(String takerAddress) {
            this.takerAddress = takerAddress;
        }

        public int getTakerAge() {
            return takerAge;
        }

        public void setTakerAge(int takerAge) {
            this.takerAge = takerAge;
        }

        public String getTakerSex() {
            return takerSex;
        }

        public void setTakerSex(String takerSex) {
            this.takerSex = takerSex;
        }
    }

    public static class DeductTime {

        String deductType;
        double deductAmount;
        String deductTime;

        public DeductTime(String deductionType, double deductionAmount, String deductionTime) {
            this.deductType = deductionType;
            this.deductAmount = deductionAmount;
            this.deductTime = deductionTime;
        }

        public double getDeductAmount() {
            return deductAmount;
        }

        public void setDeductAmount(double deductAmount) {
            this.deductAmount = deductAmount;
        }

        public String getDeductTime() {
            return deductTime;
        }

        public void setDeductTime(String deductTime) {
            this.deductTime = deductTime;
        }

        public String getDeductType() {
            return deductType;
        }

        public void setDeductType(String deductType) {
            this.deductType = deductType;
        }

        public DeductTime() {
        }
    }

    public static class PersonOrFamily {

        String relationType;
        String fullName;
        String address;
        String sex;
        int age;
        boolean selected;

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getRelationType() {
            return relationType;
        }

        public void setRelationType(String relationType) {
            this.relationType = relationType;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public PersonOrFamily() {
        }
    }

    public ArrayList<PersonOrFamily> getAllPersonUnderRelationShip(String type, String relType) {
        ArrayList<PersonOrFamily> relationMemberList = new ArrayList<PersonOrFamily>();
        try {
            ResultSet _rs = courtEntity.selectMemeberList(type, relType);
            int counter = 0;
            while (_rs.next()) {
                PersonOrFamily currentmemberList = new PersonOrFamily();

                currentmemberList.setFullName(_rs.getString("FIRST_NAME") + " " + _rs.getString("MIDDLE_NAME") + " " + _rs.getString("LAST_NAME"));
                currentmemberList.setRelationType(_rs.getString("RELATION_TYPE"));//
                currentmemberList.setSex(_rs.getString("SEX"));//
                relationMemberList.add(currentmemberList);
            }
            _rs.close();
            return relationMemberList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public CourtModel getAllPersonRelationShip(String type, String relType) {
        CourtModel courtModel = new CourtModel();
        ArrayList<PersonOrFamily> relationMemberList = new ArrayList<PersonOrFamily>();
        try {
            ResultSet _rs = courtEntity.selectMemeberList(type, relType);
            int counter = 0;
            while (_rs.next()) {

                courtModel.setNameOfTaker(_rs.getString("FIRST_NAME") + " " + _rs.getString("MIDDLE_NAME") + " " + _rs.getString("LAST_NAME"));
                courtModel.setRelationType(_rs.getString("RELATION_TYPE"));//
                courtModel.setTakerSex(_rs.getString("SEX"));//

            }
            _rs.close();
            return courtModel;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

      public String getCurrentIdOfCourtOrderPayment(){
         String currentID=courtEntity.getCurrentIdOfCourtDeduction();

        return currentID;
     }
      CourtModel savedModel=new CourtModel();
       public boolean SaveCourtDeductionModelForPerson(ArrayList<CourtModel> courtDeductForPerson) {
       String currentDateAndTime = new Timestamp((new Date()).getTime()).toString();
       ArrayList<CourtModel>  toBackDeduction = new ArrayList<CourtModel>();
       int size =courtDeductForPerson.size();

    
        try {
// 
         courtEntity.SaveCourtDeductionModelForPerson(courtDeductForPerson);
         
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
          return true;
    }


       public boolean SaveCourtDeductionModelForOrganazation(ArrayList<CourtModel> courtDeductForOrganazation) {
        String currentDateAndTime = new Timestamp((new Date()).getTime()).toString();
       ArrayList<CourtModel>  toBackDeduction = new ArrayList<CourtModel>();
      


        try {
//
         courtEntity.SaveCourtDeductionModelForOrganazation(courtDeductForOrganazation);

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
          return true;
    }

}
