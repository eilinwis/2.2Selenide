package ru.netology;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateMethod {
    private int shift;

    public String deliveryDate(int shift) {

        LocalDate localDate = LocalDate.now().plusDays(shift);
        String text = localDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return text;
    }
}
