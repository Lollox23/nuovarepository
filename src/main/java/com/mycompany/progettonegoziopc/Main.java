/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progettonegoziopc;

import eccezioni.EccezionePosizioneNonValida;
import eccezioni.FileException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author almab
 */
public class Main implements Serializable {
    
    
    public static void main(String[] args) throws IOException {
        
         NegozioPC n =new NegozioPC();
         String codicePC;
         String nomePC;
         int quantitaPC;
         String nomeFile=" computer.txt";
          String nomeFileBinario=" pc.bin";
         
 
        
         String[] vociMenu=new String[8];
          int sceltaUtente=0;
          Scanner tastiera=new Scanner(System.in);
          
          
          Pc pc;
          
          int esitoOperazione, ripiano, posizione;
    
            vociMenu[0]="esci";
            vociMenu[1]="aggiungi un pc alla lista";
            vociMenu[2]="elimina un pc dalla lista";
            vociMenu[3]="vendi un pc specifico";
            vociMenu[4]="compra un pc specifico";
            vociMenu[5]="visualizza tutti i pc sotto una determinata quantita";
            vociMenu[6]="salva i dati su un file";
            vociMenu[7]="salva i dati su un file binario";
             
             try 
        {
            FileInputStream f1=new FileInputStream(nomeFileBinario);
            ObjectInputStream reader=new ObjectInputStream(f1);

            try
            {
                n=(NegozioPC)reader.readObject();
                reader.close();
                System.out.println("\nLettura avvenuta correttamente");
            }
            catch(ClassNotFoundException ex)
            {
                reader.close();
                System.out.println("Errore di lettura");
            }
        }
        catch(IOException ex)
        {
            System.out.println("\nImpossibile accedere al file"); 
        }
             
    
    
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
                        n.aggiungiPc(pc);
                        
                        System.out.println("premi un pulsante per continuare");
                        tastiera.nextLine();
                        
                       
                        break;
                    }
                     case 2:
                    {
                        
                        System.out.println("inserisci il codice del pc che vuoi eliminare");
                        System.out.println("Codice-->");
                        codicePC=tastiera.nextLine();
                        n.rimuoviPc(codicePC);
                        System.out.println("pc eliminato correttamente");
                        
                        System.out.println("premi un pulsante per continuare");
                        tastiera.nextLine();
                        break;
                    }
                    case 3:
                    {
                        
                        System.out.println("inserisci il nome del pc che vuoi vendere");
                        System.out.println("Nome-->");
                        nomePC=tastiera.nextLine();
                        System.out.println("inserisci la quantita di pc che vuoi vendere");
                        quantitaPC=tastiera.nextInt();
                        n.DecrementaUnaCertaQuantitaDiPc(nomePC,quantitaPC);
                        
                        
                        System.out.println("premi un pulsante per continuare");
                        tastiera.nextLine();
                        break;
                    }
                    case 4:
                    {
                        
                         System.out.println("inserisci il nome del pc che vuoi aggiungere");
                        System.out.println("Nome-->");
                        nomePC=tastiera.nextLine();
                        System.out.println("inserisci la quantita di pc che vuoi aggiungere");
                        quantitaPC=tastiera.nextInt();
                        n.AggiungiUnaCertaQuantitaDiPc(nomePC,quantitaPC);
                        
                        
                        
                        System.out.println("premi un pulsante per continuare");
                        tastiera.nextLine();
                        break;
                    }
                    
                        case 5:
                    {
                        
                         System.out.println("inseriscila quantita dei pc sotto la quale li vuoi visualizzare");
                        System.out.println("quantita-->");
                         quantitaPC=tastiera.nextInt();
                         
                          Pc[] computer;
                          
                         
                          computer=n.VisualizzaTuttiPcSottoUnaQuantita(quantitaPC);
                         
                        System.out.println("ecco i pc in base alla quantita");
                        
                         for(int i=0; i<computer.length; i++)
                         {
                             
                             System.out.println("nome-->"+computer[i].getNome());
                             System.out.println("Codice-->"+computer[i].getCodice());
                             System.out.println("quantita-->"+computer[i].getQuantita());
                             
                         }
                   
                        System.out.println("premi un pulsante per continuare");
                        tastiera.nextLine();
                        break;
                    }

                    case 6:
                    {
                        try
                        {
                            n.salvaComputer(nomeFile);
                            System.out.println("salvataggioa vvenuto in modo coretto");
                            
                        }
                        catch(IOException e1)
                        {
                            System.out.println("impossibile accedere al file, i pc non sono stati slavato ");
                        }
                        catch(EccezionePosizioneNonValida | FileException e2)
                                {
                                    System.out.println(e2.toString());
                                }                 
                        
                        break;
                    }
                    
                    
                    case 7:
                    {
                        try
                        {
                            n.salvaComputerBinario(nomeFileBinario);
                            System.out.println("salvataggioa vvenuto in modo coretto");
                            
                        }
                        catch(IOException e1)
                        {
                            System.out.println("impossibile accedere al file, i pc non sono stati slavato ");
                        }
                        catch(EccezionePosizioneNonValida | FileException e2)
                                {
                                    System.out.println(e2.toString());
                                }                 
                        
                        break;
                    }
               
                    
                   }
             
          }while(sceltaUtente!=0);
            
       }
    
}
