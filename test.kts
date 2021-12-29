//클래스에 기능을 추가하는 방법


//getter/ setter
class Book() {
    var address: String = "unKnown"
        get() {
            return "ab"
        }
        set(value: String) { //String 생략가능
            field = value // 값 설정하는 방법
        }
}

println(Book().address)

//lateinit
// - var로 선언한 프로퍼티에만 사용할 수 있따
// - 주 생성자에서는 사용할수 없고 class의 탑레벨 프로퍼티에만 사용할 수 있다
// - getter/setter를 적용할 수 없다
// - nullabel 로는 사용할 수 없다
// - 기초 타입 프로퍼티에는 사용할 수 없다
// - 초기화를 하기 전에는 접근 할 수 없다
// - isInitialized로 확인 가능
class Book2 {
    //    lateinit var price : Int -> 기초타입프로퍼티에는 불가능
    lateinit var title: String

    fun tellBookTitle(): String {
        if (::title.isInitialized) {
            return title
        } else {
            return "Unknown"
        }
    }
}
// 더블콜론
// - Reflaction 기능
// - 런타임에 자체 프로그램의 구조를 조사 할 수 있는 언어 및 라이브러리 기능 집합
// - 클래스가 아니라 객체


val book2 = Book2()
println(book2.tellBookTitle())

// lazy
// - 호출시점에 by lazy정의에 의해서 초기화를 진행한다
// - val 에서만 사용이 가능 하다
class Book3 {
    val title: String by lazy {
        println("초기화 진행")
        "초기값"// return을 적으면 안된다 -> 람다식
    }
}

val book3 = Book3()
println(book3.title)

