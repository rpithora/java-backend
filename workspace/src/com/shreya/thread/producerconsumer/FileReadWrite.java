package com.shreya.thread.producerconsumer;

import java.io.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class FileReadWrite {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1024);

        ReaderThread reader = new ReaderThread(queue);
        WriterThread writer = new WriterThread(queue);

        new Thread(reader).start();
        new Thread(writer).start();

    }
}

class ReaderThread implements Runnable {

    protected BlockingQueue<String> blockingQueue = null;

    public ReaderThread(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("src\\com\\shreya\\thread\\producerconsumer\\inputFile.txt"));
            String buffer = null;
            while ((buffer = br.readLine()) != null) {
                blockingQueue.offer(buffer);
            }
            blockingQueue.put("EOF");  //When end of file has been reached
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class WriterThread implements Runnable {

    protected BlockingQueue<String> blockingQueue = null;

    public WriterThread(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("outputFile.txt");
            while (true) {
                String buffer = blockingQueue.poll();
                if (buffer.equals("EOF")) {
                    break;
                }
                System.out.println(buffer);
                writer.println(buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
}