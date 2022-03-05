import dao.ProdutoDao;
import model.Categoria;
import model.Produto;
import util.JDBCUtil;

import java.sql.SQLException;

public class Principal {

    public static void main(String[] args) throws SQLException {

        Categoria categoria1 = new Categoria();
        categoria1.setId(1L);

        Produto produto1 = new Produto();
        produto1.setModelo ("Galaxy 2032");
        produto1.setMarca("Samsung");
        produto1.setCor("Black Piano");
        produto1.setValor(4500);
        produto1.setAnoFabricado("2032");
        produto1.setCategoria(categoria1);

        ProdutoDao produtoDao = new ProdutoDao();
        //produtoDao.salvarProduto(produto1);

        produtoDao.deletarProduto(produto1);

    }


}
