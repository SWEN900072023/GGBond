/*
 Navicat Premium Data Transfer

 Source Server         : aws-pg
 Source Server Type    : PostgreSQL
 Source Server Version : 140009 (140009)
 Source Host           : 52.65.13.88:5432
 Source Catalog        : musicevents
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 140009 (140009)
 File Encoding         : 65001

 Date: 16/10/2023 20:30:44
*/


-- ----------------------------
-- Sequence structure for admin_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."admin_id_seq";
CREATE SEQUENCE "public"."admin_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
ALTER SEQUENCE "public"."admin_id_seq" OWNER TO "dbuser";

-- ----------------------------
-- Sequence structure for customer_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."customer_id_seq";
CREATE SEQUENCE "public"."customer_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
ALTER SEQUENCE "public"."customer_id_seq" OWNER TO "dbuser";

-- ----------------------------
-- Sequence structure for customerorder_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."customerorder_id_seq";
CREATE SEQUENCE "public"."customerorder_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
ALTER SEQUENCE "public"."customerorder_id_seq" OWNER TO "dbuser";

-- ----------------------------
-- Sequence structure for event_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."event_id_seq";
CREATE SEQUENCE "public"."event_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
ALTER SEQUENCE "public"."event_id_seq" OWNER TO "dbuser";

-- ----------------------------
-- Sequence structure for planner_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."planner_id_seq";
CREATE SEQUENCE "public"."planner_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
ALTER SEQUENCE "public"."planner_id_seq" OWNER TO "dbuser";

-- ----------------------------
-- Sequence structure for ticket_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."ticket_id_seq";
CREATE SEQUENCE "public"."ticket_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
ALTER SEQUENCE "public"."ticket_id_seq" OWNER TO "dbuser";

-- ----------------------------
-- Sequence structure for venue_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."venue_id_seq";
CREATE SEQUENCE "public"."venue_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
ALTER SEQUENCE "public"."venue_id_seq" OWNER TO "dbuser";

-- ----------------------------
-- Sequence structure for webuser_user_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."webuser_user_id_seq";
CREATE SEQUENCE "public"."webuser_user_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
ALTER SEQUENCE "public"."webuser_user_id_seq" OWNER TO "dbuser";

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS "public"."admin";
CREATE TABLE "public"."admin" (
  "id" int4 NOT NULL DEFAULT nextval('admin_id_seq'::regclass),
  "username" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "password" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "name" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "telephone" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying
)
;
ALTER TABLE "public"."admin" OWNER TO "dbuser";

-- ----------------------------
-- Records of admin
-- ----------------------------
BEGIN;
INSERT INTO "public"."admin" ("id", "username", "password", "name", "telephone") VALUES (1, 'admin1', '123123', 'Bob', '0403123456');
INSERT INTO "public"."admin" ("id", "username", "password", "name", "telephone") VALUES (2, 'admin2', '321321', 'Jelly', '0412345678');
COMMIT;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS "public"."customer";
CREATE TABLE "public"."customer" (
  "id" int4 NOT NULL DEFAULT nextval('customer_id_seq'::regclass),
  "username" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "password" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "name" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "telephone" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying
)
;
ALTER TABLE "public"."customer" OWNER TO "dbuser";

-- ----------------------------
-- Records of customer
-- ----------------------------
BEGIN;
INSERT INTO "public"."customer" ("id", "username", "password", "name", "telephone") VALUES (2, 'ccus', '123456', 'Jerry', '123112');
INSERT INTO "public"."customer" ("id", "username", "password", "name", "telephone") VALUES (3, 'username', 'mypw', 'Lucy', '12332699');
INSERT INTO "public"."customer" ("id", "username", "password", "name", "telephone") VALUES (4, 'superman', '123', 'superme', '123123');
INSERT INTO "public"."customer" ("id", "username", "password", "name", "telephone") VALUES (1, 'ccname', '123123', 'Erik', '1231232');
INSERT INTO "public"."customer" ("id", "username", "password", "name", "telephone") VALUES (5, 'Jenny', '520', 'blink Jennieee', '123123');
COMMIT;

-- ----------------------------
-- Table structure for customerorder
-- ----------------------------
DROP TABLE IF EXISTS "public"."customerorder";
CREATE TABLE "public"."customerorder" (
  "id" int4 NOT NULL DEFAULT nextval('customerorder_id_seq'::regclass),
  "customer_id" int4,
  "ticket_id" int4,
  "event_id" int4,
  "event_name" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "section" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "price" int4,
  "num" int4,
  "timestamp" timestamp(6) DEFAULT CURRENT_TIMESTAMP
)
;
ALTER TABLE "public"."customerorder" OWNER TO "dbuser";

