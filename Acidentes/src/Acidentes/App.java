/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Acidentes;

/**
 *
 * @author 12280437
 */
public class App {
    
    public static void main(String[] args) {
        
        CadastroAcidentes cads = CadastroAcidentes.getInstance();

        if(cads.readFile("acidente.csv"))
            System.out.println(cads.toString());
        
        else
            System.out.println("Erro de LEITURA JUMENTO");
        
        
    }
    
}
