package modeles;

import java.util.Date;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class OffreDeStage {
	// EN FXML IL FAUT UTILISER LES PROPERTIES
		private StringProperty nomDeEntreprise;
		private StringProperty domaineOffre;
		private StringProperty libelle;
		private Date dateDebut;
		private IntegerProperty duree;
		private StringProperty cheminDeStockage;
		private StringProperty descriptif;

		public OffreDeStage(StringProperty nomDeEntreprise,
				StringProperty domaineOffre, StringProperty libelle,
				Date dateDebut, IntegerProperty duree, StringProperty cheminDeStockage,
				StringProperty descriptif) {
			super();
			this.nomDeEntreprise = nomDeEntreprise;
			this.domaineOffre = domaineOffre;
			this.libelle = libelle;
			this.dateDebut = dateDebut;
			this.duree = duree;
			this.cheminDeStockage = cheminDeStockage;
			this.descriptif = descriptif;
		}

		public StringProperty getNomDeEntreprise() {
			return nomDeEntreprise;
		}

		public void setNomDeEntreprise(StringProperty nomDeEntreprise) {
			this.nomDeEntreprise = nomDeEntreprise;
		}

		public StringProperty getDomaineOffre() {
			return domaineOffre;
		}

		public void setDomaineOffre(StringProperty domaineOffre) {
			this.domaineOffre = domaineOffre;
		}

		public StringProperty getLibelle() {
			return libelle;
		}

		public void setLibelle(StringProperty libelle) {
			this.libelle = libelle;
		}

		public Date getDateDebut() {
			return dateDebut;
		}

		public void setDateDebut(Date dateDebut) {
			this.dateDebut = dateDebut;
		}

		public IntegerProperty getDuree() {
			return duree;
		}

		public void setDuree(IntegerProperty duree) {
			this.duree = duree;
		}

		public StringProperty getCheminDeStockage() {
			return cheminDeStockage;
		}

		public void setCheminDeStockage(StringProperty cheminDeStockage) {
			this.cheminDeStockage = cheminDeStockage;
		}

		public StringProperty getDescriptif() {
			return descriptif;
		}

		public void setDescriptif(StringProperty descriptif) {
			this.descriptif = descriptif;
		}
}
