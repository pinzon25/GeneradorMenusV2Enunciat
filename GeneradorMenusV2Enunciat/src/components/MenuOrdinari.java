/*
 * Classe que defineix un menú ordinari. Un menú ordinari es defineix pel seu codi,
 * data de creació i un vector amb els plats (receptes) que formen part del menú.
 */
package components;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author fta
 */
public class MenuOrdinari extends Menu {

    /*
     CONSTRUCTOR
     Paràmetres: cap
     Accions:
     - plats s'ha d'inicialtizar buit i amb una capacitat per 3 plats.
     - Assignar a l'atribut codi el valor de l'atribut properCodi i actualitzar
     properCodi amb el següent codi a assignar.
     - data s'ha d'incialitzar amb la data actual del sistema.     
     */
    public MenuOrdinari() {
        super();
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Recepta[] getPlats() {
        return plats;
    }

    public void setPlats(Recepta[] plats) {
        this.plats = plats;
    }

    /*public void mostrarMenu() {
        super.mostrarMenu();
    }*/

    /*
     PLATS
     */
 /*
     Paràmetres: recepta a afegir
     Accions:
     - Afegeix la recepta passada per paràmetre en la posició (si aquesta està buida)
     corresponent del vector de plats segons el tipus de recepta, és a dir, si és
     un primer plat s'ha de situar en la posició 0 de plats, si és un segon en la 
     posició 1 i si és una postre, en la posició 2.
     - L'estat de la recepta afegida a de canviar a verdader.
     Retorn: cap
     */
    public void afegirPlat(Recepta recepta) {

        if (plats[0] == null && recepta.getTipus().equals("1")) {
            plats[0] = recepta;
        } else if (plats[1] == null && recepta.getTipus().equals("2")) {
            plats[1] = recepta;
        } else if (plats[2] == null && recepta.getTipus().equals("P")) {
            plats[2] = recepta;
        }
        
        recepta.setAssignada(true);
    }

    @Override
    public void mostrarComponent() {
        super.mostrarComponent();
        
    }

    @Override
    public Object demanarDades(String peticio, int tipus) {
        return super.demanarDades(peticio, tipus); //To change body of generated methods, choose Tools | Templates.
    }
}
