package examen2p1_fernandopadilla;

import  java.util.*;

public class Libreria {
    static Scanner read = new Scanner(System.in);
    static ArrayList<String> titulos = new ArrayList<>();
    static ArrayList<String> autores = new ArrayList<>();

    public Libreria() {
    }

    
    public void metodoP(){
        int opcion = 0;
        do{
            System.out.println("1.Agregar Libro");
            System.out.println("2.Eliminar Libro");
            System.out.println("3.Listar");
            System.out.println("4.Buscar por titulo");
            System.out.println("5.Regresar al menu");
            opcion = read.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("Ingrese el nombre del libro: ");
                    read.nextLine();
                    String titulo = read.nextLine();
                    System.out.println("Ingrese el nombre del autor: ");
                    
                    String autor = read.nextLine();
                    titulos.add(titulo);
                    autores.add(autor);
                    break;
                    
                case 2:
                    System.out.println("Ingrese el indice del libro a eliminar: ");
                    int index = read.nextInt();
                    titulos.remove(index);
                    autores.remove(index);
                    System.out.println("El libro se ha eliminado correctamente");
                    break;
                    
                case 3:
                    String view = "";
                    for (int i = 0; i < titulos.size(); i++) {
                        view+= "Libro " +(i+1)+"\nTitulo: "+titulos.get(i)+"\nAutor: "+autores.get(i)+"\n";
                    }
                    System.out.println(view);
                    break;
                    
                case 4:
                    String nombreL = "";
                    System.out.println("Ingrese el titulo del libro: ");
                    read.nextLine();
                    nombreL = read.nextLine();
                    boolean confirm = false;
                    for (int i = 0; i < titulos.size(); i++) {
                        if (titulos.get(i).matches(nombreL)) {
                            confirm = true;
                        } else {
                            confirm = false;
                        }
                    }
                    if (confirm) {
                        System.out.println("El libro esta en inventario");
                    } else {
                        System.out.println("Lo sentimos, el libro no esta en inventario");
                    }
                    break;
                    
                case 5:
                    new Menu_Principal().setVisible(true);
                    break;
            }
        }while(opcion!=5);
    }
}
