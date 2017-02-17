<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2010, 7:48:31 AM
    Author     : BravoZulu
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <f:loadBundle basename="Localization.HRLocalization" var="msgs"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title></title>
                <ice:outputStyle href="../resources/stylesheet.css" id="outputStyleJob"/>
                <ice:outputStyle href="../xmlhttp/css/rime/rime.css"/>
                <ice:outputStyle href="../resources/TempCSS.css"/>
                <script src="../Script/Ethiopian_Calendar.js"></script>
                <script src="../Script/jquery-1.3.2.min.js"></script>
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
                <script language="javascript" type="text/javascript">
                    var $j=jQuery.noConflict();
                    function PromoteEmployee(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div style="width:100%">
                        <img alt="" class="source-image" id="img" src="../resources/images/WholePageBG.png" width="100%"/>
                        <ice:panelBorder height="280" id="whole_page" renderCenter="#{Organization$JobType.panelBorder1Bean.renderCenter}"
                            renderEast="#{Organization$JobType.panelBorder1Bean.renderEast}" renderNorth="#{Organization$JobType.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Organization$JobType.panelBorder1Bean.renderSouth}" renderWest="#{Organization$JobType.panelBorder1Bean.renderWest}"
                            style="top: 5px; position: relative" styleClass="whole_page" width="1024">
                            <f:facet name="north">
                                <ice:panelGroup dragListener="#{Organization$JobType.panelBorder1north_processMyEvent}" id="page_header" style="height: 117px">
                                    <!-- Begin Header -->
                                    <ice:panelLayout id="header" layout="flow"
                                        style="height: 129px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="header" visible="true">
                                        <jsp:directive.include file="/Header.jspf"/>
                                    </ice:panelLayout>
                                    <!-- End Header -->
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="west">
                                <ice:panelLayout id="left_menu1" layout="flow"
                                    style="height: 212px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                    <ice:panelLayout id="list_menu2" style="height: 315px; left: 0px; top: 24px; position: absolute; width: 213px" styleClass="left_menu">
                                        <ice:panelCollapsible expanded="true" id="panelCollapsible1">
                                            <f:facet name="header">
                                                <ice:panelGroup id="panelGroup1" styleClass="">
                                                    <ice:outputText id="lblCommonTasks" value="Common Tasks"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid headerClass="iceDatTblColHdr1" id="panelGrid2" width="100%">
                                                <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                    <li>
                                                        <ice:commandLink action="#{Organization$JobType.cmdJobType_action}" id="cmdJobType" immediate="true"
                                                            partialSubmit="true" style="color:#306682;font-weight:bold" value="JobType"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Organization$JobType.cmdOrganizationStructur_action}"
                                                            id="cmdOrganizationStructur" immediate="true" partialSubmit="true"
                                                            style="color:#306682;font-weight:bold" value="Organization Structur"/>
                                                    </li>
                                                </ul>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                        <ice:panelCollapsible expanded="true" id="panelCollapsible3">
                                            <f:facet name="header">
                                                <ice:panelGroup id="panelGroup2" styleClass="">
                                                    <ice:outputText id="outputText10" value="List of Job Types"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid id="panelGrid3" style="height: 168px">
                                                <ice:selectOneListbox binding="#{Organization$JobType.drlListOfJob}" id="drlListOfJob" partialSubmit="true"
                                                    size="22" style="width: 190px; height 1" value="#{Organization$JobType.defaultSelectedData3.selectedObject}" valueChangeListener="#{Organization$JobType.drlListOfJob_processValueChange}">
                                                    <f:selectItems id="selectOneMenu1selectItems2" value="#{Organization$JobType.listOfJobType}"/>
                                                </ice:selectOneListbox>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                        <ice:panelCollapsible id="panelCollapsible4">
                                            <f:facet name="header">
                                                <ice:panelGroup id="panelGroup3" styleClass="">
                                                    <ice:outputText id="outputText9" value="Notice"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid id="panelGrid4">
                                                <ice:outputText id="outputText11" value="next"/>
                                                <ice:commandButton id="button1" image="/Organization/image/btn_close.gif" value="submit"/>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                    </ice:panelLayout>
                                </ice:panelLayout>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup dragListener="#{Organization$JobType.page_display_processMyEvent}" id="page_display" style="height: 650px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 360px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <ice:panelLayout id="panelLayout1" style="border-style: none; height: 580px; margin-left: 0px; margin-top: 0px; padding-top: 1px; position: absolute; width: 778px"/>
                                        <fieldset class="filedset_css" style="height: 625px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Job Registration"/>
                                            </legend>
                                            <ice:panelLayout id="PanelLayOutJoBCategory"
                                                style="height: 35px; margin-left: 15px; margin-top: -5px;  position: absolute; width: 744px" styleClass="insideContainerMain">
                                                <ice:selectBooleanCheckbox binding="#{Organization$JobType.choOffice}" id="choOffice" partialSubmit="true"
                                                    style="left: 500px; top: 8px; position: absolute"
                                                    value="#{Organization$JobType.defaultSelectedData4.selectedBoolean}" valueChangeListener="#{Organization$JobType.choOffice_processValueChange}"/>
                                                <ice:selectBooleanCheckbox binding="#{Organization$JobType.choShift}" id="choShift" partialSubmit="true"
                                                    style="left: 570px; top: 8px; position: absolute"
                                                    value="#{Organization$JobType.defaultSelectedData5.selectedBoolean}" valueChangeListener="#{Organization$JobType.choShift_processValueChange}"/>
                                                <ice:outputText id="lblOffice" style="font-size: 10px; left: 520px; top: 10px; position: absolute" value="Normal"/>
                                                <ice:outputText id="lblShift" style="font-size: 10px; left: 590px; top: 10px; position: absolute" value="Shift"/>
                                                <ice:outputText id="lblCategory"
                                                    style="color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 20px; top: 10px; position: absolute" value="Select Category: "/>
                                            </ice:panelLayout>
                                            <ice:panelLayout id="PanelLayOutJobAtrributes"
                                                style="height: 160px; margin-left: 15px; margin-top: 40px;  position: absolute; width: 744px" styleClass="insideContainerMain">
                                                <ice:outputText id="lblJobCode" style="font-size: 10px; left: 31px; top: 10px; position: absolute" value="Job Code:"/>
                                                <ice:inputText action="#{Organization$JobType.txtJobCode_action}" binding="#{Organization$JobType.txtJobCode}"
                                                    disabled="true" id="txtJobCode" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 133px; top: 10px; position: absolute; width: 190px"/>
                                                <ice:outputText id="lblJobName" style="font-size: 10px; left: 31px; top: 50px; position: absolute" value=" Job  Name:"/>
                                                <ice:inputText binding="#{Organization$JobType.txtJobName}" id="txtJobName" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 133px; top: 50px; position: absolute; width: 190px"/>
                                                <ice:outputText id="lblresponsibility" style="font-size: 10px; left: 31px; top: 90px; position: absolute" value="Responsibility:"/>
                                                <ice:inputTextarea binding="#{Organization$JobType.txtaJobResponsiblity}" id="txtaJobResponsiblity" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 133px; top: 90px; position: absolute; width: 190px"/>
                                                <ice:outputText id="lblRank" style="font-size: 10px; left: 405px; top: 10px; position: absolute" value="Rank:"/>
                                                <ice:selectOneMenu binding="#{Organization$JobType.drlRank}" id="drlRank" partialSubmit="true"
                                                    style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 512px; top: 10px; position: absolute; width: 190px" value="#{Organization$JobType.selectOneMenu1Bean.selectedObject}">
                                                    <f:selectItems id="selectOneMenu1selectItems" value="#{Organization$JobType.rankListOpt}"/>
                                                </ice:selectOneMenu>
                                                <ice:outputText id="lblAdditionalSkills" style="font-size: 10px; left: 405px; top: 50px; position: absolute" value="Additional Skills:"/>
                                                <ice:inputTextarea binding="#{Organization$JobType.txtAAdditionalSkill}" id="txtAAdditionalSkill" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 512px; top: 50px; position: absolute;   width: 190px"/>
                                                <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtJobName" id="message2"
                                                    infoClass="infoMessage" style="font-size: 10px; left: 327px; top: 10px; position: absolute" warnClass="warnMessage"/>
                                                <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtaJobResponsiblity" id="message3"
                                                    infoClass="infoMessage" style="font-size: 10px; left: 170px; top: 90px; position: absolute" warnClass="warnMessage"/>
                                                <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlRank" id="message4"
                                                    infoClass="infoMessage" style="font-size: 10px; left: 280px; top: 10px; position: absolute" warnClass="warnMessage"/>
                                                <ice:outputText binding="#{Organization$JobType.lblConfirmation}" id="lblConfirmation" rendered="false"
                                                    style="font-size: 14px; left: 40px; top: 0px; position: absolute" value="outputText"/>
                                                <ice:outputText binding="#{Organization$JobType.lblErrorMessage}" id="lblErrorMessage" rendered="false"
                                                    style="color: red; font-size: 10px; font-weight: bold; left: 640px; top: 0px; position: absolute" value="outputText"/>
                                            </ice:panelLayout>
                                            <ice:panelLayout id="PanelLayOutJobSpecificAtrributes"
                                                style="height: 90px; margin-left: 15px; margin-top: 210px;  position: absolute; width: 744px" styleClass="insideContainerMain">
                                                <ice:outputText id="lblQualification" style="font-size: 10px; left: 405px; top: 10px; position: absolute" value="Qualification:"/>
                                                <ice:inputTextarea binding="#{Organization$JobType.txtAQualification}" id="txtAQualification" rendered="false" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 512px; top: 10px; position: absolute; height:23px; width: 190px"/>
                                                <ice:selectOneMenu binding="#{Organization$JobType.selectOneMenu1Qualification}"
                                                    id="selectOneMenu1Qualification" partialSubmit="true"
                                                    style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 512px; top: 10px; position: absolute; width: 190px"
                                                    value="#{Organization$JobType.defaultSelectedData7.selectedObject}" valueChangeListener="#{Organization$JobType.selectOneMenu1Qualification_processValueChange}">
                                                    <f:selectItems id="selectOneMenu1selectItems1" value="#{Organization$JobType.educTypeOpt}"/>
                                                </ice:selectOneMenu>
                                                <ice:outputText escape="false" id="lblMinimumExperience"
                                                    style="font-size: 10px; left: 408px; top: 48px; position: absolute" value="Minimum Experience:"/>
                                                <ice:inputTextarea binding="#{Organization$JobType.txtminmumExperance}" id="txtminmumExperance" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; height: 23px; left: 512px; top: 46px; position: absolute; width: 190px"/>
                                                <ice:outputText escape="false" id="lblEducationlevelCodeJob"
                                                    style="font-size: 10px; left: 24px; top: 48px; position: absolute" value="#{msgs.LevelOfEducation}"/>
                                                <ice:outputText escape="false" id="lblEducationCatagory"
                                                    style="font-size: 10px; left: 24px; top: 10px; position: absolute" value="Catagory"/>
                                                <ice:selectOneMenu binding="#{Organization$JobType.drlLevelOfEducation}" id="drlLevelOfEducation"
                                                    partialSubmit="true" required="true"
                                                    style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 118px; top: 46px; position: absolute; width: 190px" value="#{Employee$EmployeePage.defaultSelectedData29.selectedObject}">
                                                    <f:selectItems id="selectOneMenu1selectItems3" value="#{Organization$JobType.educLevelOpt}"/>
                                                </ice:selectOneMenu>
                                                <ice:inputText binding="#{Organization$JobType.inputTextEducLevelID}" id="inputTextEducLevelID" rendered="false"/>
                                                <ice:inputText binding="#{Organization$JobType.inputTextQualificationID}" id="inputTextQualificationID" rendered="false"/>
                                                <ice:selectOneMenu binding="#{Organization$JobType.drlEducationCatagory}" id="drlEducationCatagory"
                                                    partialSubmit="true"
                                                    style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 118px; top: 10px; position: absolute; width: 190px"
                                                    value="#{Organization$JobType.defaultSelectedData8.selectedObject}" valueChangeListener="#{Organization$JobType.drlEducationCatagory_processValueChange}">
                                                    <f:selectItems id="selectOneMenu1selectItems4" value="#{Organization$JobType.educCatagoryOpt}"/>
                                                </ice:selectOneMenu>
                                            </ice:panelLayout>
                                            <ice:panelLayout id="PanelLayOutJobSpecificAtrributesAddChoose"
                                                style="height: 40px; margin-left: 15px; margin-top: 310px; overflow: auto;  position: absolute; width: 744px" styleClass="insideContainerMain">
                                                <ice:commandButton action="#{Organization$JobType.btnAddToTable_action}" id="btnAddToTable"
                                                    style="margin-left: 10px; top:-4px; width: 100px; position: absolute" value="Add To Table"/>
                                                <ice:selectBooleanCheckbox binding="#{Organization$JobType.selectBooleanCheckbox1Choice}" disabled="true"
                                                    id="selectBooleanCheckbox1Choice" partialSubmit="true"
                                                    style="margin-left: 280px; top: 17px; position: absolute; width: 15px" value="#{Organization$JobType.defaultSelectedData6.selectedBoolean}"/>
                                                <ice:outputText id="lblChoiceIndicator" style="font-size: 10px; left: 300px; top: 16px; position: absolute" value="Select this Check Box to insert Education Level, Experience and Qualification."/>
                                            </ice:panelLayout>
                                            <ice:panelLayout id="PanelLayOutJobSpecificAtrributesAdd"
                                                style="height: 150px; margin-left: 15px; margin-top: 360px; overflow: auto;  position: absolute; width: 744px" styleClass="insideContainerMain">
                                                <ice:dataTable id="dataTableRequirmentAndSkill" style="left: 0px; top: -10px; position: absolute"
                                                    value="#{Organization$JobType.specificEducationLevel}" var="currentRow" width="525">
                                                    <ice:column id="column4EducationLevel">
                                                        <ice:outputText id="outputText3EducationLevel" value="#{currentRow['levelOfEducation']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText7EducationLevel" value="Level Of Education"/>
                                                        </f:facet>
                                                        <ice:rowSelector binding="#{Organization$JobType.rowSelectorSpecificEducationLevel}"
                                                            id="rowSelectorSpecificEducationLevel" multiple="false" preStyleOnSelection="true"
                                                            selectionListener="#{Organization$JobType.rowSelectorSpecificEducationLevel_processMyEvent}"
                                                            toggleOnClick="true" value="#{currentRow['selected']}"/>
                                                    </ice:column>
                                                    <ice:column groupOn="#{currentRow['levelOfEducation']}" id="column5">
                                                        <ice:outputText id="outputText12" value="#{currentRow['minimumExperiance']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText13" value="Minimum Experience"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column5EducationLevelID" rendered="false">
                                                        <ice:outputText id="outputText12EducationLevelID" value="#{currentRow['levelOfEducationID']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText13EducationLevelID" value="EducationLevelID"/>
                                                        </f:facet>
                                                    </ice:column>
                                                </ice:dataTable>
                                                <ice:dataTable id="dataTable2QUalification" style="left: 525px; top: -10px; position: absolute"
                                                    value="#{Organization$JobType.specificQualification}" var="currentRow" width="200">
                                                    <ice:column id="column4">
                                                        <ice:outputText id="outputText3" value="#{currentRow['qualifcation']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText7" value="Qualification"/>
                                                        </f:facet>
                                                        <ice:rowSelector binding="#{Organization$JobType.rowSelectorSpecificQualification}"
                                                            id="rowSelectorSpecificQualification" multiple="false" preStyleOnSelection="true"
                                                            selectionListener="#{Organization$JobType.rowSelectorSpecificQualification_processMyEvent}"
                                                            toggleOnClick="true" value="#{currentRow['selected1']}"/>
                                                    </ice:column>
                                                    <ice:column id="column5QualificationlID" rendered="false">
                                                        <ice:outputText id="outputText12QualificationID" value="#{currentRow['jobQualificationID']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText13QualificationID" value="QualificationID"/>
                                                        </f:facet>
                                                    </ice:column>
                                                </ice:dataTable>
                                            </ice:panelLayout>
                                            <ice:panelLayout id="PanelLayOutJobButtons"
                                                style="height: 50px; margin-left: 15px; margin-top: 520px;  position: absolute; width: 744px" styleClass="insideContainerMain">
                                                <ice:commandButton action="#{Organization$JobType.btnSave_action}" binding="#{Organization$JobType.btnSave}"
                                                    id="btnSave" style="margin-left: 120px; width: 80px" value="New"/>
                                                <ice:commandButton action="#{Organization$JobType.btnSaveSave_action}" id="btnSaveSave"
                                                    style="margin-left: 10px; width: 80px" value="Save"/>
                                                <ice:commandButton action="#{Organization$JobType.btnUpdate_action}" binding="#{Organization$JobType.btnUpdate}"
                                                    id="btnUpdate" style="margin-left: 10px; width: 80px" value="Edit"/>
                                                <ice:commandButton action="#{Organization$JobType.btnUpdateUpdate_action}"
                                                    binding="#{Organization$JobType.btnUpdateUpdate}" id="btnUpdateUpdate"
                                                    style="margin-left: 10px; width: 80px" value="Update"/>
                                                <ice:commandButton action="#{Organization$JobType.btnReset_action}"
                                                    actionListener="#{Organization$JobType.btnReset_processAction}" binding="#{Organization$JobType.btnReset}"
                                                    id="btnReset" immediate="true" partialSubmit="true" style="margin-left: 10px; width: 80px" value=" #{msgs.cmdReset}"/>
                                                <ice:commandButton action="#{Organization$JobType.btnDelete_action}"
                                                    actionListener="#{Organization$JobType.btnDelete_processAction}" binding="#{Organization$JobType.btnDelete}"
                                                    id="btnDelete" style="margin-left: 10px; width: 80px" value=" #{msgs.cmdDelete}"/>
                                            </ice:panelLayout>
                                        </fieldset>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="south">
                                <ice:panelGroup id="page_footer" style=" text-align: left;">
                                    <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">
                                        <label style="margin-left:20px;color:white;font-weight:bold;font-family:Narkisim">BUNNA INTERNATIONAL BANK.Human Resource Management System.</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <!--////////////////////////////////////////////////////////////////Start POpUp ////////////////////////////////////////////////////////////-->
                        <ice:panelPopup autoCentre="true" binding="#{Organization$JobType.poupExperience}" draggable="true" id="poupExperience" modal="true"
                            rendered="false" style="height: 271px; left: 10%; top: 20%; position: absolute; width: 600px; z-index: 1000" visible="#{Organization$JobType.panelPopup1Bean.showModalPanel}">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGrid1" style="text-align: left; width: 598px;left=1px">
                                    <ice:outputText id="lblHeaderExperience" value="Experience"/>
                                    <ice:commandButton actionListener="#{Organization$JobType.btnExperiance_processAction}"
                                        binding="#{Organization$JobType.btnExperiance}" id="btnExperiance" image="/Organization/image/btn_close.gif"
                                        style="left: 570px; top: 5px; position: absolute; width: 20px" value="submit"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGrid cellpadding="0" cellspacing="0" columns="1" id="lyGridBody" style="background-color: rgb(255, 255, 255); height: 220px; left: 0px; width: 560px;">
                                    <ice:panelLayout id="lybody" style="top:40px;position: absolute; height: 100px; left: 10px; width: 560px; ">
                                        <ice:commandButton actionListener="#{Organization$JobType.btnAdd_processAction}"
                                            binding="#{Organization$JobType.btnAdd}" id="btnAdd" immediate="true"
                                            style="left: 240px; top: 44px; position: absolute; width: 80px" value="Add"/>
                                        <ice:outputText escape="false" id="lblPostion" style="left: 35px; top: 17px; position: absolute" value="Position:"/>
                                        <ice:inputText binding="#{Organization$JobType.txtPosition}" id="txtPosition" style="left: 110px; top: 15px; position: absolute; width: 155px"/>
                                        <ice:outputText id="lblNoOfYear" style="left: 320px; top: 18px; position: absolute" value="No of Year:"/>
                                        <ice:selectOneMenu binding="#{Organization$JobType.drlNUmberOfYear}" id="drlNUmberOfYear" partialSubmit="true"
                                            style="height: 22px; left: 420px; top: 15px; bottom: 450px; position: absolute; width: 20px" value="#{Organization$JobType.selectOneMenu2Bean.selectedObject}">
                                            <f:selectItems id="selectOneMenu2selectItems" value="#{Organization$JobType.jobMinExperiance}"/>
                                        </ice:selectOneMenu>
                                        <ice:selectBooleanCheckbox binding="#{Organization$JobType.cboAnd}" id="cboAnd" partialSubmit="true"
                                            style="font-family: Verdana,Arial,Helvetica,sans-serif; font-size: 12px; left: 110px; top: 50px; position: absolute"
                                            value="#{Organization$JobType.selectBooleanCheckbox2Bean.selectedBoolean}" valueChangeListener="#{Organization$JobType.cboAnd_processValueChange}"/>
                                        <ice:selectBooleanCheckbox binding="#{Organization$JobType.cboOr}" id="cboOr" partialSubmit="true"
                                            style="font-family: 'Verdana','Arial','Helvetica',sans-serif; font-size: 12px; left: 169px; top: 50px; position: absolute" value="#{Organization$JobType.selectBooleanCheckbox1Bean.selectedBoolean}"/>
                                        <ice:outputText id="outputText1"
                                            style="font-family: 'Verdana','Arial','Helvetica',sans-serif; font-size: 12px; left: 80px; top: 49px; position: absolute" value="And"/>
                                        <ice:outputText id="outputText2"
                                            style="font-family: 'Verdana','Arial','Helvetica',sans-serif; font-size: 12px; left: 148px; top: 50px; position: absolute" value="Or"/>
                                    </ice:panelLayout>
                                    <ice:panelLayout id="lyTable" style="border-top: solid rgb(0, 0, 0) 1px; height: 150px; left: 20px; top: 125px; position: absolute; width: 560px">
                                        <ice:dataTable id="dataTable1" rows="1" style="left: 150px; top: 0px; position: absolute"
                                            value="#{SessionBean1.minExperiance}" var="currentRow">
                                            <ice:column id="column1">
                                                <ice:outputText id="txtPosition" value="#{currentRow['position']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText4" value="Position"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column2">
                                                <ice:outputText id="outputText5" value="#{currentRow['NUmberOfYear']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText6" value="NUmberOfYear"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column3">
                                                <h:commandLink id="linkEdit" style="color:#3b5998" value="Edit"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText8" value="Edit"/>
                                                </f:facet>
                                            </ice:column>
                                        </ice:dataTable>
                                        <ice:dataPaginator for="dataTable1" id="scroll" paginator="#{true}" paginatorMaxPages="10"
                                            style="margin-left: 220px;margin-top: 60px" styleClass="carNumber" vertical="#{false}">
                                            <f:facet name="first">
                                                <ice:graphicImage id="first1" style="border:none;" url="../xmlhttp/css/rime/css-images/arrow-first.gif"/>
                                            </f:facet>
                                            <f:facet name="last">
                                                <ice:graphicImage id="last1" style="border:none;" url="../xmlhttp/css/rime/css-images/arrow-last.gif"/>
                                            </f:facet>
                                            <f:facet name="previous">
                                                <ice:graphicImage id="previous1" style="border:none;" url="../xmlhttp/css/rime/css-images/arrow-previous.gif"/>
                                            </f:facet>
                                            <f:facet name="next">
                                                <ice:graphicImage id="next1" style="border:none;" url="../xmlhttp/css/rime/css-images/arrow-next.gif"/>
                                            </f:facet>
                                        </ice:dataPaginator>
                                    </ice:panelLayout>
                                    <ice:panelLayout id="lyExperianceButton" style="left: 156px; top: 205px; position: absolute; width: 560px">
                                        <ice:commandButton actionListener="#{Organization$JobType.btnSaveExperance_processAction}" id="btnSaveExperance"
                                            style="margin-left: 0px; width: 60px" value="Save"/>
                                        <ice:commandButton id="btnEditExperiance" style="margin-left: 20px; width: 60px" value="Edit"/>
                                        <ice:commandButton id="btnClearExperiance" style="margin-left: 20px; width: 60px" value="Reset"/>
                                        <ice:commandButton id="btnDeleteExperiance" style="margin-left: 20px; width: 60px" value="Delete"/>
                                    </ice:panelLayout>
                                </ice:panelGrid>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Organization$JobType.pnlPopupSuccessOrFailure}" clientOnly="true" draggable="false"
                            id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 3px; top: 80px; position: absolute; width: 667px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Organization$JobType.btnClosePopupSuccessOrFailure_action}" id="btnClosePopupSuccessOrFailure"
                                        immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 700px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Organization$JobType.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Organization$JobType.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Organization$JobType.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
