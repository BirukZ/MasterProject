<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : PageAdmin
    Created on : Jan 14, 2010, 9:36:49 AM
    Author     : BravoZulu
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
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
                </style>
                <script language="javascript" type="text/javascript">
                    var $j=jQuery.noConflict();
                    function OrganizationPage(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <f:loadBundle basename="Localization.HRLocalization_msg" var="msg_validation"/>
                <ice:form id="form1">
                    <div>
                        <img alt="" class="source-image" height="610px" id="img" src="../resources/images/WholePageBG.png"/>
                        <ice:panelBorder height="480" id="whole_page" renderCenter="#{pageSecurity$PageAdmin.panelBorder1Bean.renderCenter}"
                            renderEast="#{pageSecurity$PageAdmin.panelBorder1Bean.renderEast}"
                            renderNorth="#{pageSecurity$PageAdmin.panelBorder1Bean.renderNorth}"
                            renderSouth="#{pageSecurity$PageAdmin.panelBorder1Bean.renderSouth}"
                            renderWest="#{pageSecurity$PageAdmin.panelBorder1Bean.renderWest}" style="top: 0px; position: relative" styleClass="whole_page" width="1024">
                            <f:facet name="north">
                                <ice:panelGroup dragListener="#{Page1.panelBorder1north_processMyEvent}" id="page_header" style="height: 100px">
                                    <!-- Begin Header -->
                                    <ice:panelLayout id="header" layout="flow"
                                        style="background-image: url(images/Mugher_HEADER_1.png); height: 100px; left: 0px; position: relative; width: 1024px; -rave-layout: grid"
                                        styleClass="header" visible="true">
                                        <ice:commandLink action="#{pageSecurity$PageAdmin.lnkLogOut_action}" id="lnkLogOut" partialSubmit="true"
                                            style="left: 828px; top: 15px; position: absolute" value="Log Out"/>
                                        <ice:commandLink id="lnkAccountSetting" partialSubmit="true" style="left: 915px; top: 15px; position: absolute" value="Accout Setting"/>
                                        <ice:commandLink id="lnkEN" partialSubmit="true" style="left: 797px; top: 15px; position: absolute" value="EN"/>
                                        <ice:commandLink id="lnkAM" partialSubmit="true" style="left: 762px; top: 15px; position: absolute" value="AM"/>
                                        <ice:commandLink action="#{pageSecurity$PageAdmin.lnkHome_action}" id="lnkHome" partialSubmit="true"
                                            style="left: 1010px; top: 15px; position: absolute" value="Home"/>
                                        <ice:outputLabel id="outputLabel5" style="left: 788px; top: 12px; position: absolute" value="|"/>
                                        <ice:outputLabel id="outputLabel6" style="left: 820px; top: 12px; position: absolute" value="|"/>
                                        <ice:outputLabel id="outputLabel7" style="left: 884px; top: 12px; position: absolute" value="|"/>
                                        <ice:outputLabel id="outputLabel13" style="left: 1008px; top: 20px; position: absolute" value="|"/>
                                        <ice:commandLink action="#{pageSecurity$PageAdmin.commandLink1_action}" id="commandLink1" immediate="true"
                                            partialSubmit="true" style="position: absolute; left: 672px; top: 72px" value="Available User"/>
                                    </ice:panelLayout>
                                    <!-- End Header -->
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height: 439px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 450px; left: 0px; top: -10px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <ice:panelLayout binding="#{pageSecurity$PageAdmin.pnlMessage}" id="pnlMessage"
                                            style="left: 600px; top: 1px; position: absolute; width: 350px" styleClass="message">
                                            <ice:outputLabel binding="#{pageSecurity$PageAdmin.lblFormMessage}" id="lblFormMessage" style="color: #336600; font-size: 11px; font-weight: bold;text-align: center; vertical-align: middle;width: 350px"/>
                                        </ice:panelLayout>
                                        <ice:panelTabSet binding="#{pageSecurity$PageAdmin.ptsManageResources}" id="ptsManageResources" immediate="true"
                                            keyboardNavigationEnabled="true" style="position: absolute;height: 350px; left: 0px; top: 10px;"
                                            tabChangeListener="#{pageSecurity$PageAdmin.ptsManageResources_processTabChange}" tabPlacement="Top">
                                            <ice:panelTab id="tabManageResources" label="Manage Resource" style="font-size: 11px">
                                                <ice:panelLayout id="pnlManageResource"
                                                    style="height: 320px; left: 100px; top: 0px; position: relative; width: 700px" styleClass="filedset_border">
                                                    <ice:panelLayout id="panelLayout12" layout="flow"
                                                            style="height: 331px; position: absolute; width: 814px; -rave-layout: grid">k
                                                        <fieldset
                                                            class="filedset_css" style="width:700px;height: 310px;">
                                                            <legend class="legend_css">
                                                                <ice:outputLabel value="Manage HoPR Resources"/>
                                                            </legend>
                                                            <ice:outputLabel id="outputLabel8"
                                                                style="font-size: 11px; height: 18px; left: 24px; top: 24px; position: absolute" title="Name" value="Name"/>
                                                            <ice:outputLabel id="outputLabel9"
                                                                style="font-size: 11px; height: 18px; left: 24px; top: 120px; position: absolute" value="Description"/>
                                                            <ice:outputLabel id="outputLabel10"
                                                                style="font-size: 11px; height: 18px; left: 24px; top: 72px; position: absolute" value="Resource"/>
                                                            <ice:inputText binding="#{pageSecurity$PageAdmin.txtResourceName}" id="txtResourceName"
                                                                required="true"
                                                                style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 120px; top: 24px; position: absolute; width: 309px" validator="#{pageSecurity$PageAdmin.txtResourceName_validate}"/>
                                                            <ice:selectOneMenu binding="#{pageSecurity$PageAdmin.lstResourcesAvailable}"
                                                                id="lstResourcesAvailable" partialSubmit="true" style="left: 262px; top: 70px; position: absolute;visibility: hidden;">
                                                                <f:selectItems id="selectOneMenu2selectItems2" value="#{pageSecurity$PageAdmin.lstResourcesAvailable1DefaultItems}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:commandButton action="#{pageSecurity$PageAdmin.btnAddResource1_action}" id="btnAddResource1"
                                                                style="font-size: 11px; left: 120px; top: 216px; position: absolute" value="Add Resource"/>
                                                            <ice:inputTextarea binding="#{pageSecurity$PageAdmin.txtResourceDescription}"
                                                                id="txtResourceDescription" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter;left: 118px; top: 118px; position: absolute; width: 309px"/>
                                                            <ice:selectOneMenu binding="#{pageSecurity$PageAdmin.dpResourcesAvailable}"
                                                                id="dpResourcesAvailable" partialSubmit="true" required="true"
                                                                style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 120px; top: 71px; position: absolute; width: 309px"
                                                                value="#{pageSecurity$PageAdmin.defaultSelectedData14.selectedObject}" valueChangeListener="#{pageSecurity$PageAdmin.dpResourcesAvailable_processValueChange}">
                                                                <f:selectItems id="selectOneMenu1selectItems1" value="#{pageSecurity$PageAdmin.availableResourcesFromFile}"/>
                                                            </ice:selectOneMenu>
                                                        </fieldset>
                                                        <ice:message errorClass="iceMsgError iceMsgError errorMessage"
                                                            fatalClass="iceMsgFatal iceMsgFatal fatalMessage" for="txtResourceName" id="msgFortxtResourceName"
                                                            infoClass="iceMsgInfo iceMsgInfo infoMessage"
                                                            style="font-size: 11px; font-style: normal; margin-left: 320px; margin-top: 79px; left: 112px; top: -7px; position: absolute; width: 159px"
                                                            tooltip="true" warnClass="iceMsgWarn iceMsgWarn warnMessage"/>
                                                        <ice:message errorClass="iceMsgError iceMsgError iceMsgError errorMessage"
                                                            fatalClass="iceMsgFatal iceMsgFatal iceMsgFatal fatalMessage" for="dpResourcesAvailable"
                                                            id="msgFortxtResourcePath" infoClass="iceMsgInfo iceMsgInfo iceMsgInfo infoMessage"
                                                            style="font-size: 11px; font-style: normal; margin-left: 320px; margin-top: 79px; left: 112px; top: 41px; position: absolute; width: 201px"
                                                            tooltip="true" warnClass="iceMsgWarn iceMsgWarn iceMsgWarn warnMessage"/>
                                                    </ice:panelLayout>
                                                </ice:panelLayout>
                                            </ice:panelTab>
                                            <ice:panelTab id="tabManageRoles1" label="Manage Role">
                                                <fieldset class="filedset_css" style="width:340px;height: 310px;top:50px;left:20px;position: absolute;">
                                                    <legend class="legend_css">
                                                        <ice:outputLabel value="Add New Role"/>
                                                    </legend>
                                                    <ice:panelLayout id="pnlManageRole"
                                                        style="float: left; height: 230px; left: 0px; top: -10px; position: relative; width: 340px" styleClass="filedset_border">
                                                        <ice:outputLabel id="outputLabel11" style="font-size: 11px; left: 20px; top: 24px; position: absolute" value="Role Name"/>
                                                        <ice:outputLabel id="outputLabel12"
                                                            style="font-size: 11px; height: 22px; left: 20px; top: 72px; position: absolute" value="Description"/>
                                                        <ice:inputText binding="#{pageSecurity$PageAdmin.txtRoleName}" id="txtRoleName" required="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter;left: 94px; top: 22px; position: absolute"/>
                                                        <ice:commandButton action="#{pageSecurity$PageAdmin.btnAddRole_action}"
                                                            binding="#{pageSecurity$PageAdmin.btnAddRole}" id="btnAddRole"
                                                            style="font-size: 11px; left: 100px; top: 150px; position: absolute" value="AddRole"/>
                                                        <ice:inputTextarea binding="#{pageSecurity$PageAdmin.txtRoleDescription}" id="txtRoleDescription" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter;left: 94px; top: 70px; position: absolute; width: 229px"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtRoleName" id="msgForRoleName"
                                                            infoClass="infoMessage"
                                                            style="font-size: 11px; left: 270px; top: 85px; position: absolute; width: 80px" warnClass="warnMessage"/>
                                                    </ice:panelLayout>
                                                </fieldset>
                                                <fieldset class="filedset_css" style="width:565px;height: 310px;top:50px;left:420px;position: absolute;">
                                                    <legend class="legend_css">
                                                        <ice:outputLabel value="Assign Role To Resources"/>
                                                    </legend>
                                                    <ice:panelLayout id="pnlManageRole1"
                                                        style="float: right;height: 310px; margin-left: 0px; left: 0px; top: 10px; position: relative; width: 550px" styleClass="filedset_border">
                                                        <ice:selectOneMenu binding="#{pageSecurity$PageAdmin.dpdAvailableRoles}" id="dpdAvailableRoles"
                                                            partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 360px; top: -45px; position: absolute; width: 203px"
                                                            value="#{pageSecurity$PageAdmin.selectOneMenu3Bean.selectedObject}" valueChangeListener="#{pageSecurity$PageAdmin.dpdAvailableRoles_processValueChange}">
                                                            <f:selectItems id="selectOneMenu3selectItems" value="#{pageSecurity$PageAdmin.availableRoles}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:panelLayout id="panelLayout16" style="border: 1px solid rgb(204, 204, 204); height: 203px; left: 24px; top: 0px; overflow: auto; position: absolute; width: 200px">
                                                            <ice:dataTable clientOnly="true" id="dataTable5" sortAscending="true"
                                                                value="#{SessionBean1.avilableRoleResource}" var="currentRow" width="200">
                                                                <ice:column id="column5" style="width: 191px">
                                                                    <ice:outputText id="outputText9" value="#{currentRow['description']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText10" value="Avilable Resources"/>
                                                                    </f:facet>
                                                                    <ice:rowSelector id="rowSelector5" multiple="true"
                                                                        selectionListener="#{pageSecurity$PageAdmin.rowSelector1_processAction}" value="#{currentRow['selected']}"/>
                                                                </ice:column>
                                                            </ice:dataTable>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="panelLayout17" style="border: 1px solid rgb(204, 204, 204); height: 203px; left: 350px; top: 0px; overflow: auto; position: absolute; width: 200px">
                                                            <ice:dataTable id="dataTable6" value="#{SessionBean1.selectedRoleResource}" var="currentRow" width="200">
                                                                <ice:column id="column6" style="width: 263px">
                                                                    <ice:outputText id="outputText11" value="#{currentRow['description']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText12" value="Assigned Roles"/>
                                                                    </f:facet>
                                                                    <ice:rowSelector id="rowSelector6" multiple="true"
                                                                        selectionListener="#{pageSecurity$PageAdmin.rowSelector2_processAction}" value="#{currentRow['selected']}"/>
                                                                </ice:column>
                                                            </ice:dataTable>
                                                        </ice:panelLayout>
                                                        <ice:commandButton action="#{pageSecurity$PageAdmin.btnAddManageRole_action}"
                                                            actionListener="#{pageSecurity$PageAdmin.btnAddManageRole_processAction}" id="btnAddManageRole"
                                                            immediate="true" partialSubmit="true"
                                                            style="font-size: 11px; left: 250px; top: 50px; position: absolute; width: 80px" value="Add &gt;"/>
                                                        <ice:commandButton action="#{pageSecurity$PageAdmin.btnRemoveManageRole_action}"
                                                            actionListener="#{pageSecurity$PageAdmin.btnRemoveManageRole_processAction}"
                                                            id="btnRemoveManageRole" immediate="true" partialSubmit="true"
                                                            style="font-size: 11px; left: 250px; top: 96px; position: absolute; width: 80px" value="Remove &lt;"/>
                                                        <ice:commandButton action="#{pageSecurity$PageAdmin.btnAddAllMangeRole_action}" id="btnAddAllMangeRole"
                                                            immediate="true" partialSubmit="true"
                                                            style="font-size: 11px; left: 250px; top: 131px; position: absolute; width: 80px" value="Add All&gt;&gt;"/>
                                                        <ice:commandButton action="#{pageSecurity$PageAdmin.btnRemoveAllManageRole_action}"
                                                            id="btnRemoveAllManageRole" immediate="true" partialSubmit="true"
                                                            style="font-size: 11px; left: 250px; top: 166px; position: absolute; width: 97px" value="&lt;&lt;Remove All"/>
                                                        <ice:commandButton action="#{pageSecurity$PageAdmin.btnSave_action}" id="btnSave" immediate="true"
                                                            partialSubmit="true"
                                                            style="font-size: 11px; left: 200px; top: 200px; position: absolute; width: 100px" value="Save"/>
                                                        <ice:commandButton action="#{pageSecurity$PageAdmin.button2_action}"
                                                            actionListener="#{pageSecurity$PageAdmin.button2_processAction}" id="button2" immediate="true"
                                                            partialSubmit="true"
                                                            style="font-size: 11px; left: 350px; top: 200px; position: absolute; width: 100px" value="Delete"/>
                                                        <ice:outputLabel id="outputLabel4" style="font-size: 11px; left: 270px; top: -40px; position: absolute" value="Select role  :"/>
                                                    </ice:panelLayout>
                                                </fieldset>
                                            </ice:panelTab>
                                            <ice:panelTab id="tabManageUser1" label="Manage User">
                                                <ice:panelLayout id="pnlManageUser1"
                                                    style="float: right; height: 320px; margin-left: 0px; left: 0px; top: 5px; position: relative; width: 565px" styleClass="filedset_border">
                                                    <fieldset class="filedset_css" style="width:565px;height: 310px;">
                                                        <legend class="legend_css">
                                                            <ice:outputLabel value="Assign User To Roles"/>
                                                        </legend>
                                                        <ice:panelLayout id="pnlManageUserinsider2" style="float: right; height: 320px; margin-left: 0px; left: 0px; top: 0px; position: relative; width: 565px">
                                                            <ice:selectOneMenu binding="#{pageSecurity$PageAdmin.cmbAvailableRoles1}" id="cmbAvailableRoles1"
                                                                immediate="true" partialSubmit="true"
                                                                style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter;left: 360px; top: -55px; position: absolute; width: 202px"
                                                                value="#{pageSecurity$PageAdmin.selectOneMenu2Bean.selectedObject}" valueChangeListener="#{pageSecurity$PageAdmin.cmbAvailableRoles1_processValueChange}">
                                                                <f:selectItems id="selectOneMenu2selectItems" value="#{pageSecurity$PageAdmin.availableUsers}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:commandButton action="#{pageSecurity$PageAdmin.btnUpdate_action}" id="btnUpdate"
                                                                immediate="true" style="left: 300px; top: 225px; position: absolute" value="Update"/>
                                                            <ice:commandButton action="#{pageSecurity$PageAdmin.btnDelete_action}" id="btnDelete"
                                                                immediate="true" style="left: 200px; top: 225px; position: absolute" value="Delete"/>
                                                            <ice:panelLayout id="panelLayout14" style="border: 1px solid rgb(204, 204, 204); height: 215px; left: 24px; top: 10px; overflow: auto; position: absolute; width: 200px">
                                                                <ice:dataTable clientOnly="true" id="dataTable3" sortAscending="true"
                                                                    value="#{SessionBean1.avilableUserRole}" var="currentRow" width="200">
                                                                    <ice:column id="column3" style="width: 100px">
                                                                        <ice:outputText id="outputText5" value="#{currentRow['name']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="outputText6" value="Avilable Roles"/>
                                                                        </f:facet>
                                                                        <ice:rowSelector id="rowSelector3" multiple="true"
                                                                            selectionListener="#{pageSecurity$PageAdmin.rowSelector1_processAction}" value="#{currentRow['selected']}"/>
                                                                    </ice:column>
                                                                </ice:dataTable>
                                                            </ice:panelLayout>
                                                            <ice:panelLayout id="panelLayout15" style="border: 1px solid rgb(204, 204, 204); height: 217px; left: 350px; top: 10px; overflow: auto; position: absolute; width: 200px">
                                                                <ice:dataTable clientOnly="true" id="dataTable4" value="#{SessionBean1.selectedUserRole}"
                                                                    var="currentRow" width="200">
                                                                    <ice:column id="column4" style="width: 100px">
                                                                        <ice:outputText id="outputText7" value="#{currentRow['name']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="outputText8" value="Assigned Roles"/>
                                                                        </f:facet>
                                                                        <ice:rowSelector id="rowSelector4" multiple="true"
                                                                            selectionListener="#{pageSecurity$PageAdmin.rowSelector2_processAction}" value="#{currentRow['selected']}"/>
                                                                    </ice:column>
                                                                </ice:dataTable>
                                                            </ice:panelLayout>
                                                            <ice:commandButton action="#{pageSecurity$PageAdmin.btnAddUserPermission_action}"
                                                                id="btnAddUserPermission" immediate="true" partialSubmit="true"
                                                                style="left: 240px; top: 32px; position: absolute; width: 97px" value="Add &gt;"/>
                                                            <ice:commandButton action="#{pageSecurity$PageAdmin.btnRemoveUserPermission_action}"
                                                                id="btnRemoveUserPermission" immediate="true" partialSubmit="true"
                                                                style="left: 240px; top: 66px; position: absolute; width: 97px" value="Remove &lt;"/>
                                                            <ice:commandButton action="#{pageSecurity$PageAdmin.btnAddAllUserPermission_action}"
                                                                id="btnAddAllUserPermission" immediate="true" partialSubmit="true"
                                                                style="left: 240px; top: 128px; position: absolute; width: 97px" value="Add All&gt;&gt;"/>
                                                            <ice:commandButton action="#{pageSecurity$PageAdmin.btnRemoveAllUserPermission_action}"
                                                                id="btnRemoveAllUserPermission" partialSubmit="true"
                                                                style="left: 240px; top: 162px; position: absolute; width: 97px" value="&lt;&lt;Remove All"/>
                                                            <ice:outputLabel id="outputLabel1"
                                                                style="font-size: 11px; left: 210px; top: -50px; position: absolute" value="Select user to assign role :"/>
                                                        </ice:panelLayout>
                                                    </fieldset>
                                                </ice:panelLayout>
                                                <ice:panelLayout id="pnlManageUsers"
                                                    style="float: left; height: 320px; left: 0px; top: 5px; position: relative; width: 340px" styleClass="filedset_border">
                                                    <fieldset class="filedset_css" style="width:340px;height: 310px;">
                                                        <legend class="legend_css">
                                                            <ice:outputLabel value="Manage Employee Accounts"/>
                                                        </legend>
                                                        <ice:panelLayout id="pnlManageUsersInside" style="float: left; height: 320px; left: 0px; top: 5px; position: relative; width: 340px">
                                                            <ice:outputLabel id="lblEmployeeName"
                                                                style="font-size: 11px; left: 10px; top: 15px; position: absolute" value="Employee"/>
                                                            <ice:outputLabel id="lblPassword" style="font-size: 11px; left: 10px; top: 75px; position: absolute" value="Password"/>
                                                            <ice:outputLabel id="lblConfirmPassword"
                                                                style="font-size: 11px; left: 10px; top: 102px; position: absolute" value="Re-Password"/>
                                                            <ice:selectOneMenu binding="#{pageSecurity$PageAdmin.dpdEmployee}" id="dpdEmployee"
                                                                partialSubmit="true" required="true"
                                                                style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter;left: 90px; top: 10px; position: absolute; width: 179px"
                                                                value="#{pageSecurity$PageAdmin.selectOneMenu1Bean.selectedObject}" valueChangeListener="#{pageSecurity$PageAdmin.dpdEmployee_processValueChange}">
                                                                <f:selectItems id="selectOneMenu1selectItems" value="#{pageSecurity$PageAdmin.employees}"/>
                                                                <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="dpdEmployee" id="message1"
                                                                    infoClass="infoMessage"
                                                                    style="font-size: 11px; left: 280px; top: 15px; position: absolute; width: 86px" warnClass="warnMessage"/>
                                                            </ice:selectOneMenu>
                                                            <ice:inputText binding="#{pageSecurity$PageAdmin.txtUserName}" id="txtUserName" required="true"
                                                                style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter;left: 90px; top: 40px; position: absolute; width: 180px" validator="#{pageSecurity$PageAdmin.txtUserName_validate}">
                                                                <f:validateLength maximum="25" minimum="4"/>
                                                            </ice:inputText>
                                                            <ice:inputSecret binding="#{pageSecurity$PageAdmin.txtPassword}" id="txtPassword" required="true"
                                                                style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter;left: 90px; top: 70px; position: absolute" validator="#{pageSecurity$PageAdmin.txtPassword_validate}"/>
                                                            <ice:inputSecret binding="#{pageSecurity$PageAdmin.txtConfirmPassword}" id="txtConfirmPassword"
                                                                required="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter;left: 90px; top: 100px; position: absolute"/>
                                                            <ice:commandButton action="#{pageSecurity$PageAdmin.btnAddUser_action}" id="btnAddUser"
                                                                style="left: 250px; top: 130px; position: absolute" value="Add User"/>
                                                            <ice:outputLabel id="outputLabel2"
                                                                style="font-size: 11px; left: 10px; top: 46px; position: absolute" value="User Name"/>
                                                        </ice:panelLayout>
                                                    </fieldset>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtUserName" id="message2"
                                                        infoClass="infoMessage"
                                                        style="font-size: 11px; left: 280px; top: 100px; position: absolute; width: 86px" warnClass="warnMessage"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtPassword" id="message3"
                                                        infoClass="infoMessage"
                                                        style="font-size: 11px; left: 280px; top: 130px; position: absolute; width: 86px" warnClass="warnMessage"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtConfirmPassword" id="message4"
                                                        infoClass="infoMessage"
                                                        style="font-size: 11px; left: 280px; top: 160px; position: absolute; width: 85px" warnClass="warnMessage"/>
                                                </ice:panelLayout>
                                            </ice:panelTab>
                                            <ice:panelTab id="tabManagePermission1" label="Manage Permission">
                                                <ice:panelLayout id="pnlManagePermissions1"
                                                    style="float: right; height: 320px; margin-left: 0px; left: 0px; top: 5px; position: relative; width: 565px" styleClass="filedset_border">
                                                    <fieldset class="filedset_css" style="width:565px;height: 310px;">
                                                        <legend class="legend_css">
                                                            <ice:outputLabel value="Assign Permission To Role"/>
                                                        </legend>
                                                        <ice:panelLayout id="pnlManagePermissionsInside" style="float: left; height: 320px; left: 0px; top: 0px; position: relative; width: 340px">
                                                            <ice:commandButton action="#{pageSecurity$PageAdmin.btnAddAvilablePermission_action}"
                                                                binding="#{pageSecurity$PageAdmin.btnAddAvilablePermission}" id="btnAddAvilablePermission"
                                                                immediate="true" partialSubmit="true"
                                                                style="font-size: 11px; left: 240px; top: 56px; position: absolute; width: 97px" value="Add &gt;"/>
                                                            <ice:commandButton action="#{pageSecurity$PageAdmin.btnRemoveAvilablePermission_action}"
                                                                binding="#{pageSecurity$PageAdmin.btnRemoveAvilablePermission}" id="btnRemoveAvilablePermission"
                                                                immediate="true" partialSubmit="true"
                                                                style="font-size: 11px; left: 240px; top: 90px; position: absolute; width: 97px" value="Remove &lt;"/>
                                                            <ice:selectOneMenu binding="#{pageSecurity$PageAdmin.cmbAvailableRoles2}" id="cmbAvailableRoles2"
                                                                partialSubmit="true"
                                                                style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter;left: 20px; top: 0px; position: absolute; width: 199px"
                                                                value="#{pageSecurity$PageAdmin.selectOneMenu3Bean.selectedObject}" valueChangeListener="#{pageSecurity$PageAdmin.cmbAvailableRoles2_processValueChange}">
                                                                <f:selectItems id="selectOneMenu3selectItems1" value="#{pageSecurity$PageAdmin.availableRoles}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:selectOneMenu binding="#{pageSecurity$PageAdmin.cmbAvailableTask}" id="cmbAvailableTask"
                                                                partialSubmit="true"
                                                                style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter;left: 350px; top: 0px; position: absolute; width: 202px"
                                                                value="#{pageSecurity$PageAdmin.selectOneMenu5Bean.selectedObject}" valueChangeListener="#{pageSecurity$PageAdmin.cmbAvailableTask_processValueChange}">
                                                                <f:selectItems id="selectOneMenu5selectItems" value="#{pageSecurity$PageAdmin.assignedTask}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:outputLabel id="lblAssigned_Resource"
                                                                style="font-size: 11px; left: 350px; top: -20px; position: absolute; width: 130px" value="Assigned Resource"/>
                                                            <ice:commandButton action="#{pageSecurity$PageAdmin.btnUpdatePermission_action}"
                                                                actionListener="#{pageSecurity$PageAdmin.btnUpdatePermission_processAction}"
                                                                id="btnUpdatePermission" immediate="true" style="left: 450px; top: 220px; position: absolute" value="Save"/>
                                                            <ice:panelLayout id="panelLayout9" style="border: 1px solid rgb(204, 204, 204); height: 190px; left: 350px; top: 32px; overflow: auto; position: absolute; width: 200px">
                                                                <ice:dataTable binding="#{pageSecurity$PageAdmin.dataTable2}" clientOnly="true" id="dataTable2"
                                                                    value="#{SessionBean1.selectedPermission}" var="currentRow" width="200">
                                                                    <ice:column id="column2" style="width: 263px">
                                                                        <ice:outputText id="outputText3" value="#{currentRow['description']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="outputText4" value="Assigned Permissions"/>
                                                                        </f:facet>
                                                                        <ice:rowSelector id="rowSelector2" multiple="true"
                                                                            selectionListener="#{pageSecurity$PageAdmin.rowSelector2_processAction}" value="#{currentRow['selected']}"/>
                                                                    </ice:column>
                                                                </ice:dataTable>
                                                            </ice:panelLayout>
                                                            <ice:panelLayout id="panelLayout10" style="border: 1px solid rgb(204, 204, 204); height: 194px; left: 24px; top: 32px; overflow: auto; position: absolute; width: 200px">
                                                                <ice:dataTable binding="#{pageSecurity$PageAdmin.dataTable1}" clientOnly="true" id="dataTable1"
                                                                    sortAscending="true" value="#{SessionBean1.avilablePermission}" var="currentRow" width="200">
                                                                    <ice:column id="column1" style="width: 191px">
                                                                        <ice:outputText id="outputText1" value="#{currentRow['description']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="outputText2" value="Avilable Permissions"/>
                                                                        </f:facet>
                                                                        <ice:rowSelector binding="#{pageSecurity$PageAdmin.rowSelector1}" id="rowSelector1"
                                                                            multiple="true"
                                                                            selectionListener="#{pageSecurity$PageAdmin.rowSelector1_processAction}" value="#{currentRow['selected']}"/>
                                                                    </ice:column>
                                                                </ice:dataTable>
                                                            </ice:panelLayout>
                                                            <ice:commandButton action="#{pageSecurity$PageAdmin.btnAddAll_action}"
                                                                binding="#{pageSecurity$PageAdmin.btnAddAll}" id="btnAddAll" immediate="true"
                                                                partialSubmit="true" style="left: 240px; top: 152px; position: absolute; width: 97px" value="Add All&gt;&gt;"/>
                                                            <ice:commandButton action="#{pageSecurity$PageAdmin.btnRemoveAll_action}"
                                                                binding="#{pageSecurity$PageAdmin.btnRemoveAll}" id="btnRemoveAll" immediate="true"
                                                                partialSubmit="true"
                                                                style="font-size: 11px; left: 240px; top: 186px; position: absolute; width: 97px" value="&lt;&lt;Remove All"/>
                                                            <ice:outputLabel id="outputLabel3"
                                                                style="font-size: 11px; left: 24px; top: -20px; position: absolute" value="Available Roles"/>
                                                        </ice:panelLayout>
                                                    </fieldset>
                                                </ice:panelLayout>
                                                <ice:panelLayout id="pnlManagePermissions"
                                                    style="float: left; height: 320px; left: 0px; top: 5px; position: relative; width: 340px" styleClass="filedset_border">
                                                    <fieldset class="filedset_css" style="width:340px;height: 310px;">
                                                        <legend class="legend_css">
                                                            <ice:outputLabel value="Add New Permission"/>
                                                        </legend>
                                                        <ice:outputLabel id="lblPermissionName"
                                                            style="font-size: 11px; left: 10px; top: 55px; position: absolute" value="Name"/>
                                                        <ice:outputLabel id="permission_Description"
                                                            style="font-size: 11px; left: 10px; top: 88px; position: absolute" value="Description"/>
                                                        <ice:inputText binding="#{pageSecurity$PageAdmin.txtPermissionName}" id="txtPermissionName"
                                                            required="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter;left: 82px; top: 52px; position: absolute" validator="#{pageSecurity$PageAdmin.txtPermissionName_validate}"/>
                                                        <ice:inputTextarea binding="#{pageSecurity$PageAdmin.txtPermissionDescription}"
                                                            id="txtPermissionDescription" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter;left: 82px; top: 86px; position: absolute; width: 243px"/>
                                                        <ice:commandButton action="#{pageSecurity$PageAdmin.btnAddPermission_action}" id="btnAddPermission"
                                                            style="font-size: 11px; left: 188px; top: 140px; position: absolute" value="Add Permission"/>
                                                    </fieldset>
                                                    <ice:message errorClass="iceMsgError errorMessage" fatalClass="iceMsgFatal fatalMessage"
                                                        for="txtPermissionName" id="msgFortxtPermissionName" infoClass="iceMsgInfo infoMessage"
                                                        style="font-size: 11px; font-style: normal; margin-left: 320px; margin-top: 79px; left: -71px; top: 34px; position: absolute; width: 147px"
                                                        tooltip="true" warnClass="iceMsgWarn warnMessage"/>
                                                </ice:panelLayout>
                                            </ice:panelTab>
                                            <ice:panelConfirmation acceptLabel="Save" id="saveConfirmPanel" message="You are saving a new record.Do you want to Save?"/>
                                            <ice:panelConfirmation acceptLabel="Delete" id="deleteConfirmPanel" message="Are you sure to delete this data ?"/>
                                        </ice:panelTabSet>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="south">
                                <ice:panelGroup id="page_footer" style=" text-align: center;">
                                    <ice:panelLayout id="footer" layout="flow" style="background:none;height: 21px; left: 0px; position: relative; -rave-layout: grid">
                                        <jsp:directive.include file="/FOOTER.jspf"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup binding="#{pageSecurity$PageAdmin.pnlUserList}" clientOnly="true" draggable="true" id="pnlUserList" modal="true"
                            rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 200px; left: 97px; top: 26px; position: absolute; width: 600px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridTransionHistory"
                                    style="background-color: rgb(48, 102, 130);                              display: block; height: 27px" width="580">
                                    <ice:outputText id="lblTransionHistoryTitle"
                                        style="color: white; margin-top: 8px; top: 8px; text-align: left; vertical-align: middle;width:90%" value="BUNNA INTERNATIONAL BANK: - User List"/>
                                    <ice:commandLink action="#{pageSecurity$PageAdmin.cmdClose_action}" id="cmdClose" style="background-image: url(../resources/close_icon.gif); height: 19px; left: 620px; top: 18px; position: absolute; width: 19px"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupTransionHistoryBody" style="display: block; height: 460px; position: relative; width: 550px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="panelPopUpUser"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 430px; overflow: auto; position: absolute; width: 480px" styleClass="message">
                                        <ice:panelLayout id="pnlPopeUpInsideTable" style="float: left; height: 50px; left: 0px; top: 0px; position: absolute; width: 100%">
                                            <ice:dataTable id="dataTable7" style="left: 0px; top: -10px; position: absolute; width: 100%"
                                                value="#{pageSecurity$PageAdmin.userLIst}" var="currentRow">
                                                <ice:column id="column7">
                                                    <ice:outputText id="outputText13" value="#{currentRow['employeeId']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="outputText14" value="Employee Id"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="column8">
                                                    <ice:outputText id="outputText15" value="#{currentRow['fullName']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="outputText16" value="Full Name"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="column9">
                                                    <ice:outputText id="outputText17" value="#{currentRow['userName']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="outputText18" value="User Name"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="colSelect">
                                                    <ice:selectBooleanCheckbox binding="#{pageSecurity$PageAdmin.chkUser}" id="chkUser" partialSubmit="true" value="#{currentRow['selected']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="lblSelectForDestion" value="Select"/>
                                                    </f:facet>
                                                </ice:column>
                                            </ice:dataTable>
                                        </ice:panelLayout>
                                        <ice:commandButton action="#{pageSecurity$PageAdmin.btnDeleteUser_action}" id="btnDeleteUser"
                                            style="left: 20px; top: 410px; position: absolute; width: 100px" value="Delete"/>
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
