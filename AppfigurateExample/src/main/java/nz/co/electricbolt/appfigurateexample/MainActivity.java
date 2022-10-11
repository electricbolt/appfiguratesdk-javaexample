// MainActivity.dart
// AppfigurateExample Copyright © 2018; Electric Bolt Limited.

package nz.co.electricbolt.appfigurateexample;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import nz.co.electricbolt.appfiguratelibrary.Appfigurate;
import nz.co.electricbolt.appfiguratelibrary.ConfigurationLabel;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter<ConfigurationAdapter.ViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("Debug build? " + BuildConfig.DEBUG);

        setContentView(R.layout.activity_main);
        this.setTitle("Java Example " + Appfigurate.version());

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ConfigurationAdapter();
        recyclerView.setAdapter(adapter);

        Appfigurate.addConfigurationUpdatedListener((String action) -> {
            if (action != null) {
                System.out.println("Configuration updated by action " + action);
            } else {
                System.out.println("Configuration updated");
            }
            adapter.notifyDataSetChanged();
        });

        ConfigurationLabel configurationLabel = findViewById(R.id.configuration_label);
        configurationLabel.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Java Example").setMessage("Label clicked")
                    .setPositiveButton("OK", (dialog, id) -> {
                    });
            AlertDialog dialog = builder.create();
            dialog.show();
        });
    }

}
