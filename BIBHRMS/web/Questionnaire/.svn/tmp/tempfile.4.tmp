<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : ManageQuestions
    Created on : Oct 21, 2011, 8:36:53 AM
    Author     : Bini
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <f:loadBundle basename="Localization.HRLocalization" var="msgs"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Manage Questions</title>
                <ice:outputStyle href="../resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="../xmlhttp/css/rime/rime.css"/>
                <ice:outputStyle href="../resources/ETH/KAMSI_CAL_STYLE.css" id="outputStyle22"/>
                <ice:outputStyle href="../resources/TempCSS.css"/>
                <script src="../Script/jquery-1.3.2.min.js"></script>
                <script src="../resources/ETH/KAMSI_CAL_SCRIPT.js"></script>
                <script language="javascript" type="text/javascript">
                    var ManageQuestions=jQuery.noConflict();
                </script>
                <style type="text/css">
                    .message {
                        display: none;
                        margin: 0 0 13px 0;
                        background-color:#EFA;
                        padding: 13px 13px 13px 52px;
                        background-position: 13px 5px;
                        border: solid 1px #BD8;                                                                                                                                                border: solid 1px #BD8;
                    }
                    .message2 {
                        display: none;
                        margin: 0 0 13px 0;
                        background-color:#EFA;
                        padding: 13px 13px 13px 52px;
                        background-position: 13px 5px;
                        border: solid 1px #BD8;                                                                                                                                                border: solid 1px #BD8;
                    }
                    .success{
                        color: #336600;
                        font-size: 12px;
                        font-weight: bold;
                        text-align: center;
                        vertical-align: middle;
                        top:5px;left: 0px;
                        position: absolute;
                        width: 100%
                    }
                    .error{
                        color: red;
                        font-size: 12px;
                        font-weight: bold;
                        text-align: center;
                        vertical-align: middle;
                        top:5px;left: 0px;
                        position: absolute;
                        width: 100%
                    }
                    .success1{
                        color: #336600;
                        font-size: 11px;
                        font-weight: bold;
                        height: 16px;
                        left: 5px;
                        top: 2px;
                        position: absolute;
                        text-align: left;
                        width: 391px
                    }
                    .error1{
                        color: red;
                        font-size: 11px;
                        font-weight: bold;
                        height: 16px;
                        left: 5px;
                        top: 2px;
                        position: absolute;
                        text-align: left;
                        width: 391px
                    }
                </style>
            </head>
            <body id="outputBody1" onload="showCal()" style="-rave-layout: grid">
                <ice:form id="form1">
                    <ice:panelBorder height="680" id="whole_page" renderCenter="#{Page1.panelBorder1Bean.renderCenter}"
                        renderEast="#{Page1.panelBorder1Bean.renderEast}" renderNorth="#{Page1.panelBorder1Bean.renderNorth}"
                        renderSouth="#{Page1.panelBorder1Bean.renderSouth}" renderWest="#{Page1.panelBorder1Bean.renderWest}"
                        style="top: 0px; position: relative" styleClass="whole_page" width="1024px">
                        <f:facet name="north">
                            <ice:panelGroup id="page_header" style="height: 105px">
                                <!-- Begin Header -->
                                <ice:panelLayout id="header" layout="flow" style="height: 105px; left: 0px; position: relative; width: 100%; -rave-layout: grid"
                                    styleClass="header" visible="true">
                                    <jsp:directive.include file="/Header.jspf"/>
                                </ice:panelLayout>
                                <!-- End Header -->
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="west">
                            <ice:panelGroup id="menu_left" style=" height:100%; border:none; ">
                                <ice:panelLayout id="left_menu1" layout="flow"
                                    style="height: 300px; border:none; left: 5px; top:18px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                    <ice:panelLayout id="list_menu2" style="height: 100px; border:none; left: 0px; top: 10px; position: absolute; width: 213px" styleClass="left_menu">
                                        <ice:panelCollapsible expanded="true" id="panelCollapsible1" immediate="true" style="top:15px;border:none">
                                            <f:facet name="header">
                                                <ice:panelGroup id="panelGroup1" styleClass="">
                                                    <ice:outputText id="lblRecruitmentRequest" value="Common Tasks"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid headerClass="iceDatTblColHdr1" id="panelGrid1" style="border:none" width="100%">
                                                <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                    <li>
                                                        <ice:commandLink action="#{Questionnaire$ManageQuestions.cmdAssignQuestionnaire_action}"
                                                            id="cmdAssignQuestionnaire" immediate="true" partialSubmit="true"
                                                            style="color: rgb(48, 102, 130); font-weight: bold; text-align: left" value="Assign Questionnaire"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Questionnaire$ManageQuestions.cmdQuestionnaire_action}" id="cmdQuestionnaire"
                                                            immediate="true" partialSubmit="true"
                                                            style="color: rgb(48, 102, 130); font-weight: bold; text-align: left" value="Questionnaire"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Questionnaire$ManageQuestions.cmdAnalyzeGrading_action}"
                                                            id="cmdAnalyzeGrading" immediate="true" partialSubmit="true" style="color: rgb(48, 102, 130); font-weight: bold; text-align: left"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Questionnaire$ManageQuestions.cmdAnalyzeReGrading_action}"
                                                            id="cmdAnalyzeReGrading" immediate="true" partialSubmit="true" style="color: rgb(48, 102, 130); font-weight: bold; text-align: left"/>
                                                    </li>
                                                </ul>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                        <ice:panelCollapsible expanded="true" id="panelCollapsible3">
                                            <f:facet name="header">
                                                <ice:panelGroup id="panelGroup2" styleClass="">
                                                    <ice:outputText id="outputText4"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid headerClass="iceDatTblColHdr1" id="panelGrid2" style="border:none" width="100%"/>
                                        </ice:panelCollapsible>
                                    </ice:panelLayout>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="center">
                            <ice:panelGroup id="page_display" style="height: 995px">
                                <ice:panelLayout id="container" layout="flow"
                                    style="height: 970px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                    <ice:panelTabSet binding="#{Questionnaire$ManageQuestions.panelTabSet}" id="panelTabSet" selectedIndex="2"
                                        style="left: 0px; top: 0px; position: absolute; width: 98%" tabPlacement="Top">
                                        <ice:panelTab id="pnlTabQuestionnaire" label="Questions">
                                            <ice:panelLayout id="pnlQuestionnaire" layout="flow" style="border-width: 1px; border-style: none; height: 915px; left: 0px; top: 0px; position: relative; width: 100%">
                                                <ice:panelLayout id="panelLayout2" style="height: 760px; left: 12px; top: 89px; position: absolute; width: 715px; overflow: auto;">
                                                    <ice:dataTable id="dataTable3" style="left:0;top:-10;position:absolute;width:100%"
                                                        value="#{Questionnaire$ManageQuestions.allQuestionList}" var="currentRow">
                                                        <ice:column groupOn="#{currentRow['questionSectionDesc']}" id="column7">
                                                            <ice:outputText id="outputText14" value="#{currentRow['questionSectionDesc']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText15" value="Question Section"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column8">
                                                            <ice:outputText id="outputText16" value="#{currentRow['questionNo']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText17" value="NO."/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column9">
                                                            <ice:outputText id="outputText18" value="#{currentRow['question']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText19" value="Question"/>
                                                            </f:facet>
                                                            <ice:rowSelector id="rowSelectorQuestion" immediate="true"
                                                                selectionListener="#{Questionnaire$ManageQuestions.rowSelectorQuestion_processMyEvent}" value="#{currentRow['selected']}"/>
                                                        </ice:column>
                                                        <ice:column id="column10">
                                                            <h:selectBooleanCheckbox disabled="true" id="checkbox1" value="#{currentRow['tableForm']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText21" value="Is Table Format"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column11">
                                                            <ice:outputText id="outputText22" value="#{currentRow['questionTypeDesc']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText23" value="Question Type"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column12">
                                                            <ice:outputText id="outputText24" value="#{currentRow['optionGroupDesc']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText25" value="Option"/>
                                                            </f:facet>
                                                        </ice:column>
                                                    </ice:dataTable>
                                                </ice:panelLayout>
                                                <ice:selectOneMenu id="somQuestionnaire1" partialSubmit="true"
                                                    style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 144px; top: 24px; position: absolute; width: 220px"
                                                    value="#{Questionnaire$ManageQuestions.defaultSelectedData2.selectedObject}" valueChangeListener="#{Questionnaire$ManageQuestions.somQuestionnaire1_processValueChange}">
                                                    <f:selectItems id="selectOneMenu1selectItems3" value="#{Questionnaire$ManageQuestions.definedQuesList}"/>
                                                </ice:selectOneMenu>
                                                <ice:outputLabel id="outputLabel10" style="left: 48px; top: 24px; position: absolute" value="Questionnaire"/>
                                            </ice:panelLayout>
                                        </ice:panelTab>
                                        <ice:panelTab id="pnlTabQuestions" label="Manage Questions">
                                            <ice:panelLayout id="pnlQuestions" layout="flow" style="border-width: 1px; border-style: none; height: 915px; left: 0px; top: 0px; position: relative; width: 100%">
                                                <ice:panelLayout id="pnlJobInfo1" layout="flow"
                                                    style="height: 830px; left: 15px; top: 0px; overflow: auto; position: absolute; visibility: visible; width: 715px; -rave-layout: grid"
                                                    styleClass="insideContainerMain" visible="true">
                                                    <ice:inputTextarea binding="#{Questionnaire$ManageQuestions.txtQuestion}" disabled="true" id="txtQuestion" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; height: 55px; left: 122px; top: 12px; position: absolute; width: 335px"/>
                                                    <ice:outputText id="lblSupervisorName1"
                                                        style="font-family: 'Cambria'; left: 24px; top: 84px; position: absolute" value="Question Section"/>
                                                    <ice:outputText id="lblJobTitle1" style="font-family: 'Cambria'; left: 24px; top: 124px; position: absolute" value="Question Type"/>
                                                    <ice:outputText id="lblSpecificUnit2"
                                                        style="font-family: 'Cambria'; left: 24px; top: 15px; position: absolute" value="Question"/>
                                                    <ice:outputText id="lblSpecificUnit3"
                                                        style="font-family: 'Cambria'; left: 24px; top: 161px; position: absolute" value="Options"/>
                                                    <ice:outputText id="lblSpecificUnit4"
                                                        style="font-family: 'Cambria'; left: 24px; top: 198px; position: absolute" value="Question No."/>
                                                    <ice:inputText binding="#{Questionnaire$ManageQuestions.txtQuestNo}" disabled="true" id="txtQuestNo" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 122px; top: 194px; position: absolute; width: 50px"/>
                                                    <ice:selectOneMenu binding="#{Questionnaire$ManageQuestions.ddnQuestSection}" disabled="true"
                                                        id="ddnQuestSection" partialSubmit="true"
                                                        style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 122px; top: 83px; position: absolute; width: 220px" value="#{Questionnaire$ManageQuestions.selectOneMenu1Bean.selectedObject}">
                                                        <f:selectItems id="selectOneMenu1selectItems" value="#{Questionnaire$ManageQuestions.questSection}"/>
                                                    </ice:selectOneMenu>
                                                    <ice:selectOneMenu binding="#{Questionnaire$ManageQuestions.ddnQuestType}" disabled="true" id="ddnQuestType"
                                                        partialSubmit="true"
                                                        style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 122px; top: 120px; position: absolute; width: 220px"
                                                        value="#{Questionnaire$ManageQuestions.selectOneMenu2Bean.selectedObject}" valueChangeListener="#{Questionnaire$ManageQuestions.ddnQuestType_processValueChange}">
                                                        <f:selectItems binding="#{Questionnaire$ManageQuestions.selectOneMenu2selectItems}"
                                                            id="selectOneMenu2selectItems" value="#{Questionnaire$ManageQuestions.questType}"/>
                                                    </ice:selectOneMenu>
                                                    <ice:selectOneMenu binding="#{Questionnaire$ManageQuestions.ddnGroup}" disabled="true" id="ddnGroup"
                                                        partialSubmit="true"
                                                        style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 122px; top: 157px; position: absolute; width: 220px" value="#{Questionnaire$ManageQuestions.selectOneMenu3Bean.selectedObject}">
                                                        <f:selectItems id="selectOneMenu3selectItems" value="#{Questionnaire$ManageQuestions.groupList}"/>
                                                    </ice:selectOneMenu>
                                                    <ice:panelLayout binding="#{Questionnaire$ManageQuestions.pnlTblFormat}" id="pnlTblFormat" layout="flow"
                                                        style="border-width: 1px; height: 309px; left: 24px; top: 288px; position: absolute; visibility: visible; width: 645px; -rave-layout: grid"
                                                        styleClass="insideContainerMain" visible="true">
                                                        <ice:outputLabel id="outputLabel1" style="left: 15px; top: 12px; position: absolute" value="Column Name"/>
                                                        <ice:selectOneMenu binding="#{Questionnaire$ManageQuestions.ddnColType}" disabled="true" id="ddnColType"
                                                            partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; width: 190px;left: 94px; top: 49px; position: absolute"
                                                            value="#{Questionnaire$ManageQuestions.selectOneMenu4Bean.selectedObject}" valueChangeListener="#{Questionnaire$ManageQuestions.ddnColType_processValueChange}">
                                                            <f:selectItems id="selectOneMenu4selectItems" value="#{Questionnaire$ManageQuestions.columnType}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectOneMenu binding="#{Questionnaire$ManageQuestions.ddnQuestTypeCol}" disabled="true"
                                                            id="ddnQuestTypeCol" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 410px; top: 12px; position: absolute; width: 190px"
                                                            value="#{Questionnaire$ManageQuestions.selectOneMenu5Bean.selectedObject}" valueChangeListener="#{Questionnaire$ManageQuestions.ddnQuestTypeCol_processValueChange}">
                                                            <f:selectItems id="selectOneMenu5selectItems" value="#{Questionnaire$ManageQuestions.questType}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectOneMenu binding="#{Questionnaire$ManageQuestions.ddnGroupCol}" disabled="true"
                                                            id="ddnGroupCol" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 410px; top: 49px; position: absolute; width: 190px" value="#{Questionnaire$ManageQuestions.selectOneMenu6Bean.selectedObject}">
                                                            <f:selectItems id="selectOneMenu6selectItems" value="#{Questionnaire$ManageQuestions.groupList}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputLabel id="outputLabel2" style="left: 320px; top: 12px; position: absolute" value="Question Type"/>
                                                        <ice:outputLabel id="outputLabel3" style="left: 15px; top: 49px; position: absolute" value="Column Type"/>
                                                        <ice:outputLabel id="outputLabel4" style="left: 320px; top: 49px; position: absolute" value="Options"/>
                                                        <ice:outputLabel id="outputLabel5" style="left: 15px; top:86px; position: absolute" value="Order"/>
                                                        <ice:commandButton action="#{Questionnaire$ManageQuestions.btnAddTbl_action}"
                                                            binding="#{Questionnaire$ManageQuestions.btnAddTbl}" disabled="true" id="btnAddTbl"
                                                            style="left: 338px; top: 75px; position: absolute;" value="Add to table"/>
                                                        <ice:inputText binding="#{Questionnaire$ManageQuestions.txtColName}" disabled="true" id="txtColName" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; width: 190px;left: 94px; top: 12px; position: absolute"/>
                                                        <ice:inputText binding="#{Questionnaire$ManageQuestions.txtOrderNo}" disabled="true" id="txtOrderNo" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; width: 50px;left: 94px; top: 86px; position: absolute"/>
                                                        <ice:panelLayout id="panelLayout1" layout="flow" style="height: 170px; left: 15px; top: 120px; position: absolute; width: 607px; -rave-layout: grid">
                                                            <ice:dataTable id="tblQuestionTableFormat"
                                                                style="left: 0px; top: -10px; position: absolute;width:100%"
                                                                value="#{Questionnaire$ManageQuestions.questTblList}" var="currentRow">
                                                                <ice:column id="column1">
                                                                    <ice:outputText id="outputText1" value="#{currentRow['columnName']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText2" value="Column Name"/>
                                                                    </f:facet>
                                                                    <ice:rowSelector id="rowSelectorTblFormat" selectionListener="#{Questionnaire$ManageQuestions.rowSelectorTblFormat_processMyEvent}"/>
                                                                </ice:column>
                                                                <ice:column id="column2">
                                                                    <ice:outputText id="outputText3" value="#{currentRow['columnTypeDesc']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText5" value="Column Type"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="column3">
                                                                    <ice:outputText id="outputText6" value="#{currentRow['questionTypeDesc']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText7" value="Question Type"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="column4">
                                                                    <ice:outputText id="outputText8" value="#{currentRow['optionGroupDesc']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText9" value="Option"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="column5">
                                                                    <ice:outputText id="outputText10" value="#{currentRow['orderNo']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText11" value="Order"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="column16">
                                                                    <ice:commandLink action="#{Questionnaire$ManageQuestions.btnDeleteTbl_action}"
                                                                        id="btnDeleteTbl" value="Delete"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText20" value=""/>
                                                                    </f:facet>
                                                                </ice:column>
                                                            </ice:dataTable>
                                                        </ice:panelLayout>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout binding="#{Questionnaire$ManageQuestions.pnlQuestionColumn}" id="pnlQuestionColumn"
                                                        layout="flow"
                                                        style="border-width: 1px; height: 189px; left: 24px; top: 624px; position: absolute; width: 645px; -rave-layout: grid"
                                                        styleClass="insideContainerMain" visible="true">
                                                        <ice:outputLabel id="lblQuest"
                                                            style="left: 15px; top: 15px; position: absolute; text-align: left; vertical-align: top; width: 56px" value="Questions inTable"/>
                                                        <ice:inputText binding="#{Questionnaire$ManageQuestions.txtColQuest}" disabled="true" id="txtColQuest" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 94px; top: 17px; position: absolute; width: 350px"/>
                                                        <ice:commandButton action="#{Questionnaire$ManageQuestions.btnAddCol_action}"
                                                            binding="#{Questionnaire$ManageQuestions.btnAddCol}" disabled="true" id="btnAddCol"
                                                            style="left: 500px; top: 10px; position: absolute" value="Add to table"/>
                                                        <ice:panelLayout id="panelLayout3" style="height: 127px; left: 94px; top: 62px; position: absolute; width: 407px">
                                                            <ice:dataTable id="tblQuestionColumn" style="left:0;top:-10;width:100%;position:absolute"
                                                                value="#{Questionnaire$ManageQuestions.questColList}" var="currentRow">
                                                                <ice:column groupOn="#{currentRow['columnName']}" id="column22">
                                                                    <ice:outputText id="outputText32" value="#{currentRow['columnName']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText52" value="Column Name"/>
                                                                    </f:facet>
                                                                    <ice:rowSelector id="rowSelectorQuestionColumn" selectionListener="#{Questionnaire$ManageQuestions.rowSelectorQuestionColumn_processMyEvent}"/>
                                                                </ice:column>
                                                                <ice:column id="column6">
                                                                    <ice:outputText id="outputText12" value="#{currentRow['question']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText13" value="Question"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                            </ice:dataTable>
                                                        </ice:panelLayout>
                                                    </ice:panelLayout>
                                                    <ice:selectBooleanCheckbox binding="#{Questionnaire$ManageQuestions.chkTableFormat}" id="chkTableFormat"
                                                        partialSubmit="true" style="left: 358px; top: 122px; position: absolute"
                                                        value="#{Questionnaire$ManageQuestions.selectBooleanCheckbox1Bean.selectedBoolean}" valueChangeListener="#{Questionnaire$ManageQuestions.chkTableFormat_processValueChange}"/>
                                                    <ice:outputLabel id="chkTblFormat" style="left:378px; top: 119px; position: absolute" value="Table Format"/>
                                                    <ice:selectOneMenu binding="#{Questionnaire$ManageQuestions.somQuestionnaire}" disabled="true"
                                                        id="somQuestionnaire" partialSubmit="true"
                                                        style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 122px; top: 239px; position: absolute; width: 220px" value="#{Questionnaire$ManageQuestions.defaultSelectedData2.selectedObject}">
                                                        <f:selectItems id="selectOneMenu1selectItems2" value="#{Questionnaire$ManageQuestions.definedQuesList}"/>
                                                    </ice:selectOneMenu>
                                                    <ice:outputLabel id="outputLabel6" style="left: 24px; top: 240px; position: absolute" value="Questionnaire"/>
                                                </ice:panelLayout>
                                                <ice:panelLayout id="pnlCommandBtn1" layout="flow"
                                                    style="border-width: 1px; border-style: solid; height: 60px; left: 15px; top: 850px; position: absolute; width: 715px; -rave-layout: grid" styleClass="insideContainerMain">
                                                    <ice:commandButton action="#{Questionnaire$ManageQuestions.btnNew_action}"
                                                        binding="#{Questionnaire$ManageQuestions.btnNew}" id="btnNew"
                                                        style="left: 48px; top: 10px; position: absolute; width: 95px" value="New"/>
                                                    <ice:commandButton action="#{Questionnaire$ManageQuestions.btnSave_action}"
                                                        binding="#{Questionnaire$ManageQuestions.btnSave}" disabled="true" id="btnSave"
                                                        style="left: 168px; top: 10px; position: absolute; width: 95px" value="Save"/>
                                                    <ice:commandButton action="#{Questionnaire$ManageQuestions.btnUpdate_action}"
                                                        binding="#{Questionnaire$ManageQuestions.btnUpdate}" disabled="true" id="btnUpdate"
                                                        style="left: 408px; top: 10px; position: absolute; width: 95px" value="Update"/>
                                                    <ice:commandButton action="#{Questionnaire$ManageQuestions.btnEdit_action}"
                                                        binding="#{Questionnaire$ManageQuestions.btnEdit}" disabled="true" id="btnEdit"
                                                        style="left: 288px; top: 10px; position: absolute; width: 95px" value="Edit"/>
                                                    <ice:commandButton action="#{Questionnaire$ManageQuestions.btnDelete_action}"
                                                        binding="#{Questionnaire$ManageQuestions.btnDelete}" disabled="true" id="btnDelete"
                                                        style="left: 528px; top: 10px; position: absolute; width: 95px" value="Delete"/>
                                                </ice:panelLayout>
                                            </ice:panelLayout>
                                        </ice:panelTab>
                                        <ice:panelTab id="pnlTabOptions" label="Manage Options">
                                            <ice:panelLayout id="pnlOptions" layout="flow" style="border-width: 1px; border-style: none; height: 915px; left: 0px; top: 0px; position: relative; width: 100%;overflow: auto;">
                                                <ice:panelLayout id="panelLayout4" layout="flow"
                                                    style="border-width: 1px; height: 166px; left: 15px; top: 24px; position: absolute; width: 715px; -rave-layout: grid" styleClass="insideContainerMain">
                                                    <ice:outputLabel id="outputLabel7" style="left: 24px; top: 15px; position: absolute" value="Group"/>
                                                    <ice:inputText binding="#{Questionnaire$ManageQuestions.txtOption}" id="txtOption" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter;left: 122px; top: 52px; position: absolute;width:220px"/>
                                                    <ice:outputLabel id="option" style="left: 24px; top: 52px; position: absolute" value="outputLabel"/>
                                                    <ice:outputLabel id="outputLabel9" style="left: 24px; top: 89px; position: absolute" value="Value"/>
                                                    <ice:inputText binding="#{Questionnaire$ManageQuestions.txtOptionValue}" id="txtOptionValue" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter;left: 122px; top: 89px; position: absolute;width:220px"/>
                                                    <ice:commandButton action="#{Questionnaire$ManageQuestions.btnAddOption_action}"
                                                        binding="#{Questionnaire$ManageQuestions.btnAddOption}" id="btnAddOption"
                                                        style="left: 122px; top: 120px; position: absolute" value="Add to Table"/>
                                                    <ice:selectOneMenu binding="#{Questionnaire$ManageQuestions.ddnOptionGroup}" id="ddnOptionGroup"
                                                        partialSubmit="true"
                                                        style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 122px; top: 15px; position: absolute; width: 220px" value="#{Questionnaire$ManageQuestions.defaultSelectedData1.selectedObject}">
                                                        <f:selectItems id="selectOneMenu1selectItems1" value="#{Questionnaire$ManageQuestions.groupList}"/>
                                                    </ice:selectOneMenu>
                                                    <ice:commandButton action="#{Questionnaire$ManageQuestions.btnGroup_action}"
                                                        binding="#{Questionnaire$ManageQuestions.btnGroup}" id="btnGroup"
                                                        style="left: 350px; top: 5px; position: absolute" value=". . ."/>
                                                </ice:panelLayout>
                                                <ice:panelLayout id="pnlOption"
                                                    style="height: 615px; left: 15px; top: 212px; position: absolute; width: 715px; overflow: auto;" styleClass="insideContainerMain">
                                                    <ice:dataTable id="tblOption" style="left:0;top:-10;width:100%;position:absolute"
                                                        value="#{Questionnaire$ManageQuestions.optionManagerList}" var="currentRow">
                                                        <ice:column groupOn="#{currentRow['groupDesc']}" id="column13">
                                                            <ice:outputText id="outputText27" value="#{currentRow['groupDesc']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText28" value="Group"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column14">
                                                            <ice:outputText id="outputText29" value="#{currentRow['optionName']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText30" value="Options"/>
                                                            </f:facet>
                                                            <ice:rowSelector id="rowSelectorOption" immediate="true"
                                                                selectionListener="#{Questionnaire$ManageQuestions.rowSelectorOption_processMyEvent}" value="#{currentRow['selected']}"/>
                                                        </ice:column>
                                                        <ice:column id="column15">
                                                            <ice:outputText id="outputText31" value="#{currentRow['value']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText32" value="Value"/>
                                                            </f:facet>
                                                        </ice:column>
                                                    </ice:dataTable>
                                                </ice:panelLayout>
                                                <ice:panelLayout id="pnlCommandBtn2" layout="flow"
                                                    style="border-width: 1px; border-style: solid; height: 60px; left: 15px; top: 850px; position: absolute; width: 715px; -rave-layout: grid" styleClass="insideContainerMain">
                                                    <ice:commandButton action="#{Questionnaire$ManageQuestions.btnNewEditOpt_action}"
                                                        binding="#{Questionnaire$ManageQuestions.btnNewEditOpt}" id="btnNewEditOpt"
                                                        style="left: 108px; top: 10px; position: absolute; width: 95px" value="New/Edit"/>
                                                    <ice:commandButton action="#{Questionnaire$ManageQuestions.btnDeleteOption_action}"
                                                        binding="#{Questionnaire$ManageQuestions.btnDeleteOption}" id="btnDeleteOption"
                                                        style="left: 368px; top: 10px; position: absolute; width: 95px" value="Delete Option"/>
                                                    <ice:commandButton action="#{Questionnaire$ManageQuestions.btnSaveUpdateOpt_action}"
                                                        binding="#{Questionnaire$ManageQuestions.btnSaveUpdateOpt}" id="btnSaveUpdateOpt"
                                                        style="left: 238px; top: 10px; position: absolute; width: 95px" value="Save/Update"/>
                                                    <ice:commandButton action="#{Questionnaire$ManageQuestions.btnDeleteGroup_action}"
                                                        binding="#{Questionnaire$ManageQuestions.btnDeleteGroup}" id="btnDeleteGroup"
                                                        style="left: 498px; top: 10px; position: absolute; width: 95px" value="Delete Group"/>
                                                </ice:panelLayout>
                                            </ice:panelLayout>
                                        </ice:panelTab>
                                    </ice:panelTabSet>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="south">
                            <ice:panelGroup id="page_footer" style=" text-align: center;">
                                <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">This is the Footer</ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelBorder>
                    <ice:panelPopup autoCentre="true" binding="#{Questionnaire$ManageQuestions.pnlPopUpGroup}" draggable="true" id="pnlPopUpGroup"
                        rendered="false" style="width: 210px" visible="#{Questionnaire$ManageQuestions.panelPopup1Bean.showModalPanel}">
                        <f:facet name="header">
                            <ice:panelGrid id="panelGrid3" style="display:block;width:180px;height:20px;">
                                <ice:outputText id="outputText26" value="Manage Group"/>
                                <ice:commandLink action="#{Questionnaire$ManageQuestions.cmdCloseDeleete_action}" id="cmdCloseDeleete" immediate="true"
                                    style="background-image: url(../resources/close_icon.gif); height: 15px; left: 220px; top: 0px; z-index:2px; position: absolute; width: 19px"
                                    styleClass="popupHeaderImage" title="Close Popup"/>
                            </ice:panelGrid>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGrid columns="2" id="pnlPopUpBody"
                                style="display: block; height: 80px; text-align: center; vertical-align: middle; width: 220px" styleClass="icePnlGrp iceDatTblColHdr">
                                <ice:outputLabel id="outputLabel8" style="width: 70px" value="Group Name"/>
                                <ice:inputText binding="#{Questionnaire$ManageQuestions.txtGroupName}" id="txtGroupName" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; width: 150"/>
                                <ice:commandButton action="#{Questionnaire$ManageQuestions.btnGroupNew_action}"
                                    binding="#{Questionnaire$ManageQuestions.btnGroupNew}" id="btnGroupNew" style="left:28px; text-align: center" value="New"/>
                                <ice:commandButton action="#{Questionnaire$ManageQuestions.btnGroupUpdate_action}"
                                    binding="#{Questionnaire$ManageQuestions.btnGroupUpdate}" id="btnGroupUpdate" value="Update"/>
                            </ice:panelGrid>
                        </f:facet>
                    </ice:panelPopup>
                    <ice:panelPopup autoCentre="true" binding="#{Questionnaire$ManageQuestions.pnMessage}" clientOnly="true" draggable="false" id="pnMessage"
                        modal="false" rendered="false"
                        style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                        <f:facet name="header">
                            <ice:panelGroup id="pnlgridpnMessage" style="background-color:#333333; height: 20px; padding-top: 8px; width: 672px">
                                <ice:outputText id="pnMessageTitle"
                                    style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="National Bank of Ethiopia Human Resource Management And Integrated Payroll System:Message"/>
                                <ice:commandLink action="#{Questionnaire$ManageQuestions.modalPnlCloseMesssage_action}" id="modalPnlCloseMesssage"
                                    immediate="true"
                                    style="background-image: url(../resources/close_icon.gif); height: 19px; left: 735px; top: 20px; position: absolute; width: 19px"
                                    styleClass="popupHeaderImage" title="Close Popup"/>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGroup id="panelGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                <ice:panelLayout id="pnlMessageBody" layout="flow"
                                    style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                    <h:outputLabel binding="#{Questionnaire$ManageQuestions.lblFormMessage}" id="lblFormMessage" style="background-color: #F5F5F5;"/>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelPopup>
                    <ice:panelPopup autoCentre="true" binding="#{Questionnaire$ManageQuestions.panelPopup}" draggable="true" id="panelPopup" modal="true"
                        rendered="false"
                        style="border-style: none; background-color: transparent; display: block; height: 120px; left: 96px; top: 936px; position: absolute; width: 751px" styleClass="message">
                        <f:facet name="header">
                            <ice:panelGrid id="panelGrid11" style="background-color:#333333; height: 20px; padding-top: 8px; width: 672px">
                                <ice:outputText id="outputText10"
                                    style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="National Bank of Ethiopia Human Resource Management And Integrated Payroll System:Message"/>
                                <ice:commandLink id="cmdConfirmationCloseDeleete" immediate="true"
                                    style="background-image: url(../resources/close_icon.gif); height: 19px; left: 744px; top: 15px; position: absolute; width: 19px"
                                    styleClass="popupHeaderImage" title="Close Popup"/>
                            </ice:panelGrid>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGroup id="panelConfirmationDelete" style="display: block; height: 60px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                <ice:panelLayout id="pnlConfirmationDeleteBody" layout="flow"
                                    style="background-color: rgb(245, 245, 245); display: block; height: 35px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                    <h:outputLabel id="lblFormDeleteMessage"
                                        style="color: green; font-size: 12px; font-weight: bold; left: 24px; top: 24px; position: absolute; text-align: center; vertical-align: middle" value="ARE YOU SURE YOU WANT TO DELETE JOB ?"/>
                                    <ice:commandButton action="#{Questionnaire$ManageQuestions.bntYES_action}" id="bntYES"
                                        style="left: 360px; top: 14px; position: absolute; width: 80px" value="Yes"/>
                                    <ice:commandButton action="#{Questionnaire$ManageQuestions.btnNo_action}" id="btnNo"
                                        style="left: 456px; top: 14px; position: absolute; width: 80px" value="No"/>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelPopup>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
