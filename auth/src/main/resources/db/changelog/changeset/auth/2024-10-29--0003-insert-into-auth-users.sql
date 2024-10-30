--liquibase formatted sql

--changeset gbroccol:2024-10-29--0003-insert-into-auth-users
INSERT INTO auth.users (user_id, username, password, email, is_email_confirmed, sign_up_dt, change_dt)
VALUES ('6081d313-372e-46e4-b3c5-5ca1756b0665', 'user', '$2a$12$n55ITTEjO0buB4MEi7pH7eFLNx1nP32/YT3MvS0xUECMIwjBc5SWG', 'user@mail.com', false, now(), now()),
       ('fdd3c0c5-01ee-4cc6-8d86-ce47c7a4b57a', 'admin', '$2a$12$delR9fxE02ZABNjAJDoumuz0l4UyYBlB07MLNBrBFCKFiRIRIxZm6', 'admin@mail.com', false, now(), now());