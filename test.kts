//생성자
//-주생성자(Prminary Constructor)
//-클래스 이름 옆에 괄호로 둘러싸인 코드
//        -파라미터를 지저하고 그 새성자 파라미터에 의해 초기화 되는 프로퍼티를 정의한다
//        -주생성자 하나와 복수개의 부생성자 가능
//-부생성자(Secondary Constructor)
//-주 생성자는 constructor 키워드를 생략할 수 있지만, 부생성자는 불가능 하다
//-주생성자가 존재한다면 부생성자는 무조건 주 생성자에서 직간접적으로 생성을 위임해야 한다
//        -만약 주생성자나 부생성자를 구현하지 않을 경우에는 코틀린이 자동으로 인자가 없는 생성자를 자동으로 생성해줍니다.
//
//-init블록
//-코틀린에서 주 생성자에는 어떠한 코드도 추가될 수 없다
//        -따라서 초기화 시에 필요한 작업은 init블록에서 해야 한다
//        -객체가 만들어질 때 실행될 초기화 코드가 들어 간다

// 클래스를 선언 하는 방법
class Person1 {

}

// 클래스 주 생성자를 샐성하는 방법 1 -> 풀
class User1 constructor(_nickname: String) {
    val nickname: String

    init {
        nickname = _nickname
    }
}
println(User1("1").nickname)

// 클래스 주 생성자를 샐성하는 방법 2 -> init 생략
class User2 constructor(_nickname: String) {
    val nickname = _nickname
}
println(User2("1").nickname)

// 클래스 주 생성자를 샐성하는 방법 3 -> 전부다 생략
class User3 constructor(val nicekname: String) {}
println(User3("1").nicekname)

// 클래스 주 생성자 + 기본값
class User4 constructor(val nickname: String = "1") {}
println(User4().nickname)

// constructor 키워드 생략

// 부 생성자
//  - 주생성자가 없어서 주생성자 처럼 보이지만 부생성자가 맞다
//  - 주생성자가 없기때문에 this()생성자를 이용해 직간접으로 생성을 위임할 필요가 없을
class User5 {
    val age: Int
    val name: String

    constructor(age: Int, name: String) {
        this.age = age
        this.name = name
    }
}
println(User5(1, "1").age)

// 주생성자에게 생성을 위임하는 방법
class User6(val age: Int) {
    var name: String = ""

    // this(age)를 하지 않으면 에러 발생
    constructor(age: Int, name: String) : this(age) {
        this.name = name
    }
}
//println(User6(1, "1").age)

// init과 실행 순서
//그리고 primary constructor는 secondary constructor의 첫 번째 실행문으로 실행됩니다.
//따라서 init 블럭의 코드는 항상 secondary constructor의 body보다 먼저 실행됩니다.

class User7(val age: Int) {
    var name: String = ""

    init {
        name = "init"
    }

    constructor(age: Int, name: String) : this(age) {
        this.name = name
    }
}
println(User7(20, "name").name)