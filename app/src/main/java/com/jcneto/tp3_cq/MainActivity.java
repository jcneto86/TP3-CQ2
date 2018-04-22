package com.jcneto.tp3_cq;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String morse = "";
    private String alpha = "";
    private final TraducteurMorse traducteurMorse = new TraducteurMorseConcrete();
    private AlertDialog alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editTextMorse = (EditText) findViewById(R.id.editTextMorse);
        final EditText editTextAlpha = (EditText) findViewById(R.id.editTextAlpha);
        // Listenre Button
        Button b = (Button) findViewById(R.id.btJouer);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playMorse();
            }
        });
        // Listenre TextView
        editTextAlpha.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                TextView textViewSorti = (TextView) findViewById(R.id.textSorti);
                textViewSorti.setText(traducteurMorse.toMorse(editable.toString()));
                TextView textViewEntre = (TextView) findViewById(R.id.textEntre);
                textViewEntre.setText(traducteurMorse.nettoyerAlpha(editable.toString()));
                morse = traducteurMorse.toMorse(editable.toString());
            }
        });
        editTextMorse.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                TextView textViewSorti = (TextView) findViewById(R.id.textSorti);
                textViewSorti.setText(traducteurMorse.toAlpha(editable.toString()));
                TextView textViewEntre = (TextView) findViewById(R.id.textEntre);
                textViewEntre.setText(editTextMorse.getText());
                alpha = traducteurMorse.toAlpha(editable.toString());
                morse = editable.toString();
                /**
                 *
                 */
                if (alpha.equals("") && !morse.isEmpty()) {
                    alertAttention();
                }

            }
        });

    }

    /**
     * @param v
     */
    public void funcTire(View v) {
        final EditText editTextMorse = (EditText) findViewById(R.id.editTextMorse);
        morse += "-";
        editTextMorse.setText(morse);
    }

    /**
     * @param v
     */
    public void funcPoint(View v) {
        final EditText editTextMorse = (EditText) findViewById(R.id.editTextMorse);
        morse += ".";
        editTextMorse.setText(morse);
    }

    /**
     * @param v
     */
    public void funBarreOblique(View v) {
        final EditText editTextMorse = (EditText) findViewById(R.id.editTextMorse);
        morse += "/";
        editTextMorse.setText(morse);
    }

    /**
     * @param v
     */
    public void funcEspace(View v) {
        final EditText editTextMorse = (EditText) findViewById(R.id.editTextMorse);
        morse += " ";
        editTextMorse.setText(morse);
    }

    /**
     * @param v
     */
    public void funcEfface(View v) {
        final EditText editTextMorse = (EditText) findViewById(R.id.editTextMorse);
        final EditText editTextAlpha = (EditText) findViewById(R.id.editTextAlpha);
        morse = "";
        alpha = "";
        editTextMorse.setText("");
        editTextAlpha.setText("");
    }

    /**
     * funcBackendBy
     * Afficher une message avec les nons de les
     * programmeurs qui a develope la application
     *
     * @param v
     */
    public void funcBackendBy(View v) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Backend pour/Backend By");
        builder.setMessage(traducteurMorse.getNomProgrammeurs());
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(MainActivity.this, ":D", Toast.LENGTH_SHORT).show();
            }
        });
        alert = builder.create();
        alert.show();
    }

    public void changerAlphaMorse(View v) {
        final EditText toMorse = (EditText) findViewById(R.id.editTextMorse);
        final EditText toAlpha = (EditText) findViewById(R.id.editTextAlpha);
        final Button chagerAlphaMorse = (Button) findViewById(R.id.btChangerAlphaMorse);
        if (toMorse.getVisibility() == View.VISIBLE) {
            toMorse.setVisibility(View.INVISIBLE);
            toAlpha.setVisibility(View.VISIBLE);
            chagerAlphaMorse.setText("Traduire le morse");
        } else {
            toAlpha.setVisibility(View.INVISIBLE);
            toMorse.setVisibility(View.VISIBLE);
            chagerAlphaMorse.setText("Traduire l\'alpha");
        }
    }

    /**
     *
     */
    public void alertAttention() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Attention !");
        builder.setMessage(
                "Utilisez seulement le point, le tiret, l\'espace \n " +
                        "et la barre pour écrire en morse.\n" +
                        "Toujours taper l'espace pour chaque code \n" +
                        "de lettre tapé, et une barre oblique \n" +
                        "pour marquer les espaces entre les mots.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener()

        {
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(MainActivity.this, "Entre votre code morse\n" + "ou une phrase alpha", Toast.LENGTH_SHORT).show();
            }
        });
        alert = builder.create();
        alert.show();
    }

    public void playMorse() {
        final EditText editTextMorse = (EditText) findViewById(R.id.editTextMorse);
        final MediaPlayer dah = MediaPlayer.create(this, R.raw.dah);
        final MediaPlayer dit = MediaPlayer.create(this, R.raw.dit);
        final MediaPlayer esp = MediaPlayer.create(this, R.raw.espace);
        String morse = editTextMorse.toString();
        System.out.println(morse.toString());
        final String[] morseToPlay = morse.split("");
        for (int i = 0; i < morseToPlay.length; i++) {
            if (morseToPlay[i].equals("."))
                dit.start();
            if (morseToPlay[i].equals("-"))
                dah.start();

            if (morseToPlay[i].equals(" "))
                esp.start();
            if (morseToPlay[i].equals("/")) {
                esp.start();
                esp.start();
            }

        }
    }

}
