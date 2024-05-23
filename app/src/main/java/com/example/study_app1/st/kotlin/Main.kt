package com.example.study_app1.st.kotlin

import java.util.Scanner
import kotlin.math.max
import kotlin.random.Random

//class 상수
const val str:String ="Final String"    //const 붙으면 compile 상수 main 보다 우선 생성
fun main() {
    println("Hello world")

    //변수
    var i =10
    var name = "name"
    var point = 3.3 //자료형 추론하는 기능이 있어서 자료형 명시 필수X
    var a:Int = 20  //자료형은 모두 대문자
    var f:Float = 4.4F

    //상수(final)
    val num = 20
//    num = 30 //불가능

    //형변환
    var ii = 10
    var ll = 20L

    ll = ii.toLong()    //형변환 Int->Long
    ii = ll.toInt()     //형변환 Long->Int
    var strr = "10"
    ii = strr.toInt()   //형변환 String->Int   문자(a)를 변환하면 NuberFormatException 나온다
    println("ii: "+ii)
    println("ii + 3: "+(ii+3))
    
    var strName = "hello"
    println(strName.uppercase())    //java: toUppercase() -> uppercase()
    println(strName[2])     //l
    println("변수 strName: $strName") //변수 strName: hello -> 반드시 변수 뒤에 공백이 있어야 한다
    println("변수 strName: ${strName}으로 사용 가능")   //변수 strName: hello으로 사용 가능 ->변수 뒤에 공백 없이 사용 가능

    //math
    var ma = 10
    var mj = 20
    print(max(ma, mj))

    val randomNumber = Random.nextInt()
    println(randomNumber)
    val randomNumberLimit = Random.nextInt(0,100)   //0-99 앞은 포함, 뒤는 미포함
    println(randomNumberLimit)
/*

    //scanner
    var reader = Scanner(System.`in`)   //kotlin에서 in은 사용할 수 없기 때문에 `로 사용
    var readerInt = reader.nextInt()
    var readerStr = reader.next()
    println("int: $readerInt // str: $readerStr")
*/

    //조건문
    var ifi = 5
    if(ifi > 10) {
        println("10보다 크다")
    } else if(ifi > 5) {
        println("5보다 크다")
    } else {
        println("5보다 크지 않다")
    }

    var returnStr = when {
        ifi > 10 -> {
            "10보다 크다"
        }
        ifi > 5 -> {
            "5보다 크다"
        }
        else -> {
            "5보다 크지 않다"
        }
    }
    println(returnStr)

    //3항연산
    //boolean thrRst = ii>10?ture:false
    val thrRst = if(ifi>10) true else false

    //반복문
    val loofList = listOf(1,2,3,4,5)

    for(item in loofList) {
        println(item)
    }
    loofList.forEach { item ->
        println(item)
    }

    //for(int i=0; i<loofList.length; i++)
    for(i in 0..loofList.size-1) {
        println(i)
        println(loofList[i])
    }

    //list
    val finalItems = listOf(1,2,3,4,5)   //고정
    val items: MutableList<Int> = mutableListOf(1,2,3,4,5)    //유동 java:arrayList 형(MutableList<Int>) 생략가능

    items.add(6)
    items.remove(2)
    println(items)

    //Array 배열
    val arr = arrayOf(1,2,3)
    arr[2] = 4
    println(arr.size)

    //exception 예외처리
    try {
        var item = items[8]
    } catch(e:Exception) {
        println(e.message)
    }

    //nullSafety null 관리
    var nullName:String? = null // null 형을 지정 + null 사용 가능하다는 ?를 붙여서 표시
    nullName = "nullableName"
    nullName = null //?가 있어서 null이 가능

    //var name2:String = null   //?없이는 null 불가(형을 안쓰면 null 가능은 하지만 사용X)
    nullName = name!!   //null 절대 아니라는 의미(개발자 보증..->compile 검사 넘기기)

    val name2:String = "asdf"
    name2?.let{  //nullName이 null이 아니라면 진행, 내부에서는 it으로 접근 가능
        println(it)
        println(name2)
    }

    //call function
    println("sum 10,33: ${sum(10,33)}")
    println("sum2 3,6: ${sum2(3,6)}")

    //default 지정
    println("sum3 22,5: ${sum3(22,5)}")
    println("sum3 c=3, a=2, b=5: ${sum3(c = 3, a = 2, b = 5)}")


    //class
    val lee = Person("Lee",30)
    print(lee.name)
    println(lee.age)
    lee.age = 32
    println("lee age: ${lee.age}")

    val lee2 = Person("Lee",32)
    println(lee == lee2)    //false(class) -> true(data class)

    val kim = Person2("Kim",14)
    kim.some()
    //kim.hobby = "숨쉬기" //private set 설정으로 수정 불가
    println(kim.hobby)


    //상속 extends interface
    val dog:Animal = Dog()
    val cat = Cat()

    //cat as Dog    //강제 형 변환
    if(dog is Dog) {    //형 확확인
        dog.draw()
        println("강아지")
    }

    //generic
    val box = Box<Int>(10)  //->Box(10) 형(generic) 생략하면 자료형 추론
    val box2 = Box2("asdf")
    println(box.value)
    //println(box2.value)   //class 생성시 속성으로 선언하지 않아서 외부에서 사용 불가


    //callBack
    myFunc ({ println("함수 호출") })
//    susFunc(3){println("susFunc callback func run()")}    //suspend 함수는 suspend에서만 사용 가능
}

//function 함수
fun sum(a:Int, b:Int):Int{  //매개변수 Int a, Int b 받아서 Int 반환 ->java: int sum(int a, int b){}
    return a+b
}

fun sum2(a: Int, b: Int) = a+b

//fun sum3(a:Int, b:Int) = a+b
//fun sum3(a:Int, b:Int, c:Int) = a+b+c   //overload 동일한 함수명 사용(매개변수 차이) ->java
fun sum3(a:Int, b:Int, c:Int = 0) = a+b+c   //overload 불필요 c는 없으면 0으로 처리(default 존재)


//class 객체
//class Person { ->java
//  String name;
//  int age;
//}
//data class
data class Person(val name: String, var age: Int)    //중괄호 생략가능, 기본 : public(getter 제공), privet(getter 미제공)->속성취급, val은 final이어서 수정 불가(setter 불가)

class Person2(
    val name: String,
    var age: Int
) {
    var hobby = "운동"
        private set     //외부에서 setter 사용 불가(속성 수정 불가)
        get() = "취미: $field"    //getter
    init {
        println("init fun run")
    }

    fun some() {
        println("${name}의 취미는 ${hobby}입니다.")
    }
}


//extends
abstract class Animal {
    open fun move() {   //override 하기 위한 open
        println()
    }
}
class Dog: Animal(), Drawable {
    override fun move(){
        println("우다다다")
    }

    override fun draw() {
        TODO("Not yet implemented")
    }
}
class Cat:Animal() {
    override fun move() {   //override 방법
        println("슈웅")
    }
}

open class Person3  //상속을 위해서 open
class SuperMan:Person3()    //open class 만 가능


//interface
interface Drawable {
    fun draw()
}


//generic
class Box<T>(var value:T)
class Box2<T>(value:T)


//callBack
fun myFunc(callBack:()->Unit) {
    println("myFunc start() ")
    callBack()
    println("myFunc end()")
}

suspend fun susFunc(a:Int, callBack: () -> Unit={}){
    println("susFunc start() \na: $a")
    callBack()
    println("susFunc end()")
}