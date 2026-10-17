package utils;

import dto.SearchCarDto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SearchCarFactory {
    public static SearchCarDto positiveSearchCar() {
        LocalDate startDate = LocalDate.now().plusDays(1);
        LocalDate endDate = startDate.plusDays(3);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return SearchCarDto.builder()
                .city("Tel Aviv")
                .startDate(startDate.format(formatter))
                .endDate(endDate.format(formatter))
                .build();
    }
}
