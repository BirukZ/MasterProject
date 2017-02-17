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
                <f:loadBundle basename="Localization.HRLocalization_Milk" var="msgsm"/>
                <title>Deliver Milk To Empolyee</title>
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
                    function BenefitRequestPage(field){
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
                        <ice:panelBorder id="whole_page" renderCenter="#{MilkBenefit$DeliverMilkToEmployee.panelBorder1Bean.renderCenter}"
                            renderEast="#{MilkBenefit$DeliverMilkToEmployee.panelBorder1Bean.renderEast}"
                            renderNorth="#{MilkBenefit$DeliverMilkToEmployee.panelBorder1Bean.renderNorth}"
                            renderSouth="#{MilkBenefit$DeliverMilkToEmployee.panelBorder1Bean.renderSouth}"
                            renderWest="#{MilkBenefit$DeliverMilkToEmployee.panelBorder1Bean.renderWest}"
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
                                                        <ice:panelLayout id="StatusContainer" style="border-style: none; background-color: transparent; height: 78px; position: absolute; width: 190px"/>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height: 850px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 800px; left: 0px; position: relative; top: 20px; width: 800px; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 800px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Deliver Milk For Attended Employee"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 800px; left: 0px; top: 0px; position: absolute; width: 100%">
                                                <ice:panelGroup id="leaveRequest" style="height: 745px; width: 95%" styleClass="filedset_normal">
                                                    <ice:panelLayout id="panelDetail12" layout="flow" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 126px; margin-left: 15px; left: 10px; top: 40px; position: absolute; width: 741px">
                                                        <ice:outputLabel id="lblDocumentReferenceNumber1" style="left: 25px; top: 25px; position: absolute" value="#{msgsm.CurrentDate}"/>
                                                        <ice:inputText binding="#{MilkBenefit$DeliverMilkToEmployee.txtCurrentDate}" disabled="true"
                                                            id="txtCurrentDate" style="left: 126px; top: 23px; position: absolute; width: 183px"/>
                                                        <ice:outputLabel id="lblMilkAvil" style="left: 25px; top: 73px; position: absolute" value="#{msgsm.MilkAvail}"/>
                                                        <ice:selectBooleanCheckbox binding="#{MilkBenefit$DeliverMilkToEmployee.chkAvailble}" id="chkAvailble"
                                                            partialSubmit="true" style="position: absolute; left: 192px; top: 72px"
                                                            value="#{MilkBenefit$DeliverMilkToEmployee.selectBooleanCheckbox1Bean.selectedBoolean}" valueChangeListener="#{MilkBenefit$DeliverMilkToEmployee.chkAvailble_processValueChange}"/>
                                                        <ice:selectBooleanCheckbox binding="#{MilkBenefit$DeliverMilkToEmployee.chkNotAvailab}"
                                                            id="chkNotAvailab" partialSubmit="true" style="position: absolute; left: 360px; top: 72px"
                                                            value="#{MilkBenefit$DeliverMilkToEmployee.selectBooleanCheckbox2Bean.selectedBoolean}" valueChangeListener="#{MilkBenefit$DeliverMilkToEmployee.chkNotAvailab_processValueChange}"/>
                                                        <ice:outputLabel id="lblAvailable" style="left: 217px; top: 73px; position: absolute" value="#{msgsm.Avail}"/>
                                                        <ice:outputLabel id="lblDocumentReferenceNumber3" style="left: 385px; top: 73px; position: absolute" value="#{msgsm.NotAvail}"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutDataTable1" layout="flow"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 356px; margin-left: 15px; overflow: auto; width: 751px; top:200px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:dataTable id="dataTableEmployeeList1"
                                                            style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                                            value="#{MilkBenefit$DeliverMilkToEmployee.employeeList}" var="currentRow">
                                                            <ice:column id="colEmpId1">
                                                                <ice:inputText id="txtPopupForColumnBenefitName1" value="#{currentRow['empId']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextPopupBenefitName1" value="EmpID"/>
                                                                </f:facet>
                                                                <ice:rowSelector id="rowSelector1"
                                                                    selectionListener="#{MilkBenefit$DeliverMilkToEmployee.rowSelector1_processAction}" value="#{currentRow['rendered']}"/>
                                                            </ice:column>
                                                            <ice:column id="colPhaseoutPeriod1">
                                                                <ice:selectOneMenu id="drlTermLengthTbl1" partialSubmit="true" value="#{currentRow['type']}">
                                                                    <f:selectItems id="selectOneMenuDisciplineCategoryTbl1" value="#{MilkBenefit$DeliverMilkToEmployee.benefittype}"/>
                                                                </ice:selectOneMenu>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextInterval1" value="Benefit Type"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colPopupDisciplineTypeCode1">
                                                                <ice:inputText id="txtPopupForColumnBenefitType1" value="#{currentRow['amount']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextBenefitType1" value="Amount In Litter"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colEdit1">
                                                                <ice:selectBooleanCheckbox id="chkTake" partialSubmit="true" style="position: absolute" value="#{MilkBenefit$DeliverMilkToEmployee.selectBooleanCheckbox1Bean.selectedBoolean}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextEdit1" value="Delivered"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column1" rendered="false">
                                                                <ice:outputText id="outputText1" value="#{currentRow['benefitID']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText2" value="ID"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="column2">
                                                                <ice:outputText id="outputText3" value="#{currentRow['amountInCash']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText4" value="Amount In Cash"/>
                                                                </f:facet>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                </ice:panelGroup>
                                                <ice:panelLayout id="pnlLayoutButtons1" layout="flow"
                                                    style="height: 44px; margin-left: 15px; overflow: auto; width: 751px; top:600px; -rave-layout: grid" styleClass="insideContainerMain">
                                                    <ice:commandButton action="#{MilkBenefit$EmployeeMilkRegistraion.btnSave_action}" id="btnSave1"
                                                        style="left: 216px; top: -10px; position: absolute; width: 71px" value="#{msgsm.btnSave}"/>
                                                    <ice:commandButton action="#{MilkBenefit$EmployeeMilkRegistraion.btnReset_action}" id="btnReset1"
                                                        style="left: 384px; top: -10px; position: absolute; width: 70px" value="#{msgsm.btnReset}"/>
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
                                                style="margin-left:10px;color:white;font-weight:bold;font-family:Cambria">Copyright © 2002-2003 Ethiopian Calander | <a
                                                href="http://www.google.gov.et" style="text-decoration:none;color:orange">BUNNA INTERNATIONAL BANK |information system |Software Department.</a> |</label>
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
