package communicathon.forset.kapiure.login;

public interface LoginContract {
    public interface PresenterInterface{
        void onClickValidation(String username, String password);

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
