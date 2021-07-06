package ufrn.tads.eaj.filipe.nbaloja.DAO;

import ufrn.tads.eaj.filipe.nbaloja.controllers.ConectaBanco;
import ufrn.tads.eaj.filipe.nbaloja.model.Produto;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public List<Produto> listarProdutos() {

        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;


        List<Produto> listaDeProdutos = new ArrayList<>();

        try {
            connection = ConectaBanco.getConnection();

            stmt = connection.prepareStatement("select * from produto");

            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();

                p.setIdProduto(rs.getInt("id"));
                p.setNomeProduto(rs.getString("nomeproduto"));
                p.setTimeJogador(rs.getString("timejogador"));
                p.setPreco(rs.getFloat("preco"));
                p.setTamanho(rs.getString("tamanho"));
                p.setIndicadoPara(rs.getString("indicadopara"));

                listaDeProdutos.add(p);

            }
            connection.close();

        } catch (SQLException | URISyntaxException ex) {
            //response.getWriter().append("Connection Failed! Check output console");
        }

        return listaDeProdutos;
    }

    public void cadastrarProduto(Produto p) {
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = ConectaBanco.getConnection();

            stmt = connection.prepareStatement("insert into produto (nomeproduto, timejogador, preco, tamanho, indicadopara) values (?,?,?,?,?)");

            stmt.setString(1, p.getNomeProduto());
            stmt.setString(2, p.getTimeJogador());
            stmt.setFloat(3, p.getPreco());
            stmt.setString(4, p.getTamanho());
            stmt.setString(5, p.getIndicadoPara());

            stmt.executeUpdate();

            connection.close();


        } catch (SQLException | URISyntaxException ex) {
            //response.getWriter().append("Connection Failed! Check output console");
        }


    }

    public List<Produto> listarProdutosPorId(int id) {

        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;


        List<Produto> listaDeProdutos = new ArrayList<>();

        try {
            connection = ConectaBanco.getConnection();

            stmt = connection.prepareStatement("select * from produto where id=?");

            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                Produto p = new Produto();

                p.setIdProduto(rs.getInt("id"));
                p.setNomeProduto(rs.getString("nomeproduto"));
                p.setTimeJogador(rs.getString("timejogador"));
                p.setPreco(rs.getFloat("preco"));
                p.setTamanho(rs.getString("tamanho"));
                p.setIndicadoPara(rs.getString("indicadopara"));

                listaDeProdutos.add(p);


            }

            connection.close();

        } catch (SQLException | URISyntaxException ex) {
            //response.getWriter().append("Connection Failed! Check output console");
        }

        return listaDeProdutos;
    }
}

