package org.exampl.Jdbc;

import lombok.RequiredArgsConstructor;
import org.exampl.exeption.DataAccessException;
import org.exampl.videoCards.NvidiaCards;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component

public class NvidiaJdbc {
    public NvidiaJdbc(@Value("{spring.datasource.url") String url) {
        this.url = url;
    }

    private final String url;

    public List<NvidiaCards> getAll() {
        try (
                final Connection conn = DriverManager.getConnection(url);
                // language = PostgreSQL
                final PreparedStatement stmt = conn.prepareStatement("""
                SELECT name, price, videomemory, coolingtype, manufacture, qty FROM cards
                WHERE removed = FALSE
                ORDER BY id
                LIMIT 100
                """);
    final ResultSet rs = stmt.executeQuery();
        ) {
        final List<NvidiaCards> list = new ArrayList<>();
        while (rs.next()){
            list.add(new NvidiaCards(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getLong("price"),
                    rs.getInt("videomemory"),
                    rs.getString("coolingtype"),
                    rs.getString("manufacture"),
                    rs.getInt("qty")));
        }
        return list;
        } catch (SQLException e){
            throw new DataAccessException(e);
        }
    }

    public NvidiaCards add(NvidiaCards item) {
        try (
                final Connection conn = DriverManager.getConnection(url);
                // language = PostgreSQL
                final PreparedStatement stmt = conn.prepareStatement("""
                INSERT INTO cards(id, name, price, videomemory, coolingtype, manufacture, qty)
                VALUES (?,?,?,?,?,?,?)
                RETURNING name, price, videomemory, coolingtype, manufacture, qty
                """);
        ) {
            int index=0;
            stmt.setString(++index, item.getName());
            stmt.setLong(++index, item.getPrice());
            stmt.setInt(++index, item.getVideoMemory());
            stmt.setString(++index, item.getCoolingType());
            stmt.setString(++index, item.getManufacture());
            stmt.setInt(++index, item.getQty());

            try (
                final ResultSet rs = stmt.executeQuery();
            ){
                if(rs.next()){
                    new NvidiaCards(
                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getLong("price"),
                            rs.getInt("videomemory"),
                            rs.getString("coolingtype"),
                            rs.getString("manufacture"),
                            rs.getInt("qty")
                    );
                }
                throw new DataAccessException("Item not add");
            }
        } catch (SQLException e){
            throw new DataAccessException(e);
        }
    }
    public NvidiaCards update(NvidiaCards item) {
        try (
                final Connection conn = DriverManager.getConnection(url);
                // language = PostgreSQL
                final PreparedStatement stmt = conn.prepareStatement("""
                UPDATE cards SET name= ?, price=?, videomemory=?, coolingtype=?, manufacture=?, qty=?
                WHERE id = ? AND removed = FALSE
                RETURNING name, price, videomemory, coolingtype, manufacture, qty
                """);
        ) {
            int index=0;
            stmt.setString(++index, item.getName());
            stmt.setLong(++index, item.getPrice());
            stmt.setInt(++index, item.getVideoMemory());
            stmt.setString(++index, item.getCoolingType());
            stmt.setString(++index, item.getManufacture());
            stmt.setInt(++index, item.getQty());
            stmt.setLong(++index, item.getId());

            try (
                    final ResultSet rs = stmt.executeQuery();
            ){
                if(rs.next()){
                    new NvidiaCards(
                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getLong("price"),
                            rs.getInt("videomemory"),
                            rs.getString("coolingtype"),
                            rs.getString("manufacture"),
                            rs.getInt("qty")
                    );
                }
                throw new DataAccessException("Item not updated");
            }
        } catch (SQLException e){
            throw new DataAccessException(e);
        }
    }

    public void removeById(long id) {
        try (
                final Connection conn = DriverManager.getConnection(url);
                // language = PostgreSQL
                final PreparedStatement stmt = conn.prepareStatement("""
                UPDATE cards SET removed = TRUE
                WHERE id = ?
                """);
        ) {
            int index=0;
            stmt.setLong(++index, id);

            final int affected = stmt.executeUpdate();
            if (affected==0){
                throw new DataAccessException("no item removed");
            }
        } catch (SQLException e){
            throw new DataAccessException(e);
        }
    }
    public void restoreById(long id) {
        try (
                final Connection conn = DriverManager.getConnection(url);
                // language = PostgreSQL
                final PreparedStatement stmt = conn.prepareStatement("""
                UPDATE cards SET removed = FALSE
                WHERE id = ?
                """);
        ) {
            int index=0;
            stmt.setLong(++index, id);

            final int affected = stmt.executeUpdate();
            if (affected==0){
                throw new DataAccessException("no item restore");
            }
        } catch (SQLException e){
            throw new DataAccessException(e);
        }
    }
}

