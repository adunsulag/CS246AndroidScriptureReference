package edu.byui.cs246.snielson.scripturereference;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Takes the favorite scripture information that was shared to this activity and displays it.
 */
public class FavoriteScriptureDisplay extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_favorite_scripture_display);

    Intent intent = getIntent();
    updateScriptureDisplayFromIntent(intent);
  }

  /**
   * Updates the current display text for this activity with scripture text contained in the intent.
   * @param intent The intent that was passed to this activity containing the shared scripture.
   */
  private void updateScriptureDisplayFromIntent(Intent intent) {
    Object obj = intent.getSerializableExtra(FavoriteScriptureInput.MESSAGE_SCRIPTURE);
    if (!(obj instanceof FavoriteScripture)) {
      throw new RuntimeException("object from intent was not of type FavoriteScripture");
    }

    FavoriteScripture scripture = (FavoriteScripture)obj;
    TextView displayScripture = (TextView) findViewById(R.id.scriptureDisplay);
    if (displayScripture == null) {
      throw new RuntimeException("Could not retrieve displayScripture from view");
    }

    displayScripture.setText(scripture.getDisplayText());
  }
}
