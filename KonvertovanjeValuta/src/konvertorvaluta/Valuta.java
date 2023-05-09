/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konvertorvaluta;

import java.util.List;

/**
 *
 * @author Nemanja
 */
public class Valuta {
    private String naziv;
    private String oznaka;
    private double kurs;

    public Valuta(String naziv, String oznaka, double kurs) {
        this.naziv = naziv;
        this.oznaka = oznaka;
        this.kurs = kurs;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public double getKurs() {
        return kurs;
    }

    public void setKurs(double kurs) {
        this.kurs = kurs;
    }

    @Override
    public String toString() {
        return oznaka + " - " + naziv;
    }
    
    public String toStringList() {
        return naziv + " (" + oznaka + ") || Kurs: " + kurs;
    }
    
    public static boolean proveriOznaku(String oznaka,List<Valuta> valute){
        for (int i = 0; i < valute.size(); i++) {
            if(valute.get(i).getOznaka().equalsIgnoreCase(oznaka)){
                return true;
            }
        }
        return false;
    }
       
    public static double konvertujUDevizu(double dinar, Valuta val){
        if(val.kurs == 0){
            return 0;
        }
            
        double deviza = dinar / val.kurs;
        return(zakruziNa1Decimalu(deviza));
    }
    
    public static double konvertujUDinare(double deviza, Valuta val){
        double dinar = deviza * val.kurs;
        return(zakruziNa1Decimalu(dinar));
    }
    
    public static double zakruziNa1Decimalu(double iznos)
    {
        return Math.round(iznos * 10.0) / 10.0;
    }    
    
    
}
