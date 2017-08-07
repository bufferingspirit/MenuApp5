package com.example.admin.menuapp5;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Admin on 8/6/2017.
 */

public class Web extends android.support.v4.app.Fragment {
    View view;
    WebView wv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_menu_web, container, false);
        wv = (WebView) view.findViewById(R.id.webView);

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(savedInstanceState != null)
            wv.restoreState(savedInstanceState);
        else{
            wv.setWebViewClient(new WebViewClient());
            wv.loadUrl("http://www.google.com");
        }

        getActivity().setTitle("Web");

    }

    /*@Override
    public void onSaveInstanceState(Bundle outState) {
        wv.saveState(outState);
    }*/
}