package ca.ualberta.andromeda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class DatePickerCode extends AppCompatActivity {

//    DatePickerCode datePicker;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_date_picker);
//
//        /*Add in Oncreate() funtion after setContentView()*/
//
//
//        DatePickerCode datePicker = (DatePickerCode) findViewById(R.id.datePicker); // initiate a date picker
//        int day = datePicker.getDayOfMonth(); // get the selected day of the month
//        int month = datePicker.getMonth(); // get the selected month
//        int year = datePicker.getYear(); // get the selected year
//
//    }
    DatePicker simpleDatePickerCode;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initiate the date picker and a button
        simpleDatePickerCode = (DatePicker) findViewById(R.id.datePicker);
        save = (Button) findViewById(R.id.SaveButton);
        // perform click event on submit button
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get the values for day of month , month and year from a date picker
                String day = "Day = " + simpleDatePickerCode.getDayOfMonth();
                String month = "Month = " + (simpleDatePickerCode.getMonth() + 1);
                String year = "Year = " + simpleDatePickerCode.getYear();
                // display the values by using a toast
                System.out.println(day);
                System.out.println(month);
                System.out.println(year);


            }
        });

    }
}
