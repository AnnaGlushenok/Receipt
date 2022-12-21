# Instructions
To launch the project you have to open folder main in build (build\classes\java\main)
After open console and input the next command:
> java receipt.Main params 

Where the set of parameters in the format itemId-quantity
(itemId - the identifier of the goods, the quantity - its quantity) and card-numberOfCard, that provides discount.
For instance:
> java receipt.Main 3-1 2-5 5-1 card-6272

Also, you can fill file products.txt, that placed by path build\classes\java\main
and instead of "3-1 2-5 5-1 card-6272" pass name of file with its format.
For instance:
> java receipt.Main products.txt

Distance file will be created next to source file and called "receipt.txt".

Application is written in Java 17 and gradle 7.5, tested using junit.jupiter library 