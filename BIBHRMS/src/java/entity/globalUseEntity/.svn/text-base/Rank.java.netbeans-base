/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.globalUseEntity;

/**
 *
 * @author Administrator
 */
import connectionProvider.ConnectionManager;
import java.sql.Connection;
import manager.globalUseManager.ErrorLogWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Rank extends ConnectionManager {
    /*
     * To change this template, choose Tools | Templates
     * and open the template in the editor.
     */

    /**
     *
     * @author Preferred Customer
     */
    private String rankID;
    private String description;
    private Double beginningSalary;
    private Double maxSalary;
    private String oldRandID;
    private String type;
    Connection _con = null;
    ResultSet _rs = null;
    PreparedStatement _ps = null;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOldRandID() {
        return oldRandID;
    }

    public void setOldRandID(String oldRandID) {
        this.oldRandID = oldRandID;
    }

    /**
     *
     */
    public Rank() {
    }

    /**
     *
     * @param rankID
     * @param description
     */
    public Rank(String rankID, String description) {
        this.rankID = rankID;
        this.description = description;
    }

    /**
     *
     * @param rankID
     * @param description
     * @param beginningSalary
     * @param maxSalary
     */
    public Rank(String rankID,
            String description,
            Double beginningSalary,
            Double maxSalary) {
        this.rankID = rankID;
        this.description = description;
        this.beginningSalary = beginningSalary;
        this.maxSalary = maxSalary;

    }

    /**
     * @return the rankID
     */
    public String getRankID() {
        return rankID;
    }

    /**
     * @param rankID the rankID to set
     */
    public void setRankID(String rankID) {
        this.rankID = rankID;
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
     * @return the beginningSalary
     */
    public Double getBeginningSalary() {
        return beginningSalary;
    }

    /**
     * @param beginningSalary the beginningSalary to set
     */
    public void setBeginningSalary(Double beginningSalary) {
        this.beginningSalary = beginningSalary;
    }

    /**
     * @return the maxSalary
     */
    public Double getMaxSalary() {
        return maxSalary;
    }

    /**
     * @param maxSalary the maxSalary to set
     */
    public void setMaxSalary(Double maxSalary) {
        this.maxSalary = maxSalary;
    }

    /**
     * The method reads all rank from hr_lu_rank with the specified rank type
     * which can indicate rank for military or civil.
     * @param type can be either 1 or 2 indicating civil or military respectively.
     * @return an ArrayList of type Rank
     */
    public ArrayList<Rank> readRankList(String type) {


        ResultSet rs = null;
        ArrayList<Rank> rankList = new ArrayList<Rank>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement("select * from hr_lu_rank where type = '" + type + "'");


            rs = _ps.executeQuery();
            while (rs.next()) {
                Rank rankType = new Rank(rs.getString("rank_Id"), rs.getString("description"), Double.parseDouble(rs.getString("beginning_Salary")), Double.parseDouble(rs.getString("max_Salary")));
                rankList.add(rankType);
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
        return rankList;
    }

    /**
     *
     * @param rankID
     * @return
     */
    public HashMap readRank(String rankID) {

        HashMap listpayGrad = new HashMap();


        ResultSet rs = null;
        String str = "SELECT * FROM hr_lu_rank WHERE rank_Id=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _ps.setString(1, rankID);
            rs = _ps.executeQuery();
            if (rs.next()) {
                listpayGrad.put("RANK_ID", rs.getString("RANK_ID"));
                listpayGrad.put("RANK_DESCRIPTION", rs.getString("RANK_DESCRIPTION"));
                listpayGrad.put("BEGINNING_SALARY", rs.getString("BEGINNING_SALARY"));
                listpayGrad.put("MAX_SALARY", rs.getString("MAX_SALARY"));
                return listpayGrad;
            } else {
                return null;
            }
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

    public ArrayList<HashMap> readRank() {
        ArrayList<HashMap> listRank = new ArrayList<HashMap>();
        ResultSet rs = null;
        String queryStr = "SELECT RANK_ID, " +
                "  RANK_DESCRIPTION " +
                " FROM HR_LU_RANK " +
                " ORDER BY CAST(RANK_ID AS NUMBER)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(queryStr);
            rs = _ps.executeQuery();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("RANK_ID", rs.getString("RANK_ID"));
                hm.put("RANK_DESCRIPTION", rs.getString("RANK_DESCRIPTION"));
                listRank.add(hm);
            }
            return listRank;

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

    /**
     *
     * @param rankID
     * @param description
     * @param beginningSalary
     * @param maxSalary
     */
    public int addRank(String rankID, String description, Double beginningSalary, Double maxSalary, String type) {
        this.setRankID(rankID);
        this.setDescription(description);
        this.setBeginningSalary(beginningSalary);
        this.setMaxSalary(maxSalary);
        this.setType(type);
        return this.insertRank();
    }

    /**
     *
     * @param rankID
     * @param description
     * @param beginningSalary
     * @param maxSalary
     */
    public int updateRank(String old_RannkID, String rankID, String description, Double beginningSalary, Double maxSalary) {
        this.setRankID(rankID);
        this.setDescription(description);
        this.setBeginningSalary(beginningSalary);
        this.setMaxSalary(maxSalary);
        this.setOldRandID(old_RannkID);

        return 0;// this.updateRank();
    }

    public boolean updateRankAndPayGrade(HashMap rankList, ArrayList<HashMap> listOfPayGrade) {
        ResultSet rs = null;
        int check;
        PreparedStatement psPayGrade;
        String str = "UPDATE hr_lu_rank set rank_Id=?," +
                " RANK_DESCRIPTION=?, " +
                " beginning_Salary=?, " +
                " max_Salary=?" +
                " WHERE rank_Id=?";
        String strPayGrade = "UPDATE hr_lu_pay_grad  " +
                " set rank_Id = ? ," +
                "  step_No = ? , " +
                " salary = ? " +
                " WHERE ID_PAY_GRADE = ? ";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _ps.setString(1, rankList.get("rankID").toString());
            _ps.setString(2, rankList.get("description").toString());
            _ps.setDouble(3, Double.parseDouble(rankList.get("beginningSalary").toString()));
            _ps.setDouble(4, Double.parseDouble(rankList.get("maxSalary").toString()));
            _ps.setString(5, rankList.get("oldRankID").toString());
            if (_ps.executeUpdate() > 0) {
                for (HashMap hm : listOfPayGrade) {
                    psPayGrade = _con.prepareStatement(strPayGrade);
                    psPayGrade.setString(1, hm.get("rankID").toString());
                    psPayGrade.setString(2, hm.get("current").toString());
                    psPayGrade.setDouble(3, Double.parseDouble(hm.get("salary").toString()));
                    psPayGrade.setString(4, hm.get("payGradId").toString());
                    if (psPayGrade.executeUpdate() <= 0) {
                        return false;
                    }
                }
            } else {
                return false;
            }
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
        return false;

    }

    private int insertRank() {
        ResultSet rs = null;
        int check;
        String strRank = "INSERT INTO hr_lu_rank (" +
                " rank_Id," +
                " RANK_DESCRIPTION," +
                " beginning_Salary," +
                " max_Salary," +
                " TYPE)" +
                "  values(?,?,?,?,?)";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(strRank);
            _ps.setString(1, getRankID());
            _ps.setString(2, getDescription());
            _ps.setDouble(3, getBeginningSalary());
            _ps.setDouble(4, getMaxSalary());
            _ps.setString(5, getType());
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

    public int updateRank(String rankDescription,
            Double begningSalary,
            Double maxSalary,
            String type,
            String rankId) {
        int check;
        String str = "UPDATE hr_lu_rank set" +
                " RANK_DESCRIPTION=?," +
                " beginning_Salary=?, " +
                " max_Salary=? , " +
                " TYPE = ? " +
                " WHERE rank_Id = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _ps.setString(1, rankDescription);
            _ps.setDouble(2, begningSalary);
            _ps.setDouble(3, maxSalary);
            _ps.setString(4, type);
            _ps.setString(5, rankId);
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

    /**
     *
     * @param rankID
     */
    public int deleteRank(String rankID) {


        ResultSet rs = null;
        int check;

        String str = "DELETE FROM hr_lu_rank WHERE rank_Id=?";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _ps.setString(1, rankID);
            check = _ps.executeUpdate();

            return check;

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

    public boolean countRank(String rankID) {
        HashMap listpayGrad = new HashMap();
        ResultSet rs = null;
        String str = "SELECT * FROM hr_lu_rank WHERE rank_Id=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _ps.setString(1, rankID);
            rs = _ps.executeQuery();
            if (rs.next()) {

                return true;
            } else {

                return false;
            }


        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public HashMap readRank(String stepNumber, String rankId) {
        HashMap hm = new HashMap();
        String sqlStatment = "SELECT * FROM HR_LU_PAY_GRAD WHERE STEP_NO =? AND RANK_ID=?";

        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = getConnection();
            ps = con.prepareStatement(sqlStatment);
            ps.setString(1, stepNumber);
            ps.setString(2, rankId);
            rs = ps.executeQuery();
            if (rs.next()) {
                hm.put("STEP_NO", rs.getString("STEP_NO"));
                hm.put("SALARY", rs.getString("SALARY"));
                hm.put("RANK_ID", rs.getString("RANK_ID"));
                return hm;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
