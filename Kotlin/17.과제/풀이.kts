class Calculator {
    var result: Int = 0
        set(value) {
            field = value
            println("중간 계산 값 : " + field)
        }

    fun sum(inputNumber: Int) {
        result += inputNumber
    }

    fun minus(inputNumber: Int) {
        result -= inputNumber
    }

    fun multiply(inputNumber: Int) {
        result *= inputNumber
    }

    fun devide(inputNumber: Int) {
        result /= inputNumber
    }
}

//val calculator1 = Calculator()
//calculator1.sum(10)
//calculator1.devide(2)
//calculator1.multiply(3)

class Calculater2 constructor(val initialValue: Int = 0) {
    var result: Int

    init {
        this.result = initialValue
    }

    fun calculate(function: Char, inputNumber: Int) {
        when (function) {
            '+' -> this.result += inputNumber
            '-' -> this.result -= inputNumber
            '*' -> this.result *= inputNumber
            '/' -> this.result /= inputNumber
            else -> println("잘못된 연산 입니다")
        }
    }
}

//val calculater2 = Calculater2(10)
//calculater2.calculate('+', 10)
//calculater2.calculate('/', 20)
//calculater2.calculate('-', 100)
//println(calculater2.result)


class Calculater3 {
    var result: Int = 0

    fun calcualte(operaters: List<Char>, inputNumbers: List<Int>) {
        operaters.forEachIndexed { index, operater ->
            this._calculate(operater, inputNumbers[index])
        }
    }


    fun _calculate(function: Char, inputNumber: Int) {
        when (function) {
            '+' -> this.result += inputNumber
            '-' -> this.result -= inputNumber
            '*' -> this.result *= inputNumber
            '/' -> this.result /= inputNumber
            else -> println("잘못된 연산 입니다")
        }
    }
}

val calculater3 = Calculater3()
calculater3.calcualte(listOf<Char>('+', '-'), listOf<Int>(10, 20))
println(calculater3.result)


//['+', '-', '*'], [10, 20, 30]

//[('+', 50) ('-', 60)]
//[(Any, Any) (Any, Any)] - > 실제
//[(Char, Int) (Char, Int)] -> 기대
// Any -> Char, Int 으로 변환
