/*
 * Classe que defineix una recepta. Una recepta es defineix pel seu codi, nom,
 * un vector amb el seus ingredients (aliments), el text amb els passos per la seva elaboració,
 * el tipus de recepta què és, és a dir, si és un primer plat, un segon o postres,
 * i les calories que té.
 */
package components;

/**
 *
 * @author fta
 */
public class Recepta implements Components {

    /*Com la interface ja te la variable de tipus Scanner, aqui podem comentarla o directament eliminarla.*/
    //private final static Scanner DADES = new Scanner(System.in);
    private String codi;
    private String nom;
    private Aliment[] ingredients;
    private int posicioIngredients; //Possició actual buida del vector ingredients
    private String elaboracio;
    private String tipus;
    private double calories;
    private boolean assignada;

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
    public Recepta() {
        codi = "";
        nom = "";
        ingredients = new Aliment[25];
        posicioIngredients = 0;
        elaboracio = "";
        tipus = "";
        calories = 0;
        assignada = false;
    }

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
 /*
    Com el metode novaRecepta() no es estatic, aqui si podem utilitzar el metode demanarDades, declarat a la interface.
        Degut a que el metode retorna per defecte un "Object", el qual no es d'un tipus especificat, hem de realitzar un cast perque pugui entrar dintre del switch que conte la funcio i
        funcionar correctament. Les opcions que tenen un int 0, es perque al switch del metode demanarDades, la opcio per defecte si no es 1,2 o 3, es un nextLine(), per tant els camps amb una
        amplia quantitat de text els agafem com a nextLine();
     */
    public static Recepta novaRecepta() { //Li canviem el modificador i el tipus de retorn, ja que sino, no podrem cridarlo desde la classe cuina i afegir la recepta al vector components.
        
        //A la VERSIO ANTERIOR les variables locals es comenten.
        String codi;
        String nom;
        String elaboracio;
        String tipus;
        double calories;

        /* //VERSIO ANTERIOR.
        
        codi = (String) demanarDades("\nCodi de la recepta:", 2);
        DADES.nextLine(); //Neteja buffer
        nom = (String) demanarDades("\nNom de la recepta:", 0);
        elaboracio = (String) demanarDades("\nElaboració de la recepta:", 0);

        do {
            tipus = (String) demanarDades("\nTipus de recepta: ((1)primer plat, (2)segon plat, (P)Postres)", 2);
        } while (!(tipus.equals("1") || tipus.equals("2") || tipus.equals("P")));

        System.out.println("\nCalories de la recepta:");
        calories = (double) demanarDades("\nCalories de la recepta:", 3);
         */
        
        //VERSIO ACTUAL
        System.out.println("Codi de la recepta: ");
        codi = DADES.next();
        System.out.println("Nom de la recepta: ");
        nom = DADES.nextLine();
        System.out.println("Elaboracio de la recepta: ");
        elaboracio = DADES.nextLine();
        System.out.println("\n\nTipus de recepta: ((1)primer plat, (2)segon plat, (P)Postres)");
        tipus = DADES.next();
        System.out.println("Calories de la recepta: ");
        calories = DADES.nextDouble();

        return new Recepta(codi, nom, elaboracio, tipus, calories);

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

        System.out.println("\nCodi de la recepta: " + codi);
        codi = (String) demanarDades("\nEntra el nou codi:", 2);
        DADES.nextLine(); //Neteja buffer

        System.out.println("\nNom de la recepta: " + nom);
        nom = (String) demanarDades("\nEntra el nou nom:", 0);

        System.out.println("\nElaboració de la recepta: " + elaboracio);
        elaboracio = (String) demanarDades("\nEntra la nova elaboració:", 0);

        System.out.println("\nTipus de recepta: " + this.tipus);
        do {
            tipus = (String) demanarDades("\nNou tipus: ((1)primer plat, (2)segon plat, (P)Postres", 2);
        } while (!(tipus.equals("1") || tipus.equals("2") || tipus.equals("P")));
        this.tipus = tipus;

        System.out.println("\nCalories de la recepta: " + calories);
        calories = (double) demanarDades("\nNoves calories de la recepta:", 3);
        DADES.nextLine(); //Neteja buffer
    }

    public void mostrarComponent() {
        System.out.println("\nLes dades de la recepta amb codi " + codi + " són:");
        System.out.println("\nNom:" + nom);
        System.out.println("\nTipus:" + tipus);
        System.out.println("\nCalories:" + calories);
        System.out.println("\nIngredients:");
        for (int i = 0; i < ingredients.length && ingredients[i] != null; i++) {
            ingredients[i].mostrarComponent();
            /*El metode mostrarComponent el podem utilitzar amb l'atribut ingredient d'aquesta classe,ja que es de tipus Aliment, 
            despres repassem tots els aliments, i imprimim el seu contingut. 
            El metode de la classe aliment de mostrarAliment(), 
            el podem substituir pel metode de la interface anomentat mostrarComponent(), ja que tambe implementa la interface.
             */
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

}
