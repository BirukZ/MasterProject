<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2010, 7:48:31 AM
    Author     : BravoZulu
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title></title>
                <ice:outputStyle href="../resources/stylesheet.css" id="outputStyle1"/>
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
                        border: solid 1px #BD8;
                    }
                    .message2 {
                        display: none;
                        margin: 0 0 13px 0;
                        background-color:#EFA;
                        padding: 13px 13px 13px 52px;
                        background-position: 13px 5px;
                        border: solid 1px #BD8;
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
                    function EvaluationNavigation(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div style="width:100%">
                        <img alt="" class="source-image" id="img" src="../resources/images/WholePageBG.png" width="100%"/>
                        <ice:panelBorder height="480" id="whole_page" renderCenter="#{EmployeeHistory$EvaluationCriterias.panelBorder1Bean.renderCenter}"
                            renderEast="#{EmployeeHistory$EvaluationCriterias.panelBorder1Bean.renderEast}"
                            renderNorth="#{EmployeeHistory$EvaluationCriterias.panelBorder1Bean.renderNorth}"
                            renderSouth="#{EmployeeHistory$EvaluationCriterias.panelBorder1Bean.renderSouth}"
                            renderWest="#{EmployeeHistory$EvaluationCriterias.panelBorder1Bean.renderEast}" style="top: 5px; position: relative"
                            styleClass="whole_page" width="1024">
                            <f:facet name="north">
                                <ice:panelGroup id="page_header" style="height: 117px">
                                    <!-- Begin Header -->
                                    <ice:panelLayout id="header" layout="flow"
                                        style="height: 129px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="header" visible="true">
                                        <jsp:directive.include file="/Header.jspf"/>
                                    </ice:panelLayout>
                                    <!-- End Header -->
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="west">
                                <ice:panelGroup dragListener="#{EmployeeHistory$EvaluationCriterias.menu_left_processMyEvent}" id="menu_left" style=" height:100%;">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height: 412px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 400px; left: 5px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Common_Tasks">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="commonTasksGroup_header">
                                                        <ice:outputText id="lblCommonTasks" value="Common Tasks"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid headerClass="iceDatTblColHdr1" id="commonTasksGroup_Grid" width="100%">
                                                    <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                        <ice:panelSeries id="Common_Tasks_Series" rows="3" style="width:100%" value="CommonTasks" var="commontasks">
                                                            <li>
                                                                <ice:commandLink action="#{EmployeeHistory$EvaluationCriterias.commandLink1_action}"
                                                                    id="commandLink1" style="color:#306682;font-weight:bold" value="Evaluation Criteria"/>
                                                            </li>
                                                            <li>
                                                                <ice:commandLink action="#{EmployeeHistory$EvaluationCriterias.commandLink3_action}"
                                                                    id="commandLink3" style="color:#306682;font-weight:bold" value="Evaluation Session"/>
                                                            </li>
                                                            <li>
                                                                <ice:commandLink action="#{EmployeeHistory$EvaluationCriterias.commandLink2_action}"
                                                                    id="commandLink2" style="color:#306682;font-weight:bold" value="Evaluation Result"/>
                                                            </li>
                                                            <li>
                                                                <ice:commandLink action="#{EmployeeHistory$EvaluationNavigation.commandLink4_action}"
                                                                    id="commandLink4" style="color:#306682;font-weight:bold" value="View Result"/>
                                                            </li>
                                                            <li>
                                                                <ice:commandLink action="#{EmployeeHistory$EvaluationNavigation.commandLink5_action}"
                                                                    id="commandLink5" style="color:#306682;font-weight:bold" value="Resolve Result"/>
                                                            </li>
                                                            <li>
                                                                <ice:commandLink action="#{EmployeeHistory$EvaluationNavigation.commandLink6_action}"
                                                                    id="commandLink6" style="color:#306682;font-weight:bold" value="Evaluation Navigator"/>
                                                            </li>
                                                        </ice:panelSeries>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height: 640px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 640px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 598px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Evaluation Criteria"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 617px; left: 0px; top: -20px; position: absolute; width: 100%">
                                                <ice:panelGroup dragListener="#{EmployeeHistory$EvaluationCriterias.EvaluationCriteriaPG_processMyEvent}"
                                                    id="EvaluationCriteriaPG" style="height: 574px">
                                                    <ice:panelLayout binding="#{EmployeeHistory$EvaluationCriterias.pnevaCriteriaMessage}"
                                                        id="pnevaCriteriaMessage" style="left: 172px; top:-36px;position: absolute; height:3px; width: 544px" styleClass="message">
                                                        <h:outputLabel binding="#{EmployeeHistory$EvaluationCriterias.lblevaCriteriaFormMessage}" id="lblevaCriteriaFormMessage"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout binding="#{EmployeeHistory$EvaluationCriterias.panelLayoutTableController}"
                                                        id="panelLayoutTableController"
                                                        style=" width:744; height:245px; left: 17px; top: 290px; overflow: auto; position: absolute;" styleClass="insideContainerMain">
                                                        <ice:dataTable binding="#{EmployeeHistory$EvaluationCriterias.dataTableEvaCriteria}"
                                                            id="dataTableEvaCriteria" style="left: 0px; top: -10px; position: absolute"
                                                            value="#{EmployeeHistory$EvaluationCriterias.evaCriteriaOPt}" var="currentRow" width="727">
                                                            <ice:column id="columnCriteriaCoad">
                                                                <ice:outputText id="outputText7" value="#{currentRow['evaCriteriaCategory']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputTextCriteriaCoad" value="Criteria Category"/>
                                                                </f:facet>
                                                                <ice:rowSelector binding="#{EmployeeHistory$EvaluationCriterias.rowSelectorEvaCriteria}"
                                                                    id="rowSelectorEvaCriteria" multiple="false" preStyleOnSelection="true"
                                                                    selectionListener="#{EmployeeHistory$EvaluationCriterias.rowSelectorEvaCriteria_processMyEvent}"
                                                                    toggleOnClick="true" value="#{currentRow['selected']}"/>
                                                            </ice:column>
                                                            <ice:column id="columncName">
                                                                <ice:outputText id="outputText8" value="#{currentRow['evaCriteria']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputTextcName" value="Criteria Name"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="columnCriteriaDescription">
                                                                <ice:outputText id="outputText9" value="#{currentRow['evaCriteriaDesc']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputTextCriteriaDescription" value="Criteria Description"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column binding="#{EmployeeHistory$EvaluationCriterias.columncevaCid}" id="columncevaCid">
                                                                <ice:outputText id="outputText10" value="#{currentRow['evaParaCode']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputTextevaCid" value="Criteria ID"/>
                                                                </f:facet>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="dataTableEvaCriteria"
                                                            id="messagedataTableEvaCriteria" infoClass="infoMessage"
                                                            style="left:  270px; top: 32px; text-decoration: blink; position: absolute; width: 97px" warnClass="warnMessage"/>
                                                        <ice:outputText binding="#{EmployeeHistory$EvaluationCriterias.outputTextdataTableEvaCriteria}"
                                                            id="outputTextdataTableEvaCriteria" rendered="false"
                                                            style="color: red; text-decoration: blink; font-size: 11px; font-weight: bold; left: 280px; top: 32px; position: absolute" value=""/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="panelLOutEvaCriteria" layout="flow"
                                                        style="height: 180px; margin-left: 17px; margin-top: 50px; position: absolute; width: 744px" styleClass="insideContainerMain">
                                                        <ice:outputText id="outputTextECode" style="left: 30px; top: 48px; position: absolute"
                                                            styleClass="insideTextLable" value="criteriaCategory"/>
                                                        <ice:outputText id="outputTextECName" style="left: 440px; top: 48px; position: absolute"
                                                            styleClass="insideTextLable" value="criteriaName"/>
                                                        <ice:outputText id="outputTextECDescription" style="left: 30px; top: 150px; position: absolute"
                                                            styleClass="insideTextLable" value="criteriaDescription"/>
                                                        <ice:inputText binding="#{EmployeeHistory$EvaluationCriterias.inputTextCName}" id="inputTextCName"
                                                            partialSubmit="true"
                                                            style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 520px; top: 48px; position: absolute" valueChangeListener="#{EmployeeHistory$EvaluationCriterias.inputTextCName_processValueChange}"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="inputTextCName"
                                                            id="messageCriteriaName" infoClass="infoMessage"
                                                            style="font-size: 11px; left: 670px; top: 52px; position: absolute; text-decoration: blink; width: 97px" warnClass="warnMessage"/>
                                                        <ice:outputText binding="#{EmployeeHistory$EvaluationCriterias.outputTextCriteriaName}"
                                                            id="outputTextCriteriaName" rendered="false"
                                                            style="color: red; text-decoration: blink; font-size: 11px; font-weight: bold; left: 670px; top: 52px; position: absolute" value=""/>
                                                        <ice:selectOneMenu binding="#{EmployeeHistory$EvaluationCriterias.selectOneMenuevaCCategory}"
                                                            id="selectOneMenuevaCCategory" partialSubmit="true"
                                                            style=" border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; width:200px; left: 150px; top: 48px; position: absolute"
                                                            value="#{EmployeeHistory$EvaluationCriterias.defaultSelectedData9.selectedObject}" valueChangeListener="#{EmployeeHistory$EvaluationCriterias.selectOneMenuevaCCategory_processValueChange}">
                                                            <f:selectItems
                                                                binding="#{EmployeeHistory$EvaluationCriterias.selectOneMenu1selectItemsevaCCategory}"
                                                                id="selectOneMenu1selectItemsevaCCategory" value="#{EmployeeHistory$EvaluationCriterias.category}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:commandButton action="#{EmployeeHistory$EvaluationCriterias.addNewPurpButton_action}"
                                                            binding="#{EmployeeHistory$EvaluationCriterias.addNewPurpButton}" id="addNewPurpButton"
                                                            image="/resources/images/add.png" partialSubmit="true"
                                                            style="left: 360px; top: 50px; width:20px; height:20px;  position: absolute;" value=""/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="selectOneMenuevaCCategory"
                                                            id="messageselectOneMenuevaCCategory" infoClass="infoMessage"
                                                            style="font-size: 11px; left: 360px; top: 52px; position: absolute; text-decoration: blink; width: 97px" warnClass="warnMessage"/>
                                                        <ice:outputText
                                                            binding="#{EmployeeHistory$EvaluationCriterias.outputTextErorrselectOneMenuevaCCategory}"
                                                            id="outputTextErorrselectOneMenuevaCCategory" rendered="false"
                                                            style="color: red; text-decoration: blink; font-size: 11px; font-weight: bold; left: 360px; top: 48px; position: absolute" value=""/>
                                                        <ice:inputTextarea binding="#{EmployeeHistory$EvaluationCriterias.inputTextareaCDescription}"
                                                            id="inputTextareaCDescription" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); border-color:#86b6d2; font-family: 'Lucida Sans'; height:80px; width:510px; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 88px; position: absolute"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="panelLOutEvaCriteriaAdd"
                                                        style="height: 40px; margin-left: 17px; margin-top: 240px; position: absolute; width: 744px" styleClass="insideContainerMain">
                                                        <ice:commandButton action="#{EmployeeHistory$EvaluationCriterias.btnNewECria_action}"
                                                            binding="#{EmployeeHistory$EvaluationCriterias.btnNewECria}" id="btnNewECria" partialSubmit="true"
                                                            style="left: 10px; top: -4px; width:100px; position: absolute" value="Add Criteria"/>
                                                        <ice:selectOneMenu binding="#{EmployeeHistory$EvaluationCriterias.selectOneMenu1PurposeFillter}"
                                                            id="selectOneMenu1PurposeFillter" partialSubmit="true"
                                                            style=" border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; width:200px; left: 520px; top: 5px; position: absolute"
                                                            value="#{EmployeeHistory$EvaluationCriterias.defaultSelectedData10.selectedObject}" valueChangeListener="#{EmployeeHistory$EvaluationCriterias.selectOneMenu1PurposeFillter_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectItemsFillter" value="#{EmployeeHistory$EvaluationCriterias.categoryFilter}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputText id="outputText3" style="left: 390px; top: 6px; position: absolute" value="Filter using Criteria:"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="panelLOutEvaCriteriaSavebtn"
                                                        style="height: 40px; margin-left: -3px; margin-top: 530px; left: 17px; top: 23px; position: absolute; width: 744px" styleClass="insideContainerMain">
                                                        <ice:commandButton action="#{EmployeeHistory$EvaluationCriterias.buttonNewEC_action}"
                                                            binding="#{EmployeeHistory$EvaluationCriterias.buttonNewEC}" id="buttonNewEC" partialSubmit="true"
                                                            style="margin-left:80px; margin-top:10px; width:80;  position: absolute"
                                                            styleClass="styleContButton" value="New"/>
                                                        <ice:commandButton action="#{EmployeeHistory$EvaluationCriterias.buttonSaveEC_action}"
                                                            binding="#{EmployeeHistory$EvaluationCriterias.buttonSaveEC}" id="buttonSaveEC" partialSubmit="true"
                                                            style="margin-left:170px; margin-top:10px; width:80;  position: absolute"
                                                            styleClass="styleContButton" value="Save"/>
                                                        <ice:commandButton action="#{EmployeeHistory$EvaluationCriterias.buttonEditEC_action}"
                                                            binding="#{EmployeeHistory$EvaluationCriterias.buttonEditEC}" id="buttonEditEC" partialSubmit="true"
                                                            style="margin-left:260px; margin-top:10px; width:80;  position: absolute"
                                                            styleClass="styleContButton" value="Edit"/>
                                                        <ice:commandButton action="#{EmployeeHistory$EvaluationCriterias.buttonUpdateEC_action}"
                                                            binding="#{EmployeeHistory$EvaluationCriterias.buttonUpdateEC}" id="buttonUpdateEC"
                                                            partialSubmit="true" style="margin-left:350px; margin-top:10px; width:80;  position: absolute"
                                                            styleClass="styleContButton" value="Update"/>
                                                        <ice:commandButton action="#{EmployeeHistory$EvaluationCriterias.buttonDeleteEC_action}"
                                                            binding="#{EmployeeHistory$EvaluationCriterias.buttonDeleteEC}" id="buttonDeleteEC"
                                                            partialSubmit="true" style="margin-left:440px; margin-top:10px; width:80;  position: absolute"
                                                            styleClass="styleContButton" value="Delete"/>
                                                        <ice:commandButton action="#{EmployeeHistory$EvaluationCriterias.buttonResetEC_action}"
                                                            binding="#{EmployeeHistory$EvaluationCriterias.buttonResetEC}" id="buttonResetEC"
                                                            partialSubmit="true" style="margin-left:530px; margin-top:10px; width:80;  position: absolute"
                                                            styleClass="styleContButton" value="Cancel"/>
                                                    </ice:panelLayout>
                                                </ice:panelGroup>
                                            </ice:panelLayout>
                                        </fieldset>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="south">
                                <ice:panelGroup id="page_footer" style=" text-align: center;">
                                    <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid">
                                        <jsp:directive.include file="/FOOTER.jspf"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{EmployeeHistory$EvaluationCriterias.evaCriteriaPopUpMsg}" draggable="true"
                            effect="#{EmployeeHistory$EvaluationCriterias.evaCriteriaPopeffectWindow}" id="evaCriteriaPopUpMsg" modal="true" rendered="false" style="display: block; height: 156px; left: 97px; top: 226px; position: absolute; width: 623px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridevaCriteriaPopUpMsg" style="display: block; height: 20px; width: 500px">
                                    <ice:outputText id="lblevaCriteriaPopUpMsgTitle" value="BUNNA INTERNATIONAL BANK Human Resource Management System"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupevaCriteriaPopUpMsgBody" style="display: block; height: 94px; position: relative; width: 586">
                                    <ice:commandButton action="#{EmployeeHistory$EvaluationCriterias.btnevaCriteriaPopUpNo_action}"
                                        binding="#{EmployeeHistory$EvaluationCriterias.btnevaCriteriaPopUpNo}" id="btnevaCriteriaPopUpNo" rendered="true"
                                        style="left: 510px; top: 60px; position: absolute; visibility: visible; width: 70px" value="No" visible="true"/>
                                    <ice:commandButton action="#{EmployeeHistory$EvaluationCriterias.btnevaCriteriaPopUpYes_action}"
                                        binding="#{EmployeeHistory$EvaluationCriterias.btnevaCriteriaPopUpYes}" id="btnevaCriteriaPopUpYes" rendered="true"
                                        style="background-position: 0 100%; background-repeat: no-repeat; left: 430px; top: 60px; position: absolute; visibility: visible; width: 70px"
                                        value="Yes" visible="true"/>
                                    <ice:outputText binding="#{EmployeeHistory$EvaluationCriterias.lblevaCriteriaPopUpMsgMain}" id="lblevaCriteriaPopUpMsgMain" style="left:95px; top: 30px; position: absolute; width: 496px"/>
                                    <ice:panelLayout id="panelLayoutImageHolder" rendered="true"
                                        style=" width:62; height:56px; left: 10px; top: 15px; position: absolute;" styleClass="popUpBgimage" visible="true"/>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{EmployeeHistory$EvaluationCriterias.evaCriteriaPurposePopUpMsg}" draggable="true"
                            effect="#{EmployeeHistory$EvaluationCriterias.evaCriteriaPopeffectWindow}" id="evaCriteriaPurposePopUpMsg" modal="true"
                            rendered="false" style="display: block; height: 286px; left: 97px; top: 226px; position: absolute; width: 343px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridevaCriteriaPurposePopUpMsg" style="display: block; height: 20px; width: 300px">
                                    <ice:outputText id="lblevaCriteriaPopUpPurposeMsgTitle" value="You Can Add or Remove Purpose for Evaluation"/>
                                    <ice:commandButton action="#{EmployeeHistory$EvaluationCriterias.buttonClose_action}"
                                        binding="#{EmployeeHistory$EvaluationCriterias.buttonClose}" id="buttonClose" image="/Employee/images/close.png"
                                        partialSubmit="true"
                                        style="left:329px; margin-top: -22px; position: absolute; visibility: visible; height:15px; width:15px" value="x"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupevaCriteriaPopUpPurposeMsgBody" style="display: block; height: 80px; position: relative; width: 300px">
                                    <ice:panelGroup binding="#{EmployeeHistory$EvaluationCriterias.panelGroupevaCriteriaPopUpPurposeMsgBody11}"
                                        id="panelGroupevaCriteriaPopUpPurposeMsgBody11" rendered="true"
                                        style="display: block; height: 90px; top: 0px; position: relative; width: 300px" styleClass="insideContainerPop">
                                        <ice:outputText id="popupPurpose" style="font-size: 10px;margin-left: 5px; margin-top: 20px; position: absolute" value="Purpose:"/>
                                        <ice:inputText binding="#{EmployeeHistory$EvaluationCriterias.inputTextPopUpPurpose}" id="inputTextPopUpPurpose" style="margin-left: 60px; margin-top: 10px; position: absolute; width: 150px"/>
                                        <ice:selectOneMenu binding="#{EmployeeHistory$EvaluationCriterias.drlJob}" id="drlJob" partialSubmit="true"
                                            style="margin-left: 60px; margin-top: 50px; position: absolute; width: 150px"
                                            value="#{EmployeeHistory$EvaluationCriterias.defaultSelectedData11.selectedObject}" valueChangeListener="#{EmployeeHistory$EvaluationCriterias.drlJob_processValueChange}">
                                            <f:selectItems id="selectOneMenu1selectItems" value="#{EmployeeHistory$EvaluationCriterias.readJob}"/>
                                        </ice:selectOneMenu>
                                        <ice:outputLabel id="outputLabel1" style="font-size: 10px; margin-left: 5px; margin-top: 50px; position: absolute" value="Job"/>
                                        <ice:commandButton action="#{EmployeeHistory$EvaluationCriterias.btnevaCriteriaPopUpPurposeAdd_action}"
                                            binding="#{EmployeeHistory$EvaluationCriterias.btnevaCriteriaPopUpPurposeAdd}" id="btnevaCriteriaPopUpPurposeAdd"
                                            style="left: 212px; top: -1px; position: absolute; visibility: visible; height:25px; width: 82px" value="Add Purpose"/>
                                    </ice:panelGroup>
                                    <ice:panelGroup binding="#{EmployeeHistory$EvaluationCriterias.panelGroupevaCriteriaPopUpPurposeMsgBodyDelete}"
                                        id="panelGroupevaCriteriaPopUpPurposeMsgBodyDelete" rendered="false"
                                        style="top:30px; display: block; height: 50px; position: relative; width: 300" styleClass="insideContainerPop">
                                        <ice:outputText id="popupPurposeDelete" style="font-size: 10px;margin-left: 2px; margin-top: 10px; position: absolute" value="Are you shure you want to delete the record?"/>
                                        <ice:commandButton action="#{EmployeeHistory$EvaluationCriterias.button1_action}"
                                            binding="#{EmployeeHistory$EvaluationCriterias.button1}" id="button1" partialSubmit="true"
                                            style="left:240px; margin-top: 20px; position: absolute; visibility: visible; height:25px; width: 25px" value="Y"/>
                                        <ice:commandButton action="#{EmployeeHistory$EvaluationCriterias.button2_action}"
                                            binding="#{EmployeeHistory$EvaluationCriterias.button2}" id="button2" partialSubmit="true"
                                            style="left:270px; margin-top: 20px; position: absolute; visibility: visible; height:25px; width: 25px" value="N"/>
                                    </ice:panelGroup>
                                    <ice:panelGroup binding="#{EmployeeHistory$EvaluationCriterias.panelGroupevaCriteriaPopUpPurposeMsgBody1}"
                                        id="panelGroupevaCriteriaPopUpPurposeMsgBody1" rendered="true"
                                        style="display: block; height: 100px; top: 8px; overflow: auto; position: relative; width: 300px" styleClass="insideContainerPop">
                                        <ice:dataTable binding="#{EmployeeHistory$EvaluationCriterias.dataTableAddPurpose}" id="dataTableAddPurpose"
                                            style="left: -2px; top:  -10px; width: 283px; position: absolute"
                                            value="#{EmployeeHistory$EvaluationCriterias.evaResultOPtAddPurpose}" var="currentRow">
                                            <ice:column binding="#{EmployeeHistory$EvaluationCriterias.column1}" id="column1">
                                                <ice:outputText id="outputText1" value="#{currentRow['purpId']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText2" value="Purpose Id"/>
                                                </f:facet>
                                                <ice:rowSelector binding="#{EmployeeHistory$EvaluationCriterias.rowSelectorEvaPurposeAdd}"
                                                    id="rowSelectorEvaPurposeAdd" multiple="false" preStyleOnSelection="true"
                                                    selectionListener="#{EmployeeHistory$EvaluationCriterias.rowSelectorEvaPurposeAdd_processMyEvent}"
                                                    toggleOnClick="true" value="#{currentRow['selected']}"/>
                                            </ice:column>
                                            <ice:column binding="#{EmployeeHistory$EvaluationCriterias.column2}" id="column2">
                                                <ice:outputText id="inputTextPurpAdd" value="#{currentRow['purpName']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText4" value="Purpose Name"/>
                                                </f:facet>
                                            </ice:column>
                                        </ice:dataTable>
                                    </ice:panelGroup>
                                    <ice:panelGroup binding="#{EmployeeHistory$EvaluationCriterias.panelGroupevaCriteriaPopUpPurposeMsgBodyButtons}"
                                        id="panelGroupevaCriteriaPopUpPurposeMsgBodyButtons" rendered="true"
                                        style="display: block; height: 30px; top: 10px; position: relative; width: 300px" styleClass="insideContainerPop">
                                        <ice:commandButton action="#{EmployeeHistory$EvaluationCriterias.btnevaCriteriaPopUpPurposeNew_action}"
                                            binding="#{EmployeeHistory$EvaluationCriterias.btnevaCriteriaPopUpPurposeNew}" id="btnevaCriteriaPopUpPurposeNew"
                                            partialSubmit="true" rendered="true"
                                            style="left: 0px; top: -7px; position: absolute; visibility: visible; height:25px; width: 50px" value="New" visible="true"/>
                                        <ice:commandButton action="#{EmployeeHistory$EvaluationCriterias.btnevaCriteriaPopUpPurposeEdit_action}"
                                            binding="#{EmployeeHistory$EvaluationCriterias.btnevaCriteriaPopUpPurposeEdit}" id="btnevaCriteriaPopUpPurposeEdit"
                                            partialSubmit="true" rendered="true"
                                            style="left: 55px; top: -7px; position: absolute; visibility: visible; height:25px; width: 50px" value="Edit" visible="true"/>
                                        <ice:commandButton action="#{EmployeeHistory$EvaluationCriterias.btnevaCriteriaPopUpPurposeUpdate_action}"
                                            binding="#{EmployeeHistory$EvaluationCriterias.btnevaCriteriaPopUpPurposeUpdate}"
                                            id="btnevaCriteriaPopUpPurposeUpdate" partialSubmit="true" rendered="true"
                                            style="left: 110px; top: -7px; position: absolute; visibility: visible; height:25px; width: 60px" value="Update" visible="true"/>
                                        <ice:commandButton action="#{EmployeeHistory$EvaluationCriterias.btnevaCriteriaPopUpPurposeDelete_action}"
                                            binding="#{EmployeeHistory$EvaluationCriterias.btnevaCriteriaPopUpPurposeDelete}"
                                            id="btnevaCriteriaPopUpPurposeDelete" partialSubmit="true" rendered="true"
                                            style="background-position: 0 100%; background-repeat: no-repeat; left:175px; top: -7px; position: absolute; visibility: visible; height:25px; width: 60px"
                                            value="Delete" visible="true"/>
                                        <ice:commandButton action="#{EmployeeHistory$EvaluationCriterias.btnevaCriteriaPopUpPurposeCancel_action}"
                                            binding="#{EmployeeHistory$EvaluationCriterias.btnevaCriteriaPopUpPurposeCancel}"
                                            id="btnevaCriteriaPopUpPurposeCancel" partialSubmit="true" rendered="true"
                                            style="background-position: 0 100%; background-repeat: no-repeat; left:240px; top: -7px; position: absolute; visibility: visible; height:25px; width: 60px"
                                            value="Cancel" visible="true"/>
                                    </ice:panelGroup>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{EmployeeHistory$EvaluationCriterias.pnMessage}" clientOnly="true" draggable="false"
                            id="pnMessage" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{EmployeeHistory$EvaluationCriterias.modalPnlCloseMesssage_action}" id="modalPnlCloseMesssage"
                                        immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 735px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{EmployeeHistory$EvaluationCriterias.lblFormMessage1}" id="lblFormMessage1" style="background-color: #F5F5F5;"/>
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
