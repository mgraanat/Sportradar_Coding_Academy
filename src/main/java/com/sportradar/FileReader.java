package com.sportradar;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

public class FileReader {

    public static void main(String[] args) throws IOException {
        File file = new File("BE_data.json");
        List<Event> events;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode rootNode = objectMapper.readTree(file);
            Event[] events2 = objectMapper.treeToValue(rootNode.getElements().next(), Event[].class);
            events = Arrays.stream(events2).collect(Collectors.toList());
            mostProbableResults(15, events);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void mostProbableResults(int count, List<Event> list) {
        if (list.size() < count) {
            throw new IllegalArgumentException();
        }
        list.sort(Comparator.comparingDouble(Event::getHighestProbableValue).reversed());
        for (int i = 0; i < count; i++) {
            Event event = list.get(i);
            System.out.println(event);
        }
    }

}

