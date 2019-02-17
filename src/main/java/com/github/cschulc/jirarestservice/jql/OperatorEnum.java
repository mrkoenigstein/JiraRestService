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

public enum OperatorEnum {

    /**
     * The "=" operator is used to search for issues where the value of the specified field exactly matches the specified value.
     * (Note: cannot be used with text fields; see the CONTAINS operator instead.) To find issues where the value of a specified
     * field exactly matches multiple values, use multiple "=" statements with the AND operator.
     */
    EQUALS("="),

    /**
     * The "!=" operator is used to search for issues where the value of the specified field does not match the specified value.
     * (Note: cannot be used with text fields; see the DOES NOT MATCH ("!~") operator instead.) Note that typing field != value
     * is the same as typing NOT field = value, and that field != EMPTY is the same as field IS_NOT EMPTY.
     * The "!=" operator will not match a field that has no value (i.e. a field that is empty). For example, component != fred
     * will only match issues that have a component and the component is not "fred". To find issues that have a component other
     * than "fred" or have no component, you would need to type: component != fred or component is empty.
     */
    NOT_EQUALS("!="),

    /**
     * The ">" operator is used to search for issues where the value of the specified field is greater than the specified value.
     * Cannot be used with text fields. Note that the ">" operator can only be used with fields which support ordering
     * (e.g. date fields and version fields). To see a field's supported operators, check the individual field reference.
     */
    GREATER_THAN(">"),

    /**
     * The ">=" operator is used to search for issues where the value of the specified field is greater than or equal to the
     * specified value. Cannot be used with text fields. Note that the ">=" operator can only be used with fields which support
     * ordering (e.g. date fields and version fields). To see a field's supported operators, check the individual field reference.
     */
    GREATER_THAN_EQUALS(">="),

    /**
     * The "<" operator is used to search for issues where the value of the specified field is less than the specified value.
     * Cannot be used with text fields.Note that the "<" operator can only be used with fields which support ordering (e.g. date fields and version fields).
     * To see a field's supported operators, check the individual field reference.
     */
    LESS_THAN("<"),

    /**
     * The "<=" operator is used to search for issues where the value of the specified field is less than or equal to than the
     * specified value. Cannot be used with text fields. Note that the "<=" operator can only be used with fields which support
     * ordering (e.g. date fields and version fields). To see a field's supported operators, check the individual field reference.
     */
    LESS_THAN_EQUALS("<="),

    /**
     * The "IN" operator is used to search for issues where the value of the specified field is one of multiple specified values. The
     * values are specified as a comma-delimited list, surrounded by parentheses.
     * Using "IN" is equivalent to using multiple EQUALS (=) statements, but is shorter and more convenient. That is, typing reporter
     * IN (tom, jane, harry) is the same as typing reporter = "tom" OR reporter = "jane" OR reporter = "harry".
     */
    IN("in"),

    /**
     * The "NOT IN" operator is used to search for issues where the value of the specified field is not one of multiple specified values.
     * Using "NOT IN" is equivalent to using multiple NOT_EQUALS (!=) statements, but is shorter and more convenient. That is, typing
     * reporter NOT IN (tom, jane, harry) is the same as typing reporter != "tom" AND reporter != "jane" AND reporter != "harry". The "NOT IN"
     * operator will not match a field that has no value (i.e. a field that is empty). For example, assignee not in (jack,jill) will only
     * match issues that have an assignee and the assignee is not "jack" or "jill". To find issues that are assigned to someone other than
     * "jack" or "jill" or are unassigned, you would need to type: assignee not in (jack,jill) or assignee is empty.
     */
    NOT_IN("not in"),

    /**
     * The "~" operator is used to search for issues where the value of the specified field matches the specified value (either an exact match or
     * a "fuzzy" match — see examples below). For use with text fields only, i.e.:
     * <li>Summary</li>
     * <li>Description</li>
     * <li>Environment</li>
     * <li>CommentsBean</li>
     */
    CONTAINS("~"),

    /**
     * The "!~" operator is used to search for issues where the value of the specified field is not a "fuzzy" match for the specified value.
     * For use with text fields only, i.e.:
     * <li>Summary</li>
     * <li>Description</li>
     * <li>Environment</li>
     * <li>CommentsBean</li>
     */
    DOES_NOT_CONTAIN("!~"),

    /**
     * The "IS" operator can only be used with EMPTY or NULL. That is, it is used to search for issues where the specified field has no value.
     * Note that not all fields are compatible with this operator; see the individual field reference for details.
     */
    IS("is"),

    /**
     * The "IS NOT" operator can only be used with EMPTY or NULL. That is, it is used to search for issues where the specified field has a value.
     * Note that not all fields are compatible with this operator; see the individual field reference for details.
     */
    IS_NOT("is not"),

