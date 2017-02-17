<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Template
    Created on : Feb 26, 2010, 7:48:31 AM
    Author     : BravoZulu
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title></title>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:outputStyle href="../resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="../xmlhttp/css/rime/rime.css"/>
                <ice:form id="form1">
                    <ice:panelBorder height="480" id="whole_page" renderCenter="#{pageSecurity$ResetPassword.panelBorder1Bean.renderCenter}"
                        renderEast="#{pageSecurity$ResetPassword.panelBorder1Bean.renderEast}"
                        renderNorth="#{pageSecurity$ResetPassword.panelBorder1Bean.renderNorth}"
                        renderSouth="#{pageSecurity$ResetPassword.panelBorder1Bean.renderSouth}"
                        renderWest="#{pageSecurity$ResetPassword.panelBorder1Bean.renderWest}" style="top: 0px; position: relative" styleClass="whole_page" width="1024">
                        <f:facet name="north">
                            <ice:panelGroup dragListener="#{pageSecurity$ResetPassword.panelBorder1north_processMyEvent}" id="page_header" style="height: 117px">
                                <!-- Begin Header -->
                                <ice:panelLayout id="header" layout="flow" style="height: 129px; left: 0px; position: relative; width: 100%; -rave-layout: grid"
                                    styleClass="header" visible="true"/>
                                <!-- End Header -->
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="center">
                            <ice:panelGroup id="page_display" style="height: 438px">
                                <ice:panelLayout id="container" layout="flow"
                                    style="height: 419px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                    <fieldset class="filedset_css" style="height: 400px;">
                                        <legend class="legend_css">
                                            <ice:outputLabel value="Manage Your User Name And Pasword Here "/>
                                        </legend>
                                        <ice:panelLayout id="pnProfile" style="height: 427px; left: 0px; top: -20px; position: absolute; width: 100%">
                                            <ice:panelGroup dragListener="#{EmployeeTermination$TerminationRequestPage.RetirementApproval_processMyEvent}"
                                                id="RetirementApproval" style="height: 344px;width:970px" styleClass="filedset_border">
                                                <ice:messages errorClass="errorMessage" fatalClass="fatalMessage" id="messages1" infoClass="infoMessage"
                                                    showSummary="true"
                                                    style="color: rgb(255, 153, 51); height: 31px; left: 136px; top: 232px; position: absolute; width: 697px"
                                                    title="Error processing your request" warnClass="warnMessage"/>
                                                <ice:panelLayout binding="#{pageSecurity$ResetPassword.panelLayoutInserUserName}" id="panelLayoutInserUserName" style="border-width: 1px;height: 132px; left: 114px; top: 95px; position: absolute; width: 714px">
                                                    <ice:outputLabel id="outputLabel3" style="font-size: 11px; left: 54px; top: 45px; position: absolute" value="Please enter your username"/>
                                                    <ice:inputText binding="#{pageSecurity$ResetPassword.txtUserName}" id="txtUserName" style="left: 237px; top: 40px; position: absolute; width: 264px"/>
                                                    <ice:commandButton action="#{pageSecurity$ResetPassword.btnGetUserQuestion_action}" id="btnGetUserQuestion"
                                                        style="left: 387px; top: 86px; position: absolute; width: 116px" value="Next &gt;"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtUserName" id="message1"
                                                        infoClass="infoMessage" showSummary="true"
                                                        style="font-size: 11px; left: 530px; top: 38px; position: absolute" warnClass="warnMessage"/>
                                                </ice:panelLayout>
                                                <ice:panelLayout binding="#{pageSecurity$ResetPassword.panelLayoutAnswerSeqQuestion}"
                                                    id="panelLayoutAnswerSeqQuestion" rendered="false" style="border-width: 1px; height: 132px; left: 114px; top: 95px; position: absolute; width: 714px">
                                                    <ice:outputLabel id="outputLabel4" style="font-size: 11px; left: 20px; top: 45px; position: absolute" value="Please answer your secret question"/>
                                                    <ice:outputText binding="#{pageSecurity$ResetPassword.staticSecurityQuestion}" id="staticSecurityQuestion" style="color: #336600; font-size: 11px; font-weight: bold; left: 240px; top: 6px; position: absolute; width: 416px"/>
                                                    <ice:inputText binding="#{pageSecurity$ResetPassword.txtAnswerToQuestion}" id="txtAnswerToQuestion" style="left: 237px; top: 40px; position: absolute; width: 264px"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtAnswerToQuestion" id="message2"
                                                        infoClass="infoMessage" showSummary="true" style="left: 530px; top: 38px; position: absolute" warnClass="warnMessage"/>
                                                    <ice:commandButton action="#{pageSecurity$ResetPassword.btnCheckUserAnswer_action}" id="btnCheckUserAnswer"
                                                        style="left: 387px; top: 86px; position: absolute; width: 116px" value="Next &gt;"/>
                                                </ice:panelLayout>
                                                <ice:panelLayout binding="#{pageSecurity$ResetPassword.panelLayoutINserNewPassWord}"
                                                    id="panelLayoutINserNewPassWord" rendered="false" style="border-width: 1px;height: 132px; left: 114px; top: 95px; position: absolute; width: 714px">
                                                    <ice:outputLabel id="outputLabel5" style="font-size: 11px; left: 100px; top: 26px; position: absolute" value="New Password"/>
                                                    <ice:outputLabel id="outputLabel6" style="font-size: 11px; left: 100px; top: 61px; position: absolute" value="Re-type New  Password"/>
                                                    <ice:commandButton action="#{pageSecurity$ResetPassword.btnResetUserPassword_action}"
                                                        id="btnResetUserPassword" style="left: 352px; top: 87px; position: absolute; width: 152px" value=" Save and Finish"/>
                                                    <ice:inputSecret binding="#{pageSecurity$ResetPassword.txtNewUserPassword}" id="txtNewUserPassword" style="left: 239px; top: 20px; position: absolute; width: 264px"/>
                                                    <ice:inputSecret binding="#{pageSecurity$ResetPassword.txtRetypedUserPassword}" id="txtRetypedUserPassword" style="left: 237px; top: 57px; position: absolute; width: 264px"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtRetypedUserPassword" id="message3"
                                                        infoClass="infoMessage" showSummary="true" style="left: 435px; top: 61px; position: absolute" warnClass="warnMessage"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtNewUserPassword" id="message4"
                                                        infoClass="infoMessage" showSummary="true" style="left: 435px; top: 23px; position: absolute" warnClass="warnMessage"/>
                                                </ice:panelLayout>
                                                <ice:outputLabel binding="#{pageSecurity$ResetPassword.alertPasswordChangeStatus}"
                                                    id="alertPasswordChangeStatus" style="color: green; left: 131px; top: 54px; position: absolute; width: 692px"/>
                                            </ice:panelGroup>
                                        </ice:panelLayout>
                                    </fieldset>
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
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
