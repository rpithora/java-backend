package com.shreya.designpattern.association.files;

public class XMLFile extends File{

    String name;
    public XMLFile(String name){
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
