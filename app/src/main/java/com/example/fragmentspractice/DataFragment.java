package com.example.fragmentspractice;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DataFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DataFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;
    ArrayList<dataModel> dataHolder;

    public DataFragment() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DataFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DataFragment newInstance(String param1, String param2) {
        DataFragment fragment = new DataFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_data, container, false);
        recyclerView =view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        dataHolder = new ArrayList<dataModel>();
        dataModel ob1=new dataModel(R.drawable.angular,"Angular","Web Application");
        dataHolder.add(ob1);

        dataModel ob2=new dataModel(R.drawable.cp,"C Programming","Embed Programming");
        dataHolder.add(ob2);

        dataModel ob3=new dataModel(R.drawable.cpp,"C++ Programming","Embed Programming");
        dataHolder.add(ob3);

        dataModel ob4=new dataModel(R.drawable.dotnet,".NET Programming","Desktop and Web Programming");
        dataHolder.add(ob4);

        dataModel ob5=new dataModel(R.drawable.java,"Java Programming","Desktop and Web Programming");
        dataHolder.add(ob5);

        dataModel ob6=new dataModel(R.drawable.magento,"Magento","Web Application Framework");
        dataHolder.add(ob6);

        dataModel ob7=new dataModel(R.drawable.nodejs,"NodeJS","Web Application Framework");
        dataHolder.add(ob7);

        dataModel ob8=new dataModel(R.drawable.python,"Python","Desktop and Web Programming");
        dataHolder.add(ob8);

        dataModel ob9=new dataModel(R.drawable.shopify,"Shopify","E-Commerce Framework");
        dataHolder.add(ob9);

        dataModel ob10=new dataModel(R.drawable.wordpress,"Wordpress","WebApplication Framewrok");
        dataHolder.add(ob10);

        recyclerView.setAdapter(new myadapter(dataHolder));

        return view;
    }

}