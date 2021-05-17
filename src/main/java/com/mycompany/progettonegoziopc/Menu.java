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
public class Menu {
    
    
    private String[] elencoVoci;
    private int numeroVoci;
    
    
    public Menu( String[] elencoVoci)
    {
         numeroVoci=elencoVoci.length;
         this.elencoVoci=new String[numeroVoci];
         
         for(int i=0;i<numeroVoci;i++)
             this.elencoVoci[i]=elencoVoci[i];
               
    }
    
    public void visualizzaMenu()
    {
        
        System.out.println("MENU:");
        for(int i=0; i<numeroVoci;i++)
        {
            System.out.println(i+"-->"+elencoVoci[i]);
        }
        
        
    }
    
    public int sceltaMenu()
    {
        Scanner tastiera= new Scanner(System.in);
        String inputUtente;
        int sceltaUtente=0;
        boolean inputUtenteOK=true;
        
        
        
        do
        {
              visualizzaMenu();
        System.out.println("scelta-->");
        
        inputUtente=tastiera.nextLine();
        


//verifico che l'imput sia numerico

        inputUtenteOK=true;
        for ( int i=0; i<inputUtente.length();i++)
        {
            if(inputUtente.charAt(i)>='0' && inputUtente.charAt(i)<='9' )
                i++;
            else 
            {
                   inputUtenteOK=false;
                     break;
            }
             
        }
        
        
        if(inputUtenteOK)
        {
            sceltaUtente=Integer.parseInt(inputUtente);
            if(sceltaUtente<0 || sceltaUtente>numeroVoci-1)
                inputUtenteOK=false;
        }
        
        if(!inputUtenteOK)
        {
            System.out.println("il valore iunserito non è corretto, premi invio e inserisci nuovamente la tua scelta");
            
            tastiera.nextLine();
        }
        
        
       }while(!inputUtenteOK);
        
        
        return sceltaUtente;
        
    }
}