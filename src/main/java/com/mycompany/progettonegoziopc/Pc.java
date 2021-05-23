/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progettonegoziopc;

/**
 *
 * @author almab
 */
public class Pc {
    
    //atributi
    private String codice ;
    private String nome ;
    private int quantita ; 
    
     public Pc(String codice, String nome, int quantita)
    {
        this.codice=codice;
        this.nome=nome;
        this.quantita=quantita;
    }
     
    public Pc(Pc l)
    {
        codice=l.getCodice();
        nome=l.getNome();
        quantita=l.getQuantita();
    }
     
    public Pc()
    {
        codice="";
        nome="";
        quantita=0;
    }

    public String getCodice()
    {
        return codice;
    }
    
    
     public void setCodice(String codice)
    {
         this.codice=codice;
    }


    public String getNome( )
    {
        return nome;
    }

    public void setNome( String nome)
    {
       this.nome=nome;
    }
    
    public int getQuantita()
    {
     return quantita;
    }


public void setQuantita(int quantita)
    {
     this.quantita=quantita;

    }


 public String toString()
    {
        String s;
        s="codice: "+getCodice()+", nome: "+getNome()+", quantita: "+getQuantita();
        return s;
    }
 
}