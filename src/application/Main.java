package application;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {

	// CREATION DES ATTRIBUTS
	private Stage primaryStage;
	//private Scene scene;
	private BorderPane rootLayout;
	
	static GestionBDD gst = new GestionBDD();
	static boolean valCo = false;

	//private FXMLLoader loader;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		// DONNE LE TITRE A LA FENETRE
		this.primaryStage.setTitle("Offres De Stages");

		try {
			// CREE UN FICHIER FXML (VIDE POUR L'INSTANT)
			FXMLLoader loader = new FXMLLoader();
			// DONNE LE CHEMIN AU FICHIER FXML CREE AU-DESSUS
			loader.setLocation(Main.class.getResource("Acceuil.fxml"));
			
			// DONNE AU FICHIER RACINE LE FXML CREE PRECEDEMENT
			rootLayout =  (BorderPane) loader.load();
			
			// LA SCENE CONTIENDRA NOTRE PANE RACINE
			Scene scene = new Scene(rootLayout);
			
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
			
//			BorderPane root = new BorderPane();
//			Scene scene = new Scene(root, 400, 400);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	
}
