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

In _"db"_ io mode the input data is taken from first row of _input_data_ table from _postgres_ database. The result is written to _output_data_ table.
