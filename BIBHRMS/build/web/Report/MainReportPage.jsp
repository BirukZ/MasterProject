<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : MainReportPage
    Created on : Jul 10, 2012, 9:55:30 PM
    Author     : PROJECT
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <link href="../hopr.ico" rel="icon"/>
                <title>Main Report page</title>
                <script src="../Script/jquery-1.3.2.min.js"></script>
                <ice:outputStyle href="../resources/ETH/KAMSI_CAL_STYLE.css" id="outputStyle22"/>
                <script src="../resources/ETH/KAMSI_CAL_SCRIPT.js"></script>
                <style type="text/css">
                    .message {
                        display: none;
                        margin: 0 0 13px 0;
                        background-color:#EFA;
                        padding: 0 0 0 0;
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
                    function LeaveRequestPage(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
                <link HREF="../FederalIcon.ico" REL="icon"/>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:outputStyle href="../resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="../xmlhttp/css/rime/rime.css"/>
                <ice:form id="form1">
                    <ice:panelBorder height="480" id="whole_page" renderCenter="#{Report$MainReportPage.panelBorder1Bean.renderCenter}"
                        renderEast="#{Report$MainReportPage.panelBorder1Bean.renderEast}" renderNorth="#{Report$MainReportPage.panelBorder1Bean.renderNorth}"
                        renderSouth="#{Report$MainReportPage.panelBorder1Bean.renderSouth}" renderWest="#{Report$MainReportPage.panelBorder1Bean.renderWest}"
                        style="top: 5px; position: relative" styleClass="whole_page" width="1040">
                        <f:facet name="north">
                            <ice:panelGroup id="page_header" style="height: 75px">
                                <!-- Begin Header -->
                                <ice:panelLayout id="header" layout="flow" style="height: 75px; left: 0px; position: relative; width: 100%; -rave-layout: grid"
                                    styleClass="header" visible="true">
                                    <jsp:directive.include file="/Header.jspf"/>
                                </ice:panelLayout>
                                <!-- End Hetext desader -->
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="west">
                            <ice:panelGroup id="menu_left" style="height: 613px; top: 37px; position: relative">
                                <ice:panelLayout id="left_menu1" layout="flow"
                                    style="height: 670px; left: 0px; top: 17px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                    <ice:panelLayout id="list_menu2"
                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 800px; left: 0px; top: 15px; position: absolute; width: 286px;overflow: auto;" styleClass="list_menu">
                                        <!--
                                        <ice:tree binding="#{Report$MainReportPage.trReport}" id="trReport"
                                            style="height: 286px; left: 0px; top: 0px; position: absolute; text-align: left; width: 190px"
                                            value="#{Report$MainReportPage.tree1Model.model}" var="item">
                                            <ice:treeNode id="treeNode1">
                                                <f:facet name="icon">
                                                    <ice:panelGroup id="panelGroup1" style="display: inline;">
                                                        <ice:graphicImage id="graphicImage1" value="#{item.userObject.icon}"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <f:facet name="content">
                                                    <ice:panelGroup id="panelGroup2" style="display: inline;">
                                                        <ice:commandLink actionListener="#{item.userObject.nodeClicked}" id="commandLink1">
                                                            <ice:outputText id="outputText1" value="#{item.userObject.text}"/>
                                                        </ice:commandLink>
                                                    </ice:panelGroup>
                                                </f:facet>
                                            </ice:treeNode>
                                        </ice:tree>
                                        -->
                                    </ice:panelLayout>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="center">
                            <ice:panelGroup id="page_display" style="height: 860px">
                                <ice:panelLayout id="container" layout="flow"
                                    style="height: 720px; left: 30px; top: 65px; position: relative ; width: 725px; -rave-layout: grid" styleClass="page_display">
                                    <ice:panelLayout id="pnProfile" style="height: 810px; left: 0px; top: 10px; position: absolute; width: 100%">
                                        <ice:panelGroup id="RetirementApproval" style="height: 800px" styleClass="insideContainerMain">
                                            <ice:selectOneMenu id="selectOneMenu1" partialSubmit="true"
                                                style="font-family: 'Cambria'; left: 140px; top: 40px; position: absolute; width: 207px;border: 1px solid rgb(115, 179, 206);" value="#{Report$MainReportPage.selectOneMenu1Bean.selectedObject}">
                                                <f:selectItems id="selectOneMenu1selectItems" value="#{Report$MainReportPage.selectOneMenu1DefaultItems}"/>
                                            </ice:selectOneMenu>
                                            <ice:selectOneMenu id="selectOneMenu2" partialSubmit="true"
                                                style="font-family: 'Cambria'; left: 490px; top: 40px; position: absolute; width: 207px;border: 1px solid rgb(115, 179, 206);" value="#{Report$MainReportPage.selectOneMenu2Bean.selectedObject}">
                                                <f:selectItems id="selectOneMenu2selectItems" value="#{Report$MainReportPage.selectOneMenu2DefaultItems}"/>
                                            </ice:selectOneMenu>
                                            <ice:outputText id="outputText3"
                                                style="font-family: Cambria; font-size: 10px; left: 30px; top: 40px; position: absolute" value="outputText"/>
                                            <ice:outputText id="outputText2"
                                                style="font-family: Cambria; font-size: 10px; left: 410px; top: 40px; position: absolute" value="outputText"/>
                                            <label style="left: 5px; top: 80px; border-bottom:0.5px groove #176674; width:715px; position: absolute;"></label>
                                            <ice:outputText id="lblSelectionCriteria" style="font-family: Cambria; left: 20px; top: 85px; position: absolute" value=" Selection criteria"/>
                                            <ice:outputText id="outputText1"
                                                style="font-family: Cambria; font-size: 10px; font-weight: normal; left: 30px; top: 125px; position: absolute" value="outputText"/>
                                            <ice:outputText id="outputText4" value="outputText"/>
                                            <ice:inputText id="inputText1"/>
                                            <ice:inputText id="inputText2"/>
                                        </ice:panelGroup>
                                    </ice:panelLayout>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="south">
                            <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">
                                <label style="margin-left:10px;color:#FFFFFF;font-weight:bold;font-family:Cambria">Copyright © 2002-2003 Ethiopian Calander | <a
                                        href="http://www.insa.gov.et" style="margin-left:10px;color:#FFFFFF;">INSA</a>
                                </label>
                            </ice:panelLayout>
                        </f:facet>
                    </ice:panelBorder>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
