package arsw.threads;

/**
 * Un galgo que puede correr en un carril
 * 
 * @author rlopez
 * 
 */
public class Galgo extends Thread {
	private int paso;
	private Carril carril;
	Controlador controlador;

	public Galgo(Carril carril, String name,Controlador controlador) {
		super(name);
		this.carril = carril;
		paso = 0;
		this.controlador=controlador;
	}

	public void corra() throws InterruptedException {
		while (paso < carril.size()) {			
			Thread.sleep(100);
			carril.setPasoOn(paso++);
			carril.displayPasos(paso);
			
			if (paso == carril.size()) {						
				carril.finish();
                                controlador.actualizarLlegada(this.getName());
			}
		}
	}
	@Override
	public void run() {
		
		try {
			corra();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
