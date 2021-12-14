// 변수를 자료형과 함께 선언하는 방법
// -> val/var 변수명 : 타입 = 값
val byteInt: Byte = 10
val shortInt: Short = 10
val integertInt: Int = 10
val longInt: Long = 10

//val wrongByte: Byte = 10000 -> Byte가 표현할 수 있는 수범위 보다 큰 수를 넣은 경우 에러발생
//val wrongByte : Byte = "안녕하세요" -> 타입 미스매치 에러 발생

val floatNumber: Float = 10.0f // Flot의 경우에는 할당하려는 값 뒤에 f를 붙여줘야 한다
val doubleNumber: Double = 10.0 // Double의 경우에는 할당하려는 값 뒤에 아무 것도 붙이지 않아도 된다
//val doubleNumber1 : Double = 10 // 10과 10.0은 같지만 .을 찍어서 실수형이라는 것을 표현해야한다


// 타입추론
val number1 = 10 // Int
val number2 = 10.0 // Double

// 논리형
val yes: Boolean = true
val no: Boolean = false

// 문자형
val text1: Char = 'A'
//val text2 : Char = 'AA' -> Char형은 문자가 반드시 하나만 들어가야 한다
//val text3 : Char = "A" -> 타입 미스매치 에러 발생

// 문자열형
val text4: String = "안녕하세요"
val text5: String = "A"

// 팁
// - 타입을 선택할때는 가장 작은 타입을 선택하는 것이 좋다
//  - 실제로는 대부분 그냥 Int, Float 사용합니다

// 변수명
//val true : Int = 10 -> 코틀린에서 선점해서 사용하고 있는 키워드는 변수명으로 사용할수 없다
