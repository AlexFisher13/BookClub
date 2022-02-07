-- SpringBootStarterJDBC автоматически ищет и выполняет schema.sql и data.sql
insert into author (id, `name`)
values (1, 'Л. Н. Толстой'),
       (2, 'Д. Роулинг');
insert into genre (id, `name`)
values (1, 'роман'),
       (2, 'приключения');
insert into books (id, `name`, `author_id`, `genre_id`)
values (1, 'Война и мир', 1, 1),
       (2, 'Гарри Поттер', 2, 2);