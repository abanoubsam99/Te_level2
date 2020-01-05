package com.example.level2.Al7an;


import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.level2.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.concurrent.TimeUnit;


/**
 * A simple {@link Fragment} subclass.
 */
public class A212 extends Fragment {

    boolean play=true;
    boolean puse=false;
    private AdView mAdView;

    boolean music=true;

    public static ScrollView scrollView;

    SeekBar seekBar;
    int fprograss;
    public static   MediaPlayer mediaPlayer=new MediaPlayer();

    public static double startTime = 0;
    private double finalTime = 0;
    private Handler myHandler = new Handler();
    private TextView timeend_212,timestart_212;
    public static int oneTimeOnly = 0;
    public A212() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a212, container, false);
    }
    @SuppressLint("RestrictedApi")
    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        MobileAds.initialize(getContext(),
                "ca-app-pub-9066719717930706~4474257123");

        mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        scrollView=view.findViewById(R.id.scrollView_A212);


        Typeface typeface=Typeface.createFromAsset( getActivity().getAssets(),"Avva_Shenouda.ttf" );
        TextView textView=view.findViewById( R.id.COPTIC_A212);
        textView.setTypeface( typeface );

        chang_play(play,puse);



        FloatingActionButton play=view.findViewById(R.id.play_A212);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chang_play(false,true);

                if (music==true){
                    mediaPlayer.start();
                }
                else {
                    Toast.makeText(getActivity(), " لم يتم اضافة صوت هذا اللحن ", Toast.LENGTH_SHORT).show();
                    chang_play(true,false);
                }
            }
        });

        FloatingActionButton puse=view.findViewById(R.id.puse_A212);
        puse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chang_play(true,false);
                mediaPlayer.pause();
            }
        });




        final TextView Ta=view.findViewById(R.id.ARAB_A212);
        final TextView TC=view.findViewById(R.id.COPTIC_A212);
        final TextView TCA=view.findViewById(R.id.Ca_A212);
        timestart_212 =view.findViewById(R.id.timestart_212);
        timeend_212 =view.findViewById(R.id.timeend_212);
        Spinner spinner=view.findViewById(R.id.spinner_A212);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (view != null) {


                    if (i == 0) {
                        Ta.setText(R.string.genaynan_A211a);
                        TC.setText(R.string.genaynan_A211c);
                        TCA.setText(R.string.genaynan_A211ca);

                        music=true;
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);

                        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.genaynan212);
                        seekBar.setMax(mediaPlayer.getDuration());


                        time(mediaPlayer);
                    } else if (i == 1) {
                        Ta.setText(R.string.mazmor150_A212a);
                        TC.setText(R.string.mazmor150_A212c);
                        TCA.setText(R.string.mazmor150_A212ca);

                        music=true;
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);
                                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.tawze3212);
                        seekBar.setMax(mediaPlayer.getDuration());
                        time(mediaPlayer);
                    } else if (i == 2) {
                        Ta.setText(R.string.salawatsom_A212a);
                        TC.setText(R.string.salawatsom_A212c);
                        TCA.setText(R.string.salawatsom_A212ca);

                        music=true;
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);

                        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.lastsalayounan);
                        seekBar.setMax(mediaPlayer.getDuration());

                        time(mediaPlayer);
                    }
                    else if (i == 3) {
                        Ta.setText(R.string.mrdketa3_A212a);
                        TC.setText(R.string.mrdketa3_A212c);
                        TCA.setText(R.string.mrdketa3_A212ca);

                        music=true;
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);

                        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.keta39);
                        seekBar.setMax(mediaPlayer.getDuration());

                        time(mediaPlayer);
                    }
                    else if (i == 4) {
                        Ta.setText(R.string.m7er_A212a);
                        TC.setText(R.string.m7er_A212c);
                        TCA.setText(R.string.m7er_A212ca);

                        music=true;

                        mediaPlayer.stop();
                        chang_play(true,false);
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.m7era7ed);
                        seekBar.setMax(mediaPlayer.getDuration());

                        time(mediaPlayer);
                    }
                    else if (i ==5) {
                        Ta.setText(R.string.mosafren_A212a);
                        TC.setText(R.string.mosafren_A212c);
                        TCA.setText(R.string.mosafren_A212ca);

                        music=true;
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);

                        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.osheamosafer);
                        seekBar.setMax(mediaPlayer.getDuration());

                        time(mediaPlayer);
                    }
                    else {
                        Ta.setText(R.string.beneshte_A212a);
                        TC.setText(R.string.beneshte_A212c);
                        TCA.setText(R.string.beneshte_A211ca);

                        music=true;
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);

                        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.beneshty);
                        seekBar.setMax(mediaPlayer.getDuration());
                        time(mediaPlayer);
                    }




                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        try {
            mediaPlayer = MediaPlayer.create(getActivity(), R.raw.oniti_a011);
            mediaPlayer.prepare();
        } catch (Exception e) {
            e.printStackTrace();
        }
        seekBar=view.findViewById(R.id.seekBar_A212);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromuser) {
                fprograss=progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(fprograss);
            }
        });


    }







    @SuppressLint("RestrictedApi")
    public void chang_play(boolean play, boolean puse){
        FloatingActionButton Play=getView().findViewById(R.id.play_A212);
        FloatingActionButton Puse=getView().findViewById(R.id.puse_A212);

        if(puse==false&&play==true){
            Play.setVisibility(View.VISIBLE);
            Puse.setVisibility(View.INVISIBLE);
        }
        else if (puse==true&&play==false){
            Play.setVisibility(View.INVISIBLE);
            Puse.setVisibility(View.VISIBLE);
        }
    }



    private void  time (MediaPlayer media){

        finalTime = media.getDuration();
        startTime = media.getCurrentPosition();
        if (oneTimeOnly == 0) {
            seekBar.setMax((int) finalTime);
            oneTimeOnly = 1;
        }

        timeend_212.setText(String.format("%d : %d",
                TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                finalTime)))
        );

        timestart_212.setText(String.format("%d : %d",
                TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                startTime)))
        );

        seekBar.setProgress((int) startTime);
        myHandler.postDelayed(UpdateSongTime,100);

    }


    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            startTime = mediaPlayer.getCurrentPosition();
            timestart_212.setText(String.format("%d : %d",
                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                    toMinutes((long) startTime)))
            );
            seekBar.setProgress((int)startTime);
            myHandler.postDelayed(this, 100);


        }
    };

}
