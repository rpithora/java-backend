package com.shreya.designpattern.association.files;

public abstract class File {
    String name;
    File(String name){
        this.name = name;
    }
    public abstract String getName();
    public abstract String getType(FileType fileType);
}
