package com.example.studentresult;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.studentresult.Model.Certificate.Datum;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (==3){
//            setContentView(R.layout.result_certificate_item);
//            inflateCertificate((Datum) bundle.getSerializable("bodydata"));
//
//            Log.e("certificate",bundle.getSerializable("bodydata").toString());
//        }
//        if (bundle.getInt("type")==3){
//            setContentView(R.layout.result_certificate_item);
//            inflateCertificate((Datum) bundle.getSerializable("bodydata"));
//
//            Log.e("certificate",bundle.getSerializable("bodydata").toString());
//        }

        if (getIntent() != null) {
            Bundle bundle = getIntent().getExtras();
            switch (bundle.getInt("type")) {
                case 1:
                    setContentView(R.layout.result_diploma);
                    inflateDiploma((com.example.studentresult.Model.Diploma.Datum) bundle.getSerializable("bodydata"));

                    Log.e("certificate", bundle.getSerializable("bodydata").toString());
                    break;
                case 2:
                    setContentView(R.layout.result_higher_diploma);
                    inflateHigherDiploma((com.example.studentresult.Model.HigherDiploma.Datum) bundle.getSerializable("bodydata"));

                    Log.e("certificate", bundle.getSerializable("bodydata").toString());
                    break;
            }
        }

    }

    private void inflateHigherDiploma(com.example.studentresult.Model.HigherDiploma.Datum bodydata) {
        TextView name = findViewById(R.id.student_name);
        TextView no = findViewById(R.id.student_number);
        TextView procedure = findViewById(R.id.manage);
        TextView startegy = findViewById(R.id.strategy);
        TextView operation = findViewById(R.id.operational);
        TextView internal = findViewById(R.id.international);
        TextView suply = findViewById(R.id.chain);
        TextView global = findViewById(R.id.global);
        TextView bussiness = findViewById(R.id.law);
        TextView hr = findViewById(R.id.Hr);
        TextView research = findViewById(R.id.Methodology);
        TextView creative = findViewById(R.id.creative);


        name.setText(bodydata.getStudentName());
        no.setText(bodydata.getId().toString());
        procedure.setText(bodydata.getProcurementManagement().toString());
        startegy.setText(bodydata.getStrategicManagement().toString());
        operation.setText(bodydata.getProductionAndOperational().toString());
        internal.setText(bodydata.getInternationalTransportManagement().toString());
        suply.setText(bodydata.getSupplyChainManagement().toString());
        global.setText(bodydata.getGlobalMarketing().toString());
        bussiness.setText(bodydata.getBusinessLaw().toString());
        hr.setText(bodydata.getHumanResourcesManagement().toString());
        research.setText(bodydata.getResearchMethodology().toString());
        creative.setText(bodydata.getEntrepreneurCreativity().toString());
        global.setText(bodydata.getGlobalMarketing().toString());

    }

    private void inflateDiploma(com.example.studentresult.Model.Diploma.Datum bodydata) {
        TextView name = findViewById(R.id.student_name);
        TextView no = findViewById(R.id.student_number);
        TextView ff = findViewById(R.id.ff);
        TextView maritime = findViewById(R.id.maritime);
        TextView multimodel = findViewById(R.id.multimodel);
        TextView sea = findViewById(R.id.sea);
        TextView air = findViewById(R.id.air);
        TextView road = findViewById(R.id.road);
        TextView rail = findViewById(R.id.rail);
        TextView inland = findViewById(R.id.inland);
        TextView custom = findViewById(R.id.custom);
        TextView logistics = findViewById(R.id.logistics);
        TextView insure = findViewById(R.id.insure);
        TextView danger = findViewById(R.id.danger);
        TextView forwarding = findViewById(R.id.forwarding);
        TextView security = findViewById(R.id.security);

        name.setText(bodydata.getStudentName());
        no.setText(bodydata.getId().toString());
        ff.setText(bodydata.getIntroToFf().toString());
        maritime.setText(bodydata.getMaritimeTransport().toString());
        multimodel.setText(bodydata.getMultimodalTransport().toString());
        sea.setText(bodydata.getSeaContainers().toString());
        air.setText(bodydata.getAirTransport().toString());
        road.setText(bodydata.getRoadTransport().toString());
        rail.setText(bodydata.getRailTransport().toString());
        inland.setText(bodydata.getInlandWaterwayTransport().toString());
        custom.setText(bodydata.getCustomsProcedures().toString());
        logistics.setText(bodydata.getLogisticsAndWarehousing().toString());
        insure.setText(bodydata.getTransportInsurance().toString());
        danger.setText(bodydata.getDangerousGoods().toString());
        forwarding.setText(bodydata.getIctInForwarding().toString());
        security.setText(bodydata.getSafetyAndSecurity().toString());
    }

    private void inflateCertificate(Datum bodydata) {
        TextView name = findViewById(R.id.student_name);
        TextView no = findViewById(R.id.student_number);
        TextView ff = findViewById(R.id.intro_to_ff);
        TextView logistics = findViewById(R.id.intro_to_logistics);
        TextView business = findViewById(R.id.business_communication);
        TextView transport = findViewById(R.id.intro_to_transportation);
        TextView custom = findViewById(R.id.intro_custom_procedure);
        TextView stats = findViewById(R.id.stats);


        name.setText(bodydata.getStudentName());
        no.setText(bodydata.getId().toString());
        ff.setText(bodydata.getIntroToFf().toString());
        logistics.setText(bodydata.getIntroToLogistics().toString());
        business.setText(bodydata.getBusinessCommunication().toString());
        transport.setText(bodydata.getIntroToTransportation().toString());
        custom.setText(bodydata.getIntroToCustomsProcedures().toString());
        stats.setText(bodydata.getStatisticsAndBm().toString());

    }
}
