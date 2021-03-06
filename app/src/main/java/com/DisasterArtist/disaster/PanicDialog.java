package com.DisasterArtist.disaster;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.DisasterArtist.disaster.core.OnPromptPanicDialog;

public class PanicDialog extends DialogFragment {
    private static final String TAG = "PanicDialog";
    private OnPromptPanicDialog submitPanicInfo;
    // layout elements
    private EditText name;
    private EditText phoneNumber;
    private EditText address;
    private Button submit;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_panic_contact, container, false);

        name = view.findViewById(R.id.dialog_name);
        phoneNumber = view.findViewById(R.id.dialog_phone_number);
        address = view.findViewById(R.id.dialog_address);
        submit = view.findViewById(R.id.dialog_submit_button);

        preferences = getActivity().getSharedPreferences("Saved info & settings", Context.MODE_PRIVATE);
        editor = preferences.edit();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO change submitPanicInfo for actual values
                Log.d(TAG,"Submit clicked. Closing dialog");
                if(name.getText().toString().trim().length() == 0 || phoneNumber.getText().toString().trim().length() == 0 || address.getText().toString().trim().length() == 0){
                    Toast.makeText(getContext(), R.string.field_not_filled, Toast.LENGTH_SHORT).show();
                }
                else {
                    editor.putString("Contact Name", String.valueOf(name.getText()));
                    editor.putString("Contact Phone number", String.valueOf(phoneNumber.getText()));
                    editor.putString("Contact Address", String.valueOf(address.getText()));
                    editor.apply();
                    submitPanicInfo.submitPanicInfo("Robert", "Av De Niro", " 666");
                    getDialog().dismiss();
                }
            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        submitPanicInfo = (OnPromptPanicDialog) context;
    }
}
