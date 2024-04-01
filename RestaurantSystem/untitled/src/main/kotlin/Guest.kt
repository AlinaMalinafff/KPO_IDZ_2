class Guest(val _login: String, val _name: String, val _surname: String, _saltedPassword: Int, _salt: String) {
    // login == phone number
    val login: String = _login
    var name: String = _name;
    var surname: String = _surname;
    var listOfOrders: MutableList<Order> = mutableListOf();
    var saltedPassword: Int = _saltedPassword;
    var salt = _salt;
}