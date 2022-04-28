package com.core;

import com.domain.Staff;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.*;

public class GsonExample2 {

    public static void main(String[] args) {

        Gson gson = new Gson();

        try (Reader reader = new FileReader("json/student.json")) {

//            Staff staff = gson.fromJson(reader, Staff.class); не подходит больше, потому что сейчас у нас лист
            Type listOfMyClassObject = new TypeToken<ArrayList<Staff>>() {}.getType(); //нашла способ на https://www.baeldung.com/gson-list
            List<Staff> staffList = gson.fromJson(reader, listOfMyClassObject);

            for (Staff employee: staffList) {
                System.out.println(employee.getName());
                System.out.println(employee.getAge());
                System.out.println(Arrays.toString(employee.getPosition()));
                System.out.println(employee.getSkills());
                System.out.println(employee.getSalary());
                System.out.println("---------");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
