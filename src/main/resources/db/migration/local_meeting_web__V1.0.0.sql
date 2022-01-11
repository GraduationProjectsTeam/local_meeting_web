create table meeting(
meeting_id bigserial primary key,
organizer text not null,
address text not null,
location text not null,
title text not null,
about text,
registration_date date not null,
meeting_date date not null,
meeting_beginning decimal,
meeting_over decimal,
image_link text,

foreign key (organizer) references client(id)
);

create table comment(
id bigserial primary key,
meeting_id bigserial not null,
author text not null,
comment_date date,
comment_text text not null,

foreign key (author) references client(id),
foreign key (meeting_id) references meeting(id)
);

create table client(
id bigserial primary key,
name text,
mail text,
login text,
pass text,
);

create table location(
name text primary key

foreign key (name) references meeting(location)
);


