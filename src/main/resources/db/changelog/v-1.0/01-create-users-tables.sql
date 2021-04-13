    create table users (
       id bigint not null auto_increment,
       username varchar(50) not null,
       password varchar(100),
       primary key (id)
    ) engine=InnoDB

GO

    alter table users
       add constraint users_username_uindex unique (username)
GO

