<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : EmployeeReport
    Created on : Jul 11, 2012, 9:15:08 PM
    Author     : PROJECT
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Employee Report</title>
                <script src="../resources/DataTables-1.9.2/media/js/jquery.js" type="text/javascript"></script>
                <title>HRMS Reports</title>
                <script src="../resources/DataTables-1.9.2/media/js/jquery.dataTables.min.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/ColVis/media/js/ColVis.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/TableTools/media/js/TableTools.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/TableTools/media/js/ZeroClipboard.js" type="text/javascript"></script>
                <script src="../resources/DataTables-1.9.2/extras/ColReorder/media/js/ColReorder.js" type="text/javascript"></script>
                <script type="text/javascript">
                    var EmployeeProfileEducationReport=jQuery.noConflict();
                    var element = document.getElementById("[id='form1:dataTable1']");

                    EmployeeProfileEducationReport(document).ready(function () {
                        EmployeeProfileEducationReport("[id='form1:dataTable1']").dataTable({
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
                    <ice:dataTable headerClass="list-header" id="dataTable1" rowClasses="list-row-even,list-row-odd"
                                   style="left: 24px; top: 120px; position: absolute"
                                   styleClass="display"
                                   value="#{Report$EmployeeProfileEducationReport.listOfEmployeeEducationDate}"
                                   var="currentRow">
                        <ice:column id="column1">
                            <h:outputText id="outputText1" value="#{currentRow['employeeId']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText2" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="መታወቂያ ቁጥር"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="column2">
                            <h:outputText id="outputText3" value="#{currentRow['employeeName']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText4" style="font-family: 'Visual Geez Unicode'" value="ሠራተኛ ሥም"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="column3">
                            <h:outputText id="outputText5" value="#{currentRow['sex']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText6" style="font-family: 'Visual Geez Unicode'" value="ጾታ"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="colBirthDate">
                            <h:outputText id="lblBirthDate" value="#{currentRow['dateOfBirth']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblDisPlayBirthDate" style="font-family: 'Visual Geez Unicode'" value="የትውልድ ዘመን"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="colAge">
                            <h:outputText id="lblAge" value="#{currentRow['age']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblDisPlayAge" style="font-family: 'Visual Geez Unicode'" value="ዕድሜ"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="colReligion">
                            <h:outputText id="lblReligion" value="#{currentRow['religion']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblDisPlayReligion" style="font-family: 'Visual Geez Unicode'" value="ሀይማኖት"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="colNationality" style="font-family: 'Visual Geez Unicode'">
                            <h:outputText id="lblNationality" value="#{currentRow['nationality']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblDisPlayNationality" style="font-family: 'Visual Geez Unicode'" value="ብሄር"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="colMaritalStatus">
                            <h:outputText id="lblMaritalStatus" value="#{currentRow['maritalStatus']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblDisPlayMaritalStatus" style="font-family: 'Visual Geez Unicode'" value="የጋብቻ ሁኔታ"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="colRetirementNumber">
                            <h:outputText id="lblRetirementNumber" value="#{currentRow['retirementNumber']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblDisPlayRetirementNumber" style="font-family: 'Visual Geez Unicode'" value="የጡረታ መለያ ቁጥር"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="colTinNumber">
                            <h:outputText id="lblTinNumber" value="#{currentRow['tinNumber']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblDisPlayTinNumberr" style="font-family: 'Visual Geez Unicode'" value="የግብር ከፋይ መ.ቁ"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="colJobDescription">
                            <h:outputText id="lblJobDescription" value="#{currentRow['jobDescription']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblDisJobDescription" style="font-family: 'Visual Geez Unicode'" value="የሥራ መደቡ መጠሪያ"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="colPayGrade">
                            <h:outputText id="lblPayGrade" value="#{currentRow['payGrade']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblDisPlaPayGrade" style="font-family: 'Visual Geez Unicode'" value="የሥራ መደቡ ደረጃ"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="colSection">
                            <h:outputText id="lblSection" value="#{currentRow['payGrade']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblDisPlaSection" style="font-family: 'Visual Geez Unicode'" value="የሥራ ሂደት"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="colEducationType">
                            <h:outputText id="lblEducationType" value="#{currentRow['educationType']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblDisplayEducationType" style="font-family: 'Visual Geez Unicode'" value="የትምህርት ዓይነት"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="colEducationGrade">
                            <h:outputText id="lblEducationGrade" value="#{currentRow['educationGrade']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblDisplayEducationGrade" style="font-family: 'Visual Geez Unicode'" value="የትምህርት ዓይነት"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="colTeam">
                            <h:outputText id="lblTeam" value="#{currentRow['payGrade']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblDisPlaTeam" style="font-family: 'Visual Geez Unicode'" value="ቡድን"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="colWorkPlace">
                            <h:outputText id="lblWorkPlace" value="#{currentRow['payGrade']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblDisPlaWorkPlace" style="font-family: 'Visual Geez Unicode'" value="የሥራው ቦታ"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="colSalaryBefore">
                            <h:outputText id="lblSalaryBefore" value="#{currentRow['salary']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblDisPlaSalaryBefore" style="font-family: 'Visual Geez Unicode'" value="መነሻ ደመወዝ"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="colSalary">
                            <h:outputText id="lblSalary" value="#{currentRow['salary']}"/>
                            <f:facet name="header">
                                <h:outputText id="lblDisPlaSalary" style="font-family: 'Visual Geez Unicode'" value="አሁን ያለበት ደመወዝ"/>
                            </f:facet>
                        </ice:column>
                    </ice:dataTable>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
