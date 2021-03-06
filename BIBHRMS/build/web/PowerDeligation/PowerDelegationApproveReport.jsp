<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : PowerDelegationApprove
    Created on : Jul 16, 2012, 11:16:44 PM
    Author     : Biruk 
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
         <html id="outputHtml1">
            <head id="outputHead1">
                <title>Power Delegation Approve Report</title>
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
                    <h:dataTable border="1" headerClass="list-header" id="dataTable1" rowClasses="list-row-even,list-row-odd iceMnuPopVrt iceMnuPopVrtItem iceMnuBarVrtItemLabel oddRow"
                   style="left: 24px; top: 120px; position: absolute" styleClass="display"
                   value="#{PowerDeligation$PowerDelegationApproveReport.powerDelegationRequestModel}" var="currentRow">
                         <h:column id="column1">
                            <h:outputText id="outputText1" value="#{currentRow['requesterID']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText2" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የጠያቂው መለያ ቁጥር"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column2">
                            <h:outputText id="outputText3" value="#{currentRow['requesterFullName']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText4" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የጠያቂው ስም"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column303">
                            <h:outputText id="outputText5" value="#{currentRow['requesterPosition']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText6" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የጠያቂው የስራ መደብ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column3300">
                            <h:outputText id="outputText511" value="#{currentRow['requesterDepartment']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText6222" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የጠያቂው የሥራ ክፍል"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column3301">
                            <h:outputText id="outputText512" value="#{currentRow['delegateID']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText6223" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የወካይ መለያ ቁጥር"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column3302">
                            <h:outputText id="outputText513" value="#{currentRow['delegateFullName']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText6224" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የወካይ ስም"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column3303">
                            <h:outputText id="outputText514" value="#{currentRow['delegatePosition']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText6225" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የወካይ የሥራ መደብ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column330">
                            <h:outputText id="outputText51" value="#{currentRow['delegatedRank']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText62" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የወካይ ደረጃ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column3">
                            <h:outputText id="outputText55" value="#{currentRow['delegateDepartment']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText65" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የወካይ የስራ ክፍል"/>
                            </f:facet>
                        </h:column>
                        
                        <h:column id="column40">
                            <h:outputText id="outputText77" value="#{currentRow['delegatedSatrtDay']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText79" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የተወከለበት ቀን ከ"/>
                            </f:facet>
                        </h:column>

                        <h:column id="column30">
                            <h:outputText id="outputText87" value="#{currentRow['delegateEndDay']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText90" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የተወከለበት ቀን እስከ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column31">
                            <h:outputText id="outputText88" value="#{currentRow['delegatedPosition']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText91" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የተወከለበት የስራ መደብ "/>
                            </f:facet>
                        </h:column>
                        <h:column id="column319">
                            <h:outputText id="outputText880" value="#{currentRow['delegatedRank']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText910" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የተወከለበት የስራ ደረጃ "/>
                            </f:facet>
                        </h:column>
                        <h:column id="column32">
                            <h:outputText id="outputText89" value="#{currentRow['delegationReasoun']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText92" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የተወከለበት ምክንያት"/>
                            </f:facet>
                        </h:column>
                         <h:column id="column33">
                            <h:outputText id="outputText950" value="#{currentRow['delegationApproveDay']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText903" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="ውክልናው የፀደቀበት ቀን"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column34">
                            <h:outputText id="outputText960" value="#{currentRow['approverID']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText94" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የፈቀደው ኃላፊ መለያ ቁጥር "/>
                            </f:facet>
                        </h:column>
                        <h:column id="column339">
                            <h:outputText id="outputText951" value="#{currentRow['approverFullName']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText904" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የፈቀደው ኃላፊ ስም"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column343">
                            <h:outputText id="outputText961" value="#{currentRow['approverPosition']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText100" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የፈቀደው ኃላፊ የሥራ መደብ"/>
                            </f:facet>
                        </h:column>
                        <h:column id="column353">
                            <h:outputText id="outputText101" value="#{currentRow['approverDepartment']}"/>
                            <f:facet name="header">
                                <h:outputText id="outputText102" style="font-family: 'Visual Geez Unicode'; font-size: 12px" value="የፈቀደው ኃላፊ የሥራ ክፍል"/>
                            </f:facet>
                        </h:column>
                    </h:dataTable>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
