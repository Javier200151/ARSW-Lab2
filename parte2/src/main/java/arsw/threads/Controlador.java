/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arsw.threads;

/**
 *
 * @author Acer
 */
public class Controlador {
    private RegistroLlegada regl;
    
    public Controlador(RegistroLlegada regl){
        this.regl=regl;
    }
    
    public synchronized void actualizarLlegada(String name){
	int ubicacion=regl.getUltimaPosicionAlcanzada();
	regl.setUltimaPosicionAlcanzada(ubicacion+1);
	System.out.println("El galgo "+name+" llego en la posicion "+ubicacion);
	if (ubicacion==1){
            regl.setGanador(name);
        }       
    
    }
}
