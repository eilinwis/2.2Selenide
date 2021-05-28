package ru.netology;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

public class DateMethod {

    public String deliveryDate() {

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, 3);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return simpleDateFormat.format(calendar.getTime());
    }
}
