/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.globalUseManager;

/**
 *
 * @author Administrator
 */
import entity.globalUseEntity.Kebelle;
import entity.globalUseEntity.LookUpEntity;
import entity.globalUseEntity.PayGrad;
import entity.globalUseEntity.Rank;
import entity.globalUseEntity.Region;
import entity.globalUseEntity.WoredaOrSubCity;
import entity.globalUseEntity.ZoneOrCity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.model.SelectItem;
import com.sun.webui.jsf.model.Option;

public class LookUpManager {
    /*
     * To change this template, choose Tools | Templates
     * and open the template in the editor.
     */

    public LookUpManager() {
    }
    ZoneOrCity zoneOrCity = new ZoneOrCity();
    WoredaOrSubCity woredaOrSubCity = new WoredaOrSubCity();
    private LookUpEntity lookupEntity = new LookUpEntity();
    PayGrad payGradEntity = new PayGrad();
    Kebelle kebelle = new Kebelle();
    Rank rankEntity = new Rank();
    Double salary;
    String databaseStatus;
    String payGradeId;

    public LookUpManager(int stepNo, Double salary) {
        this.salary = salary;
        this.stepNo = stepNo;
    }

    public LookUpManager(String databaseStatus, int stepNo, Double salary) {
        this.salary = salary;
        this.stepNo = stepNo;
        this.databaseStatus = databaseStatus;
    }

