package jaxb.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "organisation")
@XmlAccessorType(XmlAccessType.FIELD)
public class Organisation {

    private String orgTitle;
    private String regNumber;
    private String orgHead;

    @XmlElementWrapper(name = "departments")
    @XmlElement(name = "department")
    private List<Department> departments;

    public Organisation() {

    }

    public Organisation(String orgTitle, String regNumber, String orgHead) {
        this.orgTitle = orgTitle;
        this.regNumber = regNumber;
        this.orgHead = orgHead;
    }

    public void setOrgTitle(String orgTitle) {
        this.orgTitle = orgTitle;
    }

    public void setErgNumber(String ergNumber) {
        this.regNumber = ergNumber;
    }

    public void setOrgHead(String orgHead) {
        this.orgHead = orgHead;
    }

    public String getOrgTitle() {
        return orgTitle;
    }

    public String getErgNumber() {
        return regNumber;
    }

    public String getOrgHead() {
        return orgHead;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
