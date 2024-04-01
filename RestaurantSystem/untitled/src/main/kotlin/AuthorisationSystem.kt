import kotlin.random.Random

class AuthorisationSystem {
    // all users - with logins
    var guestsList: MutableList<Guest> = mutableListOf()
    // all admins
    var adminsList: MutableList<Admin> = mutableListOf()

    var salt: String = ""

    fun CheckGuestUniqueness(login: String): Boolean {
        for (guest in guestsList) {
            if (guest.login == login) {
                return false;
            }
        }
        return true;
    }

    fun CheckAdminUniqueness(login: String): Boolean {
        for (guest in adminsList) {
            if (guest.login == login) {
                return false;
            }
        }
        return true;
    }

    fun GenerateSalt(): String {
        val randomValues = List(10) { Random.nextInt(0, 100) }
        var salt: String = ""
        for (value in randomValues) {
            salt += value.toChar();
        }
        return salt
    }

    fun SaltedHash(password: String): Int {
        val salt: String = GenerateSalt()
        val saltedPassword = password + salt
        val saltedHashedPassword: Int = saltedPassword.hashCode();
        return saltedHashedPassword;
    }

    fun CheckGuest(input_login: String): Guest {
        var isFound: Boolean = false;
        var foundGuest: Guest = Guest("", " ", "", 0, "");
        for (guest in guestsList) {
            if (guest.login == input_login) {
                isFound = true
                foundGuest = guest
            }
        }
        if (!isFound) {
            RegistGuest();
        }
        val passwordIsRight = false;
        while(!passwordIsRight) {
            println("input of password")
            val password: String = readln()
            val passwordInput = SaltedHash(password + foundGuest.salt)
            if (passwordInput == foundGuest.saltedPassword) {
                return foundGuest;
            }
        }
        return Guest("", "", "", 0, "");
    }

    fun RegistGuest(): Boolean {
        println("name")
        val name: String = readln()
        println("surname")
        val surname: String = readln()
        println("login - phone number")
        val login: String = readln()
        println("password")
        val password: String = readln()
        val salt = GenerateSalt()
        val saltedPassword = SaltedHash(password + salt)
        if (!CheckGuestUniqueness(login)) {
            return false;
        }
        guestsList.add(Guest(login, name, surname, saltedPassword, salt))

        return true;
    }

    fun RegistAdmin(): Boolean {
        println("name")
        val name: String = readln()
        println("surname")
        val surname: String = readln()
        println("login - phone number")
        val login: String = readln()
        println("password")
        val password: String = readln()
        val salt = GenerateSalt()
        val saltedPassword = SaltedHash(password + salt)
        if (!CheckAdminUniqueness(login)) {
            return false;
        }
        adminsList.add(Admin(login, name, surname, saltedPassword, salt))
        return true;
    }

    fun CheckAdmin(input_login: String): Admin {
        var isFound: Boolean = false;
        var foundAdmin: Admin = Admin("", " ", "", 0, "");
        for (adm in adminsList) {
            if (adm.login == input_login) {
                isFound = true
                foundAdmin = adm
            }
        }
        if (!isFound) {
            RegistAdmin();
        }
        val passwordIsRight = false;
        while(!passwordIsRight) {
            println("input of password")
            val password: String = readln()
            val passwordInput = SaltedHash(password + foundAdmin.salt)
            if (passwordInput == foundAdmin.saltedHashedPassword) {
                return foundAdmin;
            }
        }
        return Admin("", "", "", 0, "");
    }
}