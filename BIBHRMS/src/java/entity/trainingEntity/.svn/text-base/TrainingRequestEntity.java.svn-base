/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.trainingEntity;

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
 * @author DPClone
 */
public class TrainingRequestEntity extends ConnectionManager {

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
    private String trainingNeedId;
//********************************************************************List od Employee Training Request Local Variables************************************
    private String empSelectedID;
    private boolean isSelected;
    private int trainingRequestId;

    public String getEmpSelectedID() {
        return empSelectedID;
    }

    public void setEmpSelectedID(String empSelectedID) {
        this.empSelectedID = empSelectedID;
    }

    public boolean getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public int getTrainingRequestId() {
        return trainingRequestId;
    }

    public void setTrainingRequestId(int trainingRequestId) {
        this.trainingRequestId = trainingRequestId;
    }

    //********************************************************************End Of List od Employee Training Request Local Variables************************************
    /**
     *
     * @return
     */
    public String getTrainingNeedId() {
        return trainingNeedId;
    }

    /**
     *
     * @param trainingNeedId
     */
    public void setTrainingNeedId(String trainingNeedId) {
        this.trainingNeedId = trainingNeedId;
    }
    private String employeeId;
    private String trainingPlan;
    private String institutionName;
    private String remark;
    private String fromDate;
    private String todate;
    private String timeStamp;
    private String trainingType;
    private String trainingCatagory;
    private String trainingPriority;
    private String traineeNo;
    private String TrainingCostPerPerson;
    private String totalTrainingCost;

    /**
     *
     * @return
     */
    public String getTotalTrainingCost() {
        return totalTrainingCost;
    }

    /**
     *
     * @param totalTrainingCost
     */
    public void setTotalTrainingCost(String totalTrainingCost) {
        this.totalTrainingCost = totalTrainingCost;
    }

    /**
     *
     * @return
     */
    public String getTrainingCostPerPerson() {
        return TrainingCostPerPerson;
    }

    /**
     *
     * @param TrainingCostPerPerson
     */
    public void setTrainingCostPerPerson(String TrainingCostPerPerson) {
        this.TrainingCostPerPerson = TrainingCostPerPerson;
    }

    /**
     *
     * @return
     */
    public String getTraineeNo() {
        return traineeNo;
    }

    /**
     *
     * @param traineeNo
     */
    public void setTraineeNo(String traineeNo) {
        this.traineeNo = traineeNo;
    }

    /**
     *
     * @return
     */
    public String getTrainingPriority() {
        return trainingPriority;
    }

    /**
     *
     * @param trainingPriority
     */
    public void setTrainingPriority(String trainingPriority) {
        this.trainingPriority = trainingPriority;
    }
    private int numberOfTrainees;
    private static final String TRAINING_STATUS_REQUEST = "1";
    private static final String TRAINING_STATUS_APPROVE = "2";
    private static final String TRAINING_STATUS_REJECT = "3";
    private String trainingRequestID;
    private String trainingRequestName;

    public String getTrainingRequestID() {
        return trainingRequestID;
    }

    public void setTrainingRequestID(String trainingRequestID) {
        this.trainingRequestID = trainingRequestID;
    }

    public String getTrainingRequestName() {
        return trainingRequestName;
    }

    public void setTrainingRequestName(String trainingRequestName) {
        this.trainingRequestName = trainingRequestName;
    }

    /**
     *
     */
    public TrainingRequestEntity() {
    }

    /**
     *
     * @param trainingRequest
     */
    public TrainingRequestEntity(String trainingRequest) {
        this.trainingNeedId = trainingRequest;
    }

    public TrainingRequestEntity(String trainingRequestID, String trainingRequestName) {
        this.trainingRequestID = trainingRequestID;
        this.trainingRequestName = trainingRequestName;
    }

    /**
     *
     * @param trainingNeedId
     * @param institutionName
     * @param remark
     * @param fromDate
     * @param todate
     * @param trainingType
     * @param trainingCatagory
     * @param trainingPriority
     * @param traineeNo
     * @param TrainingCostPerPerson
     * @param totalTrainingCost
     */
    public TrainingRequestEntity(String trainingNeedId, String institutionName, String remark, String fromDate, String todate, String trainingType, String trainingCatagory, String trainingPriority, String traineeNo, String TrainingCostPerPerson, String totalTrainingCost) {
        this.trainingNeedId = trainingNeedId;
        this.institutionName = institutionName;
        this.remark = remark;
        this.fromDate = fromDate;
        this.todate = todate;
        this.trainingType = trainingType;
        this.trainingCatagory = trainingCatagory;
        this.trainingPriority = trainingPriority;
        this.traineeNo = traineeNo;
        this.TrainingCostPerPerson = TrainingCostPerPerson;
        this.totalTrainingCost = totalTrainingCost;
    }

