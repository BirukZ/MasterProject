/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.recruitmentEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//import javax.swing.JOptionPane;
//import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.driver.OracleResultSetMetaData;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Administrator
 */
public class CandidateExperienceEntity extends ConnectionManager {

    String institution;
    String terminationReason;
    String rank;
    String startDate;
    String copletionDate;
    String salary;
    String job_Code;
    String id;
    String experiencePrivateOrGovernmental;
    String experienceContractOrPrtmanent;
    String candidateId;
    String job_description;
    int expTotal;
    int expMonth;
    int expDay;
    String years;
    String months;
    String dates;
    String candidatNameList;
    int candidateID;
    private String expRelationType;
    int equvalentJobCode;
    Connection _con = null;
    PreparedStatement _ps = null;
    ResultSet _rs = null;
    int check = 0;

    private CandidateExperienceEntity(String CandidateName, int canidateID) {
        this.candidatNameList = CandidateName;
        this.candidateID = canidateID;
    }





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

    public int getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(int candidateID) {
        this.candidateID = candidateID;
    }

    // <editor-fold defaultstate="collapsed" desc="get & set ">
    public int getEquvalentJobCode() {
        return equvalentJobCode;
    }

    public String getCandidatNameList() {
        return candidatNameList;
    }

    public void setCandidatNameList(String candidatNameList) {
        this.candidatNameList = candidatNameList;
    }



    ////////////////////////////////////////////////////////////////////////////////////////////////////
        public ArrayList<CandidateExperienceEntity> selectAllCandidateNameForEinalSelection(String batchCode) {
            
        String _selectQuery ="select * from hr_candidate_for_exam where BATCHCODE= ? ";
        ArrayList<CandidateExperienceEntity> candidateNameList = new ArrayList<CandidateExperienceEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, batchCode.trim());
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                CandidateExperienceEntity List = new CandidateExperienceEntity(_rs.getString("CANDIDATENAME"), Integer.parseInt(_rs.getString("CANDIDATEID")));
                candidateNameList.add(List);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return candidateNameList;
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////


    public ArrayList<CandidateExperienceEntity> selectAllCandidateNameOnSelectedBatch(String batchCode) {
        String _selectQuery = "SELECT candidate_id, " +
                "  CANDIDATE_F_NAME " +
                "  ||' ' " +
                "  || CANDIDATE_M_NAME " +
                "  ||' ' " +
                "  ||CANDIDATE_L_NAME AS FullName , " +
                "  RECRUIT_BATCH_CODE " +
                " FROM HR_CANDIDATE " +
                " WHERE RECRUIT_BATCH_CODE=? ";
        ArrayList<CandidateExperienceEntity> candidateNameList = new ArrayList<CandidateExperienceEntity>();
        try {
            _con = getConnection();

            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, batchCode.trim());
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                CandidateExperienceEntity List = new CandidateExperienceEntity(_rs.getString("FullName"), Integer.parseInt(_rs.getString("candidate_id")));
                candidateNameList.add(List);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return candidateNameList;
    }

    public void setEquvalentJobCode(int equvalentJobCode) {
        this.equvalentJobCode = equvalentJobCode;
    }

    public String getJob_description() {
        return job_description;
    }

