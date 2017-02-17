<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : ReportPage
    Created on : Feb 21, 2013, 10:29:08 AM
    Author     : Administrator 
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <ice:outputStyle href="./resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="./xmlhttp/css/xp/xp.css" id="outputStyle2"/>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <ice:commandButton action="#{Leave$ReportPage.button1_action}" id="button1" style="left: 408px; top: 168px; position: absolute" value="submit"/>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
