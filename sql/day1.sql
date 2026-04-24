--SQL -> Structured Query Language
--Yapılandırılmış Sorgu Dili

--DDL-> Data Definition Language

CREATE DATABASE eticaret;

CREATE TABLE users(
    -- isim tür(SINIR) özel-durumlar
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,  -- varsayılan olarak her metinsel alan nullabledir
    surname VARCHAR(100) NOT NULL,--varchar string'in database'deki karşılığı
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    register_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP --DEFAULT->OTOMATİK ATAMA
	--CURRENT_TIMESTAMP kullanıcı herhangi bir veri girerken o zaman neyse onu ata
);
--Tabloya yeni bir sütun eklerken not null olmasını sağlayamazsınız
--Sebebi tabloda daha önce kayıt varsa hata verir.

--Tabloya yeni sütun ekleme
ALTER TABLE users ADD COLUMN gsm VARCHAR(20); --TABLO VAR,KOLON YOK

--eğer illa null yapmak istersek önce tablodaki verileri doldururuz(verilerdeki yeni kolonu) sonra güncelleriz.

ALTER TABLE users ALTER COLUMN gsm SET NOT NULL;--Tablo var,kolon var

--BAZI SQLLERDE ORTADAKİ ALTER KISMI MODIFY OLARAK YAZILABİLİR(ÖR:MYSQL)

CREATE TABLE carts(
id SERIAL PRIMARY KEY,
user_id INTEGER UNIQUE NOT NULL, --UNIQUE->Benzersiz oluşturur.
FOREIGN KEY(user_id) REFERENCES users(id) --users tablosundaki ıd'yi referans aldık ve
--yabancı anahtar olarak user_id ile bağladık.
);

--DML -> Data Manipulation Language

--INSERT

INSERT INTO users(name,surname,email,password,gsm)
VALUES ('halit','kalayci','halit@gmail.com','halit61*','+90')

--UPDATE

UPDATE users SET gsm = '+901' , surname='abc'
WHERE id=3; --bu alan önemli unutulursa db'deki her şey güncellenir veya silinir.

--DELETE
--DELETE-> BAĞLI OLDUĞUN FK BİR ÜRÜN VARSA O PK'LI VERŞİ SİLİNEMEZ

DELETE FROM users --Eğer foreign key ile bir yere bağlı değilse silinir, ama bağlıysa silinmez hata verir.
--FOREIGN KEY İLE BAŞKA TABLOYA BAĞLI OLAN TABLOLAR SİLİNMEZ.
WHERE id=3;
--

--SELECT[istenilen_kolonlar] FROM[tablo_adı]
SELECT * FROM users;
SELECT name,surname from users;

SELECT * FROM users WHERE name='merve'
--metinsel verilerde sorgulama büyük-küçük harflere duyarlıdır dikkat etmek gerekir.

--Asc->Ascending (küçükten büyüğe, a-z)
-->Desc->Descending(büyükten küçüğe,z-a)
--Default olan ascending'dir.
--ORDER BY sıralama işlemlerinde kullanılır.

SELECT *FROM users ORDER BY register_date desc;

ALTER TABLE users ADD COLUMN age int;

UPDATE users SET age=26 where id=1;

UPDATE users SET age=35 where id=2;

select *from users order by age desc;
select *from users order by name asc;

--Aggregate Functions
--Bir tablodaki veri sayısını bul.
SELECT COUNT(*) FROM users;
--COUNT(*) koymamızın amacı tüm kolonlar için bakıyor.
--Bir kolondaki min değeri al.
SELECT MIN(age) FROM users;
--Bir kolondaki max değeri al.
SELECT MAX(age) FROM users;
--Bir kolondaki ortalama değeri al.
SELECT AVG(age) FROM users;
--Bir kolondaki tüm değerleri topla.
SELECT SUM(age) FROM users;

--Kalıp
-- Sembol 1-> % ->Burdan sonra,önce kaç harf , hangi harf olduğunu umursamıyorumç

--m ile başlayan isimler
select *from users where  name like 'm%'
--t ile biten isimler
SELECT *FROM users WHERE name LIKE '%t'
--içinde r geçen isimler
SELECT *FROM users WHERE name LIKE '%r%'

-- Sembol 2-> _ ->Burdan sonra,önce hangi harf olduğunu umursamıyorum.
--aşağıdaki sorgu 2 harfli ikinci harfi a olan demek.
SELECT *FROM users WHERE NAME LIKE '_a'

--sondan bir önceki harfi a olan isimler
select *from users where name like '%a_'

--büyük-küçük harf duyarlılığını ortadan kaldırmak için aşağıdaki sorgu kullanılır.
SELECT * FROM users WHERE LOWER(name) LIKE LOWER('%AL%');
--büyük/küçük harf duyarlılığını (case-insensitivity) ortadan kaldıran bir operatördür.postresql de 
SELECT * FROM users WHERE name ILIKE '%al%'
