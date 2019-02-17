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

public enum KeywordEnum {

    /**
     * Used to combine multiple clauses, allowing you to refine your search.
     * <p>Examples:
     * <li>project = "New office" and status = "open"
     * <li>status = open and priority = urgent and assignee = jsmith
     * <li>project = JRA and assignee != jsmith
     * <li>project in (JRA,CONF) and fixVersion = "3.14"
     * <li>reporter not in (Jack,Jill,John) and assignee not in (Jack,Jill,John)
     */
    AND("and"),

    /**
     * Used to combine multiple clauses, allowing you to expand your search.
     * <p>Examples:
     * <li>reporter = jsmith or reporter = jbrown
     * <li>duedate < now() or duedate is empty
     */
    OR("or"),

    /**
     * Used to negate individual clauses or a complex JQL query (a query made up of more than one clause)
     * using parentheses, allowing you to refine your search.
     * <p>Examples:
     * <li>not assignee = jsmith
     * <li>not (reporter = jsmith or reporter = jbrown)
     */
    NOT("not"),

    /**
     * Used to search for issues where a given field does not have a value.
     * <p>Examples:
     * <li>duedate = empty
     * <li>duedate is empty
     */
    EMPTY("empty"),

    /**
     * Used to search for issues where a given field does not have a value.
     * <p>Examples:
     * <li>duedate = null
     * <li>duedate is null
     */
    NULL("null"),

    /**
     * Used to specify the fields by whose values the search results will be sorted.
     * <p>Examples:
     * <li>duedate = empty order by created
     * <li>duedate = empty order by created, priority desc
     * <li>duedate = empty order by created, priority asc
     */
    ORDER_BY("order by");

    /**
     * The keyword.
     */
    private final String keyword;

    /**
     * Instantiates a new keyword.
     *
     * @param keyword name of the keyword
     */
    KeywordEnum(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Gets the keyword.
     *
     * @return the keyword
     */
    public String getKeyword() {
        return keyword;
    }

    @Override
    public String toString() {
        return getKeyword();
    }
}
