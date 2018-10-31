/*
 * Classe Aplicacio per interactuar amb l'usuari i cridar a la resta de classes 
 * i mètodes mitjançant uns menús.
 */
package principal;

import java.util.Scanner;

/**
 *
 * @author fta
 */
public class Aplicacio {

    private final static Scanner DADES = new Scanner(System.in);

    private static Cuina[] cuines = new Cuina[4];//Cuines dels estudiants
    private static int posicioCuines = 0; //La propera posició buida del vector cuines
    private static Cuina cuinaActual = null; //Cuina seleccionada    

    public static void main(String[] args) {

        menuPrincipal();

    }

    private static void menuPrincipal() {
        int opcio = 0;

        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Gestió de cuines"); //FET
            System.out.println("\n2. Gestió de receptes");
            System.out.println("\n3. Gestió d'aliments");
            System.out.println("\n4. Gestió de menús ordinaris");
            System.out.println("\n5. Gestió de menús de règim");

            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    menuCuina();
                    break;
                case 2:
                    if (cuinaActual != null) {
                        menuComponents(2);
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la cuina en el menú de cuines");
                    }
                    break;
                case 3:
                    if (cuinaActual != null) {
                        menuComponents(3);
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la cuina en el menú de cuines");
                    }
                    break;
                case 4:
                    if (cuinaActual != null) {
                        menuComponents(4);
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la cuina en el menú de cuines");
                    }
                    break;
                case 5:
                    if (cuinaActual != null) {
                        menuComponents(5);
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la cuina en el menú de cuines");
                    }
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }

        } while (opcio != 0);
    }

    public static void menuCuina() {
        int opcio = 0;
        String codi;
        boolean trobat = false;
        do {
            int pos = -1;

            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Seleccionar");
            System.out.println("\n3. Modificar");
            System.out.println("\n4. LListar cuines");

            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    cuines[posicioCuines] = Cuina.novaCuina();
                    posicioCuines++;
                    break;
                case 2: //pos = seleccionarCuina(); //pos = cuinaActual.getPosicioComponents();
                    codi = (String) demanarDades("Insereix la adreca de la cuina: ", 0);
                    for (int i = 0; i < posicioCuines && !trobat; i++) { //repassem les cuines que tenim, i si el codi(direccio) de la cuina es igual que el introduit, la i es la posicio.
                        if (cuines[i].getAdreca().equals(codi)) {
                            pos = i;
                            trobat = true;
                        }
                    }
                    if (pos >= 0) {
                        cuinaActual = cuines[pos]; //cuinaActual obte la cuina que hem escollit.
                    } else {
                        System.out.println("\nNo existeix aquesta cuina");
                    }
                    break;
                case 3:
                    //pos = cuinaActual.getPosicioComponents();
                    if (pos >= 0) {
                        cuines[pos].modificarCuina();
                    } else {
                        System.out.println("\nNo existeix aquesta cuina");
                    }
                    break;
                case 4:
                    for (int i = 0; i < posicioCuines; i++) {
                        cuines[i].mostrarComponent();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuComponents(int tipus) {
        int opcio = 0;
        int pos = -1;
        String codi;
        switch (tipus) {

            case 1: //Recepta
                do {
                    System.out.println("\nSelecciona una opció per a la Recepta: ");
                    System.out.println("\n0. Sortir");
                    System.out.println("\n1. Alta");
                    System.out.println("\n2. Modificar");
                    System.out.println("\n3. Afegir ingredient");
                    System.out.println("\n4. Llistar receptes");

                    opcio = DADES.nextInt();

                    switch (opcio) {
                        case 0:
                            break;
                        case 1:
                            cuinaActual.afegirRecepta();
                            break;
                        case 2:
                            //pos = cuinaActual.seleccionarRecepta();
                            
                            codi = (String) demanarDades("Insereix el codi de la recepta a modificar: ", 2);
                            pos = cuinaActual.seleccionarComponent(1, codi); //Li passem el 1 ja que es el numero assignat als objectes de tipus Recepta. Retorna la posicio de la recepta.

                            for (int i = 0; i < cuinaActual.getPosicioComponents(); i++) { //repassem els components que tenim a la cuina, i si el codi(direccio) de la cuina es igual que el introduit, la i es la posicio.
                                if (cuinaActual.getComponents()[pos].equals(cuina)) { //if (cuines[i].getAdreca().equals(codi)) {
                                    pos = i;
                                }
                            }
                            if (pos >= 0) {
                                //cuinaActual.getReceptes()[pos].modificarRecepta();
                                cuinaActual.getComponents()[pos].demanarDades("codi", 2);
                                cuinaActual.getComponents()[pos].demanarDades("nom", 3);
                                cuinaActual.getComponents()[pos].demanarDades("elaboracio", 0);
                                cuinaActual.getComponents()[pos].demanarDades("tipus: (1)primer plat, (2)segon plat, (P)Postres", 2);
                                cuinaActual.getComponents()[pos].demanarDades("Calories", 3);
                            } else {
                                System.out.println("\nNo existeix aquesta recepta");
                            }
                            break;
                        case 3:
                            cuinaActual.afegeixIngredientRecepta();
                            break;
                        case 4:
                            /*
                            for (int i = 0; i < cuinaActual.getPosicioReceptes(); i++) {
                                cuinaActual.getReceptes()[i].mostrarRecepta();
                            }*/
                            for (int i = 0; i < cuinaActual.getPosicioReceptes(); i++) {
                                cuinaActual.getReceptes()[i].mostrarRecepta();
                            }
                            break;
                        default:
                            System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                            break;
                    }
                } while (opcio != 0);
                break;
            case 2: //Aliment

                do {
                    System.out.println("\nSelecciona una opció");
                    System.out.println("\n0. Sortir");
                    System.out.println("\n1. Alta");
                    System.out.println("\n2. Modificar");
                    System.out.println("\n3. Llistar aliments");

                    opcio = DADES.nextInt();

                    switch (opcio) {
                        case 0:
                            break;
                        case 1:
                            cuinaActual.afegirAliment();
                            break;
                        case 2:
                            int pos = cuinaActual.seleccionarAliment(null);
                            if (pos >= 0) {
                                cuinaActual.getAliments()[pos].modificarAliment();
                            } else {
                                System.out.println("\nNo existeix aquest aliment");
                            }
                            break;
                        case 3:
                            for (int i = 0; i < cuinaActual.getPosicioAliments(); i++) {
                                cuinaActual.getAliments()[i].mostrarAliment();
                            }
                            break;
                        default:
                            System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                            break;
                    }
                } while (opcio != 0);
                break;
            case 3: //MenuOrdinari

                do {
                    System.out.println("\nSelecciona una opció");
                    System.out.println("\n0. Sortir");
                    System.out.println("\n1. Alta");
                    System.out.println("\n2. Llistar menús ordinaris");

                    opcio = DADES.nextInt();

                    switch (opcio) {
                        case 0:
                            break;
                        case 1:
                            cuinaActual.afegirMenuOrdinari();

                            String resposta;
                            boolean[] plats = new boolean[3];

                            do {
                                System.out.println("\nVols primer plat?: ((S)si, (N)no");

                                resposta = DADES.next();

                                switch (resposta) {
                                    case "S":
                                        plats[0] = true;
                                        break;
                                    case "N":
                                        plats[0] = false;
                                        break;
                                    default:
                                        System.out.println("\nLa resposta no és correcta");
                                        break;
                                }

                            } while (!(resposta.equals("S")) && !(resposta.equals("N")));

                            do {
                                System.out.println("\nVols segon plat?: ((S)si, (N)no");

                                resposta = DADES.next();

                                switch (resposta) {
                                    case "S":
                                        plats[1] = true;
                                        break;
                                    case "N":
                                        plats[1] = false;
                                        break;
                                    default:
                                        System.out.println("\nLa resposta no és correcta");
                                        break;
                                }

                            } while (!(resposta.equals("S")) && !(resposta.equals("N")));

                            do {
                                System.out.println("\nVols postres?: ((S)si, (N)no");

                                resposta = DADES.next();

                                switch (resposta) {
                                    case "S":
                                        plats[2] = true;
                                        break;
                                    case "N":
                                        plats[2] = false;
                                        break;
                                    default:
                                        System.out.println("\nLa resposta no és correcta");
                                        break;
                                }

                            } while (!(resposta.equals("S")) && !(resposta.equals("N")));

                            cuinaActual.afegeixPlatsMenuOrdinari(plats);
                            break;

                        case 2:
                            for (int i = 0; i < cuinaActual.getPosicioMenusOrdinaris(); i++) {
                                cuinaActual.getMenusOrdinaris()[i].mostrarMenu();
                            }
                            break;

                        default:
                            System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                            break;
                    }
                } while (opcio != 0);
                break;
            case 4: //MenuRegim

                do {
                    System.out.println("\nSelecciona una opció");
                    System.out.println("\n0. Sortir");
                    System.out.println("\n1. Alta");
                    System.out.println("\n2. Modificar");
                    System.out.println("\n3. Llistar menús règim");

                    opcio = DADES.nextInt();

                    switch (opcio) {
                        case 0:
                            break;
                        case 1:
                            cuinaActual.afegirMenuRegim();
                            cuinaActual.afegeixPlatsMenuRegim();
                            break;
                        case 2:
                            int pos = cuinaActual.seleccionarMenuRegim();
                            if (pos >= 0) {
                                cuinaActual.getMenusRegim()[pos].modificarMenuRegim();
                            } else {
                                System.out.println("\nNo existeix aquest menú de Regim");
                            }
                            break;
                        case 3:
                            for (int i = 0; i < cuinaActual.getPosicioMenusRegim(); i++) {
                                cuinaActual.getMenusRegim()[i].mostrarMenu();
                            }
                            break;
                        default:
                            System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                            break;
                    }
                } while (opcio != 0);
                break;
            default:
                System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                break;

        }

    }

    /*
     Heu de desenvolupar el menú receptes amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, la propietat cuinaActual no és null
     
     Opció 0. Sortir -->         Sortim del menú. 
     Opció 1. Alta -->           Crea una recepta en la cuina actual. Penseu que Cuina sap crear receptes       
     Opció 2. Modificar -->      Permet modificar una recepta que ha d'existir a la cuina actual
     (per comprovar l'existència tenim un mètode que ens ajuda a la classe Cuina)
     Opció 3. Afegir ingredient --> Afegeix un ingredient al vector d'ingredients d'una recepta, però
     penseu que Cuina sap fer-ho
     Opció 4. Llistar receptes-->Imprimeix les dades de les receptes de la cuina actual
        
     A més, heu de fer un bucle per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     Recomanacions:
     - estructura de control switch case per bifurcar les opcions
     - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge
     "S'ha de seleccionar una opció correcta del menú."
     - definiu una variable int opcio;
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, doncs això ho farem 
     mitjançant les excepcions que veurem en la segúent unitat.
     */
 /*
    public static void menuReceptes() {
        int opcio = 0;

        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Afegir ingredient");
            System.out.println("\n4. Llistar receptes");

            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    cuinaActual.afegirRecepta();
                    break;
                case 2:
                    int pos = cuinaActual.seleccionarRecepta();
                    if (pos >= 0) {
                        cuinaActual.getReceptes()[pos].modificarRecepta();
                    } else {
                        System.out.println("\nNo existeix aquesta recepta");
                    }
                    break;
                case 3:
                    cuinaActual.afegeixIngredientRecepta();
                    break;
                case 4:
                    for (int i = 0; i < cuinaActual.getPosicioReceptes(); i++) {
                        cuinaActual.getReceptes()[i].mostrarRecepta();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }
     */
 /*
     Heu de desenvolupar el menú aliments amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, la propietat cuinaActual no és null
     
     Opció 0. Sortir -->         Sortim del menú. 
     Opció 1. Alta -->           Crea un aliment en la cuina actual. Penseu que Cuina sap crear aliments       
     Opció 2. Modificar -->      Permet modificar un aliment que ha d'existir a la cuina actual
     (per comprovar l'existència tenim un mètode que ens ajuda a la classe Cuina)
     Opció 3. Llistar aliments-->Imprimeix les dades dels aliments de la cuina actual
        
     A més, heu de fer un bucle per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     Recomanacions:
     - estructura de control switch case per bifurcar les opcions
     - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge
     "S'ha de seleccionar una opció correcta del menú."
     - definiu una variable int opcio;
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, doncs això ho farem 
     mitjançant les excepcions que veurem en la segúent unitat.
     */
 /*
    public static void menuAliments() {
        int opcio = 0;

        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Llistar aliments");

            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    cuinaActual.afegirAliment();
                    break;
                case 2:
                    int pos = cuinaActual.seleccionarAliment(null);
                    if (pos >= 0) {
                        cuinaActual.getAliments()[pos].modificarAliment();
                    } else {
                        System.out.println("\nNo existeix aquest aliment");
                    }
                    break;
                case 3:
                    for (int i = 0; i < cuinaActual.getPosicioAliments(); i++) {
                        cuinaActual.getAliments()[i].mostrarAliment();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }
     */
 /*
     Heu de desenvolupar el menú de menús ordinaris amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, la propietat cuinaActual no és null
     
     Opció 0. Sortir -->         Sortim del menú. 
     Opció 1. Alta -->           Crea un nou menú ordinari en la cuina actual i li afegeix els
     plats necessaris. Penseu que Cuina sap crear menús ordinaris i afegir els seus plats.
     Per crear el nou menú, primer li heu de demanar a l'usuari quins són els plats que
     vol. Recordeu que els plats poden ser primer, segon i postres.
     Opció 2. Llistar menús ordinaris-->Imprimeix les dades dels menús ordinaris de la cuina actual
        
     A més, heu de fer un bucle per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     Recomanacions:
     - estructura de control switch case per bifurcar les opcions
     - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge
     "S'ha de seleccionar una opció correcta del menú."
     - definiu una variable int opcio;
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, doncs això ho farem 
     mitjançant les excepcions que veurem en la segúent unitat.
     */
 /*
    public static void menuMenusOrdinaris() {
        int opcio = 0;

        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Llistar menús ordinaris");

            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    cuinaActual.afegirMenuOrdinari();

                    String resposta;
                    boolean[] plats = new boolean[3];

                    do {
                        System.out.println("\nVols primer plat?: ((S)si, (N)no");

                        resposta = DADES.next();

                        switch (resposta) {
                            case "S":
                                plats[0] = true;
                                break;
                            case "N":
                                plats[0] = false;
                                break;
                            default:
                                System.out.println("\nLa resposta no és correcta");
                                break;
                        }

                    } while (!(resposta.equals("S")) && !(resposta.equals("N")));

                    do {
                        System.out.println("\nVols segon plat?: ((S)si, (N)no");

                        resposta = DADES.next();

                        switch (resposta) {
                            case "S":
                                plats[1] = true;
                                break;
                            case "N":
                                plats[1] = false;
                                break;
                            default:
                                System.out.println("\nLa resposta no és correcta");
                                break;
                        }

                    } while (!(resposta.equals("S")) && !(resposta.equals("N")));

                    do {
                        System.out.println("\nVols postres?: ((S)si, (N)no");

                        resposta = DADES.next();

                        switch (resposta) {
                            case "S":
                                plats[2] = true;
                                break;
                            case "N":
                                plats[2] = false;
                                break;
                            default:
                                System.out.println("\nLa resposta no és correcta");
                                break;
                        }

                    } while (!(resposta.equals("S")) && !(resposta.equals("N")));

                    cuinaActual.afegeixPlatsMenuOrdinari(plats);
                    break;

                case 2:
                    for (int i = 0; i < cuinaActual.getPosicioMenusOrdinaris(); i++) {
                        cuinaActual.getMenusOrdinaris()[i].mostrarMenu();
                    }
                    break;

                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }
     */
 /*
     Heu de desenvolupar el menú de menús de règim amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, la propietat cuinaActual no és null
     
     Opció 0. Sortir -->         Sortim del menú. 
     Opció 1. Alta -->           Crea un nou menú de règim en la cuina actual i li afegeix els
     plats necessaris. Penseu que Cuina sap crear menús ordinaris i afegir els seus plats. Abans
     de crear-lo, li demanarà a l'usuari les calories màximes del menú de règim.
     Opció 2. Llistar menús de règim-->Imprimeix les dades dels menús ordinaris de la cuina actual
        
     A més, heu de fer un bucle per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     Recomanacions:
     - estructura de control switch case per bifurcar les opcions
     - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge
     S'ha de seleccionar una opció correcta del menú.
     - definiu una variable int opcio;
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, doncs això ho farem 
     mitjançant les excepcions que veurem en la segúent unitat.
     */
/*
    public static void menuMenusRegim() {
        int opcio = 0;

        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Llistar menús règim");

            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    cuinaActual.afegirMenuRegim();
                    cuinaActual.afegeixPlatsMenuRegim();
                    break;
                case 2:
                    int pos = cuinaActual.seleccionarMenuRegim();
                    if (pos >= 0) {
                        cuinaActual.getMenusRegim()[pos].modificarMenuRegim();
                    } else {
                        System.out.println("\nNo existeix aquest menú de Regim");
                    }
                    break;
                case 3:
                    for (int i = 0; i < cuinaActual.getPosicioMenusRegim(); i++) {
                        cuinaActual.getMenusRegim()[i].mostrarMenu();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    
     }
