<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page2
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
            function OrganizationPage(field){

                if (field.defaultValue == field.value) field.value = '';
                else if (field.value == '') field.value = field.defaultValue;

            }
        </script>
                <!-- <link HREF="../header_icon.ico" REL="icon"/>-->
            </head>
            <body id="outputBody1" onload="showCal()" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div style="width:100%">
                        <ice:panelBorder height="476" id="whole_page" renderCenter="#{Organization$OrganizationPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Organization$OrganizationPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Organization$OrganizationPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Organization$OrganizationPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Organization$OrganizationPage.panelBorder1Bean.renderWest}" style="top: 0px; position: relative"
                            styleClass="whole_page" width="1024">
                            <f:facet name="north">
                                <ice:panelGroup dragListener="#{Organization$OrganizationPage.panelBorder1north_processMyEvent}" id="page_header" style="height: 117px">
                                    <ice:panelLayout id="header" layout="flow"
                                        style="height: 129px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="header" visible="true">
                                        <jsp:directive.include file="/Header.jspf"/>
                                    </ice:panelLayout>
                                    <!-- End Header -->
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup dragListener="#{Organization$OrganizationPage.page_display_processMyEvent}" id="page_display" style="height: 757px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 570px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <ice:panelLayout binding="#{Organization$OrganizationPage.message}" id="message"
                                            style="left: 0px; top: -31px; position: absolute; width: 720px" styleClass="message">
                                            <ice:outputLabel binding="#{Organization$OrganizationPage.lblFormMessage}" id="lblFormMessage" value="success"/>
                                        </ice:panelLayout>
                                        <ice:panelTabSet id="panelTabSet1" immediate="true"
                                            style="height: 565px; left: 0px; top: 0px; position: absolute; width: 90%"
                                            tabChangeListener="#{Organization$OrganizationPage.panelTabSet1_processTabChange}" tabPlacement="Top">
                                            <ice:panelTab id="panelTab1" label="Organization Hierarchy">
                                                <ice:panelLayout id="panelLayout2"
                                                    style="height: 663px; left: 0px; top: 0px; overflow: auto; position: relative; width: 100%" styleClass="iceDatTblColHdr">
                                                    <ice:tree binding="#{Organization$OrganizationPage.tree1}" id="tree1"
                                                        style="height: 286px; left: 0px; top: 0px; position: absolute; text-align: left; width: 214px"
                                                        value="#{Organization$OrganizationPage.tree1Model.model}" var="item">
                                                        <ice:treeNode id="treeNode1">
                                                            <f:facet name="icon">
                                                                <ice:panelGroup id="panelGroup1" style="display: inline;">
                                                                    <ice:graphicImage id="graphicImage1" value="#{item.userObject.icon}"/>
                                                                </ice:panelGroup>
                                                            </f:facet>
                                                            <f:facet name="content">
                                                                <ice:panelGroup id="panelGroup3" style="display: inline;">
                                                                    <ice:commandLink
                                                                        actionListener="#{Organization$OrganizationPage.cmdLookDetaileNew_processAction}" id="cmdLookDetaile">
                                                                        <ice:outputText id="outputText1" value="#{item.userObject.text}"/>
                                                                    </ice:commandLink>
                                                                </ice:panelGroup>
                                                            </f:facet>
                                                        </ice:treeNode>
                                                    </ice:tree>
                                                </ice:panelLayout>
                                            </ice:panelTab>
                                            <ice:panelTab id="panelTab2" label="Unit Detail">
                                                <ice:panelLayout id="panelDescription" style="height: 663; left: 0px; top: 0px;  position: relative; width: 100%">
                                                    <ice:panelLayout id="lyDepartemntDetail" style="border: 1px solid rgb(204, 204, 204); height: 240px; margin-left: 15px; left: -15px; top: 0px; position: absolute; width: 100%">
                                                        <ice:outputText id="outputText4" style="font-size: 10px; left: 31px; top: 30px; position: absolute" value="Unit Name"/>
                                                        <ice:outputText id="outputText5" style="font-size: 10px; left: 31px; top: 75px; position: absolute" value="Established Date"/>
                                                        <ice:outputText id="outputText6" style="left: 31px; top: 129px; position: absolute" value="Mission"/>
                                                        <ice:outputText id="outputText7" style="font-size: 10px; left: 38px; top: 190px; position: absolute" value="Vision"/>
                                                        <ice:inputText binding="#{Organization$OrganizationPage.txtUnitname}" id="txtUnitname" required="true" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 30px; position: absolute; width: 639px"/>
                                                        <ice:inputText binding="#{Organization$OrganizationPage.txtEstablishedDate}" id="txtEstablishedDate"
                                                            required="true" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 158px; top: 75px; position: absolute; width: 190px"/>
                                                        <ice:inputTextarea binding="#{Organization$OrganizationPage.txtMission}" id="txtMission" required="true" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 158px; top: 115px; position: absolute; width: 631px"/>
                                                        <ice:inputTextarea binding="#{Organization$OrganizationPage.txtVision}" id="txtVision" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 158px; top: 182px; position: absolute; width: 631px"/>
                                                        <ice:selectOneMenu binding="#{Organization$OrganizationPage.drlAddressCode}" id="drlAddressCode"
                                                            partialSubmit="true"
                                                            style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 600px; top: 75px; position: absolute; width: 139px" value="#{Organization$OrganizationPage.defaultSelectedDataAddressCode.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItemsAddressCode" value="#{Organization$OrganizationPage.addressCodeList}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectInputDate binding="#{Organization$OrganizationPage.calEstablishedDate}"
                                                            id="calEstablishedDate" rendered="false" style="left: 100px; top: 0px; position: absolute;"
                                                            value="#{Organization$OrganizationPage.selectInputDate1Bean.date1}" valueChangeListener="#{Organization$OrganizationPage.calEstablishedDate_processValueChange}"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="panelLayout16" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 324px; margin-left: 15px; left: -15px; top: 250px; position: absolute; width: 100%">
                                                        <ice:panelLayout id="lyForTable" style="border: 1px solid rgb(204, 204, 204); height: 150px; margin-left: 15px; left: -5px; top: 150px; overflow: auto; position: absolute; width: 97%">
                                                            <ice:dataTable binding="#{Organization$OrganizationPage.tblJob}" id="tblJob"
                                                                style="left:0px; top:-10px; position: absolute; width: 100%;"
                                                                value="#{Organization$OrganizationPage.departmentList}" var="currentRow">
                                                                <ice:column id="column1" style="text-align: center; width: 50px">
                                                                    <ice:outputText id="outputText7" value="#{currentRow['allowedJobName']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText8" value="Job Type"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="column2" style="font-size: 10px; text-align: center; width: 50px">
                                                                    <ice:outputText id="outputText9" value="#{currentRow['deptJobCode']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText binding="#{Organization$OrganizationPage.outputText10}"
                                                                            id="outputText10" value="Job Code"/>
                                                                    </f:facet>
                                                                    <ice:rowSelector binding="#{Organization$OrganizationPage.rowSelectorZoneOrCity}"
                                                                        id="rowSelectorZoneOrCity" multiple="false" preStyleOnSelection="true"
                                                                        selectionListener="#{Organization$OrganizationPage.rowSelectorZoneOrCity_processMyEvent}"
                                                                        toggleOnClick="true" value="#{currentRow['selectedJob']}"/>
                                                                </ice:column>
                                                                <ice:column id="colNumberOfEmployee" style="font-size: 10px; text-align: center; width: 50px">
                                                                    <ice:outputText id="outputTextNumberOfEmployee2" value="#{currentRow['numberOfEmployee']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText binding="#{Organization$OrganizationPage.outputTextNumberOfEmployee}"
                                                                            id="outTextNumberOfEmployee" value="NumberOfEmployee"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                            </ice:dataTable>
                                                        </ice:panelLayout>
                                                        <ice:outputText id="lblJobType" style="font-size: 10px; left: 31px; top: 15px; position: absolute" value="Job Type"/>
                                                        <ice:outputText id="lblJobCode" style="font-size: 10px; left: 432px; top: 21px; position: absolute" value="Job Code"/>
                                                        <ice:outputText id="lblQuantity" style="font-size: 10px; left: 31px; top: 65px; position: absolute" value="Quantity"/>
                                                        <ice:selectOneMenu binding="#{Organization$OrganizationPage.drlJobType}" id="drlJobType"
                                                            partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 158px; top: 15px; position: absolute; width: 170px"
                                                            value="#{Organization$OrganizationPage.selectOneMenu2Bean.selectedObject}" valueChangeListener="#{Organization$OrganizationPage.drlJobType_processValueChange}">
                                                            <f:selectItems id="selectOneMenu2selectItems" value="#{Organization$OrganizationPage.jobOptBY}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:inputText binding="#{Organization$OrganizationPage.txtJobCode}" disabled="true" id="txtJobCode" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 506px; top: 15px; position: absolute; width: 139px"/>
                                                        <ice:inputText binding="#{Organization$OrganizationPage.txtEmployeeQuantity}" id="txtEmployeeQuantity" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 158px; top: 65px; position: absolute; width: 127px"/>
                                                        <ice:commandButton action="#{Organization$OrganizationPage.btnAdd_action}"
                                                            binding="#{Organization$OrganizationPage.btnAdd}" id="btnAdd"
                                                            style="left: 600px; top: 100px; position: absolute; width: 143px" value="Add"/>
                                                        <ice:selectBooleanCheckbox binding="#{Organization$OrganizationPage.choSaveJob}" id="choSaveJob"
                                                            partialSubmit="true" style="left: 430px; top: 57px; position: absolute"
                                                            value="#{Organization$OrganizationPage.defaultSelectedData3.selectedBoolean}" valueChangeListener="#{Organization$OrganizationPage.choSaveJob_processValueChange}"/>
                                                        <ice:outputText id="outputText2" style="font-size: 10px; left: 490px; top: 55px; position: absolute" value="To Modify Department  Job Click here   "/>
                                                        <ice:outputText binding="#{Organization$OrganizationPage.lblErrorMessage}" id="lblErrorMessage"
                                                            rendered="false"
                                                            style="color: red; font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: bold; left: 340px; top: 15px; position: absolute" value="Required "/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="panelLayout3" style="border: 1px solid rgb(204, 204, 204); height: 45px; margin-left: 2px; left: 0px; top: 600px; position: absolute; width: 100%; -rave-layout: grid">
                                                        <ice:commandButton action="#{Organization$OrganizationPage.btnNew_action}"
                                                            binding="#{Organization$OrganizationPage.btnNew}" disabled="true" id="btnNew"
                                                            style="margin-left: 30px; width: 100px" value="#{msgs.cmdNew}"/>
                                                        <ice:commandButton action="#{Organization$OrganizationPage.btnSave_action}"
                                                            binding="#{Organization$OrganizationPage.btnSave}" id="btnSave"
                                                            style="margin-left: 50px; width: 100px" value="#{msgs.cmdSave}"/>
                                                        <ice:commandButton action="#{Organization$OrganizationPage.btnEdit_action}"
                                                            binding="#{Organization$OrganizationPage.btnEdit}" id="btnEdit"
                                                            style="margin-left: 50px; width: 100px" value="#{msgs.cmdEdit}"/>
                                                        <ice:commandButton action="#{Organization$OrganizationPage.btnUpdate_action}"
                                                            binding="#{Organization$OrganizationPage.btnUpdate}" disabled="true" id="btnUpdate"
                                                            style="margin-left: 50px; width: 100px" value="#{msgs.cmdUpdate}"/>
                                                        <ice:commandButton action="#{Organization$OrganizationPage.btnReset_action}"
                                                            binding="#{Organization$OrganizationPage.btnReset}" id="btnReset" partialSubmit="true"
                                                            style="margin-left: 50px; width: 100px" value="#{msgs.cmdReset}"/>
                                                        <ice:commandButton action="#{Organization$OrganizationPage.btnDelete_action}"
                                                            binding="#{Organization$OrganizationPage.btnDelete}" id="btnDelete"
                                                            style="margin-left: 50px; width: 100px" value="#{msgs.cmdDelete}"/>
                                                    </ice:panelLayout>
                                                    <ice:outputText binding="#{Organization$OrganizationPage.lblDepartment}" id="lblDepartment" style="font-size: 10px; left: 31px; top: 0px; position: absolute"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtUnitname" id="message1"
                                                        infoClass="infoMessage" style="font-size: 10px; left: 800px; top: 32px; position: absolute" warnClass="warnMessage"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtEstablishedDate" id="message2"
                                                        infoClass="infoMessage" style="font-size: 10px; left: 360px; top: 76px; position: absolute" warnClass="warnMessage"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtMission" id="message3"
                                                        infoClass="infoMessage" style="font-size: 10px; left: 800px; top: 129px; position: absolute" warnClass="warnMessage"/>
                                                    <ice:commandButton action="#{Organization$OrganizationPage.btnCalender_action}" id="btnCalender"
                                                        image="/resources/images/cal_icon.JPG" partialSubmit="true"
                                                        style="left: 332px; top: 77px; position: absolute" value="submit"/>
                                                </ice:panelLayout>
                                            </ice:panelTab>
                                            <ice:panelTab id="tbUnitAddress" label="Unit Address" rendered="false" style="height: 23px; vertical-align: bottom; width: 193px">
                                                <ice:panelLayout id="lyunitAddress"
                                                    style="height: 490px; left: -20px; top: -20px; position: relative; width: 100%" styleClass="filedset_border">
                                                    <ice:outputText id="outputText11" style="left: 31px; top: 46px; position: absolute" value="Region:"/>
                                                    <ice:outputText id="outputText12" style="left: 31px; top: 93px; position: absolute" value="Woreda/Sub City"/>
                                                    <ice:outputText id="outputText13" style="left: 31px; top: 140px; position: absolute" value="Block No"/>
                                                    <ice:outputText id="outputText14" style="left: 426px; top: 46px; position: absolute" value="Zone/City"/>
                                                    <ice:outputText id="outputText15" style="left: 426px; top: 93px; position: absolute" value="Kebelle"/>
                                                    <ice:outputText id="outputText16" style="left: 426px; top: 140px; position: absolute" value="Floor"/>
                                                    <ice:selectOneMenu binding="#{Organization$OrganizationPage.drlRegion}" id="drlRegion" partialSubmit="true"
                                                        style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 158px; top: 45px; position: absolute; width: 140px"
                                                        value="#{Organization$OrganizationPage.selectOneMenu1Bean.selectedObject}" valueChangeListener="#{Organization$OrganizationPage.drlRegion_processValueChange}">
                                                        <f:selectItems id="selectOneMenu1selectItems" value="#{Organization$OrganizationPage.religon}"/>
                                                    </ice:selectOneMenu>
                                                    <ice:selectOneMenu binding="#{Organization$OrganizationPage.drlZoneCity}" id="drlZoneCity"
                                                        partialSubmit="true"
                                                        style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 525px; top: 45px; position: absolute; width: 140px"
                                                        value="#{Organization$OrganizationPage.defaultSelectedData2.selectedObject}" valueChangeListener="#{Organization$OrganizationPage.drlZoneCity_processValueChange}">
                                                        <f:selectItems id="selectOneMenu2selectItems1" value="#{Organization$OrganizationPage.zoneCityType}"/>
                                                    </ice:selectOneMenu>
                                                    <ice:selectOneMenu binding="#{Organization$OrganizationPage.drlWoreda}" id="drlWoreda" partialSubmit="true"
                                                        style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 158px; top: 92px; position: absolute; width: 140px"
                                                        value="#{Organization$OrganizationPage.selectOneMenu3Bean.selectedObject}" valueChangeListener="#{Organization$OrganizationPage.drlWoreda_processValueChange}">
                                                        <f:selectItems id="selectOneMenu3selectItems" value="#{Organization$OrganizationPage.woreda}"/>
                                                    </ice:selectOneMenu>
                                                    <ice:selectOneMenu binding="#{Organization$OrganizationPage.drlKebelle}" id="drlKebelle"
                                                        partialSubmit="true"
                                                        style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 525px; top: 92px; position: absolute; width: 140px" value="#{Organization$OrganizationPage.selectOneMenu4Bean.selectedObject}">
                                                        <f:selectItems id="selectOneMenu4selectItems" value="#{Organization$OrganizationPage.optKebele}"/>
                                                    </ice:selectOneMenu>
                                                    <ice:inputText binding="#{Organization$OrganizationPage.txtBlockNo}" id="txtBlockNo" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 158px; top: 137px; position: absolute; width: 140px"/>
                                                    <ice:inputText binding="#{Organization$OrganizationPage.txtFloor}" id="txtFloor" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 525px; top: 137px; position: absolute; width: 140px"/>
                                                    <ice:panelLayout id="panelLayout1" style="border-top: solid orange 1px; border-bottom: solid orange 1px; height: 180px; left: 0px; top: 185px; position: absoute; width: 100%">
                                                        <ice:outputText id="outputText17" style="left: 31px; top: 26px; position: absolute" value="Tel Office "/>
                                                        <ice:outputText id="outputText18" style="left: 31px; top: 73px; position: absolute" value="Tel Extension"/>
                                                        <ice:outputText id="outputText19" style="left: 31px; top: 120px; position: absolute" value="Mobile"/>
                                                        <ice:outputText id="outputText20" style="left: 426px; top: 26px; position: absolute" value="Office Number"/>
                                                        <ice:outputText id="outputText21" style="left: 426px; top: 73px; position: absolute" value="E-mail"/>
                                                        <ice:inputText binding="#{Organization$OrganizationPage.txtTelOffice}" id="txtTelOffice" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 158px; top: 25px; position: absolute; width: 140px"/>
                                                        <ice:inputText binding="#{Organization$OrganizationPage.txtTelExtension}" id="txtTelExtension" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 158px; top: 72px; position: absolute; width: 140px"/>
                                                        <ice:inputText binding="#{Organization$OrganizationPage.txtMobile}" id="txtMobile" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 158px; top: 117px; position: absolute; width: 140px"/>
                                                        <ice:inputText binding="#{Organization$OrganizationPage.txtOfficeNumber}" id="txtOfficeNumber" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 525px; top: 25px; position: absolute; width: 140px"/>
                                                        <ice:inputText binding="#{Organization$OrganizationPage.txtEmail}" id="txtEmail" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 525px; top: 72px; position: absolute; width: 140px"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="lyAddress" style="top: 405px; position: absolute">
                                                        <ice:commandButton action="#{Organization$OrganizationPage.btnSaveAd_action}"
                                                            actionListener="#{Organization$OrganizationPage.btnSaveAd_processAction}"
                                                            binding="#{Organization$OrganizationPage.btnSaveAd}" id="btnSaveAd"
                                                            style="margin-left: 140px; width: 80px" value="New"/>
                                                        <ice:commandButton action="#{Organization$OrganizationPage.btnUpdateAd_action}"
                                                            binding="#{Organization$OrganizationPage.btnUpdateAd}" id="btnUpdateAd"
                                                            style="margin-left: 50px; width: 80px" value="Edit"/>
                                                        <ice:commandButton action="#{Organization$OrganizationPage.btnResetAd_action}"
                                                            binding="#{Organization$OrganizationPage.btnResetAd}" id="btnResetAd"
                                                            style="margin-left: 50px; width: 80px" value="Reset"/>
                                                        <ice:commandButton action="#{Organization$OrganizationPage.btnDeleteAd_action}"
                                                            binding="#{Organization$OrganizationPage.btnDeleteAd}" id="btnDeleteAd"
                                                            style="margin-left: 50px; width: 80px" value="Delete"/>
                                                    </ice:panelLayout>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlRegion" id="message4"
                                                        infoClass="infoMessage" style="font-size: 10px; left: 308px; top: 52px; position: absolute" warnClass="warnMessage"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlZoneCity" id="message5"
                                                        infoClass="infoMessage" style="font-size: 10px; left: 675px; top: 52px; position: absolute" warnClass="warnMessage"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlWoreda" id="message6"
                                                        infoClass="infoMessage" style="font-size: 10px; left: 308px; top: 94px; position: absolute" warnClass="warnMessage"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlKebelle" id="message7"
                                                        infoClass="infoMessage" style="left: 678px; top: 98px; position: absolute" warnClass="warnMessage"/>
                                                </ice:panelLayout>
                                            </ice:panelTab>
                                        </ice:panelTabSet>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="south">
                                <ice:panelGroup id="page_footer" style=" text-align: left;">
                                    <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">
                                        <label style="margin-left:20px;color:white;font-weight:bold;font-family:Narkisim">BUNNA INTERNATIONAL BANK.Human Resource Management System.</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Organization$OrganizationPage.pnlPopUpMsg}" draggable="true" id="pnlPopUpMsg" modal="true"
                            rendered="false" style="display: block; height: 156px; left: 97px; top: 226px; position: absolute; width: 550px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopUpMsg" style="display: block; height: 20px; width: 500px">
                                    <ice:outputText id="lblPopUpMsgTitle" value="BUNNA INTERNATIONAL BANK Resource Management System"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupPopUpMsgBody" style="display: block; height: 94px; position: relative; width: 510px">
                                    <ice:commandButton action="#{Organization$OrganizationPage.btnPopUpOk_action}"
                                        binding="#{Organization$OrganizationPage.btnPopUpOk}" id="btnPopUpOk" rendered="false"
                                        style="left: 430px; top: 60px; position: absolute; width: 120px" value="OK" visible="false"/>
                                    <ice:commandButton action="#{Organization$OrganizationPage.btnPopUpNo_action}"
                                        binding="#{Organization$OrganizationPage.btnPopUpNo}" id="btnPopUpNo" rendered="false"
                                        style="left: 430px; top: 60px; position: absolute; visibility: visible; width: 80px" value="No" visible="true"/>
                                    <ice:commandButton action="#{Organization$OrganizationPage.btnPopUpYes_action}"
                                        binding="#{Organization$OrganizationPage.btnPopUpYes}" id="btnPopUpYes" rendered="true"
                                        style="left: 335px; top: 60px; position: absolute; visibility: visible; width: 80px" value="Yes" visible="true"/>
                                    <ice:outputText binding="#{Organization$OrganizationPage.lblPopUpMsgMain}" id="lblPopUpMsgMain" style="left: 20px; top: 15px; position: absolute; width: 496px"/>
                                    <ice:commandButton action="#{Organization$OrganizationPage.button1_action}"
                                        binding="#{Organization$OrganizationPage.btnPopUpYesAd}" id="btnPopUpYesAd" rendered="false"
                                        style="left: 305px; top: 60px; position: absolute; visibility: visible; width: 80px" value="Yes"/>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Organization$OrganizationPage.pnConfirmationMessage}" clientOnly="true" draggable="false"
                            id="pnConfirmationMessage" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlConfirmationMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnConfirmationTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Organization$OrganizationPage.cmdConfirmationCloseMesssage_action}"
                                        id="cmdConfirmationCloseMesssage" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 744px; top: 15px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelConfirmationGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Organization$OrganizationPage.pnlConfirmationMessageBody}" id="pnlConfirmationMessageBody"
                                        layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Organization$OrganizationPage.lblFormMessage4}" id="lblFormMessage4" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <div class="some">
                            <input id="cal_day_names" type="hidden" value="?,?,?,?,?,?,?"/>
                            <input id="cal_month_names" type="hidden" value="?????,????,???,????,??,????,????,????,????,??,???,???,???"/>
                        </div>
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>