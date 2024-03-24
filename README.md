# TestCalculator 

**_TestCalculator_** provides four arithmetic functions:
- _add n1 n2 ..._ - sums two or more numbers
- _mul n1 n2 ..._ - multiplies two or more numbers
- _mul-then-add n1 n2 n3_ - performers n1*n2+n3
- _inc-then-add n1 n2 ..._ - increments numbers then multiplies them

Program runs with two parameters: **_input_mode_** and **_output_mode_**, where mode can be
- '-' - io from/to console
- 'db'- io from/to a database
- 'file name' - io from/to a file
java

Example program call that reads input data from file and writes output to console:
java Main inputFile.txt -

In 'db' io mode it reads data from postgres database input_data table from first row. Writes to output_data table.
