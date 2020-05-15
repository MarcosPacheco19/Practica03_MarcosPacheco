/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.test;

import ec.edu.ups.controlador.ControladorTelefono;
import ec.edu.ups.controlador.ControladorUsuario;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.vista.VistaTelefono;
import ec.edu.ups.vista.VistaUsuario;
import java.util.Scanner;

/**
 *
 * @author xpacheco
 */
public class Principal {
    
    private static final Scanner opc = new Scanner(System.in);
    //DAO
    private static final TelefonoDAO telefonoDAO = new TelefonoDAO();
    private static final UsuarioDAO usarioDAO = new UsuarioDAO();
    //Vista
    private static final VistaUsuario vistaUsuario = new VistaUsuario();
    private static final VistaTelefono vistaTelefono = new VistaTelefono();
    //Controlador
    private static final ControladorTelefono controladorTelefono = new ControladorTelefono(vistaTelefono, telefonoDAO);
    private static final ControladorUsuario controladorUsuario = new ControladorUsuario(vistaTelefono, vistaUsuario, usarioDAO, telefonoDAO);

    //Metodo main
    public static void main(String[] args) {

        //Dato en el que se guardara la opcion que escoja el usuario 
        int opcion = 0;
        //Menu Principal
        while (opcion != 5) {

            
            System.out.println("              AGENDA TELEFONICA");  
            System.out.println("[1] REGISTRARSE");
            System.out.println("[2] INICIAR SESION");
            System.out.println("[3] MOSRAR USUARIOS REGISTRADOS");
            System.out.println("[4] MOSTRAR TELEFONOS REGISTRADOS");
            System.out.println("[5] SALIR");
            System.out.print("SELECCIONE LA OPCION: ");
            opcion = opc.nextInt();

            switch (opcion) {

                case 1:
                    controladorUsuario.registrar();
                    System.out.println("\n         SE HA REGISTRADO   ");
                    break;
                case 2:
                    System.out.println("                   INICIO DE SESION");
                    
                    String cedula = incioDeSesion();
                    if (cedula == null) {
                        break;
                    }

                    //Dato en en donde se guardar la opcion que escoja el usuario al ingresar al programa
                    int opcion2 = 0;
                    //Menu secundario o submenu
                    while (opcion2 != 9) {

                        System.out.println("\n[1] AÑADIR TELEFONO");
                        System.out.println("[2] EDITAR TELEFONO");
                        System.out.println("[3] ELIMINAR TELEFONO");
                        System.out.println("[4] BUSCAR TELEFONO");
                        System.out.println("[5] LISTAR TELEFONOS");
                        System.out.println("[6] MOSTRAR DATOS");
                        System.out.println("[7] EDITAR USUARIO");
                        System.out.println("[8] ELIMINAR USUARIO");
                        System.out.println("[9] VOLVER AL MENU PRINCIPAL");
                        System.out.print("\nSELECCIONA LA OPCION: \t ");
                        opcion2 = opc.nextInt();

                        switch (opcion2) {

                            case 1:
                                controladorUsuario.agregarTelefono(cedula, controladorTelefono.crear());
                                System.out.println("\nTELEFONO AÑADIDO");
                                break;
                            case 2:
                                controladorUsuario.editarTelefono(cedula);
                                break;
                            case 3:
                                controladorUsuario.eliminarTelefono(cedula);
                                break;
                            case 4:
                                controladorUsuario.buscarTelefono(cedula);
                                break;
                            case 5:
                                controladorUsuario.listarTelefonos(cedula);
                                break;
                            case 6:
                                controladorUsuario.verUsuario(cedula);
                                break;
                            case 7:
                                controladorUsuario.actualizar(cedula);
                                System.out.println("\n      DATOS ACTUALIZADOS ");
                                break;
                            case 8:
                                controladorUsuario.eliminar(cedula);
                                System.out.println("\n          USUARIO ELIMINADO  ");
                                opcion2 = 6;
                                break;
                            case 9:
                                break;

                        }

                    }
                    break;
                case 3:
                    System.out.println("                 USUARIOS REGISTRADOS");
                    controladorUsuario.verUsuarios();
                    break;
                case 4:
                    System.out.println("                TELEFONOS REGISTRADOS");
                    controladorTelefono.verTelefonos();
                    break;
                case 5:
                    System.out.println("                EL PROGRAMA A FINALIZADO");
                    System.out.println("\n");
                    break;

            }

        }

    }

    //Llama al metodo Autentificar para Generar un Usuario y si este es diferente de null obtener el nombre y la cedula de dicho usuario
    public static String incioDeSesion() {
        Usuario usuarioAutentificado = controladorUsuario.Autentificar();
        if (usuarioAutentificado == null) {
            System.out.println("\n    CORREO ELECTRONICO O CONTRASEÑA INCORRECTOS ");
            return null;
        } else {
            System.out.println("\n      BIENVENIDO " + usuarioAutentificado.getNombre() + " ");
            return usuarioAutentificado.getCedula();
        }
    }

    
}
