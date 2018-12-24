package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AcceuilControlleur {
	// ----------- DEBUT DES ATTRIBUTS
	@FXML
	private Button consulterStage;

	@FXML
	private Button creerEntreprise;

	@FXML
	private Button saisirOffreStage;

	@FXML
	private Button connexion;

	// CONSTRUCTEUR PAR DEFAUT
	public AcceuilControlleur() {
		// LE CONSTRUCTEUR DU CONTROLLEUR DOIT TOUJOURS ETRE VIDE !

	}

	@FXML
	public void clicConsulterOffreStage(ActionEvent event) {
		((Node) (event.getSource())).getScene().getWindow().hide();
		try {
			Stage primaryStage = new Stage();

			// CREE UN FICHIER FXML (VIDE POUR L'INSTANT)
			FXMLLoader loader = new FXMLLoader();
			// DONNE LE CHEMIN AU FICHIER FXML CREE AU-DESSUS
			loader.setLocation(Main.class.getResource("Acceuil.fxml"));

			// DONNE AU FICHIER RACINE LE FXML CREE PRECEDEMENT
			BorderPane rootLayout = (BorderPane) loader.load();

			// LA SCENE CONTIENDRA NOTRE PANE RACINE
			Scene scene = new Scene(rootLayout);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void clicCreerEntreprise(ActionEvent event) {
		((Node) (event.getSource())).getScene().getWindow().hide();

		try {
			Stage primaryStage = new Stage();

			// DONNE LE TITRE A LA FENETRE
			primaryStage.setTitle("Création d'une entreprise");
			
			// CREE UN FICHIER FXML (VIDE POUR L'INSTANT)
			FXMLLoader loader = new FXMLLoader();
			// DONNE LE CHEMIN AU FICHIER FXML CREE AU-DESSUS
			loader.setLocation(Main.class.getResource("CreationEntreprise.fxml"));

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

	@FXML
	public void clicSaisirOffreStage(ActionEvent event) {
		((Node) (event.getSource())).getScene().getWindow().hide();
		try {
			Stage primaryStage = new Stage();
			// DONNE LE TITRE A LA FENETRE
						primaryStage.setTitle("Saisie d'une offre de stage");
			// CREE UN FICHIER FXML (VIDE POUR L'INSTANT)
			FXMLLoader loader = new FXMLLoader();
			// DONNE LE CHEMIN AU FICHIER FXML CREE AU-DESSUS
			loader.setLocation(Main.class.getResource("SaisieOffreDeStage.fxml"));

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

	@FXML
	public void clicConnexion(ActionEvent event) {
		((Node) (event.getSource())).getScene().getWindow().hide();
		try {
			Stage primaryStage = new Stage();
			
			// DONNE LE TITRE A LA FENETRE
			primaryStage.setTitle("Connexion");
			
			// CREE UN FICHIER FXML (VIDE POUR L'INSTANT)
			FXMLLoader loader = new FXMLLoader();
			// DONNE LE CHEMIN AU FICHIER FXML CREE AU-DESSUS
			loader.setLocation(Main.class.getResource("Connexion.fxml"));

			// DONNE AU FICHIER RACINE LE FXML CREE PRECEDEMENT
			BorderPane rootLayout = (BorderPane) loader.load();

			// LA SCENE CONTIENDRA NOTRE PANE RACINE
			Scene scene = new Scene(rootLayout);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
