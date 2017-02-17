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
                <link HREF="../resources/images/header_icon.ico" REL="icon"/>
                <title>Court order payment Page</title>
                <link HREF="../resources/images/header_icon.ico" REL="icon"/>
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
                    function DisciplinePenaltyRegistrationPage(field){

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
                            <ice:panelGroup id="page_header" style="height: 117px">
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
                                        <ice:panelCollapsible binding="#{Page1.panelCollapsible2}" id="panelCollapsible2"
                                            style="left: 1px; top: 30px; position: absolute; height:46 px; width: 214px" toggleOnClick="true">
                                            <f:facet name="header">
                                                <ice:panelGroup id="panelGroup2" styleClass="">
                                                    <ice:outputText id="outputText2" value="header Value"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid id="panelGrid1">
                                                <ice:outputText id="outputText3" value="Text Description"/>
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
                            <ice:panelGroup dragListener="#{CourtOrder$CourtOrderPayment.page_display_processMyEvent}" id="page_display" style="height: 890px">
                                <ice:panelLayout id="container" layout="flow"
                                    style="height: 790px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                    <fieldset class="filedset_css" style="height: 890px;">
                                        <legend class="legend_css">
                                            <ice:outputLabel value="Manage Court Orderd Payment"/>
                                        </legend>
                                        <ice:panelLayout id="pnlemployeePro" layout="flow"
                                            style="height: 141px; margin-left: 15px; left: 9px; top: 30px; position: absolute; width: 727px; -rave-layout: grid" styleClass="insideContainerMain">
                                            <ice:selectInputText action="#{CourtOrder$CourtOrderPayment.txtRequesterFullName_action}"
                                                binding="#{CourtOrder$CourtOrderPayment.txtRequesterFullName}" id="txtRequesterFullName" immediate="true"
                                                listValue="#{ApplicationBean1.list}" listVar="employeeList" partialSubmit="true" rows="10"
                                                style="left: 166px; top: 22px; position: absolute" valueChangeListener="#{ApplicationBean1.updateList}" width="200px">
                                                <f:facet name="selectInputText">
                                                    <ice:panelGrid columnClasses="fullNameCol,empIdCol" columns="2">
                                                        <ice:outputText id="lblFullNameAutoComplete" value="#{employeeList.fullName}"/>
                                                        <ice:outputText id="lblEmployeeIdAutoComplete" value="#{employeeList.empIdentification}"/>
                                                    </ice:panelGrid>
                                                </f:facet>
                                            </ice:selectInputText>
                                            <ice:outputLabel id="lblRequesterDepartment" style="left: 48px; top: 62px; position: absolute" value="Department"/>
                                            <ice:outputLabel id="lblRequesterId" style="left: 432px; top: 24px; position: absolute" value="Id"/>
                                            <ice:inputText binding="#{CourtOrder$CourtOrderPayment.txtRequesterDepartment}" disabled="true"
                                                id="txtRequesterDepartment" style="left: 166px; top: 60px; position: absolute; width: 503px"/>
                                            <ice:inputText binding="#{CourtOrder$CourtOrderPayment.txtRequesterId}" id="txtRequesterId" immediate="true"
                                                partialSubmit="true" style="left: 526px; top: 22px; position: absolute; width: 143px"/>
                                            <ice:outputLabel id="lblRequsterFullName" style="left: 48px; top: 24px; position: absolute" value="FullName"/>
                                            <ice:outputLabel id="lblRequesterPosition" style="left: 48px; top: 96px; position: absolute" value="Position"/>
                                            <ice:inputText binding="#{CourtOrder$CourtOrderPayment.txtRequesterPosition}" disabled="true"
                                                id="txtRequesterPosition" style="left: 166px; top: 94px; position: absolute; width: 503px"/>
                                            <ice:commandButton action="#{CourtOrder$CourtOrderPayment.btnSearchRequester_action}"
                                                binding="#{CourtOrder$CourtOrderPayment.btnSearchRequester}" id="btnSearchRequester"
                                                image="/resources/images/fig_search.gif" style="left: 648px; top: 24px; position: absolute"/>
                                        </ice:panelLayout>
                                        <ice:panelLayout id="pnlType"
                                            style="height: 45px; margin-left: 15px; left: 9px; top: 176px; position: absolute; width: 727px; -rave-layout: grid" styleClass="insideContainerMain">
                                            <ice:selectOneRadio binding="#{CourtOrder$CourtOrderPayment.radioGroupApplierType}" dir="LTR"
                                                id="radioGroupApplierType" partialSubmit="true" style="left: 220px; top: 0px; position: absolute" valueChangeListener="#{CourtOrder$CourtOrderPayment.radioGroupApplierType_processValueChange}">
                                                <f:selectItem itemLabel="For Person" itemValue="#{CourtOrder$CourtOrderPayment.EMPLOYEE}"/>
                                                <f:selectItem itemLabel="For Organazation" itemValue="#{CourtOrder$CourtOrderPayment.ORGANAZATION}"/>
                                            </ice:selectOneRadio>
                                            <ice:outputText id="outputText1" style="position: absolute; left: 72px; top: 0px" value="For whom you are deduct"/>
                                        </ice:panelLayout>
                                        <ice:panelLayout id="pnlReasoun"
                                            style="height: 583px; margin-left: 15px; left: 9px; top: 230px; position: absolute; width: 727px; -rave-layout: grid" styleClass="insideContainerMain">
                                            <ice:outputText binding="#{CourtOrder$CourtOrderPayment.lbl_relation}" id="lbl_relation" rendered="false"
                                                style="left: 24px; top: 0px; position: absolute" value="Relation Type"/>
                                            <ice:selectOneMenu binding="#{CourtOrder$CourtOrderPayment.drl_relationType}" id="drl_relationType"
                                                partialSubmit="true" rendered="false"
                                                style="height: 23px; left: 100px; top: -2px; position: absolute; width: 209px"
                                                value="#{CourtOrder$CourtOrderPayment.selectOneMenu1Bean.selectedObject}" valueChangeListener="#{CourtOrder$CourtOrderPayment.drl_relationType_processValueChange}">
                                                <f:selectItems id="selectOneMenu1selectItems" value="#{CourtOrder$CourtOrderPayment.relationType}"/>
                                            </ice:selectOneMenu>
                                            <ice:outputText binding="#{CourtOrder$CourtOrderPayment.lbl_fullName}" id="lbl_fullName" rendered="false"
                                                style="left: 24px; top: 36px; position: absolute" value="Full Name"/>
                                            <ice:inputText binding="#{CourtOrder$CourtOrderPayment.txt_full_Name}" id="txt_full_Name" rendered="false" style="left: 94px; top: 36px; position: absolute; width: 215px"/>
                                            <ice:outputText binding="#{CourtOrder$CourtOrderPayment.lbl_addressPer}" id="lbl_addressPer" rendered="false"
                                                style="left: 24px; top: 72px; position: absolute" value="Address"/>
                                            <ice:inputText binding="#{CourtOrder$CourtOrderPayment.txt_Personal_Address}" id="txt_Personal_Address"
                                                rendered="false" style="left: 94px; top: 70px; position: absolute; width: 215px"/>
                                            <ice:outputText binding="#{CourtOrder$CourtOrderPayment.lbl_sex}" id="lbl_sex" rendered="false"
                                                style="left: 360px; top: 0px; position: absolute" value="Sex"/>
                                            <ice:selectOneMenu binding="#{CourtOrder$CourtOrderPayment.drl_sex}" id="drl_sex" partialSubmit="true"
                                                rendered="false" style="left: 382px; top: -2px; position: absolute; width: 167px" value="#{CourtOrder$CourtOrderPayment.selectOneMenu2Bean.selectedObject}">
                                                <f:selectItems id="selectOneMenu2selectItems" value="#{CourtOrder$CourtOrderPayment.sex}"/>
                                            </ice:selectOneMenu>
                                            <ice:outputText binding="#{CourtOrder$CourtOrderPayment.lbl_age}" id="lbl_age" rendered="false"
                                                style="left: 360px; top: 24px; position: absolute" value="Age"/>
                                            <ice:inputText binding="#{CourtOrder$CourtOrderPayment.txt_age}" id="txt_age" rendered="false" style="left: 382px; top: 22px; position: absolute; width: 167px"/>
                                            <ice:panelLayout id="pnlDataTable"
                                                style="height: 117px; margin-left: 15px; left: 9px; top: 445px; overflow: auto; position: absolute; width: 686px; -rave-layout: grid" styleClass="insideContainerMain">
                                                <ice:dataTable binding="#{CourtOrder$CourtOrderPayment.dataTable_Personal}" id="dataTable_Personal"
                                                    rendered="false" style="left: 14px; top: 5px; position: absolute"
                                                    value="#{CourtOrder$CourtOrderPayment.courtDeductForPerson}" var="currentRow" width="623">
                                                    <ice:column groupOn="#{currentRow['relationType']}" id="column1">
                                                        <ice:outputText id="outputText1Relation"
                                                            style=" font-family: 'Lucida Sans'; font-size: 11px; font-style: normal" value="#{currentRow['relationType']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText10" value="Relation Type"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column groupOn="#{currentRow['nameOfTaker']}" id="column2">
                                                        <ice:outputText id="outputText1FullName"
                                                            style=" font-family: 'Lucida Sans'; font-size: 11px; font-style: normal" value="#{currentRow['nameOfTaker']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText12" value="Full Name"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column groupOn="#{currentRow['takerSex']}" id="column3">
                                                        <ice:outputText id="outputTextSex"
                                                            style=" font-family: 'Lucida Sans'; font-size: 11px; font-style: normal" value="#{currentRow['takerSex']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText14" value="Sex"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column groupOn="#{currentRow['age']}" id="column4">
                                                        <ice:inputText id="outputTextAge" value="#{currentRow['age']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText11" value="Age"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column groupOn="#{currentRow['takerAddress']}" id="column5">
                                                        <ice:inputTextarea id="outputTextAddress" value="#{currentRow['takerAddress']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText15" value="Address"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column groupOn="#{currentRow['chargeType']}" id="column6">
                                                        <ice:inputText id="outputTextChargeType" value="#{currentRow['chargeType']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText17" value="ChargeType"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column groupOn="#{currentRow['courtName']}" id="column7">
                                                        <ice:inputText id="outputTextCourtName" value="#{currentRow['courtName']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText18" value="CourtName"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column groupOn="#{currentRow['deductionType']}" id="column8">
                                                        <ice:inputText id="outputTextDeductionType" value="#{currentRow['deductionType']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText19" value="DeductionType"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column118">
                                                        <ice:inputText id="outputTextDeductionTotalDeductionAmount" value="#{currentRow['totalDeductionAmount']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText1119" value="TotalDeductionAmount($)"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column228">
                                                        <ice:inputText id="outputTextTotalPercentDeduction" value="#{currentRow['totalPercentDeduction']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText2219" value="TotalPercentDeductionAmount(%)"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column9">
                                                        <ice:inputText id="outputTextPercentValue" value="#{currentRow['percentValue']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText20" value="MonthlyPercentValue(%)"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column10">
                                                        <ice:inputText id="outputTextDeductionAmoun" value="#{currentRow['deductionAmount']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText21" value="MonthlyDeductionAmount($)"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column12">
                                                        <ice:inputText id="outputTextStartDate" value="#{currentRow['startDate']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText23" value="StartDate"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column groupOn="#{currentRow['endDate']}" id="column13">
                                                        <ice:inputText id="outputTextEndDate" value="#{currentRow['endDate']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText24" value="EndDate"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column groupOn="#{currentRow['reasoun']}" id="column14">
                                                        <ice:inputText id="outputTextReasoun" value="#{currentRow['reasoun']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText25" value="Reasoun"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column groupOn="#{currentRow['docRef']}" id="column15">
                                                        <ice:inputText id="outputTextDocRef" value="#{currentRow['docRef']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText26" value="Doc.Ref.No"/>
                                                        </f:facet>
                                                    </ice:column>
                                                </ice:dataTable>
                                                <ice:dataTable binding="#{CourtOrder$CourtOrderPayment.dataTable_Organization}" id="dataTable_Organization"
                                                    rendered="false" style="left: 14px; top: 14px; position: absolute"
                                                    value="#{CourtOrder$CourtOrderPayment.courtDeductForOrganazation}" var="currentRow" width="623">
                                                    <ice:column groupOn="#{currentRow['organazationType']}" id="column6">
                                                        <ice:inputText id="outputTexOrgType" value="#{currentRow['organazationType']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText6" value="Organization Type"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column groupOn="#{currentRow['organazationName']}" id="column7">
                                                        <ice:inputTextarea id="outputTexOrgName" value="#{currentRow['organazationName']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText8" value="Organization Name"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column groupOn="#{currentRow['organazationAddress']}" id="column8">
                                                        <ice:inputTextarea id="outputTexOrgAddress" value="#{currentRow['organazationAddress']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText17" value="Organization Address"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column groupOn="#{currentRow['organazationPhone']}" id="column9">
                                                        <ice:inputText id="outputTexOrgPhone" value="#{currentRow['organazationPhone']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText19" value="Organization Phone"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column groupOn="#{currentRow['chargeType']}" id="columnorg6">
                                                        <ice:inputText id="outputTextChargeTypeForOrganazation" value="#{currentRow['chargeType']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputTextOtganazation17" value="ChargeType"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column groupOn="#{currentRow['courtName']}" id="columnorg7">
                                                        <ice:inputText id="outputTextCourtNameOrganazation" value="#{currentRow['courtName']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputTextOrganazation18" value="CourtName"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column groupOn="#{currentRow['deductionType']}" id="columnorg8">
                                                        <ice:inputText id="outputTextDeductionTypeorganazation" value="#{currentRow['deductionType']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputTextOrganazation19" value="DeductionType"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="columnorg8656">
                                                        <ice:inputText id="outputTextOrgTotalDeduction" value="#{currentRow['totalDeductionAmount']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputTextTotalDeduction22" value="TotalDeductionAmount($)"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="columnorg89899">
                                                        <ice:inputText id="outputTextTotalDeductionPercent" value="#{currentRow['totalPercentDeduction']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputTextTotalDeductionPercentValue" value="TotalPercentDeductionAmount(%)"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="columnorg9">
                                                        <ice:inputText id="outputTextPercentValueOrge" value="#{currentRow['percentValue']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputTextorganazation20" value="MonthlyPercentValue(%)"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="columnorg10">
                                                        <ice:inputText id="outputTextDeductionAmounOrganazation" value="#{currentRow['deductionAmount']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputTextOrg21" value="MonthlyDeductionAmount($)"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column12Org">
                                                        <ice:inputText id="outputTextStartDateOrganaztion" value="#{currentRow['startDate']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText23Org" value="StartDate"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column groupOn="#{currentRow['endDate']}" id="column13Org">
                                                        <ice:inputText id="outputTextEndDateOrganazation" value="#{currentRow['endDate']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText24org" value="EndDate"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column groupOn="#{currentRow['reasoun']}" id="column14org">
                                                        <ice:inputTextarea id="outputTextReasounOrganazation" value="#{currentRow['reasoun']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText25org" value="Reasoun"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column groupOn="#{currentRow['docRef']}" id="column15org">
                                                        <ice:inputText id="outputTextDocRefOrganazation" value="#{currentRow['docRef']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText26Org" value="Doc.Ref.No"/>
                                                        </f:facet>
                                                    </ice:column>
                                                </ice:dataTable>
                                            </ice:panelLayout>
                                            <ice:commandButton action="#{CourtOrder$CourtOrderPayment.btn_add_action}"
                                                binding="#{CourtOrder$CourtOrderPayment.btn_add}" id="btn_add" rendered="true"
                                                style="height: 32px; left: 600px; top: 45px; position: absolute; width: 71px" value="ADD"/>
                                            <ice:outputText binding="#{CourtOrder$CourtOrderPayment.out_txt_OrgType}" id="out_txt_OrgType" rendered="false"
                                                style="left: 48px; top: 0px; position: absolute" value="Organization Type"/>
                                            <ice:selectOneMenu binding="#{CourtOrder$CourtOrderPayment.drl_org_Type}" id="drl_org_Type" partialSubmit="true"
                                                rendered="false" style="left: 166px; top: 0px; position: absolute; width: 191px" value="#{CourtOrder$CourtOrderPayment.defaultSelectedData3.selectedObject}">
                                                <f:selectItems id="selectOneMenu1selectItems1" value="#{CourtOrder$CourtOrderPayment.orgType}"/>
                                            </ice:selectOneMenu>
                                            <ice:outputText binding="#{CourtOrder$CourtOrderPayment.out_txt_OrgName}" id="out_txt_OrgName" rendered="false"
                                                style="left: 48px; top: 24px; position: absolute" value="Organization Name"/>
                                            <ice:inputText binding="#{CourtOrder$CourtOrderPayment.txt_OrgName}" id="txt_OrgName" rendered="false" style="left: 166px; top: 28px; position: absolute; width: 191px"/>
                                            <ice:outputText binding="#{CourtOrder$CourtOrderPayment.out_txt_addressper}" id="out_txt_addressper"
                                                rendered="false" style="left: 408px; top: 0px; position: absolute" value="Organization Address"/>
                                            <ice:inputText binding="#{CourtOrder$CourtOrderPayment.txt_org_address}" id="txt_org_address" rendered="false" style="left: 526px; top: 0px; position: absolute; width: 191px"/>
                                            <ice:outputText binding="#{CourtOrder$CourtOrderPayment.out_txt_orgPhone}" id="out_txt_orgPhone" rendered="false"
                                                style="left: 408px; top: 24px; position: absolute" value="Organization Phone"/>
                                            <ice:inputText binding="#{CourtOrder$CourtOrderPayment.txt_org_Phone}" id="txt_org_Phone" rendered="false" style="left: 526px; top: 25px; position: absolute; width: 191px"/>
                                            <ice:panelLayout id="pnlReasoun1"
                                                style="height: 213px; margin-left: 15px; left: 9px; top: 216px; position: absolute; width: 694px; -rave-layout: grid" styleClass="insideContainerMain">
                                                <ice:outputText id="outputText4" style="left: 24px; top: 0px; position: absolute" value="Charge Type"/>
                                                <ice:outputText binding="#{CourtOrder$CourtOrderPayment.dedct_amout}" id="dedct_amout"
                                                    style="left: 24px; top: 96px; position: absolute" value="Deduction Amount(Monthly)"/>
                                                <ice:outputText id="outputText7" style="left: 24px; top: 178px; position: absolute" value="End Date"/>
                                                <ice:outputText id="outputText16" style="left: 24px; top: 30px; position: absolute" value="Court Name"/>
                                                <ice:outputText id="outputText20" style="left: 384px; top: 24px; position: absolute" value="Reason "/>
                                                <ice:outputText id="outputText22" style="left: 24px; top: 155px; position: absolute" value="Start Date"/>
                                                <ice:inputTextarea binding="#{CourtOrder$CourtOrderPayment.txtArea_Reasoun}" id="txtArea_Reasoun" style="height: 71px; left: 454px; top: 5px; position: absolute; width: 216px"/>
                                                <ice:outputText id="outputText21" style="left: 384px; top: 96px; position: absolute" value="Doc.Ref.No"/>
                                                <ice:inputText binding="#{CourtOrder$CourtOrderPayment.txt_DocRef}" id="txt_DocRef" style="height: 21px; left: 454px; top: 96px; position: absolute; width: 216px"/>
                                                <ice:inputText binding="#{CourtOrder$CourtOrderPayment.txt_StartDate}" id="txt_StartDate" style="height: 23px; left: 190px; top: 152px; position: absolute; width: 168px"/>
                                                <ice:inputText binding="#{CourtOrder$CourtOrderPayment.txt_DeductionAmount}" id="txt_DeductionAmount" style="height: 23px; left: 190px; top: 94px; position: absolute; width: 167px"/>
                                                <ice:inputText binding="#{CourtOrder$CourtOrderPayment.txt_endDate}" id="txt_endDate" style="height: 23px; left: 190px; top: 180px; position: absolute; width: 167px"/>
                                                <ice:inputText binding="#{CourtOrder$CourtOrderPayment.txt_CourtName}" id="txt_CourtName" style="height: 23px; left: 190px; top: 27px; position: absolute; width: 167px"/>
                                                <ice:selectOneMenu binding="#{CourtOrder$CourtOrderPayment.drl_chargeType}" id="drl_chargeType"
                                                    partialSubmit="true" style="left: 190px; top: -2px; position: absolute; width: 167px" value="#{CourtOrder$CourtOrderPayment.defaultSelectedData4.selectedObject}">
                                                    <f:selectItems id="selectOneMenu1selectItems2" value="#{CourtOrder$CourtOrderPayment.chargeType}"/>
                                                </ice:selectOneMenu>
                                                <ice:commandButton action="#{CourtOrder$CourtOrderPayment.button1_action}" id="button1"
                                                    image="/resources/images/cal_icon.JPG" style="left: 360px; top: 154px; position: absolute" value="submit"/>
                                                <ice:commandButton action="#{CourtOrder$CourtOrderPayment.button2_action}"
                                                    binding="#{CourtOrder$CourtOrderPayment.btn_EndDate}" id="btn_EndDate"
                                                    image="/resources/images/cal_icon.JPG" style="left: 360px; top: 178px; position: absolute" value="submit"/>
                                                <ice:outputLabel id="outputLabel1" style="left: 24px; top: 60px; position: absolute" value="DeductionType"/>
                                                <ice:selectOneRadio id="selectOneRadioDeducationType" partialSubmit="true"
                                                    style="left: 190px; top: 60px; position: absolute"
                                                    value="#{CourtOrder$CourtOrderPayment.selectOneRadio1Bean.selectedObject}" valueChangeListener="#{CourtOrder$CourtOrderPayment.selectOneRadioDeducationType_processValueChange}">
                                                    <f:selectItem itemLabel=" Percent(%)" itemValue="#{CourtOrder$CourtOrderPayment.PERCENT}"/>
                                                    <f:selectItem itemLabel="Money($)" itemValue="#{CourtOrder$CourtOrderPayment.MONEY}"/>
                                                </ice:selectOneRadio>
                                                <ice:outputLabel binding="#{CourtOrder$CourtOrderPayment.percent_value}" id="percent_value" rendered="false"
                                                    style="left: 24px; top: 96px; position: absolute" value="PercentValue(Monthly)"/>
                                                <ice:inputText binding="#{CourtOrder$CourtOrderPayment.txt_percentValue}" id="txt_percentValue" rendered="false" style="height: 23px; left: 189px; top: 94px; position: absolute; width: 71px"/>
                                                <ice:outputLabel binding="#{CourtOrder$CourtOrderPayment.percent}" id="percent" rendered="false"
                                                    style="left: 270px; top: 96px; position: absolute" value="(%)"/>
                                                <ice:outputText binding="#{CourtOrder$CourtOrderPayment.out_txt_TotalDeductionAmount}"
                                                    id="out_txt_TotalDeductionAmount" style="left: 24px; top: 130px; position: absolute" value="Total Deducation Amount"/>
                                                <ice:inputText binding="#{CourtOrder$CourtOrderPayment.intxt_TotalDeduction}" id="intxt_TotalDeduction" style="left: 190px; top: 125px; position: absolute; width: 167px"/>
                                                <ice:inputText binding="#{CourtOrder$CourtOrderPayment.intxt_TotalDeductionPercent}"
                                                    id="intxt_TotalDeductionPercent" rendered="false" style="left: 190px; top: 125px; position: absolute; width: 167px"/>
                                                <ice:outputText binding="#{CourtOrder$CourtOrderPayment.out_txt_TotalPercent}" id="out_txt_TotalPercent"
                                                    rendered="false" style="left: 24px; top: 130px; position: absolute" value="TotalDeductionAmount(%)"/>
                                            </ice:panelLayout>
                                            <ice:panelLayout binding="#{CourtOrder$CourtOrderPayment.panelLayoutFamily}" id="panelLayoutFamily"
                                                style="height: 93px; margin-left: 15px; left: 9px; top: 106px; overflow: auto; position: absolute;  width: 669px; -rave-layout: grid" styleClass="insideContainerMain">
                                                <ice:dataTable binding="#{CourtOrder$CourtOrderPayment.dataTable1Family}" id="dataTable1Family" rendered="false"
                                                    style="left: 38px; top: 0px; position: absolute" value="#{CourtOrder$CourtOrderPayment.familyOrPerson}" var="currentRow">
                                                    <ice:column id="column16">
                                                        <ice:inputText id="outputFamilyRelationType" value="#{currentRow['relationType']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText13" value="RelationType"/>
                                                        </f:facet>
                                                        <ice:rowSelector id="rowSelector1Penalitytype" preStyleOnSelection="true"
                                                            selectionListener="#{CourtOrder$CourtOrderPayment.rowSelector1FamilyRelationType_processMyEvent}"
                                                            toggleOnClick="true" value="#{currentRow['selected']}"/>
                                                    </ice:column>
                                                    <ice:column id="column17">
                                                        <ice:inputText id="outputFamilyFullName" value="#{currentRow['fullName']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText28" value="FullName"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column18">
                                                        <ice:inputText id="outputFamilySex" value="#{currentRow['sex']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText30" value="Sex"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column19">
                                                        <ice:outputText id="outputText5"/>
                                                        <ice:inputText id="outputFamilyAge" value="#{currentRow['age']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText27" value="Age"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column19Address">
                                                        <ice:outputText id="outputTextAddress5"/>
                                                        <ice:inputText id="outputFamilyAddress" value="#{currentRow['address']}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputTextAddress27" value="Address"/>
                                                        </f:facet>
                                                    </ice:column>
                                                </ice:dataTable>
                                            </ice:panelLayout>
                                        </ice:panelLayout>
                                        <ice:panelPopup autoCentre="true" binding="#{CourtOrder$CourtOrderPayment.pnlPopupSuccessOrFailure}" clientOnly="true"
                                            draggable="true" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                                            style="border-style: none; background-color: transparent; display: block; height: 136px; left: 30px; top: 180px; position: relative; width: 667px" styleClass="message">
                                            <f:facet name="header">
                                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                                    <ice:outputText id="pnMessageTitle"
                                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                                    <ice:commandLink action="#{CourtOrder$CourtOrderPayment.btnClosePopupSuccessOrFailure_action}"
                                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 700px; top: 20px; position: absolute; width: 19px"
                                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <f:facet name="body">
                                                <ice:panelGroup binding="#{CourtOrder$CourtOrderPayment.panelGroupMessage}" id="panelGroupMessage"
                                                    style="display: block; height: 80px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                                    <ice:panelLayout id="pnlMessageBody" layout="flow"
                                                        style="background-color: rgb(245, 245, 245); display: block; height: 53px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                                        <h:outputLabel binding="#{CourtOrder$CourtOrderPayment.lblSuccessOrErrorMessage}"
                                                            id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                                    </ice:panelLayout>
                                                </ice:panelGroup>
                                            </f:facet>
                                        </ice:panelPopup>
                                        <ice:panelLayout id="pnlButton"
                                            style="height: 45px; margin-left: 15px; left: 9px; top: 820px; position: absolute; width: 742px; -rave-layout: grid" styleClass="insideContainerMain">
                                            <ice:commandButton binding="#{CourtOrder$CourtOrderPayment.btn_new}" id="btn_new"
                                                style="height: 37px; left: 192px; top: -5px; position: absolute; width: 68px" value="New"/>
                                            <ice:commandButton action="#{CourtOrder$CourtOrderPayment.btn_save_action}"
                                                binding="#{CourtOrder$CourtOrderPayment.btn_save}" id="btn_save"
                                                style="height: 37px; left: 312px; top: -5px; position: absolute; width: 71px" value="Save"/>
                                            <ice:commandButton action="#{CourtOrder$CourtOrderPayment.btn_reset_action}"
                                                binding="#{CourtOrder$CourtOrderPayment.btn_reset}" id="btn_reset"
                                                style="height: 37px; left: 432px; top: -5px; position: absolute; width: 71px" value="Reset"/>
                                        </ice:panelLayout>
                                    </fieldset>
                                </ice:panelLayout>
                                <ice:selectInputDate binding="#{CourtOrder$CourtOrderPayment.calOffenceDate}" id="calOffenceDate" rendered="false"
                                    style="left: 300px; top: 600px; position: absolute" value="#{CourtOrder$CourtOrderPayment.calOffenceDateBean.date1}" valueChangeListener="#{CourtOrder$CourtOrderPayment.calOffenceDate_processValueChange}"/>
                                <ice:selectInputDate binding="#{CourtOrder$CourtOrderPayment.calReportedDate}" id="calReportedDate" rendered="false"
                                    style="left: 300px; top: 600px; position: absolute" value="#{CourtOrder$CourtOrderPayment.calReportedDateBean.date1}" valueChangeListener="#{CourtOrder$CourtOrderPayment.calReportedDate_processValueChange}"/>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="south">
                            <ice:panelGroup id="page_footer">
                                <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">
                                    <label
                                            style="margin-left:10px;color:white;font-weight:bold;font-family:Cambria">Copyright © 2002-2003 Ethiopian Calander | <a
                                            href="http://www.google.com" style="text-decoration:none;color:orange">BUNNA INTERNATIONAL BANK |information |Software Department.</a> |</label>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelBorder>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
