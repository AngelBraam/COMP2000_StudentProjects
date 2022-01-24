package com.example.comp2000_studentprojects.ui.slideshow;

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
import com.example.comp2000_studentprojects.databinding.FragmentSlideshowBinding;
import org.json.JSONObject;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    Button btnDelete = (Button) findViewByID(R.id.btnDelete);
    Button btnUpdate = (Button) findViewById(R.id.btnProjectView);
    btnUpdate.setOnClickListener(new View.OnClickListener()
    {
        public void onClick(View v)
        {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Integer tempstudentId = findViewById(R.id.editStudentIDUD);
                    String tempTitle = findViewById(R.id.editProjectTitleUD);
                    String tempDescription = findViewById(R.id.editProjectDescriptionUD);
                    Integer tempYear = findViewById(R.id.editProjectYearUD);
                    String tempFirstName = findViewById(R.id.editFirstNameUD);
                    String tempLastName = findViewById(R.id.editLastNameUD);

                    String url = "web.socem.plymouth.ac.uk/COMP2000/api/students/{id}";
                    JSONObject jsonObject = new JSONObject(Request.Method.PUT, url, null,
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
                    }new Response.ErrorListener() {
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
}