fun addTwoNumbers(number1: Int, number2: Int): Int {
    return number1 + number2
}

//고차함수
fun addTenNine(function: (Int, Int) -> Int) {
    val result: Int = function(10, 9)
    println("결과는 $result 입니다")
}

addTenNine(::addTwoNumbers)

// 람다
// 풀버젼 (생략이 없는 버젼)
val addTenNine2: (Int, Int) -> Int = { number1: Int, number2: Int ->
//    val result = number1 + number2
//    result
    number1 + number2
}
addTenNine(addTenNine2) // 람수함수를 인자로 사용하는 경우에는 ::를 사요할 필요가 없다

// 생략버젼 1
val addTenNine3: (Int, Int) -> Int = { number1, number2 ->
    number1 + number2
}
addTenNine(addTenNine3)

// 생략버젼 2
val addTenNine4 = { number1: Int, number2: Int ->
    number1 + number2
}
addTenNine(addTenNine4)

// 너무 간단한 경우
addTenNine { number1, number2 -> number1 + number2 }

// 파라미터가 없는 람다 함수
val addTenNine5: () -> Int = {
    10 + 9
}

// 파라미터가 한개인 경우에는 It을 사용한다
val addTenNine6: (Int) -> Int = {
    10 + 9
}