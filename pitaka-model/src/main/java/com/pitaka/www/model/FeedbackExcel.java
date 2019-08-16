package com.pitaka.www.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class FeedbackExcel {

    //public final static String IMAGE_URL_PREFIX = "http://192.168.1.2:9000";

    private Integer id;                 //序列id,自增
    private String series;              //所属系列
    private String product;             //所属产品
    private String condition;           //现状说明
    private String idea;                //创意
    private String image;               //附件/图片
    private List<MultipartFile> imgFileList;// 图片文件列表
    private String user;                //创意提出人
    private String career;               //职业
    private String position;             //职位
    private String method;              // 提出方式
    private String country;             // 所属国家
    private Integer sex;                // 性别 0:男，1女
    private String sexString;            //男,女
    private Integer age;                // 年龄
    private String contactinfo;         // 联系方式
    private boolean iscustomer;         //是否为公司客户 true:是,false:否
    private String  purchase;            //购买的产品
    private List<Integer> purchaseList;  //购买的产品
    private String creator;             //创意提交人
    private String commitdate;          //提交日期

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getIdea() {
        return idea;
    }

    public void setIdea(String idea) {
        this.idea = idea;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<MultipartFile> getImgFileList() {
        return imgFileList;
    }

    public void setImgFileList(List<MultipartFile> imgFileList) {
        this.imgFileList = imgFileList;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getSexString() {
        return sexString;
    }

    public void setSexString(String sexString) {
        this.sexString = sexString;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getContactinfo() {
        return contactinfo;
    }

    public void setContactinfo(String contactinfo) {
        this.contactinfo = contactinfo;
    }

    public boolean isIscustomer() {
        return iscustomer;
    }

    public void setIscustomer(boolean iscustomer) {
        this.iscustomer = iscustomer;
    }

    public String getPurchase() {
        return purchase;
    }

    public void setPurchase(String purchase) {
        this.purchase = purchase;
    }

    public List<Integer> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<Integer> purchaseList) {
        this.purchaseList = purchaseList;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCommitdate() {
        return commitdate;
    }

    public void setCommitdate(String commitdate) {
        this.commitdate = commitdate;
    }
}
