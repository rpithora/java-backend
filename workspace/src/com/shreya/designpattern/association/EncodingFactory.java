package com.shreya.designpattern.association;

import com.shreya.designpattern.association.encoding.ASCIIParser;
import com.shreya.designpattern.association.encoding.BinaryParser;
import com.shreya.designpattern.association.encoding.EncodingType;
import com.shreya.designpattern.association.encoding.Parser;
import com.shreya.designpattern.association.files.File;
import com.shreya.designpattern.association.files.FileType;
import com.shreya.designpattern.association.files.JSONFIle;
import com.shreya.designpattern.association.files.XMLFile;

public class EncodingFactory {
    static EncodingFactory encodingFactory = new EncodingFactory();

    public static EncodingFactory getEncodingFactory(){
        return encodingFactory;
    }

    public Parser getParserInstance(EncodingType encodingType) throws Exception {
        switch (encodingType){
            case ASCII:
                return new ASCIIParser();
            case BINARY:
                return new BinaryParser();
            default:
                throw new Exception("File Type not supported.");
        }
    }
}
