package org.example.mockito;

public class Login {

    public WebService webService;
    public boolean isLogin;

    public Login(WebService webService) {
        this.webService = webService;
        isLogin = false;
    }

    public void doLogin(){
        webService.login("Alberto", "12345", new Callback() {
            @Override
            public void onSuccess(String response) {

            }

            @Override
            public void onFail(String error) {

            }
        });
    }
}
