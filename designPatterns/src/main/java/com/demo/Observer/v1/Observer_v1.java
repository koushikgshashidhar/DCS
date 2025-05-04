package com.demo.Observer.v1;


// Observer Pattern
// The Observer Pattern is a behavioral design pattern that defines a one-to-many dependency between objects
// so that when one object changes state, all its dependents are notified and updated automatically.
//lets work with a simple example, Weather Station application
//the ask is when the weather condition changes , the display elements should be updated
// so we have a WeatherData class that will notify the display elements when the weather condition changes
//we have multiple display elements that will be updated when the weather condition changes
//the weather condition are temperature, humidity and pressure which are state of the WeatherData class


public class Observer_v1 {
}

class WeatherData {
    private float temperature;
    private float humidity;
    private float pressure;

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }



    public WeatherData(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public void measurementsChanged() {
       // code to implement
    }
}
