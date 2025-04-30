/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import dao.eletroDAO;
import java.util.ArrayList;
import model.Eletrodomestico;

/**
 *
 * @author aluno.den
 */

// AQUI CHAMAMOS A FUNCOES DO DAO
public class EletroController {
    private eletroDAO dao = new eletroDAO();
    
    
    public void cadastrar (String nome, String marca, int voltagem, double preco) {
        Eletrodomestico d = new Eletrodomestico (nome, marca, voltagem, preco);
        dao.inserir(d); // FUNCAO PARA CADASTRAR
    }
    
    public ArrayList <Eletrodomestico> listar(){
        return dao.listar(); // FUNCAO PARA EXIBIR A LISTA
        
    }
    
    public void atualizar (int id, String nome, String marca, int voltagem, double preco ){
        Eletrodomestico d = new Eletrodomestico(nome, marca, voltagem, preco);
        dao.atualizar(d); // FUNCAO PARA ATUALIZAR O A LISTA
    }
    
    public void remover (int id) {
        dao.remover(id); // FUNCAO PARA REMOVER 
    }
    
    public ArrayList <Eletrodomestico> buscarPorNome (String nome) {
        return dao.buscarPorNome(nome); // FUNCAO PARA BUSCAR POR NOME 
    }
    
}
