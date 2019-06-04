package com.example.studentresult.Model.HigherDiploma;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HigherDiploma {


    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "HigherDiploma{" +
                "success=" + success +
                ", data=" + data.toString() +
                '}';
    }
}