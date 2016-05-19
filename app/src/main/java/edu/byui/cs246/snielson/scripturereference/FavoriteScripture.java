package edu.byui.cs246.snielson.scripturereference;

import java.io.Serializable;

/**
 * Represents a user's favorite scripture (book, chapter, and verse).
 * @author Stephen Nielson
 */
public class FavoriteScripture implements Serializable {

  /**
   * Singleton instance of the FavoriteScripture.
   */
  private static FavoriteScripture instance;

  /**
   * The book for the scripture reference.
   */
  private String book;

  /**
   * The chapter for this scripture reference.
   */
  private String chapter;

  /**
   * The verse for this scripture reference.
   */
  private String verse;

  /**
   * Only this class can instantiate itself.
   */
  public FavoriteScripture() {}

  public String getChapter() {
    return chapter;
  }

  public void setChapter(String chapter) {
    this.chapter = chapter;
  }

  public String getBook() {
    return book;
  }

  public void setBook(String book) {
    this.book = book;
  }

  public String getVerse() {
    return verse;
  }

  public void setVerse(String verse) {
    this.verse = verse;
  }

  /**
   * Returns the string representation of the Favorite Scripture.
   * @return The text to display for the favorite scripture.
   */
  public String getDisplayText() {
    StringBuilder sb = new StringBuilder();
    sb.append(this.getBook());
    if (this.getChapter() != null) {
      sb.append(" ");
      sb.append(this.getChapter());
      if (this.getVerse() != null) {
        sb.append(":");
        sb.append(this.getVerse());
      }
    }
    return sb.toString();
  }
}
