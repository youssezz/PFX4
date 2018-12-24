package application;

import java.util.LinkedList;

public class Entreprise {
	private String nomEnt, rue, codePostal, ville, mail, numTel, sectActv;

	Entreprise(String nomEnt, String rue, String codePostal, String ville, String mail, String numTel, String sectActv){
		this.nomEnt = nomEnt;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.mail = mail;
		this.numTel = numTel;
		this.sectActv = sectActv;
	}
	
	public void exporter(){
		GestionBDD gstbdd = new GestionBDD();

		gstbdd.exporterEnt(nomEnt, rue, codePostal, ville, mail, numTel, sectActv);
	}
	
	public void importer(){
		GestionBDD gstbdd = new GestionBDD();
		
		LinkedList<String> listEnt = gstbdd.importEnt();
		nomEnt = listEnt.get(0);
		rue = listEnt.get(1);
		codePostal = listEnt.get(2);
		ville = listEnt.get(3);
		mail = listEnt.get(4);
		numTel = listEnt.get(5);
		sectActv = listEnt.get(6);
		
		// Voir pour retourner un objet entreprise / une liste d'entreprises dans la méthode importer de GestionBDD
	}
	
	public String getNomEnt(){
		return nomEnt;
	}
	
	public String getSectActv(){
		return sectActv;
	}
}
