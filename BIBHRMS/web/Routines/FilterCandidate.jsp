<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : FilterCandidate
    Created on : Jul 20, 2012, 10:34:58 AM
    Author     : HRMS
-->

<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Filter candidate</title>
                <script src="../resources/DataTables-1.9.2/media/js/jquery.js" type="text/javascript"></script>
                <title>HRMS Reports</title>
                <script src="../resources/DataTables-1.9.2/media/js/jquery.dataTables.min.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/ColVis/media/js/ColVis.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/TableTools/media/js/TableTools.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/TableTools/media/js/ZeroClipboard.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/ColReorder/media/js/ColReorder.js" type="text/javascript"></script>
                <script type="text/javascript">
                    var EmployeeEducationReport=jQuery.noConflict();
                    var element = document.getElementById("[id='form1:dataTable1']");

                    EmployeeEducationReport(document).ready(function () {
                        EmployeeEducationReport("[id='form1:dataTable1']").dataTable({
                            "sDom": 'CT"clear"Rlfrtip',
                            "oTableTools": {
                                "sSwfPath": "../resources/DataTables-1.9.2/extras/TableTools/media/swf/copy_csv_xls_pdf.swf"
                            },
                            "sPaginationType": "full_numbers"
                        });
                    });
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
                <h:form id="form1">
                    <h:dataTable headerClass="list-header" id="dataTable1" rowClasses="list-row-even,list-row-odd"
                                 style="left: 24px; top: 120px; position: absolute" styleClass="display"
                                 value="#{Routines$FilterCandidate.filterCandidateReportList}" var="currentRow">
                        <h:column id="column4">
                            <h:outputText id="outputText7" value="#{currentRow['jobType']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText8" value="Job Title"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column5">
                            <h:outputText id="outputText9" value="#{currentRow['rank']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText10" value="Rank"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column6">
                            <h:outputText id="outputText11" value="#{currentRow['candidate_ID']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText12" value="CandidateID"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column7">
                            <h:outputText id="outputText13" value="#{currentRow['sex']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText15" value="Sex"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column8">
                            <h:outputText id="outputText14" value="#{currentRow['age']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText16" value="Age"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column9">
                            <h:outputText id="outputText17" value="#{currentRow['writenExam']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText18" value="Writen Exam"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column11">
                            <h:outputText id="outputText24" value="#{currentRow['interviewExam']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText25" value="Interview"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column12">
                            <h:outputText id="outputText26" value="#{currentRow['practicalExam']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText27" value="Practical"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column13">
                            <h:outputText id="outputText28" value="#{currentRow['totalResult']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText29" value="Total"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column14">
                            <h:outputText id="outputText30" value="#{currentRow['cgpa']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText31" value="CGPA"/>
                            </f:facet>
                        </h:column>

                        <h:column id="column15">
                            <h:outputText id="outputText32" value="#{currentRow['experience']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText33" value="Experience"/>
                            </f:facet>
                        </h:column>
                        <h:column id="colExpr">
                            <h:outputText id="outputTextExpr" value="#{currentRow['experience']}"/>
                            <f:facet name="header">
                                <h:outputText id="outpExpr" value="Rank"/>
                            </f:facet>
                        </h:column>
                    </h:dataTable>
                </h:form>
            </body>
        </html>
    </f:view>
</jsp:root>