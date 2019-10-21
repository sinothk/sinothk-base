package com.sinothk.base.utils;

import java.util.*;

public class AccountUtil {

    private static Set<Long> accountSet = new HashSet<>();

//    public static void main(String[] args) {
//
//        Set<Long> initSet = new HashSet<>();
//        initSet.add(55555L);
//        AccountUtil.init(initSet);
//
//        System.out.println("产出Id = " + AccountUtil.create());
//
//        Set<Long> newSet = AccountUtil.getAccountSet();
//        System.out.println("Id Size = " + newSet.size());
//    }

    public static Set<Long> getAccountSet() {
        return accountSet;
    }

    public static long create() {
        List<Long> list = new ArrayList<>(accountSet);
        Collections.sort(list);

        long newId = list.get(list.size() - 1) + 1;

        Set<Long> set = getInitAccountSet();//new TreeSet<>();

        while (!set.contains(newId)) {
            newId += 1;
        }

        accountSet.add(newId);

        return newId;
    }

    public static void init(Set<Long> initSet) {
        accountSet.clear();
//        if (initSet == null || initSet.size() == 0) {
//            initSet = new HashSet<>();
//            initSet.add(10000L);
//        }
        accountSet.addAll(initSet);
    }

    private static Set<Long> getInitAccountSet() {
        Set<Long> set = new HashSet<>();
        set.add(99999L);
        set.add(100000L);
        set.add(88888888L);
        return set;
    }
}
