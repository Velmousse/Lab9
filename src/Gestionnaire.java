import java.util.*;

/**
 * Created by dufvi1731300 on 2018-04-12.
 */
public class Gestionnaire {
    static Scanner sc = new Scanner(System.in);
    private int modification = 0; //0 == afficher, 1 == ajouter; 2 = modifier
    //variante: false pour le contact, true pour l'occupation

    public void setModification(int modification) {
        this.modification = modification;
    }

    public void managePrenom(Contact contact) {
        System.out.print("Prénom: ");
        switch (modification) {
            case 0: System.out.println(contact.getPrenom()); break;
            case 1: contact.setPrenom(sc.nextLine());
            case 2: System.out.print(contact.getPrenom() + " "); contact.setPrenom(sc.nextLine());
        }
    }

    public void manageNom(Contact contact, boolean variante) {
        if (!variante) System.out.print("Nom: ");
        else System.out.print("  Nom: ");
        switch (modification) {
            case 0:
                if (!variante) System.out.println(contact.getNom());
                else System.out.println(contact.getOcc().getEnt().getNom());
                break;

            case 1:
                if (!variante) contact.setNom(sc.nextLine());
                else contact.getOcc().getEnt().setNom(sc.nextLine());
                break;

            case 2:
                if (!variante) {System.out.print(contact.getNom() + " "); contact.setNom(sc.nextLine());}
                else {System.out.print(contact.getOcc().getEnt().getNom() + " "); contact.getOcc().getEnt().setNom(sc.nextLine());}
        }
    }

    public void manageNumeroCivique(Contact contact, boolean variante) {
        if (!variante) System.out.print(" Numéro civique: ");
        else System.out.print("   Numéro civique: ");
        switch (modification) {
            case 0:
                if (!variante) System.out.println(contact.getAd().getNumeroCivique());
                else System.out.println(contact.getOcc().getEnt().getAd().getNumeroCivique());
                break;

            case 1:
                if (!variante) contact.getAd().setNumeroCivique(sc.nextLine());
                else contact.getOcc().getEnt().getAd().setNumeroCivique(sc.nextLine());
                break;

            case 2:
                if (!variante) {System.out.print(contact.getAd().getNumeroCivique() + " "); contact.getAd().setNumeroCivique(sc.nextLine());}
                else {System.out.print(contact.getOcc().getEnt().getAd().getNumeroCivique() + " "); contact.getOcc().getEnt().getAd().setNumeroCivique(sc.nextLine());}
        }
    }

    public void manageRue(Contact contact, boolean variante) {
        if (!variante) System.out.print(" Rue: ");
        else System.out.print("   Rue: ");
        switch (modification) {
            case 0:
                if (!variante) System.out.println(contact.getAd().getRue());
                else System.out.println(contact.getOcc().getEnt().getAd().getRue());
                break;

            case 1:
                if (!variante) contact.getAd().setRue(sc.nextLine());
                else contact.getOcc().getEnt().getAd().setRue(sc.nextLine());
                break;

            case 2:
                if (!variante) {System.out.print(contact.getAd().getRue() + " "); contact.getAd().setRue(sc.nextLine());}
                else {System.out.print(contact.getOcc().getEnt().getAd().getRue() + " "); contact.getOcc().getEnt().getAd().setRue(sc.nextLine());}
        }
    }

    public void manageAppartement(Contact contact, boolean variante) {
        if (!variante) System.out.print(" Appartement: ");
        else System.out.print("   Appartement: ");
        switch (modification) {
            case 0:
                if (!variante) System.out.println(contact.getAd().getAppartement());
                else System.out.println(contact.getOcc().getEnt().getAd().getAppartement());
                break;

            case 1:
                if (!variante) contact.getAd().setAppartement(sc.nextLine());
                else contact.getOcc().getEnt().getAd().setAppartement(sc.nextLine());
                break;

            case 2:
                if (!variante) {System.out.print(contact.getAd().getAppartement() + " "); contact.getAd().setAppartement(sc.nextLine());}
                else {System.out.print(contact.getOcc().getEnt().getAd().getAppartement() + " "); contact.getOcc().getEnt().getAd().setAppartement(sc.nextLine());}
        }
    }

    public void manageVille(Contact contact, boolean variante) {
        if (!variante) System.out.print(" Ville: ");
        else System.out.print("   Ville: ");
        switch (modification) {
            case 0:

                break;

            case 1:

                break;

            case 2:

        }
    }

    public void manageProvince(Contact contact, boolean variante) {
        if (!variante) System.out.print(" Province: ");
        else System.out.print("   Province: ");
        switch (modification) {
            case 0:

                break;

            case 1:

                break;

            case 2:

        }
    }

    public void managePays(Contact contact, boolean variante) {
        if (!variante) System.out.print(" Pays: ");
        else System.out.print("   Pays: ");
        switch (modification) {
            case 0:

                break;

            case 1:

                break;

            case 2:

        }
    }

    public void managePoste(Contact contact) {
        System.out.print(" Poste: ");
        switch (modification) {
            case 0:

                break;

            case 1:

                break;

            case 2:

        }
    }

    public void manageTelephone(Contact contact) {
        switch (modification) {
            case 0:
                for (Telephone telephone: ct.getListTelephones()) {
                    System.out.println(" Information (cellulaire, maison, travail): " + telephone.getInfos());
                    System.out.println(" Numéro: " + telephone.getNumero());
                }
                break;

            case 1:

                break;

            case 2:
        }
    }
}
