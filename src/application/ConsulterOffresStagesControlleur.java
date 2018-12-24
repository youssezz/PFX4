package application;

import java.sql.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import modeles.OffreDeStage;

public class ConsulterOffresStagesControlleur {

	// ATTRIBUTS
	
	// LE TABLEAU	
	@FXML
	private TableView <OffreDeStage> lesOffresDeStages ;
	
	// LES COLONNES DU TABLEAU
	// LE PREMIER PARAMETRE CORRESPOND AUX OBJETS DU TABLE VIEW
	// LE DEUXIEME AU TABLECOLUMN
	@FXML
	private TableColumn<OffreDeStage, String> entreprises ;
	
	@FXML
	private TableColumn<OffreDeStage, String> libelles ;
	
	@FXML
	private TableColumn<OffreDeStage, Date> dateDeDebut ;
	
	@FXML
	private TableColumn<OffreDeStage, Integer> durees ;
	
	//NOTRE OBSERVABLELIST
	private ObservableList<OffreDeStage> tousLesStages = FXCollections.observableArrayList();
	// -------------------------------
	
	public ConsulterOffresStagesControlleur () {
		//CONSTRUCTEUR DU CONTROLLEUR DOIT TOUJOURS ETRE VIDE
	}
	
	
	@FXML
	public void initialize () {
		// AJOUTER DES ELEMENTS A NOTRE OBSERVABLE LIST
		// tousLesStages.add(...)
		
		// ENTRER LA LISTE DANS NOTRE TABLE VIEW
		//lesOffresDeStages.setItems(tousLesStages);
		
		// VOICI LA METHODE POUR AFFICHER DES DONNEES DANS UN TABLE 
		entreprises.setCellValueFactory(cellData -> cellData.getValue().getNomDeEntreprise());
		libelles.setCellValueFactory(cellData -> cellData.getValue().getLibelle());
		
		// POUR LES INTEGERPROPERTY NE PAS OUBLIER LE ASOBJECT A LA FIN
		durees.setCellValueFactory(cellData -> cellData.getValue().getDuree().asObject());
	}
}
