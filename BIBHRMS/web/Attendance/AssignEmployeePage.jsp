<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : AssignEmployeePage
    Created on : Dec 17, 2012, 3:26:02 PM
    Author     : Administrator
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title></title>
                <ice:outputStyle href="../resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="../resources/TempCSS.css"/>
                <ice:outputStyle href="../xmlhttp/css/rime/rime.css"/>
                <ice:outputStyle href="../resources/TempCSS.css"/>
                <script src="../Script/jquery-1.3.2.min.js"></script>
                <style type="text/css">
                    .message {
                        display: none;
                        margin: 0 0 13px 0;
                        background-color:#EFA;
                        padding: 13px 13px 13px 52px;
                        background-position: 13px 5px;
                        border: solid 1px #BD8;                                                                                                                                                border: solid 1px #BD8;
                    }
                    .message2 {
                        display: none;
                        margin: 0 0 13px 0;
                        background-color:#EFA;
                        padding: 13px 13px 13px 52px;
                        background-position: 13px 5px;
                        border: solid 1px #BD8;                                                                                                                                                border: solid 1px #BD8;
                    }
                    .success{
                        color: #336600;
                        font-size: 12px;
                        font-weight: bold;
                        text-align: center;
                        vertical-align: middle;
                        top:5px;left: 0px;
                        position: absolute;
                        width: 100%
                    }
                    .error{
                        color: red;
                        font-size: 12px;
                        font-weight: bold;
                        text-align: center;
                        vertical-align: middle;
                        top:5px;left: 0px;
                        position: absolute;
                        width: 100%
                    }
                    .success1{
                        color: #336600;
                        font-size: 11px;
                        font-weight: bold;
                        height: 16px;
                        left: 5px;
                        top: 2px;
                        position: absolute;
                        text-align: left;
                        width: 391px
                    }
                    .error1{
                        color: red;
                        font-size: 11px;
                        font-weight: bold;
                        height: 16px;
                        left: 5px;
                        top: 2px;
                        position: absolute;
                        text-align: left;
                        width: 391px
                    }
                </style>
                <script language="javascript" type="text/javascript">
                    var $j=jQuery.noConflict();
                    function AssignEmployeePage(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
               <!-- <link HREF="../FederalIcon.ico" REL="icon"/>-->
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <ice:panelBorder id="whole_page" renderCenter="#{Attendance$AssignEmployeePage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Attendance$AssignEmployeePage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Attendance$AssignEmployeePage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Attendance$AssignEmployeePage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Attendance$AssignEmployeePage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
                            styleClass="whole_page" width="1024">
                            <f:facet name="north">
                                <ice:panelGroup id="page_header" style="height: 75px">
                                    <!-- Begin Header -->
                                    <ice:panelLayout id="header" layout="flow"
                                        style="height: 75px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="header" visible="true">
                                        <jsp:directive.include file="/Header.jspf"/>
                                    </ice:panelLayout>
                                    <!-- End Header -->
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="west">
                                <ice:panelGroup id="menu_left" style="border:none; height:470px;">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height:470px;top:70px; left: 5px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 470px; left: 5px; top: 0px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Common_Tasks" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="commonTasksGroup_header">
                                                        <ice:outputText id="lblCommonTasks" value="Common Tasks"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="commonTasksGroup_Grid11" width="100%">
                                                    <ice:panelGroup id="commonTasksGroup_Group22" style="width:100%"/>
                                                    <!--  <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                      <li>
                                                            <ice:commandLink action="#{Attendance$AssignEmployeePage.lnkPayrollPeriodLists_action}"
                                                                id="lnkPayrollPeriodLists" immediate="true" style="color:#333333;font-weight:bold" value="Take Attendance "/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Attendance$AssignEmployeePage.lnkPayrollGroup_action}"
                                                                id="lnkPayrollGroup" immediate="true" style="color:#333333;font-weight:bold" value="Approve Attendance"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Attendance$AssignEmployeePage.lnkPayrollEmployeeGroup_action}"
                                                                id="lnkPayrollEmployeeGroup" style="color:#333333;font-weight:bold" value="Certify Attendance"/>
                                                        </li>
                                                    </ul>-->
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="panelCollapsible1">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup3" styleClass="">
                                                        <ice:outputText id="outputText10" value="Boss"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="StatusBoard" style="height: 580px" width="100%">
                                                    <ice:panelGroup id="status_Group" style="border-style: none; margin: -5px -5px -5px -10px; padding: 7px; background-color: transparent; display: block; float: left; height: 550px; left: -5px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="height: 400px; position: absolute; width: 100%">
                                                            <ice:outputText id="outputText32"
                                                                style="font-family: Cambria; left: 10px; top: 10px; position: absolute" value=" Boss Name"/>
                                                            <ice:selectOneListbox binding="#{Attendance$AssignEmployeePage.selectOneListbox1}"
                                                                id="selectOneListbox1" partialSubmit="true" size="2"
                                                                style="border: 1px solid rgb(115, 179, 206); height: 300px; left: 10px; top: 30px; position: absolute; width: 180px"
                                                                value="#{Attendance$AssignEmployeePage.selectOneListbox1Bean.selectedObject}" valueChangeListener="#{Attendance$AssignEmployeePage.selectOneListbox1_processValueChange}">
                                                                <f:selectItems id="selectOneListbox1selectItems" value="#{Attendance$AssignEmployeePage.listOfBoss}"/>
                                                            </ice:selectOneListbox>
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                                <ice:panelGrid id="panelGrid1">
                                                    <ice:outputText id="outputText11" value="Text Description"/>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height:830px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 575px; top:60px;left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 760px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Assign Employee Immediate Boss"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 770px; left: 0px; top: 30px; position: absolute; width: 100%">
                                                <ice:panelGroup id="RetirementApproval" style="height: 700px" styleClass="filedset_border">
                                                    <label style="left: 20px; top: 650px; border-bottom:0.5px groove #176674; width:750px; position: absolute;"></label>
                                                    <label style="left: 20px; top:695px; border-bottom:0.5px groove #176674; width:750px; position: absolute;"></label>
                                                    <ice:outputText id="lblLocationName" style="font-family: Cambria; left: 40px; top: 29px; position: absolute" value="Immedate Boss Name :"/>
                                                    <ice:panelLayout id="panelLayout1" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 358px; left: 40px; top: 230px; overflow: auto; position: absolute; width: 250px">
                                                        <ice:dataTable clientOnly="true" id="tblAvilableUsers" sortAscending="true" style="position: absolute"
                                                            value="#{Attendance$AssignEmployeePage.availableEmployeeInDataModel}" var="currentRow" width="100%">
                                                            <ice:column id="column1" style="width: 100px">
                                                                <ice:outputText id="outputText4" value="#{currentRow['employeeName']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText5" value="Employee List"/>
                                                                </f:facet>
                                                                <ice:rowSelector id="rowSelector1" multiple="true" value="#{currentRow['selected']}"/>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="panelLayout2" style="border: 1px solid rgb(204, 204, 204); height: 358px; left: 490px; top: 230px; overflow: auto; position: absolute; width: 250px">
                                                        <ice:dataTable binding="#{Attendance$AssignEmployeePage.tblAssgnedUsers}" clientOnly="true"
                                                            id="tblAssgnedUsers" style="position: absolute"
                                                            value="#{Attendance$AssignEmployeePage.avilableEmployeeInGroup}" var="currentRow" width="100%">
                                                            <ice:column id="column2" style="width: 100px;bgcolor:red">
                                                                <ice:outputText id="outputText6"
                                                                    style="color:#{currentRow['supportInfo'] eq 'true'?'black':'red'};" value="#{currentRow['employeeName']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText7" value="Employee has Location"/>
                                                                </f:facet>
                                                                <ice:rowSelector id="rowSelector2" multiple="true" value="#{currentRow['selected']}"/>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                    <ice:outputText id="lblDepartment" style="font-family: Cambria; left: 40px; top: 117px; position: absolute" value="Employee Department:"/>
                                                    <ice:outputText id="outputText1" style="font-family: Cambria; left: 40px; top: 200px; position: absolute" value="Available  Employee  With Out Boss"/>
                                                    <ice:outputText id="outputText3" style="font-family: Cambria; left: 490px; top: 200px; position: absolute" value="List of Employee  has Boss"/>
                                                    <ice:commandButton action="#{Attendance$AssignEmployeePage.btnAdd_action}"
                                                        binding="#{Attendance$AssignEmployeePage.btnAdd}" id="btnAdd"
                                                        style="left: 360px; top: 300px; position: absolute; width: 50px" value="[ &gt; ]"/>
                                                    <ice:commandButton action="#{Attendance$AssignEmployeePage.btnRemove_action}"
                                                        binding="#{Attendance$AssignEmployeePage.btnRemove}" id="btnRemove"
                                                        style="left: 360px; top: 340px; position: absolute; width: 50px" value="[ &lt; ]"/>
                                                    <ice:commandButton action="#{Attendance$AssignEmployeePage.btnAddAll_action}"
                                                        binding="#{Attendance$AssignEmployeePage.btnAddAll}" id="btnAddAll"
                                                        style="left: 360px; top: 380px; position: absolute; width: 50px" value="[ &gt;&gt; ]"/>
                                                    <ice:commandButton action="#{Attendance$AssignEmployeePage.btnRemoveAll_action}"
                                                        binding="#{Attendance$AssignEmployeePage.btnRemoveAll}" id="btnRemoveAll"
                                                        style="left: 360px; top: 420px; position: absolute; width: 50px" value="[ &lt;&lt; ]"/>
                                                    <ice:commandButton action="#{Attendance$AssignEmployeePage.btnSaveGroup_action}" id="btnSaveGroup"
                                                        style="left: 40px; top: 650px; position: absolute; width: 170px" value="Save "/>
                                                    <ice:outputText binding="#{Attendance$AssignEmployeePage.lblDepartmentName}" id="lblDepartmentName"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 200px; top: 115px; position: absolute; width: 462px" value=":"/>
                                                    <ice:commandButton action="#{Attendance$AssignEmployeePage.btnTree_action}" id="btnTree"
                                                        image="/Employee/images/pic3-tree-icon.jpg" style="left: 652px; top: 113px; position: absolute" value="submit"/>
                                                    <ice:commandButton action="#{Attendance$AssignEmployeePage.btnAddEmployee_action}" id="btnAddEmployee"
                                                        style="left: 500px; top: 150px; position: absolute; width: 160px" value="Add"/>
                                                    <ice:commandButton action="#{Attendance$AssignEmployeePage.btnWithOutBoss_action}" id="btnWithOutBoss"
                                                        style="left: 200px; top: 150px; position: absolute; width: 160px" value="Employee with Out Boss"/>
                                                    <ice:selectInputText action="#{Attendance$AssignEmployeePage.txtEmployeeName_action}" id="txtEmployeeName"
                                                        listValue="#{ApplicationBean1.list}" listVar="employeeList" partialSubmit="true" rows="10"
                                                        style="left: 200px; top: 29px; position: absolute;" valueChangeListener="#{ApplicationBean1.updateList}" width="200px">
                                                        <f:facet name="selectInputText">
                                                            <ice:panelGrid columnClasses="fullNameCol,empIdCol" columns="2" style="width:150px">
                                                                <ice:outputText id="lblFullNameAutoComplete2" value="#{employeeList.fullName}"/>
                                                                <ice:outputText id="lblEmployeeIdAutoComplete2" value="#{employeeList.empIdentification}"/>
                                                            </ice:panelGrid>
                                                        </f:facet>
                                                    </ice:selectInputText>
                                                    <ice:outputText id="outputText8" style="font-family: Cambria; left: 450px; top: 29px; position: absolute" value="Employee Id :"/>
                                                    <ice:inputText binding="#{Attendance$AssignEmployeePage.txtEmployeeId}" id="txtEmployeeId" style="left: 550px; top: 29px; position: absolute; width: 160px"/>
                                                    <ice:commandButton action="#{Attendance$AssignEmployeePage.btnSearch_action}" id="btnSearch"
                                                        image="/Employee/images/btn_search.gif" style="left: 650px; top: 29px; position: absolute" value="submit"/>
                                                    <ice:outputText id="outputText9" style="font-family: Cambria; left: 40px; top: 72px; position: absolute" value="Employee Full Name"/>
                                                    <ice:outputText binding="#{Attendance$AssignEmployeePage.lblEmployeeFullName}" id="lblEmployeeFullName"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 200px; top: 72px; position: absolute; width: 462px" value=":"/>
                                                </ice:panelGroup>
                                            </ice:panelLayout>
                                        </fieldset>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="south">
                                <ice:panelGroup id="page_footer">
                                    <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">
                                        <label
                                                style="margin-left:10px;color:#333333;font-weight:bold;font-family:Cambria">Copyright @ 2005-2006 Ethiopian Calander | <a
                                                href="http://www.insa.gov.et" style="margin-left:10px;color:#333333;">BUNNA INTERNATIONAL BANK |INFORMATION SYSTEM DIVISION |Software Department.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Attendance$AssignEmployeePage.pnMessage}" clientOnly="true" draggable="false"
                            id="pnMessage" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#333333; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA HRMS: System:Message"/>
                                    <ice:commandLink action="#{Attendance$AssignEmployeePage.modalPnlCloseMesssage_action}" id="modalPnlCloseMesssage"
                                        immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 735px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Attendance$AssignEmployeePage.lblFormMessage1}" id="lblFormMessage1" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelLayout binding="#{Attendance$AssignEmployeePage.panelLayout3}" id="panelLayout3" layout="flow" rendered="false"
                            style="border-width: 2px; border-style: solid; height: 360px; left: 250px; top: 300px; overflow: scroll; position: absolute; width: 400px; -rave-layout: grid" styleClass="insideContainerMain">
                            <ice:tree binding="#{Attendance$AssignEmployeePage.tree1}" id="tree1"
                                style="height: 286px; margin-left: 0px; margin-top: 0px; text-align: left; width: 190px"
                                value="#{Attendance$AssignEmployeePage.tree1Model.model}" var="item">
                                <ice:treeNode id="treeNode1">
                                    <f:facet name="icon">
                                        <ice:panelGroup id="panelGroup1" style="display: inline;">
                                            <ice:graphicImage id="graphicImage1" value="#{item.userObject.icon}"/>
                                        </ice:panelGroup>
                                    </f:facet>
                                    <f:facet name="content">
                                        <ice:panelGroup id="panelGroup2" style="display: inline;">
                                            <ice:commandLink actionListener="#{Attendance$AssignEmployeePage.commandLink1_processAction}" id="commandLink1">
                                                <ice:outputText id="outputText2" value="#{item.userObject.text}"/>
                                            </ice:commandLink>
                                        </ice:panelGroup>
                                    </f:facet>
                                </ice:treeNode>
                            </ice:tree>
                        </ice:panelLayout>
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
