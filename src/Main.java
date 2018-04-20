import java.util.*;
import java.io.*;

/**
 * Created by DufVi1731300 on 2018-02-26.
 */

public class Main {
    final static Scanner sc = new Scanner(System.in);
    static int entree = 0;
    static String entreeString;

    public static void main(String[] args) {
        HashMap<String, Contact> mapContacts = new HashMap<>();
        Queue<Contact> fileRappels = new LinkedList<>();

        chargerListe(mapContacts, fileRappels);

        System.out.print("Bienvenue dans la liste de contacts!");
        while (menu(mapContacts, fileRappels)) {}

        sauvegarderListe(mapContacts, fileRappels);
    }

    public static boolean menu(HashMap map, Queue file) {
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

    public static void gestionnaire(int modification, HashMap map) {
        Gestionnaire gest = new Gestionnaire();
        gest.setModification(modification);
        boolean var = false;

        if (modification == 0) {
            System.out.print("\nQuel contact voulez-vous afficher (prénom en minuscules)?\n> ");
            sc.nextLine();
            entreeString = sc.nextLine();
            gest.setContact((Contact) map.get(entreeString)); //Vérifier les exceptions
            System.out.print("\nVeuillez entrer les informations suivantes (laissez vide si correct):");
        }
        else if (modification == 1) {
            System.out.println("Veuillez entrer les informations nécessaires:");
            gest.setContact(new Contact());
        }
        else {
            System.out.print("\nQuel contact voulez-vous modifier (prénom)?\n> ");  //Vérifier si le contact existe avant
            sc.nextLine();
            entreeString = sc.nextLine();
            gest.setContact((Contact) map.get(entreeString));
            System.out.println("Veuillez entrer les informations suivantes (laissez vide si correct)");
        }

        Contact ct = utiliserGestionnaire(gest);
        if (modification == 1) map.put(ct.getPrenom().toLowerCase(), ct);
        else if (modification == 2) {
            map.remove(entreeString);
            map.put(ct.getPrenom().toLowerCase(), ct);
        }
    }

    public static void afficherRappels(Queue file, HashMap map) {
        System.out.print("\n1- Ajouter un contact à la liste\n" +
                "2- Afficher la liste de rappels\n" +
                "3- Quitter\n" +
                "> ");
        entree = sc.nextInt();

        switch (entree) {
            case 1:
                if (map.size() > 0) {
                    System.out.print("\nQuel contact voulez-vous ajouter (prénom)?\n> ");
                    sc.nextLine();
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

    public static void supprimerContact(HashMap map) {
        System.out.print("\nQuel contact voulez-vous supprimer (prénom)?\n" +
                "> ");
        sc.nextLine();
        entreeString = sc.nextLine();
        if (map.containsKey(entreeString)) map.remove(entreeString);
        else System.out.println("Ce contact n'existe pas");
    }

    public static Contact utiliserGestionnaire(Gestionnaire gest) {
        boolean var = false;

        gest.managePrenom();
        for (int i = 0; i <= 1; i++) {
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


    public static void chargerListe(HashMap map, Queue file) {
        try {
            ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("files/data.dat")));
            map = (HashMap<String, Contact>) in.readObject();
            file = (Queue<Contact>) in.readObject();
            System.out.println("<<La liste a été chargée>>");
            in.close();
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (FileNotFoundException ex) {
            System.out.println("Le fichier n'a pas été trouvé, veuillez réessayer.");
        }
        catch (IOException ex) {
            map = new HashMap<>();
            file = new LinkedList<>();
        }
    }

    public static void sauvegarderListe(HashMap map, Queue file) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("files/data.dat")));
            out.writeObject(map);
            out.writeObject(file);
            out.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println("Le fichier n'a pas été trouvé, veuillez réessayer.");
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