-- ----------------------------
-- Records of customerorder
-- ----------------------------
BEGIN;
INSERT INTO "public"."customerorder" ("id", "customer_id", "ticket_id", "event_id", "event_name", "section", "price", "num", "timestamp") VALUES (83, 5, 14, 35, 'Taylot Swift', 'sta', 88, 1, '2023-10-15 12:17:46.55839');
INSERT INTO "public"."customerorder" ("id", "customer_id", "ticket_id", "event_id", "event_name", "section", "price", "num", "timestamp") VALUES (84, 5, 14, 35, 'Taylor Swift', 'sta', 888, 1, '2023-10-15 12:22:25.488133');
INSERT INTO "public"."customerorder" ("id", "customer_id", "ticket_id", "event_id", "event_name", "section", "price", "num", "timestamp") VALUES (85, 5, 14, 35, 'Taylot Swift', 'sta', 88, 1, '2023-10-15 12:22:52.074017');
INSERT INTO "public"."customerorder" ("id", "customer_id", "ticket_id", "event_id", "event_name", "section", "price", "num", "timestamp") VALUES (86, 5, 14, 35, 'Taylot Swift', 'sta', 88, 1, '2023-10-15 12:22:52.080042');
INSERT INTO "public"."customerorder" ("id", "customer_id", "ticket_id", "event_id", "event_name", "section", "price", "num", "timestamp") VALUES (87, 5, 14, 35, 'Taylot Swift', 'sta', 88, 1, '2023-10-15 12:22:52.081025');
INSERT INTO "public"."customerorder" ("id", "customer_id", "ticket_id", "event_id", "event_name", "section", "price", "num", "timestamp") VALUES (88, 5, 14, 35, 'Taylot Swift', 'sta', 88, 1, '2023-10-15 12:22:52.082255');
INSERT INTO "public"."customerorder" ("id", "customer_id", "ticket_id", "event_id", "event_name", "section", "price", "num", "timestamp") VALUES (89, 5, 14, 35, 'Taylot Swift', 'sta', 88, 1, '2023-10-15 12:22:52.082929');
INSERT INTO "public"."customerorder" ("id", "customer_id", "ticket_id", "event_id", "event_name", "section", "price", "num", "timestamp") VALUES (90, 5, 14, 35, 'Taylot Swift', 'sta', 88, 1, '2023-10-15 12:22:52.08426');
INSERT INTO "public"."customerorder" ("id", "customer_id", "ticket_id", "event_id", "event_name", "section", "price", "num", "timestamp") VALUES (91, 5, 14, 35, 'Taylot Swift', 'sta', 88, 1, '2023-10-15 12:22:52.085515');
INSERT INTO "public"."customerorder" ("id", "customer_id", "ticket_id", "event_id", "event_name", "section", "price", "num", "timestamp") VALUES (92, 5, 14, 35, 'Taylot Swift', 'sta', 88, 1, '2023-10-15 12:22:52.086781');
INSERT INTO "public"."customerorder" ("id", "customer_id", "ticket_id", "event_id", "event_name", "section", "price", "num", "timestamp") VALUES (93, 5, 14, 35, 'Taylot Swift', 'sta', 88, 1, '2023-10-15 12:22:52.088126');
INSERT INTO "public"."customerorder" ("id", "customer_id", "ticket_id", "event_id", "event_name", "section", "price", "num", "timestamp") VALUES (94, 5, 14, 35, 'Taylot Swift', 'sta', 88, 1, '2023-10-15 12:22:52.089546');
INSERT INTO "public"."customerorder" ("id", "customer_id", "ticket_id", "event_id", "event_name", "section", "price", "num", "timestamp") VALUES (95, 5, 14, 35, 'Taylot Swift', 'sta', 88, 1, '2023-10-15 12:22:52.090815');
INSERT INTO "public"."customerorder" ("id", "customer_id", "ticket_id", "event_id", "event_name", "section", "price", "num", "timestamp") VALUES (96, 5, 14, 35, 'Taylot Swift', 'sta', 88, 1, '2023-10-15 12:22:52.092541');
INSERT INTO "public"."customerorder" ("id", "customer_id", "ticket_id", "event_id", "event_name", "section", "price", "num", "timestamp") VALUES (97, 5, 14, 35, 'Taylot Swift', 'sta', 88, 1, '2023-10-15 12:22:52.093826');
INSERT INTO "public"."customerorder" ("id", "customer_id", "ticket_id", "event_id", "event_name", "section", "price", "num", "timestamp") VALUES (98, 5, 14, 35, 'Taylot Swift', 'sta', 88, 1, '2023-10-15 12:22:52.113489');
INSERT INTO "public"."customerorder" ("id", "customer_id", "ticket_id", "event_id", "event_name", "section", "price", "num", "timestamp") VALUES (99, 5, 14, 35, 'Taylot Swift', 'sta', 88, 1, '2023-10-15 12:22:52.114933');
INSERT INTO "public"."customerorder" ("id", "customer_id", "ticket_id", "event_id", "event_name", "section", "price", "num", "timestamp") VALUES (100, 5, 14, 35, 'Taylot Swift', 'sta', 88, 1, '2023-10-15 12:22:52.136683');
INSERT INTO "public"."customerorder" ("id", "customer_id", "ticket_id", "event_id", "event_name", "section", "price", "num", "timestamp") VALUES (101, 5, 14, 35, 'Taylot Swift', 'sta', 88, 1, '2023-10-15 12:22:52.135634');
INSERT INTO "public"."customerorder" ("id", "customer_id", "ticket_id", "event_id", "event_name", "section", "price", "num", "timestamp") VALUES (102, 5, 14, 35, 'Taylot Swift', 'sta', 88, 1, '2023-10-15 12:22:52.15661');
INSERT INTO "public"."customerorder" ("id", "customer_id", "ticket_id", "event_id", "event_name", "section", "price", "num", "timestamp") VALUES (104, 5, 14, 35, 'Taylot Swift', 'sta', 88, 1, '2023-10-15 12:22:52.161099');
INSERT INTO "public"."customerorder" ("id", "customer_id", "ticket_id", "event_id", "event_name", "section", "price", "num", "timestamp") VALUES (105, 5, 14, 35, 'Taylot Swift', 'sta', 88, 1, '2023-10-15 12:22:52.162441');
INSERT INTO "public"."customerorder" ("id", "customer_id", "ticket_id", "event_id", "event_name", "section", "price", "num", "timestamp") VALUES (106, 5, 14, 35, 'Taylot Swift', 'sta', 88, 1, '2023-10-15 12:22:52.20103');
INSERT INTO "public"."customerorder" ("id", "customer_id", "ticket_id", "event_id", "event_name", "section", "price", "num", "timestamp") VALUES (107, 5, 14, 35, 'Taylot Swift', 'sta', 88, 1, '2023-10-15 12:22:52.204084');
INSERT INTO "public"."customerorder" ("id", "customer_id", "ticket_id", "event_id", "event_name", "section", "price", "num", "timestamp") VALUES (108, 5, 14, 35, 'Taylot Swift', 'sta', 88, 1, '2023-10-15 12:22:52.209068');
INSERT INTO "public"."customerorder" ("id", "customer_id", "ticket_id", "event_id", "event_name", "section", "price", "num", "timestamp") VALUES (109, 5, 14, 35, 'Taylot Swift', 'sta', 88, 1, '2023-10-15 12:22:52.210943');
INSERT INTO "public"."customerorder" ("id", "customer_id", "ticket_id", "event_id", "event_name", "section", "price", "num", "timestamp") VALUES (110, 5, 14, 35, 'Taylot Swift', 'sta', 88, 1, '2023-10-15 12:22:52.21894');
INSERT INTO "public"."customerorder" ("id", "customer_id", "ticket_id", "event_id", "event_name", "section", "price", "num", "timestamp") VALUES (112, 5, 14, 35, 'Taylot Swift', 'sta', 88, 1, '2023-10-15 12:22:52.23732');
INSERT INTO "public"."customerorder" ("id", "customer_id", "ticket_id", "event_id", "event_name", "section", "price", "num", "timestamp") VALUES (113, 5, 14, 35, 'Taylot Swift', 'sta', 88, 1, '2023-10-15 12:22:52.238618');
INSERT INTO "public"."customerorder" ("id", "customer_id", "ticket_id", "event_id", "event_name", "section", "price", "num", "timestamp") VALUES (114, 5, 14, 35, 'Taylot Swift', 'sta', 88, 1, '2023-10-15 12:22:52.239879');
INSERT INTO "public"."customerorder" ("id", "customer_id", "ticket_id", "event_id", "event_name", "section", "price", "num", "timestamp") VALUES (115, 5, 14, 35, 'Taylor Swift', 'sta', 888, 2, '2023-10-15 16:37:34.704099');
INSERT INTO "public"."customerorder" ("id", "customer_id", "ticket_id", "event_id", "event_name", "section", "price", "num", "timestamp") VALUES (117, 2, 5, 22, 'Baorui Chen', 'sta', 888, 1, '2023-10-16 02:04:10.895516');
INSERT INTO "public"."customerorder" ("id", "customer_id", "ticket_id", "event_id", "event_name", "section", "price", "num", "timestamp") VALUES (118, 2, 5, 22, 'Baorui Chen', 'sta', 888, 1, '2023-10-16 02:05:54.534964');
INSERT INTO "public"."customerorder" ("id", "customer_id", "ticket_id", "event_id", "event_name", "section", "price", "num", "timestamp") VALUES (69, 5, 9, 30, 'Good', 'sta', 888, 1, '2023-10-15 00:30:25.640835');
INSERT INTO "public"."customerorder" ("id", "customer_id", "ticket_id", "event_id", "event_name", "section", "price", "num", "timestamp") VALUES (70, 5, 9, 30, 'Good', 'mos', 888, 1, '2023-10-15 00:30:40.248484');
COMMIT;

