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
                <title>Approved Education Report</title>
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
                    <h:dataTable binding="#{Education$ApprocedEducationReportPage.dtbEducationRequestReport}" border="1" headerClass="list-header"
                        id="dataTable1" rowClasses="list-row-even,list-row-odd" style="left: 24px; top: 120px; position: absolute" styleClass="display"
                        value="#{Education$ApprocedEducationReportPage.educationRequsetList}" var="currentRow" width="384px">
                        <h:column id="clmnId">
                            <h:outputText id="outputText1" value="#{currentRow['requesterId']}"/>
                            <f:facet name="header">
                                <h:outputText id="colId" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የመ/ቁ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnRequesterName">
                            <h:outputText id="outputText20" value="#{currentRow['requesterName']}"/>
                            <f:facet name="header">
                                <h:outputText id="colrequesterName" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="  ስም"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnAge">
                            <h:outputText id="outputTex4" value="#{currentRow['age']}"/>
                            <f:facet name="header">
                                <h:outputText id="colAge" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ዕድሜ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnSex">
                            <h:outputText id="outputText5" value="#{currentRow['sex']}"/>
                            <f:facet name="header">
                                <h:outputText id="colSex" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ጾታ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnHireDate">
                            <h:outputText id="outputText6" value="#{currentRow['hireDate']}"/>
                            <f:facet name="header">
                                <h:outputText id="colHireDate" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የቅጥር ዘመን"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnJobPostion">
                            <h:outputText id="outputText7" value="#{currentRow['jobPostion']}"/>
                            <f:facet name="header">
                                <h:outputText id="colJobPostion" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሥራ መደብ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnedpartement">
                            <h:outputText id="outputText8" value="#{currentRow['dpartement']}"/>
                            <f:facet name="header">
                                <h:outputText id="colDepartement" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሥራ ሂደት"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnCurrentEduction">
                            <h:outputText id="outputText11" value="#{currentRow['currentEducation']}"/>
                            <f:facet name="header">
                                <h:outputText id="colCurrentEducation" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ቀደም ሲል ያላቸው  የትምህርት መስክ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnCurrentEductionrank">
                            <h:outputText id="outputText12" value="#{currentRow['currentEducationrank']}"/>
                            <f:facet name="header">
                                <h:outputText id="colCurrentEducationrank" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ቀደም ሲል ያላቸው  የትምህርት ደረጃ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnRequestedEducation">
                            <h:outputText id="outputText14" value="#{currentRow['requestedEducation']}"/>
                            <f:facet name="header">
                                <h:outputText id="colRequestedEducation" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የተፈቀደ  የትምህርት"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnRequestedEuctionrank">
                            <h:outputText id="outputText15" value="#{currentRow['requestedEuctionrank']}"/>
                            <f:facet name="header">
                                <h:outputText id="colRequestedEdrank" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የተፈቀደ  የትምህርት ደረጃ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnDocRequest">
                            <h:outputText id="outputText25" value="#{currentRow['documentReferenceNumber']}"/>
                            <f:facet name="header">
                                <h:outputText id="coldocReq" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="እንዲማሩ የተፈቀደበት  ደብዳቤ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnAcadamicYear">
                            <h:outputText id="outputText16" value="#{currentRow['academicYear']}"/>
                            <f:facet name="header">
                                <h:outputText id="colAcadamicYear" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ትምህርቱን እንዲማሩ የተፈቀደበት  ዓ.ም."/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnInst">
                            <h:outputText id="outputText17" value="#{currentRow['institutionName']}"/>
                            <f:facet name="header">
                                <h:outputText id="colInst" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የትምህርት ተቋም"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnAccreted">
                            <h:outputText id="outputText18" value="#{currentRow['institutionAccredited']}"/>
                            <f:facet name="header">
                                <h:outputText id="colAcreeted" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሚማሩበት ተቋም  እውቅና "/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnDate">
                            <h:outputText id="outputText19" value="#{currentRow['issueDate']}"/>
                            <f:facet name="header">
                                <h:outputText id="colDate" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ትምህርቱን  የሚጀመርበት ጊዜ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnendDate">
                            <h:outputText id="outputText21" value="#{currentRow['endDate']}"/>
                            <f:facet name="header">
                                <h:outputText id="colendDate" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ትምህርቱየሚጠናቀቅበት  ጊዜ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnShift">
                            <h:outputText id="outputText22" value="#{currentRow['educationShiftCategory']}"/>
                            <f:facet name="header">
                                <h:outputText id="colShift" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ትምህርቱን የሚማሩበ ጊዜ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="clmnTotalCost">
                            <h:outputText id="outputText23" value="#{currentRow['totalCost']}"/>
                            <f:facet name="header">
                                <h:outputText id="coltotalCost" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="አንዲማሩ የተፈቀደላቸው  ጠቅላላ ድምር"/>
                            </f:facet>
                        </h:column>
                    </h:dataTable>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
