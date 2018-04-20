import java.io.Serializable;
import java.util.*;

/**
 * Created by dufvi1731300 on 2018-04-12.
 */
public class Gestionnaire implements Serializable{
    private static final String[] listePays = {"canada", "états-unis", "mexique", "france", "allemagne", "brésil"},
    listeProvince = {"alberta", "colombie-britannique", "île-du-prince-édouard", "manitoba", "nouveau-brunswick", "nouvelle-écosse", "ontario", "québec", "saskatchewan", "terre-neuve-et-labrador"}; //Les provinces, pas les territoires :)))

    private static Scanner sc = new Scanner(System.in);
    private char entreeChar = ' ';
    private String entreeString = "";
    private Contact contact;
    private int modification = 0; //0 == afficher, 1 == ajouter; 2 = modifier
    //variante: false pour le contact, true pour l'occupation

    public void setModification(int modification) {
        this.modification = modification;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public void managePrenom() {
        System.out.print("\nPrénom: ");
        switch (modification) {
            case 0: System.out.println(contact.getPrenom()); break;
            case 1: verifString(); contact.setPrenom(entreeString); break;
            case 2: verifString(); System.out.print(contact.getPrenom() + " "); contact.setPrenom(entreeString);
        }
    }

    public void managePoste() {
        System.out.print(" Poste: ");
        switch (modification) {
            case 0: System.out.println(contact.getOcc().getPoste()); break;
            case 1: verifString(); contact.getOcc().setPoste(entreeString); break;
            case 2: verifString(); System.out.print(contact.getOcc().getPoste() + " "); contact.getOcc().setPoste(entreeString);
        }
    }

    public void manageNom(boolean variante) {
        if (!variante) System.out.print("Nom: ");
        else System.out.print("  Nom: ");
        switch (modification) {
            case 0:
                if (!variante) System.out.println(contact.getNom());
                else System.out.println(contact.getOcc().getEnt().getNom());
                break;

            case 1:
                verifString();
                if (!variante) contact.setNom(entreeString);
                else contact.getOcc().getEnt().setNom(entreeString);
                break;

            case 2:
                verifString();
                if (!variante) {System.out.print(contact.getNom() + " "); contact.setNom(entreeString);}
                else {System.out.print(contact.getOcc().getEnt().getNom() + " "); contact.getOcc().getEnt().setNom(entreeString);}
        }
    }

    public void manageNumeroCivique(boolean variante) {
        if (!variante) System.out.print(" Numéro civique: ");
        else System.out.print("   Numéro civique: ");
        switch (modification) {
            case 0:
                if (!variante) System.out.println(contact.getAd().getNumeroCivique());
                else System.out.println(contact.getOcc().getEnt().getAd().getNumeroCivique());
                break;

            case 1:
                verifString();
                if (!variante) contact.getAd().setNumeroCivique(entreeString);
                else contact.getOcc().getEnt().getAd().setNumeroCivique(entreeString);
                break;

            case 2:
                verifString();
                if (!variante) {System.out.print(contact.getAd().getNumeroCivique() + " "); contact.getAd().setNumeroCivique(entreeString);}
                else {System.out.print(contact.getOcc().getEnt().getAd().getNumeroCivique() + " "); contact.getOcc().getEnt().getAd().setNumeroCivique(entreeString);}
        }
    }

    public void manageRue(boolean variante) {
        if (!variante) System.out.print(" Rue: ");
        else System.out.print("   Rue: ");
        switch (modification) {
            case 0:
                if (!variante) System.out.println(contact.getAd().getRue());
                else System.out.println(contact.getOcc().getEnt().getAd().getRue());
                break;

            case 1:
                verifString();
                if (!variante) contact.getAd().setRue(entreeString);
                else contact.getOcc().getEnt().getAd().setRue(entreeString);
                break;

            case 2:
                verifString();
                if (!variante) {System.out.print(contact.getAd().getRue() + " "); contact.getAd().setRue(entreeString);}
                else {System.out.print(contact.getOcc().getEnt().getAd().getRue() + " "); contact.getOcc().getEnt().getAd().setRue(entreeString);}
        }
    }

    public void manageAppartement(boolean variante) {
        if (!variante) System.out.print(" Appartement: ");
        else System.out.print("   Appartement: ");
        switch (modification) {
            case 0:
                if (!variante) System.out.println(contact.getAd().getAppartement());
                else System.out.println(contact.getOcc().getEnt().getAd().getAppartement());
                break;

            case 1:
                verifString();
                if (!variante) contact.getAd().setAppartement(entreeString);
                else contact.getOcc().getEnt().getAd().setAppartement(entreeString);
                break;

            case 2:
                verifString();
                if (!variante) {System.out.print(contact.getAd().getAppartement() + " "); contact.getAd().setAppartement(entreeString);}
                else {System.out.print(contact.getOcc().getEnt().getAd().getAppartement() + " "); contact.getOcc().getEnt().getAd().setAppartement(entreeString);}
        }
    }

    public void manageVille(boolean variante) {
        if (!variante) System.out.print(" Ville: ");
        else System.out.print("   Ville: ");
        switch (modification) {
            case 0:
                if (!variante) System.out.println(contact.getAd().getVille());
                else System.out.println(contact.getOcc().getEnt().getAd().getVille());
                break;

            case 1:
                verifString();
                if (!variante) contact.getAd().setVille(entreeString);
                else contact.getOcc().getEnt().getAd().setVille(entreeString);
                break;

            case 2:
                verifString();
                if (!variante) {System.out.print(contact.getAd().getVille() + " "); contact.getAd().setVille(entreeString);}
                else {System.out.print(contact.getOcc().getEnt().getAd().getVille() + " "); contact.getOcc().getEnt().getAd().setVille(entreeString);}
        }
    }

    public void manageProvince(boolean variante) {
        if (!variante) System.out.print(" Province: ");
        else System.out.print("   Province: ");
        switch (modification) {
            case 0:
                if (!variante) System.out.println(contact.getAd().getProvince());
                else System.out.println(contact.getOcc().getEnt().getAd().getProvince());
                break;

            case 1:
                if (!variante && contact.getAd().getPays().toLowerCase().equals("canada") || variante && contact.getOcc().getEnt().getAd().getPays().toLowerCase().equals("canada")) verifProvince();
                else verifString();

                if (!variante) contact.getAd().setProvince(entreeString);
                else contact.getOcc().getEnt().getAd().setProvince(entreeString);
                break;

            case 2:
                if (!variante && contact.getAd().getPays().toLowerCase().equals("canada") || variante && contact.getOcc().getEnt().getAd().getPays().toLowerCase().equals("canada")) verifProvince();
                else verifString();

                if (!variante) {System.out.print(contact.getAd().getProvince() + " "); contact.getAd().setProvince(entreeString);}
                else {System.out.print(contact.getOcc().getEnt().getAd().getProvince() + " "); contact.getOcc().getEnt().getAd().setProvince(entreeString);}
        }
    }

    private void verifProvince() {
        entreeString = sc.nextLine();
        boolean trouve = false;
        for (String province: listeProvince) {
            if (entreeString.toLowerCase().equals(province)) {
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.print("Entrée invalide. Réessayez: ");
            verifProvince();
        }
    }

    public void managePays(boolean variante) {
        if (!variante) System.out.print(" Pays: ");
        else System.out.print("   Pays: ");
        switch (modification) {
            case 0:
                if (!variante) System.out.println(contact.getAd().getPays());
                else System.out.println(contact.getOcc().getEnt().getAd().getPays());
                break;

            case 1:
                verifPays();
                if (!variante) contact.getAd().setPays(entreeString);
                else contact.getOcc().getEnt().getAd().setPays(entreeString);
                break;

            case 2:
                verifPays();
                if (!variante) {System.out.print(contact.getAd().getPays() + " "); contact.getAd().setPays(entreeString);}
                else {System.out.print(contact.getOcc().getEnt().getAd().getPays() + " "); contact.getOcc().getEnt().getAd().setPays(entreeString);}
        }
    }

    private void verifPays() {
        entreeString = sc.nextLine();
        boolean trouve = false;
        for (String pays: listePays) {
            if (entreeString.toLowerCase().equals(pays)) {
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.print("Entrée invalide. Réessayez: ");
            verifPays();
        }
    }

    public void manageTelephone() {
        switch (modification) {
            case 0:
                for (Telephone telephone: contact.getListTelephones()) {
                    System.out.println(" Information (cellulaire, maison, travail): " + telephone.getInfos());
                    System.out.println(" Numéro: " + telephone.getNumero());
                }
                break;

            case 1:
                System.out.print("Voulez-vous entrer un numéro de téléphone (o/n)?\n> ");
                entreeChar = sc.nextLine().toLowerCase().charAt(0);

                while (entreeChar == 'o') {
                    Telephone tel = new Telephone();
                    System.out.print(" Information (cellulaire, maison, travail): ");
                    verifString();
                    tel.setInfos(entreeString);
                    System.out.print(" Numéro (chiffres collés uniquement): ");
                    verifNumero();
                    tel.setNumero(entreeString);
                    contact.getListTelephones().add(tel);
                    System.out.print("Voulez-vous entrer un autre numéro de téléphone?\n> ");
                    entreeChar = sc.nextLine().toLowerCase().charAt(0);
                }

                break;

            case 2:
                for (Telephone telephone: contact.getListTelephones()) {
                    System.out.print(" Information (cellulaire, maison, travail): " + telephone.getInfos() + " ");
                    verifString();
                    telephone.setInfos(entreeString);
                    System.out.print(" Numéro: " + telephone.getNumero() + " ");
                    verifNumero();
                    telephone.setNumero(entreeString);
                }
        }
    }

    private void verifNumero() {
        entreeString = sc.nextLine();
        boolean invalide = false;
        if (entreeString.length() > 15) {
            System.out.print("Entrée trop longue. Réessayez: ");
            verifNumero();
        }

        char[] charArray = entreeString.toCharArray();

        for (char cara: charArray) {
            if ((int) cara < 48 || (int) cara > 57) invalide = true;
        }
        if (invalide) {
            System.out.print("Caractère invalide. Réessayez: ");
            verifNumero();
        }
    }

    private void verifString() {
        entreeString = sc.nextLine();
        boolean invalide = false;
        char[] charArray = entreeString.toCharArray();

        for (char cara: charArray) {
            if ((int) cara >= 33 && (int) cara <= 47) invalide = true;
        }
        if (invalide) {
            System.out.print("Caractère invalide. Réessayez: ");
            verifString();
        }
    }
}
