import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import jdk.internal.util.xml.impl.Input;
import sun.awt.image.ImageWatched;

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
        HashMap<String, Contact> mapContacts;
        Queue<Contact> fileRappels;

        mapContacts = chargerMap();  //Je ne sais pas trop pourquoi, mais Java ne passait pas en référence la map, il ne passait que sa valeur initiale,
        fileRappels = chargerFile(); //donc la map restait dans sa méthode sans jamais en sortir.

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

        entree = intInput();

            switch (entree) {
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
            mapContains(map);
            gest.setContact((Contact) map.get(entreeString));
            System.out.print("\nVeuillez entrer les informations suivantes (laissez vide si correct):");
        }
        else if (modification == 1) {
            System.out.println("Veuillez entrer les informations nécessaires:");
            gest.setContact(new Contact());
        }
        else {
            System.out.print("\nQuel contact voulez-vous modifier (prénom)?\n> ");
            mapContains(map);
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

        entree = intInput();

        switch (entree) {
            case 1:
                if (map.size() > 0) {
                    System.out.print("\nQuel contact voulez-vous ajouter (prénom)?\n> ");
                    mapContains(map);
                    Contact ct = (Contact) map.get(entreeString);
                    file.add(ct);
                    System.out.println("Le contact a bien été ajouté.");
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
            gest.managePays(var);
            gest.manageProvince(var);
            var = true;
        }
        gest.manageTelephone();

        return gest.getContact();
    }


    public static HashMap<String, Contact> chargerMap() {
        HashMap<String, Contact> map = new HashMap<>();
        try {
            ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("files/data.dat")));
            map = (HashMap<String, Contact>) in.readObject();
            System.out.println("<<Liste de contacts chargée>>");
        }
        catch (FileNotFoundException ex) { }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return map;
    }


    public static Queue<Contact> chargerFile() {
        Queue<Contact> file = new LinkedList<>();
        try {
            ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("files/data.dat")));
            in.readObject();
            file = (LinkedList<Contact>) in.readObject();
            System.out.println("<<Liste de rappels chargée>>");
        }
        catch (FileNotFoundException ex) {
            System.out.println("Le fichier n'a pas été trouvé, veuillez réessayer.");
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return file;
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

    static int intInput() {
        //Avec un try catch il y aurait eu une boucle infinie ici, le Scanner ne se serait pas réactivé
        while (!sc.hasNextInt())
            System.out.println(sc.next() + " n'est pas un nombre valide, Réessayez\n> ");
        return sc.nextInt();
    }

    static void mapContains(HashMap map) {
        sc.nextLine();
        entreeString = sc.nextLine();
        while (!(map.containsKey(entreeString))) {
            System.out.print("Entrée invalide. Réessayez\n> ");
            entreeString = sc.nextLine();
        }
    }
}
