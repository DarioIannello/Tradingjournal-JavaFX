/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.tradingjournal.Entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author Dario
 */
public class Database {

    private Connection con;
    private PreparedStatement ps;
    private final String connection = "jdbc:mysql://localhost:3306/tradingjournal?zeroDateTimeBehavior=convertToNull";
    private final String root = "root";
    private final String pw = "";
    private String sqlGetIDs;

    public void insert(String pair, String bs, String date, String time, String wbel, String strat, String profit, String reasonsF, String reasonsA, String others, String learn) {
        String bsId = "1";
        String wbelId = "1";
        String stratId = "1";
        ResultSet rs;

        try {
            con = DriverManager.getConnection(connection, root, pw);
            sqlGetIDs = "SELECT * FROM buysell WHERE tradeKind=?";
            ps = con.prepareStatement(sqlGetIDs);
            ps.setString(1, bs);
            rs = ps.executeQuery();
            if (rs.next()) {
                bsId = rs.getString("id_BuySell");
            }

            sqlGetIDs = "SELECT * FROM wbel WHERE finish=?";
            ps = con.prepareStatement(sqlGetIDs);
            ps.setString(1, wbel);
            rs = ps.executeQuery();
            if (rs.next()) {
                wbelId = rs.getString("id_WBEL");
            }

            sqlGetIDs = "SELECT * FROM strategy WHERE strategy=?";
            ps = con.prepareStatement(sqlGetIDs);
            ps.setString(1, strat);
            rs = ps.executeQuery();
            if (rs.next()) {
                stratId = rs.getString("id_Strategy");
            }

            String sqlInsert = "INSERT INTO trade(pair, id_BuySell, dateOfTrade, timeOfTrade, id_WBEL, id_Strategy, profit, reasonF, reasonA, other, learn) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sqlInsert);
            ps.setString(1, pair);
            ps.setString(2, bsId);
            ps.setString(3, date);
            ps.setString(4, time);
            ps.setString(5, wbelId);
            ps.setString(6, stratId);
            ps.setString(7, profit);
            ps.setString(8, reasonsF);
            ps.setString(9, reasonsA);
            ps.setString(10, others);
            ps.setString(11, learn);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "There was an Error. Please Try again!", "Something went wrong!", JOptionPane.ERROR_MESSAGE);
        } finally {
            closeConnection();
        }
    }

    public void update(String oldPair, String oldBs, String oldDate, String oldTime, String oldWbel, String oldStrat, String oldProfit, String oldReasonsF, String oldReasonsA, String oldOthers, String oldLearn, String pair, String bs, String date, String time, String wbel, String strat, String profit, String reasonsF, String reasonsA, String others, String learn) {
        int tradeId;
        String oldBsId = "1";
        String oldWbelId = "1";
        String oldStratId = "1";
        String bsId = "1";
        String wbelId = "1";
        String stratId = "1";
        ResultSet rs;

        try {
            con = DriverManager.getConnection(connection, root, pw);
            sqlGetIDs = "SELECT * FROM buysell WHERE tradeKind=?";
            ps = con.prepareStatement(sqlGetIDs);
            ps.setString(1, oldBs);
            rs = ps.executeQuery();
            if (rs.next()) {
                oldBsId = rs.getString("id_BuySell");
            }
            sqlGetIDs = "SELECT * FROM wbel WHERE finish=?";
            ps = con.prepareStatement(sqlGetIDs);
            ps.setString(1, oldWbel);
            rs = ps.executeQuery();
            if (rs.next()) {
                oldWbelId = rs.getString("id_WBEL");
            }

            sqlGetIDs = "SELECT * FROM strategy WHERE strategy=?";
            ps = con.prepareStatement(sqlGetIDs);
            ps.setString(1, oldStrat);
            rs = ps.executeQuery();
            if (rs.next()) {
                oldStratId = rs.getString("id_Strategy");
            }

            sqlGetIDs = "SELECT * FROM buysell WHERE tradeKind=?";
            ps = con.prepareStatement(sqlGetIDs);
            ps.setString(1, bs);
            rs = ps.executeQuery();
            if (rs.next()) {
                bsId = rs.getString("id_BuySell");
            }

            sqlGetIDs = "SELECT * FROM wbel WHERE finish=?";
            ps = con.prepareStatement(sqlGetIDs);
            ps.setString(1, wbel);
            rs = ps.executeQuery();
            if (rs.next()) {
                wbelId = rs.getString("id_WBEL");
            }

            sqlGetIDs = "SELECT * FROM strategy WHERE strategy=?";
            ps = con.prepareStatement(sqlGetIDs);
            ps.setString(1, strat);
            rs = ps.executeQuery();
            if (rs.next()) {
                stratId = rs.getString("id_Strategy");
            }

            sqlGetIDs = "SELECT * FROM trade WHERE pair=? AND id_BuySell=? AND dateOfTrade=? AND timeOfTrade=? AND id_WBEL=? AND id_Strategy=? AND profit=? AND reasonF=? AND reasonA=? AND other=? AND learn=?";
            ps = con.prepareStatement(sqlGetIDs);
            ps.setString(1, oldPair);
            ps.setString(2, oldBsId);
            ps.setString(3, oldDate);
            ps.setString(4, oldTime);
            ps.setString(5, oldWbelId);
            ps.setString(6, oldStratId);
            ps.setString(7, oldProfit);
            ps.setString(8, oldReasonsF);
            ps.setString(9, oldReasonsA);
            ps.setString(10, oldOthers);
            ps.setString(11, oldLearn);
            ResultSet all = ps.executeQuery();
            all.next();
            tradeId = all.getInt(1);

            String update = "UPDATE trade SET pair=?, id_BuySell=?, dateOfTrade=?, timeOfTrade=?, id_WBEL=?, id_Strategy=?, profit=?, reasonF=?, reasonA=?, other=?, learn=? WHERE id_Trade=?";
            ps = con.prepareStatement(update);
            ps.setString(1, pair);
            ps.setString(2, bsId);
            ps.setString(3, date);
            ps.setString(4, time);
            ps.setString(5, wbelId);
            ps.setString(6, stratId);
            ps.setString(7, profit);
            ps.setString(8, reasonsF);
            ps.setString(9, reasonsA);
            ps.setString(10, others);
            ps.setString(11, learn);
            ps.setString(12, String.valueOf(tradeId));
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "There was an Error. Please Try again!", "Something went wrong!", JOptionPane.ERROR_MESSAGE);
        } finally {
            closeConnection();
        }
    }

    public ObservableList<Trades> select() {
        ObservableList<Trades> trades = FXCollections.observableArrayList();
        String bs = "BUY";
        String wbel = "WIN";
        String strat = "TBX";
        ResultSet rs;

        try {
            con = DriverManager.getConnection(connection, root, pw);
            String selectAll = "SELECT * FROM trade";
            ps = con.prepareStatement(selectAll);
            rs = ps.executeQuery();
            while (rs.next()) {
                sqlGetIDs = "SELECT * FROM buysell WHERE id_BuySell=?";
                ps = con.prepareStatement(sqlGetIDs);
                ps.setString(1, rs.getString("id_BuySell"));
                ResultSet getBs = ps.executeQuery();
                if (getBs.next()) {
                    bs = getBs.getString("tradeKind");
                }

                sqlGetIDs = "SELECT * FROM wbel WHERE id_WBEL=?";
                ps = con.prepareStatement(sqlGetIDs);
                ps.setString(1, rs.getString("id_WBEL"));
                ResultSet getWbel = ps.executeQuery();
                if (getWbel.next()) {
                    wbel = getWbel.getString("finish");
                }

                sqlGetIDs = "SELECT * FROM strategy WHERE id_Strategy=?";
                ps = con.prepareStatement(sqlGetIDs);
                ps.setString(1, rs.getString("id_strategy"));
                ResultSet getStrat = ps.executeQuery();
                if (getStrat.next()) {
                    strat = getStrat.getString("strategy");
                }

                trades.add(new Trades(rs.getString("pair"), bs, rs.getString("dateOfTrade"), rs.getString("timeOfTrade"), wbel, strat, rs.getString("profit"), rs.getString("reasonF"), rs.getString("reasonA"), rs.getString("other"), rs.getString("learn")));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "There was an Error. Please Try again!", "Something went wrong!", JOptionPane.ERROR_MESSAGE);
        } finally {
            closeConnection();
        }
        return trades;
    }

    private void closeConnection() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ignore) {
            }
        }
    }
}
