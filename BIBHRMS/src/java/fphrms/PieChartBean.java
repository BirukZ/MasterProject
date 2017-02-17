/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fphrms;

import com.icesoft.faces.component.outputchart.OutputChart;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.el.ValueBinding;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author Dereje
 */
public class PieChartBean extends PieChart {
//flag to determine if the graph needs rendering

    private boolean pieNeedsRendering = false;

    //the temporary value for the selected color
    private Color selectedColor;

  private EmployeeChartData employeeChartData=new EmployeeChartData();

    //array of the available paints used in the chart
    public static final SelectItem[] availablePaints = new SelectItem[]{
        new SelectItem("E6EDF2", "Blue 1"),
        new SelectItem("FF0000", "Blue 2"),
        new SelectItem("FF0000", "Blue 3"),
        new SelectItem("BB9B43", "Blue 4"),
        new SelectItem("B7DB4A", "Blue 5"),
        new SelectItem("99CCFF", "Blue 6"),
        new SelectItem("4FAADC", "Blue 7"),
        new SelectItem("4397C5", "Blue 8"),
        new SelectItem("1A568A", "Blue 9"),
        new SelectItem("0D4274", "Blue 10"),
        new SelectItem("CCCCCC", "Grey 1"),
        new SelectItem("ACACAC", "Grey 2"),
        new SelectItem("F78208", "Orange"),
        new SelectItem("000000", "Black")};

    //a temporary string for the current label
    private String label;
    private float value;

    //index to delete from
    int deleteIndex = 0;

    //list of items to delete
    private List deleteList = new ArrayList();

    public PieChartBean() {
        super();
        // Generate data for chart from EmployeeChartData class.
        Iterator it = employeeChartData.getMasterEmployees().values().iterator();
        float count;
        String label;
        int r = 3;
        while (it.hasNext()) {
            EmployeeChartData tempEmployees = (EmployeeChartData)it.next();
            count = 0;
            label = "";
            if (tempEmployees !=null) {
                count = (tempEmployees).getCountEmployees();
                label = (tempEmployees).getLabelStatus();

            }
            labels.add(label);
            data.add(new Double(count));
            //adds paint from availablePaints list
            paints.add(new Color(Integer.parseInt((String) availablePaints[r].getValue(), 16)));
            r++;
        }
    }

    /**
     * Method to call the rendering of the chart based on the pieNeedsRendering
     * flag
     *
     * @param component chart component which will be rendered.
     * @return boolean true if OutputChart should be re-rendered; otherwise,
     *         false.
     */
    public boolean newChart(OutputChart component) {
        if (pieNeedsRendering) {
            pieNeedsRendering = false;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method to listen for the change in color in the graph
     *
     * @param event JSF value changed event
     */
    public void paintChangeListener(ValueChangeEvent event) {

        if (event.getNewValue() != null) {
            selectedColor =
                    new Color(
                    Integer.parseInt(
                    event.getNewValue().toString(), 16));
//                    Integer.parseInt(
//                    event.getNewValue().toString(), 16));
        }
    }

    public SelectItem[] getAvailablePaints() {
        return availablePaints;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        if (null == label || label.length() < 1) {
            label = " ";
        }
        this.label = label;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }




    /**
     * Method to add a value and a color to the chart
     *
     * @param event JSF action event.
     */
    public void addToChart(ActionEvent event) {
        paints.add(selectedColor);
        labels.add(label);
        data.add(new Double(value));
        pieNeedsRendering = true;
    }

    /**
     * Method to listen for an action to delete from the chart
     *
     * @param event JSF value changed event
     */
    public void deleteListValueChangeListener(ValueChangeEvent event) {
        if (event.getNewValue() != null) {
            deleteIndex = Integer.parseInt(event.getNewValue().toString());
        }
    }

    public List getDeleteList() {
        deleteList.clear();
        deleteList.add(new SelectItem("-1", "Select..."));
        for (int i = 0; i < labels.size(); i++) {
            deleteList.add(new SelectItem("" + i, "" + labels.get(i)));
        }
        return deleteList;
    }

    public void setDeleteList(List deleteList) {
        this.deleteList = deleteList;
    }

    public boolean isDeleteAllowed() {
        return labels.size() > 2;
    }

    /**
     * Method to delete an item from the chart
     *
     * @param event JSF action event
     */
    public void deleteChart(ActionEvent event) {
        if (deleteIndex >= 0 && labels.size() > 2) {
            labels.remove(deleteIndex);
            data.remove(deleteIndex);
            paints.remove(deleteIndex);
            pieNeedsRendering = true;
        }
    }
}