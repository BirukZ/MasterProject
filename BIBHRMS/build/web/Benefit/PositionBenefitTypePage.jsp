<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2010, 7:48:31 AM
    Author     : BravoZulu
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
                        <ice:panelBorder id="whole_page" renderCenter="#{Benefit$PositionBenefitTypePage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Benefit$PositionBenefitTypePage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Benefit$PositionBenefitTypePage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Benefit$PositionBenefitTypePage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Benefit$PositionBenefitTypePage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
                            styleClass="whole_page" width="1100">
                            <f:facet name="north">
                                <ice:panelGroup dragListener="#{Benefit$PositionBenefitTypePage.page_header_processMyEvent}" id="page_header" style="height: 117px">
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
                                                        <li>
                                                            <ice:commandLink action="#{Benefit$PositionBenefitTypePage.lnkBenefitType_action}"
                                                                id="lnkBenefitType" style="color:#306682;font-weight:bold" value="Approve Page"/>
                                                        </li>
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
                                <ice:panelGroup id="page_display" style="height: 925px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 915px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 850px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="BENEFIT TYPES REGISTRATION FOR EACH POSTION"/>
                                            </legend>
                                            <ice:panelLayout id="pnlLayoutMainBody" style="height: 909px; left: 0px; top: 0px; position: absolute; width: 100%">
                                                <ice:panelLayout binding="#{Benefit$PositionBenefitTypePage.pnProfile}" id="pnProfile" style="height: 909px; left: 0px; top: 0px; position: absolute; width: 100%">
                                                    <ice:panelLayout id="pnlLayoutEditor" layout="flow"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 309px; margin-left: 15px; left: 5px; top: 24px; position: absolute; width: 793px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:outputLabel id="lblDepartment" style="left: 48px; top: 24px; position: absolute" value="#{msgsb.Department}"/>
                                                        <ice:outputLabel id="lblPosition" style="left: 48px; top: 48px; position: absolute" value="#{msgsb.Position}"/>
                                                        <ice:outputLabel id="lblRemqrk" style="left: 48px; top: 216px; position: absolute" value="#{msgsb.Remark}"/>
                                                        <ice:inputText action="#{Benefit$PositionBenefitTypePage.txtDepartment_action}"
                                                            binding="#{Benefit$PositionBenefitTypePage.txtDepartment}" disabled="true" id="txtDepartment" style="left: 166px; top: 22px; position: absolute; width: 503px"/>
                                                        <ice:outputLabel id="lblBenefit" style="left: 48px; top: 72px; position: absolute" value="#{msgsb.Benefit}"/>
                                                        <ice:outputLabel id="lblDuration" rendered="false" style="left: 408px; top: 72px; position: absolute" value="Interval"/>
                                                        <ice:outputLabel id="lblQuantity" style="left: 48px; top: 144px; position: absolute" value="#{msgsb.Quantity}"/>
                                                        <ice:inputText disabled="true" id="txtDuration" rendered="false" style="left: 526px; top: 70px; position: absolute"/>
                                                        <ice:inputText binding="#{Benefit$PositionBenefitTypePage.txtQuantity}" id="txtQuantity" style="left: 166px; top: 142px; position: absolute"/>
                                                        <ice:selectOneMenu binding="#{Benefit$PositionBenefitTypePage.drlPosition}" id="drlPosition"
                                                            partialSubmit="true"
                                                            style="&#xa;&#xa;border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 46px; position: absolute; width: 186px" value="#{Benefit$PositionBenefitTypePage.selectOneMenu1Bean.selectedObject}">
                                                            <f:selectItems id="positionTypesOptionSelectItems" value="#{Benefit$PositionBenefitTypePage.positionTypesOption}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectOneMenu binding="#{Benefit$PositionBenefitTypePage.drlBenefit}" id="drlBenefit"
                                                            partialSubmit="true" style="left: 166px; top: 70px; position: absolute; width: 143px" value="#{Benefit$PositionBenefitTypePage.defaultSelectedData2.selectedObject}">
                                                            <f:selectItems id="benefitTypesOptionSelectItems" value="#{Benefit$PositionBenefitTypePage.benefitTypesOption}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:commandButton action="#{Benefit$PositionBenefitTypePage.btnDepartmentTree_action}"
                                                            id="btnDepartmentTree" image="/Employee/images/pic3-tree-icon.jpg"
                                                            style="left: 640px; top: 22px; position: absolute" value="Tree"/>
                                                        <ice:commandButton action="#{Benefit$PositionBenefitTypePage.btnAddBenefitType_action}"
                                                            id="btnAddBenefitType" style="left: 312px; top: 62px; position: absolute" value="+"/>
                                                        <ice:commandButton action="#{Benefit$PositionBenefitTypePage.btnAddToTable_action}" id="btnAddToTable"
                                                            style="left: 552px; top: 254px; position: absolute" value="#{msgsb.AddToTable}"/>
                                                        <ice:inputTextarea binding="#{Benefit$PositionBenefitTypePage.txtaRemark}" id="txtaRemark"
                                                            style="height: 47px; left: 166px; top: 190px; position: absolute; width: 503px" valueChangeListener="#{Benefit$PositionBenefitTypePage.txtaRemark_processValueChange}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Benefit$PositionBenefitTypePage.chkTaxable}" id="chkTaxable"
                                                            partialSubmit="true" style="left: 430px; top: 46px; position: absolute"
                                                            value="#{Benefit$PositionBenefitTypePage.defaultSelectedData3.selectedBoolean}" valueChangeListener="#{Benefit$PositionBenefitTypePage.chkTaxable_processValueChange}"/>
                                                        <ice:outputLabel id="lblTaxable" style="left: 480px; top: 48px; position: absolute" value="#{msgsb.TaxableOrNot}"/>
                                                        <ice:outputLabel id="lblPopupBenefitMonetary1" style="left: 480px; top: 72px; position: absolute" value="#{msgsb.Checkmoney}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Benefit$PositionBenefitTypePage.ckbBenefitMonetary}"
                                                            id="ckbBenefitMonetary" partialSubmit="true" style="left: 430px; top: 70px; position: absolute"
                                                            validator="#{Benefit$PositionBenefitTypePage.ckbBenefitMonetary_validate}"
                                                            value="#{Benefit$BenefitTypePage.selectBooleanCheckbox1Bean.selectedBoolean}" valueChangeListener="#{Benefit$PositionBenefitTypePage.ckbBenefitMonetary_processValueChange}"/>
                                                        <ice:outputLabel id="lblAmountOfBirr" style="left: 48px; top: 168px; position: absolute" value="#{msgsb.AmountOfBirr}"/>
                                                        <ice:inputText binding="#{Benefit$PositionBenefitTypePage.txtAmountOfBirr}" id="txtAmountOfBirr" style="left: 166px; top: 166px; position: absolute"/>
                                                        <ice:outputLabel id="lblBenefit1" style="left: 48px; top: 120px; position: absolute" value="#{msgsb.location}"/>
                                                        <ice:selectOneMenu binding="#{Benefit$PositionBenefitTypePage.drlLocation}" id="drlLocation"
                                                            partialSubmit="true" style="left: 166px; top: 118px; position: absolute; width: 143px" value="#{Benefit$PositionBenefitTypePage.defaultSelectedData4.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems" value="#{Benefit$PositionBenefitTypePage.benefitLocation}"/>
                                                        </ice:selectOneMenu>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutTableBenefitPosition"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 429px; margin-left: 15px; left: 9px; top: 360px; overflow: auto; position: absolute; width: 789px" styleClass="insideContainerMain">
                                                        <ice:dataTable id="dataTable"
                                                            style="height: 8px; left: 14px; top: 14px; position: absolute; width: 615px"
                                                            value="#{Benefit$PositionBenefitTypePage.positionBenefitLists}" var="currentRow">
                                                            <ice:column id="colStatus">
                                                                <ice:outputText id="optTxtForStatus" value="#{currentRow['dataBaseStatus']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextNumber" value="Status"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colBenefitName">
                                                                <ice:selectOneMenu binding="#{Benefit$PositionBenefitTypePage.drlBenefitEdit}" id="drlBenefit"
                                                                    partialSubmit="true" value="#{currentRow['benefitId']}">
                                                                    <f:selectItems id="benefitTypesOptionSelectItemsEdit" value="#{Benefit$PositionBenefitTypePage.benefitTypes}"/>
                                                                </ice:selectOneMenu>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextBenefitName" value="BenefitName"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colPosition" style="width: 50px">
                                                                <ice:selectOneMenu binding="#{Benefit$PositionBenefitTypePage.drlPositionEdit}"
                                                                    id="drlPositionEdit" partialSubmit="true" value="#{currentRow['positionId']}">
                                                                    <f:selectItems id="positionTypesOptionSelectItemsEdit" value="#{Benefit$PositionBenefitTypePage.benefitTypesPostions}"/>
                                                                </ice:selectOneMenu>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextPosition" value="Position"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colAmountOfMoney" style="width: 112px">
                                                                <ice:inputText id="txtForColumnQuantityEdit2" value="#{currentRow['moneyValue']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextPosition2" value="Amount Of Birr"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colQuantity" style="width: 60px">
                                                                <ice:inputText id="txtForColumnQuantityEdit" value="#{currentRow['quantity']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextQuantity" value="Quantity"/>
                                                                </f:facet>
                                                                <ice:rowSelector id="rowSelectorBenefitPosition" multiple="false" preStyleOnSelection="true"
                                                                    selectionListener="#{Benefit$PositionBenefitTypePage.rowSelectorBenefitPosition_processMyEvent}"
                                                                    toggleOnClick="true" value="#{currentRow['selected']}"/>
                                                            </ice:column>
                                                            <ice:column id="colBenefitLocatopn">
                                                                <ice:selectOneMenu id="drlBenefit1" partialSubmit="true" value="#{currentRow['location']}">
                                                                    <f:selectItems id="benefitTypesOptionSelectItemsEdit1" value="#{Benefit$PositionBenefitTypePage.locationList}"/>
                                                                </ice:selectOneMenu>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextBenefitName1" value="Location"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colEdit">
                                                                <ice:commandLink action="#{Benefit$PositionBenefitTypePage.cmdLnkEdit_action}" id="cmdLnkEdit" value="Ok"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextEdit" value="Edit"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colRemove">
                                                                <ice:commandLink action="#{Benefit$PositionBenefitTypePage.cmdLnkRemove_action}"
                                                                    id="cmdLnkRemove" value="Remove"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextRemove" value="Remove"/>
                                                                </f:facet>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout binding="#{Benefit$PositionBenefitTypePage.pnlLayoutTree}" id="pnlLayoutTree" layout="flow"
                                                        rendered="false"
                                                        style="border-width: 2px; border-style: solid; height: 356px; left: 11px; top: 78px; overflow: scroll; position: absolute; width: 368px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:tree binding="#{Benefit$PositionBenefitTypePage.treeOrgStructure}" id="tree"
                                                            style="height: 356px; margin-left: 0px; margin-top: 0px; left: 0px; top: 0px; position: absolute; text-align: left; width: 356px"
                                                            value="#{Benefit$PositionBenefitTypePage.treeModel.model}" var="item">
                                                            <ice:treeNode id="treeNode2">
                                                                <f:facet name="icon">
                                                                    <ice:panelGroup id="panelGroup1" style="display: inline;">
                                                                        <ice:graphicImage id="graphicImage2" value="#{item.userObject.icon}"/>
                                                                    </ice:panelGroup>
                                                                </f:facet>
                                                                <f:facet name="content">
                                                                    <ice:panelGroup id="panelGroup2" style="display: inline;">
                                                                        <ice:commandLink
                                                                            actionListener="#{Benefit$PositionBenefitTypePage.cmdLnkTree_processAction}"
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
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 44px; margin-left: 15px; left: 9px; top: 816px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                        <ice:commandButton action="#{Benefit$PositionBenefitTypePage.btnPostDecision_action}"
                                                            id="btnPostDecision" style="left: 216px; top: 0px; position: absolute; width: 71px" value="#{msgsb.btnSave}"/>
                                                        <ice:commandButton action="#{Benefit$PositionBenefitTypePage.btnReset_action}" id="btnReset"
                                                            style="left: 336px; top: 0px; position: absolute; width: 71px" value="#{msgsb.btnReset}"/>
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
                        <ice:panelPopup autoCentre="true" binding="#{Benefit$PositionBenefitTypePage.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 48px; top: 528px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BIB Human Resource Management System:Message"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Benefit$PositionBenefitTypePage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Benefit$PositionBenefitTypePage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Benefit$PositionBenefitTypePage.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
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
