package sharedObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();

	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;

	public RenderableHolder() {
		entities = new ArrayList<IRenderable>();
		comparator = (IRenderable o1, IRenderable o2) -> {
			if (o1.getZ() > o2.getZ())
				return 1;
			return -1;
		};
	}

	public static RenderableHolder getInstance() {
		return instance;
	}

	public void add(IRenderable entity) {
		entities.add(entity);
		Collections.sort(this.entities, this.comparator);
	}

	public void update() {
		Collections.sort(this.entities, this.comparator);
		for (int i = this.entities.size() - 1; i >= 0; i--) {
			if (this.entities.get(i) instanceof IUpdatable)
				((IUpdatable) this.entities.get(i)).update();
		}
		for (int i1 = this.entities.size() - 1; i1 >= 0; i1--) {
			if (((IRenderable) this.entities.get(i1)).isDestroyed())
				this.entities.remove(i1);
		}
	}

	public List<IRenderable> getEntities() {
		return entities;
	}

}
