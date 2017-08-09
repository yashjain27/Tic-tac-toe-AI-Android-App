package tech.ceece.binarytreetictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        //Print the winner
        TextView textView = (TextView) findViewById(R.id.textView2);
        if(Statics.getWinner == Box.EMPTY)
            textView.setText("It's a draw");
        else
            textView.setText("The winner is: " + Statics.getWinner);

    }

    public void onRestart(View v){
        finish();
        startActivity(new Intent(this, MainActivity.class));
    }
}
