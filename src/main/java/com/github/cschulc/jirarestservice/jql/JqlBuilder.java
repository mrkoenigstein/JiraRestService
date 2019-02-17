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

import org.apache.commons.lang3.StringUtils;

public class JqlBuilder {

    private StringBuilder jql;

    public JqlBuilder() {
        jql = new StringBuilder();
    }

    public JqlKeyword addCondition(FieldEnum field, OperatorEnum operator, String... operand) {
        JqlKeyword jqlKeyword = new JqlKeyword();

        if (field != null) {
            jql.append(field).append(" ");
        }
        if (operator != null) {
            jql.append(operator).append(" ");
        }
        if (operand != null) {
            if(operand.length > 1){
                String join = StringUtils.join(operand, ",");
                jql.append("(").append(join).append(") ");
            }else {
                jql.append(operand[0]).append(" ");
            }
        }

        return jqlKeyword;
    }

    public JqlBuilder getJqlBuilder() {
        return this;
    }

    public void clear() {
        jql.setLength(0);
    }

    public class JqlKeyword {

        public JqlBuilder and() {
            jql.append(KeywordEnum.AND).append(" ");
            return getJqlBuilder();
        }

        public JqlBuilder or() {
            jql.append(KeywordEnum.OR).append(" ");
            return getJqlBuilder();
        }

        public String orderBy(SortOrderEnum order, FieldEnum... fields) {
            if (fields == null || order == null || fields.length == 0) {
                return build();
            }

            jql.append(KeywordEnum.ORDER_BY).append(" ");
            jql.append(fields[0]);

            for (int i = 1; i < fields.length; i++) {
                jql.append(", ");
                jql.append(fields[i]);
            }

            jql.append(" ").append(order);

            return build();
        }

        /**
         * Return the request String and clear the buffer.
         *
         * @return jql as {@link String}
         */
        public String build() {
            String request = jql.toString();
            clear();
            return request;
        }
    }
}
