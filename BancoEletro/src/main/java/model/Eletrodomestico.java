/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author aluno.den
 */
public class Eletrodomestico {
    private String nome; 
    private String marca; 
    private int voltagem;
    private double preco;

    public Eletrodomestico(String nome, String marca, int voltagem, double preco) {
        this.nome = nome;
        this.marca = marca;
        this.voltagem = voltagem;
        this.preco = preco;
    }
    
    public Eletrodomestico(int id, String nome, String marca, int voltagem, double preco) {
        
    }

    public String getMarca() {
        return marca;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getVoltagem() {
        return voltagem;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setVoltagem(int voltagem) {
        this.voltagem = voltagem;
    }
    
}
