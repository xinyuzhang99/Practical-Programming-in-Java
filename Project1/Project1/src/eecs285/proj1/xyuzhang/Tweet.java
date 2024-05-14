package eecs285.proj1.xyuzhang;

import java.util.ArrayList;

public class Tweet {
  /**
   * Represent an individual tweet,
   * keeping track of both the location where the tweet originated and the content of the tweet
   */
  private String content;
  private double lat, lon;

  public Tweet(String content, double lat, double lon) {
    this.content = content;
    this.lat = lat;
    this.lon = lon;
  }

  public String getText() {
    return content;
  }

  public Location getLocation() {
    return new Location(lat, lon);
  }

  @Override
  public String toString() {
    return "[" + lat + ", " + lon + "] " + content;
  }

  // return a list of individual words in the tweet
  public ArrayList<String> getWords() {
    ArrayList<String> words = new ArrayList<>();
    String currWord = "";

    for (int i = 0; i < content.length(); i++) {
      char c = content.charAt(i);  // extract each character
      if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
        currWord += c;
      } else {
        if (!currWord.isEmpty()) {
          words.add(currWord); // add the word to the list
          currWord = "";
        }
      }
    }

    // add the last word if possible
    if (!currWord.isEmpty()) {
      words.add(currWord);
    }
    return words;
  }
}
