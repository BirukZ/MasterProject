<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : DocumentRequestReport
    Created on : Oct 21, 2011, 8:36:53 AM
    Author     : Bini
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <f:loadBundle basename="Localization.HRLocalization" var="msgs"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <script src="DataTables-1.9.2/media/js/jquery.js" type="text/javascript"></script>
                <title>የሰነድ ጥየቃ ሪፖርት</title>
                <script src="DataTables-1.9.2/media/js/jquery.dataTables.min.js" type="text/javascript"></script>
                <script src="DataTables-1.9.2/extras/ColVis/media/js/ColVis.js" type="text/javascript"></script>
                <script src="DataTables-1.9.2/extras/TableTools/media/js/TableTools.js" type="text/javascript"></script>
                <script src="DataTables-1.9.2/extras/TableTools/media/js/ZeroClipboard.js" type="text/javascript"></script>
                <script src="DataTables-1.9.2/extras/ColReorder/media/js/ColReorder.js" type="text/javascript"></script>
                <script type="text/javascript">
                    var DocumentRequestReport=jQuery.noConflict();
                    var element = document.getElementById("[id='form1:dataTable1']");

                    DocumentRequestReport(document).ready(function () {
                        DocumentRequestReport("[id='form1:dataTable1']").dataTable({
                            "sDom": 'CT"clear"Rlfrtip',
                            "oTableTools": {
                                "sSwfPath": "DataTables-1.9.2/extras/TableTools/media/swf/copy_csv_xls_pdf.swf"
                            },
                            "sPaginationType": "full_numbers"
                        });
                    });
                </script>
                <link href="DataTables-1.9.2/media/css/demo_page.css" rel="stylesheet" type="text/css"/>
                <link href="DataTables-1.9.2/media/css/demo_table.css" rel="stylesheet" type="text/css"/>
                <link href="DataTables-1.9.2/media/css/demo_table_jui.css" rel="stylesheet" type="text/css"/>
                <link href="DataTables-1.9.2/media/js/jquery.dataTables.min.js" media="all" rel="stylesheet" type="text/css"/>
                <link href="media/themes/smoothness/jquery-ui-1.7.2.custom.css" media="all" rel="stylesheet" type="text/css"/>
                <link href="DataTables-1.9.2/extras/TableTools/media/css/TableTools.css" rel="stylesheet" type="text/css"/>
                <link href="DataTables-1.9.2/extras/TableTools/media/css/TableTools_JUI.css" rel="stylesheet" type="text/css"/>
                <link href="DataTables-1.9.2/extras/ColVis/media/css/ColVis.css" rel="stylesheet" type="text/css"/>
                <link href="DataTables-1.9.2/extras/ColReorder/media/css/ColReorder.css" rel="stylesheet" type="text/css"/>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <h:form id="form1">
                    <h:dataTable headerClass="list-header" id="dataTable1" rowClasses="list-row-even,list-row-odd"
                        style="left: 24px; top: 120px; position: absolute" styleClass="display"
                        value="#{Routines$DocumentRequestReport.docReportManagerList}" var="currentRow">
                         <th colspan="1" rowspan="3">HHHHH</th>
                         <th colspan="1" rowspan="3">HHHHH</th>
                        <h:column id="column4">
                            <h:outputText id="outputText7" value="#{currentRow['requesterId']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText8" value="የጠያቂው ሠራተኛ መለያ ቁጥር"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column5">
                            <h:outputText id="outputText9" value="#{currentRow['requesterFullName']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText10" value="የጠያቂው የሠራተኛ ሥም"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column66">
                            <h:outputText id="outputText611" value="#{currentRow['requesterJob']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText612" value="የጠያቂው የሠራተኛ ሥም"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column6">
                            <h:outputText id="outputText11" value="#{currentRow['requesterDept']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText12" value="የጠያቂው ሠራተኛ የሥራ ክፍል"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column7">
                            <h:outputText id="outputText13" value="#{currentRow['requestedDocType']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText15" value="የማስረጃ ዓይነት"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column8">
                            <h:outputText id="outputText14" value="#{currentRow['requestedDate']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText16" value="ቀን"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column9">
                            <h:outputText id="outputText17" value="#{currentRow['requestedDocNum']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText18" value="ቁጥር"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column10">
                            <h:outputText id="outputTexts18" value="#{currentRow['reason']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText19" value="ማስረጃው የተጠየቀበት ምክንያት"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column11">
                            <h:outputText id="outputText20" value="#{currentRow['issuedDate']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText21" value="ማስረጃው የተፈቀደበት ቀን"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column12">
                            <h:outputText id="outputText22" value="#{currentRow['approverId']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText23" value="መለያ ቁጥር"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column13">
                            <h:outputText id="outputText24" value="#{currentRow['approverFullName']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText25" value="ሥም"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column14">
                            <h:outputText id="outputText26" value="#{currentRow['approverJob']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText27" value="የሥራ መደብ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column15">
                            <h:outputText id="outputText28" value="#{currentRow['approverDept']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText29" value="የሥራ ክፍል"/>
                            </f:facet>
                        </h:column>
                    </h:dataTable>
                </h:form>
            </body>
        </html>
    </f:view>
</jsp:root>
