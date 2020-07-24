package com.github.vramanchyk.bs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Vitali Ramanchyk on 7/24/20.
 */
public class BS242_Movie_Theatres {

    private static class Event {

        private final int time;

        private final boolean start;

        Event(int time, boolean start) {
            this.time = time;
            this.start = start;
        }
    }

    public int solve(int[][] intervals) {
        final int n = 2 * intervals.length;

        List<Event> events = new ArrayList<>(n);
        for (int[] interval : intervals) {
            events.add(new Event(interval[0], true));
            events.add(new Event(interval[1], false));
        }

        events.sort(Comparator.comparingInt(a -> a.time));

        int cursor = 0;
        int theatres = 0;
        int answer = 0;

        while (cursor < n) {
            int slide = cursor;
            int curTime = events.get(cursor).time;
            while (slide < n && curTime == events.get(slide).time) {
                theatres += events.get(slide).start ? 1 : -1;
                slide++;
            }

            cursor = slide;
            answer = Math.max(answer, theatres);
        }

        return answer;
    }
}
