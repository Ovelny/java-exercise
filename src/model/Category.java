package model;

public class Category {
	private int id;
	private int label;
	
	public Category(int id, int label) {
		this.id = id;
		this.label = label;
	}

	public int getLabel() {
		return label;
	}

	public void setLabel(int label) {
	    this.label = label;
	}

	public int getId() {
	    return id;
    }

    public void setId(int id) {
	    this.id = id;
    }

}
