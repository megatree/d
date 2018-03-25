package index.groovy

/**
 * https://blog.csdn.net/u011054333/article/details/60331204
 *
 */


trait Readable {
    void read() {
        println("read...")
    }
}

trait Writable {
    void write(String text) {
        println("write $text")
    }
}

class Notebook implements Readable, Writable {
    static void main(String[] args) {
        //使用特性类
        def notebook = new Notebook()
        notebook.read()
        notebook.write("something")
    }
}

def (a,b,c) = [1,'b',null]

Integer x = "1"
String y = x as int


def list1 = ['Groovy 1.8','Groovy 2.0','Groovy 2.3']
def list2 = ['Groovy 1.8','Groovy 2.0','Groovy 2.3']


def cp = '123'as int <=> '12' as int

def arr = (1..<9).collect()
def bool = null in arr

def users = [new User("1"), new User("1"), new User(null)]
def uarr = users*.@name.findAll { it != null }


def classTest() {
    def user = new User("hello")
    println user.name
    println user.@name
}

class User {

    public final String name

    User(String name) {
        this.name = name
    }

    String getName() {
        "name-> $name"
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        User user = (User) o

        if (name != user.name) return false

        return true
    }

    int hashCode() {
        return (name != null ? name.hashCode() : 0)
    }
}


def findd() {
    def map = [k: 1, l: 2]
    def o = map.find { it.getKey() == 'l' }
    def p = map.find { it.getValue().toString().equals("hehe") }

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

