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
                <ice:outputStyle href="../resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="../xmlhttp/css/rime/rime.css"/>
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
                    function IncrementSalaryRequest(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <ice:panelBorder height="480" id="whole_page" renderCenter="#{Page1.panelBorder1Bean.renderCenter}"
                        renderEast="#{Page1.panelBorder1Bean.renderEast}" renderNorth="#{Page1.panelBorder1Bean.renderNorth}"
                        renderSouth="#{Page1.panelBorder1Bean.renderSouth}" renderWest="#{Page1.panelBorder1Bean.renderWest}"
                        style="top: 0px; position: relative" styleClass="whole_page" width="1024">
                        <f:facet name="north">
                            <ice:panelGroup dragListener="#{Page1.panelBorder1north_processMyEvent}" id="page_header" style="height: 117px">
                                <!-- Begin Header -->
                                <ice:panelLayout id="header" layout="flow" style="height: 129px; left: 0px; position: relative; width: 100%; -rave-layout: grid"
                                    styleClass="header" visible="true">
                                    <jsp:directive.include file="/Header.jspf"/>
                                </ice:panelLayout>
                                <!-- End Header -->
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="west">
                            <ice:panelGroup id="menu_left" style=" height:100%;">
                                <ice:panelLayout id="left_menu1" layout="flow"
                                    style="height: 580px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                    <ice:panelLayout id="list_menu2" style="height: 580px; left: -4px; position: absolute; width: 213px" styleClass="list_menu">
                                        <ice:panelCollapsible binding="#{Page1.panelCollapsible2}" expanded="true" id="panelCollapsible2" style="height: 550px;" toggleOnClick="true">
                                            <f:facet name="header">
                                                <ice:panelGroup id="lblCommonTasks" styleClass="">
                                                    <ice:outputText id="lblCommonTasks1" value="Common Tasks"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid id="panelGrid1">
                                                <ice:panelGroup id="lyJobType" style="text-align: left; width: 160px" styleClass="iceDatTblColHdr">
                                                    <ice:commandLink action="#{Look_Up$LuRankAndPayGrad.cmdJobType_action}" id="cmdJobType"
                                                        style="color: rgb(48, 102, 130); font-weight: bold; text-align: left" value="JobType"/>
                                                </ice:panelGroup>
                                                <br/>
                                                <ice:panelGroup id="lyOrganizationStructure" style="text-align: left; width: 160px" styleClass="iceDatTblColHdr">
                                                    <ice:commandLink action="#{Look_Up$LuRankAndPayGrad.cmdOrganizationStructur_action}"
                                                        id="cmdOrganizationStructur" style="color:#306682;font-weight:bold" value="Organization Structur"/>
                                                </ice:panelGroup>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <ice:panelGroup id="lyPayGrade" style="text-align: left; width: 160px" styleClass="iceDatTblColHdr">
                                                    <ice:commandLink action="#{Look_Up$LuRankAndPayGrad.cmdPayGrade_action}" id="cmdPayGrade"
                                                        style="color:#306682;font-weight:bold" value="Pay Grade"/>
                                                </ice:panelGroup>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <br/>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                        <ice:panelCollapsible expanded="true" id="panelCollapsible1" rendered="false">
                                            <f:facet name="header">
                                                <ice:panelGroup id="panelGroup1" styleClass="">
                                                    <ice:outputText id="outputText1" value="header Value"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid id="panelGrid2">
                                                <ice:outputText id="outputText4" value="Text Description"/>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                    </ice:panelLayout>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="center">
                            <ice:panelGroup id="page_display" style="height: 600px">
                                <ice:panelLayout id="container" layout="flow"
                                    style="height: 580px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                    <fieldset class="filedset_css" style="height: 560px;">
                                        <legend class="legend_css">
                                            <ice:outputLabel value="Salary Scale"/>
                                        </legend>
                                        <ice:panelLayout binding="#{Look_Up$LuRankAndPayGrad.pnProfile}" id="pnProfile" style="border-style: none; height: 500px; margin-top: -20px; left: 0px; position: absolute; width: 100%">
                                            <ice:panelLayout binding="#{Look_Up$LuRankAndPayGrad.message}" id="message"
                                                style="left: 0px; top:-67px;position: absolute; width: 720px" styleClass="message">
                                                <ice:outputLabel binding="#{Look_Up$LuRankAndPayGrad.lblFormMessage}" id="lblFormMessage" value="Success"/>
                                            </ice:panelLayout>
                                            <ice:outputText binding="#{Look_Up$LuRankAndPayGrad.lblStatus}" id="lblStatus" rendered="false"
                                                style="left: 235px; top: -25px; position: absolute" value="Status"/>
                                            <ice:panelCollapsible binding="#{Look_Up$LuRankAndPayGrad.colapCivil}" expanded="true" id="colapCivil" style="border:none;border-bottom:1px solid #AAAAAA;margin-bottom:5px;">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="RetirementApproval_Group_Header">
                                                        <ice:outputText binding="#{Look_Up$LuRankAndPayGrad.headMilitayAndCivil}" id="headMilitayAndCivil" value="Members Salary Scale"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="tt" style="border-style: none; height: 500px; width: 100%">
                                                    <ice:panelGroup dragListener="#{Look_Up$LuRankAndPayGrad.lySalaryCivil_processMyEvent}" id="lySalaryCivil"
                                                        style="height: 500px; margin-top: -250px; left: 5px; position: absolute; width: 770px" styleClass="collabsable_bg">
                                                        <ice:outputText binding="#{Look_Up$LuRankAndPayGrad.lblRankAndTitle}" escape="false"
                                                            id="lblRankAndTitle" style="font-size: 10px; left: 38px; top: 39px; position: absolute" value="Rank"/>
                                                        <ice:outputText id="lblBeginningSalary"
                                                            style="font-size: 10px; left: 38px; top: 78px; position: absolute" value="Beginning Salary"/>
                                                        <ice:outputText id="outputText5" style="font-size: 10px; left: 414px; top: 82px; position: absolute" value="Max. Salary"/>
                                                        <ice:inputText binding="#{Look_Up$LuRankAndPayGrad.txtRank}" id="txtRank" rendered="true" style="color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 140px; top: 31px; position: absolute; width: 150px"/>
                                                        <ice:inputText binding="#{Look_Up$LuRankAndPayGrad.txtBigSalary}" id="txtBigSalary"
                                                            style="font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 140px; top: 76px; position: absolute; width: 140px" validator="#{Look_Up$LuRankAndPayGrad.txtBigSalary_validate}"/>
                                                        <ice:inputText binding="#{Look_Up$LuRankAndPayGrad.txtMaxSalary}" id="txtMaxSalary"
                                                            style="font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 513px; top: 76px; position: absolute; width: 140px" validator="#{Look_Up$LuRankAndPayGrad.txtMaxSalary_validate}"/>
                                                        <ice:inputHidden id="inputHidden1"/>
                                                        <ice:commandButton action="#{Look_Up$LuRankAndPayGrad.btnRank_action}"
                                                            binding="#{Look_Up$LuRankAndPayGrad.btnRank}" id="btnRank" image="/Employee/images/btn_search.gif"
                                                            partialSubmit="true" rendered="true" style="left: 228px; top: 34px; position: absolute" value="submit"/>
                                                        <ice:outputText id="lblDescription" style="font-size: 10px; left: 38px; top: 140px; position: absolute" value="Description:"/>
                                                        <ice:inputTextarea binding="#{Look_Up$LuRankAndPayGrad.txtDescription}" id="txtDescription" style="border: 1px solid rgb(134, 182, 210); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; height: 68px; margin-left: 150px; margin-top: 150px; position: absolute; width: 475px"/>
                                                        <ice:panelLayout id="panelLayout2" style="border-top: solid orange 1px; height: 300px; left: 5px; top: 205px; position: absolute; width: 763px">
                                                            <ice:outputText id="lblStepNo" style="font-size: 10px; left: 28px; top: 20px; position: absolute" value="Step No"/>
                                                            <ice:outputText id="lblSalary" style="font-size: 10px; left: 399px; top: 20px; position: absolute" value="Salary"/>
                                                            <ice:selectOneMenu binding="#{Look_Up$LuRankAndPayGrad.drlStepNo}" id="drlStepNo"
                                                                partialSubmit="true"
                                                                style="color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 125px; top: 14px; position: absolute; width: 145px"
                                                                value="#{Look_Up$LuRankAndPayGrad.selectOneMenu1Bean.selectedObject}" valueChangeListener="#{Look_Up$LuRankAndPayGrad.drlStepNo_processValueChange}">
                                                                <f:selectItems id="selectOneMenu1selectItems" value="#{Look_Up$LuRankAndPayGrad.number}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:inputText binding="#{Look_Up$LuRankAndPayGrad.txtSalary1}" id="txtSalary1"
                                                                style="font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 498px; top: 14px; position: absolute; width: 140px" validator="#{Look_Up$LuRankAndPayGrad.txtSalary1_validate}"/>
                                                            <ice:commandButton action="#{Look_Up$LuRankAndPayGrad.btnAdd_action}"
                                                                binding="#{Look_Up$LuRankAndPayGrad.btnAdd}" disabled="true" id="btnAdd"
                                                                style="left: 285px; top: 35px; position: absolute; width: 100px" value="Add"/>
                                                            <ice:panelLayout id="panelLayout16"
                                                                style="border: 1px solid rgb(204, 204, 204); height: 125px; margin-left: 15px; left: 10px; top: 75px; overflow: auto; position: absolute; width: 732px" styleClass="insideContainerMain">
                                                                <ice:dataTable binding="#{Look_Up$LuRankAndPayGrad.tblSalary}" id="tblSalary"
                                                                    style="left: 20px; top: 1px; position: absolute; width: 680px" styleClass="iceDatTblCol"
                                                                    value="#{SessionBean1.payGradList}" var="currentRow">
                                                                    <ice:column id="colStepNo" style="width: 50px;text-align: center;">
                                                                        <ice:outputText id="txtOutText" value="#{currentRow['stepNo']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="lblStepNo" value="Step No"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colSalary" style="text-align: center; width: 250px">
                                                                        <ice:outputText id="txtSalary" value="#{currentRow['salary']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="lblSalary" value="Salary"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colEdit" style="width: 150px;text-align: center;">
                                                                        <ice:commandLink action="#{Look_Up$LuRankAndPayGrad.linkEdit_action}"
                                                                            binding="#{Look_Up$LuRankAndPayGrad.linkEdit}" id="linkEdit" style="color: #34599c" value="Edit"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="lblEdit" value="Edit"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                </ice:dataTable>
                                                            </ice:panelLayout>
                                                            <ice:panelLayout id="lyButton" style="left: 30px; top: 230px; position: absolute">
                                                                <ice:commandButton action="#{Look_Up$LuRankAndPayGrad.btnSave_action}" id="btnSave"
                                                                    style="margin-left: 120px; width: 80px" value="New"/>
                                                                <ice:commandButton action="#{Look_Up$LuRankAndPayGrad.btnUpdate_action}"
                                                                    binding="#{Look_Up$LuRankAndPayGrad.btnUpdate}" id="btnUpdate"
                                                                    style="margin-left: 50px; width: 80px" value="Edit"/>
                                                                <ice:commandButton action="#{Look_Up$LuRankAndPayGrad.btnReset_action}"
                                                                    binding="#{Look_Up$LuRankAndPayGrad.btnReset}" id="btnReset" immediate="true"
                                                                    partialSubmit="true" style="margin-left: 50px; width: 80px" value="Reset"/>
                                                                <ice:commandButton action="#{Look_Up$LuRankAndPayGrad.btnDelete_action}"
                                                                    binding="#{Look_Up$LuRankAndPayGrad.btnDelete}" id="btnDelete"
                                                                    style="margin-left: 50px; width: 80px" value="Delete"/>
                                                            </ice:panelLayout>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlStepNo" id="message6"
                                                                infoClass="infoMessage" showDetail="true"
                                                                style="font-size: 10px; left: 275px; top: 15px; position: absolute" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtSalary1" id="message7"
                                                                infoClass="infoMessage" showDetail="true"
                                                                style="font-size: 10px; left: 643px; top: 15px; position: absolute" warnClass="warnMessage"/>
                                                            <ice:commandButton action="#{Look_Up$LuRankAndPayGrad.button1_action}" id="button1" value="submit"/>
                                                        </ice:panelLayout>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtBigSalary" id="message2"
                                                            infoClass="infoMessage" showDetail="true"
                                                            style="font-size: 10px; left: 285px; top: 80px; position: absolute" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtMaxSalary" id="message3"
                                                            infoClass="infoMessage" showDetail="true"
                                                            style="font-size: 10px; left: 658px; top: 77px; position: absolute" warnClass="warnMessage"/>
                                                        <ice:outputText binding="#{Look_Up$LuRankAndPayGrad.lblErrorMessage}" id="lblErrorMessage"
                                                            rendered="false" style="color: red; font-weight: bold; left: 495px; top: 5px; position: absolute" value="outputText"/>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </fieldset>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="south">
                            <ice:panelGroup id="page_footer" style=" text-align: center;">
                                <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">This is the
                                Footer</ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelBorder>
                    <ice:panelPopup autoCentre="true" binding="#{Look_Up$LuRankAndPayGrad.pnlPopUpMsgConf}" draggable="true" id="pnlPopUpMsgConf" modal="true"
                        rendered="false" style="display: block; height: 156px; left: 97px; top: 226px; position: absolute; width: 623px">
                        <f:facet name="header">
                            <ice:panelGrid id="panelGridPopUpMsgConf" style="display: block; height: 20px; width: 400px">
                                <ice:outputText id="lblPopUpMsgTitleConf" value="BUNNA INTERNATIONAL BANK Human Resource Management System"/>
                            </ice:panelGrid>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGroup dragListener="#{Look_Up$LuRankAndPayGrad.panelGroupPopUpMsgBodyConf_processMyEvent}" id="panelGroupPopUpMsgBodyConf" style="display: block; height: 94px; position: relative; width: 586">
                                <ice:commandButton action="#{Look_Up$LuRankAndPayGrad.btnPopUpNoConf_action}"
                                    binding="#{Look_Up$LuRankAndPayGrad.btnPopUpNoConf}" id="btnPopUpNoConf" rendered="true"
                                    style="left: 450px; top: 60px; position: absolute; visibility: visible; width: 70px" value="No" visible="true"/>
                                <ice:commandButton action="#{Look_Up$LuRankAndPayGrad.btnPopUpYesConf_action}"
                                    binding="#{Look_Up$LuRankAndPayGrad.btnPopUpYesConf}" id="btnPopUpYesConf" rendered="true"
                                    style="background-position: 0 100%; background-repeat: no-repeat; left: 320px; top: 60px; position: absolute; visibility: visible; width: 70px"
                                    value="Yes" visible="true"/>
                                <ice:outputText binding="#{Look_Up$LuRankAndPayGrad.lblPopUpMsgMainConf}" id="lblPopUpMsgMainConf" style="left: 95px; top: 15px; position: absolute; width: 496px"/>
                                <ice:graphicImage binding="#{Look_Up$LuRankAndPayGrad.imgConfirmation}" height="56" id="imgConfirmation"
                                    style="left: 10px; top: 15px; position: absolute" url="/Look_Up/images/edit-delete-icon.png" value="" width="62"/>
                                <ice:commandButton action="#{Look_Up$LuRankAndPayGrad.btnOK_action}" binding="#{Look_Up$LuRankAndPayGrad.btnOK}" id="btnOK"
                                    rendered="false" style="left: 450px; top: 60px; position: absolute; visibility: visible; width: 70px" value="Ok"/>
                                <ice:commandButton action="#{Look_Up$LuRankAndPayGrad.btnOk_action}" binding="#{Look_Up$LuRankAndPayGrad.btnOk}" id="btnOk"
                                    rendered="false" style="left: 450px; top: 60px; position: absolute; visibility: visible; width: 70px" value="Ok"/>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelPopup>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
