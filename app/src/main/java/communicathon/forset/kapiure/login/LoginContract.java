package communicathon.forset.kapiure.login;

import communicathon.forset.kapiure.models.UsersDatabase;

public interface LoginContract {
    public interface PresenterInterface{
        void onClickValidation(String username, String password, UsersDatabase usersDatabase);

    }
    public interface ViewInterface{
        void validationSuccess();
        void validationFail(String text);
    }

    interface OnFinishedListener {
        void onFinished();
        void onFailure(Throwable t);
    }
}
