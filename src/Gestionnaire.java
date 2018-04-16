import java.util.*;

/**
 * Created by dufvi1731300 on 2018-04-12.
 */
public class Gestionnaire {
    private static Scanner sc = new Scanner(System.in);
    private char entreeChar = ' ';
    private Contact contact;
    private int modification = 0; //0 == afficher, 1 == ajouter; 2 = modifier
    //variante: false pour le contact, true pour l'occupation

    public void setModification(int modification) {
        this.modification = modification;
    }

    public void managePrenom() {
        System.out.print("Prénom: ");
        switch (modification) {
            case 0: System.out.println(contact.getPrenom()); break;
            case 1: contact.setPrenom(sc.nextLine()); break;
            case 2: System.out.print(contact.getPrenom() + " "); contact.setPrenom(sc.nextLine());
        }
    }

    public void managePoste() {
        System.out.print(" Poste: ");
        switch (modification) {
            case 0: System.out.println(contact.getOcc().getPoste()); break;
            case 1: contact.getOcc().setPoste(sc.nextLine()); break;
            case 2: System.out.print(contact.getOcc().getPoste() + " "); contact.getOcc().setPoste(sc.nextLine());
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
                try {
                    if (!variante) contact.setNom(sc.nextLine());
                    else contact.getOcc().getEnt().setNom(sc.nextLine());
                }
                catch (TypeNotPresentException ex) {
                    System.out.println("Argument invalide");
                    manageNom(variante);
                }
                break;

            case 2:
                if (!variante) {System.out.print(contact.getNom() + " "); contact.setNom(sc.nextLine());}
                else {System.out.print(contact.getOcc().getEnt().getNom() + " "); contact.getOcc().getEnt().setNom(sc.nextLine());}
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
                if (!variante) contact.getAd().setNumeroCivique(sc.nextLine());
                else contact.getOcc().getEnt().getAd().setNumeroCivique(sc.nextLine());
                break;

            case 2:
                if (!variante) {System.out.print(contact.getAd().getNumeroCivique() + " "); contact.getAd().setNumeroCivique(sc.nextLine());}
                else {System.out.print(contact.getOcc().getEnt().getAd().getNumeroCivique() + " "); contact.getOcc().getEnt().getAd().setNumeroCivique(sc.nextLine());}
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
                if (!variante) contact.getAd().setRue(sc.nextLine());
                else contact.getOcc().getEnt().getAd().setRue(sc.nextLine());
                break;

            case 2:
                if (!variante) {System.out.print(contact.getAd().getRue() + " "); contact.getAd().setRue(sc.nextLine());}
                else {System.out.print(contact.getOcc().getEnt().getAd().getRue() + " "); contact.getOcc().getEnt().getAd().setRue(sc.nextLine());}
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
                if (!variante) contact.getAd().setAppartement(sc.nextLine());
                else contact.getOcc().getEnt().getAd().setAppartement(sc.nextLine());
                break;

            case 2:
                if (!variante) {System.out.print(contact.getAd().getAppartement() + " "); contact.getAd().setAppartement(sc.nextLine());}
                else {System.out.print(contact.getOcc().getEnt().getAd().getAppartement() + " "); contact.getOcc().getEnt().getAd().setAppartement(sc.nextLine());}
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
                if (!variante) contact.getAd().setVille(sc.nextLine());
                else contact.getOcc().getEnt().getAd().setVille(sc.nextLine());
                break;

            case 2:
                if (!variante) {System.out.print(contact.getAd().getVille() + " "); contact.getAd().setVille(sc.nextLine());}
                else {System.out.print(contact.getOcc().getEnt().getAd().getVille() + " "); contact.getOcc().getEnt().getAd().setVille(sc.nextLine());}
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
                if (!variante) contact.getAd().setProvince(sc.nextLine());
                else contact.getOcc().getEnt().getAd().setProvince(sc.nextLine());
                break;

            case 2:
                if (!variante) {System.out.print(contact.getAd().getProvince() + " "); contact.getAd().setProvince(sc.nextLine());}
                else {System.out.print(contact.getOcc().getEnt().getAd().getProvince() + " "); contact.getOcc().getEnt().getAd().setProvince(sc.nextLine());}
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
                if (!variante) contact.getAd().setPays(sc.nextLine());
                else contact.getOcc().getEnt().getAd().setPays(sc.nextLine());
                break;

            case 2:
                if (!variante) {System.out.print(contact.getAd().getPays() + " "); contact.getAd().setPays(sc.nextLine());}
                else {System.out.print(contact.getOcc().getEnt().getAd().getPays() + " "); contact.getOcc().getEnt().getAd().setPays(sc.nextLine());}
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
                entreeChar =sc.nextLine().toLowerCase().charAt(0);

                while (entreeChar == 'o') {
                    Telephone tel = new Telephone();
                    System.out.println(" Information (cellulaire, maison, travail): " + tel.getInfos());
                    sc.next();
                    System.out.println(" Numéro: " + tel.getNumero());
                    contact.getListTelephones().add(tel);
                    System.out.print("Voulez-vous entrer un autre numéro de téléphone?\n> ");
                    entreeChar = sc.nextLine().toLowerCase().charAt(0);
                }

                break;

            case 2:
                for (Telephone telephone: contact.getListTelephones()) {
                    System.out.print(" Information (cellulaire, maison, travail): " + telephone.getInfos());
                    telephone.setInfos(sc.nextLine());
                    System.out.print(" Numéro: " + telephone.getNumero());
                    telephone.setNumero(sc.nextLine());
                }
        }
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String entree() {
        String entree = "";

        return entree;
    }
}
