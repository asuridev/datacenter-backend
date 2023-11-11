

INSERT INTO "public"."operators" ("id", "name") VALUES
(1, 'TIGO');
INSERT INTO "public"."operators" ("id", "name") VALUES
(2, 'MOVISTAR');
INSERT INTO "public"."operators" ("id", "name") VALUES
(3, 'COMCEL');
INSERT INTO "public"."operators" ("id", "name") VALUES
(4, 'UFF');


INSERT INTO "public"."roles" ("id") VALUES
('ADMIN');
INSERT INTO "public"."roles" ("id") VALUES
('SELLER');



INSERT INTO "public"."users" ("id", "created_at", "update_at", "disabled", "last_name", "locked", "name", "password", "username") VALUES
(1, '2023-11-11 12:42:17.711457', '2023-11-11 12:42:17.711457', 'f', 'Gonzalez', 'f', 'Pedro', '$2a$10$7XTsM/wRuHVp/kmPoRL0zOnFxTy2U.4cysv.dv.McDRjq./aK2YRC', 'pedro@gmail.com');
INSERT INTO "public"."users" ("id", "created_at", "update_at", "disabled", "last_name", "locked", "name", "password", "username") VALUES
(2, '2023-11-11 12:42:51.174988', '2023-11-11 12:42:51.174988', 'f', 'Rodriguez', 'f', 'Maria', '$2a$10$xoXSLhj1FaNQwWj2Cnai7ehcDz/WpjiDbHh.zxHwtyLMbAV2maAO2', 'maria@gmail.com');
INSERT INTO "public"."users" ("id", "created_at", "update_at", "disabled", "last_name", "locked", "name", "password", "username") VALUES
(3, '2023-11-11 12:43:29.465561', '2023-11-11 12:43:29.465561', 'f', 'Blanco', 'f', 'Diana', '$2a$10$D0CBR8V.Y7VOb.BKidbWR.avLgJtF4YTTJ8.bWOgMjneHFE9lObnS', 'diana@gmail.com');
INSERT INTO "public"."users" ("id", "created_at", "update_at", "disabled", "last_name", "locked", "name", "password", "username") VALUES
(4, '2023-11-11 12:44:17.774793', '2023-11-11 12:44:17.774793', 'f', 'Pertuz', 'f', 'Ana', '$2a$10$uLQp/heDdPOMOMP9XMC.Eu53LRs6XwFjPE9m02hCw2XzBMdPQRV6.', 'ana@gmail.com'),
(5, '2023-11-11 12:44:55.72628', '2023-11-11 12:44:55.72628', 'f', 'Perez', 'f', 'Juan', '$2a$10$dv1mOdvBvNr5CyJ4P4g3jOuItu5L7ZeipMy2LYtY08ejiRN.8dYJ.', 'juan@gmail.com');



INSERT INTO "public"."users_roles" ("users_id", "roles_id") VALUES
(1, 'SELLER');
INSERT INTO "public"."users_roles" ("users_id", "roles_id") VALUES
(2, 'SELLER');
INSERT INTO "public"."users_roles" ("users_id", "roles_id") VALUES
(3, 'SELLER');
INSERT INTO "public"."users_roles" ("users_id", "roles_id") VALUES
(4, 'SELLER'),
(4, 'ADMIN'),
(5, 'SELLER'),
(5, 'ADMIN');