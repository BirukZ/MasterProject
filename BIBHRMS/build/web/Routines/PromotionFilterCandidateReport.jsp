<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : PromotionFilterCandidateReport
    Created on : Jul 24, 2012, 4:31:18 AM
    Author     : HRMS
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <f:loadBundle basename="Localization.HRLocalization" var="msgs"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Promotion FilterCandidate Report</title>
                <script src="DataTables-1.9.2/media/js/jquery.js" type="text/javascript"></script>
                <title>HRMS Reports</title>
                <script src="DataTables-1.9.2/media/js/jquery.dataTables.min.js" type="text/javascript"></script>
                <script src="DataTables-1.9.2/extras/ColVis/media/js/ColVis.js" type="text/javascript"></script>
                <script src="DataTables-1.9.2/extras/TableTools/media/js/TableTools.js" type="text/javascript"></script>
                <script src="DataTables-1.9.2/extras/TableTools/media/js/ZeroClipboard.js" type="text/javascript"></script>
                <script src="DataTables-1.9.2/extras/ColReorder/media/js/ColReorder.js" type="text/javascript"></script>
                <script type="text/javascript">
                    var PromotionFilterCandidate=jQuery.noConflict();
                    var element = document.getElementById("[id='form1:dataTable1']");

                    PromotionFilterCandidate(document).ready(function () {
                        PromotionFilterCandidate("[id='form1:dataTable1']").dataTable({
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
                        value="#{Routines$PromotionFilterCandidate.promotionFilterReportList}" var="currentRow">
                        <h:column id="column4">
                            <h:outputText id="outputText7" value="#{currentRow['jobType']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText8" value="Job Title"/>
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
                                <h:outputText id="outputText15" value="Chief"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column8">
                            <h:outputText id="outputText14" value="#{currentRow['directorate']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText16" value="Directorate"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column9">
                            <h:outputText id="outputText17" value="#{currentRow['process']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText18" value="Process"/>
                            </f:facet>
                        </h:column>
                        <h:column id="colWorkingPlace">
                            <h:outputText id="outputText24" value="#{currentRow['workingPla']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText25" value="Working place"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column11">
                            <h:outputText id="outputText243" value="#{currentRow['candidate_ID']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText225" value="CandidateID"/>
                            </f:facet>
                        </h:column>
                        <h:column id="colName">
                            <h:outputText id="outName" value="#{currentRow['fullName']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputName" value="Name"/>
                            </f:facet>
                        </h:column>
                        <h:column id="colsex">
                            <h:outputText id="txtsex" value="#{currentRow['sex']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblsex" value="Sex"/>
                            </f:facet>
                        </h:column>
                        <h:column id="colAge">
                            <h:outputText id="txtage" value="#{currentRow['age']}"/>
                            <f:facet name="header">
                                <h:outputText id="outxtage" value="Age"/>
                            </f:facet>
                        </h:column>
                        <h:column id="colRank">
                            <h:outputText id="outputRank" value="#{currentRow['candidateRank']}"/>
                            <f:facet name="header">
                                <h:outputText id="outpuRank7" value="Canidate Rank"/>
                            </f:facet>
                        </h:column>
                        <h:column id="colJob">
                            <h:outputText id="outpuJob" value="#{currentRow['candidateJobposi']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputJob9" value="candidate Job P"/>
                            </f:facet>
                        </h:column>
                         <h:column id="colWritenEcam">
                            <h:outputText id="outputexam" value="#{currentRow['writenExam']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputexam8" value="Writen exam"/>
                            </f:facet>
                        </h:column>
                        <h:column id="colInterview">
                            <h:outputText id="outputInterview" value="#{currentRow['interviewExam']}"/>
                            <f:facet name="header">
                                <h:outputText id="outpInterview5" value="Interview exam"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column12">
                            <h:outputText id="outputText26" value="#{currentRow['practicalExam']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText27" value="Practical exam"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column13">
                            <h:outputText id="outputText28" value="#{currentRow['totalResult']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText29" value="total"/>
                            </f:facet>
                        </h:column>
                        <h:column id="colEducLevle">
                            <h:outputText id="outputEducLevle" value="#{currentRow['sex']}"/>
                            <f:facet name="header">
                                <h:outputText id="outEducLevle" value="Educ Level"/>
                            </f:facet>
                        </h:column>
                        <h:column id="colEducType">
                            <h:outputText id="outputEducType" value="#{currentRow['sex']}"/>
                            <f:facet name="header">
                                <h:outputText id="outEducType" value="Educ Type"/>
                            </f:facet>
                        </h:column>

                        <h:column id="colCgpa">
                            <h:outputText id="outCgpa" value="#{currentRow['cgpa']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputCgpa" value="CGPA"/>
                            </f:facet>
                        </h:column>

                        <h:column id="column14">
                            <h:outputText id="outputText30" value="#{currentRow['mugerexperien']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText31" value="Experience"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column15">
                            <h:outputText id="outputText32" value="#{currentRow['sex']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText33" value="Additional Skill"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column16">
                            <h:outputText id="outputText34" value="#{currentRow['sex']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText35" value="Advertismen From"/>
                            </f:facet>
                        </h:column>
                        <h:column id="colAdvertismen">
                            <h:outputText id="outputAdvertismen4" value="#{currentRow['advertDateTo']}"/>
                            <f:facet name="header">
                                <h:outputText id="outAdvertismen5" value="Advertismen To"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column126">
                            <h:outputText id="outputText324" value="#{currentRow['advertDateFrom']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText325" value="Ref_no"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column116">
                            <h:outputText id="outputText314" value="#{currentRow['approvDate']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText315" value="Approver comm"/>
                            </f:facet>
                        </h:column>
                        <h:column id="colDate">
                            <h:outputText id="outDate4" value="#{currentRow['approvDate']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputDate" value="Approver Date"/>
                            </f:facet>
                        </h:column>
                    </h:dataTable>
                </h:form>
            </body>
        </html>
    </f:view>
</jsp:root>
