package P52;

import java.sql.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {
            OpCRUD crud = new OpCRUD();
            Scanner sc = new Scanner(System.in);
            
            boolean console = true;
            while (console) {
                System.out.println("Elija la opción deseada:");
                System.out.println("1. Comprobar conexión.");
                System.out.println("2. Operaciones CRUD para Contactos.");
                System.out.println("3. Operaciones CRUD para Provincias.");
                System.out.println("4. Operaciones CRUD para Categoría.");
                System.out.println("5. Cerrar la aplicación.");
                
                int option = sc.nextInt();
                sc.nextLine();    
                switch (option) {
                    case 1:
                        comprobarConexion();
                        break;
                    case 2:
                        menuContactos(crud, sc);
                        break;
                    case 3:
                        menuProvincias(crud, sc);
                        break;
                    case 4:
                        menuCategorias(crud, sc);
                        break;
                    case 5:
                        System.out.println("Fin del programa.");
                        console = false;
                        break;
                    default:
                        System.out.println("Ha habido un error. Pruebe otra vez.");
                        break;
                }
            }
        } catch (IllegalArgumentException | InputMismatchException | SQLException Ex) {
            System.out.println("Comprueba que se haya ejecutado el programa correctamente.\n");
            // No es recomendable usar recursión aquí, mejor utilizar un bucle.
            // main(args);
        }
    }
    
    private static void comprobarConexion() {
        try {
            Connection connection = DatabaseConnection.getConnection();
            if (connection != null) {
                System.out.println("Conexión establecida con éxito.");
            } else {
                System.out.println("Falló la conexión.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private static void menuContactos(OpCRUD crud, Scanner sc) throws SQLException {
        boolean x = true;
        while (x) {
            System.out.println("\nOperaciones CRUD para Contactos:");
            System.out.println("1. Insertar contacto.");
            System.out.println("2. Leer contactos.");
            System.out.println("3. Actualizar contacto.");
            System.out.println("4. Borrar contacto.");
            System.out.println("5. Volver al menú principal.");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    crud.insertarContacto(new Contactos(0, "", "", "", "", "", "", "", "", 0, "", "", 0));
                    break;
                case 2:
                    crud.leerContactos();
                    break;
                case 3:
                    crud.actualizarContacto(new Contactos(0, "", "", "", "", "", "", "", "", 0, "", "", 0));
                    break;
                case 4:
                    System.out.println("Ingrese el ID del contacto a borrar:");
                    int id = sc.nextInt();
                    sc.nextLine();
                    crud.borrarContacto(id);
                    break;
                case 5:
                    x = false;
                    break;
                default:
                    System.out.println("Ha habido un error. Pruebe otra vez.");
                    break;
            }
        }
    }
    
    private static void menuProvincias(OpCRUD crud, Scanner sc) throws SQLException {
        boolean x = true;
        while (x) {
            System.out.println("\nOperaciones CRUD para Provincias:");
            System.out.println("1. Insertar provincia.");
            System.out.println("2. Leer provincias.");
            System.out.println("3. Actualizar provincia.");
            System.out.println("4. Borrar provincia.");
            System.out.println("5. Volver al menú principal.");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    crud.insertarProvincia(new Provincias(0, ""));
                    break;
                case 2:
                    crud.leerProvincias();
                    break;
                case 3:
                    crud.actualizarProvincia(new Provincias(0, ""));
                    break;
                case 4:
                    System.out.println("Ingrese el ID de la provincia a borrar:");
                    int id = sc.nextInt();
                    sc.nextLine();
                    crud.borrarProvincia(id);
                    break;
                case 5:
                    x = false;
                    break;
                default:
                    System.out.println("Ha habido un error. Pruebe otra vez.");
                    break;
            }
        }
    }
    
    private static void menuCategorias(OpCRUD crud, Scanner sc) throws SQLException {
        boolean x = true;
        while (x) {
            System.out.println("\nOperaciones CRUD para Categorías:");
            System.out.println("1. Insertar categoría.");
            System.out.println("2. Leer categorías.");
            System.out.println("3. Actualizar categoría.");
            System.out.println("4. Borrar categoría.");
            System.out.println("5. Volver al menú principal.");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    crud.insertarCategoria(new Categorias("", ""));
                    break;
                case 2:
                    crud.leerCategorias();
                    break;
                case 3:
                    crud.actualizarCategoria(new Categorias("", ""));
                    break;
                case 4:
                    System.out.println("Ingrese la categoría a borrar:");
                    String categoria = sc.nextLine();
                    crud.borrarCategoria(categoria);
                    break;
                case 5:
                    x = false;
                    break;
                default:
                    System.out.println("Ha habido un error. Pruebe otra vez.");
                    break;
            }
        }
    }
}
