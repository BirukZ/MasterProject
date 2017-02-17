<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2010, 7:48:31 AM
    Author     : DavePro
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <f:loadBundle basename="Localization.HRLocalization" var="msgs"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <link HREF="../header_icon.ico" REL="icon"/>
                <title>ReportCritera Page</title>
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
                    function ReportPageRegistration(field){

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
                                <ice:panelLayout id="header" layout="flow"
                                    style="height: 129px; left: 0px; position: relative; width: 100%z; -rave-layout: grid" styleClass="header" visible="true">
                                    <jsp:directive.include file="/Header.jspf"/>
                                </ice:panelLayout>
                                <!-- End Header -->
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="west">
                            <ice:panelGroup id="menu_left" style=" height:100%;">
                                <ice:panelLayout id="left_menu1" layout="flow"
                                    style="height: 312px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                    <ice:panelLayout id="list_menu2" style="height: 136px; left: -4px; position: absolute; width: 213px" styleClass="list_menu">
                                        <ice:panelCollapsible expanded="true" id="panelCollapsible2"
                                            style="left: 1px; top: 30px; position: absolute; height:46 px; width: 214px" toggleOnClick="true">
                                            <f:facet name="header">
                                                <ice:panelGroup id="panelGroup2" styleClass="">
                                                    <ice:outputText id="outputText2" value="header Value"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid id="panelGrid1">
                                                <ice:commandLink action="#{ReportCritera$ReportPageRegistration.cmdReportCritera_action}" id="cmdReportCritera" value="ReportGenerationCritera"/>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                    </ice:panelLayout>
                                    <ice:panelLayout id="search" layout="flow"
                                        style="height: 46px; left: -5px; top: 163px; position: absolute; width: 212px; -rave-layout: grid" styleClass="search"/>
                                    <ice:panelLayout id="status" layout="flow"
                                        style="height: 63px; left: -3px; top: 218px; position: absolute; width: 212px; -rave-layout: grid" styleClass="status"/>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="center">
                            <ice:panelGroup dragListener="#{ReportCritera$ReportPageRegistration.page_display_processMyEvent}" id="page_display" style="height: 448px">
                                <ice:panelLayout id="container" layout="flow"
                                    style="height: 410px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                    <ice:panelLayout id="pnl_list_of_Reports"
                                        style="border: 1px solid rgb(204, 204, 204); height: 400px; margin-left: 0px; left: 0px; top: 26px; position: inherit; width: 100%; -rave-layout: grid" styleClass="insideContainerMain">
                                        <ice:outputLabel id="outputLabel1" style="left: 26px; top: 46px; position: absolute" value="Report Page  ID"/>
                                        <ice:outputLabel id="outputLabel2" style="left: 26px; top: 72px; position: absolute" value="Report Page Name"/>
                                        <ice:outputLabel id="outputLabel3" style="left: 26px; top: 104px; position: absolute" value="Report page Description"/>
                                        <ice:inputText binding="#{ReportCritera$ReportPageRegistration.txt_Report_Id}" id="txt_Report_Id" style="left: 160px; top: 44px; position: absolute; width: 207px"/>
                                        <ice:inputText binding="#{ReportCritera$ReportPageRegistration.txt_Report_Name}" id="txt_Report_Name" style="left: 160px; top: 70px; position: absolute; width: 207px"/>
                                        <ice:inputTextarea binding="#{ReportCritera$ReportPageRegistration.txt_Description}" id="txt_Description" style="left: 160px; top: 96px; position: absolute; width: 357px"/>
                                        <ice:panelLayout id="pnl_data_table"
                                            style="border: 1px solid rgb(204, 204, 204); height: 140px; margin-left: 0px; left: 5px; top: 200px; overflow: auto; position: absolute; width: 770px; -rave-layout: grid" styleClass="insideContainerMain">
                                            <ice:dataTable binding="#{ReportCritera$ReportPageRegistration.dataTable1_Report_Page}" id="dataTable1_Report_Page"
                                                style="left: 0px; top: -5px; position: absolute; width: 100%"
                                                value="#{ReportCritera$ReportPageRegistration.reportPageList}" var="currentRow">
                                                <ice:column id="colStatus">
                                                    <ice:outputText id="txtPColumnStatus" value="#{currentRow['status']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="outputText5" value="Status"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="column4">
                                                    <ice:outputText id="lblModuleName" value="#{currentRow['moduleName']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="outputText3" value="Module"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="column1">
                                                    <ice:outputText id="lblReportPageID" value="#{currentRow['reportPageID']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="outputText4" value="Report Page ID"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="column2">
                                                    <ice:outputText id="lblReportPageName" value="#{currentRow['reportPageName']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="outputText6" value="Report Page Name"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="column3">
                                                    <ice:outputText id="lblReportPageDescription" value="#{currentRow['reportPageDescription']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="outputText8" value="Report Page Description"/>
                                                    </f:facet>
                                                </ice:column>
                                            </ice:dataTable>
                                        </ice:panelLayout>
                                        <ice:panelLayout id="pnl_button" layout="flow"
                                            style="border: 1px solid rgb(204, 204, 204); height: 40px; margin-left: 0px; left: 5px; top: 350px; position: inherit; width: 770px; -rave-layout: grid" styleClass="insideContainerMain">
                                            <ice:commandButton action="#{ReportCritera$ReportPageRegistration.btn_Save_action}"
                                                binding="#{ReportCritera$ReportPageRegistration.btn_Save}" id="btn_Save"
                                                style="left: 104px; top: 0px; position: absolute; width: 80px" value="Save"/>
                                            <ice:commandButton action="#{ReportCritera$ReportPageRegistration.btn_Reset_action}"
                                                binding="#{ReportCritera$ReportPageRegistration.btn_Reset}" id="btn_Reset"
                                                style="left: 208px; top: 0px; position: absolute; width: 80px" value="Reset"/>
                                        </ice:panelLayout>
                                        <ice:commandButton action="#{ReportCritera$ReportPageRegistration.btn_Add_Table_action}"
                                            binding="#{ReportCritera$ReportPageRegistration.btn_Add_Table}" id="btn_Add_Table"
                                            style="height: 25px; left: 598px; top: 94px; position: absolute; width: 77px" value="ADD"/>
                                        <ice:outputLabel id="outputLabel4" style="left: 26px; top: 16px; position: absolute" value="Module"/>
                                        <ice:selectOneMenu binding="#{ReportCritera$ReportPageRegistration.drl_catagori}" id="drl_catagori" partialSubmit="true"
                                            style="left: 160px; top: 14px; position: absolute; width: 207px" value="#{ReportCritera$ReportPageRegistration.selectOneMenu1Bean.selectedObject}">
                                            <f:selectItems id="selectOneMenu1selectItems" value="#{ReportCritera$ReportPageRegistration.reportCatagori}"/>
                                        </ice:selectOneMenu>
                                    </ice:panelLayout>
                                    <ice:panelPopup autoCentre="true" binding="#{ReportCritera$ReportPageRegistration.pnlPopupSuccessOrFailure}"
                                        clientOnly="true" draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                                        style="border-style: none; background-color: transparent; display: block; height: 106px; left: -30px; top: 60px; position: absolute; width: 667px" styleClass="message">
                                        <f:facet name="header">
                                            <ice:panelGroup id="pnlGridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                                <ice:outputText id="pnMessageTitle"
                                                    style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="Bunna Human Resource Management System:Message"/>
                                                <ice:commandLink action="#{ReportCritera$ReportPageRegistration.btnClosePopupSuccessOrFailure_action}"
                                                    id="btnClosePopupSuccessOrFailure" immediate="true"
                                                    style="background-image: url(../resources/close_icon.gif); height: 19px; left: 700px; top: 20px; position: absolute; width: 19px"
                                                    styleClass="popupHeaderImage" title="Close Popup"/>
                                            </ice:panelGroup>
                                        </f:facet>
                                        <f:facet name="body">
                                            <ice:panelGroup binding="#{ReportCritera$ReportPageRegistration.panelGroupMessage}" id="panelGroupMessage"
                                                style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                                <ice:panelLayout binding="#{ReportCritera$ReportPageRegistration.pnlMessageBody}" id="pnlMessageBody"
                                                    layout="flow"
                                                    style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                                    <h:outputLabel binding="#{ReportCritera$ReportPageRegistration.lblSuccessOrErrorMessage}"
                                                        id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                                </ice:panelLayout>
                                            </ice:panelGroup>
                                        </f:facet>
                                    </ice:panelPopup>
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
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
