package ru.job4j.lambda;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles2 {

    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(profile -> profile.getAddress()).sorted(Comparator.comparing(o -> o.getCity())).distinct().collect(Collectors.toList());
    }
}
