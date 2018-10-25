/*
 * Classe que defineix una cuina. Una cuina es defineix per un codi i una adreça
 * (l'adreça del pis d'estudiants al que pertany la cuina). A més, contindrà arrays 
 * amb receptes, aliments, menús ordinàris i menús de règim. 
 */
package principal;

import components.Aliment;
import components.MenuOrdinari;
import components.MenuRegim;
import components.Recepta;
import java.util.Scanner;

/**
 *
 * @author fta
 */
public class Cuina {

    private final static Scanner DADES = new Scanner(System.in);

    private int codi;
    private static int properCodi = 1; //El proper codi a assignar
    private String adreca;
    private Recepta[] receptes;
    private int posicioReceptes; //Possició actual buida del vector receptes
    private Aliment[] aliments;
    private int posicioAliments; //Possició actual buida del vector aliments
    private MenuOrdinari[] menusOrdinaris;
    private int posicioMenusOrdinaris; //Possició actual buida del vector menusOrdinaris
    private MenuRegim[] menusRegim;
    private int posicioMenusRegim; //Possició actual buida del vector menusRegim

    /*
     CONSTRUCTOR
     Paràmetres: valor per l'atribut adreca
     Accions:
     - Assignar a l'atribut corresponent el valor passat com a paràmetre
     - Assignar a l'atribut codi el valor de l'atribut properCodi i actualitzar
     properCodi amb el següent codi a assignar.
     - receptes s'ha d'inicialtizar buit i amb una capacitat per 100 receptes.
     - aliments s'ha d'inicialtizar buit i amb una capacitat per 150 aliments.
     - menusOrdinaris s'ha d'inicialtizar buit i amb una capacitat per 50 menús ordinàris.
     - menusRegim s'ha d'inicialtizar buit i amb una capacitat per 50 menús de règim.
     - posicioReceptes, posicioAliments, posicioMenusOrdinaris i posicioMenusRegim
     s'han d'inicialtizar a 0, ja que és la primera posició del vector aliments.
     */
    public Cuina(String pAdreca) {
        codi = properCodi;
        properCodi++;
        adreca = pAdreca;
        receptes = new Recepta[100];
        aliments = new Aliment[150];
        menusOrdinaris = new MenuOrdinari[50];
        menusRegim = new MenuRegim[50];
        posicioReceptes = 0;
        posicioAliments = 0;
        posicioMenusOrdinaris = 0;
        posicioMenusRegim = 0;
    }

    /*
     Mètodes accessors    
     */
    public int getCodi() {
        return codi;
    }

    public void setCodi() {
        codi = properCodi;
    }

    public static int getProperCodi() {
        return properCodi;
    }

