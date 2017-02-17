/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.questionnaire;

import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.el.MethodExpression;
import javax.el.ValueExpression;
import javax.faces.component.UISelectItem;
import javax.faces.component.UISelectItems;
import javax.faces.component.html.HtmlColumn;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneRadio;
import javax.faces.component.html.HtmlSelectManyCheckbox;
import javax.faces.component.html.HtmlPanelGroup;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.model.SelectItem;

/**
 *
 * @author Bini
 */
public class DynamicFiledList {

    public static ArrayList<DynamicField>[] dynamicDataList;
    private int tblSize;
    QuestionOptionsManager optionManager = new QuestionOptionsManager();
    AllQuestionsManager allQuestionsManager = new AllQuestionsManager();
    QuestionnaireAnswerManager answerManager = new QuestionnaireAnswerManager();

    public DynamicFiledList() {
    }

    public DynamicFiledList(int tblSize) {
        dynamicDataList = new ArrayList[tblSize];
    }

    // <editor-fold defaultstate="collapsed" desc="  Getters and Setters   ">
    public ArrayList<DynamicField>[] getDynamicDataList() {
        return dynamicDataList;
    }

    public void setDynamicDataList(ArrayList<DynamicField>[] dynamicDataList) {
        this.dynamicDataList = dynamicDataList;
    }

    public int getTblSize() {
        return tblSize;
    }

    public void setTblSize(int tblSize) {
        this.tblSize = tblSize;
    }

    // </editor-fold>
    public void loadDynamicList(ArrayList<AllQuestionsManager> tblManger, int index) {
        Iterator<AllQuestionsManager> tblIterator = tblManger.iterator();
        Integer[] questionTypeId = new Integer[tblManger.size()];
        Integer[] optionGroupId = new Integer[tblManger.size()];
        int questTblId = 0;
        int i = 0;
        while (tblIterator.hasNext()) {
            AllQuestionsManager questionsManager = tblIterator.next();
            if (questionsManager.getColumnType() == 0) {
                questTblId = questionsManager.getQuestTblId();
            } else {
                optionGroupId[i] = questionsManager.getOptionGroupId();
                questionTypeId[i] = questionsManager.getQuestionType();
            }
            i++;
        }
        ArrayList<AllQuestionsManager> colManger = allQuestionsManager.readColumnQuestionByTblId(questTblId);
        if (colManger != null || colManger.isEmpty()) {
            Iterator<AllQuestionsManager> colIerrator = colManger.iterator();
            int row = 1;
            dynamicDataList[index] = new ArrayList<DynamicField>();
            while (colIerrator.hasNext()) {
                AllQuestionsManager questionsManager = colIerrator.next();
                dynamicDataList[index].add(loadDataWithQuestion(
                        questionTypeId,
                        optionGroupId,
                        questionsManager,
                        row));
                row++;
            }
        } else {
            for (int k = 1; k <= 5; k++) {
                dynamicDataList[index].add(loadDataWithOutQuestion(
                        questionTypeId,
                        optionGroupId,
                        k));
            }
        }
    }

    public DynamicField loadDataWithQuestion(Integer[] questionTypeId, Integer[] optionGroupId,
            AllQuestionsManager questionsManager, int row) {
        DynamicField dynamicField = new DynamicField();
        dynamicField.setQuestColId(questionsManager.getQuestColumnId());
        dynamicField.setQuestion(questionsManager.getQuestion());
        dynamicField.setRowCounter(row);
        for (int j = 1; j < optionGroupId.length; j++) {
            if (questionTypeId[j] != null) {
                if (questionTypeId[j] == 3 || questionTypeId[j] == 4) {
                    int item = j + 1;
                    if (item == 1) {
                        dynamicField.setColItem1(optionManager.getQuestionOptions(optionGroupId[j]));
                    } else if (item == 2) {
                        dynamicField.setColItem2(optionManager.getQuestionOptions(optionGroupId[j]));
                    } else if (item == 3) {
                        dynamicField.setColItem3(optionManager.getQuestionOptions(optionGroupId[j]));
                    } else if (item == 4) {
                        dynamicField.setColItem4(optionManager.getQuestionOptions(optionGroupId[j]));
                    } else if (item == 5) {
                        dynamicField.setColItem5(optionManager.getQuestionOptions(optionGroupId[j]));
                    } else if (item == 6) {
                        dynamicField.setColItem6(optionManager.getQuestionOptions(optionGroupId[j]));
                    }
                }
            }
        }
        return dynamicField;
    }

