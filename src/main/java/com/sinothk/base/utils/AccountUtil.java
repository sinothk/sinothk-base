package com.sinothk.base.utils;

import java.util.*;

public class AccountUtil {

    private static Set<Long> accountSet = new HashSet<>();

    public static void main(String[] args) {

        AccountUtil.init(null);

        System.out.println("产出Id = " + AccountUtil.create());
    }

    public static long create() {

        List<Long> list = new ArrayList<>(accountSet);
        Collections.sort(list);

        long newId = list.get(list.size() - 1) + 1;
        accountSet.add(newId);

        return newId;
    }

    public static void init(Set<Long> initSet) {
        if (initSet == null || initSet.size() == 0) {
            initSet = new HashSet<>();
            initSet.add(10000L);
        }

        accountSet.clear();
        accountSet.addAll(initSet);
    }
}
