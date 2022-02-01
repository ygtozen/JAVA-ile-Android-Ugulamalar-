package com.example.googlemap4;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.googlemap4.Models.MapPojo;
import com.example.googlemap4.RestApi.ManagerAll;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private float lat = 34.5f, lot = 21.3f;
    private String title = "merhaba";
    SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        istek();
    }

    public void istek()
    {
        Call<MapPojo> servis = ManagerAll.getOurInstance().harita();
        servis.enqueue(new Callback<MapPojo>() {
            @Override
            public void onResponse(Call<MapPojo> call, Response<MapPojo> response) {
                if (response.isSuccessful())
                {
                    lat = Float.parseFloat(response.body().getLat().toString());
                    lot = Float.parseFloat(response.body().getLot().toString());
                    title = response.body().getTitle().toString();
                    Log.i("gelen bilgiler",response.body().toString());
                    mapFragment.getMapAsync(MapsActivity.this);
                }
            }

            @Override
            public void onFailure(Call<MapPojo> call, Throwable t) {

            }
        });
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(lat,lot);
        mMap.addMarker(new MarkerOptions().position(sydney).title(title));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}