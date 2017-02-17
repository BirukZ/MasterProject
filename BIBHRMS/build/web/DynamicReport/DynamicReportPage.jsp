<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : DynamicReportPage
    Created on : Jul 26, 2012, 3:44:27 PM
    Author     : tomgenial
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Employee Report</title>
                <style type="text/css">
                    /* common to all columns*/
                    .stockColumn, .modelColumn, .desriptionColumn, .odometerColumn, .priceColumn{
                        border-right: 1px solid #666666;
                        border-bottom: 1px solid #666666;
                    }

                    .stockColumn{
                        width: 80px;
                    }

                    .modelColumn{
                        width: 225px;
                    }

                    .desriptionColumn{
                        width: 150px;
                    }

                    .odometerColumn{
                        width: 90px;
                    }

                    .priceColumn{
                        width: 75px;
                    }

                    .tableStyle{
                        border-color:#ffffff #ffffff #cccccc #ffffff;
                        border-style:solid solid solid solid;
                        border-width:1px 0px 1px 0px;
                    }

                    .oddRow{

                        color:          #000000;
                        background-color:#EAEFF5;
                    }

                    .evenRow{
                        color:          #000000;
                        background-color:#F2F2F5;
                    }




                </style>
                <script language="javascript" type="text/javascript">
                    function toggleDiv()        {
                        if (document.getElementById("divContainer").style.visibility == "hidden")
                        {
                            document.getElementById("divContainer").style.visibility = "visible";
                        }
                        else {
                            document.getElementById("divContainer").style.visibility = "hidden";
                        }
                    }
                </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <ice:panelLayout id="container" layout="flow"
                        style="height: 940px; left: 0px; top: 62px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                        <ice:commandButton action="#{DynamicReport$DynamicReportPage.btnDisplay_action}" binding="#{DynamicReport$DynamicReportPage.btnDisplay}"
                            id="btnDisplay" style="font-size: 18px; height: 36px; left: 600px; top: 180px; position: absolute; width: 192px" value="Get Report"/>
                        <ice:selectOneMenu binding="#{DynamicReport$DynamicReportPage.drlViewName}" id="drlViewName" partialSubmit="true"
                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Times New Roman',Times,serif; font-size: 14px; font-style: normal; font-weight: lighter; height: 30px; left: 420px; top: 130px; position: absolute; text-align: center; width: 522px" value="#{DynamicReport$DynamicReportPage.selectOneMenu3Bean.selectedObject}">
                            <f:selectItems id="selectOneMenu3selectItems" value="#{DynamicReport$DynamicReportPage.viewList}"/>
                        </ice:selectOneMenu>
                        <div style="width: 1604px ;margin-left: auto ;margin-right: auto ;top:20px;overflow:auto;text-align:center">
                            <ice:inputText binding="#{DynamicReport$DynamicReportPage.txtHeader}" id="txtHeader" rendered="false"
                                style="border-style: none none solid none; background-color: rgb(239, 239, 240); border-bottom-color: rgb(0, 0, 0); border-bottom-width: 1px; color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 18px; font-style: normal; font-weight: lighter; margin-left: auto; top: 0px; position: relative; text-align: center; width: 648px" value="Report Header"/>
                            <ice:dataTable binding="#{DynamicReport$DynamicReportPage.tableReport}" columnClasses="stockColumn, modelColumn, desriptionColumn"
                                id="tableReport" rendered="false" rowClasses="oddRow, evenRow" rows="#{DynamicReport$DynamicReportPage.rows}"
                                value="#{DynamicReport$DynamicReportPage.rowDataModel}" var="item">
                                <ice:column id="column1" style="width: 1%">
                                    <f:facet name="header">
                                        <ice:outputText id="Counetr" value="No"/>
                                    </f:facet>
                                    <ice:outputText id="outputText2" value="#{DynamicReport$DynamicReportPage.rowDataModel.rowIndex}"/>
                                </ice:column>
                                <ice:columns id="tdTableNames" value="#{DynamicReport$DynamicReportPage.columnDataModel}" var="colomn">
                                    <f:facet name="header">
                                        <ice:outputText id="rowData" value="#{DynamicReport$DynamicReportPage.columnDataModel.rowData}"/>
                                    </f:facet>
                                    <ice:outputText id="cellValue" style="text-align: left;" value="#{DynamicReport$DynamicReportPage.cellValue}"/>
                                </ice:columns>
                            </ice:dataTable>
                        </div>
                    </ice:panelLayout>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
