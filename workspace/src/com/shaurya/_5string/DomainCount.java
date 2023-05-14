package com.shaurya._5string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DomainCount {
    public static void main(String[] args) {
        String[] arr = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(subdomainVisits(arr));
    }

    public static List<String> subdomainVisits(String[] cpDomains) {
        Map<String, Integer> counts = new HashMap();
        for (String domain : cpDomains) {
            String[] cpInfo = domain.split("\\s+");
            String[] frags = cpInfo[1].split("\\.");
            int count = Integer.valueOf(cpInfo[0]);
            String cur = "";
            for (int i = frags.length - 1; i >= 0; --i) {
                cur = frags[i] + (i < frags.length - 1 ? "." : "") + cur;
                counts.put(cur, counts.getOrDefault(cur, 0) + count);
            }
        }

        List<String> ans = new ArrayList();
        for (String dom : counts.keySet())
            ans.add("" + counts.get(dom) + " " + dom);
        return ans;
    }
}
