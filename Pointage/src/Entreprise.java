
import java.util.ArrayList;

public class Entreprise {
 
	private ArrayList <Salarie> salaries = new ArrayList <Salarie>();
	private long regleDeGestion=500;
	
	public ArrayList <Salarie> getSalaries() {
		return salaries;
	}
	
	
	//Singleton (Design Pattern)
	private Entreprise(){
		Bienvenue test = new Bienvenue();
		test.setVisible(true);	
	}
	private static Entreprise INSTANCE=null;
	
	
	
	public static Entreprise getInstance(){
		if (INSTANCE==null){
			INSTANCE= new Entreprise();
		}
		return INSTANCE;
	}
	
	
	
	
	public void enregistrerSalarie (Salarie e,Programme p){
		
		this.getSalaries().add(e);
		e.setEntreprise(this);
		e.setProgramme(p);
	}
	
	public void retirerSalarie (Salarie e){
		this.getSalaries().remove(e);
	}
	
	public void listerCompteDesSalaries () {
		for (int i = 0; i<this.getSalaries().size();i++) {
			this.getSalaries().get(i).comptePersonnel();
		}
	}
	
	public void retardEstJusitfie(Salarie e, long l) throws RetardDejaNulException {
		boolean salarieTrouve=false;
		int i=0;
		while (salarieTrouve==false && i<this.getSalaries().size()){
			if (this.getSalaries().get(i)==e){
				salarieTrouve=true;
				long a = this.getSalaries().get(i).getRetard();
				if (a==0){
					throw  new RetardDejaNulException ();
				}
				else {
					this.getSalaries().get(i).setRetard(a-l);
					System.out.println("Retard justifi� avec succ�s");
				}
			}
			i++;
		}
		
	}
	
	
	public void nouvelleAnnee () {
		System.out.println("Bienvenue � la nouvelle Ann�e : ");
		for (int i = 0; i<this.getSalaries().size();i++) {
			this.getSalaries().get(i).setRetard(0);
			this.getSalaries().get(i).setAvance(0);
			this.getSalaries().get(i).comptePersonnel();
		}
	}
	
	public void listerHistoriqueEntree () {
		for (int i = 0; i<this.getSalaries().size();i++) {
			this.getSalaries().get(i).consulterHistorique();
		}
	}
	

	public long getRegleDeGestion() {
		return regleDeGestion;
	}


	public void setRegleDeGestion(long regleDeGestion) {
		this.regleDeGestion = regleDeGestion;
	}
	
	



	
}
