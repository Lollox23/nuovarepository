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

/**
 *
 * @author almab
 */
public class NegozioPC  
{
    private Pc[] elencoComputer;
    private final int N_MAX_PC=100;
     private int nPCPresenti=0;
   
    
     public NegozioPC ()
      {
          elencoComputer=new Pc[N_MAX_PC];
      }
     
     
     public int aggiungiPc(Pc computer)
    {
        if (nPCPresenti>N_MAX_PC)
            return -1;      
        elencoComputer[nPCPresenti] = new Pc(computer);
        nPCPresenti++;
        return 0;
    }
     
     public Pc getPc(int posizione)
     {
         return elencoComputer[posizione];
     }
      
      
      /*
       public int rimuoviPc(int posizione)
    {
        
        try
        {
            if(elencoComputer[posizione]==null)
               return -2;           
            elencoComputer[posizione]=null;
            return posizione;
        }
        catch(ArrayIndexOutOfBoundsException posizioneNonValida)
        {
            return -1;
        }
        
           
    }
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

     
    private void aggiornaPosizione(int posizione)
    {
        for(int i=posizione;i<nPCPresenti;i++)
        {
            elencoComputer[i]=elencoComputer[i+1];
        }
        nPCPresenti--;
    }
       
       
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
        
        
           public int DecrementaUnaCertaQuantitaDiPc(String nome,int quantita)
                  {
                        for(int i=0;i<nPCPresenti;i++)
                       {
                            if(elencoComputer[i].getNome().compareToIgnoreCase(nome)==0)
                
                            {
                                   quantita=quantita-elencoComputer[i].getQuantita();
                                 elencoComputer[i].setQuantita(quantita);
                           }
            
                            
                          }
        
        
                            return 0;
                        }
           
           
           public int getNPcPresebti()
                {
                  return nPCPresenti;
                }
           
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

    public void salvaComputerBinario(String nomeFile) throws IOException, EccezionePosizioneNonValida, FileException
    {
        FileOutputStream f1=new FileOutputStream(nomeFile);
        ObjectOutputStream writer=new ObjectOutputStream(f1);
        writer.writeObject(this);
        writer.flush();
        writer.close();
    }
           
           
    
   
           
           
           
 
       
       
       public String toString()
    {
        Pc t;
        String s="";
        for(int i=0;i<N_MAX_PC;i++)
        {
            if(elencoComputer[i]!=null)
            {
                t=elencoComputer[i];
                s=s+"Posizione:  "+i+t.toString()+"\n";
            }   
        }
        return s;
    }
      
  
     
}

