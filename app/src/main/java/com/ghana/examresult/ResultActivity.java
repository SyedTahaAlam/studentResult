package com.ghana.examresult;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.ghana.examresult.Model.Diploma.Datum;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {

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
                    inflateDiploma((Datum) bundle.getSerializable("bodydata"));

                    Log.e("certificate", bundle.getSerializable("bodydata").toString());
                    break;
                case 3:
                    setContentView(R.layout.result_higher_diploma);
                    inflateHigherDiploma((com.ghana.examresult.Model.HigherDiploma.Datum) bundle.getSerializable("bodydata"));

                    Log.e("certificate", bundle.getSerializable("bodydata").toString());
                    break;
                case 2:
                    setContentView(R.layout.result_certificate_item);
                    inflateCertificate((com.ghana.examresult.Model.Certificate.Datum) bundle.getSerializable("bodydata"));

                    Log.e("certificate", bundle.getSerializable("bodydata").toString());
                    break;
            }

        }

    }

    private void inflateHigherDiploma(com.ghana.examresult.Model.HigherDiploma.Datum bodydata) {
        TextView name = findViewById(R.id.nhd);
        TextView no = findViewById(R.id.nohd);
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
        TextView financial = findViewById(R.id.financial);
        TextView pc = findViewById(R.id.phd);

        name.setText(bodydata.getStudentName());
        name.setOnClickListener(v -> showDialog(name.getText().toString()));
        no.setText(bodydata.getStudentNumber());
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
        financial.setText(bodydata.getFinancialManagement().toString());

        double percentage = ((bodydata.getProcurementManagement()
                + bodydata.getStrategicManagement()
                + bodydata.getProductionAndOperational()
                + bodydata.getInternationalTransportManagement()
                + bodydata.getSupplyChainManagement()
                + bodydata.getGlobalMarketing()
                + bodydata.getBusinessLaw()
                + bodydata.getHumanResourcesManagement()
                + bodydata.getResearchMethodology()
                + bodydata.getEntrepreneurCreativity()
                + bodydata.getGlobalMarketing()
                + bodydata.getFinancialManagement()) / 1200d) * 100d;
        DecimalFormat numberFormat = new DecimalFormat("#.000");

        pc.setText(String.valueOf(numberFormat.format(percentage)));
    }

    private void inflateDiploma(Datum bodydata) {
        TextView name = findViewById(R.id.nd);
        TextView no = findViewById(R.id.nod);
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
        TextView pc = findViewById(R.id.pd);

        name.setText(bodydata.getStudentName());

        no.setText(bodydata.getStudentNumber());
        name.setOnClickListener(v -> showDialog(name.getText().toString()));
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

        double percentage = ((bodydata.getRoadTransport()
                + bodydata.getIntroToFf()
                + bodydata.getMaritimeTransport()
                + bodydata.getMultimodalTransport()
                + bodydata.getSeaContainers()
                + bodydata.getAirTransport()
                + bodydata.getRailTransport()
                + bodydata.getInlandWaterwayTransport()
                + bodydata.getCustomsProcedures()
                + bodydata.getLogisticsAndWarehousing()
                + bodydata.getTransportInsurance()
                + bodydata.getDangerousGoods()
                + bodydata.getIctInForwarding()
                + bodydata.getSafetyAndSecurity()) / 1400d) * 100d;
        DecimalFormat numberFormat = new DecimalFormat("#.000");

        pc.setText(String.valueOf(numberFormat.format(percentage)));
    }

    private void inflateCertificate(com.ghana.examresult.Model.Certificate.Datum bodydata) {
        TextView name = findViewById(R.id.student_name);
        TextView no = findViewById(R.id.student_number);
        TextView ff = findViewById(R.id.intro_to_ff);
        TextView logistics = findViewById(R.id.intro_to_logistics);
        TextView business = findViewById(R.id.business_communication);
        TextView transport = findViewById(R.id.intro_to_transportation);
        TextView custom = findViewById(R.id.intro_custom_procedure);
        TextView stats = findViewById(R.id.stats);
        TextView pc = findViewById(R.id.pc);


        name.setText(bodydata.getStudentName());
        name.setOnClickListener(v -> showDialog(name.getText().toString()));
        no.setText(bodydata.getStudentNumber());
        ff.setText(bodydata.getIntroToFf().toString());
        logistics.setText(bodydata.getIntroToLogistics().toString());
        business.setText(bodydata.getBusinessCommunication().toString());
        transport.setText(bodydata.getIntroToTransportation().toString());
        custom.setText(bodydata.getIntroToCustomsProcedures().toString());
        stats.setText(bodydata.getStatisticsAndBm().toString());
        double percentage = ((bodydata.getIntroToFf()
                + bodydata.getIntroToLogistics()
                + bodydata.getBusinessCommunication()
                + bodydata.getIntroToTransportation()
                + bodydata.getIntroToCustomsProcedures()
                + bodydata.getStatisticsAndBm()) / 600d) * 100d;
        DecimalFormat numberFormat = new DecimalFormat("#.000");

        pc.setText(String.valueOf(numberFormat.format(percentage)));
    }

    public void showDialog(String name) {

        final Dialog dialog = new Dialog(ResultActivity.this);
        // dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        dialog.setContentView(R.layout.activity_second);


        TextView nameView = dialog.findViewById(R.id.name);
        nameView.setText(name);

        dialog.show();

    }
}
