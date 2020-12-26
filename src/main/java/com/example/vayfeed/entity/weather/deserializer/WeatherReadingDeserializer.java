package com.example.vayfeed.entity.weather.deserializer;

import com.example.vayfeed.entity.weather.WeatherReading;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.IntNode;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.util.List;

@JsonComponent
public class WeatherReadingDeserializer extends JsonDeserializer<WeatherReading> {
    @Override
    public WeatherReading deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        WeatherReading weatherReading = new WeatherReading();

        TreeNode treeNode = jsonParser.getCodec().readTree(jsonParser);

        IntNode readingUnixTime = (IntNode) treeNode.get("dt");
        IntNode sunriseUnixTime = (IntNode) treeNode.get("sunrise");
        IntNode sunsetUnixTime = (IntNode) treeNode.get("sunset");
        DoubleNode tempKelvin = (DoubleNode) treeNode.get("temp");
        DoubleNode perceivedTempKelvin = (DoubleNode) treeNode.get("feels_like");
        IntNode pressure = (IntNode) treeNode.get("pressure");
        IntNode humidity = (IntNode) treeNode.get("humidity");
        IntNode cloudiness = (IntNode) treeNode.get("clouds");
        DoubleNode uvi = (DoubleNode) treeNode.get("uvi");
        DoubleNode windSpeed = (DoubleNode) treeNode.get("wind_speed");

        JsonNode weatherType = (JsonNode) treeNode.get("weather");

        weatherReading.setReadingUnixTime(readingUnixTime.intValue());
        weatherReading.setSunriseUnixTime(sunriseUnixTime.intValue());
        weatherReading.setSunsetUnixTime(sunsetUnixTime.intValue());
        weatherReading.setTempKelvin(tempKelvin.doubleValue());
        weatherReading.setPerceivedTempKelvin(perceivedTempKelvin.doubleValue());
        weatherReading.setPressure(pressure.intValue());
        weatherReading.setHumidity(humidity.intValue());
        weatherReading.setCloudiness(cloudiness.intValue());
        weatherReading.setUvi(uvi.doubleValue());
        weatherReading.setWindSpeed(windSpeed.doubleValue());

        JsonParser parser = weatherType.traverse();
        parser.setCodec(jsonParser.getCodec());
        weatherReading.setWeatherTypes(parser.readValuesAs(List.class).next());
        return weatherReading;
    }
}
