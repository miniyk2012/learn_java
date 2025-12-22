package org.example.example2;

import java.util.*;

public class Example2 {
    public static void main(String[] args) {
        Map<String, String[]> jobs1 = new HashMap<>();
        jobs1.put("Bob", new String[]{"jira-1", "jira-2"});
        jobs1.put("Alice", new String[]{"jira-3", "jira-4"});

        Map<String, String[]> jobs2 = new HashMap<>();
        jobs2.put("Sunny", new String[]{"jira-6", "jira-5"});
        jobs2.put("Bob", new String[]{"jira-7", "jira-8"});


        Map<String, List<String>> merged = mergeJobs(Arrays.asList(jobs1, jobs2));
        System.out.println(merged);
    }

    private static Map<String, List<String>> mergeJobs(List<Map<String, String[]>> jobs) {
        Map<String, List<String>> merged = new TreeMap<>();
        for (Map<String, String[]> job : jobs) {
            for (Map.Entry<String, String[]> ownerTickets : job.entrySet()) {
                for (String ticket : ownerTickets.getValue()) {
                    merged.computeIfAbsent(ownerTickets.getKey(), k -> new LinkedList<>()).add(ticket.toUpperCase());
                }
            }
        }
        // sort
        for (List<String> ownerJobs : merged.values()) {
            ownerJobs.sort(String::compareTo);
        }
        return merged;
    }
}
