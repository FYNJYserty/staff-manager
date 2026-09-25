# Staff Manager

REST API для получения списка сотрудников с должностями и списка департаментов с числом сотрудников.

## Технологии

- Язык: **Java 17**.
- Фреймворк: **Spring Boot 4.1.1**, Spring Web MVC, Spring Data JPA и Hibernate.
- Миграции базы данных: Liquibase.
- СУБД: **PostgreSQL 16**.
- База данных: **`staff_db`**.

## Быстрый запуск через Docker

Нужен установленный и запущенный Docker Desktop.

```bash
docker compose up --build
```

Compose запустит PostgreSQL, дождётся его готовности, затем соберёт и запустит приложение. Liquibase создаст таблицы и автоматически загрузит тестовые данные из `src/main/resources/db/schema/data_staff.sql`.

После запуска API доступно по адресу `http://localhost:8080`.

Проверить ответы можно командами:

```bash
curl http://localhost:8080/api/employees
curl http://localhost:8080/api/departments
```

Для остановки контейнеров:

```bash
docker compose down
```

Чтобы также удалить данные PostgreSQL, сохранённые в Docker volume:

```bash
docker compose down --volumes
```

## Локальный запуск без Docker

1. Подготовьте PostgreSQL 16 и создайте базу `staff_db`.
2. Создайте в корне проекта файл `.env`:

   ```properties
   DB_URL=jdbc:postgresql://localhost:5432/staff_db
   DB_USER=postgres
   DB_PASSWORD=postgres
   ```

3. Запустите приложение:

   ```bash
   ./mvnw spring-boot:run
   ```

Liquibase сам применит схему и тестовые данные. Настройки подключения вынесены в `.env`, который исключён из Git.

## Выполняемые запросы

Приложение использует JPQL-конструкторные проекции: Hibernate безопасно формирует SQL, а параметры в этих запросах отсутствуют. Эквивалентные SQL-запросы:

### `GET /api/employees`

```sql
SELECT e.id,
       e.first_name,
       e.last_name,
       e.middle_name,
       e.birth_date,
       e.email,
       p.id   AS position_id,
       p.name AS position
FROM employee e
JOIN position p ON p.id = e.position_id
ORDER BY e.id;
```

Возвращает JSON-массив сотрудников и их должностей.

### `GET /api/departments`

```sql
SELECT d.id,
       d.name,
       COUNT(ed.employee_id) AS employee_count
FROM department d
LEFT JOIN employee_department ed ON ed.department_id = d.id
GROUP BY d.id, d.name
ORDER BY d.id;
```

Возвращает JSON-массив департаментов, включая департаменты без сотрудников.

## Структура проекта

`src/main/java/org/example/staffmanager/` - корень проекта

`controller/` - HTTP-эндпоинты API

`dto/` - объекты JSON-ответов

`entity/` - JPA-сущности таблиц

`repository/` - JPA-репозитории и JPQL-запросы

`src/main/resources/` - миграции и настройки

`application.properties` - настройки Spring и подключения к БД

`db/changelog/` - миграции Liquibase

`db/schema/data_staff.sql` тестовые данные

`src/test/` - unit- и интеграционные тесты

## Проверка тестами

- Для контроллеров добавлены unit-тесты с моками репозиториев; они проверяют статус `200`, тело ответа и вызов репозитория.
- Подключениями к базе управляют Spring Boot и пул соединений HikariCP; Liquibase применяет изменения в транзакции при старте приложения.
- DTO отделяют JSON-ответы от JPA-сущностей, а запросы возвращают только нужные поля.

Запуск unit-тестов контроллеров:

```bash
./mvnw -Dtest=EmployeeControllerTest,DepartmentControllerTest test
```