-- ----------------------------
-- Table structure for event
-- ----------------------------
DROP TABLE IF EXISTS "public"."event";
CREATE TABLE "public"."event" (
  "id" int4 NOT NULL DEFAULT nextval('event_id_seq'::regclass),
  "name" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "venue_id" int4,
  "date" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "stap" int4,
  "mosp" int4,
  "seap" int4,
  "vipp" int4,
  "othp" int4,
  "version" int4 DEFAULT 0
)
;
ALTER TABLE "public"."event" OWNER TO "dbuser";

-- ----------------------------
-- Records of event
-- ----------------------------
BEGIN;
INSERT INTO "public"."event" ("id", "name", "venue_id", "date", "stap", "mosp", "seap", "vipp", "othp", "version") VALUES (35, 'Taylor Swift', 2, '2023-09-28', 599, 799, 1099, 1099, 20, 9);
INSERT INTO "public"."event" ("id", "name", "venue_id", "date", "stap", "mosp", "seap", "vipp", "othp", "version") VALUES (30, 'Good', 2, '2023-10-14', 50, 200, 200, 200, 300, 2);
INSERT INTO "public"."event" ("id", "name", "venue_id", "date", "stap", "mosp", "seap", "vipp", "othp", "version") VALUES (22, 'Baorui Chen', 2, '2023-02-22', 20, 50, 100, 100, 0, 1);
COMMIT;

