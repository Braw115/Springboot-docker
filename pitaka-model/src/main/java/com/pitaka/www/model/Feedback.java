package com.pitaka.www.model;

public class Feedback {

    private Integer id;                 //序列id,自增
    private Integer series;              //所属系列
    private Integer product;             //所属产品
    private String condition;           //现状说明
    private String idea;                //创意
    private String image;               //附件/图片
    private String user;                //创意提出人
    private String career;               //职业
    private String position;             //职位
    private String method;              // 提出方式
    private String country;             // 所属国家
    private Integer sex;                // 性别 0:男，1女
    private Integer age;                // 年龄
    private String contactinfo;         // 联系方式
    private boolean iscustomer;         //是否为公司客户 true:是,false:否
    private String purchase;            //购买的产品
    private String creator;             //创意提交人
    private String commitdate;          //提交日期

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
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