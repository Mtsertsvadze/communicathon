package communicathon.forset.kapiure.registration;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

import communicathon.forset.kapiure.MainActivity;
import communicathon.forset.kapiure.R;
import communicathon.forset.kapiure.models.UsersDatabase;
import communicathon.forset.kapiure.models.Users;

public class RegistrationActivity  extends AppCompatActivity implements RegistrationContract.ViewInterface{
    EditText ETusername;
    EditText ETpassword;
    EditText ETmail;

    ConstraintLayout CLlogin;
    Button BRegistration;

    private Context context;
    private Users users;
    private UsersDatabase usersDatabase;

    RegistrationPresenter registrationPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registration);

        context = this;
        usersDatabase =  UsersDatabase.getDatabase(context);


        ETusername = findViewById(R.id.registration_username);
        ETpassword = findViewById(R.id.registration_password);
        ETmail = findViewById(R.id.registration_mail);
        BRegistration = findViewById(R.id.register_button);
        CLlogin = findViewById(R.id.login_layout);

        ETusername.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    v.setOutlineAmbientShadowColor(getColor(R.color.colorAccent));
                }
            }
        });

        registrationPresenter = new RegistrationPresenter(this);

        BRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrationPresenter.onClickRegistration(ETusername.getText().toString(), ETpassword.getText().toString(), usersDatabase);
            }
        });

    }

    @Override
    public void validationSuccess() {
        users = new Users(usersDatabase);
        users.addUser(ETusername.getText().toString(), ETpassword.getText().toString());
        Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void validationFail(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        ETpassword.setText("");
    }
}
