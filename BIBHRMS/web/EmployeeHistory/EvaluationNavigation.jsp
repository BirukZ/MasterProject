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
                    function LuQualification(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div style="width:100%">
                        <img alt="" class="source-image" id="img" src="../resources/images/WholePageBG.png" width="100%"/>
                        <ice:panelBorder height="530" id="whole_page" renderCenter="#{EmployeeHistory$EvaluationNavigation.panelBorder1Bean.renderCenter}"
                            renderEast="#{EmployeeHistory$EvaluationNavigation.panelBorder1Bean.renderEast}"
                            renderNorth="#{EmployeeHistory$EvaluationNavigation.panelBorder1Bean.renderNorth}"
                            renderSouth="#{EmployeeHistory$EvaluationNavigation.panelBorder1Bean.renderSouth}"
                            renderWest="#{EmployeeHistory$EvaluationNavigation.panelBorder1Bean.renderEast}" style="top: 5px; position: relative"
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
                                <ice:panelGroup id="menu_left" style=" height:200px;">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height: 132px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 130px; left: 5px; position: absolute; width: 213px" styleClass="left_menu">
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
                                                                <ice:commandLink action="#{EmployeeHistory$EvaluationNavigation.commandLink1_action}"
                                                                    id="commandLink1" style="color:#306682;font-weight:bold" value="Evaluation Criteria"/>
                                                            </li>
                                                            <li>
                                                                <ice:commandLink action="#{EmployeeHistory$EvaluationNavigation.commandLink3_action}"
                                                                    id="commandLink3" style="color:#306682;font-weight:bold" value="Evaluation Session"/>
                                                            </li>
                                                            <li>
                                                                <ice:commandLink action="#{EmployeeHistory$EvaluationNavigation.commandLink2_action}"
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
                                <ice:panelGroup id="page_display" style="height: 200px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 200px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 320px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Evaluation Navigator"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 240px; left: 0px; top: 24px; position: absolute; width: 100%">
                                                <ice:panelGroup dragListener="#{EmployeeHistory$EvaluationNavigation.EvaluationCriteriaPG_processMyEvent}"
                                                    id="EvaluationCriteriaPG" style="height: 260px" styleClass="filedset_border">
                                                    <ice:panelLayout binding="#{EmployeeHistory$EvaluationNavigation.pnevaCriteriaMessage}"
                                                        id="pnevaCriteriaMessage" style="left: 172px; top:-36px;position: absolute; height:3px; width: 544px" styleClass="message">
                                                        <h:outputLabel binding="#{EmployeeHistory$EvaluationNavigation.lblevaCriteriaFormMessage}" id="lblevaCriteriaFormMessage"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="panelLOutNavigator"
                                                        style="height: 250px; margin-left: 5px; margin-top: -5px; left: 30px; top: 59px; position: absolute; width: 730px" styleClass="insideContainerNav">
                                                        <ice:commandButton
                                                            action="#{EmployeeHistory$EvaluationNavigation.buttonEvaluationNavigatorCriteria_action}"
                                                            binding="#{EmployeeHistory$EvaluationNavigation.buttonEvaluationNavigatorCriteria}"
                                                            id="buttonEvaluationNavigatorCriteria" image="/resources/images/Criteria.jpg" style="height: 120px; margin-left: 25px; margin-top: 20px; width: 120px"/>
                                                        <ice:commandButton
                                                            action="#{EmployeeHistory$EvaluationNavigation.buttonEvaluationNavigatorSession_action}"
                                                            binding="#{EmployeeHistory$EvaluationNavigation.buttonEvaluationNavigatorSession}"
                                                            id="buttonEvaluationNavigatorSession" image="/resources/images/Sassion.jpg"
                                                            style="border-color: #023369; background-color: #f4f8f8; font-family: Arial,Helvetica,sans-serif; margin-left: 20px; margin-top: 20px; height: 120px; width: 120px" value="SESSION"/>
                                                        <ice:commandButton
                                                            action="#{EmployeeHistory$EvaluationNavigation.buttonEvaluationNavigatorResult_action}"
                                                            binding="#{EmployeeHistory$EvaluationNavigation.buttonEvaluationNavigatorResult}"
                                                            id="buttonEvaluationNavigatorResult" image="/resources/images/Result.jpg"
                                                            style="border-color: #023369; background-color: #f4f8f8; font-family: Arial,Helvetica,sans-serif; margin-left: 20px; margin-top: 20px; height: 120px; width: 120px" value="RESULT"/>
                                                        <ice:commandButton
                                                            action="#{EmployeeHistory$EvaluationNavigation.buttonEvaluationNavigatorResultDisplay_action}"
                                                            binding="#{EmployeeHistory$EvaluationNavigation.buttonEvaluationNavigatorResultDisplay}"
                                                            id="buttonEvaluationNavigatorResultDisplay" image="/resources/images/ViewResult.jpg"
                                                            style="border-color: #023369; background-color: #f4f8f8; font-family: Arial,Helvetica,sans-serif; margin-left: 20px; margin-top: 10px; height: 120px; width: 120px" value="VIEW RESULT"/>
                                                        <ice:commandButton
                                                            action="#{EmployeeHistory$EvaluationNavigation.buttonEvaluationNavigatorResultResolve_action}"
                                                            binding="#{EmployeeHistory$EvaluationNavigation.buttonEvaluationNavigatorResultResolve}"
                                                            id="buttonEvaluationNavigatorResultResolve" image="/resources/images/Resolve.jpg"
                                                            style="border-color: #023369; background-color: #f4f8f8; font-family: Arial,Helvetica,sans-serif; margin-left: 20px; margin-top: 10px; height: 120px; width: 120px" value="RESOLVE RESULT"/>
                                                        <ice:commandButton action="#{EmployeeHistory$EvaluationNavigation.buttonReport_action}"
                                                            binding="#{EmployeeHistory$EvaluationNavigation.buttonReport}" id="buttonReport"
                                                            image="/resources/images/Report.jpg"
                                                            style="border-color: #023369; background-color: #f4f8f8; font-family: Arial,Helvetica,sans-serif; margin-left: 305px; margin-top: 10px; height: 120px; width: 120px" value="REPORT"/>
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
                        <ice:panelPopup autoCentre="true" binding="#{EmployeeHistory$EvaluationNavigation.evaCriteriaPopUpMsg}" draggable="true"
                            effect="#{EmployeeHistory$EvaluationNavigation.evaCriteriaPopeffectWindow}" id="evaCriteriaPopUpMsg" modal="true" rendered="false" style="display: block; height: 156px; left: 97px; top: 226px; position: absolute; width: 623px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridevaCriteriaPopUpMsg" style="display: block; height: 20px; width: 500px">
                                    <ice:outputText id="lblevaCriteriaPopUpMsgTitle" value="House of People's Representative Human Resource Management System"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupevaCriteriaPopUpMsgBody" style="display: block; height: 94px; position: relative; width: 586">
                                    <ice:commandButton action="#{EmployeeHistory$EvaluationNavigation.btnevaCriteriaPopUpNo_action}"
                                        binding="#{EmployeeHistory$EvaluationNavigation.btnevaCriteriaPopUpNo}" id="btnevaCriteriaPopUpNo" rendered="true"
                                        style="left: 510px; top: 60px; position: absolute; visibility: visible; width: 70px" value="No" visible="true"/>
                                    <ice:commandButton action="#{EmployeeHistory$EvaluationNavigation.btnevaCriteriaPopUpYes_action}"
                                        binding="#{EmployeeHistory$EvaluationNavigation.btnevaCriteriaPopUpYes}" id="btnevaCriteriaPopUpYes" rendered="true"
                                        style="background-position: 0 100%; background-repeat: no-repeat; left: 430px; top: 60px; position: absolute; visibility: visible; width: 70px"
                                        value="Yes" visible="true"/>
                                    <ice:outputText binding="#{EmployeeHistory$EvaluationNavigation.lblevaCriteriaPopUpMsgMain}" id="lblevaCriteriaPopUpMsgMain" style="left:95px; top: 30px; position: absolute; width: 496px"/>
                                    <ice:panelLayout id="panelLayoutImageHolder" rendered="true"
                                        style=" width:62; height:56px; left: 10px; top: 15px; position: absolute;" styleClass="popUpBgimage" visible="true"/>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{EmployeeHistory$EvaluationNavigation.evaCriteriaPurposePopUpMsg}" draggable="true"
                            effect="#{EmployeeHistory$EvaluationNavigation.evaCriteriaPopeffectWindow}" id="evaCriteriaPurposePopUpMsg" modal="true"
                            rendered="false" style="display: block; height: 256px; left: 97px; top: 226px; position: absolute; width: 343px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridevaCriteriaPurposePopUpMsg" style="display: block; height: 20px; width: 300px">
                                    <ice:outputText id="lblevaCriteriaPopUpPurposeMsgTitle" value="You Can Add or Remove Purpose for Evaluation"/>
                                    <ice:commandButton action="#{EmployeeHistory$EvaluationNavigation.buttonClose_action}"
                                        binding="#{EmployeeHistory$EvaluationNavigation.buttonClose}" id="buttonClose" image="/Employee/images/close.png"
                                        style="left:329px; margin-top: -22px; position: absolute; visibility: visible; height:15px; width:15px" value="x"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupevaCriteriaPopUpPurposeMsgBody" style="display: block; height: 194px; position: relative; width: 300">
                                    <ice:panelGroup binding="#{EmployeeHistory$EvaluationNavigation.panelGroupevaCriteriaPopUpPurposeMsgBody11}"
                                        id="panelGroupevaCriteriaPopUpPurposeMsgBody11" rendered="true"
                                        style="top:0px; display: block; height: 50px; position: relative; width: 300" styleClass="insideContainerPop">
                                        <ice:outputText id="popupPurpose" style="font-size: 10px;margin-left: 5px; margin-top: 20px; position: absolute" value="Purpose:"/>
                                        <ice:inputText binding="#{EmployeeHistory$EvaluationNavigation.inputTextPopUpPurpose}" id="inputTextPopUpPurpose" style="margin-left: 60px; margin-top: 10px; position: absolute; width: 150px"/>
                                    </ice:panelGroup>
                                    <ice:panelGroup binding="#{EmployeeHistory$EvaluationNavigation.panelGroupevaCriteriaPopUpPurposeMsgBodyDelete}"
                                        id="panelGroupevaCriteriaPopUpPurposeMsgBodyDelete" rendered="false"
                                        style="top:30px; display: block; height: 50px; position: relative; width: 300" styleClass="insideContainerPop">
                                        <ice:outputText id="popupPurposeDelete" style="font-size: 10px;margin-left: 2px; margin-top: 10px; position: absolute" value="Are you shure you want to delete the record?"/>
                                        <ice:commandButton action="#{EmployeeHistory$EvaluationNavigation.button1_action}"
                                            binding="#{EmployeeHistory$EvaluationNavigation.button1}" id="button1"
                                            style="left:240px; margin-top: 20px; position: absolute; visibility: visible; height:25px; width: 25px" value="Y"/>
                                        <ice:commandButton action="#{EmployeeHistory$EvaluationNavigation.button2_action}"
                                            binding="#{EmployeeHistory$EvaluationNavigation.button2}" id="button2"
                                            style="left:270px; margin-top: 20px; position: absolute; visibility: visible; height:25px; width: 25px" value="N"/>
                                    </ice:panelGroup>
                                    <ice:panelGroup binding="#{EmployeeHistory$EvaluationNavigation.panelGroupevaCriteriaPopUpPurposeMsgBody1}"
                                        id="panelGroupevaCriteriaPopUpPurposeMsgBody1" rendered="true"
                                        style="top:8px; display: block; height: 100px; overflow: auto; position: relative; width: 300" styleClass="insideContainerPop">
                                        <ice:dataTable binding="#{EmployeeHistory$EvaluationNavigation.dataTableAddPurpose}" id="dataTableAddPurpose"
                                            style="left: -2px; top:  -10px; width: 283px; position: absolute"
                                            value="#{EmployeeHistory$EvaluationNavigation.evaResultOPtAddPurpose}" var="currentRow">
                                            <ice:column binding="#{EmployeeHistory$EvaluationNavigation.column1}" id="column1">
                                                <ice:outputText id="outputText1" value="#{currentRow['purpId']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText2" value="Purpose Id"/>
                                                </f:facet>
                                                <ice:rowSelector binding="#{EmployeeHistory$EvaluationNavigation.rowSelectorEvaPurposeAdd}"
                                                    id="rowSelectorEvaPurposeAdd" multiple="false" preStyleOnSelection="true"
                                                    selectionListener="#{EmployeeHistory$EvaluationNavigation.rowSelectorEvaPurposeAdd_processMyEvent}"
                                                    toggleOnClick="true" value="#{currentRow['selected']}"/>
                                            </ice:column>
                                            <ice:column binding="#{EmployeeHistory$EvaluationNavigation.column2}" id="column2">
                                                <ice:outputText id="inputTextPurpAdd" value="#{currentRow['purpName']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText4" value="Purpose Name"/>
                                                </f:facet>
                                            </ice:column>
                                        </ice:dataTable>
                                    </ice:panelGroup>
                                    <ice:panelGroup binding="#{EmployeeHistory$EvaluationNavigation.panelGroupevaCriteriaPopUpPurposeMsgBodyButtons}"
                                        id="panelGroupevaCriteriaPopUpPurposeMsgBodyButtons" rendered="true"
                                        style="top:12px; display: block; height: 30px; position: relative; width: 300" styleClass="insideContainerPop">
                                        <ice:commandButton action="#{EmployeeHistory$EvaluationNavigation.btnevaCriteriaPopUpPurposeNew_action}"
                                            binding="#{EmployeeHistory$EvaluationNavigation.btnevaCriteriaPopUpPurposeNew}" id="btnevaCriteriaPopUpPurposeNew"
                                            rendered="true" style="left: 0px; top: -7px; position: absolute; visibility: visible; height:25px; width: 50px"
                                            value="New" visible="true"/>
                                        <ice:commandButton action="#{EmployeeHistory$EvaluationNavigation.btnevaCriteriaPopUpPurposeEdit_action}"
                                            binding="#{EmployeeHistory$EvaluationNavigation.btnevaCriteriaPopUpPurposeEdit}" id="btnevaCriteriaPopUpPurposeEdit"
                                            rendered="true" style="left: 55px; top: -7px; position: absolute; visibility: visible; height:25px; width: 50px"
                                            value="Edit" visible="true"/>
                                        <ice:commandButton action="#{EmployeeHistory$EvaluationNavigation.btnevaCriteriaPopUpPurposeUpdate_action}"
                                            binding="#{EmployeeHistory$EvaluationNavigation.btnevaCriteriaPopUpPurposeUpdate}"
                                            id="btnevaCriteriaPopUpPurposeUpdate" rendered="true"
                                            style="left: 110px; top: -7px; position: absolute; visibility: visible; height:25px; width: 60px" value="Update" visible="true"/>
                                        <ice:commandButton action="#{EmployeeHistory$EvaluationNavigation.btnevaCriteriaPopUpPurposeDelete_action}"
                                            binding="#{EmployeeHistory$EvaluationNavigation.btnevaCriteriaPopUpPurposeDelete}"
                                            id="btnevaCriteriaPopUpPurposeDelete" rendered="true"
                                            style="background-position: 0 100%; background-repeat: no-repeat; left:175px; top: -7px; position: absolute; visibility: visible; height:25px; width: 60px"
                                            value="Delete" visible="true"/>
                                        <ice:commandButton action="#{EmployeeHistory$EvaluationNavigation.btnevaCriteriaPopUpPurposeCancel_action}"
                                            binding="#{EmployeeHistory$EvaluationNavigation.btnevaCriteriaPopUpPurposeCancel}"
                                            id="btnevaCriteriaPopUpPurposeCancel" rendered="true"
                                            style="background-position: 0 100%; background-repeat: no-repeat; left:240px; top: -7px; position: absolute; visibility: visible; height:25px; width: 60px"
                                            value="Cancel" visible="true"/>
                                    </ice:panelGroup>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
