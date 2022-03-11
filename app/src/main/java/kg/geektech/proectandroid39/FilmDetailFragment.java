package kg.geektech.proectandroid39;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kg.geektech.proectandroid39.data.models.Film;
import kg.geektech.proectandroid39.databinding.FragmentFilmDetailBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmDetailFragment extends Fragment {

    private FragmentFilmDetailBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      binding = FragmentFilmDetailBinding.inflate(getLayoutInflater());

        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String id = getArguments().getString("id");
        App.api.getFilmById(id).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                binding.tvTitle.setText(response.body().getTitle());
                binding.tvDescription.setText(response.body().getDescription());
                binding.tvProducer.setText(response.body().getProducer());
                binding.tvOriginalTitle.setText(response.body().getOriginalTitle());
                binding.tvDirector.setText(response.body().getDirector());
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {

            }
        });
    }
}