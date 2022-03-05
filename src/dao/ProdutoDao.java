package dao;

import model.Produto;
import util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDao {

    public void salvarProduto(Produto produto) throws SQLException{

        String sql = "INSERT INTO produto (marca, modelo, cor, ano_fabrica, valor, id_categoria) VALUES (?,?,?,?,?,?)";

        try {
            Connection conexao = JDBCUtil.criarConexao();
            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setString(1, produto.getMarca());
            ps.setString(2, produto.getModelo());
            ps.setString(3, produto.getCor());
            ps.setString(4, produto.getAnoFabricado());
            ps.setDouble(5, produto.getValor());
            ps.setLong(6, produto.getCategoria().getId());
            System.out.println("Salvo com sucesso!");

            ps.execute();

            ps.close();
            conexao.close();

        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("O método INSERT não pode ser executado");

        }
    }

    public void deletarProduto(Produto produto) throws SQLException{

        String sql = "DELETE FROM produto WHERE id=?";

        try {
            Connection conexao = JDBCUtil.criarConexao();
            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setLong (1, produto.getId());
            System.out.println("Deletado com sucesso!");

            ps.execute();

            ps.close();
            conexao.close();

        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("O método INSERT não pode ser executado");

        }

    }

}
