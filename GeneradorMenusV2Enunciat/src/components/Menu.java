
package components;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
  @author david
 */
public abstract class Menu implements Components {
    protected int codi;
    protected static int properCodi;
    protected Date data;
    protected Recepta[] plats;
    
    public Menu(){
        codi = properCodi++;
        properCodi++;
        plats = new Recepta[3];
        data = new Date();
    }

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public static int getProperCodi() {
        return properCodi;
    }

    public static void setProperCodi(int aProperCodi) {
        properCodi = aProperCodi;
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
   /* public void mostrarMenu(){
      System.out.println("\nLes dades del menú amb codi " + codi + " són:");
        SimpleDateFormat formatData= new SimpleDateFormat("D - E dd-MM-yy hh:mm:ss");
        System.out.println("\nData de creació:" + formatData.format(data));
        System.out.println("\nPlats:");
        for (int i = 0; i < plats.length; i++) {
            switch (i) {
                case 0:
                    if (plats[0] == null) {
                        System.out.println("\nNo hi ha primer plat");
                    } else {
                        System.out.println("\nPrimer plat: ");
                        plats[0].mostrarRecepta();
                    }
                    break;
                case 1:
                    if (plats[1] == null) {
                        System.out.println("\nNo hi ha segon plat");
                    } else {
                        System.out.println("\nSegon plat: ");
                        plats[1].mostrarRecepta();
                    }
                    break;
                case 2:
                    if (plats[2] == null) {
                        System.out.println("\nNo hi ha postres");
                    } else {
                        System.out.println("\nPostres: ");
                        plats[2].mostrarRecepta();
                    }
                    break;
            }
        }
    }*/
    
    public void afegirPlat(Recepta recepta){
        switch (recepta.getTipus()) {
            case "1":
                plats[0] = recepta;
                break;
            case "2":
                plats[1] = recepta;
                break;
            default:
                plats[2] = recepta;
                break;
        }

        recepta.setAssignada(true);
    }
    @Override
    public void mostrarComponent() {
         System.out.println("\nLes dades del menú amb codi " + codi + " són:");
        SimpleDateFormat formatData= new SimpleDateFormat("D - E dd-MM-yy hh:mm:ss");
        System.out.println("\nData de creació:" + formatData.format(data));
        System.out.println("\nPlats:");
        for (int i = 0; i < plats.length; i++) {
            switch (i) {
                case 0:
                    if (plats[0] == null) {
                        System.out.println("\nNo hi ha primer plat");
                    } else {
                        System.out.println("\nPrimer plat: ");
                        plats[0].mostrarRecepta();
                    }
                    break;
                case 1:
                    if (plats[1] == null) {
                        System.out.println("\nNo hi ha segon plat");
                    } else {
                        System.out.println("\nSegon plat: ");
                        plats[1].mostrarRecepta();
                    }
                    break;
                case 2:
                    if (plats[2] == null) {
                        System.out.println("\nNo hi ha postres");
                    } else {
                        System.out.println("\nPostres: ");
                        plats[2].mostrarRecepta();
                    }
                    break;
            }
        }
    }
}
