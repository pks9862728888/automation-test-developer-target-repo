package com.helper.testgenerator.services;

import com.demo.automationtestdevelopertargetrepo.annotations.HideTransientFieldFromYaml;
import com.demo.automationtestdevelopertargetrepo.annotations.MandatoryVerificationField;
import com.demo.automationtestdevelopertargetrepo.annotations.PublishingInputField;
import com.demo.automationtestdevelopertargetrepo.enums.inputparsers.ModelClassName;
import com.helper.testgenerator.dao.YamlNodeModelFieldDTO;
import com.helper.testgenerator.enums.FrontendFieldValidators;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class ModelFieldExtractorService {

    public List<YamlNodeModelFieldDTO> getInputModelFields(@NonNull String nodeType, @Nullable Class<?> modelClass) {
        List<YamlNodeModelFieldDTO> modelFields = new ArrayList<>();
        // type field
        modelFields.add(YamlNodeModelFieldDTO.builder()
                .fieldName("type")
                .fieldType(String.class.getSimpleName())
                .fieldValidators(List.of(FrontendFieldValidators.REQUIRED))
                .modelClassName(Objects.nonNull(modelClass) ? modelClass.getSimpleName() : "")
                .nodeType(nodeType)
                .build());

        if (modelClass != null) {
            log.debug("Adding input model fields for class: " + modelClass.getSimpleName());

            // Super class Fields
            Arrays.stream(modelClass.getSuperclass().getDeclaredFields())
                    .filter(f -> f.getAnnotationsByType(PublishingInputField.class).length > 0)
                    .forEach(f -> addInputFieldsToList(f, nodeType, modelClass, modelFields));

            // Add self fields
            Arrays.stream(modelClass.getDeclaredFields())
                    .filter(f -> f.getAnnotationsByType(PublishingInputField.class).length > 0)
                    .forEach(f -> addInputFieldsToList(f, nodeType, modelClass, modelFields));
        }

        return modelFields;
    }

    private void addInputFieldsToList(Field field, String nodeType, Class<?> modelClass,
                                      List<YamlNodeModelFieldDTO> modelFields) {
        YamlNodeModelFieldDTO obj = YamlNodeModelFieldDTO.builder()
                .fieldName(field.getName())
                .fieldType(field.getType().getSimpleName())
                .nodeType(nodeType)
                .modelClassName(modelClass.getSimpleName())
                .fieldValidators(new ArrayList<>())
                .build();

        // Add required validator
        if (!field.getAnnotationsByType(PublishingInputField.class)[0].isOptional()) {
            obj.addFieldValidators(FrontendFieldValidators.REQUIRED);
        }

        // Add number validator
        if (obj.getFieldType().equalsIgnoreCase(Integer.class.getSimpleName()) ||
                obj.getFieldType().equalsIgnoreCase(Long.class.getSimpleName()) ||
                field.getName().equals("identifier") || field.getName().equals("identifierToReuseIdFrom")) {
            obj.addFieldValidators(FrontendFieldValidators.NUMBER);
            obj.addFieldValidators(FrontendFieldValidators.NUMBER_GREATER_THAN_EQUAL_TO_ZERO);
        }

        modelFields.add(obj);
    }

    public List<YamlNodeModelFieldDTO> getVerificationModelFields(
            @NonNull String nodeType, @Nullable Class<? extends Enum<? extends ModelClassName>> enumClass) {
        List<YamlNodeModelFieldDTO> modelFields = new ArrayList<>();

        // Type field
        modelFields.add(YamlNodeModelFieldDTO.builder()
                .fieldName("type")
                .fieldType(String.class.getSimpleName())
                .fieldValidators(List.of(FrontendFieldValidators.REQUIRED))
                .modelClassName(Objects.nonNull(enumClass) ? enumClass.getSimpleName() : "")
                .nodeType(nodeType)
                .build());

        if (enumClass != null) {
            for (Enum<? extends ModelClassName> enumConstant : enumClass.getEnumConstants()) {
                Class<?> modelClass = ((ModelClassName) enumConstant).getClassName();
                log.debug("Adding verification model fields for class: " + modelClass.getSimpleName());

                // modelClassName field
                modelFields.add(YamlNodeModelFieldDTO.builder()
                        .fieldName("modelClassName")
                        .fieldType(String.class.getSimpleName())
                        .fieldValidators(List.of(FrontendFieldValidators.REQUIRED))
                        .modelClassName(modelClass.getSimpleName())
                        .nodeType(nodeType)
                        .build());

                // Super class fields
                Arrays.stream(modelClass.getSuperclass().getDeclaredFields())
                        .filter(f -> f.getAnnotationsByType(HideTransientFieldFromYaml.class).length == 0)
                        .forEach(f -> addVerificationFieldsToList(f, nodeType, modelClass, modelFields));

                // Current class fields
                Arrays.stream(modelClass.getDeclaredFields())
                        .filter(f -> f.getAnnotationsByType(HideTransientFieldFromYaml.class).length == 0)
                        .forEach(f -> addVerificationFieldsToList(f, nodeType, modelClass, modelFields));
            }
        }

        return modelFields;
    }

    private void addVerificationFieldsToList(@NonNull Field field, @NonNull String nodeType, @NonNull Class<?> modelClass,
                                             @NonNull List<YamlNodeModelFieldDTO> modelFields) {
        YamlNodeModelFieldDTO obj = YamlNodeModelFieldDTO.builder()
                .fieldName(field.getName())
                .fieldType(field.getType().getSimpleName())
                .nodeType(nodeType)
                .modelClassName(modelClass.getSimpleName())
                .fieldValidators(new ArrayList<>())
                .build();

        // Add required validator
        if (field.getAnnotationsByType(MandatoryVerificationField.class).length > 0) {
            obj.addFieldValidators(FrontendFieldValidators.REQUIRED);
        }

        // Add number validator
        if (obj.getFieldType().equalsIgnoreCase(Integer.class.getSimpleName()) ||
                obj.getFieldType().equalsIgnoreCase(Long.class.getSimpleName()) ||
                field.getName().equals("identifier")) {
            obj.addFieldValidators(FrontendFieldValidators.NUMBER);
            obj.addFieldValidators(FrontendFieldValidators.NUMBER_GREATER_THAN_EQUAL_TO_ZERO);
        }

        modelFields.add(obj);
    }
}
