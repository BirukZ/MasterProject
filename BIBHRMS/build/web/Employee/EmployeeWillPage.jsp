<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2010, 7:48:31 AM
    Author     : Derejec
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
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
                    function RankandPayGradePage(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
                <link HREF="../FederalIcon.ico" REL="icon"/>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <ice:panelBorder id="whole_page" renderCenter="#{Employee$EmployeeWillPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Employee$EmployeeWillPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Employee$EmployeeWillPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Employee$EmployeeWillPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Employee$EmployeeWillPage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative" styleClass="whole_page" width="1024">
                            <f:facet name="north">
                                <ice:panelGroup id="page_header" style="height: 75px">
                                    <!-- Begin Header -->
                                    <ice:panelLayout id="header" layout="flow"
                                        style="height: 75px; left: 0px; position: relative; width: 100%z; -rave-layout: grid" styleClass="header" visible="true">
                                        <jsp:directive.include file="/Header.jspf"/>
                                    </ice:panelLayout>
                                    <!-- End Header -->
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="west">
                                <ice:panelGroup id="menu_left" style="border:none; height:470px;">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height:470px;top:15px left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 470px; left: 5px; top: 60px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Search" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="search_Group_Header">
                                                        <ice:outputText id="lblSearchArea" value="Search Area"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="search_panelGrid" width="100%">
                                                    <ice:panelGroup id="btnSearchEmployeeState" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;;border:none;display: block;float:left;height: 55px; width: 100%">
                                                        <ice:outputText id="outputText19" value=""/>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Common_Tasks" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="commonTasksGroup_header">
                                                        <ice:outputText id="lblCommonTasks" value="Common Tasks"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="commonTasksGroup_Grid11" width="100%">
                                                    <ice:panelGroup id="commonTasksGroup_Group22" style="width:100%"/>
                                                    <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                        <li>
                                                            <ice:commandLink action="#{Employee$EmployeeWillPage.lnkPayrollPeriodLists_action}"
                                                                id="lnkPayrollPeriodLists" style="color:#333333;font-weight:bold" value="Employee "/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Employee$EmployeeWillPage.lnkPayrollSetUp_action}" id="lnkPayrollSetUp"
                                                                style="color:#333333;font-weight:bold" value="Transfer Request "/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Employee$EmployeeWillPage.lnkAccrualEntries_action}"
                                                                id="lnkAccrualEntries" style="color:#333333;font-weight:bold" value="Transfer Approve"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Employee$EmployeeWillPage.lnkPersonalDeductions_action}"
                                                                id="lnkPersonalDeductions" style="color:#333333;font-weight:bold" value="Transfer/Promotion History"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Employee$EmployeeWillPage.lnkGovernmentDeductions_action}"
                                                                id="lnkGovernmentDeductions" style="color:#333333;font-weight:bold" value="Termination"/>
                                                        </li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Status" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="status_Group_Header">
                                                        <ice:outputText id="lblStatus" value="Status"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="StatusBoard" width="100%">
                                                    <ice:panelGroup id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;;border:none;display: block;float:left;height:310px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="position: absolute;height: 187px; width: 100%"/>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height: 985px; left: 0px; top: 45px; position: relative; width: 100%; -rave-layout: grid">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 775px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 910px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Employee Will"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 900px; left: 0px; top: 20px; position: absolute; width: 100%">
                                                <ice:panelGroup id="panEmployeeWill" style="height: 860px; top: 0px" styleClass="filedset_border">
                                                    <ice:commandButton action="#{Employee$EmployeeWillPage.btnSerach_action}" id="btnSerach"
                                                        style="left: 370px; top: 35px; position: absolute; width: 100px" value="Search"/>
                                                    <ice:inputText binding="#{Employee$EmployeeWillPage.txtEmployeeId}" id="txtEmployeeId" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 45px; position: absolute; width: 190px"/>
                                                    <ice:outputText id="outputText7" style="font-family: Cambria; left: 40px; top: 210px; position: absolute" value="Position "/>
                                                    <ice:outputText binding="#{Employee$EmployeeWillPage.lblPostion}" id="lblPostion"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 150px; top: 210px; position: absolute; width: 360px" value="outputText"/>
                                                    <ice:outputText binding="#{Employee$EmployeeWillPage.lblDepartment}" id="lblDepartment"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 150px; top: 150px; position: absolute; width: 410px" value="outputText"/>
                                                    <ice:outputText id="lblOutDepartment"
                                                        style="font-family: Cambria; left: 40px; top: 160px; position: absolute" value="Department "/>
                                                    <ice:selectBooleanCheckbox binding="#{Employee$EmployeeWillPage.choFemale}" disabled="true" id="choFemale"
                                                        partialSubmit="true" style="left: 290px; top: 123px; position: absolute" value="#{Employee$EmployeeWillPage.selectBooleanCheckbox1Bean.selectedBoolean}"/>
                                                    <ice:selectBooleanCheckbox binding="#{Employee$EmployeeWillPage.choMale}" disabled="true" id="choMale"
                                                        partialSubmit="true" style="left: 208px; top: 123px; position: absolute" value="#{Employee$EmployeeWillPage.selectBooleanCheckbox2Bean.selectedBoolean}"/>
                                                    <ice:outputText id="lblGender" style="font-family: Cambria; left: 40px; top: 120px; position: absolute" value="Gender :"/>
                                                    <ice:outputText id="lblEmployeeId" style="font-family: Cambria; left: 40px; top: 40px; position: absolute" value="Employee Id"/>
                                                    <ice:outputText binding="#{Employee$EmployeeWillPage.lblFullName}" id="lblFullName"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 150px; top: 80px; position: absolute; width: 260px" value=":"/>
                                                    <ice:outputText id="outputText3" style="font-family: Cambria; left: 40px; top: 80px; position: absolute" value="Full Name "/>
                                                    <ice:outputText id="outputText2" style="font-family: Cambria; left: 150px; top: 120px; position: absolute" value="Male"/>
                                                    <ice:outputText escape="false" id="outputText1"
                                                        style="font-family: Cambria; left: 250px; top: 120px; position: absolute" value="Female"/>
                                                    <label style="left: 30px; top: 250px; border-bottom:0.5px groove #176674; width:740px; position: absolute;"></label>
                                                    <label style="left: 30px; top: 510px; border-bottom:0.5px groove #176674; width:740px; position: absolute;"></label>
                                                    <ice:panelLayout id="lyEmployeeWill" style="display: block; height: 130px; left: 10px; top: 250px; position: absolute; width: 100%">
                                                        <ice:outputLabel id="lblWillFirstName"
                                                            style="font-size: 10px; left: 19px; top: 20px; position: absolute" value="#{msgs.Title}"/>
                                                        <ice:inputText binding="#{Employee$EmployeeWillPage.txtWillMiddelName}" id="txtWillMiddelName"
                                                            partialSubmit="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 138px; top: 50px; position: absolute; width: 190px"/>
                                                        <ice:inputText binding="#{Employee$EmployeeWillPage.txtWillRegistrationDate}"
                                                            id="txtWillRegistrationDate" partialSubmit="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 500px; top: 87px; position: absolute; width: 170px"/>
                                                        <ice:outputLabel id="lblWillMiddleName"
                                                            style="font-size: 10px; left: 19px; top: 54px; position: absolute" value="#{msgs.MidelName}"/>
                                                        <ice:commandButton id="bntWillSave" image="/Employee/images/calendar.gif"
                                                            style="left: 654px; top: 90px; position: absolute" value="1"/>
                                                        <ice:outputText id="outputText14" style="font-size: 10px; left: 396px; top: 20px; position: absolute" value="#{msgs.FirstName}"/>
                                                        <ice:outputText id="outputText20" style="left: 396px; top: 54px; position: absolute" value="#{msgs.LastName}"/>
                                                        <ice:outputText id="outputText21" style="font-size: 10px; left: 19px; top: 88px; position: absolute" value="#{msgs.Salary}"/>
                                                        <ice:outputText id="outputText22" style="left: 396px; top: 88px; position: absolute" value="Registration Date"/>
                                                        <ice:inputText binding="#{Employee$EmployeeWillPage.txtWillLastName}" id="txtWillLastName" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 500px; top: 50px; position: absolute; width: 190px"/>
                                                        <ice:inputText binding="#{Employee$EmployeeWillPage.txtWillFirstName}" id="txtWillFirstName" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 500px; top: 14px; position: absolute; width: 190px"/>
                                                        <ice:inputText binding="#{Employee$EmployeeWillPage.txtWillSalary}" id="txtWillSalary" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 138px; top: 87px; position: absolute; width: 170px"/>
                                                        <ice:selectOneMenu binding="#{Employee$EmployeeWillPage.drlTitle}" id="drlTitle" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); left: 138px; top: 14px; position: absolute; width: 120px" value="#{Employee$EmployeeWillPage.selectOneMenu1Bean.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems" value="#{Employee$EmployeeWillPage.titleList}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlTitle" id="mesTitle"
                                                            infoClass="infoMessage"
                                                            style="font-size: 11px; left: 270px; top: 20px; position: absolute; width: 100px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtWillSalary" id="message1"
                                                            infoClass="infoMessage"
                                                            style="font-size: 11px; left: 170px; top: 110px; position: absolute; width: 100px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtWillMiddelName" id="message3"
                                                            infoClass="infoMessage"
                                                            style="font-size: 11px; left: 170px; top: 70px; position: absolute; width: 100px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtWillLastName" id="message4"
                                                            infoClass="infoMessage"
                                                            style="font-size: 11px; left: 550px; top: 70px; position: absolute; width: 100px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtWillRegistrationDate"
                                                            id="message5" infoClass="infoMessage"
                                                            style="font-size: 11px; left: 550px; top: 110px; position: absolute; width: 100px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtWillFirstName" id="message6"
                                                            infoClass="infoMessage" rendered="false" showSummary="true"
                                                            style="font-size: 11px; left: 550px; top: 35px; position: absolute; width: 100px" warnClass="warnMessage"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="lyWillAddressLocation" style="border-top: groove rgb(204, 204, 204) 1px; border-bottom: groove rgb(204, 204, 204) 1px; height: 120px; left: 20px; top: 380px; overflow: auto; position: absolute; width: 716px">
                                                        <ice:outputText id="lblWillHouseNumber"
                                                            style="font-size: 10px; left: 19px; top: 88px; position: absolute" value="#{msgs.HouseNumber}"/>
                                                        <ice:inputText binding="#{Employee$EmployeeWillPage.txtWillHouseNumber}" id="txtWillHouseNumber"
                                                            immediate="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 138px; top: 84px; position: absolute"/>
                                                        <ice:outputText id="lblWellKebele" style="font-size: 10px; left: 396px; top: 54px; position: absolute" value="Kebele"/>
                                                        <ice:outputText id="lblWillRegion" style="font-size: 10px; left: 19px; top: 20px; position: absolute" value="#{msgs.Region}"/>
                                                        <ice:outputText escape="false" id="lblZone"
                                                            style="font-size: 10px; left: 19px; top: 54px; position: absolute" value="#{msgs.Woreda}"/>
                                                        <ice:outputText id="lblWillWoreda" style="font-size: 10px; left: 396px; top: 20px; position: absolute" value="Zone/City"/>
                                                        <ice:selectOneMenu binding="#{Employee$EmployeeWillPage.drlRegion}" id="drlRegion" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); left: 138px; top: 14px; position: absolute; width: 190px"
                                                            value="#{Employee$EmployeeWillPage.selectOneMenu2Bean.selectedObject}" valueChangeListener="#{Employee$EmployeeWillPage.drlRegion_processValueChange}">
                                                            <f:selectItems id="selectOneMenu2selectItems" value="#{Employee$EmployeeWillPage.region}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectOneMenu binding="#{Employee$EmployeeWillPage.drlWoredaSubCity}" id="drlWoredaSubCity"
                                                            partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 138px; top: 50px; position: absolute; width: 190px"
                                                            value="#{Employee$EmployeeWillPage.selectOneMenu3Bean.selectedObject}" valueChangeListener="#{Employee$EmployeeWillPage.drlWoredaSubCity_processValueChange}">
                                                            <f:selectItems id="selectOneMenu3selectItems" value="#{Employee$EmployeeWillPage.woredaList}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectOneMenu binding="#{Employee$EmployeeWillPage.drlZoneCity}" id="drlZoneCity"
                                                            partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 500px; top: 14px; position: absolute; width: 190px"
                                                            value="#{Employee$EmployeeWillPage.selectOneMenu4Bean.selectedObject}" valueChangeListener="#{Employee$EmployeeWillPage.drlZoneCity_processValueChange}">
                                                            <f:selectItems id="selectOneMenu4selectItems" value="#{Employee$EmployeeWillPage.zoneorCityList}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectOneMenu binding="#{Employee$EmployeeWillPage.drlKebele}" id="drlKebele" partialSubmit="true"
                                                            style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 500px; top: 50px; position: absolute; width: 150px;border: 1px solid rgb(115, 179, 206);" value="#{Employee$EmployeeWillPage.selectOneMenu5Bean.selectedObject}">
                                                            <f:selectItems id="selectOneMenu5selectItems" value="#{Employee$EmployeeWillPage.kebeleList}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlZoneCity" id="message7"
                                                            infoClass="infoMessage"
                                                            style="font-size: 11px; left: 550px; top: 35px; position: absolute; width: 100px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlRegion" id="message8"
                                                            infoClass="infoMessage"
                                                            style="font-size: 11px; left: 180px; top: 35px; position: absolute; width: 100px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlWoredaSubCity" id="message9"
                                                            infoClass="infoMessage"
                                                            style="font-size: 11px; left: 170px; top: 70px; position: absolute; width: 100px" warnClass="warnMessage"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="lyWillExternalDocument" style="border-top: groove rgb(204, 204, 204) 1px; border-bottom: groove rgb(204, 204, 204) 1px; height: 120px; left: 20px; top: 510px; overflow: auto; position: absolute; width: 716px">
                                                        <ice:outputText id="outputText5" style="font-size: 10px; left: 19px; top: 20px; position: absolute" value="External Doument No"/>
                                                        <ice:outputText id="lblInternalDocumentNo"
                                                            style="font-size: 10px; left: 396px; top: 20px; position: absolute" value="Internal Document No"/>
                                                        <ice:outputText id="outputText8"
                                                            style="font-family: Cambria; left: 230px; top: 50px; position: absolute" value="In Active"/>
                                                        <ice:inputText binding="#{Employee$EmployeeWillPage.txtExternalDoumentNo}" id="txtExternalDoumentNo" style="border: 1px solid rgb(115, 179, 206); left: 138px; top: 14px; position: absolute; width: 190px"/>
                                                        <ice:inputText binding="#{Employee$EmployeeWillPage.txtInternalDocumentNo}" id="txtInternalDocumentNo" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 500px; top: 14px; position: absolute; width: 190px"/>
                                                        <ice:selectBooleanCheckbox binding="#{Employee$EmployeeWillPage.choActive}" id="choActive"
                                                            partialSubmit="true" style="left: 190px; top: 53px; position: absolute"
                                                            value="#{Employee$EmployeeWillPage.selectBooleanCheckbox3Bean.selectedBoolean}" valueChangeListener="#{Employee$EmployeeWillPage.choActive_processValueChange}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Employee$EmployeeWillPage.choInActive}" id="choInActive"
                                                            partialSubmit="true" style="left: 298px; top: 53px; position: absolute"
                                                            value="#{Employee$EmployeeWillPage.selectBooleanCheckbox4Bean.selectedBoolean}" valueChangeListener="#{Employee$EmployeeWillPage.choInActive_processValueChange}"/>
                                                        <ice:outputText id="outputText10" style="font-size: 10px; left: 19px; top: 54px; position: absolute" value="Status"/>
                                                        <ice:outputText id="outputText9"
                                                            style="font-family: Cambria; left: 138px; top: 50px; position: absolute" value="Active"/>
                                                        <ice:commandButton action="#{Employee$EmployeeWillPage.btnAdd_action}"
                                                            binding="#{Employee$EmployeeWillPage.btnAdd}" id="btnAdd"
                                                            style="left: 500px; top: 55px; position: absolute; width: 120px" value="Add"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="choActive" id="message10"
                                                            infoClass="infoMessage"
                                                            style="font-size: 11px; left: 360px; top: 60px; position: absolute; width: 100px" warnClass="warnMessage"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="lyWillTable" style="border: 1px solid rgb(204, 204, 204); height: 200px; left: 30px; top: 615px; overflow: auto; position: absolute; width: 716px;overflow:auto">
                                                        <ice:dataTable id="dataTable1" style="left: 0px; top: -10px; position: absolute; width: 100%"
                                                            value="#{Employee$EmployeeWillPage.employeeWillList}" var="currentRow">
                                                            <ice:column id="colWillTitle">
                                                                <ice:outputText id="tblLblwillTitle" value="#{currentRow['willFullName']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="tblOutwillTitle" value="Will Full Name"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colWillSalary">
                                                                <ice:outputText id="lblTblWillSalary" value="#{currentRow['willSalary']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outTblwillSalary" value="Will Salary"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colwillRegion">
                                                                <ice:outputText id="lblTblWillRegion" value="#{currentRow['willRegion']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outTblWillRegion" value="Region"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colwillZoneorCity">
                                                                <ice:outputText id="lblTblwillZoneorCity" value="#{currentRow['willZoneorCity']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outTblwillZoneorCity" value=" Zone or City"/>
                                                                </f:facet>
                                                                <ice:rowSelector id="rowSelectorEmployeeWill" multiple="false" preStyleOnSelection="true"
                                                                    selectionListener="#{Employee$EmployeeWillPage.rowSelectorEmployeeWill_processMyEvent}"
                                                                    toggleOnClick="true" value="#{currentRow['selected']}"/>
                                                            </ice:column>
                                                            <ice:column id="colwillWoredaorSubCity">
                                                                <ice:outputText id="lblTblWoredaorSubCity" value="#{currentRow['willWoredaorSubCity']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outTblWillWoredaorSubCity" value="Woreda or SubCity"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colwillKebele">
                                                                <ice:outputText id="lblTblwillKebele" value="#{currentRow['willKebele']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outTblWillKebele" value="Kebele"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colwillHouseNumber">
                                                                <ice:outputText id="lblTblwillHouseNumber" value="#{currentRow['willHouseNumber']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outTblWillHouseNumber" value="House Number"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colwillExternalDoumentNo">
                                                                <ice:outputText id="lblTblwillExternalDoumentNo" value="#{currentRow['willExternalDoumentNo']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outTblWillExternalDoumentNo" value="External Doument No"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colwillInternalDocumentNo">
                                                                <ice:outputText id="lblTblwillInternalDocumentNo" value="#{currentRow['willInternalDocumentNo']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outTblWillInternalDocumentNo" value="Internal Document No"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colwillStatus">
                                                                <ice:outputText id="lblTblwillStatus" value="#{currentRow['willStatus']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outTblWillIStatus" value="Status"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colwillRegistrationDate">
                                                                <ice:outputText id="lblTblRegistrationDate" value="#{currentRow['registrationDate']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outTblWillIRegistrationDate" value="Registration Date"/>
                                                                </f:facet>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="lyWillButton" style="left: 20px; top: 825px; position: absolute; width: 710px" styleClass="insideContainerMain">
                                                        <ice:commandButton action="#{Employee$EmployeeWillPage.btnNew_action}" id="btnNew"
                                                            style="margin-left: 30px; width: 80px" value="#{msgs.cmdNew}"/>
                                                        <ice:commandButton action="#{Employee$EmployeeWillPage.btnSave_action}" id="btnSave"
                                                            style="margin-left: 30px; width: 80px" value="#{msgs.cmdSave}"/>
                                                        <ice:commandButton action="#{Employee$EmployeeWillPage.btnUpdate_action}" id="btnUpdate"
                                                            style="margin-left: 30px; width: 80px" value="#{msgs.cmdUpdate}"/>
                                                        <ice:commandButton action="#{Employee$EmployeeWillPage.bntReset_action}" id="bntReset"
                                                            style="margin-left: 30px; width: 80px" value="#{msgs.cmdReset}"/>
                                                        <ice:commandButton action="#{Employee$EmployeeWillPage.btnDelete_action}" id="btnDelete"
                                                            style="margin-left: 30px; width: 80px" value="#{msgs.cmdDelete}"/>
                                                    </ice:panelLayout>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtEmployeeId" id="message2"
                                                        infoClass="infoMessage"
                                                        style="font-size: 11px; left: 180px; top: 70px; position: absolute; width: 100px" warnClass="warnMessage"/>
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
                                                style="margin-left:10px;color:#333333;font-weight:bold;font-family:Cambria">Copyright © 2002-2003 Ethiopian Calander | <a
                                                href="http://www.insa.gov.et" style="margin-left:10px;color:#333333;">Information Network Security Agency |Directorate Of Research Technology |Software Department.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Employee$EmployeeWillPage.pnConfirmationMessage}" clientOnly="true" draggable="false"
                            id="pnConfirmationMessage" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlConfirmationMessage" style="background-color:#333333; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnConfirmationTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="Mugher Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Employee$EmployeeWillPage.cmdConfirmationCloseMesssage_action}" id="cmdConfirmationCloseMesssage"
                                        immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 745px; top: 15px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelConfirmationGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlConfirmationMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Employee$EmployeeWillPage.lblFormMessage}" id="lblFormMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Employee$EmployeeWillPage.willPopUpMsg}" draggable="true" id="willPopUpMsg" modal="true"
                            rendered="false" style="display: block; height: 156px; left: 97px; top: 200px; position: absolute; width: 623px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridevaSessionPopUpMsg" style="display: block; height: 20px; width: 623px">
                                    <ice:outputText id="lblevaSessionPopUpMsgTitle" value="Mugher Cement Enterprise Human Resource Management System"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupEvaSessionPopUpMsgBody" style="display: block; height: 94px; position: relative; width: 586">
                                    <ice:commandButton action="#{Employee$EmployeeWillPage.btnNoPopUp_action}" id="btnNoPopUp" rendered="true"
                                        style="left: 510px; top: 60px; position: absolute; visibility: visible; width: 70px" value="No" visible="true"/>
                                    <ice:commandButton action="#{Employee$EmployeeWillPage.btnYesPopUp_action}" id="btnYesPopUp" rendered="true"
                                        style="background-position: 0 100%; background-repeat: no-repeat; left: 430px; top: 60px; position: absolute; visibility: visible; width: 70px"
                                        value="Yes" visible="true"/>
                                    <ice:outputText binding="#{Employee$EmployeeWillPage.lblMessagePopUpMsgMain}" id="lblMessagePopUpMsgMain"
                                        style="left:95px; top: 30px; position: absolute; width: 496px" value="Are you shure You want to delete this record ?"/>
                                    <ice:panelLayout id="panelLayoutSessionImageHolder" rendered="true"
                                        style=" width:62; height:56px; left: 10px; top: 15px; position: absolute;" styleClass="popUpBgimage" visible="true"/>
                                    <ice:commandButton id="btnYesAddressPopUp" rendered="false"
                                        style="background-position: 0 100%; background-repeat: no-repeat; left: 400px; top: 60px; position: absolute; visibility: visible; width: 70px" value="Yes"/>
                                    <ice:commandButton id="btnNoAddressPopUp" rendered="false"
                                        style="left: 480px; top: 60px; position: absolute; visibility: visible; width: 70px" value="No"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body"/>
                        </ice:panelPopup>
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
