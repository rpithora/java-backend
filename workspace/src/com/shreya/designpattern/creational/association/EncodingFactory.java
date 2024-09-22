package com.shreya.designpattern.creational.association;

import com.shreya.designpattern.creational.association.encoding.ASCIIParser;
import com.shreya.designpattern.creational.association.encoding.BinaryParser;
import com.shreya.designpattern.creational.association.encoding.EncodingType;
import com.shreya.designpattern.creational.association.encoding.Parser;

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
