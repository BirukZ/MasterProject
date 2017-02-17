/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lookUps;

import java.util.ArrayList;
import javax.faces.model.SelectItem;
import manager.globalUseManager.JodanTimeCalender;
import manager.globalUseManager.StringDateManipulation;

/**
 *
 * @author Administrator
 */
public class BonesLookup {

//    public BonesLookup() {
//        super();
//        add(new SelectItem("MUGHER", "MUGHER"));
//        add(new SelectItem("ADDISABEBA", "ADDIS ABABA"));
//    }
//
//    public void setItems(String[] selectedItems) {
//        clear();
//        for (int i = 0; selectedItems != null && i < selectedItems.length; i++) {
//            add(new SelectItem(selectedItems[i]));
//        }
//    }
//
//    public String[] getItems() {
//        ArrayList arrayList = new ArrayList();
//        for (int i = 0; i < size(); i++) {
//            arrayList.add(((SelectItem) get(i)).getValue());
//        }
//        return (String[]) arrayList.toArray(new String[arrayList.size()]);
//    }
    public ArrayList<SelectItem> listOfPlace() {
        ArrayList<SelectItem> list_place = new ArrayList<SelectItem>();
        list_place.add(new SelectItem(null, "Select Here"));
        list_place.add(new SelectItem("MUGHER", "MUGHER"));
        list_place.add(new SelectItem("ADDISABEBA", "ADDIS ABABA"));
        return list_place;
    }
//    {"Holiday Bones", " "};
       public ArrayList<SelectItem> listOfBonesType() {
        ArrayList<SelectItem> list_place = new ArrayList<SelectItem>();
        list_place.add(new SelectItem("HolidayBones", "Holiday Bones"));
        list_place.add(new SelectItem("YearlyBones", "Yearly Bones"));
        return list_place;
    }

    public ArrayList<SelectItem> listOfBonesAmout() {
        ArrayList<SelectItem> list_Bones = new ArrayList<SelectItem>();
        list_Bones.add(new SelectItem(null, "Select Amount of Bones"));
        list_Bones.add(new SelectItem("1", "One Month "));
        list_Bones.add(new SelectItem("2", "Two Month"));
        list_Bones.add(new SelectItem("3", "Three Month"));
        list_Bones.add(new SelectItem("4", "Four Month"));
        list_Bones.add(new SelectItem("5", "Five Month"));
        list_Bones.add(new SelectItem("6", "Six Month "));
        return list_Bones;
    }
        public ArrayList<SelectItem> listOfBonesHolidayName() {
        ArrayList<SelectItem> holiday_Name = new ArrayList<SelectItem>();
        holiday_Name.add(new SelectItem(null, "Select Holiday Name"));
        holiday_Name.add(new SelectItem("EthiopianNewYear", "Ethiopian New Year"));
        holiday_Name.add(new SelectItem("EidAlAdhaArafa", "Eid Al-Adha(Arafa)"));
        holiday_Name.add(new SelectItem("Ganna", "Ganna"));
        holiday_Name.add(new SelectItem("EthiopianEpiphan", "Ethiopian Epiphan"));
        holiday_Name.add(new SelectItem("EthiopianEaster", "Ethiopian Easter"));
        holiday_Name.add(new SelectItem("EidAlFitrRamadon", "Eid Al-Fitr/Ramadon"));
        return holiday_Name;
    }



    public ArrayList<SelectItem> listOfBonesYear() {
        ArrayList<SelectItem> list_Year = new ArrayList<SelectItem>();
        JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
        int year = StringDateManipulation.getYear(jodanTimeCalender.currentDateFinder());
        list_Year.add(new SelectItem(null, "Select Here"));
        for (int i = 0; i < 5; i++) {
            list_Year.add(new SelectItem(year, Integer.toString(year)));
            year -= 1;
        }
        return list_Year;
    }
}
