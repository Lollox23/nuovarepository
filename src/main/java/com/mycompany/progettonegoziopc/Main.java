/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progettonegoziopc;

import java.util.Scanner;

/**
 *
 * @author almab
 */
public class Main {
    
    
    public static void main(String[] args) {
        
         String[] vociMenu=new String[9];
          int sceltaUtente=0;
          Scanner tastiera=new Scanner(System.in);
          
          
          Pc pc;
          
          int esitoOperazione, ripiano, posizione;
    
            vociMenu[0]="esci";
            vociMenu[1]="aggiungi un pc alla lista";
            vociMenu[2]="elimina un pc dalla lista";
            vociMenu[3]="vendi un pc specifico";
            vociMenu[4]="compra un pc specifico";
            vociMenu[5]="visualizza tutti i pc sotto un determinato numero";
            vociMenu[8]="salva i dati su un file";
    
    
            Menu menu= new Menu(vociMenu);
            
            do
            { 
               sceltaUtente=menu.sceltaMenu();
                switch(sceltaUtente)
                {
                    case 0:
                    {
                        System.out.println("l'applicazione verra terminata");
                        break;
                   }
                     case 1:
                    { 
                        pc=new Pc();
                        System.out.println("Codice-->");
                        pc.setCodice(tastiera.nextLine());
                        System.out.println("Nome-->");
                        pc.setNome(tastiera.nextLine());
                        System.out.println("Quantita pc-->");
                        pc.setQuantita(tastiera.nextInt());
 
                        System.out.println("premi un pulsante per continuare");
                        
                       tastiera.nextLine();
                        break;
                    }
                     case 2:
                    {
                        
                        System.out.println("Codice-->");
                        ripiano=tastiera.nextInt();
                        System.out.println("Nome");
                        posizione=tastiera.nextInt();
                        
                        Pc=s1.getLibro(codice, nome);
                        if (libro==null)
                            System.out.println("nessun libro presente in questa posizione");
                        else
                        {
                            System.out.println(libro.toString()); 
                        }
                       
                         System.out.println("premi un pulsante per continuare");
                          tastiera.nextLine();
                        break;
                    }
                    
                   }
             
          }while(sceltaUtente!=0);
            
       }
    
}
