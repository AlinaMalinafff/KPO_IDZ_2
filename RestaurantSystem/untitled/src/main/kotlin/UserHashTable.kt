class HashObj {
    var isNull: Boolean = true;
    var isErased: Boolean = false;
    val login: String = ""
    val salt: String = ""
    val hashedSaltedPassword = ""
    lateinit var user: Any
}
// линейное пробирование
// логин хешируем преобразуем к числу
// кладём в это номер и потом там же по логину
// сравниваем пароли захешированные
class UserHashTable {
    var hashtable: MutableList<HashObj> = mutableListOf()
    // идти будут по порядку регистрации чисто

}