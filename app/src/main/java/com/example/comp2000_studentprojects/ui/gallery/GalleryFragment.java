package com.example.comp2000_studentprojects.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.comp2000_studentprojects.MainActivity;
import com.example.comp2000_studentprojects.R;
import com.example.comp2000_studentprojects.databinding.FragmentGalleryBinding;
import org.json.JSONObject;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    Button btnSubmit = (Button) findViewById(R.id.btnProjectView);
    btnSubmit.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View v)
        {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String url = "web.socem.plymouth.ac.uk/COMP2000/api/students";
                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject studentProjects) {
                            @Override
                            public void onResponse (JsonObject studentProjects){
                                findViewById(R.id.txtViewProjects).setText(response.toString());
                            },new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error){
                                    Toast.makeText(GalleryFragment.this, "Error", Toast.LENGTH_LONG).show();
                                }
                            };
                        }
                    }

                }
            });
        }
    }
}