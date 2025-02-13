package com.example.shortnotes;

import static com.example.shortnotes.R.layout.activity_notes_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.shortnotes.models.Notes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NotesTrackerActivity extends AppCompatActivity {
EditText editText_title, editText_notes;
ImageView imageView_save;
Notes notes;
boolean isOldNote = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_notes_tracker);
        editText_title = findViewById(R.id.editText_title);
        editText_notes = findViewById(R.id.editText_notes);
        imageView_save = findViewById(R.id.imageView_save);
        notes = new Notes();
        try{
            notes = (Notes) getIntent().getSerializableExtra("old_notes");

 editText_title.setText(notes.getTitle());
 editText_notes.setText(notes.getNotes());
 isOldNote = true;

        }
        catch(Exception e){
e.printStackTrace();
        }




        imageView_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
  String title = editText_title.getText().toString();
  String description = editText_notes.getText().toString();
  if (description.isEmpty()){
      Toast.makeText(NotesTrackerActivity.this, "please add some notes", Toast.LENGTH_SHORT).show();

  return ;

  }
                SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMM yyy HH:mm a");
  Date date = new Date();
if(!isOldNote){
    notes = new Notes();
}


  notes.setTitle(title);
  notes.setNotes(description);
  notes.setDate(formatter.format(date));
                Intent intent = new Intent();
                intent.putExtra("note",notes);
                setResult(Activity.RESULT_OK,intent);
                finish();


            }
        });

    }
}