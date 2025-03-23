# The Adviser

## Description
The Adviser is the stupid app that just reads from or writes to
`.csv` file you words and its translation.

## How does it work
### Read
Looks for such file and throws an exception if couldn't to;

### Write
Looks for such file and creates there if didn't find.
Each writing operating is applied to newly created file.

## How to run program
Chose one of them:
1. Pull source code and build manually with `gradle build`
2. Pull source code and open project with your IDE
3. Pull latest build and run `java -jar <title>.jar arg1 arg2`

Note that <b>arg</b> 1 is either `read` or `write` and the <b>arg2</b> 
is the path to your file.