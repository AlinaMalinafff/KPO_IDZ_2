import kotlin.system.exitProcess

class RunningSystem {
    var restaurant: Restaurant = Restaurant()
    fun Run() {
        println("welcome to the program")
        AuthorisationManager()
    }
    fun AuthorisationManager() {
        println("1 - рега как гостя")
        println("2 - рега как админа")
        println("3 - выйти из программы")

        var flag: Boolean = true
        do {
            flag = true
            println("command input")
            val input: String = readln()
            when (input) {
                "1" -> GuestRegistration()
                "2" -> AdminRegistration()
                "3" -> exitProcess(0)
                else -> flag = false
            }
        } while (flag)
    }

    fun GuestRegistration() {
        val isSuccessful: Boolean = restaurant.userDataBase.RegistGuest()
        if (isSuccessful) {
            GuestSignUp()
            return
        }
        println("you already exists")
        println("1 - menu, 2 - again")
        val input: String = readln()
        when (input) {
            "1" -> AuthorisationManager()
            "2" -> GuestRegistration()
        }
    }
    fun GuestSignUp() {
        println("sign up process")
        println("login")
        val input_login: String = readln()
        restaurant.userDataBase.CheckGuest(input_login)
    }

    fun AdminSignUp() {
        println("admin registration works!")
    }

    fun AdminRegistration() {
        val isSuccessful: Boolean = restaurant.userDataBase.RegistAdmin()
        if (isSuccessful) {
            AdminSignUp()
            return
        }
        println("you already exists")
        println("1 - menu, 2 - again")
        val input: String = readln()
        when (input) {
            "1" -> AuthorisationManager()
            "2" -> AdminRegistration()
        }
    }
}