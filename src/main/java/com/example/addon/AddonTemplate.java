package com.example.addon;

import com.example.addon.modules.BlockPhase;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.modules.Modules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Addon extends MeteorAddon {
    public static final Logger LOG = LoggerFactory.getLogger("MyAddon");

    @Override
    public void onInitialize() {
        LOG.info("Initializing My Custom Meteor Addon!");
        Modules.get().add(new BlockPhase());
    }

    @Override
    public void onRegisterCategories() {}

    @Override
    public String getPackage() {
        return "com.example.addon";
    }
}