-- ----------------------------
-- Table structure for event_planner_association
-- ----------------------------
DROP TABLE IF EXISTS "public"."event_planner_association";
CREATE TABLE "public"."event_planner_association" (
  "event_id" int4 NOT NULL,
  "planner_id" int4 NOT NULL
)
;
ALTER TABLE "public"."event_planner_association" OWNER TO "dbuser";

-- ----------------------------
-- Records of event_planner_association
-- ----------------------------
BEGIN;
INSERT INTO "public"."event_planner_association" ("event_id", "planner_id") VALUES (22, 4);
INSERT INTO "public"."event_planner_association" ("event_id", "planner_id") VALUES (30, 2);
INSERT INTO "public"."event_planner_association" ("event_id", "planner_id") VALUES (35, 2);
INSERT INTO "public"."event_planner_association" ("event_id", "planner_id") VALUES (22, 1);
INSERT INTO "public"."event_planner_association" ("event_id", "planner_id") VALUES (35, 1);
INSERT INTO "public"."event_planner_association" ("event_id", "planner_id") VALUES (30, 4);
INSERT INTO "public"."event_planner_association" ("event_id", "planner_id") VALUES (22, 2);
COMMIT;

-- ----------------------------
-- Table structure for planner
-- ----------------------------
DROP TABLE IF EXISTS "public"."planner";
CREATE TABLE "public"."planner" (
  "id" int4 NOT NULL DEFAULT nextval('planner_id_seq'::regclass),
  "username" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "password" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "name" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "telephone" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying
)
;
ALTER TABLE "public"."planner" OWNER TO "dbuser";

