package com.shreya.designpattern.creational.association;

import com.shreya.designpattern.creational.association.files.File;
import com.shreya.designpattern.creational.association.files.FileType;
import com.shreya.designpattern.creational.association.files.JSONFIle;
import com.shreya.designpattern.creational.association.files.XMLFile;

public class FileFactory {
    static FileFactory fileFactory = new FileFactory();

    public static FileFactory getFileFactory(){
        return fileFactory;
    }

    public File getFileInstance(FileType fileType, String fileName) throws Exception {
        switch (fileType){
            case XML:
                return new XMLFile(fileName);
            case JSON:
                return new JSONFIle(fileName);
            default:
                throw new Exception("File Type not supported.");
        }
    }
}
