<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : HolydayHonesApprove
    Created on : Dec 17, 2012, 12:25:40 AM
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
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div style="width: 100%">
                        <img alt="" class="source-image" id="img" src="../resources/images/WholePageBG.png" width="100%"/>
                        <ice:panelBorder height="530" id="whole_page" renderCenter="#{EmployeeHistory$HolydayHonesApprove.panelBorder1Bean.renderCenter}"
                            renderEast="#{EmployeeHistory$HolydayHonesApprove.panelBorder1Bean.renderEast}"
                            renderNorth="#{EmployeeHistory$HolydayHonesApprove.panelBorder1Bean.renderNorth}"
                            renderSouth="#{EmployeeHistory$HolydayHonesApprove.panelBorder1Bean.renderSouth}"
                            renderWest="#{EmployeeHistory$HolydayHonesApprove.panelBorder1Bean.renderEast}" style="top: 5px; position: relative"
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
                                        <ice:panelLayout id="list_menu2" style="height: 420px; left: 5px; position: absolute; width: 213px" styleClass="left_menu">
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
                                                                <ice:commandLink action="#{EmployeeHistory$HolydayHonesApprove.commandLink1_action}"
                                                                    id="commandLink1" style="color:#306682;font-weight:bold" value="HolydayHonesApprove"/>
                                                            </li>
                                                            <li>
                                                                <ice:commandLink action="#{EmployeeHistory$HolydayHonesApprove.commandLink3_action}"
                                                                    id="commandLink3" style="color:#306682;font-weight:bold" value="HolydayBonesApprove"/>
                                                            </li>
                                                        </ice:panelSeries>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Status1" style="border-style: none; ">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="status_Group_Header1">
                                                        <ice:outputText id="lblBonesRequest" value="Take Attendance"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="statusBoard1" width="100%">
                                                    <ice:panelGroup id="status_Group1" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;;border:none;display: block;float:left;height:310px; width: 100%">
                                                        <ice:panelLayout id="statusContainer1" style="height: 187px; position: absolute; width: 214px">
                                                            <ice:selectOneListbox id="selectRequestApprovedLists" partialSubmit="true" size="6"
                                                                style="height: 264px; width: 190px"
                                                                value="#{EmployeeHistory$HolydayHonesApprove.selectedRequestFromApprovedList.selectedObject}" valueChangeListener="#{EmployeeHistory$HolydayHonesApprove.selectRequestApprovedLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxRequestListsToBeApproved1" value="#{EmployeeHistory$HolydayHonesApprove.holyDayBonesRequest}"/>
                                                            </ice:selectOneListbox>
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height:490px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 475px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 460px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Holyday Bones Approve (s)"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 450px; left: 0px; top: 0px; position: absolute; width: 100%">
                                                <ice:panelGroup id="RetirementApproval" style="height: 405px; top: 25px; position: absolute" styleClass="filedset_border">
                                                    <label style="left: 20px; top:320px; border-bottom:0.5px groove #176674; width:750px; position: absolute;"></label>
                                                    <label style="left: 20px; top: 365px; border-bottom:0.5px groove #176674; width:750px; position: absolute;"></label>
                                                    <ice:outputText id="lblReligion" style="left: 10px; top: 10px; position: absolute" value="Religion"/>
                                                    <ice:outputText id="lblBonesAmount" style="left: 380px; top: 10px; position: absolute" value="Bones Amount "/>
                                                    <ice:inputText binding="#{EmployeeHistory$HolydayHonesApprove.txtBonesAmount}" id="txtBonesAmount" style="left: 520px; top: 10px; position: absolute"/>
                                                    <ice:commandButton action="#{EmployeeHistory$HolydayHonesApprove.btnSave_action}"
                                                        binding="#{EmployeeHistory$HolydayHonesApprove.btnSave}" id="btnSave"
                                                        style="left: 140px; bottom: 40px; position: absolute; width: 66px" value="Approve"/>
                                                    <ice:commandButton binding="#{EmployeeHistory$HolydayHonesApprove.btnEdit}" id="btnEdit"
                                                        style="left: 260px; bottom: 40px; position: absolute; width: 66px" value="Reject"/>
                                                    <ice:outputText id="lblBranch" style="left: 10px; top: 60px; position: absolute" value="Branch "/>
                                                    <ice:outputText id="lblBonesAmount1" style="left: 380px; top: 60px; position: absolute" value="Date"/>
                                                    <ice:inputText binding="#{EmployeeHistory$HolydayHonesApprove.txtReligion}" id="txtReligion" style="left: 150px; top: 10px; position: absolute; width: 174px"/>
                                                    <ice:inputText binding="#{EmployeeHistory$HolydayHonesApprove.txtBranch}" id="txtBranch" style="left: 150px; top: 60px; position: absolute; width: 174px"/>
                                                    <ice:inputText binding="#{EmployeeHistory$HolydayHonesApprove.txtDate}" id="txtDate" style="left: 520px; top: 60px; position: absolute; width: 174px"/>
                                                    <ice:panelLayout id="pnlOption1"
                                                        style="height: 180px; top: 144px; overflow: auto; position: absolute; width: 715px" styleClass="insideContainerMain">
                                                        <ice:dataTable id="tblEmpsForInc1" style="left:0;top:-10;width:100%;position:absolute"
                                                            value="#{EmployeeHistory$HolydayHonesApprove.holydayBonesManagerList}" var="currentRow"
                                                            varStatus="rowIndex" width="100%">
                                                            <ice:column id="column1No1" style="height: 25px; width: 43px">
                                                                <ice:outputText id="outputText5No1" value="#{rowIndex.index+1}"/>
                                                                <f:facet name="headerNo">
                                                                    <ice:outputText id="outputText6No1" value="No"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="columnEmpId1">
                                                                <ice:outputText id="outputTextEmpId1" value="#{currentRow['empId']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputTextEmpId2" value="Emp Id"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="columnEmpName1">
                                                                <ice:outputText id="outputTextEmpName1" value="#{currentRow['empName']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputTextEmpName2" value="Full Name"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="columnCreligion1">
                                                                <ice:outputText id="outputTextreligion1" value="#{currentRow['religion']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputTextreligion2" value="Religion"/>
                                                                </f:facet>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                    <ice:outputText id="lblHolyDayName" style="left: 10px; top: 100px; position: absolute" value="HolyDayName"/>
                                                    <ice:inputText binding="#{EmployeeHistory$HolydayHonesApprove.txtHolydayName}" id="txtHolydayName" style="left: 150px; top: 100px; position: absolute; width: 174px"/>
                                                </ice:panelGroup>
                                            </ice:panelLayout>
                                        </fieldset>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="south">
                                <ice:panelGroup id="page_footer" style=" text-align: center;">
                                    <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">
                                        <label
                                                style="margin-left:10px;color:#333333;font-weight:bold;font-family:Cambria">Copyright © 2005-2006 Ethiopian Calander | <a
                                                href="http://www.google.com" style="margin-left:10px;color:#333333;">bunna .</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{EmployeeHistory$HolydayHonesApprove.pnMessage}" clientOnly="true" draggable="false"
                            id="pnMessage" rendered="false" style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 400px; position: absolute; width: 751px">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="MCE Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{EmployeeHistory$HolydayHonesApprove.modalPnlCloseMesssage_action}" id="modalPnlCloseMesssage"
                                        immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 700px; top: 20px; position: absolute; width: 19px" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{EmployeeHistory$HolydayBonesRequest.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{EmployeeHistory$HolydayHonesApprove.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{EmployeeHistory$HolydayHonesApprove.lblFormMessage1}" id="lblFormMessage1" style="background-color: #F5F5F5;"/>
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