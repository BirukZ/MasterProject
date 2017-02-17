<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Page1
    Created on : Nov 6, 2011, 7:48:45 AM
    Author     : Admin
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
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <img alt="" class="source-image" height="1000px" id="img" src="../resources/images/"/>
                        <ice:panelBorder height="480" id="whole_page" renderCenter="#{Page1.panelBorder1Bean.renderCenter}"
                            renderEast="#{LookUpTables$DynamicTableloockupCreator.panelBorder1Bean.renderEast}"
                            renderNorth="#{LookUpTables$DynamicTableloockupCreator.panelBorder1Bean.renderNorth}"
                            renderSouth="#{LookUpTables$DynamicTableloockupCreator.panelBorder1Bean.renderSouth}"
                            renderWest="#{LookUpTables$DynamicTableloockupCreator.panelBorder1Bean.renderWest}" style="top: 0px; position: relative"
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
                            <f:facet name="west">
                                <ice:panelGroup id="menu_left" style="width: 215px">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height: 660px;top:25px; left: 5px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 655px;position: absolute; width: 213px" styleClass="list_menu">
                                            <ice:outputLabel id="lblSelect" style="left:  15px; top: 30px; position: absolute" value="Select Schema"/>
                                            <ice:panelLayout id="divLookUpWrp1" style="height: 500px; left: 0px; top: 78px; position: absolute; width: 206px" styleClass="lookUpBody">
                                                <ice:panelLayout id="panelLayout2" layout="flow"
                                                    style="height: 500px; overflow: auto; position: absolute; width: 213px; -rave-layout: grid" styleClass="insideContainerMain">
                                                    <ice:dataTable id="dataTable1" style="left: 0px; top: -10px; position: absolute; width: 100%"
                                                        value="#{LookUpTables$DynamicTableloockupCreator.tableList}" var="currentRow">
                                                        <ice:column id="column1" style="width: 181px">
                                                            <ice:outputText id="outputText1" value="#{currentRow['name']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="txtLookup" value="Look Up TAbles"/>
                                                            </f:facet>
                                                            <ice:rowSelector id="rwSelectorList1"
                                                                selectionListener="#{LookUpTables$DynamicTableloockupCreator.rwSelectorList_processMyEvent}" value="#{currentRow['selected']}"/>
                                                            <ice:outputText id="outputText3" value="#{item['name']}"/>
                                                        </ice:column>
                                                    </ice:dataTable>
                                                    <legend></legend>
                                                </ice:panelLayout>
                                            </ice:panelLayout>
                                            <ice:selectOneMenu binding="#{LookUpTables$DynamicTableloockupCreator.cmbSchemaName}" id="cmbSchemaName"
                                                partialSubmit="true" style="left: 15px; top: 50px; position: absolute; width: 130px"
                                                value="#{LookUpTables$DynamicTableloockupCreator.selectOneMenu1Bean.selectedObject}" valueChangeListener="#{LookUpTables$DynamicTableloockupCreator.cmbSchemaName_processValueChange}">
                                                <f:selectItems id="selectOneMenu1selectItems" value="#{LookUpTables$DynamicTableloockupCreator.schemaList}"/>
                                            </ice:selectOneMenu>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height: 680px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 700px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 650px;">
                                            <ice:outputLabel id="lblTableName" style="left: 26px; top: 30px; position: absolute" value="Table Name"/>
                                            <ice:inputText action="#{LookUpTables$DynamicTableloockupCreator.txtTableNames_action}"
                                                actionListener="#{LookUpTables$DynamicTableloockupCreator.txtTableNames_processAction}"
                                                binding="#{LookUpTables$DynamicTableloockupCreator.txtTableNames}" disabled="true" id="txtTableNames" style="height: 26px; left: 120px; top: 30px; position: absolute; width: 210px"/>
                                            <ice:panelLayout id="panelLayout1" layout="flow"
                                                style="height: 549px; left: 0px; top: 72px; overflow: auto; position: absolute; width: 766px; -rave-layout: grid" styleClass="insideContainerMain">
                                                <ice:dataTable columnWidths="60px" id="dataTable3" rows="#{LookUpTables$DynamicTableloockupCreator.rows}"
                                                    style="left: 14px; top: 14px; position: absolute; width: 95%"
                                                    value="#{LookUpTables$DynamicTableloockupCreator.rowDataModel}" var="item">
                                                    <ice:column id="column1" style="width: 2%">
                                                        <f:facet name="header">
                                                            <ice:outputText id="Counetr" value="No"/>
                                                        </f:facet>
                                                        <ice:rowSelector id="selectRow" selectionListener="#{LookUpTables$DynamicTableloockupCreator.selectRow_processAction}"/>
                                                        <ice:outputText id="outputText2" value="#{LookUpTables$DynamicTableloockupCreator.rowDataModel.rowIndex}"/>
                                                    </ice:column>
                                                    <ice:columns id="tdTableNames" value="#{LookUpTables$DynamicTableloockupCreator.columnDataModel}" var="colomn">
                                                        <f:facet name="header">
                                                            <ice:outputText id="rowData" value="#{LookUpTables$DynamicTableloockupCreator.columnDataModel.rowData}"/>
                                                        </f:facet>
                                                        <ice:outputText id="cellValue" style=" width:60px" value="#{LookUpTables$DynamicTableloockupCreator.cellValue}"/>
                                                    </ice:columns>
                                                </ice:dataTable>
                                                <ice:commandButton action="#{LookUpTables$DynamicTableloockupCreator.btnNew_action}"
                                                    actionListener="#{LookUpTables$DynamicTableloockupCreator.btnNew_processAction}"
                                                    binding="#{LookUpTables$DynamicTableloockupCreator.btnNew}" id="btnNew" image="/resources/images/add.png"
                                                    style="left: 720px; top: 0px; position: absolute" value="submit"/>
                                                <legend class="legend_css">
                                                    <ice:outputLabel value="Maintain Look Up Tables "/>
                                                </legend>
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
                        <ice:panelPopup autoCentre="true" binding="#{LookUpTables$DynamicTableloockupCreator.pnlPopUp}" clientOnly="true" draggable="true"
                            id="pnlPopUp" modal="true" rendered="false" style="height: 350px; left: 234px; top: 338px; position: absolute" styleClass="icePnlPop">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlPopUpHdr" style="background-color: rgb(48, 102, 130); height: 24px; width: 600px" styleClass="icePnlGrp">
                                    <ice:panelLayout id="pnlPopUpTtl" layout="flow" style="" styleClass="popUpHdrTtl">
                                        <ice:outputText binding="#{LookUpTables$DynamicTableloockupCreator.lblPopTitle}" id="lblPopTitle" style="color: white" value="#{msgs.lblPopTitle}"/>
                                    </ice:panelLayout>
                                    <ice:commandButton actionListener="#{LookUpTables$DynamicTableloockupCreator.imgPopX_processAction}" id="imgPopX"
                                        image="/resources/images/close.png" immediate="true" partialSubmit="true"
                                        style="padding: 5px 0 0 0; color: red; float: right; height: 17px" title="Close Popup" value="X"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout binding="#{LookUpTables$DynamicTableloockupCreator.pnlContainer}" id="pnlContainer" layout="flow"
                                    style="display: block; height: 267px; left: 1px; top: 27px; position: absolute; width: 595px; -rave-layout: grid" styleClass="popUpBody">
                                    <!--body element here-->
                                    <ice:commandButton action="#{LookUpTables$DynamicTableloockupCreator.btnSubmit_action}"
                                        actionListener="#{LookUpTables$DynamicTableloockupCreator.btnSubmit_processAction}"
                                        binding="#{LookUpTables$DynamicTableloockupCreator.btnSubmit}" id="btnSubmit" partialSubmit="true"
                                        style="position: absolute; left: 24px; top: 240px" value="Submit"/>
                                    <ice:commandButton actionListener="#{LookUpTables$DynamicTableloockupCreator.btnUpdate_processAction}"
                                        binding="#{LookUpTables$DynamicTableloockupCreator.btnUpdate}" id="btnUpdate" partialSubmit="true"
                                        style="left: 135px; top: 241px; position: absolute" value="Upadte"/>
                                </ice:panelLayout>
                            </f:facet>
                        </ice:panelPopup>
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
