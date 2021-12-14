// 산술연산자
val number1: Int = 1 + 10
val number2: Int = 2 - 10
val number3: Int = 2 * 40
val number4: Int = 40 / 2
val number5: Int = 45 % 7
println(number5)
val number6 = 10 * 427 % 73 + 108 // 할당하려는 값의 타입을 알기 어려운 경우에는 코틀린에게 맡겨도된다

// 대입연산자
var number7: Int = 22
println(number7)
number7 = 100
println(number7)

// 복합대입연산자
// A+=B -> A = A + B
var number8: Int = 12
number8 += 8
number8 -= 10
number8 *= 2
number8 /= 5
println(number8)

// 증감연산자 (++, --)
// ++,-- -> 1씩 더하가나 1씩 뺀다
var number9: Int = 10
println(number9++) // 10
println(number9) // 11

println(++number9) // 11

// 비교연산자
val number10: Int = 2
val number11: Int = 2
val result: Boolean = number10 > number11
println(result)
val result2: Boolean = number10 == number11
println(result2)
val result3: Boolean = number10 != number11
println(result3)
// ===, !== -> 잘사용하지 않는다
//  - 주소값이 같은지 물어보는 연산자
// ==, !=
//  - 값이 같은지 물어보는 연산

// 논리연사자
val boolean1: Boolean = false
val boolean2: Boolean = false
val result4: Boolean = boolean1 && boolean2
val result5: Boolean = boolean1 || boolean2
println(result5)
