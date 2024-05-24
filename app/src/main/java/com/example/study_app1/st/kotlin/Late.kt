package com.example.study_app1.st.kotlin

fun main() {
    /**
     * lateinit
     * 값을 변경하기 때문에 var 만 가능
     * java -> String str;
     *  변수 생성하고 값을 아무것도 지정하지 않은 상태
     *  != null
     */
    //변수 선언(값은 미지정) java: String text;
    lateinit var text: String
    val result1 = 30

//    println(text)    //오류 UninitializedPropertyAccessException: lateinit property text has not been initialized

    text = "Result: $result1"
    println(text)

    val result2 = 50
    text = "Result: ${result1 + result2}"
    println(text)


    /**
     * by lazy
     * 현재는 없는 객체에 의존한 값을 미리 선언(생성)
     * 생성자로 {}에서 정의
     *
     * 예제로는 str이 현재는 값이 없지만, str에 의존한 값을 같는다는 생성내용 정의(str의 길이)
     */
    lateinit var str:String
    val strLength: Int by lazy {
        str.length
    }

//    println(strLength)  //오류 UninitializedPropertyAccessException: lateinit property str has not been initialized

    str = "123456"
    println(strLength)
}