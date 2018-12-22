package communicathon.forset.kapiure.models;

public class ModelContract {
    public interface UserInterface {
        String getUsername();
        String getPpassword();
        void vallidation() throws Exception;
    }
}
