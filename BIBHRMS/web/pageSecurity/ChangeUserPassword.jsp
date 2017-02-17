<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Template
    Created on : Feb 26, 2010, 7:48:31 AM
    Author     : modified by BravoZulu
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
                <ice:form binding="#{pageSecurity$ChangeUserPassword.form1}" id="form1">
                    <ice:panelBorder height="480" id="whole_page" renderCenter="#{pageSecurity$ChangeUserPassword.panelBorder1Bean.renderCenter}"
                        renderEast="#{pageSecurity$ChangeUserPassword.panelBorder1Bean.renderEast}"
                        renderNorth="#{pageSecurity$ChangeUserPassword.panelBorder1Bean.renderNorth}"
                        renderSouth="#{pageSecurity$ChangeUserPassword.panelBorder1Bean.renderSouth}"
                        renderWest="#{pageSecurity$ChangeUserPassword.panelBorder1Bean.renderWest}" style="top: 0px; position: relative" styleClass="whole_page" width="1024">
                        <f:facet name="north">
                            <ice:panelGroup dragListener="#{pageSecurity$ChangeUserPassword.panelBorder1north_processMyEvent}" id="page_header" style="height: -5px"/>
                        </f:facet>
                        <f:facet name="west"/>
                        <f:facet name="center">
                            <ice:panelGroup id="page_display" style="height: 438px">
                                <ice:panelLayout id="container" layout="flow"
                                    style="height: 419px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                    <fieldset class="filedset_css" style="height: 400px;">
                                        <legend class="legend_css">
                                            <ice:outputLabel value="Manage Your User Name And Pasword Here "/>
                                        </legend>
                                        <ice:panelLayout id="pnProfile" style="height: 427px; left: 0px; top: 20px; position: absolute; width: 100%">
                                            <ice:panelGroup dragListener="#{EmployeeTermination$TerminationRequestPage.RetirementApproval_processMyEvent}"
                                                id="RetirementApproval" style="height: 344px;width:970px" styleClass="filedset_border">
                                                <ice:selectBooleanCheckbox binding="#{pageSecurity$ChangeUserPassword.chkChangeUsername}" id="chkChangeUsername"
                                                    immediate="true" partialSubmit="true" style="left: 390px; top: 53px; position: absolute"
                                                    value="#{pageSecurity$ChangeUserPassword.selectBooleanCheckbox1Bean.selectedBoolean}" valueChangeListener="#{pageSecurity$ChangeUserPassword.chkChangeUsername_processValueChange}"/>
                                                <ice:outputLabel id="outputLabel4" style="font-size: 11px; left: 415px; top: 50px; position: absolute" value="Change user name"/>
                                                <ice:outputLabel for="pwdNewPassword" id="outputLabel6"
                                                    style="font-size: 10px; left: 160px; top: 155px; position: absolute" value="New Password"/>
                                                <ice:outputLabel for="pwdOldpassword" id="outputLabel7"
                                                    style="font-size: 10px; left: 160px; top: 117px; position: absolute" value="Old Password"/>
                                                <ice:outputLabel for="pwdNewPasswordRetyped" id="outputLabel8"
                                                    style="font-size: 10px; left: 160px; top: 185px; position: absolute" value="Re-type New Password"/>
                                                <ice:outputLabel for="ddSecurityQuestion" id="outputLabel9"
                                                    style="font-size: 10px; left: 160px; top: 225px; position: absolute" value="Security Question"/>
                                                <ice:outputLabel for="txtAnswerToQuestion" id="outputLabel10"
                                                    style="font-size: 10px; left: 160px; top: 257px; position: absolute" value="Answer to security question"/>
                                                <ice:inputText binding="#{pageSecurity$ChangeUserPassword.txtUserName}" disabled="true" id="txtUserName"
                                                    required="true"
                                                    style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 300px; top: 80px; position: absolute; width: 216px"
                                                    tabindex="1" validator="#{pageSecurity$ChangeUserPassword.txtUserName_validate}"/>
                                                <ice:inputText binding="#{pageSecurity$ChangeUserPassword.txtAnswerToQuestion}" id="txtAnswerToQuestion"
                                                    required="true"
                                                    style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 300px; top: 252px; position: absolute; width: 284px" tabindex="6"/>
                                                <ice:selectOneMenu binding="#{pageSecurity$ChangeUserPassword.ddSecurityQuestion}" id="ddSecurityQuestion"
                                                    required="true"
                                                    style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 300px; top: 217px; position: absolute; width: 284px"
                                                    tabindex="5" validator="#{pageSecurity$ChangeUserPassword.ddSecurityQuestion_validate}"
                                                    value="#{pageSecurity$ChangeUserPassword.selectOneMenu1Bean.selectedObject}" valueChangeListener="#{pageSecurity$ChangeUserPassword.ddSecurityQuestion_processValueChange}">
                                                    <f:selectItems id="selectOneMenu1selectItems" value="#{pageSecurity$ChangeUserPassword.sequrityQuestions}"/>
                                                </ice:selectOneMenu>
                                                <ice:commandButton action="#{pageSecurity$ChangeUserPassword.btnSavePasswordChange_action}"
                                                    id="btnSavePasswordChange" style="left: 497px; top: 290px; position: absolute; width: 155px" tabindex="7" value="Save and Continue"/>
                                                <ice:inputSecret binding="#{pageSecurity$ChangeUserPassword.pwdOldpassword}" id="pwdOldpassword" required="true"
                                                    style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-style: normal; font-weight: lighter; left: 300px; top: 115px; position: absolute; width: 216px" tabindex="2"/>
                                                <ice:inputSecret binding="#{pageSecurity$ChangeUserPassword.pwdNewPasswordRetyped}" id="pwdNewPasswordRetyped"
                                                    required="true"
                                                    style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-style: normal; font-weight: lighter; left: 300px; top: 183px; position: absolute; width: 216px"
                                                    tabindex="4" validator="#{pageSecurity$ChangeUserPassword.pwdNewPasswordRetyped_validate}"/>
                                                <ice:inputSecret binding="#{pageSecurity$ChangeUserPassword.pwdNewPassword}" id="pwdNewPassword" required="true"
                                                    style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-style: normal; font-weight: lighter; left: 300px; top: 148px; position: absolute; width: 216px"
                                                    tabindex="3" validator="#{pageSecurity$ChangeUserPassword.pwdNewPassword_validate}"/>
                                                <ice:panelLayout binding="#{pageSecurity$ChangeUserPassword.panelNewUser}" id="panelNewUser" rendered="false"
                                                    style="border-width: 1px; height: 98px; left: 601px; top: 45px; position: absolute; width: 387px" visible="true">
                                                    <ice:outputLabel for="txtNewUser" id="outputLabel12"
                                                        style="font-size: 10px; left: 1px; top: 42px; position: absolute; width: 113px" value="Enter New User Name"/>
                                                    <ice:inputText binding="#{pageSecurity$ChangeUserPassword.txtNewUser}" id="txtNewUser" required="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 111px; top: 35px; position: absolute; width: 216px"/>
                                                    <ice:commandButton action="#{pageSecurity$ChangeUserPassword.btnCheckUserAvail_action_action}"
                                                        id="btnCheckUserAvail_action" immediate="true" partialSubmit="true"
                                                        style="left: 192px; top: -5px; position: absolute; width: 138px" value="Cheque Avalability"/>
                                                    <ice:outputText binding="#{pageSecurity$ChangeUserPassword.staticTextAvalability}"
                                                        id="staticTextAvalability" style="height: 16px; left: 20px; top: 67px; position: absolute; width: 347px" value="#{pageSecurity$ChangeUserPassword.userNameCheckcompleteMsg}"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtNewUser" id="message7"
                                                        infoClass="infoMessage" style="font-size: 11px; left: 326px; top: 14px; position: absolute" warnClass="warnMessage"/>
                                                </ice:panelLayout>
                                                <ice:outputLabel id="outputLabel5" style="font-size: 10px; left: 160px; top: 86px; position: absolute" value="User Name"/>
                                                <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtUserName" id="message1"
                                                    infoClass="infoMessage" style="font-size: 11px; left: 530px; top: 85px; position: absolute; width: 135px" warnClass="warnMessage"/>
                                                <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="pwdOldpassword" id="message2"
                                                    infoClass="infoMessage" style="font-size: 11px; left: 530px; top: 120px; position: absolute; width: 131px" warnClass="warnMessage"/>
                                                <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="pwdNewPassword" id="message3"
                                                    infoClass="infoMessage" style="font-size: 11px; left: 530px; top: 155px; position: absolute; width: 137px" warnClass="warnMessage"/>
                                                <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="pwdNewPasswordRetyped" id="message4"
                                                    infoClass="infoMessage" style="font-size: 11px; left: 530px; top: 190px; position: absolute; width: 141px" warnClass="warnMessage"/>
                                                <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="ddSecurityQuestion" id="message5"
                                                    infoClass="infoMessage" style="font-size: 11px; left: 600px; top: 225px; position: absolute; width: 167px" warnClass="warnMessage"/>
                                                <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtAnswerToQuestion" id="message6"
                                                    infoClass="infoMessage" style="font-size: 11px; left: 600px; top: 260px; position: absolute; width: 177px" warnClass="warnMessage"/>
                                                <ice:outputLabel binding="#{pageSecurity$ChangeUserPassword.lblFormMessage}" id="lblFormMessage" style="color: #336600; font-weight: bold; left: 380px; top: -30px; position: absolute; width: 584px"/>
                                            </ice:panelGroup>
                                        </ice:panelLayout>
                                    </fieldset>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="south">
                            <ice:panelGroup id="page_footer" style=" text-align: center;">
                                <ice:panelLayout id="footer" layout="flow"
                                    style="background:none;height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">
                                    <p style="float:right">Bunna International Bank Human Resource Administarion.</p>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelBorder>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
