package com.shaurya._6recursion;

import java.util.Arrays;

public class JosephusProblemGameOfDeathInCircle {
    public static void main(String[] args) {
        int n = 40;
        int k = 7;

        int[] soldiers = new int[n];

        for(int i=0; i<n; i++){
            soldiers[i] = i+1;
        }

        Arrays.stream(soldiers).forEach(s -> System.out.print(s + " "));
        System.out.println();
        solution(soldiers, k-1, 0);
    }

    private static void solution(int[] soldiers, int k, int deathIndex) {
        if(soldiers.length == 1){
            System.out.println("Last Man Standing : " + soldiers[0]);
            return ;
        }

        deathIndex = (deathIndex + k) % soldiers.length ;
        System.out.println("DeathIndex : " + deathIndex);
        soldiers = removeElement(soldiers, deathIndex);
        Arrays.stream(soldiers).forEach(s -> System.out.print(s + " "));
        System.out.println();
        solution(soldiers, k, deathIndex);
    }

    private static int[] removeElement(int[] soldiers, int deathIndex) {
        int[] proxyArray = new int[soldiers.length - 1];
        for (int i = 0, k = 0; i < soldiers.length; i++) {

            // check if index is crossed, continue without copying
            if (i == deathIndex) {
                continue;
            }

            // else copy the element
            proxyArray[k++] = soldiers[i];
        }
        return proxyArray;
    }

    /*int[] finalSoldiers = soldiers;
    int finalDeathIndex = deathIndex;
    soldiers = IntStream.range(0, soldiers.length).filter(i -> i!= finalDeathIndex).map(i -> finalSoldiers[i]).toArray();
        Arrays.stream(soldiers).forEach(s -> System.out.print(s + " "));
        System.out.println();*/
}