    public LookUpManager(String payGradeId, String databaseStatus, int stepNo, Double salary) {
        this.salary = salary;
        this.stepNo = stepNo;
        this.databaseStatus = databaseStatus;
        this.payGradeId = payGradeId;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public int getStepNo() {
        return stepNo;
    }

    public String getPayGradeId() {
        return payGradeId;
    }

    public void setPayGradeId(String payGradeId) {
        this.payGradeId = payGradeId;
    }

    public String getDatabaseStatus() {
        return databaseStatus;
    }

    public void setDatabaseStatus(String databaseStatus) {
        this.databaseStatus = databaseStatus;
    }

    public void setStepNo(int stepNo) {
        this.stepNo = stepNo;
    }

    public Option[] getCommonOpt() {
        return commonOpt;
    }

    public void setCommonOpt(Option[] commonOpt) {
        this.commonOpt = commonOpt;
    }

    public Kebelle getKebelle() {
        return kebelle;
    }

    public void setKebelle(Kebelle kebelle) {
        this.kebelle = kebelle;
    }

    public Option[] getListenOpt() {
        return listenOpt;
    }

    public void setListenOpt(Option[] listenOpt) {
        this.listenOpt = listenOpt;
    }

    public LookUpEntity getLookupEntity() {
        return lookupEntity;
    }

    public void setLookupEntity(LookUpEntity lookupEntity) {
        this.lookupEntity = lookupEntity;
    }

    public PayGrad getPayGradeType() {
        return payGradeType;
    }

    public void setPayGradeType(PayGrad payGradeType) {
        this.payGradeType = payGradeType;
    }

    public Rank getRank() {
        return rankEntity;
    }

    public void setRank(Rank rank) {
        this.rankEntity = rank;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public PayGrad getSavePayGrad() {
        return payGradEntity;
    }

    public void setSavePayGrad(PayGrad savePayGrad) {
        this.payGradEntity = savePayGrad;
    }

    public WoredaOrSubCity getWoredaOrSubCity() {
        return woredaOrSubCity;
    }

    public void setWoredaOrSubCity(WoredaOrSubCity woredaOrSubCity) {
        this.woredaOrSubCity = woredaOrSubCity;
    }

    public ZoneOrCity getZoneOrCity() {
        return zoneOrCity;
    }

    public void setZoneOrCity(ZoneOrCity zoneOrCity) {
        this.zoneOrCity = zoneOrCity;
    }
    int stepNo;

    public LookUpManager(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    Region region = new Region();

    public int addRegion(String regionID, String regionName, String regionDescription) {
        region.addRegion(regionID, regionName, regionDescription);
        return region.insertRegion();
    }

    public int addZoneOrCity(String regionID, LookUpManager saveZoneOrCity) {
        return zoneOrCity.insertZoneOrCity(regionID, saveZoneOrCity.getId(), saveZoneOrCity.getName(), saveZoneOrCity.getDescription());
    }

    public int addWoredaOrSubCity(String zoneOrCity, String id, String name, String description) {
        return woredaOrSubCity.addWoredaOrSubCity(zoneOrCity, id, name, description);
    }

    public int updateZoneOrCity(String regionID, LookUpManager saveZoneOrCity) {
        return zoneOrCity.insertZoneOrCity(regionID, saveZoneOrCity.getId(), saveZoneOrCity.getName(), saveZoneOrCity.getName());
    }

    public int updateRegion(String regionID, String regionName, String regionDescription) {
        return region.addForUpdateRegion(regionID, regionName, regionDescription);
    }

    public int deleteRegion(String regionID) {
        return region.deleteRegion(regionID);
    }

    public int deleteZoneOrCity(String regionID) {
        return zoneOrCity.deleteZoneOrCity(regionID);
    }

    public int countRegion(String regionId) {
        return region.countRegion(regionId);
    }

    public HashMap readRegion(String regionId) {
        return region.readRegion(regionId);
    }

    public HashMap[] readZoneOrCity(String regionId) {
        return zoneOrCity.readZoneOrCity(regionId);
    }

    public int CoutZoneOrCity(String regionId) {
        return zoneOrCity.countZoneOrCity(regionId);
    }

    public int coutWoredaOrSubCity(String regionID, String zoneOrCityID) {
        return woredaOrSubCity.countWoredaOrSubCity(regionID, zoneOrCityID);
    }

    public HashMap[] readWoredaOrSubCity(String regionID, String zoneOrCityID) {
        return woredaOrSubCity.readWoredaOrSubCity(regionID, zoneOrCityID);
    }

    public HashMap[] readWoreda(String zoneOrCity) {
        return null;
    }
    public Option[] title;
    //public Option[] nationality;
    public Option[] kebelleOpt;
    public Option[] commonOpt;
    public Option[] listenOpt;
    String id;
    String name;
    String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Option[] getKebelleOpt() {
        return kebelleOpt;
    }

    public void setKebelleOpt(Option[] kebelleOpt) {
        this.kebelleOpt = kebelleOpt;
    }

    public Option[] getTitle() {
        return title;
    }

    public void setTitle(Option[] title) {
        this.title = title;
    }

    public ArrayList<SelectItem> onDisplayNation() {
        ArrayList<SelectItem> firstList = new ArrayList<SelectItem>();
        firstList.add(0, new Option(null, "Select Nation"));
        return firstList;
    }

    public ArrayList<SelectItem> getNationalityName() {
        try {
            ResultSet _rs = lookupEntity.readNationalityName();
            ArrayList<SelectItem> questionlist = new ArrayList<SelectItem>();
            if (_rs.next()) {
                do {
                    questionlist.add(new Option(String.valueOf(_rs.getInt("nationalityID")),
                            String.valueOf(_rs.getString("nationalityDescription"))));
                } while (_rs.next());
                questionlist.add(0, new Option(null, "-- Select Nationality --"));
            } else {
                questionlist.add(0, new Option(null, "No Nationality Record Avilabel"));
            }

            return questionlist;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }


    }

    public Option[] readZoneOrCityInARegionOptions(String regionId) {
        try {
            Option[] regionOpt;
            ArrayList<LookUpEntity> zoneCityTypes = lookupEntity.readZoneOrCityInARegion(regionId);
            regionOpt = new Option[zoneCityTypes.size() + 1];
            Option regionOptFirst = new Option("0", "--Select Region--");
            regionOpt[0] = regionOptFirst;
            for (int i = 0; i < zoneCityTypes.size(); i++) {
                lookupEntity = zoneCityTypes.get(i);
                Option optRegionType = new Option(lookupEntity.getTitleCode(), lookupEntity.getTitleDescription());
                regionOpt[i + 1] = optRegionType;
            }
            return regionOpt;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<SelectItem> assignMaritalStatus() {
        try {

            ArrayList<SelectItem> maritalStatus = new ArrayList<SelectItem>();
            maritalStatus.add(0, new Option(null, "Select Marital Status"));
            maritalStatus.add(new SelectItem("MARRIED", "MARRIED"));
            maritalStatus.add(new SelectItem("SINGLE", "SINGLE"));
            maritalStatus.add(new SelectItem("DIVORCED", "DIVORCED"));
            maritalStatus.add(new SelectItem("WIDOWED", "WIDOWED"));
            return maritalStatus;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }


    }

    public ArrayList<SelectItem> assignNation() {
        try {
            ArrayList<LookUpEntity> readNation = lookupEntity.readNation();
            ArrayList<SelectItem> questionlist = new ArrayList<SelectItem>();
            int size = readNation.size();
            for (int i = 0; i < size; i++) {
                lookupEntity = readNation.get(i);
                questionlist.add(new Option(String.valueOf(lookupEntity.getTitleCode()),
                        String.valueOf(lookupEntity.getTitleDescription())));
            }
            questionlist.add(0, new Option(null, "-- Select Nation --"));

            return questionlist;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getNations() {
        try {
            ArrayList<SelectItem> nationlist = new ArrayList<SelectItem>();
            ResultSet _rs = null;
            while (_rs.next()) {
                SelectItem currentNation = new SelectItem(_rs.getString(""), _rs.getString(""));
                nationlist.add(new SelectItem(currentNation));
            }
            nationlist.add(0, new SelectItem("-1", "--Select nation--"));
            return nationlist;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public Option[] onDisplayJob() {
        Option startNationality[] = new Option[2];
        Option n = new Option("---- Select Job----");
        Option m = new Option("---- First Select Department----");
        startNationality[0] = n;
        startNationality[1] = m;

        return startNationality;
    }

    public ArrayList<SelectItem> assignTitle() {
        try {
            ArrayList<LookUpEntity> readTitle = lookupEntity.readTitle();
            ArrayList<SelectItem> questionlist = new ArrayList<SelectItem>();
            if (readTitle.size() > 0) {
                for (int i = 0; i < readTitle.size(); i++) {
                    lookupEntity = readTitle.get(i);
                    questionlist.add(new Option(String.valueOf(lookupEntity.getTitleCode()) +
                            String.valueOf(lookupEntity.getTitleCode()),
                            String.valueOf(lookupEntity.getTitleDescription())));
                }
                questionlist.add(0, new Option(null, "-- Select Title --"));
            } else {
                questionlist.add(0, new Option(null, "-- Select Title --"));
            }
            return questionlist;
        } catch (Exception ex) {
            ex.printStackTrace();

            return null;
        }


    }

    public ArrayList<SelectItem> assignTitleDesc() {
        try {
            ArrayList<HashMap> readTitle = lookupEntity.readTitleDesc();
            ArrayList<SelectItem> questionlist = new ArrayList<SelectItem>();
            if (readTitle.size() > 0) {
                for (HashMap hm : readTitle) {
                    questionlist.add(new Option(String.valueOf(hm.get("TITLE_ID")) + "--" +
                            String.valueOf(hm.get("TYPE")),
                            String.valueOf(hm.get("TITLE_DESCRIPTION"))));
                }
                questionlist.add(0, new Option(null, "-- Select Title --"));
            } else {
                questionlist.add(0, new Option(null, "-- Select Title --"));
            }
            return questionlist;
        } catch (Exception ex) {
            ex.printStackTrace();

            return null;
        }


    }

    public ArrayList<SelectItem> assignTitle(String title) {
        try {
            ArrayList<LookUpEntity> readTitle = lookupEntity.readTitle(title);
            ArrayList<SelectItem> questionlist = new ArrayList<SelectItem>();
            if (readTitle.size() > 0) {

                for (int i = 0; i < readTitle.size(); i++) {
                    lookupEntity = readTitle.get(i);
                    questionlist.add(new Option(String.valueOf(lookupEntity.getTitleCode()),
                            String.valueOf(lookupEntity.getTitleDescription())));
                }
                questionlist.add(0, new Option(null, "-- Select Title --"));
            } else {
                questionlist.add(0, new Option(null, "-- Select Title --"));
            }
            return questionlist;
        } catch (Exception ex) {
            ex.printStackTrace();

            return null;
        }


    }

    public ArrayList<SelectItem> assignNumber() {
        ArrayList<SelectItem> number = new ArrayList<SelectItem>();
        for (int i = 0; i < 30; i++) {
            number.add(new SelectItem(String.valueOf(i),
                    String.valueOf(i + 1)));
        }
        number.add(new SelectItem(null, " Select Step No"));
        return number;
    }

    public ArrayList<SelectItem> stepOfPayGrade() {
        ArrayList<SelectItem> number = new ArrayList<SelectItem>();
        for (int i = 0; i < 30; i++) {
            number.add(new SelectItem(String.valueOf(i),
                    String.valueOf(i)));
        }
        number.add(new SelectItem(null, " Select Step No"));
        return number;
    }

    public String readRankOfJob(String jobCode) {
        try {
            return lookupEntity.readRankOfJob(jobCode);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String readGenderOfTitle(String title) {
        try {
            return lookupEntity.readGenderOfTitle(title);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return "";
        }
    }

    public ArrayList<SelectItem> assignJobRank() {
        try {
            ArrayList<LookUpEntity> readJobRank = lookupEntity.readJobRank();
            ArrayList<SelectItem> questionlist = new ArrayList<SelectItem>();
            if (readJobRank.size() > 0) {
                for (int i = 0; i < readJobRank.size(); i++) {
                    lookupEntity = readJobRank.get(i);
                    questionlist.add(new Option(String.valueOf(lookupEntity.getTitleCode()),
                            String.valueOf(lookupEntity.getTitleCode())));
                }
                questionlist.add(0, new Option(null, "-- Select Rank --"));
            } else {
                questionlist.add(0, new Option(null, "No Rank Record Avilabel"));
            }


            return questionlist;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public Option[] readRegionOption() {
        Option[] regionOpt = null;
        ArrayList<LookUpEntity> regionTypes = lookupEntity.readAllRegion();
        regionOpt = new Option[regionTypes.size() + 1];
        Option regionOptFirst = new Option("0", "--Select Region--");
        regionOpt[0] = regionOptFirst;
        for (int i = 0; i < regionTypes.size(); i++) {
            lookupEntity = regionTypes.get(i);
            Option optRegionType = new Option(lookupEntity.getTitleCode(), lookupEntity.getTitleDescription());
            regionOpt[i + 1] = optRegionType;
        }
        return regionOpt;
    }

    public String readRegionDescrption(String regionID) {
        return lookupEntity.readRegionDescrption(regionID);
    }

    public String readZonenDescrption(String zoneID) {
        return lookupEntity.readZoneDescrption(zoneID);
    }

    public String readWoredaDescrption(String woredaID) {
        return lookupEntity.readWoredaDescrption(woredaID);
    }

    public String readKebelleDescrption(String kebelleID) {
        return lookupEntity.readKebelleDescrption(kebelleID);
    }

    public ArrayList<SelectItem> readRegion() {
        ArrayList<LookUpEntity> regionTypes = lookupEntity.readAllRegion();
        ArrayList<SelectItem> regionOpti = new ArrayList<SelectItem>();
        for (int i = 0; i <
                regionTypes.size(); i++) {
            lookupEntity = regionTypes.get(i);
            regionOpti.add(new Option(String.valueOf(lookupEntity.getTitleCode()),
                    String.valueOf(lookupEntity.getTitleDescription())));
        }

        regionOpti.add(0, new Option(null, "--Select Region--"));
        return regionOpti;
    }

    public ArrayList<SelectItem> readWoredaAndZone(String subCity) {
        ArrayList<LookUpEntity> woredaAndZone = lookupEntity.readKebelleInAWoredaOrSubCity(subCity);
        ArrayList<SelectItem> woredaZoneOpti = new ArrayList<SelectItem>();
        for (int i = 0; i < woredaAndZone.size(); i++) {
            lookupEntity = woredaAndZone.get(i);
            woredaZoneOpti.add(new Option(String.valueOf(lookupEntity.getTitleCode()),
                    String.valueOf(lookupEntity.getTitleDescription())));
        }

        woredaZoneOpti.add(0, new Option(null, "--Select Zone--"));
        return woredaZoneOpti;
    }

    public ArrayList<SelectItem> readKebelleInSubCity(String subCity) {
        ArrayList<LookUpEntity> kebbelleEntity = lookupEntity.readKebelleInSubCity(subCity);
        ArrayList<SelectItem> kebbelleItems = new ArrayList<SelectItem>();
        for (int i = 0; i < kebbelleEntity.size(); i++) {
            lookupEntity = kebbelleEntity.get(i);
            kebbelleItems.add(new Option(String.valueOf(lookupEntity.getTitleCode()),
                    String.valueOf(lookupEntity.getTitleDescription())));
        }
        kebbelleItems.add(0, new Option(null, "--Select Kebele--"));
        return kebbelleItems;
    }

    public Option[] readKebelleInAWoredaOrSubCity(String subCity) {
        ArrayList<LookUpEntity> kebelleTypes = lookupEntity.readKebelleInAWoredaOrSubCity(subCity);
        kebelleOpt =
                new Option[kebelleTypes.size() + 1];
        Option kebelleOptFirst = new Option(0, "Select Zone");
        kebelleOpt[0] = kebelleOptFirst;
        for (int j = 0; j <
                kebelleTypes.size(); j++) {
            lookupEntity = kebelleTypes.get(j);
            Option optKebelleType = new Option(lookupEntity.getTitleCode(), lookupEntity.getTitleDescription());
            kebelleOpt[j + 1] = optKebelleType;
        }

        return kebelleOpt;

    }

    public Option[] readKebelleInSubCity2(String subCity) {
        ArrayList<LookUpEntity> kebelleTypes = lookupEntity.readKebelleInSubCity(subCity);
        kebelleOpt =
                new Option[kebelleTypes.size() + 1];
        Option kebelleOptFirst = new Option("0", "Select Kebelle");
        kebelleOpt[0] = kebelleOptFirst;
        for (int j = 0; j < kebelleTypes.size(); j++) {
            lookupEntity = kebelleTypes.get(j);
            Option optKebelleType = new Option(lookupEntity.getTitleCode(), lookupEntity.getTitleDescription());
            kebelleOpt[j + 1] = optKebelleType;
        }
        return kebelleOpt;
    }

    public ArrayList<SelectItem> readZoneOrCityInARegion(String regionId) {
        try {
            ArrayList<LookUpEntity> zoneCityTypes = lookupEntity.readZoneOrCityInARegion(regionId);
            ArrayList<SelectItem> regionOpt = new ArrayList<SelectItem>();
            Option regionOptFirst = new Option(null, "--Select Region--");
            if (zoneCityTypes.size() > 0) {
                for (int i = 0; i <
                        zoneCityTypes.size(); i++) {
                    lookupEntity = zoneCityTypes.get(i);
                    regionOpt.add(new Option(String.valueOf(lookupEntity.getTitleCode()),
                            String.valueOf(lookupEntity.getTitleDescription())));
                }

                regionOpt.add(0, new Option(null, "Select Zone/City"));
            } else {
                regionOpt.add(0, new Option(null, "No Zone/City "));
            }

            return regionOpt;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public String readTitle(String titleID) {
        return lookupEntity.readTitleName(titleID);
    }

    public String readSalary(String randkID, String payGradeID) {
        return payGradeType.readSalary(randkID, payGradeID);
    }

    public ArrayList<SelectItem> readEducationLevel() {
        try {
            ArrayList<LookUpEntity> eduLevelList = lookupEntity.readEducationLevel();
            ArrayList<SelectItem> educationOpt = new ArrayList<SelectItem>();//("Select Education Level");
            if (eduLevelList.size() > 0) {
                for (int i = 0; i <
                        eduLevelList.size(); i++) {
                    lookupEntity = eduLevelList.get(i);
                    educationOpt.add(new Option(String.valueOf(lookupEntity.getTitleCode())+"-"+
                            String.valueOf(lookupEntity.getTitleDescription())));
                }

                educationOpt.add(0, new Option(null, "Select Education Level"));
            } else {
                educationOpt.add(0, new Option(null, "Not Available Education Level"));
            }

            return educationOpt;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public ArrayList<SelectItem> readEducationTypes() {
        try {
            ArrayList<LookUpEntity> eduTypeList = lookupEntity.readEducationTypes();
            kebelleOpt = new Option[eduTypeList.size() + 1];
            ArrayList<SelectItem> educationOType = new ArrayList<SelectItem>();//Option("Select Education Type");
            if (eduTypeList.size() > 0) {
                for (int i = 0; i <
                        eduTypeList.size(); i++) {
                    lookupEntity = eduTypeList.get(i);
                    educationOType.add(new Option(String.valueOf(lookupEntity.getTitleCode()),
                            String.valueOf(lookupEntity.getTitleDescription())));
                }

                educationOType.add(0, new Option(null, "Select Education Type"));
            } else {
                educationOType.add(0, new Option(null, "Not Available Education Type"));
            }

            return educationOType;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public ArrayList<SelectItem> readLanguageType() {
        try {
            ArrayList<LookUpEntity> languageTypes = lookupEntity.readLanguageType();
            ArrayList<SelectItem> languagename = new ArrayList<SelectItem>();

            if (languageTypes.size() > 0) {
                for (int i = 0; i <
                        languageTypes.size(); i++) {
                    lookupEntity = languageTypes.get(i);
                    languagename.add(new Option(String.valueOf(lookupEntity.getTitleCode()),
                            String.valueOf(lookupEntity.getTitleDescription())));
                }

                languagename.add(0, new Option(null, "Select Language Type"));
            } else {
                languagename.add(0, new Option(null, "Not Available Language Type"));
            }

            return languagename;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public ArrayList<SelectItem> readMeasurement() {
        ArrayList<String> measuremant = new ArrayList<String>();
        ArrayList<SelectItem> measurementCriteria = new ArrayList<SelectItem>();
        measuremant.add("Excellent");
        measuremant.add("Very Good");
        measuremant.add("Good");
        measuremant.add("Poor");
        for (int i = 0; i < measuremant.size(); i++) {
            measurementCriteria.add(new Option(String.valueOf(measuremant.get(i)),
                    String.valueOf(measuremant.get(i))));
        }
        measurementCriteria.add(0, new Option(null, "Select Measurement"));
        return measurementCriteria;
    }
    PayGrad payGradeType = new PayGrad();

    public ArrayList<SelectItem> readPayGrade(String rankID) {
        try {
            ArrayList<PayGrad> payGradeTypes = payGradeType.readPayGradList(rankID);
            ArrayList<SelectItem> questionlist = new ArrayList<SelectItem>();
            if (payGradeTypes.size() > 0) {
                for (int i = 0; i <
                        payGradeTypes.size(); i++) {
                    payGradeType = payGradeTypes.get(i);
                    questionlist.add(new Option(String.valueOf(payGradeType.getPayGrad()),
                            String.valueOf(payGradeType.getPayGrad())));
                }

                questionlist.add(0, new Option(null, " Select Pay Grade"));
            } else {
                questionlist.add(0, new Option(null, "Pay Grade not avilabel"));
            }


//            ArrayList<SelectItem> listArray = new ArrayList<SelectItem>(questionlist.size());
//            questionlist.add(listArray);
//            return listArray;
            return questionlist;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public int checkZoneAvilabel(String regionID, String ZoneID) {
        return payGradEntity.checkZoneAvilabel(regionID, ZoneID);
    }

    public int checkZoneAvilabel(String regionID) {
        return payGradEntity.checkZoneAvilabel(regionID);
    }

//    public int checkZoneID(String zoneID) {
//        return payGradEntity.checkZoneID(zoneID);
//    }
    public int checkPayGrade(String rankID, String payGrad) {
        return payGradEntity.checkPayGrad(rankID, payGrad);

    }

    public int savePayGrad(String rankID, String payGrad, Double salary) {
        return payGradEntity.addPayGrad(rankID, payGrad, salary);
    }

    public int updatePayGrad(String rankID, String stepNumber, Double salary, String payGradeid) {
        return payGradEntity.updatePayGrad(rankID, stepNumber, salary, payGradeid);
    }

    public HashMap readRank(String rankID) {
        return rankEntity.readRank(rankID);
    }

    public HashMap[] readPayGrad(String rankID) {
        return payGradeType.readPayGrade(rankID);
    }

    public ArrayList<HashMap> readPayGradeList(String rankID) {
        return payGradeType.readPayGradeList(rankID);
    }

    public int saveRank(String rankID, String description, Double beginningSalary, Double maxSalary, String type) {
        return rankEntity.addRank(rankID, description, beginningSalary, maxSalary, type);
    }

    public int deleteRank(String rankID) {
        return rankEntity.deleteRank(rankID);
    }

    public int deletePayGradWith(String payGradId) {
        return payGradeType.deletePayGradWith(payGradId);
    }

    public int updateRank(String oldRankID, String rankID, String description, Double beginningSalary, Double maxSalary) {
        return rankEntity.updateRank(oldRankID, rankID, description, beginningSalary, maxSalary);
    }

    public int updateRank(String rankDescription,
            Double begningSalary,
            Double maxSalary,
            String type,
            String rankId) {
        return rankEntity.updateRank(rankDescription,
                begningSalary,
                maxSalary,
                type,
                rankId);
    }

    public boolean update_Rank(HashMap list, ArrayList<HashMap> listOfPayGrade) {
        return rankEntity.updateRankAndPayGrade(list, listOfPayGrade);
    }

    public int deletePayGrad(String rankID) {
        return payGradeType.deletePayGrad(rankID);
    }

    public int checkKebelleAvilabel(String regionID, String zoneOrCityID, String woredaOrSubCityID, String kebelleID) {
        return kebelle.checkKebellAvilabelKebelle(regionID, zoneOrCityID, woredaOrSubCityID, kebelleID);

    }

    public boolean chekRank(String rankID) {
        return rankEntity.countRank(rankID);
    }

    public int readWoredaOrSubCity(String regionID, String zoneOrCityID, String woredaOrSubCityID) {

        return woredaOrSubCity.readWoredaOrSubCity(regionID, zoneOrCityID, woredaOrSubCityID);

    }

    public int readkebelle(String regionID, String zoneOrCityID, String woredaOrSubCityID, String kebelleID) {

        return kebelle.counkebelle(regionID, zoneOrCityID, woredaOrSubCityID, kebelleID);
    }

    public int addkebelle(String woredaOrSubCityID, String kebelleID, String kebelleName, String kebelleDescription) {
        return kebelle.addkebelle(woredaOrSubCityID, kebelleID, kebelleName, kebelleDescription);
    }

    public int countKebelleUsing(String regionID, String zoneOrCityID, String woredaOrSubCityID) {
        return kebelle.coutKebelleUsing(regionID, zoneOrCityID, woredaOrSubCityID);
    }

    /**
     *
     * @param regionID
     * @param zoneOrCityID
     * @param woredaOrSubCityID
     * @return
     */
    public HashMap[] readKebelle(String regionID, String zoneOrCityID, String woredaOrSubCityID) {
        return kebelle.readKebelle(regionID, zoneOrCityID, woredaOrSubCityID);

    }

    /**
     *
     * @param kebelleID
     * @return
     */
    public int deletekebelle(String kebelleID) {
        return kebelle.deletekebelle(kebelleID);
    }

    /**
     *
     * @param regionID
     * @param id
     * @param name
     * @param description
     * @return
     */
    public int readZoneOrCity(String regionID, String zoneOrCityID) {
        return zoneOrCity.readZoneOrCity(regionID, zoneOrCityID);
    }

    public int addZoneOrCity(String regionID, String id, String name, String description) {
        try {
            return zoneOrCity.insertZoneOrCity(regionID, id, name, description);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }

    }

    public void deleteWoredaOrSubCity(String regionID, String zoneOrCity) {
        woredaOrSubCity.deleteWoredaOrSubCity(regionID, zoneOrCity);
    }

    /**
     *
     * @param regionID
     * @param zoneOrCityID
     * @return
     */
    public int deleteZoneOrCity(String regionID, String zoneOrCityID) {
        return zoneOrCity.deleteZoneOrCity(regionID, zoneOrCityID);
    }

    /**
     *
     * @param regionID
     * @param zoneOrCityID
     * @return
     */
    public int deleteWoreda(String regionID, String zoneOrCityID) {
        return zoneOrCity.deleteWoreda(regionID, zoneOrCityID);
    }

    public ArrayList<SelectItem> assignJobRank(String type) {
        try {
            ArrayList<LookUpEntity> readJobRank = null;
            if (type.equals("")) {
                readJobRank = getLookupEntity().readJobRank();
            } else {
                readJobRank = getLookupEntity().readJobRank(type);
            }
            ArrayList<SelectItem> questionlist = new ArrayList<SelectItem>();
            if (readJobRank.size() > 0) {
                if (type.equals("Civil")) {
                    for (int i = 0; i < readJobRank.size(); i++) {
                        setLookupEntity(readJobRank.get(i));
                        questionlist.add(new Option(String.valueOf(getLookupEntity().getTitleCode()),
                                String.valueOf(getLookupEntity().getTitleDescription())));
                    }

                } else {
                    for (int i = 0; i <
                            readJobRank.size(); i++) {
                        setLookupEntity(readJobRank.get(i));
                        questionlist.add(new Option(String.valueOf(getLookupEntity().getTitleCode()),
                                String.valueOf(getLookupEntity().getTitleDescription())));
                    }

                }
                questionlist.add(0, new Option(null, "-- Select JobRank --"));
            } else {
                questionlist.add(0, new Option(null, "No Rank Record Avilabel"));
            }
            return questionlist;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public ArrayList<SelectItem> readEducationForJob() {
        try {
            ArrayList<LookUpEntity> eduTypeList = lookupEntity.readEducationForJob();
            kebelleOpt = new Option[eduTypeList.size() + 1];
            ArrayList<SelectItem> educationOType = new ArrayList<SelectItem>();
            if (eduTypeList.size() > 0) {
                for (int i = 0; i <
                        eduTypeList.size(); i++) {
                    lookupEntity = eduTypeList.get(i);
                    educationOType.add(new Option(String.valueOf(lookupEntity.getTitleCode()),
                            String.valueOf(lookupEntity.getTitleDescription())));
                }

                educationOType.add(0, new Option(null, "Select Education Type"));
            } else {
                educationOType.add(0, new Option(null, "Not Available Education Type"));
            }

            return educationOType;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public ArrayList<SelectItem> readEducationByCategoryForJob(String category) {
        try {
            ArrayList<LookUpEntity> eduTypeList = lookupEntity.readEducationCategoryForJob(category);
            ArrayList<SelectItem> educationOType = new ArrayList<SelectItem>();
            if (eduTypeList.size() > 0) {
                for (int i = 0; i < eduTypeList.size(); i++) {
                    lookupEntity = eduTypeList.get(i);
                    educationOType.add(new SelectItem(String.valueOf(lookupEntity.getTitleCode()), String.valueOf(lookupEntity.getTitleDescription())));
                }

                educationOType.add(0, new SelectItem(null, "Select Education Type"));
            } else {
                educationOType.add(0, new SelectItem(null, "Not Available Education Type"));
            }

            return educationOType;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public ArrayList<SelectItem> readAllEducationCatagories() {
        ArrayList<SelectItem> educationCatagoryList = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = lookupEntity.readEducationCataegories();
            while (_rs.next()) {
                educationCatagoryList.add(new SelectItem(_rs.getString("CATEGORY_id"), _rs.getString("CATEGORY_NAME")));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        educationCatagoryList.add(0, new SelectItem("-1", "All Catagories"));
        return educationCatagoryList;
    }

    public ArrayList<SelectItem> readEducationLevelMod() {
        try {
            ArrayList<LookUpEntity> eduLevelList = lookupEntity.readEducationLevelMod();
            ArrayList<SelectItem> educationOpt = new ArrayList<SelectItem>();
            if (eduLevelList.size() > 0) {
                for (int i = 0; i <
                        eduLevelList.size(); i++) {
                    lookupEntity = (eduLevelList.get(i));
                    educationOpt.add(new Option(String.valueOf(lookupEntity.getTitleCode()),
                            String.valueOf(lookupEntity.getTitleDescription())));
                }

                educationOpt.add(0, new Option(null, "Select Education Level"));
            } else {
                educationOpt.add(0, new Option(null, "Not Available Education Level"));
            }

            return educationOpt;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public ArrayList<SelectItem> readRankList() {
        try {
            ArrayList<HashMap> eduLevelList = rankEntity.readRank();
            ArrayList<SelectItem> rankList = new ArrayList<SelectItem>();
            if (eduLevelList.size() > 0) {
                rankList.add(new SelectItem(null, "Select Rank Level"));
                for (HashMap hm : eduLevelList) {

                    rankList.add(new SelectItem(hm.get("RANK_ID"),
                            hm.get("RANK_ID").toString()));
                }


            } else {
                rankList.add(new SelectItem(null, "Not Available Rank Level"));
            }

            return rankList;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
public ArrayList<HashMap> getAllPayGrade() {
    try {
        return payGradEntity.getAllPayGrade();
    } catch (Exception e) {
        return null;
    }
   
}

    public ArrayList<SelectItem> getAllGradingSystems() {
        ArrayList<SelectItem> priortyTypes = new ArrayList<SelectItem>();

        priortyTypes.add(0, new Option("-1", "Select"));
        priortyTypes.add(1, new Option("0", " P/Fl"));
        priortyTypes.add(2, new Option("4", "  4.0 "));
        priortyTypes.add(3, new Option("5", "  5.0 "));
        priortyTypes.add(4, new Option("6", "  6.0 "));
        priortyTypes.add(5, new Option("10", " 10.0 "));
        priortyTypes.add(6, new Option("100", "100.0 "));
        return priortyTypes;
    }

    public ArrayList<SelectItem> getListofMonths() {
        ArrayList<SelectItem> monthList = new ArrayList<SelectItem>();
        monthList.add(new SelectItem(null, "Select Month"));
        monthList.add(new Option(1, "January"));
        monthList.add(new Option(2, "February"));
        monthList.add(new Option(3, "March"));
        monthList.add(new Option(4, "April"));
        monthList.add(new Option(5, "May"));
        monthList.add(new Option(6, "June"));
        monthList.add(new Option(7, "July"));
        monthList.add(new Option(8, "Augest"));
        monthList.add(new Option(9, "September"));
        monthList.add(new Option(10, "October"));
        monthList.add(new Option(11, "November"));
        monthList.add(new Option(12, "December"));
        return monthList;
    }

    public String[] getStringListofMonths() {
        String[] listOfMonth = {
            "not selected",
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "Augest",
            "September",
            "October",
            "November",
            "December"};

        return listOfMonth;
    }
}
