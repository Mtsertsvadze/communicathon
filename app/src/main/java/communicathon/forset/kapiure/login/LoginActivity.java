package communicathon.forset.kapiure.login;

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

import communicathon.forset.kapiure.MainActivity;
import communicathon.forset.kapiure.R;
import communicathon.forset.kapiure.models.UsersDatabase;
import communicathon.forset.kapiure.models.Users;
import communicathon.forset.kapiure.registration.RegistrationActivity;

public class LoginActivity extends AppCompatActivity implements LoginContract.ViewInterface {
    EditText ETusername;
    EditText ETpassword;

    ConstraintLayout CLlogin;
    Button Blogin;
    Button BRegistration;

    LoginPresenter loginPresenter;

    private Context context;
    private Users users;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        context = this;
        final UsersDatabase usersDatabase =  UsersDatabase.getDatabase(context);

        ETusername = findViewById(R.id.login_username);
        ETpassword = findViewById(R.id.login_password);
        Blogin = findViewById(R.id.login_button);
        BRegistration = findViewById(R.id.registration_button);
        CLlogin = findViewById(R.id.login_layout);

//        CLlogin.setBackgroundResource(R.drawable.cmp2);


        ETusername.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    v.setOutlineAmbientShadowColor(getColor(R.color.colorAccent));
                }
            }
        });

        loginPresenter = new LoginPresenter(this);

        Blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.onClickValidation(ETusername.getText().toString(), ETpassword.getText().toString(), usersDatabase);
            }
        });
        BRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void validationSuccess() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void validationFail(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        ETpassword.setText("");
    }
}
