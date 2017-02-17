<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2010, 7:48:31 AM
    Author     : BravoZulu
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <f:loadBundle basename="Localization.HRLocalization" var="msgs"/>
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
                <!--  <link HREF="../header_icon.ico" REL="icon"/>-->
            </head>
            <body id="outputBody1">
                <ice:form id="form1">
                    <div style="width:100%">
                        <img alt="" class="source-image" id="img" src="../resources/images/WholePageBG.png" width="100%"/>
                        <ice:panelBorder id="whole_page" renderCenter="#{Employee$EmployeePage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Employee$EmployeePage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Employee$EmployeePage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Employee$EmployeePage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Employee$EmployeePage.panelBorder1Bean.renderWest}"
                            style="background-color: transparent; top: 5px; position: relative" styleClass="whole_page" width="1024">
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
                                <ice:panelGroup id="menu_left" style=" height:640px;">
                                    <ice:panelLayout id="left_menu1" layout="flow" style="height: 640px; left: -20px; position: relative; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 640px; left: 20px; top: 10px; position: absolute" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="panelCollapsibleSearch" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup5" styleClass="">
                                                        <ice:outputText id="lblHeadSearchByName" value="Search By Name Or Id"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="panelGrid4" style="height:40px">
                                                    <ice:panelGroup id="pnlGroupSearchEmployeeByName" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;;border:none;display: block;float:left;height: 100px; width: 100%">
                                                        <ice:outputText id="lblSearchEmpByName" style="left: 15px; top: 50px; position: absolute" value="Name :"/>
                                                        <ice:selectInputText action="#{Employee$EmployeePage.txtSearchByName1_action}"
                                                            binding="#{Employee$EmployeePage.txtSearchByName1}" id="txtSearchByName1" immediate="true"
                                                            listValue="#{Employee$EmployeePage.list}" listVar="employeeList" partialSubmit="true" rows="10"
                                                            style="left: 65px; top: 50px; position: absolute" valueChangeListener="#{Employee$EmployeePage.txtSearchByName1_processValueChange}">
                                                            <f:facet name="selectInputText">
                                                                <ice:panelGrid columnClasses="fullNameCol,empIdCol" columns="2">
                                                                    <ice:graphicImage height="50" id="employeePicture" value="#{employeeList.employeePicture}" width="40"/>
                                                                    <ice:outputText id="lblEmployeeIdAutoComplete2" value="#{employeeList.empIdentification}"/>
                                                                    <ice:outputText id="lblFullNameAutoComplete2" value="#{employeeList.fullName}"/>
                                                                </ice:panelGrid>
                                                            </f:facet>
                                                        </ice:selectInputText>
                                                        <ice:outputText id="lblEmpId" style="left: 15px; top: 100px; position: absolute" value="#{msgs.ID}"/>
                                                        <ice:inputText binding="#{Employee$EmployeePage.txtFEmployeeId}" id="txtFEmployeeId" immediate="true"
                                                            partialSubmit="true" style="left: 65px; top: 100px; position: absolute; width: 150px"
                                                            value="#{Employee$EmployeePage.newNameInput}" valueChangeListener="#{Employee$EmployeePage.txtFEmployeeId_processValueChange}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnSearch_action}" id="btnSearch"
                                                            image="/Employee/images/btn_search.gif" partialSubmit="true"
                                                            style="left: 153px; top: 103px; position: absolute" value="submit"/>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible binding="#{Employee$EmployeePage.panelCollapsible1}" expanded="true" id="panelCollapsible1" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup3" styleClass="">
                                                        <ice:outputText id="outputText3" value="Manage Employee  Profile"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid headerClass="iceDatTblColHdr1" id="panelGrid1" width="100%">
                                                    <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                        <li>
                                                            <ice:commandLink id="cmdEmployeePromotion"
                                                                style="color: rgb(48, 102, 130); font-weight: bold; text-align: left" value="Promotion"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink id="cmdEmployeeTransfer" style="color:#306682;font-weight:bold" value="Transfer"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink id="cmdLeave" style="color:#306682;font-weight:bold" value="Leave"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Employee$EmployeePage.cmdDispline_action}" id="cmdDispline"
                                                                style="color:#306682;font-weight:bold" value="Displine"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Employee$EmployeePage.cmdRetirement_action}" id="cmdRetirement"
                                                                style="color:#306682;font-weight:bold" value="Termination"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Employee$EmployeePage.cmdRecruitment_action}" id="cmdRecruitment"
                                                                style="color:#306682;font-weight:bold" value="Recruitment"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Employee$EmployeePage.cmdWillRegistration_action}"
                                                                id="cmdWillRegistration" style="color:#306682;font-weight:bold" value="Employee Will"/>
                                                        </li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible binding="#{Employee$EmployeePage.panelCollapsible3}" id="panelCollapsible3" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup4" styleClass="">
                                                        <ice:outputText id="headNote" value="Candidate"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="panelGrid3">
                                                    <ice:outputText id="lblTotalEmp1" rendered="true" value="#{msgs.candidateId}"/>
                                                    <ice:selectOneMenu id="drlPassedCandidatesList" partialSubmit="true"
                                                        style="width: 150px;border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter;"
                                                        value="#{Employee$EmployeePage.defaultSelectedData64.selectedObject}" valueChangeListener="#{Employee$EmployeePage.drlPassedCandidatesList_processValueChange}">
                                                        <f:selectItems id="selectOneMenu1selectItems11" value="#{Employee$EmployeePage.bachCode}"/>
                                                    </ice:selectOneMenu>
                                                    <ice:selectOneListbox id="selectOneListbox1" partialSubmit="true" size="2"
                                                        style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; height: 50px; width: 150px"
                                                        value="#{Employee$EmployeePage.selectOneListbox1Bean.selectedObject}" valueChangeListener="#{Employee$EmployeePage.selectOneListbox1_processValueChange}">
                                                        <f:selectItems id="selectOneListbox1selectItems" value="#{Employee$EmployeePage.candidateName}"/>
                                                    </ice:selectOneListbox>
                                                    <ice:outputText id="lblMedicalFit" rendered="true" style="font-size: 11px; " value="Is Medically Fit"/>
                                                    <ice:selectBooleanCheckbox binding="#{Employee$EmployeePage.choIsMedicallyFit}" id="choIsMedicallyFit"
                                                        partialSubmit="true" value="#{Employee$EmployeePage.selectBooleanCheckbox2Bean.selectedBoolean}"/>
                                                    <ice:outputText id="lblIsCrimeFree" rendered="true" style="font-size: 11px; " value="Is Crime Free"/>
                                                    <ice:selectBooleanCheckbox binding="#{Employee$EmployeePage.choIsCrimeFree}" id="choIsCrimeFree"
                                                        partialSubmit="true" value="#{Employee$EmployeePage.defaultSelectedData77.selectedBoolean}"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="choIsCrimeFree" id="message10"
                                                        infoClass="infoMessage" warnClass="warnMessage"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="choIsMedicallyFit" id="message16"
                                                        infoClass="infoMessage" warnClass="warnMessage"/>
                                                </ice:panelGrid>
                                                <!--
                                                <ice:panelGrid id="panelGrid11" width="100%">
                                                    <ice:panelGroup id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:225px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" rendered="false" style="border-style: none; background-color: transparent; height: 78px; position: absolute; width: 100%">
                                                            <ice:selectOneMenu id="drlPassedCandidatesList" partialSubmit="true"
                                                                style="border-style: none; background-color: transparent; position: absolute; width: 200px;border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94);"
                                                                value="#{Employee$EmployeePage.defaultSelectedData64.selectedObject}" valueChangeListener="#{Employee$EmployeePage.drlPassedCandidatesList_processValueChange}">
                                                                <f:selectItems id="selectOneMenu1selectItems11" value="#{Employee$EmployeePage.bachCode}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:selectOneListbox id="selectOneListbox1" partialSubmit="true" rendered="false" size="2"
                                                                style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); height: 120px; top: 30px; position: relative; width: 200px"
                                                                value="#{Employee$EmployeePage.selectOneListbox1Bean.selectedObject}" valueChangeListener="#{Employee$EmployeePage.selectOneListbox1_processValueChange}">
                                                                <f:selectItems id="selectOneListbox1selectItems" value="#{Employee$EmployeePage.candidateName}"/>
                                                            </ice:selectOneListbox>

                                                            <ice:outputText id="lblIsCrimeFree" rendered="true" style="font-size: 11px; " value="Is Crime Free"/>

                                                            <ice:outputText id="lblIsMedicallyFit" value="Is Medically Fit"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="choIsCrimeFree" id="message10"
                                                                infoClass="infoMessage" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="choIsMedicallyFit"
                                                                id="message16" infoClass="infoMessage" warnClass="warnMessage"/>
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>-->
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height: 695px;border:none">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 700px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <ice:panelTabSet binding="#{Employee$EmployeePage.panelTabSet1}" id="panelTabSet1" immediate="true" partialSubmit="true"
                                            style="left: 0px; top: 0px; position: absolute" tabPlacement="Top">
                                            <ice:panelTab binding="#{Employee$EmployeePage.tabPersonal}" id="tabPersonal" label="#{msgs.lblPersonal}">
                                                <ice:panelLayout id="lytopPanel" style="height:550px; position: inherit; width: 100%;top:0px">
                                                    <!--///////////////////////////////////////////////Search By ID ////////////////////////////////////////////////////////////////////////////////////-->
                                                    <ice:panelLayout id="pnlLayoutContractOrPermanent"
                                                        style="height: 30px; margin-left: 2px; margin-top: 0px; position: absolute; width: 165px" styleClass="insideContainerMain">
                                                        <ice:outputText id="lblPermanent" style="left: 25px; top: 10px; position: absolute" value="Permanent"/>
                                                        <ice:outputText id="lblContract" style="left: 110px; top: 10px; position: absolute" value="Contract"/>
                                                        <ice:selectBooleanCheckbox binding="#{Employee$EmployeePage.cboPermanent}" id="cboPermanent"
                                                            partialSubmit="true" style="left: 5px; top: 10px; position: absolute"
                                                            value="#{Employee$EmployeePage.defaultSelectedDataPermanentCheckBox.selectedBoolean}" valueChangeListener="#{Employee$EmployeePage.cboPermanent_processValueChange}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Employee$EmployeePage.cboContract}" id="cboContract"
                                                            partialSubmit="true" style="left: 90px; top: 10px; position: absolute"
                                                            value="#{Employee$EmployeePage.defaultSelectedDataContractCheckBox.selectedBoolean}" valueChangeListener="#{Employee$EmployeePage.cboContract_processValueChange}"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="tabOfficeOrShift"
                                                        style="height: 30px; margin-left: 170px; margin-top: 0px; position: absolute; width: 190px" styleClass="insideContainerMain">
                                                        <ice:outputText id="lblNormal" style="left: 25px; top: 10px; position: absolute" value="Clerical"/>
                                                        <ice:outputText id="lblShift" style="height: 9px; left: 110px; top: 10px; position: absolute" value="NonClerical"/>
                                                        <ice:selectBooleanCheckbox binding="#{Employee$EmployeePage.cboOffice}" id="cboOffice" immediate="true"
                                                            partialSubmit="true" style="left: 5px; top: 10px; position: absolute"
                                                            value="#{Employee$EmployeePage.defaultSelectedDataOffice.selectedBoolean}" valueChangeListener="#{Employee$EmployeePage.cboOffice_processValueChange}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Employee$EmployeePage.cboShift}" id="cboShift" immediate="true"
                                                            partialSubmit="true" style="left: 90px; top: 10px; position: absolute"
                                                            value="#{Employee$EmployeePage.defaultSelectedDataShift.selectedBoolean}" valueChangeListener="#{Employee$EmployeePage.cboShift_processValueChange}"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="panelEmployee"
                                                        style="height: 211px; margin-left: 2px; margin-top: 40px; position: absolute; width: 452px" styleClass="insideContainerMain">
                                                        <ice:outputText id="lblTitle"
                                                            style="font-size: 10px; margin-left: 70px; margin-top: 5px; position: absolute; text-align: left; width: 35px" value="#{msgs.Title}"/>
                                                        <!--##########################################################################optTitle ##########################################-->
                                                        <ice:outputText id="lblFirstName"
                                                            style="font-size: 10px; margin-left: 300px; margin-top: 5px; left: 2px; position: absolute; text-align: left; width: 70px" value="#{msgs.FirstName}"/>
                                                        <ice:inputText binding="#{Employee$EmployeePage.txtFirstName}" id="txtFirstName" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 270px; margin-top: 25px; position: absolute; width: 144px"/>
                                                        <ice:outputText id="lblMideName"
                                                            style="font-size: 10px; margin-left: 70px; margin-top: 60px; position: absolute; text-align: left; width: 100px" value="#{msgs.MidelName}"/>
                                                        <ice:inputText binding="#{Employee$EmployeePage.txtMidelName}" id="txtMidelName" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 30px; margin-top: 80px; position: absolute; width: 144px"/>
                                                        <ice:outputText id="lblLastName"
                                                            style="font-size: 10px; margin-left: 300px; margin-top: 60px; position: absolute; text-align: left; width: 100px" value="#{msgs.LastName}"/>
                                                        <ice:inputText binding="#{Employee$EmployeePage.txtLastName}" id="txtLastName"
                                                            onfocus="showCalendarControl(this);" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 270px; margin-top: 80px; position: absolute; width: 144px"/>
                                                        <ice:outputText id="lblSex"
                                                            style="font-size: 10px; margin-left: 70px; margin-top: 110px; position: absolute; text-align: left; width: 50px" value="#{msgs.Sex}"/>
                                                        <ice:outputText id="lblGenderFemale"
                                                            style="font-family: Georgia,'Times New Roman',times,serif; font-size: 12px; margin-left: 50px; margin-top: 134px; position: absolute; text-align: left; width: 50px" value="#{msgs.Female}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Employee$EmployeePage.ckbSexMale}" id="ckbSexMale"
                                                            immediate="true" partialSubmit="true"
                                                            style="font-family: Georgia,'Times New Roman',times,serif; font-size: 12px; margin-left: 110px; margin-top: 135px; position: absolute"
                                                            value="#{Employee$EmployeePage.defaultSelectedDataSexMale.selectedBoolean}" valueChangeListener="#{Employee$EmployeePage.ckbSexMale_processValueChange}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Employee$EmployeePage.ckbSexFemale}" id="ckbSexFemale"
                                                            immediate="true" partialSubmit="true"
                                                            style="font-family: Georgia,'Times New Roman',times,serif; font-size: 12px; margin-left: 30px; margin-top: 135px; position: absolute"
                                                            value="#{Employee$EmployeePage.defaultSelectedDataSexFemale.selectedBoolean}" valueChangeListener="#{Employee$EmployeePage.ckbSexFemale_processValueChange}"/>
                                                        <ice:outputText id="lblGenderMale"
                                                            style="font-family: Georgia,'Times New Roman',times,serif; font-size: 12px; margin-left: 130px; margin-top: 134px; position: absolute; text-align: left; width: 40px" value="#{msgs.Male}"/>
                                                        <ice:outputText id="lblDateOfBirth"
                                                            style="font-size: 10px; margin-left: 300px; margin-top: 110px; position: absolute; text-align: left; width: 100px" value="#{msgs.DateOfBirth}"/>
                                                        <ice:selectOneMenu binding="#{Employee$EmployeePage.drlTitle}" id="drlTitle" rendered="false"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 30px; margin-top: 25px; position: absolute; width: 144px"
                                                            value="#{Employee$EmployeePage.defaultSelectedData15.selectedObject}" valueChangeListener="#{Employee$EmployeePage.drlTitle_processValueChange}">
                                                            <f:selectItems id="selectOneMenu2selectItems5" value="#{Employee$EmployeePage._title}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputText binding="#{Employee$EmployeePage.lblFirstNameError}" id="lblFirstNameError"
                                                            rendered="false"
                                                            style="color: red; font-size: 12px; height: 15px; margin-left: 320px; margin-top: 42px; position: absolute; text-align: left; width: 120px" value="Error"/>
                                                        <ice:message binding="#{Employee$EmployeePage.msgErrorMiddelName}" errorClass="errorMessage"
                                                            fatalClass="fatalMessage" for="txtMidelName" id="msgErrorMiddelName" infoClass="infoMessage"
                                                            style="font-size: 11px; margin-left: 180px; margin-top: 79px; position: absolute; width: 120px" warnClass="warnMessage"/>
                                                        <ice:message binding="#{Employee$EmployeePage.message1}" errorClass="errorMessage"
                                                            fatalClass="fatalMessage" for="txtLastName" id="message1" infoClass="infoMessage"
                                                            style="font-size: 11px; margin-left: 420px; margin-top: 80px; position: absolute; width: 100px"
                                                            visible="true" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtDateOfBirth" id="message4"
                                                            infoClass="infoMessage"
                                                            style="font-size: 11px; margin-left: 420px; margin-top: 135px; position: absolute; width: 100px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtFirstName" id="message15"
                                                            infoClass="infoMessage"
                                                            style="font-size: 11px; margin-left: 420px; margin-top: 30px; position: absolute; width: 100px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlTitle" id="message2"
                                                            infoClass="infoMessage" rendered="false"
                                                            style="color: red; font-size: 11px; font-weight: bolder; margin-left: 150px; margin-top: 5px; position: absolute; width: 100px" warnClass="warnMessage"/>
                                                        <ice:outputText binding="#{Employee$EmployeePage.lblSexValidation}" id="lblSexValidation"
                                                            rendered="false"
                                                            style="color: red; font-weight: bold; margin-left: 150px; margin-top: 153px; position: absolute; width: 100px" value="outputText"/>
                                                        <ice:outputText id="lblMaritalStatus1"
                                                            style="font-size: 10px; margin-left: 70px; margin-top: 160px; position: absolute; text-align: left; width: 100px" value="#{msgs.MaritalStatus}"/>
                                                        <ice:selectOneMenu binding="#{Employee$EmployeePage.drlMaritalStatus}" id="drlMaritalStatus"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 30px; margin-top: 185px; position: absolute; width: 144px" value="#{Employee$EmployeePage.selectOneMenu2Bean.selectedObject}">
                                                            <f:selectItems id="selectOneMenu2selectItems11" value="#{Employee$EmployeePage.maritalstatus}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlMaritalStatus" id="message5"
                                                            infoClass="infoMessage"
                                                            style="font-size: 11px; margin-left: 180px; margin-top: 185px; position: absolute; width: 120px" warnClass="warnMessage"/>
                                                        <ice:outputText id="lblRetiremenNo1"
                                                            style="font-size: 10px; margin-left: 300px; margin-top: 160px; position: absolute; text-align: left; width: 100px" value="#{msgs.RetirementNO}"/>
                                                        <ice:inputText binding="#{Employee$EmployeePage.txtRetirementNo}" id="txtRetirementNo"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 270px; margin-top: 185px; position: absolute; width: 144px" value="000000"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtRetirementNo" id="message9"
                                                            infoClass="infoMessage"
                                                            style="font-size: 11px; margin-left: 420px; margin-top: 185px; position: absolute; width: 100px" warnClass="warnMessage"/>
                                                        <ice:commandLink action="#{Employee$EmployeePage.commandLink2_action}" id="commandLink2"
                                                            immediate="true" partialSubmit="true"
                                                            style="font-style: normal; font-weight: bold; height: 10px; margin-left: 180px; margin-top: 28px; position: absolute; width: 20px" value="[+]"/>
                                                        <ice:inputText binding="#{Employee$EmployeePage.txtBirthDate}" disabled="true" id="txtBirthDate"
                                                            immediate="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 270px; margin-top: 135px; position: absolute; width: 145px"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnCalBirthDate_action}" id="btnCalBirthDate"
                                                            image="/resources/images/cal_button.gif" immediate="true" style="margin-left: 398px; margin-top: 139px; position: absolute"/>
                                                        <ice:selectInputDate binding="#{Employee$EmployeePage.calBirthDate}" id="calBirthDate"
                                                            popupDateFormat="yyyy-MM-dd" renderYearAsDropdown="true" rendered="false"
                                                            style="left: 170px; top: 10px; position: absolute;"
                                                            value="#{Employee$EmployeePage.selectInputDateDateOfBirthBean.date1}" valueChangeListener="#{Employee$EmployeePage.calBirthDate_processValueChange}"/>
                                                        <ice:selectOneMenu binding="#{Employee$EmployeePage.drlEmpTitle}" id="drlEmpTitle" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 30px; margin-top: 25px; position: absolute; width: 144px"
                                                            value="#{Employee$EmployeePage.defaultSelectedData78.selectedObject}" valueChangeListener="#{Employee$EmployeePage.drlEmpTitle_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectItems14" value="#{Employee$EmployeePage._title}"/>
                                                        </ice:selectOneMenu>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="panelDetail12" style="height: 70px; margin-left: 2px; margin-top: 258px; width: 746px" styleClass="insideContainerMain">
                                                        <ice:outputText id="lblReligion"
                                                            style="font-size: 10px; margin-left: 48px; margin-top: 10px; position: absolute; width: 75px" value="#{msgs.Religion}"/>
                                                        <ice:outputText id="lblNationality"
                                                            style="font-size: 10px; margin-left: 300px; margin-top: 10px; position: absolute; width: 75px" value="#{msgs.Nationality}"/>
                                                        <ice:outputText id="lblNation"
                                                            style="font-size: 10px; margin-left: 600px; margin-top: 10px; position: absolute; width: 50px" value="#{msgs.Nation}"/>
                                                        <ice:selectOneMenu binding="#{Employee$EmployeePage.drlNation}" id="drlNation"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 570px; margin-top: 30px; position: absolute; width: 144px" value="#{Employee$EmployeePage.defaultSelectedData12.selectedObject}">
                                                            <f:selectItems id="selectOneMenu2selectItems2" value="#{Employee$EmployeePage.nation}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlNationality" id="message6"
                                                            infoClass="infoMessage"
                                                            style="font-size: 11px; margin-left: 300px; margin-top: 55px; position: absolute; width: 200px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlNation" id="message7"
                                                            infoClass="infoMessage"
                                                            style="font-size: 11px; margin-left: 555px; margin-top: 55px; position: absolute; width: 200px" warnClass="warnMessage"/>
                                                        <ice:selectOneMenu binding="#{Employee$EmployeePage.drlNationality}" id="drlNationality"
                                                            partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 270px; margin-top: 30px; position: absolute; width: 144px" value="#{Employee$EmployeePage.defaultSelectedData58.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems10" value="#{Employee$EmployeePage.nationalityName}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectOneMenu binding="#{Employee$EmployeePage.drlReligion}" id="drlReligion" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 30px; margin-top: 30px; position: absolute; width: 144px" value="#{Employee$EmployeePage.defaultSelectedDataReligion.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItemsReligion" value="#{Employee$EmployeePage.religionName}"/>
                                                        </ice:selectOneMenu>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="panelPosition" layout="flow"
                                                        style="height: 170px; margin-left: 2px; margin-top: 335px; position: absolute; width: 746px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:outputText id="lblHireDate1"
                                                            style="font-family: 'Georgia','Times New Roman','times',serif; font-size: 12px; margin-left: 50px; margin-top: 10px; position: absolute; text-align: left; width: 100px" value="#{msgs.HireDate}"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtHireDate" id="message8"
                                                            infoClass="infoMessage"
                                                            style="font-size: 11px; margin-left: 165px; margin-top: 30px; position: absolute; width: 100px" warnClass="warnMessage"/>
                                                        <ice:inputText binding="#{Employee$EmployeePage.txtRecruitmentDate}" disabled="true"
                                                            id="txtRecruitmentDate" immediate="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 25px; margin-top: 30px; position: absolute; width: 130px"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnCalRecruitmentDate_action}"
                                                            id="btnCalRecruitmentDate" image="/resources/images/cal_button.gif" immediate="true" style="margin-left: 138px; margin-top: 34px; position: absolute"/>
                                                        <ice:outputText id="lblDepartment"
                                                            style="font-family: Georgia,'Times New Roman',times,serif; font-size: 12px; margin-left: 450px; margin-top: 10px; position: absolute; text-align: left; width: 100px" value="#{msgs.Department}"/>
                                                        <ice:outputText id="lblRankId"
                                                            style="font-family: 'Georgia','Times New Roman','times',serif; font-size: 12px; margin-left: 300px; margin-top: 60px; position: absolute; text-align: left; width: 100px" value="#{msgs.RankId}"/>
                                                        <ice:outputText id="lblPayGrade"
                                                            style="font-family: Georgia,'Times New Roman',times,serif; font-size: 12px; margin-left: 600px; margin-top: 60px; left: 2px; position: absolute; width: 89px" value="#{msgs.PayGrade}"/>
                                                        <ice:outputText id="lblSalary"
                                                            style="font-family: Georgia,'Times New Roman',times,serif; font-size: 12px; margin-left: 50px; margin-top: 115px; position: absolute; text-align: left; width: 100px" value="#{msgs.Salary}"/>
                                                        <ice:selectOneMenu binding="#{Employee$EmployeePage.drlJobCode}" id="drlJobCode"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 10px; margin-top: 115px; left: 15px; top: -32px; position: absolute; width: 144px" value="#{Employee$EmployeePage.defaultSelectedData14.selectedObject}">
                                                            <f:selectItems id="selectOneMenu2selectItems4" value="#{Employee$EmployeePage.perofation}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputText id="lblJobCode"
                                                            style="font-family: 'Georgia','Times New Roman','times',serif; font-size: 12px; margin-left: 50px; margin-top: 60px; position: absolute; text-align: left; width: 100px" value="#{msgs.JobCode}"/>
                                                        <ice:inputText binding="#{Employee$EmployeePage.txtSalary}" id="txtSalary" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 10px; margin-top: 170px; left: 15px; top: -32px; position: absolute; width: 144px"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlRankId" id="message12"
                                                            infoClass="infoMessage"
                                                            style="font-size: 11px; margin-left: 520px; margin-top: 70px; left: -108px; position: absolute; width: 100px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlPayGrade" id="message13"
                                                            infoClass="infoMessage"
                                                            style="font-size: 11px; margin-left: 700px; margin-top: 100px; left: -100px; position: absolute; width: 100px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtSalary" id="message14"
                                                            infoClass="infoMessage"
                                                            style="font-size: 11px; margin-left: 270px; margin-top: 140px; left: -98px; position: absolute; width: 100px" warnClass="warnMessage"/>
                                                        <ice:outputText binding="#{Employee$EmployeePage.lblRequiredMes}" id="lblRequiredMes" rendered="false"
                                                            style="color: #FF0000; font-size: 11px; font-style: normal; margin-left: 650px; margin-top: 80px; position: absolute; width: 100px" value="outputText"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnAddtree_action}" id="btnAddtree" rendered="false" value="[+]"/>
                                                        <ice:inputText binding="#{Employee$EmployeePage.txtfDepartment}" id="txtfDepartment" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 272px; margin-top: 30px; position: absolute; width: 450px"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnViewTree_action}" id="btnViewTree"
                                                            image="/Employee/images/pic3-tree-icon.jpg" immediate="true" partialSubmit="true" style="left: 690px; top: 29px; position: absolute"/>
                                                        <ice:selectOneMenu binding="#{Employee$EmployeePage.drlRankId}" id="drlRankId" partialSubmit="true"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 272px; margin-top: 80px; position: absolute; width: 135px"
                                                            value="#{Employee$EmployeePage.selectOneMenu1Bean.selectedObject}" valueChangeListener="#{Employee$EmployeePage.drlRankId_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectItems7" value="#{Employee$EmployeePage._jobRank}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectOneMenu binding="#{Employee$EmployeePage.drlPayGrade}" id="drlPayGrade" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 570px; margin-top: 80px; left: 7px; position: absolute; width: 144px"
                                                            value="#{Employee$EmployeePage.defaultSelectedDataForPayGrade.selectedObject}" valueChangeListener="#{Employee$EmployeePage.drlPayGrade_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectItems8" value="#{Employee$EmployeePage.payGradeOpt}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputText id="lblTinNumber"
                                                            style="font-family: Georgia,'Times New Roman',times,serif; font-size: 12px; margin-left: 300px; margin-top: 115px; position: absolute; text-align: left; width: 100px" value="#{msgs.TinNumber}"/>
                                                        <ice:inputText binding="#{Employee$EmployeePage.txtTinNumber}" id="txtTinNumber" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 272px; margin-top: 140px; position: absolute; width: 159px"/>
                                                        <ice:outputText id="outputText14"
                                                            style="font-family: Georgia,'Times New Roman',times,serif; font-size: 12px; margin-left: 600px; margin-top: 115px; position: absolute; text-align: left; width: 100px" value="#{msgs.Location}"/>
                                                        <ice:selectOneMenu binding="#{Employee$EmployeePage.drlLocation}" id="drlLocation" partialSubmit="true"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 570px; margin-top: 140px; position: absolute; width: 159px" value="#{Employee$EmployeePage.defaultSelectedData79.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems15" value="#{Employee$EmployeePage.emplocationList}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:commandLink action="#{Employee$EmployeePage.cmd_locationNew_action}"
                                                            binding="#{Employee$EmployeePage.cmd_locationNew}" id="cmd_locationNew"
                                                            style="position: absolute; left: 550px; top: 144px" value="[+]"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="buttons" style="margin-left: 2px; margin-top: 515px; width: 740px" styleClass="insideContainerMain">
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnNew_action}"
                                                            binding="#{Employee$EmployeePage.btnNew}" id="btnNew" immediate="true" partialSubmit="true"
                                                            style="margin-left: 40px; width: 80px" value="#{msgs.cmdNew}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnSave_action}"
                                                            binding="#{Employee$EmployeePage.btnSave}" id="btnSave" style="margin-left: 40px; width: 80px" value="#{msgs.cmdSave}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnEdit_action}"
                                                            actionListener="#{Employee$EmployeePage.btnEdit_processAction}"
                                                            binding="#{Employee$EmployeePage.btnEdit}" id="btnEdit" style="margin-left: 40px; width: 80px" value="#{msgs.cmdEdit}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnUpdate_action}"
                                                            binding="#{Employee$EmployeePage.btnUpdate}" id="btnUpdate" style="margin-left: 40px; width: 80px" value="#{msgs.cmdUpdate}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnReset_action}"
                                                            actionListener="#{Employee$EmployeePage.btnReset_processAction}"
                                                            binding="#{Employee$EmployeePage.btnReset}" id="btnReset" immediate="true" partialSubmit="true"
                                                            style="margin-left: 40px; width: 80px" value="#{msgs.cmdReset}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnDelete_action}"
                                                            binding="#{Employee$EmployeePage.btnDelete}" id="btnDelete" style="margin-left: 40px; width: 80px" value="#{msgs.cmdDelete}"/>
                                                    </ice:panelLayout>
                                                    <!--////////////////////////////////////////////////////End Command.//////////////////////////////////////////////////////////////////////////////////-->
                                                    <ice:panelLayout id="tabMemberPhotoTop"
                                                        style="height: 30px; margin-left: 355px; margin-top: 0px; left: 20px; position: absolute; width: 380px" styleClass="insideContainerMain">
                                                        <ice:inputFile actionListener="#{Employee$EmployeePage.inputPhoto_processAction}"
                                                            binding="#{Employee$EmployeePage.inputPhoto}" id="inputPhoto" immediate="true"
                                                            style="top: 3px; position: absolute" styleClass="iceInpFile  iceInpFile-dis"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="tabMemberPhoto"
                                                        style="height: 210px; margin-left: 445px; margin-top: 40px; left: 30px; position: absolute; width: 280px; " styleClass="insideContainerMain">
                                                        <ice:graphicImage binding="#{Employee$EmployeePage.imgMember}" height="145" id="imgMember" ismap="true"
                                                            style="height: 200px; margin-left: 60px; margin-top: -20px; left: -12px; top: 25px; position: absolute; width: 192px"
                                                            url="/Employee/images/new.JPG" width="192"/>
                                                        <ice:outputText binding="#{Employee$EmployeePage.lblPhoto}" id="lblPhoto" rendered="false"
                                                            style="color: red; font-size: 11px; font-weight: bold; left: 100px; top: 200px; position: absolute" value="outputText"/>
                                                    </ice:panelLayout>
                                                </ice:panelLayout>
                                                <ice:selectInputDate binding="#{Employee$EmployeePage.calHireDate}" id="calHireDate"
                                                    popupDateFormat="yyyy-MM-dd" renderYearAsDropdown="true" rendered="false"
                                                    style="left: 20px; top: 130px; position: absolute;"
                                                    value="#{Employee$EmployeePage.selectInputDateHireDateBean.date1}" valueChangeListener="#{Employee$EmployeePage.calHireDate_processValueChange}"/>
                                                <!--//////////////////////////////////////////////////////////////////////////////////////////////// -->
                                                <ice:panelPopup autoCentre="true" binding="#{Employee$EmployeePage.pnlInsertNewLocationType}" clientOnly="true"
                                                    draggable="true" id="pnlInsertNewLocationType" modal="true" rendered="false"
                                                    style="border-style: none; background-color: transparent; display: block; height: 106px; left: 3px; top: 80px; position: absolute; width: 667px" styleClass="message">
                                                    <f:facet name="header">
                                                        <ice:panelGroup id="pnlgridpnMessageLocationType" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                                            <ice:outputText id="pnMessageTitleNewLocationType"
                                                                style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System : Add New Location Name"/>
                                                            <ice:commandLink action="#{Employee$EmployeePage.btnClosePopupInsertNewLocationType_action}"
                                                                id="btnClosePopupInsertNewLocationType" immediate="true"
                                                                style="background-image: url(../resources/close_icon.gif); height: 19px; left: 700px; top: 20px; position: absolute; width: 19px"
                                                                styleClass="popupHeaderImage" title="Close Popup"/>
                                                        </ice:panelGroup>
                                                    </f:facet>
                                                    <f:facet name="body">
                                                        <ice:panelGroup id="panelGroupMessageNewLocationType"
                                                            style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                                            <ice:panelLayout id="pnlMessageBodyNewLocationType" layout="flow"
                                                                style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                                                <ice:outputText id="lblNewLocationName" value="LocationName:"/>
                                                                <ice:inputText binding="#{Employee$EmployeePage.txtNameNewLocationType}" id="txtNameNewLocationType"/>
                                                                <ice:commandButton action="#{Employee$EmployeePage.btnSaveNewLocationType_action}"
                                                                    binding="#{Employee$EmployeePage.btnSaveNewILocationType}" id="btnSaveNewILocationType"
                                                                    partialSubmit="true" value="Save"/>
                                                            </ice:panelLayout>
                                                        </ice:panelGroup>
                                                    </f:facet>
                                                </ice:panelPopup>
                                            </ice:panelTab>
                                            <!--///////////////////////////////////////////Start Family////////////////////////////////////////// -->
                                            <ice:panelTab id="tabFamily" label="#{msgs.lblFamily}" style="height: 7px; vertical-align: bottom">
                                                <ice:panelLayout id="panelLayout2" style="height:550px; position: inherit; width: 100%;">
                                                    <ice:panelLayout id="forLabelFamily" layout="flow"
                                                        style="height: 30px; left: 15px; top: 55px; position: absolute; width: 735px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:outputLabel binding="#{Employee$EmployeePage.lblForFamilyFullName}" id="lblForFamilyFullName"
                                                            style="left: 0px; top: 0px; position: absolute; width: 720px" value="#{msgs.Employee }"/>
                                                        <ice:outputText id="lblAddressType"
                                                            style="font-size: 10px; margin-left: 365px; margin-top: 5px; position: absolute; text-align: left; width: 120px" value="#{msgs.Relation} "/>
                                                        <ice:selectOneMenu binding="#{Employee$EmployeePage.drlRelationType}" id="drlRelationType"
                                                            partialSubmit="true" required="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 500px; top: 5px; position: absolute; width: 150px"
                                                            value="#{Employee$EmployeePage.defaultSelectedData17.selectedObject}" valueChangeListener="#{Employee$EmployeePage.drlRelationType_processValueChange}">
                                                            <f:selectItems id="selectOneMenu2selectItems6" value="#{Employee$EmployeePage.__reationType}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlRelationType" id="message3"
                                                            infoClass="infoMessage"
                                                            style="font-size: 11px; margin-left: 600px; margin-top: 4px; position: absolute; width: 80px" warnClass="warnMessage"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="lyFamilyimage" rendered="false"
                                                        style="height: 230px; margin-left: 420px; top: 138px; position: absolute; width: 320px;" styleClass="insideContainerMain">
                                                        <ice:graphicImage binding="#{Employee$EmployeePage.imgMemberFamily}" height="150" id="imgMemberFamily"
                                                            style="height: 205px; margin-left: 50px; margin-top: 20px; position: absolute; width: 192px" url="/Employee/images/new.JPG"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="lyFamilyimageBro" rendered="false"
                                                        style="height: 35px; margin-left: 420px; top:95px; position: absolute; width: 320px;" styleClass="insideContainerMain">
                                                        <ice:inputFile actionListener="#{Employee$EmployeePage.inputmemberPhoto_processAction}"
                                                            autoUpload="true" binding="#{Employee$EmployeePage.inputmemberPhoto}" id="inputmemberPhoto" style="height: 35px; margin-left: 4px; margin-top: 5px; position: absolute; width: 320px"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout binding="#{Employee$EmployeePage.lyFamilyName}" id="lyFamilyName" layout="flow"
                                                        style="height: 250px; margin-left: 5px; top: 95px; position: absolute; width: 734px" styleClass="insideContainerMain">
                                                        <ice:outputText id="lblEmergencyContact"
                                                            style="font-size: 10px; margin-left: 515px; margin-top: 50px; position: absolute; text-align: left; width: 120px" value="#{msgs.EmergencyContact}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Employee$EmployeePage.choEmergenceyContact}"
                                                            id="choEmergenceyContact" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 500px; top: 50px; position: absolute" valueChangeListener="#{Employee$EmployeePage.choEmergenceyContact_processValueChange}"/>
                                                        <ice:outputText escape="false" id="lbFamilylFirstName"
                                                            style="font-size: 10px; margin-left: 15px; margin-top: 15px; position: absolute; text-align: left; width: 70px" value="#{msgs.FirstName}"/>
                                                        <ice:inputText binding="#{Employee$EmployeePage.txtFamilyFirstName}" id="txtFamilyFirstName"
                                                            immediate="true" partialSubmit="true" required="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 150px; margin-top: 15px; position: absolute; width: 144px" validator="#{Employee$EmployeePage.txtFamilyFirstName_validate}"/>
                                                        <ice:outputText id="lbFamilylMiddleName"
                                                            style="font-size: 10px; margin-left: 15px; margin-top: 50px; position: absolute; text-align: left; width: 80px" value="#{msgs.MidelName}"/>
                                                        <ice:inputText binding="#{Employee$EmployeePage.txtFamilyMiddleName}" id="txtFamilyMiddleName"
                                                            immediate="true" partialSubmit="true" required="true"
                                                            style="margin-left: 150px; margin-top: 50px; position: absolute; width: 144px;border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter;" validator="#{Employee$EmployeePage.txtFamilyMiddleName_validate}"/>
                                                        <ice:outputText id="lbFamilylLastName"
                                                            style="font-size: 11px; margin-left: 15px; margin-top: 85px; position: absolute; text-align: left; width: 70px" value="#{msgs.LastName}"/>
                                                        <ice:inputText binding="#{Employee$EmployeePage.txtFamilyLastName}" id="txtFamilyLastName"
                                                            required="true" style="margin-left: 150px; margin-top: 85px; position: absolute; width: 144px;border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter;"/>
                                                        <ice:outputText id="lblFamilyDateOfBirth"
                                                            style="font-size: 10px; margin-left: 15px; margin-top: 120px; position: absolute; text-align: left; width: 125px" value="#{msgs.DateOfBirth}"/>
                                                        <ice:outputText id="lblFaSex"
                                                            style="font-size: 11px; margin-left: 400px; margin-top: 15px; position: absolute; text-align: left; width: 50px" value="#{msgs.Sex}"/>
                                                        <ice:outputText id="lblHire"
                                                            style="font-size: 10px; margin-left: 515px; margin-top: 90px; position: absolute; text-align: left; width: 106px" value="#{msgs.Heir}"/>
                                                        <ice:outputText id="lblFamilyAliveOrDied"
                                                            style="font-size: 10px; margin-left: 515px; margin-top: 135px; position: absolute; text-align: left; width: 106px" value="Is Alive"/>
                                                        <ice:selectBooleanCheckbox binding="#{Employee$EmployeePage.cobHeir}" id="cobHeir" immediate="true"
                                                            partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 500px; margin-top: 90px; position: absolute" valueChangeListener="#{Employee$EmployeePage.cobHeir_processValueChange}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Employee$EmployeePage.chkMale}" id="chkMale" immediate="true"
                                                            partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; margin-left: 580px; margin-top: 15px; position: absolute"
                                                            value="#{Employee$EmployeePage.defaultSelectedData39.selectedBoolean}" valueChangeListener="#{Employee$EmployeePage.chkMale_processValueChange}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Employee$EmployeePage.ckbFamilyAliveOrDied}"
                                                            id="ckbFamilyAliveOrDied" immediate="true" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; margin-left: 500px; margin-top: 135px; position: absolute"
                                                            value="#{Employee$EmployeePage.defaultSelectedData63.selectedBoolean}" valueChangeListener="#{Employee$EmployeePage.ckbFamilyAliveOrDied_processValueChange}"/>
                                                        <ice:outputText id="lblGenderFemale1"
                                                            style="font-size: 10px; margin-left: 520px; margin-top: 15px; left: -2px; position: absolute; text-align: left; width: 52px" value="#{msgs.Female}"/>
                                                        <ice:outputText id="lblGenderMale1"
                                                            style="font-size: 10px; margin-left: 600px; margin-top: 15px; position: absolute; text-align: left; width: 40px" value="#{msgs.Male}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Employee$EmployeePage.chkFemale}" id="chkFemale" immediate="true"
                                                            partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 500px; margin-top: 15px; position: absolute"
                                                            value="#{Employee$EmployeePage.defaultSelectedData38.selectedBoolean}" valueChangeListener="#{Employee$EmployeePage.chkFemale_processValueChange}"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtFamilyFirstName" id="message17"
                                                            infoClass="infoMessage"
                                                            style="font-size: 11px; margin-left: 300px; margin-top: 13px; position: absolute; width: 80px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtFamilyMiddleName"
                                                            id="message18" infoClass="infoMessage"
                                                            style="font-size: 11px; margin-left: 300px; margin-top: 50px; position: absolute; width: 80px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtFamilyLastName" id="message19"
                                                            infoClass="infoMessage"
                                                            style="font-size: 11px; margin-left: 300px; margin-top: 90px; position: absolute; width: 80px" warnClass="warnMessage"/>
                                                        <ice:outputText binding="#{Employee$EmployeePage.lblValidateFamilyGender}" id="lblValidateFamilyGender"
                                                            rendered="false"
                                                            style="color: red; font-size: 11px; margin-left: 95px; margin-top: 199px; position: absolute; text-align: left; width: 50px" value="Required "/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnCalFamilyBirthDate_action}"
                                                            id="btnCalFamilyBirthDate" image="/resources/images/cal_button.gif" immediate="true"
                                                            partialSubmit="true" style="margin-left: 270px; margin-top: 117px; position: absolute; "/>
                                                        <ice:inputText binding="#{Employee$EmployeePage.txtFamilyBirthDate}" id="txtFamilyBirthDate"
                                                            immediate="true" partialSubmit="true" required="true"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 150px; margin-top: 120px; position: absolute; width: 117px" validator="#{Employee$EmployeePage.txtFamilyMiddleName_validate}"/>
                                                        <ice:selectInputDate binding="#{Employee$EmployeePage.calFamilyDateOfBirth}" id="calFamilyDateOfBirth"
                                                            immediate="true" partialSubmit="true" popupDateFormat="yyyy-MM-dd" renderMonthAsDropdown="true"
                                                            renderYearAsDropdown="true" rendered="false"
                                                            style="color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 150px; margin-top: 150px; position: absolute; width: 144px; z-index: 500"
                                                            value="#{OverTime$OverTimePage.selectInputDate2Bean.date1}" valueChangeListener="#{Employee$EmployeePage.calFamilyDateOfBirth_processValueChange}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnFaAdd_action}"
                                                            binding="#{Employee$EmployeePage.btnFaAdd}" id="btnFaAdd"
                                                            style="margin-left: 500px; margin-top:200px; position: absolute; width: 80px" value="#{msgs.cmdAdd}"/>
                                                        <ice:outputText id="outputText20"
                                                            style=" font-size: 10px; margin-left: 15px; margin-top: 154px; position: absolute; text-align: left; width: 125px" value="Phone No"/>
                                                        <ice:inputText binding="#{Employee$EmployeePage.txt_phone_no}" id="txt_phone_no" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; margin-left: 150px; margin-top: 150px; position: absolute; width: 137px"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="fordatatableFamily" layout="flow"
                                                        style="overflow: auto;  height: 180px; left: 15px; top: 358px; position: absolute; width: 735px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:dataTable binding="#{Employee$EmployeePage.dataTable}" id="dataTable"
                                                            style="left: 0px; top: -10px; position: absolute; width: 100%"
                                                            value="#{Employee$EmployeePage.familyInformation}" var="currentRow" varStatus="">
                                                            <ice:column id="column1" styleClass="width:250px">
                                                                <ice:outputText id="outputText1"
                                                                    style=" font-family: 'Lucida Sans'; font-size: 11px; font-style: normal" value="#{currentRow['relation_Type']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblRelationType" style="font-size:10px" value="#{msgs.Relation}"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column2">
                                                                <ice:outputText id="outputText4" value="#{currentRow['family_FirstName']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblFirstName1" value="#{msgs.FirstName}"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column3">
                                                                <ice:outputText id="txtfamilyMidelName" value="#{currentRow['familyMidelName']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblMidelName" value="#{msgs.MidelName}"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column4">
                                                                <ice:outputText id="txtfamilyLastName" value="#{currentRow['familyLastName']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblLastName" value="#{msgs.LastName}"/>
                                                                </f:facet>
                                                                <ice:rowSelector binding="#{Employee$EmployeePage.rowSelectorEvaSession}"
                                                                    id="rowSelectorEvaSession" multiple="false" preStyleOnSelection="true"
                                                                    selectionListener="#{Employee$EmployeePage.rowSelectorEvaSession_processMyEvent}"
                                                                    toggleOnClick="true" value="#{currentRow['selected']}"/>
                                                            </ice:column>
                                                            <ice:column id="column5">
                                                                <ice:outputText id="txtfamilydateof_Birth" value="#{currentRow['dateof_Birth']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblDateOfBirth1" value="#{msgs.DateOfBirth}"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column6">
                                                                <ice:outputText id="txtFamilySex" value="#{currentRow['_sex']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblSex1" value="#{msgs.Sex}"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column26">
                                                                <ice:outputText id="txtPhoneNo" value="#{currentRow['phone_no']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblSPhoneNo" value="#{msgs.TelephoneHome}"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column7">
                                                                <ice:outputText id="txtHeir" value="#{currentRow['hire']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblHeir" value="#{msgs.Heir}"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colEmergencyContact">
                                                                <ice:outputText id="txtEmergencyContact" value="#{currentRow['emergency_Contact']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblEmergencyContact" value="#{msgs.EmergencyContact}"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colAliveOrNot">
                                                                <ice:outputText id="txtForAliveOrNot" value="#{currentRow['aliveOrDied']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblForAliveOrNot" value="Alive?"/>
                                                                </f:facet>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="buttonsfamily"
                                                        style="margin-left: 0px; margin-top: 500px;height:50px; width:740px; position: absolute" styleClass="insideContainerMain">
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnFamilyNew_action}"
                                                            binding="#{Employee$EmployeePage.btnFamilyNew}" id="btnFamilyNew" immediate="true"
                                                            partialSubmit="true" style="margin-left: 40px; width: 80px" value="#{msgs.cmdNew}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnFaSave_action}"
                                                            binding="#{Employee$EmployeePage.btnFaSave}" id="btnFaSave" immediate="true" partialSubmit="true"
                                                            style="margin-left: 40px; width: 80px" value="#{msgs.cmdSave}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnFaEdit_action}"
                                                            binding="#{Employee$EmployeePage.btnFaEdit}" disabled="true" id="btnFaEdit" partialSubmit="true"
                                                            style="margin-left: 40px; width: 80px" value="Edit"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnFaUpdate_action}"
                                                            binding="#{Employee$EmployeePage.btnFaUpdate}" id="btnFaUpdate" immediate="true"
                                                            partialSubmit="true" style="margin-left: 40px; width: 80px" value="#{msgs.cmdUpdate}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnFaReset_action}"
                                                            binding="#{Employee$EmployeePage.btnFaReset}" id="btnFaReset" immediate="true" partialSubmit="true"
                                                            style="margin-left: 40px; width: 80px" value="#{msgs.cmdReset}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnFaDelete_action}"
                                                            binding="#{Employee$EmployeePage.btnFaDelete}" disabled="true" id="btnFaDelete" immediate="true"
                                                            style="margin-left: 40px; width: 80px" value="#{msgs.cmdDelete}"/>
                                                    </ice:panelLayout>
                                                    <ice:panelPopup autoCentre="true" binding="#{Employee$EmployeePage.pnlPopUpDateSetting}" clientOnly="true"
                                                        draggable="true" id="pnlPopUpDateSetting" modal="true" rendered="false" style="display: block; height: 259px; width: 676px">
                                                        <f:facet name="header">
                                                            <ice:panelGroup id="pnlgridPopUpDateSetting" styleClass="popupHeaderWrapper">
                                                                <ice:outputText id="PopUpAttachmentDateSetting" style="width:400px" styleClass="popupHeaderText" value="BUNNA INTERNATIONAL BANK Human Resource Management System-Date  Setting"/>
                                                                <ice:commandButton action="#{Employee$EmployeePage.modalPnlCloseBtnDateSetting_action}"
                                                                    alt="Close" id="modalPnlCloseBtnDateSetting" image="/resources/images/close.gif"
                                                                    immediate="true" partialSubmit="true" style="left: 655px; top: 2px; position: absolute"
                                                                    styleClass="popupHeaderImage" title="Close Popup" type="button"/>
                                                            </ice:panelGroup>
                                                        </f:facet>
                                                        <f:facet name="body">
                                                            <ice:panelGroup id="lblDDID" style="display: block; height: 193px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                                                <ice:outputLabel id="outputLabel6" style="left: 50px; top: 42px; position: absolute" value="Title Name :"/>
                                                                <ice:inputText binding="#{Employee$EmployeePage.txtDateDefference}" disabled="true"
                                                                    id="txtDateDefference" partialSubmit="true" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 268px; top: 38px; position: absolute; width: 159px"/>
                                                                <ice:commandButton id="btntitleNew"
                                                                    style="left: 50px; top: 141px; position: absolute; width: 90px" value="New"/>
                                                                <ice:commandButton id="btntitleSave"
                                                                    style="left: 170px; top: 141px; position: absolute; width: 90px" value="Save"/>
                                                                <ice:commandButton id="btnttileEdit"
                                                                    style="left: 290px; top: 141px; position: absolute; width: 90px" value="Edit"/>
                                                                <ice:commandButton id="btnTitleEdit"
                                                                    style="left: 410px; top: 141px; position: absolute; width: 90px" value="Update"/>
                                                                <ice:commandButton disabled="true" id="btnTitleDelete"
                                                                    style="left: 530px; top: 141px; position: absolute; width: 90px" value="Delete"/>
                                                                <ice:inputTextarea binding="#{Employee$EmployeePage.txtDDDescription}" disabled="true"
                                                                    id="txtDDDescription" partialSubmit="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter;left: 267px; top: 72px; position: absolute; width: 272px"/>
                                                                <ice:outputLabel id="outputLabel7" style="left: 50px; top: 84px; position: absolute" value="Description :"/>
                                                                <ice:outputLabel id="lblDDID12323322" rendered="false"/>
                                                            </ice:panelGroup>
                                                        </f:facet>
                                                    </ice:panelPopup>
                                                </ice:panelLayout>
                                            </ice:panelTab>
                                            <!--/////////////////////////////////////////////////////////////////Start Address//////////////////////////////////////////////////////////////////////////////////-->
                                            <ice:panelTab id="tabAddress" label="#{msgs.lblAddress}">
                                                <ice:panelLayout id="lyAddress" style="height:550px; position: inherit; width: 100%;">
                                                    <ice:panelLayout id="froLabeladdresstype" layout="flow"
                                                        style="font-family: Georgia,'Times New Roman',times,serif; font-size: 12px; height: 30px; left: 10px; top: 60px; position: absolute; width: 744px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:outputLabel binding="#{Employee$EmployeePage.lblAddressTypeFullName}" id="lblAddressTypeFullName"
                                                            style="left: 0px; top: 0px; position: absolute; width: 720px" value="#{msgs.Employee}"/>
                                                        <ice:outputText id="lblAddressTypeone1"
                                                            style="font-size: 10px; top: 5px; left: 423px;  position: absolute" value="#{msgs.AddressType} "/>
                                                        <ice:selectOneMenu binding="#{Employee$EmployeePage.drlAddressType}" id="drlAddressType" required="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94);  font-size: 11px; font-style: normal; font-weight: lighter;margin-top: 5px; margin-left: 500px; position: absolute; width: 200px" valueChangeListener="#{Employee$EmployeePage.drlAddressType_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectItems" value="#{Employee$EmployeePage._addressTypeList}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlAddressType" id="message31"
                                                            infoClass="infoMessage" style="font-size: 10px; top: 5px; left: 580px;  position: absolute" warnClass="warnMessage"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnProfile" style="height: 618px; left: 0px; top: 110px; position: absolute; width: 744px; ">
                                                        <ice:panelLayout id="lyAddressLocation" layout="flow"
                                                            style="border: 1px solid rgb(204, 204, 204); height: 120px; left: 10px; top: -10px; overflow: auto; position: absolute; width: 744px; " styleClass="insideContainerMain">
                                                            <ice:outputText id="lblRegion" style="font-size: 10px; left: 19px; top: 20px; position: absolute" value="#{msgs.Region}"/>
                                                            <ice:outputText escape="false" id="lblZone"
                                                                style="font-size: 10px; left: 19px; top: 54px; position: absolute" value="#{msgs.Woreda}"/>
                                                            <ice:outputText id="lblWoreda" style="font-size: 10px; left: 396px; top: 20px; position: absolute" value="#{msgs.ZoneCity}"/>
                                                            <ice:outputText id="lblKabele" style="left: 396px; top: 54px; position: absolute" value="#{msgs.Kabele}"/>
                                                            <ice:selectOneMenu binding="#{Employee$EmployeePage.drlRegion}" id="drlRegion" immediate="true"
                                                                partialSubmit="true" required="true"
                                                                style="border: 1px solid rgb(115, 179, 206); left: 138px; top: 14px; position: absolute; width: 190px"
                                                                value="#{Employee$EmployeePage.defaultSelectedData21.selectedObject}" valueChangeListener="#{Employee$EmployeePage.drlRegion_processValueChange}">
                                                                <f:selectItems id="selectOneMenu1selectItems1" value="#{Employee$EmployeePage.regionOpt}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:selectOneMenu binding="#{Employee$EmployeePage.drlZone}" id="drlZone" immediate="true"
                                                                partialSubmit="true" required="true"
                                                                style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 500px; top: 14px; position: absolute; width: 190px"
                                                                value="#{Employee$EmployeePage.defaultSelectedData22.selectedObject}" valueChangeListener="#{Employee$EmployeePage.drlZone_processValueChange}">
                                                                <f:selectItems id="selectOneMenu1selectItems2" value="#{Employee$EmployeePage.zoneList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:selectOneMenu binding="#{Employee$EmployeePage.drlWoreda}" disabled="true" id="drlWoreda"
                                                                immediate="true" partialSubmit="true" required="true"
                                                                style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 138px; top: 50px; position: absolute; width: 190px"
                                                                value="#{Employee$EmployeePage.defaultSelectedData23.selectedObject}" valueChangeListener="#{Employee$EmployeePage.drlWoreda_processValueChange}">
                                                                <f:selectItems id="selectOneMenu2selectItems7" value="#{Employee$EmployeePage.woredaList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:selectOneMenu binding="#{Employee$EmployeePage.drlKebele}" id="drlKebele" immediate="true"
                                                                partialSubmit="true"
                                                                style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 500px; top: 50px; position: absolute; width: 121px" value="#{Employee$EmployeePage.defaultSelectedData24.selectedObject}">
                                                                <f:selectItems id="selectOneMenu3selectItems1" value="#{Employee$EmployeePage.optKebele}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:outputText id="lblHouseNumber"
                                                                style="font-size: 10px; left: 19px; top: 88px; position: absolute" value="#{msgs.HouseNumber}"/>
                                                            <ice:inputText binding="#{Employee$EmployeePage.txtHouseNumber}" id="txtHouseNumber"
                                                                immediate="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 138px; top: 84px; position: absolute"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlRegion" id="message21"
                                                                infoClass="infoMessage" style="font-size: 10px; left: 200px; top: 38px; position: absolute" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlWoreda" id="message22"
                                                                infoClass="infoMessage" style="font-size: 10px; left: 570px; top: 38px; position: absolute" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlZone" id="message23"
                                                                infoClass="infoMessage" style="font-size: 10px; left: 200px; top: 74px; position: absolute" warnClass="warnMessage"/>
                                                            <ice:outputText id="lblStreetAdress"
                                                                style="font-size: 10px; left: 396px; top: 88px; position: absolute" value="StreetAddress"/>
                                                            <ice:inputText binding="#{Employee$EmployeePage.txt_Sefere}" id="txt_Sefere" immediate="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 502px; top: 88px; position: absolute"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="paneContact"
                                                            style="border: 1px solid rgb(204, 204, 204); height: 140px; left: 10px; top: 120px; overflow: auto; position: absolute; width: 744px; " styleClass="insideContainerMain">
                                                            <ice:outputText id="lblTelHome"
                                                                style="font-size: 10px; left: 19px; top: 20px; position: absolute; text-align: left; width: 60px" value="#{msgs.POBox}"/>
                                                            <ice:outputText id="lblTelOffice"
                                                                style="font-size: 10px; left: 396px; top: 20px; position: absolute; text-align: left; width: 120px" value="#{msgs.TelephoneOffice}"/>
                                                            <ice:outputText id="lblMobile"
                                                                style="font-size: 10px; left: 19px; top: 54px; position: absolute; text-align: left; width: 95px" value="#{msgs.Mobilenumber}"/>
                                                            <ice:outputText id="lblTelHome1"
                                                                style="font-size: 10px; left: 396px; top: 54px; position: absolute; text-align: left; width: 100px" value="#{msgs.TelephoneHome}"/>
                                                            <ice:inputText binding="#{Employee$EmployeePage.txtPobox}" id="txtPobox" immediate="true"
                                                                style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 138px; top: 14px; position: absolute; width: 120px" validator="#{Employee$EmployeePage.txtPobox_validate}"/>
                                                            <ice:inputText binding="#{Employee$EmployeePage.txtMobile}" id="txtMobile" immediate="true"
                                                                style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 138px; top: 50px; position: absolute; width: 190px" validator="#{Employee$EmployeePage.txtMobile_validate}"/>
                                                            <ice:inputText binding="#{Employee$EmployeePage.txtTelOffice}" id="txtTelOffice" immediate="true"
                                                                style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 500px; top: 14px; position: absolute; width: 190px" validator="#{Employee$EmployeePage.txtTelOffice_validate}"/>
                                                            <ice:inputText binding="#{Employee$EmployeePage.txtTelHome}" id="txtTelHome" immediate="true"
                                                                style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 500px; top: 50px; position: absolute; width: 190px" validator="#{Employee$EmployeePage.txtTelHome_validate}"/>
                                                            <ice:outputText id="lblEmail"
                                                                style="font-size: 10px; left: 19px; top: 88px; position: absolute; text-align: left; width: 48px" value="#{msgs.Email}"/>
                                                            <ice:inputText binding="#{Employee$EmployeePage.txtEmail}" id="txtEmail" immediate="true"
                                                                style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 138px; top: 84px; position: absolute; width: 190px" validator="#{Employee$EmployeePage.txtEmail_validate}"/>
                                                            <ice:commandButton action="#{Employee$EmployeePage.btnAddAddress_action}"
                                                                binding="#{Employee$EmployeePage.btnAddAddress}" id="btnAddAddress"
                                                                style="left: 500px; top: 100px; position: absolute; width: 81px" value="Add"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtMobile" id="message26"
                                                                infoClass="infoMessage" style="font-size: 10px; left: 200px; top: 72px; position: absolute" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtPobox" id="message27"
                                                                infoClass="infoMessage" style="font-size: 10px; left: 170px; top: 38px; position: absolute" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtTelOffice" id="message28"
                                                                infoClass="infoMessage"
                                                                style="font-size: 10px; left: 540px; top: 38px; position: absolute; width: 100px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtEmail" id="message29"
                                                                infoClass="infoMessage"
                                                                style="font-size: 10px; left: 200px; top: 106px; position: absolute; width: 100px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtTelHome" id="message30"
                                                                infoClass="infoMessage"
                                                                style="font-size: 10px; left: 540px; top: 72px; position: absolute; width: 100px" warnClass="warnMessage"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="panelLayout1"
                                                            style="border: 1px solid rgb(204, 204, 204); height: 168px; left: 10px; top: 272px; overflow: auto; position: absolute; width: 744px" styleClass="insideContainerMain">
                                                            <ice:dataTable binding="#{Employee$EmployeePage.tblAddress}" columnClasses="desriptionColumn"
                                                                id="tblAddress" style="left: 0px; top: -15px; position: absolute; width: 100%"
                                                                value="#{Employee$EmployeePage.employeeAddress}" var="currentRow">
                                                                <ice:column id="column8" style="text-align: center; width: 180px">
                                                                    <ice:outputText id="outputText6"
                                                                        style="font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter" value="#{currentRow['addressType']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText8" value="Address Type"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="column9" style="text-align: center; width: 100px">
                                                                    <ice:outputText id="outputText9"
                                                                        style="font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter;" value="#{currentRow['regionDescrption']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText10" value="Region"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colSubcity" style="text-align: center; width: 100px">
                                                                    <ice:outputText id="outputText11"
                                                                        style="font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter;" value="#{currentRow['zoneDescription']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText12" value="Zone"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="column10" style="text-align: center">
                                                                    <ice:outputText id="txtSubcity"
                                                                        style="font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter;" value="#{currentRow['woredaDescription']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="lblSubcity" value="Sub city"/>
                                                                    </f:facet>
                                                                    <ice:rowSelector binding="#{Employee$EmployeePage.rowSelectorEmployeeAddress}"
                                                                        id="rowSelectorEmployeeAddress" multiple="false" preStyleOnSelection="true"
                                                                        selectionListener="#{Employee$EmployeePage.rowSelectorEmployeeAddress_processMyEvent}"
                                                                        toggleOnClick="true" value="#{currentRow['selectedAddress']}"/>
                                                                </ice:column>
                                                                <ice:column id="colKebele" style="text-align: center">
                                                                    <ice:outputText id="txtKebele"
                                                                        style="font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter;" value="#{currentRow['kebelleDescription']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="lblKebele" value="Kebele"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colHousenumber" style="text-align: center; width: 100px">
                                                                    <ice:outputText id="txtHousenumber"
                                                                        style="font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter;" value="#{currentRow['houseNumber']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="lblHousenumber" value="House number"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="column12">
                                                                    <ice:outputText id="outputText21"
                                                                        style="font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter;" value="#{currentRow['sefere']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText22" value="Street Address"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                            </ice:dataTable>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="lyAddressButtons"
                                                            style="margin-left:10px; margin-top: 450px; position: absolute; width: 744px; " styleClass="insideContainerMain">
                                                            <ice:commandButton action="#{Employee$EmployeePage.btnADNew_action}"
                                                                binding="#{Employee$EmployeePage.btnADNew}" id="btnADNew" immediate="true" partialSubmit="true"
                                                                style="margin-left: 30px; width: 80px" value="#{msgs.cmdNew}"/>
                                                            <ice:commandButton action="#{Employee$EmployeePage.btnADSave_action}"
                                                                binding="#{Employee$EmployeePage.btnADSave}" id="btnADSave" partialSubmit="true"
                                                                style="margin-left: 30px; width: 80px" value="#{msgs.cmdSave}"/>
                                                            <ice:commandButton action="#{Employee$EmployeePage.btnADEdit_action}"
                                                                binding="#{Employee$EmployeePage.btnADEdit}" disabled="true" id="btnADEdit" partialSubmit="true"
                                                                style="margin-left: 30px; width: 80px" value="#{msgs.cmdEdit}"/>
                                                            <ice:commandButton action="#{Employee$EmployeePage.btnADUpdate_action}"
                                                                binding="#{Employee$EmployeePage.btnADUpdate}" id="btnADUpdate" partialSubmit="true"
                                                                style="margin-left: 30px; width: 80px" value="#{msgs.cmdUpdate}"/>
                                                            <ice:commandButton action="#{Employee$EmployeePage.btnADReset_action}"
                                                                actionListener="#{Employee$EmployeePage.btnADReset_processAction}"
                                                                binding="#{Employee$EmployeePage.btnADReset}" id="btnADReset" immediate="true"
                                                                partialSubmit="true" style="margin-left: 30px; width: 80px" value="#{msgs.cmdReset}"/>
                                                            <ice:commandButton action="#{Employee$EmployeePage.btnADDelete_action}"
                                                                binding="#{Employee$EmployeePage.btnADDelete}" disabled="true" id="btnADDelete"
                                                                partialSubmit="true" style="margin-left: 30px; width: 80px" value="#{msgs.cmdDelete}"/>
                                                        </ice:panelLayout>
                                                    </ice:panelLayout>
                                                </ice:panelLayout>
                                                <!--//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// New End//////////////////-->
                                            </ice:panelTab>
                                            <!--/////////////   End Address//////////////////////////////////////////////Start Apperance///////////////////////////////////////////-->
                                            <ice:panelTab id="tabAppearance" label="#{msgs.lblAppearance}" rendered="false">
                                                <ice:panelLayout id="lyAppearance" style="height:550px; position: inherit; width: 100%;">
                                                    <ice:panelLayout id="apper" style="height: 300px; position: absolute; width: 360px" styleClass="insideContainerMain">
                                                        <ice:outputText id="lblHeight" style="font-size: 10px; left: 50px; top: 30px; position: absolute" value="#{msgs.Height}"/>
                                                        <ice:inputText binding="#{Employee$EmployeePage.txtHeight}" id="txtHeight" required="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 30px; position: absolute; width: 140px" validator="#{Employee$EmployeePage.txtHeight_validate}"/>
                                                        <ice:outputText id="lblWeight" style="font-size: 10px; left: 50px; top: 86px; position: absolute" value="#{msgs.Weight}"/>
                                                        <ice:inputText action="#{Employee$EmployeePage.txtWeight_action}"
                                                            binding="#{Employee$EmployeePage.txtWeight}" id="txtWeight" required="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 78px; position: absolute; width: 140px"/>
                                                        <ice:outputText id="lblBloodGroup" style="font-size: 10px; left: 50px; top: 128px; position: absolute" value="#{msgs.BloodGroup}"/>
                                                        <ice:outputText id="lblEyeColor" style="font-size: 10px; left: 50px; top: 170px; position: absolute" value="#{msgs.EyeColor}"/>
                                                        <ice:inputText binding="#{Employee$EmployeePage.txtEyeColor}" id="txtEyeColor" required="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 170px; position: absolute; width: 140px"/>
                                                        <ice:selectBooleanCheckbox binding="#{Employee$EmployeePage.optA}" id="optA" partialSubmit="true"
                                                            style="left: 166px; top: 128px; position: absolute"
                                                            value="#{Employee$EmployeePage.defaultSelectedData40.selectedBoolean}" valueChangeListener="#{Employee$EmployeePage.optA_processValueChange}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Employee$EmployeePage.optB}" id="optB" partialSubmit="true"
                                                            style="left: 201px; top: 128px; position: absolute"
                                                            value="#{Employee$EmployeePage.defaultSelectedData41.selectedBoolean}" valueChangeListener="#{Employee$EmployeePage.optB_processValueChange}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Employee$EmployeePage.optAB}" id="optAB" partialSubmit="true"
                                                            style="left: 236px; top: 128px; position: absolute"
                                                            value="#{Employee$EmployeePage.selectBooleanCheckbox3Bean.selectedBoolean}" valueChangeListener="#{Employee$EmployeePage.optAB_processValueChange}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Employee$EmployeePage.optO}" id="optO" partialSubmit="true"
                                                            style="font-size: 10px; left: 271px; top: 128px; position: absolute; pxmargin-left: 290.0px;"
                                                            value="#{Employee$EmployeePage.selectBooleanCheckbox4Bean.selectedBoolean}" valueChangeListener="#{Employee$EmployeePage.optO_processValueChange}"/>
                                                        <ice:outputText id="txtB"
                                                            style="font-size: 10px; left: 216px; top: 128px; position: absolute; width: 10px" value="B"/>
                                                        <ice:outputText id="txtAB"
                                                            style="font-size: 10px; left: 251px; top: 128px; position: absolute; width: 10px" value="AB"/>
                                                        <ice:outputText id="txtO"
                                                            style="font-size: 12px; left: 286px; top: 128px; position: absolute; width: 10px" value="o"/>
                                                        <ice:outputText id="txtA"
                                                            style="font-size: 10px; left: 181px; top: 128px; position: absolute; width: 10px" value="A"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtHeight" id="message24"
                                                            infoClass="infoMessage" style="font-size: 10px; left: 200px; top: 52px; position: absolute" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtWeight" id="message25"
                                                            infoClass="infoMessage" style="font-size: 10px; left: 200px; top: 100px; position: absolute" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtEyeColor" id="message33"
                                                            infoClass="infoMessage" style="font-size: 10px; left: 200px; top: 192px; position: absolute" warnClass="warnMessage"/>
                                                        <ice:outputText binding="#{Employee$EmployeePage.lblBloodGroup1}" id="lblBloodGroup1" rendered="false"
                                                            style="color: red; font-size: 13px; left: 205px; top: 148px; position: absolute" value="outputText"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="buttonApperance"
                                                        style="left: 10px; height:50px; top: 400px; position: absolute; width: 744px" styleClass="insideContainerMain">
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnAPNew_action}"
                                                            binding="#{Employee$EmployeePage.btnAPNew}" id="btnAPNew" style="margin-left: 40px; width: 80px" value="#{msgs.cmdNew}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnAPSave_action}"
                                                            actionListener="#{Employee$EmployeePage.btnAPSave_processAction}"
                                                            binding="#{Employee$EmployeePage.btnAPSave}" id="btnAPSave" style="margin-left: 40px; width: 80px" value="#{msgs.cmdSave}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnAPEdit_action}"
                                                            actionListener="#{Employee$EmployeePage.btnAPEdit_processAction}"
                                                            binding="#{Employee$EmployeePage.btnAPEdit}" disabled="true" id="btnAPEdit"
                                                            style="margin-left: 40px; width: 80px" value="#{msgs.cmdEdit}"/>
                                                        <ice:commandButton actionListener="#{Employee$EmployeePage.btnupdate_processAction}" id="btnupdate"
                                                            style="margin-left: 40px; width: 80px" value="#{msgs.cmdUpdate}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.cmdApReset_action}"
                                                            actionListener="#{Employee$EmployeePage.btnAPReset_processAction}"
                                                            binding="#{Employee$EmployeePage.btnAPReset}" id="btnAPReset" style="margin-left: 40px; width: 80px" value=" #{msgs.cmdReset}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnApDelete_action}"
                                                            binding="#{Employee$EmployeePage.btnApDelete}" disabled="true" id="btnApDelete"
                                                            style="margin-left: 40px; width: 80px" value=" #{msgs.cmdDelete}"/>
                                                    </ice:panelLayout>
                                                </ice:panelLayout>
                                            </ice:panelTab>
                                            <!--/////////////////////////////////////////////////////////////////End Apperance///////////////////////////////////////////-->
                                            <!--//////////////////////////////////////////////////////////////////Start Education///////////////////////////////////////////-->
                                            <ice:panelTab id="tabEducation" label="#{msgs.lblEducation}">
                                                <ice:panelLayout id="lyEducation" style="height:550px; position: inherit; width: 100%;">
                                                    <ice:panelLayout id="froLabelEducationCode" layout="flow"
                                                        style="font-family: Georgia,'Times New Roman',times,serif; font-size: 12px; height: 30px; left: 10px; top: 55px; position: absolute; width: 744px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:outputLabel binding="#{Employee$EmployeePage.lblEducFullName}" id="lblEducFullName"
                                                            style="left: 0px; top: 0px; position: absolute; width: 720px" value="#{msgs. Employee }"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout binding="#{Employee$EmployeePage.lyEducationCode}" id="lyEducationCode" layout="flow"
                                                        style="font-family: Georgia,'Times New Roman',times,serif; font-size: 12px; height: 247px; left: 10px; top: 95px; position: absolute; width: 744px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:outputText escape="false" id="lblEducationlevelCode"
                                                            style="font-size: 10px; left: 40px; top: 35px; position: absolute" value="#{msgs.LevelOfEducation}"/>
                                                        <ice:selectOneMenu binding="#{Employee$EmployeePage.drlLevelOfEducation}" id="drlLevelOfEducation"
                                                            partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 170px; top: 30px; position: absolute; width: 200px" value="#{Employee$EmployeePage.defaultSelectedData29.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems3" value="#{Employee$EmployeePage.educLevelOpt}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputText id="lblInstitution" style="font-size: 10px; left: 40px; top: 80px; position: absolute" value="#{msgs.Institution} "/>
                                                        <ice:inputText binding="#{Employee$EmployeePage.txtInstitution}" id="txtInstitution" immediate="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 170px; top: 76px; position: absolute; width: 200px" validator="#{Employee$EmployeePage.txtInstitution_validate}"/>
                                                        <ice:outputText id="lblTypeOfEducation"
                                                            style="font-size: 10px; left: 432px; top: 120px; position: absolute" value="#{msgs.TypeOfEducation}"/>
                                                        <ice:outputText id="lblCategoryOfEducation"
                                                            style="font-size: 10px; left: 48px; top: 120px; position: absolute" value="#{msgs.Category}"/>
                                                        <ice:selectOneMenu binding="#{Employee$EmployeePage.drlTypesOfEducation}" id="drlTypesOfEducation"
                                                            partialSubmit="true"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 526px; top: 118px; position: absolute; width: 167px" value="#{Employee$EmployeePage.defaultSelectedDataEducationType.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems4" value="#{Employee$EmployeePage.educTypeOpt}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectOneMenu binding="#{Employee$EmployeePage.drlEducationCatagories}" id="drlEducationCatagories"
                                                            partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 170px; top: 115px; position: absolute; width: 200px"
                                                            value="#{Employee$EmployeePage.defaultSelectedData30.selectedObject}" valueChangeListener="#{Employee$EmployeePage.drlEducationCatagories_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectEducCategories" value="#{Employee$EmployeePage.allEducationCatagories}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectOneMenu binding="#{Employee$EmployeePage.drlGradingScale}" id="drlGradingScale"
                                                            immediate="true" partialSubmit="true" required="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); left: 526px; top: 70px; position: absolute; width: 167px"
                                                            value="#{Employee$EmployeePage.defaultSelectedDataGradingScale.selectedObject}" valueChangeListener="#{Employee$EmployeePage.drlGradingScale_processValueChange}">
                                                            <f:selectItems id="selectOneMenuGradingScale" value="#{Employee$EmployeePage.gradingSystems}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputText id="lblStartingDate" style="font-size: 10px; left: 48px; top: 168px; position: absolute" value="#{msgs.StartDate}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnCalEducStartDate_action}" id="btnCalEducStartDate"
                                                            image="/resources/images/cal_button.gif" immediate="true" style="margin-left: 388px; margin-top: 132px; left: -76px; top: 36px; position: absolute"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnCalEducEndDate_action}" id="btnCalEducEndDate"
                                                            image="/resources/images/cal_button.gif" immediate="true" style="margin-left: 308px; margin-top: 132px; left: 364px; top: 36px; position: absolute"/>
                                                        <ice:inputText binding="#{Employee$EmployeePage.txtDispStartEducDate}" disabled="true"
                                                            id="txtDispStartEducDate" immediate="true" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 166px; position: absolute; width: 143px"/>
                                                        <ice:inputText binding="#{Employee$EmployeePage.txtDispEndEducDate}" disabled="true"
                                                            id="txtDispEndEducDate" immediate="true" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 526px; top: 170px; position: absolute; width: 143px"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.cmdEducationAdd_action}"
                                                            binding="#{Employee$EmployeePage.cmdEducationAdd}" id="cmdEducationAdd"
                                                            style="margin-left: 490px; margin-top: 190px; left: 110px; top: 26px; position: absolute; width: 100px" value=" #{msgs.cmdAdd}"/>
                                                        <ice:outputText id="lblEndDate" style="font-size: 10px; left: 432px; top: 168px; position: absolute" value="#{msgs.CompletionDate}"/>
                                                        <ice:outputText id="lblAward" style="font-size: 10px; left: 40px; top: 215px; position: absolute" value="#{msgs.Award}"/>
                                                        <ice:inputText binding="#{Employee$EmployeePage.txtaward}" id="txtaward" required="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 170px; top: 213px; position: absolute; width: 200px"/>
                                                        <ice:outputText id="lblResult" style="font-size: 10px; left: 430px; top: 35px; position: absolute" value="#{msgs.Result}"/>
                                                        <ice:outputText id="lblScale" style="font-size: 10px; left: 432px; top: 72px; position: absolute" value="#{msgs.Scale}"/>
                                                        <ice:inputText binding="#{Employee$EmployeePage.txtResult}" id="txtResult" immediate="true"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 528px; top: 30px; position: absolute; width: 165px" value="0.00"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlLevelOfEducation"
                                                            id="message32" infoClass="infoMessage" showDetail="true"
                                                            style="font-size: 11px; font-weight: normal; left: 216px; top: 55px; position: absolute; width: 85px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="" id="message36"
                                                            infoClass="infoMessage" showSummary="true"
                                                            style="position: absolute; left: 624px; top: 96px; width: 88px; height: 20px;" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlTypesOfEducation"
                                                            id="message37" infoClass="infoMessage" showDetail="true"
                                                            style="font-size: 10px; font-weight: normal; height: 20px; left: 560px; top: 147px; position: absolute; width: 88px" warnClass="warnMessage"/>
                                                        <ice:commandLink action="#{Employee$EmployeePage.cmdLinkAddEducType_action}" id="cmdLinkAddEducType"
                                                            immediate="true" partialSubmit="true"
                                                            style="font-style: normal; font-weight: bold; left: 696px; top: 120px; position: absolute" value="[+]"/>
                                                        <ice:selectInputDate binding="#{Employee$EmployeePage.calStartEduc}" id="calStartEduc" immediate="true"
                                                            popupDateFormat="yyyy-MM-dd" rendered="false"
                                                            style="position: absolute; left: 144px; top: 44px; width: 190px; height: 212px;"
                                                            value="#{Employee$EmployeePage.selectInputDateDateOfEducStartDateBean.date1}" valueChangeListener="#{Employee$EmployeePage.calStartEduc_processValueChange}"/>
                                                        <ice:selectInputDate binding="#{Employee$EmployeePage.calEndEduc}" id="calEndEduc" immediate="true"
                                                            popupDateFormat="yyyy-MM-dd" rendered="false"
                                                            style="position: absolute; left: 480px; top: 44px; width: 190px; height: 212px;"
                                                            value="#{Employee$EmployeePage.selectInputDateDateOfEducEndDateBean.date1}" valueChangeListener="#{Employee$EmployeePage.calEndEduc_processValueChange}"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout binding="#{Employee$EmployeePage.lyEducationlevel}" id="lyEducationlevel" layout="flow"
                                                        style="height: 180px; left: 10px; top: 350px; overflow: auto; position: absolute; width: 744px" styleClass="insideContainerMain">
                                                        <ice:dataTable binding="#{Employee$EmployeePage.educationTable}" id="educationTable" scrollFooter="true"
                                                            style="left: 0px; top: -10px; position: absolute; width: 100%"
                                                            value="#{Employee$EmployeePage.listOfEducation}" var="currentRow" varStatus="">
                                                            <ice:column id="colEducationLevel">
                                                                <ice:outputText id="tblEducationLevel" value="#{currentRow['educationTypeDescription']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="txtEducationLevel" value="#{msgs.TypeOfEducation}"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="Institutions">
                                                                <ice:outputText id="lblInstitutions" value="#{currentRow['educationLevelDescription']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="txtInstitutions" value="#{msgs.LevelOfEducation}"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="tblEducationType" style="height: 27px">
                                                                <ice:outputText id="lbltblEducationType" value="#{currentRow['instuation']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="txttblEducationType" value="#{msgs.Institution}"/>
                                                                </f:facet>
                                                                <ice:rowSelector binding="#{Employee$EmployeePage.rowSelectorEmployeeEducation}"
                                                                    id="rowSelectorEmployeeEducation" multiple="false" preStyleOnSelection="true"
                                                                    selectionListener="#{Employee$EmployeePage.rowSelectorEmployeeEducation_processMyEvent}"
                                                                    toggleOnClick="true" value="#{currentRow['selectedEducation']}"/>
                                                            </ice:column>
                                                            <ice:column id="tblStartingDate">
                                                                <ice:outputText id="lbltblStartingDate" value="#{currentRow['startDate']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="txttblStartingDate" value="#{msgs.StartDate}"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="tblCompletionDate">
                                                                <ice:outputText id="lbltblCompletionDate" value="#{currentRow['copletionDate']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="txttblCompletionDate" value="#{msgs.CompletionDate}"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="tblAward">
                                                                <ice:outputText id="lbltblAward" value="#{currentRow['award']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="txttblAward" value="#{msgs.Award}"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="tblResult">
                                                                <ice:outputText id="lbltblResult" value="#{currentRow['result']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="txttblResult" value="#{msgs.Result}"/>
                                                                </f:facet>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="buttonEDperance"
                                                        style="left: 10px; height:50px; top: 540px; position: absolute; width: 744px" styleClass="insideContainerMain">
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnEDNew_action}"
                                                            binding="#{Employee$EmployeePage.btnEDNew}" id="btnEDNew" partialSubmit="true"
                                                            style="margin-left: 40px; width: 80px" value=" #{msgs.cmdNew}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnEDSave_action}"
                                                            binding="#{Employee$EmployeePage.btnEDSave}" id="btnEDSave" partialSubmit="true"
                                                            style="margin-left: 40px; width: 80px" value=" #{msgs.cmdSave}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnEDEdit_action}"
                                                            binding="#{Employee$EmployeePage.btnEDEdit}" disabled="true" id="btnEDEdit" partialSubmit="true"
                                                            style="margin-left: 40px; width: 80px" value=" #{msgs.cmdEdit}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnEDUpdate_action}"
                                                            binding="#{Employee$EmployeePage.btnEDUpdate}" id="btnEDUpdate" partialSubmit="true"
                                                            style="margin-left: 40px; width: 80px" value=" #{msgs.cmdUpdate}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnEDReset_action}"
                                                            binding="#{Employee$EmployeePage.btnEDReset}" id="btnEDReset" immediate="true" partialSubmit="true"
                                                            style="margin-left: 40px; width: 80px" value=" #{msgs.cmdReset}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnEDDelete_action}"
                                                            binding="#{Employee$EmployeePage.btnEDDelete}" id="btnEDDelete" partialSubmit="true"
                                                            style="margin-left: 40px; width: 80px" value=" #{msgs.cmdDelete}"/>
                                                    </ice:panelLayout>
                                                </ice:panelLayout>
                                            </ice:panelTab>
                                            <!--///////////////////////////////////////////////////////////////////End Education///////////////////////////////////////////-->
                                            <!--//////////////////////////////////////////////////////////////////Start Training /////////////////////////////////////////-->
                                            <ice:panelTab id="tabTraining" label="Training">
                                                <ice:panelLayout id="lyTraining" style="height:550px; position: inherit; width: 100%;">
                                                    <ice:panelLayout id="froLabelTraining" layout="flow"
                                                        style="font-family: Georgia,'Times New Roman',times,serif; font-size: 12px; height: 30px; left: 10px; top: 55px; position: absolute; width: 744px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:outputLabel binding="#{Employee$EmployeePage.lblTrainingFullName}" id="lblTrainingFullName"
                                                            style="left: 0px; top: 0px; position: absolute; width: 720px" value="#{msgs.Employee}"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="lyTrainingTab" layout="flow"
                                                        style="border: 1px solid rgb(204, 204, 204); height: 190px; left: 10px; top: 90px; overflow: auto; position: absolute; width: 744px" styleClass="insideContainerMain">
                                                        <ice:outputText escape="false" id="lblTrainingandCourse"
                                                            style="font-size: 10px; left: 40px; top: 35px; position: absolute" value="#{msgs.InstitutionName}"/>
                                                        <ice:outputText escape="false" id="lblTrainingInstitution"
                                                            style="font-size: 10px; left: 40px; top: 80px; position: absolute" value="#{msgs.StartDate}"/>
                                                        <ice:outputText escape="false" id="lblTrainingOrCourseName"
                                                            style="font-size: 10px; height: 32px; left: 430px; top: 35px; position: absolute; width: 71px" value="#{msgs.TrainingCourseName}"/>
                                                        <ice:outputText escape="false" id="lblTraEndDate"
                                                            style="font-size: 10px; left: 432px; top: 80px; position: absolute" value="End Date"/>
                                                        <ice:inputText binding="#{Employee$EmployeePage.txtTraEndDate}" id="txtTraEndDate" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); left: 526px; top: 76px; position: absolute; width: 200px"/>
                                                        <ice:outputText escape="false" id="lblTraStartDate"
                                                            style="font-size: 10px; left: 40px; top: 120px; position: absolute" value="#{msgs.SponsoredBy}"/>
                                                        <ice:inputText binding="#{Employee$EmployeePage.txtTraStartDate}" id="txtTraStartDate" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 170px; top: 76px; position: absolute; width: 200px"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnAddTraining_action}"
                                                            binding="#{Employee$EmployeePage.btnAddTraining}" id="btnAddTraining"
                                                            style="margin-left: 550px; margin-top: 130px; position: absolute; width: 100px" value="Add Training "/>
                                                        <ice:inputText binding="#{Employee$EmployeePage.txtTrainingName}" id="txtTrainingName" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 528px; top: 30px; position: absolute; width: 165px"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlInstitutionName" id="message54"
                                                            infoClass="infoMessage"
                                                            style="height: 20px; left: 183px; top: 55px; position: absolute; width: 164px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtTraStartDate" id="message55"
                                                            infoClass="infoMessage"
                                                            style="height: 20px; left: 183px; top: 96px; position: absolute; width: 165px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtTraEndDate" id="message56"
                                                            infoClass="infoMessage"
                                                            style="height: 20px; left: 542px; top: 96px; position: absolute; width: 141px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtTrainingName" id="message566"
                                                            infoClass="infoMessage"
                                                            style="height: 20px; left: 542px; top: 52px; position: absolute; width: 141px" warnClass="warnMessage"/>
                                                        <ice:outputText id="outputText85"
                                                            style="color: rgb(255, 0, 0); left: 120px; top: 120px; position: absolute; text-align: left; width: 5px" value="*"/>
                                                        <ice:outputText id="outputText86"
                                                            style="color: rgb(255, 0, 0); left: 110px; top: 80px; position: absolute; text-align: left; width: 5px" value="*"/>
                                                        <ice:outputText id="outputText87"
                                                            style="color: rgb(255, 0, 0); left: 135px; top: 35px; position: absolute; text-align: left; width: 5px" value="*"/>
                                                        <ice:outputText id="outputText88"
                                                            style="color: rgb(255, 0, 0); left: 460px; top: 55px; position: absolute; text-align: left; width: 5px" value="*"/>
                                                        <ice:message errorClass="iceMsgError errorMessage" fatalClass="iceMsgFatal fatalMessage"
                                                            for="drlSponsoredBy" id="message11" infoClass="iceMsgInfo infoMessage"
                                                            style="height: 20px; left: 183px; top: 135px; position: absolute; width: 165px" warnClass="iceMsgWarn warnMessage"/>
                                                        <ice:selectOneMenu binding="#{Employee$EmployeePage.drlInstitutionName}" id="drlInstitutionName"
                                                            partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 170px; top: 30px; position: absolute; width: 200px" value="#{Employee$EmployeePage.defaultSelectedData66.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems13" value="#{Employee$EmployeePage.instituationList}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectOneMenu binding="#{Employee$EmployeePage.drlSponsoredBy}" id="drlSponsoredBy"
                                                            partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 170px; top: 115px; position: absolute; width: 200px" value="#{Employee$EmployeePage.defaultSelectedData68.selectedObject}">
                                                            <f:selectItems id="selectOneMenu2selectItems" value="#{Employee$EmployeePage.sponsoredByTraining}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnTrainingStartDate_action}"
                                                            id="btnTrainingStartDate" image="/resources/images/cal_button.gif"
                                                            style="left: 355px; top: 81px; position: absolute" value="submit"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnTrainingEndDate_action}" id="btnTrainingEndDate"
                                                            image="/resources/images/cal_button.gif" style="left: 710px; top: 82px; position: absolute" value="submit"/>
                                                        <ice:selectInputDate binding="#{Employee$EmployeePage.calEndDate}" id="calEndDate" rendered="false"
                                                            style="height: 212px; left: 530px; top: 0px; position: absolute; width: 190px; z-index: 1000"
                                                            value="#{Employee$EmployeePage.selectInputDate1Bean.date1}" valueChangeListener="#{Employee$EmployeePage.calEndDate_processValueChange}"/>
                                                        <ice:selectInputDate binding="#{Employee$EmployeePage.calStartDate}" id="calStartDate" rendered="false"
                                                            style="height: 212px; left: 172px; top: 0px; position: absolute; width: 190px; z-index: 1000"
                                                            value="#{Employee$EmployeePage.selectInputDate2Bean.date1}" valueChangeListener="#{Employee$EmployeePage.calStartDate_processValueChange}"/>
                                                        <ice:inputText binding="#{Employee$EmployeePage.txtDuration}" id="txtDuration" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 170px; top:154px; position: absolute; width: 200px"/>
                                                        <ice:outputText id="lblduration" style="font-size: 10px; left: 40px; top: 160px; position: absolute" value="#{msgs.Duration}"/>
                                                        <ice:commandLink action="#{Employee$EmployeePage.cmd_instiutation_action}"
                                                            binding="#{Employee$EmployeePage.cmd_instiutation}" id="cmd_instiutation"
                                                            style="left: 370px; top: 30px; position: absolute" value="[+]"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="lyTrainingTabTable" layout="flow"
                                                        style="border: 1px solid rgb(204, 204, 204); height: 250px; left: 10px; top: 290px; overflow: auto; position: absolute; width: 744px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:dataTable id="dtlTra" style="left: 0px; top: -10px; position: relative; width: 100%"
                                                            value="#{Employee$EmployeePage.listOfEmployeeTraining}" var="currentRow" width="100%">
                                                            <ice:column id="column1">
                                                                <ice:outputText id="outputText15" value="#{currentRow['trainingName']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText16" value="Training/Course"/>
                                                                </f:facet>
                                                                <ice:rowSelector id="rowSelectorEmployeeTraining" multiple="false" preStyleOnSelection="true"
                                                                    selectionListener="#{Employee$EmployeePage.rowSelectorEmployeeTraining_processMyEvent}"
                                                                    toggleOnClick="true" value="#{currentRow['selectedTraining']}"/>
                                                            </ice:column>
                                                            <ice:column id="column2">
                                                                <ice:outputText id="outputText17" value="#{currentRow['institution']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText18" value="Institution"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column4">
                                                                <ice:outputText id="outputText221" value="#{currentRow['startDate']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText233" value="Start Date"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column44">
                                                                <ice:outputText id="outputText222" value="#{currentRow['endDate']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText223" value="End Date"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colDuration">
                                                                <ice:outputText id="outDuration" value="#{currentRow['duration']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblDuration" value="Duration"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="tblTrainingSponsored">
                                                                <ice:outputText id="lbltblTrainingSponsored" value="#{currentRow['sponsoredBy']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="txttblTrainingSponsored" value="Sponsored By"/>
                                                                </f:facet>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="buttonTrainingPerance"
                                                        style="height: 50px; left: 10px; top: 550px; position: absolute; width: 744px" styleClass="insideContainerMain">
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnTrainingNew_action}"
                                                            binding="#{Employee$EmployeePage.btnTrainingNew}" id="btnTrainingNew" partialSubmit="true"
                                                            style="margin-left: 40px; width: 80px" value=" #{msgs.cmdNew}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnTrainingSave_action}"
                                                            binding="#{Employee$EmployeePage.btnTrainingSave}" id="btnTrainingSave" partialSubmit="true"
                                                            style="margin-left: 40px; width: 80px" value=" #{msgs.cmdSave}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnTrainingEdit_action}"
                                                            binding="#{Employee$EmployeePage.btnTrainingEdit}" disabled="true" id="btnTrainingEdit"
                                                            partialSubmit="true" style="margin-left: 40px; width: 80px" value=" #{msgs.cmdEdit}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnTrainingUpdate_action}"
                                                            binding="#{Employee$EmployeePage.btnTrainingUpdate}" id="btnTrainingUpdate" partialSubmit="true"
                                                            style="margin-left: 40px; width: 80px" value=" #{msgs.cmdUpdate}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnTrainingReset_action}"
                                                            binding="#{Employee$EmployeePage.btnTrainingReset}" id="btnTrainingReset" immediate="true"
                                                            partialSubmit="true" style="margin-left: 40px; width: 80px" value=" #{msgs.cmdReset}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnTrainingDelete_action}"
                                                            binding="#{Employee$EmployeePage.btnTrainingDelete}" id="btnTrainingDelete" partialSubmit="true"
                                                            style="margin-left: 40px; width: 80px" value=" #{msgs.cmdDelete}"/>
                                                    </ice:panelLayout>
                                                </ice:panelLayout>
                                                <ice:panelPopup autoCentre="true" binding="#{Employee$EmployeePage.pnlInsertNewInstiutationType}"
                                                    clientOnly="true" draggable="true" id="pnlInsertNewInstiutationType" modal="true" rendered="false"
                                                    style="border-style: none; background-color: transparent; display: block; height: 106px; left: 3px; top: 80px; position: absolute; width: 667px" styleClass="message">
                                                    <f:facet name="header">
                                                        <ice:panelGroup id="pnlgridpnMessageInstiutationType" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                                            <ice:outputText id="pnMessageTitleNewInstiutauionType"
                                                                style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System : Add New Instiutaion Name"/>
                                                            <ice:commandLink action="#{Employee$EmployeePage.btnClosePopupInsertNewInstiutationType_action}"
                                                                id="btnClosePopupInsertNewInstiutationType" immediate="true"
                                                                style="background-image: url(../resources/close_icon.gif); height: 19px; left: 700px; top: 20px; position: absolute; width: 19px"
                                                                styleClass="popupHeaderImage" title="Close Popup"/>
                                                        </ice:panelGroup>
                                                    </f:facet>
                                                    <f:facet name="body">
                                                        <ice:panelGroup id="panelGroupMessageNewInstiutaionType"
                                                            style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                                            <ice:panelLayout id="pnlMessageBodyNewInstiutType" layout="flow"
                                                                style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                                                <ice:outputText id="lblNewLanguageName" value="Instiutaion Name : "/>
                                                                <ice:inputText binding="#{Employee$EmployeePage.txtNameNewInstiutationType}" id="txtNameNewInstiutationType"/>
                                                                <ice:commandButton action="#{Employee$EmployeePage.btnSaveNewInstiutationType_action}"
                                                                    binding="#{Employee$EmployeePage.btnSaveNewInstiutationType}"
                                                                    id="btnSaveNewInstiutationType" partialSubmit="true" value=" Save "/>
                                                            </ice:panelLayout>
                                                        </ice:panelGroup>
                                                    </f:facet>
                                                </ice:panelPopup>
                                            </ice:panelTab>
                                            <!--////////////////////////////////////////////////////////////////End Of training///////////////////////////////////////////-->
                                            <!--///////////////////////////////////////////////////////////////////Start Language///////////////////////////////////////////-->
                                            <ice:panelTab id="tabLanguage" label="#{msgs.lblLanguage}">
                                                <ice:panelLayout id="lyLanguage" style="height:550px; position: inherit; width: 100%;">
                                                    <ice:panelLayout id="froLabelLanguage" layout="flow"
                                                        style="font-family: Georgia,'Times New Roman',times,serif; font-size: 12px; height: 30px; left: 10px; top: 55px; position: absolute; width: 744px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:outputLabel binding="#{Employee$EmployeePage.lblLanguageFullName}" id="lblLanguageFullName"
                                                            style="left: 0px; top: 0px; position: absolute; width: 720px" value="Employee : "/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="lyLanguageName" layout="flow"
                                                        style=" height:45px;  margin-left: 0px; margin-top: 35px; position: relative; width:750px;" styleClass="insideContainerMain">
                                                        <ice:outputText id="lblLanguageName"
                                                            style="font-size: 11px; margin-left: 38px; margin-top: 10px; position: absolute; text-align: left; width: 150px" value="#{msgs.LanguageName}"/>
                                                        <ice:selectOneMenu binding="#{Employee$EmployeePage.drlLanguageType}" id="drlLanguageType"
                                                            partialSubmit="true" required="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; margin-left: 170px; margin-top: 10px; position: absolute; width: 200px"
                                                            value="#{Employee$EmployeePage.defaultSelectedData31.selectedObject}" valueChangeListener="#{Employee$EmployeePage.drlLanguageType_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectItems5" value="#{Employee$EmployeePage.languageOpt}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlLanguageType" id="message38"
                                                            infoClass="infoMessage"
                                                            style="font-size: 10px; height: 20px; left: 220px; top: 32px; position: absolute; width: 88px" warnClass="warnMessage"/>
                                                        <ice:commandButton id="btnAdd" rendered="false" style="left: 384px; top: 0px; position: absolute" value="ADD"/>
                                                        <ice:commandLink action="#{Employee$EmployeePage.cmdAddNewLanguage_action}" id="cmdAddNewLanguage"
                                                            immediate="true"
                                                            style="font-style: normal; font-weight: bold; left: 375px; top: 10px; position: absolute" value="[+]"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="lyLanguagePerformace" layout="flow"
                                                        style="font-family: Georgia,'Times New Roman',times,serif; font-size: 12px; height: 190px; margin-left: 0px; margin-top: 10px; position: relative; width: 744px; -rave-layout: grid;" styleClass="insideContainerMain">
                                                        <ice:outputText id="lblLanguageListening"
                                                            style="font-size: 10px; left: 38px; top: 30px; position: absolute" value="#{msgs.Listening}"/>
                                                        <ice:outputText id="lblLanguageSpeaking"
                                                            style="font-size: 10px; left: 38px; top: 86px; position: absolute" value="#{msgs.Speaking}"/>
                                                        <ice:outputText id="lblLanguageReading"
                                                            style="font-size: 10px; left: 434px; top: 30px; position: absolute" value="#{msgs.Reading}"/>
                                                        <ice:outputText id="lblLanguageWriting"
                                                            style="font-size: 10px; left: 434px; top: 86px; position: absolute" value="#{msgs.Writing}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnLAAdd_action}"
                                                            binding="#{Employee$EmployeePage.btnLAAdd}" id="btnLAAdd"
                                                            style="left: 38px; top: 114px; position: absolute; width: 80px" value=" #{msgs.cmdAdd}"/>
                                                        <ice:selectOneMenu binding="#{Employee$EmployeePage.drlListening}" id="drlListening"
                                                            partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 167px; top: 35px; position: absolute; width: 160px" value="#{Employee$EmployeePage.defaultSelectedData32.selectedObject}">
                                                            <f:selectItems id="selectOneMenu2selectItems8" value="#{Employee$EmployeePage.measurementOpt}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectOneMenu binding="#{Employee$EmployeePage.drlSpeaking}" id="drlSpeaking" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 167px; top: 88px; position: absolute; width: 160px" value="#{Employee$EmployeePage.defaultSelectedData33.selectedObject}">
                                                            <f:selectItems id="selectOneMenu3selectItems2" value="#{Employee$EmployeePage.measurementOpt}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectOneMenu binding="#{Employee$EmployeePage.drlReading}" id="drlReading" partialSubmit="true"
                                                            required="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 530px; top: 35px; position: absolute; width: 160px" value="#{Employee$EmployeePage.defaultSelectedData34.selectedObject}">
                                                            <f:selectItems id="selectOneMenu4selectItems1" value="#{Employee$EmployeePage.measurementOpt}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectOneMenu binding="#{Employee$EmployeePage.drlWriting}" id="drlWriting" partialSubmit="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 530px; top: 88px; position: absolute; width: 160px">
                                                            <f:selectItems id="selectOneMenu5selectItems" value="#{Employee$EmployeePage.measurementOpt}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlListening" id="message39"
                                                            infoClass="infoMessage"
                                                            style="font-size: 10px; height: 20px; left: 220px; top: 57px; position: absolute; width: 88px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlReading" id="message40"
                                                            infoClass="infoMessage"
                                                            style="font-size: 10px; height: 20px; left: 586px; top: 57px; position: absolute; width: 88px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlSpeaking" id="message41"
                                                            infoClass="infoMessage"
                                                            style="font-size: 10px; height: 20px; left: 220px; top: 113px; position: absolute; width: 88px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlWriting" id="message42"
                                                            infoClass="infoMessage"
                                                            style="font-size: 10px; height: 20px; left: 586px; top: 113px; position: absolute; width: 88px" warnClass="warnMessage"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="lyLanguageTable"
                                                        style="height: 200px; left: 10px; top: 350px; overflow: auto; position: absolute; width: 744px" styleClass="insideContainerMain">
                                                        <ice:dataTable binding="#{Employee$EmployeePage.tblLanguageTable}" id="tblLanguageTable"
                                                            style="left:0px; top:-10px; position: absolute; width: 100%;"
                                                            value="#{Employee$EmployeePage.listOfLanguage}" var="currentRow">
                                                            <ice:column id="colLanguage">
                                                                <ice:outputText id="outputText7" value="#{currentRow['language_description']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="tblLanguage" value="#{msgs.LanguageName}"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="Listening">
                                                                <ice:outputText id="tblListening" value="#{currentRow['listening']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="colListening" value="#{msgs.Listening}"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="Speaking">
                                                                <ice:outputText id="tblSpeaking" value="#{currentRow['speaking']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="colSpeaking" value="#{msgs.Speaking}"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="Reading">
                                                                <ice:outputText id="tblReading" value="#{currentRow['reading']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="colReading" value="#{msgs.Reading}"/>
                                                                </f:facet>
                                                                <ice:rowSelector binding="#{Employee$EmployeePage.rowSelectorEmployeeLanguage}"
                                                                    id="rowSelectorEmployeeLanguage" multiple="false" preStyleOnSelection="true"
                                                                    selectionListener="#{Employee$EmployeePage.rowSelectorEmployeeLanguage_processMyEvent}"
                                                                    toggleOnClick="true" value="#{currentRow['selectedLanguage']}"/>
                                                            </ice:column>
                                                            <ice:column id="Writing">
                                                                <ice:outputText id="tblWriting" value="#{currentRow['writing']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="colWriting" value="#{msgs.Writing}"/>
                                                                </f:facet>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="buttonLangage"
                                                        style="height: 50px; left: 10px; top: 560px; position: absolute; width: 744px" styleClass="insideContainerMain">
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnLANew_action}"
                                                            binding="#{Employee$EmployeePage.btnLANew}" id="btnLANew" immediate="true" partialSubmit="true"
                                                            style="margin-left: 40px; width: 80px" value=" #{msgs.cmdNew}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnLASave_action}"
                                                            binding="#{Employee$EmployeePage.btnLASave}" id="btnLASave" immediate="true" partialSubmit="true"
                                                            style="margin-left: 40px; width: 80px" value=" #{msgs.cmdSave}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnLAEdit_action}"
                                                            binding="#{Employee$EmployeePage.btnLAEdit}" disabled="true" id="btnLAEdit" partialSubmit="true"
                                                            style="margin-left: 40px; width: 80px" value=" #{msgs.cmdEdit}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnLAUpdate_action}"
                                                            binding="#{Employee$EmployeePage.btnLAUpdate}" id="btnLAUpdate" immediate="true"
                                                            partialSubmit="true" style="margin-left: 40px; width: 80px" value=" #{msgs.cmdUpdate}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnLAReset_action}"
                                                            binding="#{Employee$EmployeePage.btnLAReset}" id="btnLAReset" immediate="true" partialSubmit="true"
                                                            style="margin-left: 40px; width: 80px" value=" #{msgs.cmdReset}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnLADelete_action}"
                                                            binding="#{Employee$EmployeePage.btnLADelete}" id="btnLADelete" partialSubmit="true"
                                                            style="margin-left: 40px; width: 80px" value=" #{msgs.cmdDelete}"/>
                                                    </ice:panelLayout>
                                                </ice:panelLayout>
                                            </ice:panelTab>
                                            <!--///////////////////////////////////////////////////////////////////End Language///////////////////////////////////////////-->
                                            <!--///////////////////////////////////////////////////End Education/////////////////////////////////////////////////////////-->
                                            <ice:panelTab id="tabExInstitution" label="#{msgs.lblExperience}">
                                                <ice:panelLayout id="lyExInstitution" style="height:550px; position: inherit; width: 100%;">
                                                    <ice:panelLayout id="froLabelExperienceCode" layout="flow"
                                                        style="font-family: Georgia,'Times New Roman',times,serif; font-size: 12px; height: 30px; left: 10px; top: 55px; position: absolute; width: 744px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:outputLabel binding="#{Employee$EmployeePage.lblExpreienceFullName}" id="lblExpreienceFullName"
                                                            style="left: 0px; top: 0px; position: absolute; width: 720px" value="#{msgs.Employee}"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="lyInstiution"
                                                        style="border: 1px solid rgb(204, 204, 204); height: 290px; left: 10px; top: 94px; position: absolute; width: 744px" styleClass="insideContainerMain">
                                                        <ice:outputText id="lblExInstitution" style="font-size: 10px; left: 38px; top: 15px; position: absolute" value="#{msgs.Institution}"/>
                                                        <ice:inputText binding="#{Employee$EmployeePage.txtExperianceInstitution}" id="txtExperianceInstitution"
                                                            required="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 15px; position: absolute; width: 190px"/>
                                                        <ice:inputText binding="#{Employee$EmployeePage.txtDisplayedExpStartDate}" id="txtDisplayedExpStartDate"
                                                            required="true" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 111px; position: absolute; width: 167px"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnCalExpStartDate_action}" id="btnCalExpStartDate"
                                                            image="/resources/images/cal_button.gif" immediate="true" style="margin-left: 332px; margin-top: 111px; position: absolute; "/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnCalExpEndDate_action}" id="btnCalExpEndDate"
                                                            image="/resources/images/cal_button.gif" immediate="true" style="  margin-left: 680px; margin-top: 111px; position: absolute; "/>
                                                        <ice:inputText binding="#{Employee$EmployeePage.txtDisplayedExpEndDate}" id="txtDisplayedExpEndDate"
                                                            required="true" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 513px; top: 111px; position: absolute; width: 156px"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtExperianceInstitution"
                                                            id="message43" infoClass="infoMessage"
                                                            style="font-size: 10px; left: 230px; top: 42px; position: absolute; width: 88px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtExperanceSalary" id="message44"
                                                            infoClass="infoMessage" style="font-size: 10px; left: 530px; top: 42px; position: absolute" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtJobType" id="message45"
                                                            infoClass="infoMessage" style="font-size: 10px; left: 230px; top: 88px; position: absolute" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtExRank" id="message46"
                                                            infoClass="infoMessage" style="font-size: 10px; left: 580px; top: 88px; position: absolute" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtStartDate" id="message47"
                                                            infoClass="infoMessage" style="font-size: 10px; left: 220px; top: 138px; position: absolute" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtEXEndDate" id="message48"
                                                            infoClass="infoMessage" style="font-size: 10px; left: 580px; top: 138px; position: absolute" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtTermination" id="message49"
                                                            infoClass="infoMessage" style="font-size: 10px; left: 300px; top: 260px; position: absolute" warnClass="warnMessage"/>
                                                        <ice:outputText id="lblJobType" style="font-size: 10px; left: 38px; top: 63px; position: absolute" value="#{msgs.JobCode}"/>
                                                        <ice:inputText binding="#{Employee$EmployeePage.txtJobType}" id="txtJobType" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 63px; position: absolute; width: 190px"/>
                                                        <ice:outputText id="lblSalary1" style="font-size: 10px; left: 414px; top: 15px; position: absolute" value="#{msgs.Salary}"/>
                                                        <ice:inputText binding="#{Employee$EmployeePage.txtExperanceSalary}" id="txtExperanceSalary" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 513px; top: 15px; position: absolute; width: 190px"/>
                                                        <ice:outputText id="lblStartDate" style="font-size: 10px; left: 38px; top: 111px; position: absolute" value="#{msgs.StartDate}"/>
                                                        <ice:outputText id="lblExEndDate"
                                                            style="font-size: 10px; left: 414px; top: 111px; position: absolute; text-align: left; width: 100px" value="#{msgs.EndDate}"/>
                                                        <ice:outputText id="lblExRank" style="font-size: 10px; left: 414px; top: 63px; position: absolute" value="#{msgs.Rank}"/>
                                                        <ice:inputText binding="#{Employee$EmployeePage.txtExRank}" id="txtExRank" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 513px; top: 63px; position: absolute; width: 190px"/>
                                                        <ice:inputTextarea binding="#{Employee$EmployeePage.txtTermination}" id="txtTermination" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; height: 43px; left: 166px; top: 190px; position: absolute; width: 535px"/>
                                                        <ice:outputText id="outputText5" style="font-size: 10px; left: 38px; top: 200px; position: absolute" value="#{msgs.TerminationReason}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnAddExperience_action}"
                                                            binding="#{Employee$EmployeePage.btnAddExperience}" id="btnAddExperience"
                                                            style="left: 620px; top: 238px; position: absolute; width: 80px" value="#{msgs.cmdAdd}"/>
                                                        <ice:outputText id="lblExperiencePermanent"
                                                            style="font-size: 10px; left: 38px; top: 160px; position: absolute" value="#{msgs.Permanent}"/>
                                                        <ice:outputText id="lblExperienceContract"
                                                            style="font-size: 10px; left: 285px; top: 160px; position: absolute" value="#{msgs.Contract}"/>
                                                        <ice:outputText id="lblExperienceGovernmental"
                                                            style="font-size: 10px; left: 413px; top: 160px; position: absolute" value="#{msgs.Governmental}"/>
                                                        <ice:outputText id="lblExperiencePrivate"
                                                            style="font-size: 10px; left: 638px; top: 160px; position: absolute" value="#{msgs.Private}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Employee$EmployeePage.ckbExperiencePermanent}"
                                                            id="ckbExperiencePermanent" partialSubmit="true"
                                                            style="font-size: 10px; left: 166px; top: 160px; position: absolute"
                                                            value="#{Employee$EmployeePage.defaultSelectedData59.selectedBoolean}" valueChangeListener="#{Employee$EmployeePage.ckbExperiencePermanent_processValueChange}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Employee$EmployeePage.ckbExperienceContract}"
                                                            id="ckbExperienceContract" partialSubmit="true"
                                                            style="font-size: 10px; left: 340px; top: 160px; position: absolute"
                                                            value="#{Employee$EmployeePage.defaultSelectedData60.selectedBoolean}" valueChangeListener="#{Employee$EmployeePage.ckbExperienceContract_processValueChange}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Employee$EmployeePage.ckbExperienceGovernmental}"
                                                            id="ckbExperienceGovernmental" partialSubmit="true"
                                                            style="font-size: 10px; left: 510px; top: 160px; position: absolute"
                                                            value="#{Employee$EmployeePage.defaultSelectedData62.selectedBoolean}" valueChangeListener="#{Employee$EmployeePage.ckbExperienceGovernmental_processValueChange}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Employee$EmployeePage.ckbExperiencePrivate}"
                                                            id="ckbExperiencePrivate" partialSubmit="true"
                                                            style="font-size: 10px; left: 690px; top: 160px; position: absolute"
                                                            value="#{Employee$EmployeePage.defaultSelectedData61.selectedBoolean}" valueChangeListener="#{Employee$EmployeePage.ckbExperiencePrivate_processValueChange}"/>
                                                        <ice:selectInputDate binding="#{Employee$EmployeePage.calExpEndDate}" id="calExpEndDate"
                                                            popupDateFormat="yyyy-MM-dd" rendered="false"
                                                            style="border: 1px solid rgb(115, 179, 206);background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 513px; top: 40px; position: absolute; width: 190px"
                                                            value="#{Employee$EmployeePage.selectInputDateExperienceEnd.date1}" valueChangeListener="#{Employee$EmployeePage.calExpEndDate_processValueChange}"/>
                                                        <ice:selectInputDate binding="#{Employee$EmployeePage.calExpStartDate}" id="calExpStartDate"
                                                            popupDateFormat="yyyy-MM-dd" renderYearAsDropdown="true" rendered="false"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 40px; position: absolute; width: 190px"
                                                            value="#{Employee$EmployeePage.selectInputDateExperienceStart.date1}" valueChangeListener="#{Employee$EmployeePage.calExpStartDate_processValueChange}"/>
                                                        <ice:outputText id="lblRelationinMugherProfession"
                                                            style="font-size: 10px; left: 38px; top: 245px; position: absolute; width: 105px" value="#{msgs.RelationInBunnaProfession}"/>
                                                        <ice:selectOneMenu binding="#{Employee$EmployeePage.drlProfessionInMugher}" id="drlProfessionInMugher"
                                                            partialSubmit="true"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 250px; position: absolute; width: 167px" value="#{Employee$EmployeePage.defaultSelectedData65.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems12" value="#{Employee$EmployeePage.allJobs}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputText id="lblusethisExperienceforLeave"
                                                            style="font-size: 10px; left: 413px; top: 250px; position: absolute; width: 105px" value="#{msgs.ValidforLeave}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Employee$EmployeePage.ckbUsethisExperienceforLeave}"
                                                            id="ckbUsethisExperienceforLeave" partialSubmit="true"
                                                            style="font-size: 10px; left: 550px; top: 255px; position: absolute" value="#{Employee$EmployeePage.defaultSelectedData69.selectedBoolean}"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="lyTableExperiance"
                                                        style="border: 1px solid rgb(204, 204, 204); height: 150px; left: 10px; top: 390px; overflow: auto; position: absolute; width: 744px" styleClass="insideContainerMain">
                                                        <ice:dataTable binding="#{Employee$EmployeePage.tableExperiance}" id="tableExperiance"
                                                            style="border-top: solid rgb(153, 153, 153) 1px; width: 100%"
                                                            value="#{Employee$EmployeePage.listOfExperience}" var="currentRow">
                                                            <ice:column id="colExInstitution">
                                                                <ice:outputText id="txtExInstitution" value="#{currentRow['institution']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblExInstitution" value=" #{msgs.Institution}"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colExInstitutionPvtOrGvtal">
                                                                <ice:outputText id="txtExInstitutionPvtOrGvtal" value="#{currentRow['experiencePrivateOrGovernmental']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblExInstitutionPvtOrGvtal" value="Pvt/Gvtal"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colExJobType">
                                                                <ice:outputText id="txtExJobType" value="#{currentRow['job_Code']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblExJobType" value=" #{msgs.JobCode}"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colExInstitutionPermtOrContract">
                                                                <ice:outputText id="txtExInstitutionPermtOrContract" value="#{currentRow['experienceContractOrPrtmanent']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblExInstitutionPermtOrContract" value="Per/Cont"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colExSalary">
                                                                <ice:outputText id="txtExSalary" value="#{currentRow['salary']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblExSalary" value=" #{msgs.Salary}"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colExStartDate">
                                                                <ice:outputText id="txtExStartDate" value="#{currentRow['startDate']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblExStartDate" value="#{msgs.StartDate}"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colExEndDate">
                                                                <ice:outputText id="txtExEndDate" value="#{currentRow['copletionDate']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblExEndDate" value=" #{msgs.EndDate}"/>
                                                                </f:facet>
                                                                <ice:rowSelector binding="#{Employee$EmployeePage.rowSelectorEmployeeExperance}"
                                                                    id="rowSelectorEmployeeExperance" multiple="false" preStyleOnSelection="true"
                                                                    selectionListener="#{Employee$EmployeePage.rowSelectorEmployeeExperance_processMyEvent}"
                                                                    toggleOnClick="true" value="#{currentRow['selectedExperance']}"/>
                                                            </ice:column>
                                                            <ice:column id="colExRank">
                                                                <ice:outputText id="txtExRank" value="#{currentRow['rank']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblExRank" value="#{msgs.RankId}"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colExReason">
                                                                <ice:outputText id="txtExReason" value="#{currentRow['terminationReason']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblExReason" value=" #{msgs.Reason}"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colProfessionInMugher">
                                                                <ice:outputText id="txtprofessionInMugher" value="#{currentRow['experienceRelationinInMugherJobDescription']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblColprofessionInMugher" value="Relation IN BUNNA Profession"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colValidForLeave">
                                                                <ice:outputText id="txtValidForLeave" value="#{currentRow['experienceValidForLeave']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblValidforLeave" value="Valid For Leave"/>
                                                                </f:facet>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="buttonEXperance"
                                                        style="height: 50px; left: 10px; top: 563px; position: absolute; width: 744px" styleClass="insideContainerMain">
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnEXNew_action}"
                                                            binding="#{Employee$EmployeePage.btnEXNew}" id="btnEXNew" partialSubmit="true"
                                                            style="margin-left: 40px; width: 80px" value=" #{msgs.cmdNew}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnEXSave_action}"
                                                            binding="#{Employee$EmployeePage.btnEXSave}" id="btnEXSave" immediate="true"
                                                            style="margin-left: 40px; width: 80px" value=" #{msgs.cmdSave}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnEXEdit_action}"
                                                            binding="#{Employee$EmployeePage.btnEXEdit}" disabled="true" id="btnEXEdit" partialSubmit="true"
                                                            style="margin-left: 40px; width: 80px" value=" #{msgs.cmdEdit}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnEXUpdate_action}"
                                                            binding="#{Employee$EmployeePage.btnEXUpdate}" id="btnEXUpdate" immediate="true"
                                                            style="margin-left: 40px; width: 80px" value=" #{msgs.cmdUpdate}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnEXReset_action}"
                                                            binding="#{Employee$EmployeePage.btnEXReset}" id="btnEXReset" partialSubmit="true"
                                                            style="margin-left: 40px; width: 80px" value=" #{msgs.cmdReset}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnEXDelete_action}"
                                                            binding="#{Employee$EmployeePage.btnEXDelete}" id="btnEXDelete" immediate="true"
                                                            style="margin-left: 40px; width: 80px" value=" #{msgs.cmdDelete}"/>
                                                    </ice:panelLayout>
                                                </ice:panelLayout>
                                            </ice:panelTab>
                                            <ice:panelTab id="tabFile" label="File">
                                                <ice:panelLayout id="lyFile" style="height:550px; position: inherit; width: 100%;">
                                                    <ice:panelLayout id="lyOutFile" layout="flow"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 300px; left: 0px; top: 10px; position: relative; width: 775px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:outputText id="lblFileType" style="font-size: 10px; left: 40px; top: 40px; position: absolute" value="#{msgs.FileType}"/>
                                                        <ice:outputText id="lblFileName" style="font-size: 10px; left: 40px; top: 80px; position: absolute" value="#{msgs.FileName}"/>
                                                        <ice:outputText id="lblFilePath" style="font-size: 10px; left: 40px; top: 120px; position: absolute" value="#{msgs.FilePath}"/>
                                                        <ice:outputText id="lblFileRemark" style="font-size: 10px; left: 40px; top: 160px; position: absolute" value="#{msgs.Remark}"/>
                                                        <!--<ice:selectOneMenu binding="#{Employee$EmployeePage.ddnFileType}" id="ddnFileType" partialSubmit="true"


                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 130px; top: 40px; position: absolute; width: 190px" value="#{Employee$EmployeePage.defaultSelectedData77.selectedObject}">
                                                            <f:selectItems id="selectOneMenu2selectItems13" value="#{Employee$EmployeePage.fileType}"/>
                                                        </ice:selectOneMenu>





                                                        <ice:panelLayout id="pnlDownload" style="height: 38px; left: 200px; top: 250px; position: absolute; width: 50%">
                                                            <ice:outputResource attachment="false" fileName="#{Employee$EmployeePage.fileName}"
                                                                id="downloadButton" label="DownLoad" mimeType="#{Employee$EmployeePage.mimeType}"
                                                                rendered="#{Employee$EmployeePage.downloadAvailable}"
                                                                resource="#{Employee$EmployeePage.faResource}"
                                                                style="left: 40px; top: 10px; position: relative; width: 75px" type="button"/>
                                                        </ice:panelLayout>-->
                                                        <ice:inputFile action="#{Employee$EmployeePage.fileUploadAttached_action}"
                                                            actionListener="#{Employee$EmployeePage.fileUploadAttached_processAction}"
                                                            binding="#{Employee$EmployeePage.fileUploadAttached}" failOnEmptyFile="true" id="fileUploadAttached"
                                                            style="background-color: rgb(242, 246, 240); left: 130px; top: 120px; position: absolute"
                                                            uniqueFolder="true" width="421"/>
                                                        <ice:selectOneMenu binding="#{Employee$EmployeePage.ddnFileType}" id="ddnFileType" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 130px; top: 40px; position: absolute; width: 190px" value="#{Employee$EmployeePage.defaultSelectedData76.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems6" value="#{Employee$EmployeePage.fileType}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:inputTextarea binding="#{Employee$EmployeePage.txtFileRemark}" id="txtFileRemark" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 130px; top: 160px; position: absolute; width: 350px"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtFileName" id="message73"
                                                            infoClass="infoMessage"
                                                            style="height: 20px; left: 149px; top: 102px; position: absolute; width: 184px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="ddFileType" id="message74"
                                                            infoClass="infoMessage"
                                                            style="height: 20px; left: 152px; top: 63px; position: absolute; width: 167px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtFileRemark" id="message76"
                                                            infoClass="infoMessage"
                                                            style="height: 20px; left: 144px; top: 216px; position: absolute; width: 189px" warnClass="warnMessage"/>
                                                        <ice:inputText binding="#{Employee$EmployeePage.txtFileName}" id="txtFileName" required="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 130px; top: 80px; position: absolute; width: 190px"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnAddFileTbl_action}"
                                                            binding="#{Employee$EmployeePage.btnAddFileTbl}" disabled="true" id="btnAddFileTbl"
                                                            style="height: 25px; margin-top: 220px; left: 696px; top: -4px; position: absolute; visibility: visible; width: 80px"
                                                            value="Add" visible="true"/>
                                                        <ice:panelLayout id="pnlDownload" style="height: 38px; left: 200px; top: 250px; position: absolute; width: 50%">
                                                            <ice:outputResource attachment="false" fileName="#{Employee$EmployeePage.fileName}"
                                                                id="downloadButton" label="DownLoad" mimeType="#{Employee$EmployeePage.mimeType}"
                                                                rendered="#{Employee$EmployeePage.downloadAvailable}"
                                                                resource="#{Employee$EmployeePage.faResource}"
                                                                style="left: 40px; top: 10px; position: relative; width: 75px" type="button"/>
                                                        </ice:panelLayout>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="lyTableFile"
                                                        style="border: 1px solid rgb(204, 204, 204); height: 200px; left: 10px; top: 330px; overflow: auto; position: absolute; width: 775px" styleClass="insideContainerMain">
                                                        <ice:dataTable binding="#{Employee$EmployeePage.dataTablFile}" id="dataTablFile"
                                                            style="border-top: solid rgb(153, 153, 153) 1px; width: 100%"
                                                            value="#{Employee$EmployeePage.employeeFileList}" var="currentRow">
                                                            <ice:column id="column20">
                                                                <ice:outputText id="outputText51" value="#{currentRow['fileType']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText52" value="File Type"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column21">
                                                                <h:commandLink action="#{Employee$EmployeePage.lnkFile_action}" id="lnkFile" value="#{currentRow['fileName']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText54" value="File Name"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column23">
                                                                <ice:outputText id="outputText58" value="#{currentRow['remark']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText59" value="Remark"/>
                                                                </f:facet>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                    <!--

                                                        <ice:dataTable id="dataTable4" value="#{Employee$EmployeePage.employeeFileList}" var="currentRow" width="98%">
                                                            <ice:column id="column20">
                                                                <ice:outputText id="outputText51" value="#{currentRow['fileType']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText52" value="File Type"/>
                                                                </f:facet>
                                                                <ice:rowSelector id="rowSelectorFile" multiple="false" preStyleOnSelection="true"
                                                                    toggleOnClick="true" value="#{currentRow['selected']}"/>
                                                            </ice:column>
                                                            <ice:column id="column21">
                                                                <h:commandLink id="lnkFile" value="#{currentRow['fileName']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText54" value="File Name"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column23">
                                                                <ice:outputText id="outputText58" value="#{currentRow['remark']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText59" value="Remark"/>
                                                                </f:facet>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                    -->
                                                    <ice:panelLayout id="buttonFile"
                                                        style="border: 1px solid rgb(204, 204, 204); height: 50px; left: 10px; top: 550px; position: absolute; width: 780px" styleClass="insideContainerMain">
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnFileNew_action}"
                                                            binding="#{Employee$EmployeePage.btnFileNew}" id="btnFileNew" partialSubmit="true"
                                                            style="margin-left: 40px; width: 80px" value=" #{msgs.cmdNew}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnFileSave_action}"
                                                            binding="#{Employee$EmployeePage.btnFileSave}" id="btnFileSave" partialSubmit="true"
                                                            style="margin-left: 40px; width: 80px" value=" #{msgs.cmdSave}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnFileEdit_action}"
                                                            binding="#{Employee$EmployeePage.btnFileEdit}" id="btnFileEdit" partialSubmit="true"
                                                            style="margin-left: 40px; width: 80px" value=" #{msgs.cmdEdit}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnFileUpdate_action}"
                                                            binding="#{Employee$EmployeePage.btnFileUpdate}" id="btnFileUpdate" immediate="true"
                                                            style="margin-left: 40px; width: 80px" value=" #{msgs.cmdUpdate}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnFileReset_action}"
                                                            binding="#{Employee$EmployeePage.btnFileReset}" id="btnFileReset" immediate="true"
                                                            style="margin-left: 40px; width: 80px" value=" #{msgs.cmdReset}"/>
                                                        <ice:commandButton action="#{Employee$EmployeePage.btnFileDelete_action}"
                                                            binding="#{Employee$EmployeePage.btnFileDelete}" id="btnFileDelete" partialSubmit="true"
                                                            style="margin-left: 40px; width: 80px" value=" #{msgs.cmdDelete}"/>
                                                    </ice:panelLayout>
                                                </ice:panelLayout>
                                            </ice:panelTab>
                                        </ice:panelTabSet>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="south">
                                <ice:panelGroup id="page_footer" style=" text-align: left;">
                                    <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">
                                        <ice:outputLabel id="outputLabel1"
                                            style="color: rgb(255, 255, 255); font-family: serif; font-size: 14px; font-style: italic; font-weight: bolder; height: 18px; left: 48px; top: 0px; position: absolute; width: 622px" value="BUNNA INTERNATIONAL BANK Human Resource Management System - Employee Profile."/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <!--//////////////////////////////////////////////////////////////////////////////Staret POp Up////////////////////////////////////////////////////-->
                        <ice:panelPopup autoCentre="true" binding="#{Employee$EmployeePage.popUpConfirmation}" draggable="true" id="popUpConfirmation"
                            modal="true" rendered="false" style="display: block; height: 156px; left: 97px; top: 215px; position: absolute; width: 623px;visibility: hidden;visibility: hidden;">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGrid5" style="display: block; height: 20px; width: 500px">
                                    <ice:outputText id="lblPopUpMsgTitle" value="BUNNA INTERNATIONAL BANK Human Resource Management System"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGrid id="panelGrid6" style="display: block; height: 94px; position: relative; width: 586">
                                    <ice:panelLayout id="lyPoup">
                                        <ice:commandButton actionListener="#{Employee$EmployeePage.btnPopUpOk_processAction}"
                                            binding="#{Employee$EmployeePage.btnPopUpOk}" id="btnPopUpOk" immediate="true"
                                            style="left: 470px; top: 60px; position: absolute; width: 70px" value="OK" visible="true"/>
                                        <ice:commandButton id="btnPopUpNo" rendered="false" style="left: 430px; top: 71px; visibility: visible; width: 70px"
                                            value="No" visible="true"/>
                                        <ice:commandButton binding="#{Employee$EmployeePage.btnPopUpYes}" id="btnPopUpYes" rendered="false"
                                            style="height: 10px; left: 335px; top: 70px; visibility: visible; width: 70px" value="Yes" visible="true"/>
                                        <ice:outputText binding="#{Employee$EmployeePage.lblPopUpMsgContaint}" id="lblPopUpMsgContaint"
                                            style="left: 95px; top: 15px; position: absolute; width: 496px" value="code"/>
                                        <ice:commandButton actionListener="#{Employee$EmployeePage.btnYes_processAction}"
                                            binding="#{Employee$EmployeePage.btnYes}" id="btnYes" immediate="true"
                                            style="left: 380px; top: 60px; position: absolute; width: 70px" value="Yes"/>
                                        <ice:commandButton actionListener="#{Employee$EmployeePage.btnNo_processAction}"
                                            binding="#{Employee$EmployeePage.btnNo}" id="btnNo" immediate="true"
                                            style="left: 450px; top: 40px; position: absolute; width: 70px" value="No"/>
                                        <ice:commandButton action="#{Employee$EmployeePage.btnAYes_action}" binding="#{Employee$EmployeePage.btnAYes}"
                                            id="btnAYes" rendered="false" style="left: 150px; top: 60px; position: absolute; width: 70px" value="Yes"/>
                                        <ice:commandButton action="#{Employee$EmployeePage.btnDeleteYesEducation_action}"
                                            binding="#{Employee$EmployeePage.btnDeleteYesEducation}" id="btnDeleteYesEducation" rendered="false"
                                            style="left: 370px; top: 60px; position: absolute; width: 70px" value="Yes"/>
                                    </ice:panelLayout>
                                </ice:panelGrid>
                            </f:facet>
                        </ice:panelPopup>
                        <!--//////////////////////////////////////////////////////////////////////////////////Input Recive////////////////////////////////////////////////-->
                        <ice:panelPopup autoCentre="true" binding="#{Employee$EmployeePage.popUpInputAddressType}" draggable="true" id="popUpInputAddressType"
                            rendered="false" style="display: block; height: 156px; left: 97px; top: 226px; position: absolute; width: 420px;visibility: hidden;visibility: hidden;">
                            <f:facet name="header">
                                <ice:panelGrid id="lypopUphead" style="height: 10px; width: 400px">
                                    <ice:outputText id="lblAddressType"
                                        style="margin-left: 0px; margin-top: 0px; position: absolute; text-align: left; width: 100px" value="Address Type"/>
                                    <ice:commandButton actionListener="#{Employee$EmployeePage.btnCloseAddressType_processAction}"
                                        binding="#{Employee$EmployeePage.btnCloseAddressType}" id="btnCloseAddressType" image="/Employee/images/red-error.gif"
                                        style="margin-left: 395px;width:20px;height:20px;" value="submit"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGrid id="panelGrid8" style="display:block;width:400px;height:108px;background-color:#ffffff;">
                                    <ice:panelLayout id="lyAddFamilyType">
                                        <ice:outputText id="lblPopupAddrsType"
                                            style="height: 10px; margin-left: 15px; margin-top: 10px; position: absolute; width: 100px" value="Address Type:"/>
                                        <ice:inputText id="inputText1" style=" margin-left: 150px; margin-top: 10px; position: absolute; "/>
                                        <ice:commandButton actionListener="#{Employee$EmployeePage.btnSaveAddressType_processAction}"
                                            binding="#{Employee$EmployeePage.btnSaveAddressType}" id="btnSaveAddressType"
                                            style="margin-top: 60px;margin-left: 180px;" value="submit"/>
                                    </ice:panelLayout>
                                </ice:panelGrid>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Employee$EmployeePage.familyPopUpMsg}" draggable="true" id="familyPopUpMsg" modal="true"
                            rendered="false" style="display: block; height: 156px; left: 97px; top: 200px; position: absolute; width: 623px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridevaSessionPopUpMsg" style="display: block; height: 20px; width: 623px">
                                    <ice:outputText id="lblevaSessionPopUpMsgTitle" value="BUNNA INTERNATIONAL BANK Human Resource Management System"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupEvaSessionPopUpMsgBody" style="display: block; height: 94px; position: relative; width: 586">
                                    <ice:commandButton action="#{Employee$EmployeePage.btnNoFamilyPopUp_action}"
                                        binding="#{Employee$EmployeePage.btnNoFamilyPopUp}" id="btnNoFamilyPopUp" rendered="true"
                                        style="left: 510px; top: 60px; position: absolute; visibility: visible; width: 70px" value="No" visible="true"/>
                                    <ice:commandButton action="#{Employee$EmployeePagef.btnYesFamilyPopUp_action}"
                                        binding="#{Employee$EmployeePage.btnYesFamilyPopUp}" id="btnYesFamilyPopUp" rendered="true"
                                        style="background-position: 0 100%; background-repeat: no-repeat; left: 430px; top: 60px; position: absolute; visibility: visible; width: 70px"
                                        value="Yes" visible="true"/>
                                    <ice:outputText binding="#{Employee$EmployeePage.lblMessagePopUpMsgMain}" id="lblMessagePopUpMsgMain" style="left:95px; top: 30px; position: absolute; width: 496px"/>
                                    <ice:panelLayout id="panelLayoutSessionImageHolder" rendered="true"
                                        style=" width:62; height:56px; left: 10px; top: 15px; position: absolute;" styleClass="popUpBgimage" visible="true"/>
                                    <ice:commandButton action="#{Employee$EmployeePage.btnYesAddressPopUp_action}"
                                        binding="#{Employee$EmployeePage.btnYesAddressPopUp}" id="btnYesAddressPopUp" rendered="false"
                                        style="background-position: 0 100%; background-repeat: no-repeat; left: 400px; top: 60px; position: absolute; visibility: visible; width: 70px" value="Yes"/>
                                    <ice:commandButton action="#{Employee$EmployeePage.btnNoAddressPopUp_action}"
                                        binding="#{Employee$EmployeePage.btnNoAddressPopUp}" id="btnNoAddressPopUp" rendered="false"
                                        style="left: 480px; top: 60px; position: absolute; visibility: visible; width: 70px" value="No"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body"/>
                        </ice:panelPopup>
                        <!--//////////////////////////////////////////////////////////////////////////////End POp Up////////////////////////////////////////////////////-->
                        <ice:panelPopup autoCentre="true" binding="#{Employee$EmployeePage.employeePlanPopUpMsg}" draggable="true" id="employeePlanPopUpMsg"
                            modal="true" rendered="false" style="display: block; height: 156px; left: 97px; top: 226px; position: absolute; width: 623px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridemployeePopUpMsg" style="display: block; height: 20px; width: 500px">
                                    <ice:outputText id="lblemployeePopUpMsgTitle" value="BUNNA INTERNATIONAL BANK Human Resource Management "/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupemployeePopUpMsgBody" style="display: block; height: 94px; position: relative; width:586px">
                                    <ice:commandButton action="#{Employee$EmployeePage.btntemployeePopUpNo_action}"
                                        binding="#{Employee$EmployeePage.btntemployeePopUpNo}" id="btntemployeePopUpNo" immediate="true" partialSubmit="true"
                                        rendered="true" style="left: 510px; top: 60px; position: absolute; visibility: visible; width: 70px" value="No" visible="true"/>
                                    <ice:commandButton action="#{Employee$EmployeePage.btntemployeePopUpYes_action}"
                                        binding="#{Employee$EmployeePage.btntemployeePopUpYes}" id="btntemployeePopUpYes" immediate="true" partialSubmit="true"
                                        rendered="true"
                                        style="background-position: 0 100%; background-repeat: no-repeat; left: 430px; top: 60px; position: absolute; visibility: visible; width: 70px"
                                        value="Yes" visible="true"/>
                                    <ice:outputText binding="#{Employee$EmployeePage.lblemployeePopUpMsgMain}" id="lblemployeePopUpMsgMain" style="font-size: 18px; left: 95px; top: 30px; position: absolute; width: 496px"/>
                                    <ice:panelLayout binding="#{Employee$EmployeePage.panelLayoutImageHolderemployee}" id="panelLayoutImageHolderemployee"
                                        rendered="true" style=" width:62; height:56px; left: 10px; top: 15px; position: absolute;" styleClass="popUpBgimage" visible="true"/>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Employee$EmployeePage.empTitlePopUpMsg}" id="empTitlePopUpMsg" modal="true"
                            rendered="false" style="display: block; height: 300px; left: 97px; top: 226px; position: absolute; width: 343px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridempTitlePopUpMsg" style="display: block; height: 20px; width: 300px">
                                    <ice:outputText id="lblempTitleMsgTitle" value="You Can Add or Remove Title Here"/>
                                    <ice:commandButton action="#{Employee$EmployeePage.buttonempTitleClose_action}" id="buttonempTitleClose" immediate="true"
                                        partialSubmit="true"
                                        style="left:302px; font-size: 11px; border-color: red; color:red; margin-top: -23px; position: absolute; visibility: visible; height:25px; width:25px" value="x"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Employee$EmployeePage.panelGroupempTitleMsgBody}" id="panelGroupempTitleMsgBody" style="display: block; height: 240px; position: relative; width: 300">
                                    <ice:panelGroup binding="#{Employee$EmployeePage.panelGroupempTitleMsgBody11}" id="panelGroupempTitleMsgBody11"
                                        rendered="true" style="top:0px; display: block; height: 90px; position: relative; width: 300" styleClass="insideContainerPop">
                                        <ice:outputText id="popupempTitle" style="font-size: 10px;margin-left: 5px; margin-top: 20px; position: absolute" value="Title:"/>
                                        <ice:inputText binding="#{Employee$EmployeePage.inputTextPopUpempTitle}" id="inputTextPopUpempTitle"
                                            partialSubmit="true" style="margin-left: 60px; margin-top: 10px; position: absolute;   width: 150px"/>
                                        <ice:outputText id="popupempTitleType" style="font-size: 10px;margin-left: 5px; margin-top: 50px; position: absolute" value="Category:"/>
                                        <ice:commandButton action="#{Employee$EmployeePage.btnempTitleAdd_action}"
                                            binding="#{Employee$EmployeePage.btnempTitleAdd}" id="btnempTitleAdd" partialSubmit="true" rendered="true"
                                            style="left:246px; margin-top: 60px; position: absolute; visibility: visible; height:25px; width: 50px" value="Add" visible="true"/>
                                        <ice:selectOneMenu binding="#{Employee$EmployeePage.inputTextPopUpempTitleType}" id="inputTextPopUpempTitleType"
                                            immediate="true" partialSubmit="true"
                                            style="margin-left: 60px; margin-top: 50px; position: absolute;   width: 150px" value="#{Employee$EmployeePage.defaultSelectedData53.selectedObject}">
                                            <f:selectItems id="selectOneMenu1selectItems9" value="#{Employee$EmployeePage.titleTypeA}"/>
                                        </ice:selectOneMenu>
                                    </ice:panelGroup>
                                    <ice:panelGroup binding="#{Employee$EmployeePage.panelGroupempTitleMsgBodyDelete}" id="panelGroupempTitleMsgBodyDelete"
                                        rendered="false" style="top:30px; display: block; height: 50px; position: relative; width: 300" styleClass="insideContainerPop">
                                        <ice:outputText id="popupempTitleDelete" style="font-size: 10px;margin-left: 2px; margin-top: 10px; position: absolute" value="Are you shure you want to delete the record?"/>
                                        <ice:commandButton action="#{Employee$EmployeePage.buttonempTitleY_action}"
                                            binding="#{Employee$EmployeePage.buttonempTitleY}" id="buttonempTitleY" partialSubmit="true"
                                            style="left:240px; margin-top: 20px; position: absolute; visibility: visible; height:25px; width: 25px" value="Y"/>
                                        <ice:commandButton action="#{Employee$EmployeePage.buttonempTitleN_action}" id="buttonempTitleN" partialSubmit="true"
                                            style="left:270px; margin-top: 20px; position: absolute; visibility: visible; height:25px; width: 25px" value="N"/>
                                    </ice:panelGroup>
                                    <ice:panelGroup binding="#{Employee$EmployeePage.panelGroupempTitleMsgBody1}" id="panelGroupempTitleMsgBody1"
                                        rendered="true" style="top:8px; display: block; height: 100px; overflow: auto; position: relative; width: 300" styleClass="insideContainerPop">
                                        <ice:dataTable id="dataTableAddempTitle" style="left: -2px; top:  -10px; width: 283px; position: absolute"
                                            value="#{Employee$EmployeePage.empTitleOPt}" var="currentRow">
                                            <ice:column id="column1empTitle" rendered="fasle">
                                                <ice:outputText id="outputText1empTitle" value="#{currentRow['titleID']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText2empTitle" value="Title Id"/>
                                                </f:facet>
                                                <ice:rowSelector binding="#{Employee$EmployeePage.rowSelectorempTitleAdd}" id="rowSelectorempTitleAdd"
                                                    multiple="false" preStyleOnSelection="true"
                                                    selectionListener="#{Employee$EmployeePage.rowSelectorempTitleAdd_processMyEvent}" toggleOnClick="true" value="#{currentRow['selected']}"/>
                                            </ice:column>
                                            <ice:column id="column2empTitle">
                                                <ice:outputText id="inputTextempTitleAdd" value="#{currentRow['titleDes']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText4empTitle" value="Description"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column2empTitleType">
                                                <ice:outputText id="inputTextempTitleTypecAdd" value="#{currentRow['titleType']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText4empTitleType" value="Category"/>
                                                </f:facet>
                                            </ice:column>
                                        </ice:dataTable>
                                    </ice:panelGroup>
                                    <ice:panelGroup binding="#{Employee$EmployeePage.panelGroupempTitleMsgBodyButtons}" id="panelGroupempTitleMsgBodyButtons"
                                        rendered="true" style="top:15px; display: block; height: 30px; position: relative; width: 300" styleClass="insideContainerPop">
                                        <ice:commandButton action="#{Employee$EmployeePage.btnempTitleNew_action}"
                                            binding="#{Employee$EmployeePage.btnempTitleNew}" id="btnempTitleNew" immediate="true" partialSubmit="true"
                                            rendered="true" style="left: 20px; top: -7px; position: absolute; visibility: visible; height:25px; width: 50px"
                                            value="New" visible="true"/>
                                        <ice:commandButton action="#{Employee$EmployeePage.btnempTitleSave_action}"
                                            binding="#{Employee$EmployeePage.btnempTitleSave}" id="btnempTitleSave" partialSubmit="true" rendered="true"
                                            style="left: 85px; top: -7px; position: absolute; visibility: visible; height:25px; width: 50px" value="Save" visible="true"/>
                                        <ice:commandButton action="#{Employee$EmployeePage.btnempTitleDelete_action}"
                                            binding="#{Employee$EmployeePage.btnempTitleDelete}" id="btnempTitleDelete" partialSubmit="true" rendered="true"
                                            style="background-position: 0 100%; background-repeat: no-repeat; left:145px; top: -7px; position: absolute; visibility: visible; height:25px; width: 60px"
                                            value="Delete" visible="true"/>
                                        <ice:commandButton action="#{Employee$EmployeePage.btnempTitleCancel_action}"
                                            binding="#{Employee$EmployeePage.btnempTitleCancel}" id="btnempTitleCancel" partialSubmit="true" rendered="true"
                                            style="background-position: 0 100%; background-repeat: no-repeat; left:220px; top: -7px; position: absolute; visibility: visible; height:25px; width: 60px"
                                            value="Cancel" visible="true"/>
                                    </ice:panelGroup>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <!--///////////////////////////////////////////////////////////////////////////////////////-->
                        <ice:panelPopup autoCentre="true" binding="#{Employee$EmployeePage.popupAddEducationType}" draggable="true" id="popupAddEducationType"
                            modal="true" rendered="false" style="display: block; height: 300px; left: 96px; top: 288px; position: absolute; width: 343px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGrid2" style="display: block; height: 20px; width: 300px">
                                    <ice:outputText id="outputText17" value="You Can Add or Remove Education Type Here"/>
                                    <ice:commandButton action="#{Employee$EmployeePage.buttonempEducationClose_action}" id="buttonempEducationClose"
                                        immediate="true" partialSubmit="true"
                                        style="left:302px; font-size: 11px; border-color: red; color:red; margin-top: -23px; position: absolute; visibility: visible; height:25px; width:25px" value="x"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupempEducationMsg" style="display: block; height: 240px; position: relative; width: 300">
                                    <ice:panelGroup binding="#{Employee$EmployeePage.panelGroupempEducationMsgBody11}" id="panelGroupempEducationMsgBody11"
                                        rendered="true" style="top:0px; display: block; height: 90px; position: relative; width: 300" styleClass="insideContainerPop">
                                        <ice:outputText id="popupempEducation" style="font-size: 10px;margin-left: 5px; margin-top: 20px; position: absolute" value="#{msgs.TypeOfEducation}"/>
                                        <ice:outputText binding="#{Employee$EmployeePage.popupempEducationCategory}" id="popupempEducationCategory"
                                            style="font-size: 10px;margin-left: 5px; margin-top: 50px; position: absolute" value="No Catagory Selected.\nYou can close this window and select category first"/>
                                        <ice:inputText binding="#{Employee$EmployeePage.inputTextPopUpempEducation}" id="inputTextPopUpempEducation"
                                            partialSubmit="true" style="margin-left: 120px; margin-top: 17px; position: absolute; width: 150px"/>
                                        <ice:commandButton action="#{Employee$EmployeePage.btnempEducationAdd_action}"
                                            binding="#{Employee$EmployeePage.btnempEducationAdd}" id="btnempEducationAdd" partialSubmit="true" rendered="true"
                                            style="left:246px; margin-top: 60px; position: absolute; visibility: visible; height:25px; width: 50px" value="Add" visible="true"/>
                                    </ice:panelGroup>
                                    <ice:panelGroup binding="#{Employee$EmployeePage.panelGroupempEducationMsgBodyDelete}"
                                        id="panelGroupempEducationMsgBodyDelete" rendered="false"
                                        style="top:30px; display: block; height: 50px; position: relative; width: 300" styleClass="insideContainerPop">
                                        <ice:outputText id="popupempEducationDelete"
                                            style="font-size: 10px;margin-left: 2px; margin-top: 10px; position: absolute" value="Are you shure you want to delete the record?"/>
                                        <ice:commandButton action="#{Employee$EmployeePage.buttonempEducationY_action}"
                                            binding="#{Employee$EmployeePage.buttonempEducationY}" id="buttonempEducationY" partialSubmit="true"
                                            style="left:240px; margin-top: 20px; position: absolute; visibility: visible; height:25px; width: 25px" value="Y"/>
                                        <ice:commandButton binding="#{Employee$EmployeePage.buttonempEducationN}" id="buttonempEducationN" partialSubmit="true"
                                            style="left:270px; margin-top: 20px; position: absolute; visibility: visible; height:25px; width: 25px" value="N"/>
                                    </ice:panelGroup>
                                    <ice:panelGroup binding="#{Employee$EmployeePage.panelGroupempEducationMsgBody}" id="panelGroupempEducationMsgBody"
                                        rendered="true" style="top:8px; display: block; height: 100px; overflow: auto; position: relative; width: 300" styleClass="insideContainerPop">
                                        <ice:dataTable binding="#{Employee$EmployeePage.tblEducationType1}" id="tblEducationType1"
                                            style=" width: 300px;margin-left: 5px;" value="#{Employee$EmployeePage.listOfEducationType}" var="currentRow">
                                            <ice:column binding="#{Employee$EmployeePage.column11}" id="column11" style=" width: 300px">
                                                <ice:outputText id="outputText18" style=" width: 200px" value="#{currentRow['description']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText19" style=" width: 200px" value="#{msgs.TypeOfEducation}"/>
                                                </f:facet>
                                                <ice:rowSelector binding="#{Employee$EmployeePage.rowSelectorempEducationAdd}" id="rowSelectorempEducationAdd"
                                                    multiple="false" preStyleOnSelection="true"
                                                    selectionListener="#{Employee$EmployeePage.rowSelectorempEducationAdd_processMyEvent}" toggleOnClick="true" value="#{currentRow['selected']}"/>
                                            </ice:column>
                                        </ice:dataTable>
                                    </ice:panelGroup>
                                    <ice:panelGroup binding="#{Employee$EmployeePage.panelGroupempEducationMsgBodyButtons}"
                                        id="panelGroupempEducationMsgBodyButtons" rendered="true"
                                        style="top:15px; display: block; height: 30px; position: relative; width: 300" styleClass="insideContainerPop">
                                        <ice:commandButton action="#{Employee$EmployeePage.btnempEducationNew_action}"
                                            binding="#{Employee$EmployeePage.btnempEducationNew}" id="btnempEducationNew" immediate="true" partialSubmit="true"
                                            rendered="true" style="left: 20px; top: -7px; position: absolute; visibility: visible; height:25px; width: 50px"
                                            value="New" visible="true"/>
                                        <ice:commandButton action="#{Employee$EmployeePage.btnempEducationSave_action}"
                                            binding="#{Employee$EmployeePage.btnempEducationSave}" disabled="true" id="btnempEducationSave" immediate="true"
                                            partialSubmit="true" rendered="true"
                                            style="left: 85px; top: -7px; position: absolute; visibility: visible; height:25px; width: 50px" value="Save" visible="true"/>
                                        <ice:commandButton action="#{Employee$EmployeePage.btnempEducationDelete_action}"
                                            binding="#{Employee$EmployeePage.btnempEducationDelete}" id="btnempEducationDelete" immediate="true"
                                            partialSubmit="true" rendered="true"
                                            style="background-position: 0 100%; background-repeat: no-repeat; left:145px; top: -7px; position: absolute; visibility: visible; height:25px; width: 60px"
                                            value="Delete" visible="true"/>
                                        <ice:commandButton action="#{Employee$EmployeePage.btnempEducationCancel_action}"
                                            binding="#{Employee$EmployeePage.btnempEducationCancel}" id="btnempEducationCancel" partialSubmit="true"
                                            rendered="true"
                                            style="background-position: 0 100%; background-repeat: no-repeat; left:220px; top: -7px; position: absolute; visibility: visible; height:25px; width: 60px"
                                            value="Cancel" visible="true"/>
                                    </ice:panelGroup>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelLayout binding="#{Employee$EmployeePage.panelLayout3}" id="panelLayout3" layout="flow" rendered="false"
                            style="border-width: 2px; border-style: solid; height: 360px; left: 600px; top: 350px; overflow: scroll; position: absolute; width: 400px; -rave-layout: grid" styleClass="insideContainerMain">
                            <ice:tree binding="#{Employee$EmployeePage.tree1}" id="tree1"
                                style="height: 286px; margin-left: 0px; margin-top: 0px; text-align: left; width: 190px"
                                value="#{Employee$EmployeePage.tree1Model.model}" var="item">
                                <ice:treeNode id="treeNode1">
                                    <f:facet name="icon">
                                        <ice:panelGroup id="panelGroup1" style="display: inline;">
                                            <ice:graphicImage id="graphicImage1" value="#{item.userObject.icon}"/>
                                        </ice:panelGroup>
                                    </f:facet>
                                    <f:facet name="content">
                                        <ice:panelGroup id="panelGroup2" style="display: inline;">
                                            <ice:commandLink actionListener="#{Employee$EmployeePage.commandLink1_processAction}" id="commandLink1" partialSubmit="true">
                                                <ice:outputText id="outputText2" value="#{item.userObject.text}"/>
                                            </ice:commandLink>
                                        </ice:panelGroup>
                                    </f:facet>
                                </ice:treeNode>
                            </ice:tree>
                        </ice:panelLayout>
                        <ice:panelPopup autoCentre="true" binding="#{Employee$EmployeePage.pnlPopupSuccessOrFailure}" clientOnly="true" draggable="false"
                            id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 3px; top: 80px; position: absolute; width: 667px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Employee$EmployeePage.btnClosePopupSuccessOrFailure_action}" id="btnClosePopupSuccessOrFailure"
                                        immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 700px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Employee$EmployeePage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Employee$EmployeePage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Employee$EmployeePage.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Employee$EmployeePage.pnlInsertNewLanguageType}" clientOnly="true" draggable="false"
                            id="pnlInsertNewLanguageType" modal="true" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 3px; top: 80px; position: absolute; width: 667px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessageNewLanguageType" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitleNewLanguageType"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System : Add New Language"/>
                                    <ice:commandLink action="#{Employee$EmployeePage.btnClosePopupInsertNewLanguageType_action}"
                                        id="btnClosePopupInsertNewLanguageType" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 700px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupMessageNewLanguageType" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlMessageBodyNewLanguageType" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <ice:outputText id="lblNewLanguageName" value="Language Name : "/>
                                        <ice:inputText binding="#{Employee$EmployeePage.txtNameNewLanguageType}" id="txtNameNewLanguageType"/>
                                        <ice:commandButton action="#{Employee$EmployeePage.btnSaveNewLanguageType_action}"
                                            binding="#{Employee$EmployeePage.btnSaveNewLanguageType}" id="btnSaveNewLanguageType" partialSubmit="true" value=" Save "/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Employee$EmployeePage.pnlPopUpDateSettingForContractEmployee}"
                            id="pnlPopUpDateSettingForContractEmployee" modal="true" rendered="false" style="display: block; height: 259px; left: 97px; top: 146px; position: absolute; width: 676px">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridPopUpDateSetting" styleClass="popupHeaderWrapper">
                                    <ice:outputText id="PopUpAttachmentDateSetting" style="width:400px" styleClass="popupHeaderText" value="BUNNA INTERNATIONAL BANK Human Resource Management System-Contract Employee Agreement Date"/>
                                    <ice:commandButton action="#{Employee$EmployeePage.modalPnlCloseBtnDateSettingControll_action}" alt="Close"
                                        id="modalPnlCloseBtnDateSettingControll" image="/resources/images/close.gif" immediate="true" partialSubmit="true"
                                        style="left: 655px; top: 2px; position: absolute" styleClass="popupHeaderImage" title="Close Popup" type="button"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup dragListener="#{Employee$EmployeePage.lblDDID_processMyEvent}" id="lblDDID"
                                    style="display: block; height: 193px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="lyContractEmployeeAgreement" style="display: block; height: 130px; left: 0px; top: 0px; position: absolute; width: 400px">
                                        <ice:outputLabel id="outputLabel6" style="left: 40px; top: 42px; position: absolute" value="Cotract Start Date :"/>
                                        <ice:inputText binding="#{Employee$EmployeePage.txtCotractStartDate}" disabled="true" id="txtCotractStartDate"
                                            partialSubmit="true" required="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 210px; top: 45px; position: absolute; width: 170px"/>
                                        <ice:inputText binding="#{Employee$EmployeePage.txtfContractEndDate}" disabled="true" id="txtfContractEndDate"
                                            partialSubmit="true" required="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 210px; top: 87px; position: absolute; width: 170px"/>
                                        <ice:outputLabel id="outputLabel7" style="left: 40px; top: 84px; position: absolute" value="Contract End Date :"/>
                                        <ice:commandButton action="#{Employee$EmployeePage.bntCotractEndDate_action}"
                                            binding="#{Employee$EmployeePage.bntCotractEndDate}" id="bntCotractEndDate" image="/Employee/images/calendar.gif"
                                            style="left: 365px; top: 89px; position: absolute" value="1"/>
                                        <ice:commandButton action="#{Employee$EmployeePage.bntCotractStartDate_action}"
                                            binding="#{Employee$EmployeePage.bntCotractStartDate}" id="bntCotractStartDate"
                                            image="/Employee/images/calendar.gif" style="left: 365px; top: 47px; position: absolute" value="submit"/>
                                    </ice:panelLayout>
                                    <ice:panelLayout id="lyContractEmployeeAgreementDate" style="display: block; height: 130px; left: 450px; top: 5px; position: absolute; width: 200px">
                                        <ice:outputText id="outputText13" style="left: 10px; top: 2px; position: absolute; text-align: left; width: 100px" value="Remaining   Days"/>
                                        <ice:outputText binding="#{Employee$EmployeePage.lblRemainingDayes}" id="lblRemainingDayes" style="font-size: 46px; height: 100px; left: 0px; top: 40px; position: absolute; width: 100px"/>
                                    </ice:panelLayout>
                                    <ice:commandButton action="#{Employee$EmployeePage.btnSaveContract_action}"
                                        binding="#{Employee$EmployeePage.btnSaveContract}" id="btnSaveContract"
                                        style="left: 20px; top: 141px; position: absolute; width: 90px" value="Save"/>
                                    <ice:commandButton action="#{Employee$EmployeePage.btnEditContract_action}"
                                        binding="#{Employee$EmployeePage.btnEditContract}" id="btnEditContract"
                                        style="left: 150px; top: 141px; position: absolute; width: 90px" value="Edit"/>
                                    <ice:commandButton action="#{Employee$EmployeePage.btnUpdateContract_action}"
                                        binding="#{Employee$EmployeePage.btnUpdateContract}" id="btnUpdateContract"
                                        style="left: 302px; top: 141px; position: absolute; width: 90px" value="Update"/>
                                    <ice:commandButton action="#{Employee$EmployeePage.btnCancel_action}" binding="#{Employee$EmployeePage.btnCancel}"
                                        disabled="true" id="btnCancel" style="left: 452px; top: 141px; position: absolute; width: 90px" value="Cancel"/>
                                    <label style="left: 4px; top: 143px; border-bottom:0.5px groove #176674; width:640px; position: absolute;"></label>
                                    <label style="left: 4px; top: 185px; border-bottom:0.5px groove #176674; width:640px; position: absolute;"></label>
                                    <ice:commandLink action="#{Employee$EmployeePage.commandLink3_action}" id="commandLink3"
                                        style="left: 480px; top: 185px; position: absolute; text-align: left; width: 178px" value="Terminate Contract  "/>
                                </ice:panelGroup>
                            </f:facet>
                            <ice:selectInputDate binding="#{Employee$EmployeePage.calContractStartDate}" id="calContractStartDate" popupDateFormat="yyyy-MM-dd"
                                renderYearAsDropdown="true" rendered="false" style="left: 365px; top: 47px; position: absolute;"
                                value="#{Employee$EmployeePage.selectInputDateOfContractStartDateBean.date1}" valueChangeListener="#{Employee$EmployeePage.calContractStartDate_processValueChange}"/>
                            <ice:selectInputDate binding="#{Employee$EmployeePage.calContractEndDate}" id="calContractEndDate" popupDateFormat="yyyy-MM-dd"
                                renderYearAsDropdown="true" rendered="false" style="left: 365px; top: 47px; position: absolute;"
                                value="#{Employee$EmployeePage.selectInputDateOfContractEndDateBean.date1}" valueChangeListener="#{Employee$EmployeePage.calContractEndDate_processValueChange}"/>
                        </ice:panelPopup>
                        <ice:panelPopup binding="#{Employee$EmployeePage.popContractTermination}" draggable="true" id="popContractTermination" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 300px; left: 250px; top: 140px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGrid10" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="lblContrateTerminationDate"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System"/>
                                    <ice:commandButton id="btnContrateTerminationDate" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 735px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupReport" style="display: block; height: 300px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlContrateTerminationDateBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 270px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <ice:outputText id="lbltContrateTerminationDate" style="left: 10px; top: 50px; position: absolute" value=" Contrat Termination Date"/>
                                        <ice:inputText binding="#{Employee$EmployeePage.txtContractTerminationDate}" id="txtContractTerminationDate" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 200px; top: 50px; position: absolute; width: 200px"/>
                                        <ice:commandButton action="#{Employee$EmployeePage.btnContrateTerminationCalend_action}"
                                            id="btnContrateTerminationCalend" image="/Employee/images/calendar.gif" style="left: 384px; top: 53px; position: absolute"/>
                                        <ice:outputText id="outputText91" style="left: 10px; top: 100px; position: absolute" value="Remark"/>
                                        <ice:inputTextarea binding="#{Employee$EmployeePage.txtTerminationRemark}" id="txtTerminationRemark" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; height: 70px; left: 200px; top: 100px; position: absolute; width: 400px"/>
                                        <ice:commandButton action="#{Employee$EmployeePage.btnSaveContratTermination_action}" id="btnSaveContratTermination"
                                            style="left: 192px; top: 200px; position: absolute; width: 120px" value="Save"/>
                                        <ice:commandButton id="btnUpdateContratTermination" rendered="false"
                                            style="left: 350px; top: 200px; position: absolute; width: 120px" value="Update"/>
                                        <ice:selectInputDate binding="#{Employee$EmployeePage.calContratTerminationDate}" id="calContratTerminationDate"
                                            rendered="false" style="height: 212px; left: 200px; top: 72px; position: absolute; width: 190px"
                                            value="#{Employee$EmployeePage.selectInputDateBean2.date1}" valueChangeListener="#{Employee$EmployeePage.calContratTerminationDate_processValueChange}"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Employee$EmployeePage.pnMessageForEmployeeStatus}" clientOnly="true" draggable="false"
                            id="pnMessageForEmployeeStatus" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent;                             display: block; height: 134px; left: 63px; top: 400px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessageEmployeeStatus" style="background-color:#333333; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitleEmployeeStatus"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Employee$EmployeePage.modalPnlCloseMesssageEmployeeStatus_action}"
                                        id="modalPnlCloseMesssageEmployeeStatus" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px;                                         left: 735px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupMessageEmployeeStatus"
                                    style="display: block; height: 100px;                                 position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlMessageBodyEmployeeStatus" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 70px; position: relative;                                         width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Employee$EmployeePage.lblFormMessage1EmployeeStatus}" id="lblFormMessage1EmployeeStatus" style="color: green; font-size: 14px;                                         font-weight: bold;text-align: center; vertical-align: middle"/>
                                        <ice:commandButton action="#{Employee$EmployeePage.btnSatusDisplayYse_action}" id="btnSatusDisplayYse"
                                            style="left: 450px; top: 55px; position: absolute; width: 50px" value="Yes"/>
                                        <ice:commandButton action="#{Employee$EmployeePage.btnSatusDisplayNo_action}" id="btnSatusDisplayNo"
                                            style="left: 560px; top: 55px; position: absolute; width: 50px" value="No"/>
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
