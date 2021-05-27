package ru.netology;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateMethod {

    public String seeCurrentDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        LocalDate date = LocalDate.now();
        String text = date.format(formatter);

        return text;
    }
}

