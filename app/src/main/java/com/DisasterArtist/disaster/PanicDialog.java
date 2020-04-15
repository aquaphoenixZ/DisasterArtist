package com.DisasterArtist.disaster;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class PanicDialog extends DialogFragment {
    private static final String TAG = "PanicDialog";
    // layout elements
    private EditText name;
    private EditText phoneNumber;
    private EditText adress;
    private Button submit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_panic_contact, container, false);

        name = view.findViewById(R.id.dialog_name);
        phoneNumber = view.findViewById(R.id.dialog_phone_number);
        adress = view.findViewById(R.id.dialog_address);
        submit = view.findViewById(R.id.dialog_submit_button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Submit clicked. Closing dialog");
                getDialog().dismiss();
            }
        });

        return view;
    }
}
