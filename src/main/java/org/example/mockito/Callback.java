package org.example.mockito;

public interface Callback {

    void onSuccess(String response);
    void onFail(String error);
}
