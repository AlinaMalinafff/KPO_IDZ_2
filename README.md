# KPO_IDZ_2

Готово: *до слёз*
регистрация и авторизация

В общем, я отдельно создала Running System, который менеджерит всю работу приложения главного меню приложения, то есть как раз по SOLID этот класс отвечает за работу с запросами юзера из главного меню приложения (у него только одна задача): запросы на регистрацию как гостя или как админа.

У нас есть Admin и Guest классы, которые представляют из себя шаблоны для создания типов гостей и админов, наследуются от User, а потом для каждого есть свой метод зарегистрироваться/войти, что является закосом на паттерн Фабричный метод. Изюминка: хоть эти классы и содержат поле для пароля, но а) пароль захеширован, б) там же хранится и соль, а это значит, что пароль был захеширован с солью, причём с индивидуалной солью для каждого юзера! В admin так же есть поле для хранение секретного ключа, чтобы в будущем реализовать регистрацию новых админов после подтверждения ключа другого админа (новые админы только с разрешения старого админа).

Есть AutorisationSystem, отвечающий за все процессы регистрации и авторизации. Закос на паттерн Фасад. Здесь происходит как раз генерация соли, хеширование с солью, создание новых юзеров и проверка на совпадение пароля.

Отдельно начала реализовывать класс UserHashTable (хеш табличка с линейным пробированием), дабы реализовать из неё базу данных для хранения юзеров и перетащить хранение пароля из классов в базу данных, но не додедала из-за курсача.

Конечно же, есть Restaurant, где хранится список гостей и админов. Он является некими мозгов - в будущем тут должна была появиться система заказа + листы с заказами + список всех блюд, но............

Плюс создала и по минимуму наполнила классы Dish и Order, чтоб как раз в них их листы хранить в Restaurant.

Классы системы авторизации и RunningSystem - это так же закос на паттерн Singleton, т.к. они общие и одинаковые для всех ресторанов и вообще они должны быть в еинственном экземпляре

...
