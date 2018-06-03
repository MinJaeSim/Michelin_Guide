package yellow7918.ajou.ac.michelin_guide;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Restaurant implements Serializable{
    @SerializedName("RNumber")
    private String rNumber;
    @SerializedName("KName")
    private String rName;
    @SerializedName("Grade")
    private int grade;
    @SerializedName("Phone_Num")
    private String phoneNumber;
    @SerializedName("Homepage")
    private String homepage;
    @SerializedName("Price")
    private int price;
    @SerializedName("Image1")
    private String imgRsc1;
    @SerializedName("Image2")
    private String imgRsc2;
    @SerializedName("Image3")
    private String imgRsc3;
    @SerializedName("Category")
    private String category;

    public String getrNumber() {
        return rNumber;
    }

    public void setrNumber(String rNumber) {
        this.rNumber = rNumber;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImgRsc1() {
        return imgRsc1;
    }

    public void setImgRsc1(String imgRsc1) {
        this.imgRsc1 = imgRsc1;
    }

    public String getImgRsc2() {
        return imgRsc2;
    }

    public void setImgRsc2(String imgRsc2) {
        this.imgRsc2 = imgRsc2;
    }

    public String getImgRsc3() {
        return imgRsc3;
    }

    public void setImgRsc3(String imgRsc3) {
        this.imgRsc3 = imgRsc3;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "rNumber='" + rNumber + '\'' +
                ", rName='" + rName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", homepage='" + homepage + '\'' +
                ", grade=" + grade +
                ", price=" + price +
                ", imgRscs=" + imgRsc1 +
                '}';
    }
}
