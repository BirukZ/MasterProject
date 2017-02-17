<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : OrganizationREport
    Created on : Jul 18, 2012, 1:03:03 AM
    Author     : Admin 
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Organization Report</title>
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
                    <ice:dataTable binding="#{Organization$OrganizationREport.dataTable1}" border="1" headerClass="list-header" id="dataTable1"
                        style="left: 14px; top: 110px; position: absolute" styleClass="display" value="#{Organization$OrganizationREport.initiateManagerlist}" var="currentRow">
                        <ice:column id="column1">
                            <ice:outputText id="outputText1" value="#{currentRow['jobName']}"/>
                            <f:facet name="header">
                                <ice:outputText id="outputText2" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሥራ መደቡ መጠሪያ "/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="column2" style="width: 184px">
                            <ice:outputText id="outputText3" value="#{currentRow['rank']}"/>
                            <f:facet name="header">
                                <ice:outputText id="outputText4" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሥራ  መደቡ ደረጃ                              "/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="column10" style="width: 167px">
                            <ice:outputText id="outputText15" value="#{currentRow['seraAsfetsami']}"/>
                            <f:facet name="header">
                                <ice:outputText id="outputTe26" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ዋና ሥራ አስፈጻሚ/ ሥራ አስፈጻሚ                                                      "/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="column3">
                            <ice:outputText id="outputText5" value="#{currentRow['dept']}"/>
                            <f:facet name="header">
                                <ice:outputText id="outputText6" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የሥራ  ሂደት"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="column4">
                            <ice:outputText id="outputText7" value="#{currentRow['team']}"/>
                            <f:facet name="header">
                                <ice:outputText id="outputText8" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ቡድን"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="column6">
                            <ice:outputText id="outputText11" value="#{currentRow['educType']}"/>
                            <f:facet name="header">
                                <ice:outputText id="outputText12" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ተፈላጊ የትምህርት ዓይነት"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="column7">
                            <ice:outputText id="outputText13" value="#{currentRow['educLevel']}"/>
                            <f:facet name="header">
                                <ice:outputText id="outputText14" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ተፈላጊ የትምህርት ደረጃ"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="column8">
                            <ice:outputText id="outputText40" value="#{currentRow['expiriance']}"/>
                            <f:facet name="header">
                                <ice:outputText id="outputText16" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ተፈላጊ  የሥራ  ልምድ"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="column9">
                            <ice:outputText id="outputText17" value="#{currentRow['addtionalSkill']}"/>
                            <f:facet name="header">
                                <ice:outputText id="outputText18" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ተጨማሪ  መስፈርት /Skill/"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="column40">
                            <ice:outputText id="outputText19" value="#{currentRow['requiredNumber']}"/>
                            <f:facet name="header">
                                <ice:outputText id="outputText20" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="በመዋቅሩ  የተፈቀደው  የሰው ኃይል ብዛት"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="column11">
                            <ice:outputText id="outputText21" value="#{currentRow['numberOfEmp']}"/>
                            <f:facet name="header">
                                <ice:outputText id="outputText22" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="አሁን ያለው  የሰው ኃይል"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="column12">
                            <ice:outputText id="outputText23" value="#{currentRow['vacantPossession']}"/>
                            <f:facet name="header">
                                <ice:outputText id="outputText24" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ክፍት  ቦታ"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="column13">
                            <ice:outputText id="outputText25" value="#{currentRow['minSalary']}"/>
                            <f:facet name="header">
                                <ice:outputText id="outputText26" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="መነሻ ደመወዝ"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="column14">
                            <ice:outputText id="outputText27" value="#{currentRow['maxSalary']}"/>
                            <f:facet name="header">
                                <ice:outputText id="outputText28" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="መድረሻ ደመወዝ"/>
                            </f:facet>
                        </ice:column>
                    </ice:dataTable>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
