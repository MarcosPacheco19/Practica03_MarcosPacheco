/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.modelo.Telefono;
import java.util.List;
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
        int codigo = entrada.nextInt();
        System.out.println("INGRESE EL TIPO");
        String tipo = entrada.next();
        System.out.println("INGRESE EL NUMERO");
        String numero = entrada.next();
        System.out.println("INGRESE LA OPERADORA");
        String operadora = entrada.next();
        return new Telefono(codigo, tipo, numero, operadora);
        
    }

    public Telefono actualizarTelefono() {
        entrada = new Scanner(System.in);
        System.out.println("INGRESE EL TELEFONO QUE DESEA ACTUALIZAR");
        int codigo = entrada.nextInt();
        System.out.println("INGRESE LOS NUEVOS DATOS");
        System.out.println("INGRESE EL TIPO");
        String tipo = entrada.next();
        System.out.println("INGRESE EL NUMERO");
        String numero = entrada.next();
        System.out.println("INGRESE LA OPERADORA");
        String operadora = entrada.next();
        return new Telefono(codigo, tipo, numero, operadora);
        
    }

    
    public Telefono eliminarTelefono() {
        entrada = new Scanner(System.in);
        System.out.println("INGRESE EL CODIGO DEL TELEFONO A ELIMINAR");
        int codigo = entrada.nextInt();
        return new Telefono(codigo, null, null, null);
    }
    

    public int buscarTelefono() {
        entrada = new Scanner(System.in);
        System.out.println("INGRESA EL CODIGO DEL TELEFONO A BUSCAR");
        int codigo = entrada.nextInt();
        return codigo;
    }
    

    public void verTelefono(Telefono telefono) {
        System.out.println("DATOS DEL TELEFONO\n " + telefono);
    }
    

    public void verTelfonos(List<Telefono> telefonos) {
        for (Telefono telefono : telefonos) {
            System.out.println("DATOS DEL TELEFONO\n " + telefono);
        }
    }
    
}
