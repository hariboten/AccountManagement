package hariboten;

import java.util.HashMap;
import java.util.Map;

class EntityRepository {
	private static EntityRepository singleton;
	private Map<Id, Entity> entities = new HashMap<Id, Entity>();
	private EntityRepository() {
	}
	public static synchronized EntityRepository getEntityRepository() {
		if (singleton == null) {
			singleton = new EntityRepository();
		}
		return singleton;
	}


	public void addEntity(Entity entity) {
		entities.put(entity.getId(), entity);
	}

	public Entity getEntity(Id entityId) {
		return entities.get(entityId);
	}


}
