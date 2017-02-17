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
            <f:loadBundle basename="Localization.HRLocalization_Milk" var="msgsm"/>
            <head id="outputHead1">
                <title>Employee Milk Benefit Registration</title>
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
            function BenefitTypePage(field){

                if (field.defaultValue == field.value) field.value = '';
                else if (field.value == '') field.value = field.defaultValue;

            }
        </script>
            </head>
            <body id="outputBody1">
                <ice:form id="form1">
                    <div style="width:100%">
                        <img alt="" class="source-image" id="img" src="../resources/images/WholePageBG.png" width="100%"/>
                        <ice:panelBorder id="whole_page" renderCenter="#{MilkBenefit$EmployeeMilkRegistraion.panelBorder1Bean.renderCenter}"
                            renderEast="#{MilkBenefit$EmployeeMilkRegistraion.panelBorder1Bean.renderEast}"
                            renderNorth="#{MilkBenefit$EmployeeMilkRegistraion.panelBorder1Bean.renderNorth}"
                            renderSouth="#{MilkBenefit$EmployeeMilkRegistraion.panelBorder1Bean.renderSouth}"
                            renderWest="#{MilkBenefit$EmployeeMilkRegistraion.panelBorder1Bean.renderWest}"
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
                                            <ice:panelCollapsible expanded="true" id="colsRequestLisrt" style="height: 500px">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup1" styleClass=""/>
                                                </f:facet>
                                                <ice:panelGrid id="panelGrid1" width="100%">
                                                    <ice:panelGroup id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:500px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="border-style: none; background-color: transparent; height: 21px; position: absolute; width: 214px; -rave-layout: grid"/>
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
                                        style="height: 885px; left: 0px; position: relative; top: 20px; width: 800px; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 885px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Employee Milk Benefit Registration"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 885px; left: 0px; top: 0px; position: absolute; width: 100%">
                                                <ice:panelGroup id="leaveRequest" style="height: 887px; width: 95%" styleClass="filedset_normal">
                                                    <ice:panelLayout id="pnlLayoutEmployee1" layout="flow" rendered="false"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 146px; margin-left: 15px; top: 50px; position: absolute; width: 751px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:outputLabel id="lblEmployeeDepartment1" style="left: 48px; top: 62px; position: absolute" value="#{msgsm.Department}"/>
                                                        <ice:outputLabel id="lblEmployeeId1" style="left: 432px; top: 24px; position: absolute" value="#{msgsm.Id}"/>
                                                        <ice:inputText binding="#{MilkBenefit$EmployeeMilkRegistraion.txtEmployeeDepartment}" disabled="true"
                                                            id="txtEmployeeDepartment" style="left: 166px; top: 60px; position: absolute; width: 503px"/>
                                                        <ice:inputText binding="#{MilkBenefit$EmployeeMilkRegistraion.txtEmployeeId}" disabled="true"
                                                            id="txtEmployeeId" immediate="true" partialSubmit="true" style="left: 526px; top: 22px; position: absolute; width: 148px"/>
                                                        <ice:outputLabel id="lblEmployeeFullName1" style="left: 48px; top: 24px; position: absolute" value="#{msgsm.FullName}"/>
                                                        <ice:outputLabel id="lblEmployeePosition1" style="left: 48px; top: 96px; position: absolute" value="#{msgsm.Position}"/>
                                                        <ice:selectInputText action="#{MilkBenefit$EmployeeMilkRegistraion.txtEmployeeFullName_action}"
                                                            binding="#{MilkBenefit$EmployeeMilkRegistraion.txtEmployeeFullName}" disabled="true"
                                                            id="txtEmployeeFullName" immediate="true" listValue="#{ApplicationBean1.list}"
                                                            listVar="employeeList" partialSubmit="true"
                                                            style="left: 166px; height: 30px; top: 22px; position: absolute"
                                                            valueChangeListener="#{ApplicationBean1.updateList}" width="200px">
                                                            <f:facet name="selectInputText">
                                                                <ice:panelGrid columnClasses="fullNameCol,empIdCol" columns="2">
                                                                    <ice:outputText id="lblFullNameAutoCompleteAccused" value="#{employeeList.fullName}"/>
                                                                    <ice:outputText id="lblEmployeeIdAutoCompleteAccused" value="#{employeeList.empIdentification}"/>
                                                                </ice:panelGrid>
                                                            </f:facet>
                                                        </ice:selectInputText>
                                                        <ice:inputText binding="#{MilkBenefit$EmployeeMilkRegistraion.txtEmployeePosition}" disabled="true"
                                                            id="txtEmployeePosition" style="left: 166px; top: 94px; position: absolute; width: 503px"/>
                                                        <ice:commandButton action="#{MilkBenefit$EmployeeMilkRegistraion.btnSearch_action}" id="btnSearch"
                                                            image="/resources/images/fig_search.gif" style="left: 648px; top: 24px; position: absolute"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutButtons1" layout="flow"
                                                        style="height: 44px; margin-left: 15px; top: 790px; overflow: auto; position: absolute; width: 751px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:commandButton action="#{MilkBenefit$EmployeeMilkRegistraion.btnSave_action}"
                                                            binding="#{MilkBenefit$EmployeeMilkRegistraion.btnSave}" id="btnSave"
                                                            style="left: 312px; top: -10px; position: absolute; width: 71px" value="#{msgsm.btnSave}"/>
                                                        <ice:commandButton action="#{MilkBenefit$EmployeeMilkRegistraion.btnReset_action}" id="btnReset"
                                                            style="left: 408px; top: -10px; position: absolute; width: 70px" value="#{msgsm.btnReset}"/>
                                                        <ice:commandButton action="#{MilkBenefit$EmployeeMilkRegistraion.btnNew_action}" id="btnNew"
                                                            style="left: 216px; top: -10px; position: absolute; width: 71px" value="#{msgsm.btnNew}"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutRequestInfo1" layout="flow"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 247px; margin-left: 15px; top: 50px; overflow: auto; position: absolute; width: 751px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:inputTextarea binding="#{MilkBenefit$EmployeeMilkRegistraion.txtRemark}" id="txtRemark"
                                                            style="left: 142px; top: 94px; position: absolute; width: 311px" valueChangeListener="#{MilkBenefit$EmployeeMilkRegistraion.txtRemark_processValueChange}"/>
                                                        <ice:outputLabel id="lblDescription1" style="left: 48px; top: 120px; position: absolute" value="#{msgsm.Remark}"/>
                                                        <ice:outputLabel id="lblPaidSlary1" rendered="false" style="left: 408px; top: 120px; position: absolute" value="Penality Payment"/>
                                                        <ice:commandButton action="#{Termination$TerminationRequestPage.btnCalculatePenality_action}"
                                                            id="btnCalculatePenality1" rendered="false"
                                                            style="left: 168px; top: 162px; position: absolute; width: 191px" value="Claculate Penality Payment"/>
                                                        <ice:inputText disabled="true" id="txtPenality1" rendered="false" style="left: 526px; top: 118px; position: absolute"/>
                                                        <ice:selectBooleanCheckbox id="chksuccesisor1" partialSubmit="true" rendered="false"
                                                            style="position: absolute; left: 96px; top: 24px"
                                                            value="#{Termination$TerminationRequestPage.selectBooleanCheckbox1Bean.selectedBoolean}" valueChangeListener="#{MilkBenefit$EmployeeMilkRegistraion.chksuccesisor_processValueChange}"/>
                                                        <ice:outputLabel id="lblSuccesior1" rendered="false" style="left: 144px; top: 24px; position: absolute" value="Does the Terminator has a Succesiosor?"/>
                                                        <ice:commandButton action="#{MilkBenefit$EmployeeMilkRegistraion.btnAddtoTable_action}"
                                                            binding="#{MilkBenefit$EmployeeMilkRegistraion.btnAddtoTable}" disabled="true" id="btnAddtoTable"
                                                            rendered="false" style="left: 504px; top: 14px; position: absolute; width: 143px" value="#{msgsm.btnAdd}"/>
                                                        <ice:inputText action="#{MilkBenefit$EmployeeMilkRegistraion.txtDepartment_action}"
                                                            binding="#{MilkBenefit$EmployeeMilkRegistraion.txtDepartment}" disabled="true" id="txtDepartment" style="left: 142px; top: 46px; position: absolute; width: 434px"/>
                                                        <ice:commandButton action="#{MilkBenefit$EmployeeMilkRegistraion.btnDepartmentTree1_action}"
                                                            id="btnDepartmentTree1" image="/Employee/images/pic3-tree-icon.jpg"
                                                            style="left: 576px; top: 48px; position: absolute" value="Tree"/>
                                                        <ice:outputLabel id="lblEmployeeDepartment2" style="left: 48px; top: 48px; position: absolute" value="#{msgsm.Department}"/>
                                                        <ice:commandButton action="#{MilkBenefit$EmployeeMilkRegistraion.btnAdd_action}" id="btnAdd"
                                                            style="left: 168px; top: 182px; position: absolute" value="Search All Employees"/>
                                                        <ice:commandButton action="#{MilkBenefit$EmployeeMilkRegistraion.btnSearchRegistered_action}"
                                                            binding="#{MilkBenefit$EmployeeMilkRegistraion.btnSearchRegistered}" id="btnSearchRegistered"
                                                            style="height: 23px; left: 336px; top: 182px; position: absolute; width: 191px" value="Search Registered Employee"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout binding="#{MilkBenefit$EmployeeMilkRegistraion.pnlLayoutTree}" id="pnlLayoutTree"
                                                        layout="flow" rendered="false"
                                                        style="border-width: 2px; border-style: solid; height: 356px; left: 11px; top: 78px; overflow: scroll; position: absolute; width: 368px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:tree binding="#{MilkBenefit$EmployeeMilkRegistraion.tree}" id="tree"
                                                            style="height: 356px; margin-left: 0px; margin-top: 0px; left: 0px; top: 0px; position: absolute; text-align: left; width: 356px"
                                                            value="#{MilkBenefit$EmployeeMilkRegistraion.treeModel.model}" var="item">
                                                            <ice:treeNode binding="#{MilkBenefit$EmployeeMilkRegistraion.treeNode2}" id="treeNode2">
                                                                <f:facet name="icon">
                                                                    <ice:panelGroup binding="#{MilkBenefit$EmployeeMilkRegistraion.panelGroup1}"
                                                                        id="panelGroup1" style="display: inline;">
                                                                        <ice:graphicImage binding="#{MilkBenefit$EmployeeMilkRegistraion.graphicImage2}"
                                                                            id="graphicImage2" value="#{item.userObject.icon}"/>
                                                                    </ice:panelGroup>
                                                                </f:facet>
                                                                <f:facet name="content">
                                                                    <ice:panelGroup binding="#{MilkBenefit$EmployeeMilkRegistraion.panelGroup2}"
                                                                        id="panelGroup2" style="display: inline;">
                                                                        <ice:commandLink
                                                                            actionListener="#{MilkBenefit$EmployeeMilkRegistraion.cmdLnkTree_processAction}"
                                                                            binding="#{MilkBenefit$EmployeeMilkRegistraion.cmdLnkTree}" id="cmdLnkTree" partialSubmit="true">
                                                                            <ice:outputText binding="#{MilkBenefit$EmployeeMilkRegistraion.outputText1}"
                                                                                id="outputText1" value="#{item.userObject.text}"/>
                                                                        </ice:commandLink>
                                                                    </ice:panelGroup>
                                                                </f:facet>
                                                            </ice:treeNode>
                                                        </ice:tree>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutDataTable1" layout="flow"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 356px; margin-left: 15px; top: 300px; overflow: auto; position: absolute; width: 751px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:dataTable id="dataTableEmployeeList"
                                                            style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                                            value="#{MilkBenefit$EmployeeMilkRegistraion.employeeList}" var="currentRow">
                                                            <ice:column id="colEmpId">
                                                                <ice:outputText id="txtPopupForColumnBenefitName1" value="#{currentRow['empId']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextPopupBenefitName1" value="EmpID"/>
                                                                </f:facet>
                                                                <ice:rowSelector id="rowSelector1"
                                                                    selectionListener="#{MilkBenefit$EmployeeMilkRegistraion.rowSelector1_processAction}" value="#{currentRow['rendered']}"/>
                                                            </ice:column>
                                                            <ice:column id="colPopupDisciplineTypeCode2">
                                                                <ice:outputText id="txtPopupForColumnBenefitType2" value="#{currentRow['fullName']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextBenefitType2" value="Full Name"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colPopupDescription1" style="width: 100px">
                                                                <ice:inputText id="txtPopupForColumnDescription1" value="#{currentRow['remark']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextPopupDescription1" value="Remark"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colEdit1">
                                                                <ice:commandLink action="#{MilkBenefit$EmployeeMilkRegistraion.cmdLnkEdit1_action}"
                                                                    id="cmdLnkEdit1" value="Ok"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextEdit1" value="Edit"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colRemove1">
                                                                <ice:commandLink action="#{MilkBenefit$EmployeeMilkRegistraion.cmdLnkRemove1_action}"
                                                                    id="cmdLnkRemove1" value="Remove"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextRemove1" value="Remove"/>
                                                                </f:facet>
                                                            </ice:column>
                                                        </ice:dataTable>
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
                                                style="margin-left:10px;color:white;font-weight:bold;font-family:Cambria">Copyright © 2005-2006 Ethiopian Calander | <a
                                                href="http://www.google.gov.et" style="text-decoration:none;color:orange">BUNNA INTERNATIONAL BANK |informaionSystem |Software Department.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{MilkBenefit$EmployeeMilkRegistraion.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup binding="#{MilkBenefit$EmployeeMilkRegistraion.pnlgridpnMessage}" id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText binding="#{MilkBenefit$EmployeeMilkRegistraion.pnMessageTitle}" id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{MilkBenefit$EmployeeMilkRegistraion.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{MilkBenefit$EmployeeMilkRegistraion.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{MilkBenefit$EmployeeMilkRegistraion.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
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