    public DynamicField loadDataWithOutQuestion(Integer[] questionTypeId, Integer[] optionGroupId, int row) {
        DynamicField dynamicField = new DynamicField(row);
        for (int j = 0; j < optionGroupId.length; j++) {
            if (questionTypeId[j] != null) {
                if (questionTypeId[j] == 3 || questionTypeId[j] == 4) {
                    int item = j + 1;
                    if (item == 1) {
                        dynamicField.setColItem1(optionManager.getQuestionOptions(optionGroupId[j]));
                    } else if (item == 2) {
                        dynamicField.setColItem2(optionManager.getQuestionOptions(optionGroupId[j]));
                    } else if (item == 3) {
                        dynamicField.setColItem3(optionManager.getQuestionOptions(optionGroupId[j]));
                    } else if (item == 4) {
                        dynamicField.setColItem4(optionManager.getQuestionOptions(optionGroupId[j]));
                    } else if (item == 5) {
                        dynamicField.setColItem5(optionManager.getQuestionOptions(optionGroupId[j]));
                    } else if (item == 6) {
                        dynamicField.setColItem6(optionManager.getQuestionOptions(optionGroupId[j]));
                    }
                }
            }
        }
        return dynamicField;
    }

    public void loadAnswer(int questAnsId) {
        ArrayList<DynamicField> dynamicFields = answerManager.selectTableQuestionsAnswer(questAnsId);
        for (int i = 0; i < dynamicDataList.length; i++) {
            for (DynamicField field : dynamicFields) {
                for (int j = 0; j < dynamicDataList[i].size(); j++) {
                    if (dynamicDataList[i].get(j).getQuestColId().equals(field.getQuestColId())) {
                        dynamicDataList[i].get(j).setAnswer1(field.getAnswer1());
                        dynamicDataList[i].get(j).setAnswer2(field.getAnswer2());
                        dynamicDataList[i].get(j).setAnswer3(field.getAnswer3());
                        dynamicDataList[i].get(j).setAnswer4(field.getAnswer4());
                        dynamicDataList[i].get(j).setAnswer5(field.getAnswer5());
                        dynamicDataList[i].get(j).setAnswer6(field.getAnswer6());
                        dynamicDataList[i].get(j).setAnswer7(field.getAnswer7());
                        dynamicDataList[i].get(j).setAnswer8(field.getAnswer8());
                        dynamicDataList[i].get(j).setAnswer9(field.getAnswer9());
                        dynamicDataList[i].get(j).setAnswer10(field.getAnswer10());
                        dynamicDataList[i].get(j).setAnswer11(field.getAnswer11());
                        dynamicDataList[i].get(j).setAnswer12(field.getAnswer12());
                        if (field.getAnswer1() != null && !field.getAnswer1().isEmpty()) {
                            dynamicDataList[i].get(j).setSelectedItems1(field.getAnswer1().split(","));
                        }
                        if (field.getAnswer2() != null && !field.getAnswer2().isEmpty()) {
                            dynamicDataList[i].get(j).setSelectedItems2(field.getAnswer2().split(","));
                        }
                        if (field.getAnswer3() != null && !field.getAnswer3().isEmpty()) {
                            dynamicDataList[i].get(j).setSelectedItems3(field.getAnswer3().split(","));
                        }
                        if (field.getAnswer4() != null && !field.getAnswer4().isEmpty()) {
                            dynamicDataList[i].get(j).setSelectedItems4(field.getAnswer4().split(","));
                        }
                        if (field.getAnswer5() != null && !field.getAnswer5().isEmpty()) {
                            dynamicDataList[i].get(j).setSelectedItems5(field.getAnswer5().split(","));
                        }
                        if (field.getAnswer6() != null && !field.getAnswer6().isEmpty()) {
                            dynamicDataList[i].get(j).setSelectedItems6(field.getAnswer6().split(","));
                        }
                        if (field.getAnswer7() != null && !field.getAnswer7().isEmpty()) {
                            dynamicDataList[i].get(j).setSelectedItems7(field.getAnswer7().split(","));
                        }
                        if (field.getAnswer8() != null && !field.getAnswer8().isEmpty()) {
                            dynamicDataList[i].get(j).setSelectedItems8(field.getAnswer8().split(","));
                        }
                        if (field.getAnswer9() != null && !field.getAnswer9().isEmpty()) {
                            dynamicDataList[i].get(j).setSelectedItems9(field.getAnswer9().split(","));
                        }
                        if (field.getAnswer10() != null && !field.getAnswer10().isEmpty()) {
                            dynamicDataList[i].get(j).setSelectedItems10(field.getAnswer10().split(","));
                        }
                        if (field.getAnswer12() != null && !field.getAnswer12().isEmpty()) {
                            dynamicDataList[i].get(j).setSelectedItems11(field.getAnswer11().split(","));
                        }
                        if (field.getAnswer11() != null && !field.getAnswer11().isEmpty()) {
                            dynamicDataList[i].get(j).setSelectedItems12(field.getAnswer12().split(","));
                        }
                    }
                }

            }
        }
    }

