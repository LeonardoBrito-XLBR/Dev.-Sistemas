/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import conexao.conexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pessoa;

/**
 *
 * @author aluno.den
 */
public class PessoaDAO {
    public void inserir (Pessoa pessoa){
        String sql = "INSERIR INTO pessoa (nome, idade) value (?, ?)";
        
        try (Connection conn = conexaoMySQL.conectar();
           PreparedStatement stmt = conn.prepareStatement (sql)){
           stmt.setString(1, pessoa.getNome());
           stmt.setInt (2, pessoa.getIdade());
           stmt.executeUpdate();
       
        }catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
    public ArrayList<Pessoa> listar() {
        ArrayList <Pessoa> lista = new ArrayList<>();
        String sql = "SELECT * FROM pessoa";
        try (Connection conn = conexaoMySQL.conectar();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Pessoa p = new Pessoa (
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("idade")
                );
                
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
        
    }
    
    public ArrayList<Pessoa> buscarPorNome(String nome) {
    ArrayList<Pessoa> lista = new ArrayList<>();
    String sql = "SELECT * FROM pessoa WHERE nome LIKE ?";

    try (Connection conn = conexaoMySQL.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, "%" + nome + "%");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Pessoa p = new Pessoa(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getInt("idade"));
            lista.add(p);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

        return lista;
    
    }
    
    public void atualizar (Pessoa pessoa) {
        String sql = "UPDATE pessoa SET nome = ?, idade = ? WHERE id = ?, ";
        
        try (Connection conn = conexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, pessoa.getNome());
            stmt.setInt(2, pessoa.getIdade());
            stmt.setInt(3, pessoa.getIdade());
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void remover (int id){
        String sql = "DELETE FROM pessoa WHERE id = ?";
        
        try (Connection conn = conexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
         
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
