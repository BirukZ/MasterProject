/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.userManagement;

import com.sun.webui.jsf.model.Option;
import connectionProvider.ConnectionManager;
import entity.userManagement.Entity.PermissionEntity;
import entity.userManagement.Entity.ResourcesEntity;
import entity.userManagement.Entity.RolesEntity;
import entity.userManagement.Entity.UsersEntity;
import java.io.File;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.model.SelectItem;
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 * this class is responsible for authentication and Authoraization
 * @author Yidnek
 */
public class SiteSecurityManager  extends ConnectionManager implements Serializable{

    UsersEntity users = new UsersEntity();
    RolesEntity roles = new RolesEntity();
    ResourcesEntity resources = new ResourcesEntity();
    PermissionEntity permission = new PermissionEntity();

    public String selectEmployeeId(String userName) {
        try {
            String empId = users.getEmployeeId(userName);
            return empId;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    /**
     * checks if the user is accessing the system for the first time
     * @param userName the user name used as a search criteria
     * @return true if the user is accessing the system for the first time,
     * otherwise false
     */
    public boolean isFirstTimeAccess(String userName) {
        try {
            ResultSet _rs = users.getFirstTimeAccess(userName);
            if (_rs.next()) {
                int firstTimeAccess = _rs.getInt("first_time_access");
                if (firstTimeAccess == 0) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    // authenticate
    /**
     * Compares the hashcode of the _password with the password from table
     * if the user exists
     * @param _userName the username of the user
     * @param _password the password of the user
     * @return returns <b>true</b> if user is valid user,
     * <b>false</b> otherwise
     */
    public boolean isValidUser(String _userName, String _password) {
        //check _userName and _password are available in the db
        int _passHash = _password.hashCode();
        try {
            if (users.getPassword(_userName) != null && _passHash == Integer.parseInt(users.getPassword(_userName))) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    /**
     * Compares the hashcode of the _password with the password from table
     * if the user exists
     * @param _userName the username of the user
     * @param _password the password of the user
     * @return returns <b>true</b> if user is valid user,
     * <b>false</b> otherwise
     */
    public boolean isValidUser(String _userName, String _password, String _employeeId) {
        //check _userName and _password are available in the db
        int _passHash = _password.hashCode();
        try {
            if (users.getPassword(_userName, _employeeId) != null && _passHash == Integer.parseInt(users.getPassword(_userName, _employeeId))) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    /**
     * Checks whether a user _userName is authorized for resource _resourcePath
     * @param _userName the name of the user
     * @param _resourcePath the path of the resource
     * @return returns <b>true</b> if the user is authorized,
     * <b> false</b> otherwise
     */
    public boolean isAuthorizeUser(String _userName, String _resourcePath) {
        // check All Rolls for _userName
        RolesEntity _role;
        try {
            String _assigned[] = getAssignedRoles(_userName, getConnection());
            for (int i = 0; i < _assigned.length; i++) {
                _role = new RolesEntity(_assigned[i]);
                try {
                    if (_role.hasResource(new ResourcesEntity(resources.getId(_resourcePath)))) {
                        return true;
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    ErrorLogWriter.writeError(ex);
                    return false;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // for each Roll check permision for the resource requested
        return false;
    }

    /**
     * Checks whether the resource identified by _path needs to be secure or not
     * @param _path the path of the resouce
     * @return returns <b>true</b> if resource is common resource (not secure resource),
     * <b>false</b> otherwise
     */
    public boolean isSecurResource(String _path) {
        if (resources.getId(_path) > 0) {
            try {

                return roles.isResourceSecure(new ResourcesEntity(resources.getId(_path)));
            } catch (Exception ex) {
                ex.printStackTrace();
                ErrorLogWriter.writeError(ex);
                return false;
            }
        }
        return false;
    }

    public static boolean createListConnection() {
        return true;
    }
    private static int counter = 0;
    private static Option[] root = new Option[2000];

    public static Option[] getRoot() {
        return root;
    }

    /**
     * Checks whether the username is already in use or not
     * @param userName the user name to be checked
     * @return returns <b>true</b> if the username is in use,
     * <b>false</b> otherwise
     */
    public boolean isUserNameUsed(String userName) {

        try {
            if (users.userNameInUse(userName)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public static void setRoot(Option[] root) {
        SiteSecurityManager.root = root;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        SiteSecurityManager.counter = counter;
    }

    /**
     * Updates the user information according to the parameters passed.
     * Note: this method calls three different methods to update the user information
     * @param userName the user name of the user
     * @param newUserName the new user name. Note: the new user name will replace the
     * old user name only if the new user name is not empty.
     * @param newPassword The new password
     * @param securityQuestionId the security question selected by the user. Note the
     * security question can be updated only if the user is changing the user
     * information for the first time.
     * @param answerToSecurityQuestion The answer given to the security question.
     * @param firstTimeAccess flag indicating whether the user is updating the use
     * information for the first time. Note: the flag having a value different from
     * Zero(0) indicates that user has already selected the security question and
     * provided answer to the security question. The caller must pass a number
     * different from Zero in order to indicate that the user has already updated the
     * security question.
     * @return <b>true</b> if the user information is updated successfully
     * otherwise <b>false</b>
     */
    public static boolean updateUserInformation(String userName, String newUserName,
            String newPassword, int securityQuestionId, String answerToSecurityQuestion,
            int firstTimeAccess) {
        UsersEntity _user = null;
        if (newUserName.equals(null)) {
            newUserName = userName;
        }
        try {
            if (firstTimeAccess == 0) {
                firstTimeAccess = 1;
                _user = new UsersEntity(userName, newUserName, newPassword,
                        securityQuestionId, answerToSecurityQuestion, firstTimeAccess);
                return _user.updateInformation();
            } else {
                _user = new UsersEntity();
                _user.setUserName(userName);
                _user.setNewUserName(newUserName);
                _user.setPassword(newPassword);
                return _user.update();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;

        }


    }

    /**
     * Fetchs all the files and directories in the file specified by _rootFile
     * and puts the each file's Name & Absolute path as value and label for
     * an root which is array of Option object
     * @param _rootFile the parent from which the resource needed
     */
    private static void getResourceListFromFile(File _rootFile) {
        //root = null;
        if (_rootFile.isDirectory()) {
            File _allInRoot[] = _rootFile.listFiles();
            for (int i = 0; i < _allInRoot.length; i++) {
                if (_allInRoot[i].getName().indexOf(".jsp") != -1 &&
                        _allInRoot[i].getName().indexOf(".jsp") == (_allInRoot[i].getName().length() - 4)) {
                    root[counter] = new Option(_allInRoot[i].getPath(),
                            _allInRoot[i].getName());
                    setCounter(counter + 1);
                }
                getResourceListFromFile(_allInRoot[i]);
            }
        }
    }

    /**
     * Calls getResourceListFromFile(_rootFile) and write all the list in to
     * Option array
     * @param _rootFile the file/directory from which the resource needed
     * @return Option array filled with file and directory list and value pair
     */
    public static Option[] getResourceFromFile(File _rootFile) {
        setCounter(0);
        getResourceListFromFile(_rootFile);
        Option[] _list = new Option[getCounter()];
        for (int i = 0; i < getCounter(); i++) {
            _list[i] = root[i];
        }
        //setRoot(new Option[1000]);
        //setCounter(0);
        return _list;
    }

    //insert, update, delete Role
    /**
     * Calls UsersEntity.insert after instantiate UsersEntity with the give data
     * (_password is transferd as _password.hashcode)
     * @param _userName the username
     * @param _password the password
     * @return returns <b>true</b> on successful completion of the method,
     * <b>false</b> otherwise
     */
    public static int addUser(String _userName, String _password, String _employeeId) {

        try {
            UsersEntity _user = new UsersEntity(_userName, String.valueOf(_password.hashCode()), _employeeId);
            _user.insert();
            return 1;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
    }

    /**
     * Calls UsersEntity.update after instantiate UsersEntity with the give data
     * @param _userName the old username
     * @param _newUserName the new username
     * (if empty the old username will be used)
     * @param _password tne new password
     * @return returns <b>true</b> on successful completion of the method,
     * <b>false</b> otherwise
     */
    public static boolean updateUser(String _userName,
            String _newUserName, String _password) {
        UsersEntity _user = new UsersEntity(_userName, _password);
        if (!_newUserName.equals(null)) {
            _user.setNewUserName(_newUserName);
        } else {
            _user.setNewUserName(_userName);
        }
        try {
            _user.update();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;

        }
    }

    /**
     * Calls UsersEntity.delete after instantiate UsersEntity with the give data
     * @param _userName the usert to be removed
     * @return returns <b>true</b> on successful completion of the method,
     * <b>false</b> otherwise
     */
    public static boolean deleteUser(String _userName) {
        UsersEntity _user = new UsersEntity(_userName);
        try {
            _user.delete();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }

    }

    public  boolean deleteUser(ArrayList<HashMap> userid) {
        UsersEntity _user = new UsersEntity();
        try {
            return _user.delete(userid);

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }

    }

    //insert, update, delete User
    /**
     * Calls RolesEntity.insert after instantiate RolesEntity with the give data
     * @param _name the name of the role
     * @param _desc some description about the role
     * @return returns <b>true</b> on successful completion of the method,
     * <b>false</b> otherwise
     */
    public static int addNewRole(String _name, String _desc) {
        RolesEntity _role = new RolesEntity(_name, _desc);
        try {
            _role.insert();
            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }

    }

    /**
     * Calls RolesEntity.update after instantiate RolesEntity with the give data
     * @param _name the name of the role
     * @param _newName the new name of the role
     * @param _desc some description about the role
     * @return returns <b>true</b> on successful completion of the method,
     * <b>false</b> otherwise
     */
    public static boolean updateRole(String _name,
            String _newName, String _desc) {
        RolesEntity _role = new RolesEntity(_name, _desc);
        _role.setNewName(_newName);
        try {
            _role.update();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }

    }

    /**
     * Calls RolesEntity.delete after instantiate RolesEntity with the give data
     * @param _name the name of the role
     * @return returns <b>true</b> on successful completion of the method,
     * <b>false</b> otherwise
     */
    public static boolean deleteRole(String _name) {
        RolesEntity _role = new RolesEntity(_name);
        try {
            _role.delete();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }
    //insert, update, delete PermissionEntity

    /**
     * Calls PermissionEntity.insert after instantiate PermissionEntity with the give data
     * @param _name the name of the PermissionEntity
     * @param _desc some description about the PermissionEntity
     * @return returns <b>true</b> on successful completion of the method,
     * <b>false</b> otherwise
     */
    public static int addPermission(String _name, String _desc) {
        PermissionEntity _permission = new PermissionEntity();
        try {
            return _permission.insert(_name, _desc);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
    }

    /**
     * Calls PermissionEntity.update after instantiate PermissionEntity with the give data
     * @param _name the name of the PermissionEntity
     * @param _newName the new name of the PermissionEntity
     * @param _desc some description about the PermissionEntity
     * @return returns <b>true</b> on successful completion of the method,
     * <b>false</b> otherwise
     */
    public static boolean updatePermission(int _code, String _name, String _desc) {
        PermissionEntity _permission = new PermissionEntity(_code, _name, _desc);
        try {
            _permission.update();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    /**
     * Calls PermissionEntity.delete after instantiate PermissionEntity with the give data
     * @param _name the name of the PermissionEntity
     * @return returns <b>true</b> on successful completion of the method,
     * <b>false</b> otherwise
     */
    public static boolean deletePermission(int _code) {
        PermissionEntity _permission = new PermissionEntity(_code);
        try {
            _permission.delete();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    //insert, update, delete Resource
    /**
     * Calls ResourcesEntity.insert after instantiate ResourcesEntity with the give data
     * @param _name the name of the resource
     * @param _desc some description about the resource
     * @param _path the path of the resource
     * @return returns <b>true</b> on successful completion of the method,
     * <b>false</b> otherwise
     */
    public static int addResource(String _name, String _desc, String _path) {
        ResourcesEntity _resource = new ResourcesEntity(_name, _desc, _path);
        try {
            if (_resource.addNewResource(_name, _desc, _path) == 1) {
                return 1;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    /**
     * Calls ResourcesEntity.update after instantiate ResourcesEntity with the give data
     * @param _id the table id of the resource to be updated
     * @param _name the name of the resource
     * @param _desc some description about the resource
     * @param _path the path of the resource
     * @return returns <b>true</b> on successful completion of the method,
     * <b>false</b> otherwise
     */
    public static boolean updateResource(int _id, String _name,
            String _desc, String _path) {
        ResourcesEntity _resource = new ResourcesEntity(_id, _name, _desc, _path);
        _resource.update();
        return true;
    }

    /**
     * Calls UsersEntity.updateSecurityQuestion after instantiating UsersEntity with the given data
     * @param userName the user name used to identify the row to be updated
     * @param securityQuestionId the new security question
     * @param answerToSecurityQuestion answer given to the user security question
     * @return returns <b>true</b> on successful completion of the method,
     * <b>false</b> otherwise
     */
    public static boolean updateUserSecurityQuestion(String userName,
            int securityQuestionId, String answerToSecurityQuestion) {
        UsersEntity _user = new UsersEntity(userName);
        try {
            return _user.updateSecurityQuestion(securityQuestionId, answerToSecurityQuestion);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }

    }

    /**
     * Calls UsersEntity.updateUserAccessCount after instantiating UsersEntity with the given data
     * @param userName the user name of the user
     * @param userAccessCount the access count indicating the if the user is
     * accessing for the first time or not. <b>Note: </b> the userAccessCount
     * having a value of Zero indicates that the user has never accessed the system
     * before.
     * @return <code>true</code> if the user is access count is updated successfully,
     * otherwise <code>true</code>
     */
    public static boolean updateFirstTimeAccess(String userName, int userAccessCount) {
        UsersEntity _user = new UsersEntity(userName);
        try {
            return _user.updateUserAccessCount(userAccessCount);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    /**
     * Calls ResourcesEntity.delete after instantiate ResourcesEntity with the give data
     * @param _id table the id of the resource to be updated
     * @return returns <b>true</b> on successful completion of the method,
     * <b>false</b> otherwise
     */
    public static boolean deleteResource(int _id) {
        ResourcesEntity _resource = new ResourcesEntity(_id);
        _resource.delete();
        return true;
    }

    //add role to user
    /**
     * Calls User.grantRole method iterativly for each role in _roleName[]
     * @param _userName the name of the user
     * @param _roleName all the granted roles
     * @return returns <b>true</b> on successful completion of the method,
     * <b>false</b> otherwise
     */
    public static boolean grantRoleToUser(String _userName, String _roleName[]) {
        try {
            UsersEntity _user = new UsersEntity(_userName);
            // deny all roles
            _user.denyAllRole();
            RolesEntity _role;
            for (int i = 0; i < _roleName.length; i++)
            {
                _role = new RolesEntity(_roleName[i]);
                _user.grantRole(_role);
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    /**
     * Calls User.denyRole method iterativly for each role in _roleName[]
     * @param _userName the name of the user
     * @param _roleName all the denied roles
     * @return returns <b>true</b> on successful completion of the method,
     * <b>false</b> otherwise
     */
    public static boolean denyRoleToUser(String _userName, String _roleName[]) {
        UsersEntity _user = new UsersEntity(_userName);
        RolesEntity _role;
        try {
            for (int i = 0; i < _roleName.length; i++) {
                _role = new RolesEntity(_roleName[i]);
                _user.denyRole(_role);
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    /**
     * Calls RolesEntity.grantResource method iterativly for each resource in _id[]
     * after denying all resources
     * @param _roleName the name of the role
     * @param _id  all the ids of the granted resources
     * @return returns <b>true</b> on successful completion of the method,
     * <b>false</b> otherwise
     */
    public static boolean grantResourceToRole(String _roleName, String _reAssignedResourceId[]) {
        try {
            //get list of assigned resources
            String[] assignedResourcesFromDb = getAssignedResources(_roleName);
            Set<String> resourceFromDb = new HashSet<String>();
            Set<String> commonResources = new HashSet<String>();
            if (assignedResourcesFromDb != null &&
                    assignedResourcesFromDb.length > 0) {
                //iteratively fills the assigned resources to resourceFromDb set
                for (String resources : assignedResourcesFromDb) {
                    resourceFromDb.add(resources);
                    commonResources.add(resources);
                }
            }
            Set<String> assignedFromApp = new HashSet<String>();
            //iteratively fills the re-assigned resources to assignedFromApp set
            for (String resources : _reAssignedResourceId) {
                assignedFromApp.add(resources);
            }
            //get resources common to existing and new assignment
            commonResources.retainAll(assignedFromApp);
            //remove the common resources from resourceFromDb and assignedFromApp
            // set A - (A n B)
            resourceFromDb.removeAll(commonResources);
            // set B - (A n B)
            assignedFromApp.removeAll(commonResources);
            RolesEntity _role = new RolesEntity(_roleName);
            ResourcesEntity _resource;

            //remove rejected resourceFromDb  that do not reassigned again
            Iterator rejectedResource = resourceFromDb.iterator();
            while (rejectedResource.hasNext()) {
                String resourceId = (String) rejectedResource.next();
                _resource = new ResourcesEntity(Integer.parseInt(resourceId));
                _role.denyResource(_resource);//resource removed
            }
            //saves granted assignedFromApp
            Iterator newResource = assignedFromApp.iterator();
            while (newResource.hasNext()) {
                String resourceId = (String) newResource.next();
                _resource = new ResourcesEntity(Integer.parseInt(resourceId));
                _role.grantResource(_resource, "00"); // permision not setted
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    /**
     * Calls RolesEntity.denyResource method iterativly for each resource in _id[]
     * @param _roleName the name of the role
     * @param _id the all the ids of the denied resources
     * @return returns <b>true</b> on successful completion of the method,
     * <b>false</b> otherwise
     */
    public static boolean denyResourceToRole(String _roleName, int _id[]) {
        RolesEntity _role = new RolesEntity(_roleName);
        ResourcesEntity _resource;
        try {
            for (int i = 0; i < _id.length; i++) {
                _resource = new ResourcesEntity(_id[i]);
                _role.denyResource(_resource);
            }
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    /**
     * prepares UsersEntity list as instances of Option type by using the
     * user_name from the resultset (UsersEntity.selectAllUsers())
     * as key and value pair
     * @return returns the prepared array of Options
     */
    public ArrayList<SelectItem> getAvailableUsers() {
        ArrayList<SelectItem> _usersList = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = users.selectAllUsers();
            while (_rs.next()) {
                _usersList.add(new SelectItem(_rs.getString("user_id"),
                        _rs.getString("user_name")));

            }
            return _usersList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public ArrayList<HashMap> getAvailableUsersList() {
        ArrayList<HashMap> _usersList = new ArrayList<HashMap>();
        try {
            ResultSet _rs = users.selectAllUsersList();
            while (_rs.next()) {
                HashMap hm = new HashMap();
                hm.put("fullname", _rs.getString("fullname"));
                hm.put("USER_ID", _rs.getString("USER_ID"));
                hm.put("user_name", _rs.getString("user_name"));
                hm.put("emp_id", _rs.getString("emp_id"));

                _usersList.add(hm);
            }
            return _usersList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public int getResourceId(String path) {
        try {
            return resources.getId(path);
        } catch (Exception ex) {
            return 0;
        }
    }

    /**
     * prepares RolesEntity list as instances of SelectItem type by using the
     * name from the resultset (RolesEntity.selectAllRoles())
     * as key and value pair
     * @return returns the prepared array of SelectItem
     */
    public ArrayList<SelectItem> getAvailableRoles() {
        ArrayList<SelectItem> _list = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = roles.selectAllRoles();
            _list.add(new SelectItem(null, "--Select Role--"));
            while (_rs.next()) {
                _list.add(new SelectItem(_rs.getString("role_name"), _rs.getString("role_name")));
            }
            return _list;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    /**
     * prepares RolesEntity list as instances of SelectItem type by using the
     * name from the resultset (RolesEntity.selectAllRoles())
     * as key and value pair
     * @return returns the prepared array of SelectItem
     */
    public ArrayList<SelectItem> getAvailableRolesWithId() {
        ArrayList<SelectItem> _list = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = roles.selectAllRoles();
            _list.add(new SelectItem(null, "--Select Role--"));
            while (_rs.next()) {
                _list.add(new SelectItem(_rs.getString("role_name"), _rs.getString("role_description")));
            }
            return _list;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    /**
     * prepares RolesEntity list as instances of HashMap type by using the
     * name from the resultset (RolesEntity.selectAllRoles())
     * as key and value pair
     * @return returns the prepared array of HashMap
     */
    public ArrayList<HashMap> getAvailableRoles1() {
        ArrayList<HashMap> _list = new ArrayList<HashMap>();
        try {
            ResultSet _rs = roles.selectAllRoles();

            while (_rs.next()) {
                HashMap list = new HashMap();
                list.put("name", _rs.getString("role_name"));
                list.put("description", _rs.getString("role_description"));
                _list.add(list);
            }
            return _list;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    /**
     * prepares ResourcesEntity list as instances of SelectItem type by using the
     * id & name from the resultset (ResourcesEntity.selectAllResources())
     * as key (id) and value (name) pair
     * @return returns the prepared array of SelectItem
     */
    public Option[] getAvailableResources() {
        try {
            ResultSet _rs = resources.selectAllResources();
            _rs.last();
            int len = _rs.getRow();
            Option _list[] = new Option[len];
            //ArrayList _list = new ArrayList();
            _rs.beforeFirst();

            int i = 0;//_rs.next() && !_rs.isAfterLast()
            while (_rs.next()) {

                _list[i] = new Option(String.valueOf(_rs.getInt("id")),
                        _rs.getString("name"));

                i++;
            }
            return _list;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    /**
     * prepares ResourcesEntity list as instances of SelectItem type by using the
     * id & name from the resultset (ResourcesEntity.selectAllResources())
     * as key (id) and value (name) pair
     * @return returns the prepared array of SelectItem
     */
    public ArrayList<HashMap> getAvailableResources1() {
        ArrayList<HashMap> _list = new ArrayList<HashMap>();
        try {
            ResultSet _rs = resources.selectAllResources();
            while (_rs.next()) {
                HashMap list = new HashMap();
                list.put("id", _rs.getString("resource_id"));
                list.put("name", _rs.getString("resource_name"));
                _list.add(list);

            }
            return _list;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    /**
     * prepares ResourcesEntity list as instances of Option type by using the
     * id & name from the resultset (RolesEntity.getAllowedResources())
     * as key (id) and value (name) pair for specific Role identified by _role
     * @param _role the role for which available resources required
     * @return returns the prepared array of Options
     */
    public static String[] getAssignedResources(String _roleId) {
        try {
            RolesEntity _role = new RolesEntity(_roleId);
            ResultSet _rs = _role.getAllowedResources();
            _rs.last();
            int len = _rs.getRow();
            String _list[] = new String[len];
            _rs.beforeFirst();
            int i = 0;
            while (_rs.next()) {
                _list[i] = new String(String.valueOf(_rs.getInt("resource_id")));
                i++;
            }
            return _list;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public static ArrayList<HashMap> getAssignedResources1(String _roleId) {
        ArrayList<HashMap> _list = new ArrayList<HashMap>();
        try {
            RolesEntity _role = new RolesEntity(_roleId);
            ResultSet _rs = _role.getAllowedResources();
            while (_rs.next()) {
                HashMap list = new HashMap();
                list.put("id", _rs.getString("resource_id"));
                list.put("name", _rs.getString("resource_name"));
                _list.add(list);

            }
            return _list;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    /**
     * prepares ResourcesEntity list as instances of Option type by using the
     * id & name from the resultset (RolesEntity.getAllowedResources())
     * as key (id) and value (name) pair for specific Role identified by _role
     * @param _role the role for which available resources required
     * @return returns the prepared array of Options
     */
    public static ArrayList<Option> getAssignedTask(String _roleId) {
        try {
            RolesEntity _role = new RolesEntity(_roleId);

            ResultSet _rs = _role.getAllowedResources();
            ArrayList<Option> _list = new ArrayList<Option>();
            while (_rs.next()) {
                _list.add(new Option(_rs.getInt("resource_id"), _rs.getString("resource_name")));
            }
            return _list;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public static ArrayList<SelectItem> getAssignedTask1(String _roleId) {
        ArrayList<SelectItem> _list = new ArrayList<SelectItem>();
        RolesEntity _role = new RolesEntity(_roleId);
        try {
            ResultSet _rs = _role.getAllowedResources();
            _list.add(new SelectItem(null,
                    "--Select Available Role--"));
            while (_rs.next()) {
                _list.add(new SelectItem(_rs.getInt("resource_id"),
                        _rs.getString("resource_name")));

            }
            return _list;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    /**
     * prepares RolesEntity list as instances of Option type by using the
     * role_id from the resultset (UsersEntity.getRoles())
     * as key and value pair for specific user identified by _userId
     * @param _userId the user for which assigned roles required
     * @return returns the prepared array of String
     */
    public static String[] getAssignedRoles(String _userId) {
        try {
            int len = 0;
            String _list[] = null;
            int i = 0;
            UsersEntity _user = new UsersEntity(_userId);
            int userId = 0;
            ResultSet _rs2 = _user.DBUserID();
            if (_rs2.next()) {
                userId = _rs2.getInt("USER_ID");
                ResultSet _rs = _user.getRoles(userId);
                while (_rs.next()) {
                    len = _rs.getRow();
                    _list = new String[len];
                    _list[i] = new String(_rs.getString("role_id"));
                    i++;
                }
            }
            return _list;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    /**
     * prepares RolesEntity list as instances of HashMap type by using the
     * role_id from the resultset (UsersEntity.getRoles())
     * as key and value pair for specific user identified by _userId
     * @param _userId the user for which assigned roles required
     * @return returns the prepared array of HashMap
     */
    public static ArrayList<HashMap> getAssignedRoles1(int _userId) {
        ArrayList<HashMap> _list = new ArrayList<HashMap>();
        try {
            UsersEntity _user = new UsersEntity(_userId);
            ResultSet _rs = _user.getRoles(_userId);
            while (_rs.next()) {
                HashMap list = new HashMap();
                list.put("role_id", _rs.getString("role_id"));
                _list.add(list);

            }
            return _list;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    /**
     * prepares RolesEntity list as instances of Option type by using the
     * role_id from the resultset (UsersEntity.getRoles())
     * as key and value pair for specific user identified by _userId
     * @param _userId the user for which assigned roles required
     * @param _con database Connection Object to fetch the data
     * @return returns the prepared array of String
     */
    public static String[] getAssignedRoles(String _userId, Connection _con) {

        UsersEntity _user = new UsersEntity(_userId);

        try {
            int userId = 0;
            ResultSet _rs2 = _user.DBUserID();
            OracleCachedRowSet ocrs1 = new OracleCachedRowSet();
            ocrs1.populate(_rs2);
            _rs2.close();
            ocrs1.next();
            userId = ocrs1.getInt("user_id");
            ResultSet _rs = _user.getRoles(userId);
            String _list[] = null;
            int len = 0;
            int i = 0;
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            len = ocrs.size();
            _list = new String[len];
            while (ocrs.next()) {
                _list[i] = new String(ocrs.getString("role_id"));
                i++;
            }
            return _list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }
    //add permissions to the assigned role-resource

    /**
     * Calls RolesEntity.grantPermission method for role-resource _roleName and
     * _assignedTask with _permisssion[]
     * after removing all perissions
     * @param _roleName
     * @param _assignedTask
     * @param _permissions
     * @return <b>true</b> on successful completion of the method,
     * <b>false</b> otherwise
     */
    public static boolean grantPermissionToRoleResource(String _roleName,
            String _assignedTask, String _permissions[]) {
        try {
            RolesEntity _role = new RolesEntity(_roleName);
            _role.setResourceId(Integer.parseInt(_assignedTask));
            //remove all permissions
            _role.denyPermissionToResource("00");
            String assignedPermission = "";
            for (int i = 0; i < _permissions.length; i++) {
                if (i == 0) {
                    assignedPermission = assignedPermission + _permissions[i];
                } else {
                    assignedPermission = assignedPermission + "," + _permissions[i];
                }
            }
            _role.grantPermissionToResource(assignedPermission);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    /**
     * prepares Permissions list as instances of Option type by using the
     * role_name  from the resultset (RolesEntity.getPermission())
     * as key and value pair for specific user identified by role_name
     * @param _roleName the user for which assigned roles required
     * @return returns the prepared array of String
     */
    public static String[] getAssignedPermissions(String _roleName, String _resourceId) {
        try {
            RolesEntity _role = new RolesEntity(_roleName);
            _role.setResourceId(Integer.parseInt(_resourceId));
            String assignedPermission = null;
            ResultSet _rs = _role.getAssignedPermissions();
            if (_rs.next()) {
                assignedPermission = _rs.getString("permision");
            }
            if (assignedPermission != null) {
                String _list[] = assignedPermission.split(",");
                return _list;
            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<HashMap> getAssignedPermissions1(String _roleName,
            String _resourceId) {
        ArrayList<HashMap> _list = new ArrayList<HashMap>();
        try {
            RolesEntity _role = new RolesEntity(_roleName);
            _role.setResourceId(Integer.parseInt(_resourceId));
            String assignedPermission = null;
            ResultSet _rs = _role.getAssignedPermissions();

            if (_rs.next()) {
                assignedPermission = _rs.getString("permision");
                String[] _list2 = assignedPermission.split(",");

                for (int i = 0; i < _list2.length; i++) {
                    ResultSet _rs1 = permission.selectPermissions(Integer.valueOf(_list2[i]));
                    while (_rs1.next()) {
                        HashMap list = new HashMap();
                        list.put("code", _rs1.getString("code"));
                        list.put("permission_name", _rs1.getString("permission_name"));
                        _list.add(list);
                    }
                }
            }
            return _list;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }


    //===========================================================================
    //if the request is active the following code will be excuted
    //the code is unreachable if request is inactive
    //==============================================================================
    /**
     * Fetches all permissions which are in the set
     * <br><b>     { approve, forward, reject, resubmit }</b><br>
     * granted to arole associated with process state <b>processState</b><br>
     * This method is intended to refine  decisions
     * out of permissions granted to a user on a requset.
     * @return returns <b>ArrayList<Option></b> object a maximum of size four
     * @param processState the current status of a process
     * @param resourcePath the URI of the resource on which the decision is to be made
     * @param userName the  user name of the employee who logged in to the system.
     */
    //added by mekete
    public ArrayList<SelectItem> getAvailableDecisionsToMake(String resourcePath, String userName, String processState) {

        ArrayList<SelectItem> _list = new ArrayList<SelectItem>();
        try {
            RolesEntity _role = new RolesEntity();
            String assignedPermission = null;
            ResultSet _rs = _role.getAssignedPermissions(resourcePath, userName, processState);
            if (_rs.next()) {
                assignedPermission = _rs.getString("permision");
                String[] _currentDecision = assignedPermission.split(",");
                for (int i = 0; i < _currentDecision.length; i++) {
                    //fiter permissions which belong to making decision
                    if (_currentDecision[i].equals(Permission_Reject)) {
                        _list.add(new SelectItem(Permission_Reject, " REJECT"));
                    } else if (_currentDecision[i].equals(Permission_Approve)) {
                        _list.add(new SelectItem(Permission_Approve, " APPROVE"));
                    } else if (_currentDecision[i].equals(Permission_Forward)) {
                        _list.add(new SelectItem(Permission_Forward, " FORWARD"));
                    } else if (_currentDecision[i].equals(Permission_Resubmit)) {
                        _list.add(new SelectItem(Permission_Resubmit, " RESUBMIT"));
                    }
                }
                if (_list.size() > 0) {
                    //if there are decisions set the first choice to
                    _list.add(0, new SelectItem("-1", " SELECT DECISION "));
                } else {
                    //if is no any decisions set
                    _list.add(new SelectItem("-1", " NO DECISION AVAILABLE "));
                }
            } else {
                // if no result set
                _list.add(new SelectItem("-1", " NO DECISION AVAILABLE "));
            }
            return _list;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    /**
     * Fetches all permissions which are in the set
     * <br><b>     { approve, forward, reject, resubmit }</b><br>
     * granted to arole associated with process state <b>processState</b><br>
     * This method is intended to refine  decisions
     * out of permissions granted to a user on a requset.
     * @return returns <b>ArrayList<Option></b> object a maximum of size four
     * @param processState the current status of a process
     * @param resourcePath the URI of the resource on which the decision is to be made
     * @param userName the  user name of the employee who logged in to the system.
     */
    //added by mekete
    public ArrayList<Option> getAvailableDecisions(String resourcePath, String userName, String processState) {

        //===========================================================================
        //if the request is inactive the following code will be excuted
        //==============================================================================
        ArrayList<Option> decisionLists = new ArrayList<Option>();
        if (processState.startsWith("App")) {
            decisionLists.add(new Option("-1", "ALREADY APPROVED"));
            return decisionLists;
        } else if (processState.startsWith("Rej")) {
            decisionLists.add(new Option("-1", "REJECTED"));
            return decisionLists;
        } else if (processState.startsWith("Res")) {
            decisionLists.add(new Option("-1", "RESUBMIT"));
            return decisionLists;
        }

        //===========================================================================
        //if the request is active the following code will be excuted
        //the code is unreachable if request is inactive
        //==============================================================================
        ArrayList<Option> _list = new ArrayList<Option>();
        try {
            RolesEntity _role = new RolesEntity();
            String assignedPermission = null;
            ResultSet _rs = _role.getAssignedPermissions(resourcePath, userName, processState);
            if (_rs.next()) {
                assignedPermission = _rs.getString("permision");
                String[] _currentDecision = assignedPermission.split(",");
                for (int i = 0; i < _currentDecision.length; i++) {
                    //fiter permissions which belong to making decision
                    if (_currentDecision[i].equals(Permission_Reject)) {
                        _list.add(new Option(Permission_Reject, " REJECT"));
                    } else if (_currentDecision[i].equals(Permission_Approve)) {
                        _list.add(new Option(Permission_Approve, " APPROVE"));
                    } else if (_currentDecision[i].equals(Permission_Forward)) {
                        _list.add(new Option(Permission_Forward, " FORWARD"));
                    } else if (_currentDecision[i].equals(Permission_Resubmit)) {
                        _list.add(new Option(Permission_Resubmit, " RESUBMIT"));
                    }
                }
                if (_list.size() > 0) {
                    //if there are decisions set the first choice to
                    _list.add(0, new Option("-1", " SELECT DECISION "));
                } else {
                    //if is no any decisions set
                    _list.add(new Option("-1", " NO DECISION AVAILABLE "));
                }
            } else {
                // if no result set
                _list.add(new Option("-1", " NO DECISION AVAILABLE "));
            }
            return _list;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<Option> getAvailableDecisions(String resourcePath, String userName) {

        ArrayList<Option> _list = new ArrayList<Option>();
        try {
            RolesEntity _role = new RolesEntity();
            String assignedPermission = null;
            ResultSet _rs = _role.getAssignedPermissions(resourcePath, userName);
            if (_rs.next()) {
                assignedPermission = _rs.getString("permision");
                String[] _currentDecision = assignedPermission.split(",");
                for (int i = 0; i < _currentDecision.length; i++) {
                    //fiter permissions which belong to making decision
                    if (_currentDecision[i].equals(Permission_Reject)) {
                        _list.add(new Option("REJECT", " REJECT"));
                    } else if (_currentDecision[i].equals(Permission_Approve)) {
                        _list.add(new Option("APPROVE", "APPROVE"));
                    } else if (_currentDecision[i].equals(Permission_Forward)) {
                        _list.add(new Option("FORWARD", "FORWARD"));
                    } else if (_currentDecision[i].equals(Permission_Resubmit)) {
                        _list.add(new Option("RESUBMIT", " RESUBMIT"));
                    } else if (_currentDecision[i].equals(Permission_Certify)) {
                        _list.add(new Option("CERTIFY", "CERTIFY"));
                    }


                }
                if (_list.size() > 0) {
                    //if there are decisions set the first choice to
                    _list.add(0, new Option("-1", " SELECT DECISION "));
                } else {
                    //if is no any decisions set
                    _list.add(new Option("-1", " NO DECISION AVAILABLE "));
                }
            } else {
                // if no result set
                _list.add(new Option("-1", " NO DECISION AVAILABLE "));
            }
            return _list;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    /**
     * prepares RolesEntity list as instances of Option type by using the
     * name from the resultset (RolesEntity.selectAllRoles())
     * as key and value pair
     * @return returns the prepared array of Options
     */
    public Option[] getAvailablePermissions() {
        try {
            ResultSet _rs = permission.selectPermissions();
            _rs.last();
            int len = _rs.getRow();
            Option _list[] = new Option[len];
            _rs.beforeFirst();

            int i = 0;
            while (_rs.next()) {
                _list[i] = new Option(_rs.getString("code"),
                        _rs.getString("permission_name"));
                i++;
            }
            return _list;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    /**
     * prepares PermissionEntity list as instances of Option type by using the
     * name from the resultset (PermissionEntity.selectPermissions)
     * as key and value pair
     * @return returns the prepared array of Options
     */
    public ArrayList<HashMap> getAvailablePermissions1() {

        ArrayList<HashMap> _list = new ArrayList<HashMap>();
        try {
            ResultSet _rs = permission.selectPermissions();
            while (_rs.next()) {
                HashMap list = new HashMap();
                list.put("code", _rs.getString("code"));
                list.put("permission_name", _rs.getString("permission_name"));
                _list.add(list);
            }
            return _list;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    /**
     * Checks wheather the user _user have a right to delete a record in this page
     * <br/> (note : permistion set is setted as
     * Prepare -> 01 Recieve -> 02 Check -> 03 View -> 04 Delete -> 10)
     * @param _page the form
     * @param _user the user
     * @return returns true if the user has the the right, false otherwise
     */
    public boolean canDelete(String _page, String _user) {
        if (getPermission(_page, _user).indexOf(Permission_Delete) != -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean canRequest(String _page, String _user) {
        if (getPermission(_page, _user).indexOf(Permission_Request) != -1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks wheather the user _user have a right to Prepare this page
     * <br/> (note : permistion set is setted as
     * Prepare -> 01 Recieve -> 02 Check -> 03 View -> 04)
     * @param _page the form
     * @param _user the user
     * @return returns true if the user has the the right, false otherwise
     */
    public boolean canPrepare(String _page, String _user) {
        if (getPermission(_page, _user).indexOf(Permission_Prepare) != -1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks wheather the user _user have a right to recieve this page
     * <br/> (note : permistion set is setted as
     * Prepare -> 01 Recieve -> 02 Check -> 03 View -> 04)
     * @param _page the form
     * @param _user the user
     * @return returns true if the user has the the right, false otherwise
     */
    public boolean canRecieve(String _page, String _user) {
        if (getPermission(_page, _user).indexOf(Permission_Recieve) != -1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks wheather the user _user have a right to Check this page
     * <br/> (note : permistion set is setted as
     * Prepare -> 01 Recieve -> 02 Check -> 03 View -> 04)
     * @param _page the form
     * @param _user the user
     * @return returns true if the user has the the right, false otherwise
     */
    public boolean canCheck(String _page, String _user) {
        if (getPermission(_page, _user).indexOf(Permission_Check) != -1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks wheather the user _user have a right to View this page
     * <br/> (note : permistion set is setted as
     * Prepare -> 01 Recieve -> 02 Check -> 03 View -> 04)
     * @param _page the form
     * @param _user the user
     * @return returns true if the user has the the right, false otherwise
     */
    public boolean canView(String _page, String _user) {
        if (getPermission(_page, _user).indexOf(Permission_View) != -1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks wheather the user _user have a right to Check this page
     * <br/> (note : permistion set is setted as
     * Prepare -> 01 Recieve -> 02 Check -> 03 View -> 04)
     * @param _page the form
     * @param _user the user
     * @return returns true if the user has the the right, false otherwise
     */
    public boolean canCertify(String _page, String _user) {
        if (getPermission(_page, _user).indexOf(Permission_Certify) != -1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks wheather the user _user have a right to Check this page
     * <br/> (note : permistion set is setted as
     * Prepare -> 01 Recieve -> 02 Check -> 03 View -> 04)
     * @param _page the form
     * @param _user the user
     * @return returns true if the user has the the right, false otherwise
     */
    public boolean canApprove(String _page, String _user) {
        if (getPermission(_page, _user).indexOf(Permission_Approve) != -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isImmediateBoss(String _page, String _user) {
        if (getPermission(_page, _user).indexOf(Immediate_Boss) != -1) {
            return true;
        } else {
            return false;
        }
    }

    /**<h1> Not Finished </h1>
     * builds a string value from the permission setted for user _user
     * on page _page from database
     * @param _page the form to be displayed
     * @param _user the user to be authorized
     * @return returns the string builded on successful completion of the method
     */
    public String getPermission(String _page, String _user) {

        //get the assigned role
        String _assigned[] = getAssignedRoles(_user);
        try {
            String assignedPermission = "";
            for (int i = 0; i < _assigned.length; i++) {
                RolesEntity _role = new RolesEntity(_assigned[i]);
                Integer resourceId = resources.getId(_page);
                if (_role.hasResource(new ResourcesEntity(resourceId))) {
                    _role.setResourceId(resourceId);
                    //get the permission for each role
                    ResultSet _rs = _role.getAssignedPermissions();
                    if (_rs.next()) {
                        if (assignedPermission == null) {
                            assignedPermission = _rs.getString("permision");
                        } else {
                            assignedPermission = assignedPermission +
                                    _rs.getString("permision");
                        }
                    }
                }
            }
            return assignedPermission;
//            return "01,02,03,04";
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return Permission_Zero;
        }
    }

    public Set<HashMap> readUserPermition(String userId, String resourceId) {
        Set<HashMap> permitionList = new HashSet<HashMap>();
        RolesEntity _role = new RolesEntity();
        String listOfPer = _role.readUserPermition(userId, resourceId);
        if (listOfPer != null && !listOfPer.equals("")) {
            listOfPer = listOfPer.substring(0, listOfPer.length() - 1);
            String list[] = listOfPer.split(",");
            for (String s : list) {
                HashMap hm = new HashMap();
                hm.put("per", s);
                permitionList.add(hm);
            }
        }
        return permitionList;
    }

    /**
     * this method gets the secrete question and answer of a User if the userName
     * provide existes in the table.
     * @param userName the user name used to identify the row containing the secrete
     * question
     * @return a hash map containing the secret question and an indicator
     * wheather the user name existes or not.<strong>Note: </strong>the secret
     * question will be set to null if the user name does not exist.
     */
    public static Map<String, String> getUserSecurityQuestion(String userName) {
        UsersEntity _user = new UsersEntity(userName);
        Map<String, String> userSecQuestion = new HashMap<String, String>();
        String _userName = null;
        String _securityQuestion = null;
        String _userFound = "false";
        try {
            ResultSet rs = _user.getSecurityQuestionCode();
            if (rs.next()) {
                _userName = rs.getString("user_name");
                _userFound = "true";
                int _securityQuestionId = rs.getInt("security_question_id");
                //gets the security question from the lookup table
                ResultSet _rsSecQ = _user.getSecurityQuestion(_securityQuestionId);
                if (_rsSecQ.next()) {
                    _securityQuestion = _rsSecQ.getString("security_question");
                }
            }
        } catch (SQLException ex) {
            _userName = null;
            _securityQuestion = null;
            _userFound = "false";
            Logger.getLogger(SiteSecurityManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            userSecQuestion.put("userName", _userName);
            userSecQuestion.put("securityQuestion", _securityQuestion);
            userSecQuestion.put("userFound", _userFound);
        }
        return userSecQuestion;
    //ResultSet
    }

    /**
     * Checkes if the answer provided by the user is correct
     * @param _userName the user name of the user
     * @param _answerToQuestion answer provided by the user
     * @return <b>true </b> if the user provides the correct answer to the
     * security question, otherwise <b>false</b>
     */
    public static boolean isUserAnswerCorrect(String _userName, String _answerToQuestion) {
        UsersEntity _user = new UsersEntity();
        try {
            return _user.isUserAnswerCorrect(_userName, _answerToQuestion);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    /**
     * feteches the available security quetions from the database table by
     * calling the UsersEntity.getSecurityQuestionList method
     * @return an array instance of <code>com.sun.webui.jsf.model.Option</code>
     * objects having the list of security questions.
     */
    public ArrayList<SelectItem> getSecurityQuestionList() {
        try {
            ResultSet _rs = users.getSecurityQuestionList();
            ArrayList<SelectItem> questionlist = new ArrayList<SelectItem>();
            if (_rs.next()) {
                do {
                    questionlist.add(new Option(String.valueOf(_rs.getInt("id")),
                            String.valueOf(_rs.getString("Security_question"))));
                } while (_rs.next());
                questionlist.add(0, new Option(null, "-- Select Your Security Question --"));
            } else {
                questionlist.add(0, new Option(null, "No Security question was found"));
            }
            return questionlist;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }


    }
    /**
     * No permistion  is setted No PermissionEntity -> 0
     */
    public final static String Permission_Zero = "0";
    /**
     * permistion set is setted as Prepare -> 1
     */
    public final static String Permission_Prepare = "1";
    /**
     * permistion set is setted as Recieve -> 2
     */
    public final static String Permission_Recieve = "2";
    /**
     * permistion set is setted as Check -> 3
     */
    public final static String Permission_Check = "3";
    /**
     * permistion set is setted as  View -> 4
     */
    public final static String Permission_View = "4";
    /**
     * permistion set is setted as Certify -> 5
     */
    public final static String Permission_Certify = "5";
    /**
     * permistion set is setted as Approve -> 6
     */
    public final static String Permission_Approve = "6";
    /**
     * permistion set is setted as Delete -> 6
     */
    public final static String Permission_Delete = "7";
    /**
     * permistion set is setted as Immediate_ Boss for request leave approval -> 8
     */
    public final static String Immediate_Boss = "8";
    /**
     * permistion set is setted for request  -> 9
     */
    public final static String Permission_Request = "9";
    /**
     * permistion set is setted for Resubmit  -> 10
     */
    public final static String Permission_Resubmit = "10";
    /**
     * permistion set is setted for reject  -> 11
     */
    public final static String Permission_Reject = "11";
    /**
     * permistion set is setted for forward  -> 12
     */
    public final static String Permission_Forward = "12";
    /**
     * permistion set is setted for forward  -> 13
     */
    public final static String Permission_Payment_Requester = "13";
    /**
     * permistion set is setted for forward  -> 14
     */
    public final static String Permission_Payment_Approve = "14";
    /**
     * permistion set is setted for forwardToCommittee  -> 12
     */
    public final static String Permission_ForwardToCommittee = "13";
}
