/**
*PM2 Paktikum
*@autor Johannes Kruber
*@autor Luis Nickel
*/
package aufgabe3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Simulation extends Observable implements Observer,Runnable  {
	
	private Rangierbahnhof bahnhof;
	private List<Lokfuehrer> warteschlangeLokfuehrer;
	public List<Zug> zugliste;
	
	
	public Simulation(Rangierbahnhof bahnhof){
		this.bahnhof=bahnhof;
		this.bahnhof.addObserver(this);
		warteschlangeLokfuehrer=new ArrayList<Lokfuehrer>();
		zugliste= new ArrayList<Zug>();
		for(int i=0; i< bahnhof.getGleiszahl(); i++)
		{
			zugliste.add(bahnhof.getZug(i));
		}
	}

	@Override
	public void run() {
		while(!Thread.interrupted()){
			boolean aufgabe;
			//einfahren
			if(Math.random()<0.5){
				aufgabe=true;
			}//ausfahren
			else{
				aufgabe=false;
			}
			int gleis=(int)(Math.random()*bahnhof.getGleiszahl());
			Lokfuehrer lokfuehrer =new Lokfuehrer(aufgabe,bahnhof,gleis);
			if(istAufgabeMoeglich(aufgabe, gleis)){
				lokfuehrer.start();
			}
			else{
				System.out.println(" setztWarteListe Gleis "+lokfuehrer.getGleis()+" Aufgabe:"+lokfuehrer.getAufgabe());
				warteschlangeLokfuehrer.add(lokfuehrer);		
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		for(int i=0; i< bahnhof.getGleiszahl(); i++)
		{
			zugliste.set(i, bahnhof.getZug(i));
		}
		setChanged();
		notifyObservers();
		pruefeWarteschlange();
	}
	
	private void pruefeWarteschlange(){
		
		for(Iterator<Lokfuehrer> it=warteschlangeLokfuehrer.iterator();it.hasNext();){
			Lokfuehrer lokfuehrer=it.next();
			if(istAufgabeMoeglich(lokfuehrer.getAufgabe(),lokfuehrer.getGleis())){
				System.out.println(" entfernt"+lokfuehrer.getGleis()+" Aufgabe:"+lokfuehrer.getAufgabe());
				warteschlangeLokfuehrer.remove(lokfuehrer);
				lokfuehrer.start();
				break;
				
			}
		}
	}
	
	private boolean istAufgabeMoeglich(boolean aufgabe, int gleis){
		if(aufgabe && bahnhof.isReserved(gleis)){
			return false;
		}
		else if(aufgabe && !bahnhof.isReserved(gleis)){
			return true;	
		}
		else if(!aufgabe && bahnhof.getZug(gleis) != null){
			return true;		
		}
		else{
			return false;
		}
		
	}
	
//	public static void main(String[] args) {
//	
//		Rangierbahnhof bahnhof=new Rangierbahnhof(10);
//		Simulation sims=new Simulation(bahnhof);
//		sims.run();
//	}
}
