package tech.ceece.binarytreetictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;
    Button[] button;
    Box winner;
    int move;

    //Game Tree
    GameTree gameTree = new GameTree();
    GameBoard board = new GameBoard();

    //Set the root of the tree
    GameBoardNode gameBoardNode = new GameBoardNode(board, Box.X);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set up the buttons
        b1 = (Button) findViewById(R.id.button2);
        b2 = (Button) findViewById(R.id.button5);
        b3 = (Button) findViewById(R.id.button8);
        b4 = (Button) findViewById(R.id.button3);
        b5 = (Button) findViewById(R.id.button6);
        b6 = (Button) findViewById(R.id.button9);
        b7 = (Button) findViewById(R.id.button4);
        b8 = (Button) findViewById(R.id.button7);
        b9 = (Button) findViewById(R.id.button10);
        button = new Button[] {b1, b2, b3, b4, b5, b6, b7, b8, b9};

        //Set the root of the tree
        gameBoardNode.setUpConfig();

        //Build tree
        gameTree.setRoot(gameTree.buildTree(gameBoardNode, Box.X));
        gameTree.setCursor(gameTree.getRoot());

        //System.out.println(gameTree.checkWin(gameTree.getCursor()));
        gameTree.getCursor().setProbabilities();
    }

    public void onOne(View v){
        //Human's move
        move = 1;

        try {
            gameTree.makeMove(move);
            b1.setText("X");
            winner = gameTree.checkWin(gameTree.getCursor());  //Check winner
        } catch (Exception e) {
            e.printStackTrace();
        }

        //AI Move
        AIMove();
    }

    public void onTwo(View v){
        //Human's move
        move = 2;
        b2.setText("X");
        gameTree.makeMove(move);
        winner = gameTree.checkWin(gameTree.getCursor());  //Check winner

        //AI - move
        AIMove();
    }

    public void onThree(View v){
        //Human's move
        move = 3;
        b3.setText("X");
        gameTree.makeMove(move);
        winner = gameTree.checkWin(gameTree.getCursor());  //Check winner

        //AI - move
        AIMove();
    }

    public void onFour(View v){
        //Human's move
        move = 4;
        b4.setText("X");
        gameTree.makeMove(move);
        winner = gameTree.checkWin(gameTree.getCursor());  //Check winner

        //AI - move
        AIMove();
    }

    public void onFive(View v){
        //Human's move
        move = 5;
        b5.setText("X");
        gameTree.makeMove(move);
        winner = gameTree.checkWin(gameTree.getCursor());  //Check winner

        //AI - move
        AIMove();
    }

    public void onSix(View v){
        //Human's move
        move = 6;
        b6.setText("X");
        gameTree.makeMove(move);
        winner = gameTree.checkWin(gameTree.getCursor());  //Check winner

        //AI - move
        AIMove();
    }

    public void onSeven(View v){
        //Human's move
        move = 7;
        b7.setText("X");
        gameTree.makeMove(move);
        winner = gameTree.checkWin(gameTree.getCursor());  //Check winner

        //AI - move
        AIMove();
    }

    public void onEight(View v){
        //Human's move
        move = 8;
        b8.setText("X");
        gameTree.makeMove(move);
        winner = gameTree.checkWin(gameTree.getCursor());  //Check winner

        //AI - move
        AIMove();
    }

    public void onNine(View v){
        //Human's move
        move = 9;
        b9.setText("X");
        gameTree.makeMove(move);
        winner = gameTree.checkWin(gameTree.getCursor());  //Check winner

        //AI - move
        AIMove();
    }

    public void AIMove(){
        //AI - move
        if (!gameTree.getCursor().getIsEnd()) {
            //Computer's turn
            int aiMove = gameTree.getCursor().miniMax()[1] + 1;
            Toast.makeText(this, "" + aiMove, Toast.LENGTH_SHORT).show();
            gameTree.makeMove(aiMove);
            winner = gameTree.checkWin(gameTree.getCursor());  //Check winner
            button[aiMove - 1].setText("O");
        }


        if(gameTree.getCursor().getIsEnd()){
            finish();
            Intent intent = new Intent(this, Results.class);
            Statics.getWinner = winner;
            startActivity(intent);
        }
    }



}
