package com.noname.ch06example1room;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDatabase = MyDatabase.getInstance(this);
        new QueryStudentTask().execute(); // 更新UI需要在子线程中执行，直接用Android提供的AsyncTask很方便
    }

    class QueryStudentTask extends AsyncTask<Void, Void, Void> {
        public QueryStudentTask() {

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            myDatabase.studentDao().insertStudent(new Student("lsg", 33));
            myDatabase.studentDao().insertStudent(new Student("wr", 44));
            myDatabase.studentDao().insertStudent(new Student("jack", 55));
            myDatabase.studentDao().insertStudent(new Student("rose", 66));
            // myDatabase.studentDao().updateStudent(new Student(1,"lsg", 33));
            List<Student> students = myDatabase.studentDao().getStudentList();
            for (Student student : students) {
                Log.d("Student: ", student.toString());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // studentAdapter.notifyDataSetChanged();
        }
    }
}