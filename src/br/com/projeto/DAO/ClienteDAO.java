/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.DAO;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas.silva
 */
public class ClienteDAO {
    private Connection con;

    public ClienteDAO() {
    this.con = new ConnectionFactory().getConnection();
    
    }
                
    public void cadastrarCliente(Cliente obj ){
        try {
        
            String sql = "insert into tb_clientes(nome,rg,cpf,email,"
                    + "telefone,celular,cep,endereco,numero,complemento,"
                    + "bairro,cidade,estado) "
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,obj.getNome());
            stmt.setString(2,obj.getRg());
            stmt.setString(3,obj.getCpf());
            stmt.setString(4,obj.getEmail());
            stmt.setString(5,obj.getTelefone());
            stmt.setString(6,obj.getCelular());
            stmt.setString(7,obj.getCep());
            stmt.setString(8,obj.getEndereco());
            stmt.setInt(9,obj.getNumero());
            stmt.setString(10,obj.getComplemento());
            stmt.setString(11,obj.getBairro());
            stmt.setString(12,obj.getCidade());
            stmt.setString(13,obj.getEstado());
        
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "cadastrado com sucesso");
            
        } catch (SQLException e) {
        JOptionPane.showMessageDialog(null,"erro" + e);
        }
    }
    
   public void alterarCliente(){
       
   }
   
   public void excluirCliente(){
       
   }
    
}
