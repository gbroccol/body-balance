--liquibase formatted sql

--changeset gbroccol:2025-01-17--0001-init-db

CREATE SCHEMA IF NOT EXISTS userinfo;

CREATE TABLE IF NOT EXISTS userinfo.subscriber
(
    user_id       UUID,
    subscriber_id UUID,
    CONSTRAINT pk_subscriber PRIMARY KEY (user_id, subscriber_id)
);

CREATE SCHEMA IF NOT EXISTS notify;

CREATE TABLE IF NOT EXISTS notify.notification
(
    id              BIGSERIAL,
    user_id         UUID                        NOT NULL,
    title           VARCHAR(50)                 NOT NULL,
    message         VARCHAR(256)                NOT NULL,
    create_dt       TIMESTAMP WITH TIME ZONE    NOT NULL,
    notify_dt       TIMESTAMP WITH TIME ZONE    NULL,
    is_read         BOOLEAN                     NOT NULL,
    CONSTRAINT pk_notification PRIMARY KEY (id)
);
