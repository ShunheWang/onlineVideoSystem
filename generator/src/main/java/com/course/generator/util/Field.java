package com.course.generator.util;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class Field {

    private String name; // 字段名：course_id
    private String nameHump; // 字段名小驼峰：courseId
    private String nameBigHump; // 字段名大驼峰：CourseId
    private String nameCn; // 中文名：课程
    private String type; // 字段类型：char(8)
    private String javaType; // java类型：String
    private String comment; // 注释：课程|ID
    private Boolean nullable; // 该字段是否为空
    private Integer length; // 字符串长度为0
    private Boolean enums; // 是否是枚举
    private String enumsConst; // 枚举常量 COURSE_LEVEL

    public Boolean getEnums() {
        return enums;
    }

    public void setEnums(Boolean enums) {
        this.enums = enums;
    }

    public String getEnumsConst() {
        return enumsConst;
    }

    public void setEnumsConst(String enumsConst) {
        this.enumsConst = enumsConst;
    }

    public Boolean getNullable() {
        return nullable;
    }

    public void setNullable(Boolean nullable) {
        this.nullable = nullable;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameHump() {
        return nameHump;
    }

    public void setNameHump(String nameHump) {
        this.nameHump = nameHump;
    }

    public String getNameBigHump() {
        return nameBigHump;
    }

    public void setNameBigHump(String nameBigHump) {
        this.nameBigHump = nameBigHump;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Field{" +
                "name='" + name + '\'' +
                ", nameHump='" + nameHump + '\'' +
                ", nameBigHump='" + nameBigHump + '\'' +
                ", nameCn='" + nameCn + '\'' +
                ", type='" + type + '\'' +
                ", javaType='" + javaType + '\'' +
                ", comment='" + comment + '\'' +
                ", nullable=" + nullable +
                ", length=" + length +
                ", enums=" + enums +
                ", enumsConst='" + enumsConst + '\'' +
                '}';
    }
}
