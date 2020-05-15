/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.modelo.Usuario;
import java.util.Collection;
import java.util.Scanner;

/**
 *
 * @author xpacheco
 */
public class VistaUsuario {
    
      private Scanner ingreso;

    //Constructor
    public VistaUsuario() {
        ingreso = new Scanner(System.in);
    }

    //Obtiene los datos ingresado por teclado y genera un Usuario con dichos datos 
    public Usuario ingresarUsuario() {
        System.out.println("INGRESAR DATOS DEL USUARIO: \n");
        System.out.print("CEDULA:  ");
        System.out.print("\t");
        String cedula = ingreso.nextLine();
        System.out.print("NOMBRE:  ");
        System.out.print("\t");
        String nombre = ingreso.nextLine();
        System.out.print("APELLIDO:  ");
        System.out.print("\t");
        String apellido = ingreso.nextLine();
        System.out.print("CORREO ELECTRONICO:  ");
        System.out.print("\t");
        String correo = ingreso.nextLine();
        System.out.print("CONTRASEÑA:  ");
        System.out.print("\t");
        String contraseña = ingreso.nextLine();
        return new Usuario(cedula, nombre, apellido, correo, contraseña);
    }

    //Obtiene algunos datos especificos ingresado por teclado y genera un Usuario con dichos datos
    public Usuario iniciarSesion() {
        System.out.print("CORREO ELECTRONICO:");
        System.out.print("\t");
        String correo = ingreso.nextLine();
        System.out.print("\n");
        System.out.print("CONTRASEÑA:");
        System.out.print("\t");
        String contraseña = ingreso.nextLine();
        return new Usuario(null, null, null, correo, contraseña);
    }

    //Obtiene los datos ingresado por teclado y genera un Usuario con dichos datos y con la clave ingresada como parametro
    public Usuario actualizarUsuario(String cedula) {
        System.out.println("\nINGRESE LOS NUEVOS DATOS\n");
        System.out.print("NOMBRE:");
        System.out.print("\t");
        String nombre = ingreso.nextLine();
        System.out.print("APELLIDO:");
        System.out.print("\t");
        String apellido = ingreso.nextLine();
        System.out.print("CORREO ELECTRONICO:");
        System.out.print("\t");
        String correo = ingreso.nextLine();
        System.out.print("CONTRASEÑA:");
        System.out.print("\t");
        String contraseña = ingreso.nextLine();
        return new Usuario(cedula, nombre, apellido, correo, contraseña);
    }

    //Genera un Usuario con la clave ingresada como parametro
    public Usuario eliminarUsuario(String cedula) {
        return new Usuario(cedula, null, null, null, null);
    }

    //Muestra en pantalla un Usuario ingresado como parametro
    public void verUsuario(Usuario usuario) {
        System.out.println("DATOS DEL USUARIO: " + usuario);
    }

    //Muestra en pantalla una coleccion de Usuarios ingresada como parametro
    public void verUsuarios(Collection<Usuario> usuarios) {
        int aux = 0;
        System.out.println("");
        for (Usuario usuario : usuarios){
            System.out.println("USURIO NUMERO" + ++aux + ":");
            System.out.println("DATOS DEL USUARIO: " + usuario);
            System.out.println("------------------------------------------------------");
        }
    }
    
}
