/*
 * Copyright (c) 2019. cschulc (https://github.com/cschulc)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package com.github.cschulc.jirarestservice.jql;

import java.util.Arrays;
import java.util.List;

import static com.github.cschulc.jirarestservice.jql.OperatorEnum.*;

public enum FieldTypeEnum {

    /**
     * The version.
     */
    VERSION(EQUALS, NOT_EQUALS, LESS_THAN, LESS_THAN_EQUALS, IN, NOT_IN, GREATER_THAN, GREATER_THAN_EQUALS, IS, IS_NOT, WAS, WAS_IN, WAS_NOT, WAS_NOT_IN, CHANGED),

    /**
     * The user.
     */
    USER(EQUALS, NOT_EQUALS, IS, IS_NOT, IN, NOT_IN, WAS, WAS_IN, WAS_NOT, WAS_NOT_IN, CHANGED),

    /**
     * The category.
     */
    CATEGORY(EQUALS, NOT_EQUALS, IS, IS_NOT, IN, NOT_IN),

    /**
     * The text.
     */
    TEXT(CONTAINS, DOES_NOT_CONTAIN, IS, IS_NOT),

    /**
     * The component.
     */
    COMPONENT(EQUALS, NOT_EQUALS, IS, IS_NOT, IN, NOT_IN),

    /**
     * The date.
     */
    DATE(EQUALS, NOT_EQUALS, LESS_THAN, LESS_THAN_EQUALS, IN, NOT_IN, GREATER_THAN, GREATER_THAN_EQUALS, IS, IS_NOT),

    /**
     * The filter.
     */
    FILTER(EQUALS, NOT_EQUALS, IN, NOT_IN),

    /**
     * The issue.
     */
    ISSUE(EQUALS, NOT_EQUALS, LESS_THAN, LESS_THAN_EQUALS, IN, NOT_IN, GREATER_THAN, GREATER_THAN_EQUALS, IS, IS_NOT),

    /**
     * The security level.
     */
    SECURITY_LEVEL(EQUALS, NOT_EQUALS, IS, IS_NOT, IN, NOT_IN),

    /**
     * The duration.
     */
    DURATION(EQUALS, NOT_EQUALS, LESS_THAN, LESS_THAN_EQUALS, IN, NOT_IN, GREATER_THAN, GREATER_THAN_EQUALS, IS, IS_NOT),

    /**
     * The priority.
     */
    PRIORITY(EQUALS, NOT_EQUALS, LESS_THAN, LESS_THAN_EQUALS, IN, NOT_IN, GREATER_THAN, GREATER_THAN_EQUALS, IS, IS_NOT, WAS, WAS_IN, WAS_NOT, WAS_NOT_IN, CHANGED),

    /**
     * The project.
     */
    PROJECT(EQUALS, NOT_EQUALS, IS, IS_NOT, IN, NOT_IN),

    /**
     * The resolution.
     */
    RESOLUTION(EQUALS, NOT_EQUALS, LESS_THAN, LESS_THAN_EQUALS, IN, NOT_IN, GREATER_THAN, GREATER_THAN_EQUALS, IS, IS_NOT, WAS, WAS_IN, WAS_NOT, WAS_NOT_IN, CHANGED),

    /**
     * The number.
     */
    NUMBER(EQUALS, NOT_EQUALS, IS, IS_NOT, IN, NOT_IN),

    /**
     * The status.
     */
    STATUS(EQUALS, NOT_EQUALS, IS, IS_NOT, IN, NOT_IN, WAS, WAS_IN, WAS_NOT, WAS_NOT_IN, CHANGED),

    /**
     * The text master.
     */
    TEXT_MASTER(CONTAINS),

    /**
     * The issue type.
     */
    ISSUE_TYPE(EQUALS, NOT_EQUALS, IS, IS_NOT, IN, NOT_IN),

    /**
     * The custom type.
     */
    CUSTOM_TYPE;



    /**
     * List of supported operators for a type of field.
     */
    private final List<OperatorEnum> supportedOperators;

    /**
     * Instantiates a new field type.
     *
     * @param supportedOperators = the supported operators for a type
     */
    FieldTypeEnum(OperatorEnum... supportedOperators) {
        this.supportedOperators = Arrays.asList(supportedOperators);
    }

    /**
     * Gets the list of supported opperators.
     *
     * @return the supported opperators
     */
    public List<OperatorEnum> getSupportedOperators() {
        return supportedOperators;
    }
}
