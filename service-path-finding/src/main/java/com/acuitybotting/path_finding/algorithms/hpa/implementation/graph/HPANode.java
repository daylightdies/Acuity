package com.acuitybotting.path_finding.algorithms.hpa.implementation.graph;



import com.acuitybotting.path_finding.algorithms.graph.Edge;
import com.acuitybotting.path_finding.algorithms.graph.GraphState;
import com.acuitybotting.path_finding.algorithms.graph.Node;
import com.acuitybotting.path_finding.rs.custom_edges.CustomEdge;
import com.acuitybotting.path_finding.rs.domain.location.Locateable;
import com.acuitybotting.path_finding.rs.domain.location.Location;
import com.google.gson.annotations.Expose;
import lombok.Getter;

import java.util.*;

@Getter
public class HPANode implements Node, Locateable {

    private Set<Edge> outgoingEdges = new HashSet<>();
    private Set<Edge> incomingEdges = new HashSet<>();

    @Expose
    private Location location;
    private HPARegion hpaRegion;

    @Expose
    private int type;

    public HPANode(HPARegion region, Location location, int type) {
        this.location = location;
        this.hpaRegion = region;
        this.type = type;
    }

    @Override
    public Set<Edge> getOutgoingEdges(GraphState state, Map<String, Object> args) {
        return outgoingEdges;
    }

    public HPAEdge addHpaEdge(HPANode other, int edgeType){
        return addHpaEdge(other, edgeType, 1);
    }

    public HPAEdge addHpaEdge(HPANode other, int edgeType, double cost){
        HPAEdge hpaEdge = new HPAEdge(this, other);
        hpaEdge.setCostPenalty(cost);
        hpaEdge.setType(edgeType);

        outgoingEdges.add(hpaEdge);
        hpaEdge.getEnd().getIncomingEdges().add(hpaEdge);

        return hpaEdge;
    }

    public void addHpaEdge(CustomEdge customEdge) {
        outgoingEdges.add(customEdge);
        customEdge.getEnd().getIncomingEdges().add(customEdge);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HPANode)) return false;

        HPANode hpaNode = (HPANode) o;

        if (getType() != hpaNode.getType()) return false;
        if (getLocation() != null ? !getLocation().equals(hpaNode.getLocation()) : hpaNode.getLocation() != null)
            return false;
        return getHpaRegion() != null ? getHpaRegion().equals(hpaNode.getHpaRegion()) : hpaNode.getHpaRegion() == null;
    }

    @Override
    public int hashCode() {
        int result = getLocation() != null ? getLocation().hashCode() : 0;
        result = 31 * result + (getHpaRegion() != null ? getHpaRegion().hashCode() : 0);
        result = 31 * result + getType();
        return result;
    }

    @Override
    public String toString() {
        return location.toString();
    }
}
