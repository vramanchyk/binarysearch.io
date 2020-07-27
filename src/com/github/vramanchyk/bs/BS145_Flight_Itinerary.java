package com.github.vramanchyk.bs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Vitali Ramanchyk on 7/27/20.
 */
public class BS145_Flight_Itinerary {

    private List<String> route = null;

    private void find(String cur, int count, Set<String> visited,
                      Map<String, List<String>> flights,
                      LinkedList<String> current) {

        if (count == 0) {
            route = new ArrayList<>(current);
            return;
        }

        if (route != null) {
            return;
        }

        List<String> destinations = flights.get(cur);
        if (destinations != null) {
            for (String dest : destinations) {
                if (visited.add(dest)) {
                    current.addLast(dest);
                    find(dest, count - 1, visited, flights, current);
                    current.removeLast();
                }
            }
        }
    }

    public String[] solve(String[][] flights) {

        Map<String, List<String>> edges = new HashMap<>();
        Set<String> destinations = new HashSet<>();

        for (String[] flight : flights) {
            edges.computeIfAbsent(flight[0], str -> new LinkedList<>()).add(flight[1]);
            destinations.add(flight[1]);
        }

        String start = null;
        for (String[] flight : flights) {
            if (!destinations.contains(flight[0])) {
                start = flight[0];
            }
        }

        Set<String> visited = new HashSet<>();
        LinkedList<String> current = new LinkedList<>();

        visited.add(start);
        current.add(start);

        find(start, destinations.size(), visited, edges, current);
        return route.toArray(new String[0]);
    }
}
