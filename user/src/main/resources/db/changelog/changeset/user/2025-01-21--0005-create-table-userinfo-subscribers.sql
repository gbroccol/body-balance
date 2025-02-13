----liquibase formatted sql
----changeset gbroccol:2025-01-21--0005-create-table-userinfo-subscribers

CREATE TABLE IF NOT EXISTS userinfo.subscriber
(
    user_id       UUID,
    subscriber_id UUID,
    CONSTRAINT pk_subscriber PRIMARY KEY (user_id, subscriber_id)
);

CREATE INDEX IF NOT EXISTS ix_subscriber ON userinfo.subscriber (subscriber_id);