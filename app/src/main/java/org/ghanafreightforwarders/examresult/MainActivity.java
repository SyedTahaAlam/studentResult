package org.ghanafreightforwarders.examresult;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.ghanafreightforwarders.examresult.HttpRequest.Services;
import org.ghanafreightforwarders.examresult.HttpRequest.Utils;
import org.ghanafreightforwarders.examresult.Model.Certificate.Certificate;
import org.ghanafreightforwarders.examresult.Model.Certificate.Datum;
import org.ghanafreightforwarders.examresult.Model.Diploma.Diploma;
import org.ghanafreightforwarders.examresult.Model.HigherDiploma.HigherDiploma;
import org.ghanafreightforwarders.examresult.Utils.NetworkUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MenuItem.OnMenuItemClickListener{

private TextView selectcourse;
private EditText enterStd;
    private EditText code;

private Button generateResult;
private Services mAPIService;
private ProgressDialog dialog;

private int selected;
    private String[] mCoursesName = new String[]{"Diploma", "Higher Diploma"
            ,"Certificate"
            };
//    Spinner spinner;

    public void init(){
        selectcourse=findViewById(R.id.selectcourse);
        code = findViewById(R.id.secretcode);
        enterStd=findViewById(R.id.enterstudent);
        enterStd.setText("");
        generateResult=findViewById(R.id.generateresult);
        mAPIService = Utils.getAPIService();
        selectcourse.setText(getResources().getString(R.string.select_course));
//        spinner = findViewById(R.id.spinner);
        dialog=new ProgressDialog(this);
        dialog.setTitle("Requesting...");

    }

    @Override
    protected void onResume() {
        super.onResume();
        enterStd.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


        generateResult.setOnClickListener(v->{
            if (!enterStd.getText().toString().equals("")) {
                if (!selectcourse.getText().equals(getResources().getString(R.string.select_course))) {
                    if (NetworkUtil.isConnectedToInternet(MainActivity.this) ){
                        dialog.show();
                        switch(selected){
                            case 0:
                                getDiploma(enterStd.getText().toString());
                                break;


                            case 1:
                                getHigherDiploma(enterStd.getText().toString());

                                break;

                            case 2:
                                getCertificate(enterStd.getText().toString());
                                break;

                        }}else{
                        NetworkUtil.showNoInternetAvailableErrorDialog(MainActivity.this);
                    }
                } else {
                    Toast.makeText(this, "Please Select A Course", Toast.LENGTH_SHORT).show();

                }
            } else {
                Toast.makeText(this, "Student Number Is Empty", Toast.LENGTH_SHORT).show();
            }
//            switch(selected){
//                case R.id.diploma:
//                getDiploma(enterStd.getText().toString());
//                break;
//
//
//                case R.id.Higher_Diploma:
//                    getHigherDiploma(enterStd.getText().toString());
//
//                    break;
//
//                case R.id.certificate:
//                    getCertificate(enterStd.getText().toString());
//                    break;
//
//            }

        });
        selectcourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialog();
            }
});

    }

    private void getHigherDiploma(String mStudentNumber) {
        mAPIService.getInformationOfHigherDiplomaResult(mStudentNumber).enqueue(new Callback<HigherDiploma>() {

            @Override
            public void onResponse(Call<HigherDiploma> call, Response<HigherDiploma> response) {
                if(response.isSuccessful()) {
                    dialog.dismiss();
                    if (response.body().getData().size() == 0) {
                        Toast.makeText(MainActivity.this, "No User Found", Toast.LENGTH_SHORT).show();

                    }
                    checkActivity(response.body());
                    dialog.dismiss();
                }
                else{
                    dialog.dismiss();

                    Toast.makeText(MainActivity.this, "Your Request Can not be Completed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<HigherDiploma> call, Throwable t) {
                dialog.dismiss();

                Toast.makeText(MainActivity.this, "Your Request Can not be Completed", Toast.LENGTH_SHORT).show();


            }
        });
    }


    private void getCertificate(String mStudentNumber) {
        mAPIService.getCertificate(mStudentNumber).enqueue(new Callback<Certificate>() {

            @Override
            public void onResponse(Call<Certificate> call, Response<Certificate> response) {
                if(response.isSuccessful()) {
                    if (response.body().getData().size() == 0) {
                        Toast.makeText(MainActivity.this, "No User Found", Toast.LENGTH_SHORT).show();

                    }
                    checkActivity(response.body());
                    dialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<Certificate> call, Throwable t) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "Your Request Can not be Completed", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void checkActivity(Certificate body) {
        if (body.getData().size() > 0) {
            Datum bodydata = body.getData().get(0);
            if (bodydata.getIsActive().equals("n")) {
                showInformationDialog();
            } else {
                Bundle bundle = new Bundle();
                bundle.putSerializable("bodydata", bodydata);
                bundle.putInt("type", 3);
                Intent intent = new Intent(this, CodeActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        }
    }

    private void showInformationDialog() {
        AlertDialog alertDialog = new AlertDialog.Builder(
                MainActivity.this).create();


        alertDialog.setMessage(getResources().getString(R.string.alert_dialog_message));


        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                alertDialog.dismiss();
            }
        });


        alertDialog.show();
    }

    private void checkActivity(HigherDiploma body) {
        if (body.getData().size() > 0) {
            org.ghanafreightforwarders.examresult.Model.HigherDiploma.Datum bodydata = body.getData().get(0);
            if (bodydata.getIsActive().equals("n")) {
                showInformationDialog();
            } else {
                Bundle bundle = new Bundle();
                bundle.putSerializable("bodydata", bodydata);
                bundle.putInt("type", 2);
                Intent intent = new Intent(this, CodeActivity.class);

                intent.putExtras(bundle);
                startActivity(intent);
            }
        }
    }

    private void checkActivity(Diploma body) {
        if (body.getData().size() > 0) {
            org.ghanafreightforwarders.examresult.Model.Diploma.Datum bodydata = body.getData().get(0);
            if (bodydata.getIsActive().equals("n")) {
                showInformationDialog();
            } else {
                Bundle bundle = new Bundle();
                bundle.putSerializable("bodydata", bodydata);
                bundle.putInt("type", 1);
                Intent intent = new Intent(this, CodeActivity.class);

                intent.putExtras(bundle);
                startActivity(intent);
            }
        }
    }

    private void getDiploma(String mStudentNumber) {



        mAPIService.getInformationOfDiplomaResult(mStudentNumber).enqueue(new Callback<Diploma>() {

            @Override
            public void onResponse(Call<Diploma> call, Response<Diploma> response) {
                if(response.isSuccessful()) {
                    if (response.body().getData().size() == 0) {
                        Toast.makeText(MainActivity.this, "No User Found", Toast.LENGTH_SHORT).show();

                    }
                    checkActivity(response.body());
                    dialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<Diploma> call, Throwable t) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "Your Request Can not be Completed", Toast.LENGTH_SHORT).show();

            }
        });
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }

    public void showDialog(){

        final Dialog dialog = new Dialog(MainActivity.this);
        // dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_list);


        ListView listView = dialog.findViewById(R.id.listview);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.list_item, R.id.tv, mCoursesName);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectcourse.setText(mCoursesName[position]);
                selected=position;
                dialog.dismiss();
            }
        });

        dialog.show();

    }


}
