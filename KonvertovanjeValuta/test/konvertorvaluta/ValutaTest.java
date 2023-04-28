/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konvertorvaluta;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nemanja
 */
public class ValutaTest {
    
    public List<Valuta> getValuteList(){
        List<Valuta> valute = new ArrayList<>();
        valute.add(new Valuta("Euro", "EUR", 117.231));
        valute.add(new Valuta("Americki dolar", "USD", 105.771));
        valute.add(new Valuta("Svajcarski franak", "CHF", 118.672));
        valute.add(new Valuta("Britanska funta", "GBP", 131.917));
        valute.add(new Valuta("BIH konvertabilna marka", "BAM", 59.830));
        
        return valute;
    }
    
    // --------------------//
    //   TESTOVI ZA OZNAKU //
    // --------------------//
    
    @Test
    public void testProveriOznaku1() {
        System.out.println("proveriOznaku");
        String oznaka = "1";
        List<Valuta> valute = getValuteList();
        boolean expResult = false;
        boolean result = Valuta.proveriOznaku(oznaka, valute);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testProveriOznaku2() {
        System.out.println("proveriOznaku");
        String oznaka = "USD";
        List<Valuta> valute = getValuteList();
        boolean expResult = true;
        boolean result = Valuta.proveriOznaku(oznaka, valute);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testProveriOznaku3() {
        System.out.println("proveriOznaku");
        String oznaka = "eUr";
        List<Valuta> valute = getValuteList();
        boolean expResult = true;
        boolean result = Valuta.proveriOznaku(oznaka, valute);
        assertEquals(expResult, result);
    }
    
    // ---------------------------//
    //  TESTOVI ZA KONV. U DEVIZE //
    // ---------------------------//       
    
    @Test
    public void testKonvertujUDevizu1() {
        System.out.println("konvertujUDevizu");
        double dinar = 150.0;
        Valuta val = new Valuta("Euro", "EUR", 117.231);
        double expResult = 1.3;
        double result = Valuta.konvertujUDevizu(dinar, val);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testKonvertujUDevizu2() {
        System.out.println("konvertujUDevizu");
        double dinar = 1234.56;
        Valuta val = new Valuta("Britanska funta", "GBP", 131.917);
        double expResult = 9.4;
        double result = Valuta.konvertujUDevizu(dinar, val);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testKonvertujUDevizu3() {
        System.out.println("konvertujUDevizu");
        double dinar = 125.0;
        Valuta val = new Valuta("Valuta TEST", "TST", 0.0);
        double expResult = 0.0;
        double result = Valuta.konvertujUDevizu(dinar, val);
        assertEquals(expResult, result, 0.0);
    }
       
    // ---------------------------//
    //  TESTOVI ZA KONV. U DINARE //
    // ---------------------------// 

    @Test
    public void testKonvertujUDinare1() {
        System.out.println("konvertujUDinare");
        double deviza = 5.0;
        Valuta val = new Valuta("Euro", "EUR", 117.231);
        double expResult = 586.2;
        double result = Valuta.konvertujUDinare(deviza, val);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testKonvertujUDinare2() {
        System.out.println("konvertujUDinare");
        double deviza = 10.0;
        Valuta val = new Valuta("Valuta TEST", "TST", 0.0);
        double expResult = 0.0;
        double result = Valuta.konvertujUDinare(deviza, val);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testKonvertujUDinare3() {
        System.out.println("konvertujUDinare");
        double deviza = -20.0;
        Valuta val = new Valuta("Euro", "EUR", 117.231);
        double expResult = 0.0;
        double result = Valuta.konvertujUDinare(deviza, val);
        assertEquals(expResult, result, 0.0);
    }
    
    // -----------------------//
    //  TESTOVI ZAOKRUZIVANJA //
    // -----------------------// 
    
    @Test
    public void testZakruziNa1Decimalu1() {
        System.out.println("zakruziNa1Decimalu");
        double iznos = 100.0;
        double expResult = 100.0;
        double result = Valuta.zakruziNa1Decimalu(iznos);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testZakruziNa1Decimalu2() {
        System.out.println("zakruziNa1Decimalu");
        double iznos = 12.3456;
        double expResult = 12.3;
        double result = Valuta.zakruziNa1Decimalu(iznos);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testZakruziNa1Decimalu3() {
        System.out.println("zakruziNa1Decimalu");
        double iznos = 9.9999;
        double expResult = 10.0;
        double result = Valuta.zakruziNa1Decimalu(iznos);
        assertEquals(expResult, result, 0.0);
    }
    
}
