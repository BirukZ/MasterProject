<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2010, 7:48:31 AM
    Author     : DavePro
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <f:loadBundle basename="Localization.HRLocalization" var="msgs"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title></title>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:outputStyle href="./resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="/xmlhttp/css/rime/rime.css"/>
                <ice:form id="form1">
                    <ice:panelBorder height="480" id="whole_page" renderCenter="#{Page1.panelBorder1Bean.renderCenter}"
                        renderEast="#{Page1.panelBorder1Bean.renderEast}" renderNorth="#{Page1.panelBorder1Bean.renderNorth}"
                        renderSouth="#{Page1.panelBorder1Bean.renderSouth}" renderWest="#{Page1.panelBorder1Bean.renderWest}"
                        style="top: 0px; position: relative" styleClass="whole_page" width="1024">
                        <f:facet name="center">
                            <ice:panelGroup id="page_display" style="height: 348px">
                                <ice:panelLayout id="container" layout="flow"
                                    style="background-color: white; height: 310px; left: 0px; top: 100px; position: relative; width: 100%; -rave-layout: grid;border:none;" styleClass="page_display">
                                    <ice:panelLayout id="panelLayout1" style="height: 312px; position: absolute; width: 1054px; -rave-layout: grid">
                                        <ice:panelGrid id="pnlLogin"
                                            style="background-image: url(/resources/images/Login.png); height: 296px; left: 215px; top: 2px; position: absolute" width="502">
                                            <ice:panelLayout id="lblLoginHeader" layout="flow" style="position: absolute">
                                                <ice:outputLabel for="itxtUserName" id="outputLabel1"
                                                    style="left: 50px; top: -52px; position: absolute; width: 74px" value="*User Name" visible="true"/>
                                                <ice:outputLabel for="itxtPassword" id="outputLabel2" style="left: 53px; top: -13px; position: absolute" value="*Password"/>
                                                <ice:inputSecret binding="#{pageSecurity$Login.itxtPassword}" id="itxtPassword" required="true"
                                                    style="left: 156px; top: -16px; position: absolute; width: 172px" tabindex="2"/>
                                                <ice:inputText action="#{pageSecurity$Login.itxtUserName_action}" binding="#{pageSecurity$Login.itxtUserName}"
                                                    id="itxtUserName" required="true" style="left: 158px; top: -54px; position: absolute; width: 171px" tabindex="1"/>
                                                <ice:commandButton action="#{pageSecurity$Login.button1_action}" id="button1"
                                                    style="left: 199px; top: 41px; position: absolute; width: 95px" tabindex="3" value="Login"/>
                                                <ice:outputLink id="outputLink1" style="left: 385px; top: 36px; position: absolute" value="outputLink">
                                                    <ice:outputText id="outputText1" value="Forgot Your Password?"/>
                                                </ice:outputLink>
                                            </ice:panelLayout>
                                        </ice:panelGrid>
                                    </ice:panelLayout>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelBorder>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