    /**
     *
     * @param empId
     * @param fromDate
     * @param toDate
     * @param trainingRequest
     */
    public TrainingRequestEntity(String empId, int requestID) {
        this.empSelectedID = empId;
        this.trainingRequestId = requestID;
    }

    /**
     *
     * @param trainingRequest
     * @param employeeId
     * @param trainingPlan
     * @param institutionName
     * @param fromDate
     * @param todate
     * @param timeStamp
     * @param trainingType
     * @param trainingCatagory
     * @param remark
     */
    public TrainingRequestEntity(String trainingRequest, String employeeId, String trainingPlan,
            String institutionName, String fromDate, String todate, String timeStamp,
            String trainingType, String trainingCatagory, String remark) {
        this.trainingNeedId = trainingRequest;
        this.employeeId = employeeId;
        this.trainingPlan = trainingPlan;
        this.institutionName = institutionName;
        this.fromDate = fromDate;
        this.todate = todate;
        this.timeStamp = timeStamp;
        this.trainingType = trainingType;
        this.trainingCatagory = trainingCatagory;
        this.remark = remark;
    }

    //            _list.put("institutionName", (getSessionBean1().getTrainingNeedDP().
//                    getValue("trainingInstitution").toString()));
//            _list.put("fromDate", (getSessionBean1().getTrainingNeedDP().
//                    getValue("trainingFrom").toString()));
//            _list.put("todate", (getSessionBean1().getTrainingNeedDP().
//                    getValue("trainingTo").toString()));
//            _list.put("trainingCost", (getSessionBean1().getTrainingNeedDP().
//                    getValue("trainingCosttotalTrainingCost").toString()));
//            _list.put("totalTrainingCost", (getSessionBean1().getTrainingNeedDP().
//                    getValue("totalTrainingCost").toString()));
//            _list.put("trainingType", (getSessionBean1().getTrainingNeedDP().
//                    getValue("trainingType").toString()));
//            _list.put("trainingCatagory", (getSessionBean1().getTrainingNeedDP().
//                    getValue("trainingCategory").toString()));
//            _list.put("priority", (getSessionBean1().getTrainingNeedDP().
//                    getValue("trainingPriority").toString()));
//            _list.put("remark", (getSessionBean1().getTrainingNeedDP().
//                    getValue("remark").toString()));
    /**
     *
     * @param employeeId
     * @param institutionName
     * @param fromDate
     * @param todate
     * @param timeStamp
     * @param trainingType
     * @param trainingCatagory
     * @param trainingPriority
     * @param remark
     */
    public TrainingRequestEntity(String employeeId, String institutionName,
            String fromDate, String todate, String timeStamp,
            String trainingType, String trainingCatagory, String trainingPriority, String remark) {
        this.employeeId = employeeId;
        this.institutionName = institutionName;
        this.fromDate = fromDate;
        this.todate = todate;
        this.timeStamp = timeStamp;
        this.trainingType = trainingType;
        this.trainingCatagory = trainingCatagory;
        this.trainingPriority = trainingPriority;
        this.remark = remark;
    }

    /**
     * The method calls the insert, update, approve and reject methods based on the
     * value of the newOrOld.
     * @param newOrOld
     * @throws java.sql.SQLException
     */
    public void add(String newOrOld) throws SQLException {
        if (newOrOld.equalsIgnoreCase("new")) {
            this.insert(this);
        } else if (newOrOld.equalsIgnoreCase("old")) {
            this.update(this);
        } else if (newOrOld.equalsIgnoreCase(TRAINING_STATUS_APPROVE)) {
            this.approve(this);
        } else if (newOrOld.equalsIgnoreCase(TRAINING_STATUS_REJECT)) {
            this.reject(this);
        }
    }

    /**
     *
     */
    public void delete() {
        this.delete(getTrainingNeedId());
    }

