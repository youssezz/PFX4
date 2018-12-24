package application;

import java.util.LinkedList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SaisieOffreDeStageControlleur {

	// ----------- DEBUT DES ATTRIBUTS
	@FXML
	private Button confirmer;
	@FXML
	private Button annuler;

	@FXML
	private ChoiceBox<String> nomDeL_Entreprise;
	@FXML
	private ChoiceBox<Integer> duree;

	@FXML
	private TextField domaineDeL_Offre;
	@FXML
	private TextField libelleDeL_Offre;
	@FXML
	private TextField cheminDeL_Offre;

	@FXML
	private DatePicker dateDeDebut;

	private LinkedList<String> listEnt = Main.gst.importEnt();
	
	static String nomEnt, dmn, libl, dateDebut, temps, chemin;
	
	

	// CONSTRUCTEUR VIDE
	public SaisieOffreDeStageControlleur() {
		// LE CONSTRUCTEUR DU CONTROLLEUR DOIT TOUJOURS ETRE VIDE !

	}

	// PERMET D'INITIALISER DES DONNEES DANS L'INTERFACE GRAPHIQUE
	@FXML
	public void initialize() {
		// AJOUT DES ENTREPRISES À LA LISTE
		for(String s : listEnt){
			nomDeL_Entreprise.getItems().add(s);
		}
		
		// UN STAGE VA DE 1 À 6 MOIS
		for(int i = 1; i < 7; i++){
			duree.getItems().add(i);
		}
	}

	@FXML
	public void confirmerAction(ActionEvent event) {
		// SI L'UTILISATEUR NE MET PAS DE DATE DE DEBUT
		// ON NE PEUT PAS AVANCER
		if (nomDeL_Entreprise.getValue() == null || domaineDeL_Offre.getText().isEmpty() || libelleDeL_Offre.getText().isEmpty() || dateDeDebut.getValue() == null || duree.getValue() == null || cheminDeL_Offre.getText().isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Attention !");
			alert.setHeaderText("Vous n'avez pas rempli tous les champs !");
			alert.showAndWait();
		}
		// SI TOUS LES CHAMPS SONT REMPLIS CONVENABLEMENT
		// ON PASSE A LA FENETRE SUIVANTE
		else {
			((Node) (event.getSource())).getScene().getWindow().hide();
			System.out.println("Vous avez rempli tous les champs !");
			
			nomEnt = nomDeL_Entreprise.getValue();
			dmn = domaineDeL_Offre.getText();
			libl = libelleDeL_Offre.getText();
			dateDebut = dateDeDebut.getValue().toString();
			temps = duree.getValue().toString();
			chemin = cheminDeL_Offre.getText();
			
			try {
				Stage primaryStage = new Stage();

				// CREE UN FICHIER FXML (VIDE POUR L'INSTANT)
				FXMLLoader loader = new FXMLLoader();
				// DONNE LE CHEMIN AU FICHIER FXML CREE AU-DESSUS
				loader.setLocation(Main.class.getResource("SaisieOffreDeStage2.fxml"));

				// DONNE AU FICHIER RACINE LE FXML CREE PRECEDEMENT
				BorderPane rootLayout = (BorderPane) loader.load();

				// LA SCENE CONTIENDRA NOTRE PANE RACINE
				Scene scene = new Scene(rootLayout);

				primaryStage.setScene(scene);
				primaryStage.setResizable(false);
				primaryStage.show();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	// EVENEMENT LORSQUE L'ON CLIQUE SUR ANNULER
	@FXML
	public void annulerAction(ActionEvent event) {
		((Node) (event.getSource())).getScene().getWindow().hide();
		
		// SI L'UTILISATEUR A DEJA ENTRE DES VALEURS
		// ON LUI DEMANDE SI IL VEUT BIEN ANNULER SA SAISIE
		if (nomDeL_Entreprise.getValue() != null || dateDeDebut.getValue() != null || duree.getValue() != null) {
			System.out.println("Voulez vous annuler votre saisie ?");
		}
		// SI IL N'Y A AUCUNE DONNEE SAISIE
		// ON REVIENT A L'ACCEUIL
		else {
			
		}
	}
}
