class Person(var name: String? = null, var age: Int? = null) {}

// apply
// - 적용하다
// - 객체를 초기화할때 사용하면 좋다
val gildong = Person().apply {
    println(name)
    name = "길동"
    age = 19
}

// also
// - 또한
// - 유효성 검사할 때 좋다
// - 수신된 객체의 속성을 변경하지 않고 사용할 때
val gildong2 = Person("victor").also {
//    isNameisGildong(it.name)
}


// run
// - 중복 사용을 방지 해준다
val gildong3: Person = Person().run {

}
with(gildong3) {

}