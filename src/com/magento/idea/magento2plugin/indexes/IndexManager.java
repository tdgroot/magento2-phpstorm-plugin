/**
 * Copyright © Magento, Inc. All rights reserved.
 * See COPYING.txt for license details.
 */
package com.magento.idea.magento2plugin.indexes;

import com.intellij.util.indexing.FileBasedIndexImpl;
import com.intellij.util.indexing.ID;
import com.magento.idea.magento2plugin.stubs.indexes.*;
import com.magento.idea.magento2plugin.stubs.indexes.PluginIndex;
import com.magento.idea.magento2plugin.stubs.indexes.js.MagentoLibJsIndex;
import com.magento.idea.magento2plugin.stubs.indexes.js.RequireJsIndex;
import com.magento.idea.magento2plugin.stubs.indexes.graphql.GraphQlResolverIndex;
import com.magento.idea.magento2plugin.stubs.indexes.mftf.*;
import com.magento.idea.magento2plugin.stubs.indexes.xml.PhpClassNameIndex;

public class IndexManager {
    public static void manualReindex() {
        ID<?, ?>[] indexIds = new ID<?, ?>[] {
            // php
            ModulePackageIndex.KEY,
            // xml|di configuration
            PluginIndex.KEY,
            VirtualTypeIndex.KEY,
            // layouts
            BlockNameIndex.KEY,
            ContainerNameIndex.KEY,
            // events
            EventNameIndex.KEY,
            EventObserverIndex.KEY,
            // webapi
            WebApiTypeIndex.KEY,
            ModuleNameIndex.KEY,
            PhpClassNameIndex.KEY,
            //require_js
            RequireJsIndex.KEY,
            MagentoLibJsIndex.KEY,
            // mftf
            ActionGroupIndex.KEY,
            DataIndex.KEY,
            PageIndex.KEY,
            SectionIndex.KEY,
            TestNameIndex.KEY,
             //graphql
            GraphQlResolverIndex.KEY
        };

        for (ID<?, ?> id: indexIds) {
            try {
                FileBasedIndexImpl.getInstance().requestRebuild(id);
                FileBasedIndexImpl.getInstance().scheduleRebuild(id, new Throwable());
            } catch (NullPointerException exception) {
                //that's fine, indexer is not present in map java.util.Map.get
            }
        }
    }
}
