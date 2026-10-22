package com.example.addon.modules;

import meteordevelopment.meteorclient.events.world.CollisionShapeEvent;
import meteordevelopment.meteorclient.settings.*;
import meteordevelopment.meteorclient.systems.modules.Categories;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.block.Blocks;
import net.minecraft.util.shape.VoxelShapes;

public class BlockPhase extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();

    private final Setting<Boolean> phaseBedrock = sgGeneral.add(new BoolSetting.Builder()
            .name("bedrock")
            .description("Phase through bedrock blocks.")
            .defaultValue(true)
            .build()
    );

    private final Setting<Boolean> phaseBarriers = sgGeneral.add(new BoolSetting.Builder()
            .name("barriers")
            .description("Phase through barrier blocks.")
            .defaultValue(true)
            .build()
    );

    public BlockPhase() {
        super(Categories.Movement, "block-phase", "Allows you to walk and clip through specific blocks.");
    }

    @EventHandler
    private void onCollisionShape(CollisionShapeEvent event) {
        if (mc.player == null) return;

        if (phaseBedrock.get() && event.state.isOf(Blocks.BEDROCK)) {
            event.shape = VoxelShapes.empty();
        } 
        else if (phaseBarriers.get() && event.state.isOf(Blocks.BARRIER)) {
            event.shape = VoxelShapes.empty();
        }
    }
}
