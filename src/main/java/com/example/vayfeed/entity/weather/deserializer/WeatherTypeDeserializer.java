package com.example.vayfeed.entity.weather.deserializer;

import com.example.vayfeed.entity.weather.WeatherType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.NumericNode;
import com.fasterxml.jackson.databind.node.TextNode;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@JsonComponent
public class WeatherTypeDeserializer extends JsonDeserializer<List<WeatherType>> {
    @Override
    public List<WeatherType> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        WeatherType weatherType;
        List<WeatherType> types = new ArrayList<>();

        ArrayNode arrayNode = jsonParser.getCodec().readTree(jsonParser);

        for(JsonNode node : arrayNode){
            weatherType = new WeatherType();
            NumericNode typeId = (NumericNode) node.get("id");
            TextNode name = (TextNode) node.get("main");
            TextNode description = (TextNode) node.get("description");
            TextNode iconName = (TextNode) node.get("icon");

            weatherType.setTypeId(typeId.intValue());
            weatherType.setName(name.asText());
            weatherType.setDescription(description.asText());
            weatherType.setIconName(iconName.asText());

            types.add(weatherType);
        }

        return types;
    }
}
