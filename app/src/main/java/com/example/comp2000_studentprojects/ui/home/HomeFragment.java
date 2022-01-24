package com.example.comp2000_studentprojects.ui.home;

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
import com.example.comp2000_studentprojects.databinding.FragmentHomeBinding;
import com.example.comp2000_studentprojects.ui.gallery.GalleryFragment;
import com.google.android.material.snackbar.Snackbar;
import org.json.JSONObject;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    Button btnSubmit = (Button) findViewById(R.id.btnSubmitProject);
    btnSubmit.setOnClickListener(new View.OnClickListener()

    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Integer tempstudentId = findViewById(R.id.editStudentID);
                String tempTitle = findViewById(R.id.editTitle);
                String tempDescription = findViewById(R.id.editDescription);
                Integer tempYear = findViewById(R.id.editYear);
                String tempFirstName = findViewById(R.id.editFirstName);
                String tempLastName = findViewById(R.id.editLastName);

                String url = "web.socem.plymouth.ac.uk/COMP2000/api/students";
                JSONObject jsonObject = new JSONObject(Request.Method.POST, url, null,
                        new JSONObject(tempstudentId, tempTitle, tempDescription, tempYear, tempFirstName, tempLastName); try{
                    jsonObject.put("StudentID", tempstudentId);
                    jsonObject.put("Title", tempTitle);
                    jsonObject.put("Description", tempDescription);
                    jsonObject.put("Year", tempYear);
                    jsonObject.put("First Name", tempFirstName);
                    jsonObject.put("Last Name", tempLastName);
                        } catch (Exception e){
                    Toast.makeText(MainActivity.this,
                            "Error" + e,
                            Toast.LENGTH_LONG).show();
                },new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,
                                "Error" + error,
                                Toast.LENGTH_LONG).show();
                    }
                };
                queue.add(jsonObjectRequest);
                    }
                });

            }
}