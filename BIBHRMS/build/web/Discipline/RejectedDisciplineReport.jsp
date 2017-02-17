<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : DisciplineReport
    Created on : Jul 12, 2012, 7:07:00 PM
    Author     : BravoZulu
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Discipline Request Report </title>
                <script src="../resources/DataTables-1.9.2/media/js/jquery.js" type="text/javascript"></script>
                <title>HRMS Reports</title>
                <script src="../resources/DataTables-1.9.2/media/js/jquery.dataTables.min.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/ColVis/media/js/ColVis.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/TableTools/media/js/TableTools.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/TableTools/media/js/ZeroClipboard.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/ColReorder/media/js/ColReorder.js" type="text/javascript"></script>
                <script type=" text/javascript ">
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
                    <h:dataTable border="1" headerClass="list-header" id="dataTable1"
                        rowClasses="list-row-even,list-row-odd iceMnuPopVrt iceMnuPopVrtItem iceMnuBarVrtItemLabel oddRow"
                        style="left: 24px; top: 120px; position: absolute" styleClass="display" value="#{Discipline$RejectedDisciplineReport.disciplineReport}" var="currentRow">
                        <h:column id="column1">
                            <h:outputText id="outputText1" value="#{currentRow['requesterID']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText2" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የከሳሽ መለያ ቁጥር"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column2">
                            <h:outputText id="outputText3" value="#{currentRow['requesterFullName']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText4" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የከሳሽ ሥም"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column3">
                            <h:outputText id="outputText5" value="#{currentRow['requesterPosition']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText6" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የከሳሽ የሥራ መደብ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column4">
                            <h:outputText id="outputText50" value="#{currentRow['requestrDepartment']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText26" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሥራ ክፍል"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column5">
                            <h:outputText id="outputText29" value="#{currentRow['offenderID']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText9" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የተከሳሽ መለያ ቁጥር"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column6">
                            <h:outputText id="outputText7" value="#{currentRow['offenderFullName']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText30" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የተከሳሽ ሥም"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column7">
                            <h:outputText id="outputText32" value="#{currentRow['offenderPosition']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText33" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የተከሳሽ የሥራ መደብ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column8">
                            <h:outputText id="outputText34" value="#{currentRow['offenderDepartment']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText10" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የተከሳሽ የሥራ ክፍል"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column9">
                            <h:outputText id="outputText35" value="#{currentRow['disciplineHappenDay']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText11" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ጥፋቱ የተፈፀመበት ቀን"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column10">
                            <h:outputText id="outputText36" value="#{currentRow['disciplineType']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText12" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የጥፋቱ ዓይነት"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column11">
                            <h:outputText id="outputText37" value="#{currentRow['disciplineReportDay']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText13" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የተከሰሰበት ቀን"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column12">
                            <h:outputText id="outputText38" value="#{currentRow['disciplineDescripition']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText14" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የጥፋቱ ዝርዝር መግለጫ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column13">
                            <h:outputText id="outputText39" value="#{currentRow['requesterInterset']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText15" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የከሳሽ ፍላጉት"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column14">
                            <h:outputText id="outputText40" value="#{currentRow['requesterEyewitnessInside']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText16" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ከሳሹ ያቀረባቸው የዓይን ምስክሮ  ከ ሌላ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column30">
                            <h:outputText id="outputText60" value="#{currentRow['requesterEyewitnessOutSide']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText68" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ከሳሹ ያቀረባቸው የዓይን ምስክሮች ከ ውስጥ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column15">
                            <h:outputText id="outputText55" value="#{currentRow['problemSeenBy']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText41" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ጉዳይ በ ኮሚቴ ታዬተዋል"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column16">
                            <h:outputText id="outputText17" value="#{currentRow['commiteeCommentes']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText18" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የቀረበ የውሳኔ አስተያየት"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column17">
                            <h:outputText id="outputText42" value="#{currentRow['lastApprovedPenality']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText19" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የተሰጠው ውሳኔ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column60">
                            <h:outputText id="outputText65" value="#{currentRow['approvedDeduction']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText75" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሚቆረጥበት መጠን"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column76">
                            <h:outputText id="outputText95" value="#{currentRow['approvedDuration']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText101" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሚቆረጥበት ግዜ ቆይታ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column18">
                            <h:outputText id="outputText43" value="#{currentRow['approvedDate']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText20" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ውሳኔ የተሰጠበት ቀን"/>
                            </f:facet>
                        </h:column>
                    </h:dataTable>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
