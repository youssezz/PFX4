package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class GestionBDD {
	// À faire : méthode connexion, méthode récupEntreprise, méthode récupOffreStage
	// Information d'accès à la base de données
	// HashMap rassemblant importEnt et importDom, ce qui nous permettra de changer les entreprises
	// enregistrées en fonction du domaine sélectionné
	private static String url = "jdbc:mysql://localhost/bdd_stage";
	private static String login = "root";
	private static String passwd = "";
	private static Connection cn = null;
	private static Statement st = null;
	private static ResultSet rs, rs2 = null;
	private static String type;
	
	GestionBDD(){
		try {
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = (Connection) DriverManager.getConnection(url, login, passwd);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
//		} finally {
//			if(co == false){
//				try {
//				// Etape 6 : libérer ressources de la mémoire.
//					cn.close();
//					st.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//				System.out.println("erreur de connexion, id : " + id + " mdp : " + mdp);
//			}
		}
	}
	
	public boolean connexion(String id, String mdp){
		try{
			// Etape 3 : Création d'un statement
			st = (Statement) cn.createStatement();
		
			String sql = "SELECT id, motPasse, type FROM utilisateur";
		
			// Etape 4 : exécution requête
			rs = (ResultSet) st.executeQuery(sql);

			// Si récup données alors étapes 5 (parcours Resultset)

			while (rs.next() && Main.valCo == false) {
				if(id.equals(rs.getString("id")) == true && mdp.equals(rs.getString("motPasse")) == true){
					type = rs.getString("type");
					Main.valCo = true;
					System.out.println(type);
					return Main.valCo;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		//} catch (ClassNotFoundException e) {
		//	e.printStackTrace();
		} finally {
			if(Main.valCo == false){
				try {
					// Etape 6 : libérer ressources de la mémoire.
					cn.close();
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				System.out.println("erreur de connexion, id : " + id + " mdp : " + mdp);
			}
			return Main.valCo;
		}
	}
	
	public String getType(){
		return type;
	}
		
	public LinkedList<String> importEnt(){
		LinkedList<String> listEnt = new LinkedList();
				
		try{
			// Etape 3 : Création d'un statement
			st = (Statement) cn.createStatement();

			String sql = "SELECT nomEntreprise FROM entreprise";

			// Etape 4 : exécution requête
			rs = (ResultSet) st.executeQuery(sql);

			// Si récup données alors étapes 5 (parcours Resultset)

			while (rs.next()) {
				listEnt.add(rs.getString("nomEntreprise"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//			// Etape 6 : libérer ressources de la mémoire.
//				cn.close();
//				st.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
		}
		
//		for(String s : listEnt){
//			System.out.println(s);
//		}

		return listEnt;
	}
	
	public LinkedList<String> importDom(){
		//Champ c = new Champ();
		LinkedList<String> listDom = new LinkedList();
		
		try{
			// Etape 3 : Création d'un statement
			st = (Statement) cn.createStatement();

			String sql = "SELECT DISTINCT sectActv FROM entreprise";

			// Etape 4 : exécution requête
			rs = (ResultSet) st.executeQuery(sql);

			// Si récup données alors étapes 5 (parcours Resultset)

			while (rs.next()) {
				listDom.add(rs.getString("sectActv"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//			// Etape 6 : libérer ressources de la mémoire.
//				cn.close();
//				st.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
		}

		return listDom;		
	}
	

	public LinkedList<String> importOffre(){
		//Champ c = new Champ();
		String nomCol[] = {"nomEntreprise", "adVille", "domOffre", "libelle", "dateDebut", "duree", "adMail", "description"};
		LinkedList<String> listOffre = new LinkedList();
		
		/*// Information d'accès à la base de données
		String url = "jdbc:mysql://localhost/bdd_stage";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = (Connection) DriverManager.getConnection(url, login, passwd);*/
		try{
			// Etape 3 : Création d'un statement
			st = (Statement) cn.createStatement();

			String sql = "SELECT o.*, e.adVille, e.adMail FROM entreprise e INNER JOIN offrestage o ON e.nomEntreprise = o.nomEntreprise";
			//String sql2 = "SELECT e.adVille FROM entreprise e INNER JOIN offrestage o ON e.nomEntreprise = o.nomEntreprise";

			// Etape 4 : exécution requête
			rs = (ResultSet) st.executeQuery(sql);
			//rs2 = (ResultSet) st.executeQuery(sql2);
			// Si récup données alors étapes 5 (parcours Resultset)

			while (rs.next()) {
				listOffre.add(rs.getString(nomCol[0]));
				listOffre.add(rs.getString(nomCol[1]));
				listOffre.add(rs.getString(nomCol[2]));
				listOffre.add(rs.getString(nomCol[3]));
				listOffre.add(rs.getString(nomCol[4]));
				listOffre.add(rs.getString(nomCol[5]));
				listOffre.add(rs.getString(nomCol[6]));
				listOffre.add(rs.getString(nomCol[7]));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}/* catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
			// Etape 6 : libérer ressources de la mémoire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}*/
		
		return listOffre;
	}
	
	public static void exporterEnt(String nomEnt, String rue, String codePostal, String ville, String mail, String numTel, String sectActv){		
		String tabEnt[] = {"entreprise", "nomEntreprise", "adNumRue", "adCodePostal", "adVille", "adMail", "numTel", "sectActv"};
		
		String url = "jdbc:mysql://localhost/bdd_stage";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;

		try {
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = (Connection) DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Création d'un statement
			st = (Statement) cn.createStatement();

			//String sql = "INSERT INTO `entreprise` (`nomEntreprise`, `adNumRue`, `adCodePostal`, `adVille`, `adMail`, `numTel`, `sectActv`) VALUES ('" + "tuc" + "','" + "tuc" + "','" + "tuc" + "','" + "tuc" + "','" + "tuc" + "','" + "tuc" + "','" + "tuc" + "')";
			String sql = "INSERT INTO `entreprise` (`nomEntreprise`, `adNumRue`, `adCodePostal`, `adVille`, `adMail`, `numTel`, `sectActv`) "
						 + "VALUES ('" + nomEnt + "', '" + rue + "', '" + codePostal + "', '" + ville + "', '" + mail + "', '" + numTel + "', + '" + sectActv + "')";

			// Etape 4 : exécution requête
			st.executeUpdate(sql);

			// Si récup données alors étapes 5 (parcours Resultset)

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
//		} finally {
//			try {
//			// Etape 6 : libérer ressources de la mémoire.
//				cn.close();
//				st.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
		}
	}
	
	public static void exporterOffre(String nomEnt, String dmn, String libl, String dateDebut, String duree, String chemin, String desc){				
		String url = "jdbc:mysql://localhost/bdd_stage";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;

		try {
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = (Connection) DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Création d'un statement
			st = (Statement) cn.createStatement();

			//String sql = "INSERT INTO `entreprise` (`nomEntreprise`, `adNumRue`, `adCodePostal`, `adVille`, `adMail`, `numTel`, `sectActv`) VALUES ('" + "tuc" + "','" + "tuc" + "','" + "tuc" + "','" + "tuc" + "','" + "tuc" + "','" + "tuc" + "','" + "tuc" + "')";
			String sql = "INSERT INTO `offreStage` (`nomEntreprise`, `domOffre`, `libelle`, `dateDebut`, `duree`, `chemin`, `description`) "
						 + "VALUES ('" + nomEnt + "', '" + dmn + "', '" + libl + "', '" + dateDebut + "', '" + duree + "', '" + chemin + "', + '" + desc + "')";

			// Etape 4 : exécution requête
			st.executeUpdate(sql);

			// Si récup données alors étapes 5 (parcours Resultset)

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
			// Etape 6 : libérer ressources de la mémoire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
