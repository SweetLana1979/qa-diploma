# Дипломный проект по курсу «Тестировщик ПО»
## О проекте
В рамках данного проекта необходимо автоматизировать тестирование сервиса покупки тура, взаимодействующего с СУБД и API Банка.

База данных хранит информацию о заказах, платежах, статусах карт, способах оплаты.

Покупка тура возможна с помощью карты и в кредит. Данные по картам обрабатываются отдельными сервисами (Payment Gate, Credit Gate)

Полные условия и исходные данные проекта можно посмотреть [здесь](https://github.com/netology-code/qa-diploma)

## Документация 

[План автоматизации тестирования ](https://github.com/SweetLana1979/qa-diploma/blob/main/docs/Plan.md)

[Отчёт о проведённом тестировании](https://github.com/SweetLana1979/qa-diploma/blob/main/docs/Report.md)

[Комплексный отчёт о проведённой автоматизации тестирования](https://github.com/SweetLana1979/qa-diploma/blob/main/docs/Summary.md)


## Запуск приложения

1. Склонировать репозиторий или скачать архив по [ссылке](https://github.com/SweetLana1979/qa-diploma). 
2. Установать и запустить Docker Desktop. Дополнительные инструкции можно найти по [ссылке](https://github.com/netology-code/aqa-homeworks/blob/aqa4/docker/installation.md)
3. Открыть проект в IntelliJ IDEA
4. Запустить необходимые базы данных (MySQL и PostgreSQL), а также NodeJS. Параметры для запуска хранятся в файле `docker-compose.yml`. Для запуска необходимо ввести в терминале команду:
```
docker-compose up
```
5. В новой вкладке терминала ввести следующую команду в зависимости от базы данных
- `java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar` - для MySQL
- `java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar` - для PostgreSQL
  
Приложение должно запуститься и работать по адресу http://localhost:8080/

## Запуск тестов
6. Выбрать базу данных. Для этого нужно в файле build.gradle раскомментировать строку с адресом соответствующей базы данных.
7. В новой вкладке терминала ввести команду в зависимости от запущенной БД:
- `./gradlew test "-Ddb.url=jdbc:mysql://localhost:3306/app"` - для MySQL
- `./gradlew test "-Ddb.url=jdbc:postgresql://localhost:5432/app"` - для PostgreSQL

## Перезапуск приложения и тестов
7. Остановить SUT командой CTRL + C

## Останов контейнеров
8. Остановить контейнеры командой CTRL+С, удалить контейнеры командой:
```
docker-compose down
```
## Формирование отчета AllureReport по результатам тестирования
9. В новой вкладке терминала или нажав двойной Ctrl ввести команду:
```
./gradlew allureServe
```
Сгенерированный отчет откроется в браузере автоматически. 
После просмотра и закрытия отчета можно остановить работу команды, нажав Ctrl+С или закрыть вкладку Run и нажать Disconnect.
