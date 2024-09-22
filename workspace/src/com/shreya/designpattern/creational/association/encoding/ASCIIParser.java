package com.shreya.designpattern.creational.association.encoding;

import com.shreya.designpattern.creational.association.files.File;

public class ASCIIParser extends Parser{
    @Override
    public void parse(File file) {
        System.out.println("ASCIIParser Parser : File Name : " + file.getName());
    }
}
