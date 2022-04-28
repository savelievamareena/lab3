package jaxb.test;

import jaxb.model.Department;
import jaxb.model.Employee;
import jaxb.model.Organisation;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TestExample {

    private static final String XML_FILE = "dept-info.xml";

    public static void main(String[] args) {

        Employee emp1 = new Employee("E01", "Tom", null);
        Employee emp2 = new Employee("E02", "Mary", "E01");
        Employee emp3 = new Employee("E03", "John", null);

        List<Employee> list1 = new ArrayList<>();
        list1.add(emp1);
        list1.add(emp2);
        list1.add(emp3);

        Employee emp4 = new Employee("E04", "Nick", null);
        Employee emp5 = new Employee("E05", "David", "E04");
        Employee emp6 = new Employee("E06", "Robert", "E04");

        List<Employee> list2 = new ArrayList<>();
        list2.add(emp4);
        list2.add(emp5);
        list2.add(emp6);

        Employee emp7 = new Employee("E07", "Anna", null);
        Employee emp8 = new Employee("E08", "Alex", "E07");
        Employee emp9 = new Employee("E09", "Alice", "E07");

        List<Employee> list3 = new ArrayList<>();
        list3.add(emp7);
        list3.add(emp8);
        list3.add(emp9);

        Employee emp10 = new Employee("E10", "Vera", null);
        Employee emp11 = new Employee("E11", "Lisa", "E10");
        Employee emp12 = new Employee("E12", "Max", "E10");

        List<Employee> list4 = new ArrayList<>();
        list4.add(emp10);
        list4.add(emp11);
        list4.add(emp12);

        Department dept1 = new Department("D01", "ACCOUNTING 1", "NEW YORK");
        dept1.setEmployees(list1);
        Department dept2 = new Department("D02", "ACCOUNTING 2", "LOS ANGELES");
        dept2.setEmployees(list2);
        Department dept3 = new Department("D03", "ACCOUNTING 3", "PORTLAND");
        dept3.setEmployees(list3);
        Department dept4 = new Department("D04", "ACCOUNTING 4", "AUSTIN");
        dept4.setEmployees(list4);
        List<Department> depList1 = new ArrayList<>();
        depList1.add(dept1);
        depList1.add(dept2);
        depList1.add(dept3);
        depList1.add(dept4);

        Organisation org = new Organisation("SUPER DEVELOPMENT", "NCY93847", "STEWART GREEN");
        org.setDepartments(depList1);

        try {
            // create JAXB context and instantiate marshaller
            JAXBContext context = JAXBContext.newInstance(Organisation.class);

            // (1) Marshaller : Java Object to XML content.
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            m.marshal(org, System.out);

            // Write to File
            File outFile = new File(XML_FILE);
            m.marshal(org, outFile);

            System.err.println("Write to file: " + outFile.getAbsolutePath());
            // (2) Unmarshaller : Read XML content to Java Object.
            Unmarshaller um = context.createUnmarshaller();

            // XML file create before.

            Organisation orgFromFile1 = (Organisation) um.unmarshal(new FileReader(XML_FILE));
            List<Department> deps = orgFromFile1.getDepartments();
            for (Department dep : deps) {
                System.out.println("Department: " + dep.getDeptName());
                List<Employee> emps = dep.getEmployees();
                for (Employee emp : emps) {
                    System.out.println("Employee: " + emp.getEmpName());
                }
            }

        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
