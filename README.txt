
"This assignment's submission is my own work and I did not discuss with
 any other past or current student, nor did I have access to a previous
 submission of this assignment by another student."

Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=<mode> -Darg1=<N> -Darg2=<FileName>

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.”

[Date: 12/13/2017]

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

Vector for storing results:
	Best: O(1) for add() and O(1) for remove 
	Average: O(1) for add() and O(N) for remove
	Worst: O(1) for add() and O(N) for remove
	
-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).

1) FileWriter Usage:
https://www.tutorialspoint.com/java/io/java_io_filewriter.htm

2)BufferedWriter Usage:
http://www.tutorialspoint.com/java/io/java_io_bufferedwriter.htm

3) Get HashCode of any String:
https://www.tutorialspoint.com/java/java_string_hashcode.htm

4) Motivation to select Scanner over BufferedReader:
https://stackoverflow.com/questions/2231369/scanner-vs-bufferedreader
