/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.util.Scanner;

/**
 *
 * @author david
 */
public interface Components {

    Scanner DADES = new Scanner(System.in);

    public void mostrarComponent();

    default Object demanarDades(String peticio, int tipus) {
        System.out.println(peticio);
        switch (tipus) {

            case 1:
                return DADES.nextInt();
            case 2:
                return DADES.next();
            case 3:
                return DADES.nextDouble();
            default:
                return DADES.nextLine();

        }
    }
}
