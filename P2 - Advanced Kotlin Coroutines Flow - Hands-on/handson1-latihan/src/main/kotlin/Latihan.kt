import kotlinx.coroutines.*

// Hands-on 1: Coroutines Dasar
// Tugas: Ambil data dari 2 sumber secara PARALEL menggunakan async/await,
// lalu gabungkan hasilnya. Total waktu eksekusi harus < 2 detik.

suspend fun fetchUserProfile(userId: String): String {
    delay(1000) // Simulasi network delay
    return "User: John Doe"
}

suspend fun fetchUserPosts(userId: String): List<String> {
    delay(800) // Simulasi network delay
    return listOf("Post 1", "Post 2", "Post 3")
}

fun main() = runBlocking {

    // Mencatat waktu mulai
    val startTime = System.currentTimeMillis()

    // Menjalankan kedua fungsi secara PARALEL
    val profileDeferred = async {
        fetchUserProfile("123140171")
    }

    val postsDeferred = async {
        fetchUserPosts("123140171")
    }

    // Menunggu hasil dari kedua coroutine
    val profile = profileDeferred.await()
    val posts = postsDeferred.await()

    // Menampilkan hasil
    println("=== User Profile ===")
    println(profile)

    println()
    println("=== User Posts ===")

    posts.forEach { post ->
        println(post)
    }

    // Menghitung waktu eksekusi
    val endTime = System.currentTimeMillis()
    println()
    println("Waktu: ${endTime - startTime}ms")
}
