package modeles;

import java.util.List;

import javafx.beans.property.StringProperty;

public class Entreprise {

	private StringProperty nomDeL_Entreprise;
	private StringProperty adresseNoRue;
	private StringProperty adresseCP;
	private StringProperty adresseVille;
	private StringProperty mailContact;

	public StringProperty getNomDeL_Entreprise() {
		return nomDeL_Entreprise;
	}

	public void setNomDeL_Entreprise(StringProperty nomDeL_Entreprise) {
		this.nomDeL_Entreprise = nomDeL_Entreprise;
	}

	public StringProperty getAdresseNoRue() {
		return adresseNoRue;
	}

	public void setAdresseNoRue(StringProperty adresseNoRue) {
		this.adresseNoRue = adresseNoRue;
	}

	public StringProperty getAdresseCP() {
		return adresseCP;
	}

	public void setAdresseCP(StringProperty adresseCP) {
		this.adresseCP = adresseCP;
	}

	public StringProperty getAdresseVille() {
		return adresseVille;
	}

	public void setAdresseVille(StringProperty adresseVille) {
		this.adresseVille = adresseVille;
	}

	public StringProperty getMailContact() {
		return mailContact;
	}

	public void setMailContact(StringProperty mailContact) {
		this.mailContact = mailContact;
	}

	public StringProperty getTelContact() {
		return telContact;
	}

	public void setTelContact(StringProperty telContact) {
		this.telContact = telContact;
	}

	public StringProperty getSecteurActivite() {
		return secteurActivite;
	}

	public void setSecteurActivite(StringProperty secteurActivite) {
		this.secteurActivite = secteurActivite;
	}

	public List<OffreDeStage> getListeDesOffres() {
		return listeDesOffres;
	}

	public void setListeDesOffres(List<OffreDeStage> listeDesOffres) {
		this.listeDesOffres = listeDesOffres;
	}

	private StringProperty telContact;
	private StringProperty secteurActivite;
	private List<OffreDeStage> listeDesOffres;

	public Entreprise(StringProperty nomDeL_Entreprise,
			StringProperty adresseNoRue, StringProperty adresseCP,
			StringProperty adresseVille, StringProperty mailContact,
			StringProperty telContact, StringProperty secteurActivite,
			List<OffreDeStage> listeDesOffres) {
		super();
		this.nomDeL_Entreprise = nomDeL_Entreprise;
		this.adresseNoRue = adresseNoRue;
		this.adresseCP = adresseCP;
		this.adresseVille = adresseVille;
		this.mailContact = mailContact;
		this.telContact = telContact;
		this.secteurActivite = secteurActivite;
		this.listeDesOffres = listeDesOffres;
	}

}
