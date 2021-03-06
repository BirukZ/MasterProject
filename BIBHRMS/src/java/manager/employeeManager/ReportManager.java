/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.employeeManager;


import entity.employeeEntity.ReportEntity;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.swing.ImageIcon;
import manager.globalUseManager.ErrorLogWriter;
import manager.globalUseManager.StringDateManipulation;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.j2ee.servlets.ImageServlet;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author INSA MOND IND
 */
public class ReportManager {

    ReportEntity reportEntity = new ReportEntity();

    //*********************************************************END OF PAYROLL PARAMETER PROPERTIES*********************************
    String EMPID;
    String FIRSTNAME;
    String MIDDLENAME;
    String LASTNAME;
    String EMPFULLNAME;
    String EFULLNAME;
    float SALARY;
    String TITLEDESCRIPTION;
    String TDESCRIPTION;
    String CIVILTYPE;
    float PROFFESSION;
    float PENSIONGOVACCRUAL;
    float FOOD;
    float LOCATION;
    float HOUSE;
    float TRANSPORT;
    float AOTHER;
    float ACCRUALTOTAL;
    float AT;
    float PENSIONGOVDEDUCTION;
    float TAX;
    float PDEDUCTIONTOTAL;
    float PDT;
    float FINE;
    float WEAPONS;
    float UNIFORM;
    float CARCOLLISION;
    float TELEPHONE;
    float ELECTRIC;
    float GOTHER;
    float GDEDUCTIONTOTAL;
    float GDT;
    float FAMILLY;
    float SAVING;
    float SPORT;
    float CLUB;
    float HOSPITAL;
    float NEWSPAPER;
    float DEVELOPMENTFUND;
    float LOAN;
    float OTHERLOAN;
    float SAVINGLOAN;
    float SAVINGHOLLYDAYLOAN;
    float SAVINGINTREST;
    float PRDEDUCTIONTOTAL;
    float PRDT;
    float GAPRDT;
    float NETSALARY;
    byte[] FPLOGO = null;//variable to hold the image byte information
    byte[] photobinary;//variable to hold the image byte information when a method is called.
    private static final int RECURITMENT = 1,DESCIPLINE=2;
    private ImageIcon MPIMG;

    public ImageIcon getMPIMG() {
        return MPIMG;
    }

    public void setMPIMG(ImageIcon MPIMG) {
        this.MPIMG = MPIMG;
    }
    private ArrayList<HashMap> filteredData = new ArrayList<HashMap>();

    public ArrayList<HashMap> getFilteredData() {
        return filteredData;
    }

    public void setFilteredData(ArrayList<HashMap> filteredData) {
        this.filteredData = filteredData;
    }

    public byte[] getPhotobinary() {
        return photobinary;
    }

    public void setPhotobinary(byte[] photobinary) {
        this.photobinary = photobinary;
    }

    public byte[] getFPLOGO() {
        return FPLOGO;
    }

    public void setFPLOGO(byte[] FPLOGO) {
        this.FPLOGO = FPLOGO;
    }

    public String getEMPFULLNAME() {
        return EMPFULLNAME;
    }

    public void setEMPFULLNAME(String EMPFULLNAME) {
        this.EMPFULLNAME = EMPFULLNAME;
    }

    public float getACCRUALTOTAL() {
        return ACCRUALTOTAL;
    }

    public void setACCRUALTOTAL(float ACCRUALTOTAL) {
        this.ACCRUALTOTAL = ACCRUALTOTAL;
    }

    public float getAOTHER() {
        return AOTHER;
    }

    public void setAOTHER(float AOTHER) {
        this.AOTHER = AOTHER;
    }

    public float getAT() {
        return AT;
    }

    public void setAT(float AT) {
        this.AT = AT;
    }

    public float getCARCOLLISION() {
        return CARCOLLISION;
    }

    public void setCARCOLLISION(float CARCOLLISION) {
        this.CARCOLLISION = CARCOLLISION;
    }

    public String getCIVILTYPE() {
        return CIVILTYPE;
    }

    public void setCIVILTYPE(String CIVILTYPE) {
        this.CIVILTYPE = CIVILTYPE;
    }

    public float getCLUB() {
        return CLUB;
    }

    public void setCLUB(float CLUB) {
        this.CLUB = CLUB;
    }

    public float getDEVELOPMENTFUND() {
        return DEVELOPMENTFUND;
    }

    public void setDEVELOPMENTFUND(float DEVELOPMENTFUND) {
        this.DEVELOPMENTFUND = DEVELOPMENTFUND;
    }

    public float getELECTRIC() {
        return ELECTRIC;
    }

    public void setELECTRIC(float ELECTRIC) {
        this.ELECTRIC = ELECTRIC;
    }

    public String getEMPID() {
        return EMPID;
    }

    public void setEMPID(String EMPID) {
        this.EMPID = EMPID;
    }

    public float getFAMILLY() {
        return FAMILLY;
    }

    public void setFAMILLY(float FAMILLY) {
        this.FAMILLY = FAMILLY;
    }

    public float getFINE() {
        return FINE;
    }

    public void setFINE(float FINE) {
        this.FINE = FINE;
    }

    public String getFIRSTNAME() {
        return FIRSTNAME;
    }

    public void setFIRSTNAME(String FIRSTNAME) {
        this.FIRSTNAME = FIRSTNAME;
    }

    public float getFOOD() {
        return FOOD;
    }

    public void setFOOD(float FOOD) {
        this.FOOD = FOOD;
    }

    public float getGAPRDT() {
        return GAPRDT;
    }

    public void setGAPRDT(float GAPRDT) {
        this.GAPRDT = GAPRDT;
    }

    public float getGDEDUCTIONTOTAL() {
        return GDEDUCTIONTOTAL;
    }

    public void setGDEDUCTIONTOTAL(float GDEDUCTIONTOTAL) {
        this.GDEDUCTIONTOTAL = GDEDUCTIONTOTAL;
    }

    public float getGDT() {
        return GDT;
    }

    public void setGDT(float GDT) {
        this.GDT = GDT;
    }

    public float getGOTHER() {
        return GOTHER;
    }

    public void setGOTHER(float GOTHER) {
        this.GOTHER = GOTHER;
    }

    public float getHOSPITAL() {
        return HOSPITAL;
    }

    public void setHOSPITAL(float HOSPITAL) {
        this.HOSPITAL = HOSPITAL;
    }

    public float getHOUSE() {
        return HOUSE;
    }

    public void setHOUSE(float HOUSE) {
        this.HOUSE = HOUSE;
    }

    public String getLASTNAME() {
        return LASTNAME;
    }

    public void setLASTNAME(String LASTNAME) {
        this.LASTNAME = LASTNAME;
    }

    public float getLOAN() {
        return LOAN;
    }

    public void setLOAN(float LOAN) {
        this.LOAN = LOAN;
    }

    public float getLOCATION() {
        return LOCATION;
    }

    public void setLOCATION(float LOCATION) {
        this.LOCATION = LOCATION;
    }

    public String getMIDDLENAME() {
        return MIDDLENAME;
    }

    public void setMIDDLENAME(String MIDDLENAME) {
        this.MIDDLENAME = MIDDLENAME;
    }

    public float getNETSALARY() {
        return NETSALARY;
    }

    public void setNETSALARY(float NETSALARY) {
        this.NETSALARY = NETSALARY;
    }

    public float getNEWSPAPER() {
        return NEWSPAPER;
    }

    public void setNEWSPAPER(float NEWSPAPER) {
        this.NEWSPAPER = NEWSPAPER;
    }

    public float getOTHERLOAN() {
        return OTHERLOAN;
    }

    public void setOTHERLOAN(float OTHERLOAN) {
        this.OTHERLOAN = OTHERLOAN;
    }

    public float getPDEDUCTIONTOTAL() {
        return PDEDUCTIONTOTAL;
    }

    public void setPDEDUCTIONTOTAL(float PDEDUCTIONTOTAL) {
        this.PDEDUCTIONTOTAL = PDEDUCTIONTOTAL;
    }

    public float getPDT() {
        return PDT;
    }

    public void setPDT(float PDT) {
        this.PDT = PDT;
    }

    public float getPENSIONGOVACCRUAL() {
        return PENSIONGOVACCRUAL;
    }

    public void setPENSIONGOVACCRUAL(float PENSIONGOVACCRUAL) {
        this.PENSIONGOVACCRUAL = PENSIONGOVACCRUAL;
    }

    public float getPENSIONGOVDEDUCTION() {
        return PENSIONGOVDEDUCTION;
    }

    public void setPENSIONGOVDEDUCTION(float PENSIONGOVDEDUCTION) {
        this.PENSIONGOVDEDUCTION = PENSIONGOVDEDUCTION;
    }

    public float getPRDEDUCTIONTOTAL() {
        return PRDEDUCTIONTOTAL;
    }

    public void setPRDEDUCTIONTOTAL(float PRDEDUCTIONTOTAL) {
        this.PRDEDUCTIONTOTAL = PRDEDUCTIONTOTAL;
    }

    public float getPRDT() {
        return PRDT;
    }

    public void setPRDT(float PRDT) {
        this.PRDT = PRDT;
    }

    public float getPROFFESSION() {
        return PROFFESSION;
    }

    public void setPROFFESSION(float PROFFESSION) {
        this.PROFFESSION = PROFFESSION;
    }

    public float getSALARY() {
        return SALARY;
    }

    public void setSALARY(float SALARY) {
        this.SALARY = SALARY;
    }

    public float getSAVING() {
        return SAVING;
    }

    public void setSAVING(float SAVING) {
        this.SAVING = SAVING;
    }

    public float getSAVINGHOLLYDAYLOAN() {
        return SAVINGHOLLYDAYLOAN;
    }

    public void setSAVINGHOLLYDAYLOAN(float SAVINGHOLLYDAYLOAN) {
        this.SAVINGHOLLYDAYLOAN = SAVINGHOLLYDAYLOAN;
    }

    public float getSAVINGINTREST() {
        return SAVINGINTREST;
    }

    public void setSAVINGINTREST(float SAVINGINTREST) {
        this.SAVINGINTREST = SAVINGINTREST;
    }

    public float getSAVINGLOAN() {
        return SAVINGLOAN;
    }

    public void setSAVINGLOAN(float SAVINGLOAN) {
        this.SAVINGLOAN = SAVINGLOAN;
    }

    public float getSPORT() {
        return SPORT;
    }

    public void setSPORT(float SPORT) {
        this.SPORT = SPORT;
    }

    public float getTAX() {
        return TAX;
    }

    public void setTAX(float TAX) {
        this.TAX = TAX;
    }

    public float getTELEPHONE() {
        return TELEPHONE;
    }

    public void setTELEPHONE(float TELEPHONE) {
        this.TELEPHONE = TELEPHONE;
    }

    public String getTITLEDESCRIPTION() {
        return TITLEDESCRIPTION;
    }

    public void setTITLEDESCRIPTION(String TITLEDESCRIPTION) {
        this.TITLEDESCRIPTION = TITLEDESCRIPTION;
    }

    public String getEFULLNAME() {
        return EFULLNAME;
    }

    public void setEFULLNAME(String EFULLNAME) {
        this.EFULLNAME = EFULLNAME;
    }

    public String getTDESCRIPTION() {
        return TDESCRIPTION;
    }

    public void setTDESCRIPTION(String TDESCRIPTION) {
        this.TDESCRIPTION = TDESCRIPTION;
    }

    public float getTRANSPORT() {
        return TRANSPORT;
    }

    public void setTRANSPORT(float TRANSPORT) {
        this.TRANSPORT = TRANSPORT;
    }

    public float getUNIFORM() {
        return UNIFORM;
    }

    public void setUNIFORM(float UNIFORM) {
        this.UNIFORM = UNIFORM;
    }

    public float getWEAPONS() {
        return WEAPONS;
    }

    public void setWEAPONS(float WEAPONS) {
        this.WEAPONS = WEAPONS;
    }
    //*********************************************************END OF PAYROLL PARAMETER PROPERTIES*********************************
    //*********************************************************PAYROLL PARAMETER SUM PROPERTIES*********************************
    String SALARYT;
    String PROFFESSIONT;
    String PENSIONGOVACCRUALT;
    String FOODT;
    String LOCATIONT;
    String HOUSET;
    String TRANSPORTT;
    String AOTHERT;
    String ACCRUALTOTALT;
    String ATT;
    String PENSIONGOVDEDUCTIONT;
    String TAXT;
    String PDEDUCTIONTOTALT;
    String PDTT;
    String FINET;
    String WEAPONST;
    String UNIFORMT;
    String CARCOLLISIONT;
    String TELEPHONET;
    String ELECTRICT;
    String GOTHERT;
    String GDEDUCTIONTOTALT;
    String GDTT;
    String FAMILLYT;
    String SAVINGT;
    String SPORTT;
    String CLUBT;
    String HOSPITALT;
    String NEWSPAPERT;
    String DEVELOPMENTFUNDT;
    String LOANT;
    String OTHERLOANT;
    String SAVINGLOANT;
    String SAVINGHOLLYDAYLOANT;
    String SAVINGINTRESTT;
    String PRDEDUCTIONTOTALT;
    String PRDTT;
    String GAPRDTT;
    String NETSALARYT;

