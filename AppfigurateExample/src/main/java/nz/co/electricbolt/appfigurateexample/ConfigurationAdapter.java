// ConfigurationAdapter.dart
// AppfigurateExample Copyright © 2018; Electric Bolt Limited.

package nz.co.electricbolt.appfigurateexample;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Locale;

import nz.co.electricbolt.appfiguratelibrary.Appfigurate;
import nz.co.electricbolt.appfiguratelibrary.Configuration;

class ConfigurationAdapter extends Adapter<ConfigurationAdapter.ViewHolder> {

    private final ExampleConfiguration config;

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView label;
        TextView value;

        ViewHolder(View v) {
            super(v);
            label = v.findViewById(R.id.label);
            value = v.findViewById(R.id.value);
        }
    }

    ConfigurationAdapter() {
        config = (ExampleConfiguration) Configuration.sharedConfiguration();
    }

    @NonNull
    @Override
    public ConfigurationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.configuration_view, parent, false);
        return new ViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ConfigurationAdapter.ViewHolder holder, int position) {
        switch (position) {
            case 0:
                holder.label.setText("bool");
                holder.value.setText("" + config.bool);
                break;
            case 1:
                holder.label.setText("string_Textfield");
                holder.value.setText(config.string_Textfield);
                break;
            case 2:
                holder.label.setText("string_RegexTextfield");
                holder.value.setText(config.getString_RegexTextfield());
                break;
            case 3:
                holder.label.setText("string_List");
                holder.value.setText(config.string_List);
                break;
            case 4:
                holder.label.setText("string_Textfield_List");
                holder.value.setText(config.string_Textfield_List);
                break;
            case 5:
                holder.label.setText("string_RegexTextfield_List");
                holder.value.setText(config.string_RegexTextfield_List);
                break;
            case 6:
                holder.label.setText("encrypted_string_Textfield_List");
                holder.value.setText(config.encrypted_string_Textfield_List);
                break;
            case 7:
                holder.label.setText("encrypted_string_RegexTextfield_List");
                holder.value.setText(config.encrypted_string_RegexTextfield_List);
                break;
            case 8:
                holder.label.setText("integer_Slider");
                holder.value.setText("" + config.integer_Slider);
                break;
            case 9:
                holder.label.setText("integer_Textfield");
                holder.value.setText("" + config.integer_Textfield);
                break;
            case 10:
                holder.label.setText("integer_RegexTextfield");
                holder.value.setText("" + config.integer_RegexTextfield);
                break;
            case 11:
                holder.label.setText("integer_List");
                holder.value.setText("" + config.integer_List);
                break;
            case 12:
                holder.label.setText("integer_Textfield_List");
                holder.value.setText("" + config.integer_Textfield_List);
                break;
            case 13:
                holder.label.setText("integer_RegexTextfield_List");
                holder.value.setText("" + config.integer_RegexTextfield_List);
                break;
            case 14:
                holder.label.setText("float_Slider");
                holder.value.setText(String.format(Locale.US, "%.3f", config.float_Slider));
                break;
            case 15:
                holder.label.setText("float_Textfield");
                holder.value.setText(String.format(Locale.US, "%.3f", config.float_Textfield));
                break;
            case 16:
                holder.label.setText("float_RegexTextfield");
                holder.value.setText(String.format(Locale.US, "%.3f", config.float_RegexTextfield));
                break;
            case 17:
                holder.label.setText("float_List");
                holder.value.setText(String.format(Locale.US, "%.3f", config.float_List));
                break;
            case 18:
                holder.label.setText("float_Textfield_List");
                holder.value.setText(String.format(Locale.US, "%.3f", config.float_Textfield_List));
                break;
            case 19:
                holder.label.setText("float_RegexTextfield_List");
                holder.value.setText(String.format(Locale.US, "%.3f", config.float_RegexTextfield_List));
                break;
            case 20:
                holder.label.setText("double_Slider");
                holder.value.setText(String.format(Locale.US, "%.3f", config.double_Slider));
                break;
            case 21:
                holder.label.setText("double_Textfield");
                holder.value.setText(String.format(Locale.US, "%.3f", config.double_Textfield));
                break;
            case 22:
                holder.label.setText("double_RegexTextfield");
                holder.value.setText(String.format(Locale.US, "%.3f", config.double_RegexTextfield));
                break;
            case 23:
                holder.label.setText("double_List");
                holder.value.setText(String.format(Locale.US, "%.3f", config.double_List));
                break;
            case 24:
                holder.label.setText("double_Textfield_List");
                holder.value.setText(String.format(Locale.US, "%.3f", config.double_Textfield_List));
                break;
            case 25:
                holder.label.setText("double_RegexTextfield_List");
                holder.value.setText(String.format(Locale.US, "%.3f", config.double_RegexTextfield_List));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 26;
    }

}
