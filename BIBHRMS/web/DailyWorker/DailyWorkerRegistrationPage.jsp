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
                        <img alt="" class="source-image" id="img" src="../resources/images/WholePageBG.png" width="100%"/>
                        <ice:panelBorder id="whole_page" renderCenter="#{DailyWorker$DailyWorkerRegistrationPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{DailyWorker$DailyWorkerRegistrationPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{DailyWorker$DailyWorkerRegistrationPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{DailyWorker$DailyWorkerRegistrationPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{DailyWorker$DailyWorkerRegistrationPage.panelBorder1Bean.renderWest}"
                            style="top: 5px; position: relative; background:transparent;" styleClass="whole_page" width="1024">
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
                                <ice:panelGroup id="menu_left" style="height: 613px;left: 5px; top: 20px; position: relative">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height: 670px; left: 0px; top: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 640px; left: 0px; top: 0px; position: absolute; width: 213px" styleClass="list_menu">
                                            <ice:panelCollapsible expanded="true" id="colsEmployeeSearchByName" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup4" styleClass=""/>
                                                </f:facet>
                                                <ice:panelGrid id="panelGrid4" style="height: 200px; width: 100%;border:none">
                                                    <ice:panelGroup id="commonTasksGroup_Group22" style="width:100%;"/>
                                                    <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                        <li>
                                                            <ice:commandLink action="#{DailyWorker$DailyWorkerRegistrationPage.lnkJob_action}" id="lnkJob"
                                                                style="color:#306682;font-weight:bold" value="Job"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink id="lnkHolydayBonesRequest" style="color:#306682;font-weight:bold" value="Holyday Bones Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink id="lnkYearlyBonesRequest" style="color:#306682;font-weight:bold" value="Yearly Bones Request"/>
                                                        </li>
                                                    </ul>
                                                </ice:panelGrid>
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
                                <ice:panelGroup id="page_display" style="height: 880px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 720px; left: 15px; position: relative; top: 20px; width: 800px; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 850px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Daily Worker"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 800px; left: 0px; top: 0px; position: absolute; width: 100%">
                                                <ice:panelGroup id="leaveRequest" style="height: 745px; width: 95%" styleClass="filedset_normal">
                                                    <ice:panelLayout id="panelDetail12" style="border: 1px solid rgb(204, 204, 204); height: 170px; left: 10px; top: 40px; position: absolute; width: 780px">
                                                        <ice:panelLayout id="lyEmployeeWill" style="display: block; height: 130px; left: 10px; top: 40px; position: absolute; width: 100%">
                                                            <ice:outputLabel id="lblWillFirstName"
                                                                style="font-size: 10px; left: 19px; top: 20px; position: absolute" value="#{msgs.Title}"/>
                                                            <ice:inputText binding="#{DailyWorker$DailyWorkerRegistrationPage.txtWillMiddelName}"
                                                                id="txtWillMiddelName" partialSubmit="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 138px; top: 50px; position: absolute; width: 190px"/>
                                                            <ice:inputText binding="#{DailyWorker$DailyWorkerRegistrationPage.txtRegistrationDate}"
                                                                id="txtRegistrationDate" partialSubmit="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 530px; top: 87px; position: absolute; width: 170px"/>
                                                            <ice:outputLabel id="lblWillMiddleName"
                                                                style="font-size: 10px; left: 19px; top: 54px; position: absolute" value="#{msgs.MidelName}"/>
                                                            <ice:commandButton action="#{DailyWorker$DailyWorkerRegistrationPage.bntWillSave_action}"
                                                                id="bntWillSave" image="/Employee/images/calendar.gif"
                                                                style="left: 684px; top: 90px; position: absolute" value="1"/>
                                                            <ice:outputText id="outputText14"
                                                                style="font-size: 10px; left: 396px; top: 20px; position: absolute" value="#{msgs.FirstName}"/>
                                                            <ice:outputText id="outputText20" style="left: 396px; top: 54px; position: absolute" value="#{msgs.LastName}"/>
                                                            <ice:outputText id="outputText21"
                                                                style="font-size: 10px; left: 396px; top: 88px; position: absolute" value="Registration Date"/>
                                                            <ice:inputText binding="#{DailyWorker$DailyWorkerRegistrationPage.txtWillLastName}"
                                                                id="txtWillLastName" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 530px; top: 50px; position: absolute; width: 190px"/>
                                                            <ice:inputText binding="#{DailyWorker$DailyWorkerRegistrationPage.txtWillFirstName}"
                                                                id="txtWillFirstName" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 530px; top: 14px; position: absolute; width: 190px"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlTitle" id="mesTitle"
                                                                infoClass="infoMessage"
                                                                style="font-size: 11px; left: 270px; top: 20px; position: absolute; width: 100px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtWillMiddelName"
                                                                id="message3" infoClass="infoMessage"
                                                                style="font-size: 11px; left: 170px; top: 70px; position: absolute; width: 100px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="chkFemale" id="mesForGender"
                                                                infoClass="infoMessage"
                                                                style="font-size: 11px; left: 280px; top: 100px; position: absolute; width: 100px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtWillLastName" id="message4"
                                                                infoClass="infoMessage"
                                                                style="font-size: 11px; left: 550px; top: 70px; position: absolute; width: 100px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtWillRegistrationDate"
                                                                id="message5" infoClass="infoMessage"
                                                                style="font-size: 11px; left: 550px; top: 110px; position: absolute; width: 100px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtWillFirstName"
                                                                id="message6" infoClass="infoMessage" rendered="false" showSummary="true"
                                                                style="font-size: 11px; left: 550px; top: 35px; position: absolute; width: 100px" warnClass="warnMessage"/>
                                                            <ice:selectOneMenu binding="#{DailyWorker$DailyWorkerRegistrationPage.drlTitle}" id="drlTitle"
                                                                partialSubmit="true"
                                                                style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); background-image: url(&lt;Not Set&gt;); left: 138px; top: 14px; position: absolute; width: 120px" value="#{DailyWorker$DailyWorkerRegistrationPage.selectOneMenu1Bean.selectedObject}">
                                                                <f:selectItems id="selectOneMenu1selectItems1" value="#{DailyWorker$DailyWorkerRegistrationPage.titleList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:outputText id="lblGender" style="font-size: 10px; left: 19px; top: 88px; position: absolute" value="#{msgs.Sex}"/>
                                                            <ice:outputText id="outputText1" style="font-size: 10px; left: 158px; top: 92px; position: absolute" value="#{msgs.Female}"/>
                                                            <ice:outputText id="outputText2" style="font-size: 10px; left: 230px; top: 92px; position: absolute" value="#{msgs.Male}"/>
                                                            <ice:selectBooleanCheckbox binding="#{DailyWorker$DailyWorkerRegistrationPage.chkFemale}"
                                                                id="chkFemale" partialSubmit="true"
                                                                style="font-family: Georgia,'Times New Roman',times,serif; font-size: 12px; left: 138px; top: 95px; position: absolute"
                                                                value="#{DailyWorker$DailyWorkerRegistrationPage.selectBooleanCheckbox1Bean.selectedBoolean}" valueChangeListener="#{DailyWorker$DailyWorkerRegistrationPage.chkFemale_processValueChange}"/>
                                                            <ice:selectBooleanCheckbox binding="#{DailyWorker$DailyWorkerRegistrationPage.chkMale}" id="chkMale"
                                                                partialSubmit="true"
                                                                style="font-family: Georgia,'Times New Roman',times,serif; font-size: 12px; left: 210px; top: 95px; position: absolute"
                                                                value="#{DailyWorker$DailyWorkerRegistrationPage.selectBooleanCheckbox2Bean.selectedBoolean}" valueChangeListener="#{DailyWorker$DailyWorkerRegistrationPage.chkMale_processValueChange}"/>
                                                            <ice:selectInputDate binding="#{DailyWorker$DailyWorkerRegistrationPage.calRegisterDate}"
                                                                id="calRegisterDate" immediate="true" popupDateFormat="yyyy-MM-dd" renderMonthAsDropdown="true"
                                                                renderYearAsDropdown="true" rendered="false"
                                                                style="left: 490px; top: 112px; position: absolute; width: 170px; z-index: 200"
                                                                value="#{DailyWorker$DailyWorkerRegistrationPage.selectInputDateBean1.date1}" valueChangeListener="#{DailyWorker$DailyWorkerRegistrationPage.calRegisterDate_processValueChange}"/>
                                                        </ice:panelLayout>
                                                        <ice:outputText id="lblRequretment" style="font-size: 10px; left: 29px; top: 20px; position: absolute" value="Requirement Date/Job"/>
                                                        <ice:selectOneMenu binding="#{DailyWorker$DailyWorkerRegistrationPage.drlJob}" id="drlJob"
                                                            partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); left: 150px; top: 15px; position: absolute; width: 580px"
                                                            value="#{DailyWorker$DailyWorkerRegistrationPage.defaultSelectedData2.selectedObject}" valueChangeListener="#{DailyWorker$DailyWorkerRegistrationPage.drlJob_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectItems" value="#{DailyWorker$DailyWorkerRegistrationPage.listOfJobs}"/>
                                                        </ice:selectOneMenu>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="lyWillAddressLocation" style="border: 1px solid rgb(204, 204, 204); height: 120px; left: 10px; top: 220px; overflow: auto; position: absolute; width: 780px">
                                                        <ice:outputText id="lblWillHouseNumber"
                                                            style="font-size: 10px; left: 19px; top: 88px; position: absolute" value="#{msgs.HouseNumber}"/>
                                                        <ice:inputText binding="#{DailyWorker$DailyWorkerRegistrationPage.txtWillHouseNumber}"
                                                            id="txtWillHouseNumber" immediate="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 138px; top: 84px; position: absolute"/>
                                                        <ice:outputText id="lblWellKebele" style="font-size: 10px; left: 396px; top: 54px; position: absolute" value="Kebele"/>
                                                        <ice:outputText id="lblWillRegion" style="font-size: 10px; left: 19px; top: 20px; position: absolute" value="#{msgs.Region}"/>
                                                        <ice:outputText escape="false" id="lblZone"
                                                            style="font-size: 10px; left: 19px; top: 54px; position: absolute" value="#{msgs.Woreda}"/>
                                                        <ice:outputText id="lblWillWoreda" style="font-size: 10px; left: 396px; top: 20px; position: absolute" value="Zone/City"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlZoneCity" id="message7"
                                                            infoClass="infoMessage"
                                                            style="font-size: 11px; left: 550px; top: 35px; position: absolute; width: 100px" warnClass="warnMessage"/>
                                                        <ice:selectOneMenu binding="#{DailyWorker$DailyWorkerRegistrationPage.drlRegion}" id="drlRegion"
                                                            partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); left: 138px; top: 14px; position: absolute; width: 190px"
                                                            value="#{DailyWorker$DailyWorkerRegistrationPage.selectOneMenu4Bean.selectedObject}" valueChangeListener="#{DailyWorker$DailyWorkerRegistrationPage.drlRegion_processValueChange}">
                                                            <f:selectItems id="selectOneMenu4selectItems1" value="#{DailyWorker$DailyWorkerRegistrationPage.region}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectOneMenu binding="#{DailyWorker$DailyWorkerRegistrationPage.drlZoneCity}" id="drlZoneCity"
                                                            partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 500px; top: 14px; position: absolute; width: 190px"
                                                            value="#{DailyWorker$DailyWorkerRegistrationPage.selectOneMenu3Bean.selectedObject}" valueChangeListener="#{DailyWorker$DailyWorkerRegistrationPage.drlZoneCity_processValueChange}">
                                                            <f:selectItems id="selectOneMenu3selectItems1" value="#{DailyWorker$DailyWorkerRegistrationPage.zoneorCityList}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectOneMenu binding="#{DailyWorker$DailyWorkerRegistrationPage.drlWoredaSubCity}"
                                                            id="drlWoredaSubCity" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 138px; top: 50px; position: absolute; width: 190px"
                                                            value="#{DailyWorker$DailyWorkerRegistrationPage.selectOneMenu2Bean.selectedObject}" valueChangeListener="#{DailyWorker$DailyWorkerRegistrationPage.drlWoredaSubCity_processValueChange}">
                                                            <f:selectItems id="selectOneMenu2selectItems1" value="#{DailyWorker$DailyWorkerRegistrationPage.woredaList}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectOneMenu binding="#{DailyWorker$DailyWorkerRegistrationPage.drlKebele}" id="drlKebele"
                                                            partialSubmit="true"
                                                            style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 500px; top: 50px; position: absolute; width: 150px;border: 1px solid rgb(115, 179, 206);" value="#{DailyWorker$DailyWorkerRegistrationPage.defaultSelectedData3.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems2" value="#{DailyWorker$DailyWorkerRegistrationPage.kebeleList}"/>
                                                        </ice:selectOneMenu>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="lyAddLocation" style="border: 1px solid rgb(204, 204, 204); height: 45px; left: 10px; top: 350px; overflow: auto; position: absolute; width: 780px">
                                                        <ice:commandButton action="#{DailyWorker$DailyWorkerRegistrationPage.btnAddToTable_action}"
                                                            id="btnAddToTable" style="left: 500px; width: 150px" value="Add To Table"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="lyWillTable" style="border: 1px solid rgb(204, 204, 204); height: 390px; left: 10px; top: 405px; overflow: auto; position: absolute; width: 780px">
                                                        <ice:dataTable id="dataTable1" style="left: 0px; top: -10px; position: absolute; width: 100%"
                                                            value="#{DailyWorker$DailyWorkerRegistrationPage.listOfDailyWorker}" var="currentRow">
                                                            <ice:column id="colWillTitle">
                                                                <ice:outputText id="tblLblwillTitle" value="#{currentRow['job']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="tblOutwillTitle" value="Job"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colWillSalary">
                                                                <ice:outputText id="lblTblWillSalary" value="#{currentRow['fullName']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outTblwillSalary" value="Full Name"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colwillRegion">
                                                                <ice:outputText id="lblTblWillRegion" value="#{currentRow['region']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outTblWillRegion" value="Region"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colwillZoneorCity">
                                                                <ice:outputText id="lblTblwillZoneorCity" value="#{currentRow['gender']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outTblwillZoneorCity" value="Sex"/>
                                                                </f:facet>
                                                                <ice:rowSelector id="rowSelectorEmployeeWill" multiple="false" preStyleOnSelection="true"
                                                                    selectionListener="#{DailyWorker$DailyWorkerRegistrationPage.rowSelectorEmployeeWill_processMyEvent}"
                                                                    toggleOnClick="true" value="#{currentRow['selected']}"/>
                                                            </ice:column>
                                                            <ice:column id="colwillWoredaorSubCity">
                                                                <ice:outputText id="lblTblWoredaorSubCity" value="#{currentRow['zoneorCityName']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outTblWillWoredaorSubCity" value=" Zone or City"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colwillKebele">
                                                                <ice:outputText id="lblTblwillKebele" value="#{currentRow['woredaorSubCityName']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outTblWillKebele" value="Woreda or SubCity"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colwillHouseNumber">
                                                                <ice:outputText id="lblTblwillHouseNumber" value="#{currentRow['kebele']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outTblWillHouseNumber" value="Kebele"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colwillInternalDocumentNo">
                                                                <ice:outputText id="lblTblwillInternalDocumentNo" value="#{currentRow['houseNumber']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outTblWillInternalDocumentNo" value="House Number"/>
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
                                                    <ice:panelLayout id="lyButton" style="left: 10px; top: 800px; position: absolute; width: 780px" styleClass="insideContainerMain">
                                                        <ice:commandButton action="#{DailyWorker$DailyWorkerRegistrationPage.btnNew_action}" id="btnNew"
                                                            style="margin-left: 25px; width: 100px" value="#{msgs.cmdNew}"/>
                                                        <ice:commandButton action="#{DailyWorker$DailyWorkerRegistrationPage.btnSave_action}" id="btnSave"
                                                            style="margin-left: 40px; width: 100px" value="#{msgs.cmdSave}"/>
                                                        <ice:commandButton id="btnEdite" rendered="false" style="margin-left: 30px; width: 100px" value="#{msgs.cmdEdit}"/>
                                                        <ice:commandButton action="#{DailyWorker$DailyWorkerRegistrationPage.btnUpdate_action}" id="btnUpdate"
                                                            style="margin-left: 40px; width: 100px" value="#{msgs.cmdUpdate}"/>
                                                        <ice:commandButton id="bntReset" style="margin-left: 40px; width: 100px" value="#{msgs.cmdReset}"/>
                                                        <ice:commandButton action="#{DailyWorker$DailyWorkerRegistrationPage.btnDelete_action}" id="btnDelete"
                                                            style="margin-left: 40px; width: 100px" value="#{msgs.cmdDelete}"/>
                                                    </ice:panelLayout>
                                                </ice:panelGroup>
                                            </ice:panelLayout>
                                        </fieldset>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="south">
                                <ice:panelGroup id="page_footer" style=" text-align: left;">
                                    <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">
                                        <ice:outputLabel id="outputLabel1"
                                            style="color: rgb(48, 102, 130); font-family: serif; font-size: 14px; font-style: normal; font-weight: bolder; height: 18px; left: 48px; top: 0px; position: absolute; width: 622px" value="BUNNA INTERNATIONAL BANK Human Resource Management System - Daily Worker ."/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <!--  <ice:panelPopup autoCentre="true" binding="#{Employee$EmployeeWillPage.pnConfirmationMessage}" clientOnly="true" draggable="false"
                            id="pnConfirmationMessage" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlConfirmationMessage" style="background-color:#333333; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnConfirmationTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
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
                                        rendered="true" style="display: block; height: 156px; left: 97px; top: 200px; position: absolute; width: 623px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridevaSessionPopUpMsg" style="display: block; height: 20px; width: 623px">
                                    <ice:outputText id="lblevaSessionPopUpMsgTitle" value="BUNNA INTERNATIONAL BANK Human Resource Management System"/>
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

                        </ice:panelPopup>-->
                        <ice:panelPopup autoCentre="true" binding="#{DailyWorker$DailyWorkerRegistrationPage.pnlPopUpRecruitmentType}" clientOnly="true"
                            draggable="true" id="pnlPopUpRecruitmentType" modal="true" rendered="false" style="display: block; height: 465px; left: 50px; top: 226px; position: absolute; width: 778px">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridPopUpRetireType" styleClass="popupHeaderWrapper">
                                    <ice:outputText id="PopUpRetireTypeTitle" style="width:400px" styleClass="popupHeaderText" value="Daily Worker-Required Position Setting"/>
                                    <ice:commandButton action="#{DailyWorker$DailyWorkerRegistrationPage.modalPnlCloseRetireType_action}" alt="Close"
                                        id="modalPnlCloseRetireType" image="/resources/images/close.gif" immediate="true" partialSubmit="true"
                                        style="left: 754px; top: 2px; position: absolute" styleClass="popupHeaderImage" title="Close Popup" type="button"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="pnlgroupPopUpRetireType" style="display: block; height: 400px; position: relative; width: 730px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:inputTextarea binding="#{DailyWorker$DailyWorkerRegistrationPage.txtDescription}" id="txtDescription" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; height: 75px; left: 142px; top: 270px; position: absolute; width: 500px"/>
                                    <ice:inputText binding="#{DailyWorker$DailyWorkerRegistrationPage.txtDepartemnt}" id="txtDepartemnt" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 142px; top: 70px; position: absolute; width: 504px"/>
                                    <ice:outputLabel id="outputLabeRetireType" style="left: 147px; top: 19px; position: absolute;text-transform:uppercase" value="Daily Worker-Required Position"/>
                                    <ice:outputText id="outputText14RetireType"
                                        style="font-size: 12px; font-style: normal; font-weight: normal; left: 24px; top: 70px; position: absolute" value="Depatment :"/>
                                    <ice:commandButton id="btnRetireTypeDelete" style="left: 550px; top: 355px; position: absolute; width: 80px" value="Cancel"/>
                                    <ice:commandButton action="#{DailyWorker$DailyWorkerRegistrationPage.btnUpdateType_action}" id="btnUpdateType"
                                        style="left: 400px; top: 355px; position: absolute; width: 80px" value="Update"/>
                                    <ice:commandButton action="#{DailyWorker$DailyWorkerRegistrationPage.btnSaveType_action}" id="btnSaveType"
                                        style="left: 270px; top: 355px; position: absolute; width: 80px" value="Save"/>
                                    <ice:commandButton id="btnRetireTypeNew" style="left: 139px; top: 355px; position: absolute; width: 80px" value="New"/>
                                    <ice:outputText id="outputText15RetireType"
                                        style="font-size: 11px; font-style: normal; font-weight: normal; left: 24px; top: 270px; position: absolute" value="Description :"/>
                                    <ice:inputHidden id="lblHRetireTypeID"/>
                                    <label style="left: 20px; top: 575px; border-bottom:0.5px groove #176674; width:700px; position: absolute;"></label>
                                    <label style="left: 20px; top: 40px; border-bottom:0.5px groove #176674; width:700px; position: absolute;"></label>
                                    <ice:commandButton action="#{DailyWorker$DailyWorkerRegistrationPage.btnTree_action}" id="btnTree"
                                        image="/Employee/images/pic3-tree-icon.jpg" style="left: 650px; top: 70px; position: absolute" value="submit"/>
                                    <ice:outputText id="outputText3"
                                        style="font-size: 11px; font-style: normal; font-weight: normal; left: 24px; top: 120px; position: absolute" value="Job Postion"/>
                                    <ice:outputText id="outputText4"
                                        style="font-size: 11px; font-style: normal; font-weight: normal; left: 24px; top: 170px; position: absolute" value="Start Date"/>
                                    <ice:outputText id="lblEndDate"
                                        style="font-size: 11px; font-style: normal; font-weight: normal; left: 400px; top: 170px; position: absolute" value="End Date"/>
                                    <ice:outputText id="outputText6"
                                        style="font-size: 11px; font-style: normal; font-weight: normal; left: 24px; top: 220px; position: absolute" value="Daily Payment"/>
                                    <ice:inputText binding="#{DailyWorker$DailyWorkerRegistrationPage.txtPostion}" id="txtPostion" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 142px; top: 120px; position: absolute; width: 264px"/>
                                    <ice:inputText binding="#{DailyWorker$DailyWorkerRegistrationPage.txtStartDate}" id="txtStartDate" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 142px; top: 170px; position: absolute; width: 200px"/>
                                    <ice:inputText binding="#{DailyWorker$DailyWorkerRegistrationPage.txtEndDate}" id="txtEndDate" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 490px; top: 170px; position: absolute; width: 200px"/>
                                    <ice:inputText binding="#{DailyWorker$DailyWorkerRegistrationPage.txtDailyPayment}" id="txtDailyPayment" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 142px; top: 220px; position: absolute; width: 200px"/>
                                    <ice:commandButton action="#{DailyWorker$DailyWorkerRegistrationPage.btnStartDate_action}" id="btnStartDate"
                                        image="/resources/images/cal_button.gif" style="left: 327px; top: 176px; position: absolute;" value="submit"/>
                                    <ice:commandButton action="#{DailyWorker$DailyWorkerRegistrationPage.btnEndDate_action}" id="btnEndDate"
                                        image="/resources/images/cal_button.gif" style="left: 675px; top: 176px; position: absolute;" value="submit"/>
                                    <ice:selectInputDate binding="#{DailyWorker$DailyWorkerRegistrationPage.calEndDate}" id="calEndDate" rendered="false"
                                        style="left: 492px; top: 190px; position: absolute; height:212px; width: 190px;z-index:100"
                                        value="#{DailyWorker$DailyWorkerRegistrationPage.selectInputDate1Bean.date1}" valueChangeListener="#{DailyWorker$DailyWorkerRegistrationPage.calEndDate_processValueChange}"/>
                                    <ice:selectInputDate binding="#{DailyWorker$DailyWorkerRegistrationPage.calStartDate}" id="calStartDate" rendered="false"
                                        style="height: 212px; left: 143px; top: 190px; position: absolute; width: 190px;z-index:100"
                                        value="#{DailyWorker$DailyWorkerRegistrationPage.selectInputDate2Bean.date1}" valueChangeListener="#{DailyWorker$DailyWorkerRegistrationPage.calStartDate_processValueChange}"/>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{DailyWorker$DailyWorkerRegistrationPage.employeePlanPopUpMsg}" draggable="true"
                            id="employeePlanPopUpMsg" modal="true" rendered="false" style="display: block; height: 156px; left: 97px; top: 226px; position: absolute; width: 623px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridemployeePopUpMsg" style="display: block; height: 20px; width: 500px">
                                    <ice:outputText id="lblemployeePopUpMsgTitle" value="BUNNA INTERNATIONAL BANK Human Resource Management "/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupemployeePopUpMsgBody" style="display: block; height: 94px; position: relative; width:586px">
                                    <ice:commandButton action="#{DailyWorker$DailyWorkerRegistrationPage.btntemployeePopUpNo_action}" id="btntemployeePopUpNo"
                                        immediate="true" partialSubmit="true" rendered="true"
                                        style="left: 510px; top: 60px; position: absolute; visibility: visible; width: 70px" value="No" visible="true"/>
                                    <ice:commandButton action="#{DailyWorker$DailyWorkerRegistrationPage.btntemployeePopUpYes_action}" id="btntemployeePopUpYes"
                                        immediate="true" partialSubmit="true" rendered="true"
                                        style="background-position: 0 100%; background-repeat: no-repeat; left: 430px; top: 60px; position: absolute; visibility: visible; width: 70px"
                                        value="Yes" visible="true"/>
                                    <ice:outputText binding="#{DailyWorker$DailyWorkerRegistrationPage.lblemployeePopUpMsgMain}" id="lblemployeePopUpMsgMain" style="font-size: 18px; left: 95px; top: 30px; position: absolute; width: 496px"/>
                                    <ice:panelLayout id="panelLayoutImageHolderemployee" rendered="true"
                                        style=" width:62; height:56px; left: 10px; top: 15px; position: absolute;" styleClass="popUpBgimage" visible="true"/>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{DailyWorker$DailyWorkerRegistrationPage.pnConfirmationMessage}" clientOnly="true"
                            draggable="false" id="pnConfirmationMessage" modal="true" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px;z-index:400" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlConfirmationMessage" style="background-color:#333333; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnConfirmationTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{DailyWorker$DailyWorkerRegistrationPage.cmdConfirmationCloseMesssage_action}"
                                        id="cmdConfirmationCloseMesssage" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 745px; top: 15px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelConfirmationGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlConfirmationMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{DailyWorker$DailyWorkerRegistrationPage.lblFormMessage4}" id="lblFormMessage4" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{DailyWorker$DailyWorkerRegistrationPage.porganazationSturctue}" clientOnly="true"
                            draggable="false" id="porganazationSturctue" modal="true" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 470px; left: 30px; top: 200px; position: absolute; width: 667px;z-index:200" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:OrganazationStructure"/>
                                    <ice:commandLink action="#{DailyWorker$DailyWorkerRegistrationPage.btnClosePopupOrganazation_action}"
                                        id="btnClosePopupOrganazation" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 700px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="organzationSturcture" style="display: block; height: 450px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="organzationMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 420px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <ice:outputLabel id="outputLabel2" style="left: 416px; top: 6px; position: absolute" value="Position"/>
                                        <ice:tree binding="#{DailyWorker$DailyWorkerRegistrationPage.tree1}" id="tree1"
                                            style="height: 286px; left: 0px; top: 0px; position: absolute; text-align: left; width: 190px"
                                            value="#{DailyWorker$DailyWorkerRegistrationPage.tree1Model.model}" var="item">
                                            <ice:treeNode id="treeNode1">
                                                <f:facet name="icon">
                                                    <ice:panelGroup id="panelGroup2" style="display: inline;">
                                                        <ice:graphicImage id="graphicImage1" value="#{item.userObject.icon}"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <f:facet name="content">
                                                    <ice:panelGroup id="panelGroup3" style="display: inline;">
                                                        <ice:commandLink actionListener="#{DailyWorker$DailyWorkerRegistrationPage.commandLink1_processAction}" id="commandLink1">
                                                            <ice:outputText id="outputText5" value="#{item.userObject.text}"/>
                                                        </ice:commandLink>
                                                    </ice:panelGroup>
                                                </f:facet>
                                            </ice:treeNode>
                                        </ice:tree>
                                        <ice:selectOneMenu binding="#{DailyWorker$DailyWorkerRegistrationPage.drl_Position}" id="drl_Position"
                                            partialSubmit="true" style="left: 466px; top: 5px; position: absolute; width: 155px"
                                            value="#{DailyWorker$DailyWorkerRegistrationPage.defaultSelectedData4.selectedObject}" valueChangeListener="#{DailyWorker$DailyWorkerRegistrationPage.drl_Position_processValueChange}">
                                            <f:selectItems id="selectOneMenu1selectItems3" value="#{DailyWorker$DailyWorkerRegistrationPage.perofation}"/>
                                        </ice:selectOneMenu>
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
