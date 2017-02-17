
//alert("some trial");
//VARIABLES
//constants
var weekDays = {
    MONDAY : 0,
    TUSDAY : 1,
    WEDNESDAY : 2,
    THURSDAY : 3,
    FRIDAY : 4,
    SATURDAY : 5,
    SUNDAY : 6
};
var firstDayOf1999 = weekDays.MONDAY, meskerem1999 = 1, year1999 = 1999;

// non constants
var calStartDay = firstDayOf1999;
var calMonth = meskerem1999;
var calYear = year1999;
var calDay;
var calTextDisplayId;
var calParentId=null;
var calCmdEvent = null;
var calCmbEvent = null;
var isToday =true;

//alert("some trial 3");
//METHODS

//moves _noOfDays from the calStartDay and display
function moveDays(_noOfDays){
    calStartDay = (calStartDay + _noOfDays) % 7;
    // if the move is backward
    if(calStartDay < 0)
        calStartDay += 7;
}
//current day
function today(){
    var d=new Date();
    var a =d.getFullYear();
    var b=d.getMonth();
    var c=d.getDate();

    //alert(c.getFullYear());
    var mon;
    if((b==0))
        mon="January";
    else if(b==1)
        mon="Feburary";
    else if (b==2)
        mon="March";
    else if(b==3)
        mon="April";
    else if(b==4)
        mon="May";
    else if(b==5)
        mon="June";
    else if(b==6)
        mon="July";
    else if(b==7)
        mon="August";
    else if(b==8)
        mon="September";
    else if(b==9)
        mon="October";
    else if(b==10)
        mon="November";
    else
        mon="December";

    var x=new Date(mon+" "+c+", "+a);

    var y=new Date("September 11, 2006");

    var noOfDays=x.getTime()-y.getTime();
    noOfDays /= (1000 * 60 * 60 * 24);
    var j=noOfDays % 365;
    var noYear = noOfDays / 365;

    var currentYear=1999;
    var currentMonth=1;
    var currentDate=1;
    //        currentYear+= noYear;
    currentYear+= noYear-j/365;

    noOfDays %= 365;
    if(noOfDays < noYear % 4){

        currentYear--;
        noOfDays += 365;
    }

    noOfDays -= (noYear % 4);
    var i=noOfDays%30;
    //         currentMonth += ( noOfDays / 30 );
    currentMonth += ( noOfDays / 30-i/30 );

    currentDate += ( noOfDays % 30 );
    calYear=currentYear;
    calMonth=currentMonth;
// calDay=currentDate;
}

//event handler of cmbMonths
function monthChanged(_event){
    // selected month = index of cmbMonths
    isToday= false
    var calCmbMonth = document.getElementById("calCmbMonths");
    var _selectedMonth = calCmbMonth.options[calCmbMonth.selectedIndex].value;
    moveDays((_selectedMonth - calMonth) * 2);
    calMonth = _selectedMonth;
    dispalyCalendar(calCmdEvent, calTextDisplayId, calParentId);

}
//event handler of cmbYear
function yearChanged(_event){
    // selected year = index cmbYear + 1900
    var calCmbYear = document.getElementById("calCmbYears");
    var _selectedYear = calCmbYear.options[calCmbYear.selectedIndex].value;

    //reset to meskerem of  year 1999 and move
    var _yearDifference = _selectedYear - year1999;
    calStartDay = firstDayOf1999;
    calMonth = 1;

    var _leapYear = 0;
    //calculate for leap years
    _leapYear = Math.floor(_yearDifference / 4);


    if(_yearDifference > 0){
        // year 1999 is a leap year
        _leapYear++;
    }

    moveDays(_yearDifference + _leapYear);
    calYear = _selectedYear;

    monthChanged(calCmdEvent);

}

//fill the day names
function selectedDate(_date){

    var _txtToDisplayIn = document.getElementById(calTextDisplayId);
    ////   try  alert(_txtToDisplayIn);
    var _arr_date = _date.split('-');
    var _twoDigitDate, _twoDigitMonth;

    //make date two digits
    if(_arr_date[0] < 10){
        _twoDigitDate = "0" + _arr_date[0];
    }
    else{
        _twoDigitDate = _arr_date[0];
    }
    // make month 2 digits
    if(_arr_date[1] < 10){
        _twoDigitMonth = "0" + _arr_date[1];
    }
    else{
        _twoDigitMonth = _arr_date[1];
    }

    _txtToDisplayIn.value = _arr_date[2]+ "-" + _twoDigitMonth + "-" + _twoDigitDate;

    close();
}

//removes the calendar object
function close(){
    isToday=true
    var calParent = document.getElementById(calParentId);
    var calToRemove = document.getElementById("calendar");
    calParent.removeChild(calToRemove);

}



