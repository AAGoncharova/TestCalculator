# TestCalculator 

**_TestCalculator_** provides four arithmetic functions:
- _add n1 n2 ..._ - sums two or more numbers
- _mul n1 n2 ..._ - multiplies two or more numbers
- _mul-then-add n1 n2 n3_ - performers n1*n2+n3
- _inc-then-add n1 n2 ..._ - increments numbers then multiplies them

Program takes two arguments: **_input_mode_** and **_output_mode_**, where mode can be
- _"-"_ - io from/to console
- _"db"_- io from/to a database
- _"file name"_ - io from/to a file

Example program call that reads input data from file _inputFile.txt_ and writes result to console:

```bash
java Main inputFile.txt -
```

In _"db"_ io mode the input data is taken from first row of _input_data_ table from _calculator_ database. The result is written to _output_data_ table.


**_Database connection properties:_**

url: _jdbc:postgresql://localhost:5432/calculator_

user: _postgres_

password: _postgres_


Connection properties can be changed in _DBManager.java_

The _sql.txt_ file which is located in _/src/main/resources/_ contains sql scripts to create corresponding database and tables.
