package com.mycompany.myapp;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;

public class Drawer {
    
    private Form form;
    private boolean sideMenuOpen;
    FontImage edit = FontImage.createMaterial(FontImage.MATERIAL_MODE_EDIT, "MyIcon", 6);
    FontImage nav = FontImage.createMaterial(FontImage.MATERIAL_MENU, "Navigation", 6);
    public Drawer() {
        form = new Form(new BorderLayout());
        Toolbar tb = new Toolbar();
        form.setToolbar(tb);
        tb.setTitle("G-Store Esprit");
        tb.setUIID("Toolbar");
        
        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        menuButton.addActionListener(e -> {
            if(sideMenuOpen) {
                tb.closeSideMenu();
                sideMenuOpen = false;
            } else {
                tb.openSideMenu();
                sideMenuOpen = true;
            }
        });
        tb.addComponentToSideMenu(menuButton);
        Container topsideMenuContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS_BOTTOM_LAST));
        
        Container sideMenuContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS_BOTTOM_LAST));
        sideMenuContainer.setUIID("SideMenu");
        
        Label title = new Label("G-store Esprit");
        title.setUIID("label1");
        Container titleContainer = new Container(new BorderLayout());
       
        titleContainer.add(BorderLayout.CENTER, title);
        topsideMenuContainer.add(titleContainer);
        
        Button modifierProfileButton = new Button("Modifier Profile");
        modifierProfileButton.setIcon(edit);
        modifierProfileButton.setUIID("text");
        modifierProfileButton.addActionListener(e -> {
            // Handle modifier profile button click
        });
        sideMenuContainer.add(modifierProfileButton);
        
        Button navigationLibreButton = new Button("Navigation Libre");
        navigationLibreButton.setIcon(nav);
        navigationLibreButton.setUIID("text");
        navigationLibreButton.addActionListener(e -> {
            // Handle navigation libre button click
        });
        sideMenuContainer.add(navigationLibreButton);
        
        tb.addComponentToSideMenu(topsideMenuContainer);
        tb.addComponentToSideMenu(sideMenuContainer);
        
        Command exitCommand = new Command("Exit") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Display.getInstance().exitApplication();
            }
        };
        form.setBackCommand(exitCommand);
    }
    
    public Form getForm() {
        return form;
    }
}

