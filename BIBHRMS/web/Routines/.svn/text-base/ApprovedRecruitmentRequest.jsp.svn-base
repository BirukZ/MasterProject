<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : ApprovedRecruitmentRequest
    Created on : Jul 17, 2012, 6:23:00 AM
    Author     : HRMS
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <f:loadBundle basename="Localization.HRLocalization" var="msgs"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Approved Recruitment Request</title>
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
                        value="#{Routines$ApprovedRecruitmentRequest.recruitmentApproveReportList}" var="currentRow">
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
                            <h:outputText id="outputText11" value="#{currentRow['salary']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText12" value="Initial Salary"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column7">
                            <h:outputText id="outputText13" value="#{currentRow['chief']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText15" value="Chief Excutive Officer"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column8">
                            <h:outputText id="outputText14" value="#{currentRow['directorate']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText16" value="Directorate Director"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column9">
                            <h:outputText id="outputText17" value="#{currentRow['process']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText18" value="Process Head"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column11">
                            <h:outputText id="outputText24" value="#{currentRow['workingPla']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText25" value="Working place"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column12">
                            <h:outputText id="outputText26" value="#{currentRow['numberRequiredEmployee']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText27" value="Number Required"/>
                            </f:facet>
                        </h:column>

                        <h:column id="column13">
                            <h:outputText id="outputText28" value="#{currentRow['educType']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText29" value="Educ Type"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column81">
                            <h:outputText id="outputText83" value="#{currentRow['educLevel']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText93" value="Educ Level"/>
                            </f:facet>
                        </h:column>

                        <h:column id="column14">
                            <h:outputText id="outputText30" value="#{currentRow['minExp']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText31" value="Experience"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column15">
                            <h:outputText id="outputText32" value="#{currentRow['addSkill']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText33" value="Additional Skill"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column16">
                            <h:outputText id="outputText34" value="#{currentRow['req_date']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText35" value="Reqest date"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column116">
                            <h:outputText id="outputText314" value="#{currentRow['approvDate']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText315" value="Reqest Approved"/>
                            </f:facet>
                        </h:column>
                    </h:dataTable>
                </h:form>
            </body>
        </html>
    </f:view>
</jsp:root>