//calls dispay(_startDay) if no calendar is displayed
function dispalyCalendar(_evt, _txtId, _parentId){
    if(isToday){
        today();
    }
    // if already displayed then close it
    calTextDisplayId = _txtId;
    calParentId = _parentId;
    calCmdEvent = _evt;

    var _calLeft = calCmdEvent.screenX;
    var _calTop = calCmdEvent.screenY;
    if(document.getElementById("calendar")){
        close();
    }
    //browser dependant event handling ==> should be changed
    //var srcButton = document.getElementById(evt.target.id);
    if(_calTop + 170 > window.innerHeight){
        _calTop = _calTop - 190;
    }
    display(calStartDay % 7, _calLeft - 200, _calTop - 125);


}

// this method fills the table starting from _startDay
function display(_startDay, _left, _top)
{
    var cal = document.createElement('div');
    cal.setAttribute('id', "calendar");

    cal.style.position = "absolute";
    cal.style.background = "white";
    cal.style.width = "230px";
    cal.style.height = "175px";
    cal.style.top = _top+"px";
    cal.style.left = _left+"px";
    cal.style.zIndex = "100";

    var calInterface = '<div id="calendar" class ="cal_container" >' +
    '<div id="cal_navigation" class="cal_navigation">' +
    '<span> <\/span>' +
    '<select id="calCmbMonths" class="cal_select" onChange="monthChanged(event);">' ;
    var _months_names = document.getElementById("cal_month_names").value;
    var _ui_month_names = "";
    var _arr_month_names = _months_names.split(',');

    for(var m = 1; m < 14; m++){
        if(m != calMonth){
            _ui_month_names += '<option value = "' + m + '">' + _arr_month_names[m-1] + '<\/option>';
        }
        else {
            _ui_month_names += '<option selected value = "' + m + '">' + _arr_month_names[m-1] + '<\/option>';
        }


    }
    calInterface += _ui_month_names;
    calInterface += '<\/select>' +
    '<span style="color:transparent">.<\/span>' +
    '<select id="calCmbYears" class="cal_select" onChange="yearChanged(event);">';
    var _ui_year_values = "";
    for(var y = 1900; y < 2100; y++){
        if(y != calYear){
            _ui_year_values += '<option value = "' + y + '">' + y + '<\/option>';
        }
        else {
            _ui_year_values += '<option selected value = "' + y + '">' + y + '<\/option>';
        }
    }
    calInterface += _ui_year_values;
    calInterface += '<\/select>' +
    '<\/div>' +
    '<div id="cal_content">' +
    '<table id="cal_table" border="0" cellpadding="0" cellspacing="1">';
    var _dayNames = document.getElementById("cal_day_names").value;
    var _day = _dayNames.split(',');

    var _rows ='<tr id="cal_header" style="border:none">' +
    '<tr style="margin-top:-5px;" class="mon_days"><\/tr>' +
    '<td>'+_day[0]+'<\/td>' +
    '<td>'+_day[1]+'<\/td>' +
    '<td>'+_day[2]+'<\/td>' +
    '<td>'+_day[3]+'<\/td>' +
    '<td>'+_day[4]+'<\/td>' +
    '<td>'+_day[5]+'<\/td>' +
    '<td>'+_day[6]+'<\/td>' +
    '<\/tr>'+
    '<tr><td colspan="8"><hr style="width:200px; margin-top:-5px;"/><td><\/tr>';
    var _days = 1;
    var _month = calMonth;
    var _year = calYear;

    for(var i = 0; i < 6; i++){
        _rows += '<tr>';
        var count=0;
        for(var j = 0; j < 7; j++){
            if(j >= _startDay){
                _startDay = 0;


                if(_month==13){
                    if((_year % 4 == 0) && (_year % 100 != 0) || (_year % 400 == 0)){
                        if(_days>6){
                            ++count;
                        }
                    }
                    else if(_days>5){
                        ++count;
                    }
                    if(count){
                        if(i==5){
                            break;
                        }
                        _rows += '<td class = "no_data"><\/td>';
                    }
                    else{
                        _rows += '<td><a class = "a_calendar" href="javascript:selectedDate(\'' +
                        _days + '-' + _month + '-' + _year+ '\'' +');" >' + _days + '<\/a><\/td>';

                        _days++;
                    }
                }
                else{

                    if(_days > 30){
                        break;
                    }
                    _rows += '<td><a class = "a_calendar" href="javascript:selectedDate(\'' +
                    _days + '-' + _month + '-' + _year+ '\'' +');" >' + _days + '<\/a><\/td>';

                    _days++;
                }
            }
            else {
                _rows += '<td class = "no_data"><\/td>';
            }
        }
        _rows += '<\/tr>';

        if(_days > 30)
            break;
    }

    var _footer = '<\/table>' +
    '<\/div>' +
    '<\/div>';

    calInterface = calInterface + _rows + _footer;
    //cal.innerHTML= '<a href="#"> some content <\/a>';
    cal.innerHTML = calInterface;

    var here = document.getElementById(calParentId);
    here.appendChild(cal);

    //alert(calInterface);

    var _table = document.getElementById("cal_table");
}
