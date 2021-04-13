    create table roles (
       id bigint not null auto_increment,
        rolename varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

GO

    alter table roles
       add constraint roles_rolename_uindex unique (rolename)
GO