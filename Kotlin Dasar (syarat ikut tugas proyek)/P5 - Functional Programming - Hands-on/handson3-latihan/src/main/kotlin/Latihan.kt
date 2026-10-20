// Hands-on 3: Closure — Counter Factory

fun makeCounter(): () -> Int {
   // TODO 1: Deklarasikan count mulai dari 0
    var count: Int = 0

    // TODO 2: Kembalikan lambda yang menambah count
    return {
        count++
        count
    }
}

fun main() {
    val counterA = makeCounter()
    val counterB = makeCounter()

    println(counterA()) // 1
    println(counterA()) // 2
    println(counterA()) // 3

    println(counterB()) // 1 (counterB independen dari counterA)
    println(counterB()) // 2
}
