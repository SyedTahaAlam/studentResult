package org.ghanafreightforwarders.examresult.HttpRequest;

import org.ghanafreightforwarders.examresult.Model.Certificate.Certificate;
import org.ghanafreightforwarders.examresult.Model.Diploma.Diploma;
import org.ghanafreightforwarders.examresult.Model.HigherDiploma.HigherDiploma;

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
