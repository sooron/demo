package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Component
public class ComplexTransactions {

    @Autowired
    DataSource dataSource;

    public void updateArticles(List<String> uuids, List<Integer> quantites, List<Integer> prices) throws SQLException {
        Connection con = dataSource.getConnection();
        try {
            con.setAutoCommit(false);

            // do something ...
            PreparedStatement updArticle = con.prepareStatement("UPDATE article SET quantity = ?, price = ? WHERE uuid = ?");
            updArticle.setInt(1, 5);
            updArticle.setInt(2, 5);
            updArticle.setString(3, "e7b2c562-df12-4da7-922e-6abac19d19a1");
            Integer result = updArticle.executeUpdate();
            updArticle.clearParameters();

            con.commit();
            con.close();
        } catch (SQLException e) {
            con.rollback();
            con.close();
        }
    }
}