    /**
     * @return the employeeId
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * The method fetches all training need requests made by the given employee.
     * @param empId the unique identifier of the employee
     * @return <code>ResultSet</code> object rs.
     * @throws SQLException
     */
    public ResultSet readAllTrainingRequest(String empId) throws SQLException {
        ResultSet rs = null;
        _con = getConnection();
        String selectTrainee = "SELECT h.`training_need_id`, h.`prepared_by`, " +
                "h.`confirmed_by`, h.`prepared_date`, h.`confirmed_date`, " +
                "td.`training_type`, td.`training_category`, td.`training_start_date`, td.`training_end_date`, " +
                "td.`trainer`, td.`trainee_no`, td.`cost_per_person`, td.`priority`, td.`remark`, td.`status` " +
                "FROM hr_training_need h, hr_training_need_detail td " +
                "WHERE h.`training_need_id` = td.`training_need_id`" +
                "AND h.`prepared_by` = '" + empId + "'";
        PreparedStatement ps = _con.prepareStatement(selectTrainee);
        rs = ps.executeQuery();

        return rs;
    }

    /**
     *
     * @return
     */
    public ResultSet readNewTrainingRequest() {
        ResultSet rs = null;
        try {
            _con = getConnection();
            String selectTrainee = "SELECT h.`training_need_id`, " +
                    "h.`prepared_date`, e.`first_Name`, e.`middle_Name`, e.`last_Name` " +
                    "FROM hr_training_need h, hr_employee_info e " +
                    "WHERE h.`prepared_by` = e.`emp_Id`";
            PreparedStatement ps = _con.prepareStatement(selectTrainee);
            rs = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            ErrorLogWriter.writeError(e);
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return rs;
    }

    /**
     * The method fetches data from the training_need_id, hr_training_need_detail,
     * hr_employee_info, and tbl_department table to have a complete information
     * on the training need.
     * @param needId
     * @return <code>ResultSet</code> object rs
     */
    public ResultSet readTrainingNeeds(String needId) {
        ResultSet rs = null;
        try {
            _con = getConnection();
            String selectTrainee = "SELECT h.`training_need_id`, h.`prepared_by`, h.`confirmed_by`, h.`prepared_date`, " +
                    "h.`confirmed_date`, e.`first_Name`, e.`middle_Name`, e.`last_Name`, e.`department_id`, " +
                    "d.`description` as deptDesc, tty.`description` as trainingTypeDesc, tr.`name` as trainerName," +
                    "td.`training_type`, td.`training_category`, td.`training_start_date`, " +
                    "td.`training_end_date`, td.`trainer`, td.`trainee_no`, td.`cost_per_person`, td.`priority`, " +
                    "td.`remark`, td.`status` " +
                    "FROM hr_training_need h, hr_training_need_detail td, hr_employee_info e, tbl_department d, " +
                    "tbl_training_type tty, tbl_trainer tr " +
                    "where h.`training_need_id` = td.`training_need_id` " +
                    "AND h.`training_need_id` = '" + needId + "' " +
                    "AND h.`prepared_by` = e.`emp_Id`  " +
                    "AND d.`department_id` =e.`department_id` " +
                    "AND tty.`training_type_id`= td.`training_type` " +
                    "AND tr.`trainer_id` = td.`trainer`";
            PreparedStatement ps = _con.prepareStatement(selectTrainee);
            rs = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            ErrorLogWriter.writeError(e);
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return rs;
    }

    /**
     *
     * @param userName
     * @return
     * @throws java.sql.SQLException
     */
    public ArrayList<TrainingRequestEntity> requestedTraining(String userName) throws SQLException {
        return this.readUserTrainingRequest(userName);
    }

    /**
     * @param employeeId the employeeId to set
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @return the trainingPlan
     */
    public String getTrainingPlan() {
        return trainingPlan;
    }

    /**
     * @param trainingPlan the trainingPlan to set
     */
    public void setTrainingPlan(String trainingPlan) {
        this.trainingPlan = trainingPlan;
    }

    /**
     * @return the institutionName
     */
    public String getInstitutionName() {
        return institutionName;
    }

    /**
     * @param institutionName the institutionName to set
     */
    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
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

    /**
     * @return the fromDate
     */
    public String getFromDate() {
        return fromDate;
    }

    /**
     * @param fromDate the fromDate to set
     */
    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    /**
     * @return the todate
     */
    public String getTodate() {
        return todate;
    }

    /**
     * @param todate the todate to set
     */
    public void setTodate(String todate) {
        this.todate = todate;
    }

    /**
     * @return the timeStamp
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * @param timeStamp the timeStamp to set
     */
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * @return the trainingType
     */
    public String getTrainingType() {
        return trainingType;
    }

    /**
     * @param trainingType the trainingType to set
     */
    public void setTrainingType(String trainingType) {
        this.trainingType = trainingType;
    }

    /**
     * @return the trainingCatagory
     */
    public String getTrainingCatagory() {
        return trainingCatagory;
    }

    /**
     * @param trainingCatagory the trainingCatagory to set
     */
    public void setTrainingCatagory(String trainingCatagory) {
        this.trainingCatagory = trainingCatagory;
    }

    /**
     * @return the numberOfTrainees
     */
    public int getNumberOfTrainees() {
        return numberOfTrainees;
    }

    /**
     * @param numberOfTrainees the numberOfTrainees to set
     */
    public void setNumberOfTrainees(int numberOfTrainees) {
        this.numberOfTrainees = numberOfTrainees;
    }

    /**
     * The method makes changes in the tbl_training_request table with regard to
     * training approval.
     * @param aThis a TrainingRequestEntity object
     * @throws java.sql.SQLException if a database access error occurs
     * or this method is called on a closed connection
     */
    private void approve(TrainingRequestEntity aThis) throws SQLException {
        _con = getConnection();
        String str = "UPDATE tbl_training_request SET training_type_id = ?, requester_Id = ?, " +
                "from_date = ?, to_date = ?, training_category=?, institution_name = ?, remark = ? WHERE training_type_id = ?";

        PreparedStatement ps = _con.prepareStatement(str);
        ps.setString(1, this.getTrainingType());
        ps.setString(2, this.getEmployeeId());
        ps.setString(3, this.getFromDate());
        ps.setString(4, this.getTodate());
        ps.setString(5, this.getTrainingCatagory());
        ps.setString(6, this.getInstitutionName());
        ps.setString(7, this.getRemark());
        ps.setString(8, TRAINING_STATUS_APPROVE);

        ps.executeUpdate();
    }

    /**
     * The method removes a row of data from the tbl_training_request table.
     * @param trainingRequestId the unique identifier of the training request
     * @return true if successful deletion is made, false otherwise
     */
    private boolean delete(String trainingRequestId) {
        boolean deleted = false;

        String str = "DELETE FROM tbl_training_request WHERE training_reques_id=?";

        try {
            _con = getConnection();
            PreparedStatement ps = _con.prepareStatement(str);
            ps.setString(1, trainingRequestId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                deleted = true;
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
        return deleted;
    }

    /**
     * The method inserts a row of data into the hr_training_need_detail table
     * @param aThis a TrainingRequestEntity object
     * @throws java.sql.SQLException if a database access error occurs
     * or this method is called on a closed connection
     */
    public int insert(TrainingRequestEntity aThis) throws SQLException {

        String str = "INSERT INTO TBL_TRAINING_CANDIDATES (" +
                "EMPLOYEE_ID, REQUEST_ID) " +
                " values(?, ?)";
        try {
            _con = getConnection();
            PreparedStatement ps = _con.prepareStatement(str);
            ps.setString(1, this.getEmpSelectedID());
            ps.setInt(2, this.getTrainingRequestId());
            return ps.executeUpdate();
        } catch (Exception ex) {

            ex.printStackTrace();
            return 0;
        }

    }

    public int deleteEmployeesCandidate(TrainingRequestEntity aThis) {
        String str = "DELETE FROM TBL_TRAINING_CANDIDATES WHERE EMPLOYEE_ID='" + aThis.getTrainingNeedId() + "'";
        try {
            _con = getConnection();
            PreparedStatement ps = _con.prepareStatement(str);
            return ps.executeUpdate();
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

    /**
     * The method is used to fetch training request information from the tbl_training_request
     * table and arrange the <code>ResultSet</code> object into an
     * <code>ArrayList</code> of type TrainingRequestEntity
     * @param userName the employee who made the training request
     * @return an <code>ArrayList</code> of type TrainingRequestEntity
     * @throws java.sql.SQLException if a database access error occurs
     * or this method is called on a closed connection
     */
    private ArrayList<TrainingRequestEntity> readUserTrainingRequest(String userName) throws SQLException {
        ResultSet rs = null;
        _con = getConnection();
        ArrayList<TrainingRequestEntity> trainingRequstList = new ArrayList<TrainingRequestEntity>();

        String selectTrainee = "SELECT t.`training_reques_id`, t.`training_type_id`, " +
                "t.`training_plan_id`, t.`from_date`, " +
                "t.`to_date`, t.`training_category`, t.`institution_name`, " +
                "t.`remark`, t.`no_of_trainees` " +
                "FROM tbl_training_request t WHERE status = " + '1' + " AND requester_Id = " + userName + ";";
        PreparedStatement ps = _con.prepareStatement(selectTrainee);
        rs = ps.executeQuery();

        while (rs.next()) {
            TrainingRequestEntity trainingRequests = new TrainingRequestEntity(rs.getString("training_reques_id"), rs.getString("training_type_id"),
                    rs.getString("training_plan_id"), rs.getString("from_date"), rs.getString("to_date"),
                    rs.getString("training_category"), rs.getString("training_category"), rs.getString("institution_name"),
                    rs.getString("no_of_trainees"), rs.getString("remark"));
            trainingRequstList.add(trainingRequests);
        }
        rs.close();
        return trainingRequstList;
    }

    /**
     * The method makes changes in the tbl_training_request table with the information
     * from the current instance of this class.
     * (Note: the setter method or the constructor of this class must be called
     * before calling this method.)
     * @param aThis the current object of TrainingRequestEntity class
     * @throws java.sql.SQLException if a database access error occurs
     * or this method is called on a closed connection
     */
    private void reject(TrainingRequestEntity aThis) throws SQLException {
        _con = getConnection();
        String str = "UPDATE tbl_training_request SET training_type_id = ?, requester_Id = ?, " +
                "from_date = ?, to_date = ?, training_category=?, institution_name = ?, remark = ? WHERE training_type_id = ?";

        PreparedStatement ps = _con.prepareStatement(str);
        ps.setString(1, this.getTrainingType());
        ps.setString(2, this.getEmployeeId());
        ps.setString(3, this.getFromDate());
        ps.setString(4, this.getTodate());
        ps.setString(5, this.getTrainingCatagory());
        ps.setString(6, this.getInstitutionName());
        ps.setString(7, this.getRemark());
        ps.setString(8, TRAINING_STATUS_REJECT);

        ps.executeUpdate();
    }

    /**
     * The method makes changes in the tbl_training_request table with the information
     * from the current instance of this class.
     * (Note: the setter method or the constructor of this class must be called
     * before calling this method.)
     * @param aThis the current object of TrainingRequestEntity class.
     * @throws java.sql.SQLException if a database access error occurs
     * or this method is called on a closed connection.
     */
    private void update(TrainingRequestEntity aThis) throws SQLException {
        _con = getConnection();
        String str = "UPDATE tbl_training_request SET training_type_id = ?, requester_Id = ?, " +
                "from_date = ?, to_date = ?, training_category=?, institution_name = ?, remark = ? WHERE training_type_id = ?";

        PreparedStatement ps = _con.prepareStatement(str);
        ps.setString(1, this.getTrainingType());
        ps.setString(2, this.getEmployeeId());
        ps.setString(3, this.getFromDate());
        ps.setString(4, this.getTodate());
        ps.setString(5, this.getTrainingCatagory());
        ps.setString(6, this.getInstitutionName());
        ps.setString(7, this.getRemark());

        ps.executeUpdate();
    }

    public ArrayList<TrainingRequestEntity> readEmployeeTrainingRequests() {
        //  String _select = "SELECT DEPT_ID,TRAINING_REQUES_ID,REQUESTER,DEP_DESCRIPTION FROM VW_TRAINING_REQUEST WHERE SATUS='" + 0 + "'";
        String _select = "SELECT * FROM HR_TRAIN_NEED_ASSESSEMENT_REQ WHERE " +
                "REQUEST_STATUS LIKE 'App%'";

        ArrayList<TrainingRequestEntity> trainingEntity = new ArrayList<TrainingRequestEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            while (_rs.next()) {
                //  TrainingRequestEntity trEntity = new TrainingRequestEntity(_rs.getString("TRAINING_REQUES_ID") + "--" + _rs.getString("REQUESTER") + "--" + _rs.getString("DEPT_ID"), _rs.getString("DEP_DESCRIPTION"));

                TrainingRequestEntity trEntity = new TrainingRequestEntity(
                        _rs.getString("NEED_ASSESSEMENT_REQUEST_ID") + "--" +
                        _rs.getString("REQUESTER_ID"),
                        _rs.getString("TRAINING_NAME") +
                        "--" + _rs.getString("TENTATIVE_START_DATE") +
                        "--" + _rs.getString("TENTATIVE_END_DATE"));
                trainingEntity.add(trEntity);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }
        }
        return trainingEntity;
    }

    public ArrayList<TrainingRequestEntity> readProcessedEmployeeTrainingRequests() {
        String _select = "SELECT TRAINING_REQUES_ID,DEP_DESCRIPTION FROM VW_TRAINING_REQUEST_LIST WHERE SATUS='" + 1 + "'";



        ArrayList<TrainingRequestEntity> trainingEntity = new ArrayList<TrainingRequestEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            while (_rs.next()) {
                TrainingRequestEntity trEntity = new TrainingRequestEntity(_rs.getString("TRAINING_REQUES_ID"), _rs.getString("DEP_DESCRIPTION"));
                trainingEntity.add(trEntity);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }
        }
        return trainingEntity;
    }

    public ArrayList<HashMap> readTrainingRequestByDepartment(String departmentid) throws SQLException {




        _con = getConnection();
        ArrayList<HashMap> trainingRequstList = new ArrayList<HashMap>();
        HashMap requestAttributes = new HashMap();
        _ps = null;

        String selectTrainee = "SELECT TRAINING_REQUES_ID,TRAINING_TYPE_ID, " +
                "FROM_DATE,TO_DATE,INSTITUTION_ID,REMARK,NO_OF_TRAINEES, " +
                "REQUESTER_ID,PRIORITY_ID,FOR_DEPARTMENT_ID,REQUEST_DATE, " +
                "COAST_PER_PERSON,TOTAL_COAST,PENDING " +
                "FROM tbl_training_request  WHERE FOR_DEPARTMENT_ID= '" + departmentid + "'AND PENDING ='0' ";
        try {

            _ps = _con.prepareStatement(selectTrainee);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                requestAttributes = new HashMap();
                requestAttributes.put("TRAINING_REQUES_ID", _rs.getString("TRAINING_REQUES_ID") == null ? "NULL" : _rs.getString("TRAINING_REQUES_ID"));
                requestAttributes.put("TRAINING_TYPE_ID", _rs.getString("TRAINING_TYPE_ID") == null ? "NULL" : _rs.getString("TRAINING_TYPE_ID"));
                requestAttributes.put("FROM_DATE", _rs.getString("FROM_DATE") == null ? "NULL" : _rs.getString("FROM_DATE"));
                requestAttributes.put("TO_DATE", _rs.getString("TO_DATE") == null ? "NULL" : _rs.getString("TO_DATE"));
                requestAttributes.put("INSTITUTION_ID", _rs.getString("INSTITUTION_ID") == null ? "NULL" : _rs.getString("INSTITUTION_ID"));
                requestAttributes.put("REMARK", _rs.getString("REMARK") == null ? "NULL" : _rs.getString("REMARK"));
                requestAttributes.put("NO_OF_TRAINEES", _rs.getString("NO_OF_TRAINEES") == null ? "NULL" : _rs.getString("NO_OF_TRAINEES"));
                requestAttributes.put("REQUESTER_ID", _rs.getString("REQUESTER_ID") == null ? "NULL" : _rs.getString("REQUESTER_ID"));
                requestAttributes.put("PRIORITY_ID", _rs.getString("PRIORITY_ID") == null ? "NULL" : _rs.getString("PRIORITY_ID"));
                requestAttributes.put("FOR_DEPARTMENT_ID", _rs.getString("FOR_DEPARTMENT_ID") == null ? "NULL" : _rs.getString("FOR_DEPARTMENT_ID"));
                requestAttributes.put("REQUEST_DATE", _rs.getString("REQUEST_DATE") == null ? "NULL" : _rs.getString("REQUEST_DATE"));
                requestAttributes.put("COAST_PER_PERSON", _rs.getString("COAST_PER_PERSON") == null ? "NULL" : _rs.getString("COAST_PER_PERSON"));
                requestAttributes.put("TOTAL_COAST", _rs.getString("TOTAL_COAST") == null ? "NULL" : _rs.getString("TOTAL_COAST"));
                requestAttributes.put("PENDING", _rs.getString("PENDING") == null ? "NULL" : _rs.getString("PENDING"));
                trainingRequstList.add(requestAttributes);

            }
        } finally {
            _rs.close();
            _ps.clearBatch();
            _con.close();
        }

        return trainingRequstList;
    }
}
