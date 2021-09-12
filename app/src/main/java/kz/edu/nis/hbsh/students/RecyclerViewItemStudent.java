package kz.edu.nis.hbsh.students;

public class RecyclerViewItemStudent{

    private String imgRes;
    private String FIO,clsGrp,advncd1,advncd2,stndrd,stdntIin;

public RecyclerViewItemStudent(String imgRes,String FIO,String clsGrp,String advncd1,String advncd2,String stndrd,String stdntIin){
    this.imgRes = imgRes;
    this.FIO = FIO;
    this.clsGrp = clsGrp;
    this.advncd1 = advncd1;
    this.advncd2 = advncd2;
    this.stndrd = stndrd;
    this.stdntIin = stdntIin;

}
public String getImgRes(){
    return imgRes;
}
public String getFIO(){
    return FIO;
}
public String getclsGrp(){
        return clsGrp;
    }
public String getadvncd1(){
        return advncd1;
    }
public String getadvncd2(){
        return advncd2;
    }
public String getstndrd(){
        return stndrd;
    }
public String getstdntIin(){ return stdntIin; }
}
