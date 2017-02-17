<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : TerminationReport
    Created on : Jul 16, 2012, 1:08:04 AM
    Author     : Admin
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
         <head id="outputHead1">
                <title>Termination Request Report</title>
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
                    <ice:dataTable binding="#{Termination$TerminationReport.dataTable1}" border="1" headerClass="iceDatTblHdr displayHdr list-header"
                        id="dataTable1" rowClasses="list-row-even,list-row-odd" style="left: 24px; top: 120px; position: absolute"
                        styleClass="iceDatTbl display" value="#{Termination$TerminationReport.terminationList}" var="currentRow">
                        <ice:column id="clmnId1">
                            <ice:outputText id="outputText1" value="#{currentRow['requesterId']}"/>
                            <f:facet name="header">
                                <ice:outputText id="colId1" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የመ/ቁ"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="clmnRequesterName1">
                            <ice:outputText id="outputText2" value="#{currentRow['requesterName']}"/>
                            <f:facet name="header">
                                <ice:outputText id="colrequesterName1" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የጠያቂው ስም"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="clmnJobPostion1">
                            <ice:outputText id="outputText5" value="#{currentRow['reqDept']}"/>
                            <f:facet name="header">
                                <ice:outputText id="colJobPostion1" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሥራ መደብ"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="clmnedpartement1">
                            <h:outputText id="outputText6" value="#{currentRow['reqJobTile']}"/>
                            <f:facet name="header">
                                <ice:outputText id="colDepartement1" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሥራ ሂደት"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="clmnDate">
                            <ice:outputText id="outputText7" value="#{currentRow['appliedDate']}"/>
                            <f:facet name="header">
                                <ice:outputText id="colCurrentEducation1" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የጠየቀበት  ቀን"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="clmnTermId">
                            <ice:outputText id="outputText8" value="#{currentRow['terminId']}"/>
                            <f:facet name="header">
                                <ice:outputText id="colTerId" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="መለያ ቁጥር "/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="clmnTermName">
                            <ice:outputText id="outputText9" value="#{currentRow['terminName']}"/>
                            <f:facet name="header">
                                <ice:outputText id="colTermName" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የተጠየቀለት ሥም"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="clmnSex">
                            <ice:outputText id="outputText14" value="#{currentRow['sex']}"/>
                            <f:facet name="header">
                                <ice:outputText id="colAcreeted1" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ጾታ"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="clmnAge">
                            <ice:outputText id="outputText15" value="#{currentRow['age']}"/>
                            <f:facet name="header">
                                <ice:outputText id="colAge" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ዕድሜ"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="clmnTerDept">
                            <ice:outputText id="outputText10" value="#{currentRow['termdept']}"/>
                            <f:facet name="header">
                                <ice:outputText id="colRequestedEducation1" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሥራ  ሂደት"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="colTermTeam">
                            <ice:outputText id="outputText11" value="#{currentRow['termJob']}"/>
                            <f:facet name="header">
                                <ice:outputText id="colRequestedEdrank1" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሥራ  መደቡ"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="clmnSalary">
                            <ice:outputText id="outputText12" value="#{currentRow['salary']}"/>
                            <f:facet name="header">
                                <ice:outputText id="colInst1" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ደመወዝ"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="clmnHiredate">
                            <ice:outputText id="outputText13" value="#{currentRow['hireDate']}"/>
                            <f:facet name="header">
                                <ice:outputText id="colHIreDate" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የቅጥር ዘመን"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="column1">
                            <ice:outputText id="outputText3" value="#{currentRow['terminAppdate']}"/>
                            <f:facet name="header">
                                <ice:outputText id="colAppliedDtae" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ስንብት የጠየቀበት ቀን"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="column2">
                            <ice:outputText id="outputText4" value="#{currentRow['terminationDate']}"/>
                            <f:facet name="header">
                                <ice:outputText id="colTerminDate" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ስንብት የሚለቅበት ቀን"/>
                            </f:facet>
                        </ice:column>
                        <ice:columns id="columns1">
                            <ice:outputText id="outputText5" value="#{currentRow['penalityPay']}"/>
                            <f:facet name="header">
                                <ice:outputText id="outputText16" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሚከፍሉት ገንዘብ መጠን"/>
                            </f:facet>
                        </ice:columns>
                        <ice:columns id="columns2">
                            <ice:outputText id="outputTe5" value="#{currentRow['terminationCatagory']}"/>
                            <f:facet name="header">
                                <ice:outputText id="outputText17" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የተሰናበቱበት ዓይነት"/>
                            </f:facet>
                        </ice:columns>
                        <ice:column id="column3">
                            <ice:outputText id="outputT5" value="#{currentRow['terminationType']}"/>
                            <f:facet name="header">
                                <ice:outputText id="outputText19" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የተሰናበቱበት  ምክንያት"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="column4">
                            <ice:outputText id="outputTee5" value="#{currentRow['requestStatus']}"/>
                            <f:facet name="header">
                                <ice:outputText id="outputText21" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የስንብቱ ተቀባይነት"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="column5">
                            <ice:outputText id="outputTeee5" value="#{currentRow['approverId']}"/>
                            <f:facet name="header">
                                <ice:outputText id="outputText23" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="መለያ ቁጥር "/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="column10">
                            <ice:outputText id="outputTeee40" value="#{currentRow['approverName']}"/>
                            <f:facet name="header">
                                <ice:outputText id="outputText40" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ስንብቱን የፈቀደው ሃላፊ ሥም "/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="column50">
                            <ice:outputText id="outputTeee49" value="#{currentRow['approverDept']}"/>
                            <f:facet name="header">
                                <ice:outputText id="outputText49" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሥራ  መደቡ"/>
                            </f:facet>
                        </ice:column>
                        
                        <ice:column id="column7">
                            <ice:outputText id="otpuuTee56" value="#{currentRow['commentGiven']}"/>
                            <f:facet name="header">
                                <ice:outputText id="outputText20" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሰጠው አስተያየት"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="column8" rendered="false">
                            <ice:outputText id="outputText18" value="#{currentRow['decion']}"/>
                            <f:facet name="header">
                                <ice:outputText id="outputText22" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ውሳኔ"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="column9">
                            <ice:outputText id="outputText26" value="#{currentRow['approvedDate']}"/>
                            <f:facet name="header">
                                <ice:outputText id="outputText28" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ውሳኔ የተሰጠበት ቀን"/>
                            </f:facet>
                        </ice:column>
                    </ice:dataTable>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
