<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2010, 7:48:31 AM
    Author     : DavePro
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <f:loadBundle basename="Localization.HRLocalization_SecurityGaurd" var="msgsec"/>
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
                        <ice:panelBorder id="whole_page" renderCenter="#{SecurtyGurd$DifferentLettersPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{SecurtyGurd$DifferentLettersPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{SecurtyGurd$DifferentLettersPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{SecurtyGurd$DifferentLettersPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{SecurtyGurd$DifferentLettersPage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
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
                                <ice:panelGroup id="menu_left" style="border:none; height:470px;">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height:470px; top:15px ;left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu ">
                                        <ice:panelLayout id="list_menu2" style="height: 420px; left: -4px; position: absolute; width: 213px" styleClass="left_menu">
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
                                                    <ice:panelGroup id="status_Group_Header" rendered="false">
                                                        <ice:outputText id="lblStatus" value="Status"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="StatusBoard" width="100%">
                                                    <ice:panelGroup id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;;border:none;display: block;float:left;height:310px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="height: 187px; position: absolute; width: 214px">
                                                            <ice:outputLabel id="lblMsgStatusForRequest" rendered="false"
                                                                style="color: white; font-weight: bold; margin-left: 20px; margin-top: 65px; left: 20px; position: absolute; width: 187px" value="Request History  Board"/>
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height:790px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 775px; left: -10px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 760px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Security Guard"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 770px; left: 0px; top: 15px; position: absolute; width: 100%">
                                                <ice:panelGroup id="RetirementApproval" style="height: 686px; top: 15px; " styleClass="filedset_border">
                                                    <ice:inputHidden id="lblHResignationTypeID"/>
                                                    <ice:outputLabel binding="#{Termination$ClearancePage.outputLabel1}" id="outputLabel1"/>
                                                    <ice:inputHidden binding="#{Termination$ClearancePage.inputHidden1}" id="inputHidden1" value="selected"/>
                                                    <label style="left: 20px; top: 640px; border-bottom:0.5px groove #176674; width:750px; position: absolute;"></label>
                                                    <label style="left: 20px; top: 685px; border-bottom:0.5px groove #176674; width:750px; position: absolute;"></label>
                                                    <ice:panelLayout id="panelLayout16" layout="flow" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 527px; margin-left: 15px; left: 20px; top: 30px; overflow: auto; position: absolute; width: 697px; -rave-layout: grid">
                                                        <ice:outputText id="outputText2"
                                                            style="font-size: 18px; font-weight: bold; left: 216px; top: 24px; position: absolute; text-align: center; width: 188px" value="#{msgsec.Letters}"/>
                                                        <ice:commandLink action="#{SecurtyGurd$DifferentLettersPage.commandLink1_action}" id="commandLink1"
                                                            style="left: 24px; top: 96px; position: absolute" value="#{msgsec.Termination}"/>
                                                        <ice:commandLink action="#{SecurtyGurd$DifferentLettersPage.commandLink2_action}" id="commandLink2"
                                                            style="left: 24px; top: 144px; position: absolute" value="#{msgsec.Discipline}"/>
                                                    </ice:panelLayout>
                                                    <ice:outputText id="outputText1" rendered="false" value="Select Sector :"/>
                                                    <ice:selectOneMenu binding="#{SecurtyGurd$DifferentLettersPage.lstMainDepartment}" id="lstMainDepartment"
                                                        partialSubmit="true" rendered="false" style="width: 286px" value="#{currentRow['status']}">
                                                        <f:selectItems id="selectOneMenu1selectItems"/>
                                                    </ice:selectOneMenu>
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
                                                style="margin-left:10px;color:white;font-weight:bold;font-family:Cambria">Copyright © 2002-2003 Ethiopian Calander | <a
                                                href="http://www.insa.gov.et" style="text-decoration:none;color:orange">Information Network Security Agency |Directorate Of Research Technology |Software Department.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
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
