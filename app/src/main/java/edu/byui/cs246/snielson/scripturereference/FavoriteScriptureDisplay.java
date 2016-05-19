package edu.byui.cs246.snielson.scripturereference;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class FavoriteScriptureDisplay extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_favorite_scripture_display);

    updateScriptureDisplay();
  }

  @Override
  protected void onResume() {
    super.onResume();
    updateScriptureDisplay();
  }

  private void updateScriptureDisplay() {
    FavoriteScripture scripture = FavoriteScripture.getInstance();
    TextView displayScripture = (TextView) findViewById(R.id.scriptureDisplay);
    if (displayScripture == null) {
      throw new RuntimeException("Could not retrieve displayScripture from view");
    }

    displayScripture.setText(scripture.getDisplayText());
  }
}
