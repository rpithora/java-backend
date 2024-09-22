package com.shreya.designpattern.creational.association;

import com.shreya.designpattern.creational.association.encoding.EncodingType;
import com.shreya.designpattern.creational.association.encoding.Parser;
import com.shreya.designpattern.creational.association.files.File;
import com.shreya.designpattern.creational.association.files.FileType;

public class Main {
    public static void main(String[] args) {
        try {
            File jsonFile = FileFactory.getFileFactory().getFileInstance(FileType.XML, "MyJson.xml");
            Parser parser = EncodingFactory.getEncodingFactory().getParserInstance(EncodingType.ASCII);
            parser.parse(jsonFile);
        } catch (Exception e) {
            System.err.println("Exception in here ::: " + e.getMessage());
        }
    }
}
