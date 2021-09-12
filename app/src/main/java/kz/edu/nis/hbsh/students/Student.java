package kz.edu.nis.hbsh.students;

public class Student {
    String FIO, classGroup, group, iin, image_id, advanced1, advanced2, group1, group2, groupStandard, standard;

    public Student() {
    }

    public Student(String FIO, String classGroup, String group, String iin, String image_id, String advanced1, String advanced2, String group1, String group2, String groupStandard, String standard, String class1) {
        this.FIO = FIO;
        this.classGroup = classGroup;
        this.group = group;
        this.iin = iin;
        this.image_id = image_id;
        this.advanced1 = advanced1;
        this.advanced2 = advanced2;
        this.group1 = group1;
        this.group2 = group2;
        this.groupStandard = groupStandard;
        this.standard = standard;
      //  this.class1 = class1;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getClassGroup() {
        return classGroup;
    }

    public void setClassGroup(String classGroup) {
        this.classGroup = classGroup;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getIin() {
        return iin;
    }

    public void setIin(String iin) {
        this.iin = iin;
    }

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public String getAdvanced1() {
        return advanced1;
    }

    public void setAdvanced1(String advanced1) {
        this.advanced1 = advanced1;
    }

    public String getAdvanced2() {
        return advanced2;
    }

    public void setAdvanced2(String advanced2) {
        this.advanced2 = advanced2;
    }

    public String getGroup1() {
        return group1;
    }

    public void setGroup1(String group1) {
        this.group1 = group1;
    }

    public String getGroup2() {
        return group2;
    }

    public void setGroup2(String group2) {
        this.group2 = group2;
    }

    public String getGroupStandard() {
        return groupStandard;
    }

    public void setGroupStandard(String groupStandard) {
        this.groupStandard = groupStandard;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

 }