    /**
     * The "WAS" operator is used to find issues that currently have, or previously had, the specified value for the specified field.
     * This operator has the following optional predicates:
     * <li>AFTER "date"</li>
     * <li>BEFORE "date"</li>
     * <li>BY "username"</li>
     * <li>DURING ("date1","date2")</li>
     * <li>ON "date"</li>
     * <br>
     * This operator will match the value name (e.g. "Resolved"), which was configured in your system at the time that the field was changed.
     * This operator will also match the value ID associated with that value name too — that is, it will match "4" as well as "Resolved".
     * (Note: This operator can be used with the Assignee, Fix VersionBean, PriorityBean,  Reporter, ResolutionBean and StatusBean fields only.)
     */
    WAS("was"),

    /**
     * The "WAS IN" operator is used to find issues that currently have, or previously had, any of multiple specified values for the specified field.
     * The values are specified as a comma-delimited list, surrounded by parentheses. Using "WAS IN" is equivalent to using multiple WAS statements,
     * but is shorter and more convenient. That is, typing status WAS IN ('Resolved', 'Closed') is the same as typing status WAS "Resolved" OR status WAS "Closed".
     * <li>AFTER "date"</li>
     * <li>BEFORE "date"</li>
     * <li>BY "username"</li>
     * <li>DURING ("date1","date2")</li>
     * <li>ON "date"</li>
     * <br>
     * This operator will match the value name (e.g. "Resolved"), which was configured in your system at the time that the field was changed. This
     * operator will also match the value ID associated with that value name too — that is, it will match "4" as well as "Resolved". (Note: This
     * operator can be used with the Assignee, Fix VersionBean, PriorityBean,  Reporter, ResolutionBean and StatusBean fields only.)
     */
    WAS_IN("was in"),

    /**
     * The "WAS NOT IN" operator is used to search for issues where the value of the specified field has never been one of multiple specified values.
     * Using "WAS NOT IN" is equivalent to using multiple WAS_NOT statements, but is shorter and more convenient. That is, typing status
     * WAS NOT IN ("Resolved","In ProgressBean") is the same as typing status WAS NOT "Resolved" AND status WAS NOT "In ProgressBean".
     * This operator has the following optional predicates:
     * <li>AFTER "date"</li>
     * <li>BEFORE "date"</li>
     * <li>BY "username"</li>
     * <li>DURING ("date1","date2")</li>
     * <li>ON "date"</li>
     * <br>
     * This operator will match the value name (e.g. "Resolved"), which was configured in your system at the time that the field was changed.
     * This operator will also match the value ID associated with that value name too — that is, it will match "4" as well as "Resolved".
     * (Note: This operator can be used with the Assignee, Fix VersionBean, PriorityBean,  Reporter, ResolutionBean and StatusBean fields only.)
     */
    WAS_NOT_IN("was not in"),

    /**
     * The "WAS NOT" operator is used to find issues that have never had the specified value for the specified field.
     * This operator has the following optional predicates:
     * <li>AFTER "date"</li>
     * <li>BEFORE "date"</li>
     * <li>BY "username"</li>
     * <li>DURING ("date1","date2")</li>
     * <li>ON "date"</li>
     * <br>
     * This operator will match the value name (e.g. "Resolved"), which was configured in your system at the time that the field was changed.
     * This operator will also match the value ID associated with that value name too — that is, it will match "4" as well as "Resolved".
     * (Note: This operator can be used with the Assignee, Fix VersionBean, PriorityBean,  Reporter, ResolutionBean and StatusBean fields only.)
     */
    WAS_NOT("was not"),

    /**
     * The "CHANGED" operator is used to find issues that have a value which had changed for the specified field.
     * This operator has the following optional predicates:
     * <li>AFTER "date"</li>
     * <li>BEFORE "date"</li>
     * <li>BY "username"</li>
     * <li>DURING ("date1","date2")</li>
     * <li>ON "date"</li>
     * <li>FROM "oldvalue"</li>
     * <li>TO "newvalue"</li>
     * <br>
     * (Note: This operator can be used with the Assignee, Fix VersionBean, PriorityBean, Reporter, ResolutionBean and StatusBean fields only.)
     */
    CHANGED("changed"),
    AFTER("after"),
    BEFORE("before"),
    BY("by"),
    FROM("from"),
    ON("on"),
    TO("to");

    /**
     * The operator.
     */
    private final String operator;

    /**
     * Instantiates a new operator.
     *
     * @param operator the name of the operator
     */
    OperatorEnum(String operator) {
        this.operator = operator;
    }

    /**
     * Gets the operator.
     *
     * @return the operator
     */
    public String getOperator() {
        return operator;
    }

    @Override
    public String toString() {
        return getOperator();
    }
}
