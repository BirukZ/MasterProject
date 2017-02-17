/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.employeeHistoryEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author Preferred Customer
 */
public class EvaluationCriteria extends ConnectionManager{

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
    private String evaCriteriaCategory;
    private String evaCriteria;
    private String evaCriteriaDesc;
    private int evaParaCode;
    private int purpID;
    private String purpName;

    /**
     * @return the purpID
     */
    public int getPurpID() {
        return purpID;
    }

    /**
     * @param purpID the purpID to set
     */
    public void setPurpID(int purpID) {
        this.purpID = purpID;
    }

    /**
     * @return the purpName
     */
    public String getPurpName() {
        return purpName;
    }

    /**
     * @param purpName the purpName to set
     */
    public void setPurpName(String purpName) {
        this.purpName = purpName;
    }

    /**
     * @return the evaParaCode
     */
    public int getEvaParaCode() {
        return evaParaCode;
    }

    /**
     * @param evaParaCode the evaParaCode to set
     */
    public void setEvaParaCode(int evaParaCode) {
        this.evaParaCode = evaParaCode;
    }

    /**
     *
     */
    public EvaluationCriteria() {
    }

    /**
     *
     * @param evaCriteriaCode
     * @param evaCriteria
     * @param evaCriteriaDesc
     */
    public EvaluationCriteria(int purpID, String purpName) {
        this.purpID = purpID;
        this.purpName = purpName;
    }

    public EvaluationCriteria(String evaCriteria, String evaCriteriaDesc, String evaCriteriaCategory) {
        this.evaCriteriaCategory = evaCriteriaCategory;
        this.evaCriteria = evaCriteria;
        this.evaCriteriaDesc = evaCriteriaDesc;
    }

    /**
     * @return the evaCriteriaCode
     */
    public String getEvaCriteriaCategory() {
        return evaCriteriaCategory;
    }

    /**
     * @param evaCriteriaCode the evaCriteriaCode to set
     */
    public void setEvaCriteriaCategory(String evaCriteriaCategory) {
        this.evaCriteriaCategory = evaCriteriaCategory;
    }

    /**
     * @return the evaCriteria
     */
    public String getEvaCriteria() {
        return evaCriteria;
    }

    /**
     * @param evaCriteria the evaCriteria to set
     */
    public void setEvaCriteria(String evaCriteria) {
        this.evaCriteria = evaCriteria;
    }

    /**
     * @return the evaCriteriaDesc
     */
    public String getEvaCriteriaDesc() {
        return evaCriteriaDesc;
    }

    /**
     * @param evaCriteriaDesc the evaCriteriaDesc to set
     */
    public void setEvaCriteriaDesc(String evaCriteriaDesc) {
        this.evaCriteriaDesc = evaCriteriaDesc;
    }

    /**
     *
     * @param evaCrtCode
     * @param evaCrt
     * @param evaCrtDesc
     */
    public int addEvaCrt(String evaCrtDesc, String evaCrt, String evaCrtCategory) {
        try {
            this.setEvaCriteriaCategory(evaCrtCategory);
            this.setEvaCriteria(evaCrt);
            this.setEvaCriteriaDesc(evaCrtDesc);

            return this.insertEvaCrt();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }
    }

    public int addEvaCrtPurpose(String purpName) {
        this.setPurpName(purpName);


        return this.insertEvaCrtPurpose();
    }

