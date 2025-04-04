public class SklepKomputerowy {
    private Produkt[] produkty;
    private Klient[] klienci;
    private Zamowienie[] zamowienia;
    private int liczbaProduktow;
    private int liczbaKlientow;
    private int liczbaZamowien;

    public SklepKomputerowy() {
        produkty = new Produkt[100];
        klienci = new Klient[100];
        zamowienia = new Zamowienie[100];
        liczbaProduktow = 0;
        liczbaKlientow = 0;
        liczbaZamowien = 0;
    }

    public void dodajProdukt(Produkt produkt) {
        if (liczbaProduktow < produkty.length) {
            produkty[liczbaProduktow++] = produkt;
        } else {
            System.out.println("Brak miejsca na nowe produkty!");
        }
    }

    public void dodajKlienta(Klient klient) {
        if (liczbaKlientow < klienci.length) {
            klienci[liczbaKlientow++] = klient;
        } else {
            System.out.println("Brak miejsca na nowych klientów!");
        }
    }

    public Zamowienie utworzZamowienie(Klient klient, Produkt[] listaProduktow, int[] ilosci) {
        Zamowienie zamowienie = new Zamowienie();
        zamowienie.setId(liczbaZamowien + 1);
        zamowienie.setKlient(klient);
        zamowienie.setProdukty(listaProduktow);
        zamowienie.setIlosci(ilosci);
        zamowienie.setDataZamowienia(java.time.LocalDate.now().toString());
        zamowienie.setStatus("Nowe");

        if (liczbaZamowien < zamowienia.length) {
            zamowienia[liczbaZamowien++] = zamowienie;
        } else {
            System.out.println("Brak miejsca na nowe zamówienia!");
        }
        return zamowienie;
    }

    public void aktualizujStanMagazynowy(Zamowienie zamowienie) {
        Produkt[] listaProduktow = zamowienie.getProdukty();
        int[] ilosci = zamowienie.getIlosci();
        for (int i = 0; i < listaProduktow.length; i++) {
            int aktualnaIlosc = listaProduktow[i].getIloscWMagazynie();
            listaProduktow[i].setIloscWMagazynie(aktualnaIlosc - ilosci[i]);
        }
    }

    public void zmienStatusZamowienia(int idZamowienia, String nowyStatus) {
        for (int i = 0; i < liczbaZamowien; i++) {
            if (zamowienia[i].getId() == idZamowienia) {
                zamowienia[i].setStatus(nowyStatus);
                break;
            }
        }
    }

    public void wyswietlProduktyWKategorii(String kategoria) {
        System.out.println("Produkty w kategorii: " + kategoria);
        for (int i = 0; i < liczbaProduktow; i++) {
            if (produkty[i].getKategoria().equalsIgnoreCase(kategoria)) {
                produkty[i].wyswietlInformacje();
            }
        }
    }

    public void wyswietlZamowieniaKlienta(int idKlienta) {
        System.out.println("Zamówienia klienta o ID: " + idKlienta);
        for (int i = 0; i < liczbaZamowien; i++) {
            if (zamowienia[i].getKlient().getKlientId() == idKlienta) {
                zamowienia[i].wyswietlSzczegoly();
            }
        }
    }
}
