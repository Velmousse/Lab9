import java.util.*;
import java.io.*;

/**
 * Created by DufVi1731300 on 2018-02-26.
 */

public class Main {
    final static Scanner sc = new Scanner(System.in);
    static int entree = 0;

    public static void main(String[] args) {
        Map<String, Contact> mapContacts = new HashMap<>();
        Queue<Contact> fileRappels = new LinkedList<>();
        File hashMapData = new File("files/data.dat");
        Gestionnaire gestionnaire = new Gestionnaire();

        System.out.print("Bienvenue dans la liste de contacts!");
        while (menu(mapContacts, fileRappels, hashMapData, gestionnaire)) {}

    }

    public static boolean menu(Map map, Queue file, File data, Gestionnaire gestionnaire) {
        System.out.print("\n1- Ajouter un contact\n" +
                "2- Modifier un contact\n" +
                "3- Afficher les contacts\n" +
                "4- Liste de rappels\n" +
                "5- Supprimer un contact\n" +
                "6- Quitter\n" +
                "> ");

        switch (sc.nextInt()) {
            case 1: gestionnaire(1, map); return true;
            case 2: gestionnaire(2, map); return true;
            case 3: gestionnaire(0, map); return true;
            case 4: afficherRappels(file, map); return true;
            case 5: supprimerContact(map); return true;
            case 6: default: System.out.print("\nAu revoir."); return false;
        }
    }

    public static void gestionnaire(int modification, Map map) {
        Gestionnaire gest = new Gestionnaire();
        gest.setModification(modification);
        boolean var = false;

        if (modification == 0) {
            System.out.print("\nQuel contact voulez-vous afficher (prénom en minuscules)?\n> ");
            gest.setContact((Contact) map.get(sc.nextLine())); //Vérifier les exceptions
            System.out.println("Veuillez entrer les informations suivantes (laissez vide si correct)");
        }
        else if (modification == 1)
            gest.setContact(new Contact());
        else {
            System.out.print("\nQuel contact voulez-vous modifier (prénom)?\n> ");  //Vérifier si le contact existe avant
            gest.setContact(new Contact());
            System.out.println("Veuillez entrer les informations suivantes (laissez vide si correct)");
        }

        Contact ct = utiliserGestionnaire(gest);
        if (modification == 1 || modification == 2) map.put(ct.getPrenom().toLowerCase(), ct);
    }

    public static void afficherRappels(Queue file, Map map) {
        System.out.print("\n1- Ajouter un contact à la liste\n" +
                "2- Afficher la liste de rappels\n" +
                "3- Quitter\n" +
                "> ");
        entree = sc.nextInt();

        switch (entree) {
            case 1:
                if (map.size() > 0) {
                    System.out.print("\nQuel contact voulez-vous ajouter (prénom)?\n> ");
                    Contact ct = (Contact) map.get(sc.nextLine()); //Vérifier si le contact existe
                    file.add(ct);
                }
                break;
            case 2:
                if (file.size() > 0) {
                    Gestionnaire gest = new Gestionnaire();
                    gest.setContact((Contact) file.remove());
                    gest.setModification(0);

                    System.out.println("\nVoici le contact à rappeler, il est maintenant supprimé de la liste:");
                    utiliserGestionnaire(gest);
                }
                else System.out.println("Vous n'avez pas de contacts dans la liste de rappels.\n");
                break;
            case 3: default:
        }
    }

    public static void supprimerContact(Map map) {
        System.out.print("\nVous avez " + map.size() + "contacts, lequel contact voulez-vous supprimer (position)?" +
                "> ");
        entree = sc.nextInt() - 1;
        if (entree >= 0 && entree < map.size()) map.remove(entree);
        else System.out.print("Cette entree est invalide.");
    }

    public static Contact utiliserGestionnaire(Gestionnaire gest) {
        boolean var = false;

        gest.managePrenom();
        for (int i = 0; i < 1; i++) {
            if (var) {
                System.out.println("Occupation");
                gest.managePoste();
                System.out.println(" Entreprise");
            }
            gest.manageNom(var);
            if (!var) System.out.println("Adresse");
            else System.out.println("  Adresse");
            gest.manageNumeroCivique(var);
            gest.manageRue(var);
            gest.manageAppartement(var);
            gest.manageVille(var);
            gest.manageProvince(var);
            gest.managePays(var);
            var = true;
        }
        gest.manageTelephone();

        return gest.getContact();
    }
}
