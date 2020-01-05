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
public class A221 extends Fragment {


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
    private TextView timeend_221,timestart_221;
    public static int oneTimeOnly = 0;
    public A221() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a221, container, false);
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



        scrollView=view.findViewById(R.id.scrollView_A221);




        Typeface typeface=Typeface.createFromAsset( getActivity().getAssets(),"Avva_Shenouda.ttf" );
        TextView textView=view.findViewById( R.id.COPTIC_A221 );
        textView.setTypeface( typeface );

        chang_play(play,puse);



        FloatingActionButton play=view.findViewById(R.id.play_A221);
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

        FloatingActionButton puse=view.findViewById(R.id.puse_A221);
        puse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chang_play(true,false);
                mediaPlayer.pause();
            }
        });




        final TextView Ta=view.findViewById(R.id.ARAB_A221);
        final TextView TC=view.findViewById(R.id.COPTIC_A221);
        final TextView TCA=view.findViewById(R.id.Ca_A221);
        timestart_221 =view.findViewById(R.id.timestart_221);
        timeend_221 =view.findViewById(R.id.timeend_221);
        Spinner spinner=view.findViewById(R.id.spinner_A221);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (view != null) {


                    if (i == 0) {
                        Ta.setText(R.string.tengosht_A221a);
                        TC.setText(R.string.tengosht_A221c);
                        TCA.setText(R.string.tengosht_A221ca);

                        music=true;
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);
                                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.tengosht221);
                        seekBar.setMax(mediaPlayer.getDuration());

                        time(mediaPlayer);

                    } else if (i == 1) {
                        Ta.setText(R.string.salam_A221a);
                        TC.setText(R.string.salam_A221c);
                        TCA.setText(R.string.salam_A221ca);

                        music=true;
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);

                        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.salosalam);
                        seekBar.setMax(mediaPlayer.getDuration());
                        time(mediaPlayer);
                    } else if (i == 2) {
                        Ta.setText(R.string.heten_A221a);
                        TC.setText(R.string.heten_A221c);
                        TCA.setText( R.string.heten_A221ca);

                        music=true;
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);

                        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.hetenebresfia);
                        seekBar.setMax(mediaPlayer.getDuration());

                        time(mediaPlayer);
                    }
                    else if (i == 3) {
                        Ta.setText(R.string.mradat_A221a);
                        TC.setText(R.string.mrada_A221c);
                        TCA.setText(R.string.mrada_A221ca);

                        scrollView.smoothScrollTo(0, 0);

                        music=true;

                        mediaPlayer.stop();
                        chang_play(true,false);
                                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.anafora221);
                        seekBar.setMax(mediaPlayer.getDuration());

                        time(mediaPlayer);
                    }
                    else if (i == 4) {
                        Ta.setText(R.string.tenoosht_A221a);
                        TC.setText(R.string.tenoosht_A221c);
                        TCA.setText(R.string.tenoosht_A221ca);

                        music=true;
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);

                        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.tenoosht);
                        seekBar.setMax(mediaPlayer.getDuration());

                        time(mediaPlayer);
                    }

                    else if (i == 5) {
                        Ta.setText(R.string.osheakaraben_A221a);
                        TC.setText(R.string.osheakaraben_A221c);
                        TCA.setText(R.string.osheakaraben_A221ca);

                        music=true;
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);
                                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.kraben221);
                        seekBar.setMax(mediaPlayer.getDuration());
                        time(mediaPlayer);
                    }
                    else if (i == 6) {
                        Ta.setText(R.string.mokdemazokso_A221a);
                        TC.setText(R.string.mokdemazokso_A221c);
                        TCA.setText("                                          ");

                        music=true;
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);
                                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.mozofray7e221);
                        seekBar.setMax(mediaPlayer.getDuration());


                        time(mediaPlayer);
                    }
                    else if (i == 7) {
                        Ta.setText(R.string.m7ermelad_A221a);
                        TC.setText(R.string.m7ermelad_A221c);
                        TCA.setText(R.string.m7ermelad_A221ca);

                        scrollView.smoothScrollTo(0, 0);

                        music=true;
                        mediaPlayer.stop();
                        chang_play(true,false);
                                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.m7ermelad221);
                        seekBar.setMax(mediaPlayer.getDuration());


                        time(mediaPlayer);
                    }
                    else if (i == 8) {
                        Ta.setText(R.string.mrdengelbaker_A221a);
                        TC.setText(R.string.mrdengelbaker_A221c);
                        TCA.setText(R.string.mrdengelbaker_A221ca);

                        scrollView.smoothScrollTo(0, 0);

                        music=true;
                        mediaPlayer.stop();
                        chang_play(true,false);
                                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.mrdengel221);
                        seekBar.setMax(mediaPlayer.getDuration());
                        time(mediaPlayer);
                    }
                    else {
                        Ta.setText(R.string.mrdengelmelad_A221a);
                        TC.setText(R.string.mrdengelmelad_A221c);
                        TCA.setText(R.string.mrdengelmelad_A221ca);

                        music=true;
                        scrollView.smoothScrollTo(0, 0);

                        mediaPlayer.stop();
                        chang_play(true,false);
                             mediaPlayer = MediaPlayer.create(getActivity(), R.raw.mrdengelkdas221);
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
        seekBar=view.findViewById(R.id.seekBar_A221);

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
        FloatingActionButton Play=getView().findViewById(R.id.play_A221);
        FloatingActionButton Puse=getView().findViewById(R.id.puse_A221);

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

        timeend_221.setText(String.format("%d : %d",
                TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                finalTime)))
        );

        timestart_221.setText(String.format("%d : %d",
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
            timestart_221.setText(String.format("%d : %d",
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
