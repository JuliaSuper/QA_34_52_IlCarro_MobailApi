package utils;

import dto.BookedDto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static utils.PropertiesReader.getProperty;

public class BookingFactory {

    public static BookedDto positiveBooking() {
        LocalDate startDate = LocalDate.now().plusDays(2);
        LocalDate endDate = startDate.plusDays(5);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return BookedDto.builder()
                .email(getProperty("base.properties", "email"))
                .startDate(startDate.format(formatter))
                .endDate(endDate.format(formatter))
                .build();
    }
}