    /**
     *
     */
    private int insertEvaCrt() throws SQLException {

        String insEvaCrt = "INSERT INTO hr_lu_evaluation_parameter (description , name , category)  VALUES 	(?, ?, ?) ";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(insEvaCrt);
            _ps.setString(1, getEvaCriteriaDesc());
            _ps.setString(2, getEvaCriteria());
            _ps.setString(3, getEvaCriteriaCategory());

            return _ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }
    }

    private int insertEvaCrtPurpose() {




        String insEvaCrt = "INSERT INTO HR_EVA_PURPOSE (PURPOSE_NAME)  VALUES 	(?) ";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(insEvaCrt);
            _ps.setString(1, this.getPurpName());
            return _ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
               releaseResources();
            } catch (Exception ignore) {
            }

        }
    }

    /**
     *
     * @param evaCrtCode
     * @return
     */
    public int deleteEvaCrt(int purpId) {




        String delEvaCrt = "DELETE FROM hr_lu_evaluation_parameter WHERE EVALUATION_PARA_CODE = ?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(delEvaCrt);
            _ps.setInt(1, purpId);

            return _ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }
    }

    public int deleteEvaCrtPurp(int evaCrtParaCode) {




        String delEvaCrt = "DELETE FROM HR_EVA_PURPOSE WHERE PURPOSE_ID = ?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(delEvaCrt);
            _ps.setInt(1, evaCrtParaCode);

            return _ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }
    }

    /**
     *
     * @param evaCrt
     * @return
     */
    public ResultSet readEvaCrt(String evaCrt) {

        ResultSet evaRs;
        String readEvaCrt = "SELECT ALL hr_lu_evaluation_parameter.evaluation_Para_Code, " +
                "hr_lu_evaluation_parameter.name, hr_lu_evaluation_parameter.description  " +
                "FROM hr_lu_evaluation_parameter " +
                "WHERE hr_lu_evaluation_parameter.evaluation_Para_Code = ?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(readEvaCrt);
            _ps.setString(1, evaCrt);
            return _ps.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                releaseResources();;
            } catch (Exception ignore) {
            }

        }
    }

    /**
     *
     * @param evaCrtCode
     * @param evaCrtName
     * @param evaCrtDesc
     */
    public int updateEvaCrt(int evaParaCode, String evaCrtCategory, String evaCrtName, String evaCrtDesc) {




        String strUpdateEvaCrt = ("UPDATE hr_lu_evaluation_parameter set category=?, " +
                "name=?, description=? WHERE evaluation_Para_Code='" + evaParaCode + "'");
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(strUpdateEvaCrt);
            _ps.setString(1, evaCrtCategory);
            _ps.setString(2, evaCrtName);
            _ps.setString(3, evaCrtDesc);

            return _ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }
    }

    public int updateEvaCrtPurp(int purpId, String purpName) {




        String strUpdateEvaCrt = ("UPDATE HR_EVA_PURPOSE set PURPOSE_NAME=? " +
                " WHERE PURPOSE_ID='" + purpId + "'");
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(strUpdateEvaCrt);
            _ps.setString(1, purpName);


            return _ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }
    }

    public int countEvaCriteriaUsing() {



        HashMap[] list = null;
        String str = "SELECT Max(rownum) as num FROM hr_lu_evaluation_parameter ";
        try {

            _con = getConnection();
            _ps = _con.prepareStatement(str);

            _rs = _ps.executeQuery();
            if (_rs.next()) {
                return _rs.getInt("num");
            }
            return 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }
    }

    public int countEvaCriteriaPurpose() {



        HashMap[] list = null;
        String str = "SELECT Max(rownum) as num FROM HR_EVA_PURPOSE ";
        try {

            _con = getConnection();
            _ps = _con.prepareStatement(str);

            _rs = _ps.executeQuery();
            if (_rs.next()) {
                return _rs.getInt("num");
            }
            return 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }
    }

    public HashMap[] readEvaCriteriaEdit() {



        HashMap[] list = null;
        int i = 0;
        String description = "No Description";


        String str = "SELECT * FROM hr_lu_evaluation_parameter ";
        try {
            list = new HashMap[this.countEvaCriteriaUsing()];
            _con = getConnection();
            _ps = _con.prepareStatement(str);

            _rs = _ps.executeQuery();
            while (_rs.next()) {
                list[i] = new HashMap();
                list[i].put("EVALUATION_PARA_CODE", _rs.getInt("EVALUATION_PARA_CODE"));
                list[i].put("NAME", _rs.getString("NAME"));
                list[i].put("CATEGORY", _rs.getString("CATEGORY"));
                if (_rs.getString("DESCRIPTION") != null) {
                    description = _rs.getString("DESCRIPTION");
                }
                list[i].put("DESCRIPTION", description);
                description = "No Description";
                i++;
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
               releaseResources();
            } catch (Exception ignore) {
            }

        }
    }

    public ArrayList<EvaluationCriteria> readAllPurpose() {

        String readEva = "SELECT  * FROM  HR_EVA_PURPOSE ";


        ArrayList<EvaluationCriteria> resultList = new ArrayList<EvaluationCriteria>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(readEva);
            _rs = _ps.executeQuery();

            while (_rs.next()) {
                EvaluationCriteria resultType = new EvaluationCriteria(Integer.valueOf(_rs.getString("PURPOSE_ID").toString()), _rs.getString("PURPOSE_NAME"));
                resultList.add(resultType);
            }

           return resultList;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }

    }

    public HashMap[] readEvaCriteriaEditPurpose() {



        HashMap[] list = null;
        int i = 0;



        String str = "SELECT  * FROM  HR_EVA_PURPOSE ";
        try {
            list = new HashMap[this.countEvaCriteriaPurpose()];
            _con = getConnection();
            _ps = _con.prepareStatement(str);

            _rs = _ps.executeQuery();
            while (_rs.next()) {
                list[i] = new HashMap();
                list[i].put("PURPOSE_ID", _rs.getInt("PURPOSE_ID"));
                list[i].put("PURPOSE_NAME", _rs.getString("PURPOSE_NAME"));

                i++;
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
               releaseResources();
            } catch (Exception ignore) {
            }

        }
    }

    public String readSinglePurpose(int purpID) {




        String readEva = "SELECT  * FROM  HR_EVA_PURPOSE WHERE HR_EVA_PURPOSE.PURPOSE_ID = '" + purpID + "' ";


        String resultList = "";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(readEva);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                resultList = _rs.getString("PURPOSE_NAME").toString();
            }
            return resultList;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
               releaseResources();
            } catch (Exception ignore) {
            }

        }


    }

    public HashMap[] readEvaCriteriaEditFilter(int purp) {



        HashMap[] list = null;
        int i = 0;
        String description = "No Description";


        String str = " SELECT * FROM hr_lu_evaluation_parameter, HR_EVA_PURPOSE " +
                " WHERE " +
                " HR_EVA_PURPOSE.PURPOSE_ID = '" + purp + "'" +
                " AND HR_EVA_PURPOSE.PURPOSE_NAME =  hr_lu_evaluation_parameter.CATEGORY ";
        try {
            list = new HashMap[this.countEvaCriteriaUsing()];
            _con = getConnection();
            _ps = _con.prepareStatement(str);

            _rs = _ps.executeQuery();
            while (_rs.next()) {
                list[i] = new HashMap();
                list[i].put("EVALUATION_PARA_CODE", _rs.getInt("EVALUATION_PARA_CODE"));
                list[i].put("NAME", _rs.getString("NAME"));
                list[i].put("CATEGORY", _rs.getString("CATEGORY"));
                if (_rs.getString("DESCRIPTION") != null) {
                    description = _rs.getString("DESCRIPTION");
                }
                list[i].put("DESCRIPTION", description);
                description = "No Description";
                i++;
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();

            return null;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }
    }
}
