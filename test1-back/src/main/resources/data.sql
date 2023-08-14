INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');
                        
INSERT INTO format (id, tip, broj_ucesnika) VALUES (1, 'Grand slam', '10');
INSERT INTO format (id, tip, broj_ucesnika) VALUES (2, 'Masters 1000', '15');
INSERT INTO format (id, tip, broj_ucesnika) VALUES (3, 'Masters 500', '20');
INSERT INTO format (id, tip, broj_ucesnika) VALUES (4, 'Masters 250', '30');

INSERT INTO takmicenje (naziv, mesto_odrzavanja, datum_pocetka, datum_zavrsetka, format_id) VALUES ('Australian Open', 'Melbourne', '2022-01-10', '2022-01-20', 1);
INSERT INTO takmicenje (naziv, mesto_odrzavanja, datum_pocetka, datum_zavrsetka, format_id) VALUES ('Wimbledon', 'London', '2022-06-10', '2022-06-20', 1);
INSERT INTO takmicenje (naziv, mesto_odrzavanja, datum_pocetka, datum_zavrsetka, format_id) VALUES ('Paris 1000', 'Paris', '2022-05-10', '2022-05-20', 2);
INSERT INTO takmicenje (naziv, mesto_odrzavanja, datum_pocetka, datum_zavrsetka, format_id) VALUES ('Banja Luka Open', 'Banja Luka', '2022-03-10', '2022-03-20', 4);

INSERT INTO prijava (drzava, email, datum_prijave, takmicenje_id) VALUES ('SRB', 'perisic@yahoo.com', '2022-03-10', 1);
INSERT INTO prijava (drzava, email, datum_prijave, takmicenje_id) VALUES ('SRB', 'Milica@yahoo.com', '2022-03-10', 4);
INSERT INTO prijava (drzava, email, datum_prijave, takmicenje_id) VALUES ('RUS', 'medvedev@yahoo.com', '2022-03-10', 3);
INSERT INTO prijava (drzava, email, datum_prijave, takmicenje_id) VALUES ('USA', 'Eubanks@yahoo.com', '2022-03-10', 2);