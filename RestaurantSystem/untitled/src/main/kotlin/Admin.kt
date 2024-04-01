

class Admin(val _login: String, val _name: String, val _surname: String, _password: Int, _salt: String) {
    // login == phone number
    val login: String = _login
    var name: String = _name;
    var surname: String = _surname;
    var listOfOrders: MutableList<Order> = mutableListOf()
    // id or code for new admins
    var secretCode = "pupupu"
    var saltedHashedPassword = _password;
    var salt = _salt;
}