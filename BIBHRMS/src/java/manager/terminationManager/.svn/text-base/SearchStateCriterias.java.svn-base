/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.terminationManager;

import java.util.ArrayList;
import javax.faces.model.SelectItem;

/**
 *
 * @author DPClone
 */
public class SearchStateCriterias extends ArrayList {

    public SearchStateCriterias() {
        super();
//
//        add(new SelectItem(TerminationManager.EmployeeRequestStates.pending.toString()));
//        add(new SelectItem(TerminationManager.EmployeeRequestStates.postponed.toString()));
//        add(new SelectItem(TerminationManager.EmployeeRequestStates.approved.toString()));
//        add(new SelectItem(TerminationManager.EmployeeRequestStates.rejected.toString()));

    }

    public void setItems(String[] selectedItems) {
        clear();
        for (int i = 0; selectedItems != null && i < selectedItems.length; i++) {
            add(new SelectItem(selectedItems[i]));
        }
    }

    public String[] getItems() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size(); i++) {
            arrayList.add(((SelectItem) get(i)).getValue());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
