<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2010, 7:48:31 AM
    Author     : mekete
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
                    function AuthorizationPage(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <ice:panelBorder id="whole_page" renderCenter="#{Authorization$AuthorizationPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Authorization$AuthorizationPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Authorization$AuthorizationPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Authorization$AuthorizationPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Authorization$AuthorizationPage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
                            styleClass="whole_page" width="1024">
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
                            <f:facet name="center">
                                <ice:panelGroup dragListener="#{Authorization$AuthorizationPage.page_display_processMyEvent}" id="page_display" style="height:520px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 475px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 490px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Authorization"/>
                                            </legend>
                                            <ice:panelLayout id="pnlLayoutMainBody" style="height: 449px; left: 0px; top: 50px; position: absolute; width: 100%">
                                                <ice:panelLayout binding="#{Authorization$AuthorizationPage.pnProfile}" id="pnProfile" style="height: 490px; position: absolute; width: 100%">
                                                    <ice:panelGroup binding="#{Authorization$AuthorizationPage.pnlGrpPowerDeligationContent}"
                                                        dragListener="#{Authorization$AuthorizationPage.pnlGrpPowerDeligationContent_processMyEvent}"
                                                        id="pnlGrpPowerDeligationContent" style="height: 415px; width: 953px" styleClass="icePnlGrp filedset_border">
                                                        <label></label>
                                                        <label></label>
                                                        <ice:panelLayout id="pnlLayoutDeligator" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 318px; margin-left: 15px; left: 20px; top: 30px; position: absolute; width: 889px">
                                                            <ice:outputLabel id="lblProcess" style="left: 72px; top: 24px; position: absolute; width: 93px" value="Process"/>
                                                            <ice:selectOneMenu binding="#{Authorization$AuthorizationPage.drlProcess}" id="drlProcess"
                                                                partialSubmit="true" style="left: 190px; top: 22px; position: absolute; width: 191px"
                                                                value="#{Authorization$AuthorizationPage.defaultSelectedData3.selectedObject}" valueChangeListener="#{Authorization$AuthorizationPage.drlProcess_processValueChange}">
                                                                <f:selectItems id="selectOneMenu1selectItems1" value="#{Authorization$AuthorizationPage.processesList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:outputLabel id="lblProcessState" style="left: 72px; top: 48px; position: absolute; width: 69px" value="ProcessState"/>
                                                            <ice:selectOneMenu binding="#{Authorization$AuthorizationPage.drlProcessState}" id="drlProcessState"
                                                                partialSubmit="true" style="left: 190px; top: 46px; position: absolute; width: 191px"
                                                                value="#{Authorization$AuthorizationPage.selectOneMenu1Bean.selectedObject}" valueChangeListener="#{Authorization$AuthorizationPage.drlProcessState_processValueChange}">
                                                                <f:selectItems id="selectOneMenu1selectItems" value="#{Authorization$AuthorizationPage.statesList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:commandButton action="#{Authorization$AuthorizationPage.btnAddProcessState_action}"
                                                                id="btnAddProcessState" style="left: 384px; top: 38px; position: absolute" value="+"/>
                                                            <ice:outputLabel id="lblRole" style="left: 504px; top: 48px; position: absolute; width: 46px" value="Role"/>
                                                            <ice:selectOneMenu binding="#{Authorization$AuthorizationPage.drlRole}" id="drlRole"
                                                                partialSubmit="true" style="left: 622px; top: 46px; position: absolute; width: 216px" value="#{Authorization$AuthorizationPage.selectOneMenu2Bean.selectedObject}">
                                                                <f:selectItems id="selectOneMenu2selectItems" value="#{Authorization$AuthorizationPage.rolesList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:commandButton action="#{Authorization$AuthorizationPage.btnAddToTable_action}"
                                                                id="btnAddToTable" style="left: 744px; top: 62px; position: absolute" value="AddToTable"/>
                                                            <ice:panelLayout id="pnlLayouttable" rendered="true" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 189px; margin-left: 15px; left: 9px; top: 110px; overflow: auto; position: absolute; width: 837px">
                                                                <ice:dataTable id="dataTable"
                                                                    style="left: 20px; top: 0px; height:8px; width:720px; position: absolute"
                                                                    value="#{Authorization$AuthorizationPage.authorizationModelLists}" var="currentRow">
                                                                    <ice:column groupOn="#{currentRow['processId']}" id="colProcessId">
                                                                        <ice:outputText id="optTxtForColumnProcessId" value="#{currentRow['processId']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextProcessId" value="Process Id"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column groupOn="#{currentRow['processName']}" id="colProcessName">
                                                                        <ice:outputText id="optTxtForColumnProcessName" value="#{currentRow['processName']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextProcessName" value="Process Name"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colNumber" rendered="false">
                                                                        <ice:outputText id="optTxtForColumnNumber" value="#{currentRow['counter']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextNumber" value="Num"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colState">
                                                                        <ice:outputText id="optTxtForColumnStateName" value="#{currentRow['satateName']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextState" value="State"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colRole">
                                                                        <ice:outputText id="optTxtForRoleName" value="#{currentRow['roleName']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextRole" value="Role"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colEmpFullName" rendered="false">
                                                                        <ice:commandButton id="optTxtForColumnEmpFullName" image="/resources/images/up.PNG"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextEmpFullName" value="MoveUp"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colCommentGiven" rendered="false">
                                                                        <ice:commandButton id="optTxtForCommentGiven" image="/resources/images/down.PNG"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextCommentGiven" value="MoveDown"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                </ice:dataTable>
                                                            </ice:panelLayout>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutButtons" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 44px; margin-left: 15px; left: 20px; top: 370px; overflow: auto; position: absolute; width: 889px">
                                                            <ice:commandButton action="#{Authorization$AuthorizationPage.btnPostDecision_action}"
                                                                id="btnPostDecision" style="left: 200px; top: 0px; position: absolute; width: 71px" value="Save"/>
                                                            <ice:commandButton action="#{Authorization$AuthorizationPage.btnReset_action}" id="btnReset"
                                                                style="left: 336px; top: 0px; position: absolute; width: 71px" value="#{msgs.Reset}"/>
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </ice:panelLayout>
                                            </ice:panelLayout>
                                        </fieldset>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="south">
                                <ice:panelGroup id="page_footer" style=" text-align: left;">
                                    <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid">
                                        <jsp:directive.include file="/FOOTER.jspf"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Authorization$AuthorizationPage.pnlPopupInsertProcessState}" draggable="true"
                            id="pnlPopupInsertProcessState" modal="true" rendered="false" style="height: 279px; left: 419px; top: 246px; position: absolute; width: 418px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupConfirmDelete" style="text-align: right;  display:block;width:380px;height:20px;">
                                    <ice:outputText id="otxtConfirmDeletePopupHeader" value="BUNNA INTERNATIONAL BANK HRMS - INSERT PROCESS STATE"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutInsertProcessStateBody" style=" left: 0px; top: 50px; position: absolute; ">
                                    <ice:commandButton action="#{Authorization$AuthorizationPage.btnClosePopupInsertState_action}"
                                        binding="#{Authorization$AuthorizationPage.btnClosePopupInsertState}" id="btnClosePopupInsertState"
                                        image="/resources/images/close.png" style="left: 395px; top: -52px; position: absolute; align: right"/>
                                    <ice:commandButton action="#{Authorization$AuthorizationPage.btnSaveState_action}" id="btnSaveState"
                                        style="left: 168px; top: 158px; position: absolute; width: 71px" value="Save"/>
                                    <ice:outputLabel id="lblProcessNameInPopup" style="left: 66px; top: 10px; position: absolute; width: 167px" value="ProcessName"/>
                                    <ice:selectOneMenu binding="#{Authorization$AuthorizationPage.drlProcessInPopup}" disabled="true" id="drlProcessInPopup"
                                        partialSubmit="true" style="left: 166px; top: 10px; position: absolute; width: 167px" value="#{Authorization$AuthorizationPage.defaultSelectedData3.selectedObject}">
                                        <f:selectItems id="selectOneMenu1selectItems2" value="#{Authorization$AuthorizationPage.processesList}"/>
                                    </ice:selectOneMenu>
                                    <ice:outputLabel id="lblStateNameInPopup" style="left: 66px; top: 30px; position: absolute; width: 167px" value="StateName"/>
                                    <ice:inputText binding="#{Authorization$AuthorizationPage.txtStateName}" id="txtStateName" style="left: 166px; top: 30px; position: absolute; width: 167px"/>
                                    <ice:outputLabel id="lblDescriptionInPopup" style="left: 48px; top: 120px; position: absolute; width: 167px" value="Description"/>
                                    <ice:inputTextarea binding="#{Authorization$AuthorizationPage.txtStateDescription}" id="txtStateDescription" style="height: 44px; left: 166px; top: 94px; position: absolute; width: 167px"/>
                                    <ice:selectBooleanCheckbox binding="#{Authorization$AuthorizationPage.cbkCanBeFinal}" id="cbkCanBeFinal"
                                        partialSubmit="true" style="left: 310px; top: 70px; position: absolute" value="#{Authorization$AuthorizationPage.selectBooleanCheckbox1Bean.selectedBoolean}"/>
                                    <ice:outputLabel id="lblCanBeFinal" style="left: 48px; top: 72px; position: absolute; width: 144px" value="Can be final?"/>
                                </ice:panelLayout>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="false" binding="#{Authorization$AuthorizationPage.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 3px; top: 80px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Authorization$AuthorizationPage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Authorization$AuthorizationPage.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
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
