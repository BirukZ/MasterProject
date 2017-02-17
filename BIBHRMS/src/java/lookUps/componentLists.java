/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lookUps;

/**
 *
 * @author DavePro
 */
import java.util.ArrayList;

import javax.faces.model.SelectItem;

public class componentLists extends ArrayList {

    
       public componentLists() {
              super();
              for(int i=1; i<2; i++ ){
              add(new SelectItem("Male" ));
              add(new SelectItem("Female" ));
              }
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
