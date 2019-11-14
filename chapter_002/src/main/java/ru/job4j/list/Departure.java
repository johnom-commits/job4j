package ru.job4j.list;

import java.util.*;

public class Departure {

    public void abs(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public void desc(List<String> orgs) {
        orgs.sort(Comparator.reverseOrder());
        String flag = "";
        List<String> clone = new ArrayList<>(orgs);
        orgs.clear();
        List<String> group = new ArrayList<>();
        for (String o : clone) {
            String k = o.substring(0, 2);
            if (!flag.equals(k)) {
                flag = k;
                if (group.size() > 0) {
                    sort(group, orgs);
                }
                group.clear();
            }
            group.add(o);
        }
        sort(group, orgs);
    }

    private void sort(List<String> group, List<String> orgs) {
        group.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        orgs.addAll(group);
    }

    public void fillGaps(List<String> orgs) {
        final int UNICODE_POINT_CODE = 47;
        int i;
        String depart;
        List<String> addList = new ArrayList<>();
        for (String org : orgs) {
            i = org.lastIndexOf(UNICODE_POINT_CODE);
            if (i == -1) {
                continue;
            }
            depart = org.substring(0, i);
            if (!orgs.contains(depart) && !addList.contains(depart)) {
                addList.add(depart);
            }
        }
        orgs.addAll(addList);
    }
}