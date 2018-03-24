package com.dawid.paymentsystem.model.commands;

import com.dawid.paymentsystem.model.NonDuplicableKey;

import java.util.Collection;
import java.util.Set;
import java.util.regex.Pattern;

public interface Command {

    default void validate(ValidationErrors errors) {

    }

    default void validatePresence(ValidationErrors errors, String field, String value) {
        if (value == null || value.trim().length() == 0) {
            errors.add(field, "can't be blank");
        }
    }


    default void validatePresence(ValidationErrors errors, String field, Object value) {
        if (value == null) {
            errors.add(field, "can't be blank");
        }
    }

    default void validatePresence(ValidationErrors errors, String field, Collection collection) {
        if (collection == null || collection.isEmpty()) {
            errors.add(field, "can't be blank");
        }
    }

    default void validateNonNegativity(ValidationErrors errors, String field, Integer number) {
        if (number<0){
            errors.add(field, "has to be non-negative");
        }
    }

    default void validateWithPattern(ValidationErrors errors, String field, String value, Pattern pattern) {
        if(!pattern.matcher(value).matches()) {
            errors.add(field, "invalid format");
        }
    }

    default void validateNonDuplicated(ValidationErrors errors, String field, Set<? extends NonDuplicableKey> t) {
        Long distinct;
        distinct = t.stream().map(NonDuplicableKey::getKey).distinct().count();
        if (distinct != t.size()) {
            errors.add(field, "can't be duplicated");
        }
    }
}
