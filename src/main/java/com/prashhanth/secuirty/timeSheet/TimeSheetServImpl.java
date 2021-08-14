package com.prashhanth.secuirty.timeSheet;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TimeSheetServImpl {

    public static List<WeekAndDt> getData(String date) throws ParseException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dt = LocalDate.parse(date, dtf);
        YearMonth yearMonthObject = YearMonth.of(dt.getYear(), dt.getMonth());
        int daysInMonth = yearMonthObject.lengthOfMonth();
        int count=0;
        ArrayList list= new ArrayList();
        for (int startDay = dt.getDayOfMonth(); startDay < daysInMonth; startDay++) {
        WeekAndDt weekAndDt = new WeekAndDt();
            LocalDate localDate = dt.plusDays(++count);
            weekAndDt.setDay(localDate.getDayOfWeek().toString());
        weekAndDt.setDate(localDate);
        list.add(weekAndDt);
        }
        return list;

    }



    public static void main(String[] args) throws ParseException {
        List<WeekAndDt> data = getData("21-11-1992");

        data.stream().forEach(x-> System.out.println(x));
    }
}
