/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.TransportAbsenceDatePaymentManager;

/**
 *
 * @author Henok
 */
public class TransportPaymentsModel {

   int absenceId;
    String serviceName;
    String shift;
    String inOut;
    String absenceDate;
    String status;
    String serviceId;
    String actualLocation;
    int transportPaymentId;
    String employeeId;
    String employeeName;
    private String locationName;
    private String absentAmount;
    double serviceAbsenteDate;
    double employeeAbsenteDate;
    double tarifPerDay;
    double extraPaymentPerDay;
    double paymentForNoTransport;
    double paymentForSAbsence;
    double daysInMonth;
    double totalEAbsenteDays;
    double totalPayment;
    int empLocationId;
    String empId;
    int locationId;
    int transportPaymentReqId;
    String requestDate;
    String startDate;
    String endDate;
    int requestID;
    String processedBy;
    String decision;
    String nextDate;
    String comment;
    String un;
    String recordDate;
    private boolean selected;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getAbsentAmount() {
        return absentAmount;
    }

    public void setAbsentAmount(String absentAmount) {
        this.absentAmount = absentAmount;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getAbsenceId() {
        return absenceId;
    }

    public void setAbsenceId(int absenceId) {
        this.absenceId = absenceId;
    }

    public String getAbsenceDate() {
        return absenceDate;
    }

    public void setAbsenceDate(String absenceDate) {
        this.absenceDate = absenceDate;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getInOut() {
        return inOut;
    }

    public void setInOut(String inOut) {
        this.inOut = inOut;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getDaysInMonth() {
        return daysInMonth;
    }

    public void setDaysInMonth(double daysInMonth) {
        this.daysInMonth = daysInMonth;
    }

    public double getEmployeeAbsenteDate() {
        return employeeAbsenteDate;
    }

    public void setEmployeeAbsenteDate(double employeeAbsenteDate) {
        this.employeeAbsenteDate = employeeAbsenteDate;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getExtraPaymentPerDay() {
        return extraPaymentPerDay;
    }

    public void setExtraPaymentPerDay(double extraPaymentPerDay) {
        this.extraPaymentPerDay = extraPaymentPerDay;
    }

    public double getPaymentForNoTransport() {
        return paymentForNoTransport;
    }

    public void setPaymentForNoTransport(double paymentForNoTransport) {
        this.paymentForNoTransport = paymentForNoTransport;
    }

    public double getPaymentForSAbsence() {
        return paymentForSAbsence;
    }

    public void setPaymentForSAbsence(double paymentForSAbsence) {
        this.paymentForSAbsence = paymentForSAbsence;
    }

    public double getServiceAbsenteDate() {
        return serviceAbsenteDate;
    }

    public void setServiceAbsenteDate(double serviceAbsenteDate) {
        this.serviceAbsenteDate = serviceAbsenteDate;
    }

    public double getTarifPerDay() {
        return tarifPerDay;
    }

    public void setTarifPerDay(double tarifPerDay) {
        this.tarifPerDay = tarifPerDay;
    }

    public double getTotalEAbsenteDays() {
        return totalEAbsenteDays;
    }

    public void setTotalEAbsenteDays(double totalEAbsenteDays) {
        this.totalEAbsenteDays = totalEAbsenteDays;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public String getActualLocation() {
        return actualLocation;
    }

    public void setActualLocation(String actualLocation) {
        this.actualLocation = actualLocation;
    }

    public int getTransportPaymentId() {
        return transportPaymentId;
    }

    public void setTransportPaymentId(int transportPaymentId) {
        this.transportPaymentId = transportPaymentId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public int getEmpLocationId() {
        return empLocationId;
    }

    public void setEmpLocationId(int empLocationId) {
        this.empLocationId = empLocationId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getTransportPaymentReqId() {
        return transportPaymentReqId;
    }

    public void setTransportPaymentReqId(int transportPaymentReqId) {
        this.transportPaymentReqId = transportPaymentReqId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getNextDate() {
        return nextDate;
    }

    public void setNextDate(String nextDate) {
        this.nextDate = nextDate;
    }

    public String getProcessedBy() {
        return processedBy;
    }

    public void setProcessedBy(String processedBy) {
        this.processedBy = processedBy;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public String getUn() {
        return un;
    }

    public void setUn(String un) {
        this.un = un;
    }

    public TransportPaymentsModel() {
    }

    public TransportPaymentsModel(int transportPaymentId) {
        this.transportPaymentId = transportPaymentId;
    }

    public TransportPaymentsModel(String serviceName, String shift, String absenceDate) {
        this.serviceName = serviceName;
        this.shift = shift;
        this.absenceDate = absenceDate;
    }

    public TransportPaymentsModel(String serviceName, String shift, String absenceDate, String status) {
        this.serviceName = serviceName;
        this.shift = shift;
        this.absenceDate = absenceDate;
        this.status = status;
    }

    public TransportPaymentsModel(String serviceId, String serviceName, String shift, String absenceDate, String status) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.shift = shift;
        this.absenceDate = absenceDate;
        this.status = status;
    }

    public TransportPaymentsModel(String serviceId, String serviceName, String shift, String inOut, String absenceDate, int absenceId) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.shift = shift;
        this.inOut = inOut;
        this.absenceDate = absenceDate;
        this.absenceId =  absenceId;
    }

    public TransportPaymentsModel(int absenceId, String serviceId, String serviceName, String shift, String absenceDate, String status) {
        this.absenceId = absenceId;
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.shift = shift;
        this.absenceDate = absenceDate;
        this.status = status;
    }
//    public TransportAbsenceDatePaymentModel(String employeeName, int serviceAbsenteDate, int employeeAbsenteDate,
//            double tarifPerDay, double paymentForSAbsence, int daysInMonth, int totalEAbsenteDays, double extraPayment, double totalPayment){
//        this.employeeName = employeeName;
//        this.serviceAbsenteDate = serviceAbsenteDate;
//        this.employeeAbsenteDate = employeeAbsenteDate;
//        this.tarifPerDay = tarifPerDay;
//        this.paymentForSAbsence = paymentForSAbsence;
//        this.daysInMonth = daysInMonth;
//        this.totalEAbsenteDays = totalEAbsenteDays;
//        this.extraPayment = extraPayment;
//        this.totalPayment = totalPayment;
//    }
//    public TransportAbsenceDatePaymentModel(int transportPaymentId, String employeeName, int serviceAbsenteDate, int employeeAbsenteDate,
//            double tarifPerDay, double paymentForSAbsence, int daysInMonth, int totalEAbsenteDays, double extraPayment, double totalPayment){
//        this.transportPaymentId = transportPaymentId;
//        this.employeeName = employeeName;
//        this.serviceAbsenteDate = serviceAbsenteDate;
//        this.employeeAbsenteDate = employeeAbsenteDate;
//        this.tarifPerDay = tarifPerDay;
//        this.paymentForSAbsence = paymentForSAbsence;
//        this.daysInMonth = daysInMonth;
//        this.totalEAbsenteDays = totalEAbsenteDays;
//        this.extraPayment = extraPayment;
//        this.totalPayment = totalPayment;
//    }

    public TransportPaymentsModel(int transportPaymentId, String employeeId, String employeeName, double serviceAbsenteDate, double employeeAbsenteDate,
            double tarifPerDay, double paymentForSAbsence, double daysInMonth, double totalEAbsenteDays, double extraPaymentPerDay, double paymentForNoTransport, double totalPayment) {
        this.transportPaymentId = transportPaymentId;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.serviceAbsenteDate = serviceAbsenteDate;
        this.employeeAbsenteDate = employeeAbsenteDate;
        this.tarifPerDay = tarifPerDay;
        this.paymentForSAbsence = paymentForSAbsence;
        this.daysInMonth = daysInMonth;
        this.totalEAbsenteDays = totalEAbsenteDays;
        this.extraPaymentPerDay = extraPaymentPerDay;
        this.paymentForNoTransport = paymentForNoTransport;
        this.totalPayment = totalPayment;
    }

    public TransportPaymentsModel(int transportPaymentId, String actualLocation, String employeeId, String employeeName, double serviceAbsenteDate, double employeeAbsenteDate,
            double tarifPerDay, double paymentForSAbsence, double daysInMonth, double totalEAbsenteDays, double extraPaymentPerDay, double paymentForNoTransport, double totalPayment) {
        this.transportPaymentId = transportPaymentId;
        this.actualLocation = actualLocation;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.serviceAbsenteDate = serviceAbsenteDate;
        this.employeeAbsenteDate = employeeAbsenteDate;
        this.tarifPerDay = tarifPerDay;
        this.paymentForSAbsence = paymentForSAbsence;
        this.daysInMonth = daysInMonth;
        this.totalEAbsenteDays = totalEAbsenteDays;
        this.extraPaymentPerDay = extraPaymentPerDay;
        this.paymentForNoTransport = paymentForNoTransport;
        this.totalPayment = totalPayment;
    }

    public TransportPaymentsModel(int empLocationId, String empId, int locationId) {
        this.empLocationId = empLocationId;
        this.empId = empId;
        this.locationId = locationId;
    }

    public TransportPaymentsModel(String serviceId, double extraTarif) {
        this.serviceId = serviceId;
        this.extraPaymentPerDay = extraTarif;
    }

    public TransportPaymentsModel(String serviceId, double extraTarif, String actualLocation) {
        this.serviceId = serviceId;
        this.extraPaymentPerDay = extraTarif;
        this.actualLocation = actualLocation;
    }

    public TransportPaymentsModel(int transportPaymentReqId, String requetDate, String startDate, String endDate) {
        this.transportPaymentReqId = transportPaymentReqId;
        this.requestDate = requetDate;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public TransportPaymentsModel(int requestID, String processedBy, String decision, String nextDate, String comment, String un, String recordDate) {
        this.requestID = requestID;
        this.processedBy = processedBy;
        this.decision = decision;
        this.nextDate = nextDate;
        this.comment = comment;
        this.un = un;
        this.recordDate = recordDate;
    }
//     public TransportAbsenceDatePaymentModel(String id, String emp_Id, String attendanceDate, String absentAmount, String dayDesc){
//         this.id = id;
//         this.emp_Id = emp_Id;
//         this.attendanceDate = attendanceDate;
//         this.absentAmount = absentAmount;
//         this.dayDesc = dayDesc;
//     }
}
