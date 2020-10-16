package Challenges.MergeArrays;

import java.util.*;

/**
 * Cisco miraki: each array represents divise off time.
 * ex: during time: 5 to 10 device 1 off, and 20 - 30 it's off
 * input:
 * [
 *  [5, 10], [20, 30], [35, 53],
 *  [2, 4], [6, 11], [50, 90],
 *  [3, 11], [80, 95],
 *  [60, 105],
 *  [150, 200]
 * ]
 *
 * output:
 * [
 *  [2, 4], [3, 11], [5, 10], [6, 11], [20, 30],
 *  [35, 53], [50, 90], [60, 105], [150, 200]
 * ]
 */
public class MergeNTimeSerieses {
    public static void main(String[] args) {
        int[][][] data = {
                {{5, 10}, {20, 30}, {35, 53}},
                {{2, 4}, {6, 11}, {50, 90}},
                {{3, 11}, {80, 95}},
                {{60, 105}},
                {{150, 200}}
        };

        MergeNTimeSerieses solution = new MergeNTimeSerieses();
        System.out.println(solution.merge(data));

    }

    public List<List<Integer>> merge(int[][][] data) {
        final List<List<Integer>> result = new ArrayList<>();

        Queue<TimeSeries> queue = new PriorityQueue<>();

        for(int i = 0; i < data.length; i ++) {
            queue.add(new TimeSeries(data[i][0], i, 0));
        }

        while (!queue.isEmpty()) {
            TimeSeries timeSeries = queue.remove();

            List<Integer> series = new ArrayList<>();
            series.add(timeSeries.getData()[0]);
            series.add(timeSeries.getData()[1]);
            result.add(series);

            int index = timeSeries.getIndex();
            int nextCurrentIndex = timeSeries.getCurrentIndex() + 1;
            if(data[index].length > nextCurrentIndex) {
                queue.add(new TimeSeries(data[index][nextCurrentIndex], index, nextCurrentIndex));
            }
        }

        return result;
    }
}

class TimeSeries implements Comparable<TimeSeries> {
    int[] data;
    int index;
    int currentIndex;

    public TimeSeries(int[] data, int index, int currentIndex) {
        this.data = data;
        this.index = index;
        this.currentIndex = currentIndex;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    @Override
    public int compareTo(TimeSeries o) {
        return this.data[0] - o.data[0];
    }
}
