package com.core;

import com.domain.Staff;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

public class GsonExample1 {

    public static void main(String[] args) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        List<Staff> staff = createStaffList();

        try (FileWriter writer = new FileWriter("json/student.json")) {
            gson.toJson(staff, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Staff> createStaffList() {

        Staff staff1 = new Staff();

        staff1.setName("oleg");
        staff1.setAge(35);
        staff1.setPosition(new String[]{"Founder", "SEO", "coder"});
        Map<String, BigDecimal> salary1 = new HashMap<String, BigDecimal>() {{
            put("2010", new BigDecimal(10000));
            put("2012", new BigDecimal(12000));
            put("2018", new BigDecimal(14000));
        }};
        staff1.setSalary(salary1);
        staff1.setSkills(Arrays.asList("java", "python", "node", "kotlin"));

        Staff staff2 = new Staff();

        staff2.setName("alex");
        staff2.setAge(33);
        staff2.setPosition(new String[]{"Founder", "STO", "fullstack-developer"});
        Map<String, BigDecimal> salary2 = new HashMap<String, BigDecimal>() {{
            put("2020", new BigDecimal(4000));
            put("2021", new BigDecimal(5000));
            put("2022", new BigDecimal(6000));
        }};
        staff2.setSalary(salary2);
        staff2.setSkills(Arrays.asList("java", "c++", "js", "php"));

        List<Staff> staffList = new ArrayList<>();
        staffList.add(staff1);
        staffList.add(staff2);

        return staffList;
    }
}