    public static void setProperCodi() {
        properCodi++;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public Recepta[] getReceptes() {
        return receptes;
    }

    public void setReceptes(Recepta[] receptes) {
        this.receptes = receptes;
    }

    public int getPosicioReceptes() {
        return posicioReceptes;
    }

    public void setPosicioReceptes(int posicioReceptes) {
        this.posicioReceptes = posicioReceptes;
    }

    public Aliment[] getAliments() {
        return aliments;
    }

    public void setAliments(Aliment[] aliments) {
        this.aliments = aliments;
    }

    public int getPosicioAliments() {
        return posicioAliments;
    }

    public void setPosicioAliments(int posicioAliments) {
        this.posicioAliments = posicioAliments;
    }

    public MenuOrdinari[] getMenusOrdinaris() {
        return menusOrdinaris;
    }

    public void setMenusOrdinaris(MenuOrdinari[] menusOrdinaris) {
        this.menusOrdinaris = menusOrdinaris;
    }

    public int getPosicioMenusOrdinaris() {
        return posicioMenusOrdinaris;
    }

    public void setPosicioMenusOrdinaris(int posicioMenusOrdinaris) {
        this.posicioMenusOrdinaris = posicioMenusOrdinaris;
    }

    public MenuRegim[] getMenusRegim() {
        return menusRegim;
    }

    public void setMenusRegim(MenuRegim[] menusRegim) {
        this.menusRegim = menusRegim;
    }

    public int getPosicioMenusRegim() {
        return posicioMenusRegim;
    }

    public void setPosicioMenusRegim(int posicioMenusRegim) {
        this.posicioMenusRegim = posicioMenusRegim;
    }

    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear una nova Cuina. Les dades
     a demanar són les que necessita el constructor.
     - Heu de tenir en compte que el nom de l'adreça, poden ser frases, per exemple,
     C/ Gandia, 2.
     Retorn: La nova cuina creada.
     */
    public static Cuina novaCuina() {

        System.out.println("Adreça de la cuina:");
        return new Cuina(DADES.nextLine());
    }

    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte. En aquest cas
     no es pot modificar el contingut dels vectors, només el de l'atribut adreça. 
     Evidentment, tampoc podeu modificar el codi.
     - Li heu de mostrar a l'usuari els valors actuals dels atributs de l'objecte
     actual, abans de modificar-los.
     Retorn: cap
     */
    public void modificarCuina() {

        System.out.println("\nAdreça de la cuina: " + adreca);
        System.out.println("\nEntra la nova adreça:");
        adreca = DADES.nextLine();
    }

    public void mostrarCuina() {
        System.out.println("\nLes dades de la cuina amb codi " + codi + " són:");
        System.out.println("\nAdreça:" + adreca);
    }

    /*
     RECEPTA
     */
 /*
     Paràmetres: cap
     Accions:
     - afegeix una nova recepta al vector de receptes d'aquesta cuina (l'objecte actual),
     fent servir el mètode de la classe Recepta pertinent.
     - actualitza la posició del vector de receptes.
     Retorn: cap
     */
    public void afegirRecepta() {
        receptes[posicioReceptes] = Recepta.novaRecepta();
        posicioReceptes++;
    }

    public int seleccionarRecepta() {

        System.out.println("\nCodi de la recepta?:");
        boolean trobat = false;
        int pos = -1;

        for (int i = 0; i < posicioReceptes && !trobat; i++) {
            if (receptes[i].getCodi().equals(DADES.next())) {
                pos = i;
                trobat = true;
            }
        }

        return pos;
    }

    /*
     ALIMENT
     */
 /*
     Paràmetres: cap
     Accions:
     - afegeix un nou aliment al vector d'aliments d'aquesta cuina (l'objecte actual),
     si aquest encara no s'ha afegit, fent servir el mètode de la classe Aliment pertinent,    
     i actualitza la posició del vector d'aliments.
     - heu de fer servir el mètode escaient d'aquesta classe per comprovar si l'aliment
     ja s'ha afegit o no.
     - Si l'aliment ja s'habia afegit, no s'afegirà de nou i li mostrarem a l'usuari
     el missatge "\nL'aliment ja existeix".
     Retorn: cap
     */
    public void afegirAliment() {
        Aliment aliment = Aliment.nouAliment();

        if (seleccionarAliment(aliment.getCodi()) == -1) {
            aliments[posicioAliments] = aliment;
            posicioAliments++;
        } else {
            System.out.println("\nL'aliment ja existeix");
        }

    }

    public int seleccionarAliment(String codi) {

        if (codi == null) {
            System.out.println("\nCodi de l'aliment?:");
            codi = DADES.next();
        }

        boolean trobat = false;
        int pos = -1;

        for (int i = 0; i < posicioAliments && !trobat; i++) {
            if (aliments[i].getCodi().equals(codi)) {
                pos = i;
                trobat = true;
            }
        }

        return pos;
    }

    /*
     MENÚ ORDINARI
     */
 /*
     Paràmetres: cap
     Accions:
     - afegeix un nou menú ordinari al vector de menús ordinaris d'aquesta cuina (l'objecte actual),
     fent servir el mètode de la classe MenuOrdinar pertinent.
     - actualitza la posició del vector de menús ordinaris.
     Retorn: cap
     */
    public void afegirMenuOrdinari() {
        menusOrdinaris[posicioMenusOrdinaris] = new MenuOrdinari();
        posicioMenusOrdinaris++;
    }

    public int seleccionarMenuOrdinari() {

        System.out.println("\nCodi del menú ordinari?:");
        boolean trobat = false;
        int pos = -1;

        for (int i = 0; i < posicioMenusOrdinaris && !trobat; i++) {
            if (menusOrdinaris[i].getCodi() == DADES.nextInt()) {
                pos = i;
                trobat = true;
            }
        }

        return pos;
    }

    /*
     MENÚ RÈGIM
     */
 /*
     Paràmetres: cap
     Accions:
     - afegeix un nou menú de règim al vector de menús de regim d'aquesta cuina (l'objecte actual),
     fent servir el mètode de la classe MenuRegim pertinent.
     - actualitza la posició del vector de menús de regim.
     Retorn: cap
     */
    public void afegirMenuRegim() {
        menusRegim[posicioMenusRegim] = MenuRegim.nouMenuRegim();
        posicioMenusRegim++;
    }

    public int seleccionarMenuRegim() {

        System.out.println("\nCodi del menú de règim?:");
        boolean trobat = false;
        int pos = -1;

        for (int i = 0; i < posicioMenusRegim && !trobat; i++) {
            if (menusRegim[i].getCodi() == DADES.nextInt()) {
                pos = i;
                trobat = true;
            }
        }

        return pos;
    }

    /*
     Paràmetres: cap
     Accions:
     - afegeix un nou ingredient al vector d'ingredients d'una recepta seleccionada,
     si la recepta existeix en la cuina.
     - heu de fer servir el mètode escaient d'aquesta classe per seleccionar la 
     recepta i el mètode escaient de la classe Recepta per afegir l'ingredient
     a la recepta seleccionada.
     - Si la recepta no existeix, no s'afegirà cap ingredient i li mostrarem a l'usuari
     el missatge "\nNo existeix aquesta recepta".
     Retorn: cap
     */
    public void afegeixIngredientRecepta() {
        int pos = seleccionarRecepta();

        if (pos >= 0) {
            getReceptes()[pos].afegirIngredient();
        } else {
            System.out.println("\nNo existeix aquesta recepta");
        }

    }

    /*
     Paràmetres: vector booleà de 3 posicions. La posició 0 representa el primer 
     plat del menú, la 1 el segon plat i la 3 les postres. Si es vol incloure algun
     dels plats al menú, el valor serà cert, si no fals.
     Accions:
     - Afegirem els plats (receptes) segons els valors del vector passat per paràmetre,
     a l'últim menú afegit al vector de menús ordinaris.
     - Heu d'afegir els plats tenint en compte que els seus ingredients i quantitas
     dels mateixos, es troben actualment en la cuina (vector d'ingredients) i que no
     està assignat a un altre menú.
     - Per afegir els plats heu de fer servir el mètode pertinent de la classe MenuOrdinari.    
     - Un cop afegits els plats al menú, l'aplicació finalitzarà.
     Retorn: cap
     */
    public void afegeixPlatsMenuOrdinari(boolean[] platsMenu) {
        boolean trobat = true;
        int pos = 0;

        //Recorregut receptes
        while (pos < posicioReceptes && (platsMenu[0] || platsMenu[1] || platsMenu[2])) {

            int i = 0;

            if (!receptes[pos].getAssignada() && ((platsMenu[0] && receptes[pos].getTipus().equals("1")) || (platsMenu[1] && receptes[pos].getTipus().equals("2")) || (platsMenu[2] && receptes[pos].getTipus().equals("P")))) {

                while (i < receptes[pos].getPosicioIngredients() && trobat) { //recorregut ingredients recepta actual

                    trobat = false;

                    for (int j = 0; j < posicioAliments && !trobat; j++) { //recorregut aliments cuina

                        if (receptes[pos].getIngredients()[i].equals(aliments[j]) && receptes[pos].getIngredients()[i].getQuantitat() <= aliments[j].getQuantitat()) { //Hem trobat un ingredient de la recepta
                            trobat = true;
                        }
                    }

                    i++;
                }

            }

            if (i == receptes[pos].getPosicioIngredients()) { //tenim tots els ingredients per cuinar la recepta

                menusOrdinaris[posicioMenusOrdinaris - 1].afegirPlat(receptes[pos]);

                switch (receptes[pos].getTipus()) {
                    case "1":
                        platsMenu[0] = false;
                        break;
                    case "2":
                        platsMenu[1] = false;
                        break;
                    default:
                        platsMenu[2] = false;
                        break;
                }

            }

            pos++;
        }
    }

    /*
     Paràmetres: calories que ha de tenir el menú.
     Accions:
     - Afegirem els plats (receptes) tenint en compte que la suma total de les calories
     dels plats, no pot ser major que les calories passades per paràmetre.
     - En aquest cas també hi haurà un primer plat, segon i postres com a màxim,
     tot dependrà de les calories. És a dir, si trobem una recepta que té les mateixes
     calories o s'apropa a les passades per paràmetre, el menú només tindrà un plat. 
     Si la suma de les calories de dos plats (per exemple, primer i segon) coincideix 
     o s'apropa a les calories passades per paràmetre, el menú constarà només d'un 
     primer i un segon, i de la mateixa manera si la suma és igual a les calories 
     de tres plats (primer, segon i postres), el menú constarà de 3 plats.
     - Heu d'afegir els plats tenint en compte que els seus ingredients i quantitas
     dels mateixos, es troben actualment en la cuina (vector d'ingredients) i que no
     està assignat a un altre menú.
     - Per afegir els plats heu de fer servir el mètode pertinent de la classe MenuRegim.    
     - Un cop afegits els plats al menú, l'aplicació finalitzarà.
     Retorn: cap
     */
    public void afegeixPlatsMenuRegim() {
        boolean trobat = true;
        int pos = 0;
        double calories = menusRegim[posicioMenusRegim - 1].getCalories();

        //Recorregut receptes
        while (pos < posicioReceptes) {

            int i = 0;

            if (!receptes[pos].getAssignada() && receptes[pos].getCalories() <= calories) {

                while (i < receptes[pos].getPosicioIngredients() && trobat) { //recorregut ingredients recepta actual

                    trobat = false;

                    for (int j = 0; j < posicioAliments && !trobat; j++) { //recorregut aliments cuina

                        if (receptes[pos].getIngredients()[i].equals(aliments[j]) && receptes[pos].getIngredients()[i].getQuantitat() <= aliments[j].getQuantitat()) { //Hem trobat un ingredient de la recepta
                            trobat = true;
                        }
                    }

                    i++;
                }

            }

            if (i == receptes[pos].getPosicioIngredients()) { //tenim ingredient per cuinar la recepta
                menusOrdinaris[posicioMenusRegim - 1].afegirPlat(receptes[pos]);
                calories -= receptes[pos].getCalories();
            }

            pos++;
        }

    }
    
}
