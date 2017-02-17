/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.userManagement.Entity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.HashMap;
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author 
 */
public class UsersEntity extends ConnectionManager {

    private static final long serialVersionUID = 1L;
    private String userName,  newUserName;
    private int userId;
    private String roleName;
    private String password;
    private String employeeId;
    private String dbUserName;
    private int userSecurityQuestionId;
    private String answerToSecurityQuestion;
    private int firstTimeAccess;
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

    /**
     * creates a new user object without initializing the field instances
     */
    public UsersEntity() {
    }

    /**
     * creates a new user object by initializing the userName field instance
     * @param userName the user name of the user object
     */
    public UsersEntity(String userName) {
        this.userName = userName;
    }

    /**
     * creates a new user object by initializing the userName field instance
     * @param userName the user name of the user object
     */
    public UsersEntity(int userId) {
        this.userId = userId;
    }

    /**
     * creates a new user object by initializing the userName and  password
     * field instances
     * @param userName the user name of the user object
     * @param password the password of the user object
     */
    public UsersEntity(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    /**
     * creates a new user object by initializing the userName,password and
     * employeeId field instances
     * @param userName
     * @param password
     * @param employeeId
     */
    public UsersEntity(String userName, String password, String employeeId) {
        this.userName = userName;
        this.password = password;
        this.employeeId = employeeId;
    }

    /**
     * creates a new user object by initializing the field instatnces of the class
     * @param userName the user name of the user of the user object
     * @param newUserName the new user name of the user object
     * @param password the password of the user object
     * @param userSecurityQuestionId the id of security question
     * @param answerToSecurityQuestion answer given to the security question
     * @param firstTimeAccess flag indicating the access status of the use.
     */
    public UsersEntity(String userName, String newUserName, String password,
            int userSecurityQuestionId, String answerToSecurityQuestion, int firstTimeAccess) {
        this.userName = userName;
        this.newUserName = newUserName;
        this.password = password;
        this.userSecurityQuestionId = userSecurityQuestionId;
        this.answerToSecurityQuestion = answerToSecurityQuestion;
        this.firstTimeAccess = firstTimeAccess;
    }

    /**
     * Fetches all rows from tbl_users
     * @return returns <b>ResultSet</b> object on successful completion
     * of the method, <b>null</b> otherwise
     * @throws SQLException
     */
    public ResultSet selectAllUsers() {

        String _select = "SELECT user_id,user_name, password FROM BIB.tbl_users " +
                " order by nlssort(user_name,'NLS_SORT=BINARY_CI') ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);//, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            return ocrs;
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

    public ResultSet selectAllUsersList() {

        String _select = "SELECT first_name " +
                "  ||' ' " +
                "  || middle_name " +
                "  ||' ' " +
                "  || last_name AS fullname, " +
                "  USER_ID, " +
                "  user_name, " +
                "  password, " +
                "  ei.emp_id " +
                "FROM BIB.tbl_users ur " +
                "INNER JOIN hr_employee_info ei " +
                "ON ur.EMPLOYEE_ID=ei.emp_id " +
                "ORDER BY nlssort(ei.emp_id,'NLS_SORT=BINARY_CI')";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);//, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            return ocrs;
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

    /**
     * Reads the password of _userName
     * @param _userName the name of the user
     * @return returns <b>password</b> as String object on successful completion
     * of the method, <b>null</b> otherwise
     * @throws SQLException
     */
    public String getPassword(String _userName) {

        String _select = "SELECT user_name, password FROM BIB.tbl_users " +
                " WHERE user_name = ?";
        String _password = null;
        try {
            _con = getConnection();
            _con = getConnection();
            _ps = _con.prepareStatement(_select);//, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            _ps.setString(1, _userName);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            ocrs.next();
            if (ocrs.getRow() > 0) {
                _password = ocrs.getString("password");
            }
            return _password;
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

    /**
     * Reads the password of _userName
     * @param _userName the name of the user
     * @return returns <b>password</b> as String object on successful completion
     * of the method, <b>null</b> otherwise
     * @throws SQLException
     */
    public String getPassword(String _userName, String _employeeId) {

        String _select = "SELECT user_name, password FROM BIB.tbl_users " +
                " WHERE user_name = ? " +
                " AND EMPLOYEE_ID = ? ";
        String _password = null;
        try {
            _con = getConnection();
            _con = getConnection();
            _ps = _con.prepareStatement(_select);//, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            _ps.setString(1, _userName);
            _ps.setString(2, _employeeId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            ocrs.next();
            if (ocrs.getRow() > 0) {
                _password = ocrs.getString("password");
            }
            return _password;
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

    /**
     * Reads the employee id of _userName
     * @param _userName the name of the user
     * @return returns <b>employee Id</b> as String object on successful completion
     * of the method, <b>null</b> otherwise
     * @throws SQLException
     */
    public String getEmployeeId(String _userName) {
        String _select = " SELECT employee_id FROM BIB.tbl_users " +
                " WHERE user_name = ?";



        String _empId = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);//,
//                    ResultSet.TYPE_SCROLL_INSENSITIVE,
//                    ResultSet.CONCUR_READ_ONLY);
            _ps.setString(1, _userName);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            ocrs.next();

            if (ocrs.size() > 0) {

                _empId = ocrs.getString("employee_id");
            }
            return _empId;
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

    /**
     * Reads the db_user_name of _userName
     * @param _userName the name of the user
     * @return returns <b>db_user_name</b> as String object on successful completion
     * of the method, <b>null</b> otherwise
     * @throws SQLException
     */
    public String getDbUserName(String _userName) {
        String _select = "SELECT db_user_name FROM BIB.tbl_users " +
                " WHERE user_name = ?";



        String _empId = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);//,
//                    ResultSet.TYPE_SCROLL_INSENSITIVE,
//                    ResultSet.CONCUR_READ_ONLY);
            _ps.setString(1, _userName);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            ocrs.next();

            if (ocrs.getRow() > 0) {
                _empId = ocrs.getString("db_user_name");

            }
            _rs.close();

            return _empId;
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

    /**
     * gets the security question identified by _securityQuestionId
     * @param _securityQuestionId the security question id
     * @return <b>ResultSet</b> object on successful completion
     * of the method, <b>null</b> otherwise
     * @throws java.sql.SQLException
     */
    public ResultSet getSecurityQuestion(int _securityQuestionId) {
        String _select = "SELECT security_question FROM BIB.tbl_security_question_lookup where id=?";



        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);//, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            _ps.setInt(1, _securityQuestionId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            return ocrs;
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

    /**
     * gets the security question id of the user identified by userName
     * (Note: the caller must set userName before calling this method)
     * @return <b>ResultSet</b> object on successful completion
     * of the method, <b>null</b> otherwise
     * @throws java.sql.SQLException
     */
    public ResultSet getSecurityQuestionCode() {
        String _select = "SELECT user_id,user_name, security_question_id FROM BIB.tbl_users where " +
                "user_name=?";



        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);//, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            _ps.setString(1, this.userName);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            return ocrs;
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

    /**
     * gets the security question id of the user identified by _userName
     * @param _userName the user name of the user.
     * @return <b>ResultSet</b> object on successful completion
     * of the method, <b>null</b> otherwise
     * @throws java.sql.SQLException
     */
    public ResultSet getSecurityQuestionCode(String _userName) {
        String _select = "SELECT user_id,user_name, security_question_id FROM BIB.tbl_users where " +
                "user_name=?";



        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);//, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            _ps.setString(1, _userName);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            return ocrs;
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

    /**
     * gets the list of security questions from the  tbl_security_question_lookup
     * table
     * @return <b>ResultSet</b> object on successful completion
     * of the method, <b>null</b> otherwise
     * @throws java.sql.SQLException
     */
    public ResultSet getSecurityQuestionList() {
        String _select = "SELECT id, Security_question FROM BIB.tbl_security_question_lookup " +
                "order by Security_question";



        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);//, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            return ocrs;
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

    /**
     * checks whether the answer provided to secrete question of the user is
     * correct or not
     * @param _userName the user name of the user.
     * @param _answerToQuestion the answer provided to the secret question.
     * @return <b>true</b> if the answer to the secret question is correct,
     *  <b>false</b> otherwise
     * @throws java.sql.SQLException
     */
    public boolean isUserAnswerCorrect(String _userName, String _answerToQuestion) {
        String _select = "SELECT user_id FROM BIB.tbl_users where user_name=? and answer_to_question=?";



        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);//, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            _ps.setString(1, _userName);
            _ps.setString(2, _answerToQuestion);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            if (ocrs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    /**
     * Updates row in tbl_users identified by userName
     * (Note: the caller must set userName before calling this method)
     * @return returns <b>true</b> object on successful completion
     * of the method, <b>false</b> otherwise
     * @throws SQLException
     */
    public boolean update() {

        String _update = "UPDATE BIB.tbl_users SET user_name = ? , password = ?" +
                " WHERE user_name = ? ";


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_update);
            _ps.setString(1, getNewUserName());
            _ps.setInt(2, getPassword().hashCode());
            _ps.setString(3, getUserName());

            _ps.executeUpdate();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }

    }

    /**
     * Adds a row into tbl_users using userName and password
     * (Note: the caller should set userName and password before calling
     * this method)
     * @return returns <b>true</b> object on successful completion
     * of the method, <b>false</b> otherwise
     * @throws SQLException
     */
    public int insert() {
        //get hash value of the password and insert it

        String _update = "INSERT INTO BIB.tbl_users (user_id,user_name, password, employee_id) " +
                " VALUES(SEQ_TBL_USERS.NEXTVAL,?, ?, ?) ";


        try {
            _con = getConnection();
            _ps =
             _con.prepareStatement(_update);
            _ps.setString(1, getUserName());
            _ps.setString(2, getPassword());
            _ps.setString(3, getEmployeeId());

            return _ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    /**
     * Removes a row from tbl_users identified by userName
     * (Note: the caller should set userName before calling
     * this method)
     * @return returns <b>true</b> object on successful completion
     * of the method, <b>false</b> otherwise
     * @throws SQLException
     */
    public boolean delete() {
        String _update = "DELETE FROM BIB.tbl_users WHERE user_id = ? ";


        try {
            _con = getConnection();
            _ps =
                    _con.prepareStatement(_update);
            _ps.setString(1, getUserName());
            _ps.executeUpdate();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    public boolean delete(ArrayList<HashMap> userid) {
        String _update = "DELETE FROM BIB.tbl_users WHERE user_id = ? ";


        try {
            _con = getConnection();
            _con.setAutoCommit(false);
            Savepoint sp = _con.setSavepoint("sp");
            _ps = _con.prepareStatement(_update);
            for (HashMap hm : userid) {
                _ps.setString(1, hm.get("userId").toString());
                _ps.addBatch();
            }
            int checkSave[] = _ps.executeBatch();
            for (int i : checkSave) {
                if (i == PreparedStatement.EXECUTE_FAILED) {
                    _con.rollback(sp);
                    return false;
                }
            }
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    /**
     * Fetches all role_id s  from tbl_role_user which belongs to this user
     * (Note: the caller should set userName before calling
     * this method)
     * @param _con the JDBC connection object
     * @return returns <b>ResultSet</b> object on successful completion
     * of the method, <b>null</b> otherwise
     * @throws SQLException
     */
//    public ResultSet getRoles(Connection _con) throws SQLException {
//        String _select = "SELECT role_id FROM tbl_role_user " +
//                " WHERE user_id = ?";
//        //Connection _con =  ApplicationBean1.getConnection();
//        _con = getConnection();
//        
//        PreparedStatement _ps =
//                _con.prepareStatement(_select,
//                ResultSet.TYPE_SCROLL_INSENSITIVE,
//                ResultSet.CONCUR_READ_ONLY);
//
//        _ps.setString(1, getUserName());
//        _rs = _ps.executeQuery();
//        return _rs;
//    }
    /**
     * Fetches all role_id s  from tbl_role_user which belongs to this user
     * (Note: the caller should set userName before calling
     * this method)
     * @return returns <b>ResultSet</b> object on successful completion
     * of the method, <b>null</b> otherwise
     * @throws SQLException
     */
    public ResultSet DBUserID() {
        String _select = "SELECT USER_ID FROM BIB.TBL_USERS " +
                " WHERE USER_NAME = ?";



        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.setString(1, getUserName());
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            return ocrs;
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

    /**
     * Fetches all role_id s  from tbl_role_user which belongs to this user
     * (Note: the caller should set userName before calling
     * this method)
     * @return returns <b>ResultSet</b> object on successful completion
     * of the method, <b>null</b> otherwise
     * @throws SQLException
     */
    public ResultSet getRoles(int userid) {
        String _select = "SELECT ROLE_ID FROM BIB.tbl_role_user " +
                " WHERE user_id = ?";



        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.setInt(1, userid);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            return ocrs;
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

    /**
     * Fetches all role_id s  from tbl_role_user which belongs to this user
     * (Note: the caller should set userName before calling
     * this method)
     * @param _role the role of the user
     * @return returns <b>true</b> on successful completion
     * of the method, <b>false</b> otherwise
     * @throws SQLException
     */
    public boolean hasRole(RolesEntity _role) {

        String _select = "SELECT role_id FROM BIB.tbl_role_user " +
                " WHERE user_id = ? AND role_id = ?";



        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);//, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            _ps.setString(1, getUserName());
            _ps.setString(1, _role.getName());
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            ocrs.next();
            if (ocrs.getRow() > 0) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    /**
     * Adds a new row into tbl_role_user for this user
     * (Note: the caller should set userName and roleName before calling
     * this method)
     * @param _role the role to be granted
     * @return returns <b>true</b> object on successful completion
     * of the method, <b>false</b> otherwise
     * @throws SQLException
     */
    public boolean grantRole(RolesEntity _role)
    {
        String _update = " INSERT INTO BIB.tbl_role_user(id,role_id,user_id) " +
                " VALUES (BIB.TBL_ROLE_USER_SEQ.NEXTVAL ,?,?) ";


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_update);
            _ps.setString(1, _role.getName());
            _ps.setString(2, getUserName());
            _ps.executeUpdate();
             return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    /**
     * Removes a row from tbl_role_user identified by rollName and userName
     * (Note: the caller should set userName  before calling
     * this method)
     * @param _role the role to be denied
     * @return returns <b>true</b> object on successful completion
     * of the method, <b>false</b> otherwise
     * @throws SQLException
     */
    public boolean denyRole(RolesEntity _role) {
        String _update = " DELETE FROM BIB.tbl_role_user " +
                " WHERE role_id = ? AND user_id = ? ";


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_update);
            _ps.setString(1, _role.getName());
            _ps.setString(2, getUserName());

            _ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    /**
     * Removes all rows from tbl_role_user identified by this user's name
     * (Note: the caller should set userName before calling
     * this method)
     * @return returns <b>true</b> object on successful completion
     * of the method, <b>false</b> otherwise
     * @throws SQLException
     */
    public boolean denyAllRole() {
        String _update = "DELETE FROM BIB.tbl_role_user " +
                " WHERE user_id = ? ";


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_update);
            _ps.setString(1, getUserName());

            _ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    /**
     * checks whether the username provided in use or not
     * @param _userName the user name to be checked.
     * @return <b>true</b> if the username is already in use by another user,
     *  <b>false</b> otherwise
     * @throws java.sql.SQLException
     */
    public boolean userNameInUse(String _userName) {
        String _select = "SELECT USER_ID FROM BIB.TBL_USERS WHERE USER_NAME=?";



        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);//, ResultSet.TYPE_SCROLL_INSENSITIVE,
//                    ResultSet.CONCUR_READ_ONLY);
            _ps.setString(1, _userName);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            if (ocrs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    /**
     * Reads the first_time_access value from the database table
     * @param _userName the name of the user
     * @return <b>First time access</b> as integer on successful completion.
     * <b>Note:</b> a return value of zero indicates that the user is logging in for
     * the first time.
     * @throws java.sql.SQLException
     */
    public ResultSet getFirstTimeAccess(String _userName) {
        String _select = "SELECT first_time_access FROM BIB.tbl_users where user_name=?";



        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.setString(1, _userName);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            return ocrs;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
//<editor-fold defaultstate="collapsed" desc="Setters, Getters and overides" >

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNewUserName() {
        return newUserName;
    }

    public void setNewUserName(String newUserName) {
        this.newUserName = newUserName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDbUserName() {
        return dbUserName;
    }

    public void setDbUserName(String dbUserName) {
        this.dbUserName = dbUserName;
    }

    public String getAnswerToSecurityQuestion() {
        return answerToSecurityQuestion;
    }

    public void setAnswerToSecurityQuestion(String answerToSecurityQuestion) {
        this.answerToSecurityQuestion = answerToSecurityQuestion;
    }

    public int getUserSecurityQuestionId() {
        return userSecurityQuestionId;
    }

    public void setUserSecurityQuestionId(int userSecurityQuestionId) {
        this.userSecurityQuestionId = userSecurityQuestionId;
    }

    public int getFirstTimeAccess() {
        return firstTimeAccess;
    }

    public void setFirstTimeAccess(int firstTimeAccess) {
        this.firstTimeAccess = firstTimeAccess;
    }

    public int hashCode() {
        int hash = 0;
        hash += (userName != null ? userName.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersEntity)) {
            return false;
        }
        UsersEntity other = (UsersEntity) object;
        if ((this.userName == null && other.userName != null) || (this.userName != null && !this.userName.equals(other.userName))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "entity.Users[userName=" + userName + "]";
    }
    //</editor-fold>

    /**
     * Updates row in tbl_users identified by userName
     * (Note: the caller must set userName, newUserName, password,
     * userSecurityQuestionId, answerToSecurityQuestion, firstTimeAccess before
     * calling this method)
     * @return returns <b>true</b> object on successful completion
     * of the method, <b>false</b> otherwise
     * @throws java.sql.SQLException
     */
    public boolean updateInformation() {
        String _update = "UPDATE BIB.TBL_USERS SET USER_NAME=?, PASSWORD=?, " +
                "SECURITY_QUESTION_ID=?, ANSWER_TO_QUESTION=?, FIRST_TIME_ACCESS=? " +
                " WHERE USER_NAME=?";


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_update);
            _ps.setString(1, getNewUserName());
            _ps.setInt(2, getPassword().hashCode());
            _ps.setInt(3, getUserSecurityQuestionId());
            _ps.setString(4, getAnswerToSecurityQuestion());
            _ps.setInt(5, getFirstTimeAccess());
            _ps.setString(6, getUserName());
            // returns true if the number of rows affected by the statement are more
            // than 0, otherwise false
            return _ps.executeUpdate() > 0 ? true : false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    /**
     * Updates the security question and the security answer in tbl_users
     * identified by userName
     * (Note: the caller must set userName before calling this method)
     * @param securityQuestionId the new security question id
     * @param answerToQuestion the new security answer
     * @return <b>true</b> on successful completion of the method, <b>false</b>
     * otherwise
     * @throws java.sql.SQLException
     */
    public boolean updateSecurityQuestion(int securityQuestionId, String answerToQuestion) {
        String _update = "update BIB.tbl_users set security_question_id=?, answer_to_question=? where user_name=? ";


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_update);
            _ps.setInt(1, securityQuestionId);
            _ps.setString(2, answerToQuestion);
            _ps.setString(3, getUserName());
            return _ps.executeUpdate() > 0 ? true : false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    /**
     * Updates the user acess count(i.e. if the user is logging in for the first
     * time or not) in tbl_users identified by userName
     * (Note: the caller must set userName before calling this method)
     * @param userAccessCount the new access count number. (Note: the value of
     * the parameter can be zero if the user has never logged in before, any
     * number greater than zero otherwise.)
     * @return  <b>true</b> on successful completion of the method, <b>false</b>
     * otherwise
     * @throws java.sql.SQLException
     */
    public boolean updateUserAccessCount(int userAccessCount)
    {
        String _update = "update BIB.tbl_users set first_time_access=? where user_name=?";


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_update);
            _ps.setInt(1, userAccessCount);
            _ps.setString(2, getUserName());
            return _ps.executeUpdate() > 0 ? true : false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }
}
