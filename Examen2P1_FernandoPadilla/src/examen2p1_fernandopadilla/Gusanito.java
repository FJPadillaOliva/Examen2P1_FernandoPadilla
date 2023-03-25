package examen2p1_fernandopadilla;

import java.util.*;

public class Gusanito {
    private ArrayList<String> instrucciones;
    private char[][] matriz;
    private int gusX, gusY, manX, manY;
    static Random random = new Random();
    static Scanner read = new Scanner(System.in);
    
    public Gusanito(int filas,int columnas) {
        this.matriz = new char[filas][columnas];
        this.gusX = random.nextInt(filas);
        this.gusY = random.nextInt(columnas);
        this.manX = random.nextInt(filas);
        this.manY = random.nextInt(columnas);
        this.instrucciones = new ArrayList<String>();
    }
 
    public void llenarM(){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = ' ';
            }
        }
    }
    public void imprimirM(){
        String matrizi = "";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matrizi +="["+ matriz[i][j]+"] ";
            }
            matrizi += "\n";
        }
        System.out.println(matrizi);
    }
    
    public void mover(){
        llenarM();
        char opc = 's';
        String inst;
        System.out.println("Valores aleatorios: gusX = " + gusX+ ", gusY = " + gusY+ ", manX = "+ manX+", manY = "+ manY);
        matriz[gusX][gusY] = '§';
        matriz[manX][manY] = 'Ó';
        int move = 0;
        imprimirM();
        do{
            System.out.println("Ingrese una opcion");
            inst = read.next();
            instrucciones.add(inst);
            System.out.println("Desea ingresar otra instruccion? [s/n]: ");
            opc = read.next().charAt(0);
        }while(opc != 'n');
        for (int i = 0; i < instrucciones.size(); i++) {
            String temp = instrucciones.get(i);
            move = Integer.parseInt(temp.substring(0, 1));
            System.out.println("Ejecutando instruccion: " + temp);
                if(temp.contains("UP")&& gusX - move >= matriz.length){
                    matriz[gusX][gusY] = ' ';
                    gusX = gusX - move;
                    matriz[gusX][gusY] = '§';
                    imprimirM();
                }else if(temp.contains("DN")&& gusX + move <= matriz.length){
                    matriz[gusX][gusY] = ' ';
                    gusX = gusX + move;
                    matriz[gusX][gusY] = '§';
                    imprimirM();
                }else if(temp.contains("RT")&& gusY + move <= matriz[i].length){
                    matriz[gusX][gusY] = ' ';
                    gusY = gusY + move;
                    matriz[gusX][gusY] = '§';
                    imprimirM();
                }else if(temp.contains("LT")&& gusY - move >= matriz[i].length ){
                    matriz[gusX][gusY] = ' ';
                    gusY = gusY - move;
                    matriz[gusX][gusY] = '§';
                    imprimirM();
                }else{
                    System.out.println("No se pudo realizar el movimiento");
                }
        }
        if(matriz[manX][manY] == '§'){
                    System.out.println("Lograste llegar a la manzana!");
                }else{
                    System.out.println("No has logrado llegar :(");
                }
    }
    
}
