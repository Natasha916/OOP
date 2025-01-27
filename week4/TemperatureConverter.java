package week4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TemperatureConverter {
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    @Test
    public void testCelsiusToFahrenheit() {
        assertEquals(32.0, TemperatureConverter.celsiusToFahrenheit(0.0), 0.01);
        assertEquals(212.0, TemperatureConverter.celsiusToFahrenheit(100.0), 0.01);
        assertEquals(-40.0, TemperatureConverter.celsiusToFahrenheit(-40.0), 0.01);
        assertEquals(98.6, TemperatureConverter.celsiusToFahrenheit(37.0), 0.01);
    }

    @Test
    public void testFahrenheitToCelsius() {
        assertEquals(0.0, TemperatureConverter.fahrenheitToCelsius(32.0), 0.01);
        assertEquals(100.0, TemperatureConverter.fahrenheitToCelsius(212.0), 0.01);
        assertEquals(-40.0, TemperatureConverter.fahrenheitToCelsius(-40.0), 0.01);
        assertEquals(37.0, TemperatureConverter.fahrenheitToCelsius(98.6), 0.01);
    }
}
