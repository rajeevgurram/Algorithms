package Interviews;

import Challenges.MergeArrays.MergeNTimeSerieses;

import java.util.ArrayList;
import java.util.List;

/**
 * Given list of time ranges, represents the start & end time of
 * a particular device that is down.
 * write a function to analyze the data and return in such a way
 * that it represents overall network down time
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
 *  [2, 11], [20, 30], [35, 105], [150, 200]
 * ]
 */
public class CISCO_MERAKI_NetworkDownAnalyzer {
    public static void main(String[] args) {
        int[][][] data = {
                {{5, 10}, {20, 30}, {35, 53}},
                {{2, 4}, {6, 11}, {50, 90}},
                {{3, 11}, {80, 95}},
                {{60, 105}},
                {{150, 200}}
        };

        MergeNTimeSerieses merge = new MergeNTimeSerieses();
        List<List<Integer>> flattenData = merge.merge(data);
        CISCO_MERAKI_NetworkDownAnalyzer solution = new CISCO_MERAKI_NetworkDownAnalyzer();
        System.out.println(solution.networkOutage(flattenData));
    }

    public List<List<Integer>> networkOutage(List<List<Integer>> flattenedData) {
        List<List<Integer>> result = new ArrayList<>();
        int startTime = flattenedData.get(0).get(0),
                endTime = flattenedData.get(0).get(1);
        for(int i = 1; i < flattenedData.size(); i ++) {
            List<Integer> series = flattenedData.get(i);
            if(endTime > series.get(0)) {
                startTime = Math.min(startTime, series.get(0));
                endTime = Math.max(endTime, series.get(1));
            } else {
                List<Integer> outage = new ArrayList<>();
                outage.add(startTime);
                outage.add(endTime);
                result.add(outage);

                startTime = series.get(0);
                endTime = series.get(1);
            }
        }

        List<Integer> lastRecord = result.get(result.size() - 1);
        if(lastRecord.get(0) != startTime || lastRecord.get(1) != endTime) {
            List<Integer> outage = new ArrayList<>();
            outage.add(startTime);
            outage.add(endTime);
            result.add(outage);
        }

        return result;
    }
}
