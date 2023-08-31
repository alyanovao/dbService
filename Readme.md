Проект для тестового подключения к clickhouse

Инструкция:
1 - запустить docker контейнер
docker run -d --name clickhouse -p 8123:8123 --ulimit nofile=262144:262144 clickhouse/clickhouse-server

2 - подключиться к clickhouse через IDE

3 - выполнить скрипт
CREATE TABLE test (
id int,
name String
) ENGINE = Memory;

insert into test(id, name) values (1, 'Тест');

4 - запустить проект

5 - вызвать метод http://localhost:8080/dbService/api