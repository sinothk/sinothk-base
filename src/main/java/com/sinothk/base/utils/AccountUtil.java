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

    /**
     * 初始化：查询现有账号，在现有数据基础上继续加1
     *
     * @param initSet
     */
    public static void init(Set<Long> initSet) {
        accountSet.clear();
        accountSet.addAll(initSet);
    }

    /**
     * 创建账号
     *
     * @param keepAccountSet 系统预留账号集合
     * @return
     */
    public static long create(Set<Long> keepAccountSet) {
        List<Long> list = new ArrayList<>(accountSet);
        Collections.sort(list);

        if (list.size() == 0) {
            list.add(10000L);
        }

        // 现有账号 +1
        long newId = list.get(list.size() - 1) + 1;

        // 如果新账号为系统预留账号，则继续 +1
        while (keepAccountSet.contains(newId)) {
            newId += 1;
        }


        accountSet.add(newId);
        return newId;
    }


}
