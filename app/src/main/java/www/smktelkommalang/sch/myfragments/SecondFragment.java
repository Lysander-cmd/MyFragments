package www.smktelkommalang.sch.myfragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SecondFragment extends Fragment {

    private PageViewModel pageViewModel;
    private TextView txtName;
    private TextView txtNumber;
    private TextView txtAddress;

    public SecondFragment() {
        // Required empty public constructor
    }

    public static SecondFragment newInstance() {
        return new SecondFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pageViewModel = ViewModelProviders.of(requireActivity()).get(PageViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_second_fragment, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        txtName = view.findViewById(R.id.textViewName);
        pageViewModel.getName().observe(requireActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                txtName.setText(s);
            }
        });
        txtNumber = view.findViewById(R.id.textViewNumber);
        pageViewModel.getNumber().observe(requireActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                txtNumber.setText(s);
            }
        });
        txtAddress = view.findViewById(R.id.textViewAddress);
        pageViewModel.getAddress().observe(requireActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                txtAddress.setText(s);
            }
        });
    }
}