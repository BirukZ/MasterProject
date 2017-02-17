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
        <f:loadBundle basename="Localization.HRLocalization_Termination" var="msgst"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title></title>
                <ice:outputStyle href="../resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="../resources/TempCSS.css"/>
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
                    function DifferentLettersPage(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
                <link HREF="../FederalIcon.ico" REL="icon"/>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <ice:panelBorder id="whole_page" renderCenter="#{Termination$RetirmentManagement.panelBorder1Bean.renderCenter}"
                            renderEast="#{Termination$RetirmentManagement.panelBorder1Bean.renderEast}"
                            renderNorth="#{Termination$RetirmentManagement.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Termination$RetirmentManagement.panelBorder1Bean.renderSouth}"
                            renderWest="#{Termination$RetirmentManagement.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
                            styleClass="whole_page" width="1024">
                            <f:facet name="north">
                                <ice:panelGroup id="page_header" style="height: 117px">
                                    <!-- Begin Header -->
                                    <ice:panelLayout id="header" layout="flow"
                                        style="height: 129px; left: 0px; position: relative; width: 100%z; -rave-layout: grid" styleClass="header" visible="true">
                                        <jsp:directive.include file="/Header.jspf"/>
                                    </ice:panelLayout>
                                    <!-- End Header -->
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="west">
                                <ice:panelGroup id="menu_left" style="border:none; height:470px;">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height:470px;top:15px left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height:470px; left: -4px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Search" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="search_Group_Header"/>
                                                </f:facet>
                                                <ice:panelGrid id="search_panelGrid" width="100%">
                                                    <ice:panelGroup id="btnSearchEmployeeState" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;;border:none;display: block;float:left;height: 55px; width: 100%">
                                                        <ice:outputText id="outputText19" value=""/>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Status" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="status_Group_Header"/>
                                                </f:facet>
                                                <ice:panelGrid id="StatusBoard" width="100%">
                                                    <ice:panelGroup id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;;border:none;display: block;float:left;height:310px; width: 100%"/>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height: 781px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 747px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 780px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Retirment Managment"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 721px; left: 0px; top: 20px; position: absolute; width: 100%">
                                                <ice:panelGroup id="RetirementApproval" style="height: 686px" styleClass="filedset_border">
                                                    <ice:panelLayout id="panelLayout17" layout="flow" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 654px; margin-left: 15px; left: -4px; top: 6px; overflow: auto; position: absolute; width: 732px; -rave-layout: grid">
                                                        <ice:inputText binding="#{Termination$RetirmentManagement.txtDate}" disabled="true" id="txtDate" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 118px; top: 94px; position: absolute; width: 155px"/>
                                                        <ice:outputText id="outputText1" style="left: 24px; top: 72px; position: absolute" value="#{msgst.SelectSector}"/>
                                                        <ice:selectOneMenu binding="#{Termination$RetirmentManagement.lstMainDepartment}" id="lstMainDepartment"
                                                            partialSubmit="true" style="left: 118px; top: 70px; position: absolute; width: 287px"
                                                            value="#{Termination$RetirmentManagement.selectOneMenu1Bean.selectedObject}" valueChangeListener="#{Termination$RetirmentManagement.lstMainDepartment_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectItems" value="#{Termination$RetirmentManagement.zerf}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputText id="outputText2" style="left: 24px; top: 96px; position: absolute" value="#{msgst.Date}"/>
                                                        <ice:outputText id="outputText3" style="left: 24px; top: 120px; position: absolute" value="#{msgst.Age}"/>
                                                        <ice:inputText action="#{Termination$RetirmentManagement.txtAge_action}"
                                                            binding="#{Termination$RetirmentManagement.txtAge}" id="txtAge" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 118px; top: 118px; position: absolute; width: 155px"/>
                                                        <ice:commandButton action="#{Termination$RetirmentManagement.btnFilter_action}"
                                                            binding="#{Termination$RetirmentManagement.btnFilter}" id="btnFilter"
                                                            style="left: 240px; top: 134px; position: absolute; width: 95px" value="#{msgst.btnFilter}"/>
                                                        <ice:outputText id="outputText8"
                                                            style="font-style: normal; font-weight: bold; left: 168px; top: 24px; position: absolute; text-align: center; vertical-align: middle; width: 311px" value="Filtering Criteria"/>
                                                        <ice:commandButton action="#{Termination$RetirmentManagement.btnCalendarSatartDate_action}"
                                                            binding="#{Termination$RetirmentManagement.btnCalendarSatartDate}" id="btnCalendarSatartDate"
                                                            image="/resources/images/cal_icon.JPG" style="left: 264px; top: 96px; position: absolute" value="submit"/>
                                                        <ice:selectInputDate binding="#{Termination$RetirmentManagement.calStartDate}" id="calStartDate"
                                                            rendered="false"
                                                            style="left:250px; top: 16px; position: absolute; height:180px; width: 190px; z-index:20"
                                                            value="#{Termination$RetirmentManagement.selectInputDate1Bean.date1}" valueChangeListener="#{Termination$RetirmentManagement.calStartDate_processValueChange}"/>
                                                        <ice:commandButton action="#{Termination$RetirmentManagement.btnAll_action}"
                                                            binding="#{Termination$RetirmentManagement.btnAll}" id="btnAll"
                                                            style="left: 96px; top: 134px; position: absolute; width: 95px" value="#{msgst.btnAll}"/>
                                                        <ice:commandButton action="#{Termination$RetirmentManagement.btnReset_action}"
                                                            binding="#{Termination$RetirmentManagement.btnReset}" id="btnReset"
                                                            style="left: 384px; top: 134px; position: absolute; width: 95px" value="#{msgst.btnReset}"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="lstMainDepartment" id="message1"
                                                            infoClass="infoMessage"
                                                            style="height: 20px; left: 432px; top: 72px; position: absolute; width: 261px" warnClass="warnMessage"/>
                                                        <ice:panelLayout id="panelLayout16" layout="flow" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 453px; margin-left: 15px; left: -15px; top: 192px; overflow: auto; position: absolute; width: 693px; -rave-layout: grid">
                                                            <ice:dataTable id="tblClearingDep" sortAscending="true"
                                                                style="left: 14px; right: 5px; top: -10px; position: absolute"
                                                                value="#{Termination$RetirmentManagement.readAvailableDepartments}" var="currentRow" width="100%">
                                                                <ice:column id="clmnName" style="width: 191px">
                                                                    <ice:outputText id="outputText9" value="#{currentRow['fullName']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText15" value="Full Name"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="column3" style="width: 50px">
                                                                    <ice:outputText id="outputText11" value="#{currentRow['description']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText12" value="Depertement"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="column4">
                                                                    <ice:outputText id="outputText20" value="#{currentRow['postion']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText21" value="Postion"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="clmnAge1" style="width:10px">
                                                                    <ice:outputText id="outputText13" value="#{currentRow['age']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText16" value="Age"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="clmnAge" style="width: 50px">
                                                                    <ice:outputText id="outputText10" value="#{currentRow['dateOfBirth']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText14" value="Date Of Birth"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="column1" style="width: 50px">
                                                                    <ice:outputText id="outputText4" value="#{currentRow['hireDate']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText5" value="Hire Date"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="column2">
                                                                    <ice:outputText id="outputText6" value="#{currentRow['retirmentNo']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText7" value="RetirmentNo"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                            </ice:dataTable>
                                                        </ice:panelLayout>
                                                        <ice:message errorClass="iceMsgError errorMessage" fatalClass="iceMsgFatal fatalMessage" for="txtAge"
                                                            id="message2" infoClass="iceMsgInfo infoMessage"
                                                            style="height: 20px; left: 288px; top: 120px; position: absolute; width: 70px" warnClass="iceMsgWarn warnMessage"/>
                                                    </ice:panelLayout>
                                                </ice:panelGroup>
                                            </ice:panelLayout>
                                        </fieldset>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="south">
                                <ice:panelGroup id="page_footer">
                                    <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">
                                        <label
                                                style="margin-left:10px;color:white;font-weight:bold;font-family:Cambria">Copyright © 2005-2006 Ethiopian Calander | <a
                                                href="http://www.bunnabanksc.com" style="text-decoration:none;color:orange">Bunna International Bank |Information System Department |Software Division.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" clientOnly="true" draggable="false" id="pnlPopupSuccessOrFailure" rendered="false" style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="Bunna Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Termination$RetirmentManagement.btnClosePopupSuccessOrFailure_action}"
                                        binding="#{Termination$RetirmentManagement.btnClosePopupSuccessOrFailure}" id="btnClosePopupSuccessOrFailure"
                                        immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 20px; position: absolute; width: 19px" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <div class="some" style="visibility:visible; z-index:999; position:absolute; top:-500px; left:-500px;">
                            <input id="cal_day_names" type="hidden" value="ሰ,ማ,ረ,ሐ,ዓ,ቅ,እ"/>
                            <input id="cal_month_names" type="hidden" value="መስከረም,ጥቅምት,ህዳር,ታህሳስ,ጥር,የካቲት,መጋቢት,ሚያዝያ,ግንቦት,ሰኔ,ሀምሌ,ነሀሴ,ጷግሜ"/>
                        </div>
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
