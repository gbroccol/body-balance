----liquibase formatted sql
--
----changeset gbroccol:2024-11-04--0005-alter-table-auth-users
alter table auth.users
    rename column user_id to uuid;
