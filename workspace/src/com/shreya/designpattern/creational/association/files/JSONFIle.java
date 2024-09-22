package com.shreya.designpattern.creational.association.files;

public class JSONFIle extends File{

    public JSONFIle(String name){
        super(name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType(FileType fileType) {
        return fileType.name();
    }
}
