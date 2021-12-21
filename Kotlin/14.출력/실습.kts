//1. 문자열을 직접 전달하는 방법
println("안녕하세요")

//2. 변수를 출력하는 방법
val name = "이름"
val myName = "홍길동"
println("내 $name 은 $myName 입니다")

val number1 = 10
val number2 = 100
println("$number1 더하기 $number2 는 ${number1 + number2}")

// 특수문자 출력하는 방법
println("\$myName") // /를 사용하는 방법
println("${"myName"}") // ${}를 사용하는 방법

println("" + number1 + "더하기" + number2 + "는" + "${number1 + number2}")
// 문자열 + 다른 타입 -> 문자열
println("안녕하세요" + 10)
// 다른 타입 + 문자열 -> 에러
println(10 + "안녕하세요")
