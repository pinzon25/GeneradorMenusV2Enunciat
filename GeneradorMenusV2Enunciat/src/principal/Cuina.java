/*
 * Classe que defineix una cuina. Una cuina es defineix per un codi i una adreça
 * (l'adreça del pis d'estudiants al que pertany la cuina). A més, contindrà arrays 
 * amb receptes, aliments, menús ordinàris i menús de règim. 
 */
package principal;

import components.Aliment;
import components.Components;
import components.MenuOrdinari;
import components.MenuRegim;
import components.Recepta;
import java.util.Scanner;

/**
 *
 * @author fta
 */
public class Cuina implements Components {

    private Components[] components;
    private int posicioComponents;
    private String adreca;


    /*
    //private final static Scanner DADES = new Scanner(System.in);
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
     */
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
        components = new Components[350];
        posicioComponents = 0;
        adreca = pAdreca;

        /*codi = properCodi;
        properCodi++;
        adreca = pAdreca;
        receptes = new Recepta[100];
        aliments = new Aliment[150];
        menusOrdinaris = new MenuOrdinari[50];
        menusRegim = new MenuRegim[50];
        posicioReceptes = 0;
        posicioAliments = 0;
        posicioMenusOrdinaris = 0;
        posicioMenusRegim = 0;*/
    }

    public Components[] getComponents() {
        return components;
    }

    public void setComponents(Components[] components) {
        this.components = components;
    }

    public int getPosicioComponents() {
        return posicioComponents;
    }

    public void setPosicioComponents(int posicioComponents) {
        this.posicioComponents = posicioComponents;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    /*
     Mètodes accessors    
     *//*
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
     */

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
        adreca = (String) demanarDades("\nEntra la nova adreça:", 4);
        //adreca = DADES.nextLine();
    }

    public void mostrarComponent() {
        System.out.println("\nLes dades de la cuina amb codi " + posicioComponents + " són:");
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
        components[posicioComponents] = Recepta.novaRecepta();
        posicioComponents++;
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

        if (seleccionarComponent(2, aliment.getCodi()) == -1) {
            components[posicioComponents] = aliment;
            posicioComponents++;
        } else {
            System.out.println("\nL'aliment ja existeix");
        }

    }

    public int seleccionarComponent(int tipusComponent, Object codi) {
        String tipusObjecte;
        int valor;
        int pos = -1;
        boolean trobat = false;

        if (codi == null) {

            switch (tipusComponent) {
                case 1:
                    tipusObjecte = "la recepta";
                    valor = 4;
                case 2:
                    tipusObjecte = "el aliment";
                    valor = 4;
                case 3:
                    tipusObjecte = "el menu ordinari";
                    valor = 1;

                default:
                    tipusObjecte = "el menu de regim";
                    valor = 1;
            }
            String peticio = "Codi de " + tipusObjecte + "?";
            codi = demanarDades(peticio, valor);

        }

        for (int i = 0; i < posicioComponents && !trobat; i++) {

            if (components[i] instanceof Aliment) {
                if (((Aliment) components[i]).getCodi().equals(codi)) {
                    pos = i;
                    trobat = true;
                }
            }//  aliment

            if (components[i] instanceof Recepta) {
                if (((Recepta) components[i]).getCodi().equals(codi)) {
                    pos = i;
                    trobat = true;
                }
            }// recepta

            if (components[i] instanceof MenuOrdinari) {
                if (((MenuOrdinari) components[i]).getCodi() == (int) codi) {
                    pos = i;
                    trobat = true;
                }
            }// menu ordinari

            if (components[i] instanceof MenuRegim) {
                if (((MenuRegim) components[i]).getCodi() == ((int) codi)) {
                    pos = i;
                    trobat = true;
                }
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
        components[posicioComponents] = new MenuOrdinari();
        posicioComponents++;
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
        components[posicioComponents] = MenuRegim.nouMenuRegim();
        posicioComponents++;
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

        int pos = seleccionarComponent(1, null);

        if (pos >= 0) {
            ((Recepta) components[pos]).afegirIngredient();
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
        while (pos < posicioComponents && (platsMenu[0] || platsMenu[1] || platsMenu[2])) {
            if (components[posicioComponents] instanceof Recepta) {
                int i = 0;

                if (!((Recepta) components[pos]).getAssignada() && ((platsMenu[0] && ((Recepta) components[pos]).getTipus().equals("1")) || (platsMenu[1] && ((Recepta) components[pos]).getTipus().equals("2")) || (platsMenu[2] && ((Recepta) components[pos]).getTipus().equals("P")))) {

                    while (i < ((Recepta) components[pos]).getPosicioIngredients() && trobat) { //recorregut ingredients recepta actual

                        trobat = false;

                        for (int j = 0; j < posicioComponents && !trobat; j++) { //recorregut aliments cuina

                            if (((Recepta) components[pos]).getIngredients()[i].equals((Aliment) components[j]) && ((Recepta) components[pos]).getIngredients()[i].getQuantitat() <= ((Aliment) components[j]).getQuantitat()) { //Hem trobat un ingredient de la recepta
                                trobat = true;
                            }
                        }

                        i++;
                    }

                }

                if (i == ((Recepta) components[pos]).getPosicioIngredients()) { //tenim tots els ingredients per cuinar la recepta

                    ((MenuOrdinari) components[posicioComponents]).afegirPlat(((Recepta) components[pos]));

                    switch (((Recepta) components[pos]).getTipus()) {
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
            } // aqui if
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
        double calories = ((MenuRegim) components[posicioComponents]).getCalories();

        //Recorregut receptes
        while (pos < posicioComponents) {
            if (components[posicioComponents] instanceof Recepta) {
                int i = 0;

                if (!((Recepta) components[pos]).getAssignada() && ((Recepta) components[pos]).getCalories() <= calories) {

                    while (i < ((Recepta) components[pos]).getPosicioIngredients() && trobat) { //recorregut ingredients recepta actual

                        trobat = false;

                        for (int j = 0; j < posicioComponents && !trobat; j++) { //recorregut aliments cuina

                            if (((Recepta) components[pos]).getIngredients()[i].equals((Aliment) components[j]) && ((Recepta) components[pos]).getIngredients()[i].getQuantitat() <= ((Aliment) components[j]).getQuantitat()) { //Hem trobat un ingredient de la recepta
                                trobat = true;
                            }
                        }

                        i++;
                    }

                }

                if (i == ((Recepta) components[pos]).getPosicioIngredients()) { //tenim ingredient per cuinar la recepta
                    ((MenuOrdinari) components[posicioComponents]).afegirPlat(((Recepta) components[pos]));
                    calories -= ((Recepta) components[pos]).getCalories();
                }

                pos++;
                // if intanceof
            }
        }

    }
}