    public void setJob_description(String job_description) {
        this.job_description = job_description;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public String getCopletionDate() {
        return copletionDate;
    }

    public void setCopletionDate(String copletionDate) {
        this.copletionDate = copletionDate;
    }

    public String getExperienceContractOrPrtmanent() {
        return experienceContractOrPrtmanent;
    }

    public void setExperienceContractOrPrtmanent(String experienceContractOrPrtmanent) {
        this.experienceContractOrPrtmanent = experienceContractOrPrtmanent;
    }

    public String getExperiencePrivateOrGovernmental() {
        return experiencePrivateOrGovernmental;
    }

    public void setExperiencePrivateOrGovernmental(String experiencePrivateOrGovernmental) {
        this.experiencePrivateOrGovernmental = experiencePrivateOrGovernmental;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getJob_Code() {
        return job_Code;
    }

    public void setJob_Code(String job_Code) {
        this.job_Code = job_Code;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getTerminationReason() {
        return terminationReason;
    }

    public void setTerminationReason(String terminationReason) {
        this.terminationReason = terminationReason;
    }
    // </editor-fold>

    public CandidateExperienceEntity() {
    }

    public CandidateExperienceEntity(String institution, String terminationReason,
            String startDate, String copletionDate, String salary, String candidateId,
            String job_Code, String rank, String experiencePrivateOrGovernmental,
            String experienceContractOrPrtmanent, String id, String job_description,
            int equvalentJobCode, String expRelationType, String years, String month, String dates) {
        this.candidateId = candidateId;
        this.salary = salary;
        this.institution = institution;
        this.rank = rank;
        this.job_Code = job_Code;
        this.startDate = startDate;
        this.copletionDate = copletionDate;
        this.terminationReason = terminationReason;
        this.experienceContractOrPrtmanent = experienceContractOrPrtmanent;
        this.experiencePrivateOrGovernmental = experiencePrivateOrGovernmental;
        this.id = id;
        this.equvalentJobCode = equvalentJobCode;
        this.expRelationType = expRelationType;
        this.years = years;
        this.months = month;
        this.dates = dates;

    }

    public int saveCandidateExperience(CandidateExperienceEntity candidateExperienceEntity) {
        int checkSave = 0;
        String _select = "INSERT INTO hr_Candidate_experience " +
                "(EXPERIENCE_ID,CANDIDATE_ID,INSTITUION,START_DATE,END_DATE,SALARY," +
                "JOB_TITLE,RANK,REASON_FOR_TERMINATION,PERMANENT_OR_CONTRACT," +
                " PRIVATE_OR_GVTAL,EQUVALENTJOBCODE,EXP_RELATION_TYPE,EXPDETAIL,EXP_MONTH,EXP_DAY)" +
                " VALUES (HR_CANDIDATE_EXPIRANCE_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.setString(1, candidateExperienceEntity.getCandidateId());
            _ps.setString(2, candidateExperienceEntity.getInstitution());
            _ps.setString(3, candidateExperienceEntity.getStartDate());
            _ps.setString(4, candidateExperienceEntity.getCopletionDate());
            _ps.setString(5, candidateExperienceEntity.getSalary());
            _ps.setString(6, candidateExperienceEntity.getJob_Code());
            _ps.setString(7, candidateExperienceEntity.getRank());
            _ps.setString(8, candidateExperienceEntity.getTerminationReason());
            _ps.setString(9, candidateExperienceEntity.getExperienceContractOrPrtmanent());
            _ps.setString(10, candidateExperienceEntity.getExperiencePrivateOrGovernmental());
            _ps.setInt(11, candidateExperienceEntity.getEquvalentJobCode());
            _ps.setString(12, candidateExperienceEntity.getExpRelationType());
            _ps.setString(13, candidateExperienceEntity.getYears());
            _ps.setString(14, candidateExperienceEntity.getMonths());
            _ps.setString(15, candidateExperienceEntity.getDates());
            checkSave = _ps.executeUpdate();
            return checkSave;
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {

                ex.printStackTrace();
            }
        }
        return checkSave;
    }

    public int countExperiance(String empID) {
        String count = "SELECT Max(rownum)as num  from hr_Candidate_experience WHERE CANDIDATE_ID=?";
        Connection _conn;
        ResultSet rsFamily;
        int rownum;

        try {
            _conn = getConnection();
            _ps = _conn.prepareStatement(count);
            _ps.setString(1, empID);
            rsFamily = _ps.executeQuery();
            rsFamily.next();
            rownum = rsFamily.getInt("num");
            return rownum;
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

      public int CheckExistanceOfCandidate(String candidateId) {
          int backResult=0;
           Connection _conn;
           ResultSet _rss=null;
        String sqlCheck= "select STATUS FROM hr_can_total_expirance WHERE CAN_ID=?";
        try{
            _conn = getConnection();
            _ps = _conn.prepareStatement(sqlCheck);
            _ps.setString(1, candidateId);
             _rss = _ps.executeQuery();

             while(_rss.next())
             {
             backResult=1;

             }
             return backResult;
              } catch (Exception e) {
            e.printStackTrace();
            return backResult;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

          public int countExpRow(String empID) {
        HashMap[] list = null;
        int rownum;
        String str = "SELECT MAX(rownum) AS num " +
                     "FROM hr_candidate_experience " +
                     "WHERE candidate_id=?";
        try {

            _con = getConnection();
            _ps = _con.prepareStatement(str);
          _ps.setString(1, empID);
            _rs = _ps.executeQuery();
            if (_rs.next()) {
                rownum = _rs.getInt("num");
                return rownum;
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }




//    public HashMap[] readExperiance(String empID) {
//
//        Connection _conn;
//        ResultSet rsExper;
//        int i = 0;
//        HashMap[] _list = null;
//        String select = "SELECT * FROM hr_Candidate_experience WHERE CANDIDATE_ID=? ";
//        try {
//            _conn = getConnection();
//            _ps = _conn.prepareStatement(select);
//            _ps.setString(1, empID);
//            rsExper = _ps.executeQuery();
//          OracleResultSetMetaData count = (OracleResultSetMetaData) rsExper.getMetaData();
//          _list = new HashMap[count.getColumnCount()];
//         //  _list =new HashMap[this.countExperiance(empID)];
//           // JOptionPane.showMessageDialog(null,_list.length);
//            while (rsExper.next())
//            {
//                _list[i] = new HashMap();
//                _list[i].put("CANDIDATE_ID", rsExper.getString("CANDIDATE_ID"));
//                _list[i].put("RANK", rsExper.getString("RANK") == null ? "" : rsExper.getString("RANK"));
//                _list[i].put("INSTITUION", rsExper.getString("INSTITUION") == null ? "" : rsExper.getString("INSTITUION"));
//                _list[i].put("PRIVATE_OR_GVTAL", rsExper.getString("PRIVATE_OR_GVTAL"));
//                _list[i].put("START_DATE", rsExper.getString("START_DATE") == null ? "" : rsExper.getString("START_DATE"));
//                _list[i].put("END_DATE", rsExper.getString("END_DATE")==null ? "" :rsExper.getString("END_DATE"));
//                _list[i].put("JOB_TITLE", rsExper.getString("JOB_TITLE") == null ? "" : rsExper.getString("JOB_TITLE"));
//                _list[i].put("PERMANENT_OR_CONTRACT", rsExper.getString("PERMANENT_OR_CONTRACT"));
//                _list[i].put("SALARY", rsExper.getString("SALARY") == null ? "" : rsExper.getString("SALARY"));
//                _list[i].put("REASON_FOR_TERMINATION", rsExper.getString("REASON_FOR_TERMINATION") == null ? "" : rsExper.getString("REASON_FOR_TERMINATION"));
//                _list[i].put("EXPERIENCE_ID", Integer.toString(rsExper.getInt("EXPERIENCE_ID")));
//                _list[i].put("EQUVALENTJOBCODE", Integer.toString(rsExper.getInt("EQUVALENTJOBCODE")));
//                _list[i].put("EXP_RELATION_TYPE", rsExper.getString("EXP_RELATION_TYPE"));
//                _list[i].put("EXPDETAIL", rsExper.getString("EXPDETAIL"));
//                _list[i].put("EXP_MONTH", rsExper.getString("EXP_MONTH"));
//                _list[i].put("EXP_DAY", rsExper.getString("EXP_DAY"));
//                i++;
//            }
//
//            return _list;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//
//            return null;
//        } finally {
//            try {
//                releaseResources();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        }
//    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        public ResultSet readExperianceNew(String empID) {

        Connection _conn;
        ResultSet rsExper;
        int i = 0;
        HashMap[] _list = null;
        String select = "SELECT * FROM hr_Candidate_experience WHERE CANDIDATE_ID=? ";
        try {
            _conn = getConnection();
            _ps = _conn.prepareStatement(select);
            _ps.setString(1, empID);
            rsExper = _ps.executeQuery();
              OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rsExper);
            return (ResultSet) ocrs;
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







    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////







    public int SelectCandidateExpirance(String candidateId)
        {
        int backResult=0;

        String _selectQueary = "SELECT ((CC.TotalYear*365)+(CC.TotalMonth*30)+(CC.totalDay)) AS TOTALdAYS " +
                "FROM " +
                "  (SELECT SUM(BB.EXPDETAIL) AS TotalYear, " +
                "    SUM(BB.EXP_MONTH)       AS TotalMonth, " +
                "    SUM(BB.EXP_DAY)         AS totalDay " +
                "  FROM " +
                "    (SELECT EXPDETAIL, " +
                "      EXP_MONTH, " +
                "      EXP_DAY, " +
                "      CANDIDATE_ID " +
                "    FROM HR_CANDIDATE_EXPERIENCE " +
                "    WHERE CANDIDATE_ID='"+ candidateId+"' " +
                "    )BB " +
                "  )CC";
         try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQueary);
            _rs = _ps.executeQuery();
            while(_rs.next()){

            backResult=Integer.parseInt(_rs.getString("TOTALdAYS"));

            }


            return backResult;

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
        return backResult;

    }

    public int deleteCandidateExperiance(String id) {

        String _deletet = "DELETE FROM hr_Candidate_experience WHERE EXPERIENCE_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_deletet);
            _ps.setInt(1, Integer.parseInt(id));
            check = _ps.executeUpdate();
            return check;

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
        public int SaveCandidateExpiranceTotal(String birukTotal, String candidateId,String status) {

       String _insertQueary= "INSERT INTO hr_can_total_expirance (CAN_ID,TOTAL_EXPIRANCE,STATUS) VALUES (?,?,?)";
             try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQueary);
            _ps.setString(1, candidateId);
            _ps.setString(2, birukTotal);
            _ps.setString(3, "SAVED");
            check = _ps.executeUpdate();
            return check;
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
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
      public int SaveCandidateExpiranceTotalUpdate(String birukTotal, String candidateId, String status) {
        String _updateQueary=" UPDATE hr_can_total_expirance SET TOTAL_EXPIRANCE =? where CAN_ID=?";
           try {
            _con = getConnection();
            _ps = _con.prepareStatement(_updateQueary);
            _ps.setString(1,birukTotal );
            _ps.setString(2, candidateId);
            check = _ps.executeUpdate();
            return check;
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
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


    public int updateCandidateExperience(CandidateExperienceEntity candidateExperienceEntity) 
    {
        
        String _select = "UPDATE hr_Candidate_experience SET  " +
                " CANDIDATE_ID=?,INSTITUION=?,START_DATE=?,END_DATE=?,SALARY=?,JOB_TITLE=?," +
                " RANK=?,REASON_FOR_TERMINATION=?, PERMANENT_OR_CONTRACT=?, " +
                " PRIVATE_OR_GVTAL=?,EQUVALENTJOBCODE=?,EXPDETAIL=?,EXP_MONTH=?,EXP_DAY=?  WHERE  EXPERIENCE_ID=?";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.setString(1, candidateExperienceEntity.getCandidateId());
            _ps.setString(2, candidateExperienceEntity.getInstitution());
            _ps.setString(3, candidateExperienceEntity.getStartDate());
            _ps.setString(4, candidateExperienceEntity.getCopletionDate());
            _ps.setString(5,(candidateExperienceEntity.getSalary()));
            _ps.setString(6, candidateExperienceEntity.getJob_Code());
            _ps.setString(7, candidateExperienceEntity.getRank());
            _ps.setString(8, candidateExperienceEntity.getTerminationReason());
            _ps.setString(9, candidateExperienceEntity.getExperienceContractOrPrtmanent());
            _ps.setString(10, candidateExperienceEntity.getExperiencePrivateOrGovernmental());
            _ps.setInt(11, candidateExperienceEntity.getEquvalentJobCode());        
            _ps.setString(12, candidateExperienceEntity.getYears());
            _ps.setString(13, candidateExperienceEntity.getMonths());
            _ps.setString(14, candidateExperienceEntity.getDates());
            _ps.setInt(15, Integer.parseInt(candidateExperienceEntity.getId()));
            check = _ps.executeUpdate();
            return check;
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
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

    /**
     * @return the expRelationType
     */
    public String getExpRelationType() {
        return expRelationType;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getMonths() {
        return months;
    }

    public void setMonths(String months) {
        this.months = months;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    /**
     * @param expRelationType the expRelationType to set
     */
    public void setExpRelationType(String expRelationType) {
        this.expRelationType = expRelationType;
    }

    public int getExpDay() {
        return expDay;
    }

    public void setExpDay(int expDay) {
        this.expDay = expDay;
    }

    public int getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(int expMonth) {
        this.expMonth = expMonth;
    }

    public int getExpTotal() {
        return expTotal;
    }

    public void setExpTotal(int expTotal) {
        this.expTotal = expTotal;
    }
}
