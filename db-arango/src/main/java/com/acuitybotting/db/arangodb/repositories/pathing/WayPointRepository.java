package com.acuitybotting.db.arangodb.repositories.pathing;

import com.acuitybotting.db.arangodb.api.repository.ArangoRepository;
import com.acuitybotting.db.arangodb.api.services.ArangoDbService;
import com.acuitybotting.db.arangodb.repositories.pathing.domain.WayPoint;
import org.springframework.stereotype.Service;

@Service
public class WayPointRepository extends ArangoRepository<WayPoint> {

    protected WayPointRepository(ArangoDbService arangoDbService) {
        super(WayPoint.class, arangoDbService);
        setDbName("Pathing-1");
    }

    @Override
    public String getCollectionName() {
        return "WayPoint";
    }
}
