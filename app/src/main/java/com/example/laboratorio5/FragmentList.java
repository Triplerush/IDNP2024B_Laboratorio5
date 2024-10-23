package com.example.laboratorio5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class FragmentList extends Fragment {

    private static final String ARG_TITLE = "title";
    private static final String ARG_DESCRIPTION = "description";
    private static final String ARG_IMAGE = "image";
    private static final String ARG_CONTAINER_ID = "container_id";

    private String title;
    private String description;
    private int imageResource;
    private int containerId;

    public FragmentList() {
    }

    public static FragmentList newInstance(String title, String description, int imageResource, int containerId) {
        FragmentList fragment = new FragmentList();
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
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        TextView titleTextView = view.findViewById(R.id.textView_title);
        titleTextView.setText(title);

        ImageView imageView = view.findViewById(R.id.imageView);
        imageView.setImageResource(imageResource); // Establecer la imagen

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentDescription fragmentDescription = FragmentDescription.newInstance(title, description, imageResource, containerId);
                getParentFragmentManager().beginTransaction()
                        .replace(containerId, fragmentDescription)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }
}
