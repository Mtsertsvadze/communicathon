package communicathon.forset.kapiure.login;

import communicathon.forset.kapiure.models.User;
import communicathon.forset.kapiure.models.UsersDatabase;
import communicathon.forset.kapiure.models.users;

public class LoginPresenter  implements LoginContract.PresenterInterface, LoginContract.OnFinishedListener {

    private LoginContract.ViewInterface view;



    public LoginPresenter(LoginContract.ViewInterface view){
        this.view = view;
    }

    @Override
    public void onClickValidation(String username, String password, UsersDatabase usersDatabase) {
        users users = new users(usersDatabase);
        try {
            users.loginVallidation(username, password);
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
