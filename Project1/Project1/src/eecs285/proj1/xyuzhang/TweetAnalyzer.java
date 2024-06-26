/**
 * EECS 285 Project 1 -- Class that analyzes tweet sentiments.
 *
 * Contains methods to analyze the sentiment of an individual tweet,
 * as well as the average sentiment of tweets within and outside a
 * geographic area.
 *
 * See https://eecs285.github.io/p1-sentiments/ for the specification.
 */

package eecs285.proj1.xyuzhang; // replace with your uniqname

import java.util.ArrayList;

public class TweetAnalyzer {
  /**
   * Constructs a TweetAnalyzer using the given sentiments file and
   * tweets file.
   *
   * @param sentimentFilename  the path of the sentiments file
   * @param tweetFilename  the path of the tweets file
   */
  public TweetAnalyzer(String sentimentFilename,
                       String tweetFilename) {
    sentiments = new Sentiments(sentimentFilename);
    tweets = new TweetReader(tweetFilename);
  }

  /**
   * Computes the overall sentiment of a tweet.
   *
   * The result is the average sentiment of the words in the tweet
   * that have a non-zero sentiment value. Returns null if no word in
   * the tweet has a non-zero sentiment.
   *
   * @param tweet  the tweet to analyze
   * @return  the overall sentiment of the tweet
   */
  public Double computeSentiment(Tweet tweet) {
    ArrayList<String> words = tweet.getWords();
    double sentiment = 0.0;
    int wordSize = words.size();

    // enhanced for loop
    for (String word : words) {
      if (sentiments.getSentiment(word) == 0.0) {
        wordSize -= 1;
        continue;
      } else {
        sentiment += sentiments.getSentiment(word);
      }
    }

    if (wordSize == 0) {
      return null;
    } else {
      return sentiment / wordSize;
    }
  }

  /**
   * Computes the average sentiment of tweets within the given
   * geographic area.
   *
   * Prints out the average sentiment to standard output in the format
   * described in the project specification.
   *
   * @param lowerBound  the lower bound of the geographic area
   * @param upperBound  the upper bound of the geographic area
   */
  public void averageSentimentWithin(Location lowerBound,
                                     Location upperBound) {
    // your code here
    int inCount = 0;
    double averageInSentiment = 0.0;

    for (int i = 0; i < tweets.size(); i++) {
      Tweet tweet = tweets.get(i);  // retrieve the tweet at the given index
      Double averageSentiment = computeSentiment(tweet);
      Location tweetLocation = tweet.getLocation();

      if (averageSentiment == null || !tweetLocation.isWithin(lowerBound, upperBound)) {
        continue;
      } else {
        inCount += 1;
        averageInSentiment += averageSentiment;
      }
    }

    if (inCount == 0) {
      System.out.println("  No tweets with sentiment");
    } else {
      System.out.println("  Average sentiment over " + inCount + " tweets: " +
          roundedString(averageInSentiment / inCount));
    }
  }

  /**
   * Computes the average sentiment of tweets outside the given
   * geographic area.
   *
   * Prints out the average sentiment to standard output in the format
   * described in the project specification.
   *
   * @param lowerBound  the lower bound of the geographic area
   * @param upperBound  the upper bound of the geographic area
   */
  public void averageSentimentOutside(Location lowerBound,
                                      Location upperBound) {
    // your code here
    int outCount = 0;
    double averageOutSentiment = 0.0;

    for (int i = 0; i < tweets.size(); i++) {
      Tweet tweet = tweets.get(i);  // retrieve the tweet at the given index
      Double averageSentiment = computeSentiment(tweet);
      Location tweetLocation = tweet.getLocation();

      if (averageSentiment == null || tweetLocation.isWithin(lowerBound, upperBound)) {
        continue;
      } else {
        outCount += 1;
        averageOutSentiment += averageSentiment;
      }
    }

    if (outCount == 0) {
      System.out.println("  No tweets with sentiment");
    } else {
      System.out.println("  Average sentiment over " + outCount + " tweets: " +
          roundedString(averageOutSentiment / outCount));
    }
  }

  /**
   * Returns a string representation of the given double, rounded to
   * four digits after the decimal.
   *
   * @param value  the value to represent
   * @return  string representation of value
   */
  String roundedString(double value) {
    return String.format("%.4f", value);
  }

  /** Mapping of words to sentiment values. */
  private Sentiments sentiments;
  /** Contains the tweet data to analyze. */
  private TweetReader tweets;
}
