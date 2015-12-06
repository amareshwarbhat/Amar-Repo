package app.widas.com.widas.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.widas.com.widas.R;

/**
 * Created by Amar on 11-Nov-15.
 */
public class FreeConsultationFragment extends Fragment {
    private View view;
    private EditText txtEmail;
    private EditText txtPhone;
    private EditText txt_post;
    private Button buttonSubmit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_freeconsultation, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        txtEmail = (EditText) view.findViewById(R.id.txt_email);
        txtPhone = (EditText) view.findViewById(R.id.txt_phone);
        txt_post = (EditText) view.findViewById(R.id.txt_post);
        buttonSubmit = (Button) view.findViewById(R.id.button_submit);


        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validatePhoneNumber(txtPhone) &&
                        validateEmail(txtEmail)) {
                    sendPost();
                } else {
                    Toast.makeText(getActivity(), "Emial or Password is incorrect", Toast.LENGTH_SHORT).show();
                }
            }


        });
    }

    private void sendPost() {

        Log.i("Send email", "");
        String posttext = txt_post.getText().toString();
        String postnum = txtPhone.getText().toString();
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", "amareshwarbhat@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "FeedBack");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Phone No: " + postnum + "  " + posttext);
        startActivity(Intent.createChooser(emailIntent, "Send email..."));

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            getActivity().finish();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(view.getContext(), "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }

    }

    private boolean validateEmail(EditText txtEmail) {
        boolean isEmail;
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(txtEmail.getText().toString()).matches() || txtEmail.getText().toString().isEmpty()) {
            txtEmail.setError("Invalid Email");
            isEmail = false;

        } else {
            isEmail = true;
        }
        return isEmail;
    }

    private boolean validatePhoneNumber(EditText txtPhone) {
        boolean isPhone;
        if (txtPhone.getText().toString().isEmpty() || txtPhone.getText().toString().length() != 10) {
            txtPhone.setError("Invalid Phone Number");
            isPhone = false;
        } else {
            isPhone = true;
        }

        return isPhone;
    }

}
