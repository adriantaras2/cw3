public class Zamowienie {
    private int id;
    private Klient klient;
    private Produkt[] produkty;
    private int[] ilosci;
    private String dataZamowienia;
    private String status;
    private boolean znizkaZastosowana = false;

    public Zamowienie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public Produkt[] getProdukty() {
        return produkty;
    }

    public void setProdukty(Produkt[] produkty) {
        this.produkty = produkty;
    }

    public int[] getIlosci() {
        return ilosci;
    }

    public void setIlosci(int[] ilosci) {
        this.ilosci = ilosci;
    }

    public String getDataZamowienia() {
        return dataZamowienia;
    }

    public void setDataZamowienia(String dataZamowienia) {
        this.dataZamowienia = dataZamowienia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double obliczWartoscZamowienia() {
        double suma = 0.0;
        if (produkty != null && ilosci != null && produkty.length == ilosci.length) {
            for (int i = 0; i < produkty.length; i++) {
                suma += produkty[i].getCena() * ilosci[i];
            }
        }
        if (znizkaZastosowana) {
            suma *= 0.9;
        }
        return suma;
    }

    public void zastosujZnizke() {
        if (klient != null && klient.isCzyStaly()) {
            znizkaZastosowana = true;
        }
    }

    public void wyswietlSzczegoly() {
        System.out.println("Zamówienie nr " + id);
        System.out.println("Data zamówienia: " + dataZamowienia);
        System.out.println("Status: " + status);
        if (klient != null) {
            System.out.println("Klient: " + klient.getImie() + " " + klient.getNazwisko());
        }
        System.out.println("produkty:");
        if (produkty != null && ilosci != null && produkty.length == ilosci.length) {
            for (int i = 0; i < produkty.length; i++) {
                System.out.println("  " + produkty[i].getNazwa() + " - ilość: " + ilosci[i] + ", cena: " + produkty[i].getCena() + " PLN");
            }
        }
        System.out.println("Łączna wartość zamówienia: " + obliczWartoscZamowienia() + " PLN");
    }
}
