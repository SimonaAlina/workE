package collections;

import java.util.List;

public class Penguin {

	private String name;
	private PenguinRace race;
	private double age;
	private List<Penguin> matingPartners;

	public Penguin(String name, PenguinRace race, double age) {
		this.name = name;
		this.race = race;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public PenguinRace getRace() {
		return race;
	}

	public double getAge() {
		return age;
	}

	public List<Penguin> getMatingPartners() {
		return matingPartners;
	}

	public void setMatingPartners(List<Penguin> matingPartners) {
		this.matingPartners = matingPartners;
	}

	@Override
	public String toString() {
		String str = new String("\nPenguin [name = " + name + ", race = " + race + ", \tage = " + age + "]");
		if(matingPartners == null)
			return str;
		else {
			for(Penguin p : matingPartners) {
				str += "\n-> Partner { name = " + p.getName() + ", race = " + p.getRace() + ", age = " + p.getAge() + "} ";
			}
		}
		return str;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(age);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((matingPartners == null) ? 0 : matingPartners.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((race == null) ? 0 : race.hashCode());
		return result;
		//return 31;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Penguin other = (Penguin) obj;
		if (Double.doubleToLongBits(age) != Double.doubleToLongBits(other.age))
			return false;
		if (matingPartners == null) {
			if (other.matingPartners != null)
				return false;
		} else if (!matingPartners.equals(other.matingPartners))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (race != other.race)
			return false;
		return true;
	}
}
