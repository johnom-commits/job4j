package ru.job4j.list;

import java.util.*;

public class MergeUsers {

    public static List<User> merge(List<User> users) {
        Map<String, Node> map = new HashMap<>();
        Map<User, Node> userNodeMap = new HashMap<>();

        for (User user : users) {
            for (String email : user.getEmail()) {
                if (map.containsKey(email)) {

                    Node node = map.get(email);
                    User oldUser = node.getUser();
                    userNodeMap.remove(oldUser);

                    node.changeUser(user);
                    node.email.addAll(user.getEmail());

                    userNodeMap.put(user, node);
                } else {
                    Node node = userNodeMap.get(user);
                    if (node == null) {
                        node = new Node(user);
                        node.email.addAll(user.getEmail());
                        userNodeMap.put(user, node);
                    }
                    map.put(email, node);
                }
            }
        }
        List<User> list = new ArrayList<>();
        for (var entry : userNodeMap.entrySet()) {
            User user = entry.getKey();
            Node node = entry.getValue();
            user.clearEmail();
            node.email.stream().forEach(x -> user.addEmail(x));
            list.add(user);
        }
        return list;
    }

    private static class Node {
        User user;
        Set<String> email = new HashSet<>();

        public Node(User user) {
            this.user = user;
        }

        public User getUser() {
            return user;
        }

        public void changeUser(User user) {
            this.user = user;
        }
    }
}
