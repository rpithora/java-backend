package com.shaurya._16companies.optum;

import java.io.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CountWords {

    final String readLocation;
    final String writeLocation;
    BlockingQueue<String> q;

    public CountWords(int size, String readLocation, String writeLocation) {
        this.q = new ArrayBlockingQueue(size);
        this.readLocation = readLocation;
        this.writeLocation = writeLocation;
    }

    public static void main(String[] args) throws IOException {
        CountWords countWords = new CountWords(10, "src\\com\\shaurya\\_16companies\\optum\\officers-info1.txt",
                "src\\com\\shaurya\\_16companies\\optum\\officers-info2.txt");

        Runnable readerTask = () -> {
            try {
                countWords.reader();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        Runnable writerTask = () -> {
            try {
                countWords.writer();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        new Thread(readerTask).start();
        new Thread(writerTask).start();
    }

    private void reader() throws IOException {
        System.out.println(readLocation);
        File f = new File(readLocation);
        System.out.println(f.getAbsoluteFile());
        BufferedReader reader = new BufferedReader(new FileReader(f));
        String buffer;
        while ((buffer = reader.readLine()) != null) {
            q.offer(buffer);
        }
        q.offer("EOF");
    }

    private void writer() throws IOException {
        System.out.println(writeLocation);
        File file = new File(writeLocation);
        /*Stream<String> str = Stream.of("IAS Bhanwar Shaurya Pratap Singh Chauhan"
                + "IAS Shreya Kanwar");*/
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        while (true) {
            String buf = q.poll();
            System.out.println(buf);
            if (buf == "EOF") {
                break;
            }
            writer.write(buf);
        }
        writer.close();
    }
}
