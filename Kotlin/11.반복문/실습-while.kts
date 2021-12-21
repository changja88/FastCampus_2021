// While문 실습
var i = 0
while(i <5){ // 1)->i=0, 2)->i=10
    println(i)
    if(i%2 == 0){
        println("짝수")
    }else{
        println("홀수")
    }
    i++ // 이부분을 제거하면 무한루프에 빠진다(루프(loop) : 반복)
}

var z = 10
do{
    println("시작")
}while(z >20)








