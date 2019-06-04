package com.example.studentresult;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studentresult.HttpRequest.Services;
import com.example.studentresult.HttpRequest.Utils;
import com.example.studentresult.Model.Certificate.Certificate;
import com.example.studentresult.Model.Certificate.Datum;
import com.example.studentresult.Model.Diploma.Diploma;
import com.example.studentresult.Model.HigherDiploma.HigherDiploma;
import com.example.studentresult.Utils.NetworkUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MenuItem.OnMenuItemClickListener{

private TextView selectcourse;
private EditText enterStd;
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
        enterStd=findViewById(R.id.enterstudent);
        generateResult=findViewById(R.id.generateresult);
        mAPIService = Utils.getAPIService();
        selectcourse.setText("Select Result");
//        spinner = findViewById(R.id.spinner);
        dialog=new ProgressDialog(this);
        dialog.setTitle("Requesting...");

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        
        
        
        generateResult.setOnClickListener(v->{
            if (!enterStd.getText().toString().equals(""))
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
//        PopupMenu dropDownMenu = new PopupMenu(getApplicationContext(),selectcourse);
//        dropDownMenu.getMenuInflater().inflate(R.menu.drop_down_menu, dropDownMenu.getMenu());
//        selectcourse.setText("Select Result");
//        dropDownMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//
//            @Override
//            public boolean onMenuItemClick(MenuItem menuItem) {
//                selectcourse.setText(menuItem.getTitle());
//                selected=menuItem.getItemId();
//                return true;
//            }
//        });
//        dropDownMenu.show();
        showDialog();
    }
});
//
//spinner.setOnItemClickListener(this);
//        List<String> categories = new ArrayList<String>();
//        categories.add("Item 1");
//        categories.add("Item 2");
//        categories.add("Item 3");
//        categories.add("Item 4");
//        categories.add("Item 5");
//        categories.add("Item 6");
//
//        // Creating adapter for spinner
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
//
//        // Drop down layout style - list view with radio button
//        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        // attaching data adapter to spinner
//        spinner.setAdapter(dataAdapter);

    }

    private void getHigherDiploma(String mStudentNumber) {
        mAPIService.getInformationOfHigherDiplomaResult(mStudentNumber).enqueue(new Callback<HigherDiploma>() {

            @Override
            public void onResponse(Call<HigherDiploma> call, Response<HigherDiploma> response) {
                if(response.isSuccessful()) {
                    dialog.dismiss();
                    Log.i("result", "post submitted to API." + response.body().toString());
                    checkActivity(response.body());
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

                    Log.i("result", "post submitted to API." + response.body().toString());
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
                Intent intent = new Intent(this, SecondActivity.class);
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
            com.example.studentresult.Model.HigherDiploma.Datum bodydata = body.getData().get(0);
            if (bodydata.getIsActive().equals("n")) {
                showInformationDialog();
            } else {
                Bundle bundle = new Bundle();
                bundle.putSerializable("bodydata", bodydata);
                bundle.putInt("type", 2);
                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        }
    }

    private void checkActivity(Diploma body) {
        if (body.getData().size() > 0) {
            com.example.studentresult.Model.Diploma.Datum bodydata = body.getData().get(0);
            if (bodydata.getIsActive().equals("n")) {
                showInformationDialog();
            } else {
                Bundle bundle = new Bundle();
                bundle.putSerializable("bodydata", bodydata);
                bundle.putInt("type", 1);
                Intent intent = new Intent(this, SecondActivity.class);
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
                    dialog.dismiss();
                    checkActivity(response.body());
                    Log.i("result", "post submitted to API." + response.body().toString());
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
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_list);


        ListView listView = (ListView) dialog.findViewById(R.id.listview);
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
