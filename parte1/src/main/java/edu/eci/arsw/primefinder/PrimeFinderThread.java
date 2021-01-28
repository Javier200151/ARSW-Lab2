package edu.eci.arsw.primefinder;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrimeFinderThread extends Thread{

	
	int a,b;
	
	private List<Integer> primes=new LinkedList<Integer>();
        private boolean detener;
	
	public PrimeFinderThread(int a, int b) {
		super();
		this.a = a;
		this.b = b;
                detener=false;
                
	}
        
        public static PrimeFinderThread iniciador(int a, int b)
        {
            PrimeFinderThread pft = new PrimeFinderThread(a,b);
            pft.start();
            return pft;
        }

	public void run(){
            System.out.println("Hilo Inició");
            try {
		for (int i=a;i<=b;i++){						
			if (isPrime(i)){
				primes.add(i);
				System.out.println(i);
			}
                    synchronized (this) {
                        while (detener) {                      
                            wait();                      
                        }
                }
		}
                
            } catch (InterruptedException ex) {
                Logger.getLogger(PrimeFinderThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Hilo Terminó");
		
	}
        
        synchronized void detenerhilo(){
            detener=true;
        }
        synchronized void renaudarhilo(){
            detener=false;
            notify();
        }
	
	boolean isPrime(int n) {
	    if (n%2==0) return false;
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}

	public List<Integer> getPrimes() {
		return primes;
	}
	
	
	
	
}
