package com.app.isspass.view;

import com.app.isspass.model.Response;

import java.util.List;

/**
 * This class represents the pass view interface.
 */

public interface PassesListView {
    void passesReady();
    void onGetPassesFailed(String message);
}
