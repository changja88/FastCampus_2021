class Person(var name: String? = null, var age: Int? = null) {}
// apply
// - 적용하다
// - 객체를 초기화할때 사용하면 좋다
val gildong = Person().apply {
    name = "길동"
    age = 20
}
// also
// 유효성 검사 할 때 좋다
// 수신된 객체의 속성을 변경하지 않고 사용할 때
val gildong2 = Person("victor").also {
//    nameIsGildong(it.name)
}

// run
// - 기본적으로 apply 동일하다
// - 스코프의 마지막줄을 리턴한다 -> 특정 계산 결과가 필요한 경우
val ageAfter10year = Person("gildong", 10).run {
    age!! + 10
}
val gildong4: Person = Person("gildong", 10)
val ageAfter10year2 = with(gildong4) {
    age!! + 10
}
// - with는 nullable 타입을 받지 못한다
println(ageAfter10year2)

//let
// - 기본적으로 also와 동일하다
// - 스코프의 마지막줄을 리턴한다
val gildong5 = Person("victor").let {

}