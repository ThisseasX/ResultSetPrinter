# ResultSetPrinter

A simple library that helps you print the data of a `ResultSet`, acquired from a `SELECT` SQL query, in a familiar-looking MySQL table style.

## Setup

1) Import the library.
2) Acquire a `ResultSet` through a `SELECT` query.
3) Call `ResultSetPrinter#printResultSet(ResultSet rs)` with your `ResultSet` as the argument.
4) Enjoy your MySQL-style table in the console.

## Samples

#### With ResultSetPrinter
```
+---------+--------------------+------------+-----------------------+
| city_id | city               | country_id | last_update           | 
+---------+--------------------+------------+-----------------------+
| 1       | A Corua (La Corua) | 87         | 2006-02-15 04:45:25.0 | 
| 2       | Abha               | 82         | 2006-02-15 04:45:25.0 | 
| 3       | Abu Dhabi          | 101        | 2006-02-15 04:45:25.0 | 
| 4       | Acua               | 60         | 2006-02-15 04:45:25.0 | 
| 5       | Adana              | 97         | 2006-02-15 04:45:25.0 | 
| 6       | Addis Abeba        | 31         | 2006-02-15 04:45:25.0 | 
| 7       | Aden               | 107        | 2006-02-15 04:45:25.0 | 
| 8       | Adoni              | 44         | 2006-02-15 04:45:25.0 | 
| 9       | Ahmadnagar         | 44         | 2006-02-15 04:45:25.0 | 
| 10      | Akishima           | 50         | 2006-02-15 04:45:25.0 | 
+---------+--------------------+------------+-----------------------+
```

#### Without ResultSetPrinter (Simple Loop)

```
1 A Corua (La Corua) 87 2006-02-15 04:45:25.0 
2 Abha 82 2006-02-15 04:45:25.0 
3 Abu Dhabi 101 2006-02-15 04:45:25.0 
4 Acua 60 2006-02-15 04:45:25.0 
5 Adana 97 2006-02-15 04:45:25.0 
6 Addis Abeba 31 2006-02-15 04:45:25.0 
7 Aden 107 2006-02-15 04:45:25.0 
8 Adoni 44 2006-02-15 04:45:25.0 
9 Ahmadnagar 44 2006-02-15 04:45:25.0 
10 Akishima 50 2006-02-15 04:45:25.0 
```
