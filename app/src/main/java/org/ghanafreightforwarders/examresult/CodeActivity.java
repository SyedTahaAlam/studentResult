package org.ghanafreightforwarders.examresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.ghanafreightforwarders.examresult.Model.Certificate.Datum;

public class CodeActivity extends AppCompatActivity {

    EditText code;
    String codestr;
    private Button generateResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);
        code = findViewById(R.id.secretcode);
        generateResult = findViewById(R.id.generateresult);
        generateResult.setOnClickListener(v -> {
            if (!code.getText().toString().isEmpty()) {
                codestr = code.getText().toString().trim();
                if (getIntent() != null) {
                    Bundle bundle = getIntent().getExtras();
                    switch (bundle.getInt("type")) {
                        case 1:

                            checkCode((org.ghanafreightforwarders.examresult.Model.Diploma.Datum) bundle.getSerializable("bodydata"));

                            Log.e("certificate", bundle.getSerializable("bodydata").toString());
                            break;
                        case 2:

                            checkCode((Datum) bundle.getSerializable("bodydata"));

                            Log.e("certificate", bundle.getSerializable("bodydata").toString());
                            break;
                        case 3:
                            checkCode((Datum) bundle.getSerializable("bodydata"));

                            Log.e("certificate", bundle.getSerializable("bodydata").toString());
                            break;
                    }

                }
            } else {
                Toast.makeText(CodeActivity.this, "No Code Is Entered", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void checkCode(org.ghanafreightforwarders.examresult.Model.HigherDiploma.Datum bodydata) {
        if (bodydata.getSecretCode().equalsIgnoreCase(codestr)) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("bodydata", bodydata);
            bundle.putInt("type", 3);
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
            finish();

        } else {
            Toast.makeText(this, "Code Doesn\'t match", Toast.LENGTH_SHORT).show();
        }

    }

    private void checkCode(Datum bodydata) {
        if (bodydata.getSecretCode().equalsIgnoreCase(codestr)) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("bodydata", bodydata);
            bundle.putInt("type", 2);
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
            finish();

        } else {
            Toast.makeText(this, "Code Doesn\'t match", Toast.LENGTH_SHORT).show();
        }
    }

    private void checkCode(org.ghanafreightforwarders.examresult.Model.Diploma.Datum bodydata) {
        if (bodydata.getSecretCode().equalsIgnoreCase(codestr)) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("bodydata", bodydata);
            bundle.putInt("type", 1);
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
            finish();

        } else {
            Toast.makeText(this, "Code Doesn\'t match", Toast.LENGTH_SHORT).show();
        }
    }

}
