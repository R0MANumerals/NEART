package com.neart.tup.neart;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tutor_FragmentNotification extends Fragment {


    public static Tutor_FragmentNotification newInstance() {
        Tutor_FragmentNotification fragment = new Tutor_FragmentNotification();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tutee_fragment_notification, container, false);
    }

    /**
     * A simple {@link Fragment} subclass.
     */
    public static class Tutor_FragmentMore extends Fragment {



        public static Tutor_FragmentMore newInstance() {
            Tutor_FragmentMore fragment = new Tutor_FragmentMore();

      return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.tutee_fragment_more, container, false);
        }
    }
}