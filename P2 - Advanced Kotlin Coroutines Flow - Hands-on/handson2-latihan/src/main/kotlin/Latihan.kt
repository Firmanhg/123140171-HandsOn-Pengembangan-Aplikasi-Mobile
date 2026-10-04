import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.random.Random

// Hands-on 2: Flow dengan Operators
// Tugas: Buat Flow yang mensimulasikan sensor suhu, filter suhu di atas 30°C,
// dan tampilkan warning dengan format yang bagus.

fun temperatureSensor(): Flow<Int> = flow {
    repeat(10) {
        delay(500)

        val temp = Random.nextInt(20, 40) // Random 20-39°C

        emit(temp)
    }
}

fun main() = runBlocking {

    temperatureSensor()
        // 1. Hanya mengambil suhu di atas 30°C
        .filter { temperature ->
            temperature > 30
        }

        // 2. Mengubah nilai suhu menjadi pesan warning
        .map { temperature ->
            "WARNING: Suhu tinggi terdeteksi: ${temperature}°C"
        }

        // 3. Menampilkan setiap warning
        .collect { warning ->
            println(warning)
        }
}
