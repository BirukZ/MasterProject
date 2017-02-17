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
                <title>Employee Registration</title>
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
                <link HREF="../header_icon.ico" REL="icon"/>
            </head>
            <body id="outputBody1">
                <ice:form id="form1">
                    <div style="width:100%">
                        <img alt="" class="source-image" height="620px" id="img" src="../resources/images/WholePageBG.png" width="100%"/>
                        <ice:panelBorder id="whole_page" renderCenter="#{pageSecurity$ErrorReport.panelBorder1Bean.renderCenter}"
                            renderEast="#{pageSecurity$ErrorReport.panelBorder1Bean.renderEast}"
                            renderNorth="#{pageSecurity$ErrorReport.panelBorder1Bean.renderNorth}"
                            renderSouth="#{pageSecurity$ErrorReport.panelBorder1Bean.renderSouth}"
                            renderWest="#{pageSecurity$ErrorReport.panelBorder1Bean.renderWest}"
                            style="background-color: transparent; top: 5px; position: relative;height:100px" styleClass="whole_page" width="1024">
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
                                <ice:panelGroup id="menu_left" style="height: 400px; top: 37px; position: relative">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height: 400px; left: 0px; top: 17px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 400px; left: 0px; top: 15px; position: absolute; width: 213px" styleClass="list_menu">
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
                                <ice:panelGroup id="page_display" style="height: 430px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 400px; left: 10px; top: 20px; position: relative; width: 800px; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 400px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Error Report"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 350px; left: 0px; top: 0px; position: absolute; width: 100%">
                                                <ice:panelGroup id="leaveRequest" style="height: 350px; width: 95%" styleClass="filedset_normal">
                                                    <ice:panelLayout id="panelDetail12" style="border: 1px solid rgb(204, 204, 204); height: 350px; left: 10px; top: 40px; position: absolute; width: 780px">
                                                        <ice:outputText id="outputText1" style="font-size: 10px; left: 38px; top: 20px; position: absolute" value="Page Name"/>
                                                        <ice:selectOneMenu id="drlPageName" partialSubmit="true"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 17px; position: absolute; width: 255px" value="#{pageSecurity$ErrorReport.selectOneMenu1Bean.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems" value="#{pageSecurity$ErrorReport.selectOneMenu1DefaultItems}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputText id="outputText2" style="font-size: 10px; left: 38px; top: 120px; position: absolute" value="Error Report"/>
                                                        <ice:outputText id="lblErrorStatus" style="font-size: 10px; left: 38px; top: 63px; position: absolute" value="Status"/>
                                                        <ice:selectBooleanCheckbox binding="#{pageSecurity$ErrorReport.chkErrorNotSoleved}" disabled="true"
                                                            id="chkErrorNotSoleved" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 150px; top: 64px; position: absolute" value="#{pageSecurity$ErrorReport.selectBooleanCheckbox1Bean.selectedBoolean}"/>
                                                        <ice:selectBooleanCheckbox binding="#{pageSecurity$ErrorReport.chkErrorResolve}" disabled="true"
                                                            id="chkErrorResolve" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 240px; top: 64px; position: absolute" value="#{pageSecurity$ErrorReport.selectBooleanCheckbox2Bean.selectedBoolean}"/>
                                                        <ice:inputTextarea binding="#{pageSecurity$ErrorReport.txtErrorReport}" id="txtErrorReport" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; height: 95px; left: 150px; top: 94px; position: absolute; width: 519px"/>
                                                        <ice:outputText id="outputText5" style="font-size: 11px; left: 175px; top: 64px; position: absolute" value=" Not Resolve "/>
                                                        <ice:outputText id="outputText4" style="font-size: 11px; left: 265px; top: 64px; position: absolute" value="Resolve"/>
                                                        <ice:commandButton action="#{pageSecurity$ErrorReport.btnReport_action}" id="btnReport"
                                                            style="left: 38px; top: 240px; position: absolute; width: 153px" value="Report"/>
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
                                                style="margin-left:20px;color:#0690CE;font-weight:bold;font-family:Cambria">Copyright © 2003-2005 Ethiopian Calander | <a
                                                href="#" style="text-decoration:none;color:#62B77F">MUGHER CEMENT ENTERPRISE  </a> |</label>
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
