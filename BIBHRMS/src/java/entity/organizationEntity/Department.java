/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.organizationEntity;

import connectionProvider.ConnectionManager;
import manager.globalUseManager.ErrorLogWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Administrator
 */
public class Department extends ConnectionManager {

    /*
     * To change this template, choose Tools | Templates
     * and open the template in the editor.
     */
    /**
     *
     * @author Alt
     */
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
    private String deptCode;
    private String deptDescription;
    private String deptMission;
    private String branchCode;
    private String estDate;
    private String branchID;
    int check;

    public String getBranchID() {
        return branchID;
    }

    public void setBranchID(String branchID) {
        this.branchID = branchID;
    }
    private String region;
    private String zone;
    private String woreda;
    private String kebelle;
    private String floor;
    private String block;
    private String officeNumber;
    private String telOffice;
    private String telOfficeExt;
    private String telMobile;
    private String mobile;
    private String email;
    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * A constructor used to instatiate the class <code>Department</code> without
     * parameters
     */
    public Department() {
    }//end of constructor

    public Department(String deptCode, String deptDescription,
            String deptMission, String est_Date, String branchID, int level) {
        this.deptCode = deptCode;
        this.deptDescription = deptDescription;
        this.deptMission = deptMission;
        this.estDate = est_Date;
        this.branchID = branchID;
        this.level = level;

    } //end of constructor

    /**
     * A constructor to instatiate the class <code>Department</code> with
     * only three parameters
     * @param deptCode the department identifier
     * @param deptDescription the descriptio of the department
     * @param deptMission the mission of the department
     */
    public OracleCachedRowSet readAllOrganization() {



        String str = "select * from tbl_department";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);