    public String getACCRUALTOTALT() {
        return ACCRUALTOTALT;
    }

    public void setACCRUALTOTALT(String ACCRUALTOTALT) {
        this.ACCRUALTOTALT = ACCRUALTOTALT;
    }

    public String getAOTHERT() {
        return AOTHERT;
    }

    public void setAOTHERT(String AOTHERT) {
        this.AOTHERT = AOTHERT;
    }

    public String getATT() {
        return ATT;
    }

    public void setATT(String ATT) {
        this.ATT = ATT;
    }

    public String getCARCOLLISIONT() {
        return CARCOLLISIONT;
    }

    public void setCARCOLLISIONT(String CARCOLLISIONT) {
        this.CARCOLLISIONT = CARCOLLISIONT;
    }

    public String getCLUBT() {
        return CLUBT;
    }

    public void setCLUBT(String CLUBT) {
        this.CLUBT = CLUBT;
    }

    public String getDEVELOPMENTFUNDT() {
        return DEVELOPMENTFUNDT;
    }

    public void setDEVELOPMENTFUNDT(String DEVELOPMENTFUNDT) {
        this.DEVELOPMENTFUNDT = DEVELOPMENTFUNDT;
    }

    public String getELECTRICT() {
        return ELECTRICT;
    }

    public void setELECTRICT(String ELECTRICT) {
        this.ELECTRICT = ELECTRICT;
    }

    public String getFAMILLYT() {
        return FAMILLYT;
    }

    public void setFAMILLYT(String FAMILLYT) {
        this.FAMILLYT = FAMILLYT;
    }

    public String getFINET() {
        return FINET;
    }

    public void setFINET(String FINET) {
        this.FINET = FINET;
    }

    public String getFOODT() {
        return FOODT;
    }

    public void setFOODT(String FOODT) {
        this.FOODT = FOODT;
    }

    public String getGAPRDTT() {
        return GAPRDTT;
    }

    public void setGAPRDTT(String GAPRDTT) {
        this.GAPRDTT = GAPRDTT;
    }

    public String getGDEDUCTIONTOTALT() {
        return GDEDUCTIONTOTALT;
    }

    public void setGDEDUCTIONTOTALT(String GDEDUCTIONTOTALT) {
        this.GDEDUCTIONTOTALT = GDEDUCTIONTOTALT;
    }

    public String getGDTT() {
        return GDTT;
    }

    public void setGDTT(String GDTT) {
        this.GDTT = GDTT;
    }

    public String getGOTHERT() {
        return GOTHERT;
    }

    public void setGOTHERT(String GOTHERT) {
        this.GOTHERT = GOTHERT;
    }

    public String getHOSPITALT() {
        return HOSPITALT;
    }

    public void setHOSPITALT(String HOSPITALT) {
        this.HOSPITALT = HOSPITALT;
    }

    public String getHOUSET() {
        return HOUSET;
    }

    public void setHOUSET(String HOUSET) {
        this.HOUSET = HOUSET;
    }

    public String getLOANT() {
        return LOANT;
    }

    public void setLOANT(String LOANT) {
        this.LOANT = LOANT;
    }

    public String getLOCATIONT() {
        return LOCATIONT;
    }

    public void setLOCATIONT(String LOCATIONT) {
        this.LOCATIONT = LOCATIONT;
    }

    public String getNETSALARYT() {
        return NETSALARYT;
    }

    public void setNETSALARYT(String NETSALARYT) {
        this.NETSALARYT = NETSALARYT;
    }

    public String getNEWSPAPERT() {
        return NEWSPAPERT;
    }

    public void setNEWSPAPERT(String NEWSPAPERT) {
        this.NEWSPAPERT = NEWSPAPERT;
    }

    public String getOTHERLOANT() {
        return OTHERLOANT;
    }

    public void setOTHERLOANT(String OTHERLOANT) {
        this.OTHERLOANT = OTHERLOANT;
    }

    public String getPDEDUCTIONTOTALT() {
        return PDEDUCTIONTOTALT;
    }

    public void setPDEDUCTIONTOTALT(String PDEDUCTIONTOTALT) {
        this.PDEDUCTIONTOTALT = PDEDUCTIONTOTALT;
    }

    public String getPDTT() {
        return PDTT;
    }

    public void setPDTT(String PDTT) {
        this.PDTT = PDTT;
    }

    public String getPENSIONGOVACCRUALT() {
        return PENSIONGOVACCRUALT;
    }

    public void setPENSIONGOVACCRUALT(String PENSIONGOVACCRUALT) {
        this.PENSIONGOVACCRUALT = PENSIONGOVACCRUALT;
    }

    public String getPENSIONGOVDEDUCTIONT() {
        return PENSIONGOVDEDUCTIONT;
    }

    public void setPENSIONGOVDEDUCTIONT(String PENSIONGOVDEDUCTIONT) {
        this.PENSIONGOVDEDUCTIONT = PENSIONGOVDEDUCTIONT;
    }

    public String getPRDEDUCTIONTOTALT() {
        return PRDEDUCTIONTOTALT;
    }

    public void setPRDEDUCTIONTOTALT(String PRDEDUCTIONTOTALT) {
        this.PRDEDUCTIONTOTALT = PRDEDUCTIONTOTALT;
    }

    public String getPRDTT() {
        return PRDTT;
    }

    public void setPRDTT(String PRDTT) {
        this.PRDTT = PRDTT;
    }

    public String getPROFFESSIONT() {
        return PROFFESSIONT;
    }

    public void setPROFFESSIONT(String PROFFESSIONT) {
        this.PROFFESSIONT = PROFFESSIONT;
    }

    public String getSALARYT() {
        return SALARYT;
    }

    public void setSALARYT(String SALARYT) {
        this.SALARYT = SALARYT;
    }

    public String getSAVINGHOLLYDAYLOANT() {
        return SAVINGHOLLYDAYLOANT;
    }

    public void setSAVINGHOLLYDAYLOANT(String SAVINGHOLLYDAYLOANT) {
        this.SAVINGHOLLYDAYLOANT = SAVINGHOLLYDAYLOANT;
    }

    public String getSAVINGINTRESTT() {
        return SAVINGINTRESTT;
    }

    public void setSAVINGINTRESTT(String SAVINGINTRESTT) {
        this.SAVINGINTRESTT = SAVINGINTRESTT;
    }

    public String getSAVINGLOANT() {
        return SAVINGLOANT;
    }

    public void setSAVINGLOANT(String SAVINGLOANT) {
        this.SAVINGLOANT = SAVINGLOANT;
    }

    public String getSAVINGT() {
        return SAVINGT;
    }

    public void setSAVINGT(String SAVINGT) {
        this.SAVINGT = SAVINGT;
    }

    public String getSPORTT() {
        return SPORTT;
    }

    public void setSPORTT(String SPORTT) {
        this.SPORTT = SPORTT;
    }

    public String getTAXT() {
        return TAXT;
    }

    public void setTAXT(String TAXT) {
        this.TAXT = TAXT;
    }

    public String getTELEPHONET() {
        return TELEPHONET;
    }

    public void setTELEPHONET(String TELEPHONET) {
        this.TELEPHONET = TELEPHONET;
    }

    public String getTRANSPORTT() {
        return TRANSPORTT;
    }

    public void setTRANSPORTT(String TRANSPORTT) {
        this.TRANSPORTT = TRANSPORTT;
    }

    public String getUNIFORMT() {
        return UNIFORMT;
    }

    public void setUNIFORMT(String UNIFORMT) {
        this.UNIFORMT = UNIFORMT;
    }

    public String getWEAPONST() {
        return WEAPONST;
    }

    public void setWEAPONST(String WEAPONST) {
        this.WEAPONST = WEAPONST;
    }
    //*********************************************************END OF PAYROLL PARAMETER SUM PROPERTIES*********************************

    public ReportManager() {
    }

    public ReportManager(String EMPID, String EMPFULLNAME, Float SALARY, String TITLEDESCRIPTION, String CIVILTYPE, float PROFFESSION, float PENSIONGOVACCRUAL, float FOOD, float LOCATION, float HOUSE, float TRANSPORT, float AOTHER, float ACCRUALTOTAL, float AT, float PENSIONGOVDEDUCTION, float TAX, float PDEDUCTIONTOTAL, float PDT, float FINE, float WEAPONS, float UNIFORM, float CARCOLLISION, float TELEPHONE, float ELECTRIC, float GOTHER, float GDEDUCTIONTOTAL, float GDT, float FAMILLY, float SAVING, float SPORT, float CLUB, float HOSPITAL, float NEWSPAPER, float DEVELOPMENTFUND, float LOAN, float OTHERLOAN, float SAVINGLOAN, float SAVINGHOLLYDAYLOAN, float SAVINGINTREST, float PRDEDUCTIONTOTAL, float PRDT, float GAPRDT, float NETSALARY) {
        this.EMPID = EMPID;
        this.EMPFULLNAME = EMPFULLNAME;
        this.SALARY = SALARY;
        this.TITLEDESCRIPTION = TITLEDESCRIPTION;
        this.CIVILTYPE = CIVILTYPE;
        this.PROFFESSION = PROFFESSION;
        this.PENSIONGOVACCRUAL = PENSIONGOVACCRUAL;
        this.FOOD = FOOD;
        this.LOCATION = LOCATION;
        this.HOUSE = HOUSE;
        this.TRANSPORT = TRANSPORT;
        this.AOTHER = AOTHER;
        this.ACCRUALTOTAL = ACCRUALTOTAL;
        this.AT = AT;
        this.PENSIONGOVDEDUCTION = PENSIONGOVDEDUCTION;
        this.TAX = TAX;
        this.PDEDUCTIONTOTAL = PDEDUCTIONTOTAL;
        this.PDT = PDT;
        this.FINE = FINE;
        this.WEAPONS = WEAPONS;
        this.UNIFORM = UNIFORM;
        this.CARCOLLISION = CARCOLLISION;
        this.TELEPHONE = TELEPHONE;
        this.ELECTRIC = ELECTRIC;
        this.GOTHER = GOTHER;
        this.GDEDUCTIONTOTAL = GDEDUCTIONTOTAL;
        this.GDT = GDT;
        this.FAMILLY = FAMILLY;
        this.SAVING = SAVING;
        this.SPORT = SPORT;
        this.CLUB = CLUB;
        this.HOSPITAL = HOSPITAL;
        this.NEWSPAPER = NEWSPAPER;
        this.DEVELOPMENTFUND = DEVELOPMENTFUND;
        this.LOAN = LOAN;
        this.OTHERLOAN = OTHERLOAN;
        this.SAVINGLOAN = SAVINGLOAN;
        this.SAVINGHOLLYDAYLOAN = SAVINGHOLLYDAYLOAN;
        this.SAVINGINTREST = SAVINGINTREST;
        this.PRDEDUCTIONTOTAL = PRDEDUCTIONTOTAL;
        this.PRDT = PRDT;
        this.GAPRDT = GAPRDT;
        this.NETSALARY = NETSALARY;
    }

    public ReportManager(String EMPID, String EMPFULLNAME, float SALARY, String TITLEDESCRIPTION, float PROFFESSION, float PENSIONGOVACCRUAL, float FOOD, float LOCATION, float HOUSE, float TRANSPORT, float AOTHER, float ACCRUALTOTAL, float AT, float PENSIONGOVDEDUCTION, float TAX, float PDEDUCTIONTOTAL, float PDT, float GAPRDT, float NETSALARY) {
        this.EMPID = EMPID;
        this.TITLEDESCRIPTION = TITLEDESCRIPTION;
        this.EMPFULLNAME = EMPFULLNAME;
        this.SALARY = SALARY;
        this.PROFFESSION = PROFFESSION;
        this.PENSIONGOVACCRUAL = PENSIONGOVACCRUAL;
        this.FOOD = FOOD;
        this.LOCATION = LOCATION;
        this.HOUSE = HOUSE;
        this.TRANSPORT = TRANSPORT;
        this.AOTHER = AOTHER;
        this.ACCRUALTOTAL = ACCRUALTOTAL;
        this.AT = AT;
        this.PENSIONGOVDEDUCTION = PENSIONGOVDEDUCTION;
        this.TAX = TAX;
        this.PDEDUCTIONTOTAL = PDEDUCTIONTOTAL;
        this.PDT = PDT;
        this.GAPRDT = GAPRDT;
        this.NETSALARY = NETSALARY;

    }

