<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : ExpireLeaveReportPage
    Created on : Nov 29, 2012, 5:23:35 PM
    Author     : Administrator 
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Leave Report</title>
                <script src="../resources/DataTables-1.9.2/media/js/jquery.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/media/js/jquery.dataTables.min.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/ColVis/media/js/ColVis.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/TableTools/media/js/TableTools.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/TableTools/media/js/ZeroClipboard.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/ColReorder/media/js/ColReorder.js" type="text/javascript"></script>
                <script type="text/javascript">
                    var ExpireLeaveReportPage=jQuery.noConflict();
                    var element = document.getElementById("[id='form1:dataTable1']");

                    ExpireLeaveReportPage(document).ready(function () {
                        ExpireLeaveReportPage("[id='form1:dataTable1']").dataTable({
                            "sDom": 'CT"clear"Rlfrtip',
                            "oTableTools": {
                                "sSwfPath": "../resources/DataTables-1.9.2/extras/TableTools/media/swf/copy_csv_xls_pdf.swf"
                            },
                            "sPaginationType": "full_numbers"
                        });
                    });

                   ExpireLeaveReportPage(document).ready(function() {
                        oTable = $('#outputText1').dataTable({
                            "bJQueryUI": true,
                            "sPaginationType": "full_numbers"
                        });
                    } );

                </script>
                <link href="../resources/DataTables-1.9.2/media/css/demo_page.css" rel="stylesheet" type="text/css"/>
                <link href="../resources/DataTables-1.9.2/media/css/demo_table.css" rel="stylesheet" type="text/css"/>
                <link href="../resources/DataTables-1.9.2/media/css/demo_table_jui.css" rel="stylesheet" type="text/css"/>
                <link href="../resources/DataTables-1.9.2/media/js/jquery.dataTables.min.js" media="all" rel="stylesheet" type="text/css"/>
                <link href="../resources/media/themes/smoothness/jquery-ui-1.7.2.custom.css" media="all" rel="stylesheet" type="text/css"/>
                <link href="../resources/DataTables-1.9.2/extras/TableTools/media/css/TableTools.css" rel="stylesheet" type="text/css"/>
                <link href="../resources/DataTables-1.9.2/extras/TableTools/media/css/TableTools_JUI.css" rel="stylesheet" type="text/css"/>
                <link href="../resources/DataTables-1.9.2/extras/ColVis/media/css/ColVis.css" rel="stylesheet" type="text/css"/>
                <link href="../resources/DataTables-1.9.2/extras/ColReorder/media/css/ColReorder.css" rel="stylesheet" type="text/css"/>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <ice:dataTable id="dataTable1" style="left: 24px; top: 120px; position: absolute" value="#{Report$ExpireLeaveReportPage.dataTable1Model}" var="currentRow">
                        <ice:column id="column1">
                            <ice:outputText id="outputText1" value="#{currentRow['COLUMN1']}"/>
                            <f:facet name="header">
                                <ice:outputText id="outputText2" style="font-family: Nyala,'Visual Geez Unicode'" value="መታወቂያ ቁጥር"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="column2">
                            <ice:outputText id="outputText3" value="#{currentRow['COLUMN2']}"/>
                            <f:facet name="header">
                                <ice:outputText id="outputText4" style="font-family: Nyala,'Visual Geez Unicode'" value="ሠራተኛ ሥም"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="column3">
                            <ice:outputText id="outputText5" value="#{currentRow['COLUMN3']}"/>
                            <f:facet name="header">
                                <ice:outputText id="outputText6" style="font-family: Nyala,'Visual Geez Unicode'" value="ጾታ"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="column3">
                            <ice:outputText id="outputText5" value="#{currentRow['COLUMN3']}"/>
                            <f:facet name="header">
                                <ice:outputText id="outputText6" style="font-family: Nyala,'Visual Geez Unicode'" value="የ 2004 ዓ.ም"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="column3">
                            <ice:outputText id="outputText5" value="#{currentRow['COLUMN3']}"/>
                            <f:facet name="header">
                                <ice:outputText id="outputText6" style="font-family: Nyala,'Visual Geez Unicode'" value="የተላለፈ "/>
                            </f:facet>
                        </ice:column>
                    </ice:dataTable>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
