package com.example.shortnotes;

import androidx.cardview.widget.CardView;
import com.example.shortnotes.models.Notes;
//

public interface NotesClickListener {
      void onClick(Notes notes);
      void onLongClick(Notes notes , CardView cardView);

}
