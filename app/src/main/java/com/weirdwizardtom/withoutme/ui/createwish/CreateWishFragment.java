package com.weirdwizardtom.withoutme.ui.createwish;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.weirdwizardtom.withoutme.R;

import org.w3c.dom.Text;

public class CreateWishFragment extends Fragment {

    private CreateWishViewModel createWishViewModel;

    private TextInputLayout nameTextInputLayout;
    private TextInputLayout descriptionTextInputLayout;

    private Button saveButton;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.create_wish_fragment, container, false);

        nameTextInputLayout = root.findViewById(R.id.create_wish_name_textinput);
        descriptionTextInputLayout = root.findViewById(R.id.create_wish_description_textinput);

        saveButton = root.findViewById(R.id.create_wish_save_button);
        saveButton.setOnClickListener(v -> {
            String name = nameTextInputLayout.getEditText().getText().toString();
            String description = descriptionTextInputLayout.getEditText().getText().toString();
            if (name.isEmpty()) {
                nameTextInputLayout.setError("Name cannot be empty");
            } else {
                createWishViewModel.addWish(name, description);
                getParentFragmentManager().popBackStack();
            }

        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        createWishViewModel = new ViewModelProvider(this).get(CreateWishViewModel.class);
    }

}