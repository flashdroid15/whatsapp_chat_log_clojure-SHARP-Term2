# Prerequisites
[GraalVM](https://www.graalvm.org)  
[babashka](https://github.com/babashka/babashka/blob/master/doc/build.md)

# Usage
Filters Whatsapp chat logs for particular users using regular expressions.  
Receives Whatsapp chat logs as a .txt file and outputs a filtered .txt file of chats, by their contact name.  
Requires 3 command line arguments, the input file path, the output file path, and the contact name to search for.

To run, navigate to the directory with search.clj and run this command  
``bb search.clj <input file> <output file> <contact name>``

> Special characters should be preceded with a backslash (\).  
> e.g. \+65 instead of +65  

> Arguments with whitespaces should be encased in double quotes.  
> e.g. "+65 999" instead of +65 999

# Functional Programming Concepts

## Higher Order Functions
Stream operations such as filter are higher order functions. In our program, filter is used to check if each item in the vector contains a match for our regular expressions. 
doseq is also a higher order function. doseq acts as a foreach loop and in our program, applies the spit operation to write the results of the filter to a new file.

## Minimal Actions 
Our program has zero actions other than the input and output operations. Otherwise, our program composes on only calculations.

## Immutable Data
Rather than storing the chat log as a vector, mutating it, then writing to an external file, our program uses stream operations to create a new vector of the filtered chat log, then outputs it to an external file.