            return ocrs;
        } catch (Exception ex) {
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    ResultSet readRootOrganization() {
        String str = "select * from tbl_department where dept_id='999999999'";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } catch (Exception ex) {
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public Department(String deptCode, String deptDescription,
            String deptMission) {
        this.deptCode = deptCode;
        this.deptDescription = deptDescription;
        this.deptMission = deptMission;
    } //end of constructor

    /**
     ** A constructor to instatiate the class <code>Department</code> with
     * the following four parameters
     * @param deptCode the department identifier
     * @param deptDescription the descriptio of the department
     * @param deptMission the mission of the department
     * @param est_Date the establishement date of the department
     */
    public Department(String deptCode, String deptDescription,
            String deptMission, String est_Date, String branchID) {
        this.deptCode = deptCode;
        this.deptDescription = deptDescription;
        this.deptMission = deptMission;
        this.estDate = est_Date;
        this.branchID = branchID;

    } //end of constructor

    /**
     * A constructor to instatiate the class <code>Department</code> with
     * the following four parameters
     * @param deptCode the department identifier
     * @param region the region of the department
     * @param zone the zone of the department
     * @param woreda the woreda of the department
     * @param kebelle the kebelle of the department
     * @param floor the floor of the department
     * @param block the block of the department
     * @param officeNumber the officeNumber of the department
     * @param telOffice the telOffice of the department contact
     * @param telOfficeExt the telOfficeExt of the department contact
     * @param telMobile the mobile of the department contact
     * @param mobile the mobile of the department contact
     */
    public Department(String deptCode, String region,
            String zone, String woreda, String kebelle, String floor,
            String block, String officeNumber, String telOffice,
            String telOfficeExt, String telMobile, String mobile) {
        this.deptCode = deptCode;
        this.region = region;
        this.zone = zone;
        this.woreda = woreda;
        this.kebelle = kebelle;
        this.floor = floor;
        this.block = block;
        this.officeNumber = officeNumber;
        this.telOffice = telOffice;
        this.telOfficeExt = telOfficeExt;
        this.telMobile = telMobile;
        this.mobile = mobile;
    }

    /**
     * Removes all the rows of employee's (the employee specified by emp_Id)
     * address in the hr_emp_address table
     * @param deptId the unique department identifier
     * @return either (1) the row count for SQL Data Manipulation Language (DML) statements
     *         or (2) 0 for SQL statements that return nothing
     * @throws Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public int deleteDeptAddress(String deptId) {




        String str = "DELETE * FROM hr_emp_address WHERE department_id=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _ps.setString(1, deptId);
            check = _ps.executeUpdate();

            return check;
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

    /**
     * The method fetches the department information and the allowed job types in the
     * department.
     * @param deptID the unique identifier of the job
     * @return a <code>ResultSet</code> object rs with the data from the query
     * @throws java.sql.Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public ResultSet readDeptJOb(int deptID) {




        String str = "SELECT t.`department_id`, t.`description` as deptDesc, t.`mission`, t.`vision`, " +
                "t.`est_Date`, j.`job_Code`, j.`description` as jobDesc, d.`dept_job_code` " +
                "FROM TBL_DEPARTMENT t, hr_dept_job d, hr_lu_job_type j " +
                "WHERE t.`department_id` =d.`dept_Id` AND d.`job_code` =j.`job_Code`" +
                "And t.`department_id` = '" + deptID + "'";
        try {
            _ps = _con.prepareStatement(str);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } catch (Exception ex) {
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
     * Fetches main divisions or organisations from the TBL_DEPARTMENT table
     * based on the department_id
     * @return a <code>ResultSet</code> object rs
     * @throws java.sql.Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public ResultSet readOrganization() {



        try {
            _con = getConnection();
            _ps = _con.prepareStatement(" SELECT * FROM TBL_DEPARTMENT t " +
                    " WHERE t.dept_id LIKE '__'");
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
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

    }//end of the readOrganization() method

    public ResultSet readHead() {



        try {
            _con = getConnection();
            _ps = _con.prepareStatement(" SELECT * FROM TBL_DEPARTMENT t " +
                    " WHERE t.dept_id = '999999999'");
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
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

    }//end of the readOrganization() method

    /**
     * Fetches the maximum id of main divisions or organisations from the
     * TBL_DEPARTMENT table based on the department_id
     * @return  a <code>ResultSet</code> object rs
     * @throws java.sql.Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public ResultSet readNextOrganizationId() {



        try {
            _con = getConnection();
            _ps = _con.prepareStatement("SELECT MAX(department_id) " +
                    "as maxDeptId FROM TBL_DEPARTMENT t " +
                    "WHERE t.`department_id` LIKE '__00000000'");
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } catch (Exception ex) {
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//end of readNextOrganizationId() method

    /**
     * Fetches only branches from the TBL_DEPARTMENT table based on the department_id
     * @return a <code>ResultSet</code> object rs
     * @throws Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public ResultSet readBra() {



        try {
            _con = getConnection();
            _ps = _con.prepareStatement("SELECT * FROM TBL_DEPARTMENT t " +
                    " WHERE t.dept_id LIKE '___'");
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } catch (Exception ex) {
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    } //end of  readBra() method

    /**
     * Fetches the maximum department_id of branches from the TBL_DEPARTMENT
     * table based on the department_id
     * @param orgId the unique department identifier
     * @return a <code>ResultSet</code> object rs
     * @throws java.sql.Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public ResultSet readNextBraId(String orgId) {



        try {
            _con = getConnection();
            _ps = _con.prepareStatement("SELECT MAX(department_id) as maxDeptId FROM TBL_DEPARTMENT t " +
                    "WHERE t.`department_id` LIKE ? and SUBSTRING(t.`department_id`, 3, 2) != '00'");
            _ps.setString(1, orgId + "%");
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } catch (Exception ex) {
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//end of readNextBraId method

    /**
     * Fetches only departments from the table TBL_DEPARTMENT based on department_id
     * @return a <code>ResultSet</code> object rs
     * @throws Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public ResultSet readDep() {



        try {
            _con = getConnection();
            _ps = _con.prepareStatement("select * from TBL_DEPARTMENT where TBL_DEPARTMENT.dept_id Like '____' ");

            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } catch (Exception ex) {
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//end of readDep() Method

    /**
     * Fetches the maximum department_id of departments from the TBL_DEPARTMENT table
     * table based on the department_id
     * @param braId the department identifier
     * @return a <code>ResultSet</code> object rs
     * @throws Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public ResultSet readNextDepId(String braId) {



        try {
            _ps = _con.prepareStatement("SELECT MAX(department_id) as maxDeptId FROM TBL_DEPARTMENT t " +
                    "WHERE t.`department_id` LIKE ? and SUBSTRING(t.`department_id`, 5, 2) != '00'");
            _ps.setString(1, braId + "%");
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } catch (Exception ex) {
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    } //end of readNextDeptId method

    /**
     * Fetches only sections from the table TBL_DEPARTMENT based on department_id
     * @return a <code>ResultSet</code> object rs
     * @throws Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public ResultSet readSec() {



        try {
            _con = getConnection();
            _ps = _con.prepareStatement(" SELECT * FROM TBL_DEPARTMENT t   WHERE t.dept_id LIKE '_____' ");

            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } catch (Exception ex) {
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//end of readSec() method

    /**
     * Fetches the maximum department_id of sections from the TBL_DEPARTMENT table
     * @param deptId the department identifier
     * @return a <code>ResultSet</code> object rs
     * @throws Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public ResultSet readNextSecId(String deptId) {



        try {
            _con = getConnection();
            _ps = _con.prepareStatement("SELECT MAX(department_id) as maxDeptId FROM TBL_DEPARTMENT t " +
                    "WHERE t.`department_id` LIKE ? and SUBSTRING(t.`department_id`, 7, 2) != '00' ");
            _ps.setString(1, deptId + "%");
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } catch (Exception ex) {
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//end of readNextSecId method

    /**
     * Fetches only sub sections from the table TBL_DEPARTMENT based on department_id
     * @return a <code>ResultSet</code> object rs
     * @throws Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public ResultSet readSSec() {



        try {
            _con = getConnection();
            _ps = _con.prepareStatement("SELECT * FROM TBL_DEPARTMENT t   WHERE t.dept_id LIKE '______' ");
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } catch (Exception ex) {
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    } //end of readSSec method

    public ResultSet readSSSec() {



        try {

            _con = getConnection();
            _ps = _con.prepareStatement("SELECT * FROM TBL_DEPARTMENT t   WHERE t.dept_id LIKE '_______' ");
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } catch (Exception ex) {
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    } //end of readSSec method

    /**
     * Fetches the maximum department_id of sub sections from the TBL_DEPARTMENT table
     * @param secId the department identifier
     * @return a <code>ResultSet</code> object rs
     * @throws Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public ResultSet readNextSSecId(String secId) {



        try {
            _con = getConnection();
            _ps = _con.prepareStatement("SELECT MAX(department_id) as maxDeptId FROM TBL_DEPARTMENT t " +
                    "WHERE t.`department_id` LIKE ? and SUBSTRING(t.`department_id`, 9, 2) != '00' ");
            _ps.setString(1, secId + "%");
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } catch (Exception ex) {
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    } // end of readNextSSecId method

    /**
     * Sets the current object by calling the setter methods.
     * After instatiating the current object the <code>insertDept()</code>
     * method is called.
     * @param deptId the department identifier
     * @param deptName the name of the department
     * @param mission the mission of the department
     * @param est_Date the established date
     * @return either (1) the row count for SQL INSERT statement
     *         or (2) 0 if the SQL INSERT statement returns nothing
     */
    public int addDept(String deptId, String deptName, String mission, String est_Date) {
        this.setDeptCode(deptId);
        this.setDeptDescription(deptName);
        this.setDeptMission(mission);
        this.setEstDate(est_Date);
        int i = insertDept();
        return i;
    } //end of addDept method

    /**
     * Inserts data from the current object into TBL_DEPARTMENT table
     * (Note: the caller must set the object before calling this method)
     * @return either (1) the row count for SQL INSERT statement
     *         or (2) 0 if the SQL INSERT statement that return nothing
     */
    public int insertDept() {

//        call openConnection method to create a connection
        PreparedStatement deptPreparedStatement = null;



        String deptStatement = "INSERT INTO TBL_DEPARTMENT (department_id, description, " +
                "mission, est_Date) values (?, ?, ?, ?)";
        try {
            _con = getConnection();
            deptPreparedStatement = _con.prepareStatement(deptStatement);
            deptPreparedStatement.setString(1, getDeptCode());
            deptPreparedStatement.setString(2, getDeptDescription());
            deptPreparedStatement.setString(3, getDeptMission());
            deptPreparedStatement.setString(4, getEstDate());
            check = deptPreparedStatement.executeUpdate();

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

    /**
     * The method inserts a row of data into the hr_dept_job table which contains
     * the jobs in a department.
     * @param deptId the unique department identifier
     * @param jobCode the unique identifier of the job
     * @param deptJobCode the conbination key given to a job in a department
     * @return an integer that indicates the process.
     */
    public int addDeptJob(String deptId, String jobCode, String deptJobCode) {
        PreparedStatement ps = null;


        String rs = "INSERT INTO hr_dept_job (dept_Id, job_code, " +
                "dept_job_code) values (?, ?, ?)";
        try {
            _con = getConnection();
            ps = _con.prepareStatement(rs);
            ps.setString(1, deptId);
            ps.setString(2, jobCode);
            ps.setString(3, deptJobCode);
            check = ps.executeUpdate();

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

    /**
     * Fetches every column of the TBL_DEPARTMENT table base on department_id
     * @param deptID the unique identifier of the department
     * @return a <code>ResultSet</code> object rs
     * @throws Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public ResultSet readDept(int deptID) {




        String str = "SELECT * FROM TBL_DEPARTMENT " +
                " WHERE TBL_DEPARTMENT.department_id = ?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _ps.setInt(1, deptID);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } catch (Exception ex) {
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
     * Fetches every column of the hr_emp_address table base on department_id
     * and the type of address that shows its beloging to department.
     * @param deptID the unique identifier of the department
     * @param type the type of address should be for departmentS
     * @return a <code>ResultSet</code> object rs
     * @throws Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public ResultSet readDeptAddress(int deptID, int type) {




        String str = "SELECT * FROM hr_emp_address " +
                " WHERE TBL_DEPARTMENT.department_id = ? and type = ?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _ps.setInt(1, deptID);
            _ps.setInt(2, type);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } catch (Exception ex) {
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
     * The method is used to insert the department address detail in the <b>hr_emp_address</b>
     * table. (Note the Department entity class must either be instatiated or
     * its setter methers must be called before calling this method)
     * @param deptAddress is an object of the entity class Department
     * @throws java.sql.Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public void saveDeptAddress(Department deptAddress) {
        PreparedStatement deptPs = null;


        String deptStatement = "INSERT INTO hr_emp_address " +
                "(department_id, region_Id, " +
                "zone_Or_City, woreda_Or_Subcity, kebelle, floor, block, " +
                "house_Number, telephone_Office, telephone_Residence, " +
                "mobile, email) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            _con = getConnection();
            deptPs = _con.prepareStatement(deptStatement);
            deptPs.setString(1, getDeptCode());
            deptPs.setString(2, getRegion());
            deptPs.setString(3, getZone());
            deptPs.setString(4, getWoreda());
            deptPs.setString(5, getKebelle());
            deptPs.setString(6, getFloor());
            deptPs.setString(7, getBlock());
            deptPs.setString(8, getOfficeNumber());
            deptPs.setString(9, getTelOffice());
            deptPs.setString(10, getTelOfficeExt());
            deptPs.setString(11, getTelMobile());
            deptPs.setString(12, getEmail());

            deptPs.executeUpdate();


        } catch (Exception ex) {
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Updates the TBL_DEPARTMENT table using data from the current object.
     * (Note: the caller must set the object before calling this method)
     * @return either (1) the row count for SQL INSERT statement
     *         or (2) 0 if the SQL INSERT statement that return nothing
     * @throws Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public int updateDept() {
        PreparedStatement ps = null;



        String str = ("UPDATE TBL_DEPARTMENT set department_id=?, mission=?,  description=?, " +
                "est_Date = ? where department_id='" + deptCode + "'");
        try {
            _con = getConnection();
            ps = _con.prepareStatement(str);
            ps.setString(1, this.getDeptCode());
            ps.setString(3, this.getDeptMission());
            ps.setString(2, this.getDeptDescription());
            ps.setString(4, this.getEstDate());
            check = ps.executeUpdate();

            return check;
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

    public ResultSet readAlldepartments() {
        String _selecrQuery = " SELECT DEPT_ID, MISSION,VISION,EST_DATE,LEVEL,LPAD(' ', 5* LEVEL - 1)|| DEP_DESCRIPTION || '    ' ,DEP_DESCRIPTION,BRANCH_ID" +
                " FROM TBL_DEPARTMENT" +
                " START WITH DEPT_ID=1" +
                " CONNECT BY PRIOR DEPT_ID=BRANCH_ID";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selecrQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            return ocrs;
        } catch (Exception ex) {
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
    ///////////////////////////////////////////////////////////////////////////////DeptNew///////////////////////////////////////////////////////////
     public ResultSet readAlldepartmentsNew() {
        String _selecrQuery = " SELECT DEPT_ID, MISSION,VISION,EST_DATE,LEVEL,LPAD(' ', 5* LEVEL - 1)|| DEP_DESCRIPTION || '    ' ,DEP_DESCRIPTION,BRANCH_ID" +
                " FROM TBL_DEPT_BUNNA" +
                " START WITH DEPT_ID=1" +
                " CONNECT BY PRIOR DEPT_ID=BRANCH_ID";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selecrQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            return ocrs;
        } catch (Exception ex) {
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

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public ResultSet readSubDepartmentsNew(int begningDepartmentId) {
        String _selecrQuery = " SELECT DEPT_ID, MISSION,VISION,EST_DATE,LEVEL,LPAD(' ', 5* LEVEL - 1)|| DEP_DESCRIPTION || '    ' ,DEP_DESCRIPTION,BRANCH_ID" +
                " FROM TBL_DEPARTMENT" +
                " START WITH DEPT_ID=" + begningDepartmentId +
                " CONNECT BY PRIOR DEPT_ID=BRANCH_ID";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selecrQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            return ocrs;
        } catch (Exception ex) {
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

    public ResultSet readParentDepartments(String endingDepartmentId) {
        String _selecrQuery = "SELECT DEPT_ID, " +
                "  SYS_CONNECT_BY_PATH(DEPT_ID, '>>' )         AS PATH_BY_ID, " +
                "  SYS_CONNECT_BY_PATH(DEP_DESCRIPTION, '>>' ) AS PATH_BY_NAME " +
                "  FROM TBL_DEPARTMENT " +
                "  WHERE DEPT_ID  = " + endingDepartmentId +
                "  START WITH DEPT_ID      =1 " +
                "  CONNECT BY PRIOR DEPT_ID=BRANCH_ID";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selecrQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            return ocrs;
        } catch (Exception ex) {
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

    /**
     * Removes a record from the TBL_DEPARTMENT table with the
     * specified department_id
     * @param deptId the unique identifier of the department
     * @throws Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public void deleteDept(String deptId) {
        PreparedStatement ps = null;
        String str = "DELETE FROM TBL_DEPARTMENT WHERE department_id='" + deptId + "'";
        try {
            ps = getConnection().prepareStatement(str);
            ps.executeUpdate();
        } catch (Exception ex) {
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Getter and Setter methods">

    /**
     * @return the deptDescription
     */
    public String getDeptDescription() {
        return deptDescription;
    }

    /**
     * @param deptDescription the deptDescription to set
     */
    public void setDeptDescription(String deptDescription) {
        this.deptDescription = deptDescription;
    }

    /**
     * @return the deptMission
     */
    public String getDeptMission() {
        return deptMission;
    }

    /**
     * @param deptMission the deptMission to set
     */
    public void setDeptMission(String deptMission) {
        this.deptMission = deptMission;
    }

    /**
     * @return the deptCode
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     * @param deptCode the deptCode to set
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    /**
     * @return the branchCode
     */
    public String getBranchCode() {
        return branchCode;
    }

    /**
     * @param branchCode the branchCode to set
     */
    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    /**
     * @return the estDate
     */
    public String getEstDate() {
        return estDate;
    }

    /**
     * @param estDate the estDate to set
     */
    public void setEstDate(String estDate) {
        this.estDate = estDate;
    }

    /**
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region the region to set
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * @return the zone
     */
    public String getZone() {
        return zone;
    }

    /**
     * @param zone the zone to set
     */
    public void setZone(String zone) {
        this.zone = zone;
    }

    /**
     * @return the woreda
     */
    public String getWoreda() {
        return woreda;
    }

    /**
     * @param woreda the woreda to set
     */
    public void setWoreda(String woreda) {
        this.woreda = woreda;
    }

    /**
     * @return the kebelle
     */
    public String getKebelle() {
        return kebelle;
    }

    /**
     * @param kebelle the kebelle to set
     */
    public void setKebelle(String kebelle) {
        this.kebelle = kebelle;
    }

    /**
     * @return the floor
     */
    public String getFloor() {
        return floor;
    }

    /**
     * @param floor the floor to set
     */
    public void setFloor(String floor) {
        this.floor = floor;
    }

    /**
     * @return the block
     */
    public String getBlock() {
        return block;
    }

    /**
     * @param block the block to set
     */
    public void setBlock(String block) {
        this.block = block;
    }

    /**
     * @return the officeNumber
     */
    public String getOfficeNumber() {
        return officeNumber;
    }

    /**
     * @param officeNumber the officeNumber to set
     */
    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }

    /**
     * @return the telOffice
     */
    public String getTelOffice() {
        return telOffice;
    }

    /**
     * @param telOffice the telOffice to set
     */
    public void setTelOffice(String telOffice) {
        this.telOffice = telOffice;
    }

    /**
     * @return the telOfficeExt
     */
    public String getTelOfficeExt() {
        return telOfficeExt;
    }

    /**
     * @param telOfficeExt the telOfficeExt to set
     */
    public void setTelOfficeExt(String telOfficeExt) {
        this.telOfficeExt = telOfficeExt;
    }

    /**
     * @return the telMobile
     */
    public String getTelMobile() {
        return telMobile;
    }

    /**
     * @param telMobile the telMobile to set
     */
    public void setTelMobile(String telMobile) {
        this.telMobile = telMobile;
    }

    /**
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * The methdo is used to make changes in the <b>hr_emp_address</b> table in the
     * database. (Note the Department entity class must either be instatiated or
     * its setter methers must be called before calling this method)
     * @param deptAddress
     * @throws java.sql.Exception
     */
    public void updateDeptAddress(Department deptAddress) {
        PreparedStatement deptPs = null;


        String deptStatement = "UPDATE hr_emp_address set " +
                "(department_id = ?, region_Id = ?, " +
                "zone_Or_City = ?, woreda_Or_Subcity = ?, kebelle = ?, floor = ?, block = ?, " +
                "house_Number = ?, telephone_Office = ?, telephone_Residence = ?, " +
                "mobile = ?, email = ? where department_id = '" + this.getDeptCode() + "' ";
        try {
            _con = getConnection();
            deptPs = _con.prepareStatement(deptStatement);
            deptPs.setString(1, getDeptCode());
            deptPs.setString(2, getRegion());
            deptPs.setString(3, getZone());
            deptPs.setString(4, getWoreda());
            deptPs.setString(5, getKebelle());
            deptPs.setString(6, getFloor());
            deptPs.setString(7, getBlock());
            deptPs.setString(8, getOfficeNumber());
            deptPs.setString(9, getTelOffice());
            deptPs.setString(10, getTelOfficeExt());
            deptPs.setString(11, getTelMobile());
            deptPs.setString(12, getEmail());

            deptPs.executeUpdate();
        } catch (Exception ex) {
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    // </editor-fold>
}



