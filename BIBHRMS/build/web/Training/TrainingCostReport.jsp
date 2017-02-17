<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : TrainingCostReport
    Created on : Jul 12, 2012, 3:17:44 PM
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
                <title>Training Approve Report</title>
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
                        style="font-size: 12px; left: 0px; top: 240px; position: absolute" value="#{Training$TrainingCostReport.trainingCostReport}" var="currentRow">
                        <h:column id="clmnemployeeId">
                            <h:outputText id="outputText1" value="#{currentRow['employeeId']}"/>
                            <f:facet name="header">
                                <h:outputText id="employeeId" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የመ/ ቁ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnfullName">
                            <h:outputText id="outputText3" value="#{currentRow['fullName']}"/>
                            <f:facet name="header">
                                <h:outputText id="fullName" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሰልጣኙ ስም"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmndepartmentPath">
                            <h:outputText id="outputText5" value="#{currentRow['departmentPath']}"/>
                            <f:facet name="header">
                                <h:outputText id="departmentPath" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የጠየቀው የሥራ ሂደት"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnjobDescription">
                            <h:outputText id="outputText6" value="#{currentRow['jobDescription']}"/>
                            <f:facet name="header">
                                <h:outputText id="jobDescription" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሰልጣኙ የሥራ መደብ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmncategoryName">
                            <h:outputText id="outputText7" value="#{currentRow['categoryName']}"/>
                            <f:facet name="header">
                                <h:outputText id="categoryName" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የተጠየቀው የሥልጠና ዓይነት"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmntrainingName">
                            <h:outputText id="outputText8" value="#{currentRow['trainingName']}"/>
                            <f:facet name="header">
                                <h:outputText id="trainingName" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የተጠየቀው የሥልጠና ርዕስ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnindividualCostPlan">
                            <h:outputText id="outputText9" value="#{currentRow['individualCostPlanned']}"/>
                            <f:facet name="header">
                                <h:outputText id="individualCostPlan" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የተያዘ በጀት /በብር/"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmntrainingFee">
                            <h:outputText id="outputText10" value="#{currentRow['trainingFee']}"/>
                            <f:facet name="header">
                                <h:outputText id="trainingFee" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ለሥልጠናው ወጪ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnintertainmentFee">
                            <h:outputText id="outputText11" value="#{currentRow['intertainmentFee']}"/>
                            <f:facet name="header">
                                <h:outputText id="intertainmentFee" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ለመስተንግዶ ወጪ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmntransportFee">
                            <h:outputText id="outputText12" value="#{currentRow['transportFee']}"/>
                            <f:facet name="header">
                                <h:outputText id="transportFee" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ለትራንስፖርት ወጪ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnfeeForTrainer">
                            <h:outputText id="outputText13" value="#{currentRow['feeForTrainer']}"/>
                            <f:facet name="header">
                                <h:outputText id="feeForTrainer" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ለአሰልጣኝ የተከፈለ ወጪ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnallowanceFee">
                            <h:outputText id="outputText14" value="#{currentRow['allowanceFee']}"/>
                            <f:facet name="header">
                                <h:outputText id="allowanceFee" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ለሰልጣኙ  የተከፈለ አበል ወጪ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnstationaryFee">
                            <h:outputText id="outputText15" value="#{currentRow['stationaryFee']}"/>
                            <f:facet name="header">
                                <h:outputText id="stationaryFee" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ለሰልጣኙ  የተከፈለ አበል ወጪ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnotherFee">
                            <h:outputText id="outputText16" value="#{currentRow['otherFee']}"/>
                            <f:facet name="header">
                                <h:outputText id="otherFee" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ልዩ ልዩ ወጪ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmncostPerPerson">
                            <h:outputText id="outputText17" value="#{currentRow['costPerPerson']}"/>
                            <f:facet name="header">
                                <h:outputText id="costPerPerson" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ጠቅላላ ወጪ"/>
                            </f:facet>
                        </h:column>
                    </h:dataTable>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
