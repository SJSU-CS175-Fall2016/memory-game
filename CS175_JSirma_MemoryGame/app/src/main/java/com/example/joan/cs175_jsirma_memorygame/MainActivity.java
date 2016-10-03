package com.example.joan.cs175_jsirma_memorygame;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

//    Button playButton;
//    Button rulesButton;

    @BindView(R.id.play) Button playButton;
    @BindView(R.id.rules) Button rulesButton;
    @BindView(R.id.textView) TextView textView;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayRules(View view){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTest managerFrag = new FragmentTest();
        managerFrag.setStyle(DialogFragment.STYLE_NORMAL, R.style.AppTheme);
        managerFrag.show(manager,"Rules");


//        textView.setVisibility(View.GONE);
//        playButton.setVisibility(View.GONE);
//        rulesButton.setVisibility(View.GONE);
//        FragmentTest fragment = new FragmentTest();
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.activity_main, fragment, "Fragment");
//        transaction.commit();


    }


    public void displayGame(View view){
        Intent intent = new Intent(this,GamePlay.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);


    }
}



