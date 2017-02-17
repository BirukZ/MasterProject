<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : DefineQuestionnaire
    Created on : Oct 21, 2011, 8:36:53 AM
    Author     : Bini
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <f:loadBundle basename="Localization.HRLocalization" var="msgs"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                
                <title>DefineQuestionnaire</title>
                <ice:outputStyle href="../resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="../xmlhttp/css/rime/rime.css"/>
                <ice:outputStyle href="../resources/ETH/KAMSI_CAL_STYLE.css" id="outputStyle22"/>
                <ice:outputStyle href="../resources/TempCSS.css"/>
                <script src="../Script/jquery-1.3.2.min.js"></script>
                <script src="../resources/ETH/KAMSI_CAL_SCRIPT.js"></script>
                <script language="javascript" type="text/javascript">
                    var DefineQuestionnaire=jQuery.noConflict();
                </script>
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
            </head>
            <body id="outputBody1" onload="showCal()" style="-rave-layout: grid">
                <ice:form id="form1">
                    <ice:panelBorder height="680" id="whole_page" renderCenter="#{Page1.panelBorder1Bean.renderCenter}"
                        renderEast="#{Page1.panelBorder1Bean.renderEast}" renderNorth="#{Page1.panelBorder1Bean.renderNorth}"
                        renderSouth="#{Page1.panelBorder1Bean.renderSouth}" renderWest="#{Page1.panelBorder1Bean.renderWest}"
                        style="top: 0px; position: relative" styleClass="whole_page" width="1024px">
                        <f:facet name="north">
                            <ice:panelGroup id="page_header" style="height: 105px">
                                <!-- Begin Header -->
                                <ice:panelLayout id="header" layout="flow" style="height: 105px; left: 0px; position: relative; width: 100%; -rave-layout: grid"
                                    styleClass="header" visible="true">
                                    <jsp:directive.include file="/Header.jspf"/>
                                </ice:panelLayout>
                                <!-- End Header -->
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="west">
                            <ice:panelGroup id="menu_left" style=" height:100%; border:none; ">
                                <ice:panelLayout id="left_menu1" layout="flow"
                                    style="height: 300px; border:none; left: 5px; top:18px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                    <ice:panelLayout id="list_menu2" style="height: 100px; border:none; left: 0px; top: 10px; position: absolute; width: 213px" styleClass="left_menu">
                                        <ice:panelCollapsible expanded="true" id="panelCollapsible1" immediate="true" style="top:15px;border:none">
                                            <f:facet name="header">
                                                <ice:panelGroup id="panelGroup1" styleClass="">
                                                    <ice:outputText id="lblRecruitmentRequest" value="Common Tasks"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid headerClass="iceDatTblColHdr1" id="panelGrid1" style="border:none" width="100%">
                                                <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                    <li>
                                                        <ice:commandLink action="#{Questionnaire$DefineQuestionnaire.cmdAssignQuestionnaire_action}"
                                                            id="cmdAssignQuestionnaire" immediate="true" partialSubmit="true"
                                                            style="color: rgb(48, 102, 130); font-weight: bold; text-align: left" value="Assign Questionnaire"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Questionnaire$DefineQuestionnaire.cmdQuestionnaire_action}"
                                                            id="cmdQuestionnaire" immediate="true" partialSubmit="true"
                                                            style="color: rgb(48, 102, 130); font-weight: bold; text-align: left" value="Questionnaire"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Questionnaire$DefineQuestionnaire.cmdAnalyzeGrading_action}"
                                                            id="cmdAnalyzeGrading" immediate="true" partialSubmit="true" style="color: rgb(48, 102, 130); font-weight: bold; text-align: left"/>
                                                    </li>
                                                    <li>
                                                        <ice:commandLink action="#{Questionnaire$DefineQuestionnaire.cmdAnalyzeReGrading_action}"
                                                            id="cmdAnalyzeReGrading" immediate="true" partialSubmit="true" style="color: rgb(48, 102, 130); font-weight: bold; text-align: left"/>
                                                    </li>
                                                </ul>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                        <ice:panelCollapsible expanded="true" id="panelCollapsible3">
                                            <f:facet name="header">
                                                <ice:panelGroup id="panelGroup2" styleClass="">
                                                    <ice:outputText id="outputText4"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid headerClass="iceDatTblColHdr1" id="panelGrid2" style="border:none" width="100%"/>
                                        </ice:panelCollapsible>
                                    </ice:panelLayout>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="center">
                            <ice:panelGroup id="page_display" style="height: 995px">
                                <ice:panelLayout id="container" layout="flow"
                                    style="height: 970px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                    <ice:panelTabSet binding="#{Questionnaire$DefineQuestionnaire.panelTabSet}" id="panelTabSet"
                                        style="left: 0px; top: 0px; position: absolute; width: 98%" tabPlacement="Top">
                                        <ice:panelTab id="pnlTabOptions" label="Define Questionnaire">
                                            <ice:panelLayout id="pnlOptions" layout="flow" style="border-width: 1px; border-style: none; height: 915px; left: 0px; top: 0px; position: relative; width: 100%">
                                                <ice:panelLayout id="panelLayout4" layout="flow"
                                                    style="border-width: 1px; height: 166px; left: 15px; top: 24px; position: absolute; width: 715px; -rave-layout: grid" styleClass="insideContainerMain">
                                                    <ice:outputLabel id="outputLabel7" style="left: 24px; top: 15px; position: absolute" value="Purpose"/>
                                                    <ice:inputText binding="#{Questionnaire$DefineQuestionnaire.txtQuestionnaireTitle}"
                                                        id="txtQuestionnaireTitle" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 119px; top: 53px; position: absolute; width: 220px"/>
                                                    <ice:outputLabel id="option" style="left: 24px; top: 52px; position: absolute" value="Title"/>
                                                    <ice:commandButton action="#{Questionnaire$DefineQuestionnaire.btnAddOption_action}"
                                                        binding="#{Questionnaire$DefineQuestionnaire.btnAddOption}" id="btnAddOption"
                                                        style="left: 408px; top: 110px; position: absolute" value="Add to Table"/>
                                                    <ice:selectOneMenu binding="#{Questionnaire$DefineQuestionnaire.ddnQuestionnairePurpose}"
                                                        id="ddnQuestionnairePurpose" partialSubmit="true"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 119px; top: 16px; position: absolute; width: 220px" value="#{Questionnaire$DefineQuestionnaire.defaultSelectedData1.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems1" value="#{Questionnaire$DefineQuestionnaire.questionnairePurposeList}"/>
                                                    </ice:selectOneMenu>
                                                    <ice:commandButton action="#{Questionnaire$DefineQuestionnaire.btnGroup_action}"
                                                        binding="#{Questionnaire$DefineQuestionnaire.btnGroup}" id="btnGroup"
                                                        style="left: 350px; top: 5px; position: absolute" value=". . ."/>
                                                    <ice:inputTextarea binding="#{Questionnaire$DefineQuestionnaire.txtaQuestionnaireDesc}"
                                                        id="txtaQuestionnaireDesc" style="left: 118px; top: 94px; position: absolute; width: 226px"/>
                                                    <ice:outputLabel id="outputLabel1" style="left: 24px; top: 96px; position: absolute" value="Description"/>
                                                </ice:panelLayout>
                                                <ice:panelLayout id="pnlOption" style="height: 615px; left: 15px; top: 212px; position: absolute; width: 715px" styleClass="insideContainerMain">
                                                    <ice:dataTable id="tblOption" style="left:0;top:-10;width:100%;position:absolute"
                                                        value="#{Questionnaire$DefineQuestionnaire.optionManagerList}" var="currentRow">
                                                        <ice:column groupOn="#{currentRow['defQuesPurposeDesc']}" id="column13">
                                                            <ice:outputText id="outputText27" value="#{currentRow['defQuesPurposeDesc']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText28" value="Purpose"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column14">
                                                            <ice:outputText id="outputText29" value="#{currentRow['defQuesName']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText30" value="Title"/>
                                                            </f:facet>
                                                            <ice:rowSelector id="rowSelectorOption" immediate="true"
                                                                selectionListener="#{Questionnaire$DefineQuestionnaire.rowSelectorOption_processMyEvent}" value="#{currentRow['selected']}"/>
                                                        </ice:column>
                                                        <ice:column id="column15">
                                                            <ice:outputText id="outputText31" value="#{currentRow['defQuesDescription']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText32" value="Description"/>
                                                            </f:facet>
                                                        </ice:column>
                                                    </ice:dataTable>
                                                </ice:panelLayout>
                                                <ice:panelLayout id="pnlCommandBtn2" layout="flow"
                                                    style="border-width: 1px; border-style: solid; height: 60px; left: 15px; top: 850px; position: absolute; width: 715px; -rave-layout: grid" styleClass="insideContainerMain">
                                                    <ice:commandButton binding="#{Questionnaire$DefineQuestionnaire.btnNewEditOpt}" id="btnNewEditOpt"
                                                        style="left: 108px; top: 10px; position: absolute; width: 95px" value="New/Edit"/>
                                                    <ice:commandButton binding="#{Questionnaire$DefineQuestionnaire.btnDeleteOption}" id="btnDeleteOption"
                                                        style="left: 368px; top: 10px; position: absolute; width: 95px" value="Delete Option"/>
                                                    <ice:commandButton action="#{Questionnaire$DefineQuestionnaire.btnSaveUpdateOpt_action}"
                                                        binding="#{Questionnaire$DefineQuestionnaire.btnSaveUpdateOpt}" id="btnSaveUpdateOpt"
                                                        style="left: 238px; top: 10px; position: absolute; width: 95px" value="Save/Update"/>
                                                    <ice:commandButton binding="#{Questionnaire$DefineQuestionnaire.btnDeleteGroup}" id="btnDeleteGroup"
                                                        style="left: 498px; top: 10px; position: absolute; width: 95px" value="Delete Group"/>
                                                </ice:panelLayout>
                                            </ice:panelLayout>
                                        </ice:panelTab>
                                    </ice:panelTabSet>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="south">
                            <ice:panelGroup id="page_footer" style=" text-align: center;">
                                <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">This is the Footer</ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelBorder>
                    <ice:panelPopup autoCentre="true" binding="#{Questionnaire$DefineQuestionnaire.pnlPopUpGroup}" draggable="true" id="pnlPopUpGroup"
                        rendered="false" style="width: 210px" visible="#{Questionnaire$DefineQuestionnaire.panelPopup1Bean.showModalPanel}">
                        <f:facet name="header">
                            <ice:panelGrid id="panelGrid3" style="display:block;width:180px;height:20px;">
                                <ice:outputText id="outputText26" value="Manage Group"/>
                                <ice:commandLink action="#{Questionnaire$DefineQuestionnaire.cmdCloseDeleete_action}" id="cmdCloseDeleete" immediate="true"
                                    style="background-image: url(../resources/close_icon.gif); height: 15px; left: 220px; top: 0px; z-index:2px; position: absolute; width: 19px"
                                    styleClass="popupHeaderImage" title="Close Popup"/>
                            </ice:panelGrid>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGrid columns="2" id="pnlPopUpBody"
                                style="display: block; height: 80px; text-align: center; vertical-align: middle; width: 220px" styleClass="icePnlGrp iceDatTblColHdr">
                                <ice:outputLabel id="outputLabel8" style="width: 70px" value="Group Name"/>
                                <ice:inputText binding="#{Questionnaire$DefineQuestionnaire.txtGroupName}" id="txtGroupName" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; width: 150"/>
                                <ice:commandButton action="#{Questionnaire$DefineQuestionnaire.btnGroupNew_action}"
                                    binding="#{Questionnaire$DefineQuestionnaire.btnGroupNew}" id="btnGroupNew" style="left:28px; text-align: center" value="New"/>
                                <ice:commandButton action="#{Questionnaire$DefineQuestionnaire.btnGroupUpdate_action}"
                                    binding="#{Questionnaire$DefineQuestionnaire.btnGroupUpdate}" id="btnGroupUpdate" value="Update"/>
                            </ice:panelGrid>
                        </f:facet>
                    </ice:panelPopup>
                    <ice:panelPopup autoCentre="true" binding="#{Questionnaire$DefineQuestionnaire.pnMessage}" clientOnly="true" draggable="false"
                        id="pnMessage" modal="false" rendered="false"
                        style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                        <f:facet name="header">
                            <ice:panelGroup id="pnlgridpnMessage" style="background-color:#333333; height: 20px; padding-top: 8px; width: 672px">
                                <ice:outputText id="pnMessageTitle"
                                    style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="National Bank of Ethiopia Human Resource Management And Integrated Payroll System:Message"/>
                                <ice:commandLink action="#{Questionnaire$DefineQuestionnaire.modalPnlCloseMesssage_action}" id="modalPnlCloseMesssage"
                                    immediate="true"
                                    style="background-image: url(../resources/close_icon.gif); height: 19px; left: 735px; top: 20px; position: absolute; width: 19px"
                                    styleClass="popupHeaderImage" title="Close Popup"/>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGroup id="panelGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                <ice:panelLayout id="pnlMessageBody" layout="flow"
                                    style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                    <h:outputLabel binding="#{Questionnaire$DefineQuestionnaire.lblFormMessage}" id="lblFormMessage" style="background-color: #F5F5F5;"/>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelPopup>
                    <ice:panelPopup autoCentre="true" binding="#{Questionnaire$DefineQuestionnaire.panelPopup}" draggable="true" id="panelPopup" modal="true"
                        rendered="false"
                        style="border-style: none; background-color: transparent; display: block; height: 120px; left: 96px; top: 936px; position: absolute; width: 751px" styleClass="message">
                        <f:facet name="header">
                            <ice:panelGrid id="panelGrid11" style="background-color:#333333; height: 20px; padding-top: 8px; width: 672px">
                                <ice:outputText id="outputText10"
                                    style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="National Bank of Ethiopia Human Resource Management And Integrated Payroll System:Message"/>
                                <ice:commandLink id="cmdConfirmationCloseDeleete" immediate="true"
                                    style="background-image: url(../resources/close_icon.gif); height: 19px; left: 744px; top: 15px; position: absolute; width: 19px"
                                    styleClass="popupHeaderImage" title="Close Popup"/>
                            </ice:panelGrid>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGroup id="panelConfirmationDelete" style="display: block; height: 60px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                <ice:panelLayout id="pnlConfirmationDeleteBody" layout="flow"
                                    style="background-color: rgb(245, 245, 245); display: block; height: 35px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                    <h:outputLabel id="lblFormDeleteMessage"
                                        style="color: green; font-size: 12px; font-weight: bold; left: 24px; top: 24px; position: absolute; text-align: center; vertical-align: middle" value="ARE YOU SURE YOU WANT TO DELETE JOB ?"/>
                                    <ice:commandButton action="#{Questionnaire$DefineQuestionnaire.bntYES_action}" id="bntYES"
                                        style="left: 360px; top: 14px; position: absolute; width: 80px" value="Yes"/>
                                    <ice:commandButton action="#{Questionnaire$DefineQuestionnaire.btnNo_action}" id="btnNo"
                                        style="left: 456px; top: 14px; position: absolute; width: 80px" value="No"/>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelPopup>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
