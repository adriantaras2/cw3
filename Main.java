public class Main {
    public static void main(String[] args) {
        SklepKomputerowy sklep = new SklepKomputerowy();

        Produkt p1 = new Produkt();
        p1.setId(1);
        p1.setNazwa("Laptop Lenovo L13");
        p1.setKategoria("Laptopy");
        p1.setCena(2137.99);
        p1.setIloscWMagazynie(5);

        Produkt p2 = new Produkt();
        p2.setId(2);
        p2.setNazwa("Mysz 'Chomik''");
        p2.setKategoria("Akcesoria");
        p2.setCena(21.15);
        p2.setIloscWMagazynie(20);

        Produkt p3 = new Produkt();
        p3.setId(3);
        p3.setNazwa("Monitor Samsung");
        p3.setKategoria("Monitory");
        p3.setCena(420.77);
        p3.setIloscWMagazynie(8);

        sklep.dodajProdukt(p1);
        sklep.dodajProdukt(p2);
        sklep.dodajProdukt(p3);

        Klient k1 = new Klient();
        k1.setId(1);
        k1.setImie("Adrian");
        k1.setNazwisko("Taras");
        k1.setEmail("at@gmail.com");
        k1.setCzyStaly(true);

        Klient k2 = new Klient();
        k2.setId(2);
        k2.setImie("Adrian");
        k2.setNazwisko("Balkon");
        k2.setEmail("ab@gmail.com");
        k2.setCzyStaly(false);

        sklep.dodajKlienta(k1);
        sklep.dodajKlienta(k2);

        Produkt[] produktyZam1 = { p1, p2 };
        int[] ilosciZam1 = { 1, 2 };
        Zamowienie z1 = sklep.utworzZamowienie(k1, produktyZam1, ilosciZam1);
        z1.zastosujZnizke();
        sklep.aktualizujStanMagazynowy(z1);

        System.out.println("Szczegóły 1. zamówienia:");
        z1.wyswietlSzczegoly();

        System.out.println("\nAktualny stan magazynowy:");
        sklep.wyswietlProduktyWKategorii("Laptopy");
        sklep.wyswietlProduktyWKategorii("Akcesoria");

        sklep.zmienStatusZamowienia(z1.getId(), "Zrealizowane");
        System.out.println("\nStatus zamówienia po aktualizacji:");
        z1.wyswietlSzczegoly();

        Produkt[] produktyZam2 = { p3, p2 };
        int[] ilosciZam2 = { 1, 1 };
        Zamowienie z2 = sklep.utworzZamowienie(k2, produktyZam2, ilosciZam2);
        sklep.aktualizujStanMagazynowy(z2);

        System.out.println("Zamówienia klienta Adrian Taras:");
        sklep.wyswietlZamowieniaKlienta(k1.getKlientId());
    }
}
