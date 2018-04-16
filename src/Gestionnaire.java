import java.util.*;

/**
 * Created by dufvi1731300 on 2018-04-12.
 */
public class Gestionnaire {
    static Scanner sc = new Scanner(System.in);

    private Contact ct = new Contact();
    private int modification = 0; //0 == afficher, 1 == ajouter; 2 = modifier
    //variante: false pour le contact, true pour l'occupation

    public void setModification(int modification) {
        this.modification = modification;
    }

    public void managePrenom(Contact contact) {
        switch (modification) {
            case 0:
                System.out.println("Prénom: " + contact.getPrenom());
                break;

            case 1:

                break;

            case 2:

        }
    }

    public void manageNom(Contact contact, boolean variante) {
        switch (modification) {
            case 0:
                if (!variante) System.out.println("Nom: " + contact.getNom());
                else System.out.println("  Nom: " + contact.getOcc().getEnt().getNom());
                break;

            case 1:

                break;

            case 2:

        }
    }

    public void manageNumeroCivique(Contact contact, boolean variante) {
        switch (modification) {
            case 0:
                if (!variante) System.out.println(" Numéro civique: " + contact.getAd().getNumeroCivique());
                else System.out.println("   Numéro civique: " + contact.getOcc().getEnt().getAd().getNumeroCivique());
                break;

            case 1:

                break;

            case 2:

        }
    }

    public void manageRue(Contact contact, boolean variante) {
        switch (modification) {
            case 0:
                if (!variante) System.out.println(" Rue: " + contact.getAd().getRue());
                else System.out.println("   Rue: " + contact.getOcc().getEnt().getAd().getRue());
                break;

            case 1:

                break;

            case 2:

        }
    }

    public void manageAppartement(Contact contact, boolean variante) {
        switch (modification) {
            case 0:
                if (!variante) System.out.println(" Appartement: " + contact.getAd().getAppartement());
                else System.out.println("   Appartement: " + contact.getOcc().getEnt().getAd().getAppartement());
                break;

            case 1:

                break;

            case 2:

        }
    }

    public void manageVille(Contact contact, boolean variante) {
        switch (modification) {
            case 0:
                if (!variante) System.out.println(" Ville: " + contact.getAd().getVille());
                else System.out.println("   Ville: " + contact.getOcc().getEnt().getAd().getVille());
                break;

            case 1:

                break;

            case 2:

        }
    }

    public void manageProvince(Contact contact, boolean variante) {
        switch (modification) {
            case 0:
                if (!variante) System.out.println(" Province: " + contact.getAd().getProvince());
                else System.out.println("   Province: " + contact.getOcc().getEnt().getAd().getProvince());
                break;

            case 1:

                break;

            case 2:

        }
    }

    public void managePays(Contact contact, boolean variante) {
        switch (modification) {
            case 0:
                if (!variante) System.out.println(" Pays: " + contact.getAd().getPays());
                else System.out.println("   Pays: " + contact.getOcc().getEnt().getAd().getPays());
                break;

            case 1:

                break;

            case 2:

        }
    }

    public void managePoste(Contact contact) {
        switch (modification) {
            case 0:
                System.out.println(" Poste: " + contact.getOcc().getPoste());
                break;

            case 1:

                break;

            case 2:

        }
    }
}
