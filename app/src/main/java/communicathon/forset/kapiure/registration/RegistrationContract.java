package communicathon.forset.kapiure.registration;

import communicathon.forset.kapiure.models.UsersDatabase;

public interface RegistrationContract {
    public interface PresenterInterface{
        void onClickRegistration(String username, String password, UsersDatabase usersDatabase);
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
