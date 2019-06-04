package com.example.studentresult.HttpRequest;

import com.example.studentresult.Model.Certificate.Certificate;
import com.example.studentresult.Model.Diploma.Diploma;
import com.example.studentresult.Model.HigherDiploma.HigherDiploma;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Services {
    @GET("/student_app_admin/app_api/fetch_diploma.php")
    Call<Diploma> getInformationOfDiplomaResult(@Query("student_number") String student_number);


    @GET("/student_app_admin/app_api/fetch_higher_diploma.php")
    Call<HigherDiploma> getInformationOfHigherDiplomaResult(@Query("student_number") String student_number);


    @GET("/student_app_admin/app_api/fetch_certificate.php")
    Call<Certificate> getCertificate(@Query("student_number") String student_number);


}
