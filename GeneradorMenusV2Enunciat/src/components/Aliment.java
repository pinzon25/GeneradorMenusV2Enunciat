/*
 * Classe que defineix un aliment. Un aliment es defineix pel seu codi, nom
 * i quantitat.
 */
package components;

import java.util.Scanner;

/**
 *
 * @author fta
 */
public class Aliment extends Recepta {

    private final static Scanner DADES = new Scanner(System.in);

    private String codi;
    private String nom;
    private double quantitat;

    /*
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe.
     Accions:
     - Assignar als atributs els valors passats com a paràmetres.
     */
    public Aliment(String pCodi, String pNom, double pQuantitat) {
        codi = pCodi;
        nom = pNom;
        quantitat = pQuantitat;
    }

    /*
     Mètodes accessors    
     */
    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getQuantitat() {
        return quantitat;
    }

    public void setQuantitat(double quantitat) {
        this.quantitat = quantitat;
    }

    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear un nou aliment. Les dades
     a demanar són les que necessita el constructor.
     - També heu de tenir en compte que el nom, no té perquè estar formt per una única
     paraula, per exemple, farina de força.
     Retorn: El nou aliment.
     */
    public static Aliment nouAliment() {

        String codi;
        String nom;
        double quantitat;

        System.out.println("Codi de l'aliment:");
        codi = DADES.next();
        DADES.nextLine(); //Neteja buffer
        System.out.println("Nom de l'aliment:");
        nom = DADES.nextLine();
        System.out.println("Quantitat de l'aliment:");
        quantitat = DADES.nextDouble();

        return new Aliment(codi, nom, quantitat);
    }

    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte.
     - Li heu de mostrar a l'usuari el valor actual dels atributs de l'objecte
     actual, abans de modificar-los
     Retorn: cap
     */
    public void modificarAliment() {

        System.out.println("\nCodi de l'aliment: " + codi);
        System.out.println("\nEntra el nou codi:");
        codi = DADES.next();
        DADES.nextLine(); //Neteja buffer
        System.out.println("\nNom de l'aliment: " + nom);
        System.out.println("\nEntra el nou nom:");
        nom = DADES.nextLine();
        System.out.println("\nQuantitat de l'aliment: " + quantitat);
        System.out.println("\nEntra la nova quantitat:");
        quantitat = DADES.nextDouble();
    }

    public void mostrarAliment() {
        System.out.println("\nLes dades de l'aliment amb codi " + codi + " són:");
        System.out.println("\nNom: " + nom);
        System.out.println("\nQuantitat: " + quantitat);
    }
}
