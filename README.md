# DesignPatterns-DynamicProxy-Reflection-StrategyPattern_JAVA

# By using this code, you agree to appropriate licences

# This code is a part of academic project and is for illustration purposes only

Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
ant -buildfile src/build.xml run -Darg0=<mode> -Darg1=<N> -Darg2=<FileName>

-----------------------------------------------------------------------
## Data Structures:

Vector for storing results:
	Best: O(1) for add() and O(1) for remove 
	Average: O(1) for add() and O(N) for remove
	Worst: O(1) for add() and O(N) for remove
	
-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).

1) FileWriter Usage:
https://www.tutorialspoint.com/java/io/java_io_filewriter.htm

2) BufferedWriter Usage:
http://www.tutorialspoint.com/java/io/java_io_bufferedwriter.htm

3) Get HashCode of any String:
https://www.tutorialspoint.com/java/java_string_hashcode.htm

4) Motivation to select Scanner over BufferedReader:
https://stackoverflow.com/questions/2231369/scanner-vs-bufferedreader
