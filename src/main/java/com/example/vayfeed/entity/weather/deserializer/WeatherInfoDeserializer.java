package com.example.vayfeed.entity.weather.deserializer;

import com.example.vayfeed.entity.weather.WeatherInfo;
import com.example.vayfeed.entity.weather.WeatherReading;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.TextNode;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class WeatherInfoDeserializer extends JsonDeserializer<WeatherInfo> {

    @Override
    public WeatherInfo deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        WeatherInfo weatherInfo = new WeatherInfo();

        TreeNode treeNode = jsonParser.getCodec().readTree(jsonParser);
        DoubleNode lat = (DoubleNode) treeNode.get("lat");
        DoubleNode lon = (DoubleNode) treeNode.get("lon");
        TextNode timezone = (TextNode) treeNode.get("timezone");
        IntNode timezoneOffset = (IntNode) treeNode.get("timezone_offset");

        JsonNode currentWeatherReading = (JsonNode) treeNode.get("current");

        weatherInfo.setLat(lat.asDouble());
        weatherInfo.setLon(lon.asDouble());
        weatherInfo.setTimezone(timezone.asText());
        weatherInfo.setTimezoneOffset(Integer.toString(timezoneOffset.asInt()));

        JsonParser parser = currentWeatherReading.traverse();
        parser.setCodec(jsonParser.getCodec());
        weatherInfo.setCurrentWeatherReading(parser.readValuesAs(WeatherReading.class).next());


        return weatherInfo;
    }
}
