package communicathon.forset.kapiure.login;

import android.util.Log;

import communicathon.forset.kapiure.models.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter  implements LoginContract.PresenterInterface, LoginContract.OnFinishedListener {

    private LoginContract.ViewInterface view;

    public LoginPresenter(LoginContract.ViewInterface view){
        this.view = view;
    }

    @Override
    public void onClickValidation(String username, String password) {
        User user = new User(username, password);
        try {
            user.vallidation();
            onFinished();
        } catch (Exception e) {
            view.validationFail(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onFinished() {
        view.validationSuccess();
    }

    @Override
    public void onFailure(Throwable t) {
        view.validationFail(t.getMessage());
    }
}
