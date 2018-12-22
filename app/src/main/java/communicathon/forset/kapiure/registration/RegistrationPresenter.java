package communicathon.forset.kapiure.registration;

import communicathon.forset.kapiure.models.UsersDatabase;
import communicathon.forset.kapiure.models.Users;


public class RegistrationPresenter  implements RegistrationContract.PresenterInterface, RegistrationContract.OnFinishedListener {

    private RegistrationContract.ViewInterface view;

    public RegistrationPresenter(RegistrationContract.ViewInterface view){
        this.view = view;
    }

    @Override
    public void onClickRegistration(String username, String password, UsersDatabase usersDatabase) {
        Users users = new Users(usersDatabase);
        try {
            users.registrationValidation(username, password);
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
