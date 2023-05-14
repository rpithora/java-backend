package com.shaurya._16companies.deshaw;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PriceComparison {

    ExecutorService threadPool = Executors.newFixedThreadPool(3);
    CountDownLatch countDownLatch = new CountDownLatch(3);

    public Set getPrices() throws InterruptedException {
        Set<Integer> prices = Collections.synchronizedSet(new HashSet<>());
        threadPool.submit(new PullPricesTask(countDownLatch, "amazon.com", "iphone", prices));
        threadPool.submit(new PullPricesTask(countDownLatch, "flipkart.com", "iphone", prices));
        threadPool.submit(new PullPricesTask(countDownLatch, "walmart.com", "iphone", prices));

        countDownLatch.await(3, TimeUnit.SECONDS);

        return prices;
    }

    public static void main(String[] args) {
        PriceComparison priceComparison = new PriceComparison();
        try {
            priceComparison.getPrices().forEach(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Integer a = null;
        System.out.println(a);

        String s1 = "Shaurya" ;
        String s2 = "Shaurya" ;
        String s3 = new String("Shaurya") ;
        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        ArrayList<Integer> al = new ArrayList<>();
    }
}

class PullPricesTask implements Runnable {

    Set<Integer> prices;
    String url;
    String productId;
    CountDownLatch countDownLatch;

    public PullPricesTask(CountDownLatch countDownLatch, String url, String productId, Set<Integer> prices){
        this.countDownLatch = countDownLatch;
        this.url = url;
        this.productId = productId;
        this.prices = prices;
    }
    @Override
    public void run() {
        if(url == "walmart.com"){
            System.out.println("Inside here ::: ");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Random random = new Random();
        int price = random.nextInt(100);
        prices.add(price);
        countDownLatch.countDown();
    }
}
