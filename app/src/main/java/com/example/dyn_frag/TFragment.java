package com.example.dyn_frag;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class TFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate( R.layout.activity_main2, container, false );

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated( view, savedInstanceState );

        TextView ft = view.findViewById(R.id.Frag_Text );
        int seconds = getArguments().getInt("seconds");
        ft.setText("seconds are " +  seconds);
    }

    public static TFragment newInstance(int seconds) {
        TFragment tf = new TFragment();
        Bundle args = new Bundle();
        args.putInt( "seconds", seconds );
        tf.setArguments(args);
        return tf;
    }
}
