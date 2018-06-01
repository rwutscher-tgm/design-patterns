package javaObservable;

public class javaWeatherStation {

    public static void main(String[] args) {
        javaWeatherData javaweatherdata = new javaWeatherData();

        javaCurrentConditionDisplay currentDisplay =
                new javaCurrentConditionDisplay(javaweatherdata);

        javaweatherdata.setMeasurements(80, 65, 30.4f);
        javaweatherdata.setMeasurements(82, 70, 29.2f);
        javaweatherdata.setMeasurements(78, 90, 29.2f);
    }

}
