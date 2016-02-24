package seminarski.hci.pomak.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import seminarski.hci.pomak.R;

public class ServiceFragment extends Fragment {


    public ServiceFragment() {
        // Required empty public constructor
    }

    public static ServiceFragment getInstance(int position) {
        ServiceFragment fragment = new ServiceFragment();
        Bundle args=new Bundle();
        args.putInt("position",position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_service, container, false);
    }

}
