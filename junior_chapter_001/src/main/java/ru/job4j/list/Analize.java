package ru.job4j.list;

import java.util.List;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        int deleted = 0;
        int added = 0;
        int changed = 0;
        int diffLength = previous.size() - current.size();
        if (diffLength > 0) {
            deleted = diffLength;
        } else if (diffLength < 0) {
            added = -diffLength;
        }
        for (User u : previous) {
            User user = findUser(u.id, current);
            if (user != null && !user.name.equals(u.name)) {
                changed++;
            }
        }

        Info info = new Info(added, changed, deleted);
        return info;
    }

    private User findUser(int id, List<User> list) {
        User user = null;
        for (User u : list) {
            if (u.id == id) {
                user = u;
                break;
            }
        }
        return user;
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
