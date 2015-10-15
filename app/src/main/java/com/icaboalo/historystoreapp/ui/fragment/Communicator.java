package com.icaboalo.historystoreapp.ui.fragment;

import com.icaboalo.historystoreapp.domain.PlaceListModel;

import java.util.List;

/**
 * Created by icaboalo on 10/14/2015.
 */
public interface Communicator {
    void respond(List<PlaceListModel> placeList);
}
