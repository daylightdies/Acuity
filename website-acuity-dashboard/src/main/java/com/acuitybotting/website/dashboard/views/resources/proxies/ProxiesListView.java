package com.acuitybotting.website.dashboard.views.resources.proxies;

import com.acuitybotting.website.dashboard.security.view.interfaces.Authed;
import com.acuitybotting.website.dashboard.views.RootLayout;
import com.acuitybotting.website.dashboard.views.resources.ResourcesTabsComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * Created by Zachary Herridge on 8/8/2018.
 */
@Route(value = "resources/proxies", layout = RootLayout.class)
public class ProxiesListView extends VerticalLayout implements Authed {

    public ProxiesListView(ResourcesTabsComponent resourcesTabsComponent, ProxyListComponent proxyListComponent) {
        setPadding(false);
        add(resourcesTabsComponent, proxyListComponent);
    }
}
