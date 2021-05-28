package ru.netology;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DeliveryAppTest {
    DateMethod dateMethod = new DateMethod();
    Cities cities = new Cities();

    @Test
    public void ShouldTestForm() {
        open("http://localhost:9999");
        SelenideElement form = $("[class=\"form form_size_m form_theme_alfa-on-white\"]");
        form.$("[data-test-id=city] input").setValue(cities.getRandomCity());
        form.$("[data-test-id=date] input").setValue(dateMethod.deliveryDate());
        form.$("[data-test-id=name] input").setValue("Петр Старков");
        form.$("[data-test-id=phone] input").setValue("+79270000000");
        form.$("[data-test-id=agreement]").click();
        form.$(withText("Забронировать")).click();
        $(withText("Встреча успешно забронирована на")).should(appear, Duration.ofSeconds(15));
    }

    @Test
    public void ShouldTestFormBySpaceInName() {
        open("http://localhost:9999");
        SelenideElement form = $("[class=\"form form_size_m form_theme_alfa-on-white\"]");
        form.$("[data-test-id=city] input").setValue(cities.getRandomCity());
        form.$("[data-test-id=date] input").setValue(dateMethod.deliveryDate());
        form.$("[data-test-id=name] input").setValue("Владимир Мирный Смирный");
        form.$("[data-test-id=phone] input").setValue("+79270000000");
        form.$("[data-test-id=agreement]").click();
        form.$(withText("Забронировать")).click();
        $(withText("Встреча успешно забронирована на")).should(appear, Duration.ofSeconds(15));
    }

    @Test
    public void ShouldTestFormWithHyphenInName() {
        open("http://localhost:9999");
        SelenideElement form = $("[class=\"form form_size_m form_theme_alfa-on-white\"]");
        form.$("[data-test-id=city] input").setValue(cities.getRandomCity());
        form.$("[data-test-id=date] input").setValue(dateMethod.deliveryDate());
        form.$("[data-test-id=name] input").setValue("Владимир Мирный-Смирный");
        form.$("[data-test-id=phone] input").setValue("+79270000000");
        form.$("[data-test-id=agreement]").click();
        form.$(withText("Забронировать")).click();
        $(withText("Встреча успешно забронирована на")).should(appear, Duration.ofSeconds(15));
    }

    @Test
    public void ShouldTestFormEng() {
        open("http://localhost:9999");
        SelenideElement form = $("[class=\"form form_size_m form_theme_alfa-on-white\"]");
        form.$("[data-test-id=city] input").setValue(cities.getRandomCity());
        form.$("[data-test-id=date] input").setValue(dateMethod.deliveryDate());
        form.$("[data-test-id=name] input").setValue("Petya Stark");
        form.$("[data-test-id=phone] input").setValue("+79270000000");
        form.$("[data-test-id=agreement]").click();
        form.$(withText("Забронировать")).click();
        $(withText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.")).should(appear);
    }

    @Test
    public void ShouldTestFormNumber10() {
        open("http://localhost:9999");
        SelenideElement form = $("[class=\"form form_size_m form_theme_alfa-on-white\"]");
        form.$("[data-test-id=city] input").setValue(cities.getRandomCity());
        form.$("[data-test-id=date] input").setValue(dateMethod.deliveryDate());
        form.$("[data-test-id=name] input").setValue("Владимир Мирный");
        form.$("[data-test-id=phone] input").setValue("+7927000000");
        form.$("[data-test-id=agreement]").click();
        form.$(withText("Забронировать")).click();
        $(withText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.")).should(appear);
    }

    @Test
    public void ShouldTestFormNumber12() {
        open("http://localhost:9999");
        SelenideElement form = $("[class=\"form form_size_m form_theme_alfa-on-white\"]");
        form.$("[data-test-id=city] input").setValue(cities.getRandomCity());
        form.$("[data-test-id=date] input").setValue(dateMethod.deliveryDate());
        form.$("[data-test-id=name] input").setValue("Владимир Мирный");
        form.$("[data-test-id=phone] input").setValue("+792700000000");
        form.$("[data-test-id=agreement]").click();
        form.$(withText("Забронировать")).click();
        $(withText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.")).should(appear);
    }

    @Test
    public void ShouldTestFormNumberWith8() {
        open("http://localhost:9999");
        SelenideElement form = $("[class=\"form form_size_m form_theme_alfa-on-white\"]");
        form.$("[data-test-id=city] input").setValue(cities.getRandomCity());
        form.$("[data-test-id=date] input").setValue(dateMethod.deliveryDate());
        form.$("[data-test-id=name] input").setValue("Владимир Мирный");
        form.$("[data-test-id=phone] input").setValue("89110000000");
        form.$("[data-test-id=agreement]").click();
        form.$(withText("Забронировать")).click();
        $(withText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.")).should(appear);
    }

    @Test
    public void ShouldTestFormWithoutAgreement() {
        open("http://localhost:9999");
        SelenideElement form = $("[class=\"form form_size_m form_theme_alfa-on-white\"]");
        form.$("[data-test-id=city] input").setValue(cities.getRandomCity());
        form.$("[data-test-id=date] input").setValue(dateMethod.deliveryDate());
        form.$("[data-test-id=name] input").setValue("Владимир Мирный-Смирный");
        form.$("[data-test-id=phone] input").setValue("+79270000000");
        form.$(withText("Забронировать")).click();
        form.$(By.className("checkbox_checked")).shouldNot(exist);
    }
}

