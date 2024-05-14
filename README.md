# Practical Programming in Java
## Project 1: Tweet Sentiments
This project analyzes Twitter data to determine how people within a geographical region feel about a topic compared to people outside that region. 
The tasks are to define basic data structures for locations and tweets, assign sentiments to a tweet based on the words in the contains, and aggregate tweets according to location to determine the average sentiment within and outside a region.

| File(s)                                        | Description                                                  |
| ---------------------------------------------- | ------------------------------------------------------------ |
| `Sentiments.java`                              | Data structure that maps words to sentiments                 |
| `TweetReader.java`                             | Data structure that holds tweet data read from a file        |
| `TweetAnalyzer.java`                           | Class that analyzes tweet sentiments. You will need to complete this class. |
| `TweetSentimentMain.java`                      | Main driver for tweet-sentiment analysis                     |
| `Test.java`                                    | Basic tests for `Location` and `Tweet` clases                |
| `Test.correct`                                 | Correct output from running `Test`                           |
| `data/`                                        | Directory containing sentiment data (`sentiments.csv`) and tweet data (`*.txt`) |
| `obama.correct` `soup.correct` `texas.correct` | Correct output from running sentiment analysis on `obama.txt`, `soup.txt`, and `texas.txt` |
