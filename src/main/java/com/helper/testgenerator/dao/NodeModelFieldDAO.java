package com.helper.testgenerator.dao;

import com.helper.testgenerator.enums.FrontendFieldValidators;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@Builder
public class NodeModelFieldDAO {

    private String modelClassName;
    private String nodeType;
    private String fieldName;
    private String fieldType; // Indicates the data type name of the field
    private List<FrontendFieldValidators> fieldValidators;

    public void addFieldValidators(@NonNull FrontendFieldValidators validator) {
        this.fieldValidators.add(validator);
    }
}
