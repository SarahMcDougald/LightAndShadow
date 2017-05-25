/*
 * Copyright 2015 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.terasology.las;

import org.terasology.cities.CityWorldGenerator;
import org.terasology.cities.bldg.BuildingFacetProvider;
import org.terasology.cities.blocked.BlockedAreaFacetProvider;
import org.terasology.cities.door.DoorFacetProvider;
import org.terasology.cities.door.SimpleDoorRasterizer;
import org.terasology.cities.door.WingDoorRasterizer;
import org.terasology.cities.fences.FenceFacetProvider;
import org.terasology.cities.fences.SimpleFenceRasterizer;
import org.terasology.cities.lakes.LakeFacetProvider;
import org.terasology.cities.parcels.ParcelFacetProvider;
import org.terasology.cities.raster.standard.RectPartRasterizer;
import org.terasology.cities.raster.standard.RoundPartRasterizer;
import org.terasology.cities.roads.RoadFacetProvider;
import org.terasology.cities.roads.RoadRasterizer;
import org.terasology.cities.roof.ConicRoofRasterizer;
import org.terasology.cities.roof.DomeRoofRasterizer;
import org.terasology.cities.roof.FlatRoofRasterizer;
import org.terasology.cities.roof.HipRoofRasterizer;
import org.terasology.cities.roof.PentRoofRasterizer;
import org.terasology.cities.roof.RoofFacetProvider;
import org.terasology.cities.roof.SaddleRoofRasterizer;
import org.terasology.cities.settlements.SettlementFacetProvider;
import org.terasology.cities.sites.SiteFacetProvider;
import org.terasology.cities.surface.InfiniteSurfaceHeightFacetProvider;
import org.terasology.cities.surface.SurfaceHeightFacetProvider;
import org.terasology.cities.terrain.BuildableTerrainFacetProvider;
import org.terasology.cities.walls.TownWallFacetProvider;
import org.terasology.cities.walls.TownWallRasterizer;
import org.terasology.cities.window.RectWindowRasterizer;
import org.terasology.cities.window.SimpleWindowRasterizer;
import org.terasology.cities.window.WindowFacetProvider;
import org.terasology.core.world.generator.facetProviders.DefaultFloraProvider;
import org.terasology.core.world.generator.facetProviders.EnsureSpawnableChunkZeroProvider;
import org.terasology.core.world.generator.facetProviders.SeaLevelProvider;
import org.terasology.core.world.generator.facetProviders.SurfaceToDensityProvider;
import org.terasology.core.world.generator.rasterizers.FloraRasterizer;
import org.terasology.core.world.generator.rasterizers.SolidRasterizer;
import org.terasology.engine.SimpleUri;
import org.terasology.entitySystem.entity.EntityRef;
import org.terasology.logic.spawner.Spawner;
import org.terasology.math.geom.Vector3f;
import org.terasology.registry.CoreRegistry;
import org.terasology.registry.In;
import org.terasology.world.block.BlockManager;
import org.terasology.world.generation.BaseFacetedWorldGenerator;
import org.terasology.world.generation.World;
import org.terasology.world.generation.WorldBuilder;
import org.terasology.world.generator.RegisterWorldGenerator;
import org.terasology.world.generator.plugin.WorldGeneratorPluginLibrary;

@RegisterWorldGenerator(id = "las", displayName = "Light & Shadow World")
public class LaSWorldGenerator extends CityWorldGenerator {

    World world;

    private final Spawner spawner = new LaSSpawner();

    @In
    private BlockManager blockManager;

    /**
     * @param uri the uri
     */
    public LaSWorldGenerator(SimpleUri uri) {
        super(uri);
    }

    @Override
    public Vector3f getSpawnPosition(EntityRef entity) {
        Vector3f pos = spawner.getSpawnPosition(getWorld(), entity);
        return pos != null ? pos : super.getSpawnPosition(entity);
    }

    @Override
    protected WorldBuilder createWorld() {
        return super.createWorld();
    }
}
