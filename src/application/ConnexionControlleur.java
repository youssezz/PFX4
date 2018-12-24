package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ConnexionControlleur {

	// @FXML
	// private ChoiceBox<String> role;

	@FXML
	private TextField identifiant;

	@FXML
	private TextField motDePasse;

	@FXML
	private Button confirmer;

	@FXML
	private Button retour;

	public ConnexionControlleur() {
		// LE CONSTRUCTEUR DU CONTROLLEUR DOIT TOUJOURS ETRE VIDE
	}

	// PERMET D'INITIALISER DES DONNEES DANS L'INTERFACE GRAPHIQUE
	@FXML
	public void initialize() {
		// // DONNE DES VALEURS AU CHOICEBOX
		// role.getItems().add("un étudiant");
		// role.getItems().add("une entreprise");
		// role.getItems().add("l'administrateur");
		// // MET UNE VALEUR PAR DEFAUT AU CHOICEBOX
		// role.setValue("un étudiant");
	}

	@FXML
	public void clicConfirmer(ActionEvent event) {
		if (identifiant.getText().isEmpty() || motDePasse.getText().isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Attention !");
			alert.setHeaderText("Vous n'avez pas rempli tous les champs !");
			alert.showAndWait();
		} else {
			((Node) (event.getSource())).getScene().getWindow().hide();
			String id = identifiant.getText();
			String mdp = motDePasse.getText();

			if (Main.gst.connexion(id, mdp) == false) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Attention !");
				alert.setHeaderText("Identifiant ou mot de passe incorrect");
				alert.showAndWait();
			} else { // SINON CHARGEMENT PAGE CREATION D'ENTREPRISE (TEMPORAIRE)
				((Node) (event.getSource())).getScene().getWindow().hide();
				try {
					Stage primaryStage = new Stage();

					// CREE UN FICHIER FXML (VIDE POUR L'INSTANT)
					FXMLLoader loader = new FXMLLoader();
					// DONNE LE CHEMIN AU FICHIER FXML CREE AU-DESSUS
					loader.setLocation(Main.class.getResource("CreationEntreprise.fxml"));

					// DONNE AU FICHIER RACINE LE FXML CREE PRECEDEMENT
					BorderPane rootLayout = (BorderPane) loader.load();

					// LA SCENE CONTIENDRA NOTRE PANE RACINE
					Scene scene = new Scene(rootLayout);

					primaryStage.setScene(scene);
					primaryStage.show();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@FXML
	public void clicRetour(ActionEvent event) {
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

			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