    public HtmlPanelGroup populateDynamicDataTable(int questionId, int tblIndex, int top, int left, int height, int width) {

        //create panelGroup
        HtmlPanelGroup pnlGroup = new HtmlPanelGroup();
        pnlGroup.setStyle("display: block; position:absolute; top:" + top + "px; left:" + left + "px; height:" + height + "px; width:" + width + "px");

        //read all questions
        ArrayList<AllQuestionsManager> tblFormQuest = allQuestionsManager.readTableFormQuestions(questionId);
        Iterator<AllQuestionsManager> tblIterator = tblFormQuest.iterator();

        //create data table
        HtmlDataTable dynamicDataTable = new HtmlDataTable();
        dynamicDataTable.setId("dataTable" + tblIndex);
        //set value expression (bind data value with DynamicList.dynamicDataList[tblIndex])
        dynamicDataTable.setValueExpression("value",
                createValueExpression("#{DynamicList.dynamicDataList[" + tblIndex + "]}", List.class));
        //set var attribute of currentRow--dynamicItem
        dynamicDataTable.setVar("dynamicItem");
        dynamicDataTable.setStyle("display: block;border-width: 1px;  position:absolute; top:0px; left:-10px; width:100%");
        dynamicDataTable.setStyle("iceDatTbl");
        dynamicDataTable.setHeaderClass("iceDatTblHdr");
        dynamicDataTable.setFooterClass("iceTblFtr");

        // Create <h:column>.
        HtmlColumn firstColumn = new HtmlColumn();
        dynamicDataTable.getChildren().add(firstColumn);

        // Create <h:outputText > for <f:facet name="header"> of column.
        HtmlOutputText firstHeader = new HtmlOutputText();
        firstHeader.setValue("No.");
        firstColumn.setHeader(firstHeader);

        // Create <h:outputText value="#{dynamicItem[" ... "]}"> for the body of column.
        HtmlOutputText firstOutput = new HtmlOutputText();
        firstOutput.setValueExpression("value",
                createValueExpression("#{dynamicItem['rowCounter']}", Integer.class));
        firstColumn.getChildren().add(firstOutput);

        int n = 1;
        while (tblIterator.hasNext()) {
            AllQuestionsManager tblManager = tblIterator.next();

            HtmlColumn column = new HtmlColumn();
            dynamicDataTable.getChildren().add(column);

            HtmlOutputText header = new HtmlOutputText();
            header.setValue(tblManager.getColumnName());
            column.setHeader(header);


            if (tblManager.getColumnType() == 0) {// column is question type

                // Create <h:outputText value="#{dynamicItem['question']}"> for the body of column.
                HtmlOutputText output = new HtmlOutputText();
                output.setValueExpression("value",
                        createValueExpression("#{dynamicItem['question']}", String.class));
                column.getChildren().add(output);

            } else {
                if (tblManager.getQuestionType() == 1 || tblManager.getQuestionType() == 2) {
                    // question type is single line or many line answers

                    // Create <h:inputText value="#{dynamicItem['colName1']}"> for the body of column.
                    // colName will be  colName1 or colName2 or colName3 ... based on n value
                    HtmlInputText output = new HtmlInputText();
                    output.setValueExpression("value",
                            createValueExpression("#{dynamicItem['answer" + n + "']}", String.class));
                    column.getChildren().add(output);

                } else if (tblManager.getQuestionType() == 3) {
                    // question type is only answer from list of choisces

                    HtmlOutputText header2 = new HtmlOutputText();
                    header2.setEscape(false);
                    header2.setValue(header.getValue() + " <br /> " + optionManager.getQuestionOptionsLabel(tblManager.getOptionGroupId()));
                    column.setHeader(header2);

                    // Create <h:selectOneRadio value="#{dynamicItem['selectedItem1']}"> for the body of column.
                    // selectedItem will be  selectedItem1 or selectedItem2 or selectedItem3 ... based on n value
                    HtmlSelectOneRadio output = new HtmlSelectOneRadio();
                    output.setId("rbn" + tblManager.getQuestColumnId());
                    output.setValueExpression("value",
                            createValueExpression("#{dynamicItem['answer" + n + "']}", String.class));

                    // create <f:selectItems value="#{dynamicItem['colItem1']}"> for the body of HtmlSelectOneRadio.
                    // colItem will be  colItem1 or colItem2 or colItem3 ... based on n value
                    UISelectItems selectItems = new UISelectItems();
                    selectItems.setValueExpression("value",
                            createValueExpression("#{dynamicItem['colItem" + n + "']}", List.class));
                    output.getChildren().add(selectItems);
                    column.getChildren().add(output);


                } else if (tblManager.getQuestionType() == 4) {
                    // question type is many answer from list of choisces

                    HtmlOutputText header2 = new HtmlOutputText();
                    header2.setEscape(false);
                    header2.setValue(header.getValue() + " <br /> " + optionManager.getQuestionOptionsLabel(tblManager.getOptionGroupId()));
                    column.setHeader(header2);

                    // Create <h:selectManyCheckbox value="#{dynamicItem['selectedItem1']}"> for the body of column.
                    // selectedItems will be  selectedItems1 or selectedItems2 or selectedItems3 ... based on n value
                    HtmlSelectManyCheckbox output = new HtmlSelectManyCheckbox();
                    output.setId("chk" + tblManager.getQuestColumnId());
                    output.setValueExpression("value",
                            createValueExpression("#{dynamicItem['selectedItems" + n + "']}", String[].class));

                    // create <f:selectItems value="#{dynamicItem['colItem1']}"> for the body of HtmlSelectOneRadio.
                    // colItem will be  colItem1 or colItem2 or colItem3 ... based on n value
                    UISelectItems selectItems = new UISelectItems();
                    selectItems.setValueExpression("value",
                            createValueExpression("#{dynamicItem['colItem" + n + "']}", List.class));
                    output.getChildren().add(selectItems);
                    column.getChildren().add(output);
                }
            }
            n++;
        }
        pnlGroup.getChildren().add(dynamicDataTable);//add dyanamic table to the panel group
        loadDynamicList(tblFormQuest, tblIndex);//fill table with data
        return pnlGroup;
    }

