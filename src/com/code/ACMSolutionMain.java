package com.code;

import java.util.*;

public class ACMSolutionMain {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        Scanner in = new Scanner(System.in);
        int mounthlyCarsCount = Integer.parseInt(in.nextLine());
        List<String> mounthlyCars = new ArrayList<>();
        for (int i = 0; i < mounthlyCarsCount; i++) {
            String car = in.nextLine();
            mounthlyCars.add(car);
        }
        Map<String, List<Record>> recordMap = new HashMap<>();
        int t = 0;
        while (t++ < 4) {
            String recordStr = in.nextLine();
            String[] recordInfo = recordStr.split(" ");
            String car = recordInfo[1];
            if(mounthlyCars.contains(car)){
                continue;
            }
            String[] time = recordInfo[0].split(":");
            boolean isEnter = recordInfo[2].equals("enter");
            Record record = new Record();
            record.hour = Integer.parseInt(time[0]);
            record.minute = Integer.parseInt(time[1]);
            record.isEnter = isEnter;
            List<Record> carRecords = recordMap.getOrDefault(car, new LinkedList<>());
            carRecords.add(record);
            recordMap.put(car, carRecords);
        }
        int ans = 0;
        List<String> keys = new ArrayList<>(recordMap.keySet());
        for(int i = 0; i < keys.size(); i++) {
            List<Record> records = recordMap.get(keys.get(i));
            for(int j = 0; j < records.size(); j+=2) {
                Record a = records.get(j);
                Record b = records.get(j + 1);
                int halfHourCount = calculateHalfHourCount(a, b);
                if(halfHourCount > 15) halfHourCount = 15;
                ans += halfHourCount;
            }
        }
        System.out.println(ans);

    }

    public static int calculateHalfHourCount(Record a, Record b) {//b is later than A
        int hA = a.hour;
        int mA = a.minute;
        int hB = b.hour;
        int mB = b.minute;
        int halfHourCount = 0;
        while(hB > hA || (hB == hA && mB > mA)) {
            mA += 30;
            if(mA > 60) {
                mA -= 60;
                hA ++;
            }
            halfHourCount++;
            if(hA >= 11 && mA > 30) {
                hA += 2;
            }
        }
        return halfHourCount > 1 ? halfHourCount : 0;
    }

    public static class Record {
        int hour;
        int minute;
        boolean isEnter;
    }
}
