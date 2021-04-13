    create table tasks (
       id bigint not null auto_increment,
       taskname varchar(255) not null,
       date_create datetime,
       date_start datetime,
       priority integer,
       primary key (id)
    ) engine=InnoDB

GO

    alter table tasks
       add constraint tasks_taskname_uidex unique (taskname)
GO