package com.shaurya._3slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringLengthUniqueChar {
    public static void main(String[] args) {
        String a = "aebcabgeb@#gbkdb#";
        Set<Character> hSet = new HashSet<>();
        int l =0, r = 0, ans = Integer.MIN_VALUE;
        int li =0, ri=0;
        while (r < a.length()){
            if(hSet.contains(a.charAt(r))){
                //ans = Math.max(ans, r-l);
                if(ans < r-l){
                    ans = r-l;
                    li = l;
                    ri = r;
                }
                while (a.charAt(l) != a.charAt(r)){
                    hSet.remove(a.charAt(l));
                    l++;
                }
                l++;
            }else {
                hSet.add(a.charAt(r));
            }
            r++;
        }
        //ans = Math.max(ans, r-l);
        if(ans < r-l){
            ans = r-l;
            li = l;
            ri = r;
        }
        System.out.println("Max Length : " + ans + " and the substring : " + a.substring(li, ri));
    }
}
