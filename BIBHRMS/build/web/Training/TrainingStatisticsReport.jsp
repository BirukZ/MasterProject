<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : TrainingStatisticsReport
    Created on : Aug 3, 2012, 3:54:58 PM
    Author     : tomgenial 
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <!-- <head id="outputHead1">
                <ice:outputStyle href="./resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="./xmlhttp/css/xp/xp.css" id="outputStyle2"/>
            </head> -->
            <head id="outputHead1">
                <title>Training Statistics Report</title>
                <script src="../resources/DataTables-1.9.2/media/js/jquery.js" type="text/javascript"></script>
                <title>HRMS Reports</title>
                <script src="../resources/DataTables-1.9.2/media/js/jquery.dataTables.min.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/ColVis/media/js/ColVis.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/TableTools/media/js/TableTools.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/TableTools/media/js/ZeroClipboard.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/ColReorder/media/js/ColReorder.js" type="text/javascript"></script>
                <script type="text/javascript">
                    var IncrementSalary=jQuery.noConflict();
                    var element = document.getElementById("[id='form1:dataTable1']");

                    IncrementSalary(document).ready(function () {
                        IncrementSalary("[id='form1:dataTable1']").dataTable({
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
                <ice:form id="form1">
                    <h:dataTable border="1" headerClass="list-header" id="dataTable1" rowClasses="list-row-even,list-row-odd"
                        style="position: absolute; left: 300px; top: 216px" value="#{Training$TrainingStatisticsReport.trainingStatisticsReport}" var="currentRow">
                        <h:column id="clmnCourseName">
                            <h:outputText id="outputText1" value="#{currentRow['courseName']}"/>
                            <f:facet name="header">
                                <h:outputText id="CourseName" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሥልጠናው ዓይነት"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnnoOfTraineeBefore">
                            <h:outputText id="outputText3" value="#{currentRow['noOfTraineeBefore']}"/>
                            <f:facet name="header">
                                <h:outputText id="noOfTraineeBefore" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ከዚህ በፊት የሰለጠኑ ሠራተኞች ብዛት"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnnoOfTrainee">
                            <h:outputText id="outputText4" value="#{currentRow['noOfTrainee']}"/>
                            <f:facet name="header">
                                <h:outputText id="noOfTrainee" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="በበጀት አመቱ ስልጠና የተሠጣቸው ብዛት"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmntotalexpense">
                            <h:outputText id="outputText5" value="#{currentRow['totalexpense']}"/>
                            <f:facet name="header">
                                <h:outputText id="totalexpense" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የወጣ ወጭ"/>
                            </f:facet>
                        </h:column>
                    </h:dataTable>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
