package com.shreya.designpattern.creational.association.encoding;

import com.shreya.designpattern.creational.association.files.File;

public class BinaryParser extends Parser{
    @Override
    public void parse(File file) {
        System.out.println("BinaryParser Parser : File Name : " + file.getName());
    }
}
