// ?
val number: Int = 10 // Non-Nullalbe Int
val number: Int? = null // Nullable Int

// !!
val nullableNumberList: List<Int?> = listOf<Int?>(1, 2, 3, null, null)
var result: Int = 0
nullableNumberList.forEach {
//    result += it!!
}
// -> 정말 필요한 경우에만 사용을 해야한다

// ?. (safe call)
val text: String? = null
println(text?.length)
//println(text.length) // -> NullPointException이 발생 해야함

// !!.
//println(text!!.length) // -> NullPointException이 발생 해야함

// as?
open class Warrior1(var name: String, var power: Int, var type: String) { //부모클래스, 슈퍼클래스
    fun attack() {
        println("복잡한 코드 + 공격")
    }
}

//주 생성자가 슈퍼클래스 생성을 하는 경우
class DefenseWarrior1 constructor(name: String, power: Int) {
    fun defense() {
        println("방어")
    }
}

val defenseWarrior = DefenseWarrior1("", 100)
val warrior = defenseWarrior as? Warrior1
println(warrior)

// ?: 엘비스 연산
val text2: String? = "123"
val nullText: String? = null

var len1: Int = if (text2 != null) text2.length else 0
var len2: Int = text2?.length ?: 0