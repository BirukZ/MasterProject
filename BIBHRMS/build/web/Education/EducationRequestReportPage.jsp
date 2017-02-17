<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : EducationRequestReportPage
    Created on : Jul 11, 2012, 12:11:08 AM
    Author     : Admin
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Education Request Report</title>
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
                                "sSwfPath": "DataTables-1.9.2/extras/TableTools/media/swf/copy_csv_xls_pdf.swf"
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
                    <ice:dataTable border="1" headerClass="list-header" id="dataTable1" rowClasses="list-row-even,list-row-odd"
                        style="left: 24px; top: 120px; position: absolute" styleClass="display"
                        value="#{Education$EducationRequestReportPage.educationRequsetList}" var="currentRow">
                        <ice:column id="clmnId">
                            <ice:outputText id="outputText1" value="#{currentRow['requesterId']}"/>
                            <f:facet name="header">
                                <ice:outputText id="colId" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የመ/ቁ"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="clmnRequesterName">
                            <ice:outputText id="outputText20" value="#{currentRow['requesterName']}"/>
                            <f:facet name="header">
                                <ice:outputText id="colrequesterName" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ስም"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="clmnAge">
                            <ice:outputText id="outputTex4" value="#{currentRow['age']}"/>
                            <f:facet name="header">
                                <ice:outputText id="colAge" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ዕድሜ"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="clmnSex">
                            <ice:outputText id="outputText5" value="#{currentRow['sex']}"/>
                            <f:facet name="header">
                                <ice:outputText id="colSex" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ጾታ"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="clmnHireDate">
                            <ice:outputText id="outputText6" value="#{currentRow['hireDate']}"/>
                            <f:facet name="header">
                                <ice:outputText id="colHireDate" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የቅጥር ዘመን"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="clmnJobPostion">
                            <ice:outputText id="outputText7" value="#{currentRow['jobPostion']}"/>
                            <f:facet name="header">
                                <ice:outputText id="colJobPostion" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሥራ መደብ"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="clmnedpartement">
                            <ice:outputText id="outputText8" value="#{currentRow['dpartement']}"/>
                            <f:facet name="header">
                                <ice:outputText id="colDepartement" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሥራ ሂደት"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="clmnCurrentEduction">
                            <ice:outputText id="outputText11" value="#{currentRow['currentEducation']}"/>
                            <f:facet name="header">
                                <ice:outputText id="colCurrentEducation" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="አሁን ያላቸው  የትምህርት መስክ"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="clmnCurrentEductionrank">
                            <ice:outputText id="outputText12" value="#{currentRow['currentEducationrank']}"/>
                            <f:facet name="header">
                                <ice:outputText id="colCurrentEducationrank" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="አሁን ያላቸው  የትምህርት ደረጃ"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="clmnRequestedEducation">
                            <ice:outputText id="outputText14" value="#{currentRow['requestedEducation']}"/>
                            <f:facet name="header">
                                <ice:outputText id="colRequestedEducation" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የተጠየቀት የትምህርት መስክ"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="clmnRequestedEuctionrank">
                            <ice:outputText id="outputText15" value="#{currentRow['requestedEuctionrank']}"/>
                            <f:facet name="header">
                                <ice:outputText id="colRequestedEdrank" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የተጠየቀት የትምህርት ደረጃ"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="clmnInst">
                            <ice:outputText id="outputText16" value="#{currentRow['institutionName']}"/>
                            <f:facet name="header">
                                <ice:outputText id="colInst" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የትምህርት ተቋም"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="clmnDate">
                            <ice:outputText id="outputText17" value="#{currentRow['appliedDate']}"/>
                            <f:facet name="header">
                                <ice:outputText id="colDate" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ያመለከቱተት ቀን"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="clmnAccreted">
                            <ice:outputText id="outputText18" value="#{currentRow['institutionAccredited']}"/>
                            <f:facet name="header">
                                <ice:outputText id="colAcreeted" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሚማሩበት ተቋም  እውቅና "/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="clmnShift">
                            <ice:outputText id="outputText19" value="#{currentRow['educationShiftCategory']}"/>
                            <f:facet name="header">
                                <ice:outputText id="colShift" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ትምህርቱን የሚማሩበ ጊዜ"/>
                            </f:facet>
                        </ice:column>
                    </ice:dataTable>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
