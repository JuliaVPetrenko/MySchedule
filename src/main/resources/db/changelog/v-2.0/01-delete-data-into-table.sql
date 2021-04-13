delete users_tasks.* from users_tasks
 join users on users_tasks.user_id = users.id
where username in ('Admin','Liz','Nick')

GO

delete users_roles.* from users_roles
  join users on users_roles.user_id = users.id
where username in ('Liz','Nick')

GO

delete users
where username in ('Admin','Liz','Nick')

GO

delete users_tasks.* from users_tasks
   join tasks on users_tasks.task_id = tasks.id
where taskname in ('task1', 'task2')

GO

delete from tasks
where taskname in ('task1', 'task2')

GO

delete users_roles.* from users_roles
 join roles on users_roles.role_id = roles.id
where rolename in ('ADMIN', 'USER1', 'USER2')

GO

delete from roles
where rolename in ('ADMIN', 'USER1', 'USER2')

GO
