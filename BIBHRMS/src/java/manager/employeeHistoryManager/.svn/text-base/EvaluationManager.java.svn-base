/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.employeeHistoryManager;

import entity.employeeHistoryEntity.EvaluationCriteria;
import java.util.HashMap;
import com.sun.webui.jsf.model.Option;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class EvaluationManager {

    private String evaCriteriaCategory;
    private String evaCriteria;
    private String evaCriteriaDesc;
    private boolean selected;
    private int evaParaCode;
    private int purpId;
    private String purpName;



    EvaluationCriteria evaCriteriaEntity = new EvaluationCriteria();

     public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        /**
     * @return the purpId
     */
    public int getPurpId() {
        return purpId;
    }

    /**
     * @param purpId the purpId to set
     */
    public void setPurpId(int purpId) {
        this.purpId = purpId;
    }

    /**
     * @return the purpName
     */
    public String getPurpName() {
        return purpName;
    }

    /**
     * @param purpName the purpName to set
     */
    public void setPurpName(String purpName) {
        this.purpName = purpName;
    }

    /**
     *
     * @return
     */

    public EvaluationManager(){

    }

    /**
     * @return the evaCriteriaCode
     */
    public String getEvaCriteriaCategory() {
        return evaCriteriaCategory;
    }

    /**
     * @param evaCriteriaCode the evaCriteriaCode to set
     */
    public void setEvaCriteriaCategory(String evaCriteriaCategory) {
        this.evaCriteriaCategory = evaCriteriaCategory;
    }

    /**
     * @return the evaCriteria
     */
    public String getEvaCriteria() {
        return evaCriteria;
    }

    /**
     * @param evaCriteria the evaCriteria to set
     */
    public void setEvaCriteria(String evaCriteria) {
        this.evaCriteria = evaCriteria;
    }

    /**
     * @return the evaCriteriaDesc
     */
    public String getEvaCriteriaDesc() {
        return evaCriteriaDesc;
    }

    /**
     * @param evaCriteriaDesc the evaCriteriaDesc to set
     */
    public void setEvaCriteriaDesc(String evaCriteriaDesc) {
        this.evaCriteriaDesc = evaCriteriaDesc;
    }
     public EvaluationManager(String purpName){

        this.purpName = purpName;



    }
    public EvaluationManager(int purpId, String purpName){
        this.purpId = purpId;
        this.purpName = purpName;



    }

    public EvaluationManager(String evaCriteriaCategory , String evaCriteria, String evaCriteriaDesc){
        this.evaCriteriaCategory = evaCriteriaCategory;
        this.evaCriteria = evaCriteria;
        this.evaCriteriaDesc = evaCriteriaDesc;


    }
    public EvaluationManager(int evaParaCode , String evaCriteriaCategory , String evaCriteria, String evaCriteriaDesc){
        this.evaCriteriaCategory = evaCriteriaCategory;
        this.evaCriteria = evaCriteria;
        this.evaCriteriaDesc = evaCriteriaDesc;
        this.evaParaCode = evaParaCode;

    }
    public int addEvaCriteria(String evaCriteriaDescription, String evaCriteriaName, String evaCriteriaCategory){
        return evaCriteriaEntity.addEvaCrt(evaCriteriaDescription, evaCriteriaName,evaCriteriaCategory );
    }
     public int addEvaCriteriaPurpose(String purpName){
        return evaCriteriaEntity.addEvaCrtPurpose(purpName);
    }
    /**
     * this method fetchs every row in the table
     * @return
     */
    public HashMap[] readEvaCriteriaEdit(){
        return evaCriteriaEntity.readEvaCriteriaEdit();
    }
    public HashMap[] readEvaCriteriaPurpose(){
        return evaCriteriaEntity.readEvaCriteriaEditPurpose();
    }
    /**
     used to count the number of rows that are exist in the requierd table
     */
    public int countEvaCriteriaUsing() {
        return evaCriteriaEntity.countEvaCriteriaUsing();
    }
    public int countEvaCriteriaPurpose() {
        return evaCriteriaEntity.countEvaCriteriaPurpose();
    }
    public int updateEvaCriteria(int evaParaCode, String evaCrtCategory, String evaCrtName, String evaCrtDesc) {
        return evaCriteriaEntity.updateEvaCrt(evaParaCode, evaCrtCategory, evaCrtName, evaCrtDesc);
    }
    public int updateEvaCriteriaPurp(int purpId, String purpName) {
        return evaCriteriaEntity.updateEvaCrtPurp(purpId, purpName);
    }

    public int deleteEvaCriteria(int evaCrtParaCode) {
        return evaCriteriaEntity.deleteEvaCrt(evaCrtParaCode);
    }
    public int deleteEvaCriteriaPurp(int purpId) {
        return evaCriteriaEntity.deleteEvaCrtPurp(purpId);
    }

    /**
     * @return the evaParaCode
     */
    public int getEvaParaCode() {
        return evaParaCode;
    }

    /**
     * @param evaParaCode the evaParaCode to set
     */
    public void setEvaParaCode(int evaParaCode) {
        this.evaParaCode = evaParaCode;
    }

     public Option[] readEvaCCategory() {
        Option[] purposeOpt = null;
        ArrayList<EvaluationCriteria> purposeTypes = evaCriteriaEntity.readAllPurpose();
        purposeOpt = new Option[purposeTypes.size() + 1];
        Option purposeOptFirst = new Option("0", "-----All Purpose----");
        purposeOpt[0] = purposeOptFirst;
        for (int i = 0; i < purposeTypes.size(); i++) {
            evaCriteriaEntity = purposeTypes.get(i);
            Option optRegionType = new Option(evaCriteriaEntity.getPurpID() , evaCriteriaEntity.getPurpName());
            purposeOpt[i + 1] = optRegionType;
        }

        return purposeOpt;
    }
    public String readSinglePurpose(int purpID){
        String strPurpose = evaCriteriaEntity.readSinglePurpose(purpID);
        return strPurpose;
    }

     public HashMap[] readEvaCriteriaEditFilter(int purp){
        return evaCriteriaEntity.readEvaCriteriaEditFilter(purp);
    }


}
