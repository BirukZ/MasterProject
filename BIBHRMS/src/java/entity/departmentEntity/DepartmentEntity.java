/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.departmentEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
//import javax.swing.JOptionPane;
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Administrator
 */
public class DepartmentEntity extends ConnectionManager {

    String position;
    private int depId;
    String region;
    String vision;
    private String levelOfEducation;
    private String levelOfEducationID;
    private String jobQualificationID;
    Connection _con = null;
    PreparedStatement _ps = null;
    ResultSet _rs = null;

    public void releaseResources() throws SQLException {
        if (_rs != null) {
            _rs.close();
        }
        if (_ps != null) {
            _ps.close();
        }
        if (_con != null) {
            closePooledConnections(_con);
        }
    }

    public String getJobQualificationID() {
        return jobQualificationID;
    }

    public void setJobQualificationID(String jobQualificationID) {
        this.jobQualificationID = jobQualificationID;
    }

    public String getLevelOfEducationID() {
        return levelOfEducationID;
    }

    public void setLevelOfEducationID(String levelOfEducationID) {
        this.levelOfEducationID = levelOfEducationID;
    }

    public String getLevelOfEducation() {
        return levelOfEducation;
    }

    public void setLevelOfEducation(String levelOfEducation) {
        this.levelOfEducation = levelOfEducation;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public String getOfficeNumber() {
        return OfficeNumber;
    }

    public void setOfficeNumber(String OfficeNumber) {
        this.OfficeNumber = OfficeNumber;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getKebelle() {
        return kebelle;
    }

    public void setKebelle(String kebelle) {
        this.kebelle = kebelle;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTelMobile() {
        return telMobile;
    }

    public void setTelMobile(String telMobile) {
        this.telMobile = telMobile;
    }

    public String getTelOffice() {
        return telOffice;
    }

    public void setTelOffice(String telOffice) {
        this.telOffice = telOffice;
    }

    public String getTelOfficeExt() {
        return telOfficeExt;
    }

    public void setTelOfficeExt(String telOfficeExt) {
        this.telOfficeExt = telOfficeExt;
    }

    public String getWoreda() {
        return woreda;
    }

    public void setWoreda(String woreda) {
        this.woreda = woreda;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }
    String zone;
    String woreda;
    String kebelle;
    String floor;
    String block;
    String OfficeNumber;
    String telOffice;
    String telOfficeExt;
    String telMobile;
    String email;

    public int getDepId() {
        String _select = "SELECT dep_id FROM TBL_DEPT_BUNNA";


        depId = -1;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            _rs = _ps.executeQuery();
            _rs.next();
            if (_rs.getRow() > 0) {
                depId = _rs.getInt("dep_id");
            }
        } catch (Exception _ex) {
            ErrorLogWriter.writeError(_ex);
            return -1;

        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public DepartmentEntity(int depId) {
        this.depId = depId;
    }

    public DepartmentEntity(String position, String jobCode, int NUmberOfYear, String type) {
        this.position = position;
        this.jobCode = jobCode;
        this.NUmberOfYear = NUmberOfYear;
        this.type = type;
    }

    public DepartmentEntity(String jobName, String responsiblity, String rank, String additionalSkill, String type) {
        this.jobName = jobName;
        this.responsiblity = responsiblity;
        this.rank = rank;
        this.additionalSkill = additionalSkill;
        this.type = type;
    }

    public DepartmentEntity(String educLevel, String minimumExperiance, int x) {
        this.levelOfEducation = educLevel;
        this.minimumExperiance = minimumExperiance;

    }

    public DepartmentEntity(String qualification) {
        this.qualifcation = qualification;


    }

    public DepartmentEntity(String levelOfEducationID, String levelOfEducation, String minimumExp, int x) {
        this.levelOfEducationID = levelOfEducationID;
        this.minimumExperiance = minimumExp;
        this.levelOfEducation = levelOfEducation;
    }

    public int getNUmberOfYear() {
        return NUmberOfYear;
    }

    public void setNUmberOfYear(int NUmberOfYear) {
        this.NUmberOfYear = NUmberOfYear;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    String jobCode;
    int NUmberOfYear;
    String type;

    public String getAdditionalSkill() {
        return additionalSkill;
    }

    public void setAdditionalSkill(String additionalSkill) {
        this.additionalSkill = additionalSkill;
    }

//    public ConnectionManager getConnectionManager() {
//        return ConnectionManager;
//    }
//
//    public void setConnectionManager(ConnectionManager ConnectionManager) {
//        this.ConnectionManager = ConnectionManager;
//    }
    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getMinimumExperiance() {
        return minimumExperiance;
    }

    public void setMinimumExperiance(String minimumExperiance) {
        this.minimumExperiance = minimumExperiance;
    }

    public String getQualifcation() {
        return qualifcation;
    }

    public void setQualifcation(String qualifcation) {
        this.qualifcation = qualifcation;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getResponsiblity() {
        return responsiblity;
    }

    public void setResponsiblity(String responsiblity) {
        this.responsiblity = responsiblity;
    }

    public DepartmentEntity(String jobName, String responsiblity, String rank, String qualifcation, String additionalSkill, String minimumExperiance, String type) {

        this.jobName = jobName;
        this.responsiblity = responsiblity;
        this.rank = rank;
        this.qualifcation = qualifcation;
        this.additionalSkill = additionalSkill;
        this.minimumExperiance = minimumExperiance;
        this.type = type;
    }

    public int insertJob(DepartmentEntity saveJob) {
        String insert = "INSERT INTO hr_lu_job_type ( JOB_DESCRIPTION, min_Required_Qualification, " +
                "min_Required_Experience, additionalSkill, min_Responsibility, RANK_ID,TYPE) " +
                "values( ?, ?, ?, ?, ?,?,?)";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(insert);
            _ps.setString(1, saveJob.getJobName());
            _ps.setString(2, saveJob.getQualifcation());
            _ps.setString(3, saveJob.getMinimumExperiance());
            _ps.setString(4, saveJob.getAdditionalSkill());
            _ps.setString(5, saveJob.getResponsiblity());
            _ps.setString(6, saveJob.getRank());
            _ps.setString(7, saveJob.getType());
            int rowAffected = _ps.executeUpdate();
            _ps.close();

            return rowAffected;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);

        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }

    public int updateJob(DepartmentEntity saveJob, String jobid) {
        String insert = "update hr_lu_job_type set JOB_DESCRIPTION=?, min_Required_Qualification=?, " +
                "min_Required_Experience=?, additionalSkill=?, min_Responsibility=?,RANK_ID=?,type=? where JOB_CODE=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(insert);
            _ps.setString(1, saveJob.getJobName());
            _ps.setString(2, saveJob.getQualifcation());
            _ps.setString(3, saveJob.getMinimumExperiance());
            _ps.setString(4, saveJob.getAdditionalSkill());
            _ps.setString(5, saveJob.getResponsiblity());
            _ps.setString(6, saveJob.getRank());
            _ps.setString(7, saveJob.getType());
            _ps.setString(8, jobid);
            int rowAffected = _ps.executeUpdate();
            _ps.close();

            return rowAffected;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);

        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }
    String jobName;
    String responsiblity;
    String rank;
    String qualifcation;
    String additionalSkill;
    String minimumExperiance;
    String experianceId;

    public String getExperianceId() {
        return experianceId;
    }

    public void setExperianceId(String experianceId) {
        this.experianceId = experianceId;
    }

    public DepartmentEntity(String experianceId, String code, String description) {
        this.experianceId = experianceId;
        this.code = code;
        this.description = description;
    }

    public DepartmentEntity() {
    }
    String code;
    String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DepartmentEntity(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public ArrayList<DepartmentEntity> readJobRank() {
        String _select = "SELECT * FROM hr_lu_rank";



        ArrayList<DepartmentEntity> listRank = new ArrayList<DepartmentEntity>();

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = (ResultSet) _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            while (ocrs.next()) {
                this.code = ocrs.getString("rank_Id");
                this.description = ocrs.getString("description");
                DepartmentEntity titleEntity = new DepartmentEntity(code, description);
                listRank.add(titleEntity);
            }
            _rs.close();
            _ps.close();

            return listRank;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ArrayList<DepartmentEntity> readDepartment() {
        String _select = "SELECT  dept_Id,DEP_DESCRIPTION FROM TBL_DEPT_BUNNA where dept_Id like '__'";



        ArrayList<DepartmentEntity> department = new ArrayList<DepartmentEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = (ResultSet) _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            while (ocrs.next()) {
                this.code = ocrs.getString("dept_Id");
                this.description = ocrs.getString("DEP_DESCRIPTION");
                DepartmentEntity departmentEntity = new DepartmentEntity(code, description);
                department.add(departmentEntity);
            }
            _rs.close();
            _ps.close();

            return department;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);

            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ArrayList<DepartmentEntity> readDepartmentTerm() {
        String _select = "SELECT  dept_Id,DEP_DESCRIPTION FROM TBL_DEPT_BUNNA ";



        ArrayList<DepartmentEntity> department = new ArrayList<DepartmentEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = (ResultSet) _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            while (ocrs.next()) {
                this.code = ocrs.getString("dept_Id");
                this.description = ocrs.getString("DEP_DESCRIPTION");
                DepartmentEntity departmentEntity = new DepartmentEntity(code, description);
                department.add(departmentEntity);
            }
            _rs.close();
            _ps.close();

            return department;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);

            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ArrayList<DepartmentEntity> readZerf(String departmentID) {

        String _select = "SELECT  dept_Id,DEP_DESCRIPTION FROM TBL_DEPT_BUNNA where BRANCH_ID = " + departmentID + "";



        ArrayList<DepartmentEntity> department = new ArrayList<DepartmentEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = (ResultSet) _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            while (ocrs.next()) {
                this.code = ocrs.getString("dept_Id");
                this.description = ocrs.getString("DEP_DESCRIPTION");
                DepartmentEntity departmentEntity = new DepartmentEntity(code, description);
                department.add(departmentEntity);
            }
            _rs.close();
            _ps.close();

            return department;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);

            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ArrayList<DepartmentEntity> readJob(String departmentid) {

//        String _select = "SELECT distinct hr_lu_job_type.job_Code,hr_lu_job_type.job_description FROM (hr_dept_job  INNER JOIN" +
//                " TBL_DEPARTMENT ON TBL_DEPARTMENT.DEPT_ID = hr_dept_job.DEPT_ID) INNER JOIN hr_lu_job_type ON hr_dept_job.JOB_CODE = " +
//                " hr_lu_job_type.JOB_CODE where HR_DEPT_JOB.DEPT_ID='" + departmentid + "'";


        String _select = "SELECT DISTINCT hr_lu_job_type.job_Code, " +
                "  hr_lu_job_type.JOB_NAME " +
                "FROM (hr_dept_job " +
                "INNER JOIN TBL_DEPT_BUNNA " +
                "ON TBL_DEPT_BUNNA.DEPT_ID = hr_dept_job.DEPT_ID) " +
                "INNER JOIN hr_lu_job_type " +
                "ON hr_dept_job.JOB_CODE  = hr_lu_job_type.JOB_CODE " +
                "WHERE HR_DEPT_JOB.DEPT_ID='" + departmentid + "'";




        ArrayList<DepartmentEntity> readJobFrDb = new ArrayList<DepartmentEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = (ResultSet) _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            while (ocrs.next()) {
                this.code = ocrs.getString("job_Code");
                this.description = ocrs.getString("JOB_NAME");
                DepartmentEntity departmentEntity = new DepartmentEntity(code, description);
                readJobFrDb.add(departmentEntity);
            }
            _rs.close();
            _ps.close();

            return readJobFrDb;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }


    }

    public ArrayList<DepartmentEntity> readAllJob() {
        // String _select = "SELECT job_Code,JOB_DESCRIPTION  FROM  hr_lu_job_type order by JOB_DESCRIPTION asc";
        String _select = " SELECT job_Code,JOB_NAME  FROM  hr_lu_job_type order by CAST (job_code as number)";

        ArrayList<DepartmentEntity> readJobFrDb = new ArrayList<DepartmentEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = (ResultSet) _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            while (ocrs.next()) {
                this.code = ocrs.getString("job_Code");
                this.description = ocrs.getString("JOB_NAME");
                DepartmentEntity departmentEntity = new DepartmentEntity(code, description);
                readJobFrDb.add(departmentEntity);
            }
            _rs.close();
            _ps.close();

            return readJobFrDb;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }



    }

    public ArrayList<DepartmentEntity> readExperienceJob() {

        String _select = "SELECT *  FROM  hr_lu_experienceforjob";



        ArrayList<DepartmentEntity> readExperiacne = new ArrayList<DepartmentEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = (ResultSet) _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            while (ocrs.next()) {
                this.code = ocrs.getString("id");
                this.description = ocrs.getString("postion");
                this.experianceId = ocrs.getString("NoofYear");
                DepartmentEntity departmentEntity = new DepartmentEntity(code, description, experianceId);
                readExperiacne.add(departmentEntity);
            }
            _rs.close();
            _ps.close();

            return readExperiacne;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }



    }

    public ArrayList<String> selectJobdetail(String job_Code) {




        String _select = " SELECT * FROM HR_LU_JOB_TYPE " +
                " WHERE " +
                " JOB_CODE = '" + job_Code + "'  ";

        ArrayList<String> jobdetil = new ArrayList<String>();


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = (ResultSet) _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            if (ocrs.next()) {
                jobdetil.add(ocrs.getString("JOB_CODE"));
                jobdetil.add(ocrs.getString("JOB_DESCRIPTION"));
                jobdetil.add(ocrs.getString("MIN_REQUIRED_QUALIFICATION"));
                jobdetil.add(ocrs.getString("MIN_REQUIRED_EXPERIENCE"));
                jobdetil.add(ocrs.getString("MIN_RESPONSIBILITY"));
                jobdetil.add(ocrs.getString("ADDITIONALSKILL"));
                jobdetil.add(ocrs.getString("RANK_ID"));
                jobdetil.add(ocrs.getString("TYPE"));
            }

            return jobdetil;

        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            ex.getMessage();
            return jobdetil;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }
        }
    }

    public HashMap[] selectJobDescription(String job_Code) {


        PreparedStatement _ps1 = null;

        ResultSet _rs1 = null;

        HashMap[] list = null;
        int i = 0;


        String _select = " SELECT HR_LU_JOB_TYPE.JOB_CODE AS JOB_CODE, HR_LU_JOB_TYPE.JOB_DESCRIPTION, HR_LU_JOB_TYPE.MIN_RESPONSIBILITY," +
                " HR_LU_JOB_TYPE.ADDITIONALSKILL, HR_LU_JOB_TYPE.TYPE, HR_LU_JOB_TYPE.RANK_ID," +
                " HR_LU_JOB_TYPE_EDUC_LEVEL.JOB_TYPE_EDUC_LEVEL_ID, HR_LU_JOB_TYPE_EDUC_LEVEL.EDUCATION_LEVEL," +
                " HR_LU_JOB_TYPE_EDUC_LEVEL.MIN_EXPERIENCE, HR_LU_JOB_TYPE_EDUC_LEVEL.JOB_CODE, " +
                " HR_LU_JOB_TYPE_QUALIFICATION.JOB_TYPE_QUALIFICATION_ID, HR_LU_JOB_TYPE_QUALIFICATION.QUALIFICATION AS MIN_REQUIRED_QUALIFICATION, " +
                " HR_LU_JOB_TYPE_QUALIFICATION.JOB_CODE, " +
                " HR_LU_PAY_GRAD.SALARY AS INITIAL_SALARY " +
                " FROM  " +
                " hr_lu_job_type, HR_LU_JOB_TYPE_EDUC_LEVEL, HR_LU_JOB_TYPE_QUALIFICATION, HR_LU_PAY_GRAD " +
                " WHERE" +
                " HR_LU_JOB_TYPE.JOB_CODE = '" + job_Code + "'" +
                " AND" +
                " HR_LU_JOB_TYPE.JOB_CODE = HR_LU_JOB_TYPE_EDUC_LEVEL.JOB_CODE(+) " +
                " AND " +
                " HR_LU_JOB_TYPE.JOB_CODE = HR_LU_JOB_TYPE_QUALIFICATION.JOB_CODE(+) " +
                " AND " +
                " HR_LU_PAY_GRAD.RANK_ID = HR_LU_JOB_TYPE.RANK_ID " +
                " AND HR_LU_PAY_GRAD.STEP_NO= '0' ";
        String _select1 = " SELECT * FROM HR_LU_JOB_TYPE " +
                " WHERE " +
                " JOB_CODE = '" + job_Code + "'  ";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = (ResultSet) _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            list = new HashMap[ocrs.size()];
            if (ocrs.size() > 0) {
                while (ocrs.next()) {
                    list[i] = new HashMap();
                    list[i].put("JOB_CODE", ocrs.getString("JOB_CODE"));
                    list[i].put("JOB_DESCRIPTION", ocrs.getString("JOB_DESCRIPTION"));
                    list[i].put("MIN_REQUIRED_QUALIFICATION", ocrs.getString("MIN_REQUIRED_QUALIFICATION"));
                    list[i].put("MIN_EXPERIENCE", ocrs.getString("MIN_EXPERIENCE"));
                    list[i].put("MIN_RESPONSIBILITY", ocrs.getString("MIN_RESPONSIBILITY"));
                    list[i].put("ADDITIONALSKILL", ocrs.getString("ADDITIONALSKILL"));
                    list[i].put("RANK_ID", ocrs.getString("RANK_ID"));
                    list[i].put("EDUCATION_LEVEL", ocrs.getString("EDUCATION_LEVEL"));
                    list[i].put("INITIAL_SALARY", ocrs.getString("INITIAL_SALARY"));

                    i++;
                }

                return list;
            } else {

                _ps1 = _con.prepareStatement(_select1);
                _rs1 = _ps1.executeQuery();
                OracleCachedRowSet ocrs1 = new OracleCachedRowSet();
                ocrs1.populate(_rs1);
                _rs1.close();
                list = new HashMap[ocrs1.size()];
                while (ocrs1.next()) {
                    list[i] = new HashMap();
                    list[i].put("JOB_CODE", ocrs1.getString("JOB_CODE"));
                    list[i].put("JOB_DESCRIPTION", ocrs1.getString("JOB_DESCRIPTION"));
                    list[i].put("QUALIFICATION", ocrs1.getString("MIN_REQUIRED_QUALIFICATION"));
                    list[i].put("MIN_EXPERIENCE", ocrs1.getString("MIN_REQUIRED_EXPERIENCE"));
                    list[i].put("MIN_RESPONSIBILITY", ocrs1.getString("MIN_RESPONSIBILITY"));
                    list[i].put("ADDITIONALSKILL", ocrs1.getString("ADDITIONALSKILL"));
                    list[i].put("RANK_ID", ocrs1.getString("RANK_ID"));
                    list[i].put("EDUCATION_LEVEL", "Not given yet");
                    i++;
                }

                return list;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            ex.getMessage();
            return null;
        } finally {
            try {
                _ps.close();
                _ps1.close();
                _con.close();
            } catch (Exception ignore) {
            }
        }
    }

    public HashMap selectJobDetaille(String job_Code) {
        String query = "SELECT HR_LU_JOB_TYPE.JOB_CODE AS JOB_CODE, " +
                "  HR_LU_JOB_TYPE.JOB_DESCRIPTION, " +
                "  HR_LU_JOB_TYPE.MIN_RESPONSIBILITY, " +
                "  HR_LU_JOB_TYPE.ADDITIONALSKILL, " +
                "  HR_LU_JOB_TYPE.TYPE, " +
                "  HR_LU_JOB_TYPE.RANK_ID, " +
                "  HR_LU_EDUC_TYPE.DESCRIPTION, " +
                "  HR_LU_PAY_GRAD.SALARY AS INITIAL_SALARY, " +
                "   HR_LU_EDUC_TYPE.DESCRIPTION as EDUC_DESCRIPTION, " +
                "  HR_LU_JOBTYPE_EDUCTYPE.EDUCTYPE_ID, " +
                "  nvl(HR_LU_JOBTYPE_EDUCLEVEL_EXPER.EXPERIENCE,'not register') as EXPERIENCE " +
                "FROM hr_lu_job_type, " +
                "  HR_LU_JOBTYPE_EDUCTYPE, " +
                "  HR_LU_JOB_TYPE_QUALIFICATION, " +
                "  HR_LU_PAY_GRAD, " +
                "  HR_LU_EDUC_TYPE, " +
                "  HR_LU_JOBTYPE_EDUCLEVEL_EXPER " +
                "WHERE HR_LU_JOB_TYPE.JOB_CODE                = '" + job_Code + "' " +
                "AND HR_LU_JOB_TYPE.JOB_CODE                  = HR_LU_JOBTYPE_EDUCTYPE.JOBTYPE_ID(+) " +
                "AND HR_LU_EDUC_TYPE.EDUC_TYPE_CODE= HR_LU_JOBTYPE_EDUCTYPE.EDUCTYPE_ID " +
                "AND HR_LU_JOB_TYPE.JOB_CODE                  = HR_LU_JOB_TYPE_QUALIFICATION.JOB_CODE(+) " +
                "AND HR_LU_PAY_GRAD.RANK_ID                   = HR_LU_JOB_TYPE.RANK_ID " +
                "AND HR_LU_JOB_TYPE.JOB_CODE                  = HR_LU_JOBTYPE_EDUCLEVEL_EXPER.JOBTYPE_ID " +
                "AND HR_LU_PAY_GRAD.STEP_NO                   = '0'";

        HashMap hm = new HashMap();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(query);
            _rs = (ResultSet) _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();

            if (ocrs.size() > 0) {
                if (ocrs.next()) {
                    hm.put("JOB_CODE", ocrs.getString("JOB_CODE"));
                    hm.put("JOB_DESCRIPTION", ocrs.getString("JOB_DESCRIPTION"));
                    hm.put("MIN_REQUIRED_QUALIFICATION", ocrs.getString("DESCRIPTION"));
                    hm.put("MIN_EXPERIENCE", ocrs.getString("EXPERIENCE"));
                    hm.put("MIN_RESPONSIBILITY", ocrs.getString("MIN_RESPONSIBILITY"));
                    hm.put("ADDITIONALSKILL", ocrs.getString("ADDITIONALSKILL"));
                    hm.put("RANK_ID", ocrs.getString("RANK_ID"));
                    hm.put("EDUCATION_LEVEL", ocrs.getString("EDUC_DESCRIPTION"));
                    hm.put("INITIAL_SALARY", ocrs.getString("INITIAL_SALARY"));
                    return hm;
                } else {

                    return null;
                }
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }





    }

    public int saveMinimumExperience(DepartmentEntity saveMinExp) {
        String insert = "INSERT INTO hr_lu_experienceforjob (POSTION,job_Code,NOOFYEAR,TYPE)" +
                "values(?, ?, ?, ?)";



        try {
            _con = getConnection();
            _ps = _con.prepareStatement(insert);
            _ps.setString(1, saveMinExp.getPosition());
            _ps.setString(2, saveMinExp.getJobCode());
            _ps.setInt(3, saveMinExp.getNUmberOfYear());
            _ps.setString(4, saveMinExp.getType());
            int rowAffected = _ps.executeUpdate();
            _ps.close();

            return rowAffected;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);

        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 0;


    }

    public String readDepartmentDescrption(String departmentName) {
        String _select = "SELECT *  FROM  TBL_DEPT_BUNNA where TBL_DEPT_BUNNA.DEPT_ID='" + departmentName + "'";



        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);

            if (ocrs.next()) {
                _rs.close();
                _ps.close();

                return ocrs.getString("DEP_DESCRIPTION");

            }

        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;

    }

