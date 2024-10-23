package com.example.laboratorio5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class FragmentDescription extends Fragment {

    private static final String ARG_TITLE = "title";
    private static final String ARG_DESCRIPTION = "description";
    private static final String ARG_IMAGE = "image";
    private static final String ARG_CONTAINER_ID = "container_id";

    private String title;
    private String description;
    private int imageResource;
    private int containerId;

    public FragmentDescription() {
    }

    public static FragmentDescription newInstance(String title, String description, int imageResource, int containerId) {
        FragmentDescription fragment = new FragmentDescription();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putString(ARG_DESCRIPTION, description);
        args.putInt(ARG_IMAGE, imageResource);
        args.putInt(ARG_CONTAINER_ID, containerId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_TITLE);
            description = getArguments().getString(ARG_DESCRIPTION);
            imageResource = getArguments().getInt(ARG_IMAGE);
            containerId = getArguments().getInt(ARG_CONTAINER_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_description, container, false);

        TextView titleTextView = view.findViewById(R.id.textView_title);
        TextView descriptionTextView = view.findViewById(R.id.textView_description);
        ImageView imageView = view.findViewById(R.id.imageView);

        titleTextView.setText(title);
        descriptionTextView.setText(description);
        imageView.setImageResource(imageResource);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction()
                        .replace(containerId, FragmentList.newInstance(
                                title,
                                description,
                                imageResource,
                                containerId))
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }
}
