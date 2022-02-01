package com.example.veterineruygulamasi.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.veterineruygulamasi.Adapters.PetsAdapter;
import com.example.veterineruygulamasi.Models.PetModel;
import com.example.veterineruygulamasi.R;
import com.example.veterineruygulamasi.RestApi.ManagerAll;
import com.example.veterineruygulamasi.Utils.ChangeFragment;
import com.example.veterineruygulamasi.Utils.GetSharedPreferences;
import com.example.veterineruygulamasi.Utils.Warnings;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserPetsFragment extends Fragment {

    private View view;
    private RecyclerView pet_rv;
    private PetsAdapter petsAdapter;
    private List<PetModel> petList;
    private ChangeFragment changeFragment;
    private String mus_id;
    private GetSharedPreferences sharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_user_pets, container, false);

        tanimla();
        istek(mus_id);

        return view;
    }

    public void tanimla()
    {
        petList = new ArrayList<>();
        changeFragment = new ChangeFragment(getContext());

        pet_rv = view.findViewById(R.id.pet_rv);
        RecyclerView.LayoutManager manager = new GridLayoutManager(getContext(),1);
        pet_rv.setLayoutManager(manager);

        sharedPreferences = new GetSharedPreferences(getActivity());
        mus_id = sharedPreferences.getSession().getString("id",null);
    }

    public void istek(String mus_id)
    {
        Call<List<PetModel>> servis = ManagerAll.getOurInstance().getPets(mus_id);
        servis.enqueue(new Callback<List<PetModel>>() {
            @Override
            public void onResponse(Call<List<PetModel>> call, Response<List<PetModel>> response) {
                //Log.i("petlistesi",response.body().toString());
                if (response.body().get(0).isTf())
                {
                    petList = response.body();
                    petsAdapter = new PetsAdapter(petList,getContext());
                    pet_rv.setAdapter(petsAdapter);

                    Toast.makeText(getContext(),"Sistemede kayıtlı "+petList.size()+" petiniz bulunmaktadır."
                            ,Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getContext(),"Sistemde kayıtlı petiniz bulunmamaktadır."
                    ,Toast.LENGTH_LONG).show();
                    changeFragment.change(new HomeFragment());
                }
            }

            @Override
            public void onFailure(Call<List<PetModel>> call, Throwable t) {
                Toast.makeText(getContext(), Warnings.internetProblemText,Toast.LENGTH_LONG).show();
            }
        });
    }
}