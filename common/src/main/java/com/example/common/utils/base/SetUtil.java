package com.example.common.utils.base;

import java.util.*;

/**
 * @ ClassName  ：SetUtil
 * @ Description：TODO
 * @ Author     ：yuqin
 * @ createTime : 2018-12-22
 */
public class SetUtil {

    public static void main(String[] args) {
        System.out.println("-6>>>1:"+(6>>>1));

        Long[] arr1 = new Long[]{12L};
        Long[] arr2 = new Long[]{6L,9L,21L};

        System.out.println("----------并集------------");
        Long[] andArr = getAndArr(arr1, arr2);
        for (Long a : andArr) {
            System.out.println("=>"+a);
        }
        System.out.println("----------交集------------");
        Long[] intersectArr = getIntersect(arr1, arr2);
        for (Long a : intersectArr) {
            System.out.println("=>"+a);
        }
        System.out.println("----------差集(相对补集, 绝对补集)------------");
        Long[] subtractionArr = getSubtraction(arr1, arr2);
        for (Long a : subtractionArr) {
            System.out.println("=>"+a);
        }
    }

    /**
     * 求差集(相对补集, 绝对补集)
     * minuendArr - subArr
     **/
    public static Long[] getSubtraction(Long[] subArr, Long[] minuendArr) {
        LinkedList<Long> list = new LinkedList<>();
        Set<Long> set = new HashSet<>(Arrays.asList(subArr));
        for (Long b : minuendArr) {
            if (set.contains(b)) {
                list.remove(b);
            } else {
                list.add(b);
            }
        }
        Long[] result = {};
        return list.toArray(result);
    }

    /**
     * 求交集
     **/
    public static Long[] getIntersect(Long[] arr1, Long[] arr2) {
        List<Long> rs = new ArrayList<>();
        Long[] longArr;
        Long[] shortArr;
        int n1 = arr1.length;
        int n2 = arr2.length;
        if (n1 < n2) {
            longArr = arr2;
            shortArr = arr1;
        } else {
            longArr = arr1;
            shortArr = arr2;
        }
        // 将较长的数组转为set
        Set<Long> set = new HashSet<>(Arrays.asList(longArr));

        // 遍历较短的数组
        for (Long a : shortArr) {
            if (!set.contains(a)) {
                continue;
            } else {
                rs.add(a);
            }
        }
//        rs.removeAll(Collections.singleton(null));// 去除List 的null
        Long[] resType = {};
        return rs.toArray(resType);
    }

    /**
     * 求并集
     **/
    private static Long[] getAndArr(Long[] arr1, Long[] arr2) {
        // 将数组转换为set集合
        Set<Long> set1 = new HashSet<>(Arrays.asList(arr1));
        Set<Long> set2 = new HashSet<>(Arrays.asList(arr2));
        // 合并两个集合
        set1.addAll(set2);
        Long[] arr = {};
        return set1.toArray(arr);
    }
}