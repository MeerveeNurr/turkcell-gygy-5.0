CREATE DATABASE LibrarySystems;

CREATE TABLE Ogrenci(
   id SERIAL PRIMARY KEY,
   Tckn VARCHAR(11) UNIQUE,
   isim VARCHAR(50) NOT NULL,
   soyisim VARCHAR(50) NOT NULL,
   email VARCHAR(50) NOT NULL,
   kayitTarihi TIMESTAMP NOT NULL,
   AktifMi BOOLEAN NOT NULL
);
INSERT INTO Ogrenci(Tckn, isim, soyisim, email,kayitTarihi,AktifMi)
VALUES ('12345678911','Merve','Kara','merve@gmail.com','2026-04-20',TRUE)

INSERT INTO Ogrenci(Tckn, isim, soyisim, email,kayitTarihi,AktifMi)
VALUES ('23165498722','Ahmet','Aslan','ahmet@gmail.com','2025-07-03',TRUE)

INSERT INTO Ogrenci(Tckn, isim, soyisim, email,kayitTarihi,AktifMi)
VALUES ('32165498799','Selim','Evcen','selim@gmail.com','2024-01-30',FALSE)

SELECT * FROM Ogrenci;

UPDATE Ogrenci  SET  AktifMi=TRUE WHERE ID=2;

DELETE FROM Ogrenci WHERE ID=3;

CREATE TABLE Kitap(
  id SERIAL PRIMARY KEY,
  kitapAdi VARCHAR(50) NOT NULL,
  yazar VARCHAR(50) NOT NULL,
  sayfaSayisi INT NOT NULL,
  raftaMi BOOLEAN NOT NULL
);

INSERT INTO Kitap(kitapAdi,yazar,sayfaSayisi,raftaMi) 
VALUES ('İşte Hayat','İpek Ongun','426',TRUE)

INSERT INTO Kitap(kitapAdi,yazar,sayfaSayisi,raftaMi) 
VALUES ('Genç Werther^in Acıları','Johann Wolfgang von Goethe','108',FALSE)

INSERT INTO Kitap(kitapAdi,yazar,sayfaSayisi,raftaMi) 
VALUES ('Şu Çılgın Türkler','Turgut Özakman','752',FALSE)
SELECT *FROM Kitap;

UPDATE  Kitap SET sayfaSayisi=160 WHERE ID=2

SELECT FROM Kitap
ORDER BY yazar
DESC

CREATE TABLE Gorevli(
  id SERIAL PRIMARY KEY,
  Tckn VARCHAR(11) UNIQUE,
  isim VARCHAR(50) NOT NULL,
  soyisim VARCHAR(50) NOT NULL,
  GorevSuresi TIMESTAMP NOT NULL
);

ALTER TABLE Gorevli 
ALTER COLUMN GorevSuresi TYPE VARCHAR(50);

INSERT INTO Gorevli (Tckn,isim,soyisim,GorevSuresi) VALUES ('74185296333','Murat','Kılıç','8 yıl')

INSERT INTO Gorevli (Tckn,isim,soyisim,GorevSuresi) VALUES ('96321458755','Can','Yıldırım','12 yıl')

INSERT INTO Gorevli (Tckn,isim,soyisim,GorevSuresi) VALUES ('75315964829','Mert','Öztürk','2 yıl')

SELECT *FROM Gorevli;

SELECT isim,soyisim
FROM Gorevli WHERE gorevsuresi>'5 yıl'


CREATE TABLE Odunc(
  id SERIAL PRIMARY KEY,
  ogrenciID INT,
  oduncKitapAdi VARCHAR(50) NOT NULL,
  kitapID INT,
  gorevliID INT,
  alisTarihi TIMESTAMP NOT NULL,
  verisTarihi TIMESTAMP NOT NULL,

  FOREIGN KEY (ogrenciID) REFERENCES Ogrenci(id),
  FOREIGN KEY (kitapID) REFERENCES Kitap(id),
  FOREIGN KEY (gorevliID) REFERENCES Gorevli(id)
);

INSERT INTO Odunc (ogrenciID,oduncKitapAdi,kitapID,gorevliID,alisTarihi,verisTarihi)
VALUES ('1','İşte Hayat','1','1','2026-04-15','2026-04-30')

INSERT INTO Odunc (ogrenciID,oduncKitapAdi,kitapID,gorevliID,alisTarihi,verisTarihi)
VALUES ('2','Genç Werther^in Acıları','2','2','2025-09-14','2025-10-05')

INSERT INTO Odunc (ogrenciID,oduncKitapAdi,kitapID,gorevliID,alisTarihi,verisTarihi)
VALUES ('2','Şu Çılgın Türkler','3','3','2025-08-25','2025-09-04')

SELECT * FROM Odunc;

SELECT * FROM Odunc WHERE oduncKitapAdi LIKE '%a%';

DELETE FROM Odunc WHERE ID=1;

CREATE TABLE Iade(
  id SERIAL PRIMARY KEY,
  iadeEdilenKitapAdi VARCHAR(50) NOT NULL,
  iadeEdenOgrenciID INT NOT NULL,
  iadeTarihi TIMESTAMP NOT NULL,
  gecikmeSuresi VARCHAR(10),

  FOREIGN KEY (iadeEdenOgrenciID) REFERENCES Ogrenci(id)
);

INSERT INTO Iade (iadeEdilenKitapAdi,iadeEdenOgrenciID,iadeTarihi,gecikmeSuresi) 
VALUES('İşte Hayat','1','2026-02-06',NULL)

INSERT INTO Iade (iadeEdilenKitapAdi,iadeEdenOgrenciID,iadeTarihi,gecikmeSuresi) 
VALUES('Genç Werther^in Acıları','1','2025-06-06','4 gün')

INSERT INTO Iade (iadeEdilenKitapAdi,iadeEdenOgrenciID,iadeTarihi,gecikmeSuresi) 
VALUES('Şu Çılgın Türkler','2','2026-04-08','25 gün')

SELECT * FROM Iade
ORDER BY iadeEdilenKitapAdi
ASC

SELECT *FROM Iade WHERE gecikmeSuresi IS NULL


CREATE TABLE Ceza(
  id SERIAL PRIMARY KEY,
  cezaliOgrenciAdi VARCHAR(50) NOT NULL,
  cezaOdendiMi BOOLEAN NOT NULL,
  cezaliKitapAdi VARCHAR(50) NOT NULL
);

INSERT INTO Ceza (cezaliOgrenciAdi,cezaOdendiMi,cezaliKitapAdi)
VALUES ('Merve',TRUE,'İşte Hayat')
INSERT INTO Ceza (cezaliOgrenciAdi,cezaOdendiMi,cezaliKitapAdi)
VALUES ('Selim',TRUE,'Genç Werther^in Acıları')
INSERT INTO Ceza (cezaliOgrenciAdi,cezaOdendiMi,cezaliKitapAdi)
VALUES ('Ahmet',FALSE,'Şu Çılgın Türkler')

SELECT * FROM Ceza;

DELETE FROM Ceza WHERE cezaOdendiMi=FALSE;

UPDATE Ceza SET cezaOdendiMi=FALSE WHERE ID=2;