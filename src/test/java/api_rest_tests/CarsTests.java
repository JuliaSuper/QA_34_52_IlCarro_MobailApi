package api_rest_tests;

import controllers.CarController;
import dto.BookedDto;
import dto.Car;
import dto.SearchCarDto;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BookingFactory;
import utils.CarFactory;
import utils.SearchCarFactory;

public class CarsTests extends CarController {
    @Test
    public void addNewCarPositiveTest(){
        Car car = CarFactory.posittiveCar();
        Assert.assertEquals(addNewCar(car).getStatusCode(),200);
    }

    @Test
    public void bookingCarPositiveTest(){
        Car car = CarFactory.posittiveCar();
        addNewCar(car);
        String serialNumber = car.getSerialNumber();
        BookedDto bookingBody = BookingFactory.positiveBooking();
        Response response = bookCar(serialNumber, bookingBody);
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void searchCarPositiveTest() {
        SearchCarDto searchCarDto = SearchCarFactory.positiveSearchCar();
        Response response = searchCar(searchCarDto);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void getUserCarsPositiveTest(){
        Car car = CarFactory.posittiveCar();
        Assert.assertEquals(getUserCars().getStatusCode(),200);
    }

    @Test
    public void deleteUserCarsPositiveTest(){
        Car car = CarFactory.posittiveCar();
        addNewCar(car);
        String serialNumber = car.getSerialNumber();
        Assert.assertEquals(deleteUserCars(serialNumber).getStatusCode(),200);
    }
}