    public HtmlOutputLabel getHtmlOutputLabel(int id, String value, int top, int left) {
        HtmlOutputLabel outputLabel = new HtmlOutputLabel();
        outputLabel.setId("lbl" + id);
        outputLabel.setStyle("display: block; position: " + "absolute; top: " + top + "px;left:" + left + "px");
        outputLabel.setValue(value);
        return outputLabel;
    }

    public HtmlInputText getHtmlInputText(int id, int top, int left) {
        HtmlInputText inputText = new HtmlInputText();
        inputText.setId("answer" + id);
        inputText.setStyle("display: block; position: " + "absolute; top: " + top + "px;left:" + left + "px");
        return inputText;
    }

    public HtmlInputTextarea getHtmlInputTextArea(int id, int top, int left) {
        HtmlInputTextarea inputTextArea = new HtmlInputTextarea();
        inputTextArea.setId("answer" + id);
        inputTextArea.setStyle("display: block; position: " + "absolute; top: " + top + "px;left:" + left + "px");
        return inputTextArea;
    }

    public HtmlSelectOneRadio getHtmlSelectOneRadio(int id, int top, int left, int groupId) {
        HtmlSelectOneRadio selectOneRadio = new HtmlSelectOneRadio();
        selectOneRadio.setId("answer" + id);
        selectOneRadio.setStyle("display: block; position: " + "absolute; top: " + top + "px;left:" + left + "px");
        ArrayList<SelectItem> options = optionManager.getQuestionOptions(groupId);
        for (int z = 0; z < options.size(); z++) {
            UISelectItem item = new UISelectItem();
            item.setItemLabel(options.get(z).getLabel().toString());
            item.setItemValue(options.get(z).getValue().toString());
            selectOneRadio.getChildren().add(item);
        }
        return selectOneRadio;
    }

