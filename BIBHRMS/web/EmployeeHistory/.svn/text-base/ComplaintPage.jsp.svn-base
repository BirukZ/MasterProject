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
        <html id="outputHtml1">
            <f:loadBundle basename="Localization.HRLocalization_hstry" var="msgsh"/>
            <head id="outputHead1">
                <title></title>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:outputStyle href="../resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="../xmlhttp/css/xp/xp.css" id="outputStyle2"/>
                <ice:outputStyle href="/xmlhttp/css/rime/rime.css"/>
                <script src="/resources/jmaki.js"></script>
                <script src="/resources/wfactory.js"></script>
                <ice:form binding="#{EmployeeHistory$ComplaintPage.form1}" id="form1">
                    <ice:panelBorder height="480" id="whole_page" renderCenter="#{EmployeeHistory$ComplaintPage.panelBorder1Bean.renderCenter}"
                        renderEast="#{EmployeeHistory$ComplaintPage.panelBorder1Bean.renderEast}"
                        renderNorth="#{EmployeeHistory$ComplaintPage.panelBorder1Bean.renderNorth}"
                        renderSouth="#{EmployeeHistory$ComplaintPage.panelBorder1Bean.renderSouth}"
                        renderWest="#{EmployeeHistory$ComplaintPage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative" styleClass="whole_page" width="1024">
                        <f:facet name="north">
                            <ice:panelGroup id="page_header" style="height: 117px">
                                <!-- Begin Header -->
                                <ice:panelLayout id="header" layout="flow" style="height: 129px; left: 0px; position: relative; width: 100%; -rave-layout: grid"
                                    styleClass="header" visible="true">
                                    <jsp:directive.include file="/Header.jspf"/>
                                </ice:panelLayout>
                                <!-- End Header -->
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="west">
                            <ice:panelGroup dragListener="#{EmployeeHistory$ComplaintPage.menu_left_processMyEvent}" id="menu_left" style=" height:100%;">
                                <ice:panelLayout id="left_menu1" layout="flow"
                                    style="height: 312px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                    <ice:panelLayout id="list_menu2" style="height: 354px; left: -4px; position: absolute; width: 213px" styleClass="list_menu">
                                        <ice:panelCollapsible expanded="true" id="pnl_col_Common_Tasks2">
                                            <f:facet name="header">
                                                <ice:panelGroup id="commonTasksGroup_header">
                                                    <ice:outputText id="lblCommonTasks" value="Common Tasks"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid id="commonTasksGroup_Grid" width="100%">
                                                <ice:panelSeries id="Common_Tasks_Series" rows="3" style="width:100%" value="CommonTasks" var="commontasks">
                                                    <ice:panelGroup id="commonTasksGroup_Group" style="width:100%"/>
                                                    <ice:panelGroup id="IssueComplaint" styleClass="iceDatTblColHdr">
                                                        <ice:commandLink id="commandLink1" style="color:#306682;font-weight:bold" value="#{msgsh.issueComplaint}"/>
                                                    </ice:panelGroup>
                                                    <br/>
                                                    <ice:panelGroup id="ResolveComplaint" styleClass="iceDatTblColHdr">
                                                        <ice:commandLink id="commandLink2" style="color:#306682;font-weight:bold" value="#{msgsh.resolveComplaint}"/>
                                                    </ice:panelGroup>
                                                    <br/>
                                                    <ice:panelGroup id="ComplaintRecored" styleClass="iceDatTblColHdr">
                                                        <ice:commandLink id="commandLink3" style="color:#306682;font-weight:bold" value="#{msgsh.complaintRecord}"/>
                                                    </ice:panelGroup>
                                                </ice:panelSeries>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                        <ice:panelCollapsible expanded="true" id="pnl_col_Status">
                                            <f:facet name="header">
                                                <ice:panelGroup id="status_Group_Header">
                                                    <ice:outputText id="lblStatus" value="Status"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid width="100%">
                                                <ice:panelSeries id="status_Series" rows="3" value="Status" var="status">
                                                    <ice:panelGroup id="status_Group">
                                                        <ice:panelGroup id="panelLayout1" styleClass="coulamTop1">
                                                            <ice:outputLabel id="outputLabel1" value="Current Status"/>
                                                        </ice:panelGroup>
                                                        <ice:panelGroup id="pn_status_container" styleClass="coulamMid1"/>
                                                        <ice:panelGroup id="pn_status_footer" styleClass="coulamBottom1"/>
                                                    </ice:panelGroup>
                                                </ice:panelSeries>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                        <ice:panelCollapsible expanded="true" id="pnl_col_Search">
                                            <f:facet name="header">
                                                <ice:panelGroup id="search_Group_Header">
                                                    <ice:outputText id="lblSearchArea" value="Search Area"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid width="100%">
                                                <ice:panelSeries id="search_Series" rows="3" value="Search" var="search">
                                                    <ice:panelGroup id="search_Group"/>
                                                </ice:panelSeries>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                    </ice:panelLayout>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="center">
                            <ice:panelGroup id="page_display" style="height:450px">
                                <ice:panelLayout id="container" layout="flow"
                                    style="height: 405px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                    <fieldset class="filedset_css">
                                        <legend class="legend_css">
                                            <ice:outputLabel value="Post your Complaint here"/>
                                        </legend>
                                        <ice:panelCollapsible expanded="true" id="pnlColByEmployee">
                                            <f:facet name="header">
                                                <ice:panelGroup binding="#{EmployeeHistory$ComplaintPage.pgByEmpHeader}"
                                                    dragListener="#{EmployeeHistory$ComplaintPage.pgByEmpHeader_processMyEvent}" id="pgByEmpHeader" styleClass="">
                                                    <ice:outputText id="otxtHeader" value="By The Employee"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid binding="#{EmployeeHistory$ComplaintPage.pgByEmp}" id="pgByEmp"
                                                style="border-width: 1px; border-style: solid; border-color: rgb(23, 102, 116) rgb(23, 102, 116) rgb(23, 102, 116) rgb(23, 102, 116); margin: 5px; padding: 20px; height: 288px; position: absolute" width="762">
                                                <ice:panelGroup dragListener="#{EmployeeTermination$TerminationApprovalPage.RetirementApproval_processMyEvent}"
                                                    id="PGComplaint" style="height:410px;" styleClass="collabsable_bg">
                                                    <ice:commandButton action="#{EmployeeHistory$ComplaintPage.btnNew_action}" id="btnNew"
                                                        style="background-image: url(images/edit.png); background-repeat: no-repeat; left: 41px; top: 269px; position: absolute; width: 82px" value="New"/>
                                                    <ice:commandButton action="#{EmployeeHistory$ComplaintPage.btnPost_action}" id="btnPost"
                                                        style="left: 209px; top: 269px; position: absolute; width: 78px" value="Post"/>
                                                    <ice:commandButton id="btnCancel" style="left: 377px; top: 269px; position: absolute; width: 83px" value="Cancle"/>
                                                    <ice:outputText id="lblEmpId" style="left: 26px; top: 37px; position: absolute" value="#{msgsh.id}"/>
                                                    <ice:inputText id="itxtFullName" style="left: 590px; top: 36px; position: absolute; width: 175px"/>
                                                    <ice:outputText id="lblFullName" style="left: 472px; top: 38px; position: absolute" value="#{msgsh.fullName}"/>
                                                    <ice:commandButton id="button4" style="left: 545px; top: 269px; position: absolute; width: 83px" value="Reset"/>
                                                    <ice:outputText id="lblTitle" style="left: 307px; top: 39px; position: absolute" value="#{msgsh.title}"/>
                                                    <ice:inputText id="itxtTitle" style="left: 353px; top: 37px; position: absolute; width: 85px"/>
                                                    <ice:outputText id="lblMainIssue" style="left: 26px; top: 110px; position: absolute" value="#{msgsh.complaintIssue}"/>
                                                    <ice:outputText id="outputText1" style="left: 26px; top: 74px; position: absolute" value="#{msgsh.complaintDate}"/>
                                                    <ice:outputText id="outputText2" style="left: 473px; top: 74px; position: absolute" value="#{msgsh.complaintPlace}"/>
                                                    <ice:inputText id="itxtComplaintDate" style="left: 129px; top: 69px; position: absolute; width: 85px"/>
                                                    <ice:inputText id="itxtComplaintPlace" style="left: 591px; top: 73px; position: absolute; width: 174px"/>
                                                    <ice:inputText id="itxtComplaintOnFullName" style="left: 129px; top: 246px; position: absolute"/>
                                                    <ice:inputTextarea id="inputTextarea1" style="left: 129px; top: 130px; position: absolute; width: 167px"/>
                                                    <ice:outputText id="lblFullName1" style="left: 26px; top: 248px; position: absolute" value="#{msgsh.fullName}"/>
                                                    <ice:outputText id="lblEmpId1" style="left: 26px; top: 217px; position: absolute" value="#{msgsh.id}"/>
                                                    <ice:inputTextarea id="itxtaSourceReason" style="left: 350px; top: 132px; position: absolute; width: 167px"/>
                                                    <ice:outputText id="lblEmpId2" style="left: 304px; top: 110px; position: absolute" value="#{msgsh.complain}"/>
                                                    <ice:inputTextarea id="itxtaEvidence" style="left: 590px; top: 132px; position: absolute"/>
                                                    <ice:inputTextarea id="itxtProposedSolution" style="left: 590px; top: 235px; position: absolute"/>
                                                    <ice:outputText id="lblEvidence" style="left: 592px; top: 110px; position: absolute" value="#{msgsh.evidence}"/>
                                                    <ice:outputText id="lblProposedSolution" style="left: 592px; top: 206px; position: absolute" value="#{msgsh.demandedResolution}"/>
                                                    <ice:outputText id="outputText3" style="left: 26px; top: 181px; position: absolute" value="#{msgsh.complainOn}"/>
                                                    <ice:selectOneMenu id="selectOneMenu1" partialSubmit="true"
                                                        style="left: 129px; top: 36px; position: absolute; width: 160px" value="#{EmployeeHistory$ComplaintPage_2.defaultSelectedData9.selectedObject}">
                                                        <f:selectItems id="selectOneMenu1selectItems" value="#{EmployeeHistory$ComplaintPage.selectOneMenu1DefaultItems}"/>
                                                    </ice:selectOneMenu>
                                                    <ice:selectOneMenu id="selectOneMenu2" partialSubmit="true"
                                                        style="left: 129px; top: 216px; position: absolute; width: 160px" value="#{EmployeeHistory$ComplaintPage_2.defaultSelectedData10.selectedObject}">
                                                        <f:selectItems id="selectOneMenu2selectItems" value="#{EmployeeHistory$ComplaintPage_2.selectOneMenu2DefaultItems3}"/>
                                                    </ice:selectOneMenu>
                                                </ice:panelGroup>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                        <ice:panelCollapsible binding="#{EmployeeHistory$ComplaintPage.pnl_col_byImmediateBoss}" id="pnl_col_byImmediateBoss">
                                            <f:facet name="header">
                                                <ice:panelGroup binding="#{EmployeeHistory$ComplaintPage.pgByIBossHeader}" id="pgByIBossHeader" styleClass="">
                                                    <ice:outputText binding="#{EmployeeHistory$ComplaintPage.otxtHeader2}" id="otxtHeader2" value="Complaint Resolution"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid binding="#{EmployeeHistory$ComplaintPage.pgByIBoss}" id="pgByIBoss"
                                                style="border-width: 1px; border-style: solid; border-color: rgb(23, 102, 116) rgb(23, 102, 116) rgb(23, 102, 116) rgb(23, 102, 116); margin: 5px; padding: 20px; height: 264px" width="762">
                                                <ice:commandButton action="#{EmployeeHistory$ComplaintPage.btnNew_action}" id="btnNewResolution"
                                                    style="background-image: url(images/edit.png); background-repeat: no-repeat; left: 42px; top: 278px; position: absolute; width: 82px" value="New"/>
                                                <ice:commandButton action="#{EmployeeHistory$ComplaintPage.btnPost_action}" id="btnPostResolution"
                                                    style="left: 210px; top: 278px; position: absolute; width: 78px" value="Post Resolution"/>
                                                <ice:commandButton id="btnCancelResolution" style="left: 378px; top: 278px; position: absolute; width: 83px" value="Cancle"/>
                                                <ice:outputText id="lblTeamMemberEmpId1" style="left: 26px; top: 201px; position: absolute" value="#{msgsh.id}"/>
                                                <ice:inputText id="itxtTeamMemberEmpFullName1" style="left: 406px; top: 200px; position: absolute; width: 175px"/>
                                                <ice:outputText id="lblFullName11" style="left: 337px; top: 207px; position: absolute" value="#{msgsh.fullName}"/>
                                                <ice:commandButton id="btnResetResolution" style="left: 546px; top: 278px; position: absolute; width: 83px" value="Reset"/>
                                                <ice:outputText id="lblFindings" style="left: 28px; top: 59px; position: absolute" value="#{msgsh.findings}"/>
                                                <ice:inputText id="itxtTeamMemberEmpFullName" style="left: 406px; top: 166px; position: absolute; width: 175px"/>
                                                <ice:inputTextarea id="itxtaFindings" style="left: 96px; top: 78px; position: absolute; width: 276px"/>
                                                <ice:outputText id="lblFullName12" style="left: 336px; top: 168px; position: absolute" value="#{msgsh.fullName}"/>
                                                <ice:outputText id="lblTeamMemberEmpId" style="left: 24px; top: 168px; position: absolute" value="#{msgsh.id}"/>
                                                <ice:inputTextarea id="itxtaDecision" style="left: 504px; top: 78px; position: absolute; width: 248px"/>
                                                <ice:outputText id="lblDecision" style="left: 460px; top: 59px; position: absolute" value="#{msgsh.decision}"/>
                                                <ice:outputText id="lblComplaintTeam" style="left: 25px; top: 134px; position: absolute" value="#{msgsh.complaintTeam}"/>
                                                <ice:outputText id="lblTeamMemberEmpId2" style="left: 27px; top: 237px; position: absolute" value="#{msgsh.id}"/>
                                                <ice:outputText id="lblFullName22" style="left: 339px; top: 237px; position: absolute" value="#{msgsh.fullName}"/>
                                                <ice:inputText id="itxtTeamMemberEmpFullName2" style="left: 406px; top: 235px; position: absolute; width: 175px"/>
                                                <ice:selectOneMenu id="drlMembEmpId" partialSubmit="true"
                                                    style="left: 96px; top: 166px; position: absolute; width: 160px" value="#{EmployeeHistory$ComplaintPage_2.defaultSelectedData11.selectedObject}">
                                                    <f:selectItems id="somiMembEmpId" value="#{EmployeeHistory$ComplaintPage_2.selectOneMenu1DefaultItems6}"/>
                                                </ice:selectOneMenu>
                                                <ice:selectOneMenu id="drl2MemberEmpId" partialSubmit="true"
                                                    style="left: 96px; top: 203px; position: absolute; width: 160px" value="#{EmployeeHistory$ComplaintPage_2.defaultSelectedData12.selectedObject}">
                                                    <f:selectItems id="somiMembEmpId1" value="#{EmployeeHistory$ComplaintPage_2.selectOneMenu2DefaultItems}"/>
                                                </ice:selectOneMenu>
                                                <ice:selectOneMenu id="drl3MembEmpId" partialSubmit="true"
                                                    style="left: 96px; top: 238px; position: absolute; width: 160px" value="#{EmployeeHistory$ComplaintPage_2.selectOneMenu3Bean.selectedObject}">
                                                    <f:selectItems id="somiMembEmpId2" value="#{EmployeeHistory$ComplaintPage_2.selectOneMenu3DefaultItems}"/>
                                                </ice:selectOneMenu>
                                            </ice:panelGrid>&gt;
                                </ice:panelCollapsible>
                                    </fieldset>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="south">
                            <ice:panelGroup id="page_footer" style=" text-align: center;">
                                <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">This is the
                                Footer</ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelBorder>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
