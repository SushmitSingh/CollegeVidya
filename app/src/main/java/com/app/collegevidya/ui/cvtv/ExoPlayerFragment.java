package com.app.collegevidya.ui.cvtv;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.app.collegevidya.databinding.FragmentExoPlayerBinding;
import com.app.collegevidya.ui.HomeActivity;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;


public class ExoPlayerFragment extends Fragment implements MediaPlayer.OnSeekCompleteListener, Player.Listener {
    private String url;
    private FragmentExoPlayerBinding binding;
    private Context mContext;

    public ExoPlayerFragment() {
        // Required empty public constructor
    }

    public static ExoPlayerFragment newInstance(String param1, String param2) {
        ExoPlayerFragment fragment = new ExoPlayerFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentExoPlayerBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Full Screen Fragment
        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        //Hide Bottom Nav
        ((HomeActivity) requireActivity()).closeBottomNav();

        if (getArguments() != null) {
            ExoPlayerFragmentArgs args = ExoPlayerFragmentArgs.fromBundle(getArguments());
            url = args.getUrl();
            Log.d("Url", url);
        }

        //Init ExoPlayer Video Player
        ExoPlayer simpleExoPlayer = new ExoPlayer.Builder(requireContext()).build();
        binding.playerView.setPlayer(simpleExoPlayer);
        MediaItem mediaItem = MediaItem.fromUri(url);
        simpleExoPlayer.addMediaItem(mediaItem);
        simpleExoPlayer.prepare();
        simpleExoPlayer.setPlayWhenReady(true);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        //Clear Flag For FullScreen Android
        getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        if (binding.playerView.getPlayer().isPlaying() == true) {
            binding.playerView.getPlayer().stop();
        }
        //Open Bottom Nav
        ((HomeActivity) requireActivity()).openBottomNav();
    }

    @Override
    public void onSeekComplete(MediaPlayer mp) {

    }
}