/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sudoku;

/**
 *
 * @author luanb
 */
public class CompruebaTablero {
    int[][] juego = new int[9][9];
    
    public void Reset(){ //Método que limpia la cuadrícula
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                juego[i][j]=0;
            }
        }
    }
    
    public void Llena(int i, int j, int valor){ //Método que guarda los valores ingresados iniciales
        juego[i-1][j-1]=valor; 
    }
    
    public boolean Minimo(){ //Este método se asegura de cumplir con los valores mínimos de un sudoku bien planteado
        int contador=0;
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(juego[i][j]!=0) contador+=1;
            }
        }
        
        if(contador>=17) return true;
        else return false;
    }
    
    public boolean CompruebaFila(){ //Este método se encarga de comprobar que no exista el valor dos veces en la misma fila
        int contador=0;
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(juego[i][j]!=0&&j>1&&juego[i][j]==juego[i][j-1]){ //Si no está vacío, y el valor de en frente es igual que el anterior, entonces está repetido
                        contador+=1;
               }
            }
        }
        
        if(contador>=1) return false;
        else return true;
        
    }
    
    public boolean CompruebaColumna(){ //Funciona igual que comprueba fila, pero con las columnas
        int contador=0;
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(juego[j][i]!=0&&j>1&&juego[j][i]==juego[j-1][i]){
                        contador+=1;
                }
            }
        }
        
        if(contador>=1) return false;
        else return true;
    }
    
    public boolean CompruebaCuadrante(){ //Comprueba que el número no se encuentre en el mismo cuadrante
        int fila=0, columna=0, maxfila=3,maxcolumna=3, numero=0;
        
        for(int k=0;k<9;k+=3){ //Recorre el tablero por cuadrante
            for(int i=fila;i<maxfila;i++){ //Recorre las filas de cada cuadrante
                for(int j=columna;j<maxcolumna;j++){ //Recorre las columnas de cada cuadrante
                    if(j>columna&&juego[i][j]!=0&&juego[i][j]==numero+1&&juego[i][j]==juego[i][j-1]){
                        return false;
                    }
                }
                numero+=1;
            }
            fila+=3;
            columna+=3;
            maxfila+=3;
            maxcolumna+=3;
        }
        return true;
    }
    
}
