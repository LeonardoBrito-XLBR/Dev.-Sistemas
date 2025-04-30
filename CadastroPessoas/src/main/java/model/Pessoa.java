/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author aluno.den
 */
public class Pessoa {
    private String nome;
    private int idade;
    
    public Pessoa (String nome, int idade){
        this.idade = idade;
        this.nome = nome;
    }
    
    public Pessoa (int id, String nome, int idade){
        
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
}
