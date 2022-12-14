create table library.public.authors
(
    author_id integer generated by default as identity primary key,
    name varchar(255) not null
);

create table library.public.genres
(
    genre_id integer generated by default as identity primary key,
    name varchar(255) not null
);

create table library.public.publishers
(
    publisher_id integer generated by default as identity primary key,
    name varchar(255) not null
);

create table library.public.books
(
    book_id integer generated by default as identity primary key,
    name varchar(255) not null,
    publication_date date not null,
    publisher_id integer references publishers on delete cascade
);

create table library.public.magazines
(
    magazine_id integer generated by default as identity primary key,
    name varchar(255) not null,
    publication_date date not null,
    publisher_id integer references publishers on delete cascade
);

create table library.public.newspapers
(
    newspaper_id integer generated by default as identity primary key,
    name varchar(255) not null,
    publication_date date not null,
    publisher_id integer references publishers on delete cascade
);

create table library.public.books_authors
(
    book_id integer not null references books on delete cascade,
    author_id integer not null references authors on delete cascade,
    primary key (book_id, author_id)
);

create table library.public.books_genres
(
    book_id integer not null references books on delete cascade,
    genre_id integer not null references genres on delete cascade,
    primary key (book_id, genre_id)
);

create table library.public.magazines_genres
(
    magazine_id integer not null references magazines on delete cascade,
    genre_id integer not null references genres on delete cascade,
    primary key (magazine_id, genre_id)
);

create table library.public.newspapers_genres
(
    newspaper_id integer not null references newspapers on delete cascade,
    genre_id integer not null references genres on delete cascade,
    primary key (newspaper_id, genre_id)
);