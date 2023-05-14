package com.shreya.designpattern.association.encoding;

import com.shreya.designpattern.association.files.File;

public class ASCIIParser extends Parser{
    @Override
    public void parse(File file) {
        System.out.println("ASCIIParser Parser : File Name : " + file.getName());
    }
}
