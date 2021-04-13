    create table users_tasks (
       task_id bigint not null,
        user_id bigint not null
    ) engine=InnoDB

GO
    alter table users_tasks
       add constraint users_tasks_users_id_fk
       foreign key (user_id)
       references users (id)
GO

    alter table users_tasks
       add constraint users_tasks_tasks_id_fk
       foreign key (task_id)
       references tasks (id)
GO