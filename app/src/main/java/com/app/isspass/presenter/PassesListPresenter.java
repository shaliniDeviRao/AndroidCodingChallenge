package com.app.isspass.presenter;

import android.support.v4.util.ArrayMap;
import android.text.format.DateUtils;

import com.app.isspass.model.Data;
import com.app.isspass.service.ISSPassesService;
import com.app.isspass.view.PassRowView;
import com.app.isspass.view.PassesListView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * This class represents the passes view interface.
 */

public class PassesListPresenter {
    private PassesListView passesListView;
    private ISSPassesService issPassesService;
    List<com.app.isspass.model.Response> passesList;


    public PassesListPresenter(PassesListView view) {
        this.passesListView = view;

        if (this.issPassesService == null) {
            this.issPassesService = new ISSPassesService();
        }
    }

    public void getPasses(ArrayMap<String, String> params) {
        issPassesService
                .getAPI()
                .getPasses(params)
                .enqueue(new Callback<Data>() {
                    @Override
                    public void onResponse(Call<Data> call, Response<Data> response) {
                        Data data = response.body();

                        if (data != null && data.getResponse() != null) {
                            passesList = data.getResponse();
                            passesListView.passesReady();
                        }
                    }

                    @Override
                    public void onFailure(Call<Data> call, Throwable t) {
                        passesListView.onGetPassesFailed("Something went wrong!");
                    }
                });
    }

    public void onBindPassRowViewAtPosition(int position, PassRowView rowView) {
        com.app.isspass.model.Response pass = passesList.get(position);
        rowView.setDuration(String.valueOf(pass.getDuration()) + " Seconds");
        rowView.setRiseTime(pass.getRisetime());
    }

    public int getPassesRowsCount() {
        return passesList.size();
    }
}
