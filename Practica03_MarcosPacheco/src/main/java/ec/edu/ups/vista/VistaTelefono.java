/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.modelo.Telefono;
import java.util.Collection;
import java.util.Scanner;

/**
 *
 * @author xpacheco
 */
public class VistaTelefono {
    
    private Scanner entrada;

    public VistaTelefono() {
        entrada = new Scanner(System.in);
    }
    
    public Telefono ingresarTelefono() {
        
        entrada = new Scanner(System.in);
        System.out.println("INGRESE LOS DATOS DEL TELEFONO");
        System.out.println("INGRESE EL CODIGO");
        String codigo = entrada.nextLine();
        System.out.println("INGRESE EL TIPO");
        String tipo = entrada.nextLine();
        System.out.println("INGRESE EL NUMERO");
        String numero = entrada.nextLine();
        System.out.println("INGRESE LA OPERADORA");
        String operadora = entrada.nextLine();
        return new Telefono(codigo, tipo, numero, operadora);
        
    }

    public Telefono actualizarTelefono() {
        entrada = new Scanner(System.in);
        System.out.println("INGRESE EL TELEFONO QUE DESEA ACTUALIZAR");
        String codigo = entrada.nextLine();
        System.out.println("INGRESE LOS NUEVOS DATOS");
        System.out.println("INGRESE EL TIPO");
        String tipo = entrada.nextLine();
        System.out.println("INGRESE EL NUMERO");
        String numero = entrada.nextLine();
        System.out.println("INGRESE LA OPERADORA");
        String operadora = entrada.next();
        return new Telefono(codigo, tipo, numero, operadora);
        
    }

    
    public Telefono eliminarTelefono() {
        entrada = new Scanner(System.in);
        System.out.println("INGRESE EL CODIGO DEL TELEFONO A ELIMINAR");
        String codigo = entrada.nextLine();
        return new Telefono(codigo, null, null, null);
    }
    

     public String buscarTelefono() {
        System.out.print("\nIngrese el codigo del Telefono buscado:  ");
        String codigo = entrada.nextLine();
        return codigo;
    }
    

    public void verTelefono(Telefono telefono) {
        System.out.println("DATOS DEL TELEFONO\n " + telefono);
    }
    

    public void verTelefonos(Collection<Telefono> telefonos) {
        for (Telefono telefono : telefonos) {
            System.out.println("DATOS DEL TELEFONO\n " + telefono);
        }
    }
    
}
