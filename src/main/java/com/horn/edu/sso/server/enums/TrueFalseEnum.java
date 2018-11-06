package com.horn.edu.sso.server.enums;

import com.horn.edu.sso.mybatis.model.EnumItemable;

/**
 * 是否枚举
 *
 * Created by misterxu on 2018/11/6.
 */
public enum  TrueFalseEnum implements EnumItemable<TrueFalseEnum> {
    TRUE("是", true),
    FALSE("否", false);

    private String label;
    private Boolean value;

    private TrueFalseEnum(String label, Boolean value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return this.label;
    }

    public Boolean getValue() {
        return this.value;
    }
}
