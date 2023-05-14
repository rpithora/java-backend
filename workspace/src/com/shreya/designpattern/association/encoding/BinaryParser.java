package com.shreya.designpattern.association.encoding;

import com.shreya.designpattern.association.files.File;

public class BinaryParser extends Parser{
    @Override
    public void parse(File file) {
        System.out.println("BinaryParser Parser : File Name : " + file.getName());
    }
}
