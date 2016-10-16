public class Professor {

	public static enum Rank {
		ASST, ASSOC, PROF
	}

	protected Rank rank;
	protected String name;

	public Professor(String name, Rank rank) {
		this.name = name;
		this.rank = rank;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}
}