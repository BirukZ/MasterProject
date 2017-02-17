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
                <ice:outputStyle href="/xmlhttp/css/xp/xp.css"/>
                <ice:form id="form1">
                    <ice:panelBorder height="480" id="whole_page" renderCenter="#{Page1.panelBorder1Bean.renderCenter}"
                        renderEast="#{Page1.panelBorder1Bean.renderEast}" renderNorth="#{Page1.panelBorder1Bean.renderNorth}"
                        renderSouth="#{Page1.panelBorder1Bean.renderSouth}" renderWest="#{Page1.panelBorder1Bean.renderWest}"
                        style="top: 0px; position: relative" styleClass="whole_page" width="1024">
                        <f:facet name="center">
                            <ice:panelGroup id="page_display" style="height: 393px">
                                <ice:panelLayout id="container" layout="flow"
                                    style="height: 354px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                    <ice:panelLayout id="pnlError" style="height: 226px; margin-left: 250px; left: -112px; top: 31px; position: absolute; width: 719px">
                                        <ice:commandButton action="#{ResourceNotFound.btnHome_action}" id="btnHome" immediate="true" style="background-image: url(Home.gif); background-repeat: repeat; font-family: 'Cambria'; font-size: 18px; font-style: normal; font-weight: bold; height: 50px; left: 304px; top: 209px; position: absolute; text-indent: 5px; vertical-align: middle; width: 53px; background-attachment: scroll"/>
                                        <ice:graphicImage id="graphicImage1" value="/ResourceNotFound.png"/>
                                    </ice:panelLayout>
                                </ice:panelLayout>
                                <ice:panelLayout id="footer" style="background:none;height: 21px;top:25px; left: 0px; position: relative;font-family:Cambria;font-size:12px;font-weight:bold;text-align:center">Bunna International Bank Human Resource Management System.</ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelBorder>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
