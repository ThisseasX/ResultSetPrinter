package thisseasx;

import java.sql.ResultSet;
import java.util.*;

/**
 * This class is used by {@link ResultSetPrinter} to
 * print the {@link List} of lists containing
 * the data from a {@link ResultSet}.
 *
 * @author Thiss
 */
class TablePrinter {

    private static List<List<String>> table;
    private static int columnCount;

    /**
     * The static method visible to the outside world, responsible for
     * printing the entire table.
     * @param table A {@link List} of lists, containing the data of a table.
     * @param columnCount The number of columns
     */
    static void printTable(List<List<String>> table, int columnCount) {
        TablePrinter.table = table;
        TablePrinter.columnCount = columnCount;
        printTable();
    }

    /**
     * All the methods required to yield the final result
     * of printing the entire table.
     */
    private static void printTable() {
        printDivider();
        printHeaders();
        printDivider();
        printBody();
        printDivider();
        System.out.println();
    }

    /**
     * Gets the length of the longest string in a given column.
     * @param col A given column whose width we want to calculate.
     * @return The length of the longest string in a given column.
     */
    private static int getColumnWidth(int col) {
        int columnWidth = 0;
        for (List<String> row : table) {
            if (col >= row.size()) continue;
            String s = row.get(col);
            columnWidth = s.length() > columnWidth ? s.length() : columnWidth;
        }
        return columnWidth;
    }

    /**
     * In the theoretical case where
     * we do not know the number of columns.
     * @return The number of columns.
     */
    @SuppressWarnings("unused")
    private static int getColumnCount() {
        return table.stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(List::size))
                .orElse(new ArrayList<>()).size();
    }

    /**
     * Prints the +---+---+ divider.
     */
    private static void printDivider() {
        System.out.print("+");
        for (int i = 0; i < columnCount; i++) {
            int divWidth = getColumnWidth(i) + 2;
            System.out.print(String.join("", Collections.nCopies(divWidth, "-")));
            System.out.print("+");
        }
        System.out.println();
    }

    /**
     * Prints the names of the columns.
     */
    private static void printHeaders() {
        System.out.print("| ");
        List<String> headerRow = table.get(0);
        printColumns(headerRow);
        printEmptyColumns(headerRow);
        System.out.println();
    }

    /**
     * Prints the data of the table.
     */
    private static void printBody() {
        for (int i = 1; i < table.size(); i++) {
            System.out.print("| ");
            List<String> row = table.get(i);
            printColumns(row);
            printEmptyColumns(row);
            System.out.println();
        }
    }

    /**
     * Prints the data of the row.
     * @param row A given row of the table, from which the values
     *            are extracted and printed.
     */
    private static void printColumns(List<String> row) {
        for (int i = 0; i < row.size(); i++) {
            System.out.printf("%-" + getColumnWidth(i) + "s | ", row.get(i));
        }
    }

    /**
     * Prints empty spaces for columns that have no data.
     * @param row A given row of the table, from which the values
     *            are extracted and printed.
     */
    private static void printEmptyColumns(List<String> row) {
        if (columnCount > row.size()) {
            for (int i = row.size(); i < columnCount; i++) {
                System.out.printf("%-" + getColumnWidth(i) + "s | ", "");
            }
        }
    }
}
