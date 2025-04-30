/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import model.Eletrodomestico;
import conexao.conexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author aluno.den
 */
public class eletroDAO {
    
    public void inserir (Eletrodomestico eletrodomestico){
        String sql = "INSERIR INTO eledromestico (nome, marca, voltagem, preco) VALUE (?, ?)";
        
        try (Connection conn = conexaoMySQL.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql) ){
            
            stmt.setString (1, eletrodomestico.getNome());
            stmt.setString (2, eletrodomestico.getMarca());
            stmt.setInt (3, eletrodomestico.getVoltagem());
            stmt.setDouble(4, eletrodomestico.getPreco());
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public void remover (int id) {
        String sql = "DELETE FROM eletrodomestico WHERE id = ? ";
        
        try (Connection conn = conexaoMySQL.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt (1, id);
            stmt.executeUpdate();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void atualizar (Eletrodomestico eletrodomestico){
        String sql  = "UPDATE eledomestico SET nome = ?, marca = ?, voltagem = ?, preco = ? WHERE id = ?,";
        
        try (Connection conn = conexaoMySQL.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql) ){
            
            stmt.setString (1, eletrodomestico.getNome());
            stmt.setString (2, eletrodomestico.getMarca());
            stmt.setInt (3, eletrodomestico.getVoltagem());
            stmt.setDouble(4, eletrodomestico.getPreco());
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        
    public ArrayList<Eletrodomestico> listar(){
        ArrayList <Eletrodomestico> lista = new ArrayList<>();
        
        //DIGITANDO O COMANDO DO BANCO
        String sql = "SELECT * FROM eletrodomestico";
        
        //ENVIANDO O COMANDO PARA BANCO 
        try (Connection conn = conexaoMySQL.conectar();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)){
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        //RETORNANDO A LISTA
        return lista;
    }
    
    
    
    
    public ArrayList <Eletrodomestico> buscarPorNome(String nome) {
        ArrayList<Eletrodomestico> lista = new ArrayList<>();
        String sql = "SELECT * FROM eletrodomestico WHERE nome LIKE ?";
        
        try (Connection conn = conexaoMySQL.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Eletrodomestico d = new Eletrodomestico (
                        rs.getInt("id"),
                        rs.getString ("nome"),
                        rs.getString("marca"),
                        rs.getInt("voltagem"),
                        rs.getDouble("preco")
                        
                );
                
                lista.add(d);
            }
            
        } catch (SQLException e){
            e.printStackTrace();
            
        }
        
        return lista;
        
    }
    
    
}