    public HashMap readDepartmenID(String departmentName) {
        String _select = "SELECT *  FROM  TBL_DEPT_BUNNA where TBL_DEPT_BUNNA.DEPT_ID='" + departmentName + "'";
        HashMap depart = new HashMap();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            if (ocrs.next()) {
                depart.put("DEPT_ID", ocrs.getString("DEPT_ID"));
                depart.put("DEP_DESCRIPTION", ocrs.getString("DEP_DESCRIPTION"));
                depart.put("MISSION", ocrs.getString("MISSION"));
                depart.put("VISION", ocrs.getString("VISION"));
                depart.put("EST_DATE", ocrs.getString("EST_DATE"));
                depart.put("ADDRESS_CODE", ocrs.getString("ADDRESS_CODE"));
                return depart;
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;

    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public HashMap readDepartmenIDNew(String departmentName) {
        String _select = "SELECT *  FROM  TBL_DEPT_BUNNA where TBL_DEPT_BUNNA.DEPT_ID='" + departmentName + "'";
        HashMap depart = new HashMap();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            if (ocrs.next()) {
                depart.put("DEPT_ID", ocrs.getString("DEPT_ID"));
                depart.put("DEP_DESCRIPTION", ocrs.getString("DEP_DESCRIPTION"));
                depart.put("MISSION", ocrs.getString("MISSION"));
                depart.put("VISION", ocrs.getString("VISION"));
                depart.put("EST_DATE", ocrs.getString("EST_DATE"));
                depart.put("ADDRESS_CODE", ocrs.getString("ADDRESS_CODE"));
                return depart;
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;

    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public DepartmentEntity(String deptCode, String deptDescription, String deptMission, String estDate) {
        this.deptCode = deptCode;
        this.deptDescription = deptDescription;
        this.deptMission = deptMission;
        this.estDate = estDate;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptDescription() {
        return deptDescription;
    }

    public void setDeptDescription(String deptDescription) {
        this.deptDescription = deptDescription;
    }

    public String getDeptMission() {
        return deptMission;
    }

    public void setDeptMission(String deptMission) {
        this.deptMission = deptMission;
    }

    public String getEstDate() {
        return estDate;
    }

    public void setEstDate(String estDate) {
        this.estDate = estDate;
    }
    private String deptDescription;
    private String deptMission;
    private String estDate;
    private String branchID;
    private String addressCode;

    public String getBranchID() {
        return branchID;
    }

    public void setBranchID(String branchID) {
        this.branchID = branchID;
    }

    public String getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }

    public int addDept(String deptId, String deptName, String mission, String vision, String est_Date, String branch_id, String addressCode) {

        this.setDeptCode(deptId);
        this.setDeptDescription(deptName);
        this.setDeptMission(mission);
        this.setEstDate(est_Date);
        this.setVision(vision);
        this.setBranchID(branch_id);
        this.setAddressCode(addressCode);
        return insertDept();
    }

    public int insertDept() {

        PreparedStatement deptPreparedStatement = null;

        String deptStatement = "INSERT INTO TBL_DEPT_BUNNA (dept_id, DEP_DESCRIPTION, " +
                "MISSION,VISION,EST_DATE,BRANCH_ID,ADDRESS_CODE) values (HR_DEPT_SEQ.nextval, ?, ?, ?,?,?,?)";
        try {

            _con = getConnection();
            deptPreparedStatement = _con.prepareStatement(deptStatement);
            deptPreparedStatement.setString(1, getDeptDescription());
            deptPreparedStatement.setString(2, getDeptMission());
            deptPreparedStatement.setString(3, getVision());
            deptPreparedStatement.setString(4, getEstDate());
            deptPreparedStatement.setString(5, getBranchID());
            deptPreparedStatement.setString(6, getAddressCode());
            return deptPreparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                deptPreparedStatement.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    public int deleteJobType(String jobCode) {
        String delete = "delete from hr_lu_job_type where job_code=?";



        try {
            _con = getConnection();
            _ps = _con.prepareStatement(delete);
            _ps.setString(1, jobCode);
            int rowAffected = _ps.executeUpdate();
            _ps.close();

            return rowAffected;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }

    public int deleteJobDetail(String id, int indicator) {
        String deleteEduc = " DELETE HR_LU_JOB_TYPE_EDUC_LEVEL " +
                " WHERE JOB_TYPE_EDUC_LEVEL_ID=?";

        String deleteQual = " DELETE HR_LU_JOB_TYPE_QUALIFICATION " +
                " WHERE JOB_TYPE_QUALIFICATION_ID=?";

        PreparedStatement _psE = null;
        PreparedStatement _psQ = null;


        try {
            _con = getConnection();

            if (indicator == 1) {

                _psE = _con.prepareStatement(deleteEduc);

                _psE.setString(1, id);


                return _psE.executeUpdate();
            } else if (indicator == 2) {

                _psQ = _con.prepareStatement(deleteQual);

                _psQ.setString(1, id);

                return _psQ.executeUpdate();
            }


            return 0;


        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                _psQ.close();
                _psE.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    public int readDept(int deptID) {
        String str = "SELECT * FROM TBL_DEPT_BUNNA " +
                " WHERE TBL_DEPT_BUNNA.department_id = ?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _ps.setInt(1, deptID);
            _rs = _ps.executeQuery();
            if (_rs.next()) {
                _rs.close();
                return 1;
            } else {
                _rs.close();
                return 0;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }

    public String getDepartmenttAdressCode(int deptID) {
        String str = "SELECT ADDRESS_CODE FROM TBL_DEPT_BUNNA " +
                " WHERE TBL_DEPT_BUNNA.dept_id = ?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _ps.setInt(1, deptID);
            _rs = _ps.executeQuery();
            if (_rs.next()) {
                return _rs.getString("ADDRESS_CODE");
            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    /**
     * The method inserts a row of data into the hr_dept_job table which contains
     * the jobs in a department.
     * @param deptId the unique department identifier
     * @param jobCode the unique identifier of the job
     * @param deptJobCode the conbination key given to a job in a department
     * @return an integer that indicates the process.
     */
    public int addDeptJob(String deptId, String jobCode, int numberOfEmployee) throws SQLException {

        String insert = "INSERT INTO hr_dept_job (DEPT_JOB_CODE,dept_Id, job_code,NUMBER_OF_EMPLOYEE) values (hr_dept_job_seq.nextval,?, ?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(insert);
            _ps.setString(1, deptId);
            _ps.setString(2, jobCode);
            _ps.setInt(3, numberOfEmployee);
            _ps.executeUpdate();
            _ps.close();
            return 1;
        } finally {
            releaseResources();
        }
    }

    public int deleteDept(long deptId) {
        String str_d = null;
        String str_b = null;

        str_d = "DELETE FROM TBL_DEPT_BUNNA WHERE BRANCH_ID = " + deptId + " ";
        str_b = "DELETE FROM TBL_DEPT_BUNNA WHERE DEPT_ID = " + deptId + "";


        PreparedStatement br_ps = null;


        try {
            _con = getConnection();
            br_ps = _con.prepareStatement(str_d);
            br_ps.executeUpdate();
            _ps = _con.prepareStatement(str_b);
            int rowAffected = _ps.executeUpdate();
            _ps.close();

            return rowAffected;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 0;

    }

    public int updateDepartment(String deptId, String deptName, String mission, String vision, String est_Date, String adds_code) {


        String str = ("UPDATE TBL_DEPT_BUNNA set DEPT_ID=?, MISSION=?,  DEP_DESCRIPTION=?,VISION=?, " +
                "est_Date = ?, ADDRESS_CODE=? where DEPT_ID=" + deptId + "");
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _ps.setInt(1, Integer.parseInt(deptId));
            _ps.setString(2, mission);
            _ps.setString(3, deptName);
            _ps.setString(4, vision);
            _ps.setString(5, est_Date);
            _ps.setString(6, adds_code);
            int rowAffected = _ps.executeUpdate();
            _ps.close();

            return rowAffected;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }

    public int updateDeptAddress(DepartmentEntity departmentEntity) {
        PreparedStatement deptPs = null;

        String deptStatement = "UPDATE hr_department_address set " +
                "DEPT_ID = ?, REGION_ID = ?, " +
                "zone_Or_City = ?, woreda_Or_Subcity = ?, kebelle = ?, floor = ?, block = ?, " +
                "OFFICENUMBER=?, telephone_Office = ?, TELEXTENSION = ?, " +
                "mobile = ?, email = ? where DEPT_ID =?";

        try {
            _con = getConnection();
            deptPs = _con.prepareStatement(deptStatement);
            deptPs.setInt(1, Integer.parseInt(departmentEntity.getDeptCode()));
            deptPs.setString(2, departmentEntity.getRegion());
            deptPs.setString(3, departmentEntity.getZone());
            deptPs.setString(4, departmentEntity.getWoreda());
            deptPs.setString(5, departmentEntity.getKebelle());
            deptPs.setString(6, departmentEntity.getFloor());
            deptPs.setString(7, departmentEntity.getBlock());
            deptPs.setString(8, departmentEntity.getOfficeNumber());
            deptPs.setString(9, departmentEntity.getTelOffice());
            deptPs.setString(10, departmentEntity.getTelOfficeExt());
            deptPs.setString(11, departmentEntity.getTelMobile());
            deptPs.setString(12, departmentEntity.getEmail());
            deptPs.setInt(13, Integer.parseInt(departmentEntity.getDeptCode()));
            int rowAffected = deptPs.executeUpdate();
            deptPs.close();

            return rowAffected;
        } catch (Exception ex) {
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ResultSet selectDepartmentAddress(int departmentId) throws SQLException {
        String _selectQuery = " SELECT * from HR_DEPARTMENT_ADDRESS where DEPT_ID=" + departmentId;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public int saveDeptAddress(DepartmentEntity departmentEntity) {

        PreparedStatement deptPs = null;

        String deptStatement = "INSERT INTO hr_department_address " +
                "(DEPT_ID, REGION_ID, " +
                "ZONE_OR_CITY, WOREDA_OR_SUBCITY, KEBELLE, FLOOR, BLOCK, " +
                "OFFICENUMBER, TELEPHONE_OFFICE, TELEXTENSION, " +
                "MOBILE, EMAIL) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            _con = getConnection();
            deptPs = _con.prepareStatement(deptStatement);
            deptPs.setString(1, departmentEntity.getDeptCode());
            deptPs.setString(2, departmentEntity.getRegion());
            deptPs.setString(3, departmentEntity.getZone());
            deptPs.setString(4, departmentEntity.getWoreda());
            deptPs.setString(5, departmentEntity.getKebelle());
            deptPs.setString(6, departmentEntity.getFloor());
            deptPs.setString(7, departmentEntity.getBlock());
            deptPs.setString(8, departmentEntity.getOfficeNumber());
            deptPs.setString(9, departmentEntity.getTelOffice());
            deptPs.setString(10, departmentEntity.getTelOfficeExt());
            deptPs.setString(11, departmentEntity.getTelMobile());
            deptPs.setString(12, departmentEntity.getEmail());
            int rowAffected = deptPs.executeUpdate();
            deptPs.close();

            return rowAffected;
        } catch (Exception ex) {
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }
    private String deptCode;

    public DepartmentEntity(String deptCode, String region, String zone, String woreda,
            String kebelle, String floor, String block, String officeNumber, String telOffice, String telOfficeExt, String telMobile, String email) {
        this.region = region;
        this.zone = zone;
        this.woreda = woreda;
        this.kebelle = kebelle;
        this.floor = floor;
        this.block = block;
        this.OfficeNumber = officeNumber;
        this.telOffice = telOffice;
        this.telOfficeExt = telOfficeExt;
        this.telMobile = telMobile;
        this.email = email;
        this.deptCode = deptCode;
    }

    public HashMap readDepartmentId(int deptId) {



        String str = "Select * FROM hr_department_address WHERE DEPT_ID=?";
        HashMap departmentAddress = new HashMap();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _ps.setInt(1, deptId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            if (ocrs.next()) {
                departmentAddress.put("REGION_ID", ocrs.getString("REGION_ID"));
                departmentAddress.put("ZONE_OR_CITY", ocrs.getString("ZONE_OR_CITY"));
                departmentAddress.put("WOREDA_OR_SUBCITY", ocrs.getString("WOREDA_OR_SUBCITY"));
                departmentAddress.put("KEBELLE", ocrs.getString("KEBELLE"));
                departmentAddress.put("FLOOR", ocrs.getString("FLOOR"));
                departmentAddress.put("BLOCK", ocrs.getString("BLOCK"));
                departmentAddress.put("TELEPHONE_OFFICE", ocrs.getString("TELEPHONE_OFFICE"));
                departmentAddress.put("MOBILE", ocrs.getString("MOBILE"));
                departmentAddress.put("EMAIL", ocrs.getString("EMAIL"));
                departmentAddress.put("TELEXTENSION", ocrs.getString("TELEXTENSION"));
                departmentAddress.put("OFFICENUMBER", ocrs.getString("OFFICENUMBER"));
                _rs.close();
                _ps.close();

                return departmentAddress;
            } else {
                _rs.close();
                _ps.close();

                return null;
            }
        } catch (Exception ex) {
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;

    }

    public int deleteDeptAddress(String deptId) {


        String str = "DELETE FROM hr_department_address WHERE DEPT_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _ps.setInt(1, Integer.parseInt(deptId));
            int rowAffected = _ps.executeUpdate();
            _ps.close();

            return rowAffected;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public int readDepartmentSize() {


        ResultSet rs = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement("SELECT count(dept_id) as maxDeptId FROM TBL_DEPT_BUNNA ");
            rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            ocrs.next();
            rs.close();
            _ps.close();

            return ocrs.getInt("maxDeptId");
        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }

    public int readNextZerfId() {
        ResultSet rs = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement("SELECT MAX(dept_id) as maxDeptId FROM TBL_DEPT_BUNNA t " +
                    "  WHERE t.dept_id LIKE '__'");
            rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            ocrs.next();
            rs.close();
            _ps.close();

            return ocrs.getInt("maxDeptId");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }//end of readNextOrganizationId() method

    public int readNextOrganizationId() {

        ResultSet rs = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement("SELECT MAX(dept_id) as maxDeptId FROM TBL_DEPT_BUNNA t " +
                    "  WHERE t.dept_id LIKE '__000000'");
            rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            ocrs.next();
            rs.close();
            _ps.close();

            return ocrs.getInt("maxDeptId");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }//end of readNextOrganizationId() method

    public HashMap[] readDeptJOb(long deptID) {

        int pos = 0;
        HashMap[] listJob = new HashMap[this.countDeptJOb(deptID)];
        String str = "select  hr_lu_job_type.job_code,hr_lu_job_type.job_description,hr_dept_job.dept_id , hr_dept_job.NUMBER_OF_EMPLOYEE  " +
                "from(TBL_DEPT_BUNNA INNER JOIN hr_dept_job on TBL_DEPT_BUNNA.dept_id=hr_dept_job.DEPT_ID)" +
                "INNER JOIN hr_lu_job_type ON hr_dept_job.JOB_CODE = hr_lu_job_type.JOB_CODE where TBL_DEPT_BUNNA.DEPT_ID =" + deptID + "";
//        String str = "SELECT hr_lu_job_type.job_code, " +
//                "  hr_lu_job_type.JOB_NAME, " +
//                "  hr_dept_job.dept_id , " +
//                "  hr_dept_job.NUMBER_OF_EMPLOYEE " +
//                "FROM(TBL_DEPT_BUNNA " +
//                "INNER JOIN hr_dept_job " +
//                "ON TBL_DEPT_BUNNA.dept_id=hr_dept_job.DEPT_ID) " +
//                "INNER JOIN hr_lu_job_type " +
//                "ON hr_dept_job.JOB_CODE = hr_lu_job_type.JOB_CODE " +
//                "WHERE TBL_DEPT_BUNNA.DEPT_ID =" + deptID + "";

        try {

            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            while (ocrs.next()) {
                listJob[pos] = new HashMap();
                listJob[pos].put("job_code", ocrs.getString("job_code"));
                listJob[pos].put("job_description", ocrs.getString("job_description"));
                listJob[pos].put("ID", ocrs.getString("dept_id"));
                listJob[pos].put("NUMBER_OF_EMPLOYEE", ocrs.getString("NUMBER_OF_EMPLOYEE"));
                pos += 1;
            }
            _rs.close();
            _ps.close();

            return listJob;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    ///////////////////////////////////////////////////////////////////////New//////////////////////////////////////////////////////////////////////////

    public HashMap[] readDeptJObNew(long deptID) {



        int pos = 0;
        HashMap[] listJob = new HashMap[this.countDeptJOb(deptID)];
        String str = " SELECT hr_lu_job_type.job_code, " +
                "  hr_lu_job_type.JOB_NAME, " +
                "  hr_dept_job.dept_id , " +
                "  hr_dept_job.NUMBER_OF_EMPLOYEE " +
                "FROM(TBL_DEPT_BUNNA " +
                "INNER JOIN hr_dept_job " +
                "ON TBL_DEPT_BUNNA.dept_id=hr_dept_job.DEPT_ID) " +
                "INNER JOIN hr_lu_job_type " +
                "ON hr_dept_job.JOB_CODE = hr_lu_job_type.JOB_CODE " +
                "WHERE TBL_DEPT_BUNNA.DEPT_ID =" + deptID + "";
        try {

            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            while (ocrs.next()) {
                listJob[pos] = new HashMap();
                listJob[pos].put("job_code", ocrs.getString("job_code"));
                listJob[pos].put("JOB_NAME", ocrs.getString("JOB_NAME"));
                listJob[pos].put("ID", ocrs.getString("dept_id"));
                listJob[pos].put("NUMBER_OF_EMPLOYEE", ocrs.getString("NUMBER_OF_EMPLOYEE"));
                pos += 1;
            }
            _rs.close();
            _ps.close();

            return listJob;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public int countDeptJOb(long deptID) {



//        String str = "select max(rownum) as count " +
//                "from(TBL_DEPARTMENT INNER JOIN hr_dept_job on TBL_DEPARTMENT.dept_id=hr_dept_job.DEPT_ID)" +
//                "INNER JOIN hr_lu_job_type ON hr_dept_job.JOB_CODE = hr_lu_job_type.JOB_CODE where TBL_DEPARTMENT.DEPT_ID =" + deptID + "";


        String str = "SELECT MAX(rownum) AS COUNT " +
                "FROM(TBL_DEPT_BUNNA " +
                "INNER JOIN hr_dept_job " +
                "ON TBL_DEPT_BUNNA.dept_id=hr_dept_job.DEPT_ID) " +
                "INNER JOIN hr_lu_job_type " +
                "ON hr_dept_job.JOB_CODE      = hr_lu_job_type.JOB_CODE " +
                "WHERE TBL_DEPT_BUNNA.DEPT_ID =" + deptID + "";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            if (ocrs.next()) {
                _rs.close();
                _ps.close();

                return ocrs.getInt("count");
            } else {
                _rs.close();
                _ps.close();

                return 0;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return 0;
    }

    public int deleteDeptUsingID(String departmentID, String jobCode) {


        int checkSave;
        String str = "delete from hr_dept_job where DEPT_ID='" + departmentID + "' and JOB_CODE='" + jobCode + "'   ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            checkSave = _ps.executeUpdate();
            _ps.close();

            return checkSave;
        } catch (Exception ex) {

            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }


    }

    public int deleteDeptJob(String departmentID) {



        int checkSave;
        String str = "delete from hr_dept_job where DEPT_ID=" + departmentID + "";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            int rowAffected = _ps.executeUpdate();
            _ps.close();

            return rowAffected;

        } catch (Exception ex) {

            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }


    }

    public int deleteDeptJob(String departmentID, String job_code) {


        String str = "delete from hr_dept_job where DEPT_ID=" + departmentID + " and job_code=" + job_code + "";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            int rowAffected = _ps.executeUpdate();
            _ps.close();

            return rowAffected;

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }


    }

    public int cout() {



        String str = "select count(*) as num from TBL_DEPT_BUNNA";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _rs = _ps.executeQuery();
            _rs.next();
            return _rs.getInt("num");

        } catch (Exception ex) {
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }


        return 0;
    }

    public HashMap[] tracDepartemnt() {

        String str = "select * from TBL_DEPT_BUNNA order by dept_id";
        HashMap[] list;
        list = new HashMap[this.cout()];
        try {
            int i = 0;
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _rs = _ps.executeQuery();

            while (_rs.next()) {

                if (!_rs.getString("DEPT_ID").equals("999999999")) {
                    list[i] = new HashMap();
                    list[i].put("DEPT_ID", _rs.getString("DEPT_ID"));
                    list[i].put("dep_description", _rs.getString("dep_description"));
                    list[i].put("BRANCH_ID", _rs.getString("BRANCH_ID"));

                    i++;
                }
            }
            _ps.close();


            return list;
        } catch (Exception ex) {


            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return null;
    }

       public String traceDepartemttNameBiruk(String dept_id) {



        String str ="SELECT DEPT_NAME,dept_id FROM TBL_DEPT_BUNNA WHERE dept_id=" + dept_id +" ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _rs = _ps.executeQuery();
            _rs.next();
            return _rs.getString("DEPT_NAME")+"--"+_rs.getString("dept_id");

        } catch (Exception ex) {
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }


        return null;
    }






    public String traceDepartemtnDesc(String departemntID) {
        try {


            DepartmentEntity dep = new DepartmentEntity();
            HashMap[] list = dep.tracDepartemnt();
            HashMap[] list1;
            String description = "";
            String description2 = "";
            list1 = list;
            String name = departemntID;
            for (int i = 0; i < list.length; i++) {
                for (int j = 0; j < list1.length - 2; j++) {
                    if (list1[j].get("DEPT_ID") != null)
                    {

                        if (list1[j].get("DEPT_ID").equals(name)) {

                            description += list1[j].get("dep_description").toString() + "#";//+list[j].get("DEPT_ID").toString()
                            
                            name = list1[j].get("BRANCH_ID").toString();
                           

                        }
                    } else {
                        break;
                    }
                }
            }
            boolean found = true;
            int index = description.lastIndexOf("#");
            while (found) {
                description2 += "[" + description.substring(index + 1, description.length()) + "]";
                description = description.substring(0, index);
                index = description.lastIndexOf("#");
                if (index <= 0) {
                    found = false;
                }
            }
            description2 += "[" + description + "]";
            
            return description2.substring(16);
                    //description2.substring(16);//
                   // description2.substring(23);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    public int insertJob(DepartmentEntity saveJob, DepartmentEntity educLevel, DepartmentEntity qualification, int saveIndicator, String jobID) {

        String insert = "INSERT INTO hr_lu_job_type (JOB_DESCRIPTION, additionalSkill, min_Responsibility, RANK_ID,TYPE) " +
                "values( ?, ?, ?, ?, ?)";

        String insertEducLevel1 = "INSERT INTO HR_LU_JOB_TYPE_EDUC_LEVEL (EDUCATION_LEVEL, MIN_EXPERIENCE,JOB_CODE) " +
                "values(?, ?, ?)";
        String insertQualification1 = "INSERT INTO HR_LU_JOB_TYPE_QUALIFICATION (QUALIFICATION, JOB_CODE) " +
                "values(?, ?)";


        PreparedStatement psE = null;
        PreparedStatement psQ = null;
        PreparedStatement psM = null;


        int saveCheck = 0;
        String maxID = "";

        try {
            _con = getConnection();
            _con.setAutoCommit(false);

            if (saveIndicator > 0) {


                if (educLevel != null && qualification != null) {

                    psE = _con.prepareStatement(insertEducLevel1);
                    psQ = _con.prepareStatement(insertQualification1);

                    psE.setString(1, educLevel.getLevelOfEducation());
                    psE.setString(2, educLevel.getMinimumExperiance());
                    psE.setString(3, jobID);

                    psQ.setString(1, qualification.getQualifcation());
                    psQ.setString(2, jobID);

                    if (psE.executeUpdate() != 0 && psQ.executeUpdate() != 0) {
                        saveCheck = 1;
                        _con.commit();
                    }

                } else if (educLevel != null && qualification == null) {

                    psE = _con.prepareStatement(insertEducLevel1);


                    psE.setString(1, educLevel.getLevelOfEducation());
                    psE.setString(2, educLevel.getMinimumExperiance());
                    psE.setString(3, jobID);


                    if (psE.executeUpdate() != 0) {
                        saveCheck = 1;
                        _con.commit();
                    }

                } else if (educLevel == null && qualification != null) {

                    psQ = _con.prepareStatement(insertQualification1);


                    psQ.setString(1, qualification.getQualifcation());
                    psQ.setString(2, jobID);


                    if (psQ.executeUpdate() != 0) {
                        saveCheck = 1;
                        _con.commit();
                    }

                }



            } else if (saveIndicator == -1) {
                _ps = _con.prepareStatement(insert);
                _ps.setString(1, saveJob.getJobName());
                _ps.setString(2, saveJob.getAdditionalSkill());
                _ps.setString(3, saveJob.getResponsiblity());
                _ps.setString(4, saveJob.getRank());
                _ps.setString(5, saveJob.getType());

                if (_ps.executeUpdate() != 0) {
                    saveCheck = 1;
                    _con.commit();
                }
            }

            return saveCheck;
        } catch (SQLException ex) {
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                _ps.close();
                psE.close();
                psQ.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    public int updateJob(DepartmentEntity saveJob, DepartmentEntity updateEducLevel, DepartmentEntity updateQualification, String jobid) {
        String updateAll = " UPDATE hr_lu_job_type SET JOB_DESCRIPTION=?, " +
                " additionalSkill=?, min_Responsibility=?," +
                " RANK_ID=?,type=? WHERE JOB_CODE=?";

        String insertEduc = " UPDATE HR_LU_JOB_TYPE_EDUC_LEVEL SET EDUCATION_LEVEL=?, " +
                " MIN_EXPERIENCE=? " +
                " WHERE JOB_TYPE_EDUC_LEVEL_ID=?";

        String insertQual = " UPDATE HR_LU_JOB_TYPE_QUALIFICATION " +
                " SET QUALIFICATION = ?, " +
                " WHERE JOB_TYPE_QUALIFICATION_ID=?";


        PreparedStatement _psE = null;
        PreparedStatement _psQ = null;



        try {
            _con = getConnection();

            if (saveJob != null && updateEducLevel != null && updateQualification != null) {

                _ps = _con.prepareStatement(updateAll);

                _ps.setString(1, saveJob.getJobName());
                _ps.setString(2, saveJob.getAdditionalSkill());
                _ps.setString(3, saveJob.getResponsiblity());
                _ps.setString(4, saveJob.getRank());
                _ps.setString(5, saveJob.getType());
                _ps.setString(6, jobid);

                return _ps.executeUpdate();

            } else if (saveJob == null && updateEducLevel != null && updateQualification == null) {

                _psE = _con.prepareStatement(insertEduc);

                _psE.setString(1, updateEducLevel.getLevelOfEducation());
                _psE.setString(2, updateEducLevel.getMinimumExperiance());
                _psE.setString(3, updateEducLevel.getLevelOfEducationID());

                return _psE.executeUpdate();
            } else if (saveJob == null && updateEducLevel == null && updateQualification != null) {

                _psQ = _con.prepareStatement(insertQual);

                _psQ.setString(1, updateQualification.getQualifcation());
                _psQ.setString(2, jobid);

                return _psQ.executeUpdate();
            }


            return 0;


        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                _ps.close();
                _psQ.close();
                _psE.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    public ArrayList<HashMap[]> selectJobdetail1(String job_Code) {

        PreparedStatement _ps1 = null;
        PreparedStatement _ps2 = null;
        PreparedStatement _ps3 = null;
        PreparedStatement _ps4 = null;

        ResultSet _rs1 = null;
        ResultSet _rs2 = null;

        HashMap[] list = null;
        HashMap[] list1 = null;
        HashMap[] list2 = null;
        ArrayList<HashMap[]> aggrigateJob = new ArrayList<HashMap[]>();
        int i = 0;
        int j = 0;

        String str = " SELECT HR_LU_JOB_TYPE.JOB_CODE AS JOB_CODE, HR_LU_JOB_TYPE.JOB_DESCRIPTION, HR_LU_JOB_TYPE.MIN_RESPONSIBILITY," +
                " HR_LU_JOB_TYPE.ADDITIONALSKILL, HR_LU_JOB_TYPE.RANK_ID, HR_LU_JOB_TYPE.TYPE," +
                " HR_LU_JOB_TYPE_EDUC_LEVEL.JOB_TYPE_EDUC_LEVEL_ID, HR_LU_JOB_TYPE_EDUC_LEVEL.EDUCATION_LEVEL," +
                " HR_LU_JOB_TYPE_EDUC_LEVEL.MIN_EXPERIENCE, HR_LU_JOB_TYPE_EDUC_LEVEL.JOB_CODE" +
                " FROM  HR_LU_JOB_TYPE, HR_LU_JOB_TYPE_EDUC_LEVEL  " +
                " WHERE " +
                " HR_LU_JOB_TYPE.JOB_CODE = '" + job_Code + "'" +
                " AND " +
                " HR_LU_JOB_TYPE.JOB_CODE = HR_LU_JOB_TYPE_EDUC_LEVEL.JOB_CODE ";


        String str1 = " SELECT HR_LU_JOB_TYPE.JOB_CODE AS JOB_CODE, HR_LU_JOB_TYPE.JOB_DESCRIPTION, HR_LU_JOB_TYPE.MIN_RESPONSIBILITY," +
                " HR_LU_JOB_TYPE.ADDITIONALSKILL, HR_LU_JOB_TYPE.RANK_ID, HR_LU_JOB_TYPE.TYPE," +
                " HR_LU_JOB_TYPE_QUALIFICATION.JOB_TYPE_QUALIFICATION_ID, HR_LU_JOB_TYPE_QUALIFICATION.QUALIFICATION," +
                " HR_LU_JOB_TYPE_QUALIFICATION.JOB_CODE " +
                " FROM  HR_LU_JOB_TYPE, HR_LU_JOB_TYPE_QUALIFICATION " +
                " WHERE " +
                " HR_LU_JOB_TYPE.JOB_CODE = '" + job_Code + "'" +
                " AND " +
                " HR_LU_JOB_TYPE.JOB_CODE = HR_LU_JOB_TYPE_QUALIFICATION.JOB_CODE ";
        String str2 = " SELECT * " +
                " FROM " +
                " HR_LU_JOB_TYPE_QUALIFICATION " +
                " WHERE " +
                " HR_LU_JOB_TYPE_QUALIFICATION.JOB_CODE = '" + job_Code + "'";

        String str3 = " SELECT * " +
                " FROM " +
                " HR_LU_JOB_TYPE_EDUC_LEVEL " +
                " WHERE " +
                " HR_LU_JOB_TYPE_EDUC_LEVEL.JOB_CODE = '" + job_Code + "'";

        String str4 = " SELECT HR_LU_JOB_TYPE.JOB_CODE AS JOB_CODE, HR_LU_JOB_TYPE.JOB_DESCRIPTION, HR_LU_JOB_TYPE.MIN_RESPONSIBILITY," +
                " HR_LU_JOB_TYPE.ADDITIONALSKILL, HR_LU_JOB_TYPE.RANK_ID, HR_LU_JOB_TYPE.TYPE " +
                " FROM " +
                " HR_LU_JOB_TYPE " +
                " WHERE " +
                " HR_LU_JOB_TYPE.JOB_CODE = '" + job_Code + "'";


        try {

            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _ps1 = _con.prepareStatement(str1);
            _ps2 = _con.prepareStatement(str2);
            _ps3 = _con.prepareStatement(str3);
            _ps4 = _con.prepareStatement(str4);


            if (_ps2.executeUpdate() > 0 && _ps3.executeUpdate() > 0) {
                _rs = _ps.executeQuery();
                OracleCachedRowSet ocrs = new OracleCachedRowSet();
                ocrs.populate(_rs);
                _rs.close();
                list = new HashMap[ocrs.size()];

                _rs1 = _ps1.executeQuery();
                OracleCachedRowSet ocrs1 = new OracleCachedRowSet();
                ocrs1.populate(_rs1);
                _rs1.close();
                list1 = new HashMap[ocrs1.size()];

                if (ocrs.size() >= ocrs1.size()) {

                    while (ocrs.next()) {
                        list[i] = new HashMap();

                        if (i < ocrs1.size() && ocrs1.next() == true) {
                            list1[i] = new HashMap();
                            list[i].put("JOB_CODE", ocrs.getString("JOB_CODE"));
                            list[i].put("JOB_DESCRIPTION", ocrs.getString("JOB_DESCRIPTION"));
                            list[i].put("MIN_RESPONSIBILITY", ocrs.getString("MIN_RESPONSIBILITY"));
                            list[i].put("ADDITIONALSKILL", ocrs.getString("ADDITIONALSKILL"));
                            list[i].put("RANK_ID", ocrs.getString("RANK_ID"));
                            list[i].put("TYPE", ocrs.getString("TYPE"));
                            list[i].put("JOB_TYPE_EDUC_LEVEL_ID", ocrs.getString("JOB_TYPE_EDUC_LEVEL_ID"));
                            list[i].put("EDUCATION_LEVEL", ocrs.getString("EDUCATION_LEVEL"));
                            list[i].put("MIN_EXPERIENCE", ocrs.getString("MIN_EXPERIENCE"));
                            list1[i].put("JOB_TYPE_QUALIFICATION_ID", ocrs1.getString("JOB_TYPE_QUALIFICATION_ID"));
                            list1[i].put("QUALIFICATION", ocrs1.getString("QUALIFICATION"));
                        } else {
                            list[i].put("JOB_CODE", ocrs.getString("JOB_CODE"));
                            list[i].put("JOB_DESCRIPTION", ocrs.getString("JOB_DESCRIPTION"));
                            list[i].put("MIN_RESPONSIBILITY", ocrs.getString("MIN_RESPONSIBILITY"));
                            list[i].put("ADDITIONALSKILL", ocrs.getString("ADDITIONALSKILL"));
                            list[i].put("RANK_ID", ocrs.getString("RANK_ID"));
                            list[i].put("TYPE", ocrs.getString("TYPE"));
                            list[i].put("JOB_TYPE_EDUC_LEVEL_ID", ocrs.getString("JOB_TYPE_EDUC_LEVEL_ID"));
                            list[i].put("EDUCATION_LEVEL", ocrs.getString("EDUCATION_LEVEL"));
                            list[i].put("MIN_EXPERIENCE", ocrs.getString("MIN_EXPERIENCE"));

                        }

                        i++;
                    }
                } else if (ocrs1.size() > ocrs.size()) {

                    while (ocrs1.next()) {
                        list1[i] = new HashMap();
                        if (i < ocrs.size() && ocrs.next() == true) {
                            list[i] = new HashMap();
                            list1[i].put("JOB_CODE", ocrs1.getString("JOB_CODE"));
                            list1[i].put("JOB_DESCRIPTION", ocrs1.getString("JOB_DESCRIPTION"));
                            list1[i].put("MIN_RESPONSIBILITY", ocrs1.getString("MIN_RESPONSIBILITY"));
                            list1[i].put("ADDITIONALSKILL", ocrs1.getString("ADDITIONALSKILL"));
                            list1[i].put("RANK_ID", ocrs1.getString("RANK_ID"));
                            list1[i].put("TYPE", ocrs1.getString("TYPE"));
                            list[i].put("JOB_TYPE_EDUC_LEVEL_ID", ocrs.getString("JOB_TYPE_EDUC_LEVEL_ID"));
                            list[i].put("EDUCATION_LEVEL", ocrs.getString("EDUCATION_LEVEL"));
                            list[i].put("MIN_EXPERIENCE", ocrs.getString("MIN_EXPERIENCE"));
                            list1[i].put("JOB_TYPE_QUALIFICATION_ID", ocrs1.getString("JOB_TYPE_QUALIFICATION_ID"));
                            list1[i].put("QUALIFICATION", ocrs1.getString("QUALIFICATION"));
                        } else {
                            list1[i].put("JOB_CODE", ocrs1.getString("JOB_CODE"));
                            list1[i].put("JOB_DESCRIPTION", ocrs1.getString("JOB_DESCRIPTION"));
                            list1[i].put("MIN_RESPONSIBILITY", ocrs1.getString("MIN_RESPONSIBILITY"));
                            list1[i].put("ADDITIONALSKILL", ocrs1.getString("ADDITIONALSKILL"));
                            list1[i].put("RANK_ID", ocrs1.getString("RANK_ID"));
                            list1[i].put("TYPE", ocrs1.getString("TYPE"));
                            list1[i].put("JOB_TYPE_QUALIFICATION_ID", ocrs1.getString("JOB_TYPE_QUALIFICATION_ID"));
                            list1[i].put("QUALIFICATION", ocrs1.getString("QUALIFICATION"));

                        }

                        i++;
                    }
                }
                aggrigateJob.add(list);
                aggrigateJob.add(list1);
            } else {
                _rs2 = _ps4.executeQuery();
                OracleCachedRowSet ocrs3 = new OracleCachedRowSet();
                ocrs3.populate(_rs2);
                _rs2.close();
                list2 = new HashMap[ocrs3.size()];

                while (ocrs3.next()) {
                    list2[i] = new HashMap();
                    list2[i].put("JOB_CODE", ocrs3.getString("JOB_CODE"));
                    list2[i].put("JOB_DESCRIPTION", ocrs3.getString("JOB_DESCRIPTION"));
                    list2[i].put("MIN_RESPONSIBILITY", ocrs3.getString("MIN_RESPONSIBILITY"));
                    list2[i].put("ADDITIONALSKILL", ocrs3.getString("ADDITIONALSKILL"));
                    list2[i].put("RANK_ID", ocrs3.getString("RANK_ID"));
                    list2[i].put("TYPE", ocrs3.getString("TYPE"));

                    i++;
                }
                aggrigateJob.add(list2);
            }

            return aggrigateJob;

        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                _ps.close();
                _ps1.close();
                _ps2.close();
                _ps3.close();
                _ps4.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    public ArrayList<DepartmentEntity> readAllJob(String Dept_Id) {
        String _select = " SELECT hr_lu_job_type.job_Code AS job_Code ,hr_lu_job_type.JOB_NAME," +
                " TBL_DEPT_BUNNA.DEPT_ID, HR_DEPT_JOB.DEPT_ID, HR_DEPT_JOB.JOB_CODE" +
                " FROM  hr_lu_job_type, HR_DEPT_JOB, TBL_DEPT_BUNNA" +
                " WHERE " +
                " TBL_DEPT_BUNNA.DEPT_ID = '" + Dept_Id + "'" +
                " AND " +
                " TBL_DEPT_BUNNA.DEPT_ID = HR_DEPT_JOB.DEPT_ID " +
                " AND " +
                " hr_lu_job_type.job_Code = HR_DEPT_JOB.JOB_CODE " +
                " order by JOB_NAME asc";



        ArrayList<DepartmentEntity> readJobFrDb = new ArrayList<DepartmentEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = (ResultSet) _ps.executeQuery();
            while (_rs.next()) {

                this.code = _rs.getString("job_Code");
                this.description = _rs.getString("JOB_NAME");

                DepartmentEntity departmentEntity = new DepartmentEntity(code, description);
                readJobFrDb.add(departmentEntity);
            }
            return readJobFrDb;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    public String traceDepartemtnId(String departemntID) {

        int departemntIndex = departemntID.length();
        DepartmentEntity dep = new DepartmentEntity();
        if (departemntIndex != 2) {
            try {

                HashMap[] list = dep.tracDepartemnt();
                HashMap[] list1;
                String description = "";
                String description2 = "";
                list1 = list;
                String name = departemntID;
                for (int i = 0; i < list.length; i++) {
                    for (int j = 0; j < list1.length - 2; j++) {
                        if (list1[j].get("DEPT_ID") != null) {

                            if (list1[j].get("DEPT_ID").equals(name)) {

                                description += list1[j].get("DEPT_ID").toString() + "#";//+list[j].get("DEPT_ID").toString()
                                name = list1[j].get("BRANCH_ID").toString();
                            }
                        } else {
                            break;
                        }
                    }
                }
                boolean found = true;
                int size = description.length();
                if (size > 0) {

                    description = description.substring(0, size - 1);
                } else {

                    description = description.substring(0, size);
                    return description;
                }
                int index = description.lastIndexOf("#");
                while (found) {
                    description2 += description.substring(index + 1, description.length()) + "-";
                    description = description.substring(0, index);
                    index = description.lastIndexOf("#");
                    if (index <= 0) {
                        found = false;
                    }
                }
                description2 += description;//+ "-";
                return description2;//.substring(16);//description2.substring(23);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return departemntID;
        }

    }

    public int readNextBranchId(int perform) {


        ResultSet rs = null;
        try {
            _con = getConnection();
            if (perform == 2) {
                _ps = _con.prepareStatement(" SELECT MAX(dept_id) as maxDeptId FROM TBL_DEPT_BUNNA t  WHERE " +
                        " t.dept_id LIKE '___'");
            } else if (perform == 3) {
                _ps = _con.prepareStatement(" SELECT MAX(dept_id) as maxDeptId FROM TBL_DEPT_BUNNA t  WHERE " +
                        " t.dept_id LIKE '____'");
            } else if (perform == 4) {
                _ps = _con.prepareStatement(" SELECT MAX(dept_id) as maxDeptId FROM TBL_DEPT_BUNNA t  WHERE " +
                        " t.dept_id LIKE '_____'");
            } else if (perform == 5) {
                _ps = _con.prepareStatement(" SELECT MAX(dept_id) as maxDeptId FROM TBL_DEPT_BUNNA t  WHERE " +
                        " t.dept_id LIKE '______'");
            } else if (perform == 6) {
                _ps = _con.prepareStatement(" SELECT MAX(dept_id) as maxDeptId FROM TBL_DEPT_BUNNA t  WHERE " +
                        " t.dept_id LIKE '_______'");
            } else if (perform == 7) {
                _ps = _con.prepareStatement(" SELECT MAX(dept_id) as maxDeptId FROM TBL_DEPT_BUNNA t  WHERE " +
                        " t.dept_id LIKE '________'");
            } else if (perform == 8) {
                _ps = _con.prepareStatement(" SELECT MAX(dept_id) as maxDeptId FROM TBL_DEPT_BUNNA t  WHERE " +
                        " t.dept_id LIKE '_________'");
            } else if (perform == 9) {
                _ps = _con.prepareStatement(" SELECT MAX(dept_id) as maxDeptId FROM TBL_DEPT_BUNNA t  WHERE " +
                        " t.dept_id LIKE '_________'");
            } else if (perform == 10) {
                _ps = _con.prepareStatement(" SELECT MAX(dept_id) as maxDeptId FROM TBL_DEPT_BUNNA t  WHERE " +
                        " t.dept_id LIKE '_________'");
            }
            rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            ocrs.next();
            rs.close();
            _ps.close();

            return ocrs.getInt("maxDeptId");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }//end of readNextOrganizationId() method
}





