/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.model.SelectItem;
import entity.Lookup.TableInformation;

/**
 *
 * @author leul
 */
public class LookUpManger {

    public LookUpManger() {
    }
    TableInformation table = new TableInformation();
    ArrayList<String> empitiedTableList = new ArrayList<String>();

    public ArrayList<String> getEmpitiedTableList() {
        return empitiedTableList;
    }

    public void setEmpitiedTableList(ArrayList<String> empitiedTableList) {
        this.empitiedTableList = empitiedTableList;
    }

    public TableInformation getTable() {
        return table;
    }

    public void setTable(TableInformation table) {
        this.table = table;
    }

    public ArrayList<String> getLookUpTables(String owner) {
        table.setOwner(owner);
        return table.getLookUpTables(owner);

    }

    public ArrayList<String> getColumns(String tableName, String owner) {
        table.setTableName(tableName);
        table.setOwner(owner);
        return table.getColumns();

    }

    public ArrayList<String[]> selectData(HashMap tableInfo) {
        table.setTableName(tableInfo.get("name").toString());
        table.setNoColumn((Integer) tableInfo.get("noColumn"));
        return table.selectData();

    }

    public boolean processLookUp(String tableName, String columnNames, String values) {
        boolean message = false;

        try {
            table.setTableName(tableName);
            table.setColumnNames(columnNames);
            table.setValues(values);
            getEmpitiedTableList().add(tableName);
            message = table.insert();
            return message;
        } catch (Exception ex) {
            ex.printStackTrace();
            return message;
        }
    }

    //leul
    public ArrayList<String> checkForegnKey(String tableName) {
        return table.checkForeignKey(tableName);

    }

    public String checkPrimaryKey(String tableName) {
        try {
            table.setTableName(tableName);
            return table.selectPkCol(tableName);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public ArrayList<SelectItem> refTableDetail(String tableName, String columnName) {
        try {
            ArrayList<SelectItem> tableColumn = new ArrayList<SelectItem>();
            ResultSet _rs = table.selectAllFromRef(tableName, columnName);
            while (_rs.next()) {
                tableColumn.add(new SelectItem(_rs.getString(1), _rs.getString(2)));
            }

            if (tableColumn != null) {
                return tableColumn;
            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean processLookUpUpdate(String tableName, String columnNames, String values) {
        boolean message = false;
        try {
            table.setTableName(tableName);
            table.setColumnNames(columnNames);
            table.setValues(values);
            message = table.update();
            return message;
        } catch (Exception ex) {
            ex.printStackTrace();
            return message;
        }
    }
}
