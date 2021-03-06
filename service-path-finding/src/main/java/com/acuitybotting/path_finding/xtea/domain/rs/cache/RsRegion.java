package com.acuitybotting.path_finding.xtea.domain.rs.cache;

import com.acuitybotting.path_finding.rs.domain.location.Location;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Zachary Herridge on 6/25/2018.
 */

@Getter
public class RsRegion {

    public static final int X = 64;
    public static final int Y = 64;
    public static final int Z = 4;

    private int regionID;
    private int baseX;
    private int baseY;

    private int[][][] tileHeights = new int[Z][X][Y];
    private int[][][] tileSettings = new int[Z][X][Y];
    private int[][][] overlayIds = new int[Z][X][Y];
    private int[][][] overlayPaths = new int[Z][X][Y];
    private int[][][] overlayRotations = new int[Z][X][Y];
    private int[][][] underlayIds = new int[Z][X][Y];

    private List<RsLocation> locations = new ArrayList<>();
    private int[] keys;

    public int getAt(int[][][] map, Location location){
        Location clone = location.clone(-baseX, -baseY);
        return map[location.getPlane()][clone.getX()][ clone.getY()];
    }

    public int getTileSetting(Location location){
        return getAt(tileSettings, location);
    }

    public Collection<RsLocation> getInstancesAt(Location location){
        return locations.stream().filter(sceneEntityInstance -> sceneEntityInstance.getPosition().toLocation().equals(location)).collect(Collectors.toSet());
    }

}
