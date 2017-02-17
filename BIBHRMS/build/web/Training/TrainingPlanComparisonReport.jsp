<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : TrainingPlanComparisonReport
    Created on : Aug 28, 2012, 10:30:27 AM
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
                <title>Training Plan Comparison Report</title>
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
                        style="position: absolute; left: 200px; top: 192px; height: 48px"
                        value="#{Training$TrainingPlanComparisonReport.trainingPlanComparisonReport}" var="currentRow">
                        <h:column id="clmntrainingName">
                            <h:outputText id="outputText1" value="#{currentRow['trainingName']}"/>
                            <f:facet name="header">
                                <h:outputText id="trainingName" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የስልጠና ዓይነት"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnnumberOfTraineeForYear">
                            <h:outputText id="outputText2" value="#{currentRow['numberOfTraineeForYear']}"/>
                            <f:facet name="header">
                                <h:outputText id="numberOfTraineeForYear" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ለዓመቱ የታቀደ ብዛት"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnnumberOfTraineeStillNow">
                            <h:outputText id="outputText3" value="#{currentRow['numberOfTraineeStillNow']}"/>
                            <f:facet name="header">
                                <h:outputText id="numberOfTraineeStillNow" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="እስከአሁን የሰለጠነ ሠራተኛ ብዛት"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnplanFulfilled">
                            <h:outputText id="outputText4" value="#{currentRow['planFulfilled']}"/>
                            <f:facet name="header">
                                <h:outputText id="planFulfilled" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ዕቅድ ክንውን ንጽጽር( %)"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmntotalCostStillNow">
                            <h:outputText id="outputText5" value="#{currentRow['totalCostStillNow']}"/>
                            <f:facet name="header">
                                <h:outputText id="totalCostStillNow" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="እስከአሁን የተመዘገበ የስልጠና ወጪ"/>
                            </f:facet>
                        </h:column>
                    </h:dataTable>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
