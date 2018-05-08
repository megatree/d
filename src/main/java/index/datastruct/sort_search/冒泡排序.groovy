package index.datastruct.sort_search

import index.basicAlgo.Sorts

/**
 * Created by wangzhe.bj on 2018-05-08.
 *
 * 冒泡排序是一种交换排序，
 * 两两比较相邻的关键字，如果反序则交换，知道没有反序的记录为止，
 * 优化后的冒泡排序，最好情况下仅需要n-1次比较，O（n）。最坏情况下，需要n(n-1)/2次比较。
 *
 * 平均复杂度 O（n2）
 * aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3UwMTQwOTk4OTQvYXJ0aWNsZS9kZXRhaWxzLzcyNjM4MDEz
 */

/**
 * 交换排序，比较的并非相邻元素
 * @param array
 * @return
 */
def simpleSwapSort(int[] array) {
    if (array == null || array.length == 0 || array.length == 1) return

    for (int i = 0; i < array.length; ++i) {
        for (int j = i + 1; j < array.length; ++j) {

            println "当前 i=${i} j=${j}"
            if (array[j] < array[i]) {
                println "交换 array[$i]=${array[i]} array[$j]=${array[j]}"
                Sorts.swap(array, i, j)
            }
        }
    }
}

/**
 * 正宗冒泡排序
 * @param array
 * @return
 */
def bubbleSort(int[] array) {
    if (array == null || array.length == 0 || array.length == 1) return

    for (int i = 1; i < array.length; ++i) {
        for (int j = array.length - 1; j >= i; --j) {
            println "当前 i=${i} j=${j}"

            if (array[j] < array[j - 1]) {
                println "交换 array[$j]=${array[j]} array[$j-1]=${array[j-1]}"
                Sorts.swap(array, j, j - 1)
                println "状态 $array"
            }
        }
    }

    println array
}


int[] arr = [1, 6, 2, 4, 3]

//simpleSwapSort(arr)
bubbleSort(arr)
