TestCalculator provides four arithmetic functions:
- add n1 n2 ... - sums two or more numbers
- mul n1 n2 ... - multiplies two or more numbers
- mul-then-add n1 n2 n3 - performers n1*n2+n3
- inc-then-add n1 n2 ... - increments numbers then multiplies them

Program calls with two parameters: input_mode and output_mode, where mode can be
- '-' - io from/to console
- 'db'- io from/to a database
- 'file name' - io from/to a file
java

Example program call that reads input data from file and writes output to console:
java Main inputFile.txt -

In 'db' io mode it reads data from postgres database input_data table from first row. Writes to output_data table.
