// 상속을 사용하기 전
class Warrior() {
    fun attack() {
        println("복잡한 코드 + 공격")
    }
}

class DefenseWarrior() {
    fun attack() {
        println("복잡한 코드 + 공격")
    }

    fun defense() {
        println("방어")
    }
}

class HardAttackWarrior() {
    fun attack() {
        println("복잡한 코드 + 공격")
    }

    fun hardAttack() {
        println("강하게 공격")
    }
}

// 상속을 사용
open class Warrior1(var name: String, var power: Int, var type: String) { //부모클래스, 슈퍼클래스
    fun attack() {
        println("복잡한 코드 + 공격")
    }
}

//주 생성자가 슈퍼클래스 생성을 하는 경우
class DefenseWarrior1 constructor(name: String, power: Int) : Warrior1(name, power, "고블린") {
    fun defense() {
        println("방어")
    }
}

//주 생성자가 없는 경우
class HardAttackWarrior1 : Warrior1 {
    var bonusePower: Int = 0

    constructor(name: String, power: Int, bonusPower: Int) : super(name, power, "골렘") {
        this.bonusePower = bonusePower
    }

    fun hardAttack() {
        println("강하게 공격")
    }
}

val defenseWarrior: DefenseWarrior1 = DefenseWarrior1("똑똑한 고블린", 100)
defenseWarrior.defense()
defenseWarrior.attack()

val hardAttackWarrior: HardAttackWarrior1 = HardAttackWarrior1("멍청한 골렘", 100, 20)
hardAttackWarrior.attack()
hardAttackWarrior.hardAttack()