package edu.byui.cs246.snielson.scripturereference;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Takes in the favorite scripture inputs, saves the favorite scripture, and shares them with the
 * display activity.
 */
public class FavoriteScriptureInput extends AppCompatActivity {

  public static final String MESSAGE_SCRIPTURE =
      "edu.byui.cs246.snielson.scripturereference.Scripture";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_favorite_scripture_input);
  }

  /**
   * Takes the user's favorite scripture from the activity and shares it with the display activity.
   * @param view The view button that was clicked on.
   */
  public void shareFavoriteScripture(View view) {

    Intent intent = new Intent(this, FavoriteScriptureDisplay.class);
    storeScriptureText(intent);
    startActivity(intent);
  }

  /**
   * Retrieves all of the scripture text from current activity and saves their information into the
   * FavoriteScripture object.
   */
  private void storeScriptureText(Intent intent) {
    EditText book = (EditText) findViewById(R.id.book);
    EditText chapter = (EditText) findViewById(R.id.chapter);
    EditText verse = (EditText) findViewById(R.id.verse);
    if (book == null || chapter == null || verse == null) {
      throw new RuntimeException("book, chapter, or verse widget not found.  "
          + "Cannot retrieve values");
    }

    FavoriteScripture scripture = new FavoriteScripture();
    scripture.setBook(book.getText().toString());
    scripture.setChapter(chapter.getText().toString());
    scripture.setVerse(verse.getText().toString());
    intent.putExtra(MESSAGE_SCRIPTURE, scripture);
  }
}
