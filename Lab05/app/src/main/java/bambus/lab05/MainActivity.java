package bambus.lab05;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends Activity {

    EditText edName = null;
    EditText edLastName = null;
    EditText edPhoneNumber = null;
    EditText edNationality = null;

    ListView listView = null;
    ArrayList<PeopleList> people = new ArrayList<PeopleList>();
    //ArrayAdapter<PeopleList> adapter = null;
    MyAdapter adapter;

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private int selectedRadio;

    /*
    private String name;
    private String lastname;
    private int age;


    private TextView displayName;
    private TextView displayLastName;
    private TextView displayAge;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edName = (EditText) findViewById(R.id.name);
        edLastName = (EditText) findViewById(R.id.lastName);
        edPhoneNumber = (EditText) findViewById(R.id.phone);
        edNationality = (EditText) findViewById(R.id.nationality);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        listView = (ListView) findViewById(R.id.list);
        //adapter = new ArrayAdapter<PeopleList>(this, android.R.layout.simple_list_item_1, people);
        adapter = new MyAdapter(this, people);
        listView.setAdapter(adapter);

        Button create = (Button) findViewById(R.id.button);
        create.setOnClickListener(onClick);
    }

    private View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //readFieldsFromEditText();
            //readValueFromRadioButton();
            //display();
            onSave(view);
        }
    };

    /*
        private void readFieldsFromEditText() {
            EditText nameText = (EditText) findViewById(R.id.name);
            name = nameText.getText().toString();
            EditText lastnameText = (EditText) findViewById(R.id.lastName);
            lastname = lastnameText.getText().toString();
            EditText ageText = (EditText) findViewById(R.id.age);
            String ageString = ageText.getText().toString();
            age = Integer.parseInt(ageString);
        }

        private void readValueFromRadioButton() {
            selectedRadio = radioGroup.getCheckedRadioButtonId();
            radioButton = (RadioButton) findViewById(selectedRadio);
        }

        private void display() {
            displayName = (TextView) findViewById(R.id.displayName);
            displayLastName = (TextView) findViewById(R.id.displayLastName);
            displayAge = (TextView) findViewById(R.id.displayAge);
            displayName.setText("Name: " + name);
            displayLastName.setText("LastName: " + lastname);
            displayAge.setText("Age: " + age);
            ImageView image = (ImageView) findViewById(R.id.imageView2);
            if (radioButton.getText().equals("Kobieta")) {
                image.setImageResource(R.drawable.f);
                if (!name.endsWith("a")) {
                    Toast.makeText(getApplicationContext(), "Uwaga! Wpisano imię żeńskie nie kończące się literą A", Toast.LENGTH_LONG).show();
                }
            } else {
                image.setImageResource(R.drawable.m);
            }
        }
    */
    private void onSave(View v) {
        PeopleList people = new PeopleList();
        boolean isMale;
        people.setName(edName.getText().toString());
        people.setLastName(edLastName.getText().toString());
        people.setPhoneNumber(edPhoneNumber.getText().toString());
        people.setNationality(edNationality.getText().toString());

        selectedRadio = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedRadio);

        if (radioButton.getText().equals("Kobieta")) {
            isMale = false;
        } else {
            isMale = true;
        }
        people.setMale(isMale);

        adapter.add(people);
    }
}
