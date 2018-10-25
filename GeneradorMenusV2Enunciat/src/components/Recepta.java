/*
 * Classe que defineix una recepta. Una recepta es defineix pel seu codi, nom,
 * un vector amb el seus ingredients (aliments), el text amb els passos per la seva elaboració,
 * el tipus de recepta què és, és a dir, si és un primer plat, un segon o postres,
 * i les calories que té.
 */
package components;

import java.util.Scanner;

/**
 *
 * @author fta
 */
public abstract class Recepta implements Components {

    private final static Scanner DADES = new Scanner(System.in);
    private static String codi;
    private static String nom;
    private static Aliment[] ingredients;
    private static int posicioIngredients; //Possició actual buida del vector ingredients
    private static String elaboracio;
    private static String tipus;
    private static double calories;
    private static boolean assignada;

    /*
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe, menys l'atribut ingredients
     , l'atribut posicioIngredients i l'atribut assignada.
     Accions:
     - Assignar als atributs els valors passats com a paràmetres
     - ingredients s'ha d'inicialtizar buit i amb una capacitat per 25 ingredients.
     - posicioIngredients s'ha d'inicialtizar a 0, ja que és la primera posició del
     vector ingredients.
     - assignada s'ha d'inicialitzar a false, ja que cuan es crea una recepta no està
     assignada a cap menú.
     */
    public Recepta(String pCodi, String pNom, String pElaboracio, String pTipus, double pCalories) {
        codi = pCodi;
        nom = pNom;
        ingredients = new Aliment[25];
        posicioIngredients = 0;
        elaboracio = pElaboracio;
        tipus = pTipus;
        calories = pCalories;
        assignada = false;
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

    public Aliment[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(Aliment[] ingredients) {
        this.ingredients = ingredients;
    }

    public int getPosicioIngredients() {
        return posicioIngredients;
    }

    public void setPosicioIngredients(int posicioIngredients) {
        this.posicioIngredients = posicioIngredients;
    }

    public String getElaboracio() {
        return elaboracio;
    }

    public void setElaboracio(String elaboracio) {
        this.elaboracio = elaboracio;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public boolean getAssignada() {
        return assignada;
    }

    public void setAssignada(boolean assignada) {
        this.assignada = assignada;
    }

    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear una nova recepta. Les dades
     a demanar són les que necessita el constructor.
     - En el cas del tipus, l'usuari ha d'introduir 1, si es tracta d'un primer plat, 2
     si es tracta d'un segon i P si són unes postres. Heu de comprovar que la dada
     introduida per l'usuari és la correcta (1, 2 o P) si no li mostrarem el missatge
     "\nLa dada introduida no és vàlida" i tornarem a demanr-li que introdueixi la dada.
     Això ho farem fins que introdueixi la dada correcta.
     - També heu de tenir en compte que l'elaboració, no estarà formada per una única
     paraula i que el nom, tampoc té perquè ser d'una única paraula, per exemple, 
     Francesc Xavier, o bé, matí i tarda.
     Retorn: La nova recepta.
     */
    public static void novaRecepta() {
        /*
        String codi;
        String nom;
        String elaboracio;
        String tipus;
        double calories;*/

        System.out.println("\nCodi de la recepta:");
        codi = DADES.next();
        DADES.nextLine(); //Neteja buffer
        System.out.println("\nNom de la recepta:");
        nom = DADES.nextLine();
        System.out.println("\nElaboració de la recepta:");
        elaboracio = DADES.nextLine();

        do {
            System.out.println("\nTipus de recepta: ((1)primer plat, (2)segon plat, (P)Postres)");
            tipus = DADES.next();
        } while (!(tipus.equals("1") || tipus.equals("2") || tipus.equals("P")));

        System.out.println("\nCalories de la recepta:");
        calories = DADES.nextDouble();

    }


    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte. En aquest cas no
     es pot modificar l'atribut ingredients, ni l'atribut assignada.
     - En el cas del tipus, l'usuari ha d'introduir 1, si es tracta d'un primer plat, 2
     si es tracta d'un segon i P si són unes postres. Heu de comprovar que la dada
     introduida per l'usuari és la correcta (1, 2 o P) si no tornarem a demanr-li 
     que introdueixi la dada. Això ho farem fins que introdueixi la dada correcta.
     - Li heu de mostrar a l'usuari el valor actual dels atributs de l'objecte
     actual, abans de modificar-los
     Retorn: cap
     */
    public void modificarRecepta() {

        String tipus;

        System.out.println("\nCodi de la recepta: " + codi);
        System.out.println("\nEntra el nou codi:");
        codi = DADES.next();
        DADES.nextLine(); //Neteja buffer
        System.out.println("\nNom de la recepta: " + nom);
        System.out.println("\nEntra el nou nom:");
        nom = DADES.nextLine();
        System.out.println("\nElaboració de la recepta: " + elaboracio);
        System.out.println("\nEntra la nova elaboració:");
        elaboracio = DADES.nextLine();

        System.out.println("\nTipus de recepta: " + this.tipus);
        do {
            System.out.println("\nNou tipus: ((1)primer plat, (2)segon plat, (P)Postres");
            tipus = DADES.next();
        } while (!(tipus.equals("1") || tipus.equals("2") || tipus.equals("P")));
        this.tipus = tipus;

        System.out.println("\nCalories de la recepta: " + calories);
        System.out.println("\nNoves calories de la recepta:");
        calories = DADES.nextDouble();
        DADES.nextLine(); //Neteja buffer
    }

    public void mostrarRecepta() {
        System.out.println("\nLes dades de la recepta amb codi " + codi + " són:");
        System.out.println("\nNom:" + nom);
        System.out.println("\nTipus:" + tipus);
        System.out.println("\nCalories:" + calories);
        System.out.println("\nIngredients:");
        for (int i = 0; i < ingredients.length && ingredients[i] != null; i++) {
            ingredients[i].mostrarAliment();
        }
        System.out.println("\nElaboració:" + elaboracio);
    }

    /*
     INGREDIENT
     */
 /*
     Paràmetres: cap
     Accions:
     - afegeix un nou ingredient al vector d'ingredients d'aquesta recepta (l'objecte actual),
     si aquest encara no s'ha afegit, fent servir el mètode de la classe Ingredients pertinent,    
     i actualitza la posició del vector d'ingredients.
     - heu de fer servir el mètode escaient d'aquesta classe per comprovar si l'ingredient
     ja s'ha afegit o no.
     - Si l'ingredient ja s'habia afegit, no s'afegirà de nou i li mostrarem a l'usuari
     el missatge "\nL'ingredient ja existeix".
     Retorn: cap
     */
    public void afegirIngredient() {

        Aliment ingredient = Aliment.nouAliment();

        if (seleccionarIngredient(ingredient.getCodi()) == -1) {
            ingredients[posicioIngredients] = ingredient;
            posicioIngredients++;
        } else {
            System.out.println("\nL'ingredient ja existeix");
        }

    }

    public int seleccionarIngredient(String codi) {

        boolean trobat = false;
        int pos = -1;

        for (int i = 0; i < posicioIngredients && !trobat; i++) {
            if (ingredients[i].getCodi().equals(codi)) {
                pos = i;
                trobat = true;
            }
        }

        return pos;
    }

    
    public void mostrarComponent() {
        System.out.println("El codi de la recepta es: " + codi);
        System.out.println("El nom de la recepta es: " + nom);
        System.out.println("La elaboracio de la recepta es: " + elaboracio);
        System.out.println("El tipus de recepta es: " + tipus);
        System.out.println("Les calories de la recepta son: " + calories);
    }

}
