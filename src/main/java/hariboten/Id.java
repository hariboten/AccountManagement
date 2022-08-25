package hariboten;

class Id {
	private static int count = 0;
	public int id;
	public Id() {
		id = generateId();
	}

	private static synchronized int generateId() {
		return count++;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Id other = (Id) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
