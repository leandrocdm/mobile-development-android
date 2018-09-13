package br.com.fiap.app_persistence_ii;

import java.io.Serializable;

public class Cliente implements Serializable {

    private String nome;
    private int id;

    public Cliente(){super();}

    public Cliente(int id, String nome){
        this.id = id;
        this.nome = nome;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }





}
