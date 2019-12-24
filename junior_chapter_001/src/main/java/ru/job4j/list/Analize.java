package ru.job4j.list;

import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toMap;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        int added = 0;
        int changed = 0;
        Map<Integer, String> map = previous.stream().collect(toMap(e -> e.id, e -> e.name));
        for (var user : current) {
            int id = user.id;
            if (!map.containsKey(id)) {
                added++;
                continue;
            }
            String name = map.get(id);
            if (!name.equals(user.name)) {
                changed++;
            }
            map.remove(id);
        }
        int deleted = map.size();

        Info info = new Info(added, changed, deleted);
        return info;
    }

    public static class User {
        int id;
        String name;

        public User(int aId, String aName) {
            id = aId;
            name = aName;
            }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }
    }
}
