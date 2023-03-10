# Ledger-CLI Experiment

Basic LedgerCLI implementation in Java.

## Requirements
- Java JDK 11 or OpenJDK 11

## To compile the code
```
    javac Ledger.java
```
## Using the .sh file to run the program
We can compile and run this program using the .sh file my-ledger.sh.
The command would be:
```
    ./my-ledger.sh
```
To run the code without the .sh file, once we have the code compiled we only need to use
```
    java Ledger
```
## Required arguments
- ### File: Index
In this file we can find the name of the ledger files the program will use to do the function especified. In the .sh file we can see we use a file called "Index.ledger" from the "Sample_files" folder. We can change the file to whatever file we want, but the files that are included on the Index need to be on the same folder as the Index.

To select a file we use the comand "-file" or "-f":
```
    java Ledger -f Index.ledger
```
- ### File: prices-db
In this file we can find some exchanges to use. In the .sh file we can see we use a file called "prices_db" from the "Sample_files" folder. We can change the file to whatever file we want

To select a file we use the command "--prices-db":
```
    java Ledger --prices-db prices_db
```


## Basic functions
We have 3 basic functions we can use in this implementation
- 
    - Print
    - Registry
    - Balance

- ## Print function
We can use the print function with the command print:
```
    ./my-ledger.sh print
```
This function prints the movements from our accounts that match the name of the accounts we introduce, and if we don't introduce any name we'll get every movement in our ledger files.

Using the Sample files, the output for:
```
    ./my-ledger.sh print
```
Would be: 

![Image text](https://github.com/EduardoMtz1/Ledger-CLI/blob/main/ReadMeFiles/Print-01.png)

And if we only want to see info about the Payable account, we'll use:
```
    ./my-ledger.sh print Payable
```
To get:

![Image text](https://github.com/EduardoMtz1/Ledger-CLI/blob/main/ReadMeFiles/Print-02.png)

- ## Registry function
We can use the registry function with the command registry or reg:
```
    ./my-ledger.sh registry
    ./my-ledger.sh reg
```
This function prints the registry from our accounts that match the name of the accounts we introduce, using a format where we can see better the value of every movement we have in our ledger files. If we don't introduce any name we'll get every movement in our ledger files.

Using the Sample files, the output for:
```
    ./my-ledger.sh reg
```
Would be: 

![Image text](https://github.com/EduardoMtz1/Ledger-CLI/blob/main/ReadMeFiles/Reg-01.png)

And if we only want to see info about our Bank account, we'll use:
```
    ./my-ledger.sh print Bank
```
To get:

![Image text](https://github.com/EduardoMtz1/Ledger-CLI/blob/main/ReadMeFiles/Reg-02.png)

- ## Balance function
We can use the balance function with the command balance or bal:
```
    ./my-ledger.sh balance
    ./my-ledger.sh bal
```
This function obtains the balance from the accounts that match the name of the accounts we introduce, depending on the movements we have. If we don't introduce any name we'll get the balance of every account in our ledger files.

Using the Sample files, the output for:
```
    ./my-ledger.sh bal
```
Would be: 

![Image text](https://github.com/EduardoMtz1/Ledger-CLI/blob/main/ReadMeFiles/Bal-01.png)

And if we only want to see info about our Asset, we'll use:
```
    ./my-ledger.sh bal Asset
```
To get:

![Image text](https://github.com/EduardoMtz1/Ledger-CLI/blob/main/ReadMeFiles/Bal-02.png)

### Sort Flag
In registry and print functions we can use the flag "-s" or "--sort" to sort the movements by date or amount.

For example:
```
    ./my-ledger.sh reg -s date
    ./my-ledger.sh reg -s amount
```