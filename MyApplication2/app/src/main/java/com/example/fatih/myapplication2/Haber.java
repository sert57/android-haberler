package com.example.fatih.myapplication2;

public class Haber
{
    public String baslik;
    public String resimURL;
    public String link;
    public String icon;
    public String saat;

    public Haber(String baslik, String resimURL, String link,String icon,String saat)
    {
        this.baslik = baslik;
        this.resimURL = resimURL;
        this.link = link;
        this.icon = icon;
        this.saat=saat;
    }

    @Override
    public String toString() {
        return "Baslik = "+baslik+"\nLink : "+link+"\nIcon : "+icon+"\nSaat: "+saat+"\nResim URL : "+resimURL+"\n\n";
    }
}
