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
        <f:loadBundle basename="Localization.HRLocalization_Benefit" var="msgsb"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Benefit Type Registration</title>
                <link href="../resources/images/mugher_icon.gif" rel="icon"/>
                <ice:outputStyle href="../resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="../resources/TempCSS.css"/>
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
                    function EmployeeMilkRegistraion(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <ice:panelBorder id="whole_page" renderCenter="#{Benefit$BenefitTypePage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Benefit$BenefitTypePage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Benefit$BenefitTypePage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Benefit$BenefitTypePage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Benefit$BenefitTypePage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative" styleClass="whole_page" width="1024">
                            <f:facet name="north">
                                <ice:panelGroup dragListener="#{Benefit$BenefitTypePage.page_header_processMyEvent}" id="page_header" style="height: 117px">
                                    <!-- Begin Header -->
                                    <ice:panelLayout id="header" layout="flow"
                                        style="height: 129px; left: 0px; position: relative; width: 100%z; -rave-layout: grid" styleClass="header" visible="true">
                                        <jsp:directive.include file="/Header.jspf"/>
                                    </ice:panelLayout>
                                    <!-- End Header -->
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="west">
                                <ice:panelGroup id="menu_left" style="border:none; height:470px;">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height:470px; top:15px left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height:470px; top :20px; left: 5px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Common_Tasks" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="commonTasksGroup_header">
                                                        <ice:outputText id="lblCommonTasks" value="Common Tasks"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="commonTasksGroup_Grid11" width="100%">
                                                    <ice:panelGroup id="commonTasksGroup_Group22" style="width:100%"/>
                                                    <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                        <li></li>
                                                        <li>
                                                            <ice:commandLink id="lnkAuthoriazation" style="color:#306682;font-weight:bold" value="Authoriazation"/>
                                                        </li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height:790px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 775px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 760px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="BENEFIT TYPES REGISTRATION"/>
                                            </legend>
                                            <ice:panelLayout id="pnlLayoutMainBody" style="height: 770px; left: 0px; top: 0px; position: absolute; width: 100%">
                                                <ice:panelLayout binding="#{Benefit$BenefitTypePage.pnProfile}" id="pnProfile" style="top: 20px; height: 770px; width: 100%">
                                                    <ice:panelLayout id="pnlLayoutEditor" layout="flow"
                                                        style="border: 1px solid rgb(204, 204, 204); height: 290px; left: 10px; top: 10px; position: absolute; width: 760px" styleClass="insideContainerMain">
                                                        <ice:inputText disabled="true" id="txtPopupDescplineId" rendered="false" style="left: 502px; top: 22px; position: absolute"/>
                                                        <ice:inputText binding="#{Benefit$BenefitTypePage.txtBenefitName}" id="txtBenefitName" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 17px; position: absolute; width: 190px"/>
                                                        <ice:inputText binding="#{Benefit$BenefitTypePage.txBenefitType}" id="txBenefitType" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 54px; position: absolute; width: 190px"/>
                                                        <ice:inputTextarea binding="#{Benefit$BenefitTypePage.txtaDescription}" id="txtaDescription" style="left: 166px; top: 166px; position: absolute; width: 449px"/>
                                                        <ice:outputLabel id="lblPopupDisciplineId" rendered="false"
                                                            style="left: 432px; top: 24px; position: absolute" value="DisciplineId"/>
                                                        <ice:outputLabel id="lblPopupBenefitName"
                                                            style="font-size: 10px; left: 38px; top: 20px; position: absolute" value="#{msgsb.BenefitName}"/>
                                                        <ice:outputLabel binding="#{Benefit$BenefitTypePage.lblPopupbenefitType}" id="lblPopupbenefitType"
                                                            style="font-size: 10px; left: 38px; top: 54px; position: absolute" value="#{msgsb.BenefitType}"/>
                                                        <ice:outputLabel id="lblPopupDescription" style="left: 48px; top: 168px; position: absolute" value="#{msgsb.Description}"/>
                                                        <ice:outputLabel id="lblPopupInterva" style="left: 48px; top: 240px; position: absolute" value="#{msgsb.Interval}"/>
                                                        <ice:selectOneMenu binding="#{Benefit$BenefitTypePage.drlTermLength}" id="drlTermLength"
                                                            partialSubmit="true" style="left: 166px; top: 238px; position: absolute; width: 162px" value="#{Benefit$BenefitTypePage.defaultSelectedDataDisciplineCategory.selectedObject}">
                                                            <f:selectItems id="selectOneMenuDisciplineCategory" value="#{Benefit$BenefitTypePage.benefitDurationOption}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:commandButton action="#{Benefit$BenefitTypePage.btnAddToTable_action}"
                                                            binding="#{Benefit$BenefitTypePage.btnAddToTable}" id="btnAddToTable"
                                                            style="left: 600px; top: 254px; position: absolute" value="#{msgsb.AddToTable}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Benefit$BenefitTypePage.chkPercnt}" id="chkPercnt"
                                                            partialSubmit="true" style="left: 430px; top: 22px; position: absolute"
                                                            value="#{Benefit$BenefitTypePage.defaultSelectedData3.selectedBoolean}" valueChangeListener="#{Benefit$BenefitTypePage.chkPercnt_processValueChange}"/>
                                                        <ice:outputLabel binding="#{Benefit$BenefitTypePage.lblInPercent}" id="lblInPercent"
                                                            style="left: 456px; top: 24px; position: absolute" value="#{msgsb.InPercent}"/>
                                                        <ice:outputLabel binding="#{Benefit$BenefitTypePage.lblPercent}" id="lblPercent" rendered="true"
                                                            style="font-size: 11px; left: 450px; top: 54px; position: absolute" value="How much Percent?"/>
                                                        <ice:inputText binding="#{Benefit$BenefitTypePage.txtPercent}" id="txtPercent" rendered="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 580px; top: 54px; position: absolute; width: 100px"/>
                                                        <ice:outputLabel binding="#{Benefit$BenefitTypePage.lblPercenSymbol}" id="lblPercenSymbol"
                                                            rendered="true" style="font-size: 11px; left: 700px; top: 54px; position: absolute" value="%"/>
                                                        <ice:outputLabel id="lblBenefit1" style="font-size: 10px; left: 38px; top: 90px; position: absolute" value="#{msgsb.search}"/>
                                                        <ice:selectInputText action="#{Benefit$BenefitTypePage.txtSearchByDevice_action}"
                                                            binding="#{Benefit$BenefitTypePage.txtSearchByDevice}" id="txtSearchByDevice" immediate="true"
                                                            listValue="#{Benefit$BenefitTypePage.list}" listVar="deviceList" partialSubmit="true" rows="10"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 88px; position: absolute"
                                                            valueChangeListener="#{Benefit$BenefitTypePage.txtSearchByDevice_processValueChange}" width="567">
                                                            <f:facet name="selectInputText">
                                                                <ice:panelGrid columnClasses="empIdCol,fullNameCol" columns="2">
                                                                    <ice:outputText id="lblFullNameAutoComplete2" value="#{deviceList.diviceName}"/>
                                                                    <ice:outputText id="lblEmployeeIdAutoComplete2" value="#{deviceList.diviceCode}"/>
                                                                </ice:panelGrid>
                                                            </f:facet>
                                                        </ice:selectInputText>
                                                        <ice:outputLabel id="lblBenefit2" style="left: 48px; top: 144px; position: absolute" value="#{msgsb.saftyDevice}"/>
                                                        <ice:outputLabel id="outputLabel1" rendered="false" style="left: 48px; top: 120px; position: absolute" value="#{msgsb.deviceCode}"/>
                                                        <ice:inputText binding="#{Benefit$BenefitTypePage.txtDeviceCode}" id="txtDeviceCode" rendered="false" style="height: 21px; left: 166px; top: 118px; position: absolute; width: 215px"/>
                                                        <ice:inputText binding="#{Benefit$BenefitTypePage.txtDeviceNAme}" disabled="true" id="txtDeviceNAme" style="height: 21px; left: 166px; top: 138px; position: absolute; width: 167px"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutDataTable"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 278px; margin-left: 15px; left: 33px; top: 312px; overflow: auto; position: absolute; width: 702px" styleClass="insideContainerMain">
                                                        <ice:dataTable id="dataTableDisciplineType"
                                                            style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                                            value="#{Benefit$BenefitTypePage.benefitTypesList}" var="currentRow">
                                                            <ice:column id="colPopupBenefitName">
                                                                <ice:inputText id="txtPopupForColumnBenefitName" value="#{currentRow['benefitName']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextPopupBenefitName" value="Benefit Name"/>
                                                                </f:facet>
                                                                <ice:rowSelector id="rowSelector1" multiple="false"
                                                                    selectionListener="#{Benefit$BenefitTypePage.rowSelector1_processAction}" value="#{currentRow['selected']}"/>
                                                            </ice:column>
                                                            <ice:column id="colPopupDisciplineTypeCode">
                                                                <ice:inputText id="txtPopupForColumnBenefitType" value="#{currentRow['benefitType']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextBenefitType" value="Benefit Type"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colPopupDisciplineTypeCode1">
                                                                <ice:inputText id="txtPopupForColumnBenefitType1" value="#{currentRow['saftyDevices']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextBenefitType1" value="Material Code"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colPhaseoutPeriod2">
                                                                <ice:inputText id="txtPopupForpercent" value="#{currentRow['percrnt']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextInterval2" value="Percent"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colPopupDescription">
                                                                <ice:inputText id="txtPopupForColumnDescription" value="#{currentRow['benefitDescription']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextPopupDescription" value="Description"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colPhaseoutPeriod">
                                                                <ice:selectOneMenu id="drlTermLengthTbl" partialSubmit="true" value="#{currentRow['benefitTermLength']}">
                                                                    <f:selectItems id="selectOneMenuDisciplineCategoryTbl" value="#{Benefit$BenefitTypePage.benefitDurationOption}"/>
                                                                </ice:selectOneMenu>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextInterval" value="Interval"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colEdit">
                                                                <ice:commandLink action="#{Benefit$BenefitTypePage.cmdLnkEdit_action}" id="cmdLnkEdit" value="Ok"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextEdit" value="Edit"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colRemove">
                                                                <ice:commandLink action="#{Benefit$BenefitTypePage.cmdLnkRemove_action}" id="cmdLnkRemove" value="Remove"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextRemove" value="Remove"/>
                                                                </f:facet>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout binding="#{Benefit$BenefitTypePage.pnlLayoutTree}" id="pnlLayoutTree" layout="flow"
                                                        rendered="false"
                                                        style="border-width: 2px; border-style: solid; height: 356px; left: 11px; top: 78px; overflow: scroll; position: absolute; width: 264px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:tree binding="#{Benefit$BenefitTypePage.treeOrgStructure}" id="tree"
                                                            style="height: 286px; margin-left: 0px; margin-top: 0px; left: 0px; top: 48px; position: absolute; text-align: left; width: 190px"
                                                            value="#{Benefit$BenefitTypePage.treeModel.model}" var="item">
                                                            <ice:treeNode id="treeNode2">
                                                                <f:facet name="icon">
                                                                    <ice:panelGroup id="panelGroup1" style="display: inline;">
                                                                        <ice:graphicImage id="graphicImage2" value="#{item.userObject.icon}"/>
                                                                    </ice:panelGroup>
                                                                </f:facet>
                                                                <f:facet name="content">
                                                                    <ice:panelGroup id="panelGroup2" style="display: inline;">
                                                                        <ice:commandLink actionListener="#{Benefit$BenefitTypePage.cmdLnkTree_processAction}"
                                                                            id="cmdLnkTree" partialSubmit="true">
                                                                            <ice:outputText id="outputText1" value="#{item.userObject.text}"/>
                                                                        </ice:commandLink>
                                                                    </ice:panelGroup>
                                                                </f:facet>
                                                            </ice:treeNode>
                                                        </ice:tree>
                                                    </ice:panelLayout>
                                                    <!--/ice:panelGroup-->
                                                    <ice:panelLayout id="pnlLayoutButtons"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 44px; margin-left: 15px; left: 33px; top: 624px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                        <ice:commandButton action="#{Benefit$BenefitTypePage.btnPopupSaveDiscipline_action}"
                                                            id="btnPopupSaveDiscipline" style="left: 264px;  position: absolute" value="#{msgsb.btnSave}"/>
                                                        <ice:commandButton action="#{Benefit$BenefitTypePage.btnPopupResetDiscipline_action}"
                                                            id="btnPopupResetDiscipline" style="left: 360px;  position: absolute" value="#{msgsb.btnReset}"/>
                                                    </ice:panelLayout>
                                                </ice:panelLayout>
                                            </ice:panelLayout>
                                        </fieldset>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="south">
                                <ice:panelGroup id="page_footer">
                                    <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">
                                        <label
                                                style="margin-left:10px;color:white;font-weight:bold;font-family:Cambria">Copyright © 2005-2006 Ethiopian Calander | <a
                                                href="http://www.bunnabanksc.com" style="text-decoration:none;color:orange">BUNNA INTERNATIONAL BANK |INFORMATION SYSTEM DIVISION |Software Department.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Benefit$BenefitTypePage.pnlPopupSuccessOrFailure}" clientOnly="true" draggable="false"
                            id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Benefit$BenefitTypePage.btnClosePopupSuccessOrFailure_action}" id="btnClosePopupSuccessOrFailure"
                                        immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Benefit$BenefitTypePage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Benefit$BenefitTypePage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Benefit$BenefitTypePage.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
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
