package com.shreya.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatmapExample {
    public static void main(String[] args) {

        List<String> products1 = Arrays.asList("Printer", "Mouse", "Keyboard", "Motherboard");
        List<String> products2 = Arrays.asList("Scanner", "Projector", "Light Pen");
        List<String> products3 = Arrays.asList("Pen Drive", "Charger", "WIFI Adapter", "Cooling Fan");
        List<String> products4 = Arrays.asList("CPU Cabinet", "WebCam", "USB Light", "Microphone");

        List<List<String>> allProducts = new ArrayList<List<String>>();
        allProducts.add(products1);
        allProducts.add(products2);
        allProducts.add(products3);
        allProducts.add(products4);

        List<String> listOfAllProducts = allProducts.stream().flatMap(s -> s.stream()).collect(Collectors.toList());
        listOfAllProducts.stream().forEach(System.out::println);
    }
}
