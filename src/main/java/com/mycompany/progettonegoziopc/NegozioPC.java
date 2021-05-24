/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progettonegoziopc;

import eccezioni.EccezionePosizioneNonValida;
import eccezioni.FileException;
import file.TextFile;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * la mia classe 
 * 
 * @author almab
 */
public class NegozioPC   implements Serializable
{
    private Pc[] elencoComputer;
    private final int N_MAX_PC=100;
     private int nPCPresenti=0;
   
 /**
  * inizializzo l'array
  */
     public NegozioPC ()
      {
          elencoComputer=new Pc[N_MAX_PC];
      }
     
     /**
      * il metodo aggiungiPc controlla se il numero di pc presenti è maggiore dle numero massimo, se è cosi istanzia un nuovo pc
      * @param computer
      * @return 
      */
     
     public int aggiungiPc(Pc computer)
    {
        if (nPCPresenti>N_MAX_PC)
            return -1;      
        elencoComputer[nPCPresenti] = new Pc(computer);
        nPCPresenti++;
        return 0;
    }
     
     /**
      * il metodo getPc restituisce Pc
      * @param posizione
      * @return 
      */
     
     public Pc getPc(int posizione)
     {
         return elencoComputer[posizione];
     }
      
/**
 * il metodo rimuoviPc fa passare tutti i pc presenti e compara il codice di ogni pc con 
 * quello che è stato inserito nel main e quando il codice combacia aggiorna il pc 
 * @param codice 
 */
     public void rimuoviPc(String codice)
    {

            for(int i=0;i<nPCPresenti;i++)
            {
               if(elencoComputer[i].getCodice().compareToIgnoreCase(codice)==0)
               {
                   aggiornaPosizione(i);
               }
            }
    }

     /**
      * il metodo aggiornaPosizione aggiorna la posizione nell' array
      * @param posizione 
      */
     
    private void aggiornaPosizione(int posizione)
    {
        for(int i=posizione;i<nPCPresenti;i++)
        {
            elencoComputer[i]=elencoComputer[i+1];
        }
        nPCPresenti--;
    }
       
       /**
        * il metodo AggiungiUnaCertaQuantitaDiPc gli vienie chiesto di inserire il nome del pc 
        * la quale quantita vuole essere aggiunta, ne aggiornera dopo la quantita
        * @param nome
        * @param quantita
        * @return 
        */
        public int AggiungiUnaCertaQuantitaDiPc(String nome,int quantita)
    {
        for(int i=0;i<nPCPresenti;i++)
        {
            if(elencoComputer[i].getNome().compareToIgnoreCase(nome)==0)
                
            {
                quantita=quantita+elencoComputer[i].getQuantita();
                elencoComputer[i].setQuantita(quantita);
            }
            
            
         }
        
        
           return 0;
    }
        
        /**
         * il metodo DecrementaUnaCertaQuantitaDiPc gli vienie chiesto di inserire il nome del pc 
         * la quale quantita vuole essere decrementata, ne aggiornera dopo la quantita
         * @param nome
         * @param quantita
         * @return 
         */
        
           public int DecrementaUnaCertaQuantitaDiPc(String nome,int quantita)
                  {
                        for(int i=0;i<nPCPresenti;i++)
                       {
                            if(elencoComputer[i].getNome().compareToIgnoreCase(nome)==0)
                
                            {
                                   quantita=elencoComputer[i].getQuantita()-quantita;
                                 elencoComputer[i].setQuantita(quantita);
                           }
            
                            
                          }
        
        
                            return 0;
                        }
           
           /**
            * restituisce nPCPresenti
            * @return 
            */
           public int getNPcPresebti()
                {
                  return nPCPresenti;
                }
           
           
           /**
            * il metodo VisualizzaTuttiPcSottoUnaQuantita fa passare tutti i pc presenti, li controlla e 
            * quando la quantita di un utente e minore della quantita inserita lo visualizza
            * @param quantita
            * @return 
            */
           
    public Pc[] VisualizzaTuttiPcSottoUnaQuantita(int quantita)         
    {
        Pc[] quantitaInferiore= new Pc[getNPcPresebti()];
        Pc computer;
        int c=0;
        
        
        
        for(int i=0;i<nPCPresenti;i++)
        {
            if(elencoComputer[i].getQuantita()<quantita)
                
            {
                computer= elencoComputer[i];
                quantitaInferiore[c]= computer;
                c++;
               
            }
           
            
         }
        return quantitaInferiore;
        
    }
           
    /**
     *  esporta i dati in formato csv
     * @param nomeFile
     * @throws IOException
     * @throws EccezionePosizioneNonValida
     * @throws FileException 
     */
           
           public void salvaComputer(String nomeFile) throws IOException, EccezionePosizioneNonValida, FileException
    {
        TextFile f1=new TextFile(nomeFile,'W');
        Pc computer;
        for(int i=0;i<nPCPresenti;i++)
            {
               computer=getPc(i);
                if(computer!=null)
                {
                    f1.toFile(i+";"+computer.getNome()+";"+computer.getCodice()+";"+computer.getQuantita()+";");
                }
            }
        f1.close(); 
    }
           
           
           /**
            * salva i dati dei pc su un file di tipo binario
            * @param nomeFile
            * @throws IOException
            * @throws EccezionePosizioneNonValida
            * @throws FileException 
            */

    public void salvaComputerBinario(String nomeFile) throws IOException, EccezionePosizioneNonValida, FileException
    {
        FileOutputStream f1=new FileOutputStream(nomeFile);
        ObjectOutputStream writer=new ObjectOutputStream(f1);
        writer.writeObject(this);
        writer.flush();
        writer.close();
    }
    
  
}

