/*
 * A simple library that helps you print the data of a ResultSet,
 * acquired from a SELECT SQL query, in a familiar-looking MySQL table style.
 *
 * Copyright (C) 2018  Thisseas Xanthopoulos
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package thisseasx.ResultSetPrinter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for printing an entire ResultSet
 * in a MySQL style. The {@link ResultSet} is first converted
 * into a {@link List} of lists, and then is sent to {@link TablePrinter}
 * for extraction, and ultimately printing.
 *
 * @author ThisseasX
 */
public class ResultSetPrinter {

    private static ResultSet rs;
    private static int columnCount;

    /**
     * The static method visible to the outside world, responsible for
     * printing the entire {@link ResultSet}.
     *
     * @param rs The {@link ResultSet} acquired from an SQL {@link Statement} query.
     */
    public static void printResultSet(ResultSet rs) throws SQLException {
        rs.beforeFirst();
        ResultSetPrinter.rs = rs;
        ResultSetPrinter.columnCount = rs.getMetaData().getColumnCount();
        printResultSet();
    }

    /**
     * All the methods required to yield the final result
     * of printing the entire {@link ResultSet}.
     *
     * @throws SQLException
     */
    private static void printResultSet() throws SQLException {
        List<List<String>> table = new ArrayList<>();
        table.add(getHeaders());
        fillTableWithData(table);

        TablePrinter.printTable(table, columnCount);
    }

    /**
     * Creates a {@link List} of lists, containing the {@link ResultSet}'s data.
     *
     * @param table A given {@link List} which will be filled with the {@link ResultSet}'s data.
     */
    private static void fillTableWithData(List<List<String>> table) throws SQLException {
        while (rs.next()) {
            List<String> row = new ArrayList<>();
            for (int i = 1; i <= columnCount; i++)
                row.add(rs.getString(i));
            table.add(row);
        }
    }

    /**
     * Gets the column names of the {@link ResultSet} and turns them
     * into a {@link List}.
     *
     * @return A {@link List} with the {@link ResultSet}'s column names.
     */
    private static List<String> getHeaders() throws SQLException {
        List<String> headers = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++)
            headers.add(rs.getMetaData().getColumnName(i));
        return headers;
    }
}
