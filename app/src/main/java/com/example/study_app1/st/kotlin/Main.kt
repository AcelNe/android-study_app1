package com.example.study_app1.st.kotlin

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

    ll = ii.toLong()
}