/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progettonegoziopc;

import java.io.Serializable;

/**
 *
 * @author almab
 */
public class Pc implements Serializable
{
    
    //atributi
    private String codice ;
    private String nome ;
    private int quantita ; 
    
    /**
     * assegna il valore alle variabili di codice, nome e quantita
     * @param codice
     * @param nome
     * @param quantita 
     */
    
     public Pc(String codice, String nome, int quantita)
    {
        this.codice=codice;
        this.nome=nome;
        this.quantita=quantita;
    }
     
     /**
      * è il costruttore di copia 
      * @param l 
      */
    public Pc(Pc l)
    {
        codice=l.getCodice();
        nome=l.getNome();
        quantita=l.getQuantita();
    }
     /**
      * questo è il costruttore di default
      */
    public Pc()
    {
        codice="";
        nome="";
        quantita=0;
    }
    /**
     * il metodo getCodice ti mostra quale è il codice
     * @return 
     */

    public String getCodice()
    {
        return codice;
    }
    /**
     * il metodo setCodice imposta il codice
     * @param codice 
     */
    
    
     public void setCodice(String codice)
    {
         this.codice=codice;
    }
     /**
      * il metodo getNome ti mostra quale è il nome
      * @return 
      */


    public String getNome( )
    {
        return nome;
    }
    /**
     * il metodo setNome imposta il nome
     * @param nome 
     */

    public void setNome( String nome)
    {
       this.nome=nome;
    }
    /**
     * il metodo getQuantita ti mostra quanto è la quantita
     * @return 
     */
    
    public int getQuantita()
    {
     return quantita;
    }
    
    /**
     * il metodo setQuantita imposta la quantita
     * @param quantita 
     */


public void setQuantita(int quantita)
    {
     this.quantita=quantita;

    }
/**
 * il metodo toString mostra gli attributi della classe
 * @return 
 */


 public String toString()
    {
        String s;
        s="codice: "+getCodice()+", nome: "+getNome()+", quantita: "+getQuantita();
        return s;
    }
 
}