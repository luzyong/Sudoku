/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sudoku;

/**
 *
 * @author luanb
 */
public class ValidaIntento {
    int[][] tablero = new int[9][9];
    int[][] juego = new int[9][9];
    int[][] respuesta = new int [9][9];
    boolean solucion;
    
    public ValidaIntento(int[][] tablero){ //Constructor de la clase
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                this.tablero[i][j]=tablero[i][j];
                juego[i][j]=tablero[i][j];
            }
        }
        solucion=resolver(tablero);
    }
    
    public void Reset(){ //Este método regresa el tablero al estado inicial
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                juego[i][j]=tablero[i][j];
            }
        }
    }
    
    public boolean Llena(int i, int j, int valor){ //Este método llena el tablero con los valores ingresados
        if(tablero[i-1][j-1]==0&&this.Comprueba(juego,i-1,j-1,valor)){ //Condiciones: que la casilla esté vacía y cumpla con fila-columna-cuadrante
            juego[i-1][j-1]=valor; 
            return true;
        }
        else return false;
        
    }
    
    public boolean resolver(int[][] tablero){ //Este método resuelve el tablero inicial
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                respuesta[i][j]=tablero[i][j];
            }
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(respuesta[i][j]!=0) continue; //Si no está vacío, lo salta
                else{
                    for(int k=1; k<=9;k++){
                        if(Comprueba(respuesta,i,j,k)){ //Si el valor k cumple con fila-columna-cuadrante, guarda el valor
                            respuesta[i][j]=k;
                            boolean b = resolver(respuesta); //LLama de forma recursiva para llenar todos los campos posibles con el valor k
                            if(b) return true; //Si se llena
                            else respuesta[i][j]=0; //si viola la condición, deja vacío
                        }
                    }
                 return false;
                }
            }
        }
        return true;
    }
    
    public boolean Comprueba(int[][] partida, int i, int j, int value){ //Este método se encarga de hacer cumplir la condición fila-columna-cuadrante del sudoku
        int sqrt=(int)Math.sqrt(partida.length); 
	int fila=i - i % sqrt;
	int columna=j - j % sqrt;
        
        for (int d=0;d<partida.length;d++){ //Comprueba que se llene la fila con 1-9 y no repita
            if(partida[i][d] == value){
		return false;
            }
	}
	for (int r=0;r<partida.length;r++){ //Comprueba que se llene la columna con 1-9 y no repita
            if (partida[r][j] == value){
		return false;
            }
	}	
	for(int r=fila;r<fila+sqrt;r++){ //Comprueba que se llene el cuadrante con 1-9 y no repita
            for (int d = columna;d < columna + sqrt; d++){
                if (partida[r][d] == value){
                    return false;
		}
            }
        }		
        return true;
    }
}
