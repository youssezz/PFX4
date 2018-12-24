package application;

public class OffreStage {
	String nomEnt, dmn, libl, dateDebut, duree, chemin, desc; 

	OffreStage(String nomEnt, String dmn, String libl, String dateDebut, String duree, String chemin, String desc){
		this.nomEnt = nomEnt;
		this.dmn = dmn;
		this.libl = libl;
		this.dateDebut = dateDebut;
		this.duree = duree;
		this.chemin = chemin;
		this.desc = desc;
	}
	
	public void exporter(){
		GestionBDD gestbdd = new GestionBDD();

		gestbdd.exporterOffre(nomEnt, dmn, libl, dateDebut, duree, chemin, desc);
	}
}
