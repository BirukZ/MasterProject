<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Templete
    Created on : Dec 26, 2012, 10:33:40 AM
    Author     : Administrator
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Leave Report</title>
                <ice:outputStyle href="../resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="../xmlhttp/css/rime/rime.css"/>
                <ice:outputStyle href="../resources/images/main.css"/>
                <ice:outputStyle href="../resources/TempCSS.css"/>
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
                <!--  <link HREF="../header_icon.ico" REL="icon"/>-->
            </head>
            <body id="outputBody1">
                <ice:form id="form1">
                    <div style="width:100%">
                        <img alt="" class="source-image" id="img" src="../resources/images/WholePageBG.png" width="100%"/>
                        <ice:panelBorder id="whole_page" renderCenter="#{Leave$LeaveReportPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Leave$LeaveReportPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Leave$LeaveReportPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Leave$LeaveReportPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Leave$LeaveReportPage.panelBorder1Bean.renderWest}" style="top: 5px; position: relative; background:transparent;"
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
                                <ice:panelGroup id="menu_left" style="height: 613px; top: 37px; position: relative">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height: 670px; left: 0px; top: 17px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 640px; left: 0px; top: 15px; position: absolute; width: 213px" styleClass="list_menu">
                                            <ice:panelCollapsible id="colsEmployeeSearchByName" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup4" styleClass=""/>
                                                </f:facet>
                                                <ice:panelGrid id="panelGrid4" style="height: 200px; width: 100%;border:none"/>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="colsRequestLisrt">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup1" styleClass=""/>
                                                </f:facet>
                                                <ice:panelGrid id="panelGrid1" width="100%">
                                                    <ice:panelGroup id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:225px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="border-style: none; background-color: transparent; height: 78px; position: absolute; width: 100%"/>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height: 900px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 720px; left: 0px; position: relative; top: 20px; width: 800px; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 800px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="leave report"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 800px; left: 0px; top: 0px; position: absolute; width: 100%">
                                                <ice:panelGroup id="leaveRequest" style="height: 745px; width: 95%" styleClass="filedset_normal">
                                                    <ice:panelLayout id="panelDetail12" style="border: 1px solid rgb(204, 204, 204); height: 300px; left: 10px; top: 40px; position: absolute; width: 780px">
                                                        <ice:outputText id="outputText1" style="font-family: Cambria; left: 40px; top: 29px; position: absolute" value="Employee Department:"/>
                                                        <ice:outputText binding="#{Leave$LeaveReportPage.lblDepartmentName}" id="lblDepartmentName"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 200px; top: 29px; position: absolute; width: 462px" value=":"/>
                                                        <ice:commandButton action="#{Leave$LeaveReportPage.btnTreeDisplay_action}" id="btnTreeDisplay"
                                                            image="/Employee/images/pic3-tree-icon.jpg" style="left: 652px; top: 25px; position: absolute" value="submit"/>
                                                        <ice:selectOneMenu binding="#{Leave$LeaveReportPage.drlReportType}" id="drlReportType"
                                                            partialSubmit="true"
                                                            style="background-color: rgb(242, 246, 240); left: 200px; top: 72px; position: absolute; width: 160px" value="#{Leave$LeaveReportPage.selectOneMenu1Bean.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems" value="#{Leave$LeaveReportPage.listOfRepoetType}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputText id="outputText4" style="font-family: Cambria; left: 40px; top: 72px; position: absolute" value="Ceriteri"/>
                                                        <ice:commandButton action="#{Leave$LeaveReportPage.btnDisplay_action}" id="btnDisplay"
                                                            style="left: 500px; top: 240px; position: absolute; width: 160px" value="Display"/>
                                                        <ice:panelLayout binding="#{Leave$LeaveReportPage.panTreeHolder}" id="panTreeHolder" layout="flow"
                                                            rendered="false"
                                                            style="border-width: 2px; border-style: solid; background-color: rgb(242, 246, 240); height: 360px; left: 210px; top: 54px; overflow: scroll; position: absolute; visibility: visible; width: 400px; z-index: 1000; -rave-layout: grid"
                                                            styleClass="insideContainerMain" visible="true">
                                                            <ice:tree binding="#{Leave$LeaveReportPage.treeLeaveReport}" id="treeLeaveReport"
                                                                style="height: 286px; left: 0px; top: 0px; position: absolute; text-align: left; width: 190px"
                                                                value="#{Leave$LeaveReportPage.tree2Model.model}" var="item">
                                                                <ice:treeNode id="treeNode2">
                                                                    <f:facet name="icon">
                                                                        <ice:panelGroup id="panelGroup3" style="display: inline;">
                                                                            <ice:graphicImage id="graphicImage2" value="#{item.userObject.icon}"/>
                                                                        </ice:panelGroup>
                                                                    </f:facet>
                                                                    <f:facet name="content">
                                                                        <ice:panelGroup id="panelGroup5" style="display: inline;">
                                                                            <ice:commandLink actionListener="#{Leave$LeaveReportPage.cmdTree_processAction}" id="cmdTree">
                                                                                <ice:outputText id="outputText5" value="#{item.userObject.text}"/>
                                                                            </ice:commandLink>
                                                                        </ice:panelGroup>
                                                                    </f:facet>
                                                                </ice:treeNode>
                                                            </ice:tree>
                                                        </ice:panelLayout>
                                                        <ice:selectBooleanCheckbox binding="#{Leave$LeaveReportPage.chkHtml}" id="chkHtml" partialSubmit="true"
                                                            style="left: 235px; top: 205px; position: absolute"
                                                            value="#{Leave$LeaveReportPage.selectBooleanCheckbox1Bean.selectedBoolean}" valueChangeListener="#{Leave$LeaveReportPage.chkHtml_processValueChange}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Leave$LeaveReportPage.chkExcel}" id="chkExcel"
                                                            partialSubmit="true" style="left: 305px; top: 205px; position: absolute"
                                                            value="#{Leave$LeaveReportPage.selectBooleanCheckbox2Bean.selectedBoolean}" valueChangeListener="#{Leave$LeaveReportPage.chkExcel_processValueChange}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Leave$LeaveReportPage.chkWord}" id="chkWord" partialSubmit="true"
                                                            style="font-family: Cambria; left: 370px; top: 205px; position: absolute"
                                                            value="#{Leave$LeaveReportPage.selectBooleanCheckbox3Bean.selectedBoolean}" valueChangeListener="#{Leave$LeaveReportPage.chkWord_processValueChange}"/>
                                                        <ice:outputText id="outputText6"
                                                            style="font-family: Cambria; left: 200px; top: 200px; position: absolute" value="HTML"/>
                                                        <ice:outputText id="outputText3"
                                                            style="font-family: Cambria; left: 270px; top: 200px; position: absolute" value="Excel"/>
                                                        <ice:outputText id="outputText2"
                                                            style="font-family: Cambria; left: 340px; top: 205px; position: absolute" value="Word"/>
                                                        <ice:outputText binding="#{Leave$LeaveReportPage.lblStartDate}" id="lblStartDate"
                                                            style="font-family: Cambria; left: 40px; top: 115px; position: absolute" value="Start"/>
                                                        <ice:outputText binding="#{Leave$LeaveReportPage.lblTo}" id="lblTo"
                                                            style="font-family: Cambria; left: 480px; top: 115px; position: absolute" value="To"/>
                                                        <ice:selectInputDate binding="#{Leave$LeaveReportPage.txtStartDate}" id="txtStartDate"
                                                            popupDateFormat="yyyy-MM-dd" renderAsPopup="true" renderMonthAsDropdown="true"
                                                            renderYearAsDropdown="true"
                                                            style="background-color: rgb(242, 246, 240); left: 200px; top: 115px; position: absolute; width: 205px" value="#{Leave$LeaveReportPage.selectInputDate1Bean.date1}"/>
                                                        <ice:selectInputDate binding="#{Leave$LeaveReportPage.txtEndDate}" id="txtEndDate"
                                                            popupDateFormat="yyyy-MM-dd" renderAsPopup="true" renderMonthAsDropdown="true"
                                                            renderYearAsDropdown="true"
                                                            style="height: 20px; left: 139px; top: 32px; position: absolute; width: 198px; left: 550px; top: 115px; position: absolute; width: 215px" value="#{Leave$LeaveReportPage.selectInputDate2Bean.date1}"/>
                                                    </ice:panelLayout>
                                                </ice:panelGroup>
                                            </ice:panelLayout>
                                        </fieldset>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