    public ReportManager(String EMPID, String EFULLNAME, String TDESCRIPTION, float FINE, float WEAPONS, float UNIFORM, float CARCOLLISION, float TELEPHONE, float ELECTRIC, float GOTHER, float GDEDUCTIONTOTAL, float GDT, float FAMILLY, float SAVING, float SPORT, float CLUB, float HOSPITAL, float NEWSPAPER, float DEVELOPMENTFUND, float LOAN, float OTHERLOAN, float SAVINGLOAN, float SAVINGHOLLYDAYLOAN, float SAVINGINTREST, float PRDEDUCTIONTOTAL, float PRDT) {
        this.EMPID = EMPID;
        this.TDESCRIPTION = TDESCRIPTION;
        this.EFULLNAME = EFULLNAME;
        this.FINE = FINE;
        this.WEAPONS = WEAPONS;
        this.UNIFORM = UNIFORM;
        this.CARCOLLISION = CARCOLLISION;
        this.TELEPHONE = TELEPHONE;
        this.ELECTRIC = ELECTRIC;
        this.GOTHER = GOTHER;
        this.GDEDUCTIONTOTAL = GDEDUCTIONTOTAL;
        this.GDT = GDT;
        this.FAMILLY = FAMILLY;
        this.SAVING = SAVING;
        this.SPORT = SPORT;
        this.CLUB = CLUB;
        this.HOSPITAL = HOSPITAL;
        this.NEWSPAPER = NEWSPAPER;
        this.DEVELOPMENTFUND = DEVELOPMENTFUND;
        this.LOAN = LOAN;
        this.OTHERLOAN = OTHERLOAN;
        this.SAVINGLOAN = SAVINGLOAN;
        this.SAVINGHOLLYDAYLOAN = SAVINGHOLLYDAYLOAN;
        this.SAVINGINTREST = SAVINGINTREST;
        this.PRDEDUCTIONTOTAL = PRDEDUCTIONTOTAL;
        this.PRDT = PRDT;
    }

    public ReportManager(String SALARYT, String PROFFESSIONT, String PENSIONGOVACCRUALT, String FOODT, String LOCATIONT, String HOUSET, String TRANSPORTT, String AOTHERT, String ACCRUALTOTALT, String ATT, String PENSIONGOVDEDUCTIONT, String TAXT, String PDEDUCTIONTOTALT, String PDTT, String FINET, String WEAPONST, String UNIFORMT, String CARCOLLISIONT, String TELEPHONET, String ELECTRICT, String GOTHERT, String GDEDUCTIONTOTALT, String GDTT, String FAMILLYT, String SAVINGT, String SPORTT, String CLUBT, String HOSPITALT, String NEWSPAPERT, String DEVELOPMENTFUNDT, String LOANT, String OTHERLOANT, String SAVINGLOANT, String SAVINGHOLLYDAYLOANT, String SAVINGINTRESTT, String PRDEDUCTIONTOTALT, String PRDTT, String GAPRDTT, String NETSALARYT) {
        this.SALARYT = SALARYT;
        this.PROFFESSIONT = PROFFESSIONT;
        this.PENSIONGOVACCRUALT = PENSIONGOVACCRUALT;
        this.FOODT = FOODT;
        this.LOCATIONT = LOCATIONT;
        this.HOUSET = HOUSET;
        this.TRANSPORTT = TRANSPORTT;
        this.AOTHERT = AOTHERT;
        this.ACCRUALTOTALT = ACCRUALTOTALT;
        this.ATT = ATT;
        this.PENSIONGOVDEDUCTIONT = PENSIONGOVDEDUCTIONT;
        this.TAXT = TAXT;
        this.PDEDUCTIONTOTALT = PDEDUCTIONTOTALT;
        this.PDTT = PDTT;
        this.FINET = FINET;
        this.WEAPONST = WEAPONST;
        this.UNIFORMT = UNIFORMT;
        this.CARCOLLISIONT = CARCOLLISIONT;
        this.TELEPHONET = TELEPHONET;
        this.ELECTRICT = ELECTRICT;
        this.GOTHERT = GOTHERT;
        this.GDEDUCTIONTOTALT = GDEDUCTIONTOTALT;
        this.GDTT = GDTT;
        this.FAMILLYT = FAMILLYT;
        this.SAVINGT = SAVINGT;
        this.SPORTT = SPORTT;
        this.CLUBT = CLUBT;
        this.HOSPITALT = HOSPITALT;
        this.NEWSPAPERT = NEWSPAPERT;
        this.DEVELOPMENTFUNDT = DEVELOPMENTFUNDT;
        this.LOANT = LOANT;
        this.OTHERLOANT = OTHERLOANT;
        this.SAVINGLOANT = SAVINGLOANT;
        this.SAVINGHOLLYDAYLOANT = SAVINGHOLLYDAYLOANT;
        this.SAVINGINTRESTT = SAVINGINTRESTT;
        this.PRDEDUCTIONTOTALT = PRDEDUCTIONTOTALT;
        this.PRDTT = PRDTT;
        this.GAPRDTT = GAPRDTT;
        this.NETSALARYT = NETSALARYT;
    }
    String strLocation = "A:\\HOPRREPORTS\\Employee\\FPLOG.jpg";
    File logoLogcation = new File(strLocation);

    public ReportManager(byte[] photobinary) {
        this.FPLOGO = photobinary;
    }

    public static byte[] extractByteArray(File file) {//read the byte information of the image.
        FileInputStream fileInputStream = null;
        byte[] byteFile = null;
        try {

            int len = 0;
            fileInputStream = new FileInputStream(file);
            InputStream inputStream = fileInputStream;
            len = inputStream.available();
            byteFile = new byte[len];
            inputStream.read(byteFile, 0, len);

        } catch (Exception ex) {
        } finally {
            try {
                fileInputStream.close();
            } catch (Exception ex) {
            }
        }
        return byteFile;
    }

    /**
     * <p>The following method round two decimal places of the given number. </p>
     * @return temp/p
     */
    public static float Round(float Rval, int Rpl) {
        float p = (float) Math.pow(10, Rpl);
        Rval = Rval * p;
        float tmp = Math.round(Rval);
        return (float) tmp / p;
    }

    public ReportManager(String EMPID, String FIRSTNAME, String MIDDLENAME, String LASTNAME, String EMPFULLNAME, String EFULLNAME, float SALARY, String TITLEDESCRIPTION, String TDESCRIPTION, String CIVILTYPE, float PROFFESSION, float PENSIONGOVACCRUAL, float FOOD, float LOCATION, float HOUSE, float TRANSPORT, float AOTHER, float ACCRUALTOTAL, float AT, float PENSIONGOVDEDUCTION, float TAX, float PDEDUCTIONTOTAL, float PDT, float FINE, float WEAPONS, float UNIFORM, float CARCOLLISION, float TELEPHONE, float ELECTRIC, float GOTHER, float GDEDUCTIONTOTAL, float GDT, float FAMILLY, float SAVING, float SPORT, float CLUB, float HOSPITAL, float NEWSPAPER, float DEVELOPMENTFUND, float LOAN, float OTHERLOAN, float SAVINGLOAN, float SAVINGHOLLYDAYLOAN, float SAVINGINTREST, float PRDEDUCTIONTOTAL, float PRDT, float GAPRDT, float NETSALARY, byte[] photobinary, ImageIcon MPIMG, String SALARYT, String PROFFESSIONT, String PENSIONGOVACCRUALT, String FOODT, String LOCATIONT, String HOUSET, String TRANSPORTT, String AOTHERT, String ACCRUALTOTALT, String ATT, String PENSIONGOVDEDUCTIONT, String TAXT, String PDEDUCTIONTOTALT, String PDTT, String FINET, String WEAPONST, String UNIFORMT, String CARCOLLISIONT, String TELEPHONET, String ELECTRICT, String GOTHERT, String GDEDUCTIONTOTALT, String GDTT, String FAMILLYT, String SAVINGT, String SPORTT, String CLUBT, String HOSPITALT, String NEWSPAPERT, String DEVELOPMENTFUNDT, String LOANT, String OTHERLOANT, String SAVINGLOANT, String SAVINGHOLLYDAYLOANT, String SAVINGINTRESTT, String PRDEDUCTIONTOTALT, String PRDTT, String GAPRDTT, String NETSALARYT) {
        this.EMPID = EMPID;
        this.FIRSTNAME = FIRSTNAME;
        this.MIDDLENAME = MIDDLENAME;
        this.LASTNAME = LASTNAME;
        this.EMPFULLNAME = EMPFULLNAME;
        this.EFULLNAME = EFULLNAME;
        this.SALARY = SALARY;
        this.TITLEDESCRIPTION = TITLEDESCRIPTION;
        this.TDESCRIPTION = TDESCRIPTION;
        this.CIVILTYPE = CIVILTYPE;
        this.PROFFESSION = PROFFESSION;
        this.PENSIONGOVACCRUAL = PENSIONGOVACCRUAL;
        this.FOOD = FOOD;
        this.LOCATION = LOCATION;
        this.HOUSE = HOUSE;
        this.TRANSPORT = TRANSPORT;
        this.AOTHER = AOTHER;
        this.ACCRUALTOTAL = ACCRUALTOTAL;
        this.AT = AT;
        this.PENSIONGOVDEDUCTION = PENSIONGOVDEDUCTION;
        this.TAX = TAX;
        this.PDEDUCTIONTOTAL = PDEDUCTIONTOTAL;
        this.PDT = PDT;
        this.FINE = FINE;
        this.WEAPONS = WEAPONS;
        this.UNIFORM = UNIFORM;
        this.CARCOLLISION = CARCOLLISION;
        this.TELEPHONE = TELEPHONE;
        this.ELECTRIC = ELECTRIC;
        this.GOTHER = GOTHER;
        this.GDEDUCTIONTOTAL = GDEDUCTIONTOTAL;
        this.GDT = GDT;
        this.FAMILLY = FAMILLY;
        this.SAVING = SAVING;
        this.SPORT = SPORT;
        this.CLUB = CLUB;
        this.HOSPITAL = HOSPITAL;
        this.NEWSPAPER = NEWSPAPER;
        this.DEVELOPMENTFUND = DEVELOPMENTFUND;
        this.LOAN = LOAN;
        this.OTHERLOAN = OTHERLOAN;
        this.SAVINGLOAN = SAVINGLOAN;
        this.SAVINGHOLLYDAYLOAN = SAVINGHOLLYDAYLOAN;
        this.SAVINGINTREST = SAVINGINTREST;
        this.PRDEDUCTIONTOTAL = PRDEDUCTIONTOTAL;
        this.PRDT = PRDT;
        this.GAPRDT = GAPRDT;
        this.NETSALARY = NETSALARY;
        this.photobinary = photobinary;
        this.MPIMG = MPIMG;
        this.SALARYT = SALARYT;
        this.PROFFESSIONT = PROFFESSIONT;
        this.PENSIONGOVACCRUALT = PENSIONGOVACCRUALT;
        this.FOODT = FOODT;
        this.LOCATIONT = LOCATIONT;
        this.HOUSET = HOUSET;
        this.TRANSPORTT = TRANSPORTT;
        this.AOTHERT = AOTHERT;
        this.ACCRUALTOTALT = ACCRUALTOTALT;
        this.ATT = ATT;
        this.PENSIONGOVDEDUCTIONT = PENSIONGOVDEDUCTIONT;
        this.TAXT = TAXT;
        this.PDEDUCTIONTOTALT = PDEDUCTIONTOTALT;
        this.PDTT = PDTT;
        this.FINET = FINET;
        this.WEAPONST = WEAPONST;
        this.UNIFORMT = UNIFORMT;
        this.CARCOLLISIONT = CARCOLLISIONT;
        this.TELEPHONET = TELEPHONET;
        this.ELECTRICT = ELECTRICT;
        this.GOTHERT = GOTHERT;
        this.GDEDUCTIONTOTALT = GDEDUCTIONTOTALT;
        this.GDTT = GDTT;
        this.FAMILLYT = FAMILLYT;
        this.SAVINGT = SAVINGT;
        this.SPORTT = SPORTT;
        this.CLUBT = CLUBT;
        this.HOSPITALT = HOSPITALT;
        this.NEWSPAPERT = NEWSPAPERT;
        this.DEVELOPMENTFUNDT = DEVELOPMENTFUNDT;
        this.LOANT = LOANT;
        this.OTHERLOANT = OTHERLOANT;
        this.SAVINGLOANT = SAVINGLOANT;
        this.SAVINGHOLLYDAYLOANT = SAVINGHOLLYDAYLOANT;
        this.SAVINGINTRESTT = SAVINGINTRESTT;
        this.PRDEDUCTIONTOTALT = PRDEDUCTIONTOTALT;
        this.PRDTT = PRDTT;
        this.GAPRDTT = GAPRDTT;
        this.NETSALARYT = NETSALARYT;
    }