-- ----------------------------
-- Records of planner
-- ----------------------------
BEGIN;
INSERT INTO "public"."planner" ("id", "username", "password", "name", "telephone") VALUES (2, 'plannerrrr', '123123', 'Cris', '12332697');
INSERT INTO "public"."planner" ("id", "username", "password", "name", "telephone") VALUES (3, 'ppplanner', 'mypw', 'Jay', '123112');
INSERT INTO "public"."planner" ("id", "username", "password", "name", "telephone") VALUES (4, 'joker', '123', 'batman', '123123');
INSERT INTO "public"."planner" ("id", "username", "password", "name", "telephone") VALUES (1, 'planner1', '123321', 'Jack', '12332669');
INSERT INTO "public"."planner" ("id", "username", "password", "name", "telephone") VALUES (5, 'Lover', '123', 'Jenny', '0420280917');
INSERT INTO "public"."planner" ("id", "username", "password", "name", "telephone") VALUES (6, 'Jessy', '456', 'linjing', '123456');
COMMIT;

-- ----------------------------
-- Table structure for ticket
-- ----------------------------
DROP TABLE IF EXISTS "public"."ticket";
CREATE TABLE "public"."ticket" (
  "id" int4 NOT NULL DEFAULT nextval('ticket_id_seq'::regclass),
  "event_id" int4,
  "event_name" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "venue_id" int4,
  "venue_name" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "san" int4,
  "sbn" int4,
  "scn" int4,
  "sdn" int4,
  "sen" int4,
  "sap" int4,
  "sbp" int4,
  "scp" int4,
  "sdp" int4,
  "sep" int4
)
;
ALTER TABLE "public"."ticket" OWNER TO "dbuser";

-- ----------------------------
-- Records of ticket
-- ----------------------------
BEGIN;
INSERT INTO "public"."ticket" ("id", "event_id", "event_name", "venue_id", "venue_name", "san", "sbn", "scn", "sdn", "sen", "sap", "sbp", "scp", "sdp", "sep") VALUES (14, 35, 'Taylor Swift', 2, 'State Theatre', 80, 70, 60, 20, 50, 599, 799, 1099, 1099, 20);
INSERT INTO "public"."ticket" ("id", "event_id", "event_name", "venue_id", "venue_name", "san", "sbn", "scn", "sdn", "sen", "sap", "sbp", "scp", "sdp", "sep") VALUES (9, 30, 'Good', 2, 'State Theatre', 80, 70, 60, 20, 50, 50, 200, 200, 200, 300);
INSERT INTO "public"."ticket" ("id", "event_id", "event_name", "venue_id", "venue_name", "san", "sbn", "scn", "sdn", "sen", "sap", "sbp", "scp", "sdp", "sep") VALUES (5, 22, 'Baorui Chen', 2, 'State Theatre', 80, 70, 60, 20, 50, 20, 50, 100, 100, 0);
COMMIT;

-- ----------------------------
-- Table structure for venue
-- ----------------------------
DROP TABLE IF EXISTS "public"."venue";
CREATE TABLE "public"."venue" (
  "id" int4 NOT NULL DEFAULT nextval('venue_id_seq'::regclass),
  "name" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "sectionsta" int4,
  "sectionmos" int4,
  "sectionsea" int4,
  "sectionvip" int4,
  "sectionoth" int4
)
;
ALTER TABLE "public"."venue" OWNER TO "dbuser";

-- ----------------------------
-- Records of venue
-- ----------------------------
BEGIN;
INSERT INTO "public"."venue" ("id", "name", "sectionsta", "sectionmos", "sectionsea", "sectionvip", "sectionoth") VALUES (2, 'State Theatre', 80, 70, 60, 20, 50);
INSERT INTO "public"."venue" ("id", "name", "sectionsta", "sectionmos", "sectionsea", "sectionvip", "sectionoth") VALUES (6, 'Melbourne Center', 20, 20, 20, 20, 20);
INSERT INTO "public"."venue" ("id", "name", "sectionsta", "sectionmos", "sectionsea", "sectionvip", "sectionoth") VALUES (7, 'Melbourne Mus', 30, 30, 30, 30, 30);
INSERT INTO "public"."venue" ("id", "name", "sectionsta", "sectionmos", "sectionsea", "sectionvip", "sectionoth") VALUES (1, 'Center', 110, 100, 100, 10, 50);
COMMIT;

