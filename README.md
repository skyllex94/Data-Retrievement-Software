# Data-Retrievement-Software
A software for analyzing data content and retrieving documents with the appropriate search.

Description of the System of Information Retrieval

Data Loading
To be able to load the data set then I integrated the files to the same path that the project is
done in. As doing this, I’m reading the 2 folders in separate methods and as files and after it,
creating a file array for reading each txt/html document. The same process is implemented for
the external file of stop words. Having one Spanish and another one English. All of the processes
above are done into a public method of type Map[] (array of maps).
I have put a couple of extra variables for gathering all the files’ names as well as how many
different document we have in the CACM and Quijote folders.
A while statement is used to scan all the lines from the stopword.txts and be able to execute the
upcoming manipulations.

Scanning all the words in the documents
As I read the files one by one, the following procedures is associated with creating a loop with
for(){} statement. To do so, we put the maximum number of loops to the variable that we have
created above. Immediately after it, I start reading the files and create an integer position to start
counting the positions of the words for further execution.
Next point is creating a scanner and a while loop to be able to read in the words inside. Here we
create the string coderemoval that is going to be associated with the currently running word from
the chapters and the manipulations we do with it.
First we remove the stop words with another loop that reads in each line and compares it with
the words at hand.

A while statement is used to scan all the lines from the stopword.txts and be able to execute the
upcoming manipulations.

Scanning all the words in the documents
As I read the files one by one, the following procedures is associated with creating a loop with
for(){} statement. To do so, we put the maximum number of loops to the variable that we have
created above. Immediately after it, I start reading the files and create an integer position to start
counting the positions of the words for further execution.
Next point is creating a scanner and a while loop to be able to read in the words inside. Here we
create the string coderemoval that is going to be associated with the currently running word from
the chapters and the manipulations we do with it.
First we remove the stop words with another loop that reads in each line and compares it with
the words at hand.

Word manipulation
What I did is create a separate static string for all of the manipulation that I am making on the current word (coderemovall). The method’s name is word_modif. In it we have all the regular expression for removing non useful words and symbols for the indexation.
What we have in it are expressions for: removing punctuation and unique symbols, lowering all the words – no capital letters, removing tildes, small words that are less than 4 letters, numbers and applying the stemming process for getting to the stem of the word. All of it is structured in this methods that after it returns the modified words to the same Map[] QUIJOTE method. Same process is done so on the CACM files.

Implementation of TreeMaps and Maps
As I continue on in the main class, I declare 3 initial Maps for storing the final steps of the indexation process
The second frequency_map is made for trying the vectorial search, the first is used for the Boolean search. The freq_map is made for calculating the frequency of each word in the document and the chapter_map is the one that goes with the calculating each position of a word in each capital.
All of the above are handled in the Map[] QUIJOTE and Map[] CACM. First I find the frequency and save the results in the freq_map, later on I make the chapter_map and the allwords map with some additional set of data (arrays) like the check_pos, position_map.

Boolean Results
The boolean_search method
In order to calculate the binary existence from a given query to the documents, we use another method that has 2 initializing variables: a string, representing the query; and a map for searching from the data set. First of all we split the query into separate words if they are more than 1 and after it create a for loop to start the searching process.
First of all, we manipulate the given word throw the word_modif class to remove symbols or non-useful punctuation. As we do so, we create an if statement to search of equal word in the chapters. If so, the chapter name is taken and returned.

