package edu.eci.arsw.primefinder;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	public synchronized static void main(String[] args) {
            PrimeFinderThread thread1 = PrimeFinderThread.iniciador(0,10000000);
            PrimeFinderThread thread2 = PrimeFinderThread.iniciador(10000001,20000000);
            PrimeFinderThread thread3 = PrimeFinderThread.iniciador(20000001,30000000);   
            try {
                /*
                PrimeFinderThread pft=new PrimeFinderThread(0, 30000000);
                
                pft.start();
                */

                Thread.sleep(5000);
                
                thread1.detenerhilo();
                thread2.detenerhilo();
                thread3.detenerhilo();
                System.out.println("Deteniendo Hilo.");
                
                promptEnterKey();
                
                thread1.renaudarhilo();
                thread2.renaudarhilo();
                thread3.renaudarhilo();
                System.out.println("Renaudando Hilo.");
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }     
        
        public static void promptEnterKey(){
        System.out.println("Press \"ENTER\" to continue...");
        try {
            int read = System.in.read(new byte[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
