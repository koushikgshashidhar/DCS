package com.demo.Observer.v3;


// Observer Pattern
// The Observer Pattern is a behavioral design pattern that defines a one-to-many dependency between objects
// so that when one object changes state, all its dependents are notified and updated automatically.
//lets work with a simple example, Weather Station application
//the ask is when the weather condition changes , the display elements should be updated
// so we have a WeatherData class that will notify the display elements when the weather condition changes
//we have multiple display elements that will be updated when the weather condition changes
//the weather condition are temperature, humidity and pressure which are state of the WeatherData class

//let see how first version looks like
// we have hardcoded the display elements in the WeatherData class, where there is no way to add or remove display elements without changing the code
//we also see common interfaces in the display elements ie update() method
//what if we want to add a new display element, we have to change the WeatherData class
//it is similar to publisher-subscriber pattern , but here publisher is called subject and subscriber is called observer
//strive for loose coupling between objects that interact with each other

import java.util.ArrayList;
import java.util.List;

public class Observer_v3 {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData(30, 65, 30.4f);
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(28, 70, 29.2f);
        weatherData.setMeasurements(26, 90, 29.2f);
//        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
//        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
    }
}
interface Observer {
    void update(float temp, float humidity, float pressure);
}

interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
interface DisplayElement {
    void display();
}

class WeatherData implements Subject {
    private float temperature;
    private float humidity;
    private float pressure;
    private List<Observer> observers;
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
        observers= new ArrayList<>();
    }

    public void measurementsChanged() {
       // code to implement
        notifyObservers();
    }
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }
}
class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private WeatherData weatherData;

    public CurrentConditionsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }
}