-- ----------------------------
-- Table structure for webuser
-- ----------------------------
DROP TABLE IF EXISTS "public"."webuser";
CREATE TABLE "public"."webuser" (
  "user_id" int4 NOT NULL DEFAULT nextval('webuser_user_id_seq'::regclass),
  "usertype" varchar(50) COLLATE "pg_catalog"."default",
  "phone" varchar(50) COLLATE "pg_catalog"."default",
  "username" varchar(50) COLLATE "pg_catalog"."default",
  "password" varchar(50) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "public"."webuser" OWNER TO "dbuser";

-- ----------------------------
-- Records of webuser
-- ----------------------------
BEGIN;
INSERT INTO "public"."webuser" ("user_id", "usertype", "phone", "username", "password") VALUES (1, 'admin', '403123456', 'admin1', '123123');
INSERT INTO "public"."webuser" ("user_id", "usertype", "phone", "username", "password") VALUES (2, 'Admin', '403654321', 'admin2', '123123');
COMMIT;

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."admin_id_seq"
OWNED BY "public"."admin"."id";
SELECT setval('"public"."admin_id_seq"', 2, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."customer_id_seq"
OWNED BY "public"."customer"."id";
SELECT setval('"public"."customer_id_seq"', 6, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."customerorder_id_seq"
OWNED BY "public"."customerorder"."id";
SELECT setval('"public"."customerorder_id_seq"', 118, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."event_id_seq"
OWNED BY "public"."event"."id";
SELECT setval('"public"."event_id_seq"', 36, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."planner_id_seq"
OWNED BY "public"."planner"."id";
SELECT setval('"public"."planner_id_seq"', 6, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."ticket_id_seq"
OWNED BY "public"."ticket"."id";
SELECT setval('"public"."ticket_id_seq"', 15, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."venue_id_seq"
OWNED BY "public"."venue"."id";
SELECT setval('"public"."venue_id_seq"', 7, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."webuser_user_id_seq"
OWNED BY "public"."webuser"."user_id";
SELECT setval('"public"."webuser_user_id_seq"', 4, true);

-- ----------------------------
-- Primary Key structure for table admin
-- ----------------------------
ALTER TABLE "public"."admin" ADD CONSTRAINT "admin_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table customer
-- ----------------------------
ALTER TABLE "public"."customer" ADD CONSTRAINT "customer_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table customerorder
-- ----------------------------
ALTER TABLE "public"."customerorder" ADD CONSTRAINT "customerorder_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table event
-- ----------------------------
ALTER TABLE "public"."event" ADD CONSTRAINT "event_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table event_planner_association
-- ----------------------------
ALTER TABLE "public"."event_planner_association" ADD CONSTRAINT "event_planner_association_pkey" PRIMARY KEY ("event_id", "planner_id");

-- ----------------------------
-- Primary Key structure for table planner
-- ----------------------------
ALTER TABLE "public"."planner" ADD CONSTRAINT "planner_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table ticket
-- ----------------------------
ALTER TABLE "public"."ticket" ADD CONSTRAINT "ticket_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table venue
-- ----------------------------
ALTER TABLE "public"."venue" ADD CONSTRAINT "venue_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table webuser
-- ----------------------------
ALTER TABLE "public"."webuser" ADD CONSTRAINT "webuser_pkey" PRIMARY KEY ("user_id");

-- ----------------------------
-- Foreign Keys structure for table customerorder
-- ----------------------------
ALTER TABLE "public"."customerorder" ADD CONSTRAINT "customerorder_customer_id_fkey" FOREIGN KEY ("customer_id") REFERENCES "public"."customer" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "public"."customerorder" ADD CONSTRAINT "customerorder_event_id_fkey" FOREIGN KEY ("event_id") REFERENCES "public"."event" ("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Keys structure for table event
-- ----------------------------
ALTER TABLE "public"."event" ADD CONSTRAINT "event_venue_id_fkey" FOREIGN KEY ("venue_id") REFERENCES "public"."venue" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table event_planner_association
-- ----------------------------
ALTER TABLE "public"."event_planner_association" ADD CONSTRAINT "event_planner_association_event_id_fkey" FOREIGN KEY ("event_id") REFERENCES "public"."event" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "public"."event_planner_association" ADD CONSTRAINT "event_planner_association_planner_id_fkey" FOREIGN KEY ("planner_id") REFERENCES "public"."planner" ("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Keys structure for table ticket
-- ----------------------------
ALTER TABLE "public"."ticket" ADD CONSTRAINT "ticket_event_id_fkey" FOREIGN KEY ("event_id") REFERENCES "public"."event" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
