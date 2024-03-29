package com.example.level2.Taks;


import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.level2.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


/**
 * A simple {@link Fragment} subclass.
 */
public class Taks_1 extends Fragment {
    private AdView mAdView;

    public static PDFView pdfView;
    Button Kbar,Sgar;
    public Taks_1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_taks_1, container, false);
    }
    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {


        super.onViewCreated(view, savedInstanceState);

        MobileAds.initialize(getContext(),
                "ca-app-pub-9066719717930706~4474257123");

        mAdView = view.findViewById(R.id.adViewcoptic23);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        pdfView=view.findViewById(R.id.pdfView_T21);
        pdfView.fromAsset("taks21.pdf").load();

        Kbar =view.findViewById(R.id.btk1);
        Sgar =view.findViewById(R.id.btp1);
        Sgar.setBackgroundColor(getResources().getColor(R.color.Safaf3));
        Kbar.setBackgroundColor(getResources().getColor(R.color.shafaf22));

        Kbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pdfView.fromAsset("taks21.pdf").load();
                Sgar.setBackgroundColor(getResources().getColor(R.color.Safaf3));
                Kbar.setBackgroundColor(getResources().getColor(R.color.shafaf22));
            }
        });

        Sgar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pdfView.fromAsset("taks21p.pdf").load();
                Sgar.setBackgroundColor(getResources().getColor(R.color.shafaf22));
                Kbar.setBackgroundColor(getResources().getColor(R.color.Safaf3));
            }
        });

    }
}