    public HtmlSelectManyCheckbox getHtmlSelectManyCheckbox(int id, int top, int left, int groupId) {
        HtmlSelectManyCheckbox selectManyCheckbox = new HtmlSelectManyCheckbox();
        selectManyCheckbox.setId("answer" + id);
        selectManyCheckbox.setStyle("display: block; position: " + "absolute; top: " + top + "px;left:" + left + "px");
        ArrayList<SelectItem> options = optionManager.getQuestionOptions(groupId);
        for (int z = 0; z < options.size(); z++) {
            UISelectItem item = new UISelectItem();
            item.setItemLabel(options.get(z).getLabel().toString());
            item.setItemValue(options.get(z).getValue().toString());
            selectManyCheckbox.getChildren().add(item);
        }
        return selectManyCheckbox;
    }

    public HtmlSelectOneMenu getHtmlSelectOneMenu(int id, int top, int left, int groupId) {
        HtmlSelectOneMenu selectOneMenu = new HtmlSelectOneMenu();
        selectOneMenu.setId("answer" + id);
        selectOneMenu.setStyle("display: block; position: " + "absolute; top: " + top + "px;left:" + left + "px");
        ArrayList<SelectItem> options = optionManager.getQuestionOptions(groupId);
        for (int z = 0; z < options.size(); z++) {
            UISelectItem item = new UISelectItem();
            item.setItemLabel(options.get(z).getLabel().toString());
            item.setItemValue(options.get(z).getValue().toString());
            selectOneMenu.getChildren().add(item);
        }
        return selectOneMenu;
    }

    public ValueExpression createValueExpression(String valueExpression, Class<?> valueType) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        return facesContext.getApplication().getExpressionFactory().createValueExpression(
                facesContext.getELContext(), valueExpression, valueType);
    }

    public MethodExpression createActionExpression(String actionExpression, Class<?> returnType) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        return facesContext.getApplication().getExpressionFactory().createMethodExpression(
                facesContext.getELContext(), actionExpression, returnType, new Class[0]);
    }
}
