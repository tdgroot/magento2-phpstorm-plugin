/**
 * Copyright © Magento, Inc. All rights reserved.
 * See COPYING.txt for license details.
 */

package com.magento.idea.magento2plugin.util;

@SuppressWarnings({"PMD.ClassNamingConventions"})
public class RegExUtil {

    public static final String FILE_PATH = "[\\w-]+(/[\\w-]*)*";

    public static final String ALPHANUMERIC
            = "[a-zA-Z0-9]*";

    public static final String NUMERIC
            = "[0-9]*";

    public static final String IDENTIFIER
            = "[a-zA-Z0-9_\\-]*";

    public static final String CLI_COMMAND_NAME
            = "[a-zA-Z0-9_\\-\\:]*";

    public static final String DIRECTORY
            = "^(?!\\/)[a-zA-Z0-9\\/]*[^\\/]$";

    public static final String MAGENTO_VERSION
            = "(\\d+)\\.(\\d+)\\.(\\d+)[a-zA-Z0-9_\\-]*";

    public static class Magento {
        public static final String MODULE_NAME
                = "[A-Z][a-zA-Z0-9]+_[A-Z][a-zA-Z0-9]+";

        public static final String MFTF_CURLY_BRACES
                = ".*\\{\\{[^\\}]+\\}\\}.*";

        public static final String CRON_SCHEDULE =
                "^((\\*|\\?|\\d+((\\/|\\-){0,1}(\\d+))*)\\s*){5}$";

        public static final String CONFIG_PATH = "^(.+)\\/(.+)\\/(.+)$";
    }

    public class PhpRegex {

        public static final String CLASS_NAME
                = "[A-Z][a-zA-Z0-9_\\x7f-\\xff]*";

        public static final String FQN
                = CLASS_NAME + "(\\\\" + CLASS_NAME + ")*";
    }

    public static class XmlRegex {

        public static final String CLASS_MEMBER_NAME =
                "::\\$?([a-zA-Z_\\x7f-\\xff][a-zA-Z0-9_\\x7f-\\xff]*)(\\(\\))?";

        public static final String CLASS_ELEMENT =
                "\\\\?" + PhpRegex.FQN + "(" + CLASS_MEMBER_NAME + ")?.*";
    }
}
