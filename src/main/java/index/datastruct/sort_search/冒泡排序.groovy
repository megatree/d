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
 * 1、从前往后扫，大数交换到后面去
 * 2、从后往前扫，小数交换到前面去
 * @param array
 * @return
 */
def bubbleSort(int[] array) {
    if (array == null || array.length == 0 || array.length == 1) return

    for (int i = 1; i < array.length; ++i) {
        for (int j = array.length - 1; j >= i; --j) {
            println "当前 i=${i} j=${j}"

            if (array[j] < array[j - 1]) {
                println "交换 array[$j]=${array[j]} array[$j-1]=${array[j - 1]}"
                Sorts.swap(array, j, j - 1)
                println "状态 $array"
            }
        }
    }

    println array
}

/**
 * 大数交换到后面，外层内缩
 * @param array
 * @return
 */
def bubbleSort2(int[] array) {
    if (array == null || array.length == 0 || array.length == 1) return

    for (int i = array.length - 1; i >= 1; i--) {
        for (int j = 0; j < i; j++) {
            if (array[j] > array[j + 1]) {
                Sorts.swap(array, j, j + 1)
            }
        }
    }
    println array
}

/**
 * 优化过的冒泡排序
 * 当一轮扫描时发现已经为有序，则不进行后续交换
 * @param array
 * @return
 */
def bubbleSortBetter(int[] array) {
    if (array == null || array.length == 0 || array.length == 1) return

    boolean  isSorted = false
    for (int i = array.length - 1; i >= 1 && !isSorted; i--) {

        isSorted = true //假定有序
        for (int j = 0; j < i; j++) {
            if (array[j] > array[j + 1]) {
                Sorts.swap(array, j, j + 1)
                isSorted = false  //需要交换，未排好序
            }
        }

        println "数组$array i=$i ${isSorted?'有序':'无序'}"
    }
    println array
}

int[] arr = [1, 6, 2, 4, 3]
int[] arr2 = [1,2,3,4,5]
println "原始数组 $arr"
//simpleSwapSort(arr)
//bubbleSort(arr)
//bubbleSort2(arr)
bubbleSortBetter(arr2)