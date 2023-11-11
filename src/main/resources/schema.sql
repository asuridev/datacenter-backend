
-- This script only contains the table creation statements and does not fully represent the table in the database. It's still missing: indices, triggers. Do not use it as a backup.

-- Sequence and defined type
CREATE SEQUENCE IF NOT EXISTS operators_id_seq;

-- Table Definition
CREATE TABLE "public"."operators" (
    "id" int8 NOT NULL DEFAULT nextval('operators_id_seq'::regclass),
    "name" varchar(255),
    PRIMARY KEY ("id")
);


-- This script only contains the table creation statements and does not fully represent the table in the database. It's still missing: indices, triggers. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."roles" (
    "id" varchar(255) NOT NULL,
    PRIMARY KEY ("id")
);


-- This script only contains the table creation statements and does not fully represent the table in the database. It's still missing: indices, triggers. Do not use it as a backup.

-- Sequence and defined type
CREATE SEQUENCE IF NOT EXISTS users_id_seq;

-- Table Definition
CREATE TABLE "public"."users" (
    "id" int8 NOT NULL DEFAULT nextval('users_id_seq'::regclass),
    "created_at" timestamp,
    "update_at" timestamp,
    "disabled" bool,
    "last_name" varchar(255),
    "locked" bool,
    "name" varchar(255),
    "password" varchar(255) NOT NULL,
    "username" varchar(255) NOT NULL,
    PRIMARY KEY ("id")
);


-- This script only contains the table creation statements and does not fully represent the table in the database. It's still missing: indices, triggers. Do not use it as a backup.

-- Sequence and defined type
CREATE SEQUENCE IF NOT EXISTS recharges_id_seq;

-- Table Definition
CREATE TABLE "public"."recharges" (
    "id" int8 NOT NULL DEFAULT nextval('recharges_id_seq'::regclass),
    "created_at" timestamp,
    "update_at" timestamp,
    "telephone" int8,
    "value" numeric(38,2),
    "operator_id" int8,
    "user_id" int8,
    CONSTRAINT "fkjdgqfcyk2mgxx7d0i2d6tcu6y" FOREIGN KEY ("operator_id") REFERENCES "public"."operators"("id"),
    CONSTRAINT "fkqw6v3th4n8k9n4wn4ikcsom2b" FOREIGN KEY ("user_id") REFERENCES "public"."users"("id"),
    PRIMARY KEY ("id")
);


-- This script only contains the table creation statements and does not fully represent the table in the database. It's still missing: indices, triggers. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."users_roles" (
    "users_id" int8 NOT NULL,
    "roles_id" varchar(255) NOT NULL,
    CONSTRAINT "fka62j07k5mhgifpp955h37ponj" FOREIGN KEY ("roles_id") REFERENCES "public"."roles"("id"),
    CONSTRAINT "fkml90kef4w2jy7oxyqv742tsfc" FOREIGN KEY ("users_id") REFERENCES "public"."users"("id")
);
