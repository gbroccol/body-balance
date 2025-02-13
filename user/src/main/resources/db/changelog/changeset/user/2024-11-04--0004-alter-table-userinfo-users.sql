----liquibase formatted sql
--
----changeset gbroccol:2024-11-04--0004-alter-table-userinfo-users
alter table userinfo.users
    rename column user_id to uuid;
