/*
 Navicat Premium Data Transfer

 Source Server         : 172.23.2.101Admin
 Source Server Type    : PostgreSQL
 Source Server Version : 90614
 Source Host           : 172.23.2.101:5432
 Source Catalog        : gt_gp_database
 Source Schema         : dbcenter

 Target Server Type    : PostgreSQL
 Target Server Version : 90614
 File Encoding         : 65001

 Date: 03/03/2020 10:44:00
*/


-- ----------------------------
-- Table structure for cfdj
-- ----------------------------
DROP TABLE IF EXISTS "dbcenter"."cfdj";
CREATE TABLE "dbcenter"."cfdj" (
  "BSM" int8 NOT NULL DEFAULT NULL,
  "YWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "CFJG" varchar(255) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "CFWH" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "CFQSSJ" date DEFAULT NULL,
  "CFJSSJ" date DEFAULT NULL,
  "CFFW" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "CFYYF" varchar(255) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "DBR" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "DJSJ" date DEFAULT NULL,
  "FJ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "QSZT" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "SHBSM" int4 DEFAULT NULL,
  "YXTBM" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "YXTBSM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "QXDM" int4 DEFAULT NULL,
  "BZ_CFREASON" varchar(255) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_TDESC" varchar(255) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_CF_COUSE" varchar(255) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_CF_ACTOR" varchar(255) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_CF_WH" varchar(255) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_QZ_STATE" varchar(255) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_CF_TYPE" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "REV_" numeric(64,30) DEFAULT NULL,
  "DJJG" varchar(255) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "DJYY" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_CF_ID" numeric(65,30) DEFAULT NULL,
  "BZ_CF_MJ" numeric(65,30) DEFAULT NULL,
  "BZ_CF_JE" numeric(65,30) DEFAULT NULL,
  "BZ_YCF_ZL" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_SW_RQ" date DEFAULT NULL,
  "BZ_LW_LXR" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_LW_LXDH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_YCFQLR_ID" numeric(65,30) DEFAULT NULL,
  "BZ_CF_NF" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_CF_XH" numeric(65,30) DEFAULT NULL,
  "BZ_CF_BM" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_JF_NF" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_JF_XH" numeric(65,30) DEFAULT NULL,
  "BZ_JF_BM" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_YCF_PROJECTID" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_YCF_ZDID" numeric(65,30) DEFAULT NULL,
  "BZ_YCF_BZBH" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_YCF_JFPROJECTID" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_ZDQLR_ID" numeric(65,30) DEFAULT NULL,
  "BZ_CF_ZT" numeric(65,30) DEFAULT NULL,
  "YCFZL" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "CFWJ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_CFWJ" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_TYPH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_TYPHZX" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "GXSJ" date DEFAULT NULL,
  "BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "OINSID" numeric(65,30) DEFAULT NULL,
  "BZ_YWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "CFLX" numeric(65,30) DEFAULT NULL,
  "BZ_OINSID" numeric(65,30) DEFAULT NULL,
  "_source_" varchar(5) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL,
  "delflag" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Table structure for cfdj_bhgx
-- ----------------------------
DROP TABLE IF EXISTS "dbcenter"."cfdj_bhgx";
CREATE TABLE "dbcenter"."cfdj_bhgx" (
  "BSM" int8 NOT NULL DEFAULT NULL,
  "YWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "YCFDJBSM" int8 DEFAULT NULL,
  "CFDJBSM" int8 DEFAULT NULL,
  "QXDM" int4 DEFAULT NULL,
  "BZ_NEWCF_NM" numeric(65,30) DEFAULT NULL,
  "BZ_OLDCF_NM" numeric(65,30) DEFAULT NULL,
  "REV_" numeric(65,30) DEFAULT NULL,
  "GXSJ" date DEFAULT NULL,
  "BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "YXTBM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "_source_" varchar(5) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL,
  "delflag" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Table structure for cfdj_dygx
-- ----------------------------
DROP TABLE IF EXISTS "dbcenter"."cfdj_dygx";
CREATE TABLE "dbcenter"."cfdj_dygx" (
  "BSM" int8 NOT NULL DEFAULT NULL,
  "YWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "DYBSM" int8 DEFAULT NULL,
  "BDCDYLX" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "CFDJBSM" int8 DEFAULT NULL,
  "CFDJZXBSM" int8 DEFAULT NULL,
  "DYBM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "QLBM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "QLBSM" int8 DEFAULT NULL,
  "BDCDYH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "CQZH" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "ZL" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "QXDM" int4 DEFAULT NULL,
  "YXTBSM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_FH_NM" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_FW_NM" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "YXTBM" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "REV_" numeric(65,30) DEFAULT NULL,
  "BZ_ZDQLR_ID" numeric(65,30) DEFAULT NULL,
  "BZ_CF_ID" numeric(65,30) DEFAULT NULL,
  "CFSXH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "CFLX" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "GXSJ" date DEFAULT NULL,
  "BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_FWBM" numeric(65,30) DEFAULT NULL,
  "YJFBSM" int8 DEFAULT NULL,
  "BZ_OINSID" numeric(65,30) DEFAULT NULL,
  "_source_" varchar(5) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL,
  "delflag" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Table structure for cfdj_zx
-- ----------------------------
DROP TABLE IF EXISTS "dbcenter"."cfdj_zx";
CREATE TABLE "dbcenter"."cfdj_zx" (
  "BSM" int8 NOT NULL DEFAULT NULL,
  "YWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "CFDJBSM" int8 DEFAULT NULL,
  "JFJG" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "JFWH" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "DJYY" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "DBR" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "DJSJ" date DEFAULT NULL,
  "FJ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "QSZT" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "SHBSM" int8 DEFAULT NULL,
  "YXTBM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "YXTBSM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "QXDM" int4 DEFAULT NULL,
  "BZ_QZ_STA" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_TDESC" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_JF_COU" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_JF_WH" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "REV_" numeric(65,30) DEFAULT NULL,
  "BZ_CF_ID" numeric(65,30) DEFAULT NULL,
  "JFWJ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_JFWJ" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "GXSJ" date DEFAULT NULL,
  "BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "OINSID" numeric(65,30) DEFAULT NULL,
  "BZ_OINSID" numeric(65,30) DEFAULT NULL,
  "_source_" varchar(5) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL,
  "delflag" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Table structure for cfdj_zxr
-- ----------------------------
DROP TABLE IF EXISTS "dbcenter"."cfdj_zxr";
CREATE TABLE "dbcenter"."cfdj_zxr" (
  "BSM" int8 NOT NULL DEFAULT NULL,
  "CFDJBSM" int8 DEFAULT NULL,
  "XM" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "GZZH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZXGWZH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "LXDH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DZYX" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QXDM" int8 DEFAULT NULL,
  "YXTBM" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTBSM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "REV_" numeric(65,30) DEFAULT NULL::numeric,
  "YWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "GXSJ" date DEFAULT NULL,
  "BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "_source_" varchar(5) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL::character varying,
  "delflag" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Table structure for djfz_cqzs
-- ----------------------------
DROP TABLE IF EXISTS "dbcenter"."djfz_cqzs";
CREATE TABLE "dbcenter"."djfz_cqzs" (
  "bsm" int8 NOT NULL DEFAULT NULL,
  "ywh" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "qlbsm" int8 DEFAULT NULL,
  "qlbm" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "bdcdyh" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "bdcqzh" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "qlr" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "gyqk" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "zl" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "qllx" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "qlxz" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "qlxz1" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "qlxz2" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "yt" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "yt1" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "yt2" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "mj" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "mj1" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "mj2" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "syqx" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "qlqtzk" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "fj" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "fzjc" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "fzdq" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "fznf" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "fzbm" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "fzxh" int8 DEFAULT NULL,
  "fzgbh" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "szr" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "szsj" date DEFAULT NULL,
  "szrsgzh" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "szrbsm" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "szrdnbh" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "fzr" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "fzsj" date DEFAULT NULL,
  "fzrsgzh" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "fzrbsm" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "lzr" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "lzrzjzl" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "lzrzjh" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "lzrdh" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "lzrdz" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "lzryb" varchar(6) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "lzsj" date DEFAULT NULL,
  "fzjg" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "qxdm" int4 DEFAULT NULL,
  "yxtbsm" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "yxtbm" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "bz_append" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "bz_tdesc" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "rev_" numeric(65,30) DEFAULT NULL::numeric,
  "sbh" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "bz_zdqlr_id" int4 DEFAULT NULL,
  "bz_yx_bz" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "bz_add1" date DEFAULT NULL,
  "bz_zs_qx" date DEFAULT NULL,
  "zsms" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "bz_tempcerti" int4 DEFAULT NULL,
  "bz_yzdqlrid" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "yxtbsm1" numeric(65,30) DEFAULT NULL::numeric,
  "bz_ghkh" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "bz_tdsy_qx" numeric(3) DEFAULT NULL::numeric,
  "qszt" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "zslx" numeric(65,30) DEFAULT NULL::numeric,
  "bz_qlr_id" numeric(65,30) DEFAULT NULL::numeric,
  "bz_pgy_ratio" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "bz_gxsj" date DEFAULT NULL,
  "gxsj" date DEFAULT NULL,
  "bz" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "bz_fwbm" numeric(65,30) DEFAULT NULL::numeric,
  "bz_zd_id" numeric(65,30) DEFAULT NULL::numeric,
  "bz_xzdqlr_id" numeric(65,30) DEFAULT NULL::numeric,
  "bz_zdid" numeric(65,30) DEFAULT NULL::numeric,
  "bz_lzrzjzlmc" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ghsj" date DEFAULT NULL,
  "dycs" int8 DEFAULT NULL,
  "bz_oinsid" numeric(65,30) DEFAULT NULL::numeric,
  "bz_sm" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "bz_bdcqzh" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "sj_ly" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "_source_" varchar(5) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL::character varying,
  "delflag" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Table structure for djfz_cqzs_ls
-- ----------------------------
DROP TABLE IF EXISTS "dbcenter"."djfz_cqzs_ls";
CREATE TABLE "dbcenter"."djfz_cqzs_ls" (
  "BSM" int8 NOT NULL DEFAULT NULL,
  "YWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLBSM" int8 DEFAULT NULL,
  "QLBM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BDCDYH" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BDCQZH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLR" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "GYQK" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "ZL" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "QLLX" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLXZ" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLXZ1" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLXZ2" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YT" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YT1" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YT2" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "MJ" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "MJ1" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "MJ2" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "SYQX" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLQTZK" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "FJ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "FZJC" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "FZDQ" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "FZNF" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "FZBM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "FZXH" int8 DEFAULT NULL,
  "FZGBH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "SZR" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "SZSJ" date DEFAULT NULL,
  "SZRSGZH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "SZRBSM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "SZRDNBH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "FZR" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "FZSJ" date DEFAULT NULL,
  "FZRSGZH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "FZRBSM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "LZR" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "LZRZJZL" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "LZRZJH" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "LZRDH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "LZRDZ" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "LZRYB" varchar(6) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "LZSJ" date DEFAULT NULL,
  "FZJG" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QXDM" int4 DEFAULT NULL,
  "YXTBSM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTBM" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_APPEND" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_TDESC" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "REV_" numeric(65,30) DEFAULT NULL::numeric,
  "SBH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_ZDQLR_ID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_YX_BZ" varchar(15) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_TEMPCERTI" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_ADD1" date DEFAULT NULL,
  "BZ_YZDQLRID" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZSLX" numeric(65,30) DEFAULT NULL::numeric,
  "ZSMS" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QSZT" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_TDSY_QX" int4 DEFAULT NULL,
  "BZ_QLR_ID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_ZS_QX" date DEFAULT NULL,
  "BZ_PGY_RATIO" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_GXSJ" date DEFAULT NULL,
  "GXSJ" date DEFAULT NULL,
  "BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_FWBM" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_ZD_ID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_ZDID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_LZRZJZLMC" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_OINSID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_BDCQZH" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "SJ_LY" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "_source_" varchar(5) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL::character varying,
  "delflag" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Table structure for djfz_djzm
-- ----------------------------
DROP TABLE IF EXISTS "dbcenter"."djfz_djzm";
CREATE TABLE "dbcenter"."djfz_djzm" (
  "BSM" int8 NOT NULL DEFAULT NULL,
  "YWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BDCDYH" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BDCDJZMH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DJZMZL" varchar(4) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLBSM" int8 DEFAULT NULL,
  "QLBM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZMQLHSX" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLR" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "YWR" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "ZL" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "QT" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "FJ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "FZJC" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "FZDQ" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "FZNF" int4 DEFAULT NULL,
  "FZBM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "FZXH" int8 DEFAULT NULL,
  "FZGBH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "SZR" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "SZSJ" date DEFAULT NULL,
  "SZRSGZH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "SZRBSM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "SZRDNBH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "FZR" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "FZSJ" date DEFAULT NULL,
  "FZRSGZH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "FZRBSM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "LZR" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "LZRZJZL" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "LZRZJH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "LZRDH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "LZRDZ" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "LZRYB" varchar(6) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "LZSJ" date DEFAULT NULL,
  "QSZT" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "FZJG" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QXDM" int4 DEFAULT NULL,
  "YXTBSM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTBM" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_YGTYPE" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_TDESC" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_FJ_DESC" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_QL_TYPE" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_APPEND" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "REV_" numeric(65,30) DEFAULT NULL::numeric,
  "SBH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_DY_ID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_QLR_ID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_DYR_ID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_XMBSM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_DY_NM" numeric(65,30) DEFAULT NULL::numeric,
  "GXSJ" date DEFAULT NULL,
  "BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_FCZ_NM" numeric(65,30) DEFAULT NULL::numeric,
  "JZMJ" numeric(13,3) DEFAULT NULL::numeric,
  "BZ_LZRZJZLMC" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DYCS" int8 DEFAULT NULL,
  "BZ_OINSID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_SZSJ" varchar(30) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_FZNF" varchar(30) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_BDCDJZMH" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "_source_" varchar(5) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL::character varying,
  "delflag" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Table structure for dyaq
-- ----------------------------
DROP TABLE IF EXISTS "dbcenter"."dyaq";
CREATE TABLE "dbcenter"."dyaq" (
  "BSM" int8 NOT NULL DEFAULT NULL,
  "YWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DYBDCLX" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DYFS" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZJJZWZL" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZJJZWDYFW" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BDBZQSE" numeric(15,4) DEFAULT NULL::numeric,
  "ZGZQSE" numeric(15,4) DEFAULT NULL::numeric,
  "QLQSSJ" date DEFAULT NULL,
  "QLJSSJ" date DEFAULT NULL,
  "QLQX" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZGZQQDSSHSE" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DJYY" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "DBR" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DJSJ" date DEFAULT NULL,
  "DJZMH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DJZMBSM" int8 DEFAULT NULL,
  "FJ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "DYSXH" int4 DEFAULT NULL,
  "QSZT" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "SHBSM" int8 DEFAULT NULL,
  "YXTBM" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTBSM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QXDM" int4 DEFAULT NULL,
  "BZ_JS_MARK" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_SIGN_DATE" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_CSF" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_DKAGG_ID" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_TDESC" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_DY_AREA" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_DYTD_AREA" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_EST_PRICE" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_EST_DEPT" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_FZ_MARK" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_DY_YJ" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_QL_VALUE" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "REV_" numeric(65,30) DEFAULT NULL::numeric,
  "DJJG" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_DY_QLSX" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_DY_CXQX" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_DYZDBH" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_ZX_XH" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_ZX_BM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_ZX_NF" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_TS_BM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_DY_MJ" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_DY_ZCZE" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "HTBH" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_DY_ID" numeric(65,30) DEFAULT NULL::numeric,
  "DYSX" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_GXSJ" date DEFAULT NULL,
  "GXSJ" date DEFAULT NULL,
  "BZ_BDCDYH" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_QLR_ID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_DYR_ID" numeric(65,30) DEFAULT NULL::numeric,
  "OINSID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_OINSID" numeric(65,30) DEFAULT NULL::numeric,
  "DBFW" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_QLQSSJ" varchar(30) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_QLJSSJ" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_DJSJ" varchar(30) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "HBLX" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "_source_" varchar(5) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL::character varying,
  "delflag" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Table structure for dyaq_bhgx
-- ----------------------------
DROP TABLE IF EXISTS "dbcenter"."dyaq_bhgx";
CREATE TABLE "dbcenter"."dyaq_bhgx" (
  "BSM" int8 NOT NULL DEFAULT NULL,
  "YWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YQLBSM" int8 DEFAULT NULL,
  "QLBSM" int8 DEFAULT NULL,
  "QXDM" int4 DEFAULT NULL,
  "REV_" numeric(65,30) DEFAULT NULL::numeric,
  "GXSJ" date DEFAULT NULL,
  "BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "YXTBM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "_source_" varchar(5) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL::character varying,
  "delflag" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Table structure for dyaq_dygx
-- ----------------------------
DROP TABLE IF EXISTS "dbcenter"."dyaq_dygx";
CREATE TABLE "dbcenter"."dyaq_dygx" (
  "BSM" int8 NOT NULL DEFAULT NULL,
  "YWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DYBSM" int8 DEFAULT NULL,
  "BDCDYLX" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DYAQBSM" int8 DEFAULT NULL,
  "DYAQZXBSM" int8 DEFAULT NULL,
  "DYBM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLBM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLBSM" int8 DEFAULT NULL,
  "BDCDYH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "CQZH" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "ZL" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "QXDM" int8 DEFAULT NULL,
  "YXTBSM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_FW_NM" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_FH_NM" numeric(65,30) DEFAULT NULL::numeric,
  "YXTBM" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "REV_" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_DY_MJ" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_ZC_ZE" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_DY_JE" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_YZDQLRID" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_ZGDY_JE" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_DY_ID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_DYZS_ID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_ZDQLR_ID" numeric(65,30) DEFAULT NULL::numeric,
  "DYSXH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DYSX" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "GXSJ" date DEFAULT NULL,
  "BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_FCZ_NM" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_YDY_NM" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_OINSID" numeric(65,30) DEFAULT NULL::numeric,
  "ZQSE" numeric(12,4) DEFAULT NULL::numeric,
  "DYAWJZ" numeric(12,4) DEFAULT NULL::numeric,
  "BZ_TDZH" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_DH" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "_source_" varchar(5) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL::character varying,
  "delflag" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Table structure for dyaq_zx
-- ----------------------------
DROP TABLE IF EXISTS "dbcenter"."dyaq_zx";
CREATE TABLE "dbcenter"."dyaq_zx" (
  "BSM" int8 NOT NULL DEFAULT NULL,
  "YWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DYAQBSM" int8 DEFAULT NULL,
  "DJYY" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "DJSJ" date DEFAULT NULL,
  "DBR" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "FJ" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QSZT" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "SHBSM" int8 DEFAULT NULL,
  "YXTBM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTBSM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QXDM" int8 DEFAULT NULL,
  "BZ_ZS_NM" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_TDESC" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "REV_" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_DY_ID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_DJZMBSM" numeric(65,30) DEFAULT NULL::numeric,
  "GXSJ" date DEFAULT NULL,
  "BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_FWBM" numeric(65,30) DEFAULT NULL::numeric,
  "OINSID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_DYR_ID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_QLR_ID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_OINSID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_SONAME" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "_source_" varchar(5) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL::character varying,
  "delflag" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Table structure for fdcq
-- ----------------------------
DROP TABLE IF EXISTS "dbcenter"."fdcq";
CREATE TABLE "dbcenter"."fdcq" (
  "BSM" int8 NOT NULL DEFAULT NULL,
  "YWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLLX" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DJLX" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTDJLXMC" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DJYY" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "FDCJYJG" numeric(15,4) DEFAULT NULL::numeric,
  "BDCQZH" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "DBR" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DJSJ" date DEFAULT NULL,
  "FJ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "QDFS" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "FKFS" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "GFHTBH" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "QYRQ" date DEFAULT NULL,
  "JYLX" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QSZT" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZXYWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZXSJ" date DEFAULT NULL,
  "ZXDBR" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZXYY" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "ZXFJ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "SHBSM" int8 DEFAULT NULL,
  "ZXSHBSM" int8 DEFAULT NULL,
  "SJGJZT" int8 DEFAULT NULL,
  "YXTBM" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTBSM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QXDM" int8 DEFAULT NULL,
  "BZ_FCZY_TYPE" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_FCZY_TDESC" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "REV_" numeric(65,30) DEFAULT NULL::numeric,
  "DJJG" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_GXSJ" date DEFAULT NULL,
  "TDSYQR" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "GXSJ" date DEFAULT NULL,
  "BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_FWBM" numeric(65,30) DEFAULT NULL::numeric,
  "YXTQDFS" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "OINSID" numeric(65,30) DEFAULT NULL::numeric,
  "YFWCB" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YFWXZ" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_QDFS" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_OINSID" numeric(65,30) DEFAULT NULL::numeric,
  "QDFS_GISQ" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_YXTQDFS" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DSYWLX" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YQZSJ" date DEFAULT NULL,
  "_source_" varchar(5) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL::character varying,
  "delflag" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Table structure for fdcq_bhgx
-- ----------------------------
DROP TABLE IF EXISTS "dbcenter"."fdcq_bhgx";
CREATE TABLE "dbcenter"."fdcq_bhgx" (
  "BSM" int8 NOT NULL DEFAULT NULL,
  "YWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLBSM" int8 DEFAULT NULL,
  "YQLBSM" int8 DEFAULT NULL,
  "BHSJ" date DEFAULT NULL,
  "QXDM" int4 DEFAULT NULL,
  "BZ_FCZ_NM" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_LSFCZ_NM" numeric(65,30) DEFAULT NULL::numeric,
  "REV_" numeric(65,30) DEFAULT NULL::numeric,
  "YXTBSM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTBM" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "GXSJ" date DEFAULT NULL,
  "BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_OWNERID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_OLDOWNERID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_OINSID" numeric(65,30) DEFAULT NULL::numeric,
  "_source_" varchar(5) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL::character varying,
  "delflag" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Table structure for fdcq_dygx
-- ----------------------------
DROP TABLE IF EXISTS "dbcenter"."fdcq_dygx";
CREATE TABLE "dbcenter"."fdcq_dygx" (
  "BSM" int8 NOT NULL DEFAULT NULL,
  "YWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLBSM" int8 DEFAULT NULL,
  "DYBSM" int8 DEFAULT NULL,
  "XMNDDY" int4 DEFAULT NULL,
  "ZFBSM" int8 DEFAULT NULL,
  "QXDM" int4 DEFAULT NULL,
  "REV_" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_ZL" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_YT" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "GXSJ" date DEFAULT NULL,
  "BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_SCZJMJ" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_FWBM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTBSM" numeric(65,30) DEFAULT NULL::numeric,
  "YXTBM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_FW_NM" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_OINSID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_STATUS" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "_source_" varchar(5) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL::character varying,
  "delflag" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Table structure for fdcq_ls
-- ----------------------------
DROP TABLE IF EXISTS "dbcenter"."fdcq_ls";
CREATE TABLE "dbcenter"."fdcq_ls" (
  "BSM" int8 NOT NULL DEFAULT NULL,
  "YWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLLX" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DJLX" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTDJLXMC" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DJYY" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "FDCJYJG" numeric(15,4) DEFAULT NULL::numeric,
  "BDCQZH" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "DBR" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DJSJ" date DEFAULT NULL,
  "FJ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "QDFS" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "FKFS" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "GFHTBH" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "QYRQ" date DEFAULT NULL,
  "JYLX" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QSZT" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZXYWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZXSJ" date DEFAULT NULL,
  "ZXDBR" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZXYY" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "ZXFJ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "SHBSM" int8 DEFAULT NULL,
  "ZXSHBSM" int8 DEFAULT NULL,
  "SJGJZT" int4 DEFAULT NULL,
  "YXTBM" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTBSM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QXDM" int4 DEFAULT NULL,
  "BZ_ZX_TDESC" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_FCZY_TDESC" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_FCZY_TYPE" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "REV_" numeric(65,30) DEFAULT NULL::numeric,
  "DJJG" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_GXSJ" date DEFAULT NULL,
  "TDSYQR" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "GXSJ" date DEFAULT NULL,
  "BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_FWBM" numeric(65,30) DEFAULT NULL::numeric,
  "YXTQDFS" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "OINSID" numeric(65,30) DEFAULT NULL::numeric,
  "YFWCB" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YFWXZ" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_OINSID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_ZXOINSID" numeric(65,30) DEFAULT NULL::numeric,
  "QDFS_GISQ" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_ZX_OINSID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_YXTQDFS" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_QDFS" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DSYWLX" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YQZSJ" date DEFAULT NULL,
  "_source_" varchar(5) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL::character varying,
  "delflag" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Table structure for h
-- ----------------------------
DROP TABLE IF EXISTS "dbcenter"."h";
CREATE TABLE "dbcenter"."h" (
  "BSM" int8 NOT NULL DEFAULT NULL,
  "ZDSHIYQBSM" int8 DEFAULT NULL,
  "ZRZBSM" int8 DEFAULT NULL,
  "LJZBSM" int8 DEFAULT NULL,
  "CBSM" int8 DEFAULT NULL,
  "ZRZH" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "LJZH" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "CH" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZL" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "SJCS" numeric(65,30) DEFAULT NULL::numeric,
  "HH" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "SHBW" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "HX" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "HXJG" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "FWJG" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "FWYT1" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "FWYT2" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "FWYT3" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTFWYTMC1" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTFWYTMC2" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTFWYTMC3" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "GHYT" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTGHYTMC" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YCJZMJ" numeric(15,2) DEFAULT NULL::numeric,
  "YCTNJZMJ" numeric(15,2) DEFAULT NULL::numeric,
  "YCFTJZMJ" numeric(15,2) DEFAULT NULL::numeric,
  "YCDXBFJZMJ" numeric(15,2) DEFAULT NULL::numeric,
  "YCQTJZMJ" numeric(15,2) DEFAULT NULL::numeric,
  "YCFTXS" numeric(15,6) DEFAULT NULL::numeric,
  "SCJZMJ" numeric(15,3) DEFAULT NULL::numeric,
  "SCTNJZMJ" numeric(15,3) DEFAULT NULL::numeric,
  "SCFTJZMJ" numeric(15,3) DEFAULT NULL::numeric,
  "SCDXBFJZMJ" numeric(15,3) DEFAULT NULL::numeric,
  "SCQTJZMJ" numeric(15,3) DEFAULT NULL::numeric,
  "SCFTXS" numeric(15,6) DEFAULT NULL::numeric,
  "GYTDMJ" numeric(15,3) DEFAULT NULL::numeric,
  "FTTDMJ" numeric(15,3) DEFAULT NULL::numeric,
  "DYTDMJ" numeric(15,3) DEFAULT NULL::numeric,
  "TDSYQMJ" numeric(15,3) DEFAULT NULL::numeric,
  "FWLX" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTFWLXMC" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "FWXZ" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTFWXZMC" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "SZC" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZCS" int4 DEFAULT NULL,
  "JGSJ" date DEFAULT NULL,
  "FWJS" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZDDM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BDCDYH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZTS" int4 DEFAULT NULL,
  "XMMC" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DYH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "FJSXH" int4 DEFAULT NULL,
  "FWLB" int4 DEFAULT NULL,
  "FWDH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "FWLDH" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "FWCB" char(10) COLLATE "pg_catalog"."default" DEFAULT NULL::bpchar,
  "JCNF" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "CQXZ" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "ZFBSM" int8 DEFAULT NULL,
  "YXTBM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTBSM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DCBSM" int8 DEFAULT NULL,
  "KFXMXXBSM" int8 DEFAULT NULL,
  "QXDM" int4 DEFAULT NULL,
  "REV_" numeric(65,30) DEFAULT NULL::numeric,
  "MYCS" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DCYWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "TDSYQSSJ" date DEFAULT NULL,
  "TDSYJSSJ" date DEFAULT NULL,
  "TDYT" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "TDQLXZ" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZDMJ" numeric(15,3) DEFAULT NULL::numeric,
  "BZ_GXSJ" date DEFAULT NULL,
  "BZ_ZFBDCDYH" varchar(30) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YWH" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_ZD_ID" numeric(65,30) DEFAULT NULL::numeric,
  "DCZDSHIYQBSM" int8 DEFAULT NULL,
  "FFLB" int4 DEFAULT NULL,
  "GXSJ" date DEFAULT NULL,
  "TDYTMC" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_FW_NM" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_ZRZBSM" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_FFLB" numeric(65,30) DEFAULT NULL::numeric,
  "PKBSM" int4 DEFAULT NULL,
  "YXTBSM1" numeric(65,30) DEFAULT NULL::numeric,
  "HROOMID" int4 DEFAULT NULL,
  "YXTQDFS" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YFWCB" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YFWJG" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_PROOMID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_CHROOMID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_ROOMID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_HOUSEID" numeric(65,30) DEFAULT NULL::numeric,
  "FWBM" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "TDDJ" char(2) COLLATE "pg_catalog"."default" DEFAULT NULL::bpchar,
  "BZ_FWID" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_FWCODE" varchar(30) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "SFJSMJ" int4 DEFAULT NULL,
  "BZ_FWJG" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "_source_" varchar(5) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL::character varying,
  "delflag" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Table structure for h_bhgx
-- ----------------------------
DROP TABLE IF EXISTS "dbcenter"."h_bhgx";
CREATE TABLE "dbcenter"."h_bhgx" (
  "BSM" int8 NOT NULL DEFAULT NULL,
  "YWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YDYBSM" int8 DEFAULT NULL,
  "XDYBSM" int8 DEFAULT NULL,
  "BHSJ" date DEFAULT NULL,
  "QXDM" int4 DEFAULT NULL,
  "REV_" numeric(65,30) DEFAULT NULL::numeric,
  "GXSJ" date DEFAULT NULL,
  "BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "YXTBM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "_source_" varchar(5) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL::character varying,
  "delflag" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Table structure for h_ls
-- ----------------------------
DROP TABLE IF EXISTS "dbcenter"."h_ls";
CREATE TABLE "dbcenter"."h_ls" (
  "BSM" int8 NOT NULL DEFAULT NULL,
  "ZDSHIYQBSM" int8 DEFAULT NULL,
  "ZRZBSM" int8 DEFAULT NULL,
  "LJZBSM" int8 DEFAULT NULL,
  "CBSM" int8 DEFAULT NULL,
  "ZRZH" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "LJZH" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "CH" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZL" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "SJCS" numeric(65,30) DEFAULT NULL::numeric,
  "HH" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "SHBW" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "HX" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "HXJG" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "FWJG" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "FWYT1" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "FWYT2" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "FWYT3" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTFWYTMC1" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTFWYTMC2" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTFWYTMC3" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "GHYT" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTGHYTMC" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YCJZMJ" numeric(15,2) DEFAULT NULL::numeric,
  "YCTNJZMJ" numeric(15,2) DEFAULT NULL::numeric,
  "YCFTJZMJ" numeric(15,2) DEFAULT NULL::numeric,
  "YCDXBFJZMJ" numeric(15,2) DEFAULT NULL::numeric,
  "YCQTJZMJ" numeric(15,2) DEFAULT NULL::numeric,
  "YCFTXS" numeric(15,6) DEFAULT NULL::numeric,
  "SCJZMJ" numeric(15,3) DEFAULT NULL::numeric,
  "SCTNJZMJ" numeric(15,3) DEFAULT NULL::numeric,
  "SCFTJZMJ" numeric(15,3) DEFAULT NULL::numeric,
  "SCDXBFJZMJ" numeric(15,3) DEFAULT NULL::numeric,
  "SCQTJZMJ" numeric(15,3) DEFAULT NULL::numeric,
  "SCFTXS" numeric(15,6) DEFAULT NULL::numeric,
  "GYTDMJ" numeric(15,3) DEFAULT NULL::numeric,
  "FTTDMJ" numeric(15,3) DEFAULT NULL::numeric,
  "DYTDMJ" numeric(15,3) DEFAULT NULL::numeric,
  "TDSYQMJ" numeric(15,3) DEFAULT NULL::numeric,
  "FWLX" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTFWLXMC" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "FWXZ" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTFWXZMC" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "SZC" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZCS" int4 DEFAULT NULL,
  "JGSJ" date DEFAULT NULL,
  "FWJS" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZDDM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BDCDYH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZTS" int4 DEFAULT NULL,
  "XMMC" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DYH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "FJSXH" int4 DEFAULT NULL,
  "FWLB" int4 DEFAULT NULL,
  "FWDH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "FWLDH" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "FWCB" char(10) COLLATE "pg_catalog"."default" DEFAULT NULL::bpchar,
  "JCNF" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "CQXZ" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "ZFBSM" int8 DEFAULT NULL,
  "YXTBM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTBSM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DCBSM" int8 DEFAULT NULL,
  "KFXMXXBSM" int8 DEFAULT NULL,
  "QXDM" int4 DEFAULT NULL,
  "REV_" numeric(65,30) DEFAULT NULL::numeric,
  "MYCS" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DCYWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "TDSYQSSJ" date DEFAULT NULL,
  "TDSYJSSJ" date DEFAULT NULL,
  "TDYT" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "TDQLXZ" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZDMJ" numeric(15,3) DEFAULT NULL::numeric,
  "BZ_GXSJ" date DEFAULT NULL,
  "BZ_ZFBDCDYH" varchar(30) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YWH" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_ZD_ID" numeric(65,30) DEFAULT NULL::numeric,
  "DCZDSHIYQBSM" int8 DEFAULT NULL,
  "FFLB" int4 DEFAULT NULL,
  "GXSJ" date DEFAULT NULL,
  "TDYTMC" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_FW_NM" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_ZRZBSM" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_FFLB" numeric(65,30) DEFAULT NULL::numeric,
  "PKBSM" int4 DEFAULT NULL,
  "YXTBSM1" numeric(65,30) DEFAULT NULL::numeric,
  "HROOMID" int4 DEFAULT NULL,
  "YXTQDFS" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YFWCB" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YFWJG" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_PROOMID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_CHROOMID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_ROOMID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_HOUSEID" numeric(65,30) DEFAULT NULL::numeric,
  "FWBM" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "TDDJ" char(2) COLLATE "pg_catalog"."default" DEFAULT NULL::bpchar,
  "BZ_FWID" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_FWCODE" varchar(30) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "SFJSMJ" int4 DEFAULT NULL,
  "BZ_FWJG" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "_source_" varchar(5) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL::character varying,
  "delflag" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Table structure for jsydsyq
-- ----------------------------
DROP TABLE IF EXISTS "dbcenter"."jsydsyq";
CREATE TABLE "dbcenter"."jsydsyq" (
  "BSM" int8 NOT NULL DEFAULT NULL,
  "YSDM" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLLX" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DJLX" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DJYY" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "SYQMJ" numeric(15,2) DEFAULT NULL::numeric,
  "SYQQSSJ" date DEFAULT NULL,
  "SYQJSSJ" date DEFAULT NULL,
  "QDJG" numeric(15,4) DEFAULT NULL::numeric,
  "BDCQZH" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "DJJG" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DBR" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DJSJ" date DEFAULT NULL,
  "FJ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "QSZT" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "MJDW" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZXYWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZXSJ" date DEFAULT NULL,
  "ZXDBR" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZXYY" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "ZXFJ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "SHBSM" int8 DEFAULT NULL,
  "ZXSHBSM" int8 DEFAULT NULL,
  "SJGJZT" int4 DEFAULT NULL,
  "SFCD" int4 DEFAULT NULL,
  "YXTBM" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTBSM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QXDM" int4 DEFAULT NULL,
  "REV_" numeric(65,30) DEFAULT NULL::numeric,
  "DYTDMJ" numeric(18,2) DEFAULT NULL::numeric,
  "FTTDMJ" numeric(18,2) DEFAULT NULL::numeric,
  "GYTDMJ" numeric(18,2) DEFAULT NULL::numeric,
  "JZMJ" numeric(18,2) DEFAULT NULL::numeric,
  "BZ_BD_DJ" numeric(22,6) DEFAULT NULL::numeric,
  "BZ_ADD1" date DEFAULT NULL,
  "BZ_TDSY_QX" int4 DEFAULT NULL,
  "QLXZ" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_JZ_LX" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_JZW_QS" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_QYSM" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "QLRZDBH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_QS_LYZM" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "QLRZL" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_SJ_BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_LR_RY" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_FZD_DM" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_ZDQLRGHKH" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "SJYT" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "PZYT" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "SJYTMC" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "PZYTMC" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_FW_SYQR" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_FW_CQZH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_YQLRID" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_YZDID" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_YZDQLRID" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_YZDH" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTBSM1" numeric(65,30) DEFAULT NULL::numeric,
  "DJLX_MJBAK" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTBSM_NUMBER" numeric(65,30) DEFAULT NULL::numeric,
  "QLXZ_MJBAK" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_GXSJ" date DEFAULT NULL,
  "GXSJ" date DEFAULT NULL,
  "BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "QLXZMC" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DJLXMC" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_DJNR" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_DJLXMC" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "TDSYQX" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_ZDID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_ZD_ID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_ACCESS_ID" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_DANGHID" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "_source_" varchar(5) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL::character varying,
  "delflag" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Table structure for jsydsyq_bhgx
-- ----------------------------
DROP TABLE IF EXISTS "dbcenter"."jsydsyq_bhgx";
CREATE TABLE "dbcenter"."jsydsyq_bhgx" (
  "BSM" int8 NOT NULL DEFAULT NULL,
  "YWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLBSM" int8 DEFAULT NULL,
  "YQLBSM" int8 DEFAULT NULL,
  "BHSJ" date DEFAULT NULL,
  "QXDM" int4 DEFAULT NULL,
  "REV_" numeric(65,30) DEFAULT NULL::numeric,
  "DYBSM" int8 DEFAULT NULL,
  "BZ_LZDQLR_ID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_XZDQLR_ID" numeric(65,30) DEFAULT NULL::numeric,
  "YXTBM" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTBSM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "GXSJ" date DEFAULT NULL,
  "BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "_source_" varchar(5) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL::character varying,
  "delflag" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Table structure for jsydsyq_dygx
-- ----------------------------
DROP TABLE IF EXISTS "dbcenter"."jsydsyq_dygx";
CREATE TABLE "dbcenter"."jsydsyq_dygx" (
  "BSM" int8 NOT NULL DEFAULT NULL,
  "YWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLBSM" int8 DEFAULT NULL,
  "DYBSM" int8 DEFAULT NULL,
  "QXDM" int4 DEFAULT NULL,
  "REV_" numeric(65,30) DEFAULT NULL::numeric,
  "DB_ZDID" numeric(65,30) DEFAULT NULL::numeric,
  "DB_ZDQLR_ID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_ZD_ID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_ZDQLR_ID" numeric(65,30) DEFAULT NULL::numeric,
  "GXSJ" date DEFAULT NULL,
  "BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "YXTBM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTBSM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DYBM" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_YSHZD_ID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_XZDQLR_ID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_QLBSM" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_FH_ZDID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_BDCDYH" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "_source_" varchar(5) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL::character varying,
  "delflag" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Table structure for jsydsyq_ls
-- ----------------------------
DROP TABLE IF EXISTS "dbcenter"."jsydsyq_ls";
CREATE TABLE "dbcenter"."jsydsyq_ls" (
  "BSM" int8 NOT NULL DEFAULT NULL,
  "YSDM" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLLX" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DJLX" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DJYY" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "SYQMJ" numeric(15,2) DEFAULT NULL::numeric,
  "SYQQSSJ" date DEFAULT NULL,
  "SYQJSSJ" date DEFAULT NULL,
  "QDJG" numeric(15,4) DEFAULT NULL::numeric,
  "BDCQZH" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "DJJG" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DBR" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DJSJ" date DEFAULT NULL,
  "FJ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "QSZT" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "MJDW" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZXYWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZXSJ" date DEFAULT NULL,
  "ZXDBR" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZXYY" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "ZXFJ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "SHBSM" int8 DEFAULT NULL,
  "ZXSHBSM" int8 DEFAULT NULL,
  "SJGJZT" int4 DEFAULT NULL,
  "SFCD" int4 DEFAULT NULL,
  "YXTBM" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTBSM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QXDM" int4 DEFAULT NULL,
  "REV_" numeric(65,30) DEFAULT NULL::numeric,
  "DYTDMJ" numeric(18,2) DEFAULT NULL::numeric,
  "FTTDMJ" numeric(18,2) DEFAULT NULL::numeric,
  "GYTDMJ" numeric(18,2) DEFAULT NULL::numeric,
  "JZMJ" numeric(18,2) DEFAULT NULL::numeric,
  "BZ_BD_DJ" numeric(22,6) DEFAULT NULL::numeric,
  "BZ_ADD1" date DEFAULT NULL,
  "BZ_TDSY_QX" int4 DEFAULT NULL,
  "QLXZ" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_JZ_LX" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_JZW_QS" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_QYSM" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "QLRZDBH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_QS_LYZM" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "QLRZL" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_SJ_BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_LR_RY" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_FZD_DM" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_ZDQLRGHKH" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "SJYT" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "PZYT" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "SJYTMC" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "PZYTMC" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_FW_SYQR" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_FW_CQZH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_YQLRID" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_YZDID" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_YZDQLRID" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_YZDH" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTBSM1" numeric(65,30) DEFAULT NULL::numeric,
  "DJLX_MJBAK" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTBSM_NUMBER" numeric(65,30) DEFAULT NULL::numeric,
  "QLXZ_MJBAK" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_GXSJ" date DEFAULT NULL,
  "GXSJ" date DEFAULT NULL,
  "BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "QLXZMC" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DJLXMC" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_DJNR" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_DJLXMC" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "TDSYQX" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_ZDID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_ZD_ID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_ACCESS_ID" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_DANGHID" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "_source_" varchar(5) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL::character varying,
  "delflag" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Table structure for qlr
-- ----------------------------
DROP TABLE IF EXISTS "dbcenter"."qlr";
CREATE TABLE "dbcenter"."qlr" (
  "bsm" int8 NOT NULL DEFAULT NULL,
  "ywh" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "qlrlb" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "qlbm" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "qlbsm" int8 DEFAULT NULL,
  "sxh" int4 DEFAULT NULL,
  "qlrmc" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "zjzl" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "zjh" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "sshy" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "xb" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "gddh" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "yddh" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "dz" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "yb" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "gzdw" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "dzyj" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "qlrlx" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "qlmj" numeric(15,3) DEFAULT NULL::numeric,
  "qlbl" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "gyfs" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "gyqk" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "qlrfrmc" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "qlrfrdh" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "qlrfrzjzl" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "qlrfrzjh" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "qlrfrlxdz" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "qlrdlrmc" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "qlrdlrdh" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "qlrdlrzjzl" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "qlrdlrzjh" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "qlrdljg" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "qlrdljgdm" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "bz" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "qszt" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "zsbsm" int8 DEFAULT NULL,
  "yxtbm" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "yxtbsm" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "sqrbsm" int8 DEFAULT NULL,
  "qxdm" numeric(6) DEFAULT NULL::numeric,
  "bz_gybw_name" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "bz_fcz_nm" numeric(65,30) DEFAULT NULL::numeric,
  "bz_gy_type" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "bz_syqr_xz" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "rev_" numeric(65,30) DEFAULT NULL::numeric,
  "bz_ghkh" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "bz_add1" date DEFAULT NULL,
  "bz_zdqlr_id" int4 DEFAULT NULL,
  "bz_sqr_nm" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "bz_gxsj" date DEFAULT NULL,
  "gxsj" date DEFAULT NULL,
  "bz_zsbsm" numeric(65,30) DEFAULT NULL::numeric,
  "qllxmc" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "bz_dy_id" numeric(65,30) DEFAULT NULL::numeric,
  "bz_cf_id" numeric(65,30) DEFAULT NULL::numeric,
  "gj" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "yxtzjlx" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "yxtgyfs" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "bz_zjzlmc" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "bz_qlrfrzjzlmc" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "bz_qlrdlrzjzlmc" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "bz_oinsid" numeric(65,30) DEFAULT NULL::numeric,
  "bz_zjzl" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "_source_" varchar(5) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL::character varying,
  "delflag" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Table structure for qlr_ls
-- ----------------------------
DROP TABLE IF EXISTS "dbcenter"."qlr_ls";
CREATE TABLE "dbcenter"."qlr_ls" (
  "BSM" int8 NOT NULL DEFAULT NULL,
  "YWH" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLRLB" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLBM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLBSM" int8 DEFAULT NULL,
  "SXH" int4 DEFAULT NULL,
  "QLRMC" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZJZL" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZJH" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "SSHY" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "XB" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "GDDH" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YDDH" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "YB" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "GZDW" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DZYJ" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLRLX" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLMJ" numeric(15,3) DEFAULT NULL::numeric,
  "QLBL" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "GYFS" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "GYQK" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "QLRFRMC" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLRFRDH" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLRFRZJZL" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLRFRZJH" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "QLRFRLXDZ" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLRDLRMC" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLRDLRDH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLRDLRZJZL" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLRDLRZJH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLRDLJG" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLRDLJGDM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "QSZT" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZSBSM" int8 DEFAULT NULL,
  "YXTBM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTBSM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "SQRBSM" int8 DEFAULT NULL,
  "QXDM" numeric(6) DEFAULT NULL::numeric,
  "BZ_GYBW_NAME" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_FCZ_NM" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_GY_TYPE" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_SYQR_XZ" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "REV_" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_GHKH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_ADD1" date DEFAULT NULL,
  "BZ_ZDQLR_ID" int4 DEFAULT NULL,
  "BZ_SQR_NM" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_GXSJ" date DEFAULT NULL,
  "GXSJ" date DEFAULT NULL,
  "BZ_ZSBSM" numeric(65,30) DEFAULT NULL::numeric,
  "QLLXMC" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_DY_ID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_CF_ID" numeric(65,30) DEFAULT NULL::numeric,
  "GJ" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTZJLX" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTGYFS" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_ZJZLMC" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_QLRFRZJZLMC" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_QLRDLRZJZLMC" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_OINSID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_ZJZL" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "_source_" varchar(5) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL::character varying,
  "delflag" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Table structure for xzdj
-- ----------------------------
DROP TABLE IF EXISTS "dbcenter"."xzdj";
CREATE TABLE "dbcenter"."xzdj" (
  "BSM" int8 NOT NULL DEFAULT NULL,
  "YWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "XZZXJG" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "XZLX" varchar(5) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "XZFS" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "XZWJ" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "XZWJLX" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "XZWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "XZQSSJ" date DEFAULT NULL,
  "XZJSSJ" date DEFAULT NULL,
  "BXZR" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "XZBW" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BXZQZH" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "XZMJ" numeric(15,2) DEFAULT NULL::numeric,
  "SAJE" numeric(15,4) DEFAULT NULL::numeric,
  "XZYY" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "XGR" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DBR" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DJSJ" date DEFAULT NULL,
  "FJ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "QSZT" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "SHBSM" int8 DEFAULT NULL,
  "YXTBM" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTBSM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QXDM" int8 DEFAULT NULL,
  "BZ_ISDELETE" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_TDESC" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "REV_" numeric(65,30) DEFAULT NULL::numeric,
  "GXSJ" date DEFAULT NULL,
  "BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BXZZL" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "WGLZT" int4 DEFAULT NULL,
  "BXZZMH" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "HH" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "XZSQR" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "XZQXSJ" date DEFAULT NULL,
  "OINSID" numeric(65,30) DEFAULT NULL::numeric,
  "YXTBSM1" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_SHAPE" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_SDFS" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_OINSID" numeric(65,30) DEFAULT NULL::numeric,
  "_source_" varchar(5) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL::character varying,
  "delflag" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Table structure for xzdj_dygx
-- ----------------------------
DROP TABLE IF EXISTS "dbcenter"."xzdj_dygx";
CREATE TABLE "dbcenter"."xzdj_dygx" (
  "BSM" int8 NOT NULL DEFAULT NULL,
  "YWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DYBSM" int8 DEFAULT NULL,
  "BDCDYLX" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "XZDJBSM" int8 DEFAULT NULL,
  "XZDJZXBSM" int8 DEFAULT NULL,
  "DYBM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLBM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLBSM" int8 DEFAULT NULL,
  "BDCDYH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "CQZH" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZL" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "QXDM" int4 DEFAULT NULL,
  "REV_" numeric(65,30) DEFAULT NULL::numeric,
  "GXSJ" date DEFAULT NULL,
  "BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_ZD_ID" numeric(65,30) DEFAULT NULL::numeric,
  "YXTBM" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTBSM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_ZDQLR_ID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_OINSID" numeric(65,30) DEFAULT NULL::numeric,
  "_source_" varchar(5) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL::character varying,
  "delflag" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Table structure for xzdj_zx
-- ----------------------------
DROP TABLE IF EXISTS "dbcenter"."xzdj_zx";
CREATE TABLE "dbcenter"."xzdj_zx" (
  "BSM" int8 NOT NULL DEFAULT NULL,
  "YWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "XZDJBSM" int8 DEFAULT NULL,
  "JCXZFS" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "JCXZWJ" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "JCXZWJLX" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "JCXZWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DJYY" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "FJ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "QSZT" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "SHBSM" int8 DEFAULT NULL,
  "YXTBM" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTBSM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QXDM" int8 DEFAULT NULL,
  "REV_" numeric(65,30) DEFAULT NULL::numeric,
  "GXSJ" date DEFAULT NULL,
  "BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "DBR" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DJSJ" date DEFAULT NULL,
  "OINSID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_OINSID" numeric(65,30) DEFAULT NULL::numeric,
  "_source_" varchar(5) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL::character varying,
  "delflag" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Table structure for xzdj_zxr
-- ----------------------------
DROP TABLE IF EXISTS "dbcenter"."xzdj_zxr";
CREATE TABLE "dbcenter"."xzdj_zxr" (
  "BSM" int8 NOT NULL DEFAULT NULL,
  "XZDJBSM" int8 DEFAULT NULL,
  "XM" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "GZZH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZXGWZH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "LXDH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DZYX" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QXDM" int8 DEFAULT NULL,
  "REV_" numeric(65,30) DEFAULT NULL::numeric,
  "YWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "GXSJ" date DEFAULT NULL,
  "BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "YXTBM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "_source_" varchar(5) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL::character varying,
  "delflag" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Table structure for ygdj
-- ----------------------------
DROP TABLE IF EXISTS "dbcenter"."ygdj";
CREATE TABLE "dbcenter"."ygdj" (
  "BSM" int8 NOT NULL DEFAULT NULL,
  "YWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BDCZL" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YGDJZL" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DJLX" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTDJLXMC" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DJYY" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "TDSYQR" varchar(250) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QDJG" numeric(15,4) DEFAULT NULL::numeric,
  "DJZMH" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DJZMBSM" int8 DEFAULT NULL,
  "DBR" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DJSJ" date DEFAULT NULL,
  "FJ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "FKFS" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DKLX" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "HTBH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZXYWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZXSJ" date DEFAULT NULL,
  "ZXDBR" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZXFJ" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZXYY" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "QLQSSJ" date DEFAULT NULL,
  "QLJSSJ" date DEFAULT NULL,
  "BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "QSZT" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "SHBSM" int8 DEFAULT NULL,
  "ZXSHBSM" int8 DEFAULT NULL,
  "YXTBM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTBSM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QXDM" int8 DEFAULT NULL,
  "REV_" numeric(65,30) DEFAULT NULL::numeric,
  "DJJG" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DYFS" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DYSX" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_XMBSM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_GXSJ" date DEFAULT NULL,
  "GXSJ" date DEFAULT NULL,
  "BZ_PROINS_ID" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "OINSID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_OINSID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_OINSID_ZX" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_FORENOTICEID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_ZX_OINSID" numeric(65,30) DEFAULT NULL::numeric,
  "HBLX" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "QYRQ" date DEFAULT NULL,
  "_source_" varchar(5) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL::character varying,
  "delflag" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Table structure for ygdj_bhgx
-- ----------------------------
DROP TABLE IF EXISTS "dbcenter"."ygdj_bhgx";
CREATE TABLE "dbcenter"."ygdj_bhgx" (
  "BSM" int8 NOT NULL DEFAULT NULL,
  "YWH" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YQLBSM" int8 DEFAULT NULL,
  "QLBSM" int8 DEFAULT NULL,
  "QXDM" int4 DEFAULT NULL,
  "BZ" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "GXSJ" date DEFAULT NULL,
  "REV_" numeric(65,30) DEFAULT NULL::numeric,
  "_source_" varchar(5) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL::character varying,
  "delflag" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Table structure for ygdj_dygx
-- ----------------------------
DROP TABLE IF EXISTS "dbcenter"."ygdj_dygx";
CREATE TABLE "dbcenter"."ygdj_dygx" (
  "BSM" int8 NOT NULL DEFAULT NULL,
  "YWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DYBSM" int8 DEFAULT NULL,
  "BDCDYLX" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YGDJBSM" int8 DEFAULT NULL,
  "DYBM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QXDM" int4 DEFAULT NULL,
  "BZ_FW_NM" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_FH_NM" numeric(65,30) DEFAULT NULL::numeric,
  "REV_" numeric(65,30) DEFAULT NULL::numeric,
  "QLBM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLBSM" int8 DEFAULT NULL,
  "BZ_XMBSM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "GXSJ" date DEFAULT NULL,
  "BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "BZ_FWNM" numeric(65,30) DEFAULT NULL::numeric,
  "YXTBM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_BDCDYH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTBSM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "_source_" varchar(5) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL::character varying,
  "delflag" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Table structure for zd_shiyq
-- ----------------------------
DROP TABLE IF EXISTS "dbcenter"."zd_shiyq";
CREATE TABLE "dbcenter"."zd_shiyq" (
  "BSM" int8 NOT NULL DEFAULT NULL,
  "ZDDM" varchar(19) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BDCDYH" varchar(28) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YSDM" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZDTZM" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZL" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "ZDMJ" numeric(15,4) DEFAULT NULL::numeric,
  "MJDW" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YT" varchar(4) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DJ" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "JG" numeric(15,4) DEFAULT NULL::numeric,
  "QLLX" varchar(5) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLXZ" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLSDFS" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "RJL" numeric(15,6) DEFAULT NULL::numeric,
  "JZMD" numeric(15,6) DEFAULT NULL::numeric,
  "JZXG" numeric(5,2) DEFAULT NULL::numeric,
  "ZDSZD" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "ZDSZN" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "ZDSZX" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "ZDSZB" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "ZDT" bytea DEFAULT NULL,
  "TFH" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "DJH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZT" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DZJGH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "GDHTH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YZDBH" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YTDYT" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "TDSYQR" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "JZMJ" numeric(15,2) DEFAULT NULL::numeric,
  "JZWZDMJ" numeric(15,2) DEFAULT NULL::numeric,
  "YXTBM" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTBSM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DCBSM" int8 DEFAULT NULL,
  "QXDM" int4 DEFAULT NULL,
  "REV_" numeric(65,30) DEFAULT NULL::numeric,
  "DCYWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_SJ_BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "ZDXZ" numeric(1) DEFAULT NULL::numeric,
  "BZ_ADD1" date DEFAULT NULL,
  "LHL" numeric(6,4) DEFAULT NULL::numeric,
  "BZ_ZD_SHIYZ" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTBM_NEW" numeric(65,30) DEFAULT NULL::numeric,
  "ZDXZ_MJBAK" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "SJYT" varchar(4) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YSJYT" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "SYQQSSJ" date DEFAULT NULL,
  "SYQJSSJ" date DEFAULT NULL,
  "BZ_GXSJ" date DEFAULT NULL,
  "YWH" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "GXSJ" date DEFAULT NULL,
  "BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "TXBZ" numeric(1) DEFAULT NULL::numeric,
  "BZ_SYQMJ" numeric(65,30) DEFAULT NULL::numeric,
  "YQLLX" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YQLXZ" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "PKBSM" numeric(10) DEFAULT NULL::numeric,
  "BZ_DJ" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "_source_" varchar(5) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL::character varying,
  "delflag" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Table structure for zd_shiyq_bhgx
-- ----------------------------
DROP TABLE IF EXISTS "dbcenter"."zd_shiyq_bhgx";
CREATE TABLE "dbcenter"."zd_shiyq_bhgx" (
  "BSM" int8 NOT NULL DEFAULT NULL,
  "YWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YDYBSM" int8 DEFAULT NULL,
  "XDYBSM" int8 DEFAULT NULL,
  "BHSJ" date DEFAULT NULL,
  "QXDM" int4 DEFAULT NULL,
  "REV_" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_YXTBM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_YXTBSM" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_BG_BB" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_BG_BB_X" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_FLAG" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_LZD_ID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_XZD_ID" numeric(65,30) DEFAULT NULL::numeric,
  "GXSJ" date DEFAULT NULL,
  "BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "YXTBSM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTBM" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "_source_" varchar(5) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL::character varying,
  "delflag" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Table structure for zd_shiyq_ls
-- ----------------------------
DROP TABLE IF EXISTS "dbcenter"."zd_shiyq_ls";
CREATE TABLE "dbcenter"."zd_shiyq_ls" (
  "BSM" int8 NOT NULL DEFAULT NULL,
  "ZDDM" varchar(19) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BDCDYH" varchar(28) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YSDM" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZDTZM" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZL" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "ZDMJ" numeric(15,4) DEFAULT NULL::numeric,
  "MJDW" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YT" varchar(4) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DJ" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "JG" numeric(15,4) DEFAULT NULL::numeric,
  "QLLX" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLXZ" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QLSDFS" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "RJL" numeric(15,6) DEFAULT NULL::numeric,
  "JZMD" numeric(15,6) DEFAULT NULL::numeric,
  "JZXG" numeric(5,2) DEFAULT NULL::numeric,
  "ZDSZD" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZDSZN" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZDSZX" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "ZDSZB" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZDT" bytea DEFAULT NULL,
  "TFH" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "DJH" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZT" varchar(2) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DZJGH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "GDHTH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YZDBH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YTDYT" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "TDSYQR" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "JZMJ" numeric(15,2) DEFAULT NULL::numeric,
  "JZWZDMJ" numeric(15,2) DEFAULT NULL::numeric,
  "YXTBM" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTBSM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DCBSM" int8 DEFAULT NULL,
  "QXDM" int4 DEFAULT NULL,
  "REV_" numeric(65,30) DEFAULT NULL::numeric,
  "DCYWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "SJYT" varchar(4) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YSJYT" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZDXZ" int4 DEFAULT NULL,
  "LHL" numeric(15,2) DEFAULT NULL::numeric,
  "BZ_BG_BB" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_ZD_SHIYZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "SYQQSSJ" date DEFAULT NULL,
  "SYQJSSJ" date DEFAULT NULL,
  "BZ_GXSJ" date DEFAULT NULL,
  "YWH" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "GXSJ" date DEFAULT NULL,
  "BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "TXBZ" int4 DEFAULT NULL,
  "PKBSM" int4 NOT NULL DEFAULT NULL,
  "YQLLX" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YQLXZ" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_HQ_RQ" date DEFAULT NULL,
  "BZ_SJ_BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "_source_" varchar(5) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL::character varying,
  "delflag" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Table structure for zrz
-- ----------------------------
DROP TABLE IF EXISTS "dbcenter"."zrz";
CREATE TABLE "dbcenter"."zrz" (
  "BSM" int8 NOT NULL DEFAULT NULL,
  "ZRZH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "XMMC" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "JZWMC" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "JGRQ" date DEFAULT NULL,
  "JZWGD" numeric(15,2) DEFAULT NULL::numeric,
  "ZZDMJ" numeric(15,3) DEFAULT NULL::numeric,
  "ZYDMJ" numeric(15,3) DEFAULT NULL::numeric,
  "YCJZMJ" numeric(15,3) DEFAULT NULL::numeric,
  "SCJZMJ" numeric(15,3) DEFAULT NULL::numeric,
  "ZCS" int4 DEFAULT NULL,
  "DSCS" int4 DEFAULT NULL,
  "DXCS" int4 DEFAULT NULL,
  "DXSD" numeric(15,2) DEFAULT NULL::numeric,
  "GHYT" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTGHYTMC" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "FWYT" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTFWYTMC" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "FWJG" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZTS" int4 DEFAULT NULL,
  "JZWJBYT" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "XQMC" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZL" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "ZXDZBX" numeric(15,4) DEFAULT NULL::numeric,
  "ZXDZBY" numeric(15,4) DEFAULT NULL::numeric,
  "TFH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTBM" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTBSM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DCBSM" int8 DEFAULT NULL,
  "QXDM" int4 DEFAULT NULL,
  "BZ_BUILDID" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_PROJECT_ID" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "REV_" numeric(65,30) DEFAULT NULL::numeric,
  "DCYWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BDCDYH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZDDM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZDSHIYQBSM" int8 DEFAULT NULL,
  "DCZDSHIYQBSM" int8 DEFAULT NULL,
  "GXSJ" date DEFAULT NULL,
  "BZ_LEVELPRICE" numeric(65,30) DEFAULT NULL::numeric,
  "YXTBSM1" numeric(65,30) DEFAULT NULL::numeric,
  "BZ_SURVEYNO" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_SANJAK" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ_FWLB" numeric(65,30) DEFAULT NULL::numeric,
  "_source_" varchar(5) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL::character varying,
  "delflag" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Table structure for zrz_ls
-- ----------------------------
DROP TABLE IF EXISTS "dbcenter"."zrz_ls";
CREATE TABLE "dbcenter"."zrz_ls" (
  "BSM" int8 NOT NULL DEFAULT NULL,
  "ZRZH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "XMMC" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "JZWMC" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "JGRQ" date DEFAULT NULL,
  "JZWGD" numeric(15,2) DEFAULT NULL::numeric,
  "ZZDMJ" numeric(15,3) DEFAULT NULL::numeric,
  "ZYDMJ" numeric(15,3) DEFAULT NULL::numeric,
  "YCJZMJ" numeric(15,3) DEFAULT NULL::numeric,
  "SCJZMJ" numeric(15,3) DEFAULT NULL::numeric,
  "ZCS" int4 DEFAULT NULL,
  "DSCS" int4 DEFAULT NULL,
  "DXCS" int4 DEFAULT NULL,
  "DXSD" numeric(15,2) DEFAULT NULL::numeric,
  "GHYT" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTGHYTMC" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "FWYT" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTFWYTMC" varchar(100) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "FWJG" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZTS" int4 DEFAULT NULL,
  "JZWJBYT" varchar(200) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BZ" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "XQMC" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZL" text COLLATE "pg_catalog"."default" DEFAULT NULL,
  "ZXDZBX" numeric(15,4) DEFAULT NULL::numeric,
  "ZXDZBY" numeric(15,4) DEFAULT NULL::numeric,
  "TFH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "QH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTBM" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "YXTBSM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "DCBSM" int8 DEFAULT NULL,
  "QXDM" int4 DEFAULT NULL,
  "REV_" numeric(65,30) DEFAULT NULL::numeric,
  "DCYWH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "BDCDYH" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZDDM" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "ZDSHIYQBSM" int8 DEFAULT NULL,
  "DCZDSHIYQBSM" int8 DEFAULT NULL,
  "GXSJ" date DEFAULT NULL,
  "BZ_SANJAK" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "_source_" varchar(5) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL::character varying,
  "delflag" int2 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Primary Key structure for table cfdj
-- ----------------------------
ALTER TABLE "dbcenter"."cfdj" ADD CONSTRAINT "cfdj_pkey" PRIMARY KEY ("BSM");

-- ----------------------------
-- Primary Key structure for table cfdj_bhgx
-- ----------------------------
ALTER TABLE "dbcenter"."cfdj_bhgx" ADD CONSTRAINT "cfdj_bhgx_pkey" PRIMARY KEY ("BSM");

-- ----------------------------
-- Primary Key structure for table cfdj_dygx
-- ----------------------------
ALTER TABLE "dbcenter"."cfdj_dygx" ADD CONSTRAINT "cfdj_dygx_pkey" PRIMARY KEY ("BSM");

-- ----------------------------
-- Primary Key structure for table cfdj_zx
-- ----------------------------
ALTER TABLE "dbcenter"."cfdj_zx" ADD CONSTRAINT "cfdj_zx_pkey" PRIMARY KEY ("BSM");

-- ----------------------------
-- Primary Key structure for table cfdj_zxr
-- ----------------------------
ALTER TABLE "dbcenter"."cfdj_zxr" ADD CONSTRAINT "cfdj_zxr_pkey" PRIMARY KEY ("BSM");

-- ----------------------------
-- Primary Key structure for table djfz_cqzs
-- ----------------------------
ALTER TABLE "dbcenter"."djfz_cqzs" ADD CONSTRAINT "djfz_cqzs_pkey" PRIMARY KEY ("bsm");

-- ----------------------------
-- Primary Key structure for table djfz_cqzs_ls
-- ----------------------------
ALTER TABLE "dbcenter"."djfz_cqzs_ls" ADD CONSTRAINT "djfz_cqzs_ls_pkey" PRIMARY KEY ("BSM");

-- ----------------------------
-- Primary Key structure for table djfz_djzm
-- ----------------------------
ALTER TABLE "dbcenter"."djfz_djzm" ADD CONSTRAINT "djfz_djzm_pkey" PRIMARY KEY ("BSM");

-- ----------------------------
-- Primary Key structure for table dyaq
-- ----------------------------
ALTER TABLE "dbcenter"."dyaq" ADD CONSTRAINT "dyaq_pkey" PRIMARY KEY ("BSM");

-- ----------------------------
-- Primary Key structure for table dyaq_bhgx
-- ----------------------------
ALTER TABLE "dbcenter"."dyaq_bhgx" ADD CONSTRAINT "dyaq_bhgx_pkey" PRIMARY KEY ("BSM");

-- ----------------------------
-- Primary Key structure for table dyaq_dygx
-- ----------------------------
ALTER TABLE "dbcenter"."dyaq_dygx" ADD CONSTRAINT "dyaq_dygx_pkey" PRIMARY KEY ("BSM");

-- ----------------------------
-- Primary Key structure for table dyaq_zx
-- ----------------------------
ALTER TABLE "dbcenter"."dyaq_zx" ADD CONSTRAINT "dyaq_zx_pkey" PRIMARY KEY ("BSM");

-- ----------------------------
-- Primary Key structure for table fdcq
-- ----------------------------
ALTER TABLE "dbcenter"."fdcq" ADD CONSTRAINT "fdcq_pkey" PRIMARY KEY ("BSM");

-- ----------------------------
-- Primary Key structure for table fdcq_bhgx
-- ----------------------------
ALTER TABLE "dbcenter"."fdcq_bhgx" ADD CONSTRAINT "fdcq_bhgx_pkey" PRIMARY KEY ("BSM");

-- ----------------------------
-- Primary Key structure for table fdcq_dygx
-- ----------------------------
ALTER TABLE "dbcenter"."fdcq_dygx" ADD CONSTRAINT "fdcq_dygx_pkey" PRIMARY KEY ("BSM");

-- ----------------------------
-- Primary Key structure for table fdcq_ls
-- ----------------------------
ALTER TABLE "dbcenter"."fdcq_ls" ADD CONSTRAINT "fdcq_ls_pkey" PRIMARY KEY ("BSM");

-- ----------------------------
-- Primary Key structure for table h
-- ----------------------------
ALTER TABLE "dbcenter"."h" ADD CONSTRAINT "h_pkey" PRIMARY KEY ("BSM");

-- ----------------------------
-- Primary Key structure for table h_bhgx
-- ----------------------------
ALTER TABLE "dbcenter"."h_bhgx" ADD CONSTRAINT "h_bhgx_pkey" PRIMARY KEY ("BSM");

-- ----------------------------
-- Primary Key structure for table h_ls
-- ----------------------------
ALTER TABLE "dbcenter"."h_ls" ADD CONSTRAINT "h_ls_pkey" PRIMARY KEY ("BSM");

-- ----------------------------
-- Primary Key structure for table jsydsyq
-- ----------------------------
ALTER TABLE "dbcenter"."jsydsyq" ADD CONSTRAINT "jsydsyq_pkey" PRIMARY KEY ("BSM");

-- ----------------------------
-- Primary Key structure for table jsydsyq_bhgx
-- ----------------------------
ALTER TABLE "dbcenter"."jsydsyq_bhgx" ADD CONSTRAINT "jsydsyq_bhgx_pkey" PRIMARY KEY ("BSM");

-- ----------------------------
-- Primary Key structure for table jsydsyq_dygx
-- ----------------------------
ALTER TABLE "dbcenter"."jsydsyq_dygx" ADD CONSTRAINT "jsydsyq_dygx_pkey" PRIMARY KEY ("BSM");

-- ----------------------------
-- Primary Key structure for table jsydsyq_ls
-- ----------------------------
ALTER TABLE "dbcenter"."jsydsyq_ls" ADD CONSTRAINT "jsydsyq_ls_pkey" PRIMARY KEY ("BSM");

-- ----------------------------
-- Primary Key structure for table qlr
-- ----------------------------
ALTER TABLE "dbcenter"."qlr" ADD CONSTRAINT "qlr_pkey" PRIMARY KEY ("bsm");

-- ----------------------------
-- Primary Key structure for table qlr_ls
-- ----------------------------
ALTER TABLE "dbcenter"."qlr_ls" ADD CONSTRAINT "qlr_ls_pkey" PRIMARY KEY ("BSM");

-- ----------------------------
-- Primary Key structure for table xzdj
-- ----------------------------
ALTER TABLE "dbcenter"."xzdj" ADD CONSTRAINT "xzdj_pkey" PRIMARY KEY ("BSM");

-- ----------------------------
-- Primary Key structure for table xzdj_dygx
-- ----------------------------
ALTER TABLE "dbcenter"."xzdj_dygx" ADD CONSTRAINT "xzdj_dygx_pkey" PRIMARY KEY ("BSM");

-- ----------------------------
-- Primary Key structure for table xzdj_zx
-- ----------------------------
ALTER TABLE "dbcenter"."xzdj_zx" ADD CONSTRAINT "xzdj_zx_pkey" PRIMARY KEY ("BSM");

-- ----------------------------
-- Primary Key structure for table xzdj_zxr
-- ----------------------------
ALTER TABLE "dbcenter"."xzdj_zxr" ADD CONSTRAINT "xzdj_zxr_pkey" PRIMARY KEY ("BSM");

-- ----------------------------
-- Primary Key structure for table ygdj
-- ----------------------------
ALTER TABLE "dbcenter"."ygdj" ADD CONSTRAINT "ygdj_pkey" PRIMARY KEY ("BSM");

-- ----------------------------
-- Primary Key structure for table ygdj_bhgx
-- ----------------------------
ALTER TABLE "dbcenter"."ygdj_bhgx" ADD CONSTRAINT "ygdj_bhgx_pkey" PRIMARY KEY ("BSM");

-- ----------------------------
-- Primary Key structure for table ygdj_dygx
-- ----------------------------
ALTER TABLE "dbcenter"."ygdj_dygx" ADD CONSTRAINT "ygdj_dygx_pkey" PRIMARY KEY ("BSM");

-- ----------------------------
-- Primary Key structure for table zd_shiyq
-- ----------------------------
ALTER TABLE "dbcenter"."zd_shiyq" ADD CONSTRAINT "zd_shiyq_pkey" PRIMARY KEY ("BSM");

-- ----------------------------
-- Primary Key structure for table zd_shiyq_bhgx
-- ----------------------------
ALTER TABLE "dbcenter"."zd_shiyq_bhgx" ADD CONSTRAINT "zd_shiyq_bhgx_pkey" PRIMARY KEY ("BSM");

-- ----------------------------
-- Primary Key structure for table zd_shiyq_ls
-- ----------------------------
ALTER TABLE "dbcenter"."zd_shiyq_ls" ADD CONSTRAINT "zd_shiyq_ls_pkey" PRIMARY KEY ("BSM");

-- ----------------------------
-- Primary Key structure for table zrz
-- ----------------------------
ALTER TABLE "dbcenter"."zrz" ADD CONSTRAINT "zrz_pkey" PRIMARY KEY ("BSM");

-- ----------------------------
-- Primary Key structure for table zrz_ls
-- ----------------------------
ALTER TABLE "dbcenter"."zrz_ls" ADD CONSTRAINT "zrz_ls_pkey" PRIMARY KEY ("BSM");
