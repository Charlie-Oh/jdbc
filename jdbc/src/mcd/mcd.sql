--------------------------------------------------------
--  파일이 생성됨 - 수요일-2월-08-2023   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence SEQ_ORDER_NO
--------------------------------------------------------

   CREATE SEQUENCE  "TEST"."SEQ_ORDER_NO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 32 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table TBL_BURGER
--------------------------------------------------------

  CREATE TABLE "TEST"."TBL_BURGER" 
   (	"PROD_NUM" NUMBER, 
	"PROD_NAME" VARCHAR2(40 BYTE), 
	"PRICE" NUMBER, 
	"PROD_INFO" VARCHAR2(500 BYTE), 
	"VALUE" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;

   COMMENT ON COLUMN "TEST"."TBL_BURGER"."PROD_NUM" IS '상품번호';
   COMMENT ON COLUMN "TEST"."TBL_BURGER"."PROD_NAME" IS '상품명';
   COMMENT ON COLUMN "TEST"."TBL_BURGER"."PRICE" IS '가격';
   COMMENT ON COLUMN "TEST"."TBL_BURGER"."PROD_INFO" IS '상품정보';
   COMMENT ON COLUMN "TEST"."TBL_BURGER"."VALUE" IS '상품종류';
--------------------------------------------------------
--  DDL for Table TBL_INGREDIENT
--------------------------------------------------------

  CREATE TABLE "TEST"."TBL_INGREDIENT" 
   (	"PROD_NUM" NUMBER, 
	"GRAM" NUMBER, 
	"ML" NUMBER, 
	"KCAL" NUMBER, 
	"SUGER" NUMBER, 
	"PROTEIN" NUMBER, 
	"FAT" NUMBER, 
	"NATRIUM" NUMBER, 
	"CAFFEINE" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;

   COMMENT ON COLUMN "TEST"."TBL_INGREDIENT"."PROD_NUM" IS '상품번호';
   COMMENT ON COLUMN "TEST"."TBL_INGREDIENT"."GRAM" IS '중량(G)';
   COMMENT ON COLUMN "TEST"."TBL_INGREDIENT"."ML" IS '중량(ML)';
   COMMENT ON COLUMN "TEST"."TBL_INGREDIENT"."KCAL" IS '열량';
   COMMENT ON COLUMN "TEST"."TBL_INGREDIENT"."SUGER" IS '당';
   COMMENT ON COLUMN "TEST"."TBL_INGREDIENT"."PROTEIN" IS '단백질';
   COMMENT ON COLUMN "TEST"."TBL_INGREDIENT"."FAT" IS '포화지방';
   COMMENT ON COLUMN "TEST"."TBL_INGREDIENT"."NATRIUM" IS '나트륨';
   COMMENT ON COLUMN "TEST"."TBL_INGREDIENT"."CAFFEINE" IS '카페인';
--------------------------------------------------------
--  DDL for Table TBL_ORDER
--------------------------------------------------------

  CREATE TABLE "TEST"."TBL_ORDER" 
   (	"ORDER_NO" NUMBER, 
	"NAME" VARCHAR2(20 BYTE), 
	"PHNUM" VARCHAR2(200 BYTE), 
	"ADRESS" VARCHAR2(300 BYTE), 
	"ORDER_INFO" VARCHAR2(400 BYTE), 
	"TOT_PRICE" NUMBER, 
	"CANCLE_YN" VARCHAR2(2 BYTE) DEFAULT 'n', 
	"ORDER_TIME" DATE, 
	"COUNT" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;

   COMMENT ON COLUMN "TEST"."TBL_ORDER"."ORDER_NO" IS '주문번호';
   COMMENT ON COLUMN "TEST"."TBL_ORDER"."NAME" IS '고객명';
   COMMENT ON COLUMN "TEST"."TBL_ORDER"."PHNUM" IS '전화번호';
   COMMENT ON COLUMN "TEST"."TBL_ORDER"."ADRESS" IS '주소';
   COMMENT ON COLUMN "TEST"."TBL_ORDER"."ORDER_INFO" IS '주문정보';
   COMMENT ON COLUMN "TEST"."TBL_ORDER"."TOT_PRICE" IS '총금액';
   COMMENT ON COLUMN "TEST"."TBL_ORDER"."CANCLE_YN" IS '취소여부';
   COMMENT ON COLUMN "TEST"."TBL_ORDER"."ORDER_TIME" IS '주문일자';
   COMMENT ON COLUMN "TEST"."TBL_ORDER"."COUNT" IS '수량';
REM INSERTING into TEST.TBL_BURGER
SET DEFINE OFF;
Insert into TEST.TBL_BURGER (PROD_NUM,PROD_NAME,PRICE,PROD_INFO,VALUE) values (1,'더블쿼터파운더치즈',6000,'좋아하는건 더 많이 즐기시라고,
두 배 이상 커진 1/4 파운드
비프 패티가 두 장 (226그램)!
육즙이 풍부한 고기 맛을
그대로 살린 100% 순 쇠고기 패티 두 장과
치즈 두 장이 입안 가득 완벽하게 조화되는 놀라운 맛','single');
Insert into TEST.TBL_BURGER (PROD_NUM,PROD_NAME,PRICE,PROD_INFO,VALUE) values (2,'더블쿼터파운더치즈세트',8000,'좋아하는건 더 많이 즐기시라고,
두 배 이상 커진 1/4 파운드
비프 패티가 두 장 (226그램)!
육즙이 풍부한 고기 맛을
그대로 살린 100% 순 쇠고기 패티 두 장과
치즈 두 장이 입안 가득 완벽하게 조화되는 놀라운 맛','set');
Insert into TEST.TBL_BURGER (PROD_NUM,PROD_NAME,PRICE,PROD_INFO,VALUE) values (3,'맥크리스피디럭스버거',6100,'통닭다리살 겉바속촉 케이준 치킨 패티,
촉촉한 포테이토 브리오쉬 번, 스페셜 스모키 소스가
선사하는 놀랍도록 새로운 맛의 치킨 버거!','single');
Insert into TEST.TBL_BURGER (PROD_NUM,PROD_NAME,PRICE,PROD_INFO,VALUE) values (4,'맥크리스피디럭스버거세트',8100,'통닭다리살 겉바속촉 케이준 치킨 패티,
촉촉한 포테이토 브리오쉬 번, 스페셜 스모키 소스가
선사하는 놀랍도록 새로운 맛의 치킨 버거!','set');
Insert into TEST.TBL_BURGER (PROD_NUM,PROD_NAME,PRICE,PROD_INFO,VALUE) values (5,'빅맥',6200,'100% 순 쇠고기 패티 두 장에 빅맥®만의 특별한 소스.
입안에서 살살 녹는 치즈와 신선한 양상추, 양파, 그리고 피클까지.
50년 넘게 전 세계인의 입맛을 사로 잡은 버거의 대명사.','single');
Insert into TEST.TBL_BURGER (PROD_NUM,PROD_NAME,PRICE,PROD_INFO,VALUE) values (6,'빅맥세트',8200,'100% 순 쇠고기 패티 두 장에 빅맥®만의 특별한 소스.
입안에서 살살 녹는 치즈와 신선한 양상추, 양파, 그리고 피클까지.
50년 넘게 전 세계인의 입맛을 사로 잡은 버거의 대명사.','set');
Insert into TEST.TBL_BURGER (PROD_NUM,PROD_NAME,PRICE,PROD_INFO,VALUE) values (7,'맥스파이시상하이버거',6300,'매콤한 시즈닝을 입힌 100% 닭가슴 통살 위에
아삭아삭한 양상추와 신선한 토마토~
겉은 바삭, 속은 부드러운 치킨 패티의 매콤함으로
입맛도 기분도 화끈하게!','single');
Insert into TEST.TBL_BURGER (PROD_NUM,PROD_NAME,PRICE,PROD_INFO,VALUE) values (8,'맥스파이시상하이버거세트',8300,'매콤한 시즈닝을 입힌 100% 닭가슴 통살 위에
아삭아삭한 양상추와 신선한 토마토~
겉은 바삭, 속은 부드러운 치킨 패티의 매콤함으로
입맛도 기분도 화끈하게!','set');
Insert into TEST.TBL_BURGER (PROD_NUM,PROD_NAME,PRICE,PROD_INFO,VALUE) values (9,'맥치킨모짜렐라',6400,'든든한 맥치킨에 골든 모짜렐라 치즈 스틱 2개와
매콤한 아라비아따 소스를 더해
강렬하게 재탄생한 맥치킨 모짜렐라!','single');
Insert into TEST.TBL_BURGER (PROD_NUM,PROD_NAME,PRICE,PROD_INFO,VALUE) values (10,'맥치킨모짜렐라세트',8400,'든든한 맥치킨에 골든 모짜렐라 치즈 스틱 2개와
매콤한 아라비아따 소스를 더해
강렬하게 재탄생한 맥치킨 모짜렐라!','set');
Insert into TEST.TBL_BURGER (PROD_NUM,PROD_NAME,PRICE,PROD_INFO,VALUE) values (11,'아이스바닐라라떼',3500,'바로 내린 100% 친환경 커피의 진한 맛과 향,
1A등급 우유, 그리고 천연 바닐라 향으로 달콤함까지!','mccafe');
Insert into TEST.TBL_BURGER (PROD_NUM,PROD_NAME,PRICE,PROD_INFO,VALUE) values (12,'카페라떼',3600,'바로 내린 100% 친환경 커피가 신선한 우유를 만나
더 신선하고 부드럽게!','mccafe');
Insert into TEST.TBL_BURGER (PROD_NUM,PROD_NAME,PRICE,PROD_INFO,VALUE) values (13,'아이스아메리카노',3000,'바로 내린 100% 친환경 커피로
더 신선하게! 더 풍부하게!','mccafe');
Insert into TEST.TBL_BURGER (PROD_NUM,PROD_NAME,PRICE,PROD_INFO,VALUE) values (14,'초코쉐이크',4000,'신선한 우유에 달콤함 초코렛 시럽이 들어간
부드러운 쉐이크!','drink');
Insert into TEST.TBL_BURGER (PROD_NUM,PROD_NAME,PRICE,PROD_INFO,VALUE) values (15,'오렌지주스',2000,'비타민 C를 함유한 4년 연속 세계 판매 1위 100% 오렌지 주스','drink');
Insert into TEST.TBL_BURGER (PROD_NUM,PROD_NAME,PRICE,PROD_INFO,VALUE) values (16,'바닐라쉐이크',4000,'신선한 우유에 달콤한 바닐라 시럽으로 맛을 더한
깔끔한 쉐이크!','drink');
REM INSERTING into TEST.TBL_INGREDIENT
SET DEFINE OFF;
Insert into TEST.TBL_INGREDIENT (PROD_NUM,GRAM,ML,KCAL,SUGER,PROTEIN,FAT,NATRIUM,CAFFEINE) values (1,275,null,769,10,50,20,1150,null);
Insert into TEST.TBL_INGREDIENT (PROD_NUM,GRAM,ML,KCAL,SUGER,PROTEIN,FAT,NATRIUM,CAFFEINE) values (2,null,null,1101,null,null,null,null,null);
Insert into TEST.TBL_INGREDIENT (PROD_NUM,GRAM,ML,KCAL,SUGER,PROTEIN,FAT,NATRIUM,CAFFEINE) values (3,266,null,594,14,23,5,1172,null);
Insert into TEST.TBL_INGREDIENT (PROD_NUM,GRAM,ML,KCAL,SUGER,PROTEIN,FAT,NATRIUM,CAFFEINE) values (4,null,null,927,null,null,null,null,null);
Insert into TEST.TBL_INGREDIENT (PROD_NUM,GRAM,ML,KCAL,SUGER,PROTEIN,FAT,NATRIUM,CAFFEINE) values (5,223,null,583,7,27,10,902,null);
Insert into TEST.TBL_INGREDIENT (PROD_NUM,GRAM,ML,KCAL,SUGER,PROTEIN,FAT,NATRIUM,CAFFEINE) values (6,null,null,916,null,null,null,null,null);
Insert into TEST.TBL_INGREDIENT (PROD_NUM,GRAM,ML,KCAL,SUGER,PROTEIN,FAT,NATRIUM,CAFFEINE) values (7,225,null,494,8,21,3,891,null);
Insert into TEST.TBL_INGREDIENT (PROD_NUM,GRAM,ML,KCAL,SUGER,PROTEIN,FAT,NATRIUM,CAFFEINE) values (8,null,null,827,null,null,null,null,null);
Insert into TEST.TBL_INGREDIENT (PROD_NUM,GRAM,ML,KCAL,SUGER,PROTEIN,FAT,NATRIUM,CAFFEINE) values (9,276,null,686,16,27,6,1548,null);
Insert into TEST.TBL_INGREDIENT (PROD_NUM,GRAM,ML,KCAL,SUGER,PROTEIN,FAT,NATRIUM,CAFFEINE) values (10,null,null,1018,null,null,null,null,null);
Insert into TEST.TBL_INGREDIENT (PROD_NUM,GRAM,ML,KCAL,SUGER,PROTEIN,FAT,NATRIUM,CAFFEINE) values (11,null,null,null,null,null,null,null,null);
Insert into TEST.TBL_INGREDIENT (PROD_NUM,GRAM,ML,KCAL,SUGER,PROTEIN,FAT,NATRIUM,CAFFEINE) values (12,null,null,null,null,null,null,null,null);
Insert into TEST.TBL_INGREDIENT (PROD_NUM,GRAM,ML,KCAL,SUGER,PROTEIN,FAT,NATRIUM,CAFFEINE) values (13,null,null,null,null,null,null,null,null);
Insert into TEST.TBL_INGREDIENT (PROD_NUM,GRAM,ML,KCAL,SUGER,PROTEIN,FAT,NATRIUM,CAFFEINE) values (14,null,425,344,52,9,6,211,null);
Insert into TEST.TBL_INGREDIENT (PROD_NUM,GRAM,ML,KCAL,SUGER,PROTEIN,FAT,NATRIUM,CAFFEINE) values (15,null,null,null,null,null,null,null,null);
Insert into TEST.TBL_INGREDIENT (PROD_NUM,GRAM,ML,KCAL,SUGER,PROTEIN,FAT,NATRIUM,CAFFEINE) values (16,null,425,344,49,8,6,157,null);
REM INSERTING into TEST.TBL_ORDER
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index SYS_C007178
--------------------------------------------------------

  CREATE UNIQUE INDEX "TEST"."SYS_C007178" ON "TEST"."TBL_BURGER" ("PROD_NUM") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SYS_C007177
--------------------------------------------------------

  CREATE UNIQUE INDEX "TEST"."SYS_C007177" ON "TEST"."TBL_ORDER" ("ORDER_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table TBL_BURGER
--------------------------------------------------------

  ALTER TABLE "TEST"."TBL_BURGER" ADD PRIMARY KEY ("PROD_NUM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table TBL_ORDER
--------------------------------------------------------

  ALTER TABLE "TEST"."TBL_ORDER" MODIFY ("ADRESS" NOT NULL ENABLE);
  ALTER TABLE "TEST"."TBL_ORDER" MODIFY ("PHNUM" NOT NULL ENABLE);
  ALTER TABLE "TEST"."TBL_ORDER" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "TEST"."TBL_ORDER" ADD PRIMARY KEY ("ORDER_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TBL_INGREDIENT
--------------------------------------------------------

  ALTER TABLE "TEST"."TBL_INGREDIENT" ADD CONSTRAINT "FK_PROD_NUM" FOREIGN KEY ("PROD_NUM")
	  REFERENCES "TEST"."TBL_BURGER" ("PROD_NUM") ENABLE;
