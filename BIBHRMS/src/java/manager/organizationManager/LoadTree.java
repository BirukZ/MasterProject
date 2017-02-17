/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.organizationManager;

import com.icesoft.faces.component.tree.IceUserObject;
import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author BravoZulu
 */
public class LoadTree {

    static int parentIndex = 0;
    OrganizationManager organizationManager = new OrganizationManager();

    public DefaultMutableTreeNode populateNodes() {
        ArrayList<OrganizationManager> allDepartmentsList = organizationManager.readAllDepartmentsNew();
        ArrayList<DefaultMutableTreeNode> allNodesList = new ArrayList<DefaultMutableTreeNode>();
        int sizeOfDeptList = allDepartmentsList.size();
        //create and add to allNodesList corresponding node for each department of allDepartmentsList
        for (int i = 0; i < sizeOfDeptList; i++) {
            allNodesList.add(createNodeFromDepartment(allDepartmentsList.get(i)));
        }

        for (int i = 1; i < sizeOfDeptList; i++) {
            OrganizationManager currentDepartment = allDepartmentsList.get(i);
            OrganizationManager prevDepartment = allDepartmentsList.get(i - 1);
            DefaultMutableTreeNode currentNode = allNodesList.get(i);
            if (currentDepartment.getLevel() > prevDepartment.getLevel()) {
                parentIndex = i - 1;//parent is the previeous
            } else if (currentDepartment.getLevel() == prevDepartment.getLevel()) {
                //parentIndex=parentIndex;//not changed, keep the prevous
            } else if (currentDepartment.getLevel() < prevDepartment.getLevel()) {
                int backCounter;
                for (backCounter = i; backCounter >= 0; backCounter--) {
                    if (currentDepartment.getBranchID().equals(allDepartmentsList.get(backCounter).getDeptCode())) {
                        parentIndex = backCounter;
                        break;
                    }
                }

            }
            allNodesList.get(parentIndex).add(currentNode);
        }
        return allNodesList.get(0);//rootnode
    }

    private DefaultMutableTreeNode createNodeFromDepartment(OrganizationManager department) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode();
        IceUserObject userObject = new IceUserObject(node);
        userObject.setLeafIcon("../xmlhttp/css/rime/css-images/tree_document.gif");
        userObject.setBranchContractedIcon("../xmlhttp/css/rime/css-images/tree_folder_close.gif");
        userObject.setBranchExpandedIcon("../xmlhttp/css/rime/css-images/tree_folder_open.gif");
        userObject.setBranchContractedIcon("../xmlhttp/css/rime/css-images/tree_nav_bottom_close.gif");
        int level = department.getLevel();
        if (level > 2) {
            userObject.setExpanded(false);
        } else {
            userObject.setExpanded(true);
        }

        node.setUserObject(userObject);
        String nameOfDept = department.getDeptDescription();
        String deptCode = department.getDeptCode();

        if (nameOfDept != null) {
            userObject.setText(nameOfDept + "  # " + deptCode);
            userObject.setLeaf(false);
            userObject.setExpanded(false);
            node.setAllowsChildren(true);
        } // leaf node
        else {
            userObject.setText(deptCode);
            userObject.setLeaf(true);
            node.setAllowsChildren(false);
        }
        return node;
    }

    private DefaultMutableTreeNode addNode(DefaultMutableTreeNode parent,
            String title, String DPlan) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode();
        IceUserObject userObject = new IceUserObject(node);
        userObject.setLeafIcon("../xmlhttp/css/rime/css-images/tree_document.gif");
        userObject.setBranchContractedIcon("../xmlhttp/css/rime/css-images/tree_folder_close.gif");
        userObject.setBranchExpandedIcon("../xmlhttp/css/rime/css-images/tree_folder_open.gif");
        userObject.setBranchContractedIcon("../xmlhttp/css/rime/css-images/tree_nav_bottom_close.gif");
        userObject.setExpanded(false);

        node.setUserObject(userObject);
        //userObject.setTreeNode(employee);
        //branch
        if (title != null) {
            userObject.setText(title);
            userObject.setLeaf(false);
            userObject.setExpanded(false);
            node.setAllowsChildren(true);
        } // leaf node
        else {
            userObject.setText(DPlan);
            userObject.setLeaf(true);
            node.setAllowsChildren(false);
        }
        // finally add the node to the parent.
        if (parent != null) {
            parent.add(node);
        }

        return node;
    }
}
