package com.github.cschulc.jirarestservice.jql;

import org.apache.commons.lang3.StringUtils;

public class JqlBuilder {

    private StringBuffer jql;

    public JqlBuilder() {
        jql = new StringBuffer();
    }

    public JqlKeyword addCondition(Field field, Operator operator, String... operand) {
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
            jql.append(Keyword.AND).append(" ");
            return getJqlBuilder();
        }

        public JqlBuilder or() {
            jql.append(Keyword.OR).append(" ");
            return getJqlBuilder();
        }

        public String orderBy(SortOrder order, Field... fields) {
            if (fields == null || order == null || fields.length == 0) {
                return build();
            }

            jql.append(Keyword.ORDER_BY).append(" ");
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
