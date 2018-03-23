package index.groovy

/**
 * https://blog.csdn.net/u011054333/article/details/60331204
 *
 */

findd()

def findd() {
    def map = [k: 1, l: 2]
    def o = map.find { it.getKey() == 'l' }
    println o

    map << [j: 3]
    println map
}

def name
def nullName = name ?: "123"

def math() {
    int a = 4
    int b = a**a
    println b
}

def map() {
    def map = [key1: 1, key2: 2] as LinkedHashMap
    println map
}

def arr3() {
    def arr = 'a'..'z' as char[]
    arr = arr.join(',')
    println arr
}

def arr2() {
    def array = 1..10 as int[]
    println array
}

def arr() {
    def array = ['a', 'b', 'c']
    println array

    array << ['A', 'B']
    println array

    println array[1]
}

def sayHello() {
    def hello = 4
    def arr = [1, 2, "$hello"] as LinkedList
}

