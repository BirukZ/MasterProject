<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Questionnaire_1
    Created on : Feb 20, 2012, 4:56:38 PM
    Author     : Bini
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <f:loadBundle basename="Localization.HRLocalization" var="msgs"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Questionnaire</title>Company Profile Module Development
                <ice:outputStyle href="../resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="../xmlhttp/css/rime/rime.css"/>
                <ice:outputStyle href="../resources/ETH/KAMSI_CAL_STYLE.css" id="outputStyle22"/>
                <ice:outputStyle href="../resources/TempCSS.css"/>
                <script src="../Script/jquery-1.3.2.min.js"></script>
                <script src="../resources/ETH/KAMSI_CAL_SCRIPT.js"></script>
                <script language="javascript" type="text/javascript">
                    var GenerateQuestionnairs=jQuery.noConflict();
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
                    table.people {
                        width: 100%;
                        border-collapse: collapse; /* so we can control cellspacing in a practical way */
                        border-bottom:0; /* you may not want the bottom of your table have spacing */
                    }

                    table.people th,
                    table.people td {
                        padding: 5px;
                        text-align: left;
                        font-family: Arial, Verdana, sans-serif;
                        border: 4px solid #000; /* this can be seen as cellspacing... */
                        border-bottom:0;
                    }

                    /* you may not want the top of your table have spacing */
                    table.people th {
                        border-top: 0;
                    }

                    /* you may not want the left most and right most side of your table have spacing */
                    table.people th.first,
                    table.people td.name {
                        border-left: 0;
                    }

                    table.people th.last,
                    table.people td.dateOfBirth {
                        border-right: 0;
                    }

                    table.people th {
                        background-color: #ddd;
                        color: #BB0000;
                    }

                    table.people tr.odd {
                        background-color: #DDFFFF;
                    }

                    table.people tr.even {
                        background-color: #FBFBFB;
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
                                    <ice:panelLayout id="list_menu2"
                                        style="border-style: none; height: 100px; left: 0px; top: 24px; position: absolute; width: 213px" styleClass="left_menu">
                                        <ice:panelCollapsible expanded="true" id="panelCollapsible1" immediate="true" style="top:15px;border:none">
                                            <f:facet name="header">
                                                <ice:panelGroup id="panelGroup1" styleClass="">
                                                    <ice:outputText id="lblRecruitmentRequest" value="Common Tasks"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid headerClass="iceDatTblColHdr1" id="panelGrid1" style="border:none" width="100%">
                                                <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                    <li>
                                                        <ice:commandLink action="#{Questionnaire$GenerateQuestionnairs.cmdQuestions_action}" id="cmdQuestions"
                                                            immediate="true" partialSubmit="true"
                                                            style="color: rgb(48, 102, 130); font-weight: bold; text-align: left" value="Manage Questions"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Questionnaire$GenerateQuestionnairs.cmdAssignQuestionnaire_action}"
                                                            id="cmdAssignQuestionnaire" immediate="true" partialSubmit="true"
                                                            style="color: rgb(48, 102, 130); font-weight: bold; text-align: left" value="Assign Questionnaire"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Questionnaire$GenerateQuestionnairs.cmdAnalyzeGrading_action}"
                                                            id="cmdAnalyzeGrading" immediate="true" partialSubmit="true" style="color: rgb(48, 102, 130); font-weight: bold; text-align: left"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Questionnaire$GenerateQuestionnairs.cmdAnalyzeReGrading_action}"
                                                            id="cmdAnalyzeReGrading" immediate="true" partialSubmit="true" style="color: rgb(48, 102, 130); font-weight: bold; text-align: left"/>
                                                    </li>
                                                </ul>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                        <ice:panelCollapsible expanded="true" id="panelCollapsible3">
                                            <f:facet name="header">
                                                <ice:panelGroup id="panelGroup2" styleClass="">
                                                    <ice:outputText id="outputText4" value="List of Events"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid headerClass="iceDatTblColHdr1" id="panelGrid2" style="border:none" width="100%">
                                                <ice:selectOneListbox binding="#{Questionnaire$GenerateQuestionnairs.lstActiveQuest}" id="lstActiveQuest"
                                                    partialSubmit="true" size="10" style=" border: 1px solid #73b3ce;width:125px;"
                                                    value="#{Questionnaire$GenerateQuestionnairs.selectOneListbox2Bean.selectedObject}" valueChangeListener="#{Questionnaire$GenerateQuestionnairs.lstActiveQuest_processValueChange}">
                                                    <f:selectItems id="selectOneListbox1selectItems" value="#{Questionnaire$GenerateQuestionnairs.activeQuestList}"/>
                                                </ice:selectOneListbox>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                        <ice:panelCollapsible expanded="true" id="panelCollapsible4">
                                            <f:facet name="header">
                                                <ice:panelGroup id="panelGroup24" styleClass="">
                                                    <ice:outputText id="outputText44" value="List of Answerd Questionnaire"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid headerClass="iceDatTblColHdr1" id="panelGrid24" style="border:none" width="100%">
                                                <ice:selectOneListbox binding="#{Questionnaire$GenerateQuestionnairs.lstAnsweredQuest}" id="lstAnsweredQuest"
                                                    partialSubmit="true" size="10" style=" border: 1px solid #73b3ce;width:125px;"
                                                    value="#{Questionnaire$GenerateQuestionnairs.selectOneListbox1Bean.selectedObject}" valueChangeListener="#{Questionnaire$GenerateQuestionnairs.lstAnsweredQuest_processValueChange}">
                                                    <f:selectItems id="selectOneListbox1selectItems11" value="#{Questionnaire$GenerateQuestionnairs.answerList}"/>
                                                </ice:selectOneListbox>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                    </ice:panelLayout>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="center">
                            <ice:panelGroup dragListener="#{Questionnaire$Questionnaire.page_display_processMyEvent}" id="page_display" style="height: 1330px">
                                <ice:panelLayout id="container" layout="flow"
                                    style="height: 1300px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                    <ice:panelTabSet binding="#{Questionnaire$GenerateQuestionnairs.panelTabSet}" height="1250" id="panelTabSet"
                                        immediate="true" style="left: 0px; top: 0px; position: absolute; width: 98%" tabPlacement="Top">
                                        <ice:panelTab binding="#{Questionnaire$GenerateQuestionnairs.pnlTabPage1}" id="pnlTabPage1" label="Page 1">
                                            <ice:panelLayout id="pnlPage1" layout="flow" style="border-width: 1px; border-style: none; height: 1250px; left: 0px; top: 0px; position: relative; width: 100%; -rave-layout: grid">
                                                <ice:outputText id="outputText1" style="font-weight: bold; left: 10px; top: 0px; position: absolute" value="A. Staf and Position Information"/>
                                                <ice:panelLayout id="pnlRequesterinfo1" layout="flow"
                                                    style="height: 166px; left: 8px; top: 24px; overflow: auto; position: absolute; visibility: visible; width: 724px; -rave-layout: grid"
                                                    styleClass="insideContainerMain" visible="true">
                                                    <ice:outputText id="lblSupervisorName1"
                                                        style="font-family: 'Cambria'; left: 24px; top: 12px; position: absolute" value="Name:"/>
                                                    <ice:outputText id="lblDirectorate1"
                                                        style="font-family: 'Cambria'; left: 24px; top: 50px; position: absolute" value="Job Title:"/>
                                                    <ice:outputText id="lblJobTitle1"
                                                        style="font-family: Cambria; left: 360px; top: 12px; position: absolute; text-align: left; vertical-align: top; width: 95px" value="Department:"/>
                                                    <ice:outputText id="lblSpecificUnit1"
                                                        style="font-family: 'Cambria'; left: 360px; top: 50px; position: absolute" value="Grade:"/>
                                                    <ice:outputText id="lblSupervisorName2" rendered="false"
                                                        style="font-family: 'Arial','Helvetica',sans-serif; left: 24px; top: 91px; position: absolute; text-align: left; vertical-align: top; width: 71px" value="ddd"/>
                                                    <ice:outputText id="lblJobTitle2" rendered="false"
                                                        style="font-family: 'Cambria'; left: 360px; top: 91px; position: absolute; text-align: left; vertical-align: top; width: 95px" value="Supervisor's Title:"/>
                                                    <ice:outputText id="lblDirectorate2" rendered="false"
                                                        style="font-family: 'Cambria'; left: 24px; top: 125px; position: absolute; text-align: left; vertical-align: top; width: 141px" value="You have been in your current position for :"/>
                                                    <ice:outputText binding="#{Questionnaire$GenerateQuestionnairs.txtEmpName}" id="txtEmpName" style="border-bottom-style: solid; border-bottom-width: 1px; left: 118px; top: 13px; position: absolute; width: 220px"/>
                                                    <ice:outputText binding="#{Questionnaire$GenerateQuestionnairs.txtEmpJob}" id="txtEmpJob" style="border-bottom-style: solid; border-bottom-width: 1px;  left: 118px; top: 51px; position: absolute; width: 220px"/>
                                                    <ice:outputText binding="#{Questionnaire$GenerateQuestionnairs.txtSupName}" id="txtSupName" rendered="false"
                                                        style="border-bottom-style: solid; border-bottom-width: 1px; left: 118px; top: 91px; position: absolute; width: 220px" value=":"/>
                                                    <ice:outputText binding="#{Questionnaire$GenerateQuestionnairs.txtDirectorate}" id="txtDirectorate" style=" border-bottom-style: solid; border-bottom-width: 1px; left: 454px; top: 15px; position: absolute; width: 220px"/>
                                                    <ice:outputText binding="#{Questionnaire$GenerateQuestionnairs.txtGrade}" id="txtGrade" style=" border-bottom-style: solid; border-bottom-width: 1px; left: 454px; top: 53px; position: absolute; width: 220px"/>
                                                    <ice:outputText binding="#{Questionnaire$GenerateQuestionnairs.txtExperiance}" id="txtExperiance"
                                                        rendered="false" style="border-bottom-style: solid; border-bottom-width: 1px; left: 160px; top: 129px; position: absolute; width: 190px; z-index: 1"/>
                                                    <ice:outputText binding="#{Questionnaire$GenerateQuestionnairs.txtSupJob}" id="txtSupJob" rendered="false"
                                                        style=" border-bottom-style: solid; border-bottom-width: 1px; left: 454px; top: 91px; position: absolute; width: 220px" value=":"/>
                                                    <ice:inputText binding="#{Questionnaire$GenerateQuestionnairs.txtAnsweredOn}" id="txtAnsweredOn" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 118px; top: 94px; position: absolute; width: 220"/>
                                                    <ice:outputText id="lblDirectorate4"
                                                        style="font-family: 'Cambria'; left: 24px; top: 96px; position: absolute" value="Date"/>
                                                    <ice:commandButton action="#{Questionnaire$GenerateQuestionnairs.btnCalAnswered_action}"
                                                        binding="#{Questionnaire$GenerateQuestionnairs.btnCalAnswered}" id="btnCalAnswered"
                                                        image="/resources/images/cal_icon.JPG" immediate="true"
                                                        style="left: 312px; top: 96px; position: absolute" value="submit"/>
                                                </ice:panelLayout>
                                                <ice:selectInputDate binding="#{Questionnaire$GenerateQuestionnairs.calAnswereOn}" id="calAnswereOn"
                                                    rendered="false"
                                                    style="height: 212px; left: 456px; top: 144px; position: absolute; width: 190px; z-index: 1"
                                                    value="#{Questionnaire$GenerateQuestionnairs.selectInputDate1Bean.date1}" valueChangeListener="#{Questionnaire$GenerateQuestionnairs.calAnswereOn_processValueChange}"/>
                                                <ice:outputText id="outputText2" style="font-weight: bold; left: 10px; top: 415px; position: absolute" value="Section One"/>
                                                <ice:panelLayout binding="#{Questionnaire$GenerateQuestionnairs.pnlSectionOne}" id="pnlSectionOne" layout="flow"
                                                    style="border-width: 1px; height: 176px; left: 8px; top: 440px; overflow: auto; position: absolute; width: 724px; -rave-layout: grid" styleClass="insideContainerMain"/>
                                                <ice:outputText id="outputText3" style="font-weight: bold; left: 10px; top: 618px; position: absolute" value="Section Two"/>
                                                <ice:panelLayout binding="#{Questionnaire$GenerateQuestionnairs.pnlSectionTwo}" id="pnlSectionTwo" layout="flow"
                                                    style="border-width: 1px; height: 525px; left: 8px; top: 645px; overflow: auto; position: absolute; width: 724px; -rave-layout: grid"
                                                    styleClass="insideContainerMain" visible="true"/>
                                                <ice:panelLayout id="pnlRequesterinfo2" layout="flow"
                                                    style="height: 195px; left: 8px; top: 220px; overflow: auto; position: absolute; visibility: visible; width: 724px; -rave-layout: grid"
                                                    styleClass="insideContainerMain" visible="true">
                                                    <ice:outputText id="lblSupervisorName3" rendered="false"
                                                        style="font-family: 'Cambria'; left: 24px; top: 12px; position: absolute" value="Questionnaire Id"/>
                                                    <ice:outputText id="lblDirectorate3"
                                                        style="font-family: 'Cambria'; left: 24px; top: 50px; position: absolute" value="Event"/>
                                                    <ice:outputText id="lblSpecificUnit2"
                                                        style="font-family: 'Cambria'; left: 360px; top: 50px; position: absolute" value="Event Description"/>
                                                    <ice:outputText id="lblSupervisorName4"
                                                        style="font-family: 'Arial','Helvetica',sans-serif; left: 24px; top: 91px; position: absolute; text-align: left; vertical-align: top; width: 71px" value="From"/>
                                                    <ice:outputText id="lblJobTitle4"
                                                        style="font-family: 'Cambria'; left: 360px; top: 91px; position: absolute; text-align: left; vertical-align: top; width: 95px" value="To"/>
                                                    <ice:outputText binding="#{Questionnaire$GenerateQuestionnairs.txtQuestionnaireId}" id="txtQuestionnaireId"
                                                        rendered="false"
                                                        style="border-bottom-style: solid; border-bottom-width: 1px; left: 118px; top: 13px; position: absolute; width: 220px" value=":"/>
                                                    <ice:outputText binding="#{Questionnaire$GenerateQuestionnairs.txtQuestJobCode}" id="txtQuestJobCode"
                                                        style="border-bottom-style: solid; border-bottom-width: 1px;  left: 118px; top: 51px; position: absolute; width: 220px" value=":"/>
                                                    <ice:outputText binding="#{Questionnaire$GenerateQuestionnairs.txtFromDate}" id="txtFromDate"
                                                        style="border-bottom-style: solid; border-bottom-width: 1px; left: 118px; top: 91px; position: absolute; width: 220px" value=":"/>
                                                    <ice:outputText binding="#{Questionnaire$GenerateQuestionnairs.txtQuestJobTitle}" id="txtQuestJobTitle"
                                                        style=" border-bottom-style: solid; border-bottom-width: 1px; left: 454px; top: 53px; position: absolute; width: 220px" value=":"/>
                                                    <ice:outputText binding="#{Questionnaire$GenerateQuestionnairs.txtToDate}" id="txtToDate"
                                                        style=" border-bottom-style: solid; border-bottom-width: 1px; left: 454px; top: 91px; position: absolute; width: 220px" value=":"/>
                                                    <ice:inputTextarea binding="#{Questionnaire$GenerateQuestionnairs.txtDesc}" id="txtDesc" style="left: 120px; top: 130px; position: absolute; width: 350"/>
                                                    <ice:outputText id="lblSupervisorName5"
                                                        style="font-family: 'Arial','Helvetica',sans-serif; left: 24px; top: 140px; position: absolute; text-align: left; vertical-align: top; width: 71px" value="Description"/>
                                                </ice:panelLayout>
                                                <ice:outputText id="outputText5" style="font-weight: bold; left: 10px; top: 192px; position: absolute" value="Questionnaire Information"/>
                                                <ice:panelLayout id="pnlPreviousNextFirst" layout="flow"
                                                    style="border-width: 1px; border-style: solid; height: 60px; left: 8px; top: 1185px; overflow: auto; position: absolute; width: 724px; -rave-layout: grid"
                                                    styleClass="insideContainerMain" visible="true">
                                                    <ice:commandButton action="#{Questionnaire$GenerateQuestionnairs.btnNextSec_action}"
                                                        binding="#{Questionnaire$GenerateQuestionnairs.btnNextSec}" id="btnNextSec"
                                                        style="left: 528px; top: 10px; position: absolute; width: 95px" value="Next&gt;&gt;"/>
                                                </ice:panelLayout>
                                            </ice:panelLayout>
                                        </ice:panelTab>
                                        <ice:panelTab binding="#{Questionnaire$GenerateQuestionnairs.pnlTabPage2}" id="pnlTabPage2" label="Page 2">
                                            <ice:panelLayout id="pnlPage2" layout="flow" style="border-width: 1px; border-style: none; height: 1250px; left: 0px; top: 0px; position: relative; width: 100%; -rave-layout: grid">
                                                <ice:outputLabel id="outputLabel10" style="font-weight: bold; left: 10px; top: 0px; position: absolute" value="Section Three"/>
                                                <ice:panelLayout binding="#{Questionnaire$GenerateQuestionnairs.pnlSectionThree}" id="pnlSectionThree"
                                                    layout="flow"
                                                    style="border-width: 1px; height: 600px; left: 8px; top: 24px; overflow: auto; position: absolute; width: 724px; -rave-layout: grid" styleClass="insideContainerMain"/>
                                                <ice:panelLayout binding="#{Questionnaire$GenerateQuestionnairs.pnlSectionFour}" id="pnlSectionFour"
                                                    layout="flow"
                                                    style="border-width: 1px; height: 520px; left: 8px; top: 650px; overflow: auto; position: absolute; width: 724px; -rave-layout: grid" styleClass="insideContainerMain"/>
                                                <ice:outputLabel id="outputLabel1" style="font-weight: bold; left: 10px; top: 628px; position: absolute" value="Section Four"/>
                                                <ice:panelLayout id="pnlPreviousNextSecond" layout="flow"
                                                    style="border-width: 1px; border-style: solid; height: 60px; left: 8px; top: 1185px; overflow: auto; position: absolute; width: 724px; -rave-layout: grid"
                                                    styleClass="insideContainerMain" visible="true">
                                                    <ice:commandButton action="#{Questionnaire$GenerateQuestionnairs.btnPrevFirst_action}"
                                                        binding="#{Questionnaire$GenerateQuestionnairs.btnPrevFirst}" id="btnPrevFirst"
                                                        style="left: 48px; top: 10px; position: absolute; width: 95px" value="&lt;&lt;Previous"/>
                                                    <ice:commandButton action="#{Questionnaire$GenerateQuestionnairs.btnNextthird_action}"
                                                        binding="#{Questionnaire$GenerateQuestionnairs.btnNextthird}" id="btnNextthird"
                                                        style="left: 528px; top: 10px; position: absolute; width: 95px" value="Next&gt;&gt;"/>
                                                </ice:panelLayout>
                                            </ice:panelLayout>
                                        </ice:panelTab>
                                        <ice:panelTab binding="#{Questionnaire$GenerateQuestionnairs.pnlTabPage3}" id="pnlTabPage3" label="Page 3">
                                            <ice:panelLayout id="pnlPage3" layout="flow" style="border-width: 1px; border-style: none; height: 1250px; left: 0px; top: 0px; position: relative; width: 100%; -rave-layout: grid">
                                                <ice:outputLabel id="outputLabel19" style="font-weight: bold; left: 10px; top: 0px; position: absolute" value="Section Five"/>
                                                <ice:panelLayout binding="#{Questionnaire$GenerateQuestionnairs.pnlSectionFive}" id="pnlSectionFive"
                                                    layout="flow"
                                                    style="border-width: 1px; height: 1140px; left: 8px; top: 24px; overflow: auto; position: absolute; width: 724px; -rave-layout: grid" styleClass="insideContainerMain"/>
                                                <ice:panelLayout id="pnlSectionCommand" layout="flow"
                                                    style="border-width: 1px; border-style: solid; height: 60px; left: 8px; top: 1185px; overflow: auto; position: absolute; width: 98%; -rave-layout: grid"
                                                    styleClass="insideContainerMain" visible="true">
                                                    <ice:commandButton action="#{Questionnaire$GenerateQuestionnairs.btnPrevSecond_action}"
                                                        binding="#{Questionnaire$GenerateQuestionnairs.btnPrevSecond}" id="btnPrevSecond"
                                                        style="left: 48px; top: 10px; position: absolute; width: 95px" value="&lt;&lt;Previous"/>
                                                    <ice:commandButton action="#{Questionnaire$GenerateQuestionnairs.btnSave_action}"
                                                        binding="#{Questionnaire$GenerateQuestionnairs.btnSave}" id="btnSave"
                                                        style="left: 168px; top: 10px; position: absolute; width: 95px" value="Save"/>
                                                    <ice:commandButton action="#{Questionnaire$GenerateQuestionnairs.btnUpdate_action}"
                                                        binding="#{Questionnaire$GenerateQuestionnairs.btnUpdate}" disabled="true" id="btnUpdate"
                                                        style="left: 408px; top: 10px; position: absolute; width: 95px" value="Update"/>
                                                    <ice:commandButton action="#{Questionnaire$GenerateQuestionnairs.btnEdit_action}"
                                                        binding="#{Questionnaire$GenerateQuestionnairs.btnEdit}" disabled="true" id="btnEdit"
                                                        style="left: 288px; top: 10px; position: absolute; width: 95px" value="Edit"/>
                                                    <ice:commandButton action="#{Questionnaire$GenerateQuestionnairs.btnDelete_action}"
                                                        binding="#{Questionnaire$GenerateQuestionnairs.btnDelete}" disabled="true" id="btnDelete"
                                                        style="left: 528px; top: 10px; position: absolute; width: 95px" value="Delete"/>
                                                </ice:panelLayout>
                                            </ice:panelLayout>
                                        </ice:panelTab>
                                        <ice:panelTab binding="#{Questionnaire$GenerateQuestionnairs.pnlTabRev}" id="pnlTabRev" label="Reviwer's Section"
                                            rendered="false" style="">
                                            <ice:panelLayout id="panelLayout1" layout="flow" style="border-width: 1px; border-style: none; height: 1250px; left: 0px; top: 0px; position: relative; width: 100%; -rave-layout: grid">
                                                <ice:outputLabel id="outputText6" style="font-weight: bold; left: 10px; top: 0px; position: absolute" value="Supervisor's  Review Section"/>
                                                <ice:panelLayout id="pnlRequesterinfo3" layout="flow"
                                                    style="height: 430px; left: 8px; top: 24px; overflow: auto; position: absolute; visibility: visible; width: 724px; -rave-layout: grid"
                                                    styleClass="insideContainerMain" visible="true">
                                                    <ice:outputText id="lblSupervisorName6"
                                                        style="font-family: 'Cambria'; left: 24px; top: 12px; position: absolute" value="Name:"/>
                                                    <ice:outputText id="lblDirectorate5"
                                                        style="font-family: 'Cambria'; left: 24px; top: 50px; position: absolute" value="Job Title:"/>
                                                    <ice:outputText id="lblJobTitle3"
                                                        style="font-family: Cambria; left: 360px; top: 12px; position: absolute; text-align: left; vertical-align: top; width: 95px" value="Directorate/ Unit:"/>
                                                    <ice:outputText binding="#{Questionnaire$GenerateQuestionnairs.txtSupName1}" id="txtSupName1" style="border-bottom-style: solid; border-bottom-width: 1px; left: 118px; top: 13px; position: absolute; width: 220px"/>
                                                    <ice:outputText binding="#{Questionnaire$GenerateQuestionnairs.txtSupJob1}" id="txtSupJob1" style="border-bottom-style: solid; border-bottom-width: 1px;  left: 118px; top: 51px; position: absolute; width: 220px"/>
                                                    <ice:outputText binding="#{Questionnaire$GenerateQuestionnairs.txtSupDirectorate}" id="txtSupDirectorate" style=" border-bottom-style: solid; border-bottom-width: 1px; left: 454px; top: 15px; position: absolute; width: 220px"/>
                                                    <ice:inputText binding="#{Questionnaire$GenerateQuestionnairs.txtSupDate}" id="txtSupDate" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 454px; top: 51px; position: absolute; width: 220"/>
                                                    <ice:outputText id="lblDirectorate7"
                                                        style="font-family: 'Cambria'; left: 360px; top:50px; position: absolute" value="Date"/>
                                                    <ice:commandButton action="#{Questionnaire$GenerateQuestionnairs.btnCalSupDate_action}" id="btnCalSupDate"
                                                        image="/resources/images/cal_button.gif" immediate="true"
                                                        style="left: 656px; top: 54px; position: absolute" value="submit"/>
                                                    <ice:outputLabel id="outputLabel2" style="left: 24px; top: 99px; position: absolute" value="Section"/>
                                                    <ice:selectOneMenu binding="#{Questionnaire$GenerateQuestionnairs.ddnSupSection}" id="ddnSupSection"
                                                        partialSubmit="false"
                                                        style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 118px; top: 100px; position: absolute; width: 220px" value="#{Questionnaire$GenerateQuestionnairs.selectOneMenu2Bean.selectedObject}">
                                                        <f:selectItems id="selectOneMenu1selectItems" value="#{Questionnaire$GenerateQuestionnairs.sectionList}"/>
                                                    </ice:selectOneMenu>
                                                    <ice:inputTextarea binding="#{Questionnaire$GenerateQuestionnairs.txtSupRemark}" id="txtSupRemark" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; height: 55px; left: 118px; top: 140px; position: absolute; width: 300px"/>
                                                    <ice:outputLabel id="outputLabel3"
                                                        style="left: 24px; top: 144px; position: absolute; text-align: left; vertical-align: top; width: 95px" value="Comments/ Remarks"/>
                                                    <ice:panelLayout id="panelLayout2" style="border-width: 0px; height: 189px; left: 24px; top: 216px; overflow: auto; position: absolute; width: 499px">
                                                        <ice:dataTable id="dataTable1" style="left: 0; top: -10; position: absolute;width:100%"
                                                            value="#{Questionnaire$GenerateQuestionnairs.supervisorComment}" var="currentRow">
                                                            <ice:column id="column1">
                                                                <ice:outputText id="outputText7" value="#{currentRow['sectionDesc']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText8" value="Section"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column2">
                                                                <ice:outputText id="outputText9" value="#{currentRow['remark']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText10" value="Comments/Remarks"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <f:facet name="header">
                                                                <ice:panelGroup id="panelGroup3" style="height: 20px;">
                                                                    <ice:outputText id="outputText11" value="Supervisor's Comments"/>
                                                                </ice:panelGroup>
                                                            </f:facet>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                    <ice:selectInputDate binding="#{Questionnaire$GenerateQuestionnairs.calSupDate}" id="calSupDate"
                                                        rendered="false"
                                                        style="position: absolute; left: 456px; top: 72px; width: 190px; height: 212px; z-index:1px"
                                                        value="#{Questionnaire$GenerateQuestionnairs.selectInputDateBean1.date1}" valueChangeListener="#{Questionnaire$GenerateQuestionnairs.calSupDate_processValueChange}"/>
                                                    <ice:commandButton action="#{Questionnaire$GenerateQuestionnairs.btnAddSupervisor_action}"
                                                        id="btnAddSupervisor" style="left: 456px; top: 168px; position: absolute; width: 71px" value="Add"/>
                                                </ice:panelLayout>
                                                <ice:panelLayout id="pnlRequesterinfo4" layout="flow"
                                                    style="height: 430px; left: 8px; top: 480px; overflow: auto; position: absolute; visibility: visible; width: 724px; -rave-layout: grid"
                                                    styleClass="insideContainerMain" visible="true">
                                                    <ice:outputText id="lblSupervisorName7"
                                                        style="font-family: 'Cambria'; left: 24px; top: 12px; position: absolute" value="Name:"/>
                                                    <ice:outputText id="lblDirectorate6"
                                                        style="font-family: 'Cambria'; left: 24px; top: 50px; position: absolute" value="Job Title:"/>
                                                    <ice:outputText id="lblJobTitle5"
                                                        style="font-family: Cambria; left: 360px; top: 12px; position: absolute; text-align: left; vertical-align: top; width: 95px" value="Directorate/ Unit:"/>
                                                    <ice:outputText binding="#{Questionnaire$GenerateQuestionnairs.txtRevName}" id="txtRevName" style="border-bottom-style: solid; border-bottom-width: 1px; left: 118px; top: 13px; position: absolute; width: 220px"/>
                                                    <ice:outputText binding="#{Questionnaire$GenerateQuestionnairs.txtRevJob}" id="txtRevJob" style="border-bottom-style: solid; border-bottom-width: 1px;  left: 118px; top: 51px; position: absolute; width: 220px"/>
                                                    <ice:outputText binding="#{Questionnaire$GenerateQuestionnairs.txtRevDirectorate}" id="txtRevDirectorate" style=" border-bottom-style: solid; border-bottom-width: 1px; left: 454px; top: 15px; position: absolute; width: 220px"/>
                                                    <ice:inputText binding="#{Questionnaire$GenerateQuestionnairs.txtRevDate}" id="txtRevDate" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 454px; top: 51px; position: absolute; width: 220"/>
                                                    <ice:outputText id="lblDirectorate8"
                                                        style="font-family: 'Cambria'; left: 360px; top:50px; position: absolute" value="Date"/>
                                                    <ice:commandButton action="#{Questionnaire$GenerateQuestionnairs.btnCalRevDate_action}" id="btnCalRevDate"
                                                        image="/resources/images/cal_button.gif" immediate="true"
                                                        style="left: 656px; top: 54px; position: absolute" value="submit"/>
                                                    <ice:outputLabel id="outputLabel4" style="left: 24px; top: 99px; position: absolute" value="Section"/>
                                                    <ice:selectOneMenu binding="#{Questionnaire$GenerateQuestionnairs.ddnRevSection}" id="ddnRevSection"
                                                        partialSubmit="false"
                                                        style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 118px; top: 100px; position: absolute; width: 220px" value="#{Questionnaire$GenerateQuestionnairs.selectOneMenu1Bean.selectedObject}">
                                                        <f:selectItems id="selectOneMenu1selectItems1" value="#{Questionnaire$GenerateQuestionnairs.sectionList}"/>
                                                    </ice:selectOneMenu>
                                                    <ice:inputTextarea binding="#{Questionnaire$GenerateQuestionnairs.txtRevRemark}" id="txtRevRemark" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; height: 55px; left: 118px; top: 140px; position: absolute; width: 300px"/>
                                                    <ice:outputLabel id="outputLabel5"
                                                        style="left: 24px; top: 144px; position: absolute; text-align: left; vertical-align: top; width: 95px" value="Comments/ Remarks"/>
                                                    <ice:panelLayout id="panelLayout3" style="border-width: 0px; height: 189px; left: 24px; top: 216px; overflow: auto; position: absolute; width: 499px">
                                                        <ice:dataTable id="dataTable2" style="left: 0; top: -10; position: absolute;width:100%"
                                                            value="#{Questionnaire$GenerateQuestionnairs.reviwerComment}" var="currentRow">
                                                            <ice:column id="column3">
                                                                <ice:outputText id="outputText12" value="#{currentRow['sectionDesc']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText13" value="Section"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column4">
                                                                <ice:outputText id="outputText14" value="#{currentRow['remark']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText15" value="Comments/Remarks"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <f:facet name="header">
                                                                <ice:panelGroup id="panelGroup4" style="height: 20px;">
                                                                    <ice:outputText id="outputText16" value="Reviewing Authority's Comments"/>
                                                                </ice:panelGroup>
                                                            </f:facet>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                    <ice:selectInputDate binding="#{Questionnaire$GenerateQuestionnairs.calRevDate}" id="calRevDate"
                                                        rendered="false"
                                                        style="position: absolute; left: 456px; top: 72px; width: 190px; height: 212px;  z-index:1px"
                                                        value="#{Questionnaire$GenerateQuestionnairs.selectInputDateBean2.date1}" valueChangeListener="#{Questionnaire$GenerateQuestionnairs.calRevDate_processValueChange}"/>
                                                    <ice:commandButton action="#{Questionnaire$GenerateQuestionnairs.btnAddReviwer_action}" id="btnAddReviwer"
                                                        style="left: 456px; top: 168px; position: absolute; width: 71px" value="Add"/>
                                                </ice:panelLayout>
                                                <ice:outputLabel id="outputText17" style="font-weight: bold; left: 10px; top: 456px; position: absolute" value="Reviewing Authority's Review Section"/>
                                                <ice:panelLayout id="pnlSectionCommand1" layout="flow"
                                                    style="border-width: 1px; height: 60px; left: 8px; top: 930px; overflow: auto; position: absolute; width: 724; -rave-layout: grid"
                                                    styleClass="insideContainerMain" visible="true">
                                                    <ice:commandButton action="#{Questionnaire$GenerateQuestionnairs.btnNew_action}" id="btnNewComment"
                                                        style="left: 48px; top: 10px; position: absolute; width: 95px" value="New"/>
                                                    <ice:commandButton action="#{Questionnaire$GenerateQuestionnairs.btnSaveComment_action}" id="btnSaveComment"
                                                        style="left: 168px; top: 10px; position: absolute; width: 95px" value="Save"/>
                                                    <ice:commandButton action="#{Questionnaire$GenerateQuestionnairs.btnUpdate_action}" disabled="true"
                                                        id="btnUpdateComment" style="left: 408px; top: 10px; position: absolute; width: 95px" value="Update"/>
                                                    <ice:commandButton action="#{Questionnaire$GenerateQuestionnairs.btnEdit_action}" disabled="true"
                                                        id="btnEditComment" style="left: 288px; top: 10px; position: absolute; width: 95px" value="Edit"/>
                                                    <ice:commandButton action="#{Questionnaire$GenerateQuestionnairs.btnDelete_action}" disabled="true"
                                                        id="btnDeleteComment" style="left: 528px; top: 10px; position: absolute; width: 95px" value="Delete"/>
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
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
