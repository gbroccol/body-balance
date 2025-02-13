----liquibase formatted sql
----changeset gbroccol:2025-01-21--0006-alter-table-userinfo-users

CREATE UNIQUE INDEX IF NOT EXISTS unq_ix_users ON userinfo.users (username);