    /**
     * <P>Load list of payrollcodes</P>
     * @param department
     * @param top
     * @return
     */
//    public ArrayList<SelectItem> selectPayrollCode(String department, int top) {
//        ArrayList<SelectItem> _list = new ArrayList<SelectItem>();
//        try {
//            OracleCachedRowSet _rs = new OracleCachedRowSet();
//            _rs = reportEntity.selectPayrollCode(department, top);
//            if (_rs.size() > 0) {
//                while (_rs.next()) {
//                    _list.add(new Option(String.valueOf(_rs.getString("PAYROLL_CODE")), String.valueOf(_rs.getString("PAYROLL_CODE"))));
//                }
//                _list.add(0, new Option(0, "-- Select PayrollCode --"));
//            } else {
//                _list.add(0, new Option(0, "No PayrollCode Avilabel"));
//            }
//            return _list;
//
//        } catch (Exception ex) {
//            return null;
//        }
//    }


    public List<ReportManager> loadCompanyLogo() {//load the image information and pass as list object to the interface
        List list = new ArrayList();
        try {
            setFPLOGO(extractByteArray(logoLogcation));
            ReportManager logo = new ReportManager(getFPLOGO());
            list.add(logo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

//    public HashMap readDepartmentPathDescription(String departmentName, String departnementId, String employeeId) {
//        try {
//            OracleCachedRowSet ocrs = new OracleCachedRowSet();
//            HashMap hm = new HashMap();
//            if (departmentName.equalsIgnoreCase("maindepartment")) {
//                ocrs = reportEntity.readDepartmentPathDescription(departmentName, departnementId, employeeId);
//                if (ocrs.next()) {
//                    hm.put("DEPARTMENT", ocrs.getString("DEP_DESCRIPTION"));
//                }
//            } else if (departmentName.equalsIgnoreCase("directorate")) {
//                ocrs = reportEntity.readDepartmentPathDescription(departmentName, departnementId, employeeId);
//                if (ocrs.next()) {
//                    hm.put("DEPARTMENT", ocrs.getString("MAINDEPARTMENT") + " | " + ocrs.getString("DIRECTORATE"));
//                }
//            } else if (departmentName.equalsIgnoreCase("division")) {
//                ocrs = reportEntity.readDepartmentPathDescription(departmentName, departnementId, employeeId);
//                if (ocrs.next()) {
//                    hm.put("DEPARTMENT", ocrs.getString("MAINDEPARTMENT") + " | " + ocrs.getString("DIRECTORATE") + " " + ocrs.getString("DIVISION"));
//                }
//            } else if (departmentName.equalsIgnoreCase("COOPERATIVE")) {
//                ocrs = reportEntity.readDepartmentPathDescription(departmentName, departnementId, employeeId);
//                if (ocrs.next()) {
//                    hm.put("DEPARTMENT", ocrs.getString("MAINDEPARTMENT") + " | " + ocrs.getString("DIRECTORATE") + " | " + ocrs.getString("DIVISION") + " | " + ocrs.getString("MASTEBABRIYA"));
//                }
//            } else if (departmentName.equalsIgnoreCase("team")) {
//                ocrs = reportEntity.readDepartmentPathDescription(departmentName, departnementId, employeeId);
//                if (ocrs.next()) {
//                    hm.put("DEPARTMENT", ocrs.getString("MAINDEPARTMENT") + " | " + ocrs.getString("DIRECTORATE") + " | " + ocrs.getString("DIVISION") + " | " + ocrs.getString("MASTEBABRIYA") + " " + ocrs.getString("TEAM"));
//                }
//            }
//            return hm;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return null;
//        }
//    }
    public String loadSalaryDelegatedInfo(String employeeId, String date) {
        try {
            return reportEntity.loadSalaryDelegatedInfo(employeeId, date);
        } catch (Exception ex) {
            return null;
        } finally {
            try {
            } catch (Exception ex) {
            }
        }
    }

    public List loadPaySlipAccrualsAndPersonal(String payrollCode, String currentDate) throws SQLException {
        OracleCachedRowSet _rs = new OracleCachedRowSet();
        int subReportCounter1 = 1;
        List subList = new ArrayList();//hold the variable loadAccrualAndPersonal.
        try {
            _rs = reportEntity.LoadPayroll(payrollCode, currentDate);
            while (_rs.next()) {
                HashMap subMap = new HashMap();
                subMap.put("ROWCOUNT1", subReportCounter1);
                subMap.put("EMPID", _rs.getString("EMP_ID"));
                subMap.put("DELEGATEDFULLNAME", loadSalaryDelegatedInfo(_rs.getString("EMP_ID"), currentDate));
                subMap.put("EMPFULLNAME", _rs.getString("FIRST_NAME") + " " + _rs.getString("MIDDLE_NAME") + " " + _rs.getString("LAST_NAME"));
                subMap.put("SALARY", Float.valueOf(_rs.getString("SALARY")));
                subMap.put("TITLEDESCRIPTION", _rs.getString("TITLE_DESCRIPTION"));
                subMap.put("DIRECTOR", Round(Float.valueOf(_rs.getString("DIRECTOR")), 2));
                subMap.put("PROFFESSION", Round(Float.valueOf(_rs.getString("PROFFESSION")), 2));
                subMap.put("PENSIONGOVACCRUAL", Round((Float.valueOf(_rs.getString("SALARY")) * Float.valueOf(_rs.getString("P_G_ACCRUAL"))) / 100, 2));
                subMap.put("FOOD", Round(Float.valueOf(_rs.getString("FOOD")), 2));
                subMap.put("LOCATION", Round(Float.valueOf(_rs.getString("LOCATION")), 2));
                subMap.put("HOUSE", Round(Float.valueOf(_rs.getString("HOUSE")), 2));
                subMap.put("TRANSPORT", Round(Float.valueOf(_rs.getString("TRANSPORT")), 2));
                String[] salaryCollected = _rs.getString("SALARYOTHER").toString().split("-");
                String sCollected = salaryCollected[0];
                subMap.put("SALARYOTHER", Float.valueOf(sCollected));
                String[] professionCollected = _rs.getString("PROFFESION_OTHER").toString().split("-");
                String pCollected = professionCollected[0];
                subMap.put("PROFFESIONOTHER", Round(Float.valueOf(pCollected), 2));
                subMap.put("ACCRUALTOTAL", Round(Float.valueOf(_rs.getString("ACCRUAL_TOTAL")), 2));
                subMap.put("AT", Round(Float.valueOf(_rs.getString("AT")), 2));

                subMap.put("PENSIONGOVDEDUCTION", Round((Float.valueOf(_rs.getString("SALARY")) * Float.valueOf(_rs.getString("P_P_DEDUCTION"))) / 100, 2));

                subMap.put("TAX", Round(((Float.valueOf(_rs.getString("SALARY")) + Float.valueOf(_rs.getString("SALARY_COLLECTED")) + Float.valueOf(_rs.getString("PROFESSION_COLLECTED"))) * Float.valueOf(_rs.getString("TAX")) / 100) - Float.valueOf(_rs.getString("CONSTANT_VALUE")), 2));

                subMap.put("PDEDUCTIONTOTAL", Round(Float.valueOf(_rs.getString("PDEDUCTIONTOTAL")), 2));

                subMap.put("PDT", Round(Float.valueOf(_rs.getString("PDT")), 2));

                subMap.put("GAPRDT", Round(Float.valueOf(Float.valueOf(_rs.getString("GDEDUCTIONTOTAL")) + Float.valueOf(_rs.getString("PR_DEDUCTION_TOTAL"))), 2));

                subMap.put("NETSALARY", Round(Float.valueOf((((Float.valueOf(_rs.getString("SALARY")) + Float.valueOf(_rs.getString("ACCRUAL_TOTAL"))) - Float.valueOf(_rs.getString("PDEDUCTIONTOTAL")))) - (Float.valueOf(Float.valueOf(_rs.getString("GDEDUCTIONTOTAL")) + Float.valueOf(_rs.getString("PR_DEDUCTION_TOTAL"))))), 2));

                subList.add(subMap);
                subReportCounter1++;
            }
            return subList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public List loadPaySlipPrivateAndGovernment(String payrollCode) throws SQLException {
        OracleCachedRowSet _rs = new OracleCachedRowSet();
        int subReportCounter2 = 1;
        List subList = new ArrayList();//hold the variable loadprivateAndGovernment.
        try {
            _rs = reportEntity.LoadPayroll2(payrollCode);
            while (_rs.next()) {
                HashMap subMap = new HashMap();
                subMap.put("ROWCOUNT2", subReportCounter2);
                subMap.put("EMPLOYEEID", _rs.getString("EMP_ID"));
                subMap.put("EFULLNAME", _rs.getString("FIRST_NAME") + " " + _rs.getString("MIDDLE_NAME") + " " + _rs.getString("LAST_NAME"));
                subMap.put("TDESCRIPTION", _rs.getString("TITLE_DESCRIPTION"));
                subMap.put("FINE", Float.valueOf(_rs.getString("FINE")));
                subMap.put("WEAPONS", Float.valueOf(_rs.getString("WEAPONS")));
                subMap.put("UNIFORM", Float.valueOf(_rs.getString("UNIFORM")));
                subMap.put("CARCOLLISION", Float.valueOf(_rs.getString("CAR_COLLISION")));
                subMap.put("TELEPHONE", Float.valueOf(_rs.getString("TELEPHONE")));
                subMap.put("ELECTRIC", Float.valueOf(_rs.getString("ELECTRIC")));
                subMap.put("GOTHER", Float.valueOf(_rs.getString("GOTHER")));
                subMap.put("GDEDUCTIONTOTAL", Float.valueOf(_rs.getString("GDEDUCTIONTOTAL")));
                subMap.put("GDT", Float.valueOf(_rs.getString("GDT")));
                subMap.put("FAMILLY", Float.valueOf(_rs.getString("FAMILLY")));
                subMap.put("SAVING", Float.valueOf(_rs.getString("SAVING")));
                subMap.put("SPORT", Float.valueOf(_rs.getString("SPORT")));
                subMap.put("CLUB", Float.valueOf(_rs.getString("CLUB")));
                subMap.put("HOSPITAL", Float.valueOf(_rs.getString("HOSPITAL")));
                subMap.put("NEWSPAPER", Float.valueOf(_rs.getString("NEWS_PAPER")));
                subMap.put("DEVELOPMENTFUND", Float.valueOf(_rs.getString("DEVELOPMENT_FUND")));
                subMap.put("LOAN", Float.valueOf(_rs.getString("LOAN")));
                subMap.put("OTHERLOAN", Float.valueOf(_rs.getString("OTHER_LOAN")));
                subMap.put("SAVINGLOAN", Float.valueOf(_rs.getString("SAVING_LOAN")));
                subMap.put("SAVINGHOLLYDAYLOAN", Float.valueOf(_rs.getString("SAVING_HOLLYDAY_LOAN")));
                subMap.put("SAVINGINTREST", Float.valueOf(_rs.getString("SAVING_INTREST")));
                subMap.put("PRDEDUCTIONTOTAL", Float.valueOf(_rs.getString("PR_DEDUCTION_TOTAL")));
                subMap.put("PRDT", Round((Float.valueOf(_rs.getString("PRDT"))), 2));
                subList.add(subMap);
                subReportCounter2++;

            }
            return subList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public Collection LoadPayrollSummeryReportSingle(String payrollCode) throws SQLException {
        List<HashMap> results = null;
        results = new ArrayList<HashMap>();
        HashMap hm = new HashMap();
        String strFullName = "";
        String strTitleDescription = "";
        float fltGrossSalary = 0.00F;
        float fltDirector = 0.00F;
        float fltProfession = 0.00F;
        float fltGovernmentPensionAccrual = 0.00F;
        float fltFood = 0.00F;
        float fltLocation = 0.00F;
        float fltHouse = 0.00F;
        float fltTransport = 0.00F;
        float fltSalaryOther = 0.00F;
        float fltProfession_Other = 0.00F;
        float fltAccrualTotal = 0.00F;
        float fltTotal = 0.00F;
        float fltPensionDeduction = 0.00F;
        float fltTax = 0.00F;
        float fltDeductionTotal = 0.00F;
        float fltCorrectedSum = 0.00F;
        float fltGovernmentDeductions = 0.00F;
        float fltPrivateDeductions = 0.00F;
        float fltGovernmentAndPrivateDeduction = 0.00F;
        float fltNetSalary = 0.00F;
        OracleCachedRowSet ocrs = new OracleCachedRowSet();
        try {
            ocrs = reportEntity.LoadPayrollSummeryReportSingle(payrollCode);
            while (ocrs.next()) {
                strTitleDescription = ocrs.getString("TITLE_DESCRIPTION");
                strFullName = ocrs.getString("FIRST_NAME") + " " + ocrs.getString("MIDDLE_NAME") + " " + ocrs.getString("LAST_NAME");
                fltGrossSalary += Round(Float.valueOf(ocrs.getString("GROSSSALARY")), 2);
                fltDirector += Round(Float.valueOf(ocrs.getString("DIRECTOR")), 2);
                fltProfession += Round(Float.valueOf(ocrs.getString("PROFFESSION")), 2);
                //must be converted the %
                fltGovernmentPensionAccrual += Round(Float.valueOf(ocrs.getString("GROSSSALARY")), 2) * Round(Float.valueOf(ocrs.getString("GEVERNMENTPENSIONACCRUAL")) / 100, 2);
                fltFood += Round(Float.valueOf(ocrs.getString("FOOD")), 2);
                //must be converted the %
                fltLocation += Round(Float.valueOf(ocrs.getString("GROSSSALARY")), 2) * Round(Float.valueOf(ocrs.getString("LOCATION")) / 100, 2);
                fltHouse += Round(Float.valueOf(ocrs.getString("HOUSE")), 2);
                fltHouse += Round(Float.valueOf(ocrs.getString("TRANSPORT")), 2);
                fltSalaryOther += Round(Float.valueOf(ocrs.getString("SALARYOTHER")), 2);
                fltProfession_Other += Round(Float.valueOf(ocrs.getString("PROFFESION_OTHER")), 2);
                fltAccrualTotal += Round(Float.valueOf(ocrs.getString("ACCRUALTOTAL")), 2);
                //must be converted the %
                fltPensionDeduction += Round(Float.valueOf(ocrs.getString("GROSSSALARY")), 2) * Round(Float.valueOf(ocrs.getString("PENSIONDEDUCTION")) / 100, 2);
                //must be converted the %
                fltTax += Round(((Float.valueOf(ocrs.getString("GROSSSALARY")) + Float.valueOf(ocrs.getString("SALARY_COLLECTED")) + Float.valueOf(ocrs.getString("PROFESSION_COLLECTED"))) * Float.valueOf(ocrs.getString("TAX")) / 100) - Float.valueOf(ocrs.getString("CONSTANT_VALUE")), 2);
                fltDeductionTotal += Round(Float.valueOf(ocrs.getString("DEDUCTIONTOTAL")), 2);

                fltGovernmentDeductions += Round(Float.valueOf(ocrs.getString("GOVERNMENTDEDUCTION")), 2);
                fltPrivateDeductions += Round(Float.valueOf(ocrs.getString("PRIVATEDEDUCTION")), 2);

            }
            fltTotal = fltGrossSalary + fltAccrualTotal;
            fltCorrectedSum = fltTotal - fltDeductionTotal;
            fltGovernmentAndPrivateDeduction = fltPrivateDeductions + fltGovernmentDeductions;
            fltNetSalary = fltGrossSalary + fltAccrualTotal - (fltDeductionTotal + fltPrivateDeductions + fltGovernmentDeductions);
            hm.put("TITLEDESCRIPTION", strTitleDescription);
            hm.put("FULLNAME", strFullName);
            hm.put("GROSSSALARY", Round(fltGrossSalary, 2));
            hm.put("DIRECTOR", Round(fltDirector, 2));
            hm.put("PROFFESSION", Round(fltProfession, 2));
            hm.put("GEVERNMENTPENSIONACCRUAL", Round(fltGovernmentPensionAccrual, 2));
            hm.put("FOOD", Round(fltFood, 2));
            hm.put("LOCATION", Round(fltLocation, 2));
            hm.put("HOUSE", Round(fltHouse, 2));
            hm.put("TRANSPORT", Round(fltTransport, 2));
            hm.put("SALARYOTHER", Round(fltSalaryOther, 2));
            hm.put("PROFFESION_OTHER", Round(fltProfession_Other, 2));
            hm.put("ACCRUALTOTAL", Round(fltTotal, 2));
            //personal deduction
            hm.put("PENSIONDEDUCTION", Round(fltPensionDeduction, 2));
            hm.put("TAX", Round(fltTax, 2));
            hm.put("DEDUCTIONTOTAL", Round(fltDeductionTotal, 2));
            //corrected sum
            hm.put("CORRECTEDSUM", Round(fltCorrectedSum, 2));
            //private and government deduction total
            hm.put("GOVERNMENTANDPRIVATESUM", Round(fltGovernmentAndPrivateDeduction, 2));
            //netsalary total
            hm.put("NETSALARY", Round(fltNetSalary, 2));
            results.add(hm);
            return results;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<HashMap> LoadPayrollSummeryReportAll(String date, String payrollCode) throws SQLException {
        ArrayList<HashMap> results = new ArrayList<HashMap>();
        HashMap hm = new HashMap();
        String strFullName = "";
        String strTitleDescription = "";
        float fltGrossSalary = 0.00F;
        float fltDirector = 0.00F;
        float fltProfession = 0.00F;
        float fltGovernmentPensionAccrual = 0.00F;
        float fltFood = 0.00F;
        float fltLocation = 0.00F;
        float fltHouse = 0.00F;
        float fltTransport = 0.00F;
        float fltSalaryOther = 0.00F;
        float fltProfession_Other = 0.00F;
        float fltAccrualTotal = 0.00F;
        float fltTotal = 0.00F;
        float fltPensionDeduction = 0.00F;
        float fltTax = 0.00F;
        float fltDeductionTotal = 0.00F;
        float fltCorrectedSum = 0.00F;
        float fltGovernmentDeductions = 0.00F;
        float fltPrivateDeductions = 0.00F;
        float fltGovernmentAndPrivateDeduction = 0.00F;
        float fltNetSalary = 0.00F;
        OracleCachedRowSet ocrs = new OracleCachedRowSet();
        try {
            ocrs = reportEntity.LoadPayrollSummeryReportALL(date, payrollCode);
            while (ocrs.next()) {
                strTitleDescription = ocrs.getString("TITLE_DESCRIPTION");
                strFullName = ocrs.getString("FIRST_NAME") + " " + ocrs.getString("MIDDLE_NAME") + " " + ocrs.getString("LAST_NAME");
                fltGrossSalary += Round(Float.valueOf(ocrs.getString("GROSSSALARY")), 2);
                fltDirector += Round(Float.valueOf(ocrs.getString("DIRECTOR")), 2);
                fltProfession += Round(Float.valueOf(ocrs.getString("PROFFESSION")), 2);
                //must be converted the %
                fltGovernmentPensionAccrual += Round(Float.valueOf(ocrs.getString("GROSSSALARY")), 2) * Round(Float.valueOf(ocrs.getString("GEVERNMENTPENSIONACCRUAL")) / 100, 2);
                fltFood += Round(Float.valueOf(ocrs.getString("FOOD")), 2);
                //must be converted the %
                fltLocation += Round(Float.valueOf(ocrs.getString("GROSSSALARY")), 2) * Round(Float.valueOf(ocrs.getString("LOCATION")) / 100, 2);
                fltHouse += Round(Float.valueOf(ocrs.getString("HOUSE")), 2);
                fltHouse += Round(Float.valueOf(ocrs.getString("TRANSPORT")), 2);
                fltSalaryOther += Round(Float.valueOf(ocrs.getString("SALARYOTHER")), 2);
                fltProfession_Other += Round(Float.valueOf(ocrs.getString("PROFFESION_OTHER")), 2);
                fltAccrualTotal += Round(Float.valueOf(ocrs.getString("ACCRUALTOTAL")), 2);
                //must be converted the %
                fltPensionDeduction += Round(Float.valueOf(ocrs.getString("GROSSSALARY")), 2) * Round(Float.valueOf(ocrs.getString("PENSIONDEDUCTION")) / 100, 2);
                //must be converted the %
                fltTax += Round(((Float.valueOf(ocrs.getString("GROSSSALARY")) + Float.valueOf(ocrs.getString("SALARY_COLLECTED")) + Float.valueOf(ocrs.getString("PROFESSION_COLLECTED"))) * Float.valueOf(ocrs.getString("TAX")) / 100) - Float.valueOf(ocrs.getString("CONSTANT_VALUE")), 2);
                fltDeductionTotal += Round(Float.valueOf(ocrs.getString("DEDUCTIONTOTAL")), 2);

                fltGovernmentDeductions += Round(Float.valueOf(ocrs.getString("GOVERNMENTDEDUCTION")), 2);
                fltPrivateDeductions += Round(Float.valueOf(ocrs.getString("PRIVATEDEDUCTION")), 2);

            }
            fltTotal = fltGrossSalary + fltAccrualTotal;
            fltCorrectedSum = fltTotal - fltDeductionTotal;
            fltGovernmentAndPrivateDeduction = fltPrivateDeductions + fltGovernmentDeductions;
            fltNetSalary = fltGrossSalary + fltAccrualTotal - (fltDeductionTotal + fltPrivateDeductions + fltGovernmentDeductions);
            hm.put("TITLEDESCRIPTION", strTitleDescription);
            hm.put("FULLNAME", strFullName);
            hm.put("GROSSSALARY", Round(fltGrossSalary, 2));
            hm.put("DIRECTOR", Round(fltDirector, 2));
            hm.put("PROFFESSION", Round(fltProfession, 2));
            hm.put("GEVERNMENTPENSIONACCRUAL", Round(fltGovernmentPensionAccrual, 2));
            hm.put("FOOD", Round(fltFood, 2));
            hm.put("LOCATION", Round(fltLocation, 2));
            hm.put("HOUSE", Round(fltHouse, 2));
            hm.put("TRANSPORT", Round(fltTransport, 2));
            hm.put("SALARYOTHER", Round(fltSalaryOther, 2));
            hm.put("PROFFESION_OTHER", Round(fltProfession_Other, 2));
            hm.put("ACCRUALTOTAL", Round(fltTotal, 2));
            //personal deduction
            hm.put("PENSIONDEDUCTION", Round(fltPensionDeduction, 2));
            hm.put("TAX", Round(fltTax, 2));
            hm.put("DEDUCTIONTOTAL", Round(fltDeductionTotal, 2));
            //corrected sum
            hm.put("CORRECTEDSUM", Round(fltCorrectedSum, 2));
            //private and government deduction total
            hm.put("GOVERNMENTANDPRIVATESUM", Round(fltGovernmentAndPrivateDeduction, 2));
            //netsalary total
            hm.put("NETSALARY", Round(fltNetSalary, 2));
            results.add(hm);
            return results;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Set<HashMap> LoadPayrollSummeryReportCodes(String date) {
        try {
            Set<HashMap> setHm = new HashSet<HashMap>();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs = reportEntity.LoadPayrollSummeryReportCode(date);
            while (ocrs.next()) {
                HashMap hm = new HashMap();
                hm.put("payrollCode", ocrs.getString("PAYROLL_CODE"));
                hm.put("assignedEmployee", ocrs.getString("ASSIGNED_EMPLOYEE"));
                setHm.add(hm);
            }
            return setHm;
        } catch (Exception ex) {
            return null;
        }
    }

    public Collection loadFamilyReport(String payrollCode) throws SQLException {
        List<HashMap> results = null;
        results = new ArrayList<HashMap>();
        OracleCachedRowSet ocrs = new OracleCachedRowSet();
        try {
            ocrs = reportEntity.loadFamilyReort(payrollCode);
            while (ocrs.next()) {
                HashMap list = new HashMap();
                list.put("EMPLOYEE_ID", ocrs.getString("EMPLOYEE_ID"));
                list.put("EMPLOYEE_FULL_NAME", ocrs.getString("EMPLOYEE_FULL_NAME"));
                list.put("FAMILY_ID", ocrs.getString("FAMILY_ID"));
                list.put("FAMILY_FULL_NAME", ocrs.getString("FAMILY_FULL_NAME"));
                list.put("AMOUNT", Float.valueOf(ocrs.getString("AMOUNT")));
                results.add(list);
            }
            return results;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public ArrayList<HashMap> loadEmployeesFundSummery(String payrollCode) throws SQLException {
        ArrayList<HashMap> results = null;
        results = new ArrayList<HashMap>();
        OracleCachedRowSet ocrs = new OracleCachedRowSet();
        try {
            ocrs = reportEntity.loadEmployeesFundSummery(payrollCode);
            while (ocrs.next()) {
                HashMap list = new HashMap();
                list.put("EMPLOYEE_ID", ocrs.getString("EMPLOYEE_ID"));
                list.put("EMPLOYEE_FULL_NAME", ocrs.getString("EMPLOYEE_FULL_NAME"));
                list.put("TOTAL", ocrs.getString("TOTAL"));
                results.add(list);
            }
            return results;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<HashMap> loadFundReportSummery(String payrollCode) throws SQLException {
        ArrayList<HashMap> results = null;
        results = new ArrayList<HashMap>();
        OracleCachedRowSet ocrs = new OracleCachedRowSet();
        try {
            ocrs = reportEntity.loadFundReportSummery(payrollCode);
            while (ocrs.next()) {
                HashMap list = new HashMap();
                if (ocrs.getString("ASSOCIATION_ID").equalsIgnoreCase("1")) {
                    list.put("Tigray", ocrs.getString("TOTAL"));
                }
                if (ocrs.getString("ASSOCIATION_ID").equalsIgnoreCase("2")) {
                    list.put("Afar", ocrs.getString("TOTAL"));
                }
                if (ocrs.getString("ASSOCIATION_ID").equalsIgnoreCase("3")) {
                    list.put("Amara", ocrs.getString("TOTAL"));
                }
                if (ocrs.getString("ASSOCIATION_ID").equalsIgnoreCase("4")) {
                    list.put("Oromiya", ocrs.getString("TOTAL"));
                }
                if (ocrs.getString("ASSOCIATION_ID").equalsIgnoreCase("5")) {
                    list.put("Somaliya", ocrs.getString("TOTAL"));
                }
                if (ocrs.getString("ASSOCIATION_ID").equalsIgnoreCase("6")) {
                    list.put("BenshalgulGumuz", ocrs.getString("TOTAL"));
                }
                if (ocrs.getString("ASSOCIATION_ID").equalsIgnoreCase("7")) {
                    list.put("South", ocrs.getString("TOTAL"));
                }
                if (ocrs.getString("ASSOCIATION_ID").equalsIgnoreCase("8")) {
                    list.put("Gambela", ocrs.getString("TOTAL"));
                }
                if (ocrs.getString("ASSOCIATION_ID").equalsIgnoreCase("9")) {
                    list.put("Harer", ocrs.getString("TOTAL"));
                }
                if (ocrs.getString("ASSOCIATION_ID").equalsIgnoreCase("10")) {
                    list.put("Gurage", ocrs.getString("TOTAL"));
                }
                results.add(list);
            }
            return results;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<HashMap> loadFundReport(String payrollCode) throws SQLException {
        ArrayList<HashMap> hm = new ArrayList<HashMap>();
        OracleCachedRowSet ocrs = new OracleCachedRowSet();
        try {
            ocrs = reportEntity.loadFundReport(payrollCode);
            while (ocrs.next()) {
                HashMap list = new HashMap();
                if (ocrs.getString("ASSOCIATION_ID").equalsIgnoreCase("1")) {
                    list.put("FUNDNAME", "Tigray");
                } else if (ocrs.getString("ASSOCIATION_ID").equalsIgnoreCase("2")) {
                    list.put("FUNDNAME", "Afar");
                } else if (ocrs.getString("ASSOCIATION_ID").equalsIgnoreCase("3")) {
                    list.put("FUNDNAME", "Amara");
                } else if (ocrs.getString("ASSOCIATION_ID").equalsIgnoreCase("4")) {
                    list.put("FUNDNAME", "Oromiya");
                } else if (ocrs.getString("ASSOCIATION_ID").equalsIgnoreCase("5")) {
                    list.put("FUNDNAME", "Somaliya");
                } else if (ocrs.getString("ASSOCIATION_ID").equalsIgnoreCase("6")) {
                    list.put("FUNDNAME", "Benshalgul Gumuz");
                } else if (ocrs.getString("ASSOCIATION_ID").equalsIgnoreCase("7")) {
                    list.put("FUNDNAME", "South");
                } else if (ocrs.getString("ASSOCIATION_ID").equalsIgnoreCase("8")) {
                    list.put("FUNDNAME", "Gambela");
                } else if (ocrs.getString("ASSOCIATION_ID").equalsIgnoreCase("9")) {
                    list.put("FUNDNAME", "Harer");
                } else if (ocrs.getString("ASSOCIATION_ID").equalsIgnoreCase("10")) {
                    list.put("FUNDNAME", "Gurage");
                }
                list.put("AMOUNT", Float.valueOf(ocrs.getString("AMOUNT")));
                list.put("EMPLOYEE_ID", ocrs.getString("EMPLOYEE_ID"));
                list.put("EMPLOYEE_FULL_NAME", ocrs.getString("EMPLOYEE_FULL_NAME"));
                hm.add(list);
            }
            return hm;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public ArrayList<HashMap> loadRequestedMPDetail(String MPID) {
        ArrayList<HashMap> results = null;
        results = new ArrayList<HashMap>();


        try {
            requestedMPDitail(MPID);
            for (HashMap dHashMap : getFilteredData()) {
                HashMap hm = new HashMap();
                hm.put("EMP_ID", dHashMap.get("EMP_ID"));
                hm.put("FULL_NAME", dHashMap.get("FULL_NAME"));
                hm.put("DATE_MEMBERSHIP", dHashMap.get("DATE_MEMBERSHIP"));
                hm.put("DATE_OF_BIRTH", dHashMap.get("DATE_OF_BIRTH"));
                hm.put("NATION_CODE", dHashMap.get("NATION_CODE"));
                hm.put("MARITAL_STATUS", dHashMap.get("MARITAL_STATUS"));
                hm.put("SEX", dHashMap.get("SEX"));//REQUIRED_NO
                hm.put("PHOTO", dHashMap.get("PHOTO"));
                hm.put("RETIREMENT_NO", dHashMap.get("RETIREMENT_NO"));
                hm.put("NATIONALITY", dHashMap.get("NATIONALITY"));
                hm.put("TITLE", dHashMap.get("TITLE"));
                hm.put("PARTY", dHashMap.get("PARTY"));//REQUIRED_NO
                hm.put("ELECTION_ROUND", dHashMap.get("ELECTION_ROUND"));
                hm.put("ELECTION_STATION", dHashMap.get("ELECTION_STATION"));
                hm.put("FAM_FULL_NAME", dHashMap.get("FAM_FULL_NAME"));

                results.add(hm);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return results;

    }

    private ArrayList<HashMap> requestedMPDitail(String MPID) {
        try {
            OracleCachedRowSet data = new OracleCachedRowSet();
            data = reportEntity.loadMPMemberDetail(MPID);

            ArrayList<HashMap> hmArrayELT = new ArrayList<HashMap>();

            while (data.next()) {
                HashMap hashMapEL = new HashMap();

                hashMapEL.put("EMP_ID", data.getString("EMP_ID"));
                hashMapEL.put("FULL_NAME", data.getString("FIRST_NAME") + " " + data.getString("MIDDLE_NAME") + " " + data.getString("LAST_NAME"));
                hashMapEL.put("DATE_MEMBERSHIP", data.getString("DATE_MEMBERSHIP"));
                hashMapEL.put("DATE_OF_BIRTH", data.getString("DATE_OF_BIRTH"));
                hashMapEL.put("NATION_CODE", data.getString("DESCRIPTION"));
                hashMapEL.put("MARITAL_STATUS", data.getString("MARITAL_STATUS"));
                hashMapEL.put("SEX", data.getString("SEX"));
                MPIMG = new ImageIcon((byte[]) data.getBytes("PHOTO"));
                hashMapEL.put("PHOTO", MPIMG.getImage());
                hashMapEL.put("RETIREMENT_NO", data.getString("RETIREMENT_NO"));
                hashMapEL.put("NATIONALITY", data.getString("NATIONALITY"));
                hashMapEL.put("TITLE", data.getString("TITLE_DESCRIPTION"));
                hashMapEL.put("PARTY", data.getString("PARTY"));
                hashMapEL.put("ELECTION_ROUND", data.getString("ELECTION_ROUND"));
                hashMapEL.put("ELECTION_STATION", data.getString("ELECTION_STATION"));

                hmArrayELT.add(hashMapEL);

            }

            setFilteredData(hmArrayELT);
            return getFilteredData();

        } catch (Exception ex) {
            return null;
        }
    }

    public ArrayList<HashMap> loadRequestedMPFamDetail(String MPID) {
        ArrayList<HashMap> results = null;
        results = new ArrayList<HashMap>();


        try {
            requestedMPFamDitail(MPID);
            for (HashMap dHashMap : getFilteredData()) {
                HashMap hm = new HashMap();
                hm.put("EMP_ID", dHashMap.get("EMP_ID"));
                hm.put("FULL_NAME", dHashMap.get("FULL_NAME"));
                hm.put("RELATION_TYPE", dHashMap.get("RELATION_TYPE"));
                hm.put("DATE_OF_BIRTH", dHashMap.get("DATE_OF_BIRTH"));
                hm.put("HEIR", dHashMap.get("HEIR"));
                hm.put("EMERGENCEY_CONTACT", dHashMap.get("EMERGENCEY_CONTACT"));
                hm.put("SEX", dHashMap.get("SEX"));
                hm.put("PHOTO", dHashMap.get("PHOTO"));

                results.add(hm);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return results;

    }

    private ArrayList<HashMap> requestedMPFamDitail(String MPID) {
        try {
            OracleCachedRowSet data = new OracleCachedRowSet();
            data = reportEntity.loadMPMemberFamDetail(MPID);
            ArrayList<HashMap> hmArrayELT = new ArrayList<HashMap>();

            while (data.next()) {
                HashMap hashMapEL = new HashMap();

                hashMapEL.put("EMP_ID", data.getString("EMP_ID"));
                hashMapEL.put("FULL_NAME", data.getString("FIRST_NAME") + " " + data.getString("MIDDLE_NAME") + " " + data.getString("LAST_NAME"));
                hashMapEL.put("RELATION_TYPE", data.getString("RELATION_TYPE"));
                hashMapEL.put("DATE_OF_BIRTH", data.getString("DATE_OF_BIRTH"));
                hashMapEL.put("HEIR", data.getString("HEIR"));
                hashMapEL.put("EMERGENCEY_CONTACT", data.getString("EMERGENCEY_CONTACT"));
                hashMapEL.put("SEX", data.getString("SEX"));
                MPIMG = new ImageIcon((byte[]) data.getBytes("PHOTO"));
                hashMapEL.put("PHOTO", MPIMG.getImage());

                hmArrayELT.add(hashMapEL);

            }

            setFilteredData(hmArrayELT);
            return getFilteredData();

        } catch (Exception ex) {
            return null;
        }
    }

    public ArrayList<HashMap> loadRequestedMPAddressDetail(String MPID) {
        ArrayList<HashMap> results = null;
        results = new ArrayList<HashMap>();


        try {
            requestedMPAddressDitail(MPID);
            for (HashMap dHashMap : getFilteredData()) {
                HashMap hm = new HashMap();
                hm.put("EMP_ID", dHashMap.get("EMP_ID"));
                hm.put("ZONE", dHashMap.get("ZONE"));
                hm.put("WOREDA_OR_SUBCITY", dHashMap.get("WOREDA_OR_SUBCITY"));
                hm.put("KEBELE", dHashMap.get("KEBELE"));
                hm.put("HOUSE_NUMBER", dHashMap.get("HOUSE_NUMBER"));
                hm.put("TELEPHONE_RESIDENCE", dHashMap.get("TELEPHONE_RESIDENCE"));
                hm.put("TELEPHONE_OFFICE", dHashMap.get("TELEPHONE_OFFICE"));
                hm.put("MOBILE", dHashMap.get("MOBILE"));
                hm.put("REGION_ID", dHashMap.get("REGION_ID"));
                hm.put("ADDRESSTYPE", dHashMap.get("ADDRESSTYPE"));

                results.add(hm);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return results;

    }

    private ArrayList<HashMap> requestedMPAddressDitail(String MPID) {
        try {
            OracleCachedRowSet data = new OracleCachedRowSet();
            data = reportEntity.loadMPMemberAddressDetail(MPID);
            ArrayList<HashMap> hmArrayELT = new ArrayList<HashMap>();

            while (data.next()) {
                HashMap hashMapEL = new HashMap();

                hashMapEL.put("EMP_ID", data.getString("EMP_ID"));
                hashMapEL.put("ADDRESSTYPE", data.getString("ADDRESSTYPE"));
                hashMapEL.put("ZONE", data.getString("WOREDA_OR_SUBCITY_ID"));
                hashMapEL.put("WOREDA_OR_SUBCITY", data.getString("WOREDA_OR_SUBCITY"));
                hashMapEL.put("KEBELE", data.getString("KEBELE"));
                hashMapEL.put("HOUSE_NUMBER", data.getString("HOUSE_NUMBER"));
                hashMapEL.put("TELEPHONE_RESIDENCE", data.getString("TELEPHONE_RESIDENCE"));
                hashMapEL.put("TELEPHONE_OFFICE", data.getString("TELEPHONE_OFFICE"));
                hashMapEL.put("MOBILE", data.getString("MOBILE"));
                hashMapEL.put("REGION_ID", data.getString("REGION_ID"));

                hmArrayELT.add(hashMapEL);

            }

            setFilteredData(hmArrayELT);
            return getFilteredData();

        } catch (Exception ex) {
            return null;
        }
    }

    public ArrayList<HashMap> loadRequestedMPEducationDetail(String MPID) {
        ArrayList<HashMap> results = null;
        results = new ArrayList<HashMap>();


        try {
            requestedMPEducationDitail(MPID);
            for (HashMap dHashMap : getFilteredData()) {
                HashMap hm = new HashMap();
                hm.put("EMP_ID", dHashMap.get("EMP_ID"));
                hm.put("INSTITUTION", dHashMap.get("INSTITUTION"));
                hm.put("ELDESC", dHashMap.get("ELDESC"));
                hm.put("ETDESC", dHashMap.get("ETDESC"));
                hm.put("STARTING_DATE", dHashMap.get("STARTING_DATE"));
                hm.put("COMPLETION_DATE", dHashMap.get("COMPLETION_DATE"));
                hm.put("AWARD", dHashMap.get("AWARD"));
                hm.put("RESULT", dHashMap.get("RESULT"));

                results.add(hm);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return results;

    }

    private ArrayList<HashMap> requestedMPEducationDitail(String MPID) {
        try {
            OracleCachedRowSet data = new OracleCachedRowSet();
            data = reportEntity.loadMPMemberEducationDetail(MPID);
            ArrayList<HashMap> hmArrayELT = new ArrayList<HashMap>();

            while (data.next()) {
                HashMap hashMapEL = new HashMap();

                hashMapEL.put("EMP_ID", data.getString("EMP_ID"));
                hashMapEL.put("INSTITUTION", data.getString("INSTITUTION"));
                hashMapEL.put("ELDESC", data.getString("ELDESC"));
                hashMapEL.put("ETDESC", data.getString("ETDESC"));
                hashMapEL.put("STARTING_DATE", data.getString("STARTING_DATE"));
                hashMapEL.put("COMPLETION_DATE", data.getString("COMPLETION_DATE"));
                hashMapEL.put("AWARD", data.getString("AWARD"));
                hashMapEL.put("RESULT", data.getString("RESULT"));

                hmArrayELT.add(hashMapEL);

            }

            setFilteredData(hmArrayELT);
            return getFilteredData();

        } catch (Exception ex) {
            return null;
        }
    }

    public ArrayList<HashMap> loadRequestedMPLanguageDetail(String MPID) {
        ArrayList<HashMap> results = null;
        results = new ArrayList<HashMap>();


        try {
            requestedMPLanguageDitail(MPID);
            for (HashMap dHashMap : getFilteredData()) {
                HashMap hm = new HashMap();
                hm.put("EMP_ID", dHashMap.get("EMP_ID"));
                hm.put("LANGUAGE_CODE", dHashMap.get("LANGUAGE_CODE"));
                hm.put("READING", dHashMap.get("READING"));
                hm.put("WRITING", dHashMap.get("WRITING"));
                hm.put("SPEAKING", dHashMap.get("SPEAKING"));
                hm.put("LISTENING", dHashMap.get("LISTENING"));

                results.add(hm);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return results;

    }

    private ArrayList<HashMap> requestedMPLanguageDitail(String MPID) {
        try {
            OracleCachedRowSet data = new OracleCachedRowSet();
            data = reportEntity.loadMPMemberLanguageDetail(MPID);
            ArrayList<HashMap> hmArrayELT = new ArrayList<HashMap>();

            while (data.next()) {
                HashMap hashMapEL = new HashMap();

                hashMapEL.put("EMP_ID", data.getString("EMP_ID"));
                hashMapEL.put("LANGUAGE_CODE", data.getString("LANGUAGE_CODE"));
                hashMapEL.put("READING", data.getString("READING"));
                hashMapEL.put("WRITING", data.getString("WRITING"));
                hashMapEL.put("SPEAKING", data.getString("SPEAKING"));
                hashMapEL.put("LISTENING", data.getString("LISTENING"));

                hmArrayELT.add(hashMapEL);

            }

            setFilteredData(hmArrayELT);
            return getFilteredData();

        } catch (Exception ex) {
            return null;
        }
    }

    public ArrayList<HashMap> loadRequestedMPExperienceDetail(String MPID) {
        ArrayList<HashMap> results = null;
        results = new ArrayList<HashMap>();


        try {
            requestedMPExperienceDitail(MPID);
            for (HashMap dHashMap : getFilteredData()) {
                HashMap hm = new HashMap();
                hm.put("EMP_ID", dHashMap.get("EMP_ID"));
                hm.put("INSTITUION", dHashMap.get("INSTITUION"));
                hm.put("START_DATE", dHashMap.get("START_DATE"));
                hm.put("END_DATE", dHashMap.get("END_DATE"));
                hm.put("JOB_TITLE", dHashMap.get("JOB_TITLE"));
                hm.put("SALARY", dHashMap.get("SALARY"));
                hm.put("RANK", dHashMap.get("RANK"));
                hm.put("REASON_FOR_TERMINATION", dHashMap.get("REASON_FOR_TERMINATION"));

                results.add(hm);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return results;

    }

    private ArrayList<HashMap> requestedMPExperienceDitail(String MPID) {
        try {
            OracleCachedRowSet data = new OracleCachedRowSet();
            data = reportEntity.loadMPMemberExperienceDetail(MPID);
            ArrayList<HashMap> hmArrayELT = new ArrayList<HashMap>();

            while (data.next()) {
                HashMap hashMapEL = new HashMap();

                hashMapEL.put("EMP_ID", data.getString("EMP_ID"));
                hashMapEL.put("INSTITUION", data.getString("INSTITUION"));
                hashMapEL.put("START_DATE", data.getString("START_DATE"));
                hashMapEL.put("END_DATE", data.getString("END_DATE"));
                hashMapEL.put("JOB_TITLE", data.getString("JOB_TITLE"));
                hashMapEL.put("SALARY", data.getString("SALARY"));
                hashMapEL.put("RANK", data.getString("RANK"));
                hashMapEL.put("REASON_FOR_TERMINATION", data.getString("REASON_FOR_TERMINATION"));

                hmArrayELT.add(hashMapEL);

            }

            setFilteredData(hmArrayELT);
            return getFilteredData();

        } catch (Exception ex) {
            return null;
        }
    }

    public ArrayList<HashMap> loadMPMassReport(String query) {
        ArrayList<HashMap> results = null;
        results = new ArrayList<HashMap>();


        try {
            requestedMPMassReport(query);
            for (HashMap dHashMap : getFilteredData()) {
                HashMap hm = new HashMap();
                hm.put("SNO", dHashMap.get("SNO"));
                hm.put("EMP_ID", dHashMap.get("EMP_ID"));
                hm.put("FULL_NAME", dHashMap.get("FULL_NAME"));
                hm.put("DATE_MEMBERSHIP", dHashMap.get("DATE_MEMBERSHIP"));
                hm.put("DATE_OF_BIRTH", dHashMap.get("DATE_OF_BIRTH"));
                hm.put("NATION_CODE", dHashMap.get("NATION_CODE"));
                hm.put("MARITAL_STATUS", dHashMap.get("MARITAL_STATUS"));
                hm.put("SEX", dHashMap.get("SEX"));//REQUIRED_NO
//                hm.put("PHOTO", dHashMap.get("PHOTO"));
                hm.put("RETIREMENT_NO", dHashMap.get("RETIREMENT_NO"));
                hm.put("NATIONALITY", dHashMap.get("NATIONALITY"));
                hm.put("TITLE", dHashMap.get("TITLE"));
                hm.put("PARTY", dHashMap.get("PARTY"));//REQUIRED_NO
                hm.put("ELECTION_ROUND", dHashMap.get("ELECTION_ROUND"));
                hm.put("ELECTION_STATION", dHashMap.get("ELECTION_STATION"));
                hm.put("FAM_FULL_NAME", dHashMap.get("FAM_FULL_NAME"));

                results.add(hm);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return results;

    }

    private ArrayList<HashMap> requestedMPMassReport(String query) {
        try {
            int sno = 1;
            OracleCachedRowSet data = new OracleCachedRowSet();
            data = reportEntity.loadMPMassReport(query);
            ArrayList<HashMap> hmArrayELT = new ArrayList<HashMap>();

            while (data.next()) {
                HashMap hashMapEL = new HashMap();

                hashMapEL.put("SNO", String.valueOf(sno));
                hashMapEL.put("EMP_ID", data.getString("EMP_ID"));
                hashMapEL.put("FULL_NAME", data.getString("FIRST_NAME") + " " + data.getString("MIDDLE_NAME") + " " + data.getString("LAST_NAME"));
                hashMapEL.put("DATE_MEMBERSHIP", data.getString("DATE_MEMBERSHIP"));
                hashMapEL.put("DATE_OF_BIRTH", data.getString("DATE_OF_BIRTH"));
                hashMapEL.put("NATION_CODE", data.getString("DESCRIPTION"));
                hashMapEL.put("MARITAL_STATUS", data.getString("MARITAL_STATUS"));
                hashMapEL.put("SEX", data.getString("SEX"));
//                MPIMG = new ImageIcon((byte[]) data.getBytes("PHOTO"));
//                hashMapEL.put("PHOTO", MPIMG.getImage());
                hashMapEL.put("RETIREMENT_NO", data.getString("RETIREMENT_NO"));
                hashMapEL.put("NATIONALITY", data.getString("NATIONALITY"));
                hashMapEL.put("TITLE", data.getString("TITLE_DESCRIPTION"));
                hashMapEL.put("PARTY", data.getString("PARTY"));
                hashMapEL.put("ELECTION_ROUND", data.getString("ELECTION_ROUND"));
                hashMapEL.put("ELECTION_STATION", data.getString("ELECTION_STATION"));

                hmArrayELT.add(hashMapEL);
                sno++;

            }

            setFilteredData(hmArrayELT);
            return getFilteredData();

        } catch (Exception ex) {
            return null;
        }
    }
     /**
     * this method computes for the first date of the current month
     * @return returns thisYear + thisMonth + 01
     */
    public static String getThisMonthsFirstDate() {
        String _today = StringDateManipulation.toDayInGc();
        int MonthToday = StringDateManipulation.getMonth(_today);
        int YearToday = StringDateManipulation.getYear(_today);
        return YearToday + "-" + MonthToday + "-" + "01";
    }

    /**
     * this method computes for the first date of the current month
     * @return returns "01-" + thisMonth + "-" + thisYear
     */
    public static String getThisMonthsFirstDateEC() {
        String _today = StringDateManipulation.toDayInEc();
        Integer dateToday = StringDateManipulation.getDate(_today);
        Integer MonthToday = StringDateManipulation.getMonth(_today);
        Integer YearToday = StringDateManipulation.getYear(_today);
        return YearToday + "-" + MonthToday + "-" + dateToday;
    }

    /**
     * This method computes for the last date of the current month
     * @see #getThisYearsLastDate()
     * @return thisYear + thisMonth + thisMonthLastDay
     *
     */
    public static String getThisMonthsLastDate() {
        String _today = StringDateManipulation.toDayInGc();
        int YearToday = StringDateManipulation.getYear(_today);
        int MonthToday = StringDateManipulation.getMonth(_today);
        String monthLastDate = "30";
        if (MonthToday == 2) {
            if (YearToday % 4 == 0) {
                monthLastDate = "29";
            } else {
                monthLastDate = "28";
            }
        } else {
            int firstGrp[] = {1, 3, 5, 7, 8, 10, 12};
            int secondGrp[] = {4, 6, 9, 11};
            boolean notFound = true;
            for (int i = 0; i < secondGrp.length; i++) {
                if (MonthToday == secondGrp[i]) {
                    notFound = false;
                    monthLastDate = "30";
                    break;
                }
            }
            if (notFound) {
                for (int i = 0; i < firstGrp.length; i++) {
                    if (MonthToday == firstGrp[i]) {
                        notFound = false;
                        monthLastDate = "31";
                        break;
                    }
                }
            }
        }
        return YearToday + "-" + MonthToday + "-" + monthLastDate;
    }

    /**
     * this method computes for the last date of the current month
     * @see #getThisYearsLastDate()
     * @return returns "30-" + thisMonth + "-" + thisYear if month less than 13,
     * otherwise getThisYearsLastDate()
     */
    public static String getThisMonthsLastDateEC() {
        String _today = StringDateManipulation.toDayInEc();
        Integer dateToday = StringDateManipulation.getDate(_today);
        Integer YearToday = StringDateManipulation.getYear(_today);
        Integer MonthToday = StringDateManipulation.getMonth(_today);
        //int lastmonth=0;
        if (StringDateManipulation.getMonth(_today) <= 13) {
            if (MonthToday != 1) {
                MonthToday = MonthToday - 1;

            } else {
                if (dateToday <= 25) {
                    if ((YearToday % 4 == 0) && (YearToday % 100 != 0) || (YearToday % 400 == 0)) {
                        dateToday = (dateToday + 6) % 30;
                        if ((dateToday + 6) / 30 == 1) {
                            MonthToday = 13;
                            YearToday = YearToday - 1;
                        } else {
                            MonthToday = 13 - MonthToday;
                            YearToday = YearToday - 1;
                        }
                    } else {
                        dateToday = (dateToday + 5) % 30;
                        if ((dateToday + 5) / 30 == 1) {
                            MonthToday = 13;
                            YearToday = YearToday - 1;
                        } else {
                            MonthToday = 13 - MonthToday;
                            YearToday = YearToday - 1;
                        }
                    }
                } else {
                    if ((YearToday % 4 == 0) && (YearToday % 100 != 0) || (YearToday % 400 == 0)) {
                        dateToday = 5 - (30 - dateToday);
                        MonthToday = 13;
                        YearToday = YearToday - 1;
                    } else {
                        dateToday = 6 - (30 - dateToday);
                        MonthToday = 13;
                        YearToday = YearToday - 1;
                    }
                }

            }
        }
        return YearToday + "-" + MonthToday + "-" + dateToday;
    }

    /**
     * this method computes for the first date of the current month
     * @return returns "01-" + thisMonth + "-" + thisYear
     */
    public static String getThisWeekFirstDate() {
        String _today = StringDateManipulation.toDayInEc();
        String newdate = "";
        Integer Datetoday = StringDateManipulation.getDate(_today);
        if (String.valueOf(Datetoday).length() == 1) {
            newdate = "0" + String.valueOf(Datetoday);
        } else {
            newdate = String.valueOf(Datetoday);
        }
        return _today.split("-")[0] + "-" + _today.split("-")[1] + "-" + newdate;
    }



    /**
     * this method computes for the last date of the of the week after 7
     * is subtracted also subtracts the month of the current date is less than 7
     * @return the last day of the week

     */
    public static String getThisWeekLastDate() {

        String _today = StringDateManipulation.toDayInEc();
        Integer dateToday = StringDateManipulation.getDate(_today);
        Integer MonthToday = StringDateManipulation.getMonth(_today);

        Integer YearToday = StringDateManipulation.getYear(_today);
        if (dateToday <= 7 && MonthToday != 1) {
            dateToday = dateToday + 23;
            MonthToday = MonthToday - 1;
        } else if (MonthToday == 1) {
            if (dateToday < 3) {
                if (MonthToday + 12 == 13) {
                    if ((YearToday % 4 == 0) && (YearToday % 100 != 0) || (YearToday % 400 == 0)) {
                        dateToday = 23 + 6 + dateToday;
                        MonthToday = MonthToday + 12;
                        YearToday = YearToday - 1;
                    } else {
                        dateToday = 23 + 5 + dateToday;
                        MonthToday = MonthToday + 12;
                        YearToday = YearToday - 1;
                    }
                }
            } else if (dateToday >= 3 && dateToday <= 7) {
                if (MonthToday + 12 == 13) {
                    if ((YearToday % 4 == 0) && (YearToday % 100 != 0) || (YearToday % 400 == 0)) {
                        dateToday = 6 + dateToday - 7;
                        MonthToday = MonthToday + 12;
                        YearToday = YearToday - 1;
                    } else {
                        dateToday = 5 + dateToday - 7;
                        MonthToday = MonthToday + 12;
                        YearToday = YearToday - 1;
                    }
                }


            } else if (dateToday > 7) {
                dateToday = dateToday - 7;
            }
        } else {
            dateToday = dateToday - 7;

        }

        if (MonthToday < 10 && dateToday < 10) {
            return YearToday + "-" + "0" + MonthToday + "-" + "0" + dateToday;
        } else if (MonthToday < 10) {
            return YearToday + "-" + "0" + MonthToday + "-" + dateToday;
        } else if (dateToday < 10) {
            return YearToday + "-" + MonthToday + "-" + "0" + dateToday;
        } else {
            return YearToday + "-" + MonthToday + "-" + dateToday;
        }
    }

    /**
     *
     * @return "01-01-" + thisYear
     */
    public static String getThisYearsFirstDate() {
        String _today = StringDateManipulation.toDayInGc();
        return _today.split("-")[0] + "-01-01";
    }

    /**
     *
     * @return This year last date
     */
    public static String getThisYearsLastDate() {
        String _today = StringDateManipulation.toDayInGc();
        return _today.substring(0, 4) + "-12-31";
    }

    /**
     *
     * @return "05-13-" + thisYear or "06-13-" + thisYear (for thisYear%4 == 3)
     */
    public static String getThisYearsLastDateEC() {
        String _today = StringDateManipulation.toDayInEc();
        int thisYear = StringDateManipulation.getYear(_today) - 1;
        if ((Integer.parseInt(_today.substring(0, 4)) % 4) == 3) {
            return _today.substring(0, 4) + "-13-06";
        } else {
            return _today.substring(0, 4) + "-13-05";
        }
    }

    /**
     * assuming the year is divided in four quarters, this method computes
     * for the first date of the current quarter
     * @return returns "01-" + quartersFirstMonth + "-" + thisYear
     */
    public static String getThisQuartersFirstDate() {

        String _today = StringDateManipulation.toDayInGc();

        if (StringDateManipulation.getMonth(_today) < 4) {
            return _today.substring(0, 4) + "-01-01";

        } else if (StringDateManipulation.getMonth(_today) < 7) {
            return _today.substring(0, 4) + "-04-01";
        } else if (StringDateManipulation.getMonth(_today) < 10) {
            return _today.substring(0, 4) + "-07-01";
        } else if (StringDateManipulation.getMonth(_today) < 13) {
            return _today.substring(0, 4) + "-10-01";
        } else {
            return null;
        }

    }

    /**
     * assuming the year is divided in four quarters, this method computes
     * for the first date of the current quarter
     * @return returns "01-" + quartersFirstMonth + "-" + thisYear
     */
    public static String getThisQuartersFirstDateEC() {

        String _today = StringDateManipulation.toDayInEc();

        if (StringDateManipulation.getMonth(_today) < 4) {
            return _today.substring(0, 4) + "-01-01";

        } else if (StringDateManipulation.getMonth(_today) < 7) {
            return _today.substring(0, 4) + "-04-01";
        } else if (StringDateManipulation.getMonth(_today) < 10) {
            return _today.substring(0, 4) + "-07-01";
        } else if (StringDateManipulation.getMonth(_today) < 14) {
            return _today.substring(0, 4) + "-10-01";
        } else {
            return null;
        }

    }

    /**
     * assuming the year is divided in four quarters, this method computes
     * for the last date of the current quarter
     * @return thisYear + quartersLastMonth + quartersLastDay
     */
    public static String getThisQuartersLastDate() {

        String _today = StringDateManipulation.toDayInGc();
        if (StringDateManipulation.getMonth(_today) < 4) {
            return _today.substring(0, 4) + "-03-31";
        } else if (StringDateManipulation.getMonth(_today) < 7) {
            return _today.substring(0, 4) + "-06-30";
        } else if (StringDateManipulation.getMonth(_today) < 10) {
            return _today.substring(0, 4) + "-09-30";
        } else if (StringDateManipulation.getMonth(_today) < 13) {
            return _today.substring(0, 4) + "-12-31";
        } else {
            return null;
        }
    }

    /**
     * assuming the year is divided in four quarters, this method computes
     * for the last date of the current quarter
     * @return returns "01-" + quartersLastMonth + "-" + thisYear
     */
    public static String getThisQuartersLastDateEC() {

        String _today = StringDateManipulation.toDayInEc();
        if (StringDateManipulation.getMonth(_today) < 4) {
            return _today.substring(0, 4) + "-03-30";
        } else if (StringDateManipulation.getMonth(_today) < 7) {
            return _today.substring(0, 4) + "-06-30";
        } else if (StringDateManipulation.getMonth(_today) < 10) {
            return _today.substring(0, 4) + "-09-30";
        } else if (StringDateManipulation.getMonth(_today) < 14) {
            return getThisYearsLastDate();
        } else {
            return null;
        }
    }
     public static void formatReportAsPdfStream(JasperPrint _jsPrint,
            ServletOutputStream _outputStream) {
        try {
            JRPdfExporter pdfExporter = new JRPdfExporter();

            pdfExporter.setParameter(JRExporterParameter.JASPER_PRINT,
                    _jsPrint);
            pdfExporter.setParameter(
                    JRExporterParameter.OUTPUT_STREAM, _outputStream);
            pdfExporter.exportReport();
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
        }
    }


     public static void formatReportAsHtmlStream(JasperPrint _jsPrint,
            ServletOutputStream _outputStream, FacesContext context) {
        try {

            JRHtmlExporter htmlExporter = new JRHtmlExporter();

            htmlExporter.setParameter(JRExporterParameter.JASPER_PRINT,
                    _jsPrint);
            htmlExporter.setParameter(
                    JRExporterParameter.OUTPUT_STREAM, _outputStream);
            HttpServletRequest request =
                    (HttpServletRequest) context.getExternalContext().getRequest();

            htmlExporter.setParameter(
                    JRHtmlExporterParameter.IMAGES_URI, request.getContextPath() + "/image?image=");
            request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, _jsPrint);

            htmlExporter.exportReport();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
    }

    public static void RECURITMENT(ServletOutputStream _outputStream,String _type,
            String dateStart, String dateEnd, FacesContext context) {

        try {

            Blob blb =null; //ReportManagement.getReportFile(RECURITMENT);   //id
            byte[] bb;

            bb = blb.getBytes((long) 1, (int) blb.length());
            ByteArrayInputStream bias = new ByteArrayInputStream(bb);
            ReportEntity RE = new ReportEntity();

            ResultSet _rs =null; // RE.getRECURITMENTResultset( dateStart, dateEnd);
//            ArrayList<HashMap> _data = new ArrayList<HashMap>();
//            ResultSetMetaData rMd = _rs.getMetaData();
            //if (_rs != null) {
//                _rs.next();
//                while (_rs.next()) {
//                    HashMap temp = new HashMap();
//                    for (int i = 1; i <= rMd.getColumnCount(); i++) {
//                        temp.put(rMd.getColumnName(i), _rs.getString(rMd.getColumnName(i)));
//                    }
//                    _data.add(temp);
//                }

            //}
            if (_rs != null) {
                JRResultSetDataSource jrRss = new JRResultSetDataSource(_rs);


                JasperPrint jsPrint = null; //
//                        JasperFillManager.fillReport(bias,
//                        ReportEntity.getRECURITMENTParameters(), jrRss);

                if (_type.compareTo("pdf") == 0) {
                    formatReportAsPdfStream(jsPrint, _outputStream);
                } else {
                    formatReportAsHtmlStream(jsPrint, _outputStream, context);
                }

            } else {
                String str = "<html> <body> <center><h3> No data found " +
                        "</h3> </center> </body> </html>";
                _outputStream.write(str.getBytes());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
    }
   ////////////////////////////////////////////////////
    public static void DESCIPLINE(ServletOutputStream _outputStream,String _type,
            String dateStart, String dateEnd, FacesContext context) {

        try {

            Blob blb =null; // ReportManagement.getReportFile(DESCIPLINE);   //id
            byte[] bb;

            bb = blb.getBytes((long) 1, (int) blb.length());
            ByteArrayInputStream bias = new ByteArrayInputStream(bb);
            ReportEntity RE = new ReportEntity();

            ResultSet _rs = null; //RE.getDESCIPLINEesultset( dateStart, dateEnd);
//            ArrayList<HashMap> _data = new ArrayList<HashMap>();
//            ResultSetMetaData rMd = _rs.getMetaData();
            //if (_rs != null) {
//                _rs.next();
//                while (_rs.next()) {
//                    HashMap temp = new HashMap();
//                    for (int i = 1; i <= rMd.getColumnCount(); i++) {
//                        temp.put(rMd.getColumnName(i), _rs.getString(rMd.getColumnName(i)));
//                    }
//                    _data.add(temp);
//                }

            //}
            if (_rs != null) {
                JRResultSetDataSource jrRss = new JRResultSetDataSource(_rs);


                JasperPrint jsPrint = null; //JasperFillManager.fillReport(bias,
//                        ReportEntity.getDESCIPLINEParameters(), jrRss);

                if (_type.compareTo("pdf") == 0) {
                    formatReportAsPdfStream(jsPrint, _outputStream);
                } else {
                    formatReportAsHtmlStream(jsPrint, _outputStream, context);
                }

            } else {
                String str = "<html> <body> <center><h3> No data found " +
                        "</h3> </center> </body> </html>";
                _outputStream.write(str.getBytes());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
    }
